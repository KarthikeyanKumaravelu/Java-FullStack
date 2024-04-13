package com.ladera.claims.s1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladera.claims.s1.entities.User;

public interface UserDAO  extends JpaRepository<User,Integer>{

	Optional<User> findByUserName(String userName);
}
