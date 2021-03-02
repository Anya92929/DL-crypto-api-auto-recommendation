package com.google.gson;

class SyntheticFieldExclusionStrategy implements ExclusionStrategy {
    private final boolean skipSyntheticFields;

    SyntheticFieldExclusionStrategy(boolean skipSyntheticFields2) {
        this.skipSyntheticFields = skipSyntheticFields2;
    }

    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return this.skipSyntheticFields && f.isSynthetic();
    }
}
