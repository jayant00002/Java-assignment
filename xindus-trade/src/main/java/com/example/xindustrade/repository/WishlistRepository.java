package com.example.xindustrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.xindustrade.domain.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistItem, String> {
    List<WishlistItem> findAllByUser_UserId(String userId);
}