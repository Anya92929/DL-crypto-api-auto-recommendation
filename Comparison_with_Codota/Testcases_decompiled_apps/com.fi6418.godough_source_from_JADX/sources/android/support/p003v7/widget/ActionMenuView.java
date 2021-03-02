package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p003v7.internal.view.menu.ActionMenuItemView;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuItemImpl;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.widget.ActionMenuView */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {

    /* renamed from: a */
    private MenuBuilder f2624a;

    /* renamed from: b */
    private Context f2625b;

    /* renamed from: c */
    private int f2626c;

    /* renamed from: d */
    private boolean f2627d;

    /* renamed from: e */
    private ActionMenuPresenter f2628e;

    /* renamed from: f */
    private MenuPresenter.Callback f2629f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MenuBuilder.Callback f2630g;

    /* renamed from: h */
    private boolean f2631h;

    /* renamed from: i */
    private int f2632i;

    /* renamed from: j */
    private int f2633j;

    /* renamed from: k */
    private int f2634k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnMenuItemClickListener f2635l;

    /* renamed from: android.support.v7.widget.ActionMenuView$ActionMenuChildView */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$ActionMenuPresenterCallback */
    class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$LayoutParams */
    public class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a */
        boolean f2637a;
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$MenuBuilderCallback */
    class MenuBuilderCallback implements MenuBuilder.Callback {
        private MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.f2635l != null && ActionMenuView.this.f2635l.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.f2630g != null) {
                ActionMenuView.this.f2630g.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$OnMenuItemClickListener */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f2633j = (int) (56.0f * f);
        this.f2634k = (int) (f * 4.0f);
        this.f2625b = context;
        this.f2626c = 0;
    }

    /* renamed from: a */
    static int m1704a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
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
        if (!layoutParams.isOverflowButton && z2) {
            z = true;
        }
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01de  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1707c(int r35, int r36) {
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
            int r6 = r0.f2633j
            int r9 = r25 / r6
            r0 = r34
            int r6 = r0.f2633j
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
            int r7 = r0.f2633j
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
            boolean r0 = r8 instanceof android.support.p003v7.internal.view.menu.ActionMenuItemView
            r20 = r0
            int r14 = r7 + 1
            if (r20 == 0) goto L_0x009a
            r0 = r34
            int r6 = r0.f2634k
            r7 = 0
            r0 = r34
            int r0 = r0.f2634k
            r21 = r0
            r22 = 0
            r0 = r21
            r1 = r22
            r8.setPadding(r6, r7, r0, r1)
        L_0x009a:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            r7 = 0
            r6.f2637a = r7
            r7 = 0
            r6.extraPixels = r7
            r7 = 0
            r6.cellsUsed = r7
            r7 = 0
            r6.expandable = r7
            r7 = 0
            r6.leftMargin = r7
            r7 = 0
            r6.rightMargin = r7
            if (r20 == 0) goto L_0x00ff
            r7 = r8
            android.support.v7.internal.view.menu.ActionMenuItemView r7 = (android.support.p003v7.internal.view.menu.ActionMenuItemView) r7
            boolean r7 = r7.hasText()
            if (r7 == 0) goto L_0x00ff
            r7 = 1
        L_0x00be:
            r6.preventEdgeOffset = r7
            boolean r7 = r6.isOverflowButton
            if (r7 == 0) goto L_0x0101
            r7 = 1
        L_0x00c5:
            r0 = r26
            r1 = r24
            r2 = r19
            int r20 = m1704a(r8, r0, r7, r1, r2)
            r0 = r20
            int r15 = java.lang.Math.max(r15, r0)
            boolean r7 = r6.expandable
            if (r7 == 0) goto L_0x0321
            int r7 = r10 + 1
        L_0x00db:
            boolean r6 = r6.isOverflowButton
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
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r0 = r6.expandable
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
            int r0 = r6.cellsUsed
            r28 = r0
            r0 = r28
            if (r0 >= r14) goto L_0x0153
            int r9 = r6.cellsUsed
            r6 = 1
            int r6 = r6 << r22
            long r12 = (long) r6
            r6 = 1
            goto L_0x0139
        L_0x0153:
            int r6 = r6.cellsUsed
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
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r6 = r6.preventEdgeOffset
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
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r6 = r6.preventEdgeOffset
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
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            r21 = 1
            int r21 = r21 << r14
            r0 = r21
            long r0 = (long) r0
            r28 = r0
            long r28 = r28 & r12
            r30 = 0
            int r21 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            if (r21 != 0) goto L_0x022a
            int r6 = r6.cellsUsed
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
            boolean r0 = r6.preventEdgeOffset
            r21 = r0
            if (r21 == 0) goto L_0x0257
            r21 = 1
            r0 = r21
            if (r9 != r0) goto L_0x0257
            r0 = r34
            int r0 = r0.f2634k
            r21 = r0
            int r21 = r21 + r26
            r28 = 0
            r0 = r34
            int r0 = r0.f2634k
            r29 = r0
            r30 = 0
            r0 = r20
            r1 = r21
            r2 = r28
            r3 = r29
            r4 = r30
            r0.setPadding(r1, r2, r3, r4)
        L_0x0257:
            int r0 = r6.cellsUsed
            r20 = r0
            int r20 = r20 + 1
            r0 = r20
            r6.cellsUsed = r0
            r20 = 1
            r0 = r20
            r6.f2637a = r0
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
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r10 = r10 instanceof android.support.p003v7.internal.view.menu.ActionMenuItemView
            if (r10 == 0) goto L_0x029d
            r6.extraPixels = r7
            r8 = 1
            r6.f2637a = r8
            if (r9 != 0) goto L_0x029a
            boolean r8 = r6.preventEdgeOffset
            if (r8 != 0) goto L_0x029a
            int r8 = -r7
            int r8 = r8 / 2
            r6.leftMargin = r8
        L_0x029a:
            r6 = 1
            goto L_0x01e9
        L_0x029d:
            boolean r10 = r6.isOverflowButton
            if (r10 == 0) goto L_0x02ae
            r6.extraPixels = r7
            r8 = 1
            r6.f2637a = r8
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
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r9 = r6.f2637a
            if (r9 != 0) goto L_0x02dd
        L_0x02d9:
            int r6 = r7 + 1
            r7 = r6
            goto L_0x02c5
        L_0x02dd:
            int r9 = r6.cellsUsed
            int r9 = r9 * r26
            int r6 = r6.extraPixels
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.ActionMenuView.m1707c(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5038a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : ((ActionMenuChildView) childAt2).needsDividerBefore() | z;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public void dismissPopupMenus() {
        if (this.f2628e != null) {
            this.f2628e.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams a = generateDefaultLayoutParams();
        a.isOverflowButton = true;
        return a;
    }

    public Menu getMenu() {
        if (this.f2624a == null) {
            Context context = getContext();
            this.f2624a = new MenuBuilder(context);
            this.f2624a.setCallback(new MenuBuilderCallback());
            this.f2628e = new ActionMenuPresenter(context);
            this.f2628e.setReserveOverflow(true);
            this.f2628e.setCallback(this.f2629f != null ? this.f2629f : new ActionMenuPresenterCallback());
            this.f2624a.addMenuPresenter(this.f2628e, this.f2625b);
            this.f2628e.setMenuView(this);
        }
        return this.f2624a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f2628e.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f2626c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hideOverflowMenu() {
        return this.f2628e != null && this.f2628e.hideOverflowMenu();
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.f2624a = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.f2624a.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        return this.f2628e != null && this.f2628e.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.f2628e != null && this.f2628e.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.f2627d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f2628e != null) {
            this.f2628e.updateMenuView(false);
            if (this.f2628e.isOverflowMenuShowing()) {
                this.f2628e.hideOverflowMenu();
                this.f2628e.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
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
        if (!this.f2631h) {
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
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i14 = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() == 8) {
                z2 = z3;
                i8 = i13;
                i7 = paddingRight;
                i9 = i12;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (mo5038a(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i10 = layoutParams.leftMargin + getPaddingLeft();
                        width = i10 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i10 = width - measuredWidth;
                    }
                    int i15 = i11 - (measuredHeight / 2);
                    childAt.layout(i10, i15, width, measuredHeight + i15);
                    i7 = paddingRight - measuredWidth;
                    z2 = true;
                    i8 = i13;
                    i9 = i12;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    int i16 = i12 + measuredWidth2;
                    int i17 = paddingRight - measuredWidth2;
                    if (mo5038a(i14)) {
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
            if (isLayoutRtl) {
                int width2 = getWidth() - getPaddingRight();
                int i19 = 0;
                while (i19 < childCount) {
                    View childAt2 = getChildAt(i19);
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() == 8) {
                        i6 = width2;
                    } else if (layoutParams2.isOverflowButton) {
                        i6 = width2;
                    } else {
                        int i20 = width2 - layoutParams2.rightMargin;
                        int measuredWidth3 = childAt2.getMeasuredWidth();
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        int i21 = i11 - (measuredHeight2 / 2);
                        childAt2.layout(i20 - measuredWidth3, i21, i20, measuredHeight2 + i21);
                        i6 = i20 - ((layoutParams2.leftMargin + measuredWidth3) + max);
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
                LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    i5 = paddingLeft;
                } else if (layoutParams3.isOverflowButton) {
                    i5 = paddingLeft;
                } else {
                    int i23 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i11 - (measuredHeight3 / 2);
                    childAt3.layout(i23, i24, i23 + measuredWidth4, measuredHeight3 + i24);
                    i5 = layoutParams3.rightMargin + measuredWidth4 + max + i23;
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
        boolean z = this.f2631h;
        this.f2631h = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f2631h) {
            this.f2632i = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.f2631h || this.f2624a == null || size == this.f2632i)) {
            this.f2632i = size;
            this.f2624a.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.f2631h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m1707c(i, i2);
    }

    public MenuBuilder peekMenu() {
        return this.f2624a;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f2628e.setExpandedActionViewsExclusive(z);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f2629f = callback;
        this.f2630g = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2635l = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f2628e.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f2627d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f2626c != i) {
            this.f2626c = i;
            if (i == 0) {
                this.f2625b = getContext();
            } else {
                this.f2625b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f2628e = actionMenuPresenter;
        this.f2628e.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        return this.f2628e != null && this.f2628e.showOverflowMenu();
    }
}
