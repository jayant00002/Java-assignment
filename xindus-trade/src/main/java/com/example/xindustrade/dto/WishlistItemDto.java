package com.example.xindustrade.dto;

import com.example.xindustrade.domain.WishlistItem;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

public class WishlistItemDto {
    @Getter
    @Setter
    private String productName;

    @Getter
    @Setter
    private String description;

    // Convert WishlistItemDto to WishlistItem entity
    public WishlistItem toWishlistItem() {
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setName(this.productName);
        wishlistItem.setDescription(this.description);
        // Set other necessary fields
        return wishlistItem;
    }

    // Constructor, equals, hashCode and toString methods
}

