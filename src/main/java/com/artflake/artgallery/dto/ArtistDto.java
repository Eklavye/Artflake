package com.artflake.artgallery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ArtistDto {

    @NotNull
    private Long id;

    @Size(max = 50)
    @NotNull
    private String name;

    @NotNull
    private String bio;

    @Size(max = 255)
    @NotNull
    private String profilePicture;
}
