package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Transformer;

public final class MapTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = 862391807045468939L;

    /* renamed from: a */
    private final Map<? super I, ? extends O> f6442a;

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> map) {
        if (map == null) {
            return ConstantTransformer.nullTransformer();
        }
        return new MapTransformer(map);
    }

    private MapTransformer(Map<? super I, ? extends O> map) {
        this.f6442a = map;
    }

    public O transform(I i) {
        return this.f6442a.get(i);
    }

    public Map<? super I, ? extends O> getMap() {
        return this.f6442a;
    }
}
