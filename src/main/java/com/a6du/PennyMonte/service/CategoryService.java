package com.a6du.PennyMonte.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.a6du.PennyMonte.dto.category.CategoryCreateRequestDto;
import com.a6du.PennyMonte.enums.OperationType;
import com.a6du.PennyMonte.exception.ExceptionMessages;
import com.a6du.PennyMonte.model.Category;
import com.a6du.PennyMonte.repo.CategoryRepository;
import com.a6du.PennyMonte.util.CategoryTransformer;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Get category by id
    public Category getCategoryById(int id) {
        return categoryRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ExceptionMessages.CATEGORY_NOT_FOUND.withId(id)));
    }

        //Add media
        public Category addCategory(CategoryCreateRequestDto request) {
            Category category = CategoryTransformer.toEntity(request, OperationType.CREATE);
            return categoryRepository.save(category);
        }
}
