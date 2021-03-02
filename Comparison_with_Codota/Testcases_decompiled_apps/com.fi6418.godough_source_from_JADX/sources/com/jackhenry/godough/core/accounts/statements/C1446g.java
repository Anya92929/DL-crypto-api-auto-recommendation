package com.jackhenry.godough.core.accounts.statements;

import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.accounts.statements.g */
class C1446g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f5898a;

    /* renamed from: b */
    final /* synthetic */ StatementDetailFragment f5899b;

    C1446g(StatementDetailFragment statementDetailFragment, int i) {
        this.f5899b = statementDetailFragment;
        this.f5898a = i;
    }

    public void run() {
        this.f5899b.f5882g.removeCallbacks(this.f5899b.f5883h);
        this.f5899b.f5884i.setText(this.f5899b.getString(C1506am.statements_pageCount, Integer.valueOf(this.f5898a), Integer.valueOf(this.f5899b.f5877b.getPageCount())));
        this.f5899b.f5884i.setVisibility(0);
        this.f5899b.f5882g.postDelayed(this.f5899b.f5883h, 1000);
    }
}
