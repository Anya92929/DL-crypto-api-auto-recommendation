package com.actionbarsherlock.internal.view;

import android.view.View;

public interface View_OnAttachStateChangeListener {
    void onViewAttachedToWindow(View view);

    void onViewDetachedFromWindow(View view);
}
