package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.OnSignOutCompleteListener;
import com.google.android.gms.appstate.OnStateDeletedListener;
import com.google.android.gms.appstate.OnStateListLoadedListener;
import com.google.android.gms.appstate.OnStateLoadedListener;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.internal.C0585e;
import com.google.android.gms.internal.C0597k;

/* renamed from: com.google.android.gms.internal.c */
public final class C0545c extends C0597k<C0585e> {

    /* renamed from: g */
    private final String f1242g;

    /* renamed from: com.google.android.gms.internal.c$a */
    final class C0546a extends C0482b {

        /* renamed from: n */
        private final OnStateDeletedListener f1243n;

        public C0546a(OnStateDeletedListener onStateDeletedListener) {
            this.f1243n = (OnStateDeletedListener) C0621s.m1887b(onStateDeletedListener, (Object) "Listener must not be null");
        }

        public void onStateDeleted(int statusCode, int stateKey) {
            C0545c.this.mo5431a((C0597k<T>.b<?>) new C0547b(this.f1243n, statusCode, stateKey));
        }
    }

    /* renamed from: com.google.android.gms.internal.c$b */
    final class C0547b extends C0597k<C0585e>.b<OnStateDeletedListener> {

        /* renamed from: p */
        private final int f1246p;

        /* renamed from: q */
        private final int f1247q;

        public C0547b(OnStateDeletedListener onStateDeletedListener, int i, int i2) {
            super(onStateDeletedListener);
            this.f1246p = i;
            this.f1247q = i2;
        }

        /* renamed from: a */
        public void mo4646a(OnStateDeletedListener onStateDeletedListener) {
            onStateDeletedListener.onStateDeleted(this.f1246p, this.f1247q);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.c$c */
    final class C0548c extends C0482b {

        /* renamed from: r */
        private final OnStateListLoadedListener f1249r;

        public C0548c(OnStateListLoadedListener onStateListLoadedListener) {
            this.f1249r = (OnStateListLoadedListener) C0621s.m1887b(onStateListLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: a */
        public void mo4752a(C0344d dVar) {
            C0545c.this.mo5431a((C0597k<T>.b<?>) new C0549d(this.f1249r, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.c$d */
    final class C0549d extends C0597k<C0585e>.c<OnStateListLoadedListener> {
        public C0549d(OnStateListLoadedListener onStateListLoadedListener, C0344d dVar) {
            super(onStateListLoadedListener, dVar);
        }

        /* renamed from: a */
        public void mo4644a(OnStateListLoadedListener onStateListLoadedListener, C0344d dVar) {
            onStateListLoadedListener.onStateListLoaded(dVar.getStatusCode(), new AppStateBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.c$e */
    final class C0550e extends C0482b {

        /* renamed from: s */
        private final OnStateLoadedListener f1252s;

        public C0550e(OnStateLoadedListener onStateLoadedListener) {
            this.f1252s = (OnStateLoadedListener) C0621s.m1887b(onStateLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: a */
        public void mo4751a(int i, C0344d dVar) {
            C0545c.this.mo5431a((C0597k<T>.b<?>) new C0551f(this.f1252s, i, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.c$f */
    final class C0551f extends C0597k<C0585e>.c<OnStateLoadedListener> {

        /* renamed from: q */
        private final int f1254q;

        public C0551f(OnStateLoadedListener onStateLoadedListener, int i, C0344d dVar) {
            super(onStateLoadedListener, dVar);
            this.f1254q = i;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public void mo4644a(OnStateLoadedListener onStateLoadedListener, C0344d dVar) {
            byte[] bArr;
            String str;
            byte[] bArr2 = null;
            AppStateBuffer appStateBuffer = new AppStateBuffer(dVar);
            try {
                if (appStateBuffer.getCount() > 0) {
                    AppState appState = appStateBuffer.get(0);
                    str = appState.getConflictVersion();
                    bArr = appState.getLocalData();
                    bArr2 = appState.getConflictData();
                } else {
                    bArr = null;
                    str = null;
                }
                appStateBuffer.close();
                int statusCode = dVar.getStatusCode();
                if (statusCode == 2000) {
                    onStateLoadedListener.onStateConflict(this.f1254q, str, bArr, bArr2);
                } else {
                    onStateLoadedListener.onStateLoaded(statusCode, this.f1254q, bArr);
                }
            } catch (Throwable th) {
                appStateBuffer.close();
                throw th;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.c$g */
    final class C0552g extends C0482b {

        /* renamed from: t */
        private final OnSignOutCompleteListener f1256t;

        public C0552g(OnSignOutCompleteListener onSignOutCompleteListener) {
            this.f1256t = (OnSignOutCompleteListener) C0621s.m1887b(onSignOutCompleteListener, (Object) "Listener must not be null");
        }

        public void onSignOutComplete() {
            C0545c.this.mo5431a((C0597k<T>.b<?>) new C0553h(this.f1256t));
        }
    }

    /* renamed from: com.google.android.gms.internal.c$h */
    final class C0553h extends C0597k<C0585e>.b<OnSignOutCompleteListener> {
        public C0553h(OnSignOutCompleteListener onSignOutCompleteListener) {
            super(onSignOutCompleteListener);
        }

        /* renamed from: a */
        public void mo4646a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.onSignOutComplete();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    public C0545c(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f1242g = (String) C0621s.m1890d(str);
    }

    /* renamed from: a */
    public void mo5096a(OnStateLoadedListener onStateLoadedListener, int i, byte[] bArr) {
        try {
            ((C0585e) mo5430C()).mo5390a(onStateLoadedListener == null ? null : new C0550e(onStateLoadedListener), i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4595a(C0612p pVar, C0597k.C0601d dVar) throws RemoteException {
        pVar.mo5471a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1242g, mo5434x());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4596a(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        C0621s.m1885a(z, String.format("AppStateClient requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0585e mo4600c(IBinder iBinder) {
        return C0585e.C0586a.m1764e(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4598b() {
        return "com.google.android.gms.appstate.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4601c() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void deleteState(OnStateDeletedListener listener, int stateKey) {
        try {
            ((C0585e) mo5430C()).mo5392b(new C0546a(listener), stateKey);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public int getMaxNumKeys() {
        try {
            return ((C0585e) mo5430C()).getMaxNumKeys();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int getMaxStateSize() {
        try {
            return ((C0585e) mo5430C()).getMaxStateSize();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public void listStates(OnStateListLoadedListener listener) {
        try {
            ((C0585e) mo5430C()).mo5387a(new C0548c(listener));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void loadState(OnStateLoadedListener listener, int stateKey) {
        try {
            ((C0585e) mo5430C()).mo5388a(new C0550e(listener), stateKey);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void resolveState(OnStateLoadedListener listener, int stateKey, String resolvedVersion, byte[] resolvedData) {
        try {
            ((C0585e) mo5430C()).mo5389a(new C0550e(listener), stateKey, resolvedVersion, resolvedData);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void signOut(OnSignOutCompleteListener listener) {
        try {
            ((C0585e) mo5430C()).mo5391b(listener == null ? null : new C0552g(listener));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }
}
