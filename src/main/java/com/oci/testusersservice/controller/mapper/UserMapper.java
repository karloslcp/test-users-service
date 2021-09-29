package com.oci.testusersservice.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.oci.testusersservice.controller.dto.UserDTO;
import com.oci.testusersservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    @Mapping(source = "entity", target = "name")
    UserDTO map(User entity);

    @Mapping(source = "dto", target = "firstName", qualifiedByName = "toFirstName")
    @Mapping(source = "dto", target = "lastName", qualifiedByName = "toLastName")
    User map(UserDTO dto);

    List<UserDTO> map(List<User> entities);

    Collection<User> map(Collection<UserDTO> dtos);

    default String toFullName(User entity)
    {
        return entity.getFirstName().concat(" ").concat(entity.getLastName());
    }

    @Named("toFirstName")
    default String toFirstName(UserDTO dto)
    {
        return getSubstring(dto.getName(), 0);
    }

    @Named("toLastName")
    default String toLastName(UserDTO dto)
    {
        return getSubstring(dto.getName(), 1);
    }

    default String getSubstring(String str, int subStrIndex)
    {
        return Optional.ofNullable(str)
            .map(s -> s.split(" "))
            .map(ss -> ss[subStrIndex])
            .orElse(null);
    }
}
