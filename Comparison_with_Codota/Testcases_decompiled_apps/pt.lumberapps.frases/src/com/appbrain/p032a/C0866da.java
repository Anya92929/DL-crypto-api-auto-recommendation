package com.appbrain.p032a;

import android.content.Context;
import com.appbrain.p033b.C1021y;
import com.appbrain.p037f.C1035aa;
import com.appbrain.p037f.C1052ar;
import com.appbrain.p037f.C1065bd;
import com.appbrain.p037f.C1073bl;

/* renamed from: com.appbrain.a.da */
public final class C0866da extends C0853co {
    public C0866da(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo3725a(C1021y yVar, C1035aa aaVar) {
        if (yVar instanceof C1073bl) {
            ((C1073bl) yVar).mo4318a(aaVar);
        } else if (yVar instanceof C1065bd) {
            ((C1065bd) yVar).mo4284a(aaVar);
        } else if (yVar instanceof C1052ar) {
            ((C1052ar) yVar).mo4228a(aaVar);
        } else {
            throw new IllegalArgumentException("Unknown builder type.");
        }
    }
}
