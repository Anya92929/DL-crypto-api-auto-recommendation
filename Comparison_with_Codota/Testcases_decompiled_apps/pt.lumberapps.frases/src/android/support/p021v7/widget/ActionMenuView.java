package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p021v7.view.menu.ActionMenuItemView;
import android.support.p021v7.view.menu.C0538ae;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0540ag;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.support.p021v7.view.menu.C0564q;
import android.support.p021v7.view.menu.C0566s;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.widget.ActionMenuView */
public class ActionMenuView extends C0634ce implements C0540ag, C0564q {

    /* renamed from: a */
    private C0562o f1216a;

    /* renamed from: b */
    private Context f1217b;

    /* renamed from: c */
    private int f1218c;

    /* renamed from: d */
    private boolean f1219d;

    /* renamed from: e */
    private C0689k f1220e;

    /* renamed from: f */
    private C0539af f1221f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0563p f1222g;

    /* renamed from: h */
    private boolean f1223h;

    /* renamed from: i */
    private int f1224i;

    /* renamed from: j */
    private int f1225j;

    /* renamed from: k */
    private int f1226k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C0703y f1227l;

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1225j = (int) (56.0f * f);
        this.f1226k = (int) (f * 4.0f);
        this.f1217b = context;
        this.f1218c = 0;
    }

    /* renamed from: a */
    static int m2577a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0701w wVar = (C0701w) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.mo2240b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (!wVar.f1720a && z2) {
            z = true;
        }
        wVar.f1723d = z;
        wVar.f1721b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01de  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2580c(int r35, int r36) {
        /*
            r34 = this;
            int r23 = android.view.View.MeasureSpec.getMode(r36)
            int r6 = android.view.View.MeasureSpec.getSize(r35)
            int r17 = android.view.View.MeasureSpec.getSize(r36)
            int r7 = r34.getPaddingLeft()
            int r8 = r34.getPaddingRight()
            int r7 = r7 + r8
            int r8 = r34.getPaddingTop()
            int r9 = r34.getPaddingBottom()
            int r19 = r8 + r9
            r8 = -2
            r0 = r36
            r1 = r19
            int r24 = getChildMeasureSpec(r0, r1, r8)
            int r25 = r6 - r7
            r0 = r34
            int r6 = r0.f1225j
            int r9 = r25 / r6
            r0 = r34
            int r6 = r0.f1225j
            int r6 = r25 % r6
            if (r9 != 0) goto L_0x0041
            r6 = 0
            r0 = r34
            r1 = r25
            r0.setMeasuredDimension(r1, r6)
        L_0x0040:
            return
        L_0x0041:
            r0 = r34
            int r7 = r0.f1225j
            int r6 = r6 / r9
            int r26 = r7 + r6
            r16 = 0
            r15 = 0
            r10 = 0
            r7 = 0
            r11 = 0
            r12 = 0
            int r27 = r34.getChildCount()
            r6 = 0
            r18 = r6
        L_0x0057:
            r0 = r18
            r1 = r27
            if (r0 >= r1) goto L_0x0103
            r0 = r34
            r1 = r18
            android.view.View r8 = r0.getChildAt(r1)
            int r6 = r8.getVisibility()
            r14 = 8
            if (r6 != r14) goto L_0x007e
            r8 = r7
            r6 = r12
            r12 = r16
            r13 = r9
            r9 = r15
        L_0x0073:
            int r14 = r18 + 1
            r18 = r14
            r15 = r9
            r16 = r12
            r9 = r13
            r12 = r6
            r7 = r8
            goto L_0x0057
        L_0x007e:
            boolean r0 = r8 instanceof android.support.p021v7.view.menu.ActionMenuItemView
            r20 = r0
            int r14 = r7 + 1
            if (r20 == 0) goto L_0x009a
            r0 = r34
            int r6 = r0.f1226k
            r7 = 0
            r0 = r34
            int r0 = r0.f1226k
            r21 = r0
            r22 = 0
            r0 = r21
            r1 = r22
            r8.setPadding(r6, r7, r0, r1)
        L_0x009a:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            r7 = 0
            r6.f1725f = r7
            r7 = 0
            r6.f1722c = r7
            r7 = 0
            r6.f1721b = r7
            r7 = 0
            r6.f1723d = r7
            r7 = 0
            r6.leftMargin = r7
            r7 = 0
            r6.rightMargin = r7
            if (r20 == 0) goto L_0x00ff
            r7 = r8
            android.support.v7.view.menu.ActionMenuItemView r7 = (android.support.p021v7.view.menu.ActionMenuItemView) r7
            boolean r7 = r7.mo2240b()
            if (r7 == 0) goto L_0x00ff
            r7 = 1
        L_0x00be:
            r6.f1724e = r7
            boolean r7 = r6.f1720a
            if (r7 == 0) goto L_0x0101
            r7 = 1
        L_0x00c5:
            r0 = r26
            r1 = r24
            r2 = r19
            int r20 = m2577a(r8, r0, r7, r1, r2)
            r0 = r20
            int r15 = java.lang.Math.max(r15, r0)
            boolean r7 = r6.f1723d
            if (r7 == 0) goto L_0x0321
            int r7 = r10 + 1
        L_0x00db:
            boolean r6 = r6.f1720a
            if (r6 == 0) goto L_0x031e
            r6 = 1
        L_0x00e0:
            int r11 = r9 - r20
            int r8 = r8.getMeasuredHeight()
            r0 = r16
            int r10 = java.lang.Math.max(r0, r8)
            r8 = 1
            r0 = r20
            if (r0 != r8) goto L_0x0312
            r8 = 1
            int r8 = r8 << r18
            long r8 = (long) r8
            long r8 = r8 | r12
            r12 = r10
            r13 = r11
            r10 = r7
            r11 = r6
            r6 = r8
            r9 = r15
            r8 = r14
            goto L_0x0073
        L_0x00ff:
            r7 = 0
            goto L_0x00be
        L_0x0101:
            r7 = r9
            goto L_0x00c5
        L_0x0103:
            if (r11 == 0) goto L_0x0140
            r6 = 2
            if (r7 != r6) goto L_0x0140
            r6 = 1
            r8 = r6
        L_0x010a:
            r18 = 0
            r20 = r12
            r19 = r9
        L_0x0110:
            if (r10 <= 0) goto L_0x030e
            if (r19 <= 0) goto L_0x030e
            r14 = 2147483647(0x7fffffff, float:NaN)
            r12 = 0
            r9 = 0
            r6 = 0
            r22 = r6
        L_0x011d:
            r0 = r22
            r1 = r27
            if (r0 >= r1) goto L_0x0163
            r0 = r34
            r1 = r22
            android.view.View r6 = r0.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            boolean r0 = r6.f1723d
            r28 = r0
            if (r28 != 0) goto L_0x0143
            r6 = r9
            r9 = r14
        L_0x0139:
            int r14 = r22 + 1
            r22 = r14
            r14 = r9
            r9 = r6
            goto L_0x011d
        L_0x0140:
            r6 = 0
            r8 = r6
            goto L_0x010a
        L_0x0143:
            int r0 = r6.f1721b
            r28 = r0
            r0 = r28
            if (r0 >= r14) goto L_0x0153
            int r9 = r6.f1721b
            r6 = 1
            int r6 = r6 << r22
            long r12 = (long) r6
            r6 = 1
            goto L_0x0139
        L_0x0153:
            int r6 = r6.f1721b
            if (r6 != r14) goto L_0x030a
            r6 = 1
            int r6 = r6 << r22
            long r0 = (long) r6
            r28 = r0
            long r12 = r12 | r28
            int r6 = r9 + 1
            r9 = r14
            goto L_0x0139
        L_0x0163:
            long r20 = r20 | r12
            r0 = r19
            if (r9 <= r0) goto L_0x01ee
            r12 = r20
        L_0x016b:
            if (r11 != 0) goto L_0x0273
            r6 = 1
            if (r7 != r6) goto L_0x0273
            r6 = 1
        L_0x0171:
            if (r19 <= 0) goto L_0x02bf
            r8 = 0
            int r8 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x02bf
            int r7 = r7 + -1
            r0 = r19
            if (r0 < r7) goto L_0x0184
            if (r6 != 0) goto L_0x0184
            r7 = 1
            if (r15 <= r7) goto L_0x02bf
        L_0x0184:
            int r7 = java.lang.Long.bitCount(r12)
            float r7 = (float) r7
            if (r6 != 0) goto L_0x0304
            r8 = 1
            long r8 = r8 & r12
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x01a8
            r6 = 0
            r0 = r34
            android.view.View r6 = r0.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            boolean r6 = r6.f1724e
            if (r6 != 0) goto L_0x01a8
            r6 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 - r6
        L_0x01a8:
            r6 = 1
            int r8 = r27 + -1
            int r6 = r6 << r8
            long r8 = (long) r6
            long r8 = r8 & r12
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0304
            int r6 = r27 + -1
            r0 = r34
            android.view.View r6 = r0.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            boolean r6 = r6.f1724e
            if (r6 != 0) goto L_0x0304
            r6 = 1056964608(0x3f000000, float:0.5)
            float r6 = r7 - r6
        L_0x01ca:
            r7 = 0
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0276
            int r7 = r19 * r26
            float r7 = (float) r7
            float r6 = r7 / r6
            int r6 = (int) r6
            r7 = r6
        L_0x01d6:
            r6 = 0
            r9 = r6
            r8 = r18
        L_0x01da:
            r0 = r27
            if (r9 >= r0) goto L_0x02c1
            r6 = 1
            int r6 = r6 << r9
            long r10 = (long) r6
            long r10 = r10 & r12
            r14 = 0
            int r6 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x027a
            r6 = r8
        L_0x01e9:
            int r8 = r9 + 1
            r9 = r8
            r8 = r6
            goto L_0x01da
        L_0x01ee:
            int r22 = r14 + 1
            r6 = 0
            r14 = r6
            r9 = r19
            r18 = r20
        L_0x01f6:
            r0 = r27
            if (r14 >= r0) goto L_0x026a
            r0 = r34
            android.view.View r20 = r0.getChildAt(r14)
            android.view.ViewGroup$LayoutParams r6 = r20.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            r21 = 1
            int r21 = r21 << r14
            r0 = r21
            long r0 = (long) r0
            r28 = r0
            long r28 = r28 & r12
            r30 = 0
            int r21 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            if (r21 != 0) goto L_0x022a
            int r6 = r6.f1721b
            r0 = r22
            if (r6 != r0) goto L_0x0307
            r6 = 1
            int r6 = r6 << r14
            long r0 = (long) r6
            r20 = r0
            long r18 = r18 | r20
            r6 = r9
        L_0x0225:
            int r9 = r14 + 1
            r14 = r9
            r9 = r6
            goto L_0x01f6
        L_0x022a:
            if (r8 == 0) goto L_0x0257
            boolean r0 = r6.f1724e
            r21 = r0
            if (r21 == 0) goto L_0x0257
            r21 = 1
            r0 = r21
            if (r9 != r0) goto L_0x0257
            r0 = r34
            int r0 = r0.f1226k
            r21 = r0
            int r21 = r21 + r26
            r28 = 0
            r0 = r34
            int r0 = r0.f1226k
            r29 = r0
            r30 = 0
            r0 = r20
            r1 = r21
            r2 = r28
            r3 = r29
            r4 = r30
            r0.setPadding(r1, r2, r3, r4)
        L_0x0257:
            int r0 = r6.f1721b
            r20 = r0
            int r20 = r20 + 1
            r0 = r20
            r6.f1721b = r0
            r20 = 1
            r0 = r20
            r6.f1725f = r0
            int r6 = r9 + -1
            goto L_0x0225
        L_0x026a:
            r6 = 1
            r20 = r18
            r18 = r6
            r19 = r9
            goto L_0x0110
        L_0x0273:
            r6 = 0
            goto L_0x0171
        L_0x0276:
            r6 = 0
            r7 = r6
            goto L_0x01d6
        L_0x027a:
            r0 = r34
            android.view.View r10 = r0.getChildAt(r9)
            android.view.ViewGroup$LayoutParams r6 = r10.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            boolean r10 = r10 instanceof android.support.p021v7.view.menu.ActionMenuItemView
            if (r10 == 0) goto L_0x029d
            r6.f1722c = r7
            r8 = 1
            r6.f1725f = r8
            if (r9 != 0) goto L_0x029a
            boolean r8 = r6.f1724e
            if (r8 != 0) goto L_0x029a
            int r8 = -r7
            int r8 = r8 / 2
            r6.leftMargin = r8
        L_0x029a:
            r6 = 1
            goto L_0x01e9
        L_0x029d:
            boolean r10 = r6.f1720a
            if (r10 == 0) goto L_0x02ae
            r6.f1722c = r7
            r8 = 1
            r6.f1725f = r8
            int r8 = -r7
            int r8 = r8 / 2
            r6.rightMargin = r8
            r6 = 1
            goto L_0x01e9
        L_0x02ae:
            if (r9 == 0) goto L_0x02b4
            int r10 = r7 / 2
            r6.leftMargin = r10
        L_0x02b4:
            int r10 = r27 + -1
            if (r9 == r10) goto L_0x02bc
            int r10 = r7 / 2
            r6.rightMargin = r10
        L_0x02bc:
            r6 = r8
            goto L_0x01e9
        L_0x02bf:
            r8 = r18
        L_0x02c1:
            if (r8 == 0) goto L_0x02f0
            r6 = 0
            r7 = r6
        L_0x02c5:
            r0 = r27
            if (r7 >= r0) goto L_0x02f0
            r0 = r34
            android.view.View r8 = r0.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            android.support.v7.widget.w r6 = (android.support.p021v7.widget.C0701w) r6
            boolean r9 = r6.f1725f
            if (r9 != 0) goto L_0x02dd
        L_0x02d9:
            int r6 = r7 + 1
            r7 = r6
            goto L_0x02c5
        L_0x02dd:
            int r9 = r6.f1721b
            int r9 = r9 * r26
            int r6 = r6.f1722c
            int r6 = r6 + r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            r0 = r24
            r8.measure(r6, r0)
            goto L_0x02d9
        L_0x02f0:
            r6 = 1073741824(0x40000000, float:2.0)
            r0 = r23
            if (r0 == r6) goto L_0x0301
        L_0x02f6:
            r0 = r34
            r1 = r25
            r2 = r16
            r0.setMeasuredDimension(r1, r2)
            goto L_0x0040
        L_0x0301:
            r16 = r17
            goto L_0x02f6
        L_0x0304:
            r6 = r7
            goto L_0x01ca
        L_0x0307:
            r6 = r9
            goto L_0x0225
        L_0x030a:
            r6 = r9
            r9 = r14
            goto L_0x0139
        L_0x030e:
            r12 = r20
            goto L_0x016b
        L_0x0312:
            r8 = r14
            r9 = r15
            r32 = r12
            r12 = r10
            r13 = r11
            r11 = r6
            r10 = r7
            r6 = r32
            goto L_0x0073
        L_0x031e:
            r6 = r11
            goto L_0x00e0
        L_0x0321:
            r7 = r10
            goto L_0x00db
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.ActionMenuView.m2580c(int, int):void");
    }

    /* renamed from: a */
    public C0701w generateLayoutParams(AttributeSet attributeSet) {
        return new C0701w(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0701w generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return mo2729j();
        }
        C0701w wVar = layoutParams instanceof C0701w ? new C0701w((C0701w) layoutParams) : new C0701w(layoutParams);
        if (wVar.f1521h > 0) {
            return wVar;
        }
        wVar.f1521h = 16;
        return wVar;
    }

    /* renamed from: a */
    public void mo2707a(C0539af afVar, C0563p pVar) {
        this.f1221f = afVar;
        this.f1222g = pVar;
    }

    /* renamed from: a */
    public void mo2257a(C0562o oVar) {
        this.f1216a = oVar;
    }

    /* renamed from: a */
    public boolean mo2708a() {
        return this.f1219d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo2709a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0699u)) {
            z = false | ((C0699u) childAt).mo2242d();
        }
        return (i <= 0 || !(childAt2 instanceof C0699u)) ? z : ((C0699u) childAt2).mo2241c() | z;
    }

    /* renamed from: a */
    public boolean mo2258a(C0566s sVar) {
        return this.f1216a.mo2455a((MenuItem) sVar, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0701w mo2729j() {
        C0701w wVar = new C0701w(-2, -2);
        wVar.f1521h = 16;
        return wVar;
    }

    /* renamed from: c */
    public C0701w mo2713c() {
        C0701w b = mo2729j();
        b.f1720a = true;
        return b;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0701w);
    }

    /* renamed from: d */
    public C0562o mo2715d() {
        return this.f1216a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* renamed from: e */
    public boolean mo2717e() {
        return this.f1220e != null && this.f1220e.mo3358d();
    }

    /* renamed from: f */
    public boolean mo2718f() {
        return this.f1220e != null && this.f1220e.mo3359e();
    }

    /* renamed from: g */
    public boolean mo2719g() {
        return this.f1220e != null && this.f1220e.mo3362h();
    }

    public Menu getMenu() {
        if (this.f1216a == null) {
            Context context = getContext();
            this.f1216a = new C0562o(context);
            this.f1216a.mo2370a((C0563p) new C0702x(this));
            this.f1220e = new C0689k(context);
            this.f1220e.mo3356c(true);
            this.f1220e.mo2333a(this.f1221f != null ? this.f1221f : new C0700v(this));
            this.f1216a.mo2450a((C0538ae) this.f1220e, this.f1217b);
            this.f1220e.mo3354a(this);
        }
        return this.f1216a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1220e.mo3355c();
    }

    public int getPopupTheme() {
        return this.f1218c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: h */
    public boolean mo2727h() {
        return this.f1220e != null && this.f1220e.mo3363i();
    }

    /* renamed from: i */
    public void mo2728i() {
        if (this.f1220e != null) {
            this.f1220e.mo3360f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1220e != null) {
            this.f1220e.mo2336b(false);
            if (this.f1220e.mo3362h()) {
                this.f1220e.mo3359e();
                this.f1220e.mo3358d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo2728i();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int width;
        int i10;
        if (!this.f1223h) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i11 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i12 = 0;
        int i13 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        boolean z3 = false;
        boolean a = C0682dz.m3095a(this);
        int i14 = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() == 8) {
                z2 = z3;
                i8 = i13;
                i7 = paddingRight;
                i9 = i12;
            } else {
                C0701w wVar = (C0701w) childAt.getLayoutParams();
                if (wVar.f1720a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (mo2709a(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a) {
                        i10 = wVar.leftMargin + getPaddingLeft();
                        width = i10 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - wVar.rightMargin;
                        i10 = width - measuredWidth;
                    }
                    int i15 = i11 - (measuredHeight / 2);
                    childAt.layout(i10, i15, width, measuredHeight + i15);
                    i7 = paddingRight - measuredWidth;
                    z2 = true;
                    i8 = i13;
                    i9 = i12;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth() + wVar.leftMargin + wVar.rightMargin;
                    int i16 = i12 + measuredWidth2;
                    int i17 = paddingRight - measuredWidth2;
                    if (mo2709a(i14)) {
                        i16 += dividerWidth;
                    }
                    boolean z4 = z3;
                    i7 = i17;
                    i8 = i13 + 1;
                    i9 = i16;
                    z2 = z4;
                }
            }
            i14++;
            i12 = i9;
            paddingRight = i7;
            i13 = i8;
            z3 = z2;
        }
        if (childCount != 1 || z3) {
            int i18 = i13 - (z3 ? 0 : 1);
            int max = Math.max(0, i18 > 0 ? paddingRight / i18 : 0);
            if (a) {
                int width2 = getWidth() - getPaddingRight();
                int i19 = 0;
                while (i19 < childCount) {
                    View childAt2 = getChildAt(i19);
                    C0701w wVar2 = (C0701w) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() == 8) {
                        i6 = width2;
                    } else if (wVar2.f1720a) {
                        i6 = width2;
                    } else {
                        int i20 = width2 - wVar2.rightMargin;
                        int measuredWidth3 = childAt2.getMeasuredWidth();
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        int i21 = i11 - (measuredHeight2 / 2);
                        childAt2.layout(i20 - measuredWidth3, i21, i20, measuredHeight2 + i21);
                        i6 = i20 - ((wVar2.leftMargin + measuredWidth3) + max);
                    }
                    i19++;
                    width2 = i6;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            int i22 = 0;
            while (i22 < childCount) {
                View childAt3 = getChildAt(i22);
                C0701w wVar3 = (C0701w) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    i5 = paddingLeft;
                } else if (wVar3.f1720a) {
                    i5 = paddingLeft;
                } else {
                    int i23 = paddingLeft + wVar3.leftMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i11 - (measuredHeight3 / 2);
                    childAt3.layout(i23, i24, i23 + measuredWidth4, measuredHeight3 + i24);
                    i5 = wVar3.rightMargin + measuredWidth4 + max + i23;
                }
                i22++;
                paddingLeft = i5;
            }
            return;
        }
        View childAt4 = getChildAt(0);
        int measuredWidth5 = childAt4.getMeasuredWidth();
        int measuredHeight4 = childAt4.getMeasuredHeight();
        int i25 = ((i3 - i) / 2) - (measuredWidth5 / 2);
        int i26 = i11 - (measuredHeight4 / 2);
        childAt4.layout(i25, i26, measuredWidth5 + i25, measuredHeight4 + i26);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z = this.f1223h;
        this.f1223h = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1223h) {
            this.f1224i = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.f1223h || this.f1216a == null || size == this.f1224i)) {
            this.f1224i = size;
            this.f1216a.mo2470b(true);
        }
        int childCount = getChildCount();
        if (!this.f1223h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0701w wVar = (C0701w) getChildAt(i3).getLayoutParams();
                wVar.rightMargin = 0;
                wVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m2580c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1220e.mo3357d(z);
    }

    public void setOnMenuItemClickListener(C0703y yVar) {
        this.f1227l = yVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1220e.mo3353a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1219d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1218c != i) {
            this.f1218c = i;
            if (i == 0) {
                this.f1217b = getContext();
            } else {
                this.f1217b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0689k kVar) {
        this.f1220e = kVar;
        this.f1220e.mo3354a(this);
    }
}
