package com.luxoft.blogApp.web;

import com.luxoft.blogApp.entity.Post;
import com.luxoft.blogApp.service.DefaultService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor

public class PostController {
    private final DefaultService defaultService;
    Logger logger = LoggerFactory.getLogger(getClass());



    @PostMapping
    public Post save(@RequestBody Post post) {
        logger.info("Save new post {} ", post);
        return defaultService.save(post);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        defaultService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Post post) {
        defaultService.update(id, post);
    }

    @GetMapping
    public List<Post> getAndSort(@RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "sort", required = false) String sort) {
        if (title != null) {
            logger.info("findAllPostsByTitle");
            return defaultService.findByTitle(title);
        } else if (sort != null) {
            logger.info("findAllPostsAndSortedByTitle");
            return defaultService.findByTitleAndSort();
        } else {
            return defaultService.getAll();
        }
    }

}