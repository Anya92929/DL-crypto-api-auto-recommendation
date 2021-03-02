package p000;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

/* renamed from: jl */
public abstract class C1322jl<K, V> extends AbstractMapDecorator<K, V> {
    public abstract V checkSetValue(V v);

    protected C1322jl() {
    }

    public C1322jl(Map<K, V> map) {
        super(map);
    }

    public boolean isSetValueChecking() {
        return true;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (isSetValueChecking()) {
            return new C1323a(this.f6624a.entrySet(), this);
        }
        return this.f6624a.entrySet();
    }

    /* renamed from: jl$a */
    class C1323a extends AbstractSetDecorator<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4354731610923110264L;

        /* renamed from: b */
        private final C1322jl<K, V> f4583b;

        protected C1323a(Set<Map.Entry<K, V>> set, C1322jl<K, V> jlVar) {
            super(set);
            this.f4583b = jlVar;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1324b(decorated().iterator(), this.f4583b);
        }

        public Object[] toArray() {
            Object[] array = decorated().toArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= array.length) {
                    return array;
                }
                array[i2] = new C1325c((Map.Entry) array[i2], this.f4583b);
                i = i2 + 1;
            }
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            if (tArr.length > 0) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 0);
            } else {
                tArr2 = tArr;
            }
            T[] array = decorated().toArray(tArr2);
            for (int i = 0; i < array.length; i++) {
                array[i] = new C1325c((Map.Entry) array[i], this.f4583b);
            }
            if (array.length > tArr.length) {
                return (Object[]) array;
            }
            System.arraycopy(array, 0, tArr, 0, array.length);
            if (tArr.length > array.length) {
                tArr[array.length] = null;
            }
            return tArr;
        }
    }

    /* renamed from: jl$b */
    class C1324b extends AbstractIteratorDecorator<Map.Entry<K, V>> {

        /* renamed from: b */
        private final C1322jl<K, V> f4585b;

        protected C1324b(Iterator<Map.Entry<K, V>> it, C1322jl<K, V> jlVar) {
            super(it);
            this.f4585b = jlVar;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return new C1325c((Map.Entry) getIterator().next(), this.f4585b);
        }
    }

    /* renamed from: jl$c */
    class C1325c extends AbstractMapEntryDecorator<K, V> {

        /* renamed from: b */
        private final C1322jl<K, V> f4587b;

        protected C1325c(Map.Entry<K, V> entry, C1322jl<K, V> jlVar) {
            super(entry);
            this.f4587b = jlVar;
        }

        public V setValue(V v) {
            return getMapEntry().setValue(this.f4587b.checkSetValue(v));
        }
    }
}
