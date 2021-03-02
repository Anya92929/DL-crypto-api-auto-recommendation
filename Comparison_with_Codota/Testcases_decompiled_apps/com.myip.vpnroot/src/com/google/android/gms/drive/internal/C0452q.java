package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0336j;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0372c;
import com.google.android.gms.drive.events.C0373d;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.internal.C0380ab;
import com.google.android.gms.drive.internal.C0430o;
import com.google.android.gms.drive.internal.C0450p;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.q */
public class C0452q extends C0316d<C0380ab> {

    /* renamed from: Dd */
    private final String f1019Dd;

    /* renamed from: IH */
    private final String f1020IH;

    /* renamed from: Os */
    private final Bundle f1021Os;

    /* renamed from: Ot */
    private final boolean f1022Ot;

    /* renamed from: Ou */
    private DriveId f1023Ou;

    /* renamed from: Ov */
    private DriveId f1024Ov;

    /* renamed from: Ow */
    final GoogleApiClient.ConnectionCallbacks f1025Ow;

    /* renamed from: Ox */
    final Map<DriveId, Map<C0372c, C0489y>> f1026Ox = new HashMap();

    public C0452q(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f1019Dd = (String) C0348n.m857b(clientSettings.getAccountNameOrDefault(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.f1020IH = clientSettings.getRealClientPackageName();
        this.f1025Ow = connectionCallbacks;
        this.f1021Os = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.f1022Ot = false;
                return;
            case 1:
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (!serviceInfo.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
                }
                this.f1022Ot = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: T */
    public C0380ab mo3832j(IBinder iBinder) {
        return C0380ab.C0381a.m1064U(iBinder);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PendingResult<Status> mo5070a(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        C0348n.m859b(C0373d.m1000a(i, driveId), (Object) "id");
        C0348n.m861i("eventService");
        C0348n.m852a(isConnected(), "Client must be connected");
        if (this.f1022Ot) {
            return googleApiClient.mo4221b(new C0450p.C0451a() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4861a(new AddEventListenerRequest(driveId, i), (C0386ad) null, (String) null, (C0383ac) new C0415bb(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PendingResult<Status> mo5071a(GoogleApiClient googleApiClient, final DriveId driveId, final int i, C0372c cVar) {
        HashMap hashMap;
        PendingResult<Status> mVar;
        C0348n.m859b(C0373d.m1000a(i, driveId), (Object) "id");
        C0348n.m857b(cVar, (Object) "listener");
        C0348n.m852a(isConnected(), "Client must be connected");
        synchronized (this.f1026Ox) {
            Map map = this.f1026Ox.get(driveId);
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.f1026Ox.put(driveId, hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            final C0489y yVar = (C0489y) hashMap.get(cVar);
            if (yVar == null) {
                yVar = new C0489y(getLooper(), getContext(), i, cVar);
                hashMap.put(cVar, yVar);
            } else if (yVar.mo5099br(i)) {
                mVar = new C0430o.C0449m(googleApiClient, Status.f591Jo);
            }
            yVar.mo5098bq(i);
            mVar = googleApiClient.mo4221b(new C0450p.C0451a() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4861a(new AddEventListenerRequest(driveId, i), (C0386ad) yVar, (String) null, (C0383ac) new C0415bb(this));
                }
            });
        }
        return mVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4429a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f1023Ou = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.f1024Ov = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.mo4429a(i, iBinder, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        String packageName = getContext().getPackageName();
        C0348n.m861i(eVar);
        C0348n.m861i(packageName);
        C0348n.m861i(mo4434gR());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.f1020IH)) {
            bundle.putString("proxy_package_name", this.f1020IH);
        }
        bundle.putAll(this.f1021Os);
        kVar.mo4513a((C0336j) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, mo4434gR(), this.f1019Dd, bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PendingResult<Status> mo5072b(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        C0348n.m859b(C0373d.m1000a(i, driveId), (Object) "id");
        C0348n.m861i("eventService");
        C0348n.m852a(isConnected(), "Client must be connected");
        return googleApiClient.mo4221b(new C0450p.C0451a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4877a(new RemoveEventListenerRequest(driveId, i), (C0386ad) null, (String) null, (C0383ac) new C0415bb(this));
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PendingResult<Status> mo5073b(GoogleApiClient googleApiClient, final DriveId driveId, final int i, C0372c cVar) {
        PendingResult<Status> b;
        C0348n.m859b(C0373d.m1000a(i, driveId), (Object) "id");
        C0348n.m852a(isConnected(), "Client must be connected");
        C0348n.m857b(cVar, (Object) "listener");
        synchronized (this.f1026Ox) {
            Map map = this.f1026Ox.get(driveId);
            if (map == null) {
                b = new C0430o.C0449m(googleApiClient, Status.f591Jo);
            } else {
                final C0489y yVar = (C0489y) map.remove(cVar);
                if (yVar == null) {
                    b = new C0430o.C0449m(googleApiClient, Status.f591Jo);
                } else {
                    if (map.isEmpty()) {
                        this.f1026Ox.remove(driveId);
                    }
                    b = googleApiClient.mo4221b(new C0450p.C0451a() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public void mo3769a(C0452q qVar) throws RemoteException {
                            qVar.mo5074hY().mo4877a(new RemoveEventListenerRequest(driveId, i), (C0386ad) yVar, (String) null, (C0383ac) new C0415bb(this));
                        }
                    });
                }
            }
        }
        return b;
    }

    public void disconnect() {
        C0380ab abVar = (C0380ab) mo4435gS();
        if (abVar != null) {
            try {
                abVar.mo4870a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.f1026Ox.clear();
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    /* renamed from: hY */
    public C0380ab mo5074hY() {
        return (C0380ab) mo4435gS();
    }

    /* renamed from: hZ */
    public DriveId mo5075hZ() {
        return this.f1023Ou;
    }

    /* renamed from: ia */
    public DriveId mo5076ia() {
        return this.f1024Ov;
    }

    /* renamed from: ib */
    public boolean mo5077ib() {
        return this.f1022Ot;
    }
}
