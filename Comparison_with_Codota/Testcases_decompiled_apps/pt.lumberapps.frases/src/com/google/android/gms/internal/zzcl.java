package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@zzin
public class zzcl {

    /* renamed from: a */
    private final int f6044a;

    /* renamed from: b */
    private final int f6045b;

    /* renamed from: c */
    private final int f6046c;

    /* renamed from: d */
    private final zzcq f6047d;

    /* renamed from: e */
    private final Object f6048e = new Object();

    /* renamed from: f */
    private ArrayList f6049f = new ArrayList();

    /* renamed from: g */
    private ArrayList f6050g = new ArrayList();

    /* renamed from: h */
    private int f6051h = 0;

    /* renamed from: i */
    private int f6052i = 0;

    /* renamed from: j */
    private int f6053j = 0;

    /* renamed from: k */
    private int f6054k;

    /* renamed from: l */
    private String f6055l = "";

    /* renamed from: m */
    private String f6056m = "";

    public zzcl(int i, int i2, int i3, int i4) {
        this.f6044a = i;
        this.f6045b = i2;
        this.f6046c = i3;
        this.f6047d = new zzcq(i4);
    }

    /* renamed from: a */
    private String m6951a(ArrayList arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    /* renamed from: a */
    private void m6952a(String str, boolean z) {
        if (str != null && str.length() >= this.f6046c) {
            synchronized (this.f6048e) {
                this.f6049f.add(str);
                this.f6051h += str.length();
                if (z) {
                    this.f6050g.add(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8190a() {
        return this.f6051h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8191a(int i, int i2) {
        return (this.f6044a * i) + (this.f6045b * i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzcl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzcl zzcl = (zzcl) obj;
        return zzcl.zzhr() != null && zzcl.zzhr().equals(zzhr());
    }

    public int getScore() {
        return this.f6054k;
    }

    public int hashCode() {
        return zzhr().hashCode();
    }

    public String toString() {
        int i = this.f6052i;
        int i2 = this.f6054k;
        int i3 = this.f6051h;
        String valueOf = String.valueOf(m6951a(this.f6049f, 100));
        String valueOf2 = String.valueOf(m6951a(this.f6050g, 100));
        String str = this.f6055l;
        String str2 = this.f6056m;
        return new StringBuilder(String.valueOf(valueOf).length() + 133 + String.valueOf(valueOf2).length() + String.valueOf(str).length() + String.valueOf(str2).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(valueOf).append("\n viewableText").append(valueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).toString();
    }

    public void zzd(String str, boolean z) {
        m6952a(str, z);
        synchronized (this.f6048e) {
            if (this.f6053j < 0) {
                zzkd.zzcv("ActivityContent: negative number of WebViews.");
            }
            zzhw();
        }
    }

    public void zze(String str, boolean z) {
        m6952a(str, z);
    }

    public boolean zzhq() {
        boolean z;
        synchronized (this.f6048e) {
            z = this.f6053j == 0;
        }
        return z;
    }

    public String zzhr() {
        return this.f6055l;
    }

    public String zzhs() {
        return this.f6056m;
    }

    public void zzht() {
        synchronized (this.f6048e) {
            this.f6054k -= 100;
        }
    }

    public void zzhu() {
        synchronized (this.f6048e) {
            this.f6053j--;
        }
    }

    public void zzhv() {
        synchronized (this.f6048e) {
            this.f6053j++;
        }
    }

    public void zzhw() {
        synchronized (this.f6048e) {
            int a = mo8191a(this.f6051h, this.f6052i);
            if (a > this.f6054k) {
                this.f6054k = a;
                this.f6055l = this.f6047d.zza(this.f6049f);
                this.f6056m = this.f6047d.zza(this.f6050g);
            }
        }
    }

    public void zzl(int i) {
        this.f6052i = i;
    }
}
