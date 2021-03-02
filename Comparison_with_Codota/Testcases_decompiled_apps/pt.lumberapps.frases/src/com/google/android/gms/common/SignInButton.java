package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C1204R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.dynamic.zzg;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;

    /* renamed from: a */
    private int f4278a;

    /* renamed from: b */
    private int f4279b;

    /* renamed from: c */
    private Scope[] f4280c;

    /* renamed from: d */
    private View f4281d;

    /* renamed from: e */
    private View.OnClickListener f4282e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4282e = null;
        m5954a(context, attributeSet);
        setStyle(this.f4278a, this.f4279b, this.f4280c);
    }

    /* renamed from: a */
    private static Button m5952a(Context context, int i, int i2, Scope[] scopeArr) {
        zzag zzag = new zzag(context);
        zzag.zza(context.getResources(), i, i2, scopeArr);
        return zzag;
    }

    /* renamed from: a */
    private void m5953a(Context context) {
        if (this.f4281d != null) {
            removeView(this.f4281d);
        }
        try {
            this.f4281d = zzaf.zzb(context, this.f4278a, this.f4279b, this.f4280c);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f4281d = m5952a(context, this.f4278a, this.f4279b, this.f4280c);
        }
        addView(this.f4281d);
        this.f4281d.setEnabled(isEnabled());
        this.f4281d.setOnClickListener(this);
    }

    /* renamed from: a */
    private void m5954a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1204R.styleable.SignInButton, 0, 0);
        try {
            this.f4278a = obtainStyledAttributes.getInt(C1204R.styleable.SignInButton_buttonSize, 0);
            this.f4279b = obtainStyledAttributes.getInt(C1204R.styleable.SignInButton_colorScheme, 2);
            String string = obtainStyledAttributes.getString(C1204R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.f4280c = null;
            } else {
                String[] split = string.trim().split("\\s+");
                this.f4280c = new Scope[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.f4280c[i] = new Scope(split[i].toString());
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onClick(View view) {
        if (this.f4282e != null && view == this.f4281d) {
            this.f4282e.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.f4278a, i, this.f4280c);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4281d.setEnabled(z);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f4282e = onClickListener;
        if (this.f4281d != null) {
            this.f4281d.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        setStyle(this.f4278a, this.f4279b, scopeArr);
    }

    public void setSize(int i) {
        setStyle(i, this.f4279b, this.f4280c);
    }

    public void setStyle(int i, int i2) {
        setStyle(i, i2, this.f4280c);
    }

    public void setStyle(int i, int i2, Scope[] scopeArr) {
        this.f4278a = i;
        this.f4279b = i2;
        this.f4280c = scopeArr;
        m5953a(getContext());
    }
}
