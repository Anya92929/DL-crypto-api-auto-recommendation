package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzin
public class zzde {

    /* renamed from: a */
    BlockingQueue f6105a;

    /* renamed from: b */
    ExecutorService f6106b;

    /* renamed from: c */
    LinkedHashMap f6107c = new LinkedHashMap();

    /* renamed from: d */
    Map f6108d = new HashMap();

    /* renamed from: e */
    String f6109e;

    /* renamed from: f */
    final Context f6110f;

    /* renamed from: g */
    final String f6111g;

    /* renamed from: h */
    private AtomicBoolean f6112h;

    /* renamed from: i */
    private File f6113i;

    public zzde(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.f6110f = context;
        this.f6111g = str;
        this.f6109e = str2;
        this.f6112h = new AtomicBoolean(false);
        this.f6112h.set(((Boolean) zzdc.zzazg.get()).booleanValue());
        if (this.f6112h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.f6113i = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f6107c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f6105a = new ArrayBlockingQueue(30);
        this.f6106b = Executors.newSingleThreadExecutor();
        this.f6106b.execute(new C1532ep(this));
        this.f6108d.put("action", zzdh.zzbdz);
        this.f6108d.put("ad_format", zzdh.zzbdz);
        this.f6108d.put("e", zzdh.zzbea);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6987a() {
        while (true) {
            try {
                zzdk zzdk = (zzdk) this.f6105a.take();
                String zzki = zzdk.zzki();
                if (!TextUtils.isEmpty(zzki)) {
                    m6990a(mo8273a((Map) this.f6107c, zzdk.mo8285a()), zzki);
                }
            } catch (InterruptedException e) {
                zzkd.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A[SYNTHETIC, Splitter:B:17:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[SYNTHETIC, Splitter:B:24:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6989a(java.io.File r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0045
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x0036 }
            r0 = 1
            r1.<init>(r4, r0)     // Catch:{ IOException -> 0x0022, all -> 0x0036 }
            byte[] r0 = r5.getBytes()     // Catch:{ IOException -> 0x004d }
            r1.write(r0)     // Catch:{ IOException -> 0x004d }
            r0 = 10
            r1.write(r0)     // Catch:{ IOException -> 0x004d }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001a:
            return
        L_0x001b:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkd.zzd(r1, r0)
            goto L_0x001a
        L_0x0022:
            r0 = move-exception
            r1 = r2
        L_0x0024:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkd.zzd(r2, r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x001a
        L_0x002f:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkd.zzd(r1, r0)
            goto L_0x001a
        L_0x0036:
            r0 = move-exception
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x003e }
        L_0x003d:
            throw r0
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkd.zzd(r2, r1)
            goto L_0x003d
        L_0x0045:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.zzkd.zzcx(r0)
            goto L_0x001a
        L_0x004b:
            r0 = move-exception
            goto L_0x0038
        L_0x004d:
            r0 = move-exception
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzde.m6989a(java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    private void m6990a(Map map, String str) {
        String a = mo8272a(this.f6109e, map, str);
        if (this.f6112h.get()) {
            m6989a(this.f6113i, a);
        } else {
            zzu.zzfq().zzc(this.f6110f, this.f6111g, a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8272a(String str, Map map, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder sb = new StringBuilder(buildUpon.build().toString());
        sb.append("&").append("it").append("=").append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo8273a(Map map, Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzaq(str).zzg(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public boolean zza(zzdk zzdk) {
        return this.f6105a.offer(zzdk);
    }

    public zzdh zzaq(String str) {
        zzdh zzdh = (zzdh) this.f6108d.get(str);
        return zzdh != null ? zzdh : zzdh.zzbdy;
    }

    public void zzc(List list) {
        if (list != null && !list.isEmpty()) {
            this.f6107c.put("e", TextUtils.join(",", list));
        }
    }
}
