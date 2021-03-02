package org.p004a.p005a.p025g.p026a;

import org.apache.commons.codec.binary.Base64;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.g.a.t */
class C0408t {

    /* renamed from: a */
    private byte[] f316a = null;

    /* renamed from: b */
    private int f317b = 0;

    C0408t() {
    }

    C0408t(String str, int i) {
        this.f316a = Base64.decodeBase64(C0250b.m100a(str, "ASCII"));
        if (this.f316a.length < C0404p.f281b.length) {
            throw new C0403o("NTLM message decoding error - packet too short");
        }
        for (int i2 = 0; i2 < C0404p.f281b.length; i2++) {
            if (this.f316a[i2] != C0404p.f281b[i2]) {
                throw new C0403o("NTLM message expected - instead got unrecognized bytes");
            }
        }
        int a = mo5173a(C0404p.f281b.length);
        if (a != 2) {
            throw new C0403o("NTLM type " + Integer.toString(2) + " message expected - instead got type " + Integer.toString(a));
        }
        this.f317b = this.f316a.length;
    }

    /* renamed from: a */
    private void m608a(byte b) {
        this.f316a[this.f317b] = b;
        this.f317b++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo5172a() {
        return this.f317b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo5173a(int i) {
        return C0404p.m576d(this.f316a, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5174a(int i, int i2) {
        this.f316a = new byte[i];
        this.f317b = 0;
        mo5175a(C0404p.f281b);
        mo5180d(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5175a(byte[] bArr) {
        if (bArr != null) {
            for (byte b : bArr) {
                this.f316a[this.f317b] = b;
                this.f317b++;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5176a(byte[] bArr, int i) {
        if (this.f316a.length < bArr.length + 24) {
            throw new C0403o("NTLM: Message too short");
        }
        System.arraycopy(this.f316a, 24, bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo5177b() {
        byte[] bArr;
        if (this.f316a.length > this.f317b) {
            bArr = new byte[this.f317b];
            System.arraycopy(this.f316a, 0, bArr, 0, this.f317b);
        } else {
            bArr = this.f316a;
        }
        byte[] encodeBase64 = Base64.encodeBase64(bArr);
        C0250b.m84a((Object) encodeBase64, "Input");
        return C0250b.m86a(encodeBase64, 0, encodeBase64.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final byte[] mo5178b(int i) {
        return C0404p.m573c(this.f316a, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo5179c(int i) {
        m608a((byte) i);
        m608a((byte) (i >> 8));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo5180d(int i) {
        m608a((byte) i);
        m608a((byte) (i >> 8));
        m608a((byte) (i >> 16));
        m608a((byte) (i >>> 24));
    }
}
