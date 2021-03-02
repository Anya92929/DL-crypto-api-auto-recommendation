package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzw extends Fragment implements DialogInterface.OnCancelListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f2802a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f2803b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f2804c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ConnectionResult f2805d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f2806e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private final SparseArray<C0716a> f2807f = new SparseArray<>();
    protected C1192hd zzaiD;

    /* renamed from: com.google.android.gms.common.api.internal.zzw$a */
    class C0716a implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: a */
        public final int f2808a;

        /* renamed from: b */
        public final GoogleApiClient f2809b;

        /* renamed from: c */
        public final GoogleApiClient.OnConnectionFailedListener f2810c;

        public C0716a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f2808a = i;
            this.f2809b = googleApiClient;
            this.f2810c = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        /* renamed from: a */
        public void mo5235a() {
            this.f2809b.unregisterConnectionFailedListener(this);
            this.f2809b.disconnect();
        }

        /* renamed from: a */
        public void mo5236a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.f2808a);
            printWriter.println(":");
            this.f2809b.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzw.this.f2806e.post(new C0717b(this.f2808a, connectionResult));
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzw$b */
    class C0717b implements Runnable {

        /* renamed from: b */
        private final int f2813b;

        /* renamed from: c */
        private final ConnectionResult f2814c;

        public C0717b(int i, ConnectionResult connectionResult) {
            this.f2813b = i;
            this.f2814c = connectionResult;
        }

        @MainThread
        public void run() {
            if (zzw.this.f2802a && !zzw.this.f2803b) {
                boolean unused = zzw.this.f2803b = true;
                int unused2 = zzw.this.f2804c = this.f2813b;
                ConnectionResult unused3 = zzw.this.f2805d = this.f2814c;
                if (this.f2814c.hasResolution()) {
                    try {
                        this.f2814c.startResolutionForResult(zzw.this.getActivity(), ((zzw.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzw.this) + 1) << 16) + 1);
                    } catch (IntentSender.SendIntentException e) {
                        zzw.this.zzpP();
                    }
                } else if (zzw.this.zzpQ().isUserResolvableError(this.f2814c.getErrorCode())) {
                    zzw.this.zzb(this.f2813b, this.f2814c);
                } else if (this.f2814c.getErrorCode() == 18) {
                    zzw.this.zzc(this.f2813b, this.f2814c);
                } else {
                    zzw.this.m3823a(this.f2813b, this.f2814c);
                }
            }
        }
    }

    /* renamed from: a */
    private static String m3822a(ConnectionResult connectionResult) {
        return connectionResult.getErrorMessage() + " (" + connectionResult.getErrorCode() + ": " + zze.getErrorString(connectionResult.getErrorCode()) + ')';
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3823a(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        C0716a aVar = this.f2807f.get(i);
        if (aVar != null) {
            zzbD(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = aVar.f2810c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzpP();
    }

    @Nullable
    /* renamed from: l */
    private static zzw m3829l() {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl");
        } catch (ClassNotFoundException | LinkageError | SecurityException e) {
            if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", e);
            }
            cls = null;
        }
        if (cls != null) {
            try {
                return (zzw) cls.newInstance();
            } catch (ExceptionInInitializerError | IllegalAccessException | InstantiationException | RuntimeException e2) {
                if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                    Log.d("GmsSupportLifecycleFrag", "Unable to instantiate SupportLifecycleFragmentImpl class", e2);
                }
            }
        }
        return null;
    }

    @Nullable
    public static zzw zza(FragmentActivity fragmentActivity) {
        zzx.zzcD("Must be called from main thread of process");
        try {
            zzw zzw = (zzw) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            if (zzw == null || zzw.isRemoving()) {
                return null;
            }
            return zzw;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    public static zzw zzb(FragmentActivity fragmentActivity) {
        zzw zza = zza(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (zza == null) {
            zza = m3829l();
            if (zza == null) {
                Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                zza = new zzw();
            }
            supportFragmentManager.beginTransaction().add((Fragment) zza, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        return zza;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2807f.size()) {
                this.f2807f.valueAt(i2).mo5236a(str, fileDescriptor, printWriter, strArr);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (zzpQ().isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            switch(r5) {
                case 1: goto L_0x001b;
                case 2: goto L_0x000c;
                default: goto L_0x0005;
            }
        L_0x0005:
            r0 = r1
        L_0x0006:
            if (r0 == 0) goto L_0x002b
            r4.zzpP()
        L_0x000b:
            return
        L_0x000c:
            com.google.android.gms.common.zzc r2 = r4.zzpQ()
            android.support.v4.app.FragmentActivity r3 = r4.getActivity()
            int r2 = r2.isGooglePlayServicesAvailable(r3)
            if (r2 != 0) goto L_0x0005
            goto L_0x0006
        L_0x001b:
            r2 = -1
            if (r6 == r2) goto L_0x0006
            if (r6 != 0) goto L_0x0005
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r2 = 13
            r3 = 0
            r0.<init>(r2, r3)
            r4.f2805d = r0
            goto L_0x0005
        L_0x002b:
            int r0 = r4.f2804c
            com.google.android.gms.common.ConnectionResult r1 = r4.f2805d
            r4.m3823a((int) r0, (com.google.android.gms.common.ConnectionResult) r1)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzw.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        m3823a(this.f2804c, new ConnectionResult(13, (PendingIntent) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2803b = bundle.getBoolean("resolving_error", false);
            this.f2804c = bundle.getInt("failed_client_id", -1);
            if (this.f2804c >= 0) {
                this.f2805d = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f2803b);
        if (this.f2804c >= 0) {
            bundle.putInt("failed_client_id", this.f2804c);
            bundle.putInt("failed_status", this.f2805d.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f2805d.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.f2802a = true;
        if (!this.f2803b) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2807f.size()) {
                    this.f2807f.valueAt(i2).f2809b.connect();
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
        this.f2802a = false;
        while (true) {
            int i2 = i;
            if (i2 < this.f2807f.size()) {
                this.f2807f.valueAt(i2).f2809b.disconnect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzx.zza(this.f2807f.indexOfKey(i) < 0, (Object) "Already managing a GoogleApiClient with id " + i);
        this.f2807f.put(i, new C0716a(i, googleApiClient, onConnectionFailedListener));
        if (this.f2802a && !this.f2803b) {
            googleApiClient.connect();
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + m3822a(connectionResult));
        m3823a(i, connectionResult);
    }

    public void zzbD(int i) {
        C0716a aVar = this.f2807f.get(i);
        this.f2807f.remove(i);
        if (aVar != null) {
            aVar.mo5235a();
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        m3823a(i, connectionResult);
    }

    /* access modifiers changed from: protected */
    public void zzpP() {
        int i = 0;
        this.f2803b = false;
        this.f2804c = -1;
        this.f2805d = null;
        if (this.zzaiD != null) {
            this.zzaiD.mo8270b();
            this.zzaiD = null;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.f2807f.size()) {
                this.f2807f.valueAt(i2).f2809b.connect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzc zzpQ() {
        return zzc.zzoK();
    }
}
