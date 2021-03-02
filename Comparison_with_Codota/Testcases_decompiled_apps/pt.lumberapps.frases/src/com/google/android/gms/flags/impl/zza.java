package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzua;

public abstract class zza {

    /* renamed from: com.google.android.gms.flags.impl.zza$zza  reason: collision with other inner class name */
    public class C2111zza extends zza {
        public static Boolean zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) zzua.zzb(new C1398a(sharedPreferences, str, bool));
        }
    }

    public class zzb extends zza {
        public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) zzua.zzb(new C1399b(sharedPreferences, str, num));
        }
    }

    public class zzc extends zza {
        public static Long zza(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) zzua.zzb(new C1400c(sharedPreferences, str, l));
        }
    }

    public class zzd extends zza {
        public static String zza(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) zzua.zzb(new C1401d(sharedPreferences, str, str2));
        }
    }
}
