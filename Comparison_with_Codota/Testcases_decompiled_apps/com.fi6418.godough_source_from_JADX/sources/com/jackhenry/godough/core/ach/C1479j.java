package com.jackhenry.godough.core.ach;

import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import java.util.Calendar;

/* renamed from: com.jackhenry.godough.core.ach.j */
class C1479j implements OnDateChosen {

    /* renamed from: a */
    final /* synthetic */ C1510a f5960a;

    /* renamed from: b */
    final /* synthetic */ ACHDetailFragment f5961b;

    C1479j(ACHDetailFragment aCHDetailFragment, C1510a aVar) {
        this.f5961b = aCHDetailFragment;
        this.f5960a = aVar;
    }

    public void onDateChosen(Calendar calendar) {
        this.f5961b.f5940e.setTag(calendar);
        this.f5961b.m5940s();
        this.f5960a.dismiss();
    }
}
