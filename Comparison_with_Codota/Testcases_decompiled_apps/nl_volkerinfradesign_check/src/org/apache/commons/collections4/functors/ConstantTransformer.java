package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

public class ConstantTransformer<I, O> implements Serializable, Transformer<I, O> {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer((Object) null);
    private static final long serialVersionUID = 6374440726369055124L;

    /* renamed from: a */
    private final O f6421a;

    public static <I, O> Transformer<I, O> nullTransformer() {
        return NULL_INSTANCE;
    }

    public static <I, O> Transformer<I, O> constantTransformer(O o) {
        if (o == null) {
            return nullTransformer();
        }
        return new ConstantTransformer(o);
    }

    public ConstantTransformer(O o) {
        this.f6421a = o;
    }

    public O transform(I i) {
        return this.f6421a;
    }

    public O getConstant() {
        return this.f6421a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantTransformer)) {
            return false;
        }
        Object constant = ((ConstantTransformer) obj).getConstant();
        if (constant == getConstant() || (constant != null && constant.equals(getConstant()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = "ConstantTransformer".hashCode() << 2;
        if (getConstant() != null) {
            return hashCode | getConstant().hashCode();
        }
        return hashCode;
    }
}
