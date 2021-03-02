package com.jackhenry.android.p022a.p023a;

import android.content.Context;
import android.view.View;
import com.p004a.p005a.p007b.C0344a;

/* renamed from: com.jackhenry.android.a.a.f */
public class C1354f<T> extends C0344a {

    /* renamed from: a */
    private C1353e<T> f5566a;

    /* renamed from: b */
    private C1349a<T> f5567b;

    public C1354f(Context context, boolean z, int i, int i2, C1353e<T> eVar) {
        super(context, new C1350b(context, eVar), i, i2, z);
        this.f5566a = eVar;
    }

    /* renamed from: a */
    public void mo9281a(int i) {
        ((C1350b) mo6260a()).mo9267b(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6273a(View view, Exception exc) {
        return this.f5566a.mo9280a(view, exc);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo6274b() {
        int i = 0;
        if (this.f5567b != null) {
            i = this.f5567b.mo9262c();
        }
        this.f5567b = this.f5566a.mo9278a(i);
        return this.f5567b.mo9260a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo6275c() {
        if (this.f5567b != null) {
            C1350b bVar = (C1350b) mo6260a();
            bVar.mo9266a(this.f5567b.mo9260a());
            bVar.mo9265a(this.f5567b.mo9261b());
        }
    }

    /* renamed from: h */
    public void mo9282h() {
        ((C1350b) mo6260a()).mo9264a();
    }
}
