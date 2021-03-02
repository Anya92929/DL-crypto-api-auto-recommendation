package com.google.android.gms.p018c;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.google.android.gms.c.bl */
public final class C0650bl {

    /* renamed from: a */
    private final ByteBuffer f4320a;

    private C0650bl(ByteBuffer byteBuffer) {
        this.f4320a = byteBuffer;
    }

    private C0650bl(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: a */
    private static int m3755a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = i;
        int i3 = length;
        while (true) {
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 2048) {
                    i3 += m3756a(charSequence, i2);
                    break;
                }
                i2++;
                i3 = ((127 - charAt) >>> 31) + i3;
            } else {
                break;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    /* renamed from: a */
    private static int m3756a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    /* renamed from: a */
    private static int m3757a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) charAt2;
            } else if (charAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i6 <= i5 - 3) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i6 <= i5 - 4) {
                if (i4 + 1 != charSequence.length()) {
                    i4++;
                    char charAt3 = charSequence.charAt(i4);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i10 = i6 + 1;
                        bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i3 = i12 + 1;
                        bArr[i12] = (byte) ((codePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i4 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i6);
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    /* renamed from: a */
    public static C0650bl m3758a(byte[] bArr) {
        return m3759a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C0650bl m3759a(byte[] bArr, int i, int i2) {
        return new C0650bl(bArr, i, i2);
    }

    /* renamed from: a */
    private static void m3760a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m3757a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m3770b(charSequence, byteBuffer);
        }
    }

    /* renamed from: b */
    public static int m3761b(int i) {
        if (i >= 0) {
            return m3776f(i);
        }
        return 10;
    }

    /* renamed from: b */
    public static int m3762b(int i, int i2) {
        return m3773d(i) + m3761b(i2);
    }

    /* renamed from: b */
    public static int m3763b(int i, long j) {
        return m3773d(i) + m3767b(j);
    }

    /* renamed from: b */
    public static int m3764b(int i, C0657bs bsVar) {
        return (m3773d(i) * 2) + m3772c(bsVar);
    }

    /* renamed from: b */
    public static int m3765b(int i, String str) {
        return m3773d(i) + m3768b(str);
    }

    /* renamed from: b */
    public static int m3766b(int i, boolean z) {
        return m3773d(i) + m3769b(z);
    }

    /* renamed from: b */
    public static int m3767b(long j) {
        return m3774d(j);
    }

    /* renamed from: b */
    public static int m3768b(String str) {
        int a = m3755a((CharSequence) str);
        return a + m3776f(a);
    }

    /* renamed from: b */
    public static int m3769b(boolean z) {
        return 1;
    }

    /* renamed from: b */
    private static void m3770b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    /* renamed from: c */
    public static int m3771c(int i, C0657bs bsVar) {
        return m3773d(i) + m3775d(bsVar);
    }

    /* renamed from: c */
    public static int m3772c(C0657bs bsVar) {
        return bsVar.mo7190h();
    }

    /* renamed from: d */
    public static int m3773d(int i) {
        return m3776f(C0660bv.m3839a(i, 0));
    }

    /* renamed from: d */
    public static int m3774d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: d */
    public static int m3775d(C0657bs bsVar) {
        int h = bsVar.mo7190h();
        return h + m3776f(h);
    }

    /* renamed from: f */
    public static int m3776f(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    public void mo7145a(byte b) {
        if (!this.f4320a.hasRemaining()) {
            throw new C0651bm(this.f4320a.position(), this.f4320a.limit());
        }
        this.f4320a.put(b);
    }

    /* renamed from: a */
    public void mo7146a(int i) {
        if (i >= 0) {
            mo7162e(i);
        } else {
            mo7161c((long) i);
        }
    }

    /* renamed from: a */
    public void mo7147a(int i, int i2) {
        mo7160c(i, 0);
        mo7146a(i2);
    }

    /* renamed from: a */
    public void mo7148a(int i, long j) {
        mo7160c(i, 0);
        mo7152a(j);
    }

    /* renamed from: a */
    public void mo7149a(int i, C0657bs bsVar) {
        mo7160c(i, 2);
        mo7156b(bsVar);
    }

    /* renamed from: a */
    public void mo7150a(int i, String str) {
        mo7160c(i, 2);
        mo7154a(str);
    }

    /* renamed from: a */
    public void mo7151a(int i, boolean z) {
        mo7160c(i, 0);
        mo7155a(z);
    }

    /* renamed from: a */
    public void mo7152a(long j) {
        mo7161c(j);
    }

    /* renamed from: a */
    public void mo7153a(C0657bs bsVar) {
        bsVar.mo7163a(this);
    }

    /* renamed from: a */
    public void mo7154a(String str) {
        try {
            int f = m3776f(str.length());
            if (f == m3776f(str.length() * 3)) {
                int position = this.f4320a.position();
                this.f4320a.position(position + f);
                m3760a((CharSequence) str, this.f4320a);
                int position2 = this.f4320a.position();
                this.f4320a.position(position);
                mo7162e((position2 - position) - f);
                this.f4320a.position(position2);
                return;
            }
            mo7162e(m3755a((CharSequence) str));
            m3760a((CharSequence) str, this.f4320a);
        } catch (BufferOverflowException e) {
            throw new C0651bm(this.f4320a.position(), this.f4320a.limit());
        }
    }

    /* renamed from: a */
    public void mo7155a(boolean z) {
        mo7159c(z ? 1 : 0);
    }

    /* renamed from: b */
    public void mo7156b(C0657bs bsVar) {
        mo7162e(bsVar.mo7189g());
        bsVar.mo7163a(this);
    }

    /* renamed from: b */
    public void mo7157b(byte[] bArr) {
        mo7158b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void mo7158b(byte[] bArr, int i, int i2) {
        if (this.f4320a.remaining() >= i2) {
            this.f4320a.put(bArr, i, i2);
            return;
        }
        throw new C0651bm(this.f4320a.position(), this.f4320a.limit());
    }

    /* renamed from: c */
    public void mo7159c(int i) {
        mo7145a((byte) i);
    }

    /* renamed from: c */
    public void mo7160c(int i, int i2) {
        mo7162e(C0660bv.m3839a(i, i2));
    }

    /* renamed from: c */
    public void mo7161c(long j) {
        while ((-128 & j) != 0) {
            mo7159c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        mo7159c((int) j);
    }

    /* renamed from: e */
    public void mo7162e(int i) {
        while ((i & -128) != 0) {
            mo7159c((i & 127) | 128);
            i >>>= 7;
        }
        mo7159c(i);
    }
}
