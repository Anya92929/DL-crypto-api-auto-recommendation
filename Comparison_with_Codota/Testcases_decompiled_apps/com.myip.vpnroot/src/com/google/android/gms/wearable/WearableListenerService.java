package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.C2237ae;
import com.google.android.gms.wearable.internal.C2248ah;
import com.google.android.gms.wearable.internal.C2257ak;

public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    /* access modifiers changed from: private */

    /* renamed from: BZ */
    public String f4656BZ;

    /* renamed from: LR */
    private IBinder f4657LR;

    /* renamed from: NP */
    private volatile int f4658NP = -1;
    /* access modifiers changed from: private */
    public Handler auR;
    /* access modifiers changed from: private */
    public Object auS = new Object();
    /* access modifiers changed from: private */
    public boolean auT;

    /* renamed from: com.google.android.gms.wearable.WearableListenerService$a */
    private class C2220a extends C2237ae.C2238a {
        private C2220a() {
        }

        /* renamed from: Z */
        public void mo12290Z(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.this.f4656BZ + ": " + dataHolder);
            }
            WearableListenerService.this.m7475pS();
            synchronized (WearableListenerService.this.auS) {
                if (WearableListenerService.this.auT) {
                    dataHolder.close();
                } else {
                    WearableListenerService.this.auR.post(new Runnable() {
                        public void run() {
                            DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                            try {
                                WearableListenerService.this.onDataChanged(dataEventBuffer);
                            } finally {
                                dataEventBuffer.release();
                            }
                        }
                    });
                }
            }
        }

        /* renamed from: a */
        public void mo12291a(final C2248ah ahVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + ahVar);
            }
            WearableListenerService.this.m7475pS();
            synchronized (WearableListenerService.this.auS) {
                if (!WearableListenerService.this.auT) {
                    WearableListenerService.this.auR.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onMessageReceived(ahVar);
                        }
                    });
                }
            }
        }

        /* renamed from: a */
        public void mo12292a(final C2257ak akVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.this.f4656BZ + ": " + akVar);
            }
            WearableListenerService.this.m7475pS();
            synchronized (WearableListenerService.this.auS) {
                if (!WearableListenerService.this.auT) {
                    WearableListenerService.this.auR.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onPeerConnected(akVar);
                        }
                    });
                }
            }
        }

        /* renamed from: b */
        public void mo12293b(final C2257ak akVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.this.f4656BZ + ": " + akVar);
            }
            WearableListenerService.this.m7475pS();
            synchronized (WearableListenerService.this.auS) {
                if (!WearableListenerService.this.auT) {
                    WearableListenerService.this.auR.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onPeerDisconnected(akVar);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: bc */
    private boolean m7471bc(int i) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (String equals : packagesForUid) {
            if (GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: pS */
    public void m7475pS() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f4658NP) {
            if (!GooglePlayServicesUtil.m470b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) || !m7471bc(callingUid)) {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
            this.f4658NP = callingUid;
        }
    }

    public final IBinder onBind(Intent intent) {
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            return this.f4657LR;
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.f4656BZ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.auR = new Handler(handlerThread.getLooper());
        this.f4657LR = new C2220a();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        synchronized (this.auS) {
            this.auT = true;
            this.auR.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
