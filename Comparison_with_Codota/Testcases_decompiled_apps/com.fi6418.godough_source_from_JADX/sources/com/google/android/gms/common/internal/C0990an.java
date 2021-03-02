package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.an */
final class C0990an {

    /* renamed from: a */
    final /* synthetic */ C0988al f4706a;

    /* renamed from: b */
    private final C0991ao f4707b = new C0991ao(this);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Set<ServiceConnection> f4708c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f4709d = 2;

    /* renamed from: e */
    private boolean f4710e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IBinder f4711f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C0989am f4712g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ComponentName f4713h;

    public C0990an(C0988al alVar, C0989am amVar) {
        this.f4706a = alVar;
        this.f4712g = amVar;
    }

    /* renamed from: a */
    public void mo7534a(ServiceConnection serviceConnection, String str) {
        this.f4706a.f4702d.mo7702a(this.f4706a.f4700b, serviceConnection, str, this.f4712g.mo7530a());
        this.f4708c.add(serviceConnection);
    }

    /* renamed from: a */
    public void mo7535a(String str) {
        this.f4710e = this.f4706a.f4702d.mo7704a(this.f4706a.f4700b, str, this.f4712g.mo7530a(), (ServiceConnection) this.f4707b, 129);
        if (this.f4710e) {
            this.f4709d = 3;
            return;
        }
        try {
            this.f4706a.f4702d.mo7701a(this.f4706a.f4700b, (ServiceConnection) this.f4707b);
        } catch (IllegalArgumentException e) {
        }
    }

    /* renamed from: a */
    public boolean mo7536a() {
        return this.f4710e;
    }

    /* renamed from: a */
    public boolean mo7537a(ServiceConnection serviceConnection) {
        return this.f4708c.contains(serviceConnection);
    }

    /* renamed from: b */
    public int mo7538b() {
        return this.f4709d;
    }

    /* renamed from: b */
    public void mo7539b(ServiceConnection serviceConnection, String str) {
        this.f4706a.f4702d.mo7705b(this.f4706a.f4700b, serviceConnection);
        this.f4708c.remove(serviceConnection);
    }

    /* renamed from: b */
    public void mo7540b(String str) {
        this.f4706a.f4702d.mo7701a(this.f4706a.f4700b, (ServiceConnection) this.f4707b);
        this.f4710e = false;
        this.f4709d = 2;
    }

    /* renamed from: c */
    public boolean mo7541c() {
        return this.f4708c.isEmpty();
    }

    /* renamed from: d */
    public IBinder mo7542d() {
        return this.f4711f;
    }

    /* renamed from: e */
    public ComponentName mo7543e() {
        return this.f4713h;
    }
}
