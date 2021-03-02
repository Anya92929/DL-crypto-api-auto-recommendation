package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzy {

    /* renamed from: a */
    private final String f4619a;

    private zzy(String str) {
        this.f4619a = str;
    }

    public static zzy zzhq(String str) {
        return new zzy(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo6771a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String zza(Iterable iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(mo6771a(it.next()));
            while (it.hasNext()) {
                sb.append(this.f4619a);
                sb.append(mo6771a(it.next()));
            }
        }
        return sb;
    }
}
