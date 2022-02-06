package com.luxoft.blogApp.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequestDto {

    private String text;

    private Long postId;

}