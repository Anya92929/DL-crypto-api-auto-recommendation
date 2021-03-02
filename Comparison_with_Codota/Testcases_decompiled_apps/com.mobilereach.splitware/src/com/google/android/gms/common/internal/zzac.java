package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0171R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

public final class zzac extends Button {
    public zzac(Context context) {
        this(context, (AttributeSet) null);
    }

    public zzac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void zza(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? zzd(i, zzf(i2, C0171R.C0172drawable.common_plus_signin_btn_icon_dark, C0171R.C0172drawable.common_plus_signin_btn_icon_light, C0171R.C0172drawable.common_plus_signin_btn_icon_dark), zzf(i2, C0171R.C0172drawable.common_plus_signin_btn_text_dark, C0171R.C0172drawable.common_plus_signin_btn_text_light, C0171R.C0172drawable.common_plus_signin_btn_text_dark)) : zzd(i, zzf(i2, C0171R.C0172drawable.common_google_signin_btn_icon_dark, C0171R.C0172drawable.common_google_signin_btn_icon_light, C0171R.C0172drawable.common_google_signin_btn_icon_light), zzf(i2, C0171R.C0172drawable.common_google_signin_btn_text_dark, C0171R.C0172drawable.common_google_signin_btn_text_light, C0171R.C0172drawable.common_google_signin_btn_text_light))));
    }

    private boolean zza(Scope[] scopeArr) {
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

    private void zzb(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzx.zzz(resources.getColorStateList(z ? zzf(i2, C0171R.color.common_plus_signin_btn_text_dark, C0171R.color.common_plus_signin_btn_text_light, C0171R.color.common_plus_signin_btn_text_dark) : zzf(i2, C0171R.color.common_google_signin_btn_text_dark, C0171R.color.common_google_signin_btn_text_light, C0171R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C0171R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C0171R.string.common_signin_button_text_long));
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod((TransformationMethod) null);
    }

    private int zzd(int i, int i2, int i3) {
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

    private int zzf(int i, int i2, int i3, int i4) {
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

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean zza = zza(scopeArr);
        zza(resources);
        zza(resources, i, i2, zza);
        zzb(resources, i, i2, zza);
    }
}
