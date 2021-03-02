package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0334R;

/* renamed from: com.google.android.gms.internal.u */
public final class C0623u extends Button {
    public C0623u(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0623u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: a */
    private int m1895a(int i, int i2, int i3) {
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
    private void m1896b(Resources resources, int i, int i2) {
        int a;
        switch (i) {
            case 0:
            case 1:
                a = m1895a(i2, C0334R.drawable.common_signin_btn_text_dark, C0334R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                a = m1895a(i2, C0334R.drawable.common_signin_btn_icon_dark, C0334R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (a == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(a));
    }

    /* renamed from: c */
    private void m1897c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: c */
    private void m1898c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m1895a(i2, C0334R.color.common_signin_btn_text_dark, C0334R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0334R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0334R.string.common_signin_button_text_long));
                return;
            case 2:
                setText((CharSequence) null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    /* renamed from: a */
    public void mo5489a(Resources resources, int i, int i2) {
        boolean z = true;
        C0621s.m1885a(i >= 0 && i < 3, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        C0621s.m1885a(z, "Unknown color scheme " + i2);
        m1897c(resources);
        m1896b(resources, i, i2);
        m1898c(resources, i, i2);
    }
}
