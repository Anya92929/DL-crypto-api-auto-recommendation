package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0336j;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.internal.C1329in;
import com.google.android.gms.internal.C1332io;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.gms.internal.ij */
public final class C1317ij extends C0316d<C1329in> {
    /* access modifiers changed from: private */

    /* renamed from: GL */
    public static final Object f3976GL = new Object();
    /* access modifiers changed from: private */

    /* renamed from: GM */
    public static final Object f3977GM = new Object();
    /* access modifiers changed from: private */

    /* renamed from: Gr */
    public static final C1334ip f3978Gr = new C1334ip("CastClientImpl");
    /* access modifiers changed from: private */

    /* renamed from: EO */
    public final Cast.Listener f3979EO;

    /* renamed from: FA */
    private double f3980FA;

    /* renamed from: FB */
    private boolean f3981FB;

    /* renamed from: GA */
    private boolean f3982GA;

    /* renamed from: GB */
    private int f3983GB;

    /* renamed from: GC */
    private int f3984GC;

    /* renamed from: GD */
    private final AtomicLong f3985GD = new AtomicLong(0);
    /* access modifiers changed from: private */

    /* renamed from: GE */
    public String f3986GE;
    /* access modifiers changed from: private */

    /* renamed from: GF */
    public String f3987GF;

    /* renamed from: GG */
    private Bundle f3988GG;
    /* access modifiers changed from: private */

    /* renamed from: GH */
    public Map<Long, BaseImplementation.C0270b<Status>> f3989GH = new HashMap();

    /* renamed from: GI */
    private C1320b f3990GI;
    /* access modifiers changed from: private */

    /* renamed from: GJ */
    public BaseImplementation.C0270b<Cast.ApplicationConnectionResult> f3991GJ;
    /* access modifiers changed from: private */

    /* renamed from: GK */
    public BaseImplementation.C0270b<Status> f3992GK;
    /* access modifiers changed from: private */

    /* renamed from: Gs */
    public ApplicationMetadata f3993Gs;
    /* access modifiers changed from: private */

    /* renamed from: Gt */
    public final CastDevice f3994Gt;
    /* access modifiers changed from: private */

    /* renamed from: Gu */
    public final Map<String, Cast.MessageReceivedCallback> f3995Gu = new HashMap();

    /* renamed from: Gv */
    private final long f3996Gv;

    /* renamed from: Gw */
    private C1321c f3997Gw;

    /* renamed from: Gx */
    private String f3998Gx;

    /* renamed from: Gy */
    private boolean f3999Gy;

    /* renamed from: Gz */
    private boolean f4000Gz;
    /* access modifiers changed from: private */
    public final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.ij$a */
    private static final class C1319a implements Cast.ApplicationConnectionResult {

        /* renamed from: CM */
        private final Status f4001CM;

        /* renamed from: GN */
        private final ApplicationMetadata f4002GN;

        /* renamed from: GO */
        private final String f4003GO;

        /* renamed from: GP */
        private final boolean f4004GP;

        /* renamed from: vL */
        private final String f4005vL;

        public C1319a(Status status) {
            this(status, (ApplicationMetadata) null, (String) null, (String) null, false);
        }

        public C1319a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.f4001CM = status;
            this.f4002GN = applicationMetadata;
            this.f4003GO = str;
            this.f4005vL = str2;
            this.f4004GP = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.f4002GN;
        }

        public String getApplicationStatus() {
            return this.f4003GO;
        }

        public String getSessionId() {
            return this.f4005vL;
        }

        public Status getStatus() {
            return this.f4001CM;
        }

