package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0387de;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.df */
public final class C0394df implements Handler.Callback {

    /* renamed from: kU */
    private static final Object f1117kU = new Object();

    /* renamed from: kV */
    private static C0394df f1118kV;

    /* renamed from: kW */
    private final Context f1119kW;
    /* access modifiers changed from: private */

    /* renamed from: kX */
    public final HashMap<String, C0395a> f1120kX = new HashMap<>();
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.df$a */
    final class C0395a {

        /* renamed from: kY */
        private final String f1121kY;

        /* renamed from: kZ */
        private final C0396a f1122kZ = new C0396a();
        /* access modifiers changed from: private */

        /* renamed from: la */
        public final HashSet<C0387de<?>.e> f1123la = new HashSet<>();

        /* renamed from: lb */
        private boolean f1124lb;
        /* access modifiers changed from: private */

        /* renamed from: lc */
        public IBinder f1125lc;
        /* access modifiers changed from: private */

        /* renamed from: ld */
        public ComponentName f1126ld;
        /* access modifiers changed from: private */
        public int mState = 0;

        /* renamed from: com.google.android.gms.internal.df$a$a */
        public class C0396a implements ServiceConnection {
            public C0396a() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (C0394df.this.f1120kX) {
                    IBinder unused = C0395a.this.f1125lc = binder;
                    ComponentName unused2 = C0395a.this.f1126ld = component;
                    Iterator it = C0395a.this.f1123la.iterator();
                    while (it.hasNext()) {
                        ((C0387de.C0392e) it.next()).onServiceConnected(component, binder);
                    }
                    int unused3 = C0395a.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (C0394df.this.f1120kX) {
                    IBinder unused = C0395a.this.f1125lc = null;
                    ComponentName unused2 = C0395a.this.f1126ld = component;
                    Iterator it = C0395a.this.f1123la.iterator();
                    while (it.hasNext()) {
                        ((C0387de.C0392e) it.next()).onServiceDisconnected(component);
                    }
                    int unused3 = C0395a.this.mState = 2;
                }
            }
        }

        public C0395a(String str) {
            this.f1121kY = str;
        }

        /* renamed from: a */
        public void mo4346a(C0387de<?>.e eVar) {
            this.f1123la.add(eVar);
        }

        /* renamed from: b */
        public void mo4347b(C0387de<?>.e eVar) {
            this.f1123la.remove(eVar);
        }

        /* renamed from: bg */
        public C0396a mo4348bg() {
            return this.f1122kZ;
        }

        /* renamed from: bh */
        public String mo4349bh() {
            return this.f1121kY;
        }

        /* renamed from: bi */
        public boolean mo4350bi() {
            return this.f1123la.isEmpty();
        }

        /* renamed from: c */
        public boolean mo4351c(C0387de<?>.e eVar) {
            return this.f1123la.contains(eVar);
        }

        public IBinder getBinder() {
            return this.f1125lc;
        }

        public ComponentName getComponentName() {
            return this.f1126ld;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.f1124lb;
        }

        /* renamed from: l */
        public void mo4356l(boolean z) {
            this.f1124lb = z;
        }
    }

    private C0394df(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.f1119kW = context.getApplicationContext();
    }

    /* renamed from: s */
    public static C0394df m876s(Context context) {
        synchronized (f1117kU) {
            if (f1118kV == null) {
                f1118kV = new C0394df(context.getApplicationContext());
            }
        }
        return f1118kV;
    }

    /* renamed from: a */
    public boolean mo4343a(String str, C0387de<?>.e eVar) {
        boolean isBound;
        synchronized (this.f1120kX) {
            C0395a aVar = this.f1120kX.get(str);
            if (aVar != null) {
                this.mHandler.removeMessages(0, aVar);
                if (!aVar.mo4351c(eVar)) {
                    aVar.mo4346a(eVar);
                    switch (aVar.getState()) {
                        case 1:
                            eVar.onServiceConnected(aVar.getComponentName(), aVar.getBinder());
                            break;
                        case 2:
                            aVar.mo4356l(this.f1119kW.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo4348bg(), 129));
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
                }
            } else {
                aVar = new C0395a(str);
                aVar.mo4346a(eVar);
                aVar.mo4356l(this.f1119kW.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo4348bg(), 129));
                this.f1120kX.put(str, aVar);
            }
            isBound = aVar.isBound();
        }
        return isBound;
    }

    /* renamed from: b */
    public void mo4344b(String str, C0387de<?>.e eVar) {
        synchronized (this.f1120kX) {
            C0395a aVar = this.f1120kX.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (!aVar.mo4351c(eVar)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            } else {
                aVar.mo4347b(eVar);
                if (aVar.mo4350bi()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, aVar), 5000);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0395a aVar = (C0395a) msg.obj;
                synchronized (this.f1120kX) {
                    if (aVar.mo4350bi()) {
                        this.f1119kW.unbindService(aVar.mo4348bg());
                        this.f1120kX.remove(aVar.mo4349bh());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
