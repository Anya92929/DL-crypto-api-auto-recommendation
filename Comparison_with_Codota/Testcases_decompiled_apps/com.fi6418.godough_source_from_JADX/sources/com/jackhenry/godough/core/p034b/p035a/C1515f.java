package com.jackhenry.godough.core.p034b.p035a;

import android.content.DialogInterface;
import com.jackhenry.godough.core.p038e.C1574c;

/* renamed from: com.jackhenry.godough.core.b.a.f */
class C1515f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1514e f6006a;

    C1515f(C1514e eVar) {
        this.f6006a = eVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6006a.dismiss();
        if (this.f6006a.f6005ak.mo9790a() != null) {
            this.f6006a.f6005ak.mo9790a().onDialogButtonClicked(this.f6006a.f6005ak.mo9795d(), (C1574c) null);
        }
    }
}
