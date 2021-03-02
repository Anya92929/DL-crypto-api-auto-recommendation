package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p003v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.EditTextPreference */
public class EditTextPreference extends DialogPreference {

    /* renamed from: a */
    private String f2432a;

    /* renamed from: android.support.v7.preference.EditTextPreference$SavedState */
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
        String f2433a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2433a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2433a);
        }
    }

    public EditTextPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.editTextPreferenceStyle);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo4748a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
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
        setText(savedState.f2433a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4750a(boolean z, Object obj) {
        setText(z ? mo4789c(this.f2432a) : (String) obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Parcelable mo4751b() {
        Parcelable b = super.mo4751b();
        if (isPersistent()) {
            return b;
        }
        SavedState savedState = new SavedState(b);
        savedState.f2433a = getText();
        return savedState;
    }

    public String getText() {
        return this.f2432a;
    }

    public void setText(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.f2432a = str;
        mo4786b(str);
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
    }

    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.f2432a) || super.shouldDisableDependents();
    }
}
