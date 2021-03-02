package com.jackhenry.godough.core.locations;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.jackhenry.godough.core.locations.u */
class C1622u implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ LocationZipFragment f6258a;

    C1622u(LocationZipFragment locationZipFragment) {
        this.f6258a = locationZipFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2 && this.f6258a.f6220c.isEnabled()) {
            this.f6258a.f6220c.performClick();
        }
        return true;
    }
}
