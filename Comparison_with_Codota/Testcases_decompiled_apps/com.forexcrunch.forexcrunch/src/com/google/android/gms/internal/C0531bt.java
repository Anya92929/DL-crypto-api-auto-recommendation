package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.internal.C0528bs;
import com.google.android.gms.internal.C0597k;
import com.google.android.gms.plus.C0751a;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.internal.bt */
public class C0531bt extends C0597k<C0528bs> {

    /* renamed from: ip */
    private Person f1154ip;

    /* renamed from: iq */
    private C0751a f1155iq;

    /* renamed from: com.google.android.gms.internal.bt$a */
    final class C0532a extends C0518bo {

        /* renamed from: ir */
        private final PlusClient.OnMomentsLoadedListener f1156ir;

        public C0532a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener) {
            this.f1156ir = onMomentsLoadedListener;
        }

        /* renamed from: a */
        public void mo4858a(C0344d dVar, String str, String str2) {
            C0344d dVar2;
            ConnectionResult connectionResult = new ConnectionResult(dVar.getStatusCode(), dVar.mo4065l() != null ? (PendingIntent) dVar.mo4065l().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || dVar == null) {
                dVar2 = dVar;
            } else {
                if (!dVar.isClosed()) {
                    dVar.close();
                }
                dVar2 = null;
            }
            C0531bt.this.mo5431a((C0597k<T>.b<?>) new C0533b(this.f1156ir, connectionResult, dVar2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.bt$b */
    final class C0533b extends C0597k<C0528bs>.c<PlusClient.OnMomentsLoadedListener> {

        /* renamed from: it */
        private final ConnectionResult f1159it;

        /* renamed from: iu */
        private final String f1160iu;

        /* renamed from: iv */
        private final String f1161iv;

        public C0533b(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, ConnectionResult connectionResult, C0344d dVar, String str, String str2) {
            super(onMomentsLoadedListener, dVar);
            this.f1159it = connectionResult;
            this.f1160iu = str;
            this.f1161iv = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, C0344d dVar) {
            onMomentsLoadedListener.onMomentsLoaded(this.f1159it, dVar != null ? new MomentBuffer(dVar) : null, this.f1160iu, this.f1161iv);
        }
    }

    /* renamed from: com.google.android.gms.internal.bt$c */
    final class C0534c extends C0518bo {

        /* renamed from: iw */
        private final PlusClient.OnPeopleLoadedListener f1163iw;

        public C0534c(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener) {
            this.f1163iw = onPeopleLoadedListener;
        }

        /* renamed from: a */
        public void mo4857a(C0344d dVar, String str) {
            C0344d dVar2;
            ConnectionResult connectionResult = new ConnectionResult(dVar.getStatusCode(), dVar.mo4065l() != null ? (PendingIntent) dVar.mo4065l().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || dVar == null) {
                dVar2 = dVar;
            } else {
                if (!dVar.isClosed()) {
                    dVar.close();
                }
                dVar2 = null;
            }
            C0531bt.this.mo5431a((C0597k<T>.b<?>) new C0535d(this.f1163iw, connectionResult, dVar2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.bt$d */
    final class C0535d extends C0597k<C0528bs>.c<PlusClient.OnPeopleLoadedListener> {

        /* renamed from: it */
        private final ConnectionResult f1165it;

        /* renamed from: iu */
        private final String f1166iu;

        public C0535d(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, ConnectionResult connectionResult, C0344d dVar, String str) {
            super(onPeopleLoadedListener, dVar);
            this.f1165it = connectionResult;
            this.f1166iu = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4644a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, C0344d dVar) {
            onPeopleLoadedListener.onPeopleLoaded(this.f1165it, dVar != null ? new PersonBuffer(dVar) : null, this.f1166iu);
        }
    }

    /* renamed from: com.google.android.gms.internal.bt$e */
    final class C0536e extends C0518bo {

        /* renamed from: ix */
        private final PlusClient.OnAccessRevokedListener f1168ix;

        public C0536e(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            this.f1168ix = onAccessRevokedListener;
        }

        /* renamed from: b */
        public void mo4859b(int i, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            C0531bt.this.mo5431a((C0597k<T>.b<?>) new C0537f(this.f1168ix, new ConnectionResult(i, pendingIntent)));
        }
    }

    /* renamed from: com.google.android.gms.internal.bt$f */
    final class C0537f extends C0597k<C0528bs>.b<PlusClient.OnAccessRevokedListener> {

        /* renamed from: it */
        private final ConnectionResult f1170it;

        public C0537f(PlusClient.OnAccessRevokedListener onAccessRevokedListener, ConnectionResult connectionResult) {
            super(onAccessRevokedListener);
            this.f1170it = connectionResult;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            C0531bt.this.disconnect();
            if (onAccessRevokedListener != null) {
                onAccessRevokedListener.onAccessRevoked(this.f1170it);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    public C0531bt(Context context, C0751a aVar, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, aVar.mo6365by());
        this.f1155iq = aVar;
    }

    /* renamed from: F */
    public boolean mo4915F(String str) {
        return Arrays.asList(mo5434x()).contains(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4588a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.f1154ip = C0556cc.m1601d(bundle.getByteArray("loaded_person"));
        }
        super.mo4588a(i, iBinder, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4595a(C0612p pVar, C0597k.C0601d dVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("skip_oob", false);
        bundle.putStringArray("request_visible_actions", this.f1155iq.mo6366bz());
        if (this.f1155iq.mo6361bA() != null) {
            bundle.putStringArray("required_features", this.f1155iq.mo6361bA());
        }
        if (this.f1155iq.mo6364bD() != null) {
            bundle.putString("application_name", this.f1155iq.mo6364bD());
        }
        pVar.mo5472a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.f1155iq.mo6363bC(), this.f1155iq.mo6362bB(), mo5434x(), this.f1155iq.getAccountName(), bundle);
    }

    /* renamed from: a */
    public void mo4916a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, Collection<String> collection) {
        mo5429B();
        C0534c cVar = new C0534c(onPeopleLoadedListener);
        try {
            ((C0528bs) mo5430C()).mo4896a((C0519bp) cVar, (List<String>) new ArrayList(collection));
        } catch (RemoteException e) {
            cVar.mo4857a(C0344d.m568f(8), (String) null);
        }
    }

    /* renamed from: a */
    public void mo4917a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, String[] strArr) {
        mo4916a(onPeopleLoadedListener, (Collection<String>) Arrays.asList(strArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ac */
    public C0528bs mo4600c(IBinder iBinder) {
        return C0528bs.C0529a.m1476ab(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4598b() {
        return "com.google.android.gms.plus.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4601c() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void clearDefaultAccount() {
        mo5429B();
        try {
            this.f1154ip = null;
            ((C0528bs) mo5430C()).clearDefaultAccount();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        mo5429B();
        try {
            return ((C0528bs) mo5430C()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        mo5429B();
        return this.f1154ip;
    }

    public void loadMoments(PlusClient.OnMomentsLoadedListener listener) {
        loadMoments(listener, 20, (String) null, (Uri) null, (String) null, "me");
    }

    public void loadMoments(PlusClient.OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        mo5429B();
        C0532a aVar = listener != null ? new C0532a(listener) : null;
        try {
            ((C0528bs) mo5430C()).mo4881a(aVar, maxResults, pageToken, targetUrl, type, userId);
        } catch (RemoteException e) {
            aVar.mo4858a(C0344d.m568f(8), (String) null, (String) null);
        }
    }

    public void loadVisiblePeople(PlusClient.OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        mo5429B();
        C0534c cVar = new C0534c(listener);
        try {
            ((C0528bs) mo5430C()).mo4877a((C0519bp) cVar, 1, orderBy, -1, pageToken);
        } catch (RemoteException e) {
            cVar.mo4857a(C0344d.m568f(8), (String) null);
        }
    }

    public void loadVisiblePeople(PlusClient.OnPeopleLoadedListener listener, String pageToken) {
        loadVisiblePeople(listener, 0, pageToken);
    }

    public void removeMoment(String momentId) {
        mo5429B();
        try {
            ((C0528bs) mo5430C()).removeMoment(momentId);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void revokeAccessAndDisconnect(PlusClient.OnAccessRevokedListener listener) {
        mo5429B();
        clearDefaultAccount();
        C0536e eVar = new C0536e(listener);
        try {
            ((C0528bs) mo5430C()).mo4900c(eVar);
        } catch (RemoteException e) {
            eVar.mo4859b(8, (Bundle) null);
        }
    }

    public void writeMoment(Moment moment) {
        mo5429B();
        try {
            ((C0528bs) mo5430C()).mo4875a(C0419ak.m875a((C0544bz) moment));
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
