package com.blog.website.Impl;

import com.blog.website.dto.BlogpostDto;
import com.blog.website.models.Blogpost;
import com.blog.website.repository.BlogRepository;
import com.blog.website.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public List<BlogpostDto> findAllBlogs() {
        List<Blogpost> blogpostDtoList = blogRepository.findAll();
        return blogpostDtoList.stream().map(this::mapToBlogDto).collect(Collectors.toList());
    }

    @Override
    public Blogpost saveBlog(Blogpost blogpost) {
        return blogRepository.save(blogpost);
    }

    private BlogpostDto mapToBlogDto(Blogpost blogpost) {
        return BlogpostDto.builder()
                .id(blogpost.getId())
                .title(blogpost.getTitle())
                .photoUrl(blogpost.getPhotoUrl())
                .subtitle(blogpost.getSubtitle())
                .createdOn(blogpost.getCreatedOn())
                .updatedOn(blogpost.getUpdatedOn())
                .build();
    }
}
