package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0597k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.l */
public final class C0604l implements Handler.Callback {

    /* renamed from: bJ */
    private static final Object f1412bJ = new Object();

    /* renamed from: bK */
    private static C0604l f1413bK;

    /* renamed from: bL */
    private final Context f1414bL;
    /* access modifiers changed from: private */

    /* renamed from: bM */
    public final HashMap<String, C0605a> f1415bM = new HashMap<>();
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.l$a */
    final class C0605a {

        /* renamed from: bN */
        private final String f1416bN;

        /* renamed from: bO */
        private final C0606a f1417bO = new C0606a();
        /* access modifiers changed from: private */

        /* renamed from: bP */
        public final HashSet<C0597k<?>.e> f1418bP = new HashSet<>();

        /* renamed from: bQ */
        private boolean f1419bQ;
        /* access modifiers changed from: private */

        /* renamed from: bR */
        public IBinder f1420bR;
        /* access modifiers changed from: private */

        /* renamed from: bS */
        public ComponentName f1421bS;
        /* access modifiers changed from: private */
        public int mState = 0;

        /* renamed from: com.google.android.gms.internal.l$a$a */
        public class C0606a implements ServiceConnection {
            public C0606a() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (C0604l.this.f1415bM) {
                    IBinder unused = C0605a.this.f1420bR = binder;
                    ComponentName unused2 = C0605a.this.f1421bS = component;
                    Iterator it = C0605a.this.f1418bP.iterator();
                    while (it.hasNext()) {
                        ((C0597k.C0602e) it.next()).onServiceConnected(component, binder);
                    }
                    int unused3 = C0605a.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (C0604l.this.f1415bM) {
                    IBinder unused = C0605a.this.f1420bR = null;
                    ComponentName unused2 = C0605a.this.f1421bS = component;
                    Iterator it = C0605a.this.f1418bP.iterator();
                    while (it.hasNext()) {
                        ((C0597k.C0602e) it.next()).onServiceDisconnected(component);
                    }
                    int unused3 = C0605a.this.mState = 2;
                }
            }
        }

        public C0605a(String str) {
            this.f1416bN = str;
        }

        /* renamed from: F */
        public C0606a mo5446F() {
            return this.f1417bO;
        }

        /* renamed from: G */
        public String mo5447G() {
            return this.f1416bN;
        }

        /* renamed from: H */
        public boolean mo5448H() {
            return this.f1418bP.isEmpty();
        }

        /* renamed from: a */
        public void mo5449a(C0597k<?>.e eVar) {
            this.f1418bP.add(eVar);
        }

        /* renamed from: b */
        public void mo5450b(C0597k<?>.e eVar) {
            this.f1418bP.remove(eVar);
        }

        /* renamed from: b */
        public void mo5451b(boolean z) {
            this.f1419bQ = z;
        }

        /* renamed from: c */
        public boolean mo5452c(C0597k<?>.e eVar) {
            return this.f1418bP.contains(eVar);
        }

        public IBinder getBinder() {
            return this.f1420bR;
        }

        public ComponentName getComponentName() {
            return this.f1421bS;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.f1419bQ;
        }
    }

    private C0604l(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.f1414bL = context.getApplicationContext();
    }

    /* renamed from: g */
    public static C0604l m1824g(Context context) {
        synchronized (f1412bJ) {
            if (f1413bK == null) {
                f1413bK = new C0604l(context.getApplicationContext());
            }
        }
        return f1413bK;
    }

    /* renamed from: a */
    public boolean mo5443a(String str, C0597k<?>.e eVar) {
        boolean isBound;
        synchronized (this.f1415bM) {
            C0605a aVar = this.f1415bM.get(str);
            if (aVar != null) {
                this.mHandler.removeMessages(0, aVar);
                if (!aVar.mo5452c(eVar)) {
                    aVar.mo5449a(eVar);
                    switch (aVar.getState()) {
                        case 1:
                            eVar.onServiceConnected(aVar.getComponentName(), aVar.getBinder());
                            break;
                        case 2:
                            aVar.mo5451b(this.f1414bL.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo5446F(), 129));
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
                }
            } else {
                aVar = new C0605a(str);
                aVar.mo5449a(eVar);
                aVar.mo5451b(this.f1414bL.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo5446F(), 129));
                this.f1415bM.put(str, aVar);
            }
            isBound = aVar.isBound();
        }
        return isBound;
    }

    /* renamed from: b */
    public void mo5444b(String str, C0597k<?>.e eVar) {
        synchronized (this.f1415bM) {
            C0605a aVar = this.f1415bM.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (!aVar.mo5452c(eVar)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            } else {
                aVar.mo5450b(eVar);
                if (aVar.mo5448H()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, aVar), 5000);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0605a aVar = (C0605a) msg.obj;
                synchronized (this.f1415bM) {
                    if (aVar.mo5448H()) {
                        this.f1414bL.unbindService(aVar.mo5446F());
                        this.f1415bM.remove(aVar.mo5447G());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
