package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzi implements zzh {

    /* renamed from: a */
    private final Object f3687a = new Object();

    /* renamed from: b */
    private final zzq f3688b;

    /* renamed from: c */
    private final Context f3689c;

    /* renamed from: d */
    private final JSONObject f3690d;

    /* renamed from: e */
    private final zzih f3691e;

    /* renamed from: f */
    private final zzh.zza f3692f;

    /* renamed from: g */
    private final zzas f3693g;

    /* renamed from: h */
    private final VersionInfoParcel f3694h;

    /* renamed from: i */
    private boolean f3695i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public zzlh f3696j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f3697k;

    /* renamed from: l */
    private String f3698l;

    /* renamed from: m */
    private WeakReference f3699m = null;

    public zzi(Context context, zzq zzq, zzih zzih, zzas zzas, JSONObject jSONObject, zzh.zza zza, VersionInfoParcel versionInfoParcel, String str) {
        this.f3689c = context;
        this.f3688b = zzq;
        this.f3691e = zzih;
        this.f3693g = zzas;
        this.f3690d = jSONObject;
        this.f3692f = zza;
        this.f3694h = versionInfoParcel;
        this.f3698l = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzlh mo5368a() {
        return zzu.zzfr().zza(this.f3689c, AdSizeParcel.zzk(this.f3689c), false, false, this.f3693g, this.f3694h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5369a(boolean z) {
        this.f3695i = z;
    }

    public Context getContext() {
        return this.f3689c;
    }

    public void recordImpression() {
        zzab.zzhi("recordImpression must be called on the main UI thread.");
        mo5369a(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f3690d);
            jSONObject.put("ads_id", this.f3698l);
            this.f3691e.zza(new C1259c(this, jSONObject));
        } catch (JSONException e) {
            zzkd.zzb("Unable to create impression JSON.", e);
        }
        this.f3688b.zza((zzh) this);
    }

    public C1257a zza(View.OnClickListener onClickListener) {
        zza zzkx = this.f3692f.zzkx();
        if (zzkx == null) {
            return null;
        }
        C1257a aVar = new C1257a(this.f3689c, zzkx);
        aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        aVar.mo5309a().setOnClickListener(onClickListener);
        aVar.mo5309a().setContentDescription("Ad attribution icon");
        return aVar;
    }

    public void zza(View view, Map map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        if (((Boolean) zzdc.zzbci.get()).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            for (Map.Entry value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void zza(View view, Map map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzab.zzhi("performClick must be called on the main UI thread.");
        for (Map.Entry entry : map.entrySet()) {
            if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                zza((String) entry.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
        if ("2".equals(this.f3692f.zzkw())) {
            zza("2099", jSONObject, jSONObject2, jSONObject3);
        } else if ("1".equals(this.f3692f.zzkw())) {
            zza("1099", jSONObject, jSONObject2, jSONObject3);
        }
    }

    public void zza(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzab.zzhi("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.f3692f.zzkw());
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.f3690d);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.f3688b.zzv(this.f3692f.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            try {
                JSONObject optJSONObject = this.f3690d.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject4.put("click_signals", this.f3693g.zzaw().zzb(this.f3689c, optJSONObject.optString("click_string")));
            } catch (Exception e) {
                zzkd.zzb("Exception obtaining click signals", e);
            }
            jSONObject5.put("ads_id", this.f3698l);
            this.f3691e.zza(new C1258b(this, jSONObject5));
        } catch (JSONException e2) {
            zzkd.zzb("Unable to create click JSON.", e2);
        }
    }

    public void zzb(MotionEvent motionEvent) {
        this.f3693g.zza(motionEvent);
    }

    public void zzb(View view, Map map) {
        view.setOnTouchListener((View.OnTouchListener) null);
        view.setClickable(false);
        view.setOnClickListener((View.OnClickListener) null);
        for (Map.Entry value : map.entrySet()) {
            View view2 = (View) ((WeakReference) value.getValue()).get();
            if (view2 != null) {
                view2.setOnTouchListener((View.OnTouchListener) null);
                view2.setClickable(false);
                view2.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public void zzg(View view) {
        synchronized (this.f3687a) {
            if (!this.f3695i) {
                if (view.isShown()) {
                    if (view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                        recordImpression();
                    }
                }
            }
        }
    }

    public void zzh(View view) {
        this.f3699m = new WeakReference(view);
    }

    public zzlh zzlb() {
        this.f3696j = mo5368a();
        this.f3696j.getView().setVisibility(8);
        this.f3691e.zza(new C1260d(this));
        return this.f3696j;
    }

    public View zzlc() {
        if (this.f3699m != null) {
            return (View) this.f3699m.get();
        }
        return null;
    }
}
