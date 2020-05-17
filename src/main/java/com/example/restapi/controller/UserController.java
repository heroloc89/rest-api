package com.example.restapi.controller;

import com.example.restapi.payload.request.LoginRequest;
import com.example.restapi.payload.response.LoginResponse;
import com.example.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        return new LoginResponse(userService.createToken(loginRequest));
    }
}
