package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);

    List<Post> fetchPostList();

    Post updatePost(Long postId, Post post);

    void deletePostById(Long postId);
}
