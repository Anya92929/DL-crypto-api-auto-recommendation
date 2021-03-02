package org.apache.commons.collections4.list;

import java.util.List;
import org.apache.commons.collections4.Factory;

public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -1708388017160694542L;

    /* renamed from: a */
    private final Factory<? extends E> f6581a;

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    protected LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.f6581a = factory;
    }

    public E get(int i) {
        int size = decorated().size();
        if (i < size) {
            E e = decorated().get(i);
            if (e != null) {
                return e;
            }
            E create = this.f6581a.create();
            decorated().set(i, create);
            return create;
        }
        while (size < i) {
            decorated().add((Object) null);
            size++;
        }
        E create2 = this.f6581a.create();
        decorated().add(create2);
        return create2;
    }

    public List<E> subList(int i, int i2) {
        return new LazyList(decorated().subList(i, i2), this.f6581a);
    }
}
