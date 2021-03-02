package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzeq implements zzep {

    /* renamed from: a */
    private final Context f6152a;

    /* renamed from: b */
    private final VersionInfoParcel f6153b;

    public zzeq(Context context, VersionInfoParcel versionInfoParcel) {
        this.f6152a = context;
        this.f6153b = versionInfoParcel;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1566fw mo8336a(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", (String) null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzkd.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new C1565fv(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new C1566fw(optString, url, arrayList, optString3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1567fx mo8337a(C1566fw fwVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) fwVar.mo7270b().openConnection();
            zzu.zzfq().zza(this.f6152a, this.f6153b.zzcs, false, httpURLConnection);
            Iterator it = fwVar.mo7271c().iterator();
            while (it.hasNext()) {
                C1565fv fvVar = (C1565fv) it.next();
                httpURLConnection.addRequestProperty(fvVar.mo7267a(), fvVar.mo7268b());
            }
            if (!TextUtils.isEmpty(fwVar.mo7272d())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = fwVar.mo7272d().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String fvVar2 : (List) entry.getValue()) {
                        arrayList.add(new C1565fv((String) entry.getKey(), fvVar2));
                    }
                }
            }
            return new C1567fx(this, true, new C1568fy(fwVar.mo7269a(), httpURLConnection.getResponseCode(), arrayList, zzu.zzfq().zza(new InputStreamReader(httpURLConnection.getInputStream()))), (String) null);
        } catch (Exception e) {
            return new C1567fx(this, false, (C1568fy) null, e.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo8338a(C1568fy fyVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", fyVar.mo7276a());
            if (fyVar.mo7279d() != null) {
                jSONObject.put("body", fyVar.mo7279d());
            }
            JSONArray jSONArray = new JSONArray();
            for (C1565fv fvVar : fyVar.mo7278c()) {
                jSONArray.put(new JSONObject().put("key", fvVar.mo7267a()).put("value", fvVar.mo7268b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", fyVar.mo7277b());
        } catch (JSONException e) {
            zzkd.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(zzlh zzlh, Map map) {
        zzkg.zza((Runnable) new C1563ft(this, map, zzlh));
    }

    public JSONObject zzav(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "";
            try {
                str2 = jSONObject.optString("http_request_id");
                C1567fx a = mo8337a(mo8336a(jSONObject));
                if (a.mo7275c()) {
                    jSONObject2.put("response", mo8338a(a.mo7274b()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", a.mo7273a());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzkd.m5769e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }
}
