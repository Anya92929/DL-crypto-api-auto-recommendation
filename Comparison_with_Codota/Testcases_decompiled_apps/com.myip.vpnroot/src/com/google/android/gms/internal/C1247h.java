package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.h */
public abstract class C1247h implements C1198g {

    /* renamed from: kw */
    protected MotionEvent f3820kw;

    /* renamed from: kx */
    protected DisplayMetrics f3821kx;

    /* renamed from: ky */
    protected C1551m f3822ky;

    /* renamed from: kz */
    private C1582n f3823kz;

    protected C1247h(Context context, C1551m mVar, C1582n nVar) {
        this.f3822ky = mVar;
        this.f3823kz = nVar;
        try {
            this.f3821kx = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f3821kx = new DisplayMetrics();
            this.f3821kx.density = 1.0f;
        }
    }

    /* renamed from: a */
    private String m4735a(Context context, String str, boolean z) {
        byte[] u;
        try {
            synchronized (this) {
                m4736t();
                if (z) {
                    mo8693c(context);
                } else {
                    mo8692b(context);
                }
                u = m4737u();
            }
            return u.length == 0 ? Integer.toString(5) : mo8688a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* renamed from: t */
    private void m4736t() {
        this.f3823kz.reset();
    }

    /* renamed from: u */
    private byte[] m4737u() throws IOException {
        return this.f3823kz.mo9487A();
    }

    /* renamed from: a */
    public String mo8540a(Context context) {
        return m4735a(context, (String) null, false);
    }

    /* renamed from: a */
    public String mo8541a(Context context, String str) {
        return m4735a(context, str, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8688a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] array;
        if (bArr.length > 239) {
            m4736t();
            mo8689a(20, 1);
            bArr = m4737u();
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
        new C1131f().mo8465a(array2, bArr3);
        if (str != null && str.length() > 0) {
            mo8691a(str, bArr3);
        }
        return this.f3822ky.mo8399a(bArr3, true);
    }

    /* renamed from: a */
    public void mo8542a(int i, int i2, int i3) {
        if (this.f3820kw != null) {
            this.f3820kw.recycle();
        }
        this.f3820kw = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f3821kx.density, ((float) i2) * this.f3821kx.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8689a(int i, long j) throws IOException {
        this.f3823kz.mo9488b(i, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8690a(int i, String str) throws IOException {
        this.f3823kz.mo9489b(i, str);
    }

    /* renamed from: a */
    public void mo8543a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f3820kw != null) {
                this.f3820kw.recycle();
            }
            this.f3820kw = MotionEvent.obtain(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8691a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new C1708pd(str.getBytes("UTF-8")).mo10017o(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo8692b(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo8693c(Context context);
}
