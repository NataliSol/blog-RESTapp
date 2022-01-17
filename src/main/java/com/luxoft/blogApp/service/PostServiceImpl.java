package com.luxoft.blogApp.service;

import com.luxoft.blogApp.entity.Post;
import com.luxoft.blogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchPostList() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long postId, Post post) {
        Post postDB = postRepository.findById(postId).get();
        if (Objects.nonNull(post.getPostContent()) &&
                !"".equalsIgnoreCase(post.getPostContent())) {
            postDB.setPostContent(post.getPostContent());
        }
        if (Objects.nonNull(post.getPostTitle()) &&
                !"".equalsIgnoreCase(post.getPostTitle())) {
            postDB.setPostTitle(post.getPostTitle());
        }
        return postRepository.save(postDB);
    }

    @Override
    public void deletePostById(Long postId) {
       postRepository.deleteById(postId);
    }

}
