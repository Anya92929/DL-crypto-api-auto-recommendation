package com.google.android.gms.common.util;

import android.support.p009v4.p019f.C0136a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzf {
    /* renamed from: a */
    private static void m6199a(Object[] objArr, Object[] objArr2) {
        if (objArr.length != objArr2.length) {
            int length = objArr.length;
            throw new IllegalArgumentException(new StringBuilder(66).append("Key and values array lengths not equal: ").append(length).append(" != ").append(objArr2.length).toString());
        }
    }

    public static Map zza(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        C0136a aVar = new C0136a(6);
        aVar.put(obj, obj2);
        aVar.put(obj3, obj4);
        aVar.put(obj5, obj6);
        aVar.put(obj7, obj8);
        aVar.put(obj9, obj10);
        aVar.put(obj11, obj12);
        return Collections.unmodifiableMap(aVar);
    }

    public static Set zza(Object obj, Object obj2, Object obj3) {
        zza zza = new zza(3);
        zza.add(obj);
        zza.add(obj2);
        zza.add(obj3);
        return Collections.unmodifiableSet(zza);
    }

    public static Set zza(Object obj, Object obj2, Object obj3, Object obj4) {
        zza zza = new zza(4);
        zza.add(obj);
        zza.add(obj2);
        zza.add(obj3);
        zza.add(obj4);
        return Collections.unmodifiableSet(zza);
    }

    public static Set zzaa(Object obj) {
        return Collections.singleton(obj);
    }

    public static Set zzavk() {
        return Collections.emptySet();
    }

    public static Map zzavl() {
        return Collections.emptyMap();
    }

    public static Map zzb(Object[] objArr, Object[] objArr2) {
        m6199a(objArr, objArr2);
        int length = objArr.length;
        switch (length) {
            case 0:
                return zzavl();
            case 1:
                return zze(objArr[0], objArr2[0]);
            default:
                Map aVar = length <= 32 ? new C0136a(length) : new HashMap(length, 1.0f);
                for (int i = 0; i < length; i++) {
                    aVar.put(objArr[i], objArr2[i]);
                }
                return Collections.unmodifiableMap(aVar);
        }
    }

    public static List zzc(Object obj, Object obj2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(obj);
        arrayList.add(obj2);
        return Collections.unmodifiableList(arrayList);
    }

    public static Set zzc(Object... objArr) {
        switch (objArr.length) {
            case 0:
                return zzavk();
            case 1:
                return zzaa(objArr[0]);
            case 2:
                return zzd(objArr[0], objArr[1]);
            case 3:
                return zza(objArr[0], objArr[1], objArr[2]);
            case 4:
                return zza(objArr[0], objArr[1], objArr[2], objArr[3]);
            default:
                return Collections.unmodifiableSet(objArr.length <= 32 ? new zza((Collection) Arrays.asList(objArr)) : new HashSet(Arrays.asList(objArr)));
        }
    }

    public static Set zzd(Object obj, Object obj2) {
        zza zza = new zza(2);
        zza.add(obj);
        zza.add(obj2);
        return Collections.unmodifiableSet(zza);
    }

    public static Map zze(Object obj, Object obj2) {
        return Collections.singletonMap(obj, obj2);
    }

    public static List zzz(Object obj) {
        return Collections.singletonList(obj);
    }
}
