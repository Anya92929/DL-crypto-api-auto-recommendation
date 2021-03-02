package android.support.p003v7.internal.view.menu;

/* renamed from: android.support.v7.internal.view.menu.BaseWrapper */
class BaseWrapper {
    final Object mWrappedObject;

    BaseWrapper(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = obj;
    }

    public Object getWrappedObject() {
        return this.mWrappedObject;
    }
}
