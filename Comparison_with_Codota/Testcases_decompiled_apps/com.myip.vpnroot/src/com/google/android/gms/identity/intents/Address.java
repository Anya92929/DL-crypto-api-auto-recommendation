package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1502ll;

public final class Address {
    public static final Api<AddressOptions> API = new Api<>(f2399CV, f2398CU, new Scope[0]);

    /* renamed from: CU */
    static final Api.C0268c<C1502ll> f2398CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1502ll, AddressOptions> f2399CV = new Api.C0267b<C1502ll, AddressOptions>() {
        /* renamed from: a */
        public C1502ll mo3762a(Context context, Looper looper, ClientSettings clientSettings, AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            C0348n.m859b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new C1502ll((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };

    public static final class AddressOptions implements Api.ApiOptions.HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme2) {
            this.theme = theme2;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address$a */
    private static abstract class C0875a extends BaseImplementation.C0269a<Status, C1502ll> {
        public C0875a() {
            super(Address.f2398CU);
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.mo4219a(new C0875a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1502ll llVar) throws RemoteException {
                llVar.mo9223a(request, requestCode);
                mo4196b(Status.f591Jo);
            }
        });
    }
}
