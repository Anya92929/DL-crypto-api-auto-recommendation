package com.google.gson;

import java.util.Collection;
import java.util.HashSet;

final class ModifierBasedExclusionStrategy implements ExclusionStrategy {
    private final Collection<Integer> modifiers = new HashSet();

    public ModifierBasedExclusionStrategy(int... modifiers2) {
        if (modifiers2 != null) {
            for (int modifier : modifiers2) {
                this.modifiers.add(Integer.valueOf(modifier));
            }
        }
    }

    public boolean shouldSkipField(FieldAttributes f) {
        for (Integer intValue : this.modifiers) {
            if (f.hasModifier(intValue.intValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }
}
