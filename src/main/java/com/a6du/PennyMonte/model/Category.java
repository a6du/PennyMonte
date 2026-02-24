package com.a6du.PennyMonte.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.a6du.PennyMonte.enums.OperationType;
import com.a6du.PennyMonte.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data; 
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "emoji", nullable = false, unique = true)
    private String emoji;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
    @Builder.Default
    private TransactionType categoryType = TransactionType.EXPENSE;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Version
    private int version;

    @Builder.Default
    @JsonIgnore
    private boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    @Builder.Default
    private OperationType operationType = OperationType.CREATE;
}
