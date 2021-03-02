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
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.location.C1753a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.lx */
public class C1541lx {

    /* renamed from: Dh */
    private final C1555md<C1538lw> f4274Dh;
    private ContentProviderClient aeG = null;
    private boolean aeH = false;
    private HashMap<LocationListener, C1543b> aeI = new HashMap<>();
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.lx$a */
    private static class C1542a extends Handler {
        private final LocationListener aeJ;

        public C1542a(LocationListener locationListener) {
            this.aeJ = locationListener;
        }

        public C1542a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.aeJ = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.aeJ.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.lx$b */
    private static class C1543b extends C1753a.C1754a {
        private Handler aeK;

        C1543b(LocationListener locationListener, Looper looper) {
            this.aeK = looper == null ? new C1542a(locationListener) : new C1542a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.aeK == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.aeK.sendMessage(obtain);
        }

        public void release() {
            this.aeK = null;
        }
    }

    public C1541lx(Context context, C1555md<C1538lw> mdVar) {
        this.mContext = context;
        this.f4274Dh = mdVar;
    }

    /* renamed from: a */
    private C1543b m5556a(LocationListener locationListener, Looper looper) {
        C1543b bVar;
        if (looper == null) {
            C0348n.m857b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.aeI) {
            bVar = this.aeI.get(locationListener);
            if (bVar == null) {
                bVar = new C1543b(locationListener, looper);
            }
            this.aeI.put(locationListener, bVar);
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo9318a(C1550lz lzVar, LocationListener locationListener, Looper looper) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().mo9287a(lzVar, (C1753a) m5556a(locationListener, looper));
    }

    /* renamed from: b */
    public void mo9319b(C1550lz lzVar, PendingIntent pendingIntent) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().mo9286a(lzVar, pendingIntent);
    }

    public Location getLastLocation() {
        this.f4274Dh.mo9349dK();
        try {
            return this.f4274Dh.mo9350gS().mo9308bT(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: lW */
    public void mo9321lW() {
        if (this.aeH) {
            try {
                setMockMode(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.aeI) {
                for (C1543b next : this.aeI.values()) {
                    if (next != null) {
                        this.f4274Dh.mo9350gS().mo9298a((C1753a) next);
                    }
                }
                this.aeI.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().mo9282a(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.f4274Dh.mo9349dK();
        C0348n.m857b(listener, (Object) "Invalid null listener");
        synchronized (this.aeI) {
            C1543b remove = this.aeI.remove(listener);
            if (this.aeG != null && this.aeI.isEmpty()) {
                this.aeG.release();
                this.aeG = null;
            }
            if (remove != null) {
                remove.release();
                this.f4274Dh.mo9350gS().mo9298a((C1753a) remove);
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().mo9295a(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().mo9296a(request, (C1753a) m5556a(listener, looper));
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.f4274Dh.mo9349dK();
        this.f4274Dh.mo9350gS().setMockMode(isMockMode);
        this.aeH = isMockMode;
    }
}
