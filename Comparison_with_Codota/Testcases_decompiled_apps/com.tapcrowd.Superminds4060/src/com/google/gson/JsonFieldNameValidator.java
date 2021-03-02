package com.google.gson;

import java.util.regex.Pattern;

class JsonFieldNameValidator {
    private static final String COMMON_PATTERN = "[a-zA-Z][a-zA-Z0-9\\ \\$_\\-]*$";
    private static final Pattern JSON_FIELD_NAME_PATTERN = Pattern.compile("(^[a-zA-Z][a-zA-Z0-9\\ \\$_\\-]*$)|(^[\\$_][a-zA-Z][a-zA-Z0-9\\ \\$_\\-]*$)");

    JsonFieldNameValidator() {
    }

    public String validate(String fieldName) {
        Preconditions.checkNotNull(fieldName);
        Preconditions.checkArgument(!"".equals(fieldName.trim()));
        if (JSON_FIELD_NAME_PATTERN.matcher(fieldName).matches()) {
            return fieldName;
        }
        throw new IllegalArgumentException(fieldName + " is not a valid JSON field name.");
    }
}
