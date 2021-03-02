package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.C0373e;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.internal.C0622t;
import com.google.android.gms.internal.C0623u;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;

    /* renamed from: O */
    private int f786O;

    /* renamed from: P */
    private int f787P;

    /* renamed from: Q */
    private View f788Q;

    /* renamed from: R */
    private View.OnClickListener f789R;

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f789R = null;
        setStyle(0, 0);
    }

    /* renamed from: c */
    private static Button m557c(Context context, int i, int i2) {
        C0623u uVar = new C0623u(context);
        uVar.mo5489a(context.getResources(), i, i2);
        return uVar;
    }

    /* renamed from: d */
    private void m558d(Context context) {
        if (this.f788Q != null) {
            removeView(this.f788Q);
        }
        try {
            this.f788Q = C0622t.m1891d(context, this.f786O, this.f787P);
        } catch (C0373e.C0374a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f788Q = m557c(context, this.f786O, this.f787P);
        }
        addView(this.f788Q);
        this.f788Q.setEnabled(isEnabled());
        this.f788Q.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.f789R != null && view == this.f788Q) {
            this.f789R.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.f786O, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.f788Q.setEnabled(enabled);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.f789R = listener;
        if (this.f788Q != null) {
            this.f788Q.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.f787P);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = true;
        C0621s.m1885a(buttonSize >= 0 && buttonSize < 3, "Unknown button size " + buttonSize);
        if (colorScheme < 0 || colorScheme >= 2) {
            z = false;
        }
        C0621s.m1885a(z, "Unknown color scheme " + colorScheme);
        this.f786O = buttonSize;
        this.f787P = colorScheme;
        m558d(getContext());
    }
}
