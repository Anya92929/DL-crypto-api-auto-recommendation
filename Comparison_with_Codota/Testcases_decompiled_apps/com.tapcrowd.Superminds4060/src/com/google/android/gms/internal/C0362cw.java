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
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0374cy;
import com.google.android.gms.internal.C0387de;

/* renamed from: com.google.android.gms.internal.cw */
public final class C0362cw extends C0387de<C0374cy> {

    /* renamed from: it */
    private final String f1048it;

    /* renamed from: com.google.android.gms.internal.cw$a */
    final class C0363a extends C0361cv {

        /* renamed from: iA */
        private final OnStateDeletedListener f1049iA;

        public C0363a(OnStateDeletedListener onStateDeletedListener) {
            this.f1049iA = (OnStateDeletedListener) C0411dm.m940a(onStateDeletedListener, (Object) "Listener must not be null");
        }

        public void onStateDeleted(int statusCode, int stateKey) {
            C0362cw.this.mo4326a((C0387de<T>.b<?>) new C0364b(this.f1049iA, statusCode, stateKey));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$b */
    final class C0364b extends C0387de<C0374cy>.b<OnStateDeletedListener> {

        /* renamed from: iC */
        private final int f1052iC;

        /* renamed from: iD */
        private final int f1053iD;

        public C0364b(OnStateDeletedListener onStateDeletedListener, int i, int i2) {
            super(onStateDeletedListener);
            this.f1052iC = i;
            this.f1053iD = i2;
        }

        /* renamed from: a */
        public void mo4270a(OnStateDeletedListener onStateDeletedListener) {
            onStateDeletedListener.onStateDeleted(this.f1052iC, this.f1053iD);
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$c */
    final class C0365c extends C0361cv {

        /* renamed from: iE */
        private final OnStateListLoadedListener f1055iE;

        public C0365c(OnStateListLoadedListener onStateListLoadedListener) {
            this.f1055iE = (OnStateListLoadedListener) C0411dm.m940a(onStateListLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: a */
        public void mo4255a(C0140d dVar) {
            C0362cw.this.mo4326a((C0387de<T>.b<?>) new C0366d(this.f1055iE, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$d */
    final class C0366d extends C0387de<C0374cy>.c<OnStateListLoadedListener> {
        public C0366d(OnStateListLoadedListener onStateListLoadedListener, C0140d dVar) {
            super(onStateListLoadedListener, dVar);
        }

        /* renamed from: a */
        public void mo4273a(OnStateListLoadedListener onStateListLoadedListener, C0140d dVar) {
            onStateListLoadedListener.onStateListLoaded(dVar.getStatusCode(), new AppStateBuffer(dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$e */
    final class C0367e extends C0361cv {

        /* renamed from: iF */
        private final OnStateLoadedListener f1058iF;

        public C0367e(OnStateLoadedListener onStateLoadedListener) {
            this.f1058iF = (OnStateLoadedListener) C0411dm.m940a(onStateLoadedListener, (Object) "Listener must not be null");
        }

        /* renamed from: a */
        public void mo4254a(int i, C0140d dVar) {
            C0362cw.this.mo4326a((C0387de<T>.b<?>) new C0368f(this.f1058iF, i, dVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$f */
    final class C0368f extends C0387de<C0374cy>.c<OnStateLoadedListener> {

        /* renamed from: iD */
        private final int f1060iD;

        public C0368f(OnStateLoadedListener onStateLoadedListener, int i, C0140d dVar) {
            super(onStateLoadedListener, dVar);
            this.f1060iD = i;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public void mo4273a(OnStateLoadedListener onStateLoadedListener, C0140d dVar) {
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
                    onStateLoadedListener.onStateConflict(this.f1060iD, str, bArr, bArr2);
                } else {
                    onStateLoadedListener.onStateLoaded(statusCode, this.f1060iD, bArr);
                }
            } catch (Throwable th) {
                appStateBuffer.close();
                throw th;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$g */
    final class C0369g extends C0361cv {

        /* renamed from: iG */
        private final OnSignOutCompleteListener f1062iG;

        public C0369g(OnSignOutCompleteListener onSignOutCompleteListener) {
            this.f1062iG = (OnSignOutCompleteListener) C0411dm.m940a(onSignOutCompleteListener, (Object) "Listener must not be null");
        }

        public void onSignOutComplete() {
            C0362cw.this.mo4326a((C0387de<T>.b<?>) new C0370h(this.f1062iG));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw$h */
    final class C0370h extends C0387de<C0374cy>.b<OnSignOutCompleteListener> {
        public C0370h(OnSignOutCompleteListener onSignOutCompleteListener) {
            super(onSignOutCompleteListener);
        }

        /* renamed from: a */
        public void mo4270a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.onSignOutComplete();
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    public C0362cw(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f1048it = (String) C0411dm.m944e(str);
    }

    /* renamed from: a */
    public void mo4259a(OnStateLoadedListener onStateLoadedListener, int i, byte[] bArr) {
        try {
            ((C0374cy) mo4332bd()).mo4282a(onStateLoadedListener == null ? null : new C0367e(onStateLoadedListener), i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        djVar.mo4371a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1048it, mo4327aY());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4260a(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        C0411dm.m941a(z, (Object) String.format("AppStateClient requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.gms.appstate.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void deleteState(OnStateDeletedListener listener, int stateKey) {
        try {
            ((C0374cy) mo4332bd()).mo4284b(new C0363a(listener), stateKey);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public int getMaxNumKeys() {
        try {
            return ((C0374cy) mo4332bd()).getMaxNumKeys();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int getMaxStateSize() {
        try {
            return ((C0374cy) mo4332bd()).getMaxStateSize();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public void listStates(OnStateListLoadedListener listener) {
        try {
            ((C0374cy) mo4332bd()).mo4279a(new C0365c(listener));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void loadState(OnStateLoadedListener listener, int stateKey) {
        try {
            ((C0374cy) mo4332bd()).mo4280a(new C0367e(listener), stateKey);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public C0374cy mo4168p(IBinder iBinder) {
        return C0374cy.C0375a.m812t(iBinder);
    }

    public void resolveState(OnStateLoadedListener listener, int stateKey, String resolvedVersion, byte[] resolvedData) {
        try {
            ((C0374cy) mo4332bd()).mo4281a(new C0367e(listener), stateKey, resolvedVersion, resolvedData);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void signOut(OnSignOutCompleteListener listener) {
        try {
            ((C0374cy) mo4332bd()).mo4283b(listener == null ? null : new C0369g(listener));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }
}
