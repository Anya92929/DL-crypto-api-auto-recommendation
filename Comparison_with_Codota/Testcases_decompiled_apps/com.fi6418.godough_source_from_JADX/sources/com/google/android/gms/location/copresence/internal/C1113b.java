package com.google.android.gms.location.copresence.internal;

import android.content.Context;
import com.google.android.gms.location.internal.C1129i;
import com.google.android.gms.location.internal.C1142v;

/* renamed from: com.google.android.gms.location.copresence.internal.b */
public class C1113b {

    /* renamed from: a */
    private final Context f4927a;

    /* renamed from: b */
    private final String f4928b;

    /* renamed from: c */
    private final C1142v<C1129i> f4929c;

    /* renamed from: d */
    private final String f4930d;

    /* renamed from: e */
    private final CopresenceApiOptions f4931e;

    /* renamed from: f */
    private C1114c f4932f = null;

    private C1113b(Context context, String str, String str2, C1142v<C1129i> vVar, CopresenceApiOptions copresenceApiOptions) {
        this.f4927a = context;
        this.f4928b = str;
        this.f4929c = vVar;
        this.f4930d = str2;
        this.f4931e = copresenceApiOptions;
    }

    /* renamed from: a */
    public static C1113b m4834a(Context context, String str, String str2, C1142v<C1129i> vVar, CopresenceApiOptions copresenceApiOptions) {
        return new C1113b(context, str, str2, vVar, copresenceApiOptions);
    }
}
