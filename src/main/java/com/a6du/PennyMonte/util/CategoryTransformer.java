package com.a6du.PennyMonte.util;

import com.a6du.PennyMonte.dto.category.CategoryCreateRequestDto;
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
}
