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
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0387de;
import com.google.android.gms.internal.C0543fk;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.scribe.model.OAuthConstants;

/* renamed from: com.google.android.gms.internal.fl */
public class C0546fl extends C0387de<C0543fk> implements GooglePlayServicesClient {

    /* renamed from: ro */
    private Person f1334ro;

    /* renamed from: rp */
    private C0555fn f1335rp;

    /* renamed from: com.google.android.gms.internal.fl$a */
    final class C0547a extends C0533fg {

        /* renamed from: rq */
        private final PlusClient.OnMomentsLoadedListener f1336rq;

        public C0547a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener) {
            this.f1336rq = onMomentsLoadedListener;
        }

        /* renamed from: a */
        public void mo4800a(C0140d dVar, String str, String str2) {
            C0140d dVar2;
            ConnectionResult connectionResult = new ConnectionResult(dVar.getStatusCode(), dVar.mo3599aM() != null ? (PendingIntent) dVar.mo3599aM().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || dVar == null) {
                dVar2 = dVar;
            } else {
                if (!dVar.isClosed()) {
                    dVar.close();
                }
                dVar2 = null;
            }
            C0546fl.this.mo4326a((C0387de<T>.b<?>) new C0548b(this.f1336rq, connectionResult, dVar2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl$b */
    final class C0548b extends C0387de<C0543fk>.c<PlusClient.OnMomentsLoadedListener> {

        /* renamed from: rs */
        private final ConnectionResult f1339rs;

        /* renamed from: rt */
        private final String f1340rt;

        /* renamed from: ru */
        private final String f1341ru;

        public C0548b(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, ConnectionResult connectionResult, C0140d dVar, String str, String str2) {
            super(onMomentsLoadedListener, dVar);
            this.f1339rs = connectionResult;
            this.f1340rt = str;
            this.f1341ru = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, C0140d dVar) {
            onMomentsLoadedListener.onMomentsLoaded(this.f1339rs, dVar != null ? new MomentBuffer(dVar) : null, this.f1340rt, this.f1341ru);
        }
    }

    /* renamed from: com.google.android.gms.internal.fl$c */
    final class C0549c extends C0533fg {

        /* renamed from: rv */
        private final PlusClient.OnPeopleLoadedListener f1343rv;

        public C0549c(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener) {
            this.f1343rv = onPeopleLoadedListener;
        }

        /* renamed from: a */
        public void mo4799a(C0140d dVar, String str) {
            C0140d dVar2;
            ConnectionResult connectionResult = new ConnectionResult(dVar.getStatusCode(), dVar.mo3599aM() != null ? (PendingIntent) dVar.mo3599aM().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || dVar == null) {
                dVar2 = dVar;
            } else {
                if (!dVar.isClosed()) {
                    dVar.close();
                }
                dVar2 = null;
            }
            C0546fl.this.mo4326a((C0387de<T>.b<?>) new C0550d(this.f1343rv, connectionResult, dVar2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl$d */
    final class C0550d extends C0387de<C0543fk>.c<PlusClient.OnPeopleLoadedListener> {

        /* renamed from: rs */
        private final ConnectionResult f1345rs;

        /* renamed from: rt */
        private final String f1346rt;

        public C0550d(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, ConnectionResult connectionResult, C0140d dVar, String str) {
            super(onPeopleLoadedListener, dVar);
            this.f1345rs = connectionResult;
            this.f1346rt = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4273a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, C0140d dVar) {
            onPeopleLoadedListener.onPeopleLoaded(this.f1345rs, dVar != null ? new PersonBuffer(dVar) : null, this.f1346rt);
        }
    }

    /* renamed from: com.google.android.gms.internal.fl$e */
    final class C0551e extends C0533fg {

        /* renamed from: rw */
        private final PlusClient.OnAccessRevokedListener f1348rw;

        public C0551e(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            this.f1348rw = onAccessRevokedListener;
        }

        /* renamed from: b */
        public void mo4801b(int i, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            C0546fl.this.mo4326a((C0387de<T>.b<?>) new C0552f(this.f1348rw, new ConnectionResult(i, pendingIntent)));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl$f */
    final class C0552f extends C0387de<C0543fk>.b<PlusClient.OnAccessRevokedListener> {

        /* renamed from: rs */
        private final ConnectionResult f1350rs;

        public C0552f(PlusClient.OnAccessRevokedListener onAccessRevokedListener, ConnectionResult connectionResult) {
            super(onAccessRevokedListener);
            this.f1350rs = connectionResult;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            C0546fl.this.disconnect();
            if (onAccessRevokedListener != null) {
                onAccessRevokedListener.onAccessRevoked(this.f1350rs);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    public C0546fl(Context context, C0555fn fnVar, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, fnVar.mo4851cZ());
        this.f1335rp = fnVar;
    }

    /* renamed from: Y */
    public boolean mo4834Y(String str) {
        return Arrays.asList(mo4327aY()).contains(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4324a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.f1334ro = C0563fv.m1715e(bundle.getByteArray("loaded_person"));
        }
        super.mo4324a(i, iBinder, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(OAuthConstants.CLIENT_ID, this.f1335rp.mo4858df());
        bundle.putStringArray("request_visible_actions", this.f1335rp.mo4852da());
        djVar.mo4372a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.f1335rp.mo4855dd(), this.f1335rp.mo4854dc(), mo4327aY(), this.f1335rp.getAccountName(), bundle);
    }

    /* renamed from: a */
    public void mo4835a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, Collection<String> collection) {
        mo4331bc();
        C0549c cVar = new C0549c(onPeopleLoadedListener);
        try {
            ((C0543fk) mo4332bd()).mo4821a((C0534fh) cVar, (List<String>) new ArrayList(collection));
        } catch (RemoteException e) {
            cVar.mo4799a(C0140d.m245r(8), (String) null);
        }
    }

    /* renamed from: a */
    public void mo4836a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, String[] strArr) {
        mo4835a(onPeopleLoadedListener, (Collection<String>) Arrays.asList(strArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.gms.plus.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ar */
    public C0543fk mo4168p(IBinder iBinder) {
        return C0543fk.C0544a.m1623aq(iBinder);
    }

    public void clearDefaultAccount() {
        mo4331bc();
        try {
            this.f1334ro = null;
            ((C0543fk) mo4332bd()).clearDefaultAccount();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        mo4331bc();
        try {
            return ((C0543fk) mo4332bd()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        mo4331bc();
        return this.f1334ro;
    }

    public void loadMoments(PlusClient.OnMomentsLoadedListener listener) {
        loadMoments(listener, 20, (String) null, (Uri) null, (String) null, "me");
    }

    public void loadMoments(PlusClient.OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        mo4331bc();
        C0547a aVar = listener != null ? new C0547a(listener) : null;
        try {
            ((C0543fk) mo4332bd()).mo4817a(aVar, maxResults, pageToken, targetUrl, type, userId);
        } catch (RemoteException e) {
            aVar.mo4800a(C0140d.m245r(8), (String) null, (String) null);
        }
    }

    public void loadVisiblePeople(PlusClient.OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        mo4331bc();
        C0549c cVar = new C0549c(listener);
        try {
            ((C0543fk) mo4332bd()).mo4816a(cVar, 1, orderBy, -1, pageToken);
        } catch (RemoteException e) {
            cVar.mo4799a(C0140d.m245r(8), (String) null);
        }
    }

    public void loadVisiblePeople(PlusClient.OnPeopleLoadedListener listener, String pageToken) {
        loadVisiblePeople(listener, 0, pageToken);
    }

    public void removeMoment(String momentId) {
        mo4331bc();
        try {
            ((C0543fk) mo4332bd()).removeMoment(momentId);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void revokeAccessAndDisconnect(PlusClient.OnAccessRevokedListener listener) {
        mo4331bc();
        clearDefaultAccount();
        C0551e eVar = new C0551e(listener);
        try {
            ((C0543fk) mo4332bd()).mo4822b(eVar);
        } catch (RemoteException e) {
            eVar.mo4801b(8, (Bundle) null);
        }
    }

    public void writeMoment(Moment moment) {
        mo4331bc();
        try {
            ((C0543fk) mo4332bd()).mo4814a(C0433ec.m1052a((C0560fs) moment));
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
