package com.weTraveller.api;


import com.weTraveller.entity.Location;
import com.weTraveller.entity.Post;
import com.weTraveller.entity.Privacy;
import com.weTraveller.model.PostModel;
import com.weTraveller.model.response.ApiResponse;
import com.weTraveller.service.location.LocationService;
import com.weTraveller.service.post.PostService;
import com.weTraveller.service.privacy.PrivacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/post")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    PrivacyService privacyService;

    @Autowired
    LocationService locationService;

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


    @GetMapping(path = "/getPrivacyList")
    public ResponseEntity<Object> getPrivacyList() {
        ApiResponse response = new ApiResponse(false);
        String messageCode = "";
        try {
            List<Privacy> privacyList =privacyService.findAll();
            response.setTotal(String.valueOf(privacyList.size()));
            response.setSuccess(privacyList);
            messageCode = "api.details.success";
        } catch (Exception ex) {
            messageCode = ex.getMessage();
        }
        response.setMessage(messageSource.getMessage(messageCode, null, null).toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/getLocationList")
    public ResponseEntity<Object> getLocationList() {
        ApiResponse response = new ApiResponse(false);
        String messageCode = "";
        try {

            List<Location> locationList = locationService.findAll();
            response.setTotal(String.valueOf(locationList.size()));
            response.setSuccess(locationList);
            messageCode = "api.details.success";
        } catch (Exception ex) {
            messageCode = ex.getMessage();
        }
        response.setMessage(messageSource.getMessage(messageCode, null, null).toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
