package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzlh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzn extends zzkc {

    /* renamed from: a */
    static final long f3955a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b */
    static boolean f3956b = false;

    /* renamed from: c */
    private static final Object f3957c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static zzfs f3958d = null;

    /* renamed from: e */
    private static zzeq f3959e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static zzeu f3960f = null;

    /* renamed from: g */
    private static zzep f3961g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zza.C2105zza f3962h;

    /* renamed from: i */
    private final AdRequestInfoParcel.zza f3963i;

    /* renamed from: j */
    private final Object f3964j = new Object();

    /* renamed from: k */
    private final Context f3965k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public zzfs.zzc f3966l;

    public class zza implements zzkl {
        /* renamed from: zza */
        public void zzd(zzfp zzfp) {
            zzn.m5762b(zzfp);
        }
    }

    public class zzb implements zzkl {
        /* renamed from: zza */
        public void zzd(zzfp zzfp) {
            zzn.m5759a(zzfp);
        }
    }

    public class zzc implements zzep {
        public void zza(zzlh zzlh, Map map) {
            String str = (String) map.get("request_id");
            String valueOf = String.valueOf((String) map.get("errors"));
            zzkd.zzcx(valueOf.length() != 0 ? "Invalid request: ".concat(valueOf) : new String("Invalid request: "));
            zzn.f3960f.zzax(str);
        }
    }

    public zzn(Context context, AdRequestInfoParcel.zza zza2, zza.C2105zza zza3) {
        super(true);
        this.f3962h = zza3;
        this.f3965k = context;
        this.f3963i = zza2;
        synchronized (f3957c) {
            if (!f3956b) {
                f3960f = new zzeu();
                f3959e = new zzeq(context.getApplicationContext(), zza2.zzaow);
                f3961g = new zzc();
                f3958d = new zzfs(this.f3965k.getApplicationContext(), this.f3963i.zzaow, (String) zzdc.zzaxy.get(), new zzb(), new zza());
                f3956b = true;
            }
        }
    }

    /* renamed from: a */
    private AdResponseParcel m5754a(AdRequestInfoParcel adRequestInfoParcel) {
        String zzte = zzu.zzfq().zzte();
        JSONObject a = m5758a(adRequestInfoParcel, zzte);
        if (a == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzu.zzfu().elapsedRealtime();
        Future zzaw = f3960f.zzaw(zzte);
        com.google.android.gms.ads.internal.util.client.zza.zzcnb.post(new C1311l(this, a, zzte));
        try {
            JSONObject jSONObject = (JSONObject) zzaw.get(f3955a - (zzu.zzfu().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza2 = zziq.zza(this.f3965k, adRequestInfoParcel, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.body)) ? zza2 : new AdResponseParcel(3);
        } catch (InterruptedException | CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e2) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        }
    }

    /* renamed from: a */
    private JSONObject m5758a(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject zza2;
        AdvertisingIdClient.Info info;
        Bundle bundle = adRequestInfoParcel.zzcar.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzcar.extras.getString("sdk_less_network_id");
        if (bundle == null || (zza2 = zziq.zza(this.f3965k, adRequestInfoParcel, zzu.zzfw().zzy(this.f3965k), (zziz.zza) null, (Location) null, new zzcv((String) zzdc.zzaxy.get()), (String) null, new ArrayList(), (Bundle) null, (String) null)) == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.f3965k);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzkd.zzd("Cannot get advertising id info", e);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("network_id", string);
        hashMap.put("request_param", zza2);
        hashMap.put("data", bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzu.zzfq().zzam((Map) hashMap);
        } catch (JSONException e2) {
            return null;
        }
    }

    /* renamed from: a */
    protected static void m5759a(zzfp zzfp) {
        zzfp.zza("/loadAd", (zzep) f3960f);
        zzfp.zza("/fetchHttpRequest", (zzep) f3959e);
        zzfp.zza("/invalidRequest", f3961g);
    }

    /* renamed from: b */
    protected static void m5762b(zzfp zzfp) {
        zzfp.zzb("/loadAd", (zzep) f3960f);
        zzfp.zzb("/fetchHttpRequest", (zzep) f3959e);
        zzfp.zzb("/invalidRequest", f3961g);
    }

    public void onStop() {
        synchronized (this.f3964j) {
            com.google.android.gms.ads.internal.util.client.zza.zzcnb.post(new C1314o(this));
        }
    }

    public void zzew() {
        zzkd.zzcv("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.f3963i, (String) null, -1);
        AdResponseParcel a = m5754a(adRequestInfoParcel);
        com.google.android.gms.ads.internal.util.client.zza.zzcnb.post(new C1310k(this, new zzju.zza(adRequestInfoParcel, a, (zzga) null, (AdSizeParcel) null, a.errorCode, zzu.zzfu().elapsedRealtime(), a.zzccc, (JSONObject) null)));
    }
}
