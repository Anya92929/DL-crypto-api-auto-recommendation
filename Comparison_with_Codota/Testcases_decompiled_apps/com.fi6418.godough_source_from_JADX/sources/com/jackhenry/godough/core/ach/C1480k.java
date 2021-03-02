package com.jackhenry.godough.core.ach;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.ACHRequest;

/* renamed from: com.jackhenry.godough.core.ach.k */
class C1480k implements C1593j {

    /* renamed from: a */
    final /* synthetic */ ACHRequest f5962a;

    /* renamed from: b */
    final /* synthetic */ ACHDetailFragment f5963b;

    C1480k(ACHDetailFragment aCHDetailFragment, ACHRequest aCHRequest) {
        this.f5963b = aCHDetailFragment;
        this.f5962a = aCHRequest;
    }

    public void run() {
        this.f5963b.submitData(this.f5962a);
    }
}
