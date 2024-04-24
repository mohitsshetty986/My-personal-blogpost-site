package com.blog.website.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BlogpostDto {
    private Long id;
    private String title;
    private String photoUrl;
    private String subtitle;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}