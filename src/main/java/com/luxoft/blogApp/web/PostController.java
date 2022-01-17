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
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("/api/v1/posts")
    public List<Post> fetchPostList() {
        return postService.fetchPostList();
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
}
