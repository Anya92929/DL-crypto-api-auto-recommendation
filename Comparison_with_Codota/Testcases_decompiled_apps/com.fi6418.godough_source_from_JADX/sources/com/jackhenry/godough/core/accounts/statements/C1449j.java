package com.jackhenry.godough.core.accounts.statements;

import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.accounts.statements.j */
class C1449j extends C1895t<StatementDetail> {

    /* renamed from: c */
    final /* synthetic */ StatementDetailFragment f5902c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1449j(StatementDetailFragment statementDetailFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f5902c = statementDetailFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<StatementDetail> loader, C1389d dVar) {
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<StatementDetail> loader, StatementDetail statementDetail) {
        StatementDetail unused = this.f5902c.f5877b = statementDetail;
        this.f5902c.mo10989m();
        if (this.f5902c.f5877b.getPdfFile() != null && Build.VERSION.SDK_INT < 21) {
            this.f5902c.m5856r();
        } else if (this.f5902c.f5877b.getPdfFile() != null) {
            this.f5902c.f5879d.loadDataWithBaseURL(StatementDetail.TEMP_STATEMENT_DIRECTORY.toURI().toString(), this.f5902c.f5877b.getWebOutput(), "text/html", "UTF-8", (String) null);
        } else {
            this.f5902c.m5841d(statementDetail.getMessage());
        }
        this.f5902c.m5855q();
        this.f5902c.m5851n();
    }

    /* renamed from: b */
    public void mo9581b(Loader<StatementDetail> loader, C1389d dVar) {
        this.f5902c.mo10989m();
    }

    public Loader<StatementDetail> onCreateLoader(int i, Bundle bundle) {
        return new C1454o(this.f5902c.getActivity(), this.f5902c.f5876a);
    }

    public void onLoaderReset(Loader<StatementDetail> loader) {
    }
}
