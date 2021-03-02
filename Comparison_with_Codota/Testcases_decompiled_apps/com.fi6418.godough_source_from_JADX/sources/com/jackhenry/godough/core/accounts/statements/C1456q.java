package com.jackhenry.godough.core.accounts.statements;

import android.view.View;
import android.widget.ExpandableListView;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.accounts.statements.q */
class C1456q implements ExpandableListView.OnGroupClickListener {

    /* renamed from: a */
    final /* synthetic */ StatementFragment f5912a;

    C1456q(StatementFragment statementFragment) {
        this.f5912a = statementFragment;
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        if (this.f5912a.f5888d.getChildrenCount(i) != 0) {
            return false;
        }
        AbstractActivity abstractActivity = (AbstractActivity) this.f5912a.getActivity();
        if (abstractActivity != null) {
            abstractActivity.showDialog(this.f5912a.getString(C1506am.statements_info_title), this.f5912a.getString(C1506am.statements_no_statements));
        }
        return true;
    }
}
