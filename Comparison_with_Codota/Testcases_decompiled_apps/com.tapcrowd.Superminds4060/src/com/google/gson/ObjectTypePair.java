package com.google.gson;

import java.lang.reflect.Type;

final class ObjectTypePair {
    private Object obj;
    private final boolean preserveType;
    final Type type;

    ObjectTypePair(Object obj2, Type type2, boolean preserveType2) {
        this.obj = obj2;
        this.type = type2;
        this.preserveType = preserveType2;
    }

    /* access modifiers changed from: package-private */
    public Object getObject() {
        return this.obj;
    }

    /* access modifiers changed from: package-private */
    public void setObject(Object obj2) {
        this.obj = obj2;
    }

    /* access modifiers changed from: package-private */
    public Type getType() {
        return this.type;
    }

    public String toString() {
        return String.format("preserveType: %b, type: %s, obj: %s", new Object[]{Boolean.valueOf(this.preserveType), this.type, this.obj});
    }

    /* access modifiers changed from: package-private */
    public <HANDLER> Pair<HANDLER, ObjectTypePair> getMatchingHandler(ParameterizedTypeHandlerMap<HANDLER> handlers) {
        if (!this.preserveType && this.obj != null) {
            ObjectTypePair moreSpecificType = toMoreSpecificType();
            HANDLER handler = handlers.getHandlerFor(moreSpecificType.type);
            if (handler != null) {
                return new Pair<>(handler, moreSpecificType);
            }
        }
        HANDLER handler2 = handlers.getHandlerFor(this.type);
        if (handler2 == null) {
            return null;
        }
        return new Pair<>(handler2, this);
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r0 = getActualTypeIfMoreSpecific(r4.type, r4.obj.getClass());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.ObjectTypePair toMoreSpecificType() {
        /*
            r4 = this;
            boolean r1 = r4.preserveType
            if (r1 != 0) goto L_0x0008
            java.lang.Object r1 = r4.obj
            if (r1 != 0) goto L_0x0009
        L_0x0008:
            return r4
        L_0x0009:
            java.lang.reflect.Type r1 = r4.type
            java.lang.Object r2 = r4.obj
            java.lang.Class r2 = r2.getClass()
            java.lang.reflect.Type r0 = getActualTypeIfMoreSpecific(r1, r2)
            java.lang.reflect.Type r1 = r4.type
            if (r0 == r1) goto L_0x0008
            com.google.gson.ObjectTypePair r1 = new com.google.gson.ObjectTypePair
            java.lang.Object r2 = r4.obj
            boolean r3 = r4.preserveType
            r1.<init>(r2, r0, r3)
            r4 = r1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.ObjectTypePair.toMoreSpecificType():com.google.gson.ObjectTypePair");
    }

    static Type getActualTypeIfMoreSpecific(Type type2, Class<?> actualClass) {
        if (!(type2 instanceof Class)) {
            return type2;
        }
        if (((Class) type2).isAssignableFrom(actualClass)) {
            type2 = actualClass;
        }
        if (type2 == Object.class) {
            return actualClass;
        }
        return type2;
    }

    public int hashCode() {
        if (this.obj == null) {
            return 31;
        }
        return this.obj.hashCode();
    }

    public boolean equals(Object obj2) {
        boolean z = true;
        if (this == obj2) {
            return true;
        }
        if (obj2 == null || getClass() != obj2.getClass()) {
            return false;
        }
        ObjectTypePair other = (ObjectTypePair) obj2;
        if (this.obj == null) {
            if (other.obj != null) {
                return false;
            }
        } else if (this.obj != other.obj) {
            return false;
        }
        if (this.type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!this.type.equals(other.type)) {
            return false;
        }
        if (this.preserveType != other.preserveType) {
            z = false;
        }
        return z;
    }

    public boolean isPreserveType() {
        return this.preserveType;
    }
}
