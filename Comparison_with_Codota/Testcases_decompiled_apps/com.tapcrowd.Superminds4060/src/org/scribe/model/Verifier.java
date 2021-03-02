package org.scribe.model;

import org.scribe.utils.Preconditions;

public class Verifier {
    private final String value;

    public Verifier(String value2) {
        Preconditions.checkNotNull(value2, "Must provide a valid string as verifier");
        this.value = value2;
    }

    public String getValue() {
        return this.value;
    }
}
