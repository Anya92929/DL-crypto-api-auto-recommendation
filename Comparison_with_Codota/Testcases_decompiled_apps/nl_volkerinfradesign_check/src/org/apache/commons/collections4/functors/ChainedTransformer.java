package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections4.Transformer;

public class ChainedTransformer<T> implements Serializable, Transformer<T, T> {
    private static final long serialVersionUID = 3514945074733160196L;

    /* renamed from: a */
    private final Transformer<? super T, ? extends T>[] f6413a;

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        C1320jj.m5719b((Transformer<?, ?>[]) transformerArr);
        if (transformerArr.length == 0) {
            return NOPTransformer.nopTransformer();
        }
        return new ChainedTransformer(transformerArr);
    }

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<T, T>> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Transformer collection must not be null");
        } else if (collection.size() == 0) {
            return NOPTransformer.nopTransformer();
        } else {
            Transformer[] transformerArr = (Transformer[]) collection.toArray(new Transformer[collection.size()]);
            C1320jj.m5719b((Transformer<?, ?>[]) transformerArr);
            return new ChainedTransformer(false, transformerArr);
        }
    }

    private ChainedTransformer(boolean z, Transformer<? super T, ? extends T>[] transformerArr) {
        this.f6413a = z ? C1320jj.m5716a((Transformer<? super I, ? extends O>[]) transformerArr) : transformerArr;
    }

    public ChainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        this(true, transformerArr);
    }

    public T transform(T t) {
        for (Transformer transform : this.f6413a) {
            t = transform.transform(t);
        }
        return t;
    }

    public Transformer<? super T, ? extends T>[] getTransformers() {
        return C1320jj.m5716a((Transformer<? super I, ? extends O>[]) this.f6413a);
    }
}
