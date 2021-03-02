package org.apache.commons.lang3.tuple;

public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    /* renamed from: of */
    public static <L, R> ImmutablePair<L, R> m7515of(L l, R r) {
        return new ImmutablePair<>(l, r);
    }

    public ImmutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }
}
