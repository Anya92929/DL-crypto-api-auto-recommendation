package android.support.p003v7.widget;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;

/* renamed from: android.support.v7.widget.OrientationHelper */
public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    protected final RecyclerView.LayoutManager f2880a;

    /* renamed from: b */
    private int f2881b;

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f2881b = Integer.MIN_VALUE;
        this.f2880a = layoutManager;
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public int getDecoratedEnd(View view) {
                return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + this.f2880a.getDecoratedRight(view);
            }

            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.f2880a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
            }

            public int getDecoratedMeasurementInOther(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.f2880a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
            }

            public int getDecoratedStart(View view) {
                return this.f2880a.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int getEnd() {
                return this.f2880a.getWidth();
            }

            public int getEndAfterPadding() {
                return this.f2880a.getWidth() - this.f2880a.getPaddingRight();
            }

            public int getEndPadding() {
                return this.f2880a.getPaddingRight();
            }

            public int getStartAfterPadding() {
                return this.f2880a.getPaddingLeft();
            }

            public int getTotalSpace() {
                return (this.f2880a.getWidth() - this.f2880a.getPaddingLeft()) - this.f2880a.getPaddingRight();
            }

            public void offsetChild(View view, int i) {
                view.offsetLeftAndRight(i);
            }

            public void offsetChildren(int i) {
                this.f2880a.offsetChildrenHorizontal(i);
            }
        };
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return createHorizontalHelper(layoutManager);
            case 1:
                return createVerticalHelper(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public int getDecoratedEnd(View view) {
                return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + this.f2880a.getDecoratedBottom(view);
            }

            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.f2880a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
            }

            public int getDecoratedMeasurementInOther(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.f2880a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
            }

            public int getDecoratedStart(View view) {
                return this.f2880a.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int getEnd() {
                return this.f2880a.getHeight();
            }

            public int getEndAfterPadding() {
                return this.f2880a.getHeight() - this.f2880a.getPaddingBottom();
            }

            public int getEndPadding() {
                return this.f2880a.getPaddingBottom();
            }

            public int getStartAfterPadding() {
                return this.f2880a.getPaddingTop();
            }

            public int getTotalSpace() {
                return (this.f2880a.getHeight() - this.f2880a.getPaddingTop()) - this.f2880a.getPaddingBottom();
            }

            public void offsetChild(View view, int i) {
                view.offsetTopAndBottom(i);
            }

            public void offsetChildren(int i) {
                this.f2880a.offsetChildrenVertical(i);
            }
        };
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.f2881b) {
            return 0;
        }
        return getTotalSpace() - this.f2881b;
    }

    public abstract void offsetChild(View view, int i);

    public abstract void offsetChildren(int i);

    public void onLayoutComplete() {
        this.f2881b = getTotalSpace();
    }
}
