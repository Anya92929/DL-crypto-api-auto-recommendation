package org.commonwealthcu.mobile;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: org.commonwealthcu.mobile.bm */
final class C0623bm implements View.OnTouchListener {
    C0623bm(C0620bj bjVar) {
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
