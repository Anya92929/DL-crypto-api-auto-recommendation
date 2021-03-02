package android.support.p009v4.widget;

import android.view.View;
import android.view.WindowInsets;

/* renamed from: android.support.v4.widget.ad */
class C0361ad implements View.OnApplyWindowInsetsListener {
    C0361ad() {
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((C0362ae) view).mo1641a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
