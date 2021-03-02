package com.actionbarsherlock.internal.widget;

import android.view.View;

final class IcsView {
    private IcsView() {
    }

    public static int getMeasuredStateInt(View child) {
        return (child.getMeasuredWidth() & -16777216) | ((child.getMeasuredHeight() >> 16) & -256);
    }
}
