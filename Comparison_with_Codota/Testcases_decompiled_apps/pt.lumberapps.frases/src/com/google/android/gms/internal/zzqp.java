package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzqp extends zzpn {

    /* renamed from: e */
    private TaskCompletionSource f6916e = new TaskCompletionSource();

    private zzqp(zzqk zzqk) {
        super(zzqk);
        this.f6908d.zza("GmsAvailabilityHelper", (zzqj) this);
    }

    public static zzqp zzu(Activity activity) {
        zzqk a = m7513a(activity);
        zzqp zzqp = (zzqp) a.zza("GmsAvailabilityHelper", zzqp.class);
        if (zzqp == null) {
            return new zzqp(a);
        }
        if (!zzqp.f6916e.getTask().isComplete()) {
            return zzqp;
        }
        zzqp.f6916e = new TaskCompletionSource();
        return zzqp;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8900a() {
        int isGooglePlayServicesAvailable = this.f6787c.isGooglePlayServicesAvailable(this.f6908d.zzaqt());
        if (isGooglePlayServicesAvailable == 0) {
            this.f6916e.setResult((Object) null);
        } else {
            zzk(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8901a(ConnectionResult connectionResult, int i) {
        this.f6916e.setException(new Exception());
    }

    public Task getTask() {
        return this.f6916e.getTask();
    }

    public void onStop() {
        super.onStop();
        this.f6916e.setException(new CancellationException());
    }

    public void zzk(ConnectionResult connectionResult) {
        zzb(connectionResult, 0);
    }
}
