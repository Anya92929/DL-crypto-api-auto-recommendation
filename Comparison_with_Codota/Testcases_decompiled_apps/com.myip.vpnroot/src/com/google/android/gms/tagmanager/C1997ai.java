package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0976c;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ai */
class C1997ai {
    /* renamed from: a */
    private static void m6745a(DataLayer dataLayer, C0976c.C0980d dVar) {
        for (C1026d.C1027a j : dVar.f2965fB) {
            dataLayer.mo11497cs(C2114di.m7106j(j));
        }
    }

    /* renamed from: a */
    public static void m6746a(DataLayer dataLayer, C0976c.C0985i iVar) {
        if (iVar.f3006gq == null) {
            C2028bh.m6819W("supplemental missing experimentSupplemental");
            return;
        }
        m6745a(dataLayer, iVar.f3006gq);
        m6747b(dataLayer, iVar.f3006gq);
        m6749c(dataLayer, iVar.f3006gq);
    }

    /* renamed from: b */
    private static void m6747b(DataLayer dataLayer, C0976c.C0980d dVar) {
        for (C1026d.C1027a c : dVar.f2964fA) {
            Map<String, Object> c2 = m6748c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    /* renamed from: c */
    private static Map<String, Object> m6748c(C1026d.C1027a aVar) {
        Object o = C2114di.m7111o(aVar);
        if (o instanceof Map) {
            return (Map) o;
        }
        C2028bh.m6819W("value: " + o + " is not a map value, ignored.");
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r0.longValue() > r9) goto L_0x003b;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m6749c(com.google.android.gms.tagmanager.DataLayer r13, com.google.android.gms.internal.C0976c.C0980d r14) {
        /*
            r3 = 0
            com.google.android.gms.internal.c$c[] r4 = r14.f2966fC
            int r5 = r4.length
            r2 = r3
        L_0x0005:
            if (r2 >= r5) goto L_0x00b9
            r6 = r4[r2]
            java.lang.String r0 = r6.f2959fv
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = "GaExperimentRandom: No key"
            com.google.android.gms.tagmanager.C2028bh.m6819W(r0)
        L_0x0012:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x0005
        L_0x0016:
            java.lang.String r0 = r6.f2959fv
            java.lang.Object r1 = r13.get(r0)
            boolean r0 = r1 instanceof java.lang.Number
            if (r0 != 0) goto L_0x0088
            r0 = 0
        L_0x0021:
            long r7 = r6.f2960fw
            long r9 = r6.f2961fx
            boolean r11 = r6.f2962fy
            if (r11 == 0) goto L_0x003b
            if (r0 == 0) goto L_0x003b
            long r11 = r0.longValue()
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x003b
            long r11 = r0.longValue()
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0050
        L_0x003b:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 > 0) goto L_0x0094
            double r0 = java.lang.Math.random()
            long r9 = r9 - r7
            double r9 = (double) r9
            double r0 = r0 * r9
            double r7 = (double) r7
            double r0 = r0 + r7
            long r0 = java.lang.Math.round(r0)
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
        L_0x0050:
            java.lang.String r0 = r6.f2959fv
            r13.mo11497cs(r0)
            java.lang.String r0 = r6.f2959fv
            java.util.Map r1 = r13.mo11496c(r0, r1)
            long r7 = r6.f2963fz
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0084
            java.lang.String r0 = "gtm"
            boolean r0 = r1.containsKey(r0)
            if (r0 != 0) goto L_0x009b
            java.lang.String r0 = "gtm"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r8 = "lifetime"
            r7[r3] = r8
            r8 = 1
            long r9 = r6.f2963fz
            java.lang.Long r6 = java.lang.Long.valueOf(r9)
            r7[r8] = r6
            java.util.Map r6 = com.google.android.gms.tagmanager.DataLayer.mapOf(r7)
            r1.put(r0, r6)
        L_0x0084:
            r13.push(r1)
            goto L_0x0012
        L_0x0088:
            r0 = r1
            java.lang.Number r0 = (java.lang.Number) r0
            long r7 = r0.longValue()
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            goto L_0x0021
        L_0x0094:
            java.lang.String r0 = "GaExperimentRandom: random range invalid"
            com.google.android.gms.tagmanager.C2028bh.m6819W(r0)
            goto L_0x0012
        L_0x009b:
            java.lang.String r0 = "gtm"
            java.lang.Object r0 = r1.get(r0)
            boolean r7 = r0 instanceof java.util.Map
            if (r7 == 0) goto L_0x00b3
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r7 = "lifetime"
            long r8 = r6.f2963fz
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            r0.put(r7, r6)
            goto L_0x0084
        L_0x00b3:
            java.lang.String r0 = "GaExperimentRandom: gtm not a map"
            com.google.android.gms.tagmanager.C2028bh.m6819W(r0)
            goto L_0x0084
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1997ai.m6749c(com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d):void");
    }
}
