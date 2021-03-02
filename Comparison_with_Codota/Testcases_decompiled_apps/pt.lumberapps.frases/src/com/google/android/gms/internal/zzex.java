package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzin
public class zzex implements zzep {

    /* renamed from: a */
    private final Object f6163a = new Object();

    /* renamed from: b */
    private final Map f6164b = new HashMap();

    public interface zza {
        void zzay(String str);

        void zzd(JSONObject jSONObject);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.internal.zzlh r7, java.util.Map r8) {
        /*
            r6 = this;
            java.lang.String r0 = "id"
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "fail"
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "fail_reason"
            java.lang.Object r2 = r8.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "result"
            java.lang.Object r3 = r8.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r6.f6163a
            monitor-enter(r5)
            java.util.Map r4 = r6.f6164b     // Catch:{ all -> 0x0048 }
            java.lang.Object r4 = r4.remove(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.zzex$zza r4 = (com.google.android.gms.internal.zzex.zza) r4     // Catch:{ all -> 0x0048 }
            if (r4 != 0) goto L_0x004b
            java.lang.String r1 = "Received result for unexpected method invocation: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0048 }
            int r2 = r0.length()     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0042
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0048 }
        L_0x003d:
            com.google.android.gms.internal.zzkd.zzcx(r0)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
        L_0x0041:
            return
        L_0x0042:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0048 }
            r0.<init>(r1)     // Catch:{ all -> 0x0048 }
            goto L_0x003d
        L_0x0048:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            throw r0
        L_0x004b:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0056
            r4.zzay(r2)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0056:
            if (r3 != 0) goto L_0x005f
            java.lang.String r0 = "No result."
            r4.zzay(r0)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x005f:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0069 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0069 }
            r4.zzd(r0)     // Catch:{ JSONException -> 0x0069 }
        L_0x0067:
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0069:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0048 }
            r4.zzay(r0)     // Catch:{ all -> 0x0048 }
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzex.zza(com.google.android.gms.internal.zzlh, java.util.Map):void");
    }
}
