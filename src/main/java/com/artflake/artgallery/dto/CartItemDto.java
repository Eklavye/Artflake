package com.artflake.artgallery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cartItemId;

    @NotNull
    private Long cartId;

    @NotNull
    private Long artworkId;

    @NotNull
    private int quantity;

    @NotNull
    private LocalDateTime addedAt;
}

