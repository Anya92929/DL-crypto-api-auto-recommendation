package com.google.android.gms.internal;

import android.support.p001v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzsn {

    /* renamed from: a */
    private final ByteBuffer f3281a;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzsn(ByteBuffer byteBuffer) {
        this.f3281a = byteBuffer;
        this.f3281a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzsn(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: a */
    private static int m4081a(CharSequence charSequence) {
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
                    i3 += m4082a(charSequence, i2);
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
    private static int m4082a(CharSequence charSequence, int i) {
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
    private static int m4083a(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            } else if (55296 > charAt2 || charAt2 > 57343 || (i4 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i6);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i4);
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    /* renamed from: a */
    private static void m4084a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m4083a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m4085b(charSequence, byteBuffer);
        }
    }

    /* renamed from: b */
    private static void m4085b(CharSequence charSequence, ByteBuffer byteBuffer) {
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

    public static int zzC(int i, int i2) {
        return zzmA(i) + zzmx(i2);
    }

    public static int zzD(int i, int i2) {
        return zzmA(i) + zzmy(i2);
    }

    public static zzsn zzE(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzG(byte[] bArr) {
        return zzmC(bArr.length) + bArr.length;
    }

    public static int zzaA(boolean z) {
        return 1;
    }

    public static int zzar(long j) {
        return zzav(j);
    }

    public static int zzas(long j) {
        return zzav(j);
    }

    public static int zzat(long j) {
        return zzav(zzax(j));
    }

    public static int zzav(long j) {
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

    public static long zzax(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzb(int i, double d) {
        return zzmA(i) + zzl(d);
    }

    public static int zzb(int i, zzsu zzsu) {
        return (zzmA(i) * 2) + zzd(zzsu);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzmA(i) + zzG(bArr);
    }

    public static zzsn zzb(byte[] bArr, int i, int i2) {
        return new zzsn(bArr, i, i2);
    }

    public static int zzc(int i, float f) {
        return zzmA(i) + zzk(f);
    }

    public static int zzc(int i, zzsu zzsu) {
        return zzmA(i) + zze(zzsu);
    }

    public static int zzd(int i, long j) {
        return zzmA(i) + zzas(j);
    }

    public static int zzd(zzsu zzsu) {
        return zzsu.getSerializedSize();
    }

    public static int zze(int i, long j) {
        return zzmA(i) + zzat(j);
    }

    public static int zze(zzsu zzsu) {
        int serializedSize = zzsu.getSerializedSize();
        return serializedSize + zzmC(serializedSize);
    }

    public static int zzf(int i, boolean z) {
        return zzmA(i) + zzaA(z);
    }

    public static int zzgO(String str) {
        int a = m4081a(str);
        return a + zzmC(a);
    }

    public static int zzk(float f) {
        return 4;
    }

    public static int zzl(double d) {
        return 8;
    }

    public static int zzmA(int i) {
        return zzmC(zzsx.m4114a(i, 0));
    }

    public static int zzmC(int i) {
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

    public static int zzmE(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzmx(int i) {
        if (i >= 0) {
            return zzmC(i);
        }
        return 10;
    }

    public static int zzmy(int i) {
        return zzmC(zzmE(i));
    }

    public static int zzo(int i, String str) {
        return zzmA(i) + zzgO(str);
    }

    public void zzA(int i, int i2) throws IOException {
        zzE(i, 0);
        zzmv(i2);
    }

    public void zzB(int i, int i2) throws IOException {
        zzE(i, 0);
        zzmw(i2);
    }

    public void zzE(int i, int i2) throws IOException {
        zzmB(zzsx.m4114a(i, i2));
    }

    public void zzF(byte[] bArr) throws IOException {
        zzmB(bArr.length);
        zzH(bArr);
    }

    public void zzH(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public int zzJn() {
        return this.f3281a.remaining();
    }

    public void zzJo() {
        if (zzJn() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzE(i, 1);
        zzk(d);
    }

    public void zza(int i, long j) throws IOException {
        zzE(i, 0);
        zzao(j);
    }

    public void zza(int i, zzsu zzsu) throws IOException {
        zzE(i, 2);
        zzc(zzsu);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzE(i, 2);
        zzF(bArr);
    }

    public void zzao(long j) throws IOException {
        zzau(j);
    }

    public void zzap(long j) throws IOException {
        zzau(j);
    }

    public void zzaq(long j) throws IOException {
        zzau(zzax(j));
    }

    public void zzau(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzmz((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzmz((int) j);
    }

    public void zzaw(long j) throws IOException {
        if (this.f3281a.remaining() < 8) {
            throw new zza(this.f3281a.position(), this.f3281a.limit());
        }
        this.f3281a.putLong(j);
    }

    public void zzaz(boolean z) throws IOException {
        zzmz(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        if (!this.f3281a.hasRemaining()) {
            throw new zza(this.f3281a.position(), this.f3281a.limit());
        }
        this.f3281a.put(b);
    }

    public void zzb(int i, float f) throws IOException {
        zzE(i, 5);
        zzj(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzE(i, 0);
        zzap(j);
    }

    public void zzb(zzsu zzsu) throws IOException {
        zzsu.writeTo(this);
    }

    public void zzc(int i, long j) throws IOException {
        zzE(i, 0);
        zzaq(j);
    }

    public void zzc(zzsu zzsu) throws IOException {
        zzmB(zzsu.getCachedSize());
        zzsu.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3281a.remaining() >= i2) {
            this.f3281a.put(bArr, i, i2);
            return;
        }
        throw new zza(this.f3281a.position(), this.f3281a.limit());
    }

    public void zze(int i, boolean z) throws IOException {
        zzE(i, 0);
        zzaz(z);
    }

    public void zzgN(String str) throws IOException {
        try {
            int zzmC = zzmC(str.length());
            if (zzmC == zzmC(str.length() * 3)) {
                int position = this.f3281a.position();
                if (this.f3281a.remaining() < zzmC) {
                    throw new zza(zzmC + position, this.f3281a.limit());
                }
                this.f3281a.position(position + zzmC);
                m4084a((CharSequence) str, this.f3281a);
                int position2 = this.f3281a.position();
                this.f3281a.position(position);
                zzmB((position2 - position) - zzmC);
                this.f3281a.position(position2);
                return;
            }
            zzmB(m4081a(str));
            m4084a((CharSequence) str, this.f3281a);
        } catch (BufferOverflowException e) {
            zza zza2 = new zza(this.f3281a.position(), this.f3281a.limit());
            zza2.initCause(e);
            throw zza2;
        }
    }

    public void zzj(float f) throws IOException {
        zzmD(Float.floatToIntBits(f));
    }

    public void zzk(double d) throws IOException {
        zzaw(Double.doubleToLongBits(d));
    }

    public void zzmB(int i) throws IOException {
        while ((i & -128) != 0) {
            zzmz((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzmz(i);
    }

    public void zzmD(int i) throws IOException {
        if (this.f3281a.remaining() < 4) {
            throw new zza(this.f3281a.position(), this.f3281a.limit());
        }
        this.f3281a.putInt(i);
    }

    public void zzmv(int i) throws IOException {
        if (i >= 0) {
            zzmB(i);
        } else {
            zzau((long) i);
        }
    }

    public void zzmw(int i) throws IOException {
        zzmB(zzmE(i));
    }

    public void zzmz(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzn(int i, String str) throws IOException {
        zzE(i, 2);
        zzgN(str);
    }
}
