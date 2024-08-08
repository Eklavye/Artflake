package com.artflake.artgallery.dto;

import com.artflake.artgallery.model.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @Size(max = 50)
    @NotNull
    private String username;

    @Size(max = 20)
    @NotNull
    private String password;

    @Size(max = 50)
    @NotNull
    private String email;

    @Size(max = 50)
    @NotNull
    private Role role;
}
