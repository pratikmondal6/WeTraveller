package com.weTraveller.api;

import com.weTraveller.entity.User;
import com.weTraveller.model.UserModel;
import com.weTraveller.model.response.ApiResponse;
import com.weTraveller.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;


    @PostMapping(path = "/create-user")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserModel userModelRequest) {
        ApiResponse response = new ApiResponse(false);
        String messageCode = "";
        try {
            User userDetails = null;
            User user = new User().setUser(userModelRequest);
            userDetails = userService.create(user);

            messageCode = "api.create.success";
            if(userDetails.getId()>0){
                response.setSuccess(new UserModel(userDetails));
            }
        }catch (Exception ex){
            messageCode = ex.getMessage();
        }
        response.setMessage(messageSource.getMessage(messageCode,null, null).toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
