package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C0629a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.bg */
public class C0496bg {

    /* renamed from: fG */
    private final C0507bk<C0493bf> f1110fG;

    /* renamed from: fH */
    private ContentProviderClient f1111fH = null;

    /* renamed from: fI */
    private boolean f1112fI = false;

    /* renamed from: fJ */
    private HashMap<LocationListener, C0498b> f1113fJ = new HashMap<>();
    private final ContentResolver mContentResolver;

    /* renamed from: com.google.android.gms.internal.bg$a */
    private static class C0497a extends Handler {

        /* renamed from: fK */
        private final LocationListener f1114fK;

        public C0497a(LocationListener locationListener) {
            this.f1114fK = locationListener;
        }

        public C0497a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.f1114fK = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f1114fK.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bg$b */
    private static class C0498b extends C0629a.C0630a {

        /* renamed from: fL */
        private Handler f1115fL;

        C0498b(LocationListener locationListener, Looper looper) {
            this.f1115fL = looper == null ? new C0497a(locationListener) : new C0497a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.f1115fL == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.f1115fL.sendMessage(obtain);
        }

        public void release() {
            this.f1115fL = null;
        }
    }

    public C0496bg(Context context, C0507bk<C0493bf> bkVar) {
        this.f1110fG = bkVar;
        this.mContentResolver = context.getContentResolver();
    }

    /* renamed from: aR */
    public void mo4786aR() {
        if (this.f1112fI) {
            setMockMode(false);
        }
    }

    public Location getLastLocation() {
        this.f1110fG.mo4813B();
        try {
            return this.f1110fG.mo4814C().mo4780aQ();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.f1113fJ) {
                for (C0498b next : this.f1113fJ.values()) {
                    if (next != null) {
                        this.f1110fG.mo4814C().mo4777a((C0629a) next);
                    }
                }
                this.f1113fJ.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.f1110fG.mo4813B();
        try {
            this.f1110fG.mo4814C().mo4772a(callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.f1110fG.mo4813B();
        C0621s.m1887b(listener, (Object) "Invalid null listener");
        synchronized (this.f1113fJ) {
            C0498b remove = this.f1113fJ.remove(listener);
            if (this.f1111fH != null && this.f1113fJ.isEmpty()) {
                this.f1111fH.release();
                this.f1111fH = null;
            }
            if (remove != null) {
                remove.release();
                try {
                    this.f1110fG.mo4814C().mo4777a((C0629a) remove);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.f1110fG.mo4813B();
        try {
            this.f1110fG.mo4814C().mo4775a(request, callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.f1110fG.mo4813B();
        if (looper == null) {
            C0621s.m1887b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.f1113fJ) {
            C0498b bVar = this.f1113fJ.get(listener);
            C0498b bVar2 = bVar == null ? new C0498b(listener, looper) : bVar;
            this.f1113fJ.put(listener, bVar2);
            try {
                this.f1110fG.mo4814C().mo4776a(request, (C0629a) bVar2);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.f1110fG.mo4813B();
        try {
            this.f1110fG.mo4814C().setMockLocation(mockLocation);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.f1110fG.mo4813B();
        try {
            this.f1110fG.mo4814C().setMockMode(isMockMode);
            this.f1112fI = isMockMode;
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
