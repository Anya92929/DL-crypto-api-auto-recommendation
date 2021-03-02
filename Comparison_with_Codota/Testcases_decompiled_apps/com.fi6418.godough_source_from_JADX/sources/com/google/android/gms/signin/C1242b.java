package com.google.android.gms.signin;

import com.google.android.gms.common.api.C0702a;
import com.google.android.gms.common.api.C0739d;
import com.google.android.gms.common.api.C0742g;
import com.google.android.gms.common.api.C0744i;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.C1262m;
import com.google.android.gms.signin.internal.C1263n;

/* renamed from: com.google.android.gms.signin.b */
public final class C1242b {

    /* renamed from: a */
    public static final C0744i<C1263n> f5258a = new C0744i<>();

    /* renamed from: b */
    public static final C0744i<C1263n> f5259b = new C0744i<>();

    /* renamed from: c */
    public static final C0742g<C1263n, C1247g> f5260c = new C1243c();

    /* renamed from: d */
    static final C0742g<C1263n, C0739d> f5261d = new C1244d();

    /* renamed from: e */
    public static final Scope f5262e = new Scope("profile");

    /* renamed from: f */
    public static final Scope f5263f = new Scope("email");

    /* renamed from: g */
    public static final C0702a<C1247g> f5264g = new C0702a<>("SignIn.API", f5260c, f5258a);

    /* renamed from: h */
    public static final C0702a<C0739d> f5265h = new C0702a<>("SignIn.INTERNAL_API", f5261d, f5259b);

    /* renamed from: i */
    public static final C1245e f5266i = new C1262m();
}
