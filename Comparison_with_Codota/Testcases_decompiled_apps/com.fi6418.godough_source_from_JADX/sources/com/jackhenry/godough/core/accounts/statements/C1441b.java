package com.jackhenry.godough.core.accounts.statements;

import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import com.jackhenry.godough.core.accounts.statements.model.StatementResponse;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;

/* renamed from: com.jackhenry.godough.core.accounts.statements.b */
public class C1441b extends C1396a {
    /* renamed from: a */
    public StatementDetail mo9597a(String str) {
        C1885a.m6860a();
        StatementDetail statementDetail = new StatementDetail();
        StatementDetail statementDetail2 = (StatementDetail) mo9442n().mo9452a(String.format("/Statement?statementId=%1$s&Format=%2$s", new Object[]{str, "PDF"}), (C1401c) new C1400b(StatementDetail.class));
        if (!(statementDetail2 == null || statementDetail2.getPdfFile() == null)) {
            statementDetail.setPdfFile(statementDetail2.getPdfFile());
        }
        return statementDetail;
    }

    /* renamed from: b */
    public StatementResponse mo9598b() {
        C1885a.m6860a();
        return (StatementResponse) mo9442n().mo9452a("/StatementList", (C1401c) new C1400b(StatementResponse.class));
    }
}
