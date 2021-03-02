package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.Configuration;
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
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.widget.ActionMenuView */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private Context mContext;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    /* access modifiers changed from: private */
    public MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    /* access modifiers changed from: private */
    public OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

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
        public int cellsUsed;
        public boolean expandable;
        boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
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
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
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
        this.mContext = context;
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
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

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onMeasureExactFormat(int r35, int r36) {
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
            int r6 = r0.mMinCellSize
            int r9 = r25 / r6
            r0 = r34
            int r6 = r0.mMinCellSize
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
            int r7 = r0.mMinCellSize
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
            if (r0 >= r1) goto L_0x00fc
            r0 = r34
            r1 = r18
            android.view.View r8 = r0.getChildAt(r1)
            int r6 = r8.getVisibility()
            r14 = 8
            if (r6 == r14) goto L_0x030f
            boolean r0 = r8 instanceof android.support.p003v7.internal.view.menu.ActionMenuItemView
            r20 = r0
            int r14 = r7 + 1
            if (r20 == 0) goto L_0x0089
            r0 = r34
            int r6 = r0.mGeneratedItemPadding
            r7 = 0
            r0 = r34
            int r0 = r0.mGeneratedItemPadding
            r21 = r0
            r22 = 0
            r0 = r21
            r1 = r22
            r8.setPadding(r6, r7, r0, r1)
        L_0x0089:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            r7 = 0
            r6.expanded = r7
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
            if (r20 == 0) goto L_0x00f8
            r7 = r8
            android.support.v7.internal.view.menu.ActionMenuItemView r7 = (android.support.p003v7.internal.view.menu.ActionMenuItemView) r7
            boolean r7 = r7.hasText()
            if (r7 == 0) goto L_0x00f8
            r7 = 1
        L_0x00ad:
            r6.preventEdgeOffset = r7
            boolean r7 = r6.isOverflowButton
            if (r7 == 0) goto L_0x00fa
            r7 = 1
        L_0x00b4:
            r0 = r26
            r1 = r24
            r2 = r19
            int r20 = measureChildForCells(r8, r0, r7, r1, r2)
            r0 = r20
            int r15 = java.lang.Math.max(r15, r0)
            boolean r7 = r6.expandable
            if (r7 == 0) goto L_0x030c
            int r7 = r10 + 1
        L_0x00ca:
            boolean r6 = r6.isOverflowButton
            if (r6 == 0) goto L_0x0309
            r6 = 1
        L_0x00cf:
            int r11 = r9 - r20
            int r8 = r8.getMeasuredHeight()
            r0 = r16
            int r10 = java.lang.Math.max(r0, r8)
            r8 = 1
            r0 = r20
            if (r0 != r8) goto L_0x02fd
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
        L_0x00ec:
            int r14 = r18 + 1
            r18 = r14
            r15 = r9
            r16 = r12
            r9 = r13
            r12 = r6
            r7 = r8
            goto L_0x0057
        L_0x00f8:
            r7 = 0
            goto L_0x00ad
        L_0x00fa:
            r7 = r9
            goto L_0x00b4
        L_0x00fc:
            if (r11 == 0) goto L_0x0146
            r6 = 2
            if (r7 != r6) goto L_0x0146
            r6 = 1
            r8 = r6
        L_0x0103:
            r18 = 0
            r20 = r12
            r19 = r9
        L_0x0109:
            if (r10 <= 0) goto L_0x01e4
            if (r19 <= 0) goto L_0x01e4
            r14 = 2147483647(0x7fffffff, float:NaN)
            r12 = 0
            r9 = 0
            r6 = 0
            r22 = r6
        L_0x0116:
            r0 = r22
            r1 = r27
            if (r0 >= r1) goto L_0x0159
            r0 = r34
            r1 = r22
            android.view.View r6 = r0.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r0 = r6.expandable
            r28 = r0
            if (r28 == 0) goto L_0x02f9
            int r0 = r6.cellsUsed
            r28 = r0
            r0 = r28
            if (r0 >= r14) goto L_0x0149
            int r9 = r6.cellsUsed
            r6 = 1
            int r6 = r6 << r22
            long r12 = (long) r6
            r6 = 1
        L_0x013f:
            int r14 = r22 + 1
            r22 = r14
            r14 = r9
            r9 = r6
            goto L_0x0116
        L_0x0146:
            r6 = 0
            r8 = r6
            goto L_0x0103
        L_0x0149:
            int r6 = r6.cellsUsed
            if (r6 != r14) goto L_0x02f9
            r6 = 1
            int r6 = r6 << r22
            long r0 = (long) r6
            r28 = r0
            long r12 = r12 | r28
            int r6 = r9 + 1
            r9 = r14
            goto L_0x013f
        L_0x0159:
            long r20 = r20 | r12
            r0 = r19
            if (r9 > r0) goto L_0x01e4
            int r22 = r14 + 1
            r6 = 0
            r14 = r6
            r9 = r19
            r18 = r20
        L_0x0167:
            r0 = r27
            if (r14 >= r0) goto L_0x01db
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
            if (r21 != 0) goto L_0x019b
            int r6 = r6.cellsUsed
            r0 = r22
            if (r6 != r0) goto L_0x02f6
            r6 = 1
            int r6 = r6 << r14
            long r0 = (long) r6
            r20 = r0
            long r18 = r18 | r20
            r6 = r9
        L_0x0196:
            int r9 = r14 + 1
            r14 = r9
            r9 = r6
            goto L_0x0167
        L_0x019b:
            if (r8 == 0) goto L_0x01c8
            boolean r0 = r6.preventEdgeOffset
            r21 = r0
            if (r21 == 0) goto L_0x01c8
            r21 = 1
            r0 = r21
            if (r9 != r0) goto L_0x01c8
            r0 = r34
            int r0 = r0.mGeneratedItemPadding
            r21 = r0
            int r21 = r21 + r26
            r28 = 0
            r0 = r34
            int r0 = r0.mGeneratedItemPadding
            r29 = r0
            r30 = 0
            r0 = r20
            r1 = r21
            r2 = r28
            r3 = r29
            r4 = r30
            r0.setPadding(r1, r2, r3, r4)
        L_0x01c8:
            int r0 = r6.cellsUsed
            r20 = r0
            int r20 = r20 + 1
            r0 = r20
            r6.cellsUsed = r0
            r20 = 1
            r0 = r20
            r6.expanded = r0
            int r6 = r9 + -1
            goto L_0x0196
        L_0x01db:
            r6 = 1
            r20 = r18
            r18 = r6
            r19 = r9
            goto L_0x0109
        L_0x01e4:
            r12 = r20
            if (r11 != 0) goto L_0x0289
            r6 = 1
            if (r7 != r6) goto L_0x0289
            r6 = 1
        L_0x01ec:
            if (r19 <= 0) goto L_0x02af
            r8 = 0
            int r8 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x02af
            int r7 = r7 + -1
            r0 = r19
            if (r0 < r7) goto L_0x01ff
            if (r6 != 0) goto L_0x01ff
            r7 = 1
            if (r15 <= r7) goto L_0x02af
        L_0x01ff:
            int r7 = java.lang.Long.bitCount(r12)
            float r7 = (float) r7
            if (r6 != 0) goto L_0x02f3
            r8 = 1
            long r8 = r8 & r12
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0223
            r6 = 0
            r0 = r34
            android.view.View r6 = r0.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r6 = r6.preventEdgeOffset
            if (r6 != 0) goto L_0x0223
            r6 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 - r6
        L_0x0223:
            r6 = 1
            int r8 = r27 + -1
            int r6 = r6 << r8
            long r8 = (long) r6
            long r8 = r8 & r12
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02f3
            int r6 = r27 + -1
            r0 = r34
            android.view.View r6 = r0.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r6 = r6.preventEdgeOffset
            if (r6 != 0) goto L_0x02f3
            r6 = 1056964608(0x3f000000, float:0.5)
            float r6 = r7 - r6
        L_0x0245:
            r7 = 0
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x028c
            int r7 = r19 * r26
            float r7 = (float) r7
            float r6 = r7 / r6
            int r6 = (int) r6
            r7 = r6
        L_0x0251:
            r6 = 0
            r9 = r6
            r8 = r18
        L_0x0255:
            r0 = r27
            if (r9 >= r0) goto L_0x02b1
            r6 = 1
            int r6 = r6 << r9
            long r10 = (long) r6
            long r10 = r10 & r12
            r14 = 0
            int r6 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ad
            r0 = r34
            android.view.View r10 = r0.getChildAt(r9)
            android.view.ViewGroup$LayoutParams r6 = r10.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r10 = r10 instanceof android.support.p003v7.internal.view.menu.ActionMenuItemView
            if (r10 == 0) goto L_0x028f
            r6.extraPixels = r7
            r8 = 1
            r6.expanded = r8
            if (r9 != 0) goto L_0x0283
            boolean r8 = r6.preventEdgeOffset
            if (r8 != 0) goto L_0x0283
            int r8 = -r7
            int r8 = r8 / 2
            r6.leftMargin = r8
        L_0x0283:
            r6 = 1
        L_0x0284:
            int r8 = r9 + 1
            r9 = r8
            r8 = r6
            goto L_0x0255
        L_0x0289:
            r6 = 0
            goto L_0x01ec
        L_0x028c:
            r6 = 0
            r7 = r6
            goto L_0x0251
        L_0x028f:
            boolean r10 = r6.isOverflowButton
            if (r10 == 0) goto L_0x029f
            r6.extraPixels = r7
            r8 = 1
            r6.expanded = r8
            int r8 = -r7
            int r8 = r8 / 2
            r6.rightMargin = r8
            r6 = 1
            goto L_0x0284
        L_0x029f:
            if (r9 == 0) goto L_0x02a5
            int r10 = r7 / 2
            r6.leftMargin = r10
        L_0x02a5:
            int r10 = r27 + -1
            if (r9 == r10) goto L_0x02ad
            int r10 = r7 / 2
            r6.rightMargin = r10
        L_0x02ad:
            r6 = r8
            goto L_0x0284
        L_0x02af:
            r8 = r18
        L_0x02b1:
            if (r8 == 0) goto L_0x02df
            r6 = 0
            r7 = r6
        L_0x02b5:
            r0 = r27
            if (r7 >= r0) goto L_0x02df
            r0 = r34
            android.view.View r8 = r0.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            android.support.v7.widget.ActionMenuView$LayoutParams r6 = (android.support.p003v7.widget.ActionMenuView.LayoutParams) r6
            boolean r9 = r6.expanded
            if (r9 == 0) goto L_0x02db
            int r9 = r6.cellsUsed
            int r9 = r9 * r26
            int r6 = r6.extraPixels
            int r6 = r6 + r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            r0 = r24
            r8.measure(r6, r0)
        L_0x02db:
            int r6 = r7 + 1
            r7 = r6
            goto L_0x02b5
        L_0x02df:
            r6 = 1073741824(0x40000000, float:2.0)
            r0 = r23
            if (r0 == r6) goto L_0x02f0
        L_0x02e5:
            r0 = r34
            r1 = r25
            r2 = r16
            r0.setMeasuredDimension(r1, r2)
            goto L_0x0040
        L_0x02f0:
            r16 = r17
            goto L_0x02e5
        L_0x02f3:
            r6 = r7
            goto L_0x0245
        L_0x02f6:
            r6 = r9
            goto L_0x0196
        L_0x02f9:
            r6 = r9
            r9 = r14
            goto L_0x013f
        L_0x02fd:
            r8 = r14
            r9 = r15
            r32 = r12
            r12 = r10
            r13 = r11
            r11 = r6
            r10 = r7
            r6 = r32
            goto L_0x00ec
        L_0x0309:
            r6 = r11
            goto L_0x00cf
        L_0x030c:
            r7 = r10
            goto L_0x00ca
        L_0x030f:
            r8 = r7
            r6 = r12
            r12 = r16
            r13 = r9
            r9 = r15
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.ActionMenuView.onMeasureExactFormat(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public void dismissPopupMenus() {
        if (this.mPresenter != null) {
            this.mPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
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

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            this.mMenu = new MenuBuilder(context);
            this.mMenu.setCallback(new MenuBuilderCallback());
            this.mPresenter = new ActionMenuPresenter(context);
            this.mPresenter.setReserveOverflow(true);
            this.mPresenter.setCallback(this.mActionMenuPresenterCallback != null ? this.mActionMenuPresenterCallback : new ActionMenuPresenterCallback());
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean hasSupportDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).needsDividerAfter() | false;
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : ((ActionMenuChildView) childAt2).needsDividerBefore() | z;
    }

    public boolean hideOverflowMenu() {
        return this.mPresenter != null && this.mPresenter.hideOverflowMenu();
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPresenter != null && this.mPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mPresenter != null && this.mPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.mPresenter != null) {
            this.mPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
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
        int width;
        int i9;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        boolean z2 = false;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i9 = layoutParams.leftMargin + getPaddingLeft();
                        width = i9 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i9 = width - measuredWidth;
                    }
                    int i13 = i10 - (measuredHeight / 2);
                    childAt.layout(i9, i13, width, measuredHeight + i13);
                    i7 = paddingRight - measuredWidth;
                    z2 = true;
                    i8 = i11;
                } else {
                    i7 = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                    hasSupportDividerBeforeChildAt(i12);
                    i8 = i11 + 1;
                }
            } else {
                i7 = paddingRight;
                i8 = i11;
            }
            i12++;
            i11 = i8;
            paddingRight = i7;
        }
        if (childCount != 1 || z2) {
            int i14 = i11 - (z2 ? 0 : 1);
            int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
            if (isLayoutRtl) {
                int width2 = getWidth() - getPaddingRight();
                int i15 = 0;
                while (i15 < childCount) {
                    View childAt2 = getChildAt(i15);
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() == 8 || layoutParams2.isOverflowButton) {
                        i6 = width2;
                    } else {
                        int i16 = width2 - layoutParams2.rightMargin;
                        int measuredWidth2 = childAt2.getMeasuredWidth();
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        int i17 = i10 - (measuredHeight2 / 2);
                        childAt2.layout(i16 - measuredWidth2, i17, i16, measuredHeight2 + i17);
                        i6 = i16 - ((layoutParams2.leftMargin + measuredWidth2) + max);
                    }
                    i15++;
                    width2 = i6;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            int i18 = 0;
            while (i18 < childCount) {
                View childAt3 = getChildAt(i18);
                LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams3.isOverflowButton) {
                    i5 = paddingLeft;
                } else {
                    int i19 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i19, i20, i19 + measuredWidth3, measuredHeight3 + i20);
                    i5 = layoutParams3.rightMargin + measuredWidth3 + max + i19;
                }
                i18++;
                paddingLeft = i5;
            }
            return;
        }
        View childAt4 = getChildAt(0);
        int measuredWidth4 = childAt4.getMeasuredWidth();
        int measuredHeight4 = childAt4.getMeasuredHeight();
        int i21 = ((i3 - i) / 2) - (measuredWidth4 / 2);
        int i22 = i10 - (measuredHeight4 / 2);
        childAt4.layout(i21, i22, measuredWidth4 + i21, measuredHeight4 + i22);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z = this.mFormatItems;
        this.mFormatItems = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.mFormatItems || this.mMenu == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            this.mMenu.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        onMeasureExactFormat(i, i2);
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = this.mContext;
            } else {
                this.mPopupContext = new ContextThemeWrapper(this.mContext, i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        this.mPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        return this.mPresenter != null && this.mPresenter.showOverflowMenu();
    }
}
