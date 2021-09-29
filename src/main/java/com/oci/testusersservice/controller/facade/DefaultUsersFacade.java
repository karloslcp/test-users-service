package com.oci.testusersservice.controller.facade;

import java.util.List;

import com.oci.testusersservice.controller.dto.UserDTO;
import com.oci.testusersservice.controller.mapper.UserMapper;
import com.oci.testusersservice.exception.NoUserContentException;
import com.oci.testusersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUsersFacade implements UserFacade
{
    private UserRepository repository;

    private UserMapper mapper;

    @Override
    public List<UserDTO> get()
    {
        final var users = repository.findAll();
        if (users.isEmpty())
        {
            throw new NoUserContentException();
        }
        return mapper.map(users);
    }

    @Override
    public UserDTO get(final String uuid)
    {
        return null;
    }
}
