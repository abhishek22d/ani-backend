package com.ani.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ani.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
