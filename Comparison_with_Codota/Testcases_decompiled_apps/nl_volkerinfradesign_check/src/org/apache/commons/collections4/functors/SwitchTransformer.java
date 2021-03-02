package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class SwitchTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = -6404460890903469332L;

    /* renamed from: a */
    private final Predicate<? super I>[] f6457a;

    /* renamed from: b */
    private final Transformer<? super I, ? extends O>[] f6458b;

    /* renamed from: c */
    private final Transformer<? super I, ? extends O> f6459c;

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        C1320jj.m5718b((Predicate<?>[]) predicateArr);
        C1320jj.m5719b((Transformer<?, ?>[]) transformerArr);
        if (predicateArr.length != transformerArr.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        } else if (predicateArr.length != 0) {
            return new SwitchTransformer(predicateArr, transformerArr, transformer);
        } else {
            if (transformer == null) {
                return ConstantTransformer.nullTransformer();
            }
            return transformer;
        }
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> map) {
        if (map == null) {
            throw new IllegalArgumentException("The predicate and transformer map must not be null");
        } else if (map.size() == 0) {
            return ConstantTransformer.nullTransformer();
        } else {
            Transformer<I, O> transformer = (Transformer) map.remove((Object) null);
            int size = map.size();
            if (size != 0) {
                Transformer[] transformerArr = new Transformer[size];
                Predicate[] predicateArr = new Predicate[size];
                int i = 0;
                for (Map.Entry next : map.entrySet()) {
                    predicateArr[i] = (Predicate) next.getKey();
                    transformerArr[i] = (Transformer) next.getValue();
                    i++;
                }
                return new SwitchTransformer(false, predicateArr, transformerArr, transformer);
            } else if (transformer == null) {
                return ConstantTransformer.nullTransformer();
            } else {
                return transformer;
            }
        }
    }

    private SwitchTransformer(boolean z, Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this.f6457a = z ? C1320jj.m5715a((Predicate<? super T>[]) predicateArr) : predicateArr;
        this.f6458b = z ? C1320jj.m5716a(transformerArr) : transformerArr;
        this.f6459c = transformer == null ? ConstantTransformer.nullTransformer() : transformer;
    }

    public SwitchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this(true, predicateArr, transformerArr, transformer);
    }

    public O transform(I i) {
        for (int i2 = 0; i2 < this.f6457a.length; i2++) {
            if (this.f6457a[i2].evaluate(i)) {
                return this.f6458b[i2].transform(i);
            }
        }
        return this.f6459c.transform(i);
    }

    public Predicate<? super I>[] getPredicates() {
        return C1320jj.m5715a((Predicate<? super T>[]) this.f6457a);
    }

    public Transformer<? super I, ? extends O>[] getTransformers() {
        return C1320jj.m5716a(this.f6458b);
    }

    public Transformer<? super I, ? extends O> getDefaultTransformer() {
        return this.f6459c;
    }
}
