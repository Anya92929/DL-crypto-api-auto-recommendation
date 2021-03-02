package com.google.gson;

final class Pair<FIRST, SECOND> {
    final FIRST first;
    final SECOND second;

    Pair(FIRST first2, SECOND second2) {
        this.first = first2;
        this.second = second2;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.first != null ? this.first.hashCode() : 0) * 17;
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode + (i * 17);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> that = (Pair) o;
        if (!equal(this.first, that.first) || !equal(this.second, that.second)) {
            return false;
        }
        return true;
    }

    private static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public String toString() {
        return String.format("{%s,%s}", new Object[]{this.first, this.second});
    }
}
