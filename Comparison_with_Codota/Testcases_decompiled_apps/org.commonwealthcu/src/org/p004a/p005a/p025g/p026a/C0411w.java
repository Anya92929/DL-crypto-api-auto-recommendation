package org.p004a.p005a.p025g.p026a;

import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* renamed from: org.a.a.g.a.w */
final class C0411w extends C0408t {

    /* renamed from: a */
    private int f322a;

    /* renamed from: b */
    private byte[] f323b;

    /* renamed from: c */
    private byte[] f324c;

    /* renamed from: d */
    private byte[] f325d;

    /* renamed from: e */
    private byte[] f326e;

    /* renamed from: f */
    private byte[] f327f;

    /* renamed from: g */
    private byte[] f328g;

    C0411w(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) {
        byte[] l;
        byte[] bArr3;
        this.f322a = i;
        String c = C0404p.m581e(str2);
        String d = C0404p.m581e(str);
        C0405q qVar = new C0405q(d, str3, str4, bArr, str5, bArr2);
        if ((8388608 & i) != 0 && bArr2 != null && str5 != null) {
            try {
                this.f327f = qVar.mo5159d();
                this.f326e = qVar.mo5160e();
                l = (i & 128) != 0 ? qVar.mo5167l() : qVar.mo5165j();
            } catch (C0403o e) {
                this.f327f = new byte[0];
                this.f326e = qVar.mo5157b();
                l = (i & 128) != 0 ? qVar.mo5167l() : qVar.mo5163h();
            }
        } else if ((524288 & i) != 0) {
            this.f327f = qVar.mo5161f();
            this.f326e = qVar.mo5162g();
            l = (i & 128) != 0 ? qVar.mo5167l() : qVar.mo5166k();
        } else {
            this.f327f = qVar.mo5158c();
            this.f326e = qVar.mo5157b();
            l = (i & 128) != 0 ? qVar.mo5167l() : qVar.mo5164i();
        }
        if ((i & 16) == 0) {
            this.f328g = null;
        } else if ((1073741824 & i) != 0) {
            this.f328g = C0404p.m567b(qVar.mo5156a(), l);
        } else {
            this.f328g = l;
        }
        if (c != null) {
            try {
                bArr3 = c.getBytes("UnicodeLittleUnmarked");
            } catch (UnsupportedEncodingException e2) {
                throw new C0403o("Unicode not supported: " + e2.getMessage(), e2);
            }
        } else {
            bArr3 = null;
        }
        this.f324c = bArr3;
        this.f323b = d != null ? d.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked") : null;
        this.f325d = str3.getBytes("UnicodeLittleUnmarked");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo5177b() {
        int i = 0;
        int length = this.f327f.length;
        int length2 = this.f326e.length;
        int length3 = this.f323b != null ? this.f323b.length : 0;
        int length4 = this.f324c != null ? this.f324c.length : 0;
        int length5 = this.f325d.length;
        if (this.f328g != null) {
            i = this.f328g.length;
        }
        int i2 = length2 + 72;
        int i3 = i2 + length;
        int i4 = i3 + length3;
        int i5 = i4 + length5;
        int i6 = i5 + length4;
        mo5174a(i6 + i, 3);
        mo5179c(length2);
        mo5179c(length2);
        mo5180d(72);
        mo5179c(length);
        mo5179c(length);
        mo5180d(i2);
        mo5179c(length3);
        mo5179c(length3);
        mo5180d(i3);
        mo5179c(length5);
        mo5179c(length5);
        mo5180d(i4);
        mo5179c(length4);
        mo5179c(length4);
        mo5180d(i5);
        mo5179c(i);
        mo5179c(i);
        mo5180d(i6);
        mo5180d((this.f322a & 128) | (this.f322a & 512) | (this.f322a & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END) | 33554432 | (this.f322a & 32768) | (this.f322a & 32) | (this.f322a & 16) | (this.f322a & 536870912) | (this.f322a & Integer.MIN_VALUE) | (this.f322a & 1073741824) | (this.f322a & 8388608) | (this.f322a & 1) | (this.f322a & 4));
        mo5179c(261);
        mo5180d(2600);
        mo5179c(3840);
        mo5175a(this.f326e);
        mo5175a(this.f327f);
        mo5175a(this.f323b);
        mo5175a(this.f325d);
        mo5175a(this.f324c);
        if (this.f328g != null) {
            mo5175a(this.f328g);
        }
        return super.mo5177b();
    }
}
