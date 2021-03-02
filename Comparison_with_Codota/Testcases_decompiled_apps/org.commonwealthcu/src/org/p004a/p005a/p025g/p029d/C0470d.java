package org.p004a.p005a.p025g.p029d;

import java.io.Serializable;
import java.util.Date;
import org.p004a.p005a.p021e.C0359o;

/* renamed from: org.a.a.g.d.d */
public final class C0470d extends C0469c implements Serializable, C0359o {

    /* renamed from: a */
    private int[] f471a;

    /* renamed from: b */
    private boolean f472b;

    public C0470d(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public final void mo5078a(int[] iArr) {
        this.f471a = iArr;
    }

    /* renamed from: a */
    public final boolean mo5046a(Date date) {
        return this.f472b || super.mo5046a(date);
    }

    /* renamed from: b */
    public final void mo5079b(boolean z) {
        this.f472b = true;
    }

    public final Object clone() {
        C0470d dVar = (C0470d) super.clone();
        if (this.f471a != null) {
            dVar.f471a = (int[]) this.f471a.clone();
        }
        return dVar;
    }

    /* renamed from: e */
    public final int[] mo5050e() {
        return this.f471a;
    }
}
