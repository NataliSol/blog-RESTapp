package com.luxoft.blogApp.dto;

import com.luxoft.blogApp.entity.Comment;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostWithoutCommentDto {

    private Long id;

    private String title;

    private String content;

    private boolean star;

    private List<Comment> comments;

}