package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.s */
class C2147s extends C1998aj {

    /* renamed from: ID */
    private static final String f4602ID = C0880a.FUNCTION_CALL.toString();
    private static final String anK = C0929b.ADDITIONAL_PARAMS.toString();
    private static final String aot = C0929b.FUNCTION_CALL_NAME.toString();
    private final C2148a aou;

    /* renamed from: com.google.android.gms.tagmanager.s$a */
    public interface C2148a {
        /* renamed from: b */
        Object mo11488b(String str, Map<String, Object> map);
    }

    public C2147s(C2148a aVar) {
        super(f4602ID, aot);
        this.aou = aVar;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String j = C2114di.m7106j(map.get(aot));
        HashMap hashMap = new HashMap();
        C1026d.C1027a aVar = map.get(anK);
        if (aVar != null) {
            Object o = C2114di.m7111o(aVar);
            if (!(o instanceof Map)) {
                C2028bh.m6819W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return C2114di.m7119pI();
            }
            for (Map.Entry entry : ((Map) o).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return C2114di.m7124u(this.aou.mo11488b(j, hashMap));
        } catch (Exception e) {
            C2028bh.m6819W("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return C2114di.m7119pI();
        }
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
