package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* renamed from: android.support.v7.widget.dn */
public class C0670dn {

    /* renamed from: a */
    private final Context f1650a;

    /* renamed from: b */
    private final TypedArray f1651b;

    private C0670dn(Context context, TypedArray typedArray) {
        this.f1650a = context;
        this.f1651b = typedArray;
    }

    /* renamed from: a */
    public static C0670dn m3012a(Context context, int i, int[] iArr) {
        return new C0670dn(context, context.obtainStyledAttributes(i, iArr));
    }

    /* renamed from: a */
    public static C0670dn m3013a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0670dn(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: a */
    public static C0670dn m3014a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0670dn(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public float mo3316a(int i, float f) {
        return this.f1651b.getFloat(i, f);
    }

    /* renamed from: a */
    public int mo3317a(int i, int i2) {
        return this.f1651b.getInt(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r3.f1651b.getResourceId(r4, 0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable mo3318a(int r4) {
        /*
            r3 = this;
            android.content.res.TypedArray r0 = r3.f1651b
            boolean r0 = r0.hasValue(r4)
            if (r0 == 0) goto L_0x001c
            android.content.res.TypedArray r0 = r3.f1651b
            r1 = 0
            int r0 = r0.getResourceId(r4, r1)
            if (r0 == 0) goto L_0x001c
            android.support.v7.widget.ap r1 = android.support.p021v7.widget.C0591ap.m2736a()
            android.content.Context r2 = r3.f1650a
            android.graphics.drawable.Drawable r0 = r1.mo2982a((android.content.Context) r2, (int) r0)
        L_0x001b:
            return r0
        L_0x001c:
            android.content.res.TypedArray r0 = r3.f1651b
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r4)
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0670dn.mo3318a(int):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    public void mo3319a() {
        this.f1651b.recycle();
    }

    /* renamed from: a */
    public boolean mo3320a(int i, boolean z) {
        return this.f1651b.getBoolean(i, z);
    }

    /* renamed from: b */
    public int mo3321b(int i, int i2) {
        return this.f1651b.getColor(i, i2);
    }

    /* renamed from: b */
    public Drawable mo3322b(int i) {
        int resourceId;
        if (!this.f1651b.hasValue(i) || (resourceId = this.f1651b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0591ap.m2736a().mo2983a(this.f1650a, resourceId, true);
    }

    /* renamed from: c */
    public int mo3323c(int i, int i2) {
        return this.f1651b.getInteger(i, i2);
    }

    /* renamed from: c */
    public CharSequence mo3324c(int i) {
        return this.f1651b.getText(i);
    }

    /* renamed from: d */
    public int mo3325d(int i, int i2) {
        return this.f1651b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: d */
    public String mo3326d(int i) {
        return this.f1651b.getString(i);
    }

    /* renamed from: e */
    public int mo3327e(int i, int i2) {
        return this.f1651b.getDimensionPixelSize(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = android.support.p021v7.widget.C0620br.m2806a(r2.f1650a, (r0 = r2.f1651b.getResourceId(r3, 0)));
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList mo3328e(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1651b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f1651b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f1650a
            android.content.res.ColorStateList r0 = android.support.p021v7.widget.C0620br.m2806a(r1, r0)
            if (r0 == 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f1651b
            android.content.res.ColorStateList r0 = r0.getColorStateList(r3)
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0670dn.mo3328e(int):android.content.res.ColorStateList");
    }

    /* renamed from: f */
    public int mo3329f(int i, int i2) {
        return this.f1651b.getLayoutDimension(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] mo3330f(int i) {
        return this.f1651b.getTextArray(i);
    }

    /* renamed from: g */
    public int mo3331g(int i, int i2) {
        return this.f1651b.getResourceId(i, i2);
    }

    /* renamed from: g */
    public boolean mo3332g(int i) {
        return this.f1651b.hasValue(i);
    }
}
