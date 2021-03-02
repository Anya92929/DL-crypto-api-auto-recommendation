package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzf;
import java.util.regex.Pattern;

public class zzw {

    /* renamed from: a */
    private static final Pattern f4740a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzib(String str) {
        return str == null || zzf.f4557xN.zzb(str);
    }
}
