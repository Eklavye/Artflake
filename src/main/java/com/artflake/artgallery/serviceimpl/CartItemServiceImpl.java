package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.CartItemDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.CartItem;
import com.artflake.artgallery.repository.CartItemRepository;
import com.artflake.artgallery.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CartItemDto> getAllCartItems() {
        return cartItemRepository.findAll().stream()
                .map(cartItem -> modelMapper.map(cartItem, CartItemDto.class))
                .collect(Collectors.toList());
    }

    public ApiResponse createCartItem(CartItemDto cartItemDto) {
        CartItem cartItem = modelMapper.map(cartItemDto, CartItem.class);
        cartItem = cartItemRepository.save(cartItem);
        modelMapper.map(cartItem, CartItemDto.class);
        return new ApiResponse("Cart item created successfully");
    }

    public ApiResponse deleteCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
        return new ApiResponse("Cart item deleted successfully");
    }
}

