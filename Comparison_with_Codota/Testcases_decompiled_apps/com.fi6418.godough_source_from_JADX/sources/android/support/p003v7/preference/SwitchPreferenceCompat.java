package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.support.p003v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.preference.SwitchPreferenceCompat */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: b */
    private final Listener f2521b;

    /* renamed from: c */
    private CharSequence f2522c;

    /* renamed from: d */
    private CharSequence f2523d;

    /* renamed from: android.support.v7.preference.SwitchPreferenceCompat$Listener */
    class Listener implements CompoundButton.OnCheckedChangeListener {
        private Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.setChecked(z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2521b = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.SwitchPreferenceCompat, i, i2);
        setSummaryOn((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.SwitchPreferenceCompat_summaryOn, C0268R.styleable.SwitchPreferenceCompat_android_summaryOn));
        setSummaryOff((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.SwitchPreferenceCompat_summaryOff, C0268R.styleable.SwitchPreferenceCompat_android_summaryOff));
        setSwitchTextOn((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.SwitchPreferenceCompat_switchTextOn, C0268R.styleable.SwitchPreferenceCompat_android_switchTextOn));
        setSwitchTextOff((CharSequence) TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.SwitchPreferenceCompat_switchTextOff, C0268R.styleable.SwitchPreferenceCompat_android_switchTextOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(obtainStyledAttributes, C0268R.styleable.SwitchPreferenceCompat_disableDependentsState, C0268R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    private void m1638c(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            m1639d(view.findViewById(C0268R.C0270id.switchWidget));
            mo4939b(view.findViewById(16908304));
        }
    }

    /* renamed from: d */
    private void m1639d(View view) {
        if (view instanceof SwitchCompat) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f2525a);
        }
        if (view instanceof SwitchCompat) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f2522c);
            switchCompat.setTextOff(this.f2523d);
            switchCompat.setOnCheckedChangeListener(this.f2521b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4727a(View view) {
        super.mo4727a(view);
        m1638c(view);
    }

    public CharSequence getSwitchTextOff() {
        return this.f2523d;
    }

    public CharSequence getSwitchTextOn() {
        return this.f2522c;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        m1639d(preferenceViewHolder.findViewById(C0268R.C0270id.switchWidget));
        mo4938a(preferenceViewHolder);
    }

    public void setSwitchTextOff(int i) {
        setSwitchTextOff((CharSequence) getContext().getString(i));
    }

    public void setSwitchTextOff(CharSequence charSequence) {
        this.f2523d = charSequence;
        mo4795f();
    }

    public void setSwitchTextOn(int i) {
        setSwitchTextOn((CharSequence) getContext().getString(i));
    }

    public void setSwitchTextOn(CharSequence charSequence) {
        this.f2522c = charSequence;
        mo4795f();
    }
}
