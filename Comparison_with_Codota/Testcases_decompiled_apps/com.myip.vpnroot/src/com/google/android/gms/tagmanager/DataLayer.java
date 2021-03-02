package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] aov = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aow = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final LinkedList<Map<String, Object>> aoA;
    private final C1977c aoB;
    /* access modifiers changed from: private */
    public final CountDownLatch aoC;
    private final ConcurrentHashMap<C1976b, Integer> aox;
    private final Map<String, Object> aoy;
    private final ReentrantLock aoz;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$a */
    static final class C1975a {

        /* renamed from: JH */
        public final String f4521JH;

        /* renamed from: wq */
        public final Object f4522wq;

        C1975a(String str, Object obj) {
            this.f4521JH = str;
            this.f4522wq = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C1975a)) {
                return false;
            }
            C1975a aVar = (C1975a) o;
            return this.f4521JH.equals(aVar.f4521JH) && this.f4522wq.equals(aVar.f4522wq);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f4521JH.hashCode()), Integer.valueOf(this.f4522wq.hashCode())});
        }

        public String toString() {
            return "Key: " + this.f4521JH + " value: " + this.f4522wq.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$b */
    interface C1976b {
        /* renamed from: D */
        void mo11510D(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$c */
    interface C1977c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer$c$a */
        public interface C1978a {
            /* renamed from: g */
            void mo11506g(List<C1975a> list);
        }

        /* renamed from: a */
        void mo11503a(C1978a aVar);

        /* renamed from: a */
        void mo11504a(List<C1975a> list, long j);

        /* renamed from: cu */
        void mo11505cu(String str);
    }

    DataLayer() {
        this(new C1977c() {
            /* renamed from: a */
            public void mo11503a(C1977c.C1978a aVar) {
                aVar.mo11506g(new ArrayList());
            }

            /* renamed from: a */
            public void mo11504a(List<C1975a> list, long j) {
            }

            /* renamed from: cu */
            public void mo11505cu(String str) {
            }
        });
    }

    DataLayer(C1977c persistentStore) {
        this.aoB = persistentStore;
        this.aox = new ConcurrentHashMap<>();
        this.aoy = new HashMap();
        this.aoz = new ReentrantLock();
        this.aoA = new LinkedList<>();
        this.aoC = new CountDownLatch(1);
        m6694oc();
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m6683F(Map<String, Object> map) {
        this.aoz.lock();
        try {
            this.aoA.offer(map);
            if (this.aoz.getHoldCount() == 1) {
                m6695od();
            }
            m6684G(map);
        } finally {
            this.aoz.unlock();
        }
    }

    /* renamed from: G */
    private void m6684G(Map<String, Object> map) {
        Long H = m6685H(map);
        if (H != null) {
            List<C1975a> J = m6687J(map);
            J.remove("gtm.lifetime");
            this.aoB.mo11504a(J, H.longValue());
        }
    }

    /* renamed from: H */
    private Long m6685H(Map<String, Object> map) {
        Object I = m6686I(map);
        if (I == null) {
            return null;
        }
        return m6693ct(I.toString());
    }

    /* renamed from: I */
    private Object m6686I(Map<String, Object> map) {
        String[] strArr = aov;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            String str = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(str);
        }
        return obj;
    }

    /* renamed from: J */
    private List<C1975a> m6687J(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        m6692a(map, "", arrayList);
        return arrayList;
    }

    /* renamed from: K */
    private void m6688K(Map<String, Object> map) {
        synchronized (this.aoy) {
            for (String next : map.keySet()) {
                mo11494a(mo11496c(next, map.get(next)), this.aoy);
            }
        }
        m6689L(map);
    }

    /* renamed from: L */
    private void m6689L(Map<String, Object> map) {
        for (C1976b D : this.aox.keySet()) {
            D.mo11510D(map);
        }
    }

    /* renamed from: a */
    private void m6692a(Map<String, Object> map, String str, Collection<C1975a> collection) {
        for (Map.Entry next : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) next.getKey());
            if (next.getValue() instanceof Map) {
                m6692a((Map) next.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C1975a(str2, next.getValue()));
            }
        }
    }

    /* renamed from: ct */
    static Long m6693ct(String str) {
        long j;
        Matcher matcher = aow.matcher(str);
        if (!matcher.matches()) {
            C2028bh.m6817U("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            C2028bh.m6819W("illegal number in _lifetime value: " + str);
            j = 0;
        }
        if (j <= 0) {
            C2028bh.m6817U("non-positive _lifetime: " + str);
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        switch (group.charAt(0)) {
            case 'd':
                return Long.valueOf(j * 1000 * 60 * 60 * 24);
            case 'h':
                return Long.valueOf(j * 1000 * 60 * 60);
            case 'm':
                return Long.valueOf(j * 1000 * 60);
            case 's':
                return Long.valueOf(j * 1000);
            default:
                C2028bh.m6819W("unknown units in _lifetime: " + str);
                return null;
        }
    }

    public static List<Object> listOf(Object... objects) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objects.length) {
                return hashMap;
            }
            if (!(objects[i2] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + objects[i2]);
            }
            hashMap.put(objects[i2], objects[i2 + 1]);
            i = i2 + 2;
        }
    }

    /* renamed from: oc */
    private void m6694oc() {
        this.aoB.mo11503a(new C1977c.C1978a() {
            /* renamed from: g */
            public void mo11506g(List<C1975a> list) {
                for (C1975a next : list) {
                    DataLayer.this.m6683F(DataLayer.this.mo11496c(next.f4521JH, next.f4522wq));
                }
                DataLayer.this.aoC.countDown();
            }
        });
    }

    /* renamed from: od */
    private void m6695od() {
        int i = 0;
        while (true) {
            int i2 = i;
            Map poll = this.aoA.poll();
            if (poll != null) {
                m6688K(poll);
                i = i2 + 1;
                if (i > 500) {
                    this.aoA.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11493a(C1976b bVar) {
        this.aox.put(bVar, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11494a(Map<String, Object> map, Map<String, Object> map2) {
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                mo11495b((List) obj, (List) map2.get(next));
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                mo11494a((Map<String, Object>) (Map) obj, (Map<String, Object>) (Map) map2.get(next));
            } else {
                map2.put(next, obj);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo11495b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add((Object) null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Object obj = list.get(i2);
                if (obj instanceof List) {
                    if (!(list2.get(i2) instanceof List)) {
                        list2.set(i2, new ArrayList());
                    }
                    mo11495b((List) obj, (List) list2.get(i2));
                } else if (obj instanceof Map) {
                    if (!(list2.get(i2) instanceof Map)) {
                        list2.set(i2, new HashMap());
                    }
                    mo11494a((Map<String, Object>) (Map) obj, (Map<String, Object>) (Map) list2.get(i2));
                } else if (obj != OBJECT_NOT_PRESENT) {
                    list2.set(i2, obj);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Map<String, Object> mo11496c(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cs */
    public void mo11497cs(String str) {
        push(str, (Object) null);
        this.aoB.mo11505cu(str);
    }

    public Object get(String key) {
        synchronized (this.aoy) {
            Object obj = this.aoy;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj2 = obj;
            int i = 0;
            while (i < length) {
                String str = split[i];
                if (!(obj2 instanceof Map)) {
                    return null;
                }
                Object obj3 = ((Map) obj2).get(str);
                if (obj3 == null) {
                    return null;
                }
                i++;
                obj2 = obj3;
            }
            return obj2;
        }
    }

    public void push(String key, Object value) {
        push(mo11496c(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.aoC.await();
        } catch (InterruptedException e) {
            C2028bh.m6819W("DataLayer.push: unexpected InterruptedException");
        }
        m6683F(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        HashMap hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }

    public String toString() {
        String sb;
        synchronized (this.aoy) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.aoy.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{next.getKey(), next.getValue()}));
            }
            sb = sb2.toString();
        }
        return sb;
    }
}
