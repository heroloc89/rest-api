package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/google")
public class GoogleController {
    @GetMapping(value = "/login")
    public Principal user(Principal principal) {
        return principal;
    }
}
