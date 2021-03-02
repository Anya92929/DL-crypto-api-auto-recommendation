package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.view.C0241bs;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* renamed from: android.support.v7.widget.bh */
public class C0610bh extends Spinner implements C0241bs {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final boolean f1447a = (Build.VERSION.SDK_INT >= 23);

    /* renamed from: b */
    private static final boolean f1448b = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: c */
    private static final int[] f1449c = {16843505};

    /* renamed from: d */
    private C0591ap f1450d;

    /* renamed from: e */
    private C0585aj f1451e;

    /* renamed from: f */
    private Context f1452f;

    /* renamed from: g */
    private C0628bz f1453g;

    /* renamed from: h */
    private SpinnerAdapter f1454h;

    /* renamed from: i */
    private boolean f1455i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0613bk f1456j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f1457k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Rect f1458l;

    public C0610bh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.spinnerStyle);
    }

    public C0610bh(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0610bh(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0610bh(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12, android.content.res.Resources.Theme r13) {
        /*
            r8 = this;
            r1 = 0
            r3 = 1
            r7 = 0
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f1458l = r0
            int[] r0 = android.support.p021v7.p023b.C0515k.Spinner
            android.support.v7.widget.dn r4 = android.support.p021v7.widget.C0670dn.m3014a(r9, r10, r0, r11, r7)
            android.support.v7.widget.ap r0 = android.support.p021v7.widget.C0591ap.m2736a()
            r8.f1450d = r0
            android.support.v7.widget.aj r0 = new android.support.v7.widget.aj
            android.support.v7.widget.ap r2 = r8.f1450d
            r0.<init>(r8, r2)
            r8.f1451e = r0
            if (r13 == 0) goto L_0x00b6
            android.support.v7.view.e r0 = new android.support.v7.view.e
            r0.<init>((android.content.Context) r9, (android.content.res.Resources.Theme) r13)
            r8.f1452f = r0
        L_0x002b:
            android.content.Context r0 = r8.f1452f
            if (r0 == 0) goto L_0x0089
            r0 = -1
            if (r12 != r0) goto L_0x0051
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r0 < r2) goto L_0x00ea
            int[] r0 = f1449c     // Catch:{ Exception -> 0x00d2, all -> 0x00e2 }
            r2 = 0
            android.content.res.TypedArray r2 = r9.obtainStyledAttributes(r10, r0, r11, r2)     // Catch:{ Exception -> 0x00d2, all -> 0x00e2 }
            r0 = 0
            boolean r0 = r2.hasValue(r0)     // Catch:{ Exception -> 0x00ef }
            if (r0 == 0) goto L_0x004c
            r0 = 0
            r5 = 0
            int r12 = r2.getInt(r0, r5)     // Catch:{ Exception -> 0x00ef }
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.recycle()
        L_0x0051:
            if (r12 != r3) goto L_0x0089
            android.support.v7.widget.bk r0 = new android.support.v7.widget.bk
            android.content.Context r2 = r8.f1452f
            r0.<init>(r8, r2, r10, r11)
            android.content.Context r2 = r8.f1452f
            int[] r5 = android.support.p021v7.p023b.C0515k.Spinner
            android.support.v7.widget.dn r2 = android.support.p021v7.widget.C0670dn.m3014a(r2, r10, r5, r11, r7)
            int r5 = android.support.p021v7.p023b.C0515k.Spinner_android_dropDownWidth
            r6 = -2
            int r5 = r2.mo3329f(r5, r6)
            r8.f1457k = r5
            int r5 = android.support.p021v7.p023b.C0515k.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r2.mo3318a(r5)
            r0.mo3171a((android.graphics.drawable.Drawable) r5)
            int r5 = android.support.p021v7.p023b.C0515k.Spinner_android_prompt
            java.lang.String r5 = r4.mo3326d(r5)
            r0.mo3066a((java.lang.CharSequence) r5)
            r2.mo3319a()
            r8.f1456j = r0
            android.support.v7.widget.bi r2 = new android.support.v7.widget.bi
            r2.<init>(r8, r8, r0)
            r8.f1453g = r2
        L_0x0089:
            int r0 = android.support.p021v7.p023b.C0515k.Spinner_android_entries
            java.lang.CharSequence[] r0 = r4.mo3330f(r0)
            if (r0 == 0) goto L_0x00a0
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            int r5 = android.support.p021v7.p023b.C0512h.support_simple_spinner_dropdown_item
            r2.<init>(r9, r5, r0)
            int r0 = android.support.p021v7.p023b.C0512h.support_simple_spinner_dropdown_item
            r2.setDropDownViewResource(r0)
            r8.setAdapter((android.widget.SpinnerAdapter) r2)
        L_0x00a0:
            r4.mo3319a()
            r8.f1455i = r3
            android.widget.SpinnerAdapter r0 = r8.f1454h
            if (r0 == 0) goto L_0x00b0
            android.widget.SpinnerAdapter r0 = r8.f1454h
            r8.setAdapter((android.widget.SpinnerAdapter) r0)
            r8.f1454h = r1
        L_0x00b0:
            android.support.v7.widget.aj r0 = r8.f1451e
            r0.mo2954a(r10, r11)
            return
        L_0x00b6:
            int r0 = android.support.p021v7.p023b.C0515k.Spinner_popupTheme
            int r0 = r4.mo3331g(r0, r7)
            if (r0 == 0) goto L_0x00c7
            android.support.v7.view.e r2 = new android.support.v7.view.e
            r2.<init>((android.content.Context) r9, (int) r0)
            r8.f1452f = r2
            goto L_0x002b
        L_0x00c7:
            boolean r0 = f1447a
            if (r0 != 0) goto L_0x00d0
            r0 = r9
        L_0x00cc:
            r8.f1452f = r0
            goto L_0x002b
        L_0x00d0:
            r0 = r1
            goto L_0x00cc
        L_0x00d2:
            r0 = move-exception
            r2 = r1
        L_0x00d4:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r0)     // Catch:{ all -> 0x00ed }
            if (r2 == 0) goto L_0x0051
            r2.recycle()
            goto L_0x0051
        L_0x00e2:
            r0 = move-exception
            r2 = r1
        L_0x00e4:
            if (r2 == 0) goto L_0x00e9
            r2.recycle()
        L_0x00e9:
            throw r0
        L_0x00ea:
            r12 = r3
            goto L_0x0051
        L_0x00ed:
            r0 = move-exception
            goto L_0x00e4
        L_0x00ef:
            r0 = move-exception
            goto L_0x00d4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0610bh.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m2781a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view2 = null;
        int i = 0;
        int i2 = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
                view = view2;
            }
            view2 = spinnerAdapter.getView(max2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view2.getMeasuredWidth());
            max2++;
            i2 = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f1458l);
        return this.f1458l.left + this.f1458l.right + i;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1451e != null) {
            this.f1451e.mo2957c();
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f1456j != null) {
            return this.f1456j.mo3186j();
        }
        if (f1448b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        if (this.f1456j != null) {
            return this.f1456j.mo3187k();
        }
        if (f1448b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f1456j != null) {
            return this.f1457k;
        }
        if (f1448b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        if (this.f1456j != null) {
            return this.f1456j.mo3182h();
        }
        if (f1448b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        if (this.f1456j != null) {
            return this.f1452f;
        }
        if (f1447a) {
            return super.getPopupContext();
        }
        return null;
    }

    public CharSequence getPrompt() {
        return this.f1456j != null ? this.f1456j.mo3067b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1451e != null) {
            return this.f1451e.mo2949a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1451e != null) {
            return this.f1451e.mo2955b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1456j != null && this.f1456j.mo2364d()) {
            this.f1456j.mo2363c();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1456j != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m2781a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1453g == null || !this.f1453g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        if (this.f1456j == null) {
            return super.performClick();
        }
        if (!this.f1456j.mo2364d()) {
            this.f1456j.mo2362a();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1455i) {
            this.f1454h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1456j != null) {
            this.f1456j.mo3065a((ListAdapter) new C0612bj(spinnerAdapter, (this.f1452f == null ? getContext() : this.f1452f).getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1451e != null) {
            this.f1451e.mo2953a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1451e != null) {
            this.f1451e.mo2950a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f1456j != null) {
            this.f1456j.mo3176c(i);
        } else if (f1448b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f1456j != null) {
            this.f1456j.mo3177d(i);
        } else if (f1448b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f1456j != null) {
            this.f1457k = i;
        } else if (f1448b) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f1456j != null) {
            this.f1456j.mo3171a(drawable);
        } else if (f1448b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0025a.getDrawable(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f1456j != null) {
            this.f1456j.mo3066a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1451e != null) {
            this.f1451e.mo2951a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1451e != null) {
            this.f1451e.mo2952a(mode);
        }
    }
}
