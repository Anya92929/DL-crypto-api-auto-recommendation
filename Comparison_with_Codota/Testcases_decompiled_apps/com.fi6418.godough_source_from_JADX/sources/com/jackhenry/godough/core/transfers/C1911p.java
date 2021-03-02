package com.jackhenry.godough.core.transfers;

import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import java.util.Calendar;

/* renamed from: com.jackhenry.godough.core.transfers.p */
class C1911p implements OnDateChosen {

    /* renamed from: a */
    final /* synthetic */ C1510a f6835a;

    /* renamed from: b */
    final /* synthetic */ TransfersFragment f6836b;

    C1911p(TransfersFragment transfersFragment, C1510a aVar) {
        this.f6836b = transfersFragment;
        this.f6835a = aVar;
    }

    public void onDateChosen(Calendar calendar) {
        Calendar unused = this.f6836b.f6803ar = (Calendar) calendar.clone();
        this.f6836b.m6912w();
        this.f6836b.m6911v();
        this.f6835a.dismiss();
    }
}
