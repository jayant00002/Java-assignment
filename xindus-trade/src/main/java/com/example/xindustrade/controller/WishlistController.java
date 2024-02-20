package com.example.xindustrade.controller;

import com.example.xindustrade.Exception.UserException;
import com.example.xindustrade.Model.Users;
import com.example.xindustrade.domain.WishlistItem;
import com.example.xindustrade.dto.WishlistItemDto;
import com.example.xindustrade.repository.UserRepository;
import com.example.xindustrade.service.UserService;
import com.example.xindustrade.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
    @Autowired
    private UserRepository userRepository;

    private final WishlistService wishlistService;

    private final UserService userService;

    @Autowired
    public WishlistController(WishlistService wishlistService, UserService userService) {
        this.wishlistService = wishlistService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<WishlistItem>> getWishlist() throws Exception {
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
        if(opt.isEmpty()) {
            throw new UserException("User not found");
        }
        Users loggedInUser = opt.get();
        //Long userId = getCurrentUserId(principal);
        List<WishlistItem> wishlistItems = wishlistService.getWishlistByUserId(loggedInUser.getUserId());
        return ResponseEntity.ok(wishlistItems);
    }

    @PostMapping
    public ResponseEntity<WishlistItem> createWishlistItem(@RequestBody WishlistItemDto itemDto) throws Exception {
        System.out.println("REACHED");
        //Long userId = 1L;
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
        if(opt.isEmpty()) {
            throw new UserException("User not found");
        }
        Users loggedInUser = opt.get();
        System.out.println(loggedInUser.getUserId());
        WishlistItem wishlistItem = wishlistService.createWishlistItem(loggedInUser.getUserId(), itemDto.toWishlistItem());
        return ResponseEntity.ok(wishlistItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWishlistItem(@PathVariable String id) throws Exception {
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
        if(opt.isEmpty()) {
            throw new UserException("User not found");
        }
        Users loggedInUser = opt.get();
        wishlistService.deleteWishlistItem(loggedInUser.getUserId(), id);
        return ResponseEntity.ok("Wishlist item deleted successfully.");
    }

}
