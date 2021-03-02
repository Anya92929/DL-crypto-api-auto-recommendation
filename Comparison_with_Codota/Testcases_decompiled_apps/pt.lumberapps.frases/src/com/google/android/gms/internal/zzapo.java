package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;
import android.support.p021v7.p023b.C0515k;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzapo {

    /* renamed from: a */
    private final ByteBuffer f5894a;

    public class zza extends IOException {
        zza(int i, int i2) {
            super(new StringBuilder(C0515k.AppCompatTheme_ratingBarStyle).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i).append(" limit ").append(i2).append(").").toString());
        }
    }

    private zzapo(ByteBuffer byteBuffer) {
        this.f5894a = byteBuffer;
        this.f5894a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzapo(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: a */
    private static int m6786a(CharSequence charSequence) {
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
                    i3 += m6787a(charSequence, i2);
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
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i3) + 4294967296L).toString());
    }

    /* renamed from: a */
    private static int m6787a(CharSequence charSequence, int i) {
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
                        throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    /* renamed from: a */
    private static int m6788a(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
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
                        bArr[i10] = (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        i3 = i12 + 1;
                        bArr[i12] = (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4 - 1).toString());
            } else {
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i6).toString());
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    /* renamed from: a */
    private static void m6789a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m6788a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m6790b(charSequence, byteBuffer);
        }
    }

    /* renamed from: b */
    private static void m6790b(CharSequence charSequence, ByteBuffer byteBuffer) {
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
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        byteBuffer.put((byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i - 1).toString());
            }
            i++;
        }
    }

    public static int zzafx(int i) {
        if (i >= 0) {
            return zzagc(i);
        }
        return 10;
    }

    public static int zzafy(int i) {
        return zzagc(zzage(i));
    }

    public static int zzag(int i, int i2) {
        return zzaga(i) + zzafx(i2);
    }

    public static int zzaga(int i) {
        return zzagc(zzapy.zzaj(i, 0));
    }

    public static int zzagc(int i) {
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

    public static int zzage(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzah(int i, int i2) {
        return zzaga(i) + zzafy(i2);
    }

    public static int zzb(int i, double d) {
        return zzaga(i) + zzp(d);
    }

    public static int zzb(int i, zzapv zzapv) {
        return (zzaga(i) * 2) + zzd(zzapv);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzaga(i) + zzbg(bArr);
    }

    public static zzapo zzbe(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    public static int zzbg(byte[] bArr) {
        return zzagc(bArr.length) + bArr.length;
    }

    public static int zzc(int i, zzapv zzapv) {
        return zzaga(i) + zze(zzapv);
    }

    public static zzapo zzc(byte[] bArr, int i, int i2) {
        return new zzapo(bArr, i, i2);
    }

    public static int zzcx(long j) {
        return zzdc(j);
    }

    public static int zzcy(long j) {
        return zzdc(j);
    }

    public static int zzcz(long j) {
        return 8;
    }

    public static int zzd(int i, float f) {
        return zzaga(i) + zzl(f);
    }

    public static int zzd(zzapv zzapv) {
        return zzapv.mo8049aM();
    }

    public static int zzda(long j) {
        return zzdc(zzde(j));
    }

    public static int zzdc(long j) {
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

    public static long zzde(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzdg(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzaga(i) + zzcy(j);
    }

    public static int zze(zzapv zzapv) {
        int aM = zzapv.mo8049aM();
        return aM + zzagc(aM);
    }

    public static int zzf(int i, long j) {
        return zzaga(i) + zzcz(j);
    }

    public static int zzg(int i, long j) {
        return zzaga(i) + zzda(j);
    }

    public static int zzk(int i, boolean z) {
        return zzaga(i) + zzdg(z);
    }

    public static int zzl(float f) {
        return 4;
    }

    public static int zzp(double d) {
        return 8;
    }

    public static int zzs(int i, String str) {
        return zzaga(i) + zztx(str);
    }

    public static int zztx(String str) {
        int a = m6786a(str);
        return a + zzagc(a);
    }

    /* renamed from: ay */
    public int mo7987ay() {
        return this.f5894a.remaining();
    }

    /* renamed from: az */
    public void mo7988az() {
        if (mo7987ay() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) {
        zzai(i, 1);
        zzo(d);
    }

    public void zza(int i, long j) {
        zzai(i, 0);
        zzct(j);
    }

    public void zza(int i, zzapv zzapv) {
        zzai(i, 2);
        zzc(zzapv);
    }

    public void zza(int i, byte[] bArr) {
        zzai(i, 2);
        zzbf(bArr);
    }

    public void zzae(int i, int i2) {
        zzai(i, 0);
        zzafv(i2);
    }

    public void zzaf(int i, int i2) {
        zzai(i, 0);
        zzafw(i2);
    }

    public void zzafv(int i) {
        if (i >= 0) {
            zzagb(i);
        } else {
            zzdb((long) i);
        }
    }

    public void zzafw(int i) {
        zzagb(zzage(i));
    }

    public void zzafz(int i) {
        zzc((byte) i);
    }

    public void zzagb(int i) {
        while ((i & -128) != 0) {
            zzafz((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        zzafz(i);
    }

    public void zzagd(int i) {
        if (this.f5894a.remaining() < 4) {
            throw new zza(this.f5894a.position(), this.f5894a.limit());
        }
        this.f5894a.putInt(i);
    }

    public void zzai(int i, int i2) {
        zzagb(zzapy.zzaj(i, i2));
    }

    public void zzb(int i, long j) {
        zzai(i, 0);
        zzcu(j);
    }

    public void zzb(zzapv zzapv) {
        zzapv.zza(this);
    }

    public void zzbf(byte[] bArr) {
        zzagb(bArr.length);
        zzbh(bArr);
    }

    public void zzbh(byte[] bArr) {
        zzd(bArr, 0, bArr.length);
    }

    public void zzc(byte b) {
        if (!this.f5894a.hasRemaining()) {
            throw new zza(this.f5894a.position(), this.f5894a.limit());
        }
        this.f5894a.put(b);
    }

    public void zzc(int i, float f) {
        zzai(i, 5);
        zzk(f);
    }

    public void zzc(int i, long j) {
        zzai(i, 1);
        zzcv(j);
    }

    public void zzc(zzapv zzapv) {
        zzagb(zzapv.mo8048aL());
        zzapv.zza(this);
    }

    public void zzct(long j) {
        zzdb(j);
    }

    public void zzcu(long j) {
        zzdb(j);
    }

    public void zzcv(long j) {
        zzdd(j);
    }

    public void zzcw(long j) {
        zzdb(zzde(j));
    }

    public void zzd(int i, long j) {
        zzai(i, 0);
        zzcw(j);
    }

    public void zzd(byte[] bArr, int i, int i2) {
        if (this.f5894a.remaining() >= i2) {
            this.f5894a.put(bArr, i, i2);
            return;
        }
        throw new zza(this.f5894a.position(), this.f5894a.limit());
    }

    public void zzdb(long j) {
        while ((-128 & j) != 0) {
            zzafz((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        zzafz((int) j);
    }

    public void zzdd(long j) {
        if (this.f5894a.remaining() < 8) {
            throw new zza(this.f5894a.position(), this.f5894a.limit());
        }
        this.f5894a.putLong(j);
    }

    public void zzdf(boolean z) {
        zzafz(z ? 1 : 0);
    }

    public void zzj(int i, boolean z) {
        zzai(i, 0);
        zzdf(z);
    }

    public void zzk(float f) {
        zzagd(Float.floatToIntBits(f));
    }

    public void zzo(double d) {
        zzdd(Double.doubleToLongBits(d));
    }

    public void zzr(int i, String str) {
        zzai(i, 2);
        zztw(str);
    }

    public void zztw(String str) {
        try {
            int zzagc = zzagc(str.length());
            if (zzagc == zzagc(str.length() * 3)) {
                int position = this.f5894a.position();
                if (this.f5894a.remaining() < zzagc) {
                    throw new zza(zzagc + position, this.f5894a.limit());
                }
                this.f5894a.position(position + zzagc);
                m6789a((CharSequence) str, this.f5894a);
                int position2 = this.f5894a.position();
                this.f5894a.position(position);
                zzagb((position2 - position) - zzagc);
                this.f5894a.position(position2);
                return;
            }
            zzagb(m6786a(str));
            m6789a((CharSequence) str, this.f5894a);
        } catch (BufferOverflowException e) {
            zza zza2 = new zza(this.f5894a.position(), this.f5894a.limit());
            zza2.initCause(e);
            throw zza2;
        }
    }
}
