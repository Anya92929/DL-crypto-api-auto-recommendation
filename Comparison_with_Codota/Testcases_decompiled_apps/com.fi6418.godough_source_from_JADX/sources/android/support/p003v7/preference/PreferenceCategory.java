package android.support.p003v7.preference;

import android.content.Context;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.PreferenceCategory */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context) {
        this(context, (AttributeSet) null);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.preferenceCategoryStyle);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4857a(Preference preference) {
        if (!(preference instanceof PreferenceCategory)) {
            return super.mo4857a(preference);
        }
        throw new IllegalArgumentException("Cannot add a PreferenceCategory directly to a PreferenceCategory");
    }

    public boolean isEnabled() {
        return false;
    }

    public boolean shouldDisableDependents() {
        return !super.isEnabled();
    }
}
