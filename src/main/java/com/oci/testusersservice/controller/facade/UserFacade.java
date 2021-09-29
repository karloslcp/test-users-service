package com.oci.testusersservice.controller.facade;

import java.util.List;

import com.oci.testusersservice.controller.dto.UserDTO;

public interface UserFacade
{
    List<UserDTO> get();

    UserDTO get(final Long id);
}
