package com.jackhenry.godough.core.accounts.statements.widget;

import android.view.GestureDetector;
import android.webkit.WebView;

/* renamed from: com.jackhenry.godough.core.accounts.statements.widget.b */
class C1464b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    WebView f5923a;

    /* renamed from: b */
    final /* synthetic */ GoDoughStatementWebView f5924b;

    public C1464b(GoDoughStatementWebView goDoughStatementWebView, WebView webView) {
        this.f5924b = goDoughStatementWebView;
        this.f5923a = webView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:4:0x000c, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v3 int) binds: [B:0:0x0000, B:4:0x000c] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onDoubleTapEvent(android.view.MotionEvent r3) {
        /*
            r2 = this;
            r0 = 0
        L_0x0001:
            android.webkit.WebView r1 = r2.f5923a
            boolean r1 = r1.zoomOut()
            if (r1 == 0) goto L_0x000e
            int r0 = r0 + 1
            r1 = 4
            if (r0 <= r1) goto L_0x0001
        L_0x000e:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jackhenry.godough.core.accounts.statements.widget.C1464b.onDoubleTapEvent(android.view.MotionEvent):boolean");
    }
}
