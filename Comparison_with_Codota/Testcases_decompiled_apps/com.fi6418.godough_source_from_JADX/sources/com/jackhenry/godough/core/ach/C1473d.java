package com.jackhenry.godough.core.ach;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.ach.d */
class C1473d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ACHDetailFragment f5954a;

    C1473d(ACHDetailFragment aCHDetailFragment) {
        this.f5954a = aCHDetailFragment;
    }

    public void onClick(View view) {
        this.f5954a.f5937b.setChecked(!this.f5954a.f5937b.isChecked());
    }
}
