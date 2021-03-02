package com.jackhenry.android.widget.quickactionmenu;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.jackhenry.android.widget.quickactionmenu.a */
class C1371a implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ PopupWindows f5706a;

    C1371a(PopupWindows popupWindows) {
        this.f5706a = popupWindows;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        this.f5706a.f5687b.dismiss();
        return true;
    }
}
