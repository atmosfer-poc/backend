package com.atmosferpoc.apigatewayservice.repository;

import com.atmosferpoc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
