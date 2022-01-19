package com.luxoft.blogApp.web;

import com.luxoft.blogApp.entity.Post;
import com.luxoft.blogApp.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private Post post;

    @BeforeEach
    void setUp() {
        post = post.builder()
                .postTitle("News")
                .postContent("bla-bla")
                .build();
    }

    @Test
    void addPost() throws Exception {
        Post inputPost = Post.builder()
                .postTitle("Music")
                .postContent("la-la-la")
                .build();

        Mockito.when(postService.addPost(inputPost))
                .thenReturn(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"postTitle(\":\"News\",\n" +
                                "\t\"postContent\":\"bla-bla\",\n" +
                                "}"))
                .andExpect(status().isOk());
    }
}