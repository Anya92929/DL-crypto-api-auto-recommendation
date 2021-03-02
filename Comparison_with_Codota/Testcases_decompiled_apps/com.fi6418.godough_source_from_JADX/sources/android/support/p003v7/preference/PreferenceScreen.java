package android.support.p003v7.preference;

import android.content.Context;
import android.support.p003v7.preference.PreferenceManager;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.PreferenceScreen */
public final class PreferenceScreen extends PreferenceGroup {
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0268R.attr.preferenceScreenStyle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4729a() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListener;
        if (getIntent() == null && getFragment() == null && getPreferenceCount() != 0 && (onNavigateToScreenListener = getPreferenceManager().getOnNavigateToScreenListener()) != null) {
            onNavigateToScreenListener.onNavigateToScreen(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo4888j() {
        return false;
    }
}
