package com.weTraveller.service.post;


import com.weTraveller.entity.Post;
import com.weTraveller.service.AbstractService;

import java.util.List;

public interface PostService extends AbstractService<Post> {

    public List<Post> findAll();
}
