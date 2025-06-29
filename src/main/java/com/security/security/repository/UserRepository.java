package com.security.security.repository;

import com.security.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    public User  findByEmail( String email);




}
