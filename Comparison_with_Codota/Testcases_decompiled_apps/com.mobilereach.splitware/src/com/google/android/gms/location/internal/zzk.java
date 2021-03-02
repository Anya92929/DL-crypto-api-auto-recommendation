package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;
import java.util.HashMap;
import java.util.Map;

public class zzk {
    private final Context mContext;
    private ContentProviderClient zzaOG = null;
    private boolean zzaOH = false;
    private Map<LocationCallback, zza> zzaOI = new HashMap();
    private final zzp<zzi> zzaOt;
    private Map<LocationListener, zzc> zzaxd = new HashMap();

    private static class zza extends zzc.zza {
        private Handler zzaOJ;

        zza(final LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzx.zza(looper != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaOJ = new Handler(looper) {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 0:
                            locationCallback.onLocationResult((LocationResult) msg.obj);
                            return;
                        case 1:
                            locationCallback.onLocationAvailability((LocationAvailability) msg.obj);
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        private void zzb(int i, Object obj) {
            if (this.zzaOJ == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.zzaOJ.sendMessage(obtain);
        }

        public void onLocationAvailability(LocationAvailability state) {
            zzb(1, state);
        }

        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public void release() {
            this.zzaOJ = null;
        }
    }

    private static class zzb extends Handler {
        private final LocationListener zzaOL;

        public zzb(LocationListener locationListener) {
            this.zzaOL = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.zzaOL = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzaOL.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class zzc extends zzd.zza {
        private Handler zzaOJ;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzx.zza(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaOJ = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.zzaOJ == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.zzaOJ.sendMessage(obtain);
        }

        public void release() {
            this.zzaOJ = null;
        }
    }

    public zzk(Context context, zzp<zzi> zzp) {
        this.mContext = context;
        this.zzaOt = zzp;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza zza2;
        synchronized (this.zzaOI) {
            zza2 = this.zzaOI.get(locationCallback);
            if (zza2 == null) {
                zza2 = new zza(locationCallback, looper);
            }
            this.zzaOI.put(locationCallback, zza2);
        }
        return zza2;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc zzc2;
        synchronized (this.zzaxd) {
            zzc2 = this.zzaxd.get(locationListener);
            if (zzc2 == null) {
                zzc2 = new zzc(locationListener, looper);
            }
            this.zzaxd.put(locationListener, zzc2);
        }
        return zzc2;
    }

    public Location getLastLocation() {
        this.zzaOt.zzqI();
        try {
            return this.zzaOt.zzqJ().zzei(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.zzaxd) {
                for (zzc next : this.zzaxd.values()) {
                    if (next != null) {
                        this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza((zzd) next, (zzg) null));
                    }
                }
                this.zzaxd.clear();
            }
            synchronized (this.zzaOI) {
                for (zza next2 : this.zzaOI.values()) {
                    if (next2 != null) {
                        this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza((com.google.android.gms.location.zzc) next2, (zzg) null));
                    }
                }
                this.zzaOI.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zza(PendingIntent pendingIntent, zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zzb(pendingIntent, zzg));
    }

    public void zza(LocationCallback locationCallback, zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        zzx.zzb(locationCallback, (Object) "Invalid null callback");
        synchronized (this.zzaOI) {
            zza remove = this.zzaOI.remove(locationCallback);
            if (remove != null) {
                remove.release();
                this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza((com.google.android.gms.location.zzc) remove, zzg));
            }
        }
    }

    public void zza(LocationListener locationListener, zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        zzx.zzb(locationListener, (Object) "Invalid null listener");
        synchronized (this.zzaxd) {
            zzc remove = this.zzaxd.remove(locationListener);
            if (this.zzaOG != null && this.zzaxd.isEmpty()) {
                this.zzaOG.release();
                this.zzaOG = null;
            }
            if (remove != null) {
                remove.release();
                this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza((zzd) remove, zzg));
            }
        }
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), pendingIntent, zzg));
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), (zzd) zza(locationListener, looper), zzg));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zza(LocationRequestUpdateData.zza(locationRequestInternal, (com.google.android.gms.location.zzc) zza(locationCallback, looper), zzg));
    }

    public void zza(zzg zzg) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zza(zzg);
    }

    public void zzam(boolean z) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zzam(z);
        this.zzaOH = z;
    }

    public void zzc(Location location) throws RemoteException {
        this.zzaOt.zzqI();
        this.zzaOt.zzqJ().zzc(location);
    }

    public LocationAvailability zzyO() {
        this.zzaOt.zzqI();
        try {
            return this.zzaOt.zzqJ().zzej(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzyP() {
        if (this.zzaOH) {
            try {
                zzam(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
