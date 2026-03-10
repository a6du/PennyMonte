package com.a6du.PennyMonte.util;

import com.a6du.PennyMonte.dto.category.CategoryCreateRequestDto;
import com.a6du.PennyMonte.dto.category.CategoryResponseDto;
import com.a6du.PennyMonte.enums.OperationType;
import com.a6du.PennyMonte.model.Category;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategoryTransformer {

    public static Category toEntity(CategoryCreateRequestDto request,  OperationType operationType) {
        return Category.builder()
                .name(request.name())
                .emoji(request.emoji())
                .categoryType(request.categoryType())
                .operationType(operationType)
                .build();
    }

    public static CategoryResponseDto toResponseDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName(),
                category.getEmoji(),
                category.getCategoryType()
        );
    }
}
