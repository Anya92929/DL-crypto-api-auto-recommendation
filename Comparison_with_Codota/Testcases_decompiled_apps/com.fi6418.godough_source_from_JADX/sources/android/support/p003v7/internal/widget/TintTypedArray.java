package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: android.support.v7.internal.widget.TintTypedArray */
public class TintTypedArray {

    /* renamed from: a */
    private final Context f2393a;

    /* renamed from: b */
    private final TypedArray f2394b;

    /* renamed from: c */
    private TintManager f2395c;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f2393a = context;
        this.f2394b = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f2394b.getBoolean(i, z);
    }

    public int getChangingConfigurations() {
        return this.f2394b.getChangingConfigurations();
    }

    public int getColor(int i, int i2) {
        return this.f2394b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f2394b.getColorStateList(i);
    }

    public float getDimension(int i, float f) {
        return this.f2394b.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f2394b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f2394b.getDimensionPixelSize(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f2394b.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable getDrawable(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f2394b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f2394b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.support.v7.internal.widget.TintManager r1 = r2.getTintManager()
            android.graphics.drawable.Drawable r0 = r1.getDrawable(r0)
        L_0x0019:
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f2394b
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r3)
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.TintTypedArray.getDrawable(int):android.graphics.drawable.Drawable");
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.f2394b.hasValue(i) || (resourceId = this.f2394b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return getTintManager().getDrawable(resourceId, true);
    }

    public float getFloat(int i, float f) {
        return this.f2394b.getFloat(i, f);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.f2394b.getFraction(i, i2, i3, f);
    }

    public int getIndex(int i) {
        return this.f2394b.getIndex(i);
    }

    public int getIndexCount() {
        return this.f2394b.getIndexCount();
    }

    public int getInt(int i, int i2) {
        return this.f2394b.getInt(i, i2);
    }

    public int getInteger(int i, int i2) {
        return this.f2394b.getInteger(i, i2);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f2394b.getLayoutDimension(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f2394b.getLayoutDimension(i, str);
    }

    public String getNonResourceString(int i) {
        return this.f2394b.getNonResourceString(i);
    }

    public String getPositionDescription() {
        return this.f2394b.getPositionDescription();
    }

    public int getResourceId(int i, int i2) {
        return this.f2394b.getResourceId(i, i2);
    }

    public Resources getResources() {
        return this.f2394b.getResources();
    }

    public String getString(int i) {
        return this.f2394b.getString(i);
    }

    public CharSequence getText(int i) {
        return this.f2394b.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f2394b.getTextArray(i);
    }

    public TintManager getTintManager() {
        if (this.f2395c == null) {
            this.f2395c = TintManager.get(this.f2393a);
        }
        return this.f2395c;
    }

    public int getType(int i) {
        return this.f2394b.getType(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f2394b.getValue(i, typedValue);
    }

    public boolean hasValue(int i) {
        return this.f2394b.hasValue(i);
    }

    public int length() {
        return this.f2394b.length();
    }

    public TypedValue peekValue(int i) {
        return this.f2394b.peekValue(i);
    }

    public void recycle() {
        this.f2394b.recycle();
    }
}
