package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Comment;


import java.util.List;

public interface CommentService {
    List<Comment> getAll();

    Comment save(Comment comment);

    Comment getById(Long id);

    void delete(Long id);

    Comment update(Comment comment);

    List<Comment> getAllByPostId(Long postId);

    Comment getByIdAndPostId(Long Id, Long postId);

}
