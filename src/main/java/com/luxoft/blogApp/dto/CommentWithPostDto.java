package com.luxoft.blogApp.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentWithPostDto {

    private String text;

    private Long postId;

}