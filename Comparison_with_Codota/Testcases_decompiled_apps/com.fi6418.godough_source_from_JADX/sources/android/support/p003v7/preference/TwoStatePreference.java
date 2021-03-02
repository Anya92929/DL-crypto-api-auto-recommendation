package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p003v7.preference.Preference;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.TwoStatePreference */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: a */
    protected boolean f2525a;

    /* renamed from: b */
    private CharSequence f2526b;

    /* renamed from: c */
    private CharSequence f2527c;

    /* renamed from: d */
    private boolean f2528d;

    /* renamed from: e */
    private boolean f2529e;

    /* renamed from: android.support.v7.preference.TwoStatePreference$SavedState */
    class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        boolean f2530a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z = true;
            this.f2530a = parcel.readInt() != 1 ? false : z;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2530a ? 1 : 0);
        }
    }

    public TwoStatePreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4748a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4729a() {
        super.mo4729a();
        boolean z = !isChecked();
        if (callChangeListener(Boolean.valueOf(z))) {
            setChecked(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4749a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.mo4749a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.mo4749a(savedState.getSuperState());
        setChecked(savedState.f2530a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4938a(PreferenceViewHolder preferenceViewHolder) {
        mo4939b(preferenceViewHolder.findViewById(16908304));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4750a(boolean z, Object obj) {
        setChecked(z ? mo4787b(this.f2525a) : ((Boolean) obj).booleanValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Parcelable mo4751b() {
        Parcelable b = super.mo4751b();
        if (isPersistent()) {
            return b;
        }
        SavedState savedState = new SavedState(b);
        savedState.f2530a = isChecked();
        return savedState;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4939b(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r5 instanceof android.widget.TextView
            if (r1 != 0) goto L_0x0006
        L_0x0005:
            return
        L_0x0006:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r1 = 1
            boolean r2 = r4.f2525a
            if (r2 == 0) goto L_0x0039
            java.lang.CharSequence r2 = r4.f2526b
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0039
            java.lang.CharSequence r1 = r4.f2526b
            r5.setText(r1)
            r1 = r0
        L_0x001b:
            if (r1 == 0) goto L_0x004e
            java.lang.CharSequence r2 = r4.getSummary()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x004e
            r5.setText(r2)
            r2 = r0
        L_0x002b:
            r1 = 8
            if (r2 != 0) goto L_0x004c
        L_0x002f:
            int r1 = r5.getVisibility()
            if (r0 == r1) goto L_0x0005
            r5.setVisibility(r0)
            goto L_0x0005
        L_0x0039:
            boolean r2 = r4.f2525a
            if (r2 != 0) goto L_0x001b
            java.lang.CharSequence r2 = r4.f2527c
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x001b
            java.lang.CharSequence r1 = r4.f2527c
            r5.setText(r1)
            r1 = r0
            goto L_0x001b
        L_0x004c:
            r0 = r1
            goto L_0x002f
        L_0x004e:
            r2 = r1
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.preference.TwoStatePreference.mo4939b(android.view.View):void");
    }

    public boolean getDisableDependentsState() {
        return this.f2529e;
    }

    public CharSequence getSummaryOff() {
        return this.f2527c;
    }

    public CharSequence getSummaryOn() {
        return this.f2526b;
    }

    public boolean isChecked() {
        return this.f2525a;
    }

    public void setChecked(boolean z) {
        boolean z2 = this.f2525a != z;
        if (z2 || !this.f2528d) {
            this.f2525a = z;
            this.f2528d = true;
            mo4784a(z);
            if (z2) {
                notifyDependencyChange(shouldDisableDependents());
                mo4795f();
            }
        }
    }

    public void setDisableDependentsState(boolean z) {
        this.f2529e = z;
    }

    public void setSummaryOff(int i) {
        setSummaryOff((CharSequence) getContext().getString(i));
    }

    public void setSummaryOff(CharSequence charSequence) {
        this.f2527c = charSequence;
        if (!isChecked()) {
            mo4795f();
        }
    }

    public void setSummaryOn(int i) {
        setSummaryOn((CharSequence) getContext().getString(i));
    }

    public void setSummaryOn(CharSequence charSequence) {
        this.f2526b = charSequence;
        if (isChecked()) {
            mo4795f();
        }
    }

    public boolean shouldDisableDependents() {
        return (this.f2529e ? this.f2525a : !this.f2525a) || super.shouldDisableDependents();
    }
}
