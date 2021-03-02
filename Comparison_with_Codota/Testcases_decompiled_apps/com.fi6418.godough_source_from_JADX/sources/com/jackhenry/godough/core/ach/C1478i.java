package com.jackhenry.godough.core.ach;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.OffsetAccount;

/* renamed from: com.jackhenry.godough.core.ach.i */
class C1478i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ACHDetailFragment f5959a;

    C1478i(ACHDetailFragment aCHDetailFragment) {
        this.f5959a = aCHDetailFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5959a.f5938c.setTag((OffsetAccount) this.f5959a.f5942g.getItem(i));
        this.f5959a.m5939r();
        dialogInterface.dismiss();
        this.f5959a.m5941t();
    }
}
