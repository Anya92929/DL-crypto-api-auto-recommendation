package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.C1009bf;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.internal.p */
public final class C0568p {

    /* renamed from: a */
    final /* synthetic */ C0566n f3885a;

    /* renamed from: b */
    private final String f3886b;

    /* renamed from: c */
    private final long f3887c;

    private C0568p(C0566n nVar, String str, long j) {
        this.f3885a = nVar;
        C1009bf.m4530a(str);
        C1009bf.m4536b(j > 0);
        this.f3886b = str;
        this.f3887c = j;
    }

    /* renamed from: c */
    private void m3313c() {
        long a = this.f3885a.mo6885n().mo6990a();
        SharedPreferences.Editor edit = this.f3885a.f3881a.edit();
        edit.remove(m3317g());
        edit.remove(mo6832b());
        edit.putLong(m3316f(), a);
        edit.commit();
    }

    /* renamed from: d */
    private long m3314d() {
        long e = m3315e();
        if (e == 0) {
            return 0;
        }
        return Math.abs(e - this.f3885a.mo6885n().mo6990a());
    }

    /* renamed from: e */
    private long m3315e() {
        return this.f3885a.f3881a.getLong(m3316f(), 0);
    }

    /* renamed from: f */
    private String m3316f() {
        return this.f3886b + ":start";
    }

    /* renamed from: g */
    private String m3317g() {
        return this.f3886b + ":count";
    }

    /* renamed from: a */
    public Pair<String, Long> mo6830a() {
        long d = m3314d();
        if (d < this.f3887c) {
            return null;
        }
        if (d > this.f3887c * 2) {
            m3313c();
            return null;
        }
        String string = this.f3885a.f3881a.getString(mo6832b(), (String) null);
        long j = this.f3885a.f3881a.getLong(m3317g(), 0);
        m3313c();
        if (string == null || j <= 0) {
            return null;
        }
        return new Pair<>(string, Long.valueOf(j));
    }

    /* renamed from: a */
    public void mo6831a(String str) {
        if (m3315e() == 0) {
            m3313c();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.f3885a.f3881a.getLong(m3317g(), 0);
            if (j <= 0) {
                SharedPreferences.Editor edit = this.f3885a.f3881a.edit();
                edit.putString(mo6832b(), str);
                edit.putLong(m3317g(), 1);
                edit.apply();
                return;
            }
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1);
            SharedPreferences.Editor edit2 = this.f3885a.f3881a.edit();
            if (z) {
                edit2.putString(mo6832b(), str);
            }
            edit2.putLong(m3317g(), j + 1);
            edit2.apply();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo6832b() {
        return this.f3886b + ":value";
    }
}
