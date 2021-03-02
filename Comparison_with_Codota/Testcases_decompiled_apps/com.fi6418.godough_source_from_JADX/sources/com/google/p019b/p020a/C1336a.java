package com.google.p019b.p020a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.b.a.a */
public class C1336a {

    /* renamed from: l */
    private static final C1341f f5413l = new C1341f().mo9217b("NA");

    /* renamed from: o */
    private static final Pattern f5414o = Pattern.compile("\\[([^\\[\\]])*\\]");

    /* renamed from: p */
    private static final Pattern f5415p = Pattern.compile("\\d(?=[^,}][^,}])");

    /* renamed from: q */
    private static final Pattern f5416q = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*)+");

    /* renamed from: r */
    private static final Pattern f5417r = Pattern.compile("[- ]");

    /* renamed from: s */
    private static final Pattern f5418s = Pattern.compile(" ");

    /* renamed from: A */
    private List<C1340e> f5419A = new ArrayList();

    /* renamed from: B */
    private C1344i f5420B = new C1344i(64);

    /* renamed from: a */
    private String f5421a = "";

    /* renamed from: b */
    private StringBuilder f5422b = new StringBuilder();

    /* renamed from: c */
    private String f5423c = "";

    /* renamed from: d */
    private StringBuilder f5424d = new StringBuilder();

    /* renamed from: e */
    private StringBuilder f5425e = new StringBuilder();

    /* renamed from: f */
    private boolean f5426f = true;

    /* renamed from: g */
    private boolean f5427g = false;

    /* renamed from: h */
    private boolean f5428h = false;

    /* renamed from: i */
    private boolean f5429i = false;

    /* renamed from: j */
    private final C1338c f5430j = C1338c.m5478a();

    /* renamed from: k */
    private String f5431k;

    /* renamed from: m */
    private C1341f f5432m;

    /* renamed from: n */
    private C1341f f5433n;

    /* renamed from: t */
    private int f5434t = 0;

    /* renamed from: u */
    private int f5435u = 0;

    /* renamed from: v */
    private int f5436v = 0;

    /* renamed from: w */
    private StringBuilder f5437w = new StringBuilder();

    /* renamed from: x */
    private boolean f5438x = false;

    /* renamed from: y */
    private String f5439y = "";

    /* renamed from: z */
    private StringBuilder f5440z = new StringBuilder();

    C1336a(String str) {
        this.f5431k = str;
        this.f5433n = m5452a(this.f5431k);
        this.f5432m = this.f5433n;
    }

    /* renamed from: a */
    private C1341f m5452a(String str) {
        C1341f b = this.f5430j.mo9194b(this.f5430j.mo9195b(this.f5430j.mo9196c(str)));
        return b != null ? b : f5413l;
    }

    /* renamed from: a */
    private String m5453a(char c, boolean z) {
        this.f5424d.append(c);
        if (z) {
            this.f5435u = this.f5424d.length();
        }
        if (!m5458c(c)) {
            this.f5426f = false;
            this.f5427g = true;
        } else {
            c = m5456b(c, z);
        }
        if (this.f5426f) {
            switch (this.f5425e.length()) {
                case 0:
                case 1:
                case 2:
                    return this.f5424d.toString();
                case 3:
                    if (m5470k()) {
                        this.f5429i = true;
                        break;
                    } else {
                        this.f5439y = m5469j();
                        return m5466g();
                    }
            }
            if (this.f5429i) {
                if (m5471l()) {
                    this.f5429i = false;
                }
                return this.f5437w + this.f5440z.toString();
            } else if (this.f5419A.size() <= 0) {
                return m5466g();
            } else {
                String d = m5460d(c);
                String b = mo9188b();
                if (b.length() > 0) {
                    return b;
                }
                m5461d(this.f5440z.toString());
                return m5462d() ? m5467h() : this.f5426f ? m5464e(d) : this.f5424d.toString();
            }
        } else if (this.f5427g) {
            return this.f5424d.toString();
        } else {
            if (m5470k()) {
                if (m5471l()) {
                    return m5463e();
                }
            } else if (m5465f()) {
                this.f5437w.append(' ');
                return m5463e();
            }
            return this.f5424d.toString();
        }
    }

    /* renamed from: a */
    private String m5454a(String str, String str2) {
        Matcher matcher = this.f5420B.mo9256a(str).matcher("999999999999999");
        matcher.find();
        String group = matcher.group();
        return group.length() < this.f5440z.length() ? "" : group.replaceAll(str, str2).replaceAll("9", " ");
    }

    /* renamed from: a */
    private boolean m5455a(C1340e eVar) {
        String a = eVar.mo9200a();
        if (a.indexOf(124) != -1) {
            return false;
        }
        String replaceAll = f5415p.matcher(f5414o.matcher(a).replaceAll("\\\\d")).replaceAll("\\\\d");
        this.f5422b.setLength(0);
        String a2 = m5454a(replaceAll, eVar.mo9203b());
        if (a2.length() <= 0) {
            return false;
        }
        this.f5422b.append(a2);
        return true;
    }

    /* renamed from: b */
    private char m5456b(char c, boolean z) {
        if (c == '+') {
            this.f5425e.append(c);
        } else {
            c = Character.forDigit(Character.digit(c, 10), 10);
            this.f5425e.append(c);
            this.f5440z.append(c);
        }
        if (z) {
            this.f5436v = this.f5425e.length();
        }
        return c;
    }

    /* renamed from: b */
    private void m5457b(String str) {
        List<C1340e> f = (!this.f5428h || this.f5433n.mo9239i() <= 0) ? this.f5433n.mo9232f() : this.f5433n.mo9238h();
        boolean c = this.f5433n.mo9223c();
        for (C1340e next : f) {
            if (c && !this.f5428h && !next.mo9208e()) {
                C1338c cVar = this.f5430j;
                if (!C1338c.m5481a(next.mo9207d())) {
                }
            }
            if (m5459c(next.mo9203b())) {
                this.f5419A.add(next);
            }
        }
        m5461d(str);
    }

    /* renamed from: c */
    private boolean m5458c(char c) {
        if (!Character.isDigit(c)) {
            return this.f5424d.length() == 1 && C1338c.f5445a.matcher(Character.toString(c)).matches();
        }
        return true;
    }

    /* renamed from: c */
    private boolean m5459c(String str) {
        return f5416q.matcher(str).matches();
    }

    /* renamed from: d */
    private String m5460d(char c) {
        Matcher matcher = f5418s.matcher(this.f5422b);
        if (matcher.find(this.f5434t)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c));
            this.f5422b.replace(0, replaceFirst.length(), replaceFirst);
            this.f5434t = matcher.start();
            return this.f5422b.substring(0, this.f5434t + 1);
        }
        if (this.f5419A.size() == 1) {
            this.f5426f = false;
        }
        this.f5423c = "";
        return this.f5424d.toString();
    }

    /* renamed from: d */
    private void m5461d(String str) {
        int length = str.length() - 3;
        Iterator<C1340e> it = this.f5419A.iterator();
        while (it.hasNext()) {
            C1340e next = it.next();
            if (next.mo9204c() > length && !this.f5420B.mo9256a(next.mo9201a(length)).matcher(str).lookingAt()) {
                it.remove();
            }
        }
    }

    /* renamed from: d */
    private boolean m5462d() {
        Iterator<C1340e> it = this.f5419A.iterator();
        while (it.hasNext()) {
            C1340e next = it.next();
            String a = next.mo9200a();
            if (this.f5423c.equals(a)) {
                return false;
            }
            if (m5455a(next)) {
                this.f5423c = a;
                this.f5438x = f5417r.matcher(next.mo9207d()).find();
                this.f5434t = 0;
                return true;
            }
            it.remove();
        }
        this.f5426f = false;
        return false;
    }

    /* renamed from: e */
    private String m5463e() {
        this.f5426f = true;
        this.f5429i = false;
        this.f5419A.clear();
        return m5466g();
    }

    /* renamed from: e */
    private String m5464e(String str) {
        int length = this.f5437w.length();
        return (!this.f5438x || length <= 0 || this.f5437w.charAt(length + -1) == ' ') ? this.f5437w + str : new String(this.f5437w) + ' ' + str;
    }

    /* renamed from: f */
    private boolean m5465f() {
        if (this.f5439y.length() > 0) {
            this.f5440z.insert(0, this.f5439y);
            this.f5437w.setLength(this.f5437w.lastIndexOf(this.f5439y));
        }
        return !this.f5439y.equals(m5469j());
    }

    /* renamed from: g */
    private String m5466g() {
        if (this.f5440z.length() < 3) {
            return m5464e(this.f5440z.toString());
        }
        m5457b(this.f5440z.substring(0, 3));
        return m5462d() ? m5467h() : this.f5424d.toString();
    }

    /* renamed from: h */
    private String m5467h() {
        int length = this.f5440z.length();
        if (length <= 0) {
            return this.f5437w.toString();
        }
        String str = "";
        for (int i = 0; i < length; i++) {
            str = m5460d(this.f5440z.charAt(i));
        }
        return this.f5426f ? m5464e(str) : this.f5424d.toString();
    }

    /* renamed from: i */
    private boolean m5468i() {
        return this.f5433n.mo9211a() == 1 && this.f5440z.charAt(0) == '1' && this.f5440z.charAt(1) != '0' && this.f5440z.charAt(1) != '1';
    }

    /* renamed from: j */
    private String m5469j() {
        int i = 1;
        if (m5468i()) {
            this.f5437w.append('1').append(' ');
            this.f5428h = true;
        } else {
            if (this.f5433n.mo9226d()) {
                Matcher matcher = this.f5420B.mo9256a(this.f5433n.mo9229e()).matcher(this.f5440z);
                if (matcher.lookingAt()) {
                    this.f5428h = true;
                    i = matcher.end();
                    this.f5437w.append(this.f5440z.substring(0, i));
                }
            }
            i = 0;
        }
        String substring = this.f5440z.substring(0, i);
        this.f5440z.delete(0, i);
        return substring;
    }

    /* renamed from: k */
    private boolean m5470k() {
        Matcher matcher = this.f5420B.mo9256a("\\+|" + this.f5433n.mo9219b()).matcher(this.f5425e);
        if (!matcher.lookingAt()) {
            return false;
        }
        this.f5428h = true;
        int end = matcher.end();
        this.f5440z.setLength(0);
        this.f5440z.append(this.f5425e.substring(end));
        this.f5437w.setLength(0);
        this.f5437w.append(this.f5425e.substring(0, end));
        if (this.f5425e.charAt(0) == '+') {
            return true;
        }
        this.f5437w.append(' ');
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = new java.lang.StringBuilder();
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5471l() {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = r4.f5440z
            int r1 = r1.length()
            if (r1 != 0) goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.google.b.a.c r2 = r4.f5430j
            java.lang.StringBuilder r3 = r4.f5440z
            int r2 = r2.mo9191a((java.lang.StringBuilder) r3, (java.lang.StringBuilder) r1)
            if (r2 == 0) goto L_0x0009
            java.lang.StringBuilder r3 = r4.f5440z
            r3.setLength(r0)
            java.lang.StringBuilder r0 = r4.f5440z
            r0.append(r1)
            com.google.b.a.c r0 = r4.f5430j
            java.lang.String r0 = r0.mo9195b((int) r2)
            java.lang.String r1 = "001"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004a
            com.google.b.a.c r0 = r4.f5430j
            com.google.b.a.f r0 = r0.mo9192a((int) r2)
            r4.f5433n = r0
        L_0x0039:
            java.lang.String r0 = java.lang.Integer.toString(r2)
            java.lang.StringBuilder r1 = r4.f5437w
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 32
            r0.append(r1)
            r0 = 1
            goto L_0x0009
        L_0x004a:
            java.lang.String r1 = r4.f5431k
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0039
            com.google.b.a.f r0 = r4.m5452a((java.lang.String) r0)
            r4.f5433n = r0
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p019b.p020a.C1336a.m5471l():boolean");
    }

    /* renamed from: a */
    public String mo9186a(char c) {
        this.f5421a = m5453a(c, false);
        return this.f5421a;
    }

    /* renamed from: a */
    public void mo9187a() {
        this.f5421a = "";
        this.f5424d.setLength(0);
        this.f5425e.setLength(0);
        this.f5422b.setLength(0);
        this.f5434t = 0;
        this.f5423c = "";
        this.f5437w.setLength(0);
        this.f5439y = "";
        this.f5440z.setLength(0);
        this.f5426f = true;
        this.f5427g = false;
        this.f5436v = 0;
        this.f5435u = 0;
        this.f5428h = false;
        this.f5429i = false;
        this.f5419A.clear();
        this.f5438x = false;
        if (!this.f5433n.equals(this.f5432m)) {
            this.f5433n = m5452a(this.f5431k);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo9188b() {
        for (C1340e next : this.f5419A) {
            Matcher matcher = this.f5420B.mo9256a(next.mo9200a()).matcher(this.f5440z);
            if (matcher.matches()) {
                this.f5438x = f5417r.matcher(next.mo9207d()).find();
                return m5464e(matcher.replaceAll(next.mo9203b()));
            }
        }
        return "";
    }

    /* renamed from: b */
    public String mo9189b(char c) {
        this.f5421a = m5453a(c, true);
        return this.f5421a;
    }

    /* renamed from: c */
    public int mo9190c() {
        int i = 0;
        if (!this.f5426f) {
            return this.f5435u;
        }
        int i2 = 0;
        while (i2 < this.f5436v && i < this.f5421a.length()) {
            if (this.f5425e.charAt(i2) == this.f5421a.charAt(i)) {
                i2++;
            }
            i++;
        }
        return i;
    }
}
