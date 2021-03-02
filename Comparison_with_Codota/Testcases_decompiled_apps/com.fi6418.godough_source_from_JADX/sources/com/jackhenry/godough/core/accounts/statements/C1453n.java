package com.jackhenry.godough.core.accounts.statements;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* renamed from: com.jackhenry.godough.core.accounts.statements.n */
class C1453n extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ StatementDetailFragment f5907a;

    C1453n(StatementDetailFragment statementDetailFragment) {
        this.f5907a = statementDetailFragment;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.f5907a.mo10989m();
        }
    }
}
