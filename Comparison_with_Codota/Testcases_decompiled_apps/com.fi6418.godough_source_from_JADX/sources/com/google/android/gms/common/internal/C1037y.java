package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0743h;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.api.C0756u;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.y */
public abstract class C1037y<T extends IInterface> implements C0743h, C0986aj {

    /* renamed from: c */
    public static final String[] f4766c = {"service_esmobile", "service_googleme"};

    /* renamed from: a */
    final Handler f4767a;

    /* renamed from: b */
    protected AtomicInteger f4768b;

    /* renamed from: d */
    private final Context f4769d;

    /* renamed from: e */
    private final C1032t f4770e;

    /* renamed from: f */
    private final Looper f4771f;

    /* renamed from: g */
    private final C0987ak f4772g;

    /* renamed from: h */
    private final C0772b f4773h;

    /* renamed from: i */
    private final Object f4774i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0999aw f4775j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C0756u f4776k;

    /* renamed from: l */
    private T f4777l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final ArrayList<C1037y<T>.com/google/android/gms/common/internal/ab<?>> f4778m;

    /* renamed from: n */
    private C1037y<T>.C0980ad f4779n;

    /* renamed from: o */
    private int f4780o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final Set<Scope> f4781p;

    /* renamed from: q */
    private final Account f4782q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final C0752q f4783r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final C0753r f4784s;

    /* renamed from: t */
    private final int f4785t;

    protected C1037y(Context context, Looper looper, int i, C1032t tVar, C0752q qVar, C0753r rVar) {
        this(context, looper, C0987ak.m4389a(context), C0772b.m4180a(), i, tVar, (C0752q) C1009bf.m4528a(qVar), (C0753r) C1009bf.m4528a(rVar));
    }

