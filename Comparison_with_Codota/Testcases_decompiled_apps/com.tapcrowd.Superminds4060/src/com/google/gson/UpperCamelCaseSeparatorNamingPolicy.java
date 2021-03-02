package com.google.gson;

import com.google.gson.ModifyFirstLetterNamingPolicy;

final class UpperCamelCaseSeparatorNamingPolicy extends CompositionFieldNamingPolicy {
    public UpperCamelCaseSeparatorNamingPolicy(String separatorString) {
        super(new CamelCaseSeparatorNamingPolicy(separatorString), new ModifyFirstLetterNamingPolicy(ModifyFirstLetterNamingPolicy.LetterModifier.UPPER));
    }
}
