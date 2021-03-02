package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
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
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.common.api.bd */
public class C0733bd extends Fragment implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult> {

    /* renamed from: a */
    private boolean f4496a;

    /* renamed from: b */
    private int f4497b = -1;

    /* renamed from: c */
    private ConnectionResult f4498c;

    /* renamed from: d */
    private final Handler f4499d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final SparseArray<C0736bg> f4500e = new SparseArray<>();

    /* renamed from: a */
    public static C0733bd m4059a(FragmentActivity fragmentActivity) {
        C1009bf.m4535b("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            C0733bd bdVar = (C0733bd) supportFragmentManager.findFragmentByTag("GmsSupportLoaderLifecycleFragment");
            if (bdVar != null && !bdVar.isRemoving()) {
                return bdVar;
            }
            C0733bd bdVar2 = new C0733bd();
            supportFragmentManager.beginTransaction().add((Fragment) bdVar2, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return bdVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    /* renamed from: a */
    private void m4060a(int i, ConnectionResult connectionResult) {
        if (!this.f4496a) {
            this.f4496a = true;
            this.f4497b = i;
            this.f4498c = connectionResult;
            this.f4499d.post(new C0737bh(this, i, connectionResult));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4063b(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        C0736bg bgVar = this.f4500e.get(i);
        if (bgVar != null) {
            mo7424b(i);
            C0753r rVar = bgVar.f4505b;
            if (rVar != null) {
                rVar.onConnectionFailed(connectionResult);
            }
        }
        m4064l();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m4064l() {
        this.f4496a = false;
        this.f4497b = -1;
        this.f4498c = null;
        LoaderManager loaderManager = getLoaderManager();
        for (int i = 0; i < this.f4500e.size(); i++) {
            int keyAt = this.f4500e.keyAt(i);
            C0735bf c = mo7425c(keyAt);
            if (c != null && c.mo7427c()) {
                loaderManager.destroyLoader(keyAt);
                loaderManager.initLoader(keyAt, (Bundle) null, this);
            }
        }
    }

    /* renamed from: a */
    public C0749n mo7421a(int i) {
        C0735bf c;
        if (getActivity() == null || (c = mo7425c(i)) == null) {
            return null;
        }
        return c.f4501a;
    }

    /* renamed from: a */
    public void mo7422a(int i, C0749n nVar, C0753r rVar) {
        C1009bf.m4529a(nVar, (Object) "GoogleApiClient instance cannot be null");
        C1009bf.m4533a(this.f4500e.indexOfKey(i) < 0, (Object) "Already managing a GoogleApiClient with id " + i);
        this.f4500e.put(i, new C0736bg(nVar, rVar));
        if (getActivity() != null) {
            LoaderManager.enableDebugLogging(false);
            getLoaderManager().initLoader(i, (Bundle) null, this);
        }
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<ConnectionResult> loader, ConnectionResult connectionResult) {
        if (!connectionResult.mo7323b()) {
            m4060a(loader.getId(), connectionResult);
        }
    }

    /* renamed from: b */
    public void mo7424b(int i) {
        this.f4500e.remove(i);
        getLoaderManager().destroyLoader(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0735bf mo7425c(int i) {
        try {
            return (C0735bf) getLoaderManager().getLoader(i);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (com.google.android.gms.common.C0853e.m4237a((android.content.Context) getActivity()) == 0) goto L_0x0006;
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
            r3.m4064l()
        L_0x000b:
            return
        L_0x000c:
            android.support.v4.app.FragmentActivity r2 = r3.getActivity()
            int r2 = com.google.android.gms.common.C0853e.m4237a((android.content.Context) r2)
            if (r2 != 0) goto L_0x0005
            goto L_0x0006
        L_0x0017:
            r2 = -1
            if (r5 != r2) goto L_0x0005
            goto L_0x0006
        L_0x001b:
            int r0 = r3.f4497b
            com.google.android.gms.common.ConnectionResult r1 = r3.f4498c
            r3.m4063b(r0, r1)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.C0733bd.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4500e.size()) {
                int keyAt = this.f4500e.keyAt(i2);
                C0735bf c = mo7425c(keyAt);
                if (c == null || this.f4500e.valueAt(i2).f4504a == c.f4501a) {
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
        m4063b(this.f4497b, new ConnectionResult(13, (PendingIntent) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4496a = bundle.getBoolean("resolving_error", false);
            this.f4497b = bundle.getInt("failed_client_id", -1);
            if (this.f4497b >= 0) {
                this.f4498c = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public Loader<ConnectionResult> onCreateLoader(int i, Bundle bundle) {
        return new C0735bf(getActivity(), this.f4500e.get(i).f4504a);
    }

    public void onLoaderReset(Loader<ConnectionResult> loader) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f4496a);
        if (this.f4497b >= 0) {
            bundle.putInt("failed_client_id", this.f4497b);
            bundle.putInt("failed_status", this.f4498c.mo7324c());
            bundle.putParcelable("failed_resolution", this.f4498c.mo7325d());
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.f4496a) {
            for (int i = 0; i < this.f4500e.size(); i++) {
                getLoaderManager().initLoader(this.f4500e.keyAt(i), (Bundle) null, this);
            }
        }
    }
}
