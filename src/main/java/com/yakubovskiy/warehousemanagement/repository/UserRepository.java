package com.yakubovskiy.warehousemanagement.repository;

import com.yakubovskiy.warehousemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	List<User> findAll();

	List<User> findByActive(boolean active);

	Optional<User> findUserById(int id);

	Optional<User> findUserByUsername(String username);
}
