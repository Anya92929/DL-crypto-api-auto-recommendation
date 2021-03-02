package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;

/* renamed from: android.support.v7.preference.CheckBoxPreference */
public class CheckBoxPreference extends TwoStatePreference {
    public CheckBoxPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.checkBoxPreferenceStyle);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.CheckBoxPreference, i, i2);
        setSummaryOn((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.CheckBoxPreference_summaryOn, C0268R.styleable.CheckBoxPreference_android_summaryOn));
        setSummaryOff((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.CheckBoxPreference_summaryOff, C0268R.styleable.CheckBoxPreference_android_summaryOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.CheckBoxPreference_disableDependentsState, C0268R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    private void m1543c(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            m1544d(view.findViewById(C0268R.C0270id.checkbox));
            mo4939b(view.findViewById(16908304));
        }
    }

    /* renamed from: d */
    private void m1544d(View view) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f2525a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4727a(View view) {
        super.mo4727a(view);
        m1543c(view);
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        View findViewById = preferenceViewHolder.findViewById(C0268R.C0270id.checkbox);
        if (findViewById != null && (findViewById instanceof Checkable)) {
            ((Checkable) findViewById).setChecked(this.f2525a);
        }
        mo4938a(preferenceViewHolder);
    }
}
