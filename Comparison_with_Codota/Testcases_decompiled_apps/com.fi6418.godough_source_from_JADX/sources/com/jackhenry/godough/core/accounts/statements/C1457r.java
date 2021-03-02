package com.jackhenry.godough.core.accounts.statements;

import android.widget.ExpandableListView;

/* renamed from: com.jackhenry.godough.core.accounts.statements.r */
class C1457r implements ExpandableListView.OnGroupExpandListener {

    /* renamed from: a */
    final /* synthetic */ StatementFragment f5913a;

    C1457r(StatementFragment statementFragment) {
        this.f5913a = statementFragment;
    }

    public void onGroupExpand(int i) {
        if (!(this.f5913a.f5890f == -1 || i == this.f5913a.f5890f)) {
            this.f5913a.f5886b.collapseGroup(this.f5913a.f5890f);
        }
        int unused = this.f5913a.f5890f = i;
    }
}
