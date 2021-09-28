package com.oci.testusersservice.facade;

import java.util.List;

import com.oci.testusersservice.entity.User;
import com.oci.testusersservice.exception.NoUserContentException;
import com.oci.testusersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUsersFacade implements UserFacade
{
    private UserRepository repository;

    @Override
    public List<User> get()
    {
        final var users = repository.findAll();
        if (users.isEmpty())
        {
            throw new NoUserContentException();
        }
        return users;
    }

    @Override
    public User get(final String uuid)
    {
        return null;
    }
}
