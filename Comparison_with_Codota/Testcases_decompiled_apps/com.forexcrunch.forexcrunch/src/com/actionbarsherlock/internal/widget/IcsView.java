package com.actionbarsherlock.internal.widget;

import android.view.View;
import org.achartengine.renderer.DefaultRenderer;

final class IcsView {
    private IcsView() {
    }

    public static int getMeasuredStateInt(View child) {
        return (child.getMeasuredWidth() & DefaultRenderer.BACKGROUND_COLOR) | ((child.getMeasuredHeight() >> 16) & -256);
    }
}
