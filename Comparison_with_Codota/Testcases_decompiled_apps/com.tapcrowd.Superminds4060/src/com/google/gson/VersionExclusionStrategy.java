package com.google.gson;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

final class VersionExclusionStrategy implements ExclusionStrategy {
    private final double version;

    public VersionExclusionStrategy(double version2) {
        Preconditions.checkArgument(version2 >= 0.0d);
        this.version = version2;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return !isValidVersion((Since) f.getAnnotation(Since.class), (Until) f.getAnnotation(Until.class));
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return !isValidVersion((Since) clazz.getAnnotation(Since.class), (Until) clazz.getAnnotation(Until.class));
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since annotation) {
        if (annotation == null || annotation.value() <= this.version) {
            return true;
        }
        return false;
    }

    private boolean isValidUntil(Until annotation) {
        if (annotation == null || annotation.value() > this.version) {
            return true;
        }
        return false;
    }
}
