package com.example.xindustrade.domain;

import com.example.xindustrade.Model.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="wishlist_items")
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long item_id;

   // @Column(name="user_id")



    //private String username;
    @Column(name="product_name")
    private String name;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;


}
