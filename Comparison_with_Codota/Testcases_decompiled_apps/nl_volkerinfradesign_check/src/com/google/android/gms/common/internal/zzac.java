package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0666R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

public final class zzac extends Button {
    public zzac(Context context) {
        this(context, (AttributeSet) null);
    }

    public zzac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: a */
    private int m3903a(int i, int i2, int i3) {
        switch (i) {
            case 0:
            case 1:
                return i3;
            case 2:
                return i2;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    /* renamed from: a */
    private int m3904a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    /* renamed from: a */
    private void m3905a(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: a */
    private void m3906a(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? m3903a(i, m3904a(i2, C0666R.C0667drawable.common_plus_signin_btn_icon_dark, C0666R.C0667drawable.common_plus_signin_btn_icon_light, C0666R.C0667drawable.common_plus_signin_btn_icon_dark), m3904a(i2, C0666R.C0667drawable.common_plus_signin_btn_text_dark, C0666R.C0667drawable.common_plus_signin_btn_text_light, C0666R.C0667drawable.common_plus_signin_btn_text_dark)) : m3903a(i, m3904a(i2, C0666R.C0667drawable.common_google_signin_btn_icon_dark, C0666R.C0667drawable.common_google_signin_btn_icon_light, C0666R.C0667drawable.common_google_signin_btn_icon_light), m3904a(i2, C0666R.C0667drawable.common_google_signin_btn_text_dark, C0666R.C0667drawable.common_google_signin_btn_text_light, C0666R.C0667drawable.common_google_signin_btn_text_light))));
    }

    /* renamed from: a */
    private boolean m3907a(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope zzpb : scopeArr) {
            String zzpb2 = zzpb.zzpb();
            if (zzpb2.contains("/plus.") && !zzpb2.equals(Scopes.PLUS_ME)) {
                return true;
            }
            if (zzpb2.equals(Scopes.GAMES)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m3908b(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzx.zzz(resources.getColorStateList(z ? m3904a(i2, C0666R.color.common_plus_signin_btn_text_dark, C0666R.color.common_plus_signin_btn_text_light, C0666R.color.common_plus_signin_btn_text_dark) : m3904a(i2, C0666R.color.common_google_signin_btn_text_dark, C0666R.color.common_google_signin_btn_text_light, C0666R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C0666R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C0666R.string.common_signin_button_text_long));
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod((TransformationMethod) null);
    }

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean a = m3907a(scopeArr);
        m3905a(resources);
        m3906a(resources, i, i2, a);
        m3908b(resources, i, i2, a);
    }
}
