package com.jackhenry.godough.core.accounts.statements;

import android.widget.Button;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.accounts.statements.k */
class C1450k implements C1578g {

    /* renamed from: a */
    final /* synthetic */ StatementDetailFragment f5903a;

    C1450k(StatementDetailFragment statementDetailFragment) {
        this.f5903a = statementDetailFragment;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        if (cVar.mo9788a() == 1) {
            this.f5903a.m5857s();
        }
        this.f5903a.m5841d(this.f5903a.getString(C1506am.statements_msg_pdf_not_supported));
        Button button = (Button) this.f5903a.getView().findViewById(C1494ai.pdf_error_button);
        button.setOnClickListener(new C1451l(this));
        button.setVisibility(0);
    }
}
