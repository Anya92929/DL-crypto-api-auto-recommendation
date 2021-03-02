package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.gms.common.internal.e */
public final class C0325e {
    /* access modifiers changed from: private */

    /* renamed from: LE */
    public final C0327b f769LE;
    /* access modifiers changed from: private */

    /* renamed from: LF */
    public final ArrayList<GoogleApiClient.ConnectionCallbacks> f770LF = new ArrayList<>();

    /* renamed from: LG */
    final ArrayList<GoogleApiClient.ConnectionCallbacks> f771LG = new ArrayList<>();

    /* renamed from: LH */
    private boolean f772LH = false;

    /* renamed from: LI */
    private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> f773LI = new ArrayList<>();
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.common.internal.e$a */
    final class C0326a extends Handler {
        public C0326a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (C0325e.this.f770LF) {
                    if (C0325e.this.f769LE.mo4274gr() && C0325e.this.f769LE.isConnected() && C0325e.this.f770LF.contains(msg.obj)) {
                        ((GoogleApiClient.ConnectionCallbacks) msg.obj).onConnected(C0325e.this.f769LE.mo4273fD());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    /* renamed from: com.google.android.gms.common.internal.e$b */
    public interface C0327b {
        /* renamed from: fD */
        Bundle mo4273fD();

        /* renamed from: gr */
        boolean mo4274gr();

        boolean isConnected();
    }

    public C0325e(Context context, Looper looper, C0327b bVar) {
        this.f769LE = bVar;
        this.mHandler = new C0326a(looper);
    }

    /* renamed from: aB */
    public void mo4461aB(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.f770LF) {
            this.f772LH = true;
            Iterator it = new ArrayList(this.f770LF).iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f769LE.mo4274gr()) {
                    break;
                } else if (this.f770LF.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f772LH = false;
        }
    }

    /* renamed from: b */
    public void mo4462b(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.f773LI) {
            Iterator it = new ArrayList(this.f773LI).iterator();
            while (it.hasNext()) {
                GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener = (GooglePlayServicesClient.OnConnectionFailedListener) it.next();
                if (this.f769LE.mo4274gr()) {
                    if (this.f773LI.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public void mo4463d(Bundle bundle) {
        boolean z = true;
        synchronized (this.f770LF) {
            C0348n.m850I(!this.f772LH);
            this.mHandler.removeMessages(1);
            this.f772LH = true;
            if (this.f771LG.size() != 0) {
                z = false;
            }
            C0348n.m850I(z);
            Iterator it = new ArrayList(this.f770LF).iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f769LE.mo4274gr() || !this.f769LE.isConnected()) {
                    break;
                } else if (!this.f771LG.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f771LG.clear();
            this.f772LH = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: dM */
    public void mo4464dM() {
        synchronized (this.f770LF) {
            mo4463d(this.f769LE.mo4273fD());
        }
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks listener) {
        boolean contains;
        C0348n.m861i(listener);
        synchronized (this.f770LF) {
            contains = this.f770LF.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        boolean contains;
        C0348n.m861i(listener);
        synchronized (this.f773LI) {
            contains = this.f773LI.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        C0348n.m861i(listener);
        synchronized (this.f770LF) {
            if (this.f770LF.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.f770LF.add(listener);
            }
        }
        if (this.f769LE.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        C0348n.m861i(listener);
        synchronized (this.f773LI) {
            if (this.f773LI.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.f773LI.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        C0348n.m861i(listener);
        synchronized (this.f770LF) {
            if (this.f770LF != null) {
                if (!this.f770LF.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.f772LH) {
                    this.f771LG.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        C0348n.m861i(listener);
        synchronized (this.f773LI) {
            if (this.f773LI != null && !this.f773LI.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }
}
