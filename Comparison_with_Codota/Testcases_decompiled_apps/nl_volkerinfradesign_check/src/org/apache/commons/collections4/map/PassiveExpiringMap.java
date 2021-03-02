package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PassiveExpiringMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: b */
    private final Map<Object, Long> f6703b;

    /* renamed from: c */
    private final ExpirationPolicy<K, V> f6704c;

    public interface ExpirationPolicy<K, V> extends Serializable {
        long expirationTime(K k, V v);
    }

    public static class ConstantTimeToLiveExpirationPolicy<K, V> implements ExpirationPolicy<K, V> {
        private static final long serialVersionUID = 1;

        /* renamed from: a */
        private final long f6705a;

        public ConstantTimeToLiveExpirationPolicy() {
            this(-1);
        }

        public ConstantTimeToLiveExpirationPolicy(long j) {
            this.f6705a = j;
        }

        public ConstantTimeToLiveExpirationPolicy(long j, TimeUnit timeUnit) {
            this(PassiveExpiringMap.m7149b(j, timeUnit));
        }

        public long expirationTime(K k, V v) {
            if (this.f6705a < 0) {
                return -1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > Long.MAX_VALUE - this.f6705a) {
                return -1;
            }
            return this.f6705a + currentTimeMillis;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static long m7149b(long j, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return TimeUnit.MILLISECONDS.convert(j, timeUnit);
        }
        throw new IllegalArgumentException("Time unit must not be null");
    }

    public PassiveExpiringMap() {
        this(-1);
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy) {
        this(expirationPolicy, new HashMap());
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy, Map<K, V> map) {
        super(map);
        this.f6703b = new HashMap();
        if (expirationPolicy == null) {
            throw new IllegalArgumentException("Policy must not be null.");
        }
        this.f6704c = expirationPolicy;
    }

    public PassiveExpiringMap(long j) {
        this(new ConstantTimeToLiveExpirationPolicy(j), new HashMap());
    }

    public PassiveExpiringMap(long j, Map<K, V> map) {
        this(new ConstantTimeToLiveExpirationPolicy(j), map);
    }

    public PassiveExpiringMap(long j, TimeUnit timeUnit) {
        this(m7149b(j, timeUnit));
    }

    public PassiveExpiringMap(long j, TimeUnit timeUnit, Map<K, V> map) {
        this(m7149b(j, timeUnit), map);
    }

    public PassiveExpiringMap(Map<K, V> map) {
        this(-1, map);
    }

    public void clear() {
        super.clear();
        this.f6703b.clear();
    }

    public boolean containsKey(Object obj) {
        m7147a(obj, m7143a());
        return super.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        m7146a(m7143a());
        return super.containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        m7146a(m7143a());
        return super.entrySet();
    }

    public V get(Object obj) {
        m7147a(obj, m7143a());
        return super.get(obj);
    }

    public boolean isEmpty() {
        m7146a(m7143a());
        return super.isEmpty();
    }

    /* renamed from: a */
    private boolean m7148a(long j, Long l) {
        if (l == null) {
            return false;
        }
        long longValue = l.longValue();
        if (longValue < 0 || j < longValue) {
            return false;
        }
        return true;
    }

    public Set<K> keySet() {
        m7146a(m7143a());
        return super.keySet();
    }

    /* renamed from: a */
    private long m7143a() {
        return System.currentTimeMillis();
    }

    public V put(K k, V v) {
        return m7145a(k, v, m7143a());
    }

    /* renamed from: a */
    private V m7145a(K k, V v, long j) {
        this.f6703b.put(k, Long.valueOf(this.f6704c.expirationTime(k, v)));
        return super.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V remove(Object obj) {
        this.f6703b.remove(obj);
        return super.remove(obj);
    }

    /* renamed from: a */
    private void m7146a(long j) {
        Iterator<Map.Entry<Object, Long>> it = this.f6703b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (m7148a(j, (Long) next.getValue())) {
                super.remove(next.getKey());
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private void m7147a(Object obj, long j) {
        if (m7148a(j, this.f6703b.get(obj))) {
            remove(obj);
        }
    }

    public int size() {
        m7146a(m7143a());
        return super.size();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6624a = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6624a);
    }

    public Collection<V> values() {
        m7146a(m7143a());
        return super.values();
    }
}
