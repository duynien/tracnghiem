package com.java.demo_ttcscn.services.model.impl;

import com.java.demo_ttcscn.enitities.model.Post;
import com.java.demo_ttcscn.exception.NotFoundException;
import com.java.demo_ttcscn.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post getPost() {
        Optional<Post> post = postRepository.findById(1);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new NotFoundException("Không có bài đăng");
        }
    }

    @Transactional
    public Post updatePost(Post post) {
        try {
            postRepository.save(post);
            return post;
        } catch (Exception e) {
            return null;
        }
    }
}
