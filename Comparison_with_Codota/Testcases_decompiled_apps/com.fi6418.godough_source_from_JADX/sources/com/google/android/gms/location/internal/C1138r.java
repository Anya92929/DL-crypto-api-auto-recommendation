package com.google.android.gms.location.internal;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.location.copresence.internal.C1113b;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;

/* renamed from: com.google.android.gms.location.internal.r */
public class C1138r extends C1121a {

    /* renamed from: e */
    private final C1135o f4981e;

    /* renamed from: f */
    private final C1113b f4982f;

    public C1138r(Context context, Looper looper, C0752q qVar, C0753r rVar, String str, C1032t tVar) {
        this(context, looper, qVar, rVar, str, tVar, CopresenceApiOptions.f4923a);
    }

    public C1138r(Context context, Looper looper, C0752q qVar, C0753r rVar, String str, C1032t tVar, CopresenceApiOptions copresenceApiOptions) {
        super(context, looper, qVar, rVar, str, tVar);
        this.f4981e = new C1135o(context, this.f4967d);
        this.f4982f = C1113b.m4834a(context, tVar.mo7629a(), tVar.mo7636g(), this.f4967d, copresenceApiOptions);
    }

    /* renamed from: a */
    public void mo7432a() {
        synchronized (this.f4981e) {
            if (mo7437b()) {
                try {
                    this.f4981e.mo7886b();
                    this.f4981e.mo7887c();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.mo7432a();
        }
    }

    /* renamed from: o */
    public boolean mo7661o() {
        return true;
    }

    /* renamed from: p */
    public Location mo7891p() {
        return this.f4981e.mo7884a();
    }
}
