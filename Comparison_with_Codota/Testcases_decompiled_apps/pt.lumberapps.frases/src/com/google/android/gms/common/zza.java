package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza implements ServiceConnection {

    /* renamed from: a */
    boolean f4746a = false;

    /* renamed from: b */
    private final BlockingQueue f4747b = new LinkedBlockingQueue();

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4747b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder zza(long j, TimeUnit timeUnit) {
        zzab.zzhj("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f4746a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f4746a = true;
        IBinder iBinder = (IBinder) this.f4747b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public IBinder zzanf() {
        zzab.zzhj("BlockingServiceConnection.getService() called on main thread");
        if (this.f4746a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f4746a = true;
        return (IBinder) this.f4747b.take();
    }
}
