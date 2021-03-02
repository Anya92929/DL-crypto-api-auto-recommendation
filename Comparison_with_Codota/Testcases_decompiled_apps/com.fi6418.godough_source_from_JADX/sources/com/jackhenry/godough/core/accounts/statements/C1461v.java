package com.jackhenry.godough.core.accounts.statements;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import android.text.TextUtils;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.accounts.statements.model.StatementResponse;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.accounts.statements.v */
class C1461v extends C1895t<StatementResponse> {

    /* renamed from: c */
    final /* synthetic */ StatementFragment f5917c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1461v(StatementFragment statementFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f5917c = statementFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<StatementResponse> loader, C1389d dVar) {
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<StatementResponse> loader, StatementResponse statementResponse) {
        this.f5917c.mo10989m();
        ArrayList unused = this.f5917c.f5887c = statementResponse.getStatements();
        if (this.f5917c.f5887c.size() == 0) {
            this.f5917c.f5886b.setVisibility(8);
            TextView textView = (TextView) this.f5917c.f5889e.findViewById(C1494ai.empty_statement_list);
            if (!TextUtils.isEmpty(statementResponse.getMessage())) {
                textView.setText(statementResponse.getMessage());
            }
            textView.setVisibility(0);
        }
        this.f5917c.m5870n();
    }

    /* renamed from: b */
    public void mo9581b(Loader<StatementResponse> loader, C1389d dVar) {
        this.f5917c.mo10989m();
    }

    public Loader<StatementResponse> onCreateLoader(int i, Bundle bundle) {
        return new C1442c(this.f5917c.getActivity());
    }

    public void onLoaderReset(Loader<StatementResponse> loader) {
    }
}
