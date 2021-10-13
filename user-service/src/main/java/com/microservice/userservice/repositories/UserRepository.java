package com.microservice.userservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.userservice.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findAllByEmailContainingIgnoreCase(Pageable pageable, String email);
}
