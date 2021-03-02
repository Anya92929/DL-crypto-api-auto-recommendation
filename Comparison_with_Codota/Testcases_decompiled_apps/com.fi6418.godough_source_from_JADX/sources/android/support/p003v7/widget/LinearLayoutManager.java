package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.media.TransportMediator;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* renamed from: android.support.v7.widget.LinearLayoutManager */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    private LayoutState f2786a;

    /* renamed from: b */
    private boolean f2787b;

    /* renamed from: c */
    private boolean f2788c;

    /* renamed from: d */
    private boolean f2789d;

    /* renamed from: e */
    private boolean f2790e;

    /* renamed from: f */
    private boolean f2791f;

    /* renamed from: j */
    int f2792j;

    /* renamed from: k */
    OrientationHelper f2793k;

    /* renamed from: l */
    boolean f2794l;

    /* renamed from: m */
    int f2795m;

    /* renamed from: n */
    int f2796n;

    /* renamed from: o */
    SavedState f2797o;

    /* renamed from: p */
    final AnchorInfo f2798p;

    /* renamed from: android.support.v7.widget.LinearLayoutManager$AnchorInfo */
    class AnchorInfo {

        /* renamed from: a */
        int f2800a;

        /* renamed from: b */
        int f2801b;

        /* renamed from: c */
        boolean f2802c;

        AnchorInfo() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m1898a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5355a() {
            this.f2800a = -1;
            this.f2801b = Integer.MIN_VALUE;
            this.f2802c = false;
        }

        public void assignFromView(View view) {
            if (this.f2802c) {
                this.f2801b = LinearLayoutManager.this.f2793k.getDecoratedEnd(view) + LinearLayoutManager.this.f2793k.getTotalSpaceChange();
            } else {
                this.f2801b = LinearLayoutManager.this.f2793k.getDecoratedStart(view);
            }
            this.f2800a = LinearLayoutManager.this.getPosition(view);
        }

        public void assignFromViewAndKeepVisibleRect(View view) {
            int totalSpaceChange = LinearLayoutManager.this.f2793k.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view);
                return;
            }
            this.f2800a = LinearLayoutManager.this.getPosition(view);
            if (this.f2802c) {
                int endAfterPadding = (LinearLayoutManager.this.f2793k.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.f2793k.getDecoratedEnd(view);
                this.f2801b = LinearLayoutManager.this.f2793k.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.f2801b - LinearLayoutManager.this.f2793k.getDecoratedMeasurement(view);
                    int startAfterPadding = LinearLayoutManager.this.f2793k.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(LinearLayoutManager.this.f2793k.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.f2801b = Math.min(endAfterPadding, -min) + this.f2801b;
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = LinearLayoutManager.this.f2793k.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - LinearLayoutManager.this.f2793k.getStartAfterPadding();
            this.f2801b = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (LinearLayoutManager.this.f2793k.getEndAfterPadding() - Math.min(0, (LinearLayoutManager.this.f2793k.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.f2793k.getDecoratedEnd(view))) - (decoratedStart + LinearLayoutManager.this.f2793k.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.f2801b -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5358b() {
            this.f2801b = this.f2802c ? LinearLayoutManager.this.f2793k.getEndAfterPadding() : LinearLayoutManager.this.f2793k.getStartAfterPadding();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2800a + ", mCoordinate=" + this.f2801b + ", mLayoutFromEnd=" + this.f2802c + '}';
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$LayoutChunkResult */
    public class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5360a() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$LayoutState */
    class LayoutState {

        /* renamed from: a */
        boolean f2804a = true;

        /* renamed from: b */
        int f2805b;

        /* renamed from: c */
        int f2806c;

        /* renamed from: d */
        int f2807d;

        /* renamed from: e */
        int f2808e;

        /* renamed from: f */
        int f2809f;

        /* renamed from: g */
        int f2810g;

        /* renamed from: h */
        int f2811h = 0;

        /* renamed from: i */
        boolean f2812i = false;

        /* renamed from: j */
        int f2813j;

        /* renamed from: k */
        List<RecyclerView.ViewHolder> f2814k = null;

        LayoutState() {
        }

        /* renamed from: a */
        private View m1902a() {
            int size = this.f2814k.size();
            for (int i = 0; i < size; i++) {
                View view = this.f2814k.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.f2807d == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo5361a(RecyclerView.Recycler recycler) {
            if (this.f2814k != null) {
                return m1902a();
            }
            View viewForPosition = recycler.getViewForPosition(this.f2807d);
            this.f2807d += this.f2808e;
            return viewForPosition;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5362a(RecyclerView.State state) {
            return this.f2807d >= 0 && this.f2807d < state.getItemCount();
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList((View) null);
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            if (nextViewInLimitedList == null) {
                this.f2807d = -1;
            } else {
                this.f2807d = ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public View nextViewInLimitedList(View view) {
            int i;
            View view2;
            int size = this.f2814k.size();
            View view3 = null;
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < size) {
                View view4 = this.f2814k.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view4.getLayoutParams();
                if (view4 != view) {
                    if (layoutParams.isItemRemoved()) {
                        i = i2;
                        view2 = view3;
                    } else {
                        i = (layoutParams.getViewLayoutPosition() - this.f2807d) * this.f2808e;
                        if (i < 0) {
                            i = i2;
                            view2 = view3;
                        } else if (i < i2) {
                            if (i == 0) {
                                return view4;
                            }
                            view2 = view4;
                        }
                    }
                    i3++;
                    view3 = view2;
                    i2 = i;
                }
                i = i2;
                view2 = view3;
                i3++;
                view3 = view2;
                i2 = i;
            }
            return view3;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$SavedState */
    class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f2815a;

        /* renamed from: b */
        int f2816b;

        /* renamed from: c */
        boolean f2817c;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f2815a = parcel.readInt();
            this.f2816b = parcel.readInt();
            this.f2817c = parcel.readInt() != 1 ? false : z;
        }

        public SavedState(SavedState savedState) {
            this.f2815a = savedState.f2815a;
            this.f2816b = savedState.f2816b;
            this.f2817c = savedState.f2817c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5366a() {
            return this.f2815a >= 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5367b() {
            this.f2815a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2815a);
            parcel.writeInt(this.f2816b);
            parcel.writeInt(this.f2817c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f2788c = false;
        this.f2794l = false;
        this.f2789d = false;
        this.f2790e = true;
        this.f2795m = -1;
        this.f2796n = Integer.MIN_VALUE;
        this.f2797o = null;
        this.f2798p = new AnchorInfo();
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2788c = false;
        this.f2794l = false;
        this.f2789d = false;
        this.f2790e = true;
        this.f2795m = -1;
        this.f2796n = Integer.MIN_VALUE;
        this.f2797o = null;
        this.f2798p = new AnchorInfo();
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    /* renamed from: a */
    private int m1859a(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.f2792j != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f2792j != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f2792j != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case TransportMediator.KEYCODE_MEDIA_RECORD:
                if (this.f2792j == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* renamed from: a */
    private int m1860a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.f2793k.getEndAfterPadding() - i;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -mo5312a(-endAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (endAfterPadding = this.f2793k.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.f2793k.offsetChildren(endAfterPadding);
        return i2 + endAfterPadding;
    }

    /* renamed from: a */
    private View m1861a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f2794l ? m1880c(recycler, state) : m1883d(recycler, state);
    }

    /* renamed from: a */
    private View m1862a(boolean z, boolean z2) {
        return this.f2794l ? mo5315a(getChildCount() - 1, -1, z, z2) : mo5315a(0, getChildCount(), z, z2);
    }

    /* renamed from: a */
    private void m1863a(int i, int i2) {
        this.f2786a.f2806c = this.f2793k.getEndAfterPadding() - i2;
        this.f2786a.f2808e = this.f2794l ? -1 : 1;
        this.f2786a.f2807d = i;
        this.f2786a.f2809f = 1;
        this.f2786a.f2805b = i2;
        this.f2786a.f2810g = Integer.MIN_VALUE;
    }

    /* renamed from: a */
    private void m1864a(int i, int i2, boolean z, RecyclerView.State state) {
        int startAfterPadding;
        int i3 = -1;
        int i4 = 1;
        this.f2786a.f2811h = mo5314a(state);
        this.f2786a.f2809f = i;
        if (i == 1) {
            this.f2786a.f2811h += this.f2793k.getEndPadding();
            View g = m1886g();
            LayoutState layoutState = this.f2786a;
            if (!this.f2794l) {
                i3 = 1;
            }
            layoutState.f2808e = i3;
            this.f2786a.f2807d = getPosition(g) + this.f2786a.f2808e;
            this.f2786a.f2805b = this.f2793k.getDecoratedEnd(g);
            startAfterPadding = this.f2793k.getDecoratedEnd(g) - this.f2793k.getEndAfterPadding();
        } else {
            View f = m1885f();
            this.f2786a.f2811h += this.f2793k.getStartAfterPadding();
            LayoutState layoutState2 = this.f2786a;
            if (!this.f2794l) {
                i4 = -1;
            }
            layoutState2.f2808e = i4;
            this.f2786a.f2807d = getPosition(f) + this.f2786a.f2808e;
            this.f2786a.f2805b = this.f2793k.getDecoratedStart(f);
            startAfterPadding = (-this.f2793k.getDecoratedStart(f)) + this.f2793k.getStartAfterPadding();
        }
        this.f2786a.f2806c = i2;
        if (z) {
            this.f2786a.f2806c -= startAfterPadding;
        }
        this.f2786a.f2810g = startAfterPadding;
    }

    /* renamed from: a */
    private void m1865a(AnchorInfo anchorInfo) {
        m1863a(anchorInfo.f2800a, anchorInfo.f2801b);
    }

    /* renamed from: a */
    private void m1866a(RecyclerView.Recycler recycler, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            if (this.f2794l) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (this.f2793k.getDecoratedEnd(getChildAt(i2)) > i) {
                        m1867a(recycler, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                if (this.f2793k.getDecoratedEnd(getChildAt(i3)) > i) {
                    m1867a(recycler, 0, i3);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m1867a(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    /* renamed from: a */
    private void m1868a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f2804a) {
            if (layoutState.f2809f == -1) {
                m1877b(recycler, layoutState.f2810g);
            } else {
                m1866a(recycler, layoutState.f2810g);
            }
        }
    }

    /* renamed from: a */
    private void m1869a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int decoratedMeasurement;
        int i3;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            int i4 = 0;
            int i5 = 0;
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i6 = 0;
            while (i6 < size) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i6);
                if (viewHolder.mo5934n()) {
                    decoratedMeasurement = i5;
                    i3 = i4;
                } else {
                    if (((viewHolder.getLayoutPosition() < position) != this.f2794l ? (char) 65535 : 1) == 65535) {
                        i3 = this.f2793k.getDecoratedMeasurement(viewHolder.itemView) + i4;
                        decoratedMeasurement = i5;
                    } else {
                        decoratedMeasurement = this.f2793k.getDecoratedMeasurement(viewHolder.itemView) + i5;
                        i3 = i4;
                    }
                }
                i6++;
                i4 = i3;
                i5 = decoratedMeasurement;
            }
            this.f2786a.f2814k = scrapList;
            if (i4 > 0) {
                m1875b(getPosition(m1885f()), i);
                this.f2786a.f2811h = i4;
                this.f2786a.f2806c = 0;
                this.f2786a.assignPositionFromScrapList();
                mo5313a(recycler, this.f2786a, state, false);
            }
            if (i5 > 0) {
                m1863a(getPosition(m1886g()), i2);
                this.f2786a.f2811h = i5;
                this.f2786a.f2806c = 0;
                this.f2786a.assignPositionFromScrapList();
                mo5313a(recycler, this.f2786a, state, false);
            }
            this.f2786a.f2814k = null;
        }
    }

    /* renamed from: a */
    private boolean m1870a(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (state.isPreLayout() || this.f2795m == -1) {
            return false;
        }
        if (this.f2795m < 0 || this.f2795m >= state.getItemCount()) {
            this.f2795m = -1;
            this.f2796n = Integer.MIN_VALUE;
            return false;
        }
        anchorInfo.f2800a = this.f2795m;
        if (this.f2797o != null && this.f2797o.mo5366a()) {
            anchorInfo.f2802c = this.f2797o.f2817c;
            if (anchorInfo.f2802c) {
                anchorInfo.f2801b = this.f2793k.getEndAfterPadding() - this.f2797o.f2816b;
                return true;
            }
            anchorInfo.f2801b = this.f2793k.getStartAfterPadding() + this.f2797o.f2816b;
            return true;
        } else if (this.f2796n == Integer.MIN_VALUE) {
            View findViewByPosition = findViewByPosition(this.f2795m);
            if (findViewByPosition == null) {
                if (getChildCount() > 0) {
                    if ((this.f2795m < getPosition(getChildAt(0))) == this.f2794l) {
                        z = true;
                    }
                    anchorInfo.f2802c = z;
                }
                anchorInfo.mo5358b();
                return true;
            } else if (this.f2793k.getDecoratedMeasurement(findViewByPosition) > this.f2793k.getTotalSpace()) {
                anchorInfo.mo5358b();
                return true;
            } else if (this.f2793k.getDecoratedStart(findViewByPosition) - this.f2793k.getStartAfterPadding() < 0) {
                anchorInfo.f2801b = this.f2793k.getStartAfterPadding();
                anchorInfo.f2802c = false;
                return true;
            } else if (this.f2793k.getEndAfterPadding() - this.f2793k.getDecoratedEnd(findViewByPosition) < 0) {
                anchorInfo.f2801b = this.f2793k.getEndAfterPadding();
                anchorInfo.f2802c = true;
                return true;
            } else {
                anchorInfo.f2801b = anchorInfo.f2802c ? this.f2793k.getDecoratedEnd(findViewByPosition) + this.f2793k.getTotalSpaceChange() : this.f2793k.getDecoratedStart(findViewByPosition);
                return true;
            }
        } else {
            anchorInfo.f2802c = this.f2794l;
            if (this.f2794l) {
                anchorInfo.f2801b = this.f2793k.getEndAfterPadding() - this.f2796n;
                return true;
            }
            anchorInfo.f2801b = this.f2793k.getStartAfterPadding() + this.f2796n;
            return true;
        }
    }

    /* renamed from: b */
    private int m1871b(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.f2793k.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -mo5312a(startAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (startAfterPadding = i3 - this.f2793k.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.f2793k.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    /* renamed from: b */
    private int m1872b(RecyclerView.State state) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        mo5318b();
        OrientationHelper orientationHelper = this.f2793k;
        View a = m1862a(!this.f2790e, true);
        if (!this.f2790e) {
            z = true;
        }
        return ScrollbarHelper.m2184a(state, orientationHelper, a, m1874b(z, true), this, this.f2790e, this.f2794l);
    }

    /* renamed from: b */
    private View m1873b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.f2794l ? m1883d(recycler, state) : m1880c(recycler, state);
    }

    /* renamed from: b */
    private View m1874b(boolean z, boolean z2) {
        return this.f2794l ? mo5315a(0, getChildCount(), z, z2) : mo5315a(getChildCount() - 1, -1, z, z2);
    }

    /* renamed from: b */
    private void m1875b(int i, int i2) {
        this.f2786a.f2806c = i2 - this.f2793k.getStartAfterPadding();
        this.f2786a.f2807d = i;
        this.f2786a.f2808e = this.f2794l ? 1 : -1;
        this.f2786a.f2809f = -1;
        this.f2786a.f2805b = i2;
        this.f2786a.f2810g = Integer.MIN_VALUE;
    }

    /* renamed from: b */
    private void m1876b(AnchorInfo anchorInfo) {
        m1875b(anchorInfo.f2800a, anchorInfo.f2801b);
    }

    /* renamed from: b */
    private void m1877b(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.f2793k.getEnd() - i;
            if (this.f2794l) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (this.f2793k.getDecoratedStart(getChildAt(i2)) < end) {
                        m1867a(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                if (this.f2793k.getDecoratedStart(getChildAt(i3)) < end) {
                    m1867a(recycler, childCount - 1, i3);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private void m1878b(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!m1870a(state, anchorInfo) && !m1881c(recycler, state, anchorInfo)) {
            anchorInfo.mo5358b();
            anchorInfo.f2800a = this.f2789d ? state.getItemCount() - 1 : 0;
        }
    }

    /* renamed from: c */
    private int m1879c(RecyclerView.State state) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        mo5318b();
        OrientationHelper orientationHelper = this.f2793k;
        View a = m1862a(!this.f2790e, true);
        if (!this.f2790e) {
            z = true;
        }
        return ScrollbarHelper.m2183a(state, orientationHelper, a, m1874b(z, true), this, this.f2790e);
    }

    /* renamed from: c */
    private View m1880c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo5238a(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    /* renamed from: c */
    private boolean m1881c(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && anchorInfo.m1898a(focusedChild, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild);
            return true;
        } else if (this.f2787b != this.f2789d) {
            return false;
        } else {
            View a = anchorInfo.f2802c ? m1861a(recycler, state) : m1873b(recycler, state);
            if (a == null) {
                return false;
            }
            anchorInfo.assignFromView(a);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.f2793k.getDecoratedStart(a) >= this.f2793k.getEndAfterPadding() || this.f2793k.getDecoratedEnd(a) < this.f2793k.getStartAfterPadding()) {
                    z = true;
                }
                if (z) {
                    anchorInfo.f2801b = anchorInfo.f2802c ? this.f2793k.getEndAfterPadding() : this.f2793k.getStartAfterPadding();
                }
            }
            return true;
        }
    }

    /* renamed from: d */
    private int m1882d(RecyclerView.State state) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        mo5318b();
        OrientationHelper orientationHelper = this.f2793k;
        View a = m1862a(!this.f2790e, true);
        if (!this.f2790e) {
            z = true;
        }
        return ScrollbarHelper.m2185b(state, orientationHelper, a, m1874b(z, true), this, this.f2790e);
    }

    /* renamed from: d */
    private View m1883d(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return mo5238a(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    /* renamed from: e */
    private void m1884e() {
        boolean z = true;
        if (this.f2792j == 1 || !mo5316a()) {
            this.f2794l = this.f2788c;
            return;
        }
        if (this.f2788c) {
            z = false;
        }
        this.f2794l = z;
    }

    /* renamed from: f */
    private View m1885f() {
        return getChildAt(this.f2794l ? getChildCount() - 1 : 0);
    }

    /* renamed from: g */
    private View m1886g() {
        return getChildAt(this.f2794l ? 0 : getChildCount() - 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5312a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.f2786a.f2804a = true;
        mo5318b();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m1864a(i2, abs, true, state);
        int a = this.f2786a.f2810g + mo5313a(recycler, this.f2786a, state, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f2793k.offsetChildren(-i);
        this.f2786a.f2813j = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5313a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        int i = layoutState.f2806c;
        if (layoutState.f2810g != Integer.MIN_VALUE) {
            if (layoutState.f2806c < 0) {
                layoutState.f2810g += layoutState.f2806c;
            }
            m1868a(recycler, layoutState);
        }
        int i2 = layoutState.f2806c + layoutState.f2811h;
        LayoutChunkResult layoutChunkResult = new LayoutChunkResult();
        while (i2 > 0 && layoutState.mo5362a(state)) {
            layoutChunkResult.mo5360a();
            mo5240a(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.f2805b += layoutChunkResult.mConsumed * layoutState.f2809f;
                if (!layoutChunkResult.mIgnoreConsumed || this.f2786a.f2814k != null || !state.isPreLayout()) {
                    layoutState.f2806c -= layoutChunkResult.mConsumed;
                    i2 -= layoutChunkResult.mConsumed;
                }
                if (layoutState.f2810g != Integer.MIN_VALUE) {
                    layoutState.f2810g += layoutChunkResult.mConsumed;
                    if (layoutState.f2806c < 0) {
                        layoutState.f2810g += layoutState.f2806c;
                    }
                    m1868a(recycler, layoutState);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.f2806c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo5314a(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.f2793k.getTotalSpace();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5315a(int i, int i2, boolean z, boolean z2) {
        mo5318b();
        int startAfterPadding = this.f2793k.getStartAfterPadding();
        int endAfterPadding = this.f2793k.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int decoratedStart = this.f2793k.getDecoratedStart(childAt);
            int decoratedEnd = this.f2793k.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (!z) {
                    return childAt;
                }
                if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                    return childAt;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
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
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view3 == null) {
                        view = view2;
                        i += i4;
                        view2 = view;
                        view3 = childAt;
                    }
                } else if (this.f2793k.getDecoratedStart(childAt) < endAfterPadding && this.f2793k.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view2 == null) {
                        view = childAt;
                        childAt = view3;
                        i += i4;
                        view2 = view;
                        view3 = childAt;
                    }
                }
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
    public void mo5239a(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5240a(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int paddingTop;
        int decoratedMeasurementInOther;
        int i;
        int i2;
        int decoratedMeasurementInOther2;
        View a = layoutState.mo5361a(recycler);
        if (a == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a.getLayoutParams();
        if (layoutState.f2814k == null) {
            if (this.f2794l == (layoutState.f2809f == -1)) {
                addView(a);
            } else {
                addView(a, 0);
            }
        } else {
            if (this.f2794l == (layoutState.f2809f == -1)) {
                addDisappearingView(a);
            } else {
                addDisappearingView(a, 0);
            }
        }
        measureChildWithMargins(a, 0, 0);
        layoutChunkResult.mConsumed = this.f2793k.getDecoratedMeasurement(a);
        if (this.f2792j == 1) {
            if (mo5316a()) {
                decoratedMeasurementInOther2 = getWidth() - getPaddingRight();
                i = decoratedMeasurementInOther2 - this.f2793k.getDecoratedMeasurementInOther(a);
            } else {
                i = getPaddingLeft();
                decoratedMeasurementInOther2 = this.f2793k.getDecoratedMeasurementInOther(a) + i;
            }
            if (layoutState.f2809f == -1) {
                int i3 = layoutState.f2805b;
                paddingTop = layoutState.f2805b - layoutChunkResult.mConsumed;
                i2 = decoratedMeasurementInOther2;
                decoratedMeasurementInOther = i3;
            } else {
                paddingTop = layoutState.f2805b;
                i2 = decoratedMeasurementInOther2;
                decoratedMeasurementInOther = layoutState.f2805b + layoutChunkResult.mConsumed;
            }
        } else {
            paddingTop = getPaddingTop();
            decoratedMeasurementInOther = this.f2793k.getDecoratedMeasurementInOther(a) + paddingTop;
            if (layoutState.f2809f == -1) {
                int i4 = layoutState.f2805b;
                i = layoutState.f2805b - layoutChunkResult.mConsumed;
                i2 = i4;
            } else {
                i = layoutState.f2805b;
                i2 = layoutState.f2805b + layoutChunkResult.mConsumed;
            }
        }
        layoutDecorated(a, i + layoutParams.leftMargin, paddingTop + layoutParams.topMargin, i2 - layoutParams.rightMargin, decoratedMeasurementInOther - layoutParams.bottomMargin);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = a.isFocusable();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5316a() {
        return getLayoutDirection() == 1;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f2797o == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5318b() {
        if (this.f2786a == null) {
            this.f2786a = mo5319c();
        }
        if (this.f2793k == null) {
            this.f2793k = OrientationHelper.createOrientationHelper(this, this.f2792j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public LayoutState mo5319c() {
        return new LayoutState();
    }

    public boolean canScrollHorizontally() {
        return this.f2792j == 0;
    }

    public boolean canScrollVertically() {
        return this.f2792j == 1;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m1879c(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return m1872b(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return m1882d(state);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.f2794l) {
            i2 = -1;
        }
        return this.f2792j == 0 ? new PointF((float) i2, BitmapDescriptorFactory.HUE_RED) : new PointF(BitmapDescriptorFactory.HUE_RED, (float) i2);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m1879c(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return m1872b(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return m1882d(state);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View a = mo5315a(0, getChildCount(), true, false);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public int findFirstVisibleItemPosition() {
        View a = mo5315a(0, getChildCount(), false, true);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View a = mo5315a(getChildCount() - 1, -1, true, false);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public int findLastVisibleItemPosition() {
        View a = mo5315a(getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOrientation() {
        return this.f2792j;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f2791f;
    }

    public boolean getReverseLayout() {
        return this.f2788c;
    }

    public boolean getStackFromEnd() {
        return this.f2789d;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.f2790e;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f2791f) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int a;
        m1884e();
        if (getChildCount() == 0 || (a = m1859a(i)) == Integer.MIN_VALUE) {
            return null;
        }
        mo5318b();
        View b = a == -1 ? m1873b(recycler, state) : m1861a(recycler, state);
        if (b == null) {
            return null;
        }
        mo5318b();
        m1864a(a, (int) (0.33f * ((float) this.f2793k.getTotalSpace())), false, state);
        this.f2786a.f2810g = Integer.MIN_VALUE;
        this.f2786a.f2804a = false;
        mo5313a(recycler, this.f2786a, state, true);
        View f = a == -1 ? m1885f() : m1886g();
        if (f == b || !f.isFocusable()) {
            return null;
        }
        return f;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(findFirstVisibleItemPosition());
            asRecord.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        View findViewByPosition;
        int decoratedStart;
        if (!(this.f2797o == null && this.f2795m == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.f2797o != null && this.f2797o.mo5366a()) {
            this.f2795m = this.f2797o.f2815a;
        }
        mo5318b();
        this.f2786a.f2804a = false;
        m1884e();
        this.f2798p.mo5355a();
        this.f2798p.f2802c = this.f2794l ^ this.f2789d;
        m1878b(recycler, state, this.f2798p);
        int a = mo5314a(state);
        if (this.f2786a.f2813j >= 0) {
            i = 0;
        } else {
            i = a;
            a = 0;
        }
        int startAfterPadding = i + this.f2793k.getStartAfterPadding();
        int endPadding = a + this.f2793k.getEndPadding();
        if (!(!state.isPreLayout() || this.f2795m == -1 || this.f2796n == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(this.f2795m)) == null)) {
            if (this.f2794l) {
                decoratedStart = (this.f2793k.getEndAfterPadding() - this.f2793k.getDecoratedEnd(findViewByPosition)) - this.f2796n;
            } else {
                decoratedStart = this.f2796n - (this.f2793k.getDecoratedStart(findViewByPosition) - this.f2793k.getStartAfterPadding());
            }
            if (decoratedStart > 0) {
                startAfterPadding += decoratedStart;
            } else {
                endPadding -= decoratedStart;
            }
        }
        mo5239a(recycler, state, this.f2798p);
        detachAndScrapAttachedViews(recycler);
        this.f2786a.f2812i = state.isPreLayout();
        if (this.f2798p.f2802c) {
            m1876b(this.f2798p);
            this.f2786a.f2811h = startAfterPadding;
            mo5313a(recycler, this.f2786a, state, false);
            int i5 = this.f2786a.f2805b;
            int i6 = this.f2786a.f2807d;
            if (this.f2786a.f2806c > 0) {
                endPadding += this.f2786a.f2806c;
            }
            m1865a(this.f2798p);
            this.f2786a.f2811h = endPadding;
            this.f2786a.f2807d += this.f2786a.f2808e;
            mo5313a(recycler, this.f2786a, state, false);
            int i7 = this.f2786a.f2805b;
            if (this.f2786a.f2806c > 0) {
                int i8 = this.f2786a.f2806c;
                m1875b(i6, i5);
                this.f2786a.f2811h = i8;
                mo5313a(recycler, this.f2786a, state, false);
                i4 = this.f2786a.f2805b;
            } else {
                i4 = i5;
            }
            i3 = i4;
            i2 = i7;
        } else {
            m1865a(this.f2798p);
            this.f2786a.f2811h = endPadding;
            mo5313a(recycler, this.f2786a, state, false);
            i2 = this.f2786a.f2805b;
            int i9 = this.f2786a.f2807d;
            if (this.f2786a.f2806c > 0) {
                startAfterPadding += this.f2786a.f2806c;
            }
            m1876b(this.f2798p);
            this.f2786a.f2811h = startAfterPadding;
            this.f2786a.f2807d += this.f2786a.f2808e;
            mo5313a(recycler, this.f2786a, state, false);
            i3 = this.f2786a.f2805b;
            if (this.f2786a.f2806c > 0) {
                int i10 = this.f2786a.f2806c;
                m1863a(i9, i2);
                this.f2786a.f2811h = i10;
                mo5313a(recycler, this.f2786a, state, false);
                i2 = this.f2786a.f2805b;
            }
        }
        if (getChildCount() > 0) {
            if (this.f2794l ^ this.f2789d) {
                int a2 = m1860a(i2, recycler, state, true);
                int i11 = i3 + a2;
                int b = m1871b(i11, recycler, state, false);
                i3 = i11 + b;
                i2 = i2 + a2 + b;
            } else {
                int b2 = m1871b(i3, recycler, state, true);
                int i12 = i2 + b2;
                int a3 = m1860a(i12, recycler, state, false);
                i3 = i3 + b2 + a3;
                i2 = i12 + a3;
            }
        }
        m1869a(recycler, state, i3, i2);
        if (!state.isPreLayout()) {
            this.f2795m = -1;
            this.f2796n = Integer.MIN_VALUE;
            this.f2793k.onLayoutComplete();
        }
        this.f2787b = this.f2789d;
        this.f2797o = null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2797o = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f2797o != null) {
            return new SavedState(this.f2797o);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            mo5318b();
            boolean z = this.f2787b ^ this.f2794l;
            savedState.f2817c = z;
            if (z) {
                View g = m1886g();
                savedState.f2816b = this.f2793k.getEndAfterPadding() - this.f2793k.getDecoratedEnd(g);
                savedState.f2815a = getPosition(g);
                return savedState;
            }
            View f = m1885f();
            savedState.f2815a = getPosition(f);
            savedState.f2816b = this.f2793k.getDecoratedStart(f) - this.f2793k.getStartAfterPadding();
            return savedState;
        }
        savedState.mo5367b();
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        mo5318b();
        m1884e();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        boolean z = position < position2 ? true : true;
        if (this.f2794l) {
            if (z) {
                scrollToPositionWithOffset(position2, this.f2793k.getEndAfterPadding() - (this.f2793k.getDecoratedStart(view2) + this.f2793k.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.f2793k.getEndAfterPadding() - this.f2793k.getDecoratedEnd(view2));
            }
        } else if (z) {
            scrollToPositionWithOffset(position2, this.f2793k.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.f2793k.getDecoratedEnd(view2) - this.f2793k.getDecoratedMeasurement(view));
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f2792j == 1) {
            return 0;
        }
        return mo5312a(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        this.f2795m = i;
        this.f2796n = Integer.MIN_VALUE;
        if (this.f2797o != null) {
            this.f2797o.mo5367b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.f2795m = i;
        this.f2796n = i2;
        if (this.f2797o != null) {
            this.f2797o.mo5367b();
        }
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f2792j == 0) {
            return 0;
        }
        return mo5312a(i, recycler, state);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.f2792j) {
                this.f2792j = i;
                this.f2793k = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.f2791f = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.f2788c) {
            this.f2788c = z;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.f2790e = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.f2789d != z) {
            this.f2789d = z;
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        C02971 r0 = new LinearSmoothScroller(recyclerView.getContext()) {
            public PointF computeScrollVectorForPosition(int i) {
                return LinearLayoutManager.this.computeScrollVectorForPosition(i);
            }
        };
        r0.setTargetPosition(i);
        startSmoothScroll(r0);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f2797o == null && this.f2787b == this.f2789d;
    }
}
