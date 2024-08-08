package com.artflake.artgallery.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long cartItemId;
    private Long cartId;
    private Long artworkId;
    private int quantity;
    private LocalDateTime addedAt;
}

