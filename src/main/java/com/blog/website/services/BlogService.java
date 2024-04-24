package com.blog.website.services;

import com.blog.website.dto.BlogpostDto;
import com.blog.website.models.Blogpost;

import java.util.List;

public interface BlogService {
    List<BlogpostDto> findAllBlogs();


    Blogpost saveBlog(Blogpost blogpost);
}
