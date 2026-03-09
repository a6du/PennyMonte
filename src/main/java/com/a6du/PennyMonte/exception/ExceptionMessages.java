package com.a6du.PennyMonte.exception;

public enum ExceptionMessages {
    CATEGORY_NOT_FOUND("Category not found with id "),
    CATEGORY_NAME_ALREADY_EXISTS("Category name already exists"),
    CATEGORY_EMOJI_ALREADY_IN_USE("Category emoji already in use");

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
