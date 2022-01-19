package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Post;

import java.util.List;

public interface PostService {
    public Post addPost(Post post);

    public List<Post> getPostList();

    public Post updatePost(Long postId, Post post);

    public void deletePostById(Long postId);

    public Post getPostByTitle(String postTitle);


}
