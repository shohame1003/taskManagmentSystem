package com.example.taskmanagementsystem.user;

import com.example.taskmanagementsystem.common.service.GenericDtoMapper;
import com.example.taskmanagementsystem.user.dto.UserCreateDto;

import com.example.taskmanagementsystem.user.dto.UserResponseDto;
import com.example.taskmanagementsystem.user.dto.UserUpdateDto;
import com.example.taskmanagementsystem.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperDto extends GenericDtoMapper<User, UserCreateDto, UserUpdateDto, UserResponseDto> {

    private final ModelMapper mapper;

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return mapper.map(userCreateDto, User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void update(UserUpdateDto userUpdateDto, User user) {
        mapper.map(userUpdateDto, user);
    }
}
