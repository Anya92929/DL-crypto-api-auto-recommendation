package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* renamed from: android.support.v7.widget.GridLayoutManager */
public class GridLayoutManager extends LinearLayoutManager {
    public static final int DEFAULT_SPAN_COUNT = -1;

    /* renamed from: a */
    static final int f2752a = View.MeasureSpec.makeMeasureSpec(0, 0);

    /* renamed from: b */
    boolean f2753b = false;

    /* renamed from: c */
    int f2754c = -1;

    /* renamed from: d */
    int[] f2755d;

    /* renamed from: e */
    View[] f2756e;

    /* renamed from: f */
    final SparseIntArray f2757f = new SparseIntArray();

    /* renamed from: g */
    final SparseIntArray f2758g = new SparseIntArray();

    /* renamed from: h */
    SpanSizeLookup f2759h = new DefaultSpanSizeLookup();

    /* renamed from: i */
    final Rect f2760i = new Rect();

    /* renamed from: android.support.v7.widget.GridLayoutManager$DefaultSpanSizeLookup */
    public final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$LayoutParams */
    public class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f2761e = -1;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f2762f = 0;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int getSpanIndex() {
            return this.f2761e;
        }

        public int getSpanSize() {
            return this.f2762f;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$SpanSizeLookup */
    public abstract class SpanSizeLookup {

        /* renamed from: a */
        final SparseIntArray f2763a = new SparseIntArray();

        /* renamed from: b */
        private boolean f2764b = false;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5264a(int i) {
            int i2 = 0;
            int size = this.f2763a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f2763a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f2763a.size()) {
                return -1;
            }
            return this.f2763a.keyAt(i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5265a(int i, int i2) {
            if (!this.f2764b) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.f2763a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.f2763a.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                int i6 = i5 + spanSize2;
                if (i6 == i2) {
                    i4++;
                    spanSize2 = 0;
                } else if (i6 > i2) {
                    i4++;
                } else {
                    spanSize2 = i6;
                }
                i3++;
                i5 = spanSize2;
            }
            return i5 + spanSize > i2 ? i4 + 1 : i4;
        }

        public int getSpanIndex(int i, int i2) {
            int i3;
            int i4;
            int a;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (!this.f2764b || this.f2763a.size() <= 0 || (a = mo5264a(i)) < 0) {
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.f2763a.get(a) + getSpanSize(a);
                i3 = a + 1;
            }
            int i5 = i3;
            while (i5 < i) {
                int spanSize2 = getSpanSize(i5);
                int i6 = i4 + spanSize2;
                if (i6 == i2) {
                    spanSize2 = 0;
                } else if (i6 <= i2) {
                    spanSize2 = i6;
                }
                i5++;
                i4 = spanSize2;
            }
            if (i4 + spanSize <= i2) {
                return i4;
            }
            return 0;
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanIndexCache() {
            this.f2763a.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.f2764b;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            this.f2764b = z;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    /* renamed from: a */
    private int m1816a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - i2) - i3, mode) : i;
    }

    /* renamed from: a */
    private int m1817a(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.f2759h.getSpanGroupIndex(i, this.f2754c);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.f2759h.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.f2754c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* renamed from: a */
    private void m1818a(int i) {
        int i2;
        int i3 = 0;
        if (!(this.f2755d != null && this.f2755d.length == this.f2754c + 1 && this.f2755d[this.f2755d.length - 1] == i)) {
            this.f2755d = new int[(this.f2754c + 1)];
        }
        this.f2755d[0] = 0;
        int i4 = i / this.f2754c;
        int i5 = i % this.f2754c;
        int i6 = 0;
        for (int i7 = 1; i7 <= this.f2754c; i7++) {
            int i8 = i3 + i5;
            if (i8 <= 0 || this.f2754c - i8 >= i5) {
                i3 = i8;
                i2 = i4;
            } else {
                i3 = i8 - this.f2754c;
                i2 = i4 + 1;
            }
            i6 += i2;
            this.f2755d[i7] = i6;
        }
    }

    /* renamed from: a */
    private void m1819a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i4 = -1;
            i = -1;
        }
        if (this.f2792j != 1 || !mo5316a()) {
            i5 = 0;
            i6 = 1;
        } else {
            i5 = this.f2754c - 1;
            i6 = -1;
        }
        int i7 = i5;
        for (int i8 = i3; i8 != i; i8 += i4) {
            View view = this.f2756e[i8];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int unused = layoutParams.f2762f = m1824c(recycler, state, getPosition(view));
            if (i6 != -1 || layoutParams.f2762f <= 1) {
                int unused2 = layoutParams.f2761e = i7;
            } else {
                int unused3 = layoutParams.f2761e = i7 - (layoutParams.f2762f - 1);
            }
            i7 += layoutParams.f2762f * i6;
        }
    }

