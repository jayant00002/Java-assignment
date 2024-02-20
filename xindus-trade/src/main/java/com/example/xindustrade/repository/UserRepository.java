package com.example.xindustrade.repository;


import java.util.Optional;

import com.example.xindustrade.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, String>{

    public Optional<Users> findByEmail(String email);

}