        public boolean getWasLaunched() {
            return this.f4004GP;
        }
    }

    /* renamed from: com.google.android.gms.internal.ij$b */
    private class C1320b implements GoogleApiClient.OnConnectionFailedListener {
        private C1320b() {
        }

        public void onConnectionFailed(ConnectionResult result) {
            C1317ij.this.m4942fG();
        }
    }

    /* renamed from: com.google.android.gms.internal.ij$c */
    private class C1321c extends C1332io.C1333a {

        /* renamed from: GR */
        private AtomicBoolean f4008GR;

        private C1321c() {
            this.f4008GR = new AtomicBoolean(false);
        }

        /* renamed from: ag */
        private boolean m4968ag(int i) {
            synchronized (C1317ij.f3977GM) {
                if (C1317ij.this.f3992GK == null) {
                    return false;
                }
                C1317ij.this.f3992GK.mo4196b(new Status(i));
                BaseImplementation.C0270b unused = C1317ij.this.f3992GK = null;
                return true;
            }
        }

        /* renamed from: c */
        private void m4969c(long j, int i) {
            BaseImplementation.C0270b bVar;
            synchronized (C1317ij.this.f3989GH) {
                bVar = (BaseImplementation.C0270b) C1317ij.this.f3989GH.remove(Long.valueOf(j));
            }
            if (bVar != null) {
                bVar.mo4196b(new Status(i));
            }
        }

        /* renamed from: a */
        public void mo8857a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            if (!this.f4008GR.get()) {
                ApplicationMetadata unused = C1317ij.this.f3993Gs = applicationMetadata;
                String unused2 = C1317ij.this.f3986GE = applicationMetadata.getApplicationId();
                String unused3 = C1317ij.this.f3987GF = str2;
                synchronized (C1317ij.f3976GL) {
                    if (C1317ij.this.f3991GJ != null) {
                        C1317ij.this.f3991GJ.mo4196b(new C1319a(new Status(0), applicationMetadata, str, str2, z));
                        BaseImplementation.C0270b unused4 = C1317ij.this.f3991GJ = null;
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo8858a(String str, double d, boolean z) {
            C1317ij.f3978Gr.mo8910b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        /* renamed from: a */
        public void mo8859a(String str, long j) {
            if (!this.f4008GR.get()) {
                m4969c(j, 0);
            }
        }

        /* renamed from: a */
        public void mo8860a(String str, long j, int i) {
            if (!this.f4008GR.get()) {
                m4969c(j, i);
            }
        }

        /* renamed from: ac */
        public void mo8861ac(int i) {
            if (mo8868fL()) {
                C1317ij.f3978Gr.mo8910b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    C1317ij.this.mo4431aA(2);
                }
            }
        }

        /* renamed from: ad */
        public void mo8862ad(int i) {
            if (!this.f4008GR.get()) {
                synchronized (C1317ij.f3976GL) {
                    if (C1317ij.this.f3991GJ != null) {
                        C1317ij.this.f3991GJ.mo4196b(new C1319a(new Status(i)));
                        BaseImplementation.C0270b unused = C1317ij.this.f3991GJ = null;
                    }
                }
            }
        }

        /* renamed from: ae */
        public void mo8863ae(int i) {
            if (!this.f4008GR.get()) {
                m4968ag(i);
            }
        }

        /* renamed from: af */
        public void mo8864af(int i) {
            if (!this.f4008GR.get()) {
                m4968ag(i);
            }
        }

        /* renamed from: b */
        public void mo8865b(final C1314ig igVar) {
            if (!this.f4008GR.get()) {
                C1317ij.f3978Gr.mo8910b("onApplicationStatusChanged", new Object[0]);
                C1317ij.this.mHandler.post(new Runnable() {
                    public void run() {
                        C1317ij.this.m4928a(igVar);
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo8866b(final C1327il ilVar) {
            if (!this.f4008GR.get()) {
                C1317ij.f3978Gr.mo8910b("onDeviceStatusChanged", new Object[0]);
                C1317ij.this.mHandler.post(new Runnable() {
                    public void run() {
                        C1317ij.this.m4931a(ilVar);
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo8867b(String str, byte[] bArr) {
            if (!this.f4008GR.get()) {
                C1317ij.f3978Gr.mo8910b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        /* renamed from: fL */
        public boolean mo8868fL() {
            if (this.f4008GR.getAndSet(true)) {
                return false;
            }
            C1317ij.this.m4941fC();
            return true;
        }

        /* renamed from: fM */
        public boolean mo8869fM() {
            return this.f4008GR.get();
        }

        /* renamed from: k */
        public void mo8870k(final String str, final String str2) {
            if (!this.f4008GR.get()) {
                C1317ij.f3978Gr.mo8910b("Receive (type=text, ns=%s) %s", str, str2);
                C1317ij.this.mHandler.post(new Runnable() {
                    public void run() {
                        Cast.MessageReceivedCallback messageReceivedCallback;
                        synchronized (C1317ij.this.f3995Gu) {
                            messageReceivedCallback = (Cast.MessageReceivedCallback) C1317ij.this.f3995Gu.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(C1317ij.this.f3994Gt, str, str2);
                            return;
                        }
                        C1317ij.f3978Gr.mo8910b("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }

        public void onApplicationDisconnected(final int statusCode) {
            if (!this.f4008GR.get()) {
                String unused = C1317ij.this.f3986GE = null;
                String unused2 = C1317ij.this.f3987GF = null;
                m4968ag(statusCode);
                if (C1317ij.this.f3979EO != null) {
                    C1317ij.this.mHandler.post(new Runnable() {
                        public void run() {
                            if (C1317ij.this.f3979EO != null) {
                                C1317ij.this.f3979EO.onApplicationDisconnected(statusCode);
                            }
                        }
                    });
                }
            }
        }
    }

    public C1317ij(Context context, Looper looper, CastDevice castDevice, long j, Cast.Listener listener, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.f3994Gt = castDevice;
        this.f3979EO = listener;
        this.f3996Gv = j;
        this.mHandler = new Handler(looper);
        m4941fC();
        this.f3990GI = new C1320b();
        registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this.f3990GI);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4928a(C1314ig igVar) {
        boolean z;
        String fz = igVar.mo8826fz();
        if (!C1326ik.m4984a(fz, this.f3998Gx)) {
            this.f3998Gx = fz;
            z = true;
        } else {
            z = false;
        }
        f3978Gr.mo8910b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.f3999Gy));
        if (this.f3979EO != null && (z || this.f3999Gy)) {
            this.f3979EO.onApplicationStatusChanged();
        }
        this.f3999Gy = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4931a(C1327il ilVar) {
        boolean z;
        boolean z2;
        boolean z3;
        this.f3993Gs = ilVar.getApplicationMetadata();
        double fF = ilVar.mo8878fF();
        if (fF == Double.NaN || fF == this.f3980FA) {
            z = false;
        } else {
            this.f3980FA = fF;
            z = true;
        }
        boolean fN = ilVar.mo8879fN();
        if (fN != this.f3981FB) {
            this.f3981FB = fN;
            z = true;
        }
        f3978Gr.mo8910b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.f4000Gz));
        if (this.f3979EO != null && (z || this.f4000Gz)) {
            this.f3979EO.onVolumeChanged();
        }
        int fO = ilVar.mo8880fO();
        if (fO != this.f3983GB) {
            this.f3983GB = fO;
            z2 = true;
        } else {
            z2 = false;
        }
        f3978Gr.mo8910b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.f4000Gz));
        if (this.f3979EO != null && (z2 || this.f4000Gz)) {
            this.f3979EO.mo3928W(this.f3983GB);
        }
        int fP = ilVar.mo8881fP();
        if (fP != this.f3984GC) {
            this.f3984GC = fP;
            z3 = true;
        } else {
            z3 = false;
        }
        f3978Gr.mo8910b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.f4000Gz));
        if (this.f3979EO != null && (z3 || this.f4000Gz)) {
            this.f3979EO.mo3929X(this.f3984GC);
        }
        this.f4000Gz = false;
    }

    /* renamed from: c */
    private void m4935c(BaseImplementation.C0270b<Cast.ApplicationConnectionResult> bVar) {
        synchronized (f3976GL) {
            if (this.f3991GJ != null) {
                this.f3991GJ.mo4196b(new C1319a(new Status(2002)));
            }
            this.f3991GJ = bVar;
        }
    }

    /* renamed from: e */
    private void m4939e(BaseImplementation.C0270b<Status> bVar) {
        synchronized (f3977GM) {
            if (this.f3992GK != null) {
                bVar.mo4196b(new Status(2001));
            } else {
                this.f3992GK = bVar;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fC */
    public void m4941fC() {
        this.f3982GA = false;
        this.f3983GB = -1;
        this.f3984GC = -1;
        this.f3993Gs = null;
        this.f3998Gx = null;
        this.f3980FA = 0.0d;
        this.f3981FB = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: fG */
    public void m4942fG() {
        f3978Gr.mo8910b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.f3995Gu) {
            this.f3995Gu.clear();
        }
    }

    /* renamed from: fH */
    private void m4943fH() throws IllegalStateException {
        if (!this.f3982GA || this.f3997Gw == null || this.f3997Gw.mo8869fM()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* renamed from: G */
    public void mo8841G(boolean z) throws IllegalStateException, RemoteException {
        ((C1329in) mo4435gS()).mo8894a(z, this.f3980FA, this.f3981FB);
    }

    /* access modifiers changed from: protected */
    /* renamed from: L */
    public C1329in mo3832j(IBinder iBinder) {
        return C1329in.C1330a.m5009M(iBinder);
    }

    /* renamed from: a */
    public void mo8843a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((C1329in) mo4435gS()).mo8890a(d, this.f3980FA, this.f3981FB);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4429a(int i, IBinder iBinder, Bundle bundle) {
        f3978Gr.mo8910b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.f3982GA = true;
            this.f3999Gy = true;
            this.f4000Gz = true;
        } else {
            this.f3982GA = false;
        }
        if (i == 1001) {
            this.f3988GG = new Bundle();
            this.f3988GG.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.mo4429a(i, iBinder, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        f3978Gr.mo8910b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.f3986GE, this.f3987GF);
        this.f3994Gt.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f3996Gv);
        if (this.f3986GE != null) {
            bundle.putString("last_application_id", this.f3986GE);
            if (this.f3987GF != null) {
                bundle.putString("last_session_id", this.f3987GF);
            }
        }
        this.f3997Gw = new C1321c();
        kVar.mo4506a((C0336j) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f3997Gw.asBinder(), bundle);
    }

    /* renamed from: a */
    public void mo8844a(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        C1326ik.m4985aF(str);
        mo8849aE(str);
        if (messageReceivedCallback != null) {
            synchronized (this.f3995Gu) {
                this.f3995Gu.put(str, messageReceivedCallback);
            }
            ((C1329in) mo4435gS()).mo8896aI(str);
        }
    }

    /* renamed from: a */
    public void mo8845a(String str, LaunchOptions launchOptions, BaseImplementation.C0270b<Cast.ApplicationConnectionResult> bVar) throws IllegalStateException, RemoteException {
        m4935c(bVar);
        ((C1329in) mo4435gS()).mo8891a(str, launchOptions);
    }

    /* renamed from: a */
    public void mo8846a(String str, BaseImplementation.C0270b<Status> bVar) throws IllegalStateException, RemoteException {
        m4939e(bVar);
        ((C1329in) mo4435gS()).mo8895aH(str);
    }

    /* renamed from: a */
    public void mo8847a(String str, String str2, BaseImplementation.C0270b<Status> bVar) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            C1326ik.m4985aF(str);
            m4943fH();
            long incrementAndGet = this.f3985GD.incrementAndGet();
            try {
                this.f3989GH.put(Long.valueOf(incrementAndGet), bVar);
                ((C1329in) mo4435gS()).mo8892a(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.f3989GH.remove(Long.valueOf(incrementAndGet));
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void mo8848a(String str, boolean z, BaseImplementation.C0270b<Cast.ApplicationConnectionResult> bVar) throws IllegalStateException, RemoteException {
        m4935c(bVar);
        ((C1329in) mo4435gS()).mo8899f(str, z);
    }

    /* renamed from: aE */
    public void mo8849aE(String str) throws IllegalArgumentException, RemoteException {
        Cast.MessageReceivedCallback remove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.f3995Gu) {
            remove = this.f3995Gu.remove(str);
        }
        if (remove != null) {
            try {
                ((C1329in) mo4435gS()).mo8897aJ(str);
            } catch (IllegalStateException e) {
                f3978Gr.mo8908a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    /* renamed from: b */
    public void mo8850b(String str, String str2, BaseImplementation.C0270b<Cast.ApplicationConnectionResult> bVar) throws IllegalStateException, RemoteException {
        m4935c(bVar);
        ((C1329in) mo4435gS()).mo8902l(str, str2);
    }

    /* renamed from: d */
    public void mo8851d(BaseImplementation.C0270b<Status> bVar) throws IllegalStateException, RemoteException {
        m4939e(bVar);
        ((C1329in) mo4435gS()).mo8901fQ();
    }

    public void disconnect() {
        f3978Gr.mo8910b("disconnect(); ServiceListener=%s, isConnected=%b", this.f3997Gw, Boolean.valueOf(isConnected()));
        C1321c cVar = this.f3997Gw;
        this.f3997Gw = null;
        if (cVar == null || !cVar.mo8868fL()) {
            f3978Gr.mo8910b("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        m4942fG();
        try {
            if (isConnected() || isConnecting()) {
                ((C1329in) mo4435gS()).disconnect();
            }
        } catch (RemoteException e) {
            f3978Gr.mo8908a(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        } finally {
            super.disconnect();
        }
    }

    /* renamed from: fD */
    public Bundle mo4273fD() {
        if (this.f3988GG == null) {
            return super.mo4273fD();
        }
        Bundle bundle = this.f3988GG;
        this.f3988GG = null;
        return bundle;
    }

    /* renamed from: fE */
    public void mo8852fE() throws IllegalStateException, RemoteException {
        ((C1329in) mo4435gS()).mo8900fE();
    }

    /* renamed from: fF */
    public double mo8853fF() throws IllegalStateException {
        m4943fH();
        return this.f3980FA;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        m4943fH();
        return this.f3993Gs;
    }

    public String getApplicationStatus() throws IllegalStateException {
        m4943fH();
        return this.f3998Gx;
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public boolean isMute() throws IllegalStateException {
        m4943fH();
        return this.f3981FB;
    }
}
