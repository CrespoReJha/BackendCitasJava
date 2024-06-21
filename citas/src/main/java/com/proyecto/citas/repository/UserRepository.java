package com.proyecto.citas.repository;

import com.proyecto.citas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
