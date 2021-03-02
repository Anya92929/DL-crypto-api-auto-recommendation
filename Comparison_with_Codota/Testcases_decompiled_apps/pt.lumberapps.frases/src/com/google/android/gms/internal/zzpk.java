package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzpk extends zzpn {

    /* renamed from: e */
    private final SparseArray f6779e = new SparseArray();

    private zzpk(zzqk zzqk) {
        super(zzqk);
        this.f6908d.zza("AutoManageHelper", (zzqj) this);
    }

    public static zzpk zza(zzqi zzqi) {
        zzqk a = m7514a(zzqi);
        zzpk zzpk = (zzpk) a.zza("AutoManageHelper", zzpk.class);
        return zzpk != null ? zzpk : new zzpk(a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8900a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f6779e.size()) {
                ((C1789oc) this.f6779e.valueAt(i2)).f5418b.connect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8901a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C1789oc ocVar = (C1789oc) this.f6779e.get(i);
        if (ocVar != null) {
            zzfh(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = ocVar.f5419c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f6779e.size()) {
                ((C1789oc) this.f6779e.valueAt(i2)).mo7601a(str, fileDescriptor, printWriter, strArr);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.f6785a;
        String valueOf = String.valueOf(this.f6779e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.f6786b) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f6779e.size()) {
                    ((C1789oc) this.f6779e.valueAt(i2)).f5418b.connect();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f6779e.size()) {
                ((C1789oc) this.f6779e.valueAt(i2)).f5418b.disconnect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzab.zza(this.f6779e.indexOfKey(i) < 0, (Object) new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i).toString());
        Log.d("AutoManageHelper", new StringBuilder(54).append("starting AutoManage for client ").append(i).append(" ").append(this.f6785a).append(" ").append(this.f6786b).toString());
        this.f6779e.put(i, new C1789oc(this, i, googleApiClient, onConnectionFailedListener));
        if (this.f6785a && !this.f6786b) {
            String valueOf = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            googleApiClient.connect();
        }
    }

    public void zzfh(int i) {
        C1789oc ocVar = (C1789oc) this.f6779e.get(i);
        this.f6779e.remove(i);
        if (ocVar != null) {
            ocVar.mo7600a();
        }
    }
}
