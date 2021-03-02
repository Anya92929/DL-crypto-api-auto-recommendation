package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0333i;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.internal.C1380jp;
import com.google.android.gms.internal.C1636nv;
import com.google.android.gms.internal.C1639ny;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.C1952d;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1955e extends C0316d<C1952d> {
    private Person ali;
    private final C1966h alj;

    /* renamed from: com.google.android.gms.plus.internal.e$a */
    final class C1956a extends C1945a {
        private final BaseImplementation.C0270b<Status> alk;

        public C1956a(BaseImplementation.C0270b<Status> bVar) {
            this.alk = bVar;
        }

        /* renamed from: aB */
        public void mo11319aB(Status status) {
            C1955e.this.mo4430a((C0316d<T>.b<?>) new C1959d(this.alk, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$b */
    final class C1957b extends C1945a {
        private final BaseImplementation.C0270b<Moments.LoadMomentsResult> alk;

        public C1957b(BaseImplementation.C0270b<Moments.LoadMomentsResult> bVar) {
            this.alk = bVar;
        }

        /* renamed from: a */
        public void mo11318a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), (String) null, dataHolder.mo4321gz() != null ? (PendingIntent) dataHolder.mo4321gz().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            C1955e.this.mo4430a((C0316d<T>.b<?>) new C1958c(this.alk, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$c */
    final class C1958c extends C0316d<C1952d>.d<BaseImplementation.C0270b<Moments.LoadMomentsResult>> implements Moments.LoadMomentsResult {

        /* renamed from: CM */
        private final Status f4503CM;

        /* renamed from: Ni */
        private final String f4504Ni;
        private final String alm;
        private MomentBuffer aln;

        public C1958c(BaseImplementation.C0270b<Moments.LoadMomentsResult> bVar, Status status, DataHolder dataHolder, String str, String str2) {
            super(bVar, dataHolder);
            this.f4503CM = status;
            this.f4504Ni = str;
            this.alm = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4455a(BaseImplementation.C0270b<Moments.LoadMomentsResult> bVar, DataHolder dataHolder) {
            this.aln = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            bVar.mo4196b(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.aln;
        }

        public String getNextPageToken() {
            return this.f4504Ni;
        }

        public Status getStatus() {
            return this.f4503CM;
        }

        public String getUpdated() {
            return this.alm;
        }

        public void release() {
            if (this.aln != null) {
                this.aln.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$d */
    final class C1959d extends C0316d<C1952d>.b<BaseImplementation.C0270b<Status>> {

        /* renamed from: CM */
        private final Status f4505CM;

        public C1959d(BaseImplementation.C0270b<Status> bVar, Status status) {
            super(bVar);
            this.f4505CM = status;
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public void mo4449g(BaseImplementation.C0270b<Status> bVar) {
            if (bVar != null) {
                bVar.mo4196b(this.f4505CM);
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$e */
    final class C1960e extends C1945a {
        private final BaseImplementation.C0270b<People.LoadPeopleResult> alk;

        public C1960e(BaseImplementation.C0270b<People.LoadPeopleResult> bVar) {
            this.alk = bVar;
        }

        /* renamed from: a */
        public void mo11317a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), (String) null, dataHolder.mo4321gz() != null ? (PendingIntent) dataHolder.mo4321gz().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            C1955e.this.mo4430a((C0316d<T>.b<?>) new C1961f(this.alk, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$f */
    final class C1961f extends C0316d<C1952d>.d<BaseImplementation.C0270b<People.LoadPeopleResult>> implements People.LoadPeopleResult {

        /* renamed from: CM */
        private final Status f4506CM;

        /* renamed from: Ni */
        private final String f4507Ni;
        private PersonBuffer alo;

        public C1961f(BaseImplementation.C0270b<People.LoadPeopleResult> bVar, Status status, DataHolder dataHolder, String str) {
            super(bVar, dataHolder);
            this.f4506CM = status;
            this.f4507Ni = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4455a(BaseImplementation.C0270b<People.LoadPeopleResult> bVar, DataHolder dataHolder) {
            this.alo = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            bVar.mo4196b(this);
        }

        public String getNextPageToken() {
            return this.f4507Ni;
        }

        public PersonBuffer getPersonBuffer() {
            return this.alo;
        }

        public Status getStatus() {
            return this.f4506CM;
        }

        public void release() {
            if (this.alo != null) {
                this.alo.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$g */
    final class C1962g extends C1945a {
        private final BaseImplementation.C0270b<Status> alk;

        public C1962g(BaseImplementation.C0270b<Status> bVar) {
            this.alk = bVar;
        }

        /* renamed from: h */
        public void mo11322h(int i, Bundle bundle) {
            C1955e.this.mo4430a((C0316d<T>.b<?>) new C1963h(this.alk, new Status(i, (String) null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$h */
    final class C1963h extends C0316d<C1952d>.b<BaseImplementation.C0270b<Status>> {

        /* renamed from: CM */
        private final Status f4508CM;

        public C1963h(BaseImplementation.C0270b<Status> bVar, Status status) {
            super(bVar);
            this.f4508CM = status;
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public void mo4449g(BaseImplementation.C0270b<Status> bVar) {
            C1955e.this.disconnect();
            if (bVar != null) {
                bVar.mo4196b(this.f4508CM);
            }
        }
    }

    public C1955e(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, C1966h hVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, hVar.mo11382ne());
        this.alj = hVar;
    }

    @Deprecated
    public C1955e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C1966h hVar) {
        this(context, context.getMainLooper(), new C0316d.C0319c(connectionCallbacks), new C0316d.C0323g(onConnectionFailedListener), hVar);
    }

    /* renamed from: a */
    public C0333i mo11353a(BaseImplementation.C0270b<People.LoadPeopleResult> bVar, int i, String str) {
        mo4433dK();
        C1960e eVar = new C1960e(bVar);
        try {
            return ((C1952d) mo4435gS()).mo11330a(eVar, 1, i, -1, str);
        } catch (RemoteException e) {
            eVar.mo11317a(DataHolder.m593as(8), (String) null);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4429a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.ali = C1639ny.m5760i(bundle.getByteArray("loaded_person"));
        }
        super.mo4429a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo11354a(BaseImplementation.C0270b<Moments.LoadMomentsResult> bVar, int i, String str, Uri uri, String str2, String str3) {
        mo4433dK();
        C1957b bVar2 = bVar != null ? new C1957b(bVar) : null;
        try {
            ((C1952d) mo4435gS()).mo11333a(bVar2, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            bVar2.mo11318a(DataHolder.m593as(8), (String) null, (String) null);
        }
    }

    /* renamed from: a */
    public void mo11355a(BaseImplementation.C0270b<Status> bVar, Moment moment) {
        mo4433dK();
        C1956a aVar = bVar != null ? new C1956a(bVar) : null;
        try {
            ((C1952d) mo4435gS()).mo11335a((C1946b) aVar, C1380jp.m5180a((C1636nv) moment));
        } catch (RemoteException e) {
            if (aVar == null) {
                throw new IllegalStateException(e);
            }
            aVar.mo11319aB(new Status(8, (String) null, (PendingIntent) null));
        }
    }

    /* renamed from: a */
    public void mo11356a(BaseImplementation.C0270b<People.LoadPeopleResult> bVar, Collection<String> collection) {
        mo4433dK();
        C1960e eVar = new C1960e(bVar);
        try {
            ((C1952d) mo4435gS()).mo11338a((C1946b) eVar, (List<String>) new ArrayList(collection));
        } catch (RemoteException e) {
            eVar.mo11317a(DataHolder.m593as(8), (String) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        Bundle nm = this.alj.mo11390nm();
        nm.putStringArray("request_visible_actions", this.alj.mo11383nf());
        kVar.mo4511a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.alj.mo11386ni(), this.alj.mo11385nh(), mo4434gR(), this.alj.getAccountName(), nm);
    }

    /* access modifiers changed from: protected */
    /* renamed from: bH */
    public C1952d mo3832j(IBinder iBinder) {
        return C1952d.C1953a.m6598bG(iBinder);
    }

    /* renamed from: cd */
    public boolean mo11358cd(String str) {
        return Arrays.asList(mo4434gR()).contains(str);
    }

    public void clearDefaultAccount() {
        mo4433dK();
        try {
            this.ali = null;
            ((C1952d) mo4435gS()).clearDefaultAccount();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: d */
    public void mo11360d(BaseImplementation.C0270b<People.LoadPeopleResult> bVar, String[] strArr) {
        mo11356a(bVar, (Collection<String>) Arrays.asList(strArr));
    }

    public String getAccountName() {
        mo4433dK();
        try {
            return ((C1952d) mo4435gS()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        mo4433dK();
        return this.ali;
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.plus.service.START";
    }

    /* renamed from: k */
    public void mo11363k(BaseImplementation.C0270b<Moments.LoadMomentsResult> bVar) {
        mo11354a(bVar, 20, (String) null, (Uri) null, (String) null, "me");
    }

    /* renamed from: l */
    public void mo11364l(BaseImplementation.C0270b<People.LoadPeopleResult> bVar) {
        mo4433dK();
        C1960e eVar = new C1960e(bVar);
        try {
            ((C1952d) mo4435gS()).mo11330a(eVar, 2, 1, -1, (String) null);
        } catch (RemoteException e) {
            eVar.mo11317a(DataHolder.m593as(8), (String) null);
        }
    }

    /* renamed from: m */
    public void mo11365m(BaseImplementation.C0270b<Status> bVar) {
        mo4433dK();
        clearDefaultAccount();
        C1962g gVar = new C1962g(bVar);
        try {
            ((C1952d) mo4435gS()).mo11340b(gVar);
        } catch (RemoteException e) {
            gVar.mo11322h(8, (Bundle) null);
        }
    }

    /* renamed from: r */
    public C0333i mo11366r(BaseImplementation.C0270b<People.LoadPeopleResult> bVar, String str) {
        return mo11353a(bVar, 0, str);
    }

    public void removeMoment(String momentId) {
        mo4433dK();
        try {
            ((C1952d) mo4435gS()).removeMoment(momentId);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
