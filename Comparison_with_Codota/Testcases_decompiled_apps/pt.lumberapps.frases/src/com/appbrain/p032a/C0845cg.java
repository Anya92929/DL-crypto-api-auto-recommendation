package com.appbrain.p032a;

import android.content.Context;
import android.support.p009v4.app.NotificationCompat;
import android.util.AttributeSet;
import cmn.C0738bf;
import com.appbrain.C0783a;
import com.appbrain.C1138z;

/* renamed from: com.appbrain.a.cg */
public final class C0845cg {

    /* renamed from: a */
    private static final int[] f2229a = {0, 1, 2, 3};

    /* renamed from: b */
    private static final int[] f2230b = {4, 5, 6};

    /* renamed from: c */
    private int f2231c;

    /* renamed from: d */
    private int f2232d;

    /* renamed from: e */
    private int f2233e;

    /* renamed from: f */
    private int f2234f;

    /* renamed from: a */
    private static int m3731a(AttributeSet attributeSet, boolean z, String str, int i) {
        int attributeIntValue = attributeSet == null ? -1 : attributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.appbrain", str, -1);
        if (attributeIntValue == -1) {
            if (z) {
                return 0;
            }
            return C0738bf.m3250a(i);
        } else if (attributeIntValue < 0 || attributeIntValue >= i) {
            return 0;
        } else {
            return attributeIntValue;
        }
    }

    /* renamed from: a */
    public final C0955gi mo3708a(Context context, String str, C1138z zVar, C0783a aVar) {
        C0974u uVar = C0838c.f2211b[this.f2231c];
        C0970q qVar = C0838c.f2210a[this.f2232d];
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String a = C0801aq.m3606a(f2229a[this.f2233e], language);
        String a2 = C0801aq.m3606a(f2230b[this.f2234f], language);
        int i = (this.f2231c * 16) + this.f2232d + (this.f2233e * NotificationCompat.FLAG_HIGH_PRIORITY) + (this.f2234f * 1024);
        C0846ch chVar = new C0846ch(this, str, i, aVar, context, zVar);
        C0803as b = new C0803as().mo3648b(i);
        if (aVar != null) {
            b.mo3650c(aVar.mo3616a());
        }
        return new C0847ci(this, a, a2, qVar, chVar, uVar, context, b.toString());
    }

    /* renamed from: a */
    public final void mo3709a(int i) {
        this.f2233e = i;
        if (this.f2233e < 0 || this.f2233e >= f2229a.length) {
            this.f2233e = 0;
        }
    }

    /* renamed from: a */
    public final void mo3710a(AttributeSet attributeSet, boolean z) {
        this.f2231c = m3731a(attributeSet, z, "design", C0838c.f2211b.length);
        this.f2232d = m3731a(attributeSet, z, "colors", C0838c.f2210a.length);
        this.f2233e = m3731a(attributeSet, z, "title", f2229a.length);
        this.f2234f = m3731a(attributeSet, z, "button", f2230b.length);
    }

    /* renamed from: b */
    public final void mo3711b(int i) {
        this.f2234f = i;
        if (this.f2234f < 0 || this.f2234f >= f2230b.length) {
            this.f2234f = 0;
        }
    }

    /* renamed from: c */
    public final void mo3712c(int i) {
        this.f2231c = i;
        if (this.f2231c < 0 || this.f2231c >= C0838c.f2211b.length) {
            this.f2231c = 0;
        }
    }

    /* renamed from: d */
    public final void mo3713d(int i) {
        this.f2232d = i;
        if (this.f2232d < 0 || this.f2232d >= C0838c.f2210a.length) {
            this.f2232d = 0;
        }
    }
}
