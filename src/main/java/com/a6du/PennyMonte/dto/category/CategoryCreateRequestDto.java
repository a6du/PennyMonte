package com.a6du.PennyMonte.dto.category;

import com.a6du.PennyMonte.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CategoryCreateRequestDto(
        @NotBlank(message = "Category name is mandatory")
        String name,

        @NotBlank(message = "Category emoji is mandatory")
        String emoji,

        @NotNull(message = "Category type must be either INCOME or EXPENSE")
        TransactionType categoryType
) {
}