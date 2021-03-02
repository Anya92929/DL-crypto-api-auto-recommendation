package com.appbrain.p032a;

import android.content.Context;
import android.content.SharedPreferences;
import cmn.C0726au;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.appbrain.a.ct */
public abstract class C0858ct {

    /* renamed from: a */
    private final long f2271a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f2272b = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f2273c;

    /* renamed from: d */
    private final String f2274d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f2275e;

    /* renamed from: f */
    private final boolean f2276f;

    public C0858ct(String str, long j) {
        this.f2273c = "last_check_" + str;
        this.f2274d = "last_err_" + str;
        this.f2275e = "errorcount_" + str;
        this.f2271a = j;
        this.f2276f = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3765a(long j, long j2, long j3, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(this.f2273c, j);
            if (j2 > 0) {
                edit.putLong(this.f2274d, j2);
            } else {
                edit.remove(this.f2274d);
            }
            if (j3 > 0) {
                edit.putLong(this.f2275e, j3);
            } else {
                edit.remove(this.f2275e);
            }
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public SharedPreferences mo3734a(Context context) {
        return context.getSharedPreferences("update_check", 0);
    }

    /* renamed from: b */
    public final boolean mo3735b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f2272b.compareAndSet(false, true)) {
            SharedPreferences a = mo3734a(context);
            long j = a.getLong(this.f2273c, 0);
            long j2 = a.getLong(this.f2274d, 0);
            long j3 = a.getLong(this.f2275e, 0);
            long j4 = j + this.f2271a;
            if (j3 > 0) {
                j4 = (long) Math.max((double) j4, ((double) j2) + (Math.pow(1.5d, (double) Math.min(12, j3)) * 10.0d * 1000.0d));
            }
            if (j4 <= System.currentTimeMillis()) {
                C0859cu cuVar = new C0859cu(this, context, currentTimeMillis, a);
                if (this.f2276f) {
                    C0726au.m3237a((Runnable) cuVar);
                } else {
                    cuVar.run();
                }
                return true;
            }
            if (a.getLong(this.f2273c, 0) > 3600000 + currentTimeMillis || a.getLong(this.f2274d, 0) > 3600000 + currentTimeMillis) {
                m3765a(0, 0, 0, a);
            }
            this.f2272b.set(false);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo3736c(Context context);
}
