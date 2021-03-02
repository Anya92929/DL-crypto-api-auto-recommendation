package com.google.gson;

import java.util.Collection;

final class DisjunctionExclusionStrategy implements ExclusionStrategy {
    private final Collection<ExclusionStrategy> strategies;

    public DisjunctionExclusionStrategy(Collection<ExclusionStrategy> strategies2) {
        Preconditions.checkNotNull(strategies2);
        this.strategies = strategies2;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        for (ExclusionStrategy strategy : this.strategies) {
            if (strategy.shouldSkipField(f)) {
                return true;
            }
        }
        return false;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        for (ExclusionStrategy strategy : this.strategies) {
            if (strategy.shouldSkipClass(clazz)) {
                return true;
            }
        }
        return false;
    }
}
