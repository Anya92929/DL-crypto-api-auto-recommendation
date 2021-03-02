package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsz;
import java.util.ArrayList;

public class zzb {

    /* renamed from: a */
    private final ArrayList<zza> f3575a;

    /* renamed from: b */
    private int f3576b;

    public static class zza {
        public final PlayLoggerContext zzbdG;
        public final LogEvent zzbdH;
        public final zzsz.zzd zzbdI;

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            this.zzbdG = (PlayLoggerContext) zzx.zzz(playLoggerContext);
            this.zzbdH = (LogEvent) zzx.zzz(logEvent);
            this.zzbdI = null;
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        this.f3575a = new ArrayList<>();
        this.f3576b = i;
    }

    /* renamed from: a */
    private void m4232a() {
        while (getSize() > getCapacity()) {
            this.f3575a.remove(0);
        }
    }

    public void clear() {
        this.f3575a.clear();
    }

    public int getCapacity() {
        return this.f3576b;
    }

    public int getSize() {
        return this.f3575a.size();
    }

    public boolean isEmpty() {
        return this.f3575a.isEmpty();
    }

    public ArrayList<zza> zzEU() {
        return this.f3575a;
    }

    public void zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.f3575a.add(new zza(playLoggerContext, logEvent));
        m4232a();
    }
}
