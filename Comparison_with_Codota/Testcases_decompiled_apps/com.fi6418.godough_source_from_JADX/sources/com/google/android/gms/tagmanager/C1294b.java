package com.google.android.gms.tagmanager;

import java.util.ArrayList;
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

/* renamed from: com.google.android.gms.tagmanager.b */
public class C1294b {

    /* renamed from: a */
    public static final Object f5354a = new Object();

    /* renamed from: b */
    static final String[] f5355b = "gtm.lifetime".toString().split("\\.");

    /* renamed from: c */
    private static final Pattern f5356c = Pattern.compile("(\\d+)\\s*([smhd]?)");

    /* renamed from: d */
    private final ConcurrentHashMap<C1315f, Integer> f5357d;

    /* renamed from: e */
    private final Map<String, Object> f5358e;

    /* renamed from: f */
    private final ReentrantLock f5359f;

    /* renamed from: g */
    private final LinkedList<Map<String, Object>> f5360g;

    /* renamed from: h */
    private final C1316g f5361h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final CountDownLatch f5362i;

    C1294b() {
        this(new C1312c());
    }

    C1294b(C1316g gVar) {
        this.f5361h = gVar;
        this.f5357d = new ConcurrentHashMap<>();
        this.f5358e = new HashMap();
        this.f5359f = new ReentrantLock();
        this.f5360g = new LinkedList<>();
        this.f5362i = new CountDownLatch(1);
        m5327a();
    }

    /* renamed from: a */
    static Long m5325a(String str) {
        long j;
        Matcher matcher = f5356c.matcher(str);
        if (!matcher.matches()) {
            C1333x.m5443c("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            C1333x.m5442b("illegal number in _lifetime value: " + str);
            j = 0;
        }
        if (j <= 0) {
            C1333x.m5443c("non-positive _lifetime: " + str);
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
                C1333x.m5442b("unknown units in _lifetime: " + str);
                return null;
        }
    }

    /* renamed from: a */
    private void m5327a() {
        this.f5361h.mo9152a(new C1313d(this));
    }

    /* renamed from: a */
    private void m5329a(Map<String, Object> map, String str, Collection<C1314e> collection) {
        for (Map.Entry next : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) next.getKey());
            if (next.getValue() instanceof Map) {
                m5329a((Map) next.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C1314e(str2, next.getValue()));
            }
        }
    }

    /* renamed from: b */
    private void m5330b() {
        int i = 0;
        while (true) {
            int i2 = i;
            Map poll = this.f5360g.poll();
            if (poll != null) {
                m5336g(poll);
                i = i2 + 1;
                if (i > 500) {
                    this.f5360g.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5331b(Map<String, Object> map) {
        this.f5359f.lock();
        try {
            this.f5360g.offer(map);
            if (this.f5359f.getHoldCount() == 1) {
                m5330b();
            }
            m5332c(map);
        } finally {
            this.f5359f.unlock();
        }
    }

    /* renamed from: c */
    private void m5332c(Map<String, Object> map) {
        Long d = m5333d(map);
        if (d != null) {
            List<C1314e> f = m5335f(map);
            f.remove("gtm.lifetime");
            this.f5361h.mo9153a(f, d.longValue());
        }
    }

    /* renamed from: d */
    private Long m5333d(Map<String, Object> map) {
        Object e = m5334e(map);
        if (e == null) {
            return null;
        }
        return m5325a(e.toString());
    }

    /* renamed from: e */
    private Object m5334e(Map<String, Object> map) {
        String[] strArr = f5355b;
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

    /* renamed from: f */
    private List<C1314e> m5335f(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        m5329a(map, "", arrayList);
        return arrayList;
    }

    /* renamed from: g */
    private void m5336g(Map<String, Object> map) {
        synchronized (this.f5358e) {
            for (String next : map.keySet()) {
                mo9120a(mo9116a(next, map.get(next)), this.f5358e);
            }
        }
        m5337h(map);
    }

    /* renamed from: h */
    private void m5337h(Map<String, Object> map) {
        for (C1315f a : this.f5357d.keySet()) {
            a.mo9123a(map);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, Object> mo9116a(String str, Object obj) {
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
    /* renamed from: a */
    public void mo9117a(C1315f fVar) {
        this.f5357d.put(fVar, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9118a(List<Object> list, List<Object> list2) {
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
                    mo9118a((List<Object>) (List) obj, (List<Object>) (List) list2.get(i2));
                } else if (obj instanceof Map) {
                    if (!(list2.get(i2) instanceof Map)) {
                        list2.set(i2, new HashMap());
                    }
                    mo9120a((Map<String, Object>) (Map) obj, (Map<String, Object>) (Map) list2.get(i2));
                } else if (obj != f5354a) {
                    list2.set(i2, obj);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo9119a(Map<String, Object> map) {
        try {
            this.f5362i.await();
        } catch (InterruptedException e) {
            C1333x.m5442b("DataLayer.push: unexpected InterruptedException");
        }
        m5331b(map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9120a(Map<String, Object> map, Map<String, Object> map2) {
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                mo9118a((List<Object>) (List) obj, (List<Object>) (List) map2.get(next));
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                mo9120a((Map<String, Object>) (Map) obj, (Map<String, Object>) (Map) map2.get(next));
            } else {
                map2.put(next, obj);
            }
        }
    }

    public String toString() {
        String sb;
        synchronized (this.f5358e) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.f5358e.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{next.getKey(), next.getValue()}));
            }
            sb = sb2.toString();
        }
        return sb;
    }
}
