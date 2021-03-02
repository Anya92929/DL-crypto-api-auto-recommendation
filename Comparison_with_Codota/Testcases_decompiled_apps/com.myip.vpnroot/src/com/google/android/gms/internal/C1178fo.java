package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C0955bq;
import com.google.android.gms.internal.C1196fz;
import com.google.android.gms.internal.C1222go;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.fo */
public class C1178fo implements Callable<C1196fz> {
    private final Context mContext;

    /* renamed from: mw */
    private final Object f3583mw = new Object();

    /* renamed from: pw */
    private final C1735u f3584pw;

    /* renamed from: tX */
    private final C1222go f3585tX;

    /* renamed from: tY */
    private final C0899ai f3586tY;

    /* renamed from: tZ */
    private boolean f3587tZ;

    /* renamed from: tc */
    private int f3588tc;

    /* renamed from: tn */
    private final C1196fz.C1197a f3589tn;

    /* renamed from: ua */
    private List<String> f3590ua;

    /* renamed from: com.google.android.gms.internal.fo$a */
    public interface C1181a<T extends C0955bq.C0956a> {
        /* renamed from: a */
        T mo8523a(C1178fo foVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    public C1178fo(Context context, C1735u uVar, C0899ai aiVar, C1222go goVar, C1196fz.C1197a aVar) {
        this.mContext = context;
        this.f3584pw = uVar;
        this.f3585tX = goVar;
        this.f3586tY = aiVar;
        this.f3589tn = aVar;
        this.f3587tZ = false;
        this.f3588tc = -2;
        this.f3590ua = null;
    }

    /* renamed from: a */
    private C0955bq.C0956a m4470a(C0897ah ahVar, C1181a aVar, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (mo8516cI()) {
            return null;
        }
        String[] b = m4472b(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.f3590ua = b == null ? null : Arrays.asList(b);
        C0955bq.C0956a a = aVar.mo8523a(this, jSONObject);
        if (a == null) {
            C1229gs.m4676T("Failed to retrieve ad assets.");
            return null;
        }
        a.mo8137a(new C0955bq(this.f3584pw, ahVar, jSONObject));
        return a;
    }

    /* renamed from: a */
    private C1196fz m4471a(C0955bq.C0956a aVar) {
        int i;
        synchronized (this.f3583mw) {
            i = this.f3588tc;
            if (aVar == null && this.f3588tc == -2) {
                i = 0;
            }
        }
        return new C1196fz(this.f3589tn.f3691vv.f3539tx, (C1232gv) null, this.f3589tn.f3692vw.f3555qf, i, this.f3589tn.f3692vw.f3556qg, this.f3590ua, this.f3589tn.f3692vw.orientation, this.f3589tn.f3692vw.f3557qj, this.f3589tn.f3691vv.f3532tA, false, (C1003cl) null, (C1016cu) null, (String) null, (C1004cm) null, (C1006co) null, 0, this.f3589tn.f3686lH, this.f3589tn.f3692vw.f3561tH, this.f3589tn.f3689vs, this.f3589tn.f3690vt, this.f3589tn.f3692vw.f3567tN, this.f3589tn.f3687vp, i != -2 ? null : aVar);
    }

    /* renamed from: b */
    private String[] m4472b(JSONObject jSONObject, String str) throws JSONException {
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

    /* renamed from: c */
    private JSONObject m4473c(final C0897ah ahVar) throws TimeoutException, JSONException {
        if (mo8516cI()) {
            return null;
        }
        final C1216gk gkVar = new C1216gk();
        ahVar.mo7945a("/nativeAdPreProcess", (C0974by) new C0974by() {
            /* renamed from: a */
            public void mo7942a(C1232gv gvVar, Map<String, String> map) {
                ahVar.mo7949g("/nativeAdPreProcess");
                try {
                    String str = map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        gkVar.mo8592a(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (JSONException e) {
                    C1229gs.m4681b("Malformed native JSON response.", e);
                }
                C1178fo.this.mo8518s(0);
                C0348n.m852a(C1178fo.this.mo8516cI(), "Unable to set the ad state error!");
                gkVar.mo8592a(null);
            }
        });
        ahVar.mo7946a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.f3589tn.f3692vw.f3560tG));
        return (JSONObject) gkVar.get();
    }

    /* renamed from: cH */
    private C0897ah m4474cH() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (mo8516cI()) {
            return null;
        }
        C0897ah ahVar = this.f3586tY.mo7953a(this.mContext, this.f3589tn.f3691vv.f3529lD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        ahVar.mo7944a(this.f3584pw, this.f3584pw, this.f3584pw, this.f3584pw, false, this.f3584pw);
        return ahVar;
    }

    /* renamed from: a */
    public Future<Drawable> mo8512a(JSONObject jSONObject, String str, final boolean z) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        String string = z ? jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject2.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return this.f3585tX.mo8607a(string, new C1222go.C1225a<Drawable>() {
                /* renamed from: a */
                public Drawable mo8520b(InputStream inputStream) {
                    byte[] bArr;
                    try {
                        bArr = C1389jy.m5224d(inputStream);
                    } catch (IOException e) {
                        bArr = null;
                    }
                    if (bArr == null) {
                        C1178fo.this.mo8513a(2, z);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray != null) {
                        return new BitmapDrawable(Resources.getSystem(), decodeByteArray);
                    }
                    C1178fo.this.mo8513a(2, z);
                    return null;
                }

                /* renamed from: cJ */
                public Drawable mo8522cK() {
                    C1178fo.this.mo8513a(2, z);
                    return null;
                }
            });
        }
        mo8513a(0, z);
        return new C1217gl(null);
    }

    /* renamed from: a */
    public void mo8513a(int i, boolean z) {
        if (z) {
            mo8518s(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1181a mo8514b(JSONObject jSONObject) throws JSONException {
        if (mo8516cI()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        if ("2".equals(string)) {
            return new C1182fp();
        }
        if ("1".equals(string)) {
            return new C1183fq();
        }
        mo8518s(0);
        return null;
    }

    /* renamed from: cG */
    public C1196fz call() {
        try {
            C0897ah cH = m4474cH();
            JSONObject c = m4473c(cH);
            return m4471a(m4470a(cH, mo8514b(c), c));
        } catch (InterruptedException | CancellationException | ExecutionException e) {
        } catch (JSONException e2) {
            C1229gs.m4683d("Malformed native JSON response.", e2);
        } catch (TimeoutException e3) {
            C1229gs.m4683d("Timeout when loading native ad.", e3);
        }
        if (!this.f3587tZ) {
            mo8518s(0);
        }
        return m4471a((C0955bq.C0956a) null);
    }

    /* renamed from: cI */
    public boolean mo8516cI() {
        boolean z;
        synchronized (this.f3583mw) {
            z = this.f3587tZ;
        }
        return z;
    }

    /* renamed from: s */
    public void mo8518s(int i) {
        synchronized (this.f3583mw) {
            this.f3587tZ = true;
            this.f3588tc = i;
        }
    }
}
