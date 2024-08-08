package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.UserDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    ApiResponse createUser(UserDto userDto);

    ApiResponse updateUser(Long id, UserDto userDto);

    ApiResponse deleteUser(Long id);

}
