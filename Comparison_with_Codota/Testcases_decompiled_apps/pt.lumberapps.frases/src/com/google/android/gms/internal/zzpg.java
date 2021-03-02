package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.zzab;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class zzpg implements zzb.C2109zzb {

    /* renamed from: a */
    static Boolean f6768a = null;

    /* renamed from: c */
    private static final Charset f6769c = Charset.forName("UTF-8");

    /* renamed from: b */
    final C1787oa f6770b;

    public zzpg() {
        this(new C1787oa((Context) null));
    }

    public zzpg(Context context) {
        this(new C1787oa(context));
    }

    zzpg(C1787oa oaVar) {
        this.f6770b = (C1787oa) zzab.zzy(oaVar);
    }

    /* renamed from: a */
    static long m7404a(long j) {
        return zzpd.zzm(ByteBuffer.allocate(8).putLong(j).array());
    }

    /* renamed from: a */
    static long m7405a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return m7404a(j);
        }
        byte[] bytes = str.getBytes(f6769c);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return zzpd.zzm(allocate.array());
    }

    /* renamed from: a */
    static C1788ob m7406a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String str2 = "";
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            String valueOf = String.valueOf(str);
            Log.e("LogSamplerImpl", valueOf.length() != 0 ? "Failed to parse the rule: ".concat(valueOf) : new String("Failed to parse the rule: "));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new C1788ob(str2, parseLong, parseLong2);
            }
            Log.e("LogSamplerImpl", new StringBuilder(72).append("negative values not supported: ").append(parseLong).append("/").append(parseLong2).toString());
            return null;
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            String valueOf2 = String.valueOf(str);
            Log.e("LogSamplerImpl", valueOf2.length() != 0 ? "parseLong() failed while parsing: ".concat(valueOf2) : new String("parseLong() failed while parsing: "), numberFormatException);
            return null;
        }
    }

    /* renamed from: a */
    static boolean m7407a(long j, long j2, long j3) {
        if (j2 >= 0 && j3 >= 0) {
            return j3 > 0 && zzph.zzd(j, j3) < j2;
        }
        throw new IllegalArgumentException(new StringBuilder(72).append("negative values not supported: ").append(j2).append("/").append(j3).toString());
    }

    public boolean zzg(String str, int i) {
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        long a = this.f6770b.mo7596a();
        C1788ob a2 = m7406a(this.f6770b.mo7597a(str));
        if (a2 != null) {
            return m7407a(m7405a(a2.f5414a, a), a2.f5415b, a2.f5416c);
        }
        return true;
    }
}
