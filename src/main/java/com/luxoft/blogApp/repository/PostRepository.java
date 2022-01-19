package com.luxoft.blogApp.repository;

import com.luxoft.blogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Long> {
    public Post findByPostTitle(String postTitle);

    public Post findByPostTitleIgnoreCase(String postTitle);
}