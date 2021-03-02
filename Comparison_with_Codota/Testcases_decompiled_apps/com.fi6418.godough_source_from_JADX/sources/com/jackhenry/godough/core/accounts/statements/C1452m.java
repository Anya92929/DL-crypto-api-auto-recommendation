package com.jackhenry.godough.core.accounts.statements;

import android.content.Context;
import android.webkit.JavascriptInterface;

/* renamed from: com.jackhenry.godough.core.accounts.statements.m */
class C1452m {

    /* renamed from: a */
    final /* synthetic */ StatementDetailFragment f5905a;

    /* renamed from: b */
    private Context f5906b;

    public C1452m(StatementDetailFragment statementDetailFragment, Context context) {
        this.f5905a = statementDetailFragment;
        this.f5906b = context;
    }

    @JavascriptInterface
    public void showPageCounter(int i) {
        this.f5905a.m5835a(i + 1);
    }
}
