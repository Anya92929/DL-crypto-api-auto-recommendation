package com.jackhenry.godough.core.locations;

import android.content.DialogInterface;
import com.jackhenry.android.p022a.C1363j;

/* renamed from: com.jackhenry.godough.core.locations.f */
class C1607f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LocationCityFragment f6241a;

    C1607f(LocationCityFragment locationCityFragment) {
        this.f6241a = locationCityFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6241a.f6180g.size()) {
            String unused = this.f6241a.f6179f = ((C1363j) this.f6241a.f6180g.get(i)).mo9285b();
            this.f6241a.m6229o();
        }
        dialogInterface.dismiss();
    }
}
