package com.appbrain.p032a;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.appbrain.a.dt */
public final class C0885dt {

    /* renamed from: a */
    private static C0885dt f2351a;

    /* renamed from: b */
    private final Context f2352b;

    /* renamed from: c */
    private volatile C0888dw f2353c;

    /* renamed from: d */
    private CountDownLatch f2354d = new CountDownLatch(1);

    private C0885dt(Context context) {
        this.f2352b = context.getApplicationContext();
        new C0886du(this).mo3410a((Object[]) new Void[0]);
    }

    /* renamed from: a */
    static synchronized C0885dt m3847a(Context context) {
        C0885dt dtVar;
        synchronized (C0885dt.class) {
            if (f2351a == null) {
                f2351a = new C0885dt(context);
            }
            dtVar = f2351a;
        }
        return dtVar;
    }

    /* renamed from: a */
    private C0888dw m3848a() {
        this.f2352b.getPackageManager().getPackageInfo("com.android.vending", 0);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
        C0887dv dvVar = new C0887dv(this, linkedBlockingQueue);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!this.f2352b.bindService(intent, dvVar, 1)) {
            throw new IOException("Error connecting to Google Play Services");
        }
        try {
            IBinder iBinder = (IBinder) linkedBlockingQueue.take();
            return new C0888dw(m3849a(iBinder), m3851b(iBinder));
        } finally {
            this.f2352b.unbindService(dvVar);
        }
    }

    /* renamed from: a */
    private static String m3849a(IBinder iBinder) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3850a(C0885dt dtVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0888dw dwVar = null;
        if (!Debug.isDebuggerConnected()) {
            int i = 0;
            while (i < 3) {
                try {
                    dwVar = C0889dx.m3856a(dtVar.f2352b);
                    break;
                } catch (IOException e) {
                    Thread.sleep(500);
                    i++;
                } catch (Throwable th) {
                }
            }
        }
        if (dwVar == null) {
            try {
                dwVar = dtVar.m3848a();
            } catch (Exception e2) {
            }
        }
        dtVar.f2353c = dwVar;
        dtVar.f2354d.countDown();
        new StringBuilder("Fetch took ").append(SystemClock.elapsedRealtime() - elapsedRealtime);
    }

    /* renamed from: b */
    private static boolean m3851b(IBinder iBinder) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(1);
            iBinder.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* renamed from: a */
    public final C0888dw mo3764a(int i, TimeUnit timeUnit) {
        try {
            this.f2354d.await((long) i, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f2353c;
    }
}
