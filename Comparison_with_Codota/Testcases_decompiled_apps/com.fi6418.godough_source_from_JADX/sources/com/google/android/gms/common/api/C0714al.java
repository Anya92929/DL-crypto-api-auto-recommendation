package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Looper;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C0985ai;
import com.google.android.gms.common.internal.C0986aj;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.C1012c;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.common.internal.C1033u;
import com.google.android.gms.signin.C1246f;
import com.google.android.gms.signin.C1247g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.al */
final class C0714al implements C0749n {

    /* renamed from: A */
    private final C0986aj f4445A = new C0717ao(this);

    /* renamed from: a */
    final C0985ai f4446a;

    /* renamed from: b */
    final Queue<C0723au<?>> f4447b = new LinkedList();

    /* renamed from: c */
    BroadcastReceiver f4448c;

    /* renamed from: d */
    final Map<C0744i<?>, C0743h> f4449d = new HashMap();

    /* renamed from: e */
    final Map<C0744i<?>, ConnectionResult> f4450e = new HashMap();

    /* renamed from: f */
    Set<Scope> f4451f = new HashSet();

    /* renamed from: g */
    final C1032t f4452g;

    /* renamed from: h */
    final Map<C0702a<?>, Integer> f4453h;

    /* renamed from: i */
    final C0742g<? extends C1246f, C1247g> f4454i;

    /* renamed from: j */
    final Set<C0723au<?>> f4455j = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Lock f4456k = new ReentrantLock();

    /* renamed from: l */
    private final Condition f4457l;

    /* renamed from: m */
    private final int f4458m;

    /* renamed from: n */
    private final int f4459n;

    /* renamed from: o */
    private final Context f4460o;

    /* renamed from: p */
    private final Looper f4461p;

    /* renamed from: q */
    private volatile boolean f4462q;

    /* renamed from: r */
    private long f4463r = 120000;

    /* renamed from: s */
    private long f4464s = 5000;

    /* renamed from: t */
    private final C0719aq f4465t;

    /* renamed from: u */
    private final C0772b f4466u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile C0724av f4467v;

    /* renamed from: w */
    private ConnectionResult f4468w = null;

    /* renamed from: x */
    private final Set<C0726ax<?>> f4469x = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: y */
    private final C0722at f4470y = new C0715am(this);

    /* renamed from: z */
    private final C0752q f4471z = new C0716an(this);

