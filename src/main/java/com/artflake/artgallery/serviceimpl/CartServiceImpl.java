package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.CartDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Cart;
import com.artflake.artgallery.repository.CartRepository;
import com.artflake.artgallery.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream()
                .map(cart -> modelMapper.map(cart, CartDto.class))
                .toList();
    }

    @Override
    public CartDto getCartById(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        return modelMapper.map(cart, CartDto.class);
    }

    @Override
    public ApiResponse createCart(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        cartRepository.save(cart);
        return new ApiResponse("Inserted cart successfully");
    }

    @Override
    public ApiResponse updateCart(Long id, CartDto cartDto) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        modelMapper.map(cartDto, cart);
        cartRepository.save(cart);
        return new ApiResponse("Updated cart successfully");
    }

    @Override
    public ApiResponse deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return new ApiResponse("Deleted cart successfully");
        } else {
            throw new ResourceNotFoundException("Cart not found");
        }
    }
}
