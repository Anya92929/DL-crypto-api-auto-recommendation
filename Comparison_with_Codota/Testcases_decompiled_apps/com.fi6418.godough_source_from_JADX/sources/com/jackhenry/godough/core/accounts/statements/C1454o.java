package com.jackhenry.godough.core.accounts.statements;

import android.content.Context;
import com.jackhenry.godough.core.C1752m;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetailHeader;

/* renamed from: com.jackhenry.godough.core.accounts.statements.o */
public class C1454o extends C1752m<StatementDetail> {

    /* renamed from: f */
    StatementDetailHeader f5908f;

    public C1454o(Context context, StatementDetailHeader statementDetailHeader) {
        super(context);
        this.f5908f = statementDetailHeader;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public StatementDetail mo9582j() {
        StatementDetail a = new C1441b().mo9597a(this.f5908f.getStatementId());
        new C1443d(a, getContext(), this.f5908f).mo9600b();
        a.setWebOutput(new C1462w(a, getContext(), this.f5908f).mo9657a());
        return a;
    }
}
