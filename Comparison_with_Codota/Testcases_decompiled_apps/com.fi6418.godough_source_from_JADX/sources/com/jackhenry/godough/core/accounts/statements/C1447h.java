package com.jackhenry.godough.core.accounts.statements;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.accounts.statements.h */
class C1447h implements C1593j {

    /* renamed from: a */
    final /* synthetic */ StatementDetailFragment f5900a;

    C1447h(StatementDetailFragment statementDetailFragment) {
        this.f5900a = statementDetailFragment;
    }

    public void run() {
        new Handler().post(new C1448i(this));
    }
}
