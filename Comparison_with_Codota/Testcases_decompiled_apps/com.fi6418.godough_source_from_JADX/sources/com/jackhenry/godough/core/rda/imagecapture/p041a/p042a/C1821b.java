package com.jackhenry.godough.core.rda.imagecapture.p041a.p042a;

import android.view.ViewGroup;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.a.a.b */
class C1821b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f6680a;

    /* renamed from: b */
    final /* synthetic */ C1820a f6681b;

    C1821b(C1820a aVar, ViewGroup viewGroup) {
        this.f6681b = aVar;
        this.f6680a = viewGroup;
    }

    public void run() {
        try {
            this.f6681b.mo11035b(this.f6680a);
        } catch (C1389d e) {
            this.f6681b.mo11029a().showDialog(this.f6681b.mo11029a().getString(C1506am.rdaCameraErrorTitle, new Object[]{GoDoughApp.getUserSettings().getUserMenu().getRda().getText()}), e.getMessage());
            e.printStackTrace();
        }
    }
}
