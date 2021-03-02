package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.ads.aj */
public abstract class C0189aj implements C0188ai {

    /* renamed from: a */
    protected MotionEvent f337a = null;

    /* renamed from: b */
    protected DisplayMetrics f338b = null;

    /* renamed from: c */
    private C0204au f339c = null;

    /* renamed from: d */
    private ByteArrayOutputStream f340d = null;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo3340b(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo3341c(Context context);

    protected C0189aj(Context context) {
        try {
            this.f338b = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f338b = new DisplayMetrics();
            this.f338b.density = 1.0f;
        }
    }

    /* renamed from: a */
    public String mo3332a(Context context) {
        return m58a(context, (String) null, false);
    }

    /* renamed from: a */
    public String mo3333a(Context context, String str) {
        return m58a(context, str, true);
    }

    /* renamed from: a */
    public void mo3338a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f337a != null) {
                this.f337a.recycle();
            }
            this.f337a = MotionEvent.obtain(motionEvent);
        }
    }

    /* renamed from: a */
    public void mo3335a(int i, int i2, int i3) {
        if (this.f337a != null) {
            this.f337a.recycle();
        }
        this.f337a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f338b.density, ((float) i2) * this.f338b.density, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, 0);
    }

    /* renamed from: a */
    private String m58a(Context context, String str, boolean z) {
        try {
            m59a();
            if (z) {
                mo3341c(context);
            } else {
                mo3340b(context);
            }
            byte[] b = m60b();
            if (b.length == 0) {
                return Integer.toString(5);
            }
            return mo3334a(b, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3336a(int i, long j) throws IOException {
        this.f339c.mo3352a(i, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3337a(int i, String str) throws IOException {
        this.f339c.mo3353a(i, str);
    }

    /* renamed from: a */
    private void m59a() {
        this.f340d = new ByteArrayOutputStream();
        this.f339c = C0204au.m116a((OutputStream) this.f340d);
    }

    /* renamed from: b */
    private byte[] m60b() throws IOException {
        this.f339c.mo3348a();
        return this.f340d.toByteArray();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo3334a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] array;
        if (bArr.length > 239) {
            m59a();
            mo3336a(20, 1);
            bArr = m60b();
        }
        if (bArr.length < 239) {
            byte[] bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2); // CRYPTOGRAPHIC API CALLSITE 23
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 21
        instance.update(array); // CRYPTOGRAPHIC API CALLSITE 20
        byte[] array2 = ByteBuffer.allocate(256).put(instance.digest()).put(array).array(); // CRYPTOGRAPHIC API CALLSITE 24
        byte[] bArr3 = new byte[256];
        new C0172ag().mo3330a(array2, bArr3);
        if (str != null && str.length() > 0) {
            mo3339a(str, bArr3);
        }
        return C0198aq.m105a(bArr3, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3339a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new C0199ar(str.getBytes("UTF-8")).mo3345a(bArr);
    }
}
