package com.appbrain.p038g;

import com.appbrain.p039h.C1109b;
import com.appbrain.p039h.C1111d;
import com.appbrain.p039h.C1113f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.appbrain.g.a */
public abstract class C1100a implements C1106g {

    /* renamed from: a */
    private final C1113f f3073a;

    protected C1100a(C1113f fVar) {
        this.f3073a = fVar;
    }

    /* renamed from: a */
    protected static long m5077a(byte[]... bArr) {
        MessageDigest a = m5078a();
        for (int i = 0; i <= 0; i++) {
            a.update(bArr[0]); // CRYPTOGRAPHIC API CALLSITE 25
        }
        return ByteBuffer.wrap(a.digest()).getLong(); // CRYPTOGRAPHIC API CALLSITE 24
    }

    /* renamed from: a */
    private static MessageDigest m5078a() {
        try {
            return MessageDigest.getInstance("SHA-1"); // CRYPTOGRAPHIC API CALLSITE 13
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract long mo4374a(byte[] bArr);

    /* renamed from: a */
    public final C1109b mo4375a(C1109b bVar) {
        if (!bVar.mo4402n() || !bVar.mo4404p()) {
            C1111d K = bVar.mo4027d();
            K.mo4416a(mo4374a(bVar.mo3915b()));
            K.mo4418a(this.f3073a);
            return K.mo4028d();
        }
        throw new IllegalArgumentException("Already signed");
    }

    /* renamed from: b */
    public final void mo4376b(C1109b bVar) {
        if (bVar.mo4405q() != this.f3073a) {
            throw new SecurityException("Unexpected sign-type: " + bVar.mo4405q());
        }
        C1111d K = bVar.mo4027d();
        K.mo4425g();
        K.mo4426h();
        long a = mo4374a(K.mo4028d().mo3915b());
        if (a != bVar.mo4403o()) {
            throw new SecurityException("Wrong checksum value. " + a + " " + bVar.mo4403o() + ", wrapper:\n" + bVar);
        }
    }
}
