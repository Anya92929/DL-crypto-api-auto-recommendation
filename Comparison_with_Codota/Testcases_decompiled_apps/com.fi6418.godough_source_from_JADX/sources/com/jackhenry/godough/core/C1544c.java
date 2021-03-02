package com.jackhenry.godough.core;

import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.c */
class C1544c implements C1578g {

    /* renamed from: a */
    final /* synthetic */ AbstractActivity f6073a;

    C1544c(AbstractActivity abstractActivity) {
        this.f6073a = abstractActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -1:
                this.f6073a.mo9483a(this.f6073a.getString(C1506am.dg_logging_out));
                this.f6073a.mo9879h();
                return;
            default:
                return;
        }
    }
}
