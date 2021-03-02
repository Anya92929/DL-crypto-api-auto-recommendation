package com.jackhenry.godough.core.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class JhaEditText extends EditText {

    /* renamed from: a */
    private OnBackKeyPressedListener f6857a;

    public interface OnBackKeyPressedListener {
        void onBackKeyPressed(View view);
    }

    public JhaEditText(Context context) {
        super(context);
    }

    public JhaEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JhaEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.f6857a != null) {
            this.f6857a.onBackKeyPressed(this);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnBackKeyPressedListener(OnBackKeyPressedListener onBackKeyPressedListener) {
        this.f6857a = onBackKeyPressedListener;
    }
}
