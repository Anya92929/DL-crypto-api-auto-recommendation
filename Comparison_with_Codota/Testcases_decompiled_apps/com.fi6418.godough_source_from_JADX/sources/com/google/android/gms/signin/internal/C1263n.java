package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.api.C0756u;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.C0981ae;
import com.google.android.gms.common.internal.C0993aq;
import com.google.android.gms.common.internal.C1002az;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.common.internal.C1037y;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.C1246f;
import com.google.android.gms.signin.C1247g;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.gms.signin.internal.n */
public class C1263n extends C1037y<C1258i> implements C1246f {

    /* renamed from: d */
    private final boolean f5286d;

    /* renamed from: e */
    private final C1032t f5287e;

    /* renamed from: f */
    private final C1247g f5288f;

    /* renamed from: g */
    private Integer f5289g;

    /* renamed from: h */
    private final ExecutorService f5290h;

    public C1263n(Context context, Looper looper, boolean z, C1032t tVar, C1247g gVar, C0752q qVar, C0753r rVar, ExecutorService executorService) {
        super(context, looper, 44, tVar, qVar, rVar);
        this.f5286d = z;
        this.f5287e = tVar;
        this.f5288f = tVar.mo7638i();
        this.f5289g = tVar.mo7639j();
        this.f5290h = executorService;
    }

    /* renamed from: a */
    public static Bundle m5233a(C1247g gVar, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", gVar.mo9019a());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", gVar.mo9020b());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", gVar.mo9021c());
        if (gVar.mo9022d() != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new C1264o(gVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    public void mo9014a(C0993aq aqVar, Set<Scope> set, C1255f fVar) {
        C1009bf.m4529a(fVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((C1258i) mo7659m()).mo9053a(new AuthAccountRequest(aqVar, set), fVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                fVar.mo7456a(new ConnectionResult(8, (PendingIntent) null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    /* renamed from: a */
    public void mo9015a(C0993aq aqVar, boolean z) {
        try {
            ((C1258i) mo7659m()).mo9055a(aqVar, this.f5289g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    /* renamed from: a */
    public void mo9016a(C1002az azVar) {
        C1009bf.m4529a(azVar, (Object) "Expecting a valid IResolveAccountCallbacks");
        try {
            ((C1258i) mo7659m()).mo9054a(new ResolveAccountRequest(this.f5287e.mo7632c(), this.f5289g.intValue()), azVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                azVar.mo7355a(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1258i mo7614a(IBinder iBinder) {
        return C1259j.m5220a(iBinder);
    }

    /* renamed from: c */
    public boolean mo7438c() {
        return this.f5286d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo7616d() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo7617e() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Bundle mo7657k() {
        Bundle a = m5233a(this.f5288f, this.f5287e.mo7639j(), this.f5290h);
        if (!mo7655i().getPackageName().equals(this.f5287e.mo7636g())) {
            a.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f5287e.mo7636g());
        }
        return a;
    }

    /* renamed from: p */
    public void mo7891p() {
        try {
            ((C1258i) mo7659m()).mo9051a(this.f5289g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* renamed from: q */
    public void mo9018q() {
        mo7433a((C0756u) new C0981ae(this));
    }
}
