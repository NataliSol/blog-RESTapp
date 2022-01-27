package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Post;
import com.luxoft.blogApp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultService implements PostService {


    private final PostRepository postRepository;

    public List<Post> getAll() {
        List<Post> users = postRepository.findAll();
        System.out.println("Posts in blog: " + users.size());
        return users;
    }

    public Post save(Post post) {
       return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public void update(Long id, Post post) {
        post.setId(id);
        postRepository.save(post);
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleIs(title);
    }

    @Override
    public List<Post> findByTitleAndSort() {
        return postRepository.findByOrderByTitleAsc();
    }
}