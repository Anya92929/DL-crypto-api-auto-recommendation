package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0135R;

/* renamed from: com.google.android.gms.common.internal.p */
public final class C0350p extends Button {
    public C0350p(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0350p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: b */
    private int m866b(int i, int i2, int i3) {
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
    private void m867b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case 0:
            case 1:
                b = m866b(i2, C0135R.C0136drawable.common_signin_btn_text_dark, C0135R.C0136drawable.common_signin_btn_text_light);
                break;
            case 2:
                b = m866b(i2, C0135R.C0136drawable.common_signin_btn_icon_dark, C0135R.C0136drawable.common_signin_btn_icon_light);
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
    private void m868c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: c */
    private void m869c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m866b(i2, C0135R.color.common_signin_btn_text_dark, C0135R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0135R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0135R.string.common_signin_button_text_long));
                return;
            case 2:
                setText((CharSequence) null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    /* renamed from: a */
    public void mo4553a(Resources resources, int i, int i2) {
        C0348n.m853a(i >= 0 && i < 3, "Unknown button size %d", Integer.valueOf(i));
        C0348n.m853a(i2 >= 0 && i2 < 2, "Unknown color scheme %s", Integer.valueOf(i2));
        m868c(resources);
        m867b(resources, i, i2);
        m869c(resources, i, i2);
    }
}
