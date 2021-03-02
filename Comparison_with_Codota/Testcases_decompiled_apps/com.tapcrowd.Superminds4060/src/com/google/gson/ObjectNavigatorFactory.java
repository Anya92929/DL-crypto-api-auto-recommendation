package com.google.gson;

final class ObjectNavigatorFactory {
    private final FieldNamingStrategy2 fieldNamingPolicy;
    private final ExclusionStrategy strategy;

    public ObjectNavigatorFactory(ExclusionStrategy strategy2, FieldNamingStrategy2 fieldNamingPolicy2) {
        Preconditions.checkNotNull(fieldNamingPolicy2);
        this.strategy = strategy2 == null ? new NullExclusionStrategy() : strategy2;
        this.fieldNamingPolicy = fieldNamingPolicy2;
    }

    public ObjectNavigator create(ObjectTypePair objTypePair) {
        return new ObjectNavigator(objTypePair, this.strategy);
    }

    /* access modifiers changed from: package-private */
    public FieldNamingStrategy2 getFieldNamingPolicy() {
        return this.fieldNamingPolicy;
    }
}
