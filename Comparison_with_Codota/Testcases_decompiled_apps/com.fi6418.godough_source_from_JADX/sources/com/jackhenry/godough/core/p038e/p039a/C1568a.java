package com.jackhenry.godough.core.p038e.p039a;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.p027b.C1389d;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.jackhenry.godough.core.e.a.a */
public class C1568a {

    /* renamed from: a */
    public static int f6120a = 16;

    /* renamed from: b */
    private static int f6121b = 256;

    /* renamed from: c */
    private C1571d f6122c;

    /* renamed from: d */
    private Cipher f6123d;

    /* renamed from: e */
    private int f6124e;

    /* renamed from: f */
    private int f6125f;

    /* renamed from: g */
    private C1570c f6126g;

    public C1568a(C1570c cVar) {
        this("Default", cVar);
    }

    public C1568a(String str, C1570c cVar) {
        this.f6124e = 0;
        this.f6125f = 2;
        this.f6122c = new C1571d(str);
        this.f6124e = 0;
        this.f6126g = cVar;
    }

    /* renamed from: a */
    private C1569b m6123a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = new byte[f6120a];
        wrap.get(bArr2, 0, f6120a);
        byte[] bArr3 = new byte[wrap.remaining()];
        wrap.get(bArr3, 0, wrap.remaining());
        return new C1569b(this, bArr3, bArr2);
    }

    /* renamed from: a */
    private byte[] m6124a() {
        C1584m mVar = new C1584m(GoDoughApp.getApp());
        try {
            String a = mVar.mo9798a("DATA", (String) null);
            if (a != null) {
                a = a.trim();
            }
            if (!TextUtils.isEmpty(a)) {
                return Base64.decode(a.getBytes("UTF-8"), 0);
            }
            mVar.mo9799a("DATA");
            this.f6126g.mo9782a();
            byte[] a2 = mo9778a(f6120a);
            mVar.mo9801b("DATA", new String(Base64.encode(a2, 0)));
            return a2;
        } catch (Exception e) {
            e.printStackTrace();
            if (this.f6124e > this.f6125f) {
                Log.e(getClass().getSimpleName(), "Max tries exceeded for retriving Data");
                return null;
            }
            this.f6124e++;
            mVar.mo9799a("DATA");
            this.f6126g.mo9782a();
            return m6124a();
        }
    }

    /* renamed from: a */
    private byte[] m6125a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length + bArr2.length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.put(bArr);
        allocate.put(bArr2);
        allocate.rewind();
        byte[] bArr3 = new byte[length];
        allocate.get(bArr3);
        return bArr3;
    }

    /* renamed from: a */
    public byte[] mo9778a(int i) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(f6121b);
            SecretKey generateKey = instance.generateKey();
            byte[] bArr = new byte[i];
            new SecureRandom().nextBytes(bArr);
            return m6125a(bArr, this.f6122c.mo9783a(generateKey.getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(GoDoughApp.getApp().getString(C1506am.keystore_open_error), 1000);
        }
    }

    /* renamed from: b */
    public Cipher mo9779b(int i) {
        byte[] a = m6124a();
        if (a != null) {
            C1569b a2 = m6123a(a);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a2.mo9781b());
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f6122c.mo9784b(a2.mo9780a()), "AES/CBC/PKCS7Padding");
            if (this.f6123d == null) {
                this.f6123d = Cipher.getInstance("AES/CBC/PKCS7Padding");
            }
            if (i == 1) {
                this.f6123d.init(1, secretKeySpec, ivParameterSpec);
            } else {
                this.f6123d.init(2, secretKeySpec, ivParameterSpec);
            }
            return this.f6123d;
        }
        throw new C1389d(GoDoughApp.getApp().getString(C1506am.storage_error), 1000);
    }
}
