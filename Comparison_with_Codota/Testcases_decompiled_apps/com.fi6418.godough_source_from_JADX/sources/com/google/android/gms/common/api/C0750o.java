package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.common.internal.C1033u;
import com.google.android.gms.p018c.C0676r;
import com.google.android.gms.signin.C1242b;
import com.google.android.gms.signin.C1246f;
import com.google.android.gms.signin.C1247g;
import com.google.android.gms.signin.C1249i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.api.o */
public final class C0750o {

    /* renamed from: a */
    private Account f4509a;

    /* renamed from: b */
    private final Set<Scope> f4510b = new HashSet();

    /* renamed from: c */
    private int f4511c;

    /* renamed from: d */
    private View f4512d;

    /* renamed from: e */
    private String f4513e;

    /* renamed from: f */
    private String f4514f;

    /* renamed from: g */
    private final Map<C0702a<?>, C1033u> f4515g = new C0676r();

    /* renamed from: h */
    private final Context f4516h;

    /* renamed from: i */
    private final Map<C0702a<?>, C0729b> f4517i = new C0676r();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public FragmentActivity f4518j;

    /* renamed from: k */
    private int f4519k = -1;

    /* renamed from: l */
    private int f4520l = -1;

    /* renamed from: m */
    private C0753r f4521m;

    /* renamed from: n */
    private Looper f4522n;

    /* renamed from: o */
    private C0772b f4523o = C0772b.m4180a();

    /* renamed from: p */
    private C0742g<? extends C1246f, C1247g> f4524p = C1242b.f5260c;

    /* renamed from: q */
    private final ArrayList<C0752q> f4525q = new ArrayList<>();

    /* renamed from: r */
    private final ArrayList<C0753r> f4526r = new ArrayList<>();

    /* renamed from: s */
    private C1249i f4527s = new C1249i();

    public C0750o(Context context) {
        this.f4516h = context;
        this.f4522n = context.getMainLooper();
        this.f4513e = context.getPackageName();
        this.f4514f = context.getClass().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4103a(C0730ba baVar, C0749n nVar) {
        baVar.mo7416a(this.f4519k, nVar, this.f4521m);
    }

    /* renamed from: c */
    private C0749n m4105c() {
        C0714al alVar = new C0714al(this.f4516h.getApplicationContext(), this.f4522n, mo7448a(), this.f4523o, this.f4524p, this.f4517i, this.f4525q, this.f4526r, this.f4519k, -1);
        C0730ba a = C0730ba.m4045a(this.f4518j);
        if (a == null) {
            new Handler(this.f4516h.getMainLooper()).post(new C0751p(this, alVar));
        } else {
            m4103a(a, alVar);
        }
        return alVar;
    }

    /* renamed from: d */
    private C0749n m4106d() {
        C0733bd a = C0733bd.m4059a(this.f4518j);
        C0749n a2 = a.mo7421a(this.f4520l);
        if (a2 == null) {
            a2 = new C0714al(this.f4516h.getApplicationContext(), this.f4522n, mo7448a(), this.f4523o, this.f4524p, this.f4517i, this.f4525q, this.f4526r, -1, this.f4520l);
        }
        a.mo7422a(this.f4520l, a2, this.f4521m);
        return a2;
    }

    /* renamed from: a */
    public C0750o mo7445a(C0702a<? extends C0740e> aVar) {
        this.f4517i.put(aVar, (Object) null);
        this.f4510b.addAll(aVar.mo7350a().mo7431a(null));
        return this;
    }

    /* renamed from: a */
    public C0750o mo7446a(C0752q qVar) {
        this.f4525q.add(qVar);
        return this;
    }

    /* renamed from: a */
    public C0750o mo7447a(C0753r rVar) {
        this.f4526r.add(rVar);
        return this;
    }

    /* renamed from: a */
    public C1032t mo7448a() {
        return new C1032t(this.f4509a, this.f4510b, this.f4515g, this.f4511c, this.f4512d, this.f4513e, this.f4514f, this.f4527s.mo9023a());
    }

    /* renamed from: b */
    public C0749n mo7449b() {
        C1009bf.m4537b(!this.f4517i.isEmpty(), "must call addApi() to add at least one API");
        return this.f4519k >= 0 ? m4105c() : this.f4520l >= 0 ? m4106d() : new C0714al(this.f4516h, this.f4522n, mo7448a(), this.f4523o, this.f4524p, this.f4517i, this.f4525q, this.f4526r, -1, -1);
    }
}
