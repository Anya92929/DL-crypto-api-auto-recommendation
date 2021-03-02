package org.commonwealthcu.mobile;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: org.commonwealthcu.mobile.r */
final class C0639r implements View.OnTouchListener {
    C0639r(BankingView bankingView) {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            default:
                return false;
        }
    }
}
