package com.oci.testusersservice.facade;

import java.util.List;

import com.oci.testusersservice.entity.User;

public interface UserFacade
{
    List<User> get();

    User get(String uuid);
}
