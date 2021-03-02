package com.jackhenry.godough.core.accounts.statements;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.accounts.statements.t */
class C1459t implements C1593j {

    /* renamed from: a */
    final /* synthetic */ StatementFragment f5915a;

    C1459t(StatementFragment statementFragment) {
        this.f5915a = statementFragment;
    }

    public void run() {
        new Handler().post(new C1460u(this));
    }
}
