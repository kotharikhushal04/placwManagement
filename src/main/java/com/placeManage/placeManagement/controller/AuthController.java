package com.placeManage.placeManagement.controller;

import com.placeManage.placeManagement.dto.LoginDto;
import com.placeManage.placeManagement.dto.RegisterDto;
import com.placeManage.placeManagement.entity.User;
import com.placeManage.placeManagement.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterDto registerDto) throws Exception {
        return userService.registerUser(registerDto);
    }
    @GetMapping("/login")
    public String loginUser(@RequestBody LoginDto loginDto) throws Exception {
        System.out.println("rfrfr");
        return userService.loginUser(loginDto);
    }
}
