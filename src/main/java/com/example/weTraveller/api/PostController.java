package com.example.weTraveller.api;


import com.example.weTraveller.entity.Post;
import com.example.weTraveller.entity.User;
import com.example.weTraveller.model.PostModel;
import com.example.weTraveller.model.UserModel;
import com.example.weTraveller.model.response.ApiResponse;
import com.example.weTraveller.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/post")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping(path = "/create-user")
    public ResponseEntity<Object> createPost(@RequestBody PostModel postModel) {
        ApiResponse response = new ApiResponse(false);
        String messageCode = "";
        try {
            Post postDetails = null;
            Post post = new Post().setPost(postModel);
            postDetails = postService.create(post);

            messageCode = "api.create.success";
            if(postDetails.getId()>0){
                response.setSuccess(new PostModel(postDetails));
            }
        }catch (Exception ex){
            messageCode = ex.getMessage();
        }
        response.setMessage(messageSource.getMessage(messageCode,null, null).toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
