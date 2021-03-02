package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;

/* renamed from: com.google.android.gms.measurement.internal.b */
class C1909b {

    /* renamed from: a */
    private final zzx f7136a;

    /* renamed from: b */
    private final String f7137b;

    /* renamed from: c */
    private String f7138c;

    /* renamed from: d */
    private String f7139d;

    /* renamed from: e */
    private String f7140e;

    /* renamed from: f */
    private String f7141f;

    /* renamed from: g */
    private long f7142g;

    /* renamed from: h */
    private long f7143h;

    /* renamed from: i */
    private long f7144i;

    /* renamed from: j */
    private String f7145j;

    /* renamed from: k */
    private long f7146k;

    /* renamed from: l */
    private String f7147l;

    /* renamed from: m */
    private long f7148m;

    /* renamed from: n */
    private long f7149n;

    /* renamed from: o */
    private boolean f7150o;

    /* renamed from: p */
    private long f7151p;

    /* renamed from: q */
    private long f7152q;

    /* renamed from: r */
    private long f7153r;

    /* renamed from: s */
    private long f7154s;

    /* renamed from: t */
    private long f7155t;

    /* renamed from: u */
    private boolean f7156u;

    /* renamed from: v */
    private long f7157v;

    /* renamed from: w */
    private long f7158w;

    C1909b(zzx zzx, String str) {
        zzab.zzy(zzx);
        zzab.zzhr(str);
        this.f7136a = zzx;
        this.f7137b = str;
        this.f7136a.zzwu();
    }

    /* renamed from: a */
    public void mo9264a() {
        this.f7136a.zzwu();
        this.f7156u = false;
    }

