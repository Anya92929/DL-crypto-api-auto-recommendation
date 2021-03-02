package com.jackhenry.godough.core.accounts.statements.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.jackhenry.godough.core.accounts.statements.widget.a */
class C1463a implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ GestureDetector f5921a;

    /* renamed from: b */
    final /* synthetic */ GoDoughStatementWebView f5922b;

    C1463a(GoDoughStatementWebView goDoughStatementWebView, GestureDetector gestureDetector) {
        this.f5922b = goDoughStatementWebView;
        this.f5921a = gestureDetector;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f5921a.onTouchEvent(motionEvent);
    }
}
