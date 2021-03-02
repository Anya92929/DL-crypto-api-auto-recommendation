package com.p041b.p042a.p045b;

import com.p046c.p047a.C1153a;

/* renamed from: com.b.a.b.b */
public class C1150b {
    /* renamed from: a */
    public static C1153a[] m5247a(C1153a[] aVarArr, C1153a[] aVarArr2, C1153a aVar) {
        C1153a[] aVarArr3 = new C1153a[(aVarArr.length + aVarArr2.length + 1)];
        int i = 0;
        while (i < aVarArr.length) {
            aVarArr3[i] = aVarArr[i];
            i++;
        }
        for (C1153a aVar2 : aVarArr2) {
            aVarArr3[i] = aVar2;
            i++;
        }
        aVarArr3[aVarArr3.length - 1] = aVar;
        return aVarArr3;
    }
}
