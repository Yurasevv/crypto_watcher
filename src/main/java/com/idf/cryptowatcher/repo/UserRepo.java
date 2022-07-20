package com.idf.cryptowatcher.repo;

import com.idf.cryptowatcher.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
