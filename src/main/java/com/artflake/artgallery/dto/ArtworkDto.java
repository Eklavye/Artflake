package com.artflake.artgallery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ArtworkDto {

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    private String description;

    @Size(max = 255)
    @NotNull
    private String image;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Long artistId;

    @NotNull
    private String artistName;
}
