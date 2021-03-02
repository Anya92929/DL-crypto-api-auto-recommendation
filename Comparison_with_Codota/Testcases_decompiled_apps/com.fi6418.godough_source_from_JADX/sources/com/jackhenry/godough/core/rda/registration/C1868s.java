package com.jackhenry.godough.core.rda.registration;

import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.rda.registration.s */
class C1868s implements C1578g {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationFragmentActivity f6759a;

    C1868s(RDARegistrationFragmentActivity rDARegistrationFragmentActivity) {
        this.f6759a = rDARegistrationFragmentActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -1:
                this.f6759a.finish();
                return;
            default:
                return;
        }
    }
}
