package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.LoaderManager;
import android.support.p000v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0348n;

/* renamed from: com.google.android.gms.common.api.d */
public class C0285d extends Fragment implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult> {

    /* renamed from: Ju */
    private boolean f632Ju;

    /* renamed from: Jv */
    private int f633Jv = -1;

    /* renamed from: Jw */
    private ConnectionResult f634Jw;

    /* renamed from: Jx */
    private final Handler f635Jx = new Handler(Looper.getMainLooper());

    /* renamed from: Jy */
    private final SparseArray<C0288b> f636Jy = new SparseArray<>();

    /* renamed from: com.google.android.gms.common.api.d$a */
    static class C0287a extends Loader<ConnectionResult> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: JA */
        private boolean f637JA;

        /* renamed from: JB */
        private ConnectionResult f638JB;

        /* renamed from: Jz */
        public final GoogleApiClient f639Jz;

        public C0287a(Context context, GoogleApiClient googleApiClient) {
            super(context);
            this.f639Jz = googleApiClient;
        }

        /* renamed from: a */
        private void m582a(ConnectionResult connectionResult) {
            this.f638JB = connectionResult;
            if (isStarted() && !isAbandoned()) {
                deliverResult(connectionResult);
            }
        }

        /* renamed from: gw */
        public void mo4290gw() {
            if (this.f637JA) {
                this.f637JA = false;
                if (isStarted() && !isAbandoned()) {
                    this.f639Jz.connect();
                }
            }
        }

        public void onConnected(Bundle connectionHint) {
            this.f637JA = false;
            m582a(ConnectionResult.f541HE);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f637JA = true;
            m582a(result);
        }

        public void onConnectionSuspended(int cause) {
        }

        /* access modifiers changed from: protected */
        public void onReset() {
            this.f638JB = null;
            this.f637JA = false;
            this.f639Jz.unregisterConnectionCallbacks(this);
            this.f639Jz.unregisterConnectionFailedListener(this);
            this.f639Jz.disconnect();
        }

        /* access modifiers changed from: protected */
        public void onStartLoading() {
            super.onStartLoading();
            this.f639Jz.registerConnectionCallbacks(this);
            this.f639Jz.registerConnectionFailedListener(this);
            if (this.f638JB != null) {
                deliverResult(this.f638JB);
            }
            if (!this.f639Jz.isConnected() && !this.f639Jz.isConnecting() && !this.f637JA) {
                this.f639Jz.connect();
            }
        }

