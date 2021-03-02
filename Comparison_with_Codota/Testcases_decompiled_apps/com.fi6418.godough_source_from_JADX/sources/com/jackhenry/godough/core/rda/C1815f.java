package com.jackhenry.godough.core.rda;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.rda.f */
class C1815f implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ DepositCheckFragment f6654a;

    C1815f(DepositCheckFragment depositCheckFragment) {
        this.f6654a = depositCheckFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6654a.f6632h.setHint(this.f6654a.getString(C1506am.amount_hint));
    }
}
