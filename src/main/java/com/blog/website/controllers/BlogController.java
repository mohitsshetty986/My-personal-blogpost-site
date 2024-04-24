package com.blog.website.controllers;

import com.blog.website.dto.BlogpostDto;
import com.blog.website.models.Blogpost;
import com.blog.website.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String listBlogs(Model model) {
        List<BlogpostDto> blogpostDtoList = blogService.findAllBlogs();
        model.addAttribute("blogposts", blogpostDtoList);
        return "list-blogs";
    }

    @GetMapping("/blogs/newBlog")
    public String createBlogForm(Model model) {
        Blogpost blogpost = new Blogpost();
        model.addAttribute("blogpost", blogpost);
        return "create-blog";
    }

    @PostMapping("/blogs/newBlog")
    public String saveBlog(@ModelAttribute("blogpost") Blogpost blogpost) {
        blogService.saveBlog(blogpost);
        return "redirect:/blogs";
    }
}
