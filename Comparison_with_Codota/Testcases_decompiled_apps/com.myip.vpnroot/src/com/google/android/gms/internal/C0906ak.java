package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@C1130ez
/* renamed from: com.google.android.gms.internal.ak */
public class C0906ak {

    /* renamed from: mw */
    private final Object f2560mw = new Object();

    /* renamed from: nf */
    private final int f2561nf;

    /* renamed from: ng */
    private final int f2562ng;

    /* renamed from: nh */
    private final int f2563nh;

    /* renamed from: ni */
    private final C0915ap f2564ni;

    /* renamed from: nj */
    private ArrayList<String> f2565nj = new ArrayList<>();

    /* renamed from: nk */
    private int f2566nk = 0;

    /* renamed from: nl */
    private int f2567nl = 0;

    /* renamed from: nm */
    private int f2568nm = 0;

    /* renamed from: nn */
    private int f2569nn;

    /* renamed from: no */
    private String f2570no = "";

    public C0906ak(int i, int i2, int i3, int i4) {
        this.f2561nf = i;
        this.f2562ng = i2;
        this.f2563nh = i3;
        this.f2564ni = new C0915ap(i4);
    }

    /* renamed from: a */
    private String m3857a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    /* renamed from: j */
    private void m3858j(String str) {
        if (str != null && str.length() >= this.f2563nh) {
            synchronized (this.f2560mw) {
                this.f2565nj.add(str);
                this.f2566nk += str.length();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7958a(int i, int i2) {
        return (this.f2561nf * i) + (this.f2562ng * i2);
    }

    /* renamed from: aN */
    public boolean mo7959aN() {
        boolean z;
        synchronized (this.f2560mw) {
            z = this.f2568nm == 0;
        }
        return z;
    }

    /* renamed from: aO */
    public String mo7960aO() {
        return this.f2570no;
    }

    /* renamed from: aP */
    public void mo7961aP() {
        synchronized (this.f2560mw) {
            this.f2569nn -= 100;
        }
    }

    /* renamed from: aQ */
    public void mo7962aQ() {
        synchronized (this.f2560mw) {
            this.f2568nm--;
        }
    }

    /* renamed from: aR */
    public void mo7963aR() {
        synchronized (this.f2560mw) {
            this.f2568nm++;
        }
    }

    /* renamed from: aS */
    public void mo7964aS() {
        synchronized (this.f2560mw) {
            int a = mo7958a(this.f2566nk, this.f2567nl);
            if (a > this.f2569nn) {
                this.f2569nn = a;
                this.f2570no = this.f2564ni.mo8002a(this.f2565nj);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aT */
    public int mo7965aT() {
        return this.f2566nk;
    }

    /* renamed from: c */
    public void mo7966c(int i) {
        this.f2567nl = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0906ak)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C0906ak akVar = (C0906ak) obj;
        return akVar.mo7960aO() != null && akVar.mo7960aO().equals(mo7960aO());
    }

    public int getScore() {
        return this.f2569nn;
    }

    /* renamed from: h */
    public void mo7969h(String str) {
        m3858j(str);
        synchronized (this.f2560mw) {
            if (this.f2568nm < 0) {
                C1229gs.m4675S("ActivityContent: negative number of WebViews.");
            }
            mo7964aS();
        }
    }

    public int hashCode() {
        return mo7960aO().hashCode();
    }

    /* renamed from: i */
    public void mo7971i(String str) {
        m3858j(str);
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.f2567nl + " score:" + this.f2569nn + " total_length:" + this.f2566nk + "\n text: " + m3857a(this.f2565nj, 200) + "\n signture: " + this.f2570no;
    }
}
