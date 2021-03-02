package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzju;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzii implements Callable {

    /* renamed from: a */
    private static final long f6411a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: b */
    private final Context f6412b;

    /* renamed from: c */
    private final zzkn f6413c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzq f6414d;

    /* renamed from: e */
    private final zzas f6415e;

    /* renamed from: f */
    private final zzih f6416f;

    /* renamed from: g */
    private final Object f6417g = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzju.zza f6418h;

    /* renamed from: i */
    private boolean f6419i;

    /* renamed from: j */
    private int f6420j;

    /* renamed from: k */
    private List f6421k;

    /* renamed from: l */
    private JSONObject f6422l;

    public interface zza {
        zzh.zza zza(zzii zzii, JSONObject jSONObject);
    }

    public zzii(Context context, zzq zzq, zzkn zzkn, zzas zzas, zzju.zza zza2) {
        this.f6412b = context;
        this.f6414d = zzq;
        this.f6413c = zzkn;
        this.f6418h = zza2;
        this.f6415e = zzas;
        this.f6416f = mo8517a(context, zza2, zzq, zzas);
        this.f6416f.zzqg();
        this.f6419i = false;
        this.f6420j = -2;
        this.f6421k = null;
    }

    /* renamed from: a */
    private zzh.zza m7188a(zza zza2, JSONObject jSONObject, String str) {
        if (zzqs()) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] b = m7200b(jSONObject2, "impression_tracking_urls");
        this.f6421k = b == null ? null : Arrays.asList(b);
        this.f6422l = jSONObject2.optJSONObject("active_view");
        zzh.zza zza3 = zza2.zza(this, jSONObject);
        if (zza3 == null) {
            zzkd.m5769e("Failed to retrieve ad assets.");
            return null;
        }
        zza3.zzb(new zzi(this.f6412b, this.f6414d, this.f6416f, this.f6415e, jSONObject, zza3, this.f6418h.zzcip.zzaow, str));
        return zza3;
    }

    /* renamed from: a */
    private zzky m7190a(JSONObject jSONObject, boolean z, boolean z2) {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzkw(new zzc((Drawable) null, Uri.parse(string), optDouble)) : this.f6413c.zza(string, new C1693ko(this, z, optDouble, string));
        }
        zza(0, z);
        return new zzkw((Object) null);
    }

    /* renamed from: a */
    private Integer m7191a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m7193a(String str) {
        if (zzqs()) {
            return null;
        }
        zzkv zzkv = new zzkv();
        this.f6416f.zza(new C1687ki(this, new C1694kp(this), zzkv, str));
        return (JSONObject) zzkv.get(f6411a, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    private void m7194a(zzh.zza zza2) {
        if (zza2 instanceof zzf) {
            C1694kp kpVar = new C1694kp(this);
            C1690kl klVar = new C1690kl(this, (zzf) zza2);
            kpVar.f5235a = klVar;
            this.f6416f.zza(new C1691km(this, klVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7195a(zzdz zzdz, String str) {
        try {
            zzed zzv = this.f6414d.zzv(zzdz.getCustomTemplateId());
            if (zzv != null) {
                zzv.zza(zzdz, str);
            }
        } catch (RemoteException e) {
            zzkd.zzd(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    /* renamed from: b */
    private zzju m7198b(zzh.zza zza2) {
        int i;
        synchronized (this.f6417g) {
            i = this.f6420j;
            if (zza2 == null && this.f6420j == -2) {
                i = 0;
            }
        }
        return new zzju(this.f6418h.zzcip.zzcar, (zzlh) null, this.f6418h.zzciq.zzbnm, i, this.f6418h.zzciq.zzbnn, this.f6421k, this.f6418h.zzciq.orientation, this.f6418h.zzciq.zzbns, this.f6418h.zzcip.zzcau, false, (zzfz) null, (zzgk) null, (String) null, (zzga) null, (zzgc) null, 0, this.f6418h.zzapa, this.f6418h.zzciq.zzcbx, this.f6418h.zzcik, this.f6418h.zzcil, this.f6418h.zzciq.zzccd, this.f6422l, i != -2 ? null : zza2, (RewardItemParcel) null, (List) null, (List) null, this.f6418h.zzciq.zzccq, this.f6418h.zzciq.zzccr, (String) null, this.f6418h.zzciq.zzbnp);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List m7199b(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Drawable) zze.zzad(((zzc) it.next()).zzkt()));
        }
        return arrayList;
    }

    /* renamed from: b */
    private String[] m7200b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzih mo8517a(Context context, zzju.zza zza2, zzq zzq, zzas zzas) {
        return new zzih(context, zza2, zzq, zzas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zza mo8518a(JSONObject jSONObject) {
        if (zzqs()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.f6418h.zzcip.zzapo != null ? this.f6418h.zzcip.zzapo.zzbgp : false;
        boolean z2 = this.f6418h.zzcip.zzapo != null ? this.f6418h.zzcip.zzapo.zzbgr : false;
        if ("2".equals(string)) {
            return new zzij(z, z2);
        }
        if ("1".equals(string)) {
            return new zzik(z, z2);
        }
        if ("3".equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            zzkv zzkv = new zzkv();
            zzkh.zzclc.post(new C1689kk(this, zzkv, string2));
            if (zzkv.get(f6411a, TimeUnit.MILLISECONDS) != null) {
                return new zzil(z);
            }
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            zzkd.m5769e(valueOf.length() != 0 ? "No handler for custom template: ".concat(valueOf) : new String("No handler for custom template: "));
        } else {
            zzan(0);
        }
        return null;
    }

    public zzky zza(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m7190a(jSONObject2, z, z2);
    }

    public List zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(m7190a(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future zza(JSONObject jSONObject, String str, boolean z) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m7190a(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzan(i);
        }
    }

    public void zzan(int i) {
        synchronized (this.f6417g) {
            this.f6419i = true;
            this.f6420j = i;
        }
    }

    public zzky zzg(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzkw((Object) null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer a = m7191a(optJSONObject, "text_color");
        Integer a2 = m7191a(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.f6418h.zzcip.zzapo == null || this.f6418h.zzcip.zzapo.versionCode < 2) ? 1 : this.f6418h.zzcip.zzapo.zzbgs;
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzkx.zza(zzkx.zzn(arrayList), new C1692kn(this, optString, a2, a, optInt, optInt3, optInt2, i));
    }

    /* renamed from: zzqr */
    public zzju call() {
        try {
            this.f6416f.zzqh();
            String uuid = UUID.randomUUID().toString();
            JSONObject a = m7193a(uuid);
            zzh.zza a2 = m7188a(mo8518a(a), a, uuid);
            m7194a(a2);
            return m7198b(a2);
        } catch (InterruptedException | CancellationException | ExecutionException e) {
        } catch (JSONException e2) {
            zzkd.zzd("Malformed native JSON response.", e2);
        } catch (TimeoutException e3) {
            zzkd.zzd("Timeout when loading native ad.", e3);
        }
        if (!this.f6419i) {
            zzan(0);
        }
        return m7198b((zzh.zza) null);
    }

    public boolean zzqs() {
        boolean z;
        synchronized (this.f6417g) {
            z = this.f6419i;
        }
        return z;
    }
}
