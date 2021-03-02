package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzae;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzao implements zzan {

    /* renamed from: a */
    protected MotionEvent f5817a;

    /* renamed from: b */
    protected LinkedList f5818b = new LinkedList();

    /* renamed from: c */
    protected long f5819c = 0;

    /* renamed from: d */
    protected long f5820d = 0;

    /* renamed from: e */
    protected long f5821e = 0;

    /* renamed from: f */
    protected long f5822f = 0;

    /* renamed from: g */
    protected long f5823g = 0;

    /* renamed from: h */
    protected DisplayMetrics f5824h;

    /* renamed from: i */
    private boolean f5825i = false;

    protected zzao(Context context) {
        C1462c.m6296a();
        try {
            this.f5824h = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f5824h = new DisplayMetrics();
            this.f5824h.density = 1.0f;
        }
    }

    /* renamed from: a */
    private String m6691a(Context context, String str, boolean z) {
        zzae.zza a;
        boolean z2 = true;
        if (z) {
            try {
                a = mo7899b(context);
                this.f5825i = true;
            } catch (NoSuchAlgorithmException e) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e2) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        } else {
            a = mo7898a(context);
        }
        if (a == null || a.mo8049aM() == 0) {
            return Integer.toString(5);
        }
        if (m6693a(z)) {
            z2 = false;
        }
        return C1462c.m6291a(a, str, z2);
    }

    /* renamed from: a */
    private void m6692a() {
        if (((Boolean) zzdc.zzbbt.get()).booleanValue()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int i = 0;
            for (int length = stackTrace.length - 1; length >= 0; length--) {
                i++;
                if (stackTrace[length].toString().startsWith("com.google.android.ads.") || stackTrace[length].toString().startsWith("com.google.android.gms.")) {
                    break;
                }
            }
            this.f5823g = (long) i;
        }
    }

    /* renamed from: a */
    private static boolean m6693a(boolean z) {
        if (!((Boolean) zzdc.zzbbl.get()).booleanValue()) {
            return true;
        }
        return ((Boolean) zzdc.zzbbu.get()).booleanValue() && z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzae.zza mo7898a(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract zzae.zza mo7899b(Context context);

    public void zza(int i, int i2, int i3) {
        if (this.f5817a != null) {
            this.f5817a.recycle();
        }
        this.f5817a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f5824h.density, ((float) i2) * this.f5824h.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    public void zza(MotionEvent motionEvent) {
        if (this.f5825i) {
            this.f5822f = 0;
            this.f5821e = 0;
            this.f5820d = 0;
            this.f5819c = 0;
            this.f5823g = 0;
            Iterator it = this.f5818b.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f5818b.clear();
            this.f5817a = null;
            this.f5825i = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f5819c++;
                return;
            case 1:
                this.f5817a = MotionEvent.obtain(motionEvent);
                this.f5818b.add(this.f5817a);
                if (this.f5818b.size() > 6) {
                    ((MotionEvent) this.f5818b.remove()).recycle();
                }
                this.f5821e++;
                m6692a();
                return;
            case 2:
                this.f5820d += (long) (motionEvent.getHistorySize() + 1);
                return;
            case 3:
                this.f5822f++;
                return;
            default:
                return;
        }
    }

    public String zzb(Context context) {
        return m6691a(context, (String) null, false);
    }

    public String zzb(Context context, String str) {
        return m6691a(context, str, true);
    }
}
