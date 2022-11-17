package com.javapractice.demo.dao;

import com.javapractice.demo.entities.Animals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalsRepository extends JpaRepository<Animals, UUID> {
}