    /* renamed from: a */
    public void mo9265a(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7143h != j) | this.f7156u;
        this.f7143h = j;
    }

    /* renamed from: a */
    public void mo9266a(String str) {
        this.f7136a.zzwu();
        this.f7156u = (!zzal.zzbb(this.f7138c, str)) | this.f7156u;
        this.f7138c = str;
    }

    /* renamed from: a */
    public void mo9267a(boolean z) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7150o != z) | this.f7156u;
        this.f7150o = z;
    }

    /* renamed from: b */
    public String mo9268b() {
        this.f7136a.zzwu();
        return this.f7137b;
    }

    /* renamed from: b */
    public void mo9269b(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7144i != j) | this.f7156u;
        this.f7144i = j;
    }

    /* renamed from: b */
    public void mo9270b(String str) {
        this.f7136a.zzwu();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f7156u = (!zzal.zzbb(this.f7139d, str)) | this.f7156u;
        this.f7139d = str;
    }

    /* renamed from: c */
    public String mo9271c() {
        this.f7136a.zzwu();
        return this.f7138c;
    }

    /* renamed from: c */
    public void mo9272c(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7146k != j) | this.f7156u;
        this.f7146k = j;
    }

    /* renamed from: c */
    public void mo9273c(String str) {
        this.f7136a.zzwu();
        this.f7156u = (!zzal.zzbb(this.f7140e, str)) | this.f7156u;
        this.f7140e = str;
    }

    /* renamed from: d */
    public String mo9274d() {
        this.f7136a.zzwu();
        return this.f7139d;
    }

    /* renamed from: d */
    public void mo9275d(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7148m != j) | this.f7156u;
        this.f7148m = j;
    }

    /* renamed from: d */
    public void mo9276d(String str) {
        this.f7136a.zzwu();
        this.f7156u = (!zzal.zzbb(this.f7141f, str)) | this.f7156u;
        this.f7141f = str;
    }

    /* renamed from: e */
    public String mo9277e() {
        this.f7136a.zzwu();
        return this.f7140e;
    }

    /* renamed from: e */
    public void mo9278e(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7149n != j) | this.f7156u;
        this.f7149n = j;
    }

    /* renamed from: e */
    public void mo9279e(String str) {
        this.f7136a.zzwu();
        this.f7156u = (!zzal.zzbb(this.f7145j, str)) | this.f7156u;
        this.f7145j = str;
    }

    /* renamed from: f */
    public String mo9280f() {
        this.f7136a.zzwu();
        return this.f7141f;
    }

    /* renamed from: f */
    public void mo9281f(long j) {
        boolean z = true;
        zzab.zzbo(j >= 0);
        this.f7136a.zzwu();
        boolean z2 = this.f7156u;
        if (this.f7142g == j) {
            z = false;
        }
        this.f7156u = z2 | z;
        this.f7142g = j;
    }

    /* renamed from: f */
    public void mo9282f(String str) {
        this.f7136a.zzwu();
        this.f7156u = (!zzal.zzbb(this.f7147l, str)) | this.f7156u;
        this.f7147l = str;
    }

    /* renamed from: g */
    public long mo9283g() {
        this.f7136a.zzwu();
        return this.f7143h;
    }

    /* renamed from: g */
    public void mo9284g(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7157v != j) | this.f7156u;
        this.f7157v = j;
    }

    /* renamed from: h */
    public long mo9285h() {
        this.f7136a.zzwu();
        return this.f7144i;
    }

    /* renamed from: h */
    public void mo9286h(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7158w != j) | this.f7156u;
        this.f7158w = j;
    }

    /* renamed from: i */
    public String mo9287i() {
        this.f7136a.zzwu();
        return this.f7145j;
    }

    /* renamed from: i */
    public void mo9288i(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7151p != j) | this.f7156u;
        this.f7151p = j;
    }

    /* renamed from: j */
    public long mo9289j() {
        this.f7136a.zzwu();
        return this.f7146k;
    }

    /* renamed from: j */
    public void mo9290j(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7152q != j) | this.f7156u;
        this.f7152q = j;
    }

    /* renamed from: k */
    public String mo9291k() {
        this.f7136a.zzwu();
        return this.f7147l;
    }

    /* renamed from: k */
    public void mo9292k(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7153r != j) | this.f7156u;
        this.f7153r = j;
    }

    /* renamed from: l */
    public long mo9293l() {
        this.f7136a.zzwu();
        return this.f7148m;
    }

    /* renamed from: l */
    public void mo9294l(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7154s != j) | this.f7156u;
        this.f7154s = j;
    }

    /* renamed from: m */
    public long mo9295m() {
        this.f7136a.zzwu();
        return this.f7149n;
    }

    /* renamed from: m */
    public void mo9296m(long j) {
        this.f7136a.zzwu();
        this.f7156u = (this.f7155t != j) | this.f7156u;
        this.f7155t = j;
    }

    /* renamed from: n */
    public boolean mo9297n() {
        this.f7136a.zzwu();
        return this.f7150o;
    }

    /* renamed from: o */
    public long mo9298o() {
        this.f7136a.zzwu();
        return this.f7142g;
    }

    /* renamed from: p */
    public long mo9299p() {
        this.f7136a.zzwu();
        return this.f7157v;
    }

    /* renamed from: q */
    public long mo9300q() {
        this.f7136a.zzwu();
        return this.f7158w;
    }

    /* renamed from: r */
    public void mo9301r() {
        this.f7136a.zzwu();
        long j = this.f7142g + 1;
        if (j > 2147483647L) {
            this.f7136a.zzbsd().zzbsx().log("Bundle index overflow");
            j = 0;
        }
        this.f7156u = true;
        this.f7142g = j;
    }

    /* renamed from: s */
    public long mo9302s() {
        this.f7136a.zzwu();
        return this.f7151p;
    }

    /* renamed from: t */
    public long mo9303t() {
        this.f7136a.zzwu();
        return this.f7152q;
    }

    /* renamed from: u */
    public long mo9304u() {
        this.f7136a.zzwu();
        return this.f7153r;
    }

    /* renamed from: v */
    public long mo9305v() {
        this.f7136a.zzwu();
        return this.f7154s;
    }

    /* renamed from: w */
    public long mo9306w() {
        this.f7136a.zzwu();
        return this.f7155t;
    }
}
