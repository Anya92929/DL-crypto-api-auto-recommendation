package android.support.p003v7.internal.view.menu;

/* renamed from: android.support.v7.internal.view.menu.BaseWrapper */
class BaseWrapper<T> {

    /* renamed from: b */
    final T f2073b;

    BaseWrapper(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f2073b = t;
    }

    public T getWrappedObject() {
        return this.f2073b;
    }
}
