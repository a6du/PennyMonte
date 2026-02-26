package com.a6du.PennyMonte.exception;

public enum ExceptionMessages {
    CATEGORY_NOT_FOUND("Category not found with id ");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String withId(Object id) {
        return message + id;
    }

    public String withDetail(String detail) {
        return message + detail;
    }
}
