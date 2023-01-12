package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    private PostRepository postRepository;
    @RequestMapping("/")
    public String listPosts(ModelMap map) {
        List<Post> postList = postRepository.getAllPosts();
        map.put("title", "Blog Post 1");
        map.put("posts", postList);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap map) {
        Post post = postRepository.findById(id);
        map.put("post", post);
        return "post-details";
    }
}
