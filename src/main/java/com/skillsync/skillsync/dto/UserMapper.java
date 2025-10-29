package com.skillsync.skillsync.dto;

import com.skillsync.skillsync.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDtoToEntity(UserUpdateDTO userUpdateDTO);
    UserUpdateDTO fromEntityToDto(User user);
}
