package com.jackhenry.godough.core.transfers;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.transfers.h */
class C1903h implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6826a;

    C1903h(TransfersFragment transfersFragment) {
        this.f6826a = transfersFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6826a.f6811c.setHint(this.f6826a.getString(C1506am.amount_hint));
    }
}
