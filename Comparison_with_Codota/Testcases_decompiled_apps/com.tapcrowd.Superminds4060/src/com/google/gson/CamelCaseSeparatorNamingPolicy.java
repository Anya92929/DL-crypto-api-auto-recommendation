package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

final class CamelCaseSeparatorNamingPolicy extends RecursiveFieldNamingPolicy {
    private final String separatorString;

    public CamelCaseSeparatorNamingPolicy(String separatorString2) {
        Preconditions.checkNotNull(separatorString2);
        Preconditions.checkArgument(!"".equals(separatorString2));
        this.separatorString = separatorString2;
    }

    /* access modifiers changed from: protected */
    public String translateName(String target, Type fieldType, Collection<Annotation> collection) {
        StringBuilder translation = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char character = target.charAt(i);
            if (Character.isUpperCase(character) && translation.length() != 0) {
                translation.append(this.separatorString);
            }
            translation.append(character);
        }
        return translation.toString();
    }
}
