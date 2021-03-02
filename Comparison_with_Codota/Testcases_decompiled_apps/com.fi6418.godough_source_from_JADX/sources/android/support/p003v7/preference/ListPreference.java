package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.support.p003v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.ListPreference */
public class ListPreference extends DialogPreference {

    /* renamed from: a */
    private CharSequence[] f2435a;

    /* renamed from: b */
    private CharSequence[] f2436b;

    /* renamed from: c */
    private String f2437c;

    /* renamed from: d */
    private String f2438d;

    /* renamed from: e */
    private boolean f2439e;

    /* renamed from: android.support.v7.preference.ListPreference$SavedState */
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
        String f2440a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2440a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2440a);
        }
    }

    public ListPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.dialogPreferenceStyle);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.ListPreference, i, i2);
        this.f2435a = TypedArrayUtils.getTextArray(obtainStyledAttributes, C0268R.styleable.ListPreference_entries, C0268R.styleable.ListPreference_android_entries);
        this.f2436b = TypedArrayUtils.getTextArray(obtainStyledAttributes, C0268R.styleable.ListPreference_entryValues, C0268R.styleable.ListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0268R.styleable.Preference, i, i2);
        this.f2438d = TypedArrayUtils.getString(obtainStyledAttributes2, C0268R.styleable.Preference_summary, C0268R.styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    /* renamed from: j */
    private int m1555j() {
        return findIndexOfValue(this.f2437c);
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
        setValue(savedState.f2440a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4750a(boolean z, Object obj) {
        setValue(z ? mo4789c(this.f2437c) : (String) obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Parcelable mo4751b() {
        Parcelable b = super.mo4751b();
        if (isPersistent()) {
            return b;
        }
        SavedState savedState = new SavedState(b);
        savedState.f2440a = getValue();
        return savedState;
    }

    public int findIndexOfValue(String str) {
        if (!(str == null || this.f2436b == null)) {
            for (int length = this.f2436b.length - 1; length >= 0; length--) {
                if (this.f2436b[length].equals(str)) {
                    return length;
                }
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.f2435a;
    }

    public CharSequence getEntry() {
        int j = m1555j();
        if (j < 0 || this.f2435a == null) {
            return null;
        }
        return this.f2435a[j];
    }

    public CharSequence[] getEntryValues() {
        return this.f2436b;
    }

    public CharSequence getSummary() {
        Object entry = getEntry();
        if (this.f2438d == null) {
            return super.getSummary();
        }
        String str = this.f2438d;
        Object[] objArr = new Object[1];
        if (entry == null) {
            entry = "";
        }
        objArr[0] = entry;
        return String.format(str, objArr);
    }

    public String getValue() {
        return this.f2437c;
    }

    public void setEntries(int i) {
        setEntries(getContext().getResources().getTextArray(i));
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.f2435a = charSequenceArr;
    }

    public void setEntryValues(int i) {
        setEntryValues(getContext().getResources().getTextArray(i));
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.f2436b = charSequenceArr;
    }

    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.f2438d != null) {
            this.f2438d = null;
        } else if (charSequence != null && !charSequence.equals(this.f2438d)) {
            this.f2438d = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean z = !TextUtils.equals(this.f2437c, str);
        if (z || !this.f2439e) {
            this.f2437c = str;
            this.f2439e = true;
            mo4786b(str);
            if (z) {
                mo4795f();
            }
        }
    }

    public void setValueIndex(int i) {
        if (this.f2436b != null) {
            setValue(this.f2436b[i].toString());
        }
    }
}
