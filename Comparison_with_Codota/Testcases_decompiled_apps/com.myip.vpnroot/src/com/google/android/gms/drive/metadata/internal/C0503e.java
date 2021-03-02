package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.C1395kd;
import com.google.android.gms.internal.C1406kf;
import com.google.android.gms.internal.C1413kh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public final class C0503e {

    /* renamed from: PC */
    private static Map<String, MetadataField<?>> f1105PC = new HashMap();

    static {
        m1408b(C1395kd.f4144PE);
        m1408b(C1395kd.f4170Qe);
        m1408b(C1395kd.f4161PV);
        m1408b(C1395kd.f4168Qc);
        m1408b(C1395kd.f4171Qf);
        m1408b(C1395kd.f4155PP);
        m1408b(C1395kd.f4156PQ);
        m1408b(C1395kd.f4153PN);
        m1408b(C1395kd.f4158PS);
        m1408b(C1395kd.f4166Qa);
        m1408b(C1395kd.f4145PF);
        m1408b(C1395kd.f4163PX);
        m1408b(C1395kd.f4147PH);
        m1408b(C1395kd.f4154PO);
        m1408b(C1395kd.f4148PI);
        m1408b(C1395kd.f4149PJ);
        m1408b(C1395kd.f4150PK);
        m1408b(C1395kd.f4160PU);
        m1408b(C1395kd.f4157PR);
        m1408b(C1395kd.f4162PW);
        m1408b(C1395kd.f4164PY);
        m1408b(C1395kd.f4165PZ);
        m1408b(C1395kd.f4167Qb);
        m1408b(C1395kd.f4172Qg);
        m1408b(C1395kd.f4173Qh);
        m1408b(C1395kd.f4152PM);
        m1408b(C1395kd.f4151PL);
        m1408b(C1395kd.f4169Qd);
        m1408b(C1395kd.f4159PT);
        m1408b(C1395kd.f4146PG);
        m1408b(C1395kd.f4174Qi);
        m1408b(C1395kd.f4175Qj);
        m1408b(C1395kd.f4176Qk);
        m1408b(C1406kf.f4177Ql);
        m1408b(C1406kf.f4179Qn);
        m1408b(C1406kf.f4180Qo);
        m1408b(C1406kf.f4181Qp);
        m1408b(C1406kf.f4178Qm);
        m1408b(C1413kh.f4183Qr);
        m1408b(C1413kh.f4184Qs);
    }

    /* renamed from: b */
    private static void m1408b(MetadataField<?> metadataField) {
        if (f1105PC.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        f1105PC.put(metadataField.getName(), metadataField);
    }

    /* renamed from: bj */
    public static MetadataField<?> m1409bj(String str) {
        return f1105PC.get(str);
    }

    /* renamed from: in */
    public static Collection<MetadataField<?>> m1410in() {
        return Collections.unmodifiableCollection(f1105PC.values());
    }
}
