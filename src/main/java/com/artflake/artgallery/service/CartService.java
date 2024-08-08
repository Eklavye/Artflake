package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.CartDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface CartService {
    List<CartDto> getAllCarts();

    CartDto getCartById(Long id);

    ApiResponse createCart(CartDto cartDto);

    ApiResponse updateCart(Long id, CartDto cartDto);

    ApiResponse deleteCart(Long id);
}
