package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1009bf;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.common.api.ba */
public class C0730ba extends Fragment implements DialogInterface.OnCancelListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f4483a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f4484b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f4485c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ConnectionResult f4486d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f4487e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private final SparseArray<C0731bb> f4488f = new SparseArray<>();

    /* renamed from: a */
    public static C0730ba m4045a(FragmentActivity fragmentActivity) {
        C1009bf.m4535b("Must be called from main thread of process");
        try {
            C0730ba baVar = (C0730ba) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFragment");
            if (baVar == null || baVar.isRemoving()) {
                return null;
            }
            return baVar;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4046a(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        C0731bb bbVar = this.f4488f.get(i);
        if (bbVar != null) {
            mo7415a(i);
            C0753r rVar = bbVar.f4491c;
            if (rVar != null) {
                rVar.onConnectionFailed(connectionResult);
            }
        }
        m4054l();
    }

    /* renamed from: b */
    public static C0730ba m4050b(FragmentActivity fragmentActivity) {
        C0730ba a = m4045a(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (a != null) {
            return a;
        }
        C0730ba baVar = new C0730ba();
        supportFragmentManager.beginTransaction().add((Fragment) baVar, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return baVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m4054l() {
        int i = 0;
        this.f4484b = false;
        this.f4485c = -1;
        this.f4486d = null;
        while (true) {
            int i2 = i;
            if (i2 < this.f4488f.size()) {
                this.f4488f.valueAt(i2).f4490b.mo7372a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo7415a(int i) {
        C0731bb bbVar = this.f4488f.get(i);
        this.f4488f.remove(i);
        if (bbVar != null) {
            bbVar.mo7418a();
        }
    }

    /* renamed from: a */
    public void mo7416a(int i, C0749n nVar, C0753r rVar) {
        C1009bf.m4529a(nVar, (Object) "GoogleApiClient instance cannot be null");
        C1009bf.m4533a(this.f4488f.indexOfKey(i) < 0, (Object) "Already managing a GoogleApiClient with id " + i);
        this.f4488f.put(i, new C0731bb(this, i, nVar, rVar));
        if (this.f4483a && !this.f4484b) {
            nVar.mo7372a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4488f.size()) {
                this.f4488f.valueAt(i2).mo7419a(str, fileDescriptor, printWriter, strArr);
                i = i2 + 1;
            } else {
                return;
            }
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
            r3.m4054l()
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
            int r0 = r3.f4485c
            com.google.android.gms.common.ConnectionResult r1 = r3.f4486d
            r3.m4046a((int) r0, (com.google.android.gms.common.ConnectionResult) r1)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.C0730ba.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        m4046a(this.f4485c, new ConnectionResult(13, (PendingIntent) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4484b = bundle.getBoolean("resolving_error", false);
            this.f4485c = bundle.getInt("failed_client_id", -1);
            if (this.f4485c >= 0) {
                this.f4486d = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f4484b);
        if (this.f4485c >= 0) {
            bundle.putInt("failed_client_id", this.f4485c);
            bundle.putInt("failed_status", this.f4486d.mo7324c());
            bundle.putParcelable("failed_resolution", this.f4486d.mo7325d());
        }
    }

    public void onStart() {
        super.onStart();
        this.f4483a = true;
        if (!this.f4484b) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f4488f.size()) {
                    this.f4488f.valueAt(i2).f4490b.mo7372a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onStop() {
        int i = 0;
        super.onStop();
        this.f4483a = false;
        while (true) {
            int i2 = i;
            if (i2 < this.f4488f.size()) {
                this.f4488f.valueAt(i2).f4490b.mo7380b();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
