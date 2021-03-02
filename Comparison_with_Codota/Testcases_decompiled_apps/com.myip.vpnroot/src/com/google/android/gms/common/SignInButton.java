package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.C0349o;
import com.google.android.gms.common.internal.C0350p;
import com.google.android.gms.dynamic.C0599g;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;

    /* renamed from: Ih */
    private View f549Ih;

    /* renamed from: Ii */
    private View.OnClickListener f550Ii;
    private int mColor;
    private int mSize;

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f550Ii = null;
        setStyle(0, 0);
    }

    /* renamed from: G */
    private void m478G(Context context) {
        if (this.f549Ih != null) {
            removeView(this.f549Ih);
        }
        try {
            this.f549Ih = C0349o.m862b(context, this.mSize, this.mColor);
        } catch (C0599g.C0600a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f549Ih = m479a(context, this.mSize, this.mColor);
        }
        addView(this.f549Ih);
        this.f549Ih.setEnabled(isEnabled());
        this.f549Ih.setOnClickListener(this);
    }

    /* renamed from: a */
    private static Button m479a(Context context, int i, int i2) {
        C0350p pVar = new C0350p(context);
        pVar.mo4553a(context.getResources(), i, i2);
        return pVar;
    }

    public void onClick(View view) {
        if (this.f550Ii != null && view == this.f549Ih) {
            this.f550Ii.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.f549Ih.setEnabled(enabled);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.f550Ii = listener;
        if (this.f549Ih != null) {
            this.f549Ih.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.mColor);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        C0348n.m853a(buttonSize >= 0 && buttonSize < 3, "Unknown button size %d", Integer.valueOf(buttonSize));
        C0348n.m853a(colorScheme >= 0 && colorScheme < 2, "Unknown color scheme %s", Integer.valueOf(colorScheme));
        this.mSize = buttonSize;
        this.mColor = colorScheme;
        m478G(getContext());
    }
}
