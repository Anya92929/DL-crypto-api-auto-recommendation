package org.scribe.model;

import org.scribe.utils.OAuthEncoder;

public class Parameter implements Comparable<Parameter> {
    private static final String UTF = "UTF8";
    private final String key;
    private final String value;

    public Parameter(String key2, String value2) {
        this.key = key2;
        this.value = value2;
    }

    public String asUrlEncodedPair() {
        return OAuthEncoder.encode(this.key).concat("=").concat(OAuthEncoder.encode(this.value));
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Parameter)) {
            return false;
        }
        Parameter otherParam = (Parameter) other;
        if (!otherParam.key.equals(this.key) || !otherParam.value.equals(this.value)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.key.hashCode() + this.value.hashCode();
    }

    public int compareTo(Parameter parameter) {
        int keyDiff = this.key.compareTo(parameter.key);
        return keyDiff != 0 ? keyDiff : this.value.compareTo(parameter.value);
    }
}
