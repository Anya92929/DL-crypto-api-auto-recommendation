package com.jackhenry.godough.core.login;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.jackhenry.godough.core.login.bi */
class C1664bi implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ MFAActivity f6402a;

    C1664bi(MFAActivity mFAActivity) {
        this.f6402a = mFAActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2 && this.f6402a.f6302t.isEnabled()) {
            this.f6402a.f6302t.performClick();
        }
        return true;
    }
}
