package com.google.android.gms.internal;

import com.google.android.gms.internal.zzau;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzbo {

    /* renamed from: a */
    protected static final String f5973a = zzbo.class.getSimpleName();

    /* renamed from: b */
    private final zzax f5974b;

    /* renamed from: c */
    private final String f5975c;

    /* renamed from: d */
    private final String f5976d;

    /* renamed from: e */
    private final int f5977e = 2;

    /* renamed from: f */
    private volatile Method f5978f = null;

    /* renamed from: g */
    private List f5979g;

    /* renamed from: h */
    private CountDownLatch f5980h = new CountDownLatch(1);

    public zzbo(zzax zzax, String str, String str2, List list) {
        this.f5974b = zzax;
        this.f5975c = str;
        this.f5976d = str2;
        this.f5979g = new ArrayList(list);
        this.f5974b.zzcd().submit(new C1504do(this));
    }

    /* renamed from: a */
    private String m6915a(byte[] bArr, String str) {
        return new String(this.f5974b.zzcf().zzc(bArr, str), "UTF-8");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6916a() {
        try {
            Class loadClass = this.f5974b.zzce().loadClass(m6915a(this.f5974b.zzcg(), this.f5975c));
            if (loadClass != null) {
                this.f5978f = loadClass.getMethod(m6915a(this.f5974b.zzcg(), this.f5976d), (Class[]) this.f5979g.toArray(new Class[this.f5979g.size()]));
                if (this.f5978f == null) {
                    this.f5980h.countDown();
                } else {
                    this.f5980h.countDown();
                }
            }
        } catch (zzau.zza e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.f5980h.countDown();
        }
    }

    public Method zzcz() {
        if (this.f5978f != null) {
            return this.f5978f;
        }
        try {
            if (this.f5980h.await(2, TimeUnit.SECONDS)) {
                return this.f5978f;
            }
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
