package com.spring.student_jpa.controller;

import com.spring.student_jpa.model.Response;
import com.spring.student_jpa.model.user.User;
import com.spring.student_jpa.model.user.UserRequest;
import com.spring.student_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public Response add(@RequestBody UserRequest request){
        Response response = new Response();
        User user = userService.add(request);
        if(user !=  null){
            response.setCode(0);
            response.setMesage("add sucess");
            response.setData(user);
        }else {
            response.setCode(1);
            response.setMesage("add fail");
        }
        return response;
    }

}
