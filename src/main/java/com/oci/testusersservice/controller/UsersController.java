package com.oci.testusersservice.controller;

import java.util.List;

import com.oci.testusersservice.entity.User;
import com.oci.testusersservice.facade.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UsersController
{
    private UserFacade facade;

    @GetMapping
    public List<User> getAllUsers()
    {
        return facade.get();
    }
}
