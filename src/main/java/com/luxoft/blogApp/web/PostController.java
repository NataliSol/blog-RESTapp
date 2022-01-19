package com.luxoft.blogApp.web;

import com.luxoft.blogApp.entity.Post;
import com.luxoft.blogApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/v1/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @GetMapping("/api/v1/posts")
    public List<Post> getPostList() {
        return postService.getPostList();
    }

    @PutMapping("/api/v1/posts/{id}")
    public Post updatePostById(@PathVariable("id") Long postId,
                                 @RequestBody Post post) {
        return postService.updatePost(postId, post);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public String deletePostById(@PathVariable("id") Long postId) {
        postService.deletePostById(postId);
        return "Post deleted Successfully!!";
    }
    @GetMapping("/api/v1/posts/{title}")
    public Post getPostByTitle(@PathVariable("title") String postTitle) {
          return postService.getPostByTitle(postTitle);
    }
}
