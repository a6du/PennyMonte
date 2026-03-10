package com.a6du.PennyMonte.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.a6du.PennyMonte.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByIdAndIsDeletedFalse(Integer id);

    boolean existsByNameAndIsDeletedFalse(String name);

    boolean existsByEmojiAndIsDeletedFalse(String emoji);
}
