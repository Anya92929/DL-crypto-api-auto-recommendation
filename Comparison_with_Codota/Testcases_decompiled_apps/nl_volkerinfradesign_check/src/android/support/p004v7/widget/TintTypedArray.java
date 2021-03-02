package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: android.support.v7.widget.TintTypedArray */
public class TintTypedArray {

    /* renamed from: a */
    private final Context f2316a;

    /* renamed from: b */
    private final TypedArray f2317b;

    /* renamed from: c */
    private TintManager f2318c;

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f2316a = context;
        this.f2317b = typedArray;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        if (!this.f2317b.hasValue(i) || (resourceId = this.f2317b.getResourceId(i, 0)) == 0) {
            return this.f2317b.getDrawable(i);
        }
        return getTintManager().getDrawable(resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.f2317b.hasValue(i) || (resourceId = this.f2317b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return getTintManager().getDrawable(resourceId, true);
    }

    public int length() {
        return this.f2317b.length();
    }

    public int getIndexCount() {
        return this.f2317b.getIndexCount();
    }

    public int getIndex(int i) {
        return this.f2317b.getIndex(i);
    }

    public Resources getResources() {
        return this.f2317b.getResources();
    }

    public CharSequence getText(int i) {
        return this.f2317b.getText(i);
    }

    public String getString(int i) {
        return this.f2317b.getString(i);
    }

    public String getNonResourceString(int i) {
        return this.f2317b.getNonResourceString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f2317b.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.f2317b.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.f2317b.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.f2317b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f2317b.getColorStateList(i);
    }

    public int getInteger(int i, int i2) {
        return this.f2317b.getInteger(i, i2);
    }

    public float getDimension(int i, float f) {
        return this.f2317b.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f2317b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f2317b.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f2317b.getLayoutDimension(i, str);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f2317b.getLayoutDimension(i, i2);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.f2317b.getFraction(i, i2, i3, f);
    }

    public int getResourceId(int i, int i2) {
        return this.f2317b.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f2317b.getTextArray(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f2317b.getValue(i, typedValue);
    }

    public int getType(int i) {
        return this.f2317b.getType(i);
    }

    public boolean hasValue(int i) {
        return this.f2317b.hasValue(i);
    }

    public TypedValue peekValue(int i) {
        return this.f2317b.peekValue(i);
    }

    public String getPositionDescription() {
        return this.f2317b.getPositionDescription();
    }

    public void recycle() {
        this.f2317b.recycle();
    }

    public int getChangingConfigurations() {
        return this.f2317b.getChangingConfigurations();
    }

    public TintManager getTintManager() {
        if (this.f2318c == null) {
            this.f2318c = TintManager.get(this.f2316a);
        }
        return this.f2318c;
    }
}
