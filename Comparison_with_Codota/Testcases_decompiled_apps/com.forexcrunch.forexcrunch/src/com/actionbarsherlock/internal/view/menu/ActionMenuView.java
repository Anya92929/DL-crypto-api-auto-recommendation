package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ActionMenuView extends IcsLinearLayout implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    private static final boolean IS_FROYO = (Build.VERSION.SDK_INT >= 8 ? true : IS_FROYO);
    static final int MIN_CELL_SIZE = 56;
    private boolean mFirst;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFirst = true;
        setBaselineAligned(IS_FROYO);
        float density = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * density);
        this.mGeneratedItemPadding = (int) (4.0f * density);
    }

    public void setPresenter(ActionMenuPresenter presenter) {
        this.mPresenter = presenter;
    }

    public boolean isExpandedFormat() {
        return this.mFormatItems;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (IS_FROYO) {
            super.onConfigurationChanged(newConfig);
        }
        this.mPresenter.updateMenuView(IS_FROYO);
        if (this.mPresenter != null && this.mPresenter.isOverflowMenuShowing()) {
            this.mPresenter.hideOverflowMenu();
            this.mPresenter.showOverflowMenu();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (IS_FROYO || !this.mFirst) {
            super.onDraw(canvas);
            return;
        }
        this.mFirst = IS_FROYO;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        boolean wasFormatted = this.mFormatItems;
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.mFormatItems = z;
        if (wasFormatted != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int widthSize = View.MeasureSpec.getMode(widthMeasureSpec);
        if (!(!this.mFormatItems || this.mMenu == null || widthSize == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = widthSize;
            this.mMenu.onItemsChanged(true);
        }
        if (this.mFormatItems) {
            onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        int cellsAvailable;
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int widthPadding = getPaddingLeft() + getPaddingRight();
        int heightPadding = getPaddingTop() + getPaddingBottom();
        int widthSize2 = widthSize - widthPadding;
        int cellCount = widthSize2 / this.mMinCellSize;
        int cellSizeRemaining = widthSize2 % this.mMinCellSize;
        if (cellCount == 0) {
            setMeasuredDimension(widthSize2, 0);
            return;
        }
        int cellSize = this.mMinCellSize + (cellSizeRemaining / cellCount);
        int cellsRemaining = cellCount;
        int maxChildHeight = 0;
        int maxCellsUsed = 0;
        int expandableItemCount = 0;
        int visibleItemCount = 0;
        boolean hasOverflow = IS_FROYO;
        long smallestItemsAt = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                boolean isGeneratedItem = child instanceof ActionMenuItemView;
                visibleItemCount++;
                if (isGeneratedItem) {
                    child.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                }
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.expanded = IS_FROYO;
                lp.extraPixels = 0;
                lp.cellsUsed = 0;
                lp.expandable = IS_FROYO;
                lp.leftMargin = 0;
                lp.rightMargin = 0;
                lp.preventEdgeOffset = (!isGeneratedItem || !((ActionMenuItemView) child).hasText()) ? IS_FROYO : true;
                if (lp.isOverflowButton) {
                    cellsAvailable = 1;
                } else {
                    cellsAvailable = cellsRemaining;
                }
                int cellsUsed = measureChildForCells(child, cellSize, cellsAvailable, heightMeasureSpec, heightPadding);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                if (lp.expandable) {
                    expandableItemCount++;
                }
                if (lp.isOverflowButton) {
                    hasOverflow = true;
                }
                cellsRemaining -= cellsUsed;
                maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
                if (cellsUsed == 1) {
                    smallestItemsAt |= (long) (1 << i);
                }
            }
        }
        boolean centerSingleExpandedItem = (!hasOverflow || visibleItemCount != 2) ? IS_FROYO : true;
        boolean needsExpansion = IS_FROYO;
        while (expandableItemCount > 0 && cellsRemaining > 0) {
            int minCells = Integer.MAX_VALUE;
            long minCellsAt = 0;
            int minCellsItemCount = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams lp2 = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (lp2.expandable) {
                    if (lp2.cellsUsed < minCells) {
                        minCells = lp2.cellsUsed;
                        minCellsAt = (long) (1 << i2);
                        minCellsItemCount = 1;
                    } else if (lp2.cellsUsed == minCells) {
                        minCellsAt |= (long) (1 << i2);
                        minCellsItemCount++;
                    }
                }
            }
            smallestItemsAt |= minCellsAt;
            if (minCellsItemCount > cellsRemaining) {
                break;
            }
            int minCells2 = minCells + 1;
            for (int i3 = 0; i3 < childCount; i3++) {
                View child2 = getChildAt(i3);
                LayoutParams lp3 = (LayoutParams) child2.getLayoutParams();
                if ((((long) (1 << i3)) & minCellsAt) != 0) {
                    if (centerSingleExpandedItem && lp3.preventEdgeOffset && cellsRemaining == 1) {
                        child2.setPadding(this.mGeneratedItemPadding + cellSize, 0, this.mGeneratedItemPadding, 0);
                    }
                    lp3.cellsUsed++;
                    lp3.expanded = true;
                    cellsRemaining--;
                } else if (lp3.cellsUsed == minCells2) {
                    smallestItemsAt |= (long) (1 << i3);
                }
            }
            needsExpansion = true;
        }
        boolean singleItem = (hasOverflow || visibleItemCount != 1) ? IS_FROYO : true;
        if (cellsRemaining > 0 && smallestItemsAt != 0 && (cellsRemaining < visibleItemCount - 1 || singleItem || maxCellsUsed > 1)) {
            float expandCount = (float) Long.bitCount(smallestItemsAt);
            if (!singleItem) {
                if ((1 & smallestItemsAt) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    expandCount -= 0.5f;
                }
                if ((((long) (1 << (childCount - 1))) & smallestItemsAt) != 0 && !((LayoutParams) getChildAt(childCount - 1).getLayoutParams()).preventEdgeOffset) {
                    expandCount -= 0.5f;
                }
            }
            int extraPixels = expandCount > BitmapDescriptorFactory.HUE_RED ? (int) (((float) (cellsRemaining * cellSize)) / expandCount) : 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                if ((((long) (1 << i4)) & smallestItemsAt) != 0) {
                    View child3 = getChildAt(i4);
                    LayoutParams lp4 = (LayoutParams) child3.getLayoutParams();
                    if (child3 instanceof ActionMenuItemView) {
                        lp4.extraPixels = extraPixels;
                        lp4.expanded = true;
                        if (i4 == 0 && !lp4.preventEdgeOffset) {
                            lp4.leftMargin = (-extraPixels) / 2;
                        }
                        needsExpansion = true;
                    } else if (lp4.isOverflowButton) {
                        lp4.extraPixels = extraPixels;
                        lp4.expanded = true;
                        lp4.rightMargin = (-extraPixels) / 2;
                        needsExpansion = true;
                    } else {
                        if (i4 != 0) {
                            lp4.leftMargin = extraPixels / 2;
                        }
                        if (i4 != childCount - 1) {
                            lp4.rightMargin = extraPixels / 2;
                        }
                    }
                }
            }
        }
        if (needsExpansion) {
            int heightSpec = View.MeasureSpec.makeMeasureSpec(heightSize - heightPadding, heightMode);
            for (int i5 = 0; i5 < childCount; i5++) {
                View child4 = getChildAt(i5);
                LayoutParams lp5 = (LayoutParams) child4.getLayoutParams();
                if (lp5.expanded) {
                    child4.measure(View.MeasureSpec.makeMeasureSpec((lp5.cellsUsed * cellSize) + lp5.extraPixels, 1073741824), heightSpec);
                }
            }
        }
        if (heightMode != 1073741824) {
            heightSize = maxChildHeight;
        }
        setMeasuredDimension(widthSize2, heightSize);
    }

    static int measureChildForCells(View child, int cellSize, int cellsRemaining, int parentHeightMeasureSpec, int parentHeightPadding) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int childHeightSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(parentHeightMeasureSpec) - parentHeightPadding, View.MeasureSpec.getMode(parentHeightMeasureSpec));
        int cellsUsed = 0;
        if (cellsRemaining > 0) {
            child.measure(View.MeasureSpec.makeMeasureSpec(cellSize * cellsRemaining, Integer.MIN_VALUE), childHeightSpec);
            int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) {
                cellsUsed++;
            }
        }
        ActionMenuItemView itemView = child instanceof ActionMenuItemView ? (ActionMenuItemView) child : null;
        lp.expandable = (lp.isOverflowButton || itemView == null || !itemView.hasText()) ? IS_FROYO : true;
        lp.cellsUsed = cellsUsed;
        child.measure(View.MeasureSpec.makeMeasureSpec(cellsUsed * cellSize, 1073741824), childHeightSpec);
        return cellsUsed;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!this.mFormatItems) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }
        int childCount = getChildCount();
        int midVertical = (top + bottom) / 2;
        int nonOverflowCount = 0;
        int widthRemaining = ((right - left) - getPaddingRight()) - getPaddingLeft();
        boolean hasOverflow = IS_FROYO;
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            if (v.getVisibility() != 8) {
                LayoutParams p = (LayoutParams) v.getLayoutParams();
                if (p.isOverflowButton) {
                    int overflowWidth = v.getMeasuredWidth();
                    if (hasDividerBeforeChildAt(i)) {
                        overflowWidth += 0;
                    }
                    int height = v.getMeasuredHeight();
                    int r = (getWidth() - getPaddingRight()) - p.rightMargin;
                    int t = midVertical - (height / 2);
                    v.layout(r - overflowWidth, t, r, t + height);
                    widthRemaining -= overflowWidth;
                    hasOverflow = true;
                } else {
                    widthRemaining -= (v.getMeasuredWidth() + p.leftMargin) + p.rightMargin;
                    nonOverflowCount++;
                }
            }
        }
        if (childCount != 1 || hasOverflow) {
            int spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);
            int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
            int startLeft = getPaddingLeft();
            for (int i2 = 0; i2 < childCount; i2++) {
                View v2 = getChildAt(i2);
                LayoutParams lp = (LayoutParams) v2.getLayoutParams();
                if (v2.getVisibility() != 8 && !lp.isOverflowButton) {
                    int startLeft2 = startLeft + lp.leftMargin;
                    int width = v2.getMeasuredWidth();
                    int height2 = v2.getMeasuredHeight();
                    int t2 = midVertical - (height2 / 2);
                    v2.layout(startLeft2, t2, startLeft2 + width, t2 + height2);
                    startLeft = startLeft2 + lp.rightMargin + width + spacerSize;
                }
            }
            return;
        }
        View v3 = getChildAt(0);
        int width2 = v3.getMeasuredWidth();
        int height3 = v3.getMeasuredHeight();
        int l = ((right - left) / 2) - (width2 / 2);
        int t3 = midVertical - (height3 / 2);
        v3.layout(l, t3, l + width2, t3 + height3);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPresenter.dismissPopupMenus();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void setOverflowReserved(boolean reserveOverflow) {
        this.mReserveOverflow = reserveOverflow;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams params = new LayoutParams(-2, -2);
        params.gravity = 16;
        return params;
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        if (!(p instanceof LayoutParams)) {
            return generateDefaultLayoutParams();
        }
        LayoutParams result = new LayoutParams((LayoutParams) p);
        if (result.gravity > 0) {
            return result;
        }
        result.gravity = 16;
        return result;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        if (p == null || !(p instanceof LayoutParams)) {
            return IS_FROYO;
        }
        return true;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
        return result;
    }

    public boolean invokeItem(MenuItemImpl item) {
        return this.mMenu.performItemAction(item, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder menu) {
        this.mMenu = menu;
    }

    /* access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            return IS_FROYO;
        }
        View childBefore = getChildAt(childIndex - 1);
        View child = getChildAt(childIndex);
        boolean result = IS_FROYO;
        if (childIndex < getChildCount() && (childBefore instanceof ActionMenuChildView)) {
            result = false | ((ActionMenuChildView) childBefore).needsDividerAfter();
        }
        if (childIndex <= 0 || !(child instanceof ActionMenuChildView)) {
            return result;
        }
        return result | ((ActionMenuChildView) child).needsDividerBefore();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return IS_FROYO;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int cellsUsed;
        public boolean expandable;
        public boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(LayoutParams other) {
            super(other);
            this.isOverflowButton = other.isOverflowButton;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.isOverflowButton = ActionMenuView.IS_FROYO;
        }

        public LayoutParams(int width, int height, boolean isOverflowButton2) {
            super(width, height);
            this.isOverflowButton = isOverflowButton2;
        }
    }
}
