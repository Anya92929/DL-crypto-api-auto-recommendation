package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import java.util.Map;
import org.json.JSONObject;

@zzin
public class zzg extends zzi {

    /* renamed from: a */
    private zzgn f3681a;

    /* renamed from: b */
    private zzgo f3682b;

    /* renamed from: c */
    private final zzq f3683c;

    /* renamed from: d */
    private zzh f3684d;

    /* renamed from: e */
    private boolean f3685e;

    /* renamed from: f */
    private Object f3686f;

    private zzg(Context context, zzq zzq, zzas zzas) {
        super(context, zzq, (zzih) null, zzas, (JSONObject) null, (zzh.zza) null, (VersionInfoParcel) null, (String) null);
        this.f3685e = false;
        this.f3686f = new Object();
        this.f3683c = zzq;
    }

    public zzg(Context context, zzq zzq, zzas zzas, zzgn zzgn) {
        this(context, zzq, zzas);
        this.f3681a = zzgn;
    }

    public zzg(Context context, zzq zzq, zzas zzas, zzgo zzgo) {
        this(context, zzq, zzas);
        this.f3682b = zzgo;
    }

    public void recordImpression() {
        zzab.zzhi("recordImpression must be called on the main UI thread.");
        synchronized (this.f3686f) {
            mo5369a(true);
            if (this.f3684d != null) {
                this.f3684d.recordImpression();
                this.f3683c.recordImpression();
            } else {
                try {
                    if (this.f3681a != null && !this.f3681a.getOverrideImpressionRecording()) {
                        this.f3681a.recordImpression();
                        this.f3683c.recordImpression();
                    } else if (this.f3682b != null && !this.f3682b.getOverrideImpressionRecording()) {
                        this.f3682b.recordImpression();
                        this.f3683c.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzkd.zzd("Failed to call recordImpression", e);
                }
            }
        }
    }

    public C1257a zza(View.OnClickListener onClickListener) {
        return null;
    }

    public void zza(View view, Map map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.f3686f) {
            this.f3685e = true;
            try {
                if (this.f3681a != null) {
                    this.f3681a.zzl(zze.zzac(view));
                } else if (this.f3682b != null) {
                    this.f3682b.zzl(zze.zzac(view));
                }
            } catch (RemoteException e) {
                zzkd.zzd("Failed to call prepareAd", e);
            }
            this.f3685e = false;
        }
    }

    public void zza(View view, Map map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzab.zzhi("performClick must be called on the main UI thread.");
        synchronized (this.f3686f) {
            if (this.f3684d != null) {
                this.f3684d.zza(view, map, jSONObject, jSONObject2, jSONObject3);
                this.f3683c.onAdClicked();
            } else {
                try {
                    if (this.f3681a != null && !this.f3681a.getOverrideClickHandling()) {
                        this.f3681a.zzk(zze.zzac(view));
                        this.f3683c.onAdClicked();
                    }
                    if (this.f3682b != null && !this.f3682b.getOverrideClickHandling()) {
                        this.f3682b.zzk(zze.zzac(view));
                        this.f3683c.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzkd.zzd("Failed to call performClick", e);
                }
            }
        }
    }

    public void zzb(View view, Map map) {
        synchronized (this.f3686f) {
            try {
                if (this.f3681a != null) {
                    this.f3681a.zzm(zze.zzac(view));
                } else if (this.f3682b != null) {
                    this.f3682b.zzm(zze.zzac(view));
                }
            } catch (RemoteException e) {
                zzkd.zzd("Failed to call untrackView", e);
            }
        }
    }

    public void zzc(zzh zzh) {
        synchronized (this.f3686f) {
            this.f3684d = zzh;
        }
    }

    public boolean zzkz() {
        boolean z;
        synchronized (this.f3686f) {
            z = this.f3685e;
        }
        return z;
    }

    public zzh zzla() {
        zzh zzh;
        synchronized (this.f3686f) {
            zzh = this.f3684d;
        }
        return zzh;
    }

    public zzlh zzlb() {
        return null;
    }
}
