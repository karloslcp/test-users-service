package com.oci.testusersservice.controller;

import java.util.List;

import com.oci.testusersservice.entity.User;
import com.oci.testusersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UsersController
{
    private UserRepository repository;

    @GetMapping
    public List<User> getAllUsers()
    {
        return repository.findAll();
    }
}
