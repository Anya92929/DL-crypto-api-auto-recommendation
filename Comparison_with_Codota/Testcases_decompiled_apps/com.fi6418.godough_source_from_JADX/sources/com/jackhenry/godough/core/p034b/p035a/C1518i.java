package com.jackhenry.godough.core.p034b.p035a;

import android.content.DialogInterface;
import com.jackhenry.godough.core.p038e.C1574c;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.b.a.i */
class C1518i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f6011a;

    /* renamed from: b */
    final /* synthetic */ C1514e f6012b;

    C1518i(C1514e eVar, List list) {
        this.f6012b = eVar;
        this.f6011a = list;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6012b.dismiss();
        if (this.f6012b.f6005ak.mo9790a() != null) {
            this.f6012b.f6005ak.mo9790a().onDialogButtonClicked(this.f6012b.f6005ak.mo9795d(), (C1574c) this.f6011a.get(2));
        }
    }
}
