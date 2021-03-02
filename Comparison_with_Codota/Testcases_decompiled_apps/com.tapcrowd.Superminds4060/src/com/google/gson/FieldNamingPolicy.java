package com.google.gson;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.gson.ModifyFirstLetterNamingPolicy;

public enum FieldNamingPolicy {
    UPPER_CAMEL_CASE(new ModifyFirstLetterNamingPolicy(ModifyFirstLetterNamingPolicy.LetterModifier.UPPER)),
    UPPER_CAMEL_CASE_WITH_SPACES(new UpperCamelCaseSeparatorNamingPolicy(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)),
    LOWER_CASE_WITH_UNDERSCORES(new LowerCamelCaseSeparatorNamingPolicy("_")),
    LOWER_CASE_WITH_DASHES(new LowerCamelCaseSeparatorNamingPolicy("-"));
    
    private final FieldNamingStrategy2 namingPolicy;

    private FieldNamingPolicy(FieldNamingStrategy2 namingPolicy2) {
        this.namingPolicy = namingPolicy2;
    }

    /* access modifiers changed from: package-private */
    public FieldNamingStrategy2 getFieldNamingPolicy() {
        return this.namingPolicy;
    }
}
