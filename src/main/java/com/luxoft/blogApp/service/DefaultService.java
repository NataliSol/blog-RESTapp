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

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        Post savedPost = postRepository.findById(post.getId()).orElse(null);
        if (savedPost == null) {
            return null;
        } else {
            return postRepository.save(post);
        }
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).orElse(null);
    }


    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }


    @Override
    public Post update(Post post) {
        Post existingPost = postRepository.findById(post.getId()).orElse(null);
        if (existingPost != null) {
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleIs(title);
    }

    @Override
    public List<Post> findByTitleAndSort() {
        return postRepository.findByOrderByTitleAsc();
    }

    @Override
    public List<Post> returnMarkedByStar() {
        return postRepository.returnMarkedByStar();
    }

    @Override
    public Post markedByStar(Long id) {
        return postRepository.markedByStar(id);
    }

    @Override
    public Post unmarkedByStar(Long id) {
        return postRepository.unmarkedByStar(id);
    }
}
