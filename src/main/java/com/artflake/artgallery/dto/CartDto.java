package com.artflake.artgallery.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CartDto {

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime createdAt;
}
