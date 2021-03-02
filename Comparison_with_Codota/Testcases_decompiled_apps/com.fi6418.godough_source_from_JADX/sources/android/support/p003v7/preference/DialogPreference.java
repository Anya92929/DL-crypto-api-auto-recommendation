package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;

/* renamed from: android.support.v7.preference.DialogPreference */
public abstract class DialogPreference extends Preference {

    /* renamed from: a */
    private CharSequence f2426a;

    /* renamed from: b */
    private CharSequence f2427b;

    /* renamed from: c */
    private Drawable f2428c;

    /* renamed from: d */
    private CharSequence f2429d;

    /* renamed from: e */
    private CharSequence f2430e;

    /* renamed from: f */
    private int f2431f;

    /* renamed from: android.support.v7.preference.DialogPreference$TargetFragment */
    public interface TargetFragment {
        Preference findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0268R.attr.dialogPreferenceStyle);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0268R.styleable.DialogPreference, i, i2);
        this.f2426a = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.DialogPreference_dialogTitle, C0268R.styleable.DialogPreference_android_dialogTitle);
        if (this.f2426a == null) {
            this.f2426a = getTitle();
        }
        this.f2427b = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.DialogPreference_dialogMessage, C0268R.styleable.DialogPreference_android_dialogMessage);
        this.f2428c = TypedArrayUtils.getDrawable(obtainStyledAttributes, C0268R.styleable.DialogPreference_dialogIcon, C0268R.styleable.DialogPreference_android_dialogIcon);
        this.f2429d = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.DialogPreference_positiveButtonText, C0268R.styleable.DialogPreference_android_positiveButtonText);
        this.f2430e = TypedArrayUtils.getString(obtainStyledAttributes, C0268R.styleable.DialogPreference_negativeButtonText, C0268R.styleable.DialogPreference_android_negativeButtonText);
        this.f2431f = TypedArrayUtils.getResourceId(obtainStyledAttributes, C0268R.styleable.DialogPreference_dialogLayout, C0268R.styleable.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4729a() {
        getPreferenceManager().showDialog(this);
    }

    public Drawable getDialogIcon() {
        return this.f2428c;
    }

    public int getDialogLayoutResource() {
        return this.f2431f;
    }

    public CharSequence getDialogMessage() {
        return this.f2427b;
    }

    public CharSequence getDialogTitle() {
        return this.f2426a;
    }

    public CharSequence getNegativeButtonText() {
        return this.f2430e;
    }

    public CharSequence getPositiveButtonText() {
        return this.f2429d;
    }

    public void setDialogIcon(int i) {
        this.f2428c = ContextCompat.getDrawable(getContext(), i);
    }

    public void setDialogIcon(Drawable drawable) {
        this.f2428c = drawable;
    }

    public void setDialogLayoutResource(int i) {
        this.f2431f = i;
    }

    public void setDialogMessage(int i) {
        setDialogMessage((CharSequence) getContext().getString(i));
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.f2427b = charSequence;
    }

    public void setDialogTitle(int i) {
        setDialogTitle((CharSequence) getContext().getString(i));
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.f2426a = charSequence;
    }

    public void setNegativeButtonText(int i) {
        setNegativeButtonText((CharSequence) getContext().getString(i));
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.f2430e = charSequence;
    }

    public void setPositiveButtonText(int i) {
        setPositiveButtonText((CharSequence) getContext().getString(i));
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.f2429d = charSequence;
    }
}
