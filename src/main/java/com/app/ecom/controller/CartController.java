package com.app.ecom.controller;


import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.service.CartService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @PostMapping
    public ResponseEntity<String> addtoCart (
            @RequestHeader("X-User-ID") String userId ,
            @RequestBody CartItemRequest request ) {
        if (!cartService.addToCart(userId ,request)){
            return ResponseEntity.badRequest().body("Product Out of Stock or user not found in db");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("items/{id}")
    public ResponseEntity<Void> removeFromCart(
            @RequestHeader("X-User-ID") String userId ,
            @PathVariable("id") Long productId ){
       boolean deleted = cartService.deleteItemFromCart(userId ,productId);
       return deleted ? ResponseEntity.notFound().build() : ResponseEntity.badRequest().build();
    }

    

}
