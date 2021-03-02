package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.C0273a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0336j;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1309id;

/* renamed from: com.google.android.gms.internal.ib */
public final class C1298ib extends C0316d<C1309id> {

    /* renamed from: Dd */
    private final String f3909Dd;

    /* renamed from: com.google.android.gms.internal.ib$a */
    private static final class C1299a extends C1297ia {

        /* renamed from: De */
        private final BaseImplementation.C0270b<AppStateManager.StateDeletedResult> f3910De;

        public C1299a(BaseImplementation.C0270b<AppStateManager.StateDeletedResult> bVar) {
            this.f3910De = (BaseImplementation.C0270b) C0348n.m857b(bVar, (Object) "Result holder must not be null");
        }

        /* renamed from: e */
        public void mo8798e(int i, int i2) {
            this.f3910De.mo4196b(new C1300b(new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$b */
    private static final class C1300b implements AppStateManager.StateDeletedResult {

        /* renamed from: CM */
        private final Status f3911CM;

        /* renamed from: Df */
        private final int f3912Df;

        public C1300b(Status status, int i) {
            this.f3911CM = status;
            this.f3912Df = i;
        }

        public int getStateKey() {
            return this.f3912Df;
        }

        public Status getStatus() {
            return this.f3911CM;
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$c */
    private static final class C1301c extends C1297ia {

        /* renamed from: De */
        private final BaseImplementation.C0270b<AppStateManager.StateListResult> f3913De;

        public C1301c(BaseImplementation.C0270b<AppStateManager.StateListResult> bVar) {
            this.f3913De = (BaseImplementation.C0270b) C0348n.m857b(bVar, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo8797a(DataHolder dataHolder) {
            this.f3913De.mo4196b(new C1302d(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$d */
    private static final class C1302d extends C0273a implements AppStateManager.StateListResult {

        /* renamed from: Dg */
        private final AppStateBuffer f3914Dg;

        public C1302d(DataHolder dataHolder) {
            super(dataHolder);
            this.f3914Dg = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.f3914Dg;
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$e */
    private static final class C1303e extends C1297ia {

        /* renamed from: De */
        private final BaseImplementation.C0270b<AppStateManager.StateResult> f3915De;

        public C1303e(BaseImplementation.C0270b<AppStateManager.StateResult> bVar) {
            this.f3915De = (BaseImplementation.C0270b) C0348n.m857b(bVar, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo8796a(int i, DataHolder dataHolder) {
            this.f3915De.mo4196b(new C1304f(i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$f */
    private static final class C1304f extends C0273a implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {

        /* renamed from: Df */
        private final int f3916Df;

        /* renamed from: Dg */
        private final AppStateBuffer f3917Dg;

        public C1304f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.f3916Df = i;
            this.f3917Dg = new AppStateBuffer(dataHolder);
        }

        /* renamed from: ft */
        private boolean m4881ft() {
            return this.f599CM.getStatusCode() == 2000;
        }

        public AppStateManager.StateConflictResult getConflictResult() {
            if (m4881ft()) {
                return this;
            }
            return null;
        }

        public AppStateManager.StateLoadedResult getLoadedResult() {
            if (m4881ft()) {
                return null;
            }
            return this;
        }

        public byte[] getLocalData() {
            if (this.f3917Dg.getCount() == 0) {
                return null;
            }
            return this.f3917Dg.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            if (this.f3917Dg.getCount() == 0) {
                return null;
            }
            return this.f3917Dg.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            if (this.f3917Dg.getCount() == 0) {
                return null;
            }
            return this.f3917Dg.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.f3916Df;
        }

        public void release() {
            this.f3917Dg.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$g */
    private static final class C1305g extends C1297ia {

        /* renamed from: De */
        private final BaseImplementation.C0270b<Status> f3918De;

        public C1305g(BaseImplementation.C0270b<Status> bVar) {
            this.f3918De = (BaseImplementation.C0270b) C0348n.m857b(bVar, (Object) "Holder must not be null");
        }

        /* renamed from: fq */
        public void mo8799fq() {
            this.f3918De.mo4196b(new Status(0));
        }
    }

    public C1298ib(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f3909Dd = (String) C0348n.m861i(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public C1309id mo3832j(IBinder iBinder) {
        return C1309id.C1310a.m4903K(iBinder);
    }

    /* renamed from: a */
    public void mo8801a(BaseImplementation.C0270b<AppStateManager.StateListResult> bVar) {
        try {
            ((C1309id) mo4435gS()).mo8812a(new C1301c(bVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo8802a(BaseImplementation.C0270b<AppStateManager.StateDeletedResult> bVar, int i) {
        try {
            ((C1309id) mo4435gS()).mo8817b(new C1299a(bVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo8803a(BaseImplementation.C0270b<AppStateManager.StateResult> bVar, int i, String str, byte[] bArr) {
        try {
            ((C1309id) mo4435gS()).mo8814a(new C1303e(bVar), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo8804a(BaseImplementation.C0270b<AppStateManager.StateResult> bVar, int i, byte[] bArr) {
        try {
            ((C1309id) mo4435gS()).mo8815a(bVar == null ? null : new C1303e(bVar), i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4509a((C0336j) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f3909Dd, mo4434gR());
    }

    /* renamed from: b */
    public void mo8805b(BaseImplementation.C0270b<Status> bVar) {
        try {
            ((C1309id) mo4435gS()).mo8816b(new C1305g(bVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: b */
    public void mo8806b(BaseImplementation.C0270b<AppStateManager.StateResult> bVar, int i) {
        try {
            ((C1309id) mo4435gS()).mo8813a(new C1303e(bVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4432c(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        C0348n.m852a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    /* renamed from: fr */
    public int mo8807fr() {
        try {
            return ((C1309id) mo4435gS()).mo8819fr();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    /* renamed from: fs */
    public int mo8808fs() {
        try {
            return ((C1309id) mo4435gS()).mo8820fs();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.appstate.service.START";
    }
}
