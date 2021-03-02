package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.e */
public abstract class C0430e implements C0382d {

    /* renamed from: dg */
    protected MotionEvent f1171dg;

    /* renamed from: dh */
    protected DisplayMetrics f1172dh;

    /* renamed from: di */
    protected C0601j f1173di;

    /* renamed from: dj */
    private C0602k f1174dj;

    protected C0430e(Context context, C0601j jVar, C0602k kVar) {
        this.f1173di = jVar;
        this.f1174dj = kVar;
        try {
            this.f1172dh = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f1172dh = new DisplayMetrics();
            this.f1172dh.density = 1.0f;
        }
    }

    /* renamed from: a */
    private String m1033a(Context context, String str, boolean z) {
        byte[] c;
        try {
            synchronized (this) {
                m1034b();
                if (z) {
                    mo4485c(context);
                } else {
                    mo4484b(context);
                }
                c = m1035c();
            }
            return c.length == 0 ? Integer.toString(5) : mo4480a(c, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* renamed from: b */
    private void m1034b() {
        this.f1174dj.reset();
    }

    /* renamed from: c */
    private byte[] m1035c() throws IOException {
        return this.f1174dj.mo5307h();
    }

    /* renamed from: a */
    public String mo4315a(Context context) {
        return m1033a(context, (String) null, false);
    }

    /* renamed from: a */
    public String mo4316a(Context context, String str) {
        return m1033a(context, str, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4480a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] array;
        if (bArr.length > 239) {
            m1034b();
            mo4481a(20, 1);
            bArr = m1035c();
        }
        if (bArr.length < 239) {
            byte[] bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(array);
        byte[] array2 = ByteBuffer.allocate(256).put(instance.digest()).put(array).array();
        byte[] bArr3 = new byte[256];
        new C0248b().mo4077a(array2, bArr3);
        if (str != null && str.length() > 0) {
            mo4483a(str, bArr3);
        }
        return this.f1173di.mo4005a(bArr3, true);
    }

    /* renamed from: a */
    public void mo4317a(int i, int i2, int i3) {
        if (this.f1171dg != null) {
            this.f1171dg.recycle();
        }
        this.f1171dg = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f1172dh.density, ((float) i2) * this.f1172dh.density, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4481a(int i, long j) throws IOException {
        this.f1174dj.mo5305b(i, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4482a(int i, String str) throws IOException {
        this.f1174dj.mo5306b(i, str);
    }

    /* renamed from: a */
    public void mo4318a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f1171dg != null) {
                this.f1171dg.recycle();
            }
            this.f1171dg = MotionEvent.obtain(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4483a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new C0595gk(str.getBytes("UTF-8")).mo5288f(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo4484b(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo4485c(Context context);
}
