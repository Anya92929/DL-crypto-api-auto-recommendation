package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.C0169e;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0412dn;
import com.google.android.gms.internal.C0413do;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;

    /* renamed from: jc */
    private int f361jc;

    /* renamed from: jd */
    private View f362jd;

    /* renamed from: je */
    private View.OnClickListener f363je;
    private int mSize;

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f363je = null;
        setStyle(0, 0);
    }

    /* renamed from: c */
    private static Button m235c(Context context, int i, int i2) {
        C0413do doVar = new C0413do(context);
        doVar.mo4391a(context.getResources(), i, i2);
        return doVar;
    }

    /* renamed from: p */
    private void m236p(Context context) {
        if (this.f362jd != null) {
            removeView(this.f362jd);
        }
        try {
            this.f362jd = C0412dn.m949d(context, this.mSize, this.f361jc);
        } catch (C0169e.C0170a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f362jd = m235c(context, this.mSize, this.f361jc);
        }
        addView(this.f362jd);
        this.f362jd.setEnabled(isEnabled());
        this.f362jd.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.f363je != null && view == this.f362jd) {
            this.f363je.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.f362jd.setEnabled(enabled);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.f363je = listener;
        if (this.f362jd != null) {
            this.f362jd.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.f361jc);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = true;
        C0411dm.m941a(buttonSize >= 0 && buttonSize < 3, (Object) "Unknown button size " + buttonSize);
        if (colorScheme < 0 || colorScheme >= 2) {
            z = false;
        }
        C0411dm.m941a(z, (Object) "Unknown color scheme " + colorScheme);
        this.mSize = buttonSize;
        this.f361jc = colorScheme;
        m236p(getContext());
    }
}
