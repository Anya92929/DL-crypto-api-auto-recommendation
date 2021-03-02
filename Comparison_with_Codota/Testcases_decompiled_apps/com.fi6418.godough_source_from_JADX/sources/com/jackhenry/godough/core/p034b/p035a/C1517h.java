package com.jackhenry.godough.core.p034b.p035a;

import android.content.DialogInterface;
import com.jackhenry.godough.core.p038e.C1574c;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.b.a.h */
class C1517h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f6009a;

    /* renamed from: b */
    final /* synthetic */ C1514e f6010b;

    C1517h(C1514e eVar, List list) {
        this.f6010b = eVar;
        this.f6009a = list;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6010b.dismiss();
        if (this.f6010b.f6005ak.mo9790a() != null) {
            this.f6010b.f6005ak.mo9790a().onDialogButtonClicked(this.f6010b.f6005ak.mo9795d(), (C1574c) this.f6009a.get(1));
        }
    }
}
