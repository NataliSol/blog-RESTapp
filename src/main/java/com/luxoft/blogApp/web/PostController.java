package com.luxoft.blogApp.web;

import com.luxoft.blogApp.dto.PostWithoutCommentDto;
import com.luxoft.blogApp.entity.Comment;
import com.luxoft.blogApp.entity.Post;
import com.luxoft.blogApp.service.CommentServiceImpl;
import com.luxoft.blogApp.service.DefaultService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor


public class PostController {
    private final DefaultService defaultService;
    private final CommentServiceImpl commentService;
    Logger logger = LoggerFactory.getLogger(getClass());


    @PostMapping
    public Post save(@RequestBody Post post) {
        post.setId(0L);
        logger.info("obtain request to save new post {} ", post);
        return defaultService.save(post);

    }
    @GetMapping("/{id}/full")
    ResponseEntity<PostWithoutCommentDto> getFullPostById(@PathVariable Long id) {
        Post post = defaultService.getById(id);
        if (post == null) {
            return new ResponseEntity<PostWithoutCommentDto>(HttpStatus.BAD_REQUEST);
        } else {
            List<Comment> commentList = commentService.getAllByPostId(post.getId());
            PostWithoutCommentDto dto = PostWithoutCommentDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .star(post.isStar())
                    .comments(commentList)
                    .build();
            return new ResponseEntity<PostWithoutCommentDto>(dto, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Post> delete(@PathVariable Long id) {
        Post post = defaultService.getById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            defaultService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Post> update(@RequestBody Post post, @PathVariable Long id) {
        post.setId(id);
        Post savedPost = defaultService.update(post);
        if (savedPost == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(savedPost, HttpStatus.OK);
        }
    }

    @GetMapping
    ResponseEntity<List<Post>> getAndSort(@RequestParam(value = "title", required = false) String title,
                                          @RequestParam(value = "sort", required = false) String sort) {
        if (title != null) {
            return new ResponseEntity<List<Post>>(defaultService.findAllByTitle(title), HttpStatus.OK);
        } else if (sort != null) {
            return new ResponseEntity<List<Post>>(defaultService.findAllWithSort(sort), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Post>>(defaultService.getAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/star")
    ResponseEntity<List<Post>> getPostsMarkByStar() {
        return new ResponseEntity<List<Post>>(defaultService.returnMarkedByStar(), HttpStatus.OK);
    }

    @PutMapping("/{id}/star")
    ResponseEntity<Post> markPostByStar(@PathVariable Long id) {
        return new ResponseEntity<Post>(defaultService.markedByStar(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/star")
    ResponseEntity<Post> updatePostBySetStarFalse(@PathVariable Long id) {
        return new ResponseEntity<Post>(defaultService.unmarkedByStar(id), HttpStatus.OK);
    }

}

