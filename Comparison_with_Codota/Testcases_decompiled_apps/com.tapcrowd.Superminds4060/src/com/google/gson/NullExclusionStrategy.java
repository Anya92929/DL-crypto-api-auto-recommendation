package com.google.gson;

final class NullExclusionStrategy implements ExclusionStrategy {
    NullExclusionStrategy() {
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return false;
    }

    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }
}