    /* renamed from: a */
    private void m1820a(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.f2760i);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.f2792j == 1) {
            i = m1816a(i, layoutParams.leftMargin + this.f2760i.left, layoutParams.rightMargin + this.f2760i.right);
        }
        if (z || this.f2792j == 0) {
            i2 = m1816a(i2, layoutParams.topMargin + this.f2760i.top, layoutParams.bottomMargin + this.f2760i.bottom);
        }
        view.measure(i, i2);
    }

    /* renamed from: b */
    private int m1821b(int i) {
        return i < 0 ? f2752a : View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    /* renamed from: b */
    private int m1822b(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.f2759h.mo5265a(i, this.f2754c);
        }
        int i2 = this.f2758g.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.f2759h.mo5265a(convertPreLayoutPositionToPostLayout, this.f2754c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    /* renamed from: b */
    private void m1823b(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo) {
        int b = m1822b(recycler, state, anchorInfo.f2800a);
        while (b > 0 && anchorInfo.f2800a > 0) {
            anchorInfo.f2800a--;
            b = m1822b(recycler, state, anchorInfo.f2800a);
        }
    }

    /* renamed from: c */
    private int m1824c(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.f2759h.getSpanSize(i);
        }
        int i2 = this.f2757f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.f2759h.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* renamed from: e */
    private void m1825e() {
        this.f2757f.clear();
        this.f2758g.clear();
    }

    /* renamed from: f */
    private void m1826f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.f2757f.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.f2758g.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    /* renamed from: g */
    private void m1827g() {
        m1818a(getOrientation() == 1 ? (getWidth() - getPaddingRight()) - getPaddingLeft() : (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5238a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        View view;
        View view2 = null;
        mo5318b();
        int startAfterPadding = this.f2793k.getStartAfterPadding();
        int endAfterPadding = this.f2793k.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view3 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (m1822b(recycler, state, position) != 0) {
                    view = view2;
                    childAt = view3;
                } else if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view3 == null) {
                        view = view2;
                    }
                } else if (this.f2793k.getDecoratedStart(childAt) < endAfterPadding && this.f2793k.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view2 == null) {
                        view = childAt;
                        childAt = view3;
                    }
                }
                i += i4;
                view2 = view;
                view3 = childAt;
            }
            view = view2;
            childAt = view3;
            i += i4;
            view2 = view;
            view3 = childAt;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5239a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo) {
        super.mo5239a(recycler, state, anchorInfo);
        m1827g();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            m1823b(recycler, state, anchorInfo);
        }
        if (this.f2756e == null || this.f2756e.length != this.f2754c) {
            this.f2756e = new View[this.f2754c];
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5240a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a;
        boolean z = layoutState.f2808e == 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = this.f2754c;
        if (!z) {
            i8 = m1822b(recycler, state, layoutState.f2807d) + m1824c(recycler, state, layoutState.f2807d);
        }
        while (i6 < this.f2754c && layoutState.mo5362a(state) && i8 > 0) {
            int i9 = layoutState.f2807d;
            int c = m1824c(recycler, state, i9);
            if (c <= this.f2754c) {
                i8 -= c;
                if (i8 < 0 || (a = layoutState.mo5361a(recycler)) == null) {
                    break;
                }
                i7 += c;
                this.f2756e[i6] = a;
                i6++;
            } else {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + c + " spans but GridLayoutManager has only " + this.f2754c + " spans.");
            }
        }
        if (i6 == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        m1819a(recycler, state, i6, i7, z);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i6) {
            View view = this.f2756e[i10];
            if (layoutState.f2814k == null) {
                if (z) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2755d[layoutParams.f2761e + layoutParams.f2762f] - this.f2755d[layoutParams.f2761e], 1073741824);
            if (this.f2792j == 1) {
                m1820a(view, makeMeasureSpec, m1821b(layoutParams.height), false);
            } else {
                m1820a(view, m1821b(layoutParams.width), makeMeasureSpec, false);
            }
            int decoratedMeasurement = this.f2793k.getDecoratedMeasurement(view);
            if (decoratedMeasurement <= i11) {
                decoratedMeasurement = i11;
            }
            i10++;
            i11 = decoratedMeasurement;
        }
        int b = m1821b(i11);
        for (int i12 = 0; i12 < i6; i12++) {
            View view2 = this.f2756e[i12];
            if (this.f2793k.getDecoratedMeasurement(view2) != i11) {
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f2755d[layoutParams2.f2761e + layoutParams2.f2762f] - this.f2755d[layoutParams2.f2761e], 1073741824);
                if (this.f2792j == 1) {
                    m1820a(view2, makeMeasureSpec2, b, true);
                } else {
                    m1820a(view2, b, makeMeasureSpec2, true);
                }
            }
        }
        layoutChunkResult.mConsumed = i11;
        int i13 = 0;
        if (this.f2792j == 1) {
            if (layoutState.f2809f == -1) {
                i13 = layoutState.f2805b;
                i3 = i13 - i11;
                i2 = 0;
                i = 0;
            } else {
                int i14 = layoutState.f2805b;
                i13 = i14 + i11;
                i3 = i14;
                i2 = 0;
                i = 0;
            }
        } else if (layoutState.f2809f == -1) {
            int i15 = layoutState.f2805b;
            i2 = i15;
            i = i15 - i11;
            i3 = 0;
        } else {
            i = layoutState.f2805b;
            i2 = i11 + i;
            i3 = 0;
        }
        int i16 = 0;
        int i17 = i;
        int i18 = i2;
        int i19 = i3;
        int i20 = i13;
        while (i16 < i6) {
            View view3 = this.f2756e[i16];
            LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
            if (this.f2792j == 1) {
                int paddingLeft = this.f2755d[layoutParams3.f2761e] + getPaddingLeft();
                i4 = this.f2793k.getDecoratedMeasurementInOther(view3) + paddingLeft;
                i5 = paddingLeft;
            } else {
                i19 = this.f2755d[layoutParams3.f2761e] + getPaddingTop();
                i20 = this.f2793k.getDecoratedMeasurementInOther(view3) + i19;
                i4 = i18;
                i5 = i17;
            }
            layoutDecorated(view3, i5 + layoutParams3.leftMargin, i19 + layoutParams3.topMargin, i4 - layoutParams3.rightMargin, i20 - layoutParams3.bottomMargin);
            if (layoutParams3.isItemRemoved() || layoutParams3.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= view3.isFocusable();
            i16++;
            i18 = i4;
            i17 = i5;
        }
        Arrays.fill(this.f2756e, (Object) null);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f2792j == 1) {
            return this.f2754c;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return m1817a(recycler, state, state.getItemCount() - 1);
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f2792j == 0) {
            return this.f2754c;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return m1817a(recycler, state, state.getItemCount() - 1);
    }

    public int getSpanCount() {
        return this.f2754c;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.f2759h;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.mo5707a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a = m1817a(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.f2792j == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), a, 1, this.f2754c > 1 && layoutParams2.getSpanSize() == this.f2754c, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(a, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), this.f2754c > 1 && layoutParams2.getSpanSize() == this.f2754c, false));
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f2759h.invalidateSpanIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f2759h.invalidateSpanIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f2759h.invalidateSpanIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f2759h.invalidateSpanIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f2759h.invalidateSpanIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            m1826f();
        }
        super.onLayoutChildren(recycler, state);
        m1825e();
        if (!state.isPreLayout()) {
            this.f2753b = false;
        }
    }

    public void setSpanCount(int i) {
        if (i != this.f2754c) {
            this.f2753b = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f2754c = i;
            this.f2759h.invalidateSpanIndexCache();
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.f2759h = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f2797o == null && !this.f2753b;
    }
}
