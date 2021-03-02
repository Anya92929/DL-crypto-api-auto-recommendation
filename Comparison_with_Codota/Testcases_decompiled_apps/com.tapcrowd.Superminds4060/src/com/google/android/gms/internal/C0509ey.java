package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C0625a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ey */
public class C0509ey {
    private final Context mContext;

    /* renamed from: oO */
    private final C0522fc<C0506ex> f1279oO;

    /* renamed from: oP */
    private ContentProviderClient f1280oP = null;

    /* renamed from: oQ */
    private boolean f1281oQ = false;

    /* renamed from: oR */
    private HashMap<LocationListener, C0511b> f1282oR = new HashMap<>();

    /* renamed from: com.google.android.gms.internal.ey$a */
    private static class C0510a extends Handler {

        /* renamed from: oS */
        private final LocationListener f1283oS;

        public C0510a(LocationListener locationListener) {
            this.f1283oS = locationListener;
        }

        public C0510a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.f1283oS = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f1283oS.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ey$b */
    private static class C0511b extends C0625a.C0626a {

        /* renamed from: oT */
        private Handler f1284oT;

        C0511b(LocationListener locationListener, Looper looper) {
            this.f1284oT = looper == null ? new C0510a(locationListener) : new C0510a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.f1284oT == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.f1284oT.sendMessage(obtain);
        }

        public void release() {
            this.f1284oT = null;
        }
    }

    public C0509ey(Context context, C0522fc<C0506ex> fcVar) {
        this.mContext = context;
        this.f1279oO = fcVar;
    }

    /* renamed from: cm */
    public void mo4732cm() {
        if (this.f1281oQ) {
            setMockMode(false);
        }
    }

    public Location getLastLocation() {
        this.f1279oO.mo4759bc();
        try {
            return this.f1279oO.mo4760bd().mo4726cl();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.f1282oR) {
                for (C0511b next : this.f1282oR.values()) {
                    if (next != null) {
                        this.f1279oO.mo4760bd().mo4723a((C0625a) next);
                    }
                }
                this.f1282oR.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.f1279oO.mo4759bc();
        try {
            this.f1279oO.mo4760bd().mo4717a(callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.f1279oO.mo4759bc();
        C0411dm.m940a(listener, (Object) "Invalid null listener");
        synchronized (this.f1282oR) {
            C0511b remove = this.f1282oR.remove(listener);
            if (this.f1280oP != null && this.f1282oR.isEmpty()) {
                this.f1280oP.release();
                this.f1280oP = null;
            }
            if (remove != null) {
                remove.release();
                try {
                    this.f1279oO.mo4760bd().mo4723a((C0625a) remove);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.f1279oO.mo4759bc();
        try {
            this.f1279oO.mo4760bd().mo4720a(request, callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.f1279oO.mo4759bc();
        if (looper == null) {
            C0411dm.m940a(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.f1282oR) {
            C0511b bVar = this.f1282oR.get(listener);
            C0511b bVar2 = bVar == null ? new C0511b(listener, looper) : bVar;
            this.f1282oR.put(listener, bVar2);
            try {
                this.f1279oO.mo4760bd().mo4722a(request, (C0625a) bVar2, this.mContext.getPackageName());
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.f1279oO.mo4759bc();
        try {
            this.f1279oO.mo4760bd().setMockLocation(mockLocation);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.f1279oO.mo4759bc();
        try {
            this.f1279oO.mo4760bd().setMockMode(isMockMode);
            this.f1281oQ = isMockMode;
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
