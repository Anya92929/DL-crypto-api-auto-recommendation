package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class Flat3Map<K, V> implements Serializable, Cloneable, IterableMap<K, V> {
    private static final long serialVersionUID = -6701087419741928296L;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public transient int f6648a;

    /* renamed from: b */
    private transient int f6649b;

    /* renamed from: c */
    private transient int f6650c;

    /* renamed from: d */
    private transient int f6651d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public transient K f6652e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public transient K f6653f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public transient K f6654g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public transient V f6655h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public transient V f6656i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public transient V f6657j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public transient AbstractHashedMap<K, V> f6658k;

    public Flat3Map() {
    }

    public Flat3Map(Map<? extends K, ? extends V> map) {
        putAll(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2.f6653f != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (r2.f6652e != null) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return r2.f6656i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return r2.f6655h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(java.lang.Object r3) {
        /*
            r2 = this;
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r2.f6658k
            if (r0 == 0) goto L_0x000b
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r2.f6658k
            java.lang.Object r0 = r0.get(r3)
        L_0x000a:
            return r0
        L_0x000b:
            if (r3 != 0) goto L_0x0029
            int r0 = r2.f6648a
            switch(r0) {
                case 1: goto L_0x0022;
                case 2: goto L_0x001b;
                case 3: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0 = 0
            goto L_0x000a
        L_0x0014:
            K r0 = r2.f6654g
            if (r0 != 0) goto L_0x001b
            V r0 = r2.f6657j
            goto L_0x000a
        L_0x001b:
            K r0 = r2.f6653f
            if (r0 != 0) goto L_0x0022
            V r0 = r2.f6656i
            goto L_0x000a
        L_0x0022:
            K r0 = r2.f6652e
            if (r0 != 0) goto L_0x0012
            V r0 = r2.f6655h
            goto L_0x000a
        L_0x0029:
            int r0 = r2.f6648a
            if (r0 <= 0) goto L_0x0012
            int r0 = r3.hashCode()
            int r1 = r2.f6648a
            switch(r1) {
                case 1: goto L_0x0037;
                case 2: goto L_0x0055;
                case 3: goto L_0x0046;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0012
        L_0x0037:
            int r1 = r2.f6649b
            if (r1 != r0) goto L_0x0012
            K r0 = r2.f6652e
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0012
            V r0 = r2.f6655h
            goto L_0x000a
        L_0x0046:
            int r1 = r2.f6651d
            if (r1 != r0) goto L_0x0055
            K r1 = r2.f6654g
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0055
            V r0 = r2.f6657j
            goto L_0x000a
        L_0x0055:
            int r1 = r2.f6650c
            if (r1 != r0) goto L_0x0037
            K r1 = r2.f6653f
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0037
            V r0 = r2.f6656i
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.Flat3Map.get(java.lang.Object):java.lang.Object");
    }

    public int size() {
        if (this.f6658k != null) {
            return this.f6658k.size();
        }
        return this.f6648a;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r3.f6653f == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r3.f6652e != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsKey(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r1 = r3.f6658k
            if (r1 == 0) goto L_0x000c
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r3.f6658k
            boolean r0 = r0.containsKey(r4)
        L_0x000b:
            return r0
        L_0x000c:
            if (r4 != 0) goto L_0x0022
            int r1 = r3.f6648a
            switch(r1) {
                case 1: goto L_0x001d;
                case 2: goto L_0x0019;
                case 3: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            r0 = 0
            goto L_0x000b
        L_0x0015:
            K r1 = r3.f6654g
            if (r1 == 0) goto L_0x000b
        L_0x0019:
            K r1 = r3.f6653f
            if (r1 == 0) goto L_0x000b
        L_0x001d:
            K r1 = r3.f6652e
            if (r1 != 0) goto L_0x0013
            goto L_0x000b
        L_0x0022:
            int r1 = r3.f6648a
            if (r1 <= 0) goto L_0x0013
            int r1 = r4.hashCode()
            int r2 = r3.f6648a
            switch(r2) {
                case 1: goto L_0x0030;
                case 2: goto L_0x0049;
                case 3: goto L_0x003d;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0013
        L_0x0030:
            int r2 = r3.f6649b
            if (r2 != r1) goto L_0x0013
            K r1 = r3.f6652e
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0013
            goto L_0x000b
        L_0x003d:
            int r2 = r3.f6651d
            if (r2 != r1) goto L_0x0049
            K r2 = r3.f6654g
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x000b
        L_0x0049:
            int r2 = r3.f6650c
            if (r2 != r1) goto L_0x0030
            K r2 = r3.f6653f
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0030
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.Flat3Map.containsKey(java.lang.Object):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r2.f6656i == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r2.f6655h != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsValue(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 1
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r1 = r2.f6658k
            if (r1 == 0) goto L_0x000c
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r2.f6658k
            boolean r0 = r0.containsValue(r3)
        L_0x000b:
            return r0
        L_0x000c:
            if (r3 != 0) goto L_0x0022
            int r1 = r2.f6648a
            switch(r1) {
                case 1: goto L_0x001d;
                case 2: goto L_0x0019;
                case 3: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            r0 = 0
            goto L_0x000b
        L_0x0015:
            V r1 = r2.f6657j
            if (r1 == 0) goto L_0x000b
        L_0x0019:
            V r1 = r2.f6656i
            if (r1 == 0) goto L_0x000b
        L_0x001d:
            V r1 = r2.f6655h
            if (r1 != 0) goto L_0x0013
            goto L_0x000b
        L_0x0022:
            int r1 = r2.f6648a
            switch(r1) {
                case 1: goto L_0x0028;
                case 2: goto L_0x0039;
                case 3: goto L_0x0031;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0013
        L_0x0028:
            V r1 = r2.f6655h
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0013
            goto L_0x000b
        L_0x0031:
            V r1 = r2.f6657j
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x000b
        L_0x0039:
            V r1 = r2.f6656i
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0028
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.Flat3Map.containsValue(java.lang.Object):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r4.f6653f != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0 = r4.f6656i;
        r4.f6656i = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r4.f6652e != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r0 = r4.f6655h;
        r4.f6655h = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V put(K r5, V r6) {
        /*
            r4 = this;
            r1 = 0
            r0 = 0
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r2 = r4.f6658k
            if (r2 == 0) goto L_0x000d
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r4.f6658k
            java.lang.Object r0 = r0.put(r5, r6)
        L_0x000c:
            return r0
        L_0x000d:
            if (r5 != 0) goto L_0x003e
            int r2 = r4.f6648a
            switch(r2) {
                case 1: goto L_0x0035;
                case 2: goto L_0x002c;
                case 3: goto L_0x0023;
                default: goto L_0x0014;
            }
        L_0x0014:
            int r2 = r4.f6648a
            switch(r2) {
                case 0: goto L_0x00a3;
                case 1: goto L_0x0095;
                case 2: goto L_0x007f;
                default: goto L_0x0019;
            }
        L_0x0019:
            r4.m7125a()
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r4.f6658k
            r0.put(r5, r6)
            r0 = r1
            goto L_0x000c
        L_0x0023:
            K r2 = r4.f6654g
            if (r2 != 0) goto L_0x002c
            V r0 = r4.f6657j
            r4.f6657j = r6
            goto L_0x000c
        L_0x002c:
            K r2 = r4.f6653f
            if (r2 != 0) goto L_0x0035
            V r0 = r4.f6656i
            r4.f6656i = r6
            goto L_0x000c
        L_0x0035:
            K r2 = r4.f6652e
            if (r2 != 0) goto L_0x0014
            V r0 = r4.f6655h
            r4.f6655h = r6
            goto L_0x000c
        L_0x003e:
            int r2 = r4.f6648a
            if (r2 <= 0) goto L_0x0014
            int r2 = r5.hashCode()
            int r3 = r4.f6648a
            switch(r3) {
                case 1: goto L_0x004c;
                case 2: goto L_0x006e;
                case 3: goto L_0x005d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0014
        L_0x004c:
            int r3 = r4.f6649b
            if (r3 != r2) goto L_0x0014
            K r2 = r4.f6652e
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0014
            V r0 = r4.f6655h
            r4.f6655h = r6
            goto L_0x000c
        L_0x005d:
            int r3 = r4.f6651d
            if (r3 != r2) goto L_0x006e
            K r3 = r4.f6654g
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x006e
            V r0 = r4.f6657j
            r4.f6657j = r6
            goto L_0x000c
        L_0x006e:
            int r3 = r4.f6650c
            if (r3 != r2) goto L_0x004c
            K r3 = r4.f6653f
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x004c
            V r0 = r4.f6656i
            r4.f6656i = r6
            goto L_0x000c
        L_0x007f:
            if (r5 != 0) goto L_0x0090
        L_0x0081:
            r4.f6651d = r0
            r4.f6654g = r5
            r4.f6657j = r6
        L_0x0087:
            int r0 = r4.f6648a
            int r0 = r0 + 1
            r4.f6648a = r0
            r0 = r1
            goto L_0x000c
        L_0x0090:
            int r0 = r5.hashCode()
            goto L_0x0081
        L_0x0095:
            if (r5 != 0) goto L_0x009e
        L_0x0097:
            r4.f6650c = r0
            r4.f6653f = r5
            r4.f6656i = r6
            goto L_0x0087
        L_0x009e:
            int r0 = r5.hashCode()
            goto L_0x0097
        L_0x00a3:
            if (r5 != 0) goto L_0x00ac
        L_0x00a5:
            r4.f6649b = r0
            r4.f6652e = r5
            r4.f6655h = r6
            goto L_0x0087
        L_0x00ac:
            int r0 = r5.hashCode()
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.Flat3Map.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            if (this.f6658k != null) {
                this.f6658k.putAll(map);
            } else if (size < 4) {
                for (Map.Entry next : map.entrySet()) {
                    put(next.getKey(), next.getValue());
                }
            } else {
                m7125a();
                this.f6658k.putAll(map);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0031, code lost:
        r5.f6658k.put(r5.f6653f, r5.f6656i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        r5.f6658k.put(r5.f6652e, r5.f6655h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        r5.f6648a = 0;
        r5.f6651d = 0;
        r5.f6650c = 0;
        r5.f6649b = 0;
        r5.f6654g = null;
        r5.f6653f = null;
        r5.f6652e = null;
        r5.f6657j = null;
        r5.f6656i = null;
        r5.f6655h = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0057, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7125a() {
        /*
            r5 = this;
            r4 = 0
            r3 = 0
            org.apache.commons.collections4.map.AbstractHashedMap r0 = r5.createDelegateMap()
            r5.f6658k = r0
            int r0 = r5.f6648a
            switch(r0) {
                case 0: goto L_0x0043;
                case 1: goto L_0x003a;
                case 2: goto L_0x0031;
                case 3: goto L_0x0028;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid map index: "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r5.f6648a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0028:
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r5.f6658k
            K r1 = r5.f6654g
            V r2 = r5.f6657j
            r0.put(r1, r2)
        L_0x0031:
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r5.f6658k
            K r1 = r5.f6653f
            V r2 = r5.f6656i
            r0.put(r1, r2)
        L_0x003a:
            org.apache.commons.collections4.map.AbstractHashedMap<K, V> r0 = r5.f6658k
            K r1 = r5.f6652e
            V r2 = r5.f6655h
            r0.put(r1, r2)
        L_0x0043:
            r5.f6648a = r3
            r5.f6651d = r3
            r5.f6650c = r3
            r5.f6649b = r3
            r5.f6654g = r4
            r5.f6653f = r4
            r5.f6652e = r4
            r5.f6657j = r4
            r5.f6656i = r4
            r5.f6655h = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.Flat3Map.m7125a():void");
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap<K, V> createDelegateMap() {
        return new HashedMap();
    }

    public V remove(Object obj) {
        if (this.f6658k != null) {
            return this.f6658k.remove(obj);
        }
        if (this.f6648a == 0) {
            return null;
        }
        if (obj == null) {
            switch (this.f6648a) {
                case 1:
                    if (this.f6652e != null) {
                        return null;
                    }
                    V v = this.f6655h;
                    this.f6649b = 0;
                    this.f6652e = null;
                    this.f6655h = null;
                    this.f6648a = 0;
                    return v;
                case 2:
                    if (this.f6653f == null) {
                        V v2 = this.f6656i;
                        this.f6650c = 0;
                        this.f6653f = null;
                        this.f6656i = null;
                        this.f6648a = 1;
                        return v2;
                    } else if (this.f6652e != null) {
                        return null;
                    } else {
                        V v3 = this.f6655h;
                        this.f6649b = this.f6650c;
                        this.f6652e = this.f6653f;
                        this.f6655h = this.f6656i;
                        this.f6650c = 0;
                        this.f6653f = null;
                        this.f6656i = null;
                        this.f6648a = 1;
                        return v3;
                    }
                case 3:
                    if (this.f6654g == null) {
                        V v4 = this.f6657j;
                        this.f6651d = 0;
                        this.f6654g = null;
                        this.f6657j = null;
                        this.f6648a = 2;
                        return v4;
                    } else if (this.f6653f == null) {
                        V v5 = this.f6656i;
                        this.f6650c = this.f6651d;
                        this.f6653f = this.f6654g;
                        this.f6656i = this.f6657j;
                        this.f6651d = 0;
                        this.f6654g = null;
                        this.f6657j = null;
                        this.f6648a = 2;
                        return v5;
                    } else if (this.f6652e != null) {
                        return null;
                    } else {
                        V v6 = this.f6655h;
                        this.f6649b = this.f6651d;
                        this.f6652e = this.f6654g;
                        this.f6655h = this.f6657j;
                        this.f6651d = 0;
                        this.f6654g = null;
                        this.f6657j = null;
                        this.f6648a = 2;
                        return v6;
                    }
                default:
                    return null;
            }
        } else if (this.f6648a <= 0) {
            return null;
        } else {
            int hashCode = obj.hashCode();
            switch (this.f6648a) {
                case 1:
                    if (this.f6649b != hashCode || !obj.equals(this.f6652e)) {
                        return null;
                    }
                    V v7 = this.f6655h;
                    this.f6649b = 0;
                    this.f6652e = null;
                    this.f6655h = null;
                    this.f6648a = 0;
                    return v7;
                case 2:
                    if (this.f6650c == hashCode && obj.equals(this.f6653f)) {
                        V v8 = this.f6656i;
                        this.f6650c = 0;
                        this.f6653f = null;
                        this.f6656i = null;
                        this.f6648a = 1;
                        return v8;
                    } else if (this.f6649b != hashCode || !obj.equals(this.f6652e)) {
                        return null;
                    } else {
                        V v9 = this.f6655h;
                        this.f6649b = this.f6650c;
                        this.f6652e = this.f6653f;
                        this.f6655h = this.f6656i;
                        this.f6650c = 0;
                        this.f6653f = null;
                        this.f6656i = null;
                        this.f6648a = 1;
                        return v9;
                    }
                case 3:
                    if (this.f6651d == hashCode && obj.equals(this.f6654g)) {
                        V v10 = this.f6657j;
                        this.f6651d = 0;
                        this.f6654g = null;
                        this.f6657j = null;
                        this.f6648a = 2;
                        return v10;
                    } else if (this.f6650c == hashCode && obj.equals(this.f6653f)) {
                        V v11 = this.f6656i;
                        this.f6650c = this.f6651d;
                        this.f6653f = this.f6654g;
                        this.f6656i = this.f6657j;
                        this.f6651d = 0;
                        this.f6654g = null;
                        this.f6657j = null;
                        this.f6648a = 2;
                        return v11;
                    } else if (this.f6649b != hashCode || !obj.equals(this.f6652e)) {
                        return null;
                    } else {
                        V v12 = this.f6655h;
                        this.f6649b = this.f6651d;
                        this.f6652e = this.f6654g;
                        this.f6655h = this.f6657j;
                        this.f6651d = 0;
                        this.f6654g = null;
                        this.f6657j = null;
                        this.f6648a = 2;
                        return v12;
                    }
                default:
                    return null;
            }
        }
    }

    public void clear() {
        if (this.f6658k != null) {
            this.f6658k.clear();
            this.f6658k = null;
            return;
        }
        this.f6648a = 0;
        this.f6651d = 0;
        this.f6650c = 0;
        this.f6649b = 0;
        this.f6654g = null;
        this.f6653f = null;
        this.f6652e = null;
        this.f6657j = null;
        this.f6656i = null;
        this.f6655h = null;
    }

    public MapIterator<K, V> mapIterator() {
        if (this.f6658k != null) {
            return this.f6658k.mapIterator();
        }
        if (this.f6648a == 0) {
            return EmptyMapIterator.emptyMapIterator();
        }
        return new C1886e(this);
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$e */
    static class C1886e<K, V> implements MapIterator<K, V>, ResettableIterator<K> {

        /* renamed from: a */
        private final Flat3Map<K, V> f6666a;

        /* renamed from: b */
        private int f6667b = 0;

        /* renamed from: c */
        private boolean f6668c = false;

        C1886e(Flat3Map<K, V> flat3Map) {
            this.f6666a = flat3Map;
        }

        public boolean hasNext() {
            return this.f6667b < this.f6666a.f6648a;
        }

        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.f6668c = true;
            this.f6667b++;
            return getKey();
        }

        public void remove() {
            if (!this.f6668c) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.f6666a.remove(getKey());
            this.f6667b--;
            this.f6668c = false;
        }

        public K getKey() {
            if (!this.f6668c) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            switch (this.f6667b) {
                case 1:
                    return this.f6666a.f6652e;
                case 2:
                    return this.f6666a.f6653f;
                case 3:
                    return this.f6666a.f6654g;
                default:
                    throw new IllegalStateException("Invalid map index: " + this.f6667b);
            }
        }

        public V getValue() {
            if (!this.f6668c) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            switch (this.f6667b) {
                case 1:
                    return this.f6666a.f6655h;
                case 2:
                    return this.f6666a.f6656i;
                case 3:
                    return this.f6666a.f6657j;
                default:
                    throw new IllegalStateException("Invalid map index: " + this.f6667b);
            }
        }

        public V setValue(V v) {
            if (!this.f6668c) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            V value = getValue();
            switch (this.f6667b) {
                case 1:
                    Object unused = this.f6666a.f6655h = v;
                    break;
                case 2:
                    Object unused2 = this.f6666a.f6656i = v;
                    break;
                case 3:
                    Object unused3 = this.f6666a.f6657j = v;
                    break;
                default:
                    throw new IllegalStateException("Invalid map index: " + this.f6667b);
            }
            return value;
        }

        public void reset() {
            this.f6667b = 0;
            this.f6668c = false;
        }

        public String toString() {
            if (this.f6668c) {
                return "Iterator[" + getKey() + "=" + getValue() + "]";
            }
            return "Iterator[]";
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6658k != null) {
            return this.f6658k.entrySet();
        }
        return new C1883b(this);
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$b */
    static class C1883b<K, V> extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: a */
        private final Flat3Map<K, V> f6662a;

        C1883b(Flat3Map<K, V> flat3Map) {
            this.f6662a = flat3Map;
        }

        public int size() {
            return this.f6662a.size();
        }

        public void clear() {
            this.f6662a.clear();
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Object key = ((Map.Entry) obj).getKey();
            boolean containsKey = this.f6662a.containsKey(key);
            this.f6662a.remove(key);
            return containsKey;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            if (this.f6662a.f6658k != null) {
                return this.f6662a.f6658k.entrySet().iterator();
            }
            if (this.f6662a.size() == 0) {
                return EmptyIterator.emptyIterator();
            }
            return new C1884c(this.f6662a);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$d */
    static class C1885d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        private final Flat3Map<K, V> f6663a;

        /* renamed from: b */
        private final int f6664b;

        /* renamed from: c */
        private volatile boolean f6665c = false;

        public C1885d(Flat3Map<K, V> flat3Map, int i) {
            this.f6663a = flat3Map;
            this.f6664b = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo12027a(boolean z) {
            this.f6665c = z;
        }

        public K getKey() {
            if (this.f6665c) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            switch (this.f6664b) {
                case 1:
                    return this.f6663a.f6652e;
                case 2:
                    return this.f6663a.f6653f;
                case 3:
                    return this.f6663a.f6654g;
                default:
                    throw new IllegalStateException("Invalid map index: " + this.f6664b);
            }
        }

        public V getValue() {
            if (this.f6665c) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            switch (this.f6664b) {
                case 1:
                    return this.f6663a.f6655h;
                case 2:
                    return this.f6663a.f6656i;
                case 3:
                    return this.f6663a.f6657j;
                default:
                    throw new IllegalStateException("Invalid map index: " + this.f6664b);
            }
        }

        public V setValue(V v) {
            if (this.f6665c) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            V value = getValue();
            switch (this.f6664b) {
                case 1:
                    Object unused = this.f6663a.f6655h = v;
                    break;
                case 2:
                    Object unused2 = this.f6663a.f6656i = v;
                    break;
                case 3:
                    Object unused3 = this.f6663a.f6657j = v;
                    break;
                default:
                    throw new IllegalStateException("Invalid map index: " + this.f6664b);
            }
            return value;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 0
                boolean r1 = r4.f6665c
                if (r1 == 0) goto L_0x0006
            L_0x0005:
                return r0
            L_0x0006:
                boolean r1 = r5 instanceof java.util.Map.Entry
                if (r1 == 0) goto L_0x0005
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r1 = r4.getKey()
                java.lang.Object r2 = r4.getValue()
                if (r1 != 0) goto L_0x0026
                java.lang.Object r1 = r5.getKey()
                if (r1 != 0) goto L_0x0005
            L_0x001c:
                if (r2 != 0) goto L_0x0031
                java.lang.Object r1 = r5.getValue()
                if (r1 != 0) goto L_0x0005
            L_0x0024:
                r0 = 1
                goto L_0x0005
            L_0x0026:
                java.lang.Object r3 = r5.getKey()
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0005
                goto L_0x001c
            L_0x0031:
                java.lang.Object r1 = r5.getValue()
                boolean r1 = r2.equals(r1)
                if (r1 == 0) goto L_0x0005
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.Flat3Map.C1885d.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            if (this.f6665c) {
                return 0;
            }
            Object key = getKey();
            Object value = getValue();
            int hashCode = key == null ? 0 : key.hashCode();
            if (value != null) {
                i = value.hashCode();
            }
            return i ^ hashCode;
        }

        public String toString() {
            if (!this.f6665c) {
                return getKey() + "=" + getValue();
            }
            return "";
        }
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$a */
    static abstract class C1882a<K, V> {

        /* renamed from: a */
        private final Flat3Map<K, V> f6659a;

        /* renamed from: b */
        private int f6660b = 0;

        /* renamed from: c */
        private C1885d<K, V> f6661c = null;

        public C1882a(Flat3Map<K, V> flat3Map) {
            this.f6659a = flat3Map;
        }

        public boolean hasNext() {
            return this.f6660b < this.f6659a.f6648a;
        }

        /* renamed from: a */
        public Map.Entry<K, V> mo12018a() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            Flat3Map<K, V> flat3Map = this.f6659a;
            int i = this.f6660b + 1;
            this.f6660b = i;
            this.f6661c = new C1885d<>(flat3Map, i);
            return this.f6661c;
        }

        public void remove() {
            if (this.f6661c == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.f6661c.mo12027a(true);
            this.f6659a.remove(this.f6661c.getKey());
            this.f6660b--;
            this.f6661c = null;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$c */
    static class C1884c<K, V> extends C1882a<K, V> implements Iterator<Map.Entry<K, V>> {
        C1884c(Flat3Map<K, V> flat3Map) {
            super(flat3Map);
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            return mo12018a();
        }
    }

    public Set<K> keySet() {
        if (this.f6658k != null) {
            return this.f6658k.keySet();
        }
        return new C1887f(this);
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$f */
    static class C1887f<K> extends AbstractSet<K> {

        /* renamed from: a */
        private final Flat3Map<K, ?> f6669a;

        C1887f(Flat3Map<K, ?> flat3Map) {
            this.f6669a = flat3Map;
        }

        public int size() {
            return this.f6669a.size();
        }

        public void clear() {
            this.f6669a.clear();
        }

        public boolean contains(Object obj) {
            return this.f6669a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            boolean containsKey = this.f6669a.containsKey(obj);
            this.f6669a.remove(obj);
            return containsKey;
        }

        public Iterator<K> iterator() {
            if (this.f6669a.f6658k != null) {
                return this.f6669a.f6658k.keySet().iterator();
            }
            if (this.f6669a.size() == 0) {
                return EmptyIterator.emptyIterator();
            }
            return new C1888g(this.f6669a);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$g */
    static class C1888g<K> extends C1882a<K, Object> implements Iterator<K> {
        C1888g(Flat3Map<K, ?> flat3Map) {
            super(flat3Map);
        }

        public K next() {
            return mo12018a().getKey();
        }
    }

    public Collection<V> values() {
        if (this.f6658k != null) {
            return this.f6658k.values();
        }
        return new C1889h(this);
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$h */
    static class C1889h<V> extends AbstractCollection<V> {

        /* renamed from: a */
        private final Flat3Map<?, V> f6670a;

        C1889h(Flat3Map<?, V> flat3Map) {
            this.f6670a = flat3Map;
        }

        public int size() {
            return this.f6670a.size();
        }

        public void clear() {
            this.f6670a.clear();
        }

        public boolean contains(Object obj) {
            return this.f6670a.containsValue(obj);
        }

        public Iterator<V> iterator() {
            if (this.f6670a.f6658k != null) {
                return this.f6670a.f6658k.values().iterator();
            }
            if (this.f6670a.size() == 0) {
                return EmptyIterator.emptyIterator();
            }
            return new C1890i(this.f6670a);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.Flat3Map$i */
    static class C1890i<V> extends C1882a<Object, V> implements Iterator<V> {
        C1890i(Flat3Map<?, V> flat3Map) {
            super(flat3Map);
        }

        public V next() {
            return mo12018a().getValue();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt > 3) {
            this.f6658k = createDelegateMap();
        }
        while (readInt > 0) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
            readInt--;
        }
    }

    public Flat3Map<K, V> clone() {
        try {
            Flat3Map<K, V> flat3Map = (Flat3Map) super.clone();
            if (flat3Map.f6658k != null) {
                flat3Map.f6658k = flat3Map.f6658k.clone();
            }
            return flat3Map;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (this.f6658k != null) {
            return this.f6658k.equals(obj);
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.f6648a != map.size()) {
            return false;
        }
        if (this.f6648a <= 0) {
            return true;
        }
        switch (this.f6648a) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                if (!map.containsKey(this.f6654g)) {
                    return false;
                }
                Object obj2 = map.get(this.f6654g);
                if (this.f6657j != null ? !this.f6657j.equals(obj2) : obj2 != null) {
                    return false;
                }
            default:
                return true;
        }
        if (!map.containsKey(this.f6653f)) {
            return false;
        }
        Object obj3 = map.get(this.f6653f);
        if (this.f6656i != null ? !this.f6656i.equals(obj3) : obj3 != null) {
            return false;
        }
        if (!map.containsKey(this.f6652e)) {
            return false;
        }
        Object obj4 = map.get(this.f6652e);
        if (this.f6655h == null) {
            if (obj4 == null) {
                return true;
            }
        } else if (this.f6655h.equals(obj4)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        if (this.f6658k != null) {
            return this.f6658k.hashCode();
        }
        switch (this.f6648a) {
            case 0:
                return 0;
            case 1:
                i = 0;
                break;
            case 2:
                i2 = 0;
                break;
            case 3:
                i2 = ((this.f6657j == null ? 0 : this.f6657j.hashCode()) ^ this.f6651d) + 0;
                break;
            default:
                throw new IllegalStateException("Invalid map index: " + this.f6648a);
        }
        i = i2 + ((this.f6656i == null ? 0 : this.f6656i.hashCode()) ^ this.f6650c);
        int i4 = this.f6649b;
        if (this.f6655h != null) {
            i3 = this.f6655h.hashCode();
        }
        return (i3 ^ i4) + i;
    }

    public String toString() {
        if (this.f6658k != null) {
            return this.f6658k.toString();
        }
        if (this.f6648a == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append('{');
        switch (this.f6648a) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                sb.append(this.f6654g == this ? "(this Map)" : this.f6654g);
                sb.append('=');
                sb.append(this.f6657j == this ? "(this Map)" : this.f6657j);
                sb.append(',');
                break;
            default:
                throw new IllegalStateException("Invalid map index: " + this.f6648a);
        }
        sb.append(this.f6653f == this ? "(this Map)" : this.f6653f);
        sb.append('=');
        sb.append(this.f6656i == this ? "(this Map)" : this.f6656i);
        sb.append(',');
        sb.append(this.f6652e == this ? "(this Map)" : this.f6652e);
        sb.append('=');
        sb.append(this.f6655h == this ? "(this Map)" : this.f6655h);
        sb.append('}');
        return sb.toString();
    }
}
