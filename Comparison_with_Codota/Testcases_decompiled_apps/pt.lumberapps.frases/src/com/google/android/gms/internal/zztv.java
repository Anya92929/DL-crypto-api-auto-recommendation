package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class zztv {

    /* renamed from: a */
    private final int f6994a;

    /* renamed from: b */
    private final String f6995b;

    /* renamed from: c */
    private final Object f6996c;

    public class zza extends zztv {
        public zza(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        /* renamed from: zzb */
        public Boolean zza(zzty zzty) {
            try {
                return Boolean.valueOf(zzty.getBooleanFlagValue(getKey(), ((Boolean) zzjw()).booleanValue(), getSource()));
            } catch (RemoteException e) {
                return (Boolean) zzjw();
            }
        }
    }

    public class zzb extends zztv {
        public zzb(int i, String str, Integer num) {
            super(i, str, num);
        }

        /* renamed from: zzc */
        public Integer zza(zzty zzty) {
            try {
                return Integer.valueOf(zzty.getIntFlagValue(getKey(), ((Integer) zzjw()).intValue(), getSource()));
            } catch (RemoteException e) {
                return (Integer) zzjw();
            }
        }
    }

    public class zzc extends zztv {
        public zzc(int i, String str, Long l) {
            super(i, str, l);
        }

        /* renamed from: zzd */
        public Long zza(zzty zzty) {
            try {
                return Long.valueOf(zzty.getLongFlagValue(getKey(), ((Long) zzjw()).longValue(), getSource()));
            } catch (RemoteException e) {
                return (Long) zzjw();
            }
        }
    }

    public class zzd extends zztv {
        public zzd(int i, String str, String str2) {
            super(i, str, str2);
        }

        /* renamed from: zze */
        public String zza(zzty zzty) {
            try {
                return zzty.getStringFlagValue(getKey(), (String) zzjw(), getSource());
            } catch (RemoteException e) {
                return (String) zzjw();
            }
        }
    }

    private zztv(int i, String str, Object obj) {
        this.f6994a = i;
        this.f6995b = str;
        this.f6996c = obj;
        zztz.zzbet().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public Object get() {
        return zztz.zzbeu().zzb(this);
    }

    public String getKey() {
        return this.f6995b;
    }

    public int getSource() {
        return this.f6994a;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(zzty zzty);

    public Object zzjw() {
        return this.f6996c;
    }
}
