package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzv {

    /* renamed from: a */
    private final String f3035a;

    private zzv(String str) {
        this.f3035a = str;
    }

    public static zzv zzcL(String str) {
        return new zzv(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo5599a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(mo5599a(it.next()));
            while (it.hasNext()) {
                sb.append(this.f3035a);
                sb.append(mo5599a(it.next()));
            }
        }
        return sb;
    }
}
