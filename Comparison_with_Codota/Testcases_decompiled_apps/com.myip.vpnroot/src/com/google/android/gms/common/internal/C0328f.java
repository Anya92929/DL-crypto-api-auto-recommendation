package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0316d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.google.android.gms.common.internal.f */
public final class C0328f implements Handler.Callback {

    /* renamed from: LK */
    private static final Object f775LK = new Object();

    /* renamed from: LL */
    private static C0328f f776LL;
    /* access modifiers changed from: private */

    /* renamed from: LM */
    public final HashMap<String, C0329a> f777LM = new HashMap<>();

    /* renamed from: mD */
    private final Context f778mD;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.common.internal.f$a */
    final class C0329a {

        /* renamed from: LN */
        private final String f779LN;

        /* renamed from: LO */
        private final C0330a f780LO = new C0330a();
        /* access modifiers changed from: private */

        /* renamed from: LP */
        public final HashSet<C0316d<?>.f> f781LP = new HashSet<>();

        /* renamed from: LQ */
        private boolean f782LQ;
        /* access modifiers changed from: private */

        /* renamed from: LR */
        public IBinder f783LR;
        /* access modifiers changed from: private */

        /* renamed from: LS */
        public ComponentName f784LS;
        /* access modifiers changed from: private */
        public int mState = 0;

        /* renamed from: com.google.android.gms.common.internal.f$a$a */
        public class C0330a implements ServiceConnection {
            public C0330a() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (C0328f.this.f777LM) {
                    IBinder unused = C0329a.this.f783LR = binder;
                    ComponentName unused2 = C0329a.this.f784LS = component;
                    Iterator it = C0329a.this.f781LP.iterator();
                    while (it.hasNext()) {
                        ((C0316d.C0322f) it.next()).onServiceConnected(component, binder);
                    }
                    int unused3 = C0329a.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (C0328f.this.f777LM) {
                    IBinder unused = C0329a.this.f783LR = null;
                    ComponentName unused2 = C0329a.this.f784LS = component;
                    Iterator it = C0329a.this.f781LP.iterator();
                    while (it.hasNext()) {
                        ((C0316d.C0322f) it.next()).onServiceDisconnected(component);
                    }
                    int unused3 = C0329a.this.mState = 2;
                }
            }
        }

        public C0329a(String str) {
            this.f779LN = str;
        }

        /* renamed from: J */
        public void mo4475J(boolean z) {
            this.f782LQ = z;
        }

        /* renamed from: a */
        public void mo4476a(C0316d<?>.f fVar) {
            this.f781LP.add(fVar);
        }

        /* renamed from: b */
        public void mo4477b(C0316d<?>.f fVar) {
            this.f781LP.remove(fVar);
        }

        /* renamed from: c */
        public boolean mo4478c(C0316d<?>.f fVar) {
            return this.f781LP.contains(fVar);
        }

        /* renamed from: gW */
        public C0330a mo4479gW() {
            return this.f780LO;
        }

        /* renamed from: gX */
        public String mo4480gX() {
            return this.f779LN;
        }

        /* renamed from: gY */
        public boolean mo4481gY() {
            return this.f781LP.isEmpty();
        }

        public IBinder getBinder() {
            return this.f783LR;
        }

        public ComponentName getComponentName() {
            return this.f784LS;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.f782LQ;
        }
    }

    private C0328f(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.f778mD = context.getApplicationContext();
    }

    /* renamed from: J */
    public static C0328f m730J(Context context) {
        synchronized (f775LK) {
            if (f776LL == null) {
                f776LL = new C0328f(context.getApplicationContext());
            }
        }
        return f776LL;
    }

    /* renamed from: a */
    public boolean mo4472a(String str, C0316d<?>.f fVar) {
        boolean isBound;
        synchronized (this.f777LM) {
            C0329a aVar = this.f777LM.get(str);
            if (aVar != null) {
                this.mHandler.removeMessages(0, aVar);
                if (!aVar.mo4478c(fVar)) {
                    aVar.mo4476a(fVar);
                    switch (aVar.getState()) {
                        case 1:
                            fVar.onServiceConnected(aVar.getComponentName(), aVar.getBinder());
                            break;
                        case 2:
                            aVar.mo4475J(this.f778mD.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo4479gW(), 129));
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
                }
            } else {
                aVar = new C0329a(str);
                aVar.mo4476a(fVar);
                aVar.mo4475J(this.f778mD.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo4479gW(), 129));
                this.f777LM.put(str, aVar);
            }
            isBound = aVar.isBound();
        }
        return isBound;
    }

    /* renamed from: b */
    public void mo4473b(String str, C0316d<?>.f fVar) {
        synchronized (this.f777LM) {
            C0329a aVar = this.f777LM.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (!aVar.mo4478c(fVar)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            } else {
                aVar.mo4477b(fVar);
                if (aVar.mo4481gY()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, aVar), 5000);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0329a aVar = (C0329a) msg.obj;
                synchronized (this.f777LM) {
                    if (aVar.mo4481gY()) {
                        this.f778mD.unbindService(aVar.mo4479gW());
                        this.f777LM.remove(aVar.mo4480gX());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