    protected C1037y(Context context, Looper looper, C0987ak akVar, C0772b bVar, int i, C1032t tVar, C0752q qVar, C0753r rVar) {
        this.f4774i = new Object();
        this.f4778m = new ArrayList<>();
        this.f4780o = 1;
        this.f4768b = new AtomicInteger(0);
        this.f4769d = (Context) C1009bf.m4529a(context, (Object) "Context must not be null");
        this.f4771f = (Looper) C1009bf.m4529a(looper, (Object) "Looper must not be null");
        this.f4772g = (C0987ak) C1009bf.m4529a(akVar, (Object) "Supervisor must not be null");
        this.f4773h = (C0772b) C1009bf.m4529a(bVar, (Object) "API availability must not be null");
        this.f4767a = new C0977aa(this, looper);
        this.f4785t = i;
        this.f4770e = (C1032t) C1009bf.m4528a(tVar);
        this.f4782q = tVar.mo7631b();
        this.f4781p = m4652b(tVar.mo7634e());
        this.f4783r = qVar;
        this.f4784s = rVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4649a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f4774i) {
            if (this.f4780o != i) {
                z = false;
            } else {
                m4653b(i2, t);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    private Set<Scope> m4652b(Set<Scope> set) {
        Set<Scope> a = mo7645a(set);
        if (a == null) {
            return a;
        }
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4653b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        C1009bf.m4536b(z);
        synchronized (this.f4774i) {
            this.f4780o = i;
            this.f4777l = t;
            mo7615a(i, t);
            switch (i) {
                case 1:
                    mo9018q();
                    break;
                case 2:
                    mo7891p();
                    break;
                case 3:
                    mo7653g();
                    break;
            }
        }
    }

    /* renamed from: p */
    private void mo7891p() {
        if (this.f4779n != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + mo7616d());
            this.f4772g.mo7528b(mo7616d(), this.f4779n, mo7652f());
            this.f4768b.incrementAndGet();
        }
        this.f4779n = new C0980ad(this, this.f4768b.get());
        if (!this.f4772g.mo7527a(mo7616d(), this.f4779n, mo7652f())) {
            Log.e("GmsClient", "unable to connect to service: " + mo7616d());
            this.f4767a.sendMessage(this.f4767a.obtainMessage(3, this.f4768b.get(), 9));
        }
    }

    /* renamed from: q */
    private void mo9018q() {
        if (this.f4779n != null) {
            this.f4772g.mo7528b(mo7616d(), this.f4779n, mo7652f());
            this.f4779n = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo7614a(IBinder iBinder);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Set<Scope> mo7645a(Set<Scope> set) {
        return set;
    }

    /* renamed from: a */
    public void mo7432a() {
        this.f4768b.incrementAndGet();
        synchronized (this.f4778m) {
            int size = this.f4778m.size();
            for (int i = 0; i < size; i++) {
                this.f4778m.get(i).mo7506e();
            }
            this.f4778m.clear();
        }
        m4653b(1, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7646a(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7647a(int i, Bundle bundle, int i2) {
        this.f4767a.sendMessage(this.f4767a.obtainMessage(5, i2, -1, new C0984ah(this, i, bundle)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7648a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f4767a.sendMessage(this.f4767a.obtainMessage(1, i2, -1, new C0982af(this, i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7615a(int i, T t) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7649a(ConnectionResult connectionResult) {
    }

    /* renamed from: a */
    public void mo7433a(C0756u uVar) {
        this.f4776k = (C0756u) C1009bf.m4529a(uVar, (Object) "Connection progress callbacks cannot be null.");
        m4653b(2, (IInterface) null);
    }

    /* renamed from: a */
    public void mo7434a(C0993aq aqVar) {
        try {
            this.f4775j.mo7566a((C0996at) new C0979ac(this, this.f4768b.get()), new ValidateAccountRequest(aqVar, (Scope[]) this.f4781p.toArray(new Scope[this.f4781p.size()]), this.f4769d.getPackageName(), mo7660n()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            mo7650b(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* renamed from: a */
    public void mo7435a(C0993aq aqVar, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f4785t).mo7476a(this.f4769d.getPackageName()).mo7474a(mo7657k());
            if (set != null) {
                a.mo7477a((Collection<Scope>) set);
            }
            if (mo7438c()) {
                a.mo7473a(mo7656j()).mo7475a(aqVar);
            } else if (mo7661o()) {
                a.mo7473a(this.f4782q);
            }
            this.f4775j.mo7565a((C0996at) new C0979ac(this, this.f4768b.get()), a);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            mo7650b(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* renamed from: a */
    public void mo7436a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.f4774i) {
            i = this.f4780o;
            t = this.f4777l;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append(mo7617e()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
    }

    /* renamed from: a_ */
    public Bundle mo7394a_() {
        return null;
    }

    /* renamed from: b */
    public void mo7650b(int i) {
        this.f4767a.sendMessage(this.f4767a.obtainMessage(4, this.f4768b.get(), i));
    }

    /* renamed from: b */
    public boolean mo7437b() {
        boolean z;
        synchronized (this.f4774i) {
            z = this.f4780o == 3;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7651c(int i) {
        this.f4767a.sendMessage(this.f4767a.obtainMessage(6, i, -1, new C0983ag(this)));
    }

    /* renamed from: c */
    public boolean mo7438c() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract String mo7616d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract String mo7617e();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final String mo7652f() {
        return this.f4770e.mo7637h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo7653g() {
    }

    /* renamed from: h */
    public boolean mo7654h() {
        boolean z;
        synchronized (this.f4774i) {
            z = this.f4780o == 2;
        }
        return z;
    }

    /* renamed from: i */
    public final Context mo7655i() {
        return this.f4769d;
    }

    /* renamed from: j */
    public final Account mo7656j() {
        return this.f4782q != null ? this.f4782q : new Account("<<default account>>", "com.google");
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Bundle mo7657k() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final void mo7658l() {
        if (!mo7437b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* renamed from: m */
    public final T mo7659m() {
        T t;
        synchronized (this.f4774i) {
            if (this.f4780o == 4) {
                throw new DeadObjectException();
            }
            mo7658l();
            C1009bf.m4533a(this.f4777l != null, (Object) "Client is connected but service is null");
            t = this.f4777l;
        }
        return t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public Bundle mo7660n() {
        return null;
    }

    /* renamed from: o */
    public boolean mo7661o() {
        return false;
    }
}