    public C0714al(Context context, Looper looper, C1032t tVar, C0772b bVar, C0742g<? extends C1246f, C1247g> gVar, Map<C0702a<?>, C0729b> map, ArrayList<C0752q> arrayList, ArrayList<C0753r> arrayList2, int i, int i2) {
        int i3;
        this.f4460o = context;
        this.f4446a = new C0985ai(looper, this.f4445A);
        this.f4461p = looper;
        this.f4465t = new C0719aq(this, looper);
        this.f4466u = bVar;
        this.f4458m = i;
        this.f4459n = i2;
        this.f4453h = new HashMap();
        this.f4457l = this.f4456k.newCondition();
        this.f4467v = new C0713ak(this);
        Iterator<C0752q> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f4446a.mo7521a(it.next());
        }
        Iterator<C0753r> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.f4446a.mo7522a(it2.next());
        }
        Map<C0702a<?>, C1033u> f = tVar.mo7635f();
        for (C0702a next : map.keySet()) {
            C0729b bVar2 = map.get(next);
            if (f.get(next) != null) {
                i3 = f.get(next).f4761b ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.f4453h.put(next, Integer.valueOf(i3));
            this.f4449d.put(next.mo7352c(), next.mo7353d() ? m3987a(next.mo7351b(), (Object) bVar2, context, looper, tVar, this.f4471z, m3986a(next, i3)) : m3985a(next.mo7350a(), (Object) bVar2, context, looper, tVar, this.f4471z, m3986a(next, i3)));
        }
        this.f4452g = tVar;
        this.f4454i = gVar;
    }

    /* renamed from: a */
    private static <C extends C0743h, O> C m3985a(C0742g<C, O> gVar, Object obj, Context context, Looper looper, C1032t tVar, C0752q qVar, C0753r rVar) {
        return gVar.mo7430a(context, looper, tVar, obj, qVar, rVar);
    }

    /* renamed from: a */
    private final C0753r m3986a(C0702a<?> aVar, int i) {
        return new C0718ap(this, aVar, i);
    }

    /* renamed from: a */
    private static <C extends C0745j, O> C1012c m3987a(C0746k<C, O> kVar, Object obj, Context context, Looper looper, C1032t tVar, C0752q qVar, C0753r rVar) {
        return new C1012c(context, looper, kVar.mo7443a(), qVar, rVar, tVar, kVar.mo7444a(obj));
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m3992n() {
        this.f4456k.lock();
        try {
            if (mo7389i()) {
                mo7372a();
            }
        } finally {
            this.f4456k.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m3993o() {
        this.f4456k.lock();
        try {
            if (mo7391k()) {
                mo7372a();
            }
        } finally {
            this.f4456k.unlock();
        }
    }

    /* renamed from: a */
    public <C extends C0743h> C mo7371a(C0744i<C> iVar) {
        C c = (C0743h) this.f4449d.get(iVar);
        C1009bf.m4529a(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    /* renamed from: a */
    public void mo7372a() {
        this.f4456k.lock();
        try {
            this.f4467v.mo7369c();
        } finally {
            this.f4456k.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7373a(ConnectionResult connectionResult) {
        this.f4456k.lock();
        try {
            this.f4468w = connectionResult;
            this.f4467v = new C0713ak(this);
            this.f4467v.mo7364a();
            this.f4457l.signalAll();
        } finally {
            this.f4456k.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7374a(C0720ar arVar) {
        this.f4465t.sendMessage(this.f4465t.obtainMessage(3, arVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <A extends C0743h> void mo7375a(C0723au<A> auVar) {
        this.f4455j.add(auVar);
        auVar.mo7401a(this.f4470y);
    }

    /* renamed from: a */
    public void mo7376a(C0752q qVar) {
        this.f4446a.mo7521a(qVar);
    }

    /* renamed from: a */
    public void mo7377a(C0753r rVar) {
        this.f4446a.mo7522a(rVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7378a(RuntimeException runtimeException) {
        this.f4465t.sendMessage(this.f4465t.obtainMessage(4, runtimeException));
    }

    /* renamed from: a */
    public void mo7379a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mState=").append(this.f4467v.mo7370d());
        printWriter.append(" mResuming=").print(this.f4462q);
        printWriter.append(" mWorkQueue.size()=").print(this.f4447b.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.f4455j.size());
        String str2 = str + "  ";
        for (C0702a next : this.f4453h.keySet()) {
            printWriter.append(str).append(next.mo7354e()).println(":");
            this.f4449d.get(next.mo7352c()).mo7436a(str2, fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: b */
    public void mo7380b() {
        this.f4456k.lock();
        try {
            mo7391k();
            this.f4467v.mo7368b();
        } finally {
            this.f4456k.unlock();
        }
    }

    /* renamed from: b */
    public void mo7381b(C0752q qVar) {
        this.f4446a.mo7524b(qVar);
    }

    /* renamed from: b */
    public void mo7382b(C0753r rVar) {
        this.f4446a.mo7525b(rVar);
    }

    /* renamed from: c */
    public boolean mo7383c() {
        return this.f4467v instanceof C0757v;
    }

    /* renamed from: d */
    public boolean mo7384d() {
        return this.f4467v instanceof C0758w;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo7385e() {
        for (C0723au next : this.f4455j) {
            next.mo7401a((C0722at) null);
            next.mo7399a();
        }
        this.f4455j.clear();
        for (C0726ax<?> a : this.f4469x) {
            a.mo7406a();
        }
        this.f4469x.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo7386f() {
        for (C0743h a : this.f4449d.values()) {
            a.mo7432a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo7387g() {
        this.f4456k.lock();
        try {
            this.f4467v = new C0758w(this, this.f4452g, this.f4453h, this.f4466u, this.f4454i, this.f4456k, this.f4460o);
            this.f4467v.mo7364a();
            this.f4457l.signalAll();
        } finally {
            this.f4456k.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo7388h() {
        this.f4456k.lock();
        try {
            mo7391k();
            this.f4467v = new C0757v(this);
            this.f4467v.mo7364a();
            this.f4457l.signalAll();
        } finally {
            this.f4456k.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo7389i() {
        return this.f4462q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo7390j() {
        if (!mo7389i()) {
            this.f4462q = true;
            if (this.f4448c == null) {
                this.f4448c = new C0721as(this);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                this.f4460o.getApplicationContext().registerReceiver(this.f4448c, intentFilter);
            }
            this.f4465t.sendMessageDelayed(this.f4465t.obtainMessage(1), this.f4463r);
            this.f4465t.sendMessageDelayed(this.f4465t.obtainMessage(2), this.f4464s);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public boolean mo7391k() {
        if (!mo7389i()) {
            return false;
        }
        this.f4462q = false;
        this.f4465t.removeMessages(2);
        this.f4465t.removeMessages(1);
        if (this.f4448c != null) {
            this.f4460o.getApplicationContext().unregisterReceiver(this.f4448c);
            this.f4448c = null;
        }
        return true;
    }

    /* renamed from: l */
    public Looper mo7392l() {
        return this.f4461p;
    }

    /* renamed from: m */
    public int mo7393m() {
        return System.identityHashCode(this);
    }
}
