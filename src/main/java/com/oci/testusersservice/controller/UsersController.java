package com.oci.testusersservice.controller;

import java.util.List;

import com.oci.testusersservice.controller.dto.UserDTO;
import com.oci.testusersservice.controller.facade.UserFacade;
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
    public List<UserDTO> getAllUsers()
    {
        return facade.get();
    }
}
