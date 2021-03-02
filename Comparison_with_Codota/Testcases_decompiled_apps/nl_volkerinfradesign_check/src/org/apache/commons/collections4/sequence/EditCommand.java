package org.apache.commons.collections4.sequence;

public abstract class EditCommand<T> {

    /* renamed from: a */
    private final T f6739a;

    public abstract void accept(CommandVisitor<T> commandVisitor);

    protected EditCommand(T t) {
        this.f6739a = t;
    }

    /* access modifiers changed from: protected */
    public T getObject() {
        return this.f6739a;
    }
}
