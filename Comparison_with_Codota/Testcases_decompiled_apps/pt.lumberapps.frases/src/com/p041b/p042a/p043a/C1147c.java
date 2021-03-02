package com.p041b.p042a.p043a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.widget.GridView;
import com.p041b.p042a.p045b.C1151c;
import com.p046c.p047a.C1153a;
import com.p046c.p047a.C1174d;
import com.p046c.p049c.C1200a;

/* renamed from: com.b.a.a.c */
public class C1147c {

    /* renamed from: a */
    private final C1151c f3198a;

    /* renamed from: b */
    private final SparseArray f3199b = new SparseArray();

    /* renamed from: c */
    private int f3200c = 150;

    /* renamed from: d */
    private int f3201d = 100;

    /* renamed from: e */
    private int f3202e = 300;

    /* renamed from: f */
    private long f3203f;

    /* renamed from: g */
    private int f3204g;

    /* renamed from: h */
    private int f3205h;

    /* renamed from: i */
    private boolean f3206i = true;

    public C1147c(C1151c cVar) {
        this.f3198a = cVar;
        this.f3203f = -1;
        this.f3204g = -1;
        this.f3205h = -1;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private int m5234b(int i) {
        if ((this.f3198a.mo4488c() - this.f3198a.mo4487b()) + 1 >= (i - 1) - this.f3204g) {
            return Math.max(0, (int) ((-SystemClock.uptimeMillis()) + this.f3203f + ((long) this.f3200c) + ((long) ((i - this.f3204g) * this.f3201d))));
        }
        int i2 = this.f3201d;
        if (!(this.f3198a.mo4489d() instanceof GridView) || Build.VERSION.SDK_INT < 11) {
            return i2;
        }
        return ((i % ((GridView) this.f3198a.mo4489d()).getNumColumns()) * this.f3201d) + i2;
    }

    /* renamed from: b */
    private void m5235b(int i, View view, C1153a[] aVarArr) {
        if (this.f3203f == -1) {
            this.f3203f = SystemClock.uptimeMillis();
        }
        C1200a.m5464a(view, 0.0f);
        C1174d dVar = new C1174d();
        dVar.mo4557a(aVarArr);
        dVar.mo4558b((long) m5234b(i));
        dVar.mo4490a((long) this.f3202e);
        dVar.mo4491a();
        this.f3199b.put(view.hashCode(), dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4463a(int i) {
        this.f3205h = i;
    }

    /* renamed from: a */
    public void mo4464a(int i, View view, C1153a[] aVarArr) {
        if (this.f3206i && i > this.f3205h) {
            if (this.f3204g == -1) {
                this.f3204g = i;
            }
            m5235b(i, view, aVarArr);
            this.f3205h = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4465a(View view) {
        int hashCode = view.hashCode();
        C1153a aVar = (C1153a) this.f3199b.get(hashCode);
        if (aVar != null) {
            aVar.mo4495c();
            this.f3199b.remove(hashCode);
        }
    }
}
