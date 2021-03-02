package com.jackhenry.godough.core;

import android.content.Intent;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.w */
class C1918w implements C1578g {

    /* renamed from: a */
    final /* synthetic */ Intent f6848a;

    /* renamed from: b */
    final /* synthetic */ boolean f6849b;

    /* renamed from: c */
    final /* synthetic */ C1916u f6850c;

    C1918w(C1916u uVar, Intent intent, boolean z) {
        this.f6850c = uVar;
        this.f6848a = intent;
        this.f6849b = z;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        if (cVar.mo9788a() == -2) {
            this.f6850c.f6844a.mo9535a(this.f6848a);
        } else if (this.f6849b) {
            this.f6850c.f6844a.mo9534a();
        }
    }
}
