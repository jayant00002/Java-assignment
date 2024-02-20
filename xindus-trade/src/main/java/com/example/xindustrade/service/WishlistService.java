package com.example.xindustrade.service;

import com.example.xindustrade.domain.WishlistItem;
import com.example.xindustrade.repository.UserRepository;
import com.example.xindustrade.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
    }

    public WishlistItem createWishlistItem(String userId, WishlistItem wishlistItem) throws Exception {
        System.out.println(userId);
        System.out.println(wishlistItem);
        return userRepository.findById(String.valueOf(userId)).map(user -> {
            wishlistItem.setUser(user);
            return wishlistRepository.save(wishlistItem);
        }).orElseThrow(() -> new Exception("User not found with id: " + userId));
    }

    public List<WishlistItem> getWishlistByUserId(String userId) {
        return wishlistRepository.findAllByUser_UserId(userId);
    }

    public void deleteWishlistItem(String userId, String itemId) throws Exception {
        WishlistItem wishlistItem = wishlistRepository.findById(itemId)
                .orElseThrow(() -> new Exception("WishlistItem not found with id: " + itemId));

        if (!wishlistItem.getUser().getUserId().equals(userId)) {
            throw new Exception("User " + userId + " cannot delete wishlist item " + itemId);
        }

        wishlistRepository.deleteById(itemId);
    }

    // Other wishlist related methods
}
