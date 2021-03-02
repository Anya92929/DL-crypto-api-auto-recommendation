package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public abstract class zzpn extends zzqj implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    protected boolean f6785a;

    /* renamed from: b */
    protected boolean f6786b;

    /* renamed from: c */
    protected final GoogleApiAvailability f6787c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ConnectionResult f6788e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f6789f;

    /* renamed from: g */
    private final Handler f6790g;

    protected zzpn(zzqk zzqk) {
        this(zzqk, GoogleApiAvailability.getInstance());
    }

    zzpn(zzqk zzqk, GoogleApiAvailability googleApiAvailability) {
        super(zzqk);
        this.f6789f = -1;
        this.f6790g = new Handler(Looper.getMainLooper());
        this.f6787c = googleApiAvailability;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8900a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8901a(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8919b() {
        this.f6789f = -1;
        this.f6786b = false;
        this.f6788e = null;
        mo8900a();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            r4 = 18
            r2 = 13
            r0 = 1
            r1 = 0
            switch(r6) {
                case 1: goto L_0x0027;
                case 2: goto L_0x0010;
                default: goto L_0x0009;
            }
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 == 0) goto L_0x003d
            r5.mo8919b()
        L_0x000f:
            return
        L_0x0010:
            com.google.android.gms.common.GoogleApiAvailability r2 = r5.f6787c
            android.app.Activity r3 = r5.getActivity()
            int r2 = r2.isGooglePlayServicesAvailable(r3)
            if (r2 != 0) goto L_0x0047
        L_0x001c:
            com.google.android.gms.common.ConnectionResult r1 = r5.f6788e
            int r1 = r1.getErrorCode()
            if (r1 != r4) goto L_0x000a
            if (r2 != r4) goto L_0x000a
            goto L_0x000f
        L_0x0027:
            r3 = -1
            if (r7 == r3) goto L_0x000a
            if (r7 != 0) goto L_0x0009
            if (r8 == 0) goto L_0x0045
            java.lang.String r0 = "<<ResolutionFailureErrorDetail>>"
            int r0 = r8.getIntExtra(r0, r2)
        L_0x0034:
            com.google.android.gms.common.ConnectionResult r2 = new com.google.android.gms.common.ConnectionResult
            r3 = 0
            r2.<init>(r0, r3)
            r5.f6788e = r2
            goto L_0x0009
        L_0x003d:
            com.google.android.gms.common.ConnectionResult r0 = r5.f6788e
            int r1 = r5.f6789f
            r5.mo8901a(r0, r1)
            goto L_0x000f
        L_0x0045:
            r0 = r2
            goto L_0x0034
        L_0x0047:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpn.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo8901a(new ConnectionResult(13, (PendingIntent) null), this.f6789f);
        mo8919b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f6786b = bundle.getBoolean("resolving_error", false);
            if (this.f6786b) {
                this.f6789f = bundle.getInt("failed_client_id", -1);
                this.f6788e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f6786b);
        if (this.f6786b) {
            bundle.putInt("failed_client_id", this.f6789f);
            bundle.putInt("failed_status", this.f6788e.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f6788e.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.f6785a = true;
    }

    public void onStop() {
        super.onStop();
        this.f6785a = false;
    }

    public void zzb(ConnectionResult connectionResult, int i) {
        if (!this.f6786b) {
            this.f6786b = true;
            this.f6789f = i;
            this.f6788e = connectionResult;
            this.f6790g.post(new C1791oe(this));
        }
    }
}