        /* access modifiers changed from: protected */
        public void onStopLoading() {
            this.f639Jz.disconnect();
        }
    }

    /* renamed from: com.google.android.gms.common.api.d$b */
    private static class C0288b {

        /* renamed from: JC */
        public final GoogleApiClient.OnConnectionFailedListener f640JC;

        /* renamed from: Jz */
        public final GoogleApiClient f641Jz;

        private C0288b(GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f641Jz = googleApiClient;
            this.f640JC = onConnectionFailedListener;
        }
    }

    /* renamed from: com.google.android.gms.common.api.d$c */
    private class C0289c implements Runnable {

        /* renamed from: JD */
        private final int f642JD;

        /* renamed from: JE */
        private final ConnectionResult f643JE;

        public C0289c(int i, ConnectionResult connectionResult) {
            this.f642JD = i;
            this.f643JE = connectionResult;
        }

        public void run() {
            if (this.f643JE.hasResolution()) {
                try {
                    this.f643JE.startResolutionForResult(C0285d.this.getActivity(), ((C0285d.this.getActivity().getSupportFragmentManager().getFragments().indexOf(C0285d.this) + 1) << 16) + 1);
                } catch (IntentSender.SendIntentException e) {
                    C0285d.this.m576gv();
                }
            } else if (GooglePlayServicesUtil.isUserRecoverableError(this.f643JE.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.f643JE.getErrorCode(), C0285d.this.getActivity(), C0285d.this, 2, C0285d.this);
            } else {
                C0285d.this.m575b(this.f642JD, this.f643JE);
            }
        }
    }

    /* renamed from: a */
    public static C0285d m570a(FragmentActivity fragmentActivity) {
        C0348n.m854aT("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            C0285d dVar = (C0285d) supportFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
            if (dVar != null && !dVar.isRemoving()) {
                return dVar;
            }
            C0285d dVar2 = new C0285d();
            supportFragmentManager.beginTransaction().add((Fragment) dVar2, "GmsSupportLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return dVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* renamed from: a */
    private void m571a(int i, ConnectionResult connectionResult) {
        if (!this.f632Ju) {
            this.f632Ju = true;
            this.f633Jv = i;
            this.f634Jw = connectionResult;
            this.f635Jx.post(new C0289c(i, connectionResult));
        }
    }

    /* renamed from: an */
    private void m574an(int i) {
        if (i == this.f633Jv) {
            m576gv();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m575b(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        C0288b bVar = this.f636Jy.get(i);
        if (bVar != null) {
            mo4287al(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = bVar.f640JC;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        m576gv();
    }

    /* access modifiers changed from: private */
    /* renamed from: gv */
    public void m576gv() {
        this.f632Ju = false;
        this.f633Jv = -1;
        this.f634Jw = null;
        LoaderManager loaderManager = getLoaderManager();
        for (int i = 0; i < this.f636Jy.size(); i++) {
            int keyAt = this.f636Jy.keyAt(i);
            C0287a am = mo4288am(keyAt);
            if (am != null) {
                am.mo4290gw();
            }
            loaderManager.initLoader(keyAt, (Bundle) null, this);
        }
    }

    /* renamed from: a */
    public void mo4284a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        C0348n.m857b(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        C0348n.m852a(this.f636Jy.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.f636Jy.put(i, new C0288b(googleApiClient, onConnectionFailedListener));
        if (getActivity() != null) {
            getLoaderManager().initLoader(i, (Bundle) null, this);
        }
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<ConnectionResult> loader, ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            m574an(loader.getId());
        } else {
            m571a(loader.getId(), connectionResult);
        }
    }

    /* renamed from: ak */
    public GoogleApiClient mo4286ak(int i) {
        C0287a am;
        if (getActivity() == null || (am = mo4288am(i)) == null) {
            return null;
        }
        return am.f639Jz;
    }

    /* renamed from: al */
    public void mo4287al(int i) {
        getLoaderManager().destroyLoader(i);
        this.f636Jy.remove(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: am */
    public C0287a mo4288am(int i) {
        try {
            return (C0287a) getLoaderManager().getLoader(i);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", e);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r5 == -1) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            switch(r4) {
                case 1: goto L_0x0017;
                case 2: goto L_0x000c;
                default: goto L_0x0005;
            }
        L_0x0005:
            r0 = r1
        L_0x0006:
            if (r0 == 0) goto L_0x001b
            r3.m576gv()
        L_0x000b:
            return
        L_0x000c:
            android.support.v4.app.FragmentActivity r2 = r3.getActivity()
            int r2 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r2)
            if (r2 != 0) goto L_0x0005
            goto L_0x0006
        L_0x0017:
            r2 = -1
            if (r5 != r2) goto L_0x0005
            goto L_0x0006
        L_0x001b:
            int r0 = r3.f633Jv
            com.google.android.gms.common.ConnectionResult r1 = r3.f634Jw
            r3.m575b(r0, r1)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.C0285d.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f636Jy.size()) {
                int keyAt = this.f636Jy.keyAt(i2);
                C0287a am = mo4288am(keyAt);
                if (am == null || this.f636Jy.valueAt(i2).f641Jz == am.f639Jz) {
                    getLoaderManager().initLoader(keyAt, (Bundle) null, this);
                } else {
                    getLoaderManager().restartLoader(keyAt, (Bundle) null, this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        m575b(this.f633Jv, this.f634Jw);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.f632Ju = savedInstanceState.getBoolean("resolving_error", false);
            this.f633Jv = savedInstanceState.getInt("failed_client_id", -1);
            if (this.f633Jv >= 0) {
                this.f634Jw = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    public Loader<ConnectionResult> onCreateLoader(int id, Bundle args) {
        return new C0287a(getActivity(), this.f636Jy.get(id).f641Jz);
    }

    public void onLoaderReset(Loader<ConnectionResult> loader) {
        if (loader.getId() == this.f633Jv) {
            m576gv();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.f632Ju);
        if (this.f633Jv >= 0) {
            outState.putInt("failed_client_id", this.f633Jv);
            outState.putInt("failed_status", this.f634Jw.getErrorCode());
            outState.putParcelable("failed_resolution", this.f634Jw.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.f632Ju) {
            for (int i = 0; i < this.f636Jy.size(); i++) {
                getLoaderManager().initLoader(this.f636Jy.keyAt(i), (Bundle) null, this);
            }
        }
    }
}
