package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C1204R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

public final class zzag extends Button {
    public zzag(Context context) {
        this(context, (AttributeSet) null);
    }

    public zzag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: a */
    private int m6071a(int i, int i2, int i3) {
        switch (i) {
            case 0:
            case 1:
                return i3;
            case 2:
                return i2;
            default:
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i).toString());
        }
    }

    /* renamed from: a */
    private int m6072a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException(new StringBuilder(33).append("Unknown color scheme: ").append(i).toString());
        }
    }

    /* renamed from: a */
    private void m6073a(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: a */
    private void m6074a(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? m6071a(i, m6072a(i2, C1204R.drawable.common_plus_signin_btn_icon_dark, C1204R.drawable.common_plus_signin_btn_icon_light, C1204R.drawable.common_plus_signin_btn_icon_dark), m6072a(i2, C1204R.drawable.common_plus_signin_btn_text_dark, C1204R.drawable.common_plus_signin_btn_text_light, C1204R.drawable.common_plus_signin_btn_text_dark)) : m6071a(i, m6072a(i2, C1204R.drawable.common_google_signin_btn_icon_dark, C1204R.drawable.common_google_signin_btn_icon_light, C1204R.drawable.common_google_signin_btn_icon_light), m6072a(i2, C1204R.drawable.common_google_signin_btn_text_dark, C1204R.drawable.common_google_signin_btn_text_light, C1204R.drawable.common_google_signin_btn_text_light))));
    }

    /* renamed from: a */
    private boolean m6075a(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope zzaok : scopeArr) {
            String zzaok2 = zzaok.zzaok();
            if (zzaok2.contains("/plus.") && !zzaok2.equals(Scopes.PLUS_ME)) {
                return true;
            }
            if (zzaok2.equals(Scopes.GAMES)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m6076b(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzab.zzy(resources.getColorStateList(z ? m6072a(i2, C1204R.color.common_plus_signin_btn_text_dark, C1204R.color.common_plus_signin_btn_text_light, C1204R.color.common_plus_signin_btn_text_dark) : m6072a(i2, C1204R.color.common_google_signin_btn_text_dark, C1204R.color.common_google_signin_btn_text_light, C1204R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C1204R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C1204R.string.common_signin_button_text_long));
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i).toString());
        }
        setTransformationMethod((TransformationMethod) null);
    }

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean a = m6075a(scopeArr);
        m6073a(resources);
        m6074a(resources, i, i2, a);
        m6076b(resources, i, i2, a);
    }
}
