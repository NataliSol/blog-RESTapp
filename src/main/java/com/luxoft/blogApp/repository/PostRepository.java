package com.luxoft.blogApp.repository;

import com.luxoft.blogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Post, Long> {

  List<Post> findByTitleIs(String title);

  List<Post> findByOrderByTitleAsc();


}