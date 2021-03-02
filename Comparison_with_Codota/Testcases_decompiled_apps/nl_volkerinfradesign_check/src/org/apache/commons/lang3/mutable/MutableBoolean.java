package org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableBoolean implements Serializable, Comparable<MutableBoolean>, Mutable<Boolean> {
    private static final long serialVersionUID = -4830728138360036487L;

    /* renamed from: a */
    private boolean f7143a;

    public MutableBoolean() {
    }

    public MutableBoolean(boolean z) {
        this.f7143a = z;
    }

    public MutableBoolean(Boolean bool) {
        this.f7143a = bool.booleanValue();
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.f7143a);
    }

    public void setValue(boolean z) {
        this.f7143a = z;
    }

    public void setValue(Boolean bool) {
        this.f7143a = bool.booleanValue();
    }

    public boolean isTrue() {
        return this.f7143a;
    }

    public boolean isFalse() {
        return !this.f7143a;
    }

    public boolean booleanValue() {
        return this.f7143a;
    }

    public Boolean toBoolean() {
        return Boolean.valueOf(booleanValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableBoolean) || this.f7143a != ((MutableBoolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7143a ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode();
    }

    public int compareTo(MutableBoolean mutableBoolean) {
        if (this.f7143a == mutableBoolean.f7143a) {
            return 0;
        }
        return this.f7143a ? 1 : -1;
    }

    public String toString() {
        return String.valueOf(this.f7143a);
    }
}
