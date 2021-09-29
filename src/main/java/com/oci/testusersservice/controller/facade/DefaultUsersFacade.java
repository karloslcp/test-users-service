package com.oci.testusersservice.controller.facade;

import java.util.List;

import com.oci.testusersservice.controller.dto.UserDTO;
import com.oci.testusersservice.controller.mapper.UserMapper;
import com.oci.testusersservice.exception.NoUserContentException;
import com.oci.testusersservice.exception.UserNotFoundException;
import com.oci.testusersservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUsersFacade implements UserFacade
{
    private UserRepository repository;

    private UserMapper mapper;

    private MessageSource messageSource;

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
    public UserDTO get(final Long id)
    {
        final var user = repository.findById(id);
        return user
            .map(mapper::map)
            .orElseThrow(() -> {
                final var message = messageSource.getMessage("users.exception.not-found", new Object[] { id }, LocaleContextHolder.getLocale());
                return new UserNotFoundException(message);
            });
    }
}
