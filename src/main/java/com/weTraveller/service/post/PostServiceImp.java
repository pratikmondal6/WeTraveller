package com.weTraveller.service.post;


import com.weTraveller.entity.Post;
import com.weTraveller.exception.NotFoundException;
import com.weTraveller.exception.ServiceException;
import com.weTraveller.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImp implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    private Environment env;


    @Override
    public Post create(Post post) throws ServiceException {
        return postRepository.save(post);
    }

    @Override
    public Post update(long id, Post post) throws ServiceException {
        Post _ex = this.findById(id);
        if(_ex == null) throw new NotFoundException();
        return postRepository.save(post);
    }

    @Override
    public boolean delete(long id) throws ServiceException {
        Post _ex = this.findById(id);
        if(_ex == null) throw new NotFoundException();

        postRepository.deleteById(id);
        return true;
    }

    @Override
    public Post findById(long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.isPresent() ? post.get() : null;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }


}
