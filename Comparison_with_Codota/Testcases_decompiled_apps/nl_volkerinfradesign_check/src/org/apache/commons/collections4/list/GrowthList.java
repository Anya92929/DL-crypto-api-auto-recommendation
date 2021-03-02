package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public static <E> GrowthList<E> growthList(List<E> list) {
        return new GrowthList<>(list);
    }

    public GrowthList() {
        super(new ArrayList());
    }

    public GrowthList(int i) {
        super(new ArrayList(i));
    }

    protected GrowthList(List<E> list) {
        super(list);
    }

    public void add(int i, E e) {
        int size = decorated().size();
        if (i > size) {
            decorated().addAll(Collections.nCopies(i - size, (Object) null));
        }
        decorated().add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        int size = decorated().size();
        boolean z = false;
        if (i > size) {
            decorated().addAll(Collections.nCopies(i - size, (Object) null));
            z = true;
        }
        return z | decorated().addAll(i, collection);
    }

    public E set(int i, E e) {
        int size = decorated().size();
        if (i >= size) {
            decorated().addAll(Collections.nCopies((i - size) + 1, (Object) null));
        }
        return decorated().set(i, e);
    }
}
