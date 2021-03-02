package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0129R;

/* renamed from: com.google.android.gms.internal.do */
public final class C0413do extends Button {
    public C0413do(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0413do(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: b */
    private int m953b(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    /* renamed from: b */
    private void m954b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case 0:
            case 1:
                b = m953b(i2, C0129R.drawable.common_signin_btn_text_dark, C0129R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                b = m953b(i2, C0129R.drawable.common_signin_btn_icon_dark, C0129R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    /* renamed from: c */
    private void m955c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: c */
    private void m956c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m953b(i2, C0129R.color.common_signin_btn_text_dark, C0129R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0129R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0129R.string.common_signin_button_text_long));
                return;
            case 2:
                setText((CharSequence) null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    /* renamed from: a */
    public void mo4391a(Resources resources, int i, int i2) {
        boolean z = true;
        C0411dm.m941a(i >= 0 && i < 3, (Object) "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        C0411dm.m941a(z, (Object) "Unknown color scheme " + i2);
        m955c(resources);
        m954b(resources, i, i2);
        m956c(resources, i, i2);
    }
}
