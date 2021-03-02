package com.google.android.gms.common.internal;

import java.util.Arrays;

public abstract class zzf {

    /* renamed from: xN */
    public static final zzf f4557xN = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(8192, 8202));

    /* renamed from: xO */
    public static final zzf f4558xO = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(8192, 8198)).zza(zza(8200, 8202));

    /* renamed from: xP */
    public static final zzf f4559xP = zza(0, 127);

    /* renamed from: xQ */
    public static final zzf f4560xQ;

    /* renamed from: xR */
    public static final zzf f4561xR = zza(9, 13).zza(zza(28, ' ')).zza(zzc(5760)).zza(zzc(6158)).zza(zza(8192, 8198)).zza(zza(8200, 8203)).zza(zza(8232, 8233)).zza(zzc(8287)).zza(zzc(12288));

    /* renamed from: xS */
    public static final zzf f4562xS = new C1366e();

    /* renamed from: xT */
    public static final zzf f4563xT = new C1372k();

    /* renamed from: xU */
    public static final zzf f4564xU = new C1373l();

    /* renamed from: xV */
    public static final zzf f4565xV = new C1374m();

    /* renamed from: xW */
    public static final zzf f4566xW = new C1375n();

    /* renamed from: xX */
    public static final zzf f4567xX = zza(0, 31).zza(zza(127, 159));

    /* renamed from: xY */
    public static final zzf f4568xY = zza(0, ' ').zza(zza(127, 160)).zza(zzc(173)).zza(zza(1536, 1539)).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(8192, 8207)).zza(zza(8232, 8239)).zza(zza(8287, 8292)).zza(zza(8298, 8303)).zza(zzc(12288)).zza(zza(55296, 63743)).zza(zza((CharSequence) "﻿￹￺￻"));

    /* renamed from: xZ */
    public static final zzf f4569xZ = zza(0, 1273).zza(zzc(1470)).zza(zza(1488, 1514)).zza(zzc(1523)).zza(zzc(1524)).zza(zza(1536, 1791)).zza(zza(1872, 1919)).zza(zza(3584, 3711)).zza(zza(7680, 8367)).zza(zza(8448, 8506)).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));

    /* renamed from: ya */
    public static final zzf f4570ya = new C1376o();

    /* renamed from: yb */
    public static final zzf f4571yb = new C1367f();

    static {
        zzf zza = zza('0', '9');
        zzf zzf = zza;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzf = zzf.zza(zza(c, (char) (c + 9)));
        }
        f4560xQ = zzf;
    }

    public static zzf zza(char c, char c2) {
        zzab.zzbo(c2 >= c);
        return new C1371j(c, c2);
    }

    public static zzf zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f4571yb;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                return new C1369h(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new C1370i(charArray);
        }
    }

    public static zzf zzc(char c) {
        return new C1368g(c);
    }

    public zzf zza(zzf zzf) {
        return new C1377p(Arrays.asList(new zzf[]{this, (zzf) zzab.zzy(zzf)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
