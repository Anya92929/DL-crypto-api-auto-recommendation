package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@zzin
public class zzcg implements zzch {

    /* renamed from: a */
    private final Object f6035a = new Object();

    /* renamed from: b */
    private final WeakHashMap f6036b = new WeakHashMap();

    /* renamed from: c */
    private final ArrayList f6037c = new ArrayList();

    /* renamed from: d */
    private final Context f6038d;

    /* renamed from: e */
    private final VersionInfoParcel f6039e;

    /* renamed from: f */
    private final zzfs f6040f;

    public zzcg(Context context, VersionInfoParcel versionInfoParcel, zzfs zzfs) {
        this.f6038d = context.getApplicationContext();
        this.f6039e = versionInfoParcel;
        this.f6040f = zzfs;
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzju zzju) {
        return zza(adSizeParcel, zzju, zzju.zzbtm.getView());
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzju zzju, View view) {
        return zza(adSizeParcel, zzju, (zzck) new zzcd.zzd(view, zzju), (zzft) null);
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzju zzju, View view, zzft zzft) {
        return zza(adSizeParcel, zzju, (zzck) new zzcd.zzd(view, zzju), zzft);
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzju zzju, zzh zzh) {
        return zza(adSizeParcel, zzju, (zzck) new zzcd.zza(zzh), (zzft) null);
    }

    public zzcd zza(AdSizeParcel adSizeParcel, zzju zzju, zzck zzck, zzft zzft) {
        zzcd zzcj;
        synchronized (this.f6035a) {
            if (zzh(zzju)) {
                zzcj = (zzcd) this.f6036b.get(zzju);
            } else {
                if (zzft != null) {
                    zzcj = new zzci(this.f6038d, adSizeParcel, zzju, this.f6039e, zzck, zzft);
                } else {
                    zzcj = new zzcj(this.f6038d, adSizeParcel, zzju, this.f6039e, zzck, this.f6040f);
                }
                zzcj.zza((zzch) this);
                this.f6036b.put(zzju, zzcj);
                this.f6037c.add(zzcj);
            }
        }
        return zzcj;
    }

    public void zza(zzcd zzcd) {
        synchronized (this.f6035a) {
            if (!zzcd.zzha()) {
                this.f6037c.remove(zzcd);
                Iterator it = this.f6036b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Map.Entry) it.next()).getValue() == zzcd) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzh(zzju zzju) {
        boolean z;
        synchronized (this.f6035a) {
            zzcd zzcd = (zzcd) this.f6036b.get(zzju);
            z = zzcd != null && zzcd.zzha();
        }
        return z;
    }

    public void zzi(zzju zzju) {
        synchronized (this.f6035a) {
            zzcd zzcd = (zzcd) this.f6036b.get(zzju);
            if (zzcd != null) {
                zzcd.zzgy();
            }
        }
    }

    public void zzj(zzju zzju) {
        synchronized (this.f6035a) {
            zzcd zzcd = (zzcd) this.f6036b.get(zzju);
            if (zzcd != null) {
                zzcd.stop();
            }
        }
    }

    public void zzk(zzju zzju) {
        synchronized (this.f6035a) {
            zzcd zzcd = (zzcd) this.f6036b.get(zzju);
            if (zzcd != null) {
                zzcd.pause();
            }
        }
    }

    public void zzl(zzju zzju) {
        synchronized (this.f6035a) {
            zzcd zzcd = (zzcd) this.f6036b.get(zzju);
            if (zzcd != null) {
                zzcd.resume();
            }
        }
    }
}
