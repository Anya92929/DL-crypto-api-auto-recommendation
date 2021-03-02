package com.google.p019b.p020a;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* renamed from: com.google.b.a.c */
public class C1338c {

    /* renamed from: A */
    private static final Pattern f5441A = Pattern.compile("\\$FG");

    /* renamed from: B */
    private static final Pattern f5442B = Pattern.compile("\\$CC");

    /* renamed from: C */
    private static final Pattern f5443C = Pattern.compile("\\(?\\$1\\)?");

    /* renamed from: D */
    private static C1338c f5444D = null;

    /* renamed from: a */
    static final Pattern f5445a = Pattern.compile("[+＋]+");

    /* renamed from: b */
    static final Pattern f5446b = Pattern.compile("[\\\\/] *x");

    /* renamed from: c */
    static final Pattern f5447c = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");

    /* renamed from: d */
    static final String f5448d = m5482e("xｘ#＃~～");

    /* renamed from: e */
    static final Pattern f5449e = Pattern.compile("(\\D+)");

    /* renamed from: g */
    private static final Logger f5450g = Logger.getLogger(C1338c.class.getName());

    /* renamed from: k */
    private static final Map<Character, Character> f5451k;

    /* renamed from: l */
    private static final Map<Character, Character> f5452l;

    /* renamed from: m */
    private static final Map<Character, Character> f5453m;

    /* renamed from: n */
    private static final Map<Character, Character> f5454n;

    /* renamed from: o */
    private static final Pattern f5455o = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");

