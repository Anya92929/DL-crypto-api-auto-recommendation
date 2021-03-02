package com.jackhenry.godough.core.accounts.statements;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetailHeader;
import com.jackhenry.godough.core.accounts.statements.model.StatementGroup;

/* renamed from: com.jackhenry.godough.core.accounts.statements.s */
class C1458s implements ExpandableListView.OnChildClickListener {

    /* renamed from: a */
    final /* synthetic */ StatementFragment f5914a;

    C1458s(StatementFragment statementFragment) {
        this.f5914a = statementFragment;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        StatementDetailHeader statementDetailHeader = ((StatementGroup) this.f5914a.f5887c.get(i)).getStatementDetails().get(i2);
        if (((StatementGroup) this.f5914a.f5887c.get(i)).isDate()) {
            statementDetailHeader.setStatementTitle(this.f5914a.getString(C1506am.statements_for, Integer.valueOf(i2 + 1), ((StatementGroup) this.f5914a.f5887c.get(i)).getStatementTitle()));
        } else {
            statementDetailHeader.setStatementTitle(((StatementGroup) this.f5914a.f5887c.get(i)).getStatementTitle());
        }
        statementDetailHeader.setTitleIsDate(((StatementGroup) this.f5914a.f5887c.get(i)).isDate());
        Intent intent = new Intent(GoDoughApp.getApp(), StatementDetailFragmentActivity.class);
        intent.putExtra("EXTRA_STATEMENT_DETAIL", statementDetailHeader);
        this.f5914a.getActivity().startActivity(intent);
        return true;
    }
}
