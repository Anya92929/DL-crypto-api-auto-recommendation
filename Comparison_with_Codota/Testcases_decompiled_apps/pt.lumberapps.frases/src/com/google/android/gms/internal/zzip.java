package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zziz;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public final class zzip extends zzk.zza {

    /* renamed from: a */
    private static final Object f6432a = new Object();

    /* renamed from: b */
    private static zzip f6433b;

    /* renamed from: c */
    private final Context f6434c;

    /* renamed from: d */
    private final zzio f6435d;

    /* renamed from: e */
    private final zzcv f6436e;

    /* renamed from: f */
    private final zzfs f6437f;

    zzip(Context context, zzcv zzcv, zzio zzio) {
        this.f6434c = context;
        this.f6435d = zzio;
        this.f6436e = zzcv;
        this.f6437f = new zzfs(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(9452208, 9452208, true), zzcv.zzjv(), new C1700kv(this), new zzfs.zzb());
    }

    /* renamed from: a */
    private static Location m7212a(zzky zzky) {
        try {
            return (Location) zzky.get(((Long) zzdc.zzbcp.get()).longValue(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            zzkd.zzd("Exception caught while getting location", e);
            return null;
        }
    }

    /* renamed from: a */
    private static AdResponseParcel m7213a(Context context, zzfs zzfs, zzcv zzcv, zzio zzio, AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        zzky zzky;
        String string;
        zzkd.zzcv("Starting ad request from service using: AFMA_getAd");
        zzdc.initialize(context);
        zzdk zzdk = new zzdk(((Boolean) zzdc.zzaze.get()).booleanValue(), "load_ad", adRequestInfoParcel.zzapa.zzaur);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzcbj != -1) {
            zzdk.zza(zzdk.zzc(adRequestInfoParcel.zzcbj), "cts");
        }
        zzdi zzkg = zzdk.zzkg();
        Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzcay == null) ? null : adRequestInfoParcel.zzcay;
        if (!((Boolean) zzdc.zzazn.get()).booleanValue() || zzio.zzcdw == null) {
            bundle = bundle2;
            zzky = null;
        } else {
            if (bundle2 == null && ((Boolean) zzdc.zzazo.get()).booleanValue()) {
                zzkd.m7303v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                zzky = zzkg.zza((Callable) new C1695kq(zzio, context, adRequestInfoParcel, bundle2));
            } else {
                bundle = bundle2;
                zzky = null;
            }
        }
        zzky zzkw = new zzkw((Object) null);
        Bundle bundle3 = adRequestInfoParcel.zzcar.extras;
        zzky zza = (!adRequestInfoParcel.zzcbq || (bundle3 != null && bundle3.getString("_ad") != null)) ? zzkw : zzio.zzcds.zza(adRequestInfoParcel.applicationInfo);
        zziv zzy = zzu.zzfw().zzy(context);
        if (zzy.zzcgp == -1) {
            zzkd.zzcv("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzcbg : UUID.randomUUID().toString();
        zzir zzir = new zzir(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzcar.extras != null && (string = adRequestInfoParcel.zzcar.extras.getString("_ad")) != null) {
            return zziq.zza(context, adRequestInfoParcel, string);
        }
        List zza2 = zzio.zzcdq.zza(adRequestInfoParcel);
        String zzf = zzio.zzcdt.zzf(adRequestInfoParcel);
        zziz.zza zzz = zzio.zzcdu.zzz(context);
        if (zzky != null) {
            try {
                zzkd.m7303v("Waiting for app index fetching task.");
                zzky.get(((Long) zzdc.zzazp.get()).longValue(), TimeUnit.MILLISECONDS);
                zzkd.m7303v("App index fetching task completed.");
            } catch (InterruptedException | ExecutionException e) {
                zzkd.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e2) {
                zzkd.zzcv("Timed out waiting for app index fetching task");
            }
        }
        String zzck = zzio.zzcdp.zzck(adRequestInfoParcel.zzcas.packageName);
        JSONObject zza3 = zziq.zza(context, adRequestInfoParcel, zzy, zzz, m7212a(zza), zzcv, zzf, zza2, bundle, zzck);
        if (zza3 == null) {
            return new AdResponseParcel(0);
        }
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza3.put("request_id", uuid);
            } catch (JSONException e3) {
            }
        }
        try {
            zza3.put("prefetch_mode", "url");
        } catch (JSONException e4) {
            zzkd.zzd("Failed putting prefetch parameters to ad request.", e4);
        }
        String jSONObject = zza3.toString();
        zzdk.zza(zzkg, "arc");
        zzkh.zzclc.post(new C1696kr(zzfs, zzir, zzdk, zzdk.zzkg(), jSONObject));
        try {
            C1706la laVar = (C1706la) zzir.zzrh().get(10, TimeUnit.SECONDS);
            if (laVar == null) {
                return new AdResponseParcel(0);
            }
            if (laVar.mo7452a() != -2) {
                AdResponseParcel adResponseParcel = new AdResponseParcel(laVar.mo7452a());
                zzkh.zzclc.post(new C1699ku(zzio, context, zzir, adRequestInfoParcel));
                return adResponseParcel;
            }
            if (zzdk.zzkj() != null) {
                zzdk.zza(zzdk.zzkj(), "rur");
            }
            AdResponseParcel adResponseParcel2 = null;
            if (!TextUtils.isEmpty(laVar.mo7460h())) {
                adResponseParcel2 = zziq.zza(context, adRequestInfoParcel, laVar.mo7460h());
            }
            if (adResponseParcel2 == null && !TextUtils.isEmpty(laVar.mo7456d())) {
                adResponseParcel2 = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzaow.zzcs, laVar.mo7456d(), zzck, laVar, zzdk, zzio);
            }
            if (adResponseParcel2 == null) {
                adResponseParcel2 = new AdResponseParcel(0);
            }
            zzdk.zza(zzkg, "tts");
            adResponseParcel2.zzccl = zzdk.zzki();
            zzkh.zzclc.post(new C1699ku(zzio, context, zzir, adRequestInfoParcel));
            return adResponseParcel2;
        } catch (Exception e5) {
            return new AdResponseParcel(0);
        } finally {
            zzkh.zzclc.post(new C1699ku(zzio, context, zzir, adRequestInfoParcel));
        }
    }

    /* renamed from: a */
    private static void m7214a(String str, Map map, String str2, int i) {
        if (zzkd.zzaz(2)) {
            zzkd.m7303v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzkd.m7303v(new StringBuilder(String.valueOf(str3).length() + 5).append("    ").append(str3).append(":").toString());
                    for (String valueOf : (List) map.get(str3)) {
                        String valueOf2 = String.valueOf(valueOf);
                        zzkd.m7303v(valueOf2.length() != 0 ? "      ".concat(valueOf2) : new String("      "));
                    }
                }
            }
            zzkd.m7303v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzkd.m7303v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzkd.m7303v("    null");
            }
            zzkd.m7303v(new StringBuilder(34).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01cd, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        r6 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r4 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5 = com.google.android.gms.ads.internal.zzu.zzfq().zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.google.android.gms.common.util.zzo.zzb(r4);
        m7214a(r6, r12, r5, r9);
        r8.zzb(r6, r12, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c8, code lost:
        if (r19 == null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ca, code lost:
        r19.zza(r3, "ufe");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d7, code lost:
        r3 = r8.zzj(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00de, code lost:
        if (r20 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
        r20.zzcdv.zzrp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0127, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0128, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        com.google.android.gms.common.util.zzo.zzb(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0149, code lost:
        com.google.android.gms.internal.zzkd.zzcx("No location header to follow redirect.");
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0157, code lost:
        if (r20 == null) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0159, code lost:
        r20.zzcdv.zzrp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x016c, code lost:
        com.google.android.gms.internal.zzkd.zzcx("Too many redirects.");
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x017a, code lost:
        if (r20 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x017c, code lost:
        r20.zzcdv.zzrp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        com.google.android.gms.internal.zzkd.zzcx(new java.lang.StringBuilder(46).append("Received error HTTP response code: ").append(r9).toString());
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a7, code lost:
        if (r20 == null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a9, code lost:
        r20.zzcdv.zzrp();
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:59:0x0115=Splitter:B:59:0x0115, B:94:0x0186=Splitter:B:94:0x0186, B:70:0x0129=Splitter:B:70:0x0129} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.C1706la r18, com.google.android.gms.internal.zzdk r19, com.google.android.gms.internal.zzio r20) {
        /*
            if (r19 == 0) goto L_0x00e9
            com.google.android.gms.internal.zzdi r2 = r19.zzkg()
            r3 = r2
        L_0x0007:
            com.google.android.gms.internal.zzis r8 = new com.google.android.gms.internal.zzis     // Catch:{ IOException -> 0x00f4 }
            r8.<init>(r13)     // Catch:{ IOException -> 0x00f4 }
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r2 = java.lang.String.valueOf(r16)     // Catch:{ IOException -> 0x00f4 }
            int r5 = r2.length()     // Catch:{ IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x00ed
            java.lang.String r2 = r4.concat(r2)     // Catch:{ IOException -> 0x00f4 }
        L_0x001c:
            com.google.android.gms.internal.zzkd.zzcv(r2)     // Catch:{ IOException -> 0x00f4 }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00f4 }
            r0 = r16
            r4.<init>(r0)     // Catch:{ IOException -> 0x00f4 }
            r2 = 0
            com.google.android.gms.common.util.zze r5 = com.google.android.gms.ads.internal.zzu.zzfu()     // Catch:{ IOException -> 0x00f4 }
            long r10 = r5.elapsedRealtime()     // Catch:{ IOException -> 0x00f4 }
            r6 = r2
            r7 = r4
        L_0x0031:
            if (r20 == 0) goto L_0x003a
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzro()     // Catch:{ IOException -> 0x00f4 }
        L_0x003a:
            java.net.URLConnection r2 = r7.openConnection()     // Catch:{ IOException -> 0x00f4 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00f4 }
            com.google.android.gms.internal.zzkh r4 = com.google.android.gms.ads.internal.zzu.zzfq()     // Catch:{ all -> 0x0119 }
            r5 = 0
            r4.zza((android.content.Context) r14, (java.lang.String) r15, (boolean) r5, (java.net.HttpURLConnection) r2)     // Catch:{ all -> 0x0119 }
            boolean r4 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x0119 }
            if (r4 != 0) goto L_0x005b
            boolean r4 = r18.mo7458f()     // Catch:{ all -> 0x0119 }
            if (r4 == 0) goto L_0x005b
            java.lang.String r4 = "x-afma-drt-cookie"
            r0 = r17
            r2.addRequestProperty(r4, r0)     // Catch:{ all -> 0x0119 }
        L_0x005b:
            java.lang.String r4 = r13.zzcbr     // Catch:{ all -> 0x0119 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0119 }
            if (r5 != 0) goto L_0x006d
            java.lang.String r5 = "Sending webview cookie in ad request header."
            com.google.android.gms.internal.zzkd.zzcv(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = "Cookie"
            r2.addRequestProperty(r5, r4)     // Catch:{ all -> 0x0119 }
        L_0x006d:
            if (r18 == 0) goto L_0x0099
            java.lang.String r4 = r18.mo7455c()     // Catch:{ all -> 0x0119 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0119 }
            if (r4 != 0) goto L_0x0099
            r4 = 1
            r2.setDoOutput(r4)     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = r18.mo7455c()     // Catch:{ all -> 0x0119 }
            byte[] r9 = r4.getBytes()     // Catch:{ all -> 0x0119 }
            int r4 = r9.length     // Catch:{ all -> 0x0119 }
            r2.setFixedLengthStreamingMode(r4)     // Catch:{ all -> 0x0119 }
            r5 = 0
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0113 }
            java.io.OutputStream r12 = r2.getOutputStream()     // Catch:{ all -> 0x0113 }
            r4.<init>(r12)     // Catch:{ all -> 0x0113 }
            r4.write(r9)     // Catch:{ all -> 0x01d0 }
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
        L_0x0099:
            int r9 = r2.getResponseCode()     // Catch:{ all -> 0x0119 }
            java.util.Map r12 = r2.getHeaderFields()     // Catch:{ all -> 0x0119 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r9 < r4) goto L_0x012d
            r4 = 300(0x12c, float:4.2E-43)
            if (r9 >= r4) goto L_0x012d
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0119 }
            r5 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0127 }
            java.io.InputStream r7 = r2.getInputStream()     // Catch:{ all -> 0x0127 }
            r4.<init>(r7)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.zzkh r5 = com.google.android.gms.ads.internal.zzu.zzfq()     // Catch:{ all -> 0x01cd }
            java.lang.String r5 = r5.zza((java.io.InputStreamReader) r4)     // Catch:{ all -> 0x01cd }
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
            m7214a(r6, r12, r5, r9)     // Catch:{ all -> 0x0119 }
            r8.zzb(r6, r12, r5)     // Catch:{ all -> 0x0119 }
            if (r19 == 0) goto L_0x00d7
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0119 }
            r5 = 0
            java.lang.String r6 = "ufe"
            r4[r5] = r6     // Catch:{ all -> 0x0119 }
            r0 = r19
            r0.zza(r3, r4)     // Catch:{ all -> 0x0119 }
        L_0x00d7:
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = r8.zzj((long) r10)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x00e7
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzrp()     // Catch:{ IOException -> 0x00f4 }
        L_0x00e7:
            r2 = r3
        L_0x00e8:
            return r2
        L_0x00e9:
            r2 = 0
            r3 = r2
            goto L_0x0007
        L_0x00ed:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x00f4 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x00f4 }
            goto L_0x001c
        L_0x00f4:
            r2 = move-exception
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r2.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x01c6
            java.lang.String r2 = r3.concat(r2)
        L_0x0109:
            com.google.android.gms.internal.zzkd.zzcx(r2)
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r3 = 2
            r2.<init>(r3)
            goto L_0x00e8
        L_0x0113:
            r3 = move-exception
            r4 = r5
        L_0x0115:
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
            throw r3     // Catch:{ all -> 0x0119 }
        L_0x0119:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x0126
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzrp()     // Catch:{ IOException -> 0x00f4 }
        L_0x0126:
            throw r3     // Catch:{ IOException -> 0x00f4 }
        L_0x0127:
            r3 = move-exception
            r4 = r5
        L_0x0129:
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
            throw r3     // Catch:{ all -> 0x0119 }
        L_0x012d:
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0119 }
            r5 = 0
            m7214a(r4, r12, r5, r9)     // Catch:{ all -> 0x0119 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r9 < r4) goto L_0x0186
            r4 = 400(0x190, float:5.6E-43)
            if (r9 >= r4) goto L_0x0186
            java.lang.String r4 = "Location"
            java.lang.String r4 = r2.getHeaderField(r4)     // Catch:{ all -> 0x0119 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0119 }
            if (r5 == 0) goto L_0x0162
            java.lang.String r3 = "No location header to follow redirect."
            com.google.android.gms.internal.zzkd.zzcx(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0119 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x0160
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzrp()     // Catch:{ IOException -> 0x00f4 }
        L_0x0160:
            r2 = r3
            goto L_0x00e8
        L_0x0162:
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x0119 }
            r5.<init>(r4)     // Catch:{ all -> 0x0119 }
            int r4 = r6 + 1
            r6 = 5
            if (r4 <= r6) goto L_0x01b3
            java.lang.String r3 = "Too many redirects."
            com.google.android.gms.internal.zzkd.zzcx(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0119 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x0183
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzrp()     // Catch:{ IOException -> 0x00f4 }
        L_0x0183:
            r2 = r3
            goto L_0x00e8
        L_0x0186:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r4 = 46
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = "Received error HTTP response code: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r3 = r3.append(r9)     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.zzkd.zzcx(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0119 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x01b0
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzrp()     // Catch:{ IOException -> 0x00f4 }
        L_0x01b0:
            r2 = r3
            goto L_0x00e8
        L_0x01b3:
            r8.zzj((java.util.Map) r12)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x01c2
            r0 = r20
            com.google.android.gms.internal.zziy r2 = r0.zzcdv     // Catch:{ IOException -> 0x00f4 }
            r2.zzrp()     // Catch:{ IOException -> 0x00f4 }
        L_0x01c2:
            r6 = r4
            r7 = r5
            goto L_0x0031
        L_0x01c6:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            goto L_0x0109
        L_0x01cd:
            r3 = move-exception
            goto L_0x0129
        L_0x01d0:
            r3 = move-exception
            goto L_0x0115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzip.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.la, com.google.android.gms.internal.zzdk, com.google.android.gms.internal.zzio):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzip zza(Context context, zzcv zzcv, zzio zzio) {
        zzip zzip;
        synchronized (f6432a) {
            if (f6433b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f6433b = new zzip(context, zzcv, zzio);
            }
            zzip = f6433b;
        }
        return zzip;
    }

    public void zza(AdRequestInfoParcel adRequestInfoParcel, zzl zzl) {
        zzu.zzft().zzb(this.f6434c, adRequestInfoParcel.zzaow);
        zzkg.zza((Runnable) new C1701kw(this, adRequestInfoParcel, zzl));
    }

    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return m7213a(this.f6434c, this.f6437f, this.f6436e, this.f6435d, adRequestInfoParcel);
    }
}