    /* renamed from: p */
    private static final String f5456p = (Arrays.toString(f5452l.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(f5452l.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));

    /* renamed from: q */
    private static final Pattern f5457q = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");

    /* renamed from: r */
    private static final Pattern f5458r = Pattern.compile("(\\p{Nd})");

    /* renamed from: s */
    private static final Pattern f5459s = Pattern.compile("[+＋\\p{Nd}]");

    /* renamed from: t */
    private static final Pattern f5460t = Pattern.compile("(?:.*?[A-Za-z]){3}.*");

    /* renamed from: u */
    private static final String f5461u = ("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*" + f5456p + "\\p{Nd}" + "]*");

    /* renamed from: v */
    private static final String f5462v = m5482e("," + "xｘ#＃~～");

    /* renamed from: w */
    private static final Pattern f5463w = Pattern.compile("(?:" + f5462v + ")$", 66);

    /* renamed from: x */
    private static final Pattern f5464x = Pattern.compile(f5461u + "(?:" + f5462v + ")?", 66);

    /* renamed from: y */
    private static final Pattern f5465y = Pattern.compile("(\\$\\d)");

    /* renamed from: z */
    private static final Pattern f5466z = Pattern.compile("\\$NP");

    /* renamed from: E */
    private final Map<String, C1341f> f5467E = Collections.synchronizedMap(new HashMap());

    /* renamed from: F */
    private final Map<Integer, C1341f> f5468F = Collections.synchronizedMap(new HashMap());

    /* renamed from: G */
    private final Set<Integer> f5469G = new HashSet();

    /* renamed from: H */
    private C1344i f5470H = new C1344i(100);

    /* renamed from: f */
    private String f5471f = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";

    /* renamed from: h */
    private Map<Integer, List<String>> f5472h = null;

    /* renamed from: i */
    private final Set<String> f5473i = new HashSet(320);

    /* renamed from: j */
    private final Set<String> f5474j = new HashSet(35);

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('0', '0');
        hashMap.put('1', '1');
        hashMap.put('2', '2');
        hashMap.put('3', '3');
        hashMap.put('4', '4');
        hashMap.put('5', '5');
        hashMap.put('6', '6');
        hashMap.put('7', '7');
        hashMap.put('8', '8');
        hashMap.put('9', '9');
        HashMap hashMap2 = new HashMap(40);
        hashMap2.put('A', '2');
        hashMap2.put('B', '2');
        hashMap2.put('C', '2');
        hashMap2.put('D', '3');
        hashMap2.put('E', '3');
        hashMap2.put('F', '3');
        hashMap2.put('G', '4');
        hashMap2.put('H', '4');
        hashMap2.put('I', '4');
        hashMap2.put('J', '5');
        hashMap2.put('K', '5');
        hashMap2.put('L', '5');
        hashMap2.put('M', '6');
        hashMap2.put('N', '6');
        hashMap2.put('O', '6');
        hashMap2.put('P', '7');
        hashMap2.put('Q', '7');
        hashMap2.put('R', '7');
        hashMap2.put('S', '7');
        hashMap2.put('T', '8');
        hashMap2.put('U', '8');
        hashMap2.put('V', '8');
        hashMap2.put('W', '9');
        hashMap2.put('X', '9');
        hashMap2.put('Y', '9');
        hashMap2.put('Z', '9');
        f5452l = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap(100);
        hashMap3.putAll(f5452l);
        hashMap3.putAll(hashMap);
        f5453m = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.putAll(hashMap);
        hashMap4.put('+', '+');
        hashMap4.put('*', '*');
        f5451k = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        for (Character charValue : f5452l.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap5.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap5.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap5.putAll(hashMap);
        hashMap5.put('-', '-');
        hashMap5.put(65293, '-');
        hashMap5.put(8208, '-');
        hashMap5.put(8209, '-');
        hashMap5.put(8210, '-');
        hashMap5.put(8211, '-');
        hashMap5.put(8212, '-');
        hashMap5.put(8213, '-');
        hashMap5.put(8722, '-');
        hashMap5.put('/', '/');
        hashMap5.put(65295, '/');
        hashMap5.put(' ', ' ');
        hashMap5.put(12288, ' ');
        hashMap5.put(8288, ' ');
        hashMap5.put('.', '.');
        hashMap5.put(65294, '.');
        f5454n = Collections.unmodifiableMap(hashMap5);
    }

    private C1338c() {
    }

    /* renamed from: a */
    public static synchronized C1338c m5478a() {
        C1338c a;
        synchronized (C1338c.class) {
            a = f5444D == null ? m5479a("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", C1337b.m5477a()) : f5444D;
        }
        return a;
    }

    /* renamed from: a */
    static synchronized C1338c m5479a(String str, Map<Integer, List<String>> map) {
        C1338c cVar;
        synchronized (C1338c.class) {
            if (f5444D == null) {
                f5444D = new C1338c();
                f5444D.f5472h = map;
                f5444D.m5483f(str);
            }
            cVar = f5444D;
        }
        return cVar;
    }

    /* renamed from: a */
    private static void m5480a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                f5450g.log(Level.WARNING, "error closing input stream (ignored)", e);
            }
        }
    }

    /* renamed from: a */
    static boolean m5481a(String str) {
        return f5443C.matcher(str).matches();
    }

    /* renamed from: e */
    private static String m5482e(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)" + "[:\\.．]?[  \\t,-]*" + "(\\p{Nd}{1,7})" + "#?|" + "[- ]+(" + "\\p{Nd}" + "{1,5})#";
    }

    /* renamed from: f */
    private void m5483f(String str) {
        this.f5471f = str;
        for (Map.Entry next : this.f5472h.entrySet()) {
            List list = (List) next.getValue();
            if (list.size() != 1 || !"001".equals(list.get(0))) {
                this.f5473i.addAll(list);
            } else {
                this.f5469G.add(next.getKey());
            }
        }
        if (this.f5473i.remove("001")) {
            f5450g.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f5474j.addAll(this.f5472h.get(1));
    }

    /* renamed from: g */
    private boolean m5484g(String str) {
        return str != null && this.f5473i.contains(str);
    }

    /* renamed from: h */
    private int m5485h(String str) {
        C1341f b = mo9194b(str);
        if (b != null) {
            return b.mo9211a();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo9191a(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() == 0 || sb.charAt(0) == '0') {
            return 0;
        }
        int length = sb.length();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 3 && i2 <= length) {
                int parseInt = Integer.parseInt(sb.substring(0, i2));
                if (this.f5472h.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i2));
                    return parseInt;
                }
                i = i2 + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return r3.f5468F.get(java.lang.Integer.valueOf(r4));
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.p019b.p020a.C1341f mo9192a(int r4) {
        /*
            r3 = this;
            java.util.Map<java.lang.Integer, com.google.b.a.f> r1 = r3.f5468F
            monitor-enter(r1)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> r0 = r3.f5472h     // Catch:{ all -> 0x0033 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0012
            r0 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
        L_0x0011:
            return r0
        L_0x0012:
            java.util.Map<java.lang.Integer, com.google.b.a.f> r0 = r3.f5468F     // Catch:{ all -> 0x0033 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = r3.f5471f     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = "001"
            r3.mo9193a(r0, r2, r4)     // Catch:{ all -> 0x0033 }
        L_0x0025:
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            java.util.Map<java.lang.Integer, com.google.b.a.f> r0 = r3.f5468F
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.Object r0 = r0.get(r1)
            com.google.b.a.f r0 = (com.google.p019b.p020a.C1341f) r0
            goto L_0x0011
        L_0x0033:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p019b.p020a.C1338c.mo9192a(int):com.google.b.a.f");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9193a(String str, String str2, int i) {
        ObjectInputStream objectInputStream;
        boolean equals = "001".equals(str2);
        String str3 = str + "_" + (equals ? String.valueOf(i) : str2);
        InputStream resourceAsStream = C1338c.class.getResourceAsStream(str3);
        if (resourceAsStream == null) {
            f5450g.log(Level.SEVERE, "missing metadata: " + str3);
            throw new RuntimeException("missing metadata: " + str3);
        }
        try {
            objectInputStream = new ObjectInputStream(resourceAsStream);
            try {
                C1342g gVar = new C1342g();
                gVar.readExternal(objectInputStream);
                List<C1341f> a = gVar.mo9247a();
                if (a.isEmpty()) {
                    f5450g.log(Level.SEVERE, "empty metadata: " + str3);
                    throw new RuntimeException("empty metadata: " + str3);
                }
                if (a.size() > 1) {
                    f5450g.log(Level.WARNING, "invalid metadata (too many entries): " + str3);
                }
                C1341f fVar = a.get(0);
                if (equals) {
                    this.f5468F.put(Integer.valueOf(i), fVar);
                } else {
                    this.f5467E.put(str2, fVar);
                }
                m5480a((InputStream) objectInputStream);
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e = e2;
            objectInputStream = null;
            try {
                f5450g.log(Level.SEVERE, "cannot load/parse metadata: " + str3, e);
                throw new RuntimeException("cannot load/parse metadata: " + str3, e);
            } catch (Throwable th) {
                th = th;
                m5480a((InputStream) objectInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
            m5480a((InputStream) objectInputStream);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1341f mo9194b(String str) {
        if (!m5484g(str)) {
            return null;
        }
        synchronized (this.f5467E) {
            if (!this.f5467E.containsKey(str)) {
                mo9193a(this.f5471f, str, 0);
            }
        }
        return this.f5467E.get(str);
    }

    /* renamed from: b */
    public String mo9195b(int i) {
        List list = this.f5472h.get(Integer.valueOf(i));
        return list == null ? "ZZ" : (String) list.get(0);
    }

    /* renamed from: c */
    public int mo9196c(String str) {
        if (m5484g(str)) {
            return m5485h(str);
        }
        Logger logger = f5450g;
        Level level = Level.WARNING;
        StringBuilder append = new StringBuilder().append("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        logger.log(level, append.append(str).append(") provided.").toString());
        return 0;
    }

    /* renamed from: d */
    public C1336a mo9197d(String str) {
        return new C1336a(str);
    }
}
