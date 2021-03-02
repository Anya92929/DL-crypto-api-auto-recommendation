package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0666R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
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
    private int f2598a;

    /* renamed from: b */
    private int f2599b;

    /* renamed from: c */
    private Scope[] f2600c;

    /* renamed from: d */
    private View f2601d;

    /* renamed from: e */
    private View.OnClickListener f2602e;

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
        this.f2602e = null;
        m3691a(context, attributeSet);
        setStyle(this.f2598a, this.f2599b, this.f2600c);
    }

    /* renamed from: a */
    private static Button m3689a(Context context, int i, int i2, Scope[] scopeArr) {
        zzac zzac = new zzac(context);
        zzac.zza(context.getResources(), i, i2, scopeArr);
        return zzac;
    }

    /* renamed from: a */
    private void m3690a(Context context) {
        if (this.f2601d != null) {
            removeView(this.f2601d);
        }
        try {
            this.f2601d = zzab.zzb(context, this.f2598a, this.f2599b, this.f2600c);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f2601d = m3689a(context, this.f2598a, this.f2599b, this.f2600c);
        }
        addView(this.f2601d);
        this.f2601d.setEnabled(isEnabled());
        this.f2601d.setOnClickListener(this);
    }

    /* renamed from: a */
    private void m3691a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0666R.styleable.SignInButton, 0, 0);
        try {
            this.f2598a = obtainStyledAttributes.getInt(C0666R.styleable.SignInButton_buttonSize, 0);
            this.f2599b = obtainStyledAttributes.getInt(C0666R.styleable.SignInButton_colorScheme, 2);
            String string = obtainStyledAttributes.getString(C0666R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.f2600c = null;
            } else {
                String[] split = string.trim().split("\\s+");
                this.f2600c = new Scope[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.f2600c[i] = new Scope(split[i].toString());
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onClick(View view) {
        if (this.f2602e != null && view == this.f2601d) {
            this.f2602e.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.f2598a, i, this.f2600c);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2601d.setEnabled(z);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2602e = onClickListener;
        if (this.f2601d != null) {
            this.f2601d.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        setStyle(this.f2598a, this.f2599b, scopeArr);
    }

    public void setSize(int i) {
        setStyle(i, this.f2599b, this.f2600c);
    }

    public void setStyle(int i, int i2) {
        setStyle(i, i2, this.f2600c);
    }

    public void setStyle(int i, int i2, Scope[] scopeArr) {
        this.f2598a = i;
        this.f2599b = i2;
        this.f2600c = scopeArr;
        m3690a(getContext());
    }
}
