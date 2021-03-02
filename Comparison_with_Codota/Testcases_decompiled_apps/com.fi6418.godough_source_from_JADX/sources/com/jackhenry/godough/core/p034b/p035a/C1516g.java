package com.jackhenry.godough.core.p034b.p035a;

import android.content.DialogInterface;
import com.jackhenry.godough.core.p038e.C1574c;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.b.a.g */
class C1516g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f6007a;

    /* renamed from: b */
    final /* synthetic */ C1514e f6008b;

    C1516g(C1514e eVar, List list) {
        this.f6008b = eVar;
        this.f6007a = list;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6008b.dismiss();
        if (this.f6008b.f6005ak.mo9790a() != null) {
            this.f6008b.f6005ak.mo9790a().onDialogButtonClicked(this.f6008b.f6005ak.mo9795d(), (C1574c) this.f6007a.get(0));
        }
    }
}
