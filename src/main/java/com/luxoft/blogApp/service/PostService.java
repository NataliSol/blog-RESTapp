package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post save(Post post);

    void delete(Long id);

    void update(Long id, Post post);

    List<Post> findByTitle(String title);

    List<Post> findByTitleAndSort();

    List<Post> returnMarkedByStar();

    Post markedByStar(Long id);
    Post unmarkedByStar(Long id);

}

