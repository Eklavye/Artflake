package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.CartDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        List<CartDto> carts = cartService.getAllCarts();
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") Long id) {
        CartDto cart = cartService.getCartById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCart(@RequestBody CartDto cartDto) {
        ApiResponse response = cartService.createCart(cartDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCart(@PathVariable("id") Long id, @RequestBody CartDto cartDto) {
        ApiResponse response = cartService.updateCart(id, cartDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCart(@PathVariable("id") Long id) {
        ApiResponse response = cartService.deleteCart(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}