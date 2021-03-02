package com.google.android.gms.internal;

import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ar */
public class C0426ar {
    /* renamed from: a */
    public static void m908a(StringBuilder sb, HashMap<String, String> hashMap) {
        boolean z;
        sb.append("{");
        boolean z2 = true;
        for (String next : hashMap.keySet()) {
            if (!z2) {
                sb.append(",");
                z = z2;
            } else {
                z = false;
            }
            String str = hashMap.get(next);
            sb.append("\"").append(next).append("\":");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append("\"").append(str).append("\"");
            }
            z2 = z;
        }
        sb.append("}");
    }
}
