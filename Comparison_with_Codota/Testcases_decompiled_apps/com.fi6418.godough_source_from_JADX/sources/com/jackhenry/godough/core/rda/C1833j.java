package com.jackhenry.godough.core.rda;

import com.jackhenry.android.widget.quickactionmenu.QuickAction;

/* renamed from: com.jackhenry.godough.core.rda.j */
class C1833j implements QuickAction.OnActionItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DepositCheckFragment f6691a;

    C1833j(DepositCheckFragment depositCheckFragment) {
        this.f6691a = depositCheckFragment;
    }

    public void onQuickActionClick(QuickAction quickAction, int i, int i2) {
        if (i2 == 1) {
            this.f6691a.m6679b(this.f6691a.f6622ap);
        } else if (i2 == 2) {
            this.f6691a.m6692r();
        } else if (i2 == 3) {
            this.f6691a.m6674a(-90);
        } else if (i2 == 4) {
            this.f6691a.m6674a(90);
        }
    }
}
