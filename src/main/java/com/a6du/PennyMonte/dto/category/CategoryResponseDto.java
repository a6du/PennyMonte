package com.a6du.PennyMonte.dto.category;

import com.a6du.PennyMonte.enums.TransactionType;

public record CategoryResponseDto(
    int id,
    String name,
    String emoji,
    TransactionType categoryType
) {
    
}
