package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post save(Post post);

    Post getById(Long id);

    void delete(Long id);

    Post update(Post post);

    List<Post> findByTitle(String title);

    List<Post> findByTitleAndSort();

    List<Post> returnMarkedByStar();

    Post markedByStar(Long id);

    Post unmarkedByStar(Long id);
}

