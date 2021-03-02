package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.p002os.TraceCompat;
import android.support.p000v4.util.ArrayMap;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.NestedScrollingChild;
import android.support.p000v4.view.NestedScrollingChildHelper;
import android.support.p000v4.view.ScrollingView;
import android.support.p000v4.view.VelocityTrackerCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p000v4.widget.EdgeEffectCompat;
import android.support.p000v4.widget.ScrollerCompat;
import android.support.p003v7.recyclerview.C0273R;
import android.support.p003v7.widget.AdapterHelper;
import android.support.p003v7.widget.ChildHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v7.widget.RecyclerView */
public class RecyclerView extends ViewGroup implements NestedScrollingChild, ScrollingView {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_TYPE = -1;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public static final Interpolator f2899an = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final boolean f2900h = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);

    /* renamed from: i */
    private static final Class<?>[] f2901i = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};

    /* renamed from: A */
    private boolean f2902A;

    /* renamed from: B */
    private int f2903B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f2904C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final boolean f2905D;

    /* renamed from: E */
    private final AccessibilityManager f2906E;

    /* renamed from: F */
    private List<OnChildAttachStateChangeListener> f2907F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f2908G;

    /* renamed from: H */
    private int f2909H;

    /* renamed from: I */
    private EdgeEffectCompat f2910I;

    /* renamed from: J */
    private EdgeEffectCompat f2911J;

    /* renamed from: K */
    private EdgeEffectCompat f2912K;

    /* renamed from: L */
    private EdgeEffectCompat f2913L;

    /* renamed from: M */
    private int f2914M;

    /* renamed from: N */
    private int f2915N;

    /* renamed from: O */
    private VelocityTracker f2916O;

    /* renamed from: P */
    private int f2917P;

    /* renamed from: Q */
    private int f2918Q;

    /* renamed from: R */
    private int f2919R;

    /* renamed from: S */
    private int f2920S;

    /* renamed from: T */
    private int f2921T;

    /* renamed from: U */
    private final int f2922U;

    /* renamed from: V */
    private final int f2923V;

    /* renamed from: W */
    private float f2924W;

    /* renamed from: a */
    final Recycler f2925a;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public final ViewFlinger f2926aa;

    /* renamed from: ab */
    private OnScrollListener f2927ab;

    /* renamed from: ac */
    private List<OnScrollListener> f2928ac;

    /* renamed from: ad */
    private ItemAnimator.ItemAnimatorListener f2929ad;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public boolean f2930ae;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public RecyclerViewAccessibilityDelegate f2931af;

    /* renamed from: ag */
    private ChildDrawingOrderCallback f2932ag;

    /* renamed from: ah */
    private final int[] f2933ah;

    /* renamed from: ai */
    private final NestedScrollingChildHelper f2934ai;

    /* renamed from: aj */
    private final int[] f2935aj;

    /* renamed from: ak */
    private final int[] f2936ak;

    /* renamed from: al */
    private final int[] f2937al;

    /* renamed from: am */
    private Runnable f2938am;

    /* renamed from: b */
    AdapterHelper f2939b;

    /* renamed from: c */
    ChildHelper f2940c;

    /* renamed from: d */
    ItemAnimator f2941d;

    /* renamed from: e */
    final State f2942e;

    /* renamed from: f */
    boolean f2943f;

    /* renamed from: g */
    boolean f2944g;

    /* renamed from: j */
    private final RecyclerViewDataObserver f2945j;

    /* renamed from: k */
    private SavedState f2946k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2947l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Runnable f2948m;

    /* renamed from: n */
    private final Rect f2949n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Adapter f2950o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LayoutManager f2951p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public RecyclerListener f2952q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final ArrayList<ItemDecoration> f2953r;

    /* renamed from: s */
    private final ArrayList<OnItemTouchListener> f2954s;

    /* renamed from: t */
    private OnItemTouchListener f2955t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f2956u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f2957v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f2958w;

    /* renamed from: x */
    private boolean f2959x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f2960y;

    /* renamed from: z */
    private boolean f2961z;

    /* renamed from: android.support.v7.widget.RecyclerView$Adapter */
    public abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a */
        private final AdapterDataObservable f2966a = new AdapterDataObservable();

        /* renamed from: b */
        private boolean f2967b = false;

        public final void bindViewHolder(VH vh, int i) {
            vh.f3038a = i;
            if (hasStableIds()) {
                vh.f3040c = getItemId(i);
            }
            vh.mo5908a(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            onBindViewHolder(vh, i, vh.mo5938r());
            vh.mo5937q();
            TraceCompat.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            TraceCompat.beginSection("RV CreateView");
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
            onCreateViewHolder.f3041d = i;
            TraceCompat.endSection();
            return onCreateViewHolder;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.f2966a.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.f2967b;
        }

        public final void notifyDataSetChanged() {
            this.f2966a.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.f2966a.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.f2966a.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemInserted(int i) {
            this.f2966a.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.f2966a.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.f2966a.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.f2966a.notifyItemRangeChanged(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.f2966a.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.f2966a.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.f2966a.notifyItemRangeRemoved(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.f2966a.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f2967b = z;
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.f2966a.unregisterObserver(adapterDataObserver);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$AdapterDataObservable */
    class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, (Object) null);
        }

        public void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$AdapterDataObserver */
    public abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ChildDrawingOrderCallback */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ItemAnimator */
    public abstract class ItemAnimator {

        /* renamed from: a */
        private ItemAnimatorListener f2968a = null;

        /* renamed from: b */
        private ArrayList<ItemAnimatorFinishedListener> f2969b = new ArrayList<>();

        /* renamed from: c */
        private long f2970c = 120;

        /* renamed from: d */
        private long f2971d = 120;

        /* renamed from: e */
        private long f2972e = 250;

        /* renamed from: f */
        private long f2973f = 250;

        /* renamed from: g */
        private boolean f2974g = true;

        /* renamed from: android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* renamed from: android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorListener */
        interface ItemAnimatorListener {
            void onAddFinished(ViewHolder viewHolder);

            void onChangeFinished(ViewHolder viewHolder);

            void onMoveFinished(ViewHolder viewHolder);

            void onRemoveFinished(ViewHolder viewHolder);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5663a(ItemAnimatorListener itemAnimatorListener) {
            this.f2968a = itemAnimatorListener;
        }

        public abstract boolean animateAdd(ViewHolder viewHolder);

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4);

        public abstract boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4);

        public abstract boolean animateRemove(ViewHolder viewHolder);

        public final void dispatchAddFinished(ViewHolder viewHolder) {
            onAddFinished(viewHolder);
            if (this.f2968a != null) {
                this.f2968a.onAddFinished(viewHolder);
            }
        }

        public final void dispatchAddStarting(ViewHolder viewHolder) {
            onAddStarting(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.f2969b.size();
            for (int i = 0; i < size; i++) {
                this.f2969b.get(i).onAnimationsFinished();
            }
            this.f2969b.clear();
        }

        public final void dispatchChangeFinished(ViewHolder viewHolder, boolean z) {
            onChangeFinished(viewHolder, z);
            if (this.f2968a != null) {
                this.f2968a.onChangeFinished(viewHolder);
            }
        }

        public final void dispatchChangeStarting(ViewHolder viewHolder, boolean z) {
            onChangeStarting(viewHolder, z);
        }

        public final void dispatchMoveFinished(ViewHolder viewHolder) {
            onMoveFinished(viewHolder);
            if (this.f2968a != null) {
                this.f2968a.onMoveFinished(viewHolder);
            }
        }

        public final void dispatchMoveStarting(ViewHolder viewHolder) {
            onMoveStarting(viewHolder);
        }

        public final void dispatchRemoveFinished(ViewHolder viewHolder) {
            onRemoveFinished(viewHolder);
            if (this.f2968a != null) {
                this.f2968a.onRemoveFinished(viewHolder);
            }
        }

        public final void dispatchRemoveStarting(ViewHolder viewHolder) {
            onRemoveStarting(viewHolder);
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.f2970c;
        }

        public long getChangeDuration() {
            return this.f2973f;
        }

        public long getMoveDuration() {
            return this.f2972e;
        }

        public long getRemoveDuration() {
            return this.f2971d;
        }

        public boolean getSupportsChangeAnimations() {
            return this.f2974g;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.f2969b.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        public void onAddFinished(ViewHolder viewHolder) {
        }

        public void onAddStarting(ViewHolder viewHolder) {
        }

        public void onChangeFinished(ViewHolder viewHolder, boolean z) {
        }

        public void onChangeStarting(ViewHolder viewHolder, boolean z) {
        }

        public void onMoveFinished(ViewHolder viewHolder) {
        }

        public void onMoveStarting(ViewHolder viewHolder) {
        }

        public void onRemoveFinished(ViewHolder viewHolder) {
        }

        public void onRemoveStarting(ViewHolder viewHolder) {
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.f2970c = j;
        }

        public void setChangeDuration(long j) {
            this.f2973f = j;
        }

        public void setMoveDuration(long j) {
            this.f2972e = j;
        }

        public void setRemoveDuration(long j) {
            this.f2971d = j;
        }

        public void setSupportsChangeAnimations(boolean z) {
            this.f2974g = z;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ItemAnimatorRestoreListener */
    class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        private ItemAnimatorRestoreListener() {
        }

        public void onAddFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (!viewHolder.m2152w()) {
                boolean unused = RecyclerView.this.m1987c(viewHolder.itemView);
            }
        }

        public void onChangeFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.f3043f != null && viewHolder.f3044g == null) {
                viewHolder.f3043f = null;
                viewHolder.mo5908a(-65, viewHolder.f3048k);
            }
            viewHolder.f3044g = null;
            if (!viewHolder.m2152w()) {
                boolean unused = RecyclerView.this.m1987c(viewHolder.itemView);
            }
        }

        public void onMoveFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (!viewHolder.m2152w()) {
                boolean unused = RecyclerView.this.m1987c(viewHolder.itemView);
            }
        }

        public void onRemoveFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (!RecyclerView.this.m1987c(viewHolder.itemView) && viewHolder.mo5935o()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ItemDecoration */
    public abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ItemHolderInfo */
    class ItemHolderInfo {

        /* renamed from: a */
        ViewHolder f2976a;

        /* renamed from: b */
        int f2977b;

        /* renamed from: c */
        int f2978c;

        /* renamed from: d */
        int f2979d;

        /* renamed from: e */
        int f2980e;

        ItemHolderInfo(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.f2976a = viewHolder;
            this.f2977b = i;
            this.f2978c = i2;
            this.f2979d = i3;
            this.f2980e = i4;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$LayoutManager */
    public abstract class LayoutManager {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f2981a = false;

        /* renamed from: b */
        private boolean f2982b = false;

        /* renamed from: q */
        ChildHelper f2983q;

        /* renamed from: r */
        RecyclerView f2984r;

        /* renamed from: s */
        SmoothScroller f2985s;

        /* renamed from: android.support.v7.widget.RecyclerView$LayoutManager$Properties */
        public class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        /* renamed from: a */
        private void m2053a(int i, View view) {
            this.f2983q.mo5202d(i);
        }

        /* renamed from: a */
        private void m2055a(Recycler recycler, int i, View view) {
            ViewHolder a = RecyclerView.m1956a(view);
            if (!a.mo5916c()) {
                if (!a.mo5930j() || a.mo5934n() || a.mo5932l() || this.f2984r.f2950o.hasStableIds()) {
                    detachViewAt(i);
                    recycler.mo5835b(view);
                    return;
                }
                removeViewAt(i);
                recycler.mo5834b(a);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2056a(SmoothScroller smoothScroller) {
            if (this.f2985s == smoothScroller) {
                this.f2985s = null;
            }
        }

        /* renamed from: a */
        private void m2057a(View view, int i, boolean z) {
            ViewHolder a = RecyclerView.m1956a(view);
            if (z || a.mo5934n()) {
                this.f2984r.f2942e.mo5885b(view);
            } else {
                this.f2984r.f2942e.mo5884a(view);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (a.mo5919f() || a.mo5917d()) {
                if (a.mo5917d()) {
                    a.mo5918e();
                } else {
                    a.mo5920g();
                }
                this.f2983q.mo5193a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f2984r) {
                int b = this.f2983q.mo5197b(view);
                if (i == -1) {
                    i = this.f2983q.mo5196b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2984r.indexOfChild(view));
                } else if (b != i) {
                    this.f2984r.f2951p.moveView(b, i);
                }
            } else {
                this.f2983q.mo5194a(view, i, false);
                layoutParams.f2988c = true;
                if (this.f2985s != null && this.f2985s.isRunning()) {
                    this.f2985s.mo5861a(view);
                }
            }
            if (layoutParams.f2989d) {
                a.itemView.invalidate();
                layoutParams.f2989d = false;
            }
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = 1073741824;
            int max = Math.max(0, i - i2);
            if (z) {
                if (i3 < 0) {
                    i4 = 0;
                    i3 = 0;
                }
            } else if (i3 < 0) {
                if (i3 == -1) {
                    i3 = max;
                } else if (i3 == -2) {
                    i4 = Integer.MIN_VALUE;
                    i3 = max;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i4);
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0273R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(C0273R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(C0273R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(C0273R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(C0273R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5703a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            onInitializeAccessibilityNodeInfo(this.f2984r.f2925a, this.f2984r.f2942e, accessibilityNodeInfoCompat);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5704a(Recycler recycler) {
            int b = recycler.mo5830b();
            for (int i = b - 1; i >= 0; i--) {
                View b2 = recycler.mo5831b(i);
                ViewHolder a = RecyclerView.m1956a(b2);
                if (!a.mo5916c()) {
                    a.setIsRecyclable(false);
                    if (a.mo5935o()) {
                        this.f2984r.removeDetachedView(b2, false);
                    }
                    if (this.f2984r.f2941d != null) {
                        this.f2984r.f2941d.endAnimation(a);
                    }
                    a.setIsRecyclable(true);
                    recycler.mo5828a(b2);
                }
            }
            recycler.mo5838c();
            if (b > 0) {
                this.f2984r.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5705a(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2984r = null;
                this.f2983q = null;
                return;
            }
            this.f2984r = recyclerView;
            this.f2983q = recyclerView.f2940c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5706a(RecyclerView recyclerView, Recycler recycler) {
            this.f2982b = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5707a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder a = RecyclerView.m1956a(view);
            if (a != null && !a.mo5934n() && !this.f2983q.mo5201c(a.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.f2984r.f2925a, this.f2984r.f2942e, view, accessibilityNodeInfoCompat);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5708a(int i, Bundle bundle) {
            return performAccessibilityAction(this.f2984r.f2925a, this.f2984r.f2942e, i, bundle);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5709a(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.f2984r.f2925a, this.f2984r.f2942e, view, i, bundle);
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            m2057a(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            m2057a(view, i, false);
        }

        public void assertInLayoutOrScroll(String str) {
            if (this.f2984r != null) {
                this.f2984r.mo5506a(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            if (this.f2984r != null) {
                this.f2984r.mo5519b(str);
            }
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder a = RecyclerView.m1956a(view);
            if (a.mo5934n()) {
                this.f2984r.f2942e.mo5885b(view);
            } else {
                this.f2984r.f2942e.mo5884a(view);
            }
            this.f2983q.mo5193a(view, i, layoutParams, a.mo5934n());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5718b(RecyclerView recyclerView) {
            this.f2982b = true;
            onAttachedToWindow(recyclerView);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            if (this.f2984r == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f2984r.mo5516b(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5720d() {
            if (this.f2985s != null) {
                this.f2985s.mo5862e();
            }
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                m2055a(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            m2055a(recycler, this.f2983q.mo5197b(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            m2055a(recycler, i, getChildAt(i));
        }

        public void detachView(View view) {
            int b = this.f2983q.mo5197b(view);
            if (b >= 0) {
                m2053a(b, view);
            }
        }

        public void detachViewAt(int i) {
            m2053a(i, getChildAt(i));
        }

        public void endAnimation(View view) {
            if (this.f2984r.f2941d != null) {
                this.f2984r.f2941d.endAnimation(RecyclerView.m1956a(view));
            }
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder a = RecyclerView.m1956a(childAt);
                if (a != null && a.getLayoutPosition() == i && !a.mo5916c() && (this.f2984r.f2942e.isPreLayout() || !a.mo5934n())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2987b.bottom;
        }

        public View getChildAt(int i) {
            if (this.f2983q != null) {
                return this.f2983q.mo5198b(i);
            }
            return null;
        }

        public int getChildCount() {
            if (this.f2983q != null) {
                return this.f2983q.mo5196b();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            return this.f2984r != null && this.f2984r.f2947l;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            if (this.f2984r == null || this.f2984r.f2950o == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.f2984r.f2950o.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2987b;
            return rect.bottom + view.getMeasuredHeight() + rect.top;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2987b;
            return rect.right + view.getMeasuredWidth() + rect.left;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            if (this.f2984r == null || (focusedChild = this.f2984r.getFocusedChild()) == null || this.f2983q.mo5201c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            if (this.f2984r != null) {
                return this.f2984r.getHeight();
            }
            return 0;
        }

        public int getItemCount() {
            Adapter adapter = this.f2984r != null ? this.f2984r.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.m1956a(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.f2984r);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2987b.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.f2984r);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.f2984r);
        }

        public int getPaddingBottom() {
            if (this.f2984r != null) {
                return this.f2984r.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            if (this.f2984r != null) {
                return ViewCompat.getPaddingEnd(this.f2984r);
            }
            return 0;
        }

        public int getPaddingLeft() {
            if (this.f2984r != null) {
                return this.f2984r.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            if (this.f2984r != null) {
                return this.f2984r.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            if (this.f2984r != null) {
                return ViewCompat.getPaddingStart(this.f2984r);
            }
            return 0;
        }

        public int getPaddingTop() {
            if (this.f2984r != null) {
                return this.f2984r.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2987b.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            if (this.f2984r == null || this.f2984r.f2950o == null || !canScrollVertically()) {
                return 1;
            }
            return this.f2984r.f2950o.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2987b.top;
        }

        public int getWidth() {
            if (this.f2984r != null) {
                return this.f2984r.getWidth();
            }
            return 0;
        }

        public boolean hasFocus() {
            return this.f2984r != null && this.f2984r.hasFocus();
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.f2984r || this.f2984r.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            }
            ViewHolder a = RecyclerView.m1956a(view);
            a.mo5915b(128);
            this.f2984r.f2942e.onViewIgnored(a);
        }

        public boolean isAttachedToWindow() {
            return this.f2982b;
        }

        public boolean isFocused() {
            return this.f2984r != null && this.f2984r.isFocused();
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isSmoothScrolling() {
            return this.f2985s != null && this.f2985s.isRunning();
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2987b;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect b = this.f2984r.mo5516b(view);
            view.measure(getChildMeasureSpec(getWidth(), b.left + b.right + i + getPaddingLeft() + getPaddingRight(), layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), b.bottom + b.top + i2 + getPaddingTop() + getPaddingBottom(), layoutParams.height, canScrollVertically()));
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect b = this.f2984r.mo5516b(view);
            view.measure(getChildMeasureSpec(getWidth(), b.left + b.right + i + getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), b.bottom + b.top + i2 + getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height, canScrollVertically()));
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            detachViewAt(i);
            attachView(childAt, i2);
        }

        public void offsetChildrenHorizontal(int i) {
            if (this.f2984r != null) {
                this.f2984r.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            if (this.f2984r != null) {
                this.f2984r.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            if (this.f2984r != null && asRecord != null) {
                if (!ViewCompat.canScrollVertically(this.f2984r, 1) && !ViewCompat.canScrollVertically(this.f2984r, -1) && !ViewCompat.canScrollHorizontally(this.f2984r, -1) && !ViewCompat.canScrollHorizontally(this.f2984r, 1)) {
                    z = false;
                }
                asRecord.setScrollable(z);
                if (this.f2984r.f2950o != null) {
                    asRecord.setItemCount(this.f2984r.f2950o.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.f2984r.f2925a, this.f2984r.f2942e, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.canScrollVertically(this.f2984r, -1) || ViewCompat.canScrollHorizontally(this.f2984r, -1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.f2984r, 1) || ViewCompat.canScrollHorizontally(this.f2984r, 1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.f2984r.m1994f(i, i2);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
            r3 = r0;
            r0 = 0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(android.support.p003v7.widget.RecyclerView.Recycler r7, android.support.p003v7.widget.RecyclerView.State r8, int r9, android.os.Bundle r10) {
            /*
                r6 = this;
                r4 = -1
                r2 = 1
                r1 = 0
                android.support.v7.widget.RecyclerView r0 = r6.f2984r
                if (r0 != 0) goto L_0x0008
            L_0x0007:
                return r1
            L_0x0008:
                switch(r9) {
                    case 4096: goto L_0x004a;
                    case 8192: goto L_0x0018;
                    default: goto L_0x000b;
                }
            L_0x000b:
                r0 = r1
                r3 = r1
            L_0x000d:
                if (r3 != 0) goto L_0x0011
                if (r0 == 0) goto L_0x0007
            L_0x0011:
                android.support.v7.widget.RecyclerView r1 = r6.f2984r
                r1.scrollBy(r0, r3)
                r1 = r2
                goto L_0x0007
            L_0x0018:
                android.support.v7.widget.RecyclerView r0 = r6.f2984r
                boolean r0 = android.support.p000v4.view.ViewCompat.canScrollVertically(r0, r4)
                if (r0 == 0) goto L_0x007f
                int r0 = r6.getHeight()
                int r3 = r6.getPaddingTop()
                int r0 = r0 - r3
                int r3 = r6.getPaddingBottom()
                int r0 = r0 - r3
                int r0 = -r0
            L_0x002f:
                android.support.v7.widget.RecyclerView r3 = r6.f2984r
                boolean r3 = android.support.p000v4.view.ViewCompat.canScrollHorizontally(r3, r4)
                if (r3 == 0) goto L_0x007a
                int r3 = r6.getWidth()
                int r4 = r6.getPaddingLeft()
                int r3 = r3 - r4
                int r4 = r6.getPaddingRight()
                int r3 = r3 - r4
                int r3 = -r3
                r5 = r3
                r3 = r0
                r0 = r5
                goto L_0x000d
            L_0x004a:
                android.support.v7.widget.RecyclerView r0 = r6.f2984r
                boolean r0 = android.support.p000v4.view.ViewCompat.canScrollVertically(r0, r2)
                if (r0 == 0) goto L_0x007d
                int r0 = r6.getHeight()
                int r3 = r6.getPaddingTop()
                int r0 = r0 - r3
                int r3 = r6.getPaddingBottom()
                int r0 = r0 - r3
            L_0x0060:
                android.support.v7.widget.RecyclerView r3 = r6.f2984r
                boolean r3 = android.support.p000v4.view.ViewCompat.canScrollHorizontally(r3, r2)
                if (r3 == 0) goto L_0x007a
                int r3 = r6.getWidth()
                int r4 = r6.getPaddingLeft()
                int r3 = r3 - r4
                int r4 = r6.getPaddingRight()
                int r3 = r3 - r4
                r5 = r3
                r3 = r0
                r0 = r5
                goto L_0x000d
            L_0x007a:
                r3 = r0
                r0 = r1
                goto L_0x000d
            L_0x007d:
                r0 = r1
                goto L_0x0060
            L_0x007f:
                r0 = r1
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.RecyclerView.LayoutManager.performAccessibilityAction(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            if (this.f2984r != null) {
                ViewCompat.postOnAnimation(this.f2984r, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.f2983q.mo5191a(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.m1956a(getChildAt(childCount)).mo5916c()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            if (this.f2984r != null) {
                return this.f2984r.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.f2984r.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.f2983q.mo5192a(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.f2983q.mo5191a(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int min;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = view.getLeft() + rect.left;
            int top = view.getTop() + rect.top;
            int width2 = left + rect.width();
            int height2 = top + rect.height();
            int min2 = Math.min(0, left - paddingLeft);
            int min3 = Math.min(0, top - paddingTop);
            int max = Math.max(0, width2 - width);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min2, width2 - width);
                }
                min = max;
            } else {
                min = min2 != 0 ? min2 : Math.min(left - paddingLeft, max);
            }
            int min4 = min3 != 0 ? min3 : Math.min(top - paddingTop, max2);
            if (min == 0 && min4 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(min, min4);
            } else {
                recyclerView.smoothScrollBy(min, min4);
            }
            return true;
        }

        public void requestLayout() {
            if (this.f2984r != null) {
                this.f2984r.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.f2981a = true;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void setMeasuredDimension(int i, int i2) {
            this.f2984r.setMeasuredDimension(i, i2);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            if (!(this.f2985s == null || smoothScroller == this.f2985s || !this.f2985s.isRunning())) {
                this.f2985s.mo5862e();
            }
            this.f2985s = smoothScroller;
            this.f2985s.mo5860a(this.f2984r, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder a = RecyclerView.m1956a(view);
            a.mo5928i();
            a.mo5939s();
            a.mo5915b(4);
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$LayoutParams */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        ViewHolder f2986a;

        /* renamed from: b */
        final Rect f2987b = new Rect();

        /* renamed from: c */
        boolean f2988c = true;

        /* renamed from: d */
        boolean f2989d = false;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int getViewAdapterPosition() {
            return this.f2986a.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.f2986a.getLayoutPosition();
        }

        public int getViewPosition() {
            return this.f2986a.getPosition();
        }

        public boolean isItemChanged() {
            return this.f2986a.mo5932l();
        }

        public boolean isItemRemoved() {
            return this.f2986a.mo5934n();
        }

        public boolean isViewInvalid() {
            return this.f2986a.mo5930j();
        }

        public boolean viewNeedsUpdate() {
            return this.f2986a.mo5931k();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$OnItemTouchListener */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$OnScrollListener */
    public abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$RecycledViewPool */
    public class RecycledViewPool {

        /* renamed from: a */
        private SparseArray<ArrayList<ViewHolder>> f2990a = new SparseArray<>();

        /* renamed from: b */
        private SparseIntArray f2991b = new SparseIntArray();

        /* renamed from: c */
        private int f2992c = 0;

        /* renamed from: a */
        private ArrayList<ViewHolder> m2069a(int i) {
            ArrayList<ViewHolder> arrayList = this.f2990a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f2990a.put(i, arrayList);
                if (this.f2991b.indexOfKey(i) < 0) {
                    this.f2991b.put(i, 5);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5812a() {
            this.f2992c--;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5813a(Adapter adapter) {
            this.f2992c++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5814a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                mo5812a();
            }
            if (!z && this.f2992c == 0) {
                clear();
            }
            if (adapter2 != null) {
                mo5813a(adapter2);
            }
        }

        public void clear() {
            this.f2990a.clear();
        }

        public ViewHolder getRecycledView(int i) {
            ArrayList arrayList = this.f2990a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            arrayList.remove(size);
            return viewHolder;
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> a = m2069a(itemViewType);
            if (this.f2991b.get(itemViewType) > a.size()) {
                viewHolder.mo5939s();
                a.add(viewHolder);
            }
        }

        public void setMaxRecycledViews(int i, int i2) {
            this.f2991b.put(i, i2);
            ArrayList arrayList = this.f2990a.get(i);
            if (arrayList != null) {
                while (arrayList.size() > i2) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$Recycler */
    public final class Recycler {

        /* renamed from: a */
        final ArrayList<ViewHolder> f2993a = new ArrayList<>();

        /* renamed from: b */
        final ArrayList<ViewHolder> f2994b = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public ArrayList<ViewHolder> f2996d = null;

        /* renamed from: e */
        private final List<ViewHolder> f2997e = Collections.unmodifiableList(this.f2993a);

        /* renamed from: f */
        private int f2998f = 2;

        /* renamed from: g */
        private RecycledViewPool f2999g;

        /* renamed from: h */
        private ViewCacheExtension f3000h;

        public Recycler() {
        }

        /* renamed from: a */
        private void m2074a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m2074a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* renamed from: c */
        private void m2075c(View view) {
            if (RecyclerView.this.mo5559h()) {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.f2931af.mo5942b());
                }
            }
        }

        /* renamed from: f */
        private void m2076f(ViewHolder viewHolder) {
            if (viewHolder.itemView instanceof ViewGroup) {
                m2074a((ViewGroup) viewHolder.itemView, false);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ViewHolder mo5819a(int i, int i2, boolean z) {
            View a;
            ViewHolder viewHolder;
            int i3 = 0;
            int size = this.f2993a.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                viewHolder = this.f2993a.get(i4);
                if (viewHolder.mo5919f() || viewHolder.getLayoutPosition() != i || viewHolder.mo5930j() || (!RecyclerView.this.f2942e.f3027k && viewHolder.mo5934n())) {
                    i4++;
                }
            }
            if (i2 == -1 || viewHolder.getItemViewType() == i2) {
                viewHolder.mo5915b(32);
                return viewHolder;
            }
            Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + viewHolder.getItemViewType() + " but expected " + i2 + ")");
            if (!z && (a = RecyclerView.this.f2940c.mo5189a(i, i2)) != null) {
                RecyclerView.this.f2941d.endAnimation(RecyclerView.this.getChildViewHolder(a));
            }
            int size2 = this.f2994b.size();
            while (i3 < size2) {
                ViewHolder viewHolder2 = this.f2994b.get(i3);
                if (viewHolder2.mo5930j() || viewHolder2.getLayoutPosition() != i) {
                    i3++;
                } else if (z) {
                    return viewHolder2;
                } else {
                    this.f2994b.remove(i3);
                    return viewHolder2;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public ViewHolder mo5820a(long j, int i, boolean z) {
            for (int size = this.f2993a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f2993a.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.mo5919f()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.mo5915b(32);
                        if (!viewHolder.mo5934n() || RecyclerView.this.f2942e.isPreLayout()) {
                            return viewHolder;
                        }
                        viewHolder.mo5908a(2, 14);
                        return viewHolder;
                    } else if (!z) {
                        this.f2993a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        mo5828a(viewHolder.itemView);
                    }
                }
            }
            for (int size2 = this.f2994b.size() - 1; size2 >= 0; size2--) {
                ViewHolder viewHolder2 = this.f2994b.get(size2);
                if (viewHolder2.getItemId() == j) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (z) {
                            return viewHolder2;
                        }
                        this.f2994b.remove(size2);
                        return viewHolder2;
                    } else if (!z) {
                        mo5823a(size2);
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0171  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x017c  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0194  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01ce  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View mo5821a(int r10, boolean r11) {
            /*
                r9 = this;
                r3 = 0
                r1 = 1
                r2 = 0
                if (r10 < 0) goto L_0x000f
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r0 = r0.f2942e
                int r0 = r0.getItemCount()
                if (r10 < r0) goto L_0x0044
            L_0x000f:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r10)
                java.lang.String r2 = "("
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r10)
                java.lang.String r2 = "). Item count:"
                java.lang.StringBuilder r1 = r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r2 = r2.f2942e
                int r2 = r2.getItemCount()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0044:
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r0 = r0.f2942e
                boolean r0 = r0.isPreLayout()
                if (r0 == 0) goto L_0x01f2
                android.support.v7.widget.RecyclerView$ViewHolder r4 = r9.mo5837c((int) r10)
                if (r4 == 0) goto L_0x00d5
                r0 = r1
            L_0x0055:
                r8 = r4
                r4 = r0
                r0 = r8
            L_0x0058:
                if (r0 != 0) goto L_0x01ef
                r0 = -1
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r9.mo5819a((int) r10, (int) r0, (boolean) r11)
                if (r0 == 0) goto L_0x01ef
                boolean r5 = r9.mo5829a((android.support.p003v7.widget.RecyclerView.ViewHolder) r0)
                if (r5 != 0) goto L_0x00e2
                if (r11 != 0) goto L_0x0080
                r5 = 4
                r0.mo5915b((int) r5)
                boolean r5 = r0.mo5917d()
                if (r5 == 0) goto L_0x00d8
                android.support.v7.widget.RecyclerView r5 = android.support.p003v7.widget.RecyclerView.this
                android.view.View r6 = r0.itemView
                r5.removeDetachedView(r6, r2)
                r0.mo5918e()
            L_0x007d:
                r9.mo5834b((android.support.p003v7.widget.RecyclerView.ViewHolder) r0)
            L_0x0080:
                r0 = r3
                r3 = r4
            L_0x0082:
                if (r0 != 0) goto L_0x01eb
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.AdapterHelper r4 = r4.f2939b
                int r4 = r4.mo5068a((int) r10)
                if (r4 < 0) goto L_0x009a
                android.support.v7.widget.RecyclerView r5 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r5 = r5.f2950o
                int r5 = r5.getItemCount()
                if (r4 < r5) goto L_0x00e4
            L_0x009a:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r10)
                java.lang.String r2 = "(offset:"
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r4)
                java.lang.String r2 = ")."
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = "state:"
                java.lang.StringBuilder r1 = r1.append(r2)
                android.support.v7.widget.RecyclerView r2 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r2 = r2.f2942e
                int r2 = r2.getItemCount()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00d5:
                r0 = r2
                goto L_0x0055
            L_0x00d8:
                boolean r5 = r0.mo5919f()
                if (r5 == 0) goto L_0x007d
                r0.mo5920g()
                goto L_0x007d
            L_0x00e2:
                r3 = r1
                goto L_0x0082
            L_0x00e4:
                android.support.v7.widget.RecyclerView r5 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r5 = r5.f2950o
                int r5 = r5.getItemViewType(r4)
                android.support.v7.widget.RecyclerView r6 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r6 = r6.f2950o
                boolean r6 = r6.hasStableIds()
                if (r6 == 0) goto L_0x010d
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r0 = r0.f2950o
                long r6 = r0.getItemId(r4)
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r9.mo5820a((long) r6, (int) r5, (boolean) r11)
                if (r0 == 0) goto L_0x010d
                r0.f3038a = r4
                r3 = r1
            L_0x010d:
                if (r0 != 0) goto L_0x0139
                android.support.v7.widget.RecyclerView$ViewCacheExtension r4 = r9.f3000h
                if (r4 == 0) goto L_0x0139
                android.support.v7.widget.RecyclerView$ViewCacheExtension r4 = r9.f3000h
                android.view.View r4 = r4.getViewForPositionAndType(r9, r10, r5)
                if (r4 == 0) goto L_0x0139
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r0.getChildViewHolder(r4)
                if (r0 != 0) goto L_0x012b
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r0.<init>(r1)
                throw r0
            L_0x012b:
                boolean r4 = r0.mo5916c()
                if (r4 == 0) goto L_0x0139
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r0.<init>(r1)
                throw r0
            L_0x0139:
                if (r0 != 0) goto L_0x0151
                android.support.v7.widget.RecyclerView$RecycledViewPool r0 = r9.mo5843d()
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r0.getRecycledView(r5)
                if (r0 == 0) goto L_0x0151
                r0.mo5939s()
                boolean r4 = android.support.p003v7.widget.RecyclerView.f2900h
                if (r4 == 0) goto L_0x0151
                r9.m2076f(r0)
            L_0x0151:
                if (r0 != 0) goto L_0x01eb
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r0 = r0.f2950o
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r0.createViewHolder(r4, r5)
                r4 = r3
                r3 = r0
            L_0x0161:
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r0 = r0.f2942e
                boolean r0 = r0.isPreLayout()
                if (r0 == 0) goto L_0x0194
                boolean r0 = r3.mo5933m()
                if (r0 == 0) goto L_0x0194
                r3.f3042e = r10
                r5 = r2
            L_0x0174:
                android.view.View r0 = r3.itemView
                android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
                if (r0 != 0) goto L_0x01ce
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r0 = r0.generateDefaultLayoutParams()
                android.support.v7.widget.RecyclerView$LayoutParams r0 = (android.support.p003v7.widget.RecyclerView.LayoutParams) r0
                android.view.View r6 = r3.itemView
                r6.setLayoutParams(r0)
            L_0x0189:
                r0.f2986a = r3
                if (r4 == 0) goto L_0x01e7
                if (r5 == 0) goto L_0x01e7
            L_0x018f:
                r0.f2989d = r1
                android.view.View r0 = r3.itemView
                return r0
            L_0x0194:
                boolean r0 = r3.mo5933m()
                if (r0 == 0) goto L_0x01a6
                boolean r0 = r3.mo5931k()
                if (r0 != 0) goto L_0x01a6
                boolean r0 = r3.mo5930j()
                if (r0 == 0) goto L_0x01e9
            L_0x01a6:
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.AdapterHelper r0 = r0.f2939b
                int r0 = r0.mo5068a((int) r10)
                android.support.v7.widget.RecyclerView r5 = android.support.p003v7.widget.RecyclerView.this
                r3.f3047j = r5
                android.support.v7.widget.RecyclerView r5 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r5 = r5.f2950o
                r5.bindViewHolder(r3, r0)
                android.view.View r0 = r3.itemView
                r9.m2075c((android.view.View) r0)
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r0 = r0.f2942e
                boolean r0 = r0.isPreLayout()
                if (r0 == 0) goto L_0x01cc
                r3.f3042e = r10
            L_0x01cc:
                r5 = r1
                goto L_0x0174
            L_0x01ce:
                android.support.v7.widget.RecyclerView r6 = android.support.p003v7.widget.RecyclerView.this
                boolean r6 = r6.checkLayoutParams(r0)
                if (r6 != 0) goto L_0x01e4
                android.support.v7.widget.RecyclerView r6 = android.support.p003v7.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r0 = r6.generateLayoutParams((android.view.ViewGroup.LayoutParams) r0)
                android.support.v7.widget.RecyclerView$LayoutParams r0 = (android.support.p003v7.widget.RecyclerView.LayoutParams) r0
                android.view.View r6 = r3.itemView
                r6.setLayoutParams(r0)
                goto L_0x0189
            L_0x01e4:
                android.support.v7.widget.RecyclerView$LayoutParams r0 = (android.support.p003v7.widget.RecyclerView.LayoutParams) r0
                goto L_0x0189
            L_0x01e7:
                r1 = r2
                goto L_0x018f
            L_0x01e9:
                r5 = r2
                goto L_0x0174
            L_0x01eb:
                r4 = r3
                r3 = r0
                goto L_0x0161
            L_0x01ef:
                r3 = r4
                goto L_0x0082
            L_0x01f2:
                r0 = r3
                r4 = r2
                goto L_0x0058
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.RecyclerView.Recycler.mo5821a(int, boolean):android.view.View");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5822a() {
            for (int size = this.f2994b.size() - 1; size >= 0; size--) {
                mo5823a(size);
            }
            this.f2994b.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5823a(int i) {
            mo5840c(this.f2994b.get(i));
            this.f2994b.remove(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5824a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f2994b.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = this.f2994b.get(i6);
                if (viewHolder != null && viewHolder.f3038a >= i5 && viewHolder.f3038a <= i4) {
                    if (viewHolder.f3038a == i) {
                        viewHolder.mo5910a(i2 - i, false);
                    } else {
                        viewHolder.mo5910a(i3, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5825a(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            mo5843d().mo5814a(adapter, adapter2, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5826a(RecycledViewPool recycledViewPool) {
            if (this.f2999g != null) {
                this.f2999g.mo5812a();
            }
            this.f2999g = recycledViewPool;
            if (recycledViewPool != null) {
                this.f2999g.mo5813a(RecyclerView.this.getAdapter());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5827a(ViewCacheExtension viewCacheExtension) {
            this.f3000h = viewCacheExtension;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5828a(View view) {
            ViewHolder a = RecyclerView.m1956a(view);
            Recycler unused = a.f3050n = null;
            a.mo5920g();
            mo5834b(a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5829a(ViewHolder viewHolder) {
            if (viewHolder.mo5934n()) {
                return true;
            }
            if (viewHolder.f3038a < 0 || viewHolder.f3038a >= RecyclerView.this.f2950o.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder);
            } else if (RecyclerView.this.f2942e.isPreLayout() || RecyclerView.this.f2950o.getItemViewType(viewHolder.f3038a) == viewHolder.getItemViewType()) {
                return !RecyclerView.this.f2950o.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.f2950o.getItemId(viewHolder.f3038a);
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5830b() {
            return this.f2993a.size();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public View mo5831b(int i) {
            return this.f2993a.get(i).itemView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5832b(int i, int i2) {
            int size = this.f2994b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.f2994b.get(i3);
                if (viewHolder != null && viewHolder.getLayoutPosition() >= i) {
                    viewHolder.mo5910a(i2, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5833b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f2994b.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f2994b.get(size);
                if (viewHolder != null) {
                    if (viewHolder.getLayoutPosition() >= i3) {
                        viewHolder.mo5910a(-i2, z);
                    } else if (viewHolder.getLayoutPosition() >= i) {
                        viewHolder.mo5915b(8);
                        mo5823a(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc  */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo5834b(android.support.p003v7.widget.RecyclerView.ViewHolder r6) {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                boolean r2 = r6.mo5917d()
                if (r2 != 0) goto L_0x0010
                android.view.View r2 = r6.itemView
                android.view.ViewParent r2 = r2.getParent()
                if (r2 == 0) goto L_0x0041
            L_0x0010:
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Scrapped or attached views may not be recycled. isScrap:"
                java.lang.StringBuilder r3 = r3.append(r4)
                boolean r4 = r6.mo5917d()
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r4 = " isAttached:"
                java.lang.StringBuilder r3 = r3.append(r4)
                android.view.View r4 = r6.itemView
                android.view.ViewParent r4 = r4.getParent()
                if (r4 == 0) goto L_0x003f
            L_0x0033:
                java.lang.StringBuilder r0 = r3.append(r0)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            L_0x003f:
                r0 = r1
                goto L_0x0033
            L_0x0041:
                boolean r2 = r6.mo5935o()
                if (r2 == 0) goto L_0x0060
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Tmp detached view should be removed from RecyclerView before it can be recycled: "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r6)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0060:
                boolean r2 = r6.mo5916c()
                if (r2 == 0) goto L_0x006e
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle."
                r0.<init>(r1)
                throw r0
            L_0x006e:
                boolean r3 = r6.m2153x()
                android.support.v7.widget.RecyclerView r2 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r2 = r2.f2950o
                if (r2 == 0) goto L_0x00ca
                if (r3 == 0) goto L_0x00ca
                android.support.v7.widget.RecyclerView r2 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r2 = r2.f2950o
                boolean r2 = r2.onFailedToRecycleView(r6)
                if (r2 == 0) goto L_0x00ca
                r2 = r0
            L_0x0089:
                if (r2 != 0) goto L_0x0091
                boolean r2 = r6.isRecyclable()
                if (r2 == 0) goto L_0x00d0
            L_0x0091:
                r2 = 78
                boolean r2 = r6.mo5913a((int) r2)
                if (r2 != 0) goto L_0x00ce
                java.util.ArrayList<android.support.v7.widget.RecyclerView$ViewHolder> r2 = r5.f2994b
                int r2 = r2.size()
                int r4 = r5.f2998f
                if (r2 != r4) goto L_0x00a8
                if (r2 <= 0) goto L_0x00a8
                r5.mo5823a((int) r1)
            L_0x00a8:
                int r4 = r5.f2998f
                if (r2 >= r4) goto L_0x00ce
                java.util.ArrayList<android.support.v7.widget.RecyclerView$ViewHolder> r2 = r5.f2994b
                r2.add(r6)
                r2 = r0
            L_0x00b2:
                if (r2 != 0) goto L_0x00cc
                r5.mo5840c((android.support.p003v7.widget.RecyclerView.ViewHolder) r6)
                r1 = r0
                r0 = r2
            L_0x00b9:
                android.support.v7.widget.RecyclerView r2 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r2 = r2.f2942e
                r2.mo5883a((android.support.p003v7.widget.RecyclerView.ViewHolder) r6)
                if (r0 != 0) goto L_0x00c9
                if (r1 != 0) goto L_0x00c9
                if (r3 == 0) goto L_0x00c9
                r0 = 0
                r6.f3047j = r0
            L_0x00c9:
                return
            L_0x00ca:
                r2 = r1
                goto L_0x0089
            L_0x00cc:
                r0 = r2
                goto L_0x00b9
            L_0x00ce:
                r2 = r1
                goto L_0x00b2
            L_0x00d0:
                r0 = r1
                goto L_0x00b9
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.RecyclerView.Recycler.mo5834b(android.support.v7.widget.RecyclerView$ViewHolder):void");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5835b(View view) {
            ViewHolder a = RecyclerView.m1956a(view);
            a.mo5911a(this);
            if (a.mo5932l() && RecyclerView.this.m2021z()) {
                if (this.f2996d == null) {
                    this.f2996d = new ArrayList<>();
                }
                this.f2996d.add(a);
            } else if (!a.mo5930j() || a.mo5934n() || RecyclerView.this.f2950o.hasStableIds()) {
                this.f2993a.add(a);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        public void bindViewToPosition(View view, int i) {
            LayoutParams layoutParams;
            boolean z = true;
            ViewHolder a = RecyclerView.m1956a(view);
            if (a == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int a2 = RecyclerView.this.f2939b.mo5068a(i);
            if (a2 < 0 || a2 >= RecyclerView.this.f2950o.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a2 + ")." + "state:" + RecyclerView.this.f2942e.getItemCount());
            }
            a.f3047j = RecyclerView.this;
            RecyclerView.this.f2950o.bindViewHolder(a, a2);
            m2075c(view);
            if (RecyclerView.this.f2942e.isPreLayout()) {
                a.f3042e = i;
            }
            ViewGroup.LayoutParams layoutParams2 = a.itemView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                a.itemView.setLayoutParams(layoutParams);
            } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                a.itemView.setLayoutParams(layoutParams);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.f2988c = true;
            layoutParams.f2986a = a;
            if (a.itemView.getParent() != null) {
                z = false;
            }
            layoutParams.f2989d = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public ViewHolder mo5837c(int i) {
            int size;
            int a;
            int i2 = 0;
            if (this.f2996d == null || (size = this.f2996d.size()) == 0) {
                return null;
            }
            int i3 = 0;
            while (i3 < size) {
                ViewHolder viewHolder = this.f2996d.get(i3);
                if (viewHolder.mo5919f() || viewHolder.getLayoutPosition() != i) {
                    i3++;
                } else {
                    viewHolder.mo5915b(32);
                    return viewHolder;
                }
            }
            if (RecyclerView.this.f2950o.hasStableIds() && (a = RecyclerView.this.f2939b.mo5068a(i)) > 0 && a < RecyclerView.this.f2950o.getItemCount()) {
                long itemId = RecyclerView.this.f2950o.getItemId(a);
                while (i2 < size) {
                    ViewHolder viewHolder2 = this.f2996d.get(i2);
                    if (viewHolder2.mo5919f() || viewHolder2.getItemId() != itemId) {
                        i2++;
                    } else {
                        viewHolder2.mo5915b(32);
                        return viewHolder2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5838c() {
            this.f2993a.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5839c(int i, int i2) {
            int layoutPosition;
            int i3 = i + i2;
            for (int size = this.f2994b.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f2994b.get(size);
                if (viewHolder != null && (layoutPosition = viewHolder.getLayoutPosition()) >= i && layoutPosition < i3) {
                    viewHolder.mo5915b(2);
                    mo5823a(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5840c(ViewHolder viewHolder) {
            ViewCompat.setAccessibilityDelegate(viewHolder.itemView, (AccessibilityDelegateCompat) null);
            mo5846e(viewHolder);
            viewHolder.f3047j = null;
            mo5843d().putRecycledView(viewHolder);
        }

        public void clear() {
            this.f2993a.clear();
            mo5822a();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i >= 0 && i < RecyclerView.this.f2942e.getItemCount()) {
                return !RecyclerView.this.f2942e.isPreLayout() ? i : RecyclerView.this.f2939b.mo5068a(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + RecyclerView.this.f2942e.getItemCount());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public RecycledViewPool mo5843d() {
            if (this.f2999g == null) {
                this.f2999g = new RecycledViewPool();
            }
            return this.f2999g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5844d(ViewHolder viewHolder) {
            if (!viewHolder.mo5932l() || !RecyclerView.this.m2021z() || this.f2996d == null) {
                this.f2993a.remove(viewHolder);
            } else {
                this.f2996d.remove(viewHolder);
            }
            Recycler unused = viewHolder.f3050n = null;
            viewHolder.mo5920g();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5845e() {
            int size = this.f2994b.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.f2994b.get(i);
                if (viewHolder != null) {
                    viewHolder.mo5915b(512);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5846e(ViewHolder viewHolder) {
            if (RecyclerView.this.f2952q != null) {
                RecyclerView.this.f2952q.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.f2950o != null) {
                RecyclerView.this.f2950o.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.f2942e != null) {
                RecyclerView.this.f2942e.mo5883a(viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo5847f() {
            if (RecyclerView.this.f2950o == null || !RecyclerView.this.f2950o.hasStableIds()) {
                mo5822a();
                return;
            }
            int size = this.f2994b.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.f2994b.get(i);
                if (viewHolder != null) {
                    viewHolder.mo5915b(6);
                    viewHolder.mo5912a((Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo5848g() {
            int size = this.f2994b.size();
            for (int i = 0; i < size; i++) {
                this.f2994b.get(i).mo5907a();
            }
            int size2 = this.f2993a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f2993a.get(i2).mo5907a();
            }
            if (this.f2996d != null) {
                int size3 = this.f2996d.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f2996d.get(i3).mo5907a();
                }
            }
        }

        public List<ViewHolder> getScrapList() {
            return this.f2997e;
        }

        public View getViewForPosition(int i) {
            return mo5821a(i, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo5851h() {
            int size = this.f2994b.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f2994b.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f2988c = true;
                }
            }
        }

        public void recycleView(View view) {
            ViewHolder a = RecyclerView.m1956a(view);
            if (a.mo5935o()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (a.mo5917d()) {
                a.mo5918e();
            } else if (a.mo5919f()) {
                a.mo5920g();
            }
            mo5834b(a);
        }

        public void setViewCacheSize(int i) {
            this.f2998f = i;
            for (int size = this.f2994b.size() - 1; size >= 0 && this.f2994b.size() > i; size--) {
                mo5823a(size);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$RecyclerListener */
    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$RecyclerViewDataObserver */
    class RecyclerViewDataObserver extends AdapterDataObserver {
        private RecyclerViewDataObserver() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5855a() {
            if (!RecyclerView.this.f2905D || !RecyclerView.this.f2957v || !RecyclerView.this.f2956u) {
                boolean unused = RecyclerView.this.f2904C = true;
                RecyclerView.this.requestLayout();
                return;
            }
            ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.f2948m);
        }

        public void onChanged() {
            RecyclerView.this.mo5519b((String) null);
            if (RecyclerView.this.f2950o.hasStableIds()) {
                boolean unused = RecyclerView.this.f2942e.f3026j = true;
                RecyclerView.this.m1954D();
            } else {
                boolean unused2 = RecyclerView.this.f2942e.f3026j = true;
                RecyclerView.this.m1954D();
            }
            if (!RecyclerView.this.f2939b.mo5080d()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.mo5519b((String) null);
            if (RecyclerView.this.f2939b.mo5074a(i, i2, obj)) {
                mo5855a();
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.mo5519b((String) null);
            if (RecyclerView.this.f2939b.mo5077b(i, i2)) {
                mo5855a();
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.mo5519b((String) null);
            if (RecyclerView.this.f2939b.mo5073a(i, i2, i3)) {
                mo5855a();
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.mo5519b((String) null);
            if (RecyclerView.this.f2939b.mo5079c(i, i2)) {
                mo5855a();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        Parcelable f3002a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3002a = parcel.readParcelable(LayoutManager.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2106a(SavedState savedState) {
            this.f3002a = savedState.f3002a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f3002a, 0);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$SimpleOnItemTouchListener */
    public class SimpleOnItemTouchListener implements OnItemTouchListener {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$SmoothScroller */
    public abstract class SmoothScroller {

        /* renamed from: a */
        private int f3003a = -1;

        /* renamed from: b */
        private RecyclerView f3004b;

        /* renamed from: c */
        private LayoutManager f3005c;

        /* renamed from: d */
        private boolean f3006d;

        /* renamed from: e */
        private boolean f3007e;

        /* renamed from: f */
        private View f3008f;

        /* renamed from: g */
        private final Action f3009g = new Action(0, 0);

        /* renamed from: android.support.v7.widget.RecyclerView$SmoothScroller$Action */
        public class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;

            /* renamed from: a */
            private int f3010a;

            /* renamed from: b */
            private int f3011b;

            /* renamed from: c */
            private int f3012c;

            /* renamed from: d */
            private int f3013d;

            /* renamed from: e */
            private Interpolator f3014e;

            /* renamed from: f */
            private boolean f3015f;

            /* renamed from: g */
            private int f3016g;

            public Action(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, (Interpolator) null);
            }

            public Action(int i, int i2, int i3) {
                this(i, i2, i3, (Interpolator) null);
            }

            public Action(int i, int i2, int i3, Interpolator interpolator) {
                this.f3013d = -1;
                this.f3015f = false;
                this.f3016g = 0;
                this.f3010a = i;
                this.f3011b = i2;
                this.f3012c = i3;
                this.f3014e = interpolator;
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m2119a(RecyclerView recyclerView) {
                if (this.f3013d >= 0) {
                    int i = this.f3013d;
                    this.f3013d = -1;
                    recyclerView.m1973b(i);
                    this.f3015f = false;
                } else if (this.f3015f) {
                    m2120b();
                    if (this.f3014e != null) {
                        recyclerView.f2926aa.smoothScrollBy(this.f3010a, this.f3011b, this.f3012c, this.f3014e);
                    } else if (this.f3012c == Integer.MIN_VALUE) {
                        recyclerView.f2926aa.smoothScrollBy(this.f3010a, this.f3011b);
                    } else {
                        recyclerView.f2926aa.smoothScrollBy(this.f3010a, this.f3011b, this.f3012c);
                    }
                    this.f3016g++;
                    if (this.f3016g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3015f = false;
                } else {
                    this.f3016g = 0;
                }
            }

            /* renamed from: b */
            private void m2120b() {
                if (this.f3014e != null && this.f3012c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f3012c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo5872a() {
                return this.f3013d >= 0;
            }

            public int getDuration() {
                return this.f3012c;
            }

            public int getDx() {
                return this.f3010a;
            }

            public int getDy() {
                return this.f3011b;
            }

            public Interpolator getInterpolator() {
                return this.f3014e;
            }

            public void jumpTo(int i) {
                this.f3013d = i;
            }

            public void setDuration(int i) {
                this.f3015f = true;
                this.f3012c = i;
            }

            public void setDx(int i) {
                this.f3015f = true;
                this.f3010a = i;
            }

            public void setDy(int i) {
                this.f3015f = true;
                this.f3011b = i;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.f3015f = true;
                this.f3014e = interpolator;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.f3010a = i;
                this.f3011b = i2;
                this.f3012c = i3;
                this.f3014e = interpolator;
                this.f3015f = true;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2108a(int i, int i2) {
            RecyclerView recyclerView = this.f3004b;
            if (!this.f3007e || this.f3003a == -1 || recyclerView == null) {
                mo5862e();
            }
            this.f3006d = false;
            if (this.f3008f != null) {
                if (getChildPosition(this.f3008f) == this.f3003a) {
                    mo5377a(this.f3008f, recyclerView.f2942e, this.f3009g);
                    this.f3009g.m2119a(recyclerView);
                    mo5862e();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f3008f = null;
                }
            }
            if (this.f3007e) {
                mo5375a(i, i2, recyclerView.f2942e, this.f3009g);
                boolean a = this.f3009g.mo5872a();
                this.f3009g.m2119a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f3007e) {
                    this.f3006d = true;
                    recyclerView.f2926aa.mo5899a();
                    return;
                }
                mo5862e();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5374a();

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5375a(int i, int i2, State state, Action action);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5859a(PointF pointF) {
            double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x = (float) (((double) pointF.x) / sqrt);
            pointF.y = (float) (((double) pointF.y) / sqrt);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5860a(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.f3004b = recyclerView;
            this.f3005c = layoutManager;
            if (this.f3003a == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            int unused = this.f3004b.f2942e.f3022f = this.f3003a;
            this.f3007e = true;
            this.f3006d = true;
            this.f3008f = findViewByPosition(getTargetPosition());
            mo5374a();
            this.f3004b.f2926aa.mo5899a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5861a(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.f3008f = view;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5377a(View view, State state, Action action);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo5379b();

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public final void mo5862e() {
            if (this.f3007e) {
                mo5379b();
                int unused = this.f3004b.f2942e.f3022f = -1;
                this.f3008f = null;
                this.f3003a = -1;
                this.f3006d = false;
                this.f3007e = false;
                this.f3005c.m2056a(this);
                this.f3005c = null;
                this.f3004b = null;
            }
        }

        public View findViewByPosition(int i) {
            return this.f3004b.f2951p.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.f3004b.f2951p.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.f3004b.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager() {
            return this.f3005c;
        }

        public int getTargetPosition() {
            return this.f3003a;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.f3004b.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.f3006d;
        }

        public boolean isRunning() {
            return this.f3007e;
        }

        public void setTargetPosition(int i) {
            this.f3003a = i;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$State */
    public class State {

        /* renamed from: a */
        ArrayMap<ViewHolder, ItemHolderInfo> f3017a = new ArrayMap<>();

        /* renamed from: b */
        ArrayMap<ViewHolder, ItemHolderInfo> f3018b = new ArrayMap<>();

        /* renamed from: c */
        ArrayMap<Long, ViewHolder> f3019c = new ArrayMap<>();

        /* renamed from: d */
        final List<View> f3020d = new ArrayList();

        /* renamed from: e */
        int f3021e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f3022f = -1;

        /* renamed from: g */
        private SparseArray<Object> f3023g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f3024h = 0;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public int f3025i = 0;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public boolean f3026j = false;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f3027k = false;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public boolean f3028l = false;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public boolean f3029m = false;

        /* renamed from: a */
        static /* synthetic */ int m2122a(State state, int i) {
            int i2 = state.f3025i + i;
            state.f3025i = i2;
            return i2;
        }

        /* renamed from: a */
        private void m2123a(ArrayMap<Long, ViewHolder> arrayMap, ViewHolder viewHolder) {
            for (int size = arrayMap.size() - 1; size >= 0; size--) {
                if (viewHolder == arrayMap.valueAt(size)) {
                    arrayMap.removeAt(size);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5883a(ViewHolder viewHolder) {
            this.f3017a.remove(viewHolder);
            this.f3018b.remove(viewHolder);
            if (this.f3019c != null) {
                m2123a(this.f3019c, viewHolder);
            }
            this.f3020d.remove(viewHolder.itemView);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5884a(View view) {
            this.f3020d.remove(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5885b(View view) {
            if (!this.f3020d.contains(view)) {
                this.f3020d.add(view);
            }
        }

        public boolean didStructureChange() {
            return this.f3026j;
        }

        public <T> T get(int i) {
            if (this.f3023g == null) {
                return null;
            }
            return this.f3023g.get(i);
        }

        public int getItemCount() {
            return this.f3027k ? this.f3024h - this.f3025i : this.f3021e;
        }

        public int getTargetScrollPosition() {
            return this.f3022f;
        }

        public boolean hasTargetScrollPosition() {
            return this.f3022f != -1;
        }

        public boolean isPreLayout() {
            return this.f3027k;
        }

        public void onViewIgnored(ViewHolder viewHolder) {
            mo5883a(viewHolder);
        }

        public void put(int i, Object obj) {
            if (this.f3023g == null) {
                this.f3023g = new SparseArray<>();
            }
            this.f3023g.put(i, obj);
        }

        public void remove(int i) {
            if (this.f3023g != null) {
                this.f3023g.remove(i);
            }
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f3022f + ", mPreLayoutHolderMap=" + this.f3017a + ", mPostLayoutHolderMap=" + this.f3018b + ", mData=" + this.f3023g + ", mItemCount=" + this.f3021e + ", mPreviousLayoutItemCount=" + this.f3024h + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3025i + ", mStructureChanged=" + this.f3026j + ", mInPreLayout=" + this.f3027k + ", mRunSimpleAnimations=" + this.f3028l + ", mRunPredictiveAnimations=" + this.f3029m + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.f3029m;
        }

        public boolean willRunSimpleAnimations() {
            return this.f3028l;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ViewCacheExtension */
    public abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler recycler, int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ViewFlinger */
    class ViewFlinger implements Runnable {

        /* renamed from: b */
        private int f3031b;

        /* renamed from: c */
        private int f3032c;

        /* renamed from: d */
        private ScrollerCompat f3033d;

        /* renamed from: e */
        private Interpolator f3034e = RecyclerView.f2899an;

        /* renamed from: f */
        private boolean f3035f = false;

        /* renamed from: g */
        private boolean f3036g = false;

        public ViewFlinger() {
            this.f3033d = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.f2899an);
        }

        /* renamed from: a */
        private float m2138a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        /* renamed from: a */
        private int m2139a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float a = (m2138a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i6)) + ((float) i6);
            if (sqrt > 0) {
                i5 = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                i5 = (int) (((((float) (z ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        /* renamed from: b */
        private void m2140b() {
            this.f3036g = false;
            this.f3035f = true;
        }

        /* renamed from: c */
        private void m2141c() {
            this.f3035f = false;
            if (this.f3036g) {
                mo5899a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5899a() {
            if (this.f3035f) {
                this.f3036g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f3032c = 0;
            this.f3031b = 0;
            this.f3033d.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            mo5899a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:106:0x0257  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x0262  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0265  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x014e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0160  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0175  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x017c  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x018d  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x01c0  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01db  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r22.m2140b()
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                r4.m2011r()
                r0 = r22
                android.support.v4.widget.ScrollerCompat r11 = r0.f3033d
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$LayoutManager r4 = r4.f2951p
                android.support.v7.widget.RecyclerView$SmoothScroller r12 = r4.f2985s
                boolean r4 = r11.computeScrollOffset()
                if (r4 == 0) goto L_0x0209
                int r13 = r11.getCurrX()
                int r14 = r11.getCurrY()
                r0 = r22
                int r4 = r0.f3031b
                int r15 = r13 - r4
                r0 = r22
                int r4 = r0.f3032c
                int r16 = r14 - r4
                r7 = 0
                r5 = 0
                r0 = r22
                r0.f3031b = r13
                r0 = r22
                r0.f3032c = r14
                r6 = 0
                r4 = 0
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Adapter r8 = r8.f2950o
                if (r8 == 0) goto L_0x0243
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r8.mo5517b()
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r8.m2018w()
                java.lang.String r8 = "RV Scroll"
                android.support.p000v4.p002os.TraceCompat.beginSection(r8)
                if (r15 == 0) goto L_0x0077
                r0 = r22
                android.support.v7.widget.RecyclerView r6 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$LayoutManager r6 = r6.f2951p
                r0 = r22
                android.support.v7.widget.RecyclerView r7 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Recycler r7 = r7.f2925a
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r8 = r8.f2942e
                int r7 = r6.scrollHorizontallyBy(r15, r7, r8)
                int r6 = r15 - r7
            L_0x0077:
                if (r16 == 0) goto L_0x0095
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$LayoutManager r4 = r4.f2951p
                r0 = r22
                android.support.v7.widget.RecyclerView r5 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$Recycler r5 = r5.f2925a
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r8 = r8.f2942e
                r0 = r16
                int r5 = r4.scrollVerticallyBy(r0, r5, r8)
                int r4 = r16 - r5
            L_0x0095:
                android.support.p000v4.p002os.TraceCompat.endSection()
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                boolean r8 = r8.m2021z()
                if (r8 == 0) goto L_0x010f
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.ChildHelper r8 = r8.f2940c
                int r9 = r8.mo5196b()
                r8 = 0
            L_0x00ad:
                if (r8 >= r9) goto L_0x010f
                r0 = r22
                android.support.v7.widget.RecyclerView r10 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.ChildHelper r10 = r10.f2940c
                android.view.View r10 = r10.mo5198b((int) r8)
                r0 = r22
                android.support.v7.widget.RecyclerView r0 = android.support.p003v7.widget.RecyclerView.this
                r17 = r0
                r0 = r17
                android.support.v7.widget.RecyclerView$ViewHolder r17 = r0.getChildViewHolder(r10)
                if (r17 == 0) goto L_0x010c
                r0 = r17
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r0.f3044g
                r18 = r0
                if (r18 == 0) goto L_0x010c
                r0 = r17
                android.support.v7.widget.RecyclerView$ViewHolder r0 = r0.f3044g
                r17 = r0
                r0 = r17
                android.view.View r0 = r0.itemView
                r17 = r0
                int r18 = r10.getLeft()
                int r10 = r10.getTop()
                int r19 = r17.getLeft()
                r0 = r18
                r1 = r19
                if (r0 != r1) goto L_0x00f5
                int r19 = r17.getTop()
                r0 = r19
                if (r10 == r0) goto L_0x010c
            L_0x00f5:
                int r19 = r17.getWidth()
                int r19 = r19 + r18
                int r20 = r17.getHeight()
                int r20 = r20 + r10
                r0 = r17
                r1 = r18
                r2 = r19
                r3 = r20
                r0.layout(r1, r10, r2, r3)
            L_0x010c:
                int r8 = r8 + 1
                goto L_0x00ad
            L_0x010f:
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r8.m2019x()
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r9 = 0
                r8.mo5507a((boolean) r9)
                if (r12 == 0) goto L_0x0243
                boolean r8 = r12.isPendingInitialRun()
                if (r8 != 0) goto L_0x0243
                boolean r8 = r12.isRunning()
                if (r8 == 0) goto L_0x0243
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$State r8 = r8.f2942e
                int r8 = r8.getItemCount()
                if (r8 != 0) goto L_0x0223
                r12.mo5862e()
                r21 = r6
                r6 = r5
                r5 = r21
            L_0x0140:
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                java.util.ArrayList r8 = r8.f2953r
                boolean r8 = r8.isEmpty()
                if (r8 != 0) goto L_0x0155
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r8.invalidate()
            L_0x0155:
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                int r8 = android.support.p000v4.view.ViewCompat.getOverScrollMode(r8)
                r9 = 2
                if (r8 == r9) goto L_0x0169
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r0 = r16
                r8.m1990e(r15, r0)
            L_0x0169:
                if (r5 != 0) goto L_0x016d
                if (r4 == 0) goto L_0x01ab
            L_0x016d:
                float r8 = r11.getCurrVelocity()
                int r9 = (int) r8
                r8 = 0
                if (r5 == r13) goto L_0x0265
                if (r5 >= 0) goto L_0x024a
                int r8 = -r9
            L_0x0178:
                r10 = r8
            L_0x0179:
                r8 = 0
                if (r4 == r14) goto L_0x0262
                if (r4 >= 0) goto L_0x0252
                int r9 = -r9
            L_0x017f:
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                int r8 = android.support.p000v4.view.ViewCompat.getOverScrollMode(r8)
                r17 = 2
                r0 = r17
                if (r8 == r0) goto L_0x0194
                r0 = r22
                android.support.v7.widget.RecyclerView r8 = android.support.p003v7.widget.RecyclerView.this
                r8.mo5503a((int) r10, (int) r9)
            L_0x0194:
                if (r10 != 0) goto L_0x019e
                if (r5 == r13) goto L_0x019e
                int r5 = r11.getFinalX()
                if (r5 != 0) goto L_0x01ab
            L_0x019e:
                if (r9 != 0) goto L_0x01a8
                if (r4 == r14) goto L_0x01a8
                int r4 = r11.getFinalY()
                if (r4 != 0) goto L_0x01ab
            L_0x01a8:
                r11.abortAnimation()
            L_0x01ab:
                if (r7 != 0) goto L_0x01af
                if (r6 == 0) goto L_0x01b6
            L_0x01af:
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                r4.mo5526d(r7, r6)
            L_0x01b6:
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                boolean r4 = r4.awakenScrollBars()
                if (r4 != 0) goto L_0x01c7
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                r4.invalidate()
            L_0x01c7:
                if (r16 == 0) goto L_0x0257
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$LayoutManager r4 = r4.f2951p
                boolean r4 = r4.canScrollVertically()
                if (r4 == 0) goto L_0x0257
                r0 = r16
                if (r6 != r0) goto L_0x0257
                r4 = 1
                r5 = r4
            L_0x01dd:
                if (r15 == 0) goto L_0x025a
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                android.support.v7.widget.RecyclerView$LayoutManager r4 = r4.f2951p
                boolean r4 = r4.canScrollHorizontally()
                if (r4 == 0) goto L_0x025a
                if (r7 != r15) goto L_0x025a
                r4 = 1
            L_0x01f0:
                if (r15 != 0) goto L_0x01f4
                if (r16 == 0) goto L_0x01f8
            L_0x01f4:
                if (r4 != 0) goto L_0x01f8
                if (r5 == 0) goto L_0x025c
            L_0x01f8:
                r4 = 1
            L_0x01f9:
                boolean r5 = r11.isFinished()
                if (r5 != 0) goto L_0x0201
                if (r4 != 0) goto L_0x025e
            L_0x0201:
                r0 = r22
                android.support.v7.widget.RecyclerView r4 = android.support.p003v7.widget.RecyclerView.this
                r5 = 0
                r4.setScrollState(r5)
            L_0x0209:
                if (r12 == 0) goto L_0x021f
                boolean r4 = r12.isPendingInitialRun()
                if (r4 == 0) goto L_0x0216
                r4 = 0
                r5 = 0
                r12.m2108a((int) r4, (int) r5)
            L_0x0216:
                r0 = r22
                boolean r4 = r0.f3036g
                if (r4 != 0) goto L_0x021f
                r12.mo5862e()
            L_0x021f:
                r22.m2141c()
                return
            L_0x0223:
                int r9 = r12.getTargetPosition()
                if (r9 < r8) goto L_0x023c
                int r8 = r8 + -1
                r12.setTargetPosition(r8)
                int r8 = r15 - r6
                int r9 = r16 - r4
                r12.m2108a((int) r8, (int) r9)
                r21 = r6
                r6 = r5
                r5 = r21
                goto L_0x0140
            L_0x023c:
                int r8 = r15 - r6
                int r9 = r16 - r4
                r12.m2108a((int) r8, (int) r9)
            L_0x0243:
                r21 = r6
                r6 = r5
                r5 = r21
                goto L_0x0140
            L_0x024a:
                if (r5 <= 0) goto L_0x024f
                r8 = r9
                goto L_0x0178
            L_0x024f:
                r8 = 0
                goto L_0x0178
            L_0x0252:
                if (r4 > 0) goto L_0x017f
                r9 = 0
                goto L_0x017f
            L_0x0257:
                r4 = 0
                r5 = r4
                goto L_0x01dd
            L_0x025a:
                r4 = 0
                goto L_0x01f0
            L_0x025c:
                r4 = 0
                goto L_0x01f9
            L_0x025e:
                r22.mo5899a()
                goto L_0x0209
            L_0x0262:
                r9 = r8
                goto L_0x017f
            L_0x0265:
                r10 = r8
                goto L_0x0179
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.RecyclerView.ViewFlinger.run():void");
        }

        public void smoothScrollBy(int i, int i2) {
            smoothScrollBy(i, i2, 0, 0);
        }

        public void smoothScrollBy(int i, int i2, int i3) {
            smoothScrollBy(i, i2, i3, RecyclerView.f2899an);
        }

        public void smoothScrollBy(int i, int i2, int i3, int i4) {
            smoothScrollBy(i, i2, m2139a(i, i2, i3, i4));
        }

        public void smoothScrollBy(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f3034e != interpolator) {
                this.f3034e = interpolator;
                this.f3033d = ScrollerCompat.create(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f3032c = 0;
            this.f3031b = 0;
            this.f3033d.startScroll(0, 0, i, i2, i3);
            mo5899a();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.f3033d.abortAnimation();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$ViewHolder */
    public abstract class ViewHolder {

        /* renamed from: l */
        private static final List<Object> f3037l = Collections.EMPTY_LIST;

        /* renamed from: a */
        int f3038a = -1;

        /* renamed from: b */
        int f3039b = -1;

        /* renamed from: c */
        long f3040c = -1;

        /* renamed from: d */
        int f3041d = -1;

        /* renamed from: e */
        int f3042e = -1;

        /* renamed from: f */
        ViewHolder f3043f = null;

        /* renamed from: g */
        ViewHolder f3044g = null;

        /* renamed from: h */
        List<Object> f3045h = null;

        /* renamed from: i */
        List<Object> f3046i = null;
        public final View itemView;

        /* renamed from: j */
        RecyclerView f3047j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public int f3048k;

        /* renamed from: m */
        private int f3049m = 0;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public Recycler f3050n = null;

        /* renamed from: o */
        private int f3051o = 0;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        /* renamed from: t */
        private void mo9563t() {
            if (this.f3045h == null) {
                this.f3045h = new ArrayList();
                this.f3046i = Collections.unmodifiableList(this.f3045h);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public void mo9564u() {
            this.f3051o = ViewCompat.getImportantForAccessibility(this.itemView);
            ViewCompat.setImportantForAccessibility(this.itemView, 4);
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public void m2151v() {
            ViewCompat.setImportantForAccessibility(this.itemView, this.f3051o);
            this.f3051o = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public boolean m2152w() {
            return (this.f3048k & 16) != 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public boolean m2153x() {
            return (this.f3048k & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5907a() {
            this.f3039b = -1;
            this.f3042e = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5908a(int i, int i2) {
            this.f3048k = (this.f3048k & (i2 ^ -1)) | (i & i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5909a(int i, int i2, boolean z) {
            mo5915b(8);
            mo5910a(i2, z);
            this.f3038a = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5910a(int i, boolean z) {
            if (this.f3039b == -1) {
                this.f3039b = this.f3038a;
            }
            if (this.f3042e == -1) {
                this.f3042e = this.f3038a;
            }
            if (z) {
                this.f3042e += i;
            }
            this.f3038a += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f2988c = true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5911a(Recycler recycler) {
            this.f3050n = recycler;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5912a(Object obj) {
            if (obj == null) {
                mo5915b(1024);
            } else if ((this.f3048k & 1024) == 0) {
                mo9563t();
                this.f3045h.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5913a(int i) {
            return (this.f3048k & i) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5914b() {
            if (this.f3039b == -1) {
                this.f3039b = this.f3038a;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5915b(int i) {
            this.f3048k |= i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo5916c() {
            return (this.f3048k & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo5917d() {
            return this.f3050n != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5918e() {
            this.f3050n.mo5844d(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean mo5919f() {
            return (this.f3048k & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo5920g() {
            this.f3048k &= -33;
        }

        public final int getAdapterPosition() {
            if (this.f3047j == null) {
                return -1;
            }
            return this.f3047j.m1981c(this);
        }

        public final long getItemId() {
            return this.f3040c;
        }

        public final int getItemViewType() {
            return this.f3041d;
        }

        public final int getLayoutPosition() {
            return this.f3042e == -1 ? this.f3038a : this.f3042e;
        }

        public final int getOldPosition() {
            return this.f3039b;
        }

        @Deprecated
        public final int getPosition() {
            return this.f3042e == -1 ? this.f3038a : this.f3042e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo5927h() {
            this.f3048k &= -257;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo5928i() {
            this.f3048k &= -129;
        }

        public final boolean isRecyclable() {
            return (this.f3048k & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean mo5930j() {
            return (this.f3048k & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean mo5931k() {
            return (this.f3048k & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public boolean mo5932l() {
            return (this.f3048k & 64) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public boolean mo5933m() {
            return (this.f3048k & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo5934n() {
            return (this.f3048k & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public boolean mo5935o() {
            return (this.f3048k & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public boolean mo5936p() {
            return (this.f3048k & 512) != 0 || mo5930j();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public void mo5937q() {
            if (this.f3045h != null) {
                this.f3045h.clear();
            }
            this.f3048k &= -1025;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public List<Object> mo5938r() {
            return (this.f3048k & 1024) == 0 ? (this.f3045h == null || this.f3045h.size() == 0) ? f3037l : this.f3046i : f3037l;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public void mo5939s() {
            this.f3048k = 0;
            this.f3038a = -1;
            this.f3039b = -1;
            this.f3040c = -1;
            this.f3042e = -1;
            this.f3049m = 0;
            this.f3043f = null;
            this.f3044g = null;
            mo5937q();
            this.f3051o = 0;
        }

        public final void setIsRecyclable(boolean z) {
            this.f3049m = z ? this.f3049m - 1 : this.f3049m + 1;
            if (this.f3049m < 0) {
                this.f3049m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.f3049m == 1) {
                this.f3048k |= 16;
            } else if (z && this.f3049m == 0) {
                this.f3048k &= -17;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f3038a + " id=" + this.f3040c + ", oldPos=" + this.f3039b + ", pLpos:" + this.f3042e);
            if (mo5917d()) {
                sb.append(" scrap");
            }
            if (mo5930j()) {
                sb.append(" invalid");
            }
            if (!mo5933m()) {
                sb.append(" unbound");
            }
            if (mo5931k()) {
                sb.append(" update");
            }
            if (mo5934n()) {
                sb.append(" removed");
            }
            if (mo5916c()) {
                sb.append(" ignored");
            }
            if (mo5932l()) {
                sb.append(" changed");
            }
            if (mo5935o()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.f3049m + ")");
            }
            if (mo5936p()) {
                sb.append("undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2945j = new RecyclerViewDataObserver();
        this.f2925a = new Recycler();
        this.f2948m = new Runnable() {
            public void run() {
                if (RecyclerView.this.f2958w) {
                    if (RecyclerView.this.f2908G) {
                        TraceCompat.beginSection("RV FullInvalidate");
                        RecyclerView.this.mo5562i();
                        TraceCompat.endSection();
                    } else if (RecyclerView.this.f2939b.mo5080d()) {
                        TraceCompat.beginSection("RV PartialInvalidate");
                        RecyclerView.this.mo5517b();
                        RecyclerView.this.f2939b.mo5076b();
                        if (!RecyclerView.this.f2960y) {
                            RecyclerView.this.mo5571m();
                        }
                        RecyclerView.this.mo5507a(true);
                        TraceCompat.endSection();
                    }
                }
            }
        };
        this.f2949n = new Rect();
        this.f2953r = new ArrayList<>();
        this.f2954s = new ArrayList<>();
        this.f2908G = false;
        this.f2909H = 0;
        this.f2941d = new DefaultItemAnimator();
        this.f2914M = 0;
        this.f2915N = -1;
        this.f2924W = Float.MIN_VALUE;
        this.f2926aa = new ViewFlinger();
        this.f2942e = new State();
        this.f2943f = false;
        this.f2944g = false;
        this.f2929ad = new ItemAnimatorRestoreListener();
        this.f2930ae = false;
        this.f2933ah = new int[2];
        this.f2935aj = new int[2];
        this.f2936ak = new int[2];
        this.f2937al = new int[2];
        this.f2938am = new Runnable() {
            public void run() {
                if (RecyclerView.this.f2941d != null) {
                    RecyclerView.this.f2941d.runPendingAnimations();
                }
                boolean unused = RecyclerView.this.f2930ae = false;
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.f2905D = Build.VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2921T = viewConfiguration.getScaledTouchSlop();
        this.f2922U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2923V = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(ViewCompat.getOverScrollMode(this) == 2);
        this.f2941d.mo5663a(this.f2929ad);
        mo5501a();
        m2009q();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.f2906E = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0273R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0273R.styleable.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            m1959a(context, string, attributeSet, i, 0);
        }
        this.f2934ai = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    /* renamed from: A */
    private void m1951A() {
        if (!this.f2930ae && this.f2956u) {
            ViewCompat.postOnAnimation(this, this.f2938am);
            this.f2930ae = true;
        }
    }

    /* renamed from: B */
    private boolean m1952B() {
        return this.f2941d != null && this.f2951p.supportsPredictiveItemAnimations();
    }

    /* renamed from: C */
    private void m1953C() {
        boolean z = true;
        if (this.f2908G) {
            this.f2939b.mo5070a();
            mo5572n();
            this.f2951p.onItemsChanged(this);
        }
        if (this.f2941d == null || !this.f2951p.supportsPredictiveItemAnimations()) {
            this.f2939b.mo5081e();
        } else {
            this.f2939b.mo5076b();
        }
        boolean z2 = (this.f2943f && !this.f2944g) || this.f2943f || (this.f2944g && m2021z());
        boolean unused = this.f2942e.f3028l = this.f2958w && this.f2941d != null && (this.f2908G || z2 || this.f2951p.f2981a) && (!this.f2908G || this.f2950o.hasStableIds());
        State state = this.f2942e;
        if (!this.f2942e.f3028l || !z2 || this.f2908G || !m1952B()) {
            z = false;
        }
        boolean unused2 = state.f3029m = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m1954D() {
        if (!this.f2908G) {
            this.f2908G = true;
            int c = this.f2940c.mo5199c();
            for (int i = 0; i < c; i++) {
                ViewHolder a = m1956a(this.f2940c.mo5200c(i));
                if (a != null && !a.mo5916c()) {
                    a.mo5915b(512);
                }
            }
            this.f2925a.mo5845e();
        }
    }

    /* renamed from: a */
    static ViewHolder m1956a(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2986a;
    }

    /* renamed from: a */
    private String m1957a(Context context, String str) {
        return str.charAt(0) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        if (r7.f2913L.onPull(r11 / ((float) getHeight()), 1.0f - (r8 / ((float) getWidth()))) == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if (r7.f2911J.onPull((-r11) / ((float) getHeight()), r8 / ((float) getWidth())) != false) goto L_0x0042;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1958a(float r8, float r9, float r10, float r11) {
        /*
            r7 = this;
            r6 = 1065353216(0x3f800000, float:1.0)
            r0 = 1
            r5 = 0
            r1 = 0
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0050
            r7.mo5520c()
            android.support.v4.widget.EdgeEffectCompat r2 = r7.f2910I
            float r3 = -r9
            int r4 = r7.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            int r4 = r7.getHeight()
            float r4 = (float) r4
            float r4 = r10 / r4
            float r4 = r6 - r4
            boolean r2 = r2.onPull(r3, r4)
            if (r2 == 0) goto L_0x0025
            r1 = r0
        L_0x0025:
            int r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x006f
            r7.mo5531e()
            android.support.v4.widget.EdgeEffectCompat r2 = r7.f2911J
            float r3 = -r11
            int r4 = r7.getHeight()
            float r4 = (float) r4
            float r3 = r3 / r4
            int r4 = r7.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            boolean r2 = r2.onPull(r3, r4)
            if (r2 == 0) goto L_0x008e
        L_0x0042:
            if (r0 != 0) goto L_0x004c
            int r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x004c
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x004f
        L_0x004c:
            android.support.p000v4.view.ViewCompat.postInvalidateOnAnimation(r7)
        L_0x004f:
            return
        L_0x0050:
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0025
            r7.mo5525d()
            android.support.v4.widget.EdgeEffectCompat r2 = r7.f2912K
            int r3 = r7.getWidth()
            float r3 = (float) r3
            float r3 = r9 / r3
            int r4 = r7.getHeight()
            float r4 = (float) r4
            float r4 = r10 / r4
            boolean r2 = r2.onPull(r3, r4)
            if (r2 == 0) goto L_0x0025
            r1 = r0
            goto L_0x0025
        L_0x006f:
            int r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x008e
            r7.mo5532f()
            android.support.v4.widget.EdgeEffectCompat r2 = r7.f2913L
            int r3 = r7.getHeight()
            float r3 = (float) r3
            float r3 = r11 / r3
            int r4 = r7.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            float r4 = r6 - r4
            boolean r2 = r2.onPull(r3, r4)
            if (r2 != 0) goto L_0x0042
        L_0x008e:
            r0 = r1
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.RecyclerView.m1958a(float, float, float, float):void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1959a(android.content.Context r9, java.lang.String r10, android.util.AttributeSet r11, int r12, int r13) {
        /*
            r8 = this;
            if (r10 == 0) goto L_0x0054
            java.lang.String r0 = r10.trim()
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0054
            java.lang.String r3 = r8.m1957a((android.content.Context) r9, (java.lang.String) r0)
            boolean r0 = r8.isInEditMode()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            if (r0 == 0) goto L_0x0055
            java.lang.Class r0 = r8.getClass()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
        L_0x001e:
            java.lang.Class r0 = r0.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.Class<android.support.v7.widget.RecyclerView$LayoutManager> r1 = android.support.p003v7.widget.RecyclerView.LayoutManager.class
            java.lang.Class r4 = r0.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            r1 = 0
            java.lang.Class<?>[] r0 = f2901i     // Catch:{ NoSuchMethodException -> 0x005a }
            java.lang.reflect.Constructor r2 = r4.getConstructor(r0)     // Catch:{ NoSuchMethodException -> 0x005a }
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ NoSuchMethodException -> 0x005a }
            r5 = 0
            r0[r5] = r9     // Catch:{ NoSuchMethodException -> 0x005a }
            r5 = 1
            r0[r5] = r11     // Catch:{ NoSuchMethodException -> 0x005a }
            r5 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)     // Catch:{ NoSuchMethodException -> 0x005a }
            r0[r5] = r6     // Catch:{ NoSuchMethodException -> 0x005a }
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)     // Catch:{ NoSuchMethodException -> 0x005a }
            r0[r5] = r6     // Catch:{ NoSuchMethodException -> 0x005a }
            r1 = r2
        L_0x0047:
            r2 = 1
            r1.setAccessible(r2)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.Object r0 = r1.newInstance(r0)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            android.support.v7.widget.RecyclerView$LayoutManager r0 = (android.support.p003v7.widget.RecyclerView.LayoutManager) r0     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            r8.setLayoutManager(r0)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
        L_0x0054:
            return
        L_0x0055:
            java.lang.ClassLoader r0 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            goto L_0x001e
        L_0x005a:
            r0 = move-exception
            r2 = 0
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0066 }
            java.lang.reflect.Constructor r0 = r4.getConstructor(r2)     // Catch:{ NoSuchMethodException -> 0x0066 }
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0047
        L_0x0066:
            r1 = move-exception
            r1.initCause(r0)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            r2.<init>()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.String r4 = r11.getPositionDescription()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.String r4 = ": Error creating LayoutManager "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            java.lang.String r2 = r2.toString()     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            r0.<init>(r2, r1)     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x008b, InvocationTargetException -> 0x00ad, InstantiationException -> 0x00cf, IllegalAccessException -> 0x00f1, ClassCastException -> 0x0113 }
        L_0x008b:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r11.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ": Unable to find LayoutManager "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00ad:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r11.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ": Could not instantiate the LayoutManager: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00cf:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r11.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ": Could not instantiate the LayoutManager: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00f1:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r11.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ": Cannot access non-public constructor "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0113:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r11.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ": Class is not a LayoutManager "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.RecyclerView.m1959a(android.content.Context, java.lang.String, android.util.AttributeSet, int, int):void");
    }

    /* renamed from: a */
    private void m1960a(ArrayMap<View, Rect> arrayMap) {
        List<View> list = this.f2942e.f3020d;
        for (int size = list.size() - 1; size >= 0; size--) {
            View view = list.get(size);
            ViewHolder a = m1956a(view);
            ItemHolderInfo remove = this.f2942e.f3017a.remove(a);
            if (!this.f2942e.isPreLayout()) {
                this.f2942e.f3018b.remove(a);
            }
            if (arrayMap.remove(view) != null) {
                this.f2951p.removeAndRecycleView(view, this.f2925a);
            } else if (remove != null) {
                m1962a(remove);
            } else {
                m1962a(new ItemHolderInfo(a, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }
        list.clear();
    }

    /* renamed from: a */
    private void m1961a(Adapter adapter, boolean z, boolean z2) {
        if (this.f2950o != null) {
            this.f2950o.unregisterAdapterDataObserver(this.f2945j);
            this.f2950o.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            if (this.f2941d != null) {
                this.f2941d.endAnimations();
            }
            if (this.f2951p != null) {
                this.f2951p.removeAndRecycleAllViews(this.f2925a);
                this.f2951p.mo5704a(this.f2925a);
            }
            this.f2925a.clear();
        }
        this.f2939b.mo5070a();
        Adapter adapter2 = this.f2950o;
        this.f2950o = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f2945j);
            adapter.onAttachedToRecyclerView(this);
        }
        if (this.f2951p != null) {
            this.f2951p.onAdapterChanged(adapter2, this.f2950o);
        }
        this.f2925a.mo5825a(adapter2, this.f2950o, z);
        boolean unused = this.f2942e.f3026j = true;
        mo5572n();
    }

    /* renamed from: a */
    private void m1962a(ItemHolderInfo itemHolderInfo) {
        View view = itemHolderInfo.f2976a.itemView;
        m1974b(itemHolderInfo.f2976a);
        int i = itemHolderInfo.f2977b;
        int i2 = itemHolderInfo.f2978c;
        int left = view.getLeft();
        int top = view.getTop();
        if (itemHolderInfo.f2976a.mo5934n() || (i == left && i2 == top)) {
            itemHolderInfo.f2976a.setIsRecyclable(false);
            if (this.f2941d.animateRemove(itemHolderInfo.f2976a)) {
                m1951A();
                return;
            }
            return;
        }
        itemHolderInfo.f2976a.setIsRecyclable(false);
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        if (this.f2941d.animateMove(itemHolderInfo.f2976a, i, i2, left, top)) {
            m1951A();
        }
    }

    /* renamed from: a */
    private void m1963a(ViewHolder viewHolder, Rect rect, int i, int i2) {
        View view = viewHolder.itemView;
        if (rect == null || (rect.left == i && rect.top == i2)) {
            viewHolder.setIsRecyclable(false);
            if (this.f2941d.animateAdd(viewHolder)) {
                m1951A();
                return;
            }
            return;
        }
        viewHolder.setIsRecyclable(false);
        if (this.f2941d.animateMove(viewHolder, rect.left, rect.top, i, i2)) {
            m1951A();
        }
    }

    /* renamed from: a */
    private void m1964a(ViewHolder viewHolder, ViewHolder viewHolder2) {
        int i;
        int i2;
        viewHolder.setIsRecyclable(false);
        m1974b(viewHolder);
        viewHolder.f3043f = viewHolder2;
        this.f2925a.mo5844d(viewHolder);
        int left = viewHolder.itemView.getLeft();
        int top = viewHolder.itemView.getTop();
        if (viewHolder2 == null || viewHolder2.mo5916c()) {
            i = top;
            i2 = left;
        } else {
            i2 = viewHolder2.itemView.getLeft();
            i = viewHolder2.itemView.getTop();
            viewHolder2.setIsRecyclable(false);
            viewHolder2.f3044g = viewHolder;
        }
        if (this.f2941d.animateChange(viewHolder, viewHolder2, left, top, i2, i)) {
            m1951A();
        }
    }

    /* renamed from: a */
    private void m1969a(int[] iArr) {
        int b = this.f2940c.mo5196b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            ViewHolder a = m1956a(this.f2940c.mo5198b(i3));
            if (!a.mo5916c()) {
                int layoutPosition = a.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
            i3++;
            i = i;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* renamed from: a */
    private boolean m1972a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f2955t = null;
        }
        int size = this.f2954s.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = this.f2954s.get(i);
            if (!onItemTouchListener.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f2955t = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1973b(int i) {
        if (this.f2951p != null) {
            this.f2951p.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    /* renamed from: b */
    private void m1974b(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.f2925a.mo5844d(getChildViewHolder(view));
        if (viewHolder.mo5935o()) {
            this.f2940c.mo5193a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.f2940c.mo5195a(view, true);
        } else {
            this.f2940c.mo5203d(view);
        }
    }

    /* renamed from: b */
    private boolean m1980b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f2955t != null) {
            if (action == 0) {
                this.f2955t = null;
            } else {
                this.f2955t.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f2955t = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f2954s.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener = this.f2954s.get(i);
                if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent)) {
                    this.f2955t = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m1981c(ViewHolder viewHolder) {
        if (viewHolder.mo5913a(524) || !viewHolder.mo5933m()) {
            return -1;
        }
        return this.f2939b.applyPendingUpdatesToPosition(viewHolder.f3038a);
    }

    /* renamed from: c */
    private void m1984c(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f2915N) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2915N = MotionEventCompat.getPointerId(motionEvent, i);
            int x = (int) (MotionEventCompat.getX(motionEvent, i) + 0.5f);
            this.f2919R = x;
            this.f2917P = x;
            int y = (int) (MotionEventCompat.getY(motionEvent, i) + 0.5f);
            this.f2920S = y;
            this.f2918Q = y;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m1987c(View view) {
        mo5517b();
        boolean e = this.f2940c.mo5204e(view);
        if (e) {
            ViewHolder a = m1956a(view);
            this.f2925a.mo5844d(a);
            this.f2925a.mo5834b(a);
        }
        mo5507a(false);
        return e;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1989d(View view) {
        ViewHolder a = m1956a(view);
        onChildDetachedFromWindow(view);
        if (!(this.f2950o == null || a == null)) {
            this.f2950o.onViewDetachedFromWindow(a);
        }
        if (this.f2907F != null) {
            for (int size = this.f2907F.size() - 1; size >= 0; size--) {
                this.f2907F.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m1990e(int i, int i2) {
        boolean z = false;
        if (this.f2910I != null && !this.f2910I.isFinished() && i > 0) {
            z = this.f2910I.onRelease();
        }
        if (this.f2912K != null && !this.f2912K.isFinished() && i < 0) {
            z |= this.f2912K.onRelease();
        }
        if (this.f2911J != null && !this.f2911J.isFinished() && i2 > 0) {
            z |= this.f2911J.onRelease();
        }
        if (this.f2913L != null && !this.f2913L.isFinished() && i2 < 0) {
            z |= this.f2913L.onRelease();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m1992e(View view) {
        ViewHolder a = m1956a(view);
        onChildAttachedToWindow(view);
        if (!(this.f2950o == null || a == null)) {
            this.f2950o.onViewAttachedToWindow(a);
        }
        if (this.f2907F != null) {
            for (int size = this.f2907F.size() - 1; size >= 0; size--) {
                this.f2907F.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m1994f(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size = ViewCompat.getMinimumWidth(this);
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size2 = ViewCompat.getMinimumHeight(this);
                break;
        }
        setMeasuredDimension(size, size2);
    }

    /* renamed from: g */
    private boolean m1996g(int i, int i2) {
        int layoutPosition;
        int b = this.f2940c.mo5196b();
        if (b == 0) {
            return (i == 0 && i2 == 0) ? false : true;
        }
        for (int i3 = 0; i3 < b; i3++) {
            ViewHolder a = m1956a(this.f2940c.mo5198b(i3));
            if (!a.mo5916c() && ((layoutPosition = a.getLayoutPosition()) < i || layoutPosition > i2)) {
                return true;
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.f2924W == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            this.f2924W = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.f2924W;
    }

    /* renamed from: q */
    private void m2009q() {
        this.f2940c = new ChildHelper(new ChildHelper.Callback() {
            public void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.m1992e(view);
            }

            public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder a = RecyclerView.m1956a(view);
                if (a != null) {
                    if (a.mo5935o() || a.mo5916c()) {
                        a.mo5927h();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + a);
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public void detachViewFromParent(int i) {
                ViewHolder a;
                View childAt = getChildAt(i);
                if (!(childAt == null || (a = RecyclerView.m1956a(childAt)) == null)) {
                    if (!a.mo5935o() || a.mo5916c()) {
                        a.mo5915b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + a);
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.m1956a(view);
            }

            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void onEnteredHiddenState(View view) {
                ViewHolder a = RecyclerView.m1956a(view);
                if (a != null) {
                    a.mo9564u();
                }
            }

            public void onLeftHiddenState(View view) {
                ViewHolder a = RecyclerView.m1956a(view);
                if (a != null) {
                    a.m2151v();
                }
            }

            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    RecyclerView.this.m1989d(getChildAt(i));
                }
                RecyclerView.this.removeAllViews();
            }

            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.m1989d(childAt);
                }
                RecyclerView.this.removeViewAt(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m2011r() {
        this.f2948m.run();
    }

    /* renamed from: s */
    private void m2012s() {
        this.f2926aa.stop();
        if (this.f2951p != null) {
            this.f2951p.mo5720d();
        }
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (i != this.f2914M) {
            this.f2914M = i;
            if (i != 2) {
                m2012s();
            }
            mo5502a(i);
        }
    }

    /* renamed from: t */
    private void m2015t() {
        boolean z = false;
        if (this.f2910I != null) {
            z = this.f2910I.onRelease();
        }
        if (this.f2911J != null) {
            z |= this.f2911J.onRelease();
        }
        if (this.f2912K != null) {
            z |= this.f2912K.onRelease();
        }
        if (this.f2913L != null) {
            z |= this.f2913L.onRelease();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: u */
    private void m2016u() {
        if (this.f2916O != null) {
            this.f2916O.clear();
        }
        stopNestedScroll();
        m2015t();
    }

    /* renamed from: v */
    private void m2017v() {
        m2016u();
        setScrollState(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m2018w() {
        this.f2909H++;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m2019x() {
        this.f2909H--;
        if (this.f2909H < 1) {
            this.f2909H = 0;
            m2020y();
        }
    }

    /* renamed from: y */
    private void m2020y() {
        int i = this.f2903B;
        this.f2903B = 0;
        if (i != 0 && mo5559h()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m2021z() {
        return this.f2941d != null && this.f2941d.getSupportsChangeAnimations();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo5499a(ViewHolder viewHolder) {
        return this.f2950o.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.f3038a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ViewHolder mo5500a(int i, boolean z) {
        int c = this.f2940c.mo5199c();
        for (int i2 = 0; i2 < c; i2++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i2));
            if (a != null && !a.mo5934n()) {
                if (z) {
                    if (a.f3038a == i) {
                        return a;
                    }
                } else if (a.getLayoutPosition() == i) {
                    return a;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5501a() {
        this.f2939b = new AdapterHelper(new AdapterHelper.Callback() {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo5624a(AdapterHelper.UpdateOp updateOp) {
                switch (updateOp.f2646a) {
                    case 0:
                        RecyclerView.this.f2951p.onItemsAdded(RecyclerView.this, updateOp.f2647b, updateOp.f2649d);
                        return;
                    case 1:
                        RecyclerView.this.f2951p.onItemsRemoved(RecyclerView.this, updateOp.f2647b, updateOp.f2649d);
                        return;
                    case 2:
                        RecyclerView.this.f2951p.onItemsUpdated(RecyclerView.this, updateOp.f2647b, updateOp.f2649d, updateOp.f2648c);
                        return;
                    case 3:
                        RecyclerView.this.f2951p.onItemsMoved(RecyclerView.this, updateOp.f2647b, updateOp.f2649d, 1);
                        return;
                    default:
                        return;
                }
            }

            public ViewHolder findViewHolder(int i) {
                ViewHolder a = RecyclerView.this.mo5500a(i, true);
                if (a != null && !RecyclerView.this.f2940c.mo5201c(a.itemView)) {
                    return a;
                }
                return null;
            }

            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView.this.mo5504a(i, i2, obj);
                RecyclerView.this.f2944g = true;
            }

            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView.this.mo5521c(i, i2);
                RecyclerView.this.f2943f = true;
            }

            public void offsetPositionsForMove(int i, int i2) {
                RecyclerView.this.mo5518b(i, i2);
                RecyclerView.this.f2943f = true;
            }

            public void offsetPositionsForRemovingInvisible(int i, int i2) {
                RecyclerView.this.mo5505a(i, i2, true);
                RecyclerView.this.f2943f = true;
                State.m2122a(RecyclerView.this.f2942e, i2);
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
                RecyclerView.this.mo5505a(i, i2, false);
                RecyclerView.this.f2943f = true;
            }

            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                mo5624a(updateOp);
            }

            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                mo5624a(updateOp);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5502a(int i) {
        if (this.f2951p != null) {
            this.f2951p.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        if (this.f2927ab != null) {
            this.f2927ab.onScrollStateChanged(this, i);
        }
        if (this.f2928ac != null) {
            for (int size = this.f2928ac.size() - 1; size >= 0; size--) {
                this.f2928ac.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5503a(int i, int i2) {
        if (i < 0) {
            mo5520c();
            this.f2910I.onAbsorb(-i);
        } else if (i > 0) {
            mo5525d();
            this.f2912K.onAbsorb(i);
        }
        if (i2 < 0) {
            mo5531e();
            this.f2911J.onAbsorb(-i2);
        } else if (i2 > 0) {
            mo5532f();
            this.f2913L.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5504a(int i, int i2, Object obj) {
        int c = this.f2940c.mo5199c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.f2940c.mo5200c(i4);
            ViewHolder a = m1956a(c2);
            if (a != null && !a.mo5916c() && a.f3038a >= i && a.f3038a < i3) {
                a.mo5915b(2);
                a.mo5912a(obj);
                if (m2021z()) {
                    a.mo5915b(64);
                }
                ((LayoutParams) c2.getLayoutParams()).f2988c = true;
            }
        }
        this.f2925a.mo5839c(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5505a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f2940c.mo5199c();
        for (int i4 = 0; i4 < c; i4++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i4));
            if (a != null && !a.mo5916c()) {
                if (a.f3038a >= i3) {
                    a.mo5910a(-i2, z);
                    boolean unused = this.f2942e.f3026j = true;
                } else if (a.f3038a >= i) {
                    a.mo5909a(i - 1, -i2, z);
                    boolean unused2 = this.f2942e.f3026j = true;
                }
            }
        }
        this.f2925a.mo5833b(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5506a(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5507a(boolean z) {
        if (this.f2959x) {
            if (z && this.f2960y && !this.f2961z && this.f2951p != null && this.f2950o != null) {
                mo5562i();
            }
            this.f2959x = false;
            if (!this.f2961z) {
                this.f2960y = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5508a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        m2011r();
        if (this.f2950o != null) {
            mo5517b();
            m2018w();
            TraceCompat.beginSection("RV Scroll");
            if (i != 0) {
                i5 = this.f2951p.scrollHorizontallyBy(i, this.f2925a, this.f2942e);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.f2951p.scrollVerticallyBy(i2, this.f2925a, this.f2942e);
                i4 = i2 - i6;
            }
            TraceCompat.endSection();
            if (m2021z()) {
                int b = this.f2940c.mo5196b();
                for (int i7 = 0; i7 < b; i7++) {
                    View b2 = this.f2940c.mo5198b(i7);
                    ViewHolder childViewHolder = getChildViewHolder(b2);
                    if (!(childViewHolder == null || childViewHolder.f3044g == null)) {
                        ViewHolder viewHolder = childViewHolder.f3044g;
                        View view = viewHolder != null ? viewHolder.itemView : null;
                        if (view != null) {
                            int left = b2.getLeft();
                            int top = b2.getTop();
                            if (left != view.getLeft() || top != view.getTop()) {
                                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                            }
                        }
                    }
                }
            }
            m2019x();
            mo5507a(false);
        }
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        if (!this.f2953r.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i9, i10, i3, i8, this.f2935aj)) {
            this.f2919R -= this.f2935aj[0];
            this.f2920S -= this.f2935aj[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.f2935aj[0], (float) this.f2935aj[1]);
            }
            int[] iArr = this.f2937al;
            iArr[0] = iArr[0] + this.f2935aj[0];
            int[] iArr2 = this.f2937al;
            iArr2[1] = iArr2[1] + this.f2935aj[1];
        } else if (ViewCompat.getOverScrollMode(this) != 2) {
            if (motionEvent != null) {
                m1958a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i8);
            }
            m1990e(i, i2);
        }
        if (!(i9 == 0 && i10 == 0)) {
            mo5526d(i9, i10);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i9 == 0 && i10 == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5509a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes != 0) {
            i = contentChangeTypes;
        }
        this.f2903B = i | this.f2903B;
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f2951p == null || !this.f2951p.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        if (this.f2951p != null) {
            this.f2951p.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f2953r.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f2953r.add(itemDecoration);
        } else {
            this.f2953r.add(i, itemDecoration);
        }
        mo5568j();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.f2907F == null) {
            this.f2907F = new ArrayList();
        }
        this.f2907F.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.f2954s.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.f2928ac == null) {
            this.f2928ac = new ArrayList();
        }
        this.f2928ac.add(onScrollListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Rect mo5516b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f2988c) {
            return layoutParams.f2987b;
        }
        Rect rect = layoutParams.f2987b;
        rect.set(0, 0, 0, 0);
        int size = this.f2953r.size();
        for (int i = 0; i < size; i++) {
            this.f2949n.set(0, 0, 0, 0);
            this.f2953r.get(i).getItemOffsets(this.f2949n, view, this, this.f2942e);
            rect.left += this.f2949n.left;
            rect.top += this.f2949n.top;
            rect.right += this.f2949n.right;
            rect.bottom += this.f2949n.bottom;
        }
        layoutParams.f2988c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5517b() {
        if (!this.f2959x) {
            this.f2959x = true;
            if (!this.f2961z) {
                this.f2960y = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5518b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int c = this.f2940c.mo5199c();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i6));
            if (a != null && a.f3038a >= i5 && a.f3038a <= i4) {
                if (a.f3038a == i) {
                    a.mo5910a(i2 - i, false);
                } else {
                    a.mo5910a(i3, false);
                }
                boolean unused = this.f2942e.f3026j = true;
            }
        }
        this.f2925a.mo5824a(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5519b(String str) {
        if (!isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5520c() {
        if (this.f2910I == null) {
            this.f2910I = new EdgeEffectCompat(getContext());
            if (this.f2947l) {
                this.f2910I.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f2910I.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5521c(int i, int i2) {
        int c = this.f2940c.mo5199c();
        for (int i3 = 0; i3 < c; i3++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i3));
            if (a != null && !a.mo5916c() && a.f3038a >= i) {
                a.mo5910a(i2, false);
                boolean unused = this.f2942e.f3026j = true;
            }
        }
        this.f2925a.mo5832b(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f2951p.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.f2907F != null) {
            this.f2907F.clear();
        }
    }

    public void clearOnScrollListeners() {
        if (this.f2928ac != null) {
            this.f2928ac.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        if (this.f2951p.canScrollHorizontally()) {
            return this.f2951p.computeHorizontalScrollExtent(this.f2942e);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        if (this.f2951p.canScrollHorizontally()) {
            return this.f2951p.computeHorizontalScrollOffset(this.f2942e);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f2951p.canScrollHorizontally()) {
            return this.f2951p.computeHorizontalScrollRange(this.f2942e);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f2951p.canScrollVertically()) {
            return this.f2951p.computeVerticalScrollExtent(this.f2942e);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f2951p.canScrollVertically()) {
            return this.f2951p.computeVerticalScrollOffset(this.f2942e);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f2951p.canScrollVertically()) {
            return this.f2951p.computeVerticalScrollRange(this.f2942e);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5525d() {
        if (this.f2912K == null) {
            this.f2912K = new EdgeEffectCompat(getContext());
            if (this.f2947l) {
                this.f2912K.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f2912K.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5526d(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.f2927ab != null) {
            this.f2927ab.onScrolled(this, i, i2);
        }
        if (this.f2928ac != null) {
            for (int size = this.f2928ac.size() - 1; size >= 0; size--) {
                this.f2928ac.get(size).onScrolled(this, i, i2);
            }
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2934ai.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2934ai.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f2934ai.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2934ai.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        super.draw(canvas);
        int size = this.f2953r.size();
        for (int i = 0; i < size; i++) {
            this.f2953r.get(i).onDrawOver(canvas, this, this.f2942e);
        }
        if (this.f2910I == null || this.f2910I.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f2947l ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (paddingBottom + (-getHeight())), BitmapDescriptorFactory.HUE_RED);
            z = this.f2910I != null && this.f2910I.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.f2911J != null && !this.f2911J.isFinished()) {
            int save2 = canvas.save();
            if (this.f2947l) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            z |= this.f2911J != null && this.f2911J.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.f2912K != null && !this.f2912K.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f2947l ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            z |= this.f2912K != null && this.f2912K.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.f2913L != null && !this.f2913L.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f2947l) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.f2913L != null && this.f2913L.draw(canvas)) {
                z3 = true;
            }
            z |= z3;
            canvas.restoreToCount(save4);
        }
        if (z || this.f2941d == null || this.f2953r.size() <= 0 || !this.f2941d.isRunning()) {
            z2 = z;
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5531e() {
        if (this.f2911J == null) {
            this.f2911J = new EdgeEffectCompat(getContext());
            if (this.f2947l) {
                this.f2911J.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f2911J.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5532f() {
        if (this.f2913L == null) {
            this.f2913L = new EdgeEffectCompat(getContext());
            if (this.f2947l) {
                this.f2913L.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f2913L.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.f2940c.mo5196b() - 1; b >= 0; b--) {
            View b2 = this.f2940c.mo5198b(b);
            float translationX = ViewCompat.getTranslationX(b2);
            float translationY = ViewCompat.getTranslationY(b2);
            if (f >= ((float) b2.getLeft()) + translationX && f <= translationX + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + translationY && f2 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        if (this.f2908G) {
            return null;
        }
        int c = this.f2940c.mo5199c();
        for (int i2 = 0; i2 < c; i2++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i2));
            if (a != null && !a.mo5934n() && m1981c(a) == i) {
                return a;
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        int c = this.f2940c.mo5199c();
        for (int i = 0; i < c; i++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i));
            if (a != null && a.getItemId() == j) {
                return a;
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return mo5500a(i, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return mo5500a(i, false);
    }

    public boolean fling(int i, int i2) {
        if (this.f2951p == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f2961z) {
            return false;
        } else {
            boolean canScrollHorizontally = this.f2951p.canScrollHorizontally();
            boolean canScrollVertically = this.f2951p.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.f2922U) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.f2922U) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            boolean z = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling((float) i, (float) i2, z);
            if (!z) {
                return false;
            }
            this.f2926aa.fling(Math.max(-this.f2923V, Math.min(i, this.f2923V)), Math.max(-this.f2923V, Math.min(i2, this.f2923V)));
            return true;
        }
    }

    public View focusSearch(View view, int i) {
        View onInterceptFocusSearch = this.f2951p.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null && this.f2950o != null && this.f2951p != null && !isComputingLayout() && !this.f2961z) {
            mo5517b();
            findNextFocus = this.f2951p.onFocusSearchFailed(view, i, this.f2925a, this.f2942e);
            mo5507a(false);
        }
        return findNextFocus == null ? super.focusSearch(view, i) : findNextFocus;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5540g() {
        this.f2913L = null;
        this.f2911J = null;
        this.f2912K = null;
        this.f2910I = null;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f2951p != null) {
            return this.f2951p.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f2951p != null) {
            return this.f2951p.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f2951p != null) {
            return this.f2951p.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public Adapter getAdapter() {
        return this.f2950o;
    }

    public int getBaseline() {
        return this.f2951p != null ? this.f2951p.getBaseline() : super.getBaseline();
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder a = m1956a(view);
        if (a != null) {
            return a.getAdapterPosition();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return this.f2932ag == null ? super.getChildDrawingOrder(i, i2) : this.f2932ag.onGetChildDrawingOrder(i, i2);
    }

    public long getChildItemId(View view) {
        ViewHolder a;
        if (this.f2950o == null || !this.f2950o.hasStableIds() || (a = m1956a(view)) == null) {
            return -1;
        }
        return a.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder a = m1956a(view);
        if (a != null) {
            return a.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return m1956a(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f2931af;
    }

    public ItemAnimator getItemAnimator() {
        return this.f2941d;
    }

    public LayoutManager getLayoutManager() {
        return this.f2951p;
    }

    public int getMaxFlingVelocity() {
        return this.f2923V;
    }

    public int getMinFlingVelocity() {
        return this.f2922U;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.f2925a.mo5843d();
    }

    public int getScrollState() {
        return this.f2914M;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo5559h() {
        return this.f2906E != null && this.f2906E.isEnabled();
    }

    public boolean hasFixedSize() {
        return this.f2957v;
    }

    public boolean hasNestedScrollingParent() {
        return this.f2934ai.hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.f2958w || this.f2908G || this.f2939b.mo5080d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo5562i() {
        ArrayMap arrayMap;
        boolean z;
        if (this.f2950o == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f2951p == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f2942e.f3020d.clear();
            mo5517b();
            m2018w();
            m1953C();
            this.f2942e.f3019c = (!this.f2942e.f3028l || !this.f2944g || !m2021z()) ? null : new ArrayMap<>();
            this.f2944g = false;
            this.f2943f = false;
            boolean unused = this.f2942e.f3027k = this.f2942e.f3029m;
            this.f2942e.f3021e = this.f2950o.getItemCount();
            m1969a(this.f2933ah);
            if (this.f2942e.f3028l) {
                this.f2942e.f3017a.clear();
                this.f2942e.f3018b.clear();
                int b = this.f2940c.mo5196b();
                for (int i = 0; i < b; i++) {
                    ViewHolder a = m1956a(this.f2940c.mo5198b(i));
                    if (!a.mo5916c() && (!a.mo5930j() || this.f2950o.hasStableIds())) {
                        View view = a.itemView;
                        this.f2942e.f3017a.put(a, new ItemHolderInfo(a, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    }
                }
            }
            if (this.f2942e.f3029m) {
                mo5569k();
                if (this.f2942e.f3019c != null) {
                    int b2 = this.f2940c.mo5196b();
                    for (int i2 = 0; i2 < b2; i2++) {
                        ViewHolder a2 = m1956a(this.f2940c.mo5198b(i2));
                        if (a2.mo5932l() && !a2.mo5934n() && !a2.mo5916c()) {
                            this.f2942e.f3019c.put(Long.valueOf(mo5499a(a2)), a2);
                            this.f2942e.f3017a.remove(a2);
                        }
                    }
                }
                boolean c = this.f2942e.f3026j;
                boolean unused2 = this.f2942e.f3026j = false;
                this.f2951p.onLayoutChildren(this.f2925a, this.f2942e);
                boolean unused3 = this.f2942e.f3026j = c;
                ArrayMap arrayMap2 = new ArrayMap();
                for (int i3 = 0; i3 < this.f2940c.mo5196b(); i3++) {
                    View b3 = this.f2940c.mo5198b(i3);
                    if (!m1956a(b3).mo5916c()) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= this.f2942e.f3017a.size()) {
                                z = false;
                                break;
                            } else if (this.f2942e.f3017a.keyAt(i4).itemView == b3) {
                                z = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (!z) {
                            arrayMap2.put(b3, new Rect(b3.getLeft(), b3.getTop(), b3.getRight(), b3.getBottom()));
                        }
                    }
                }
                mo5570l();
                this.f2939b.mo5078c();
                arrayMap = arrayMap2;
            } else {
                mo5570l();
                this.f2939b.mo5081e();
                if (this.f2942e.f3019c != null) {
                    int b4 = this.f2940c.mo5196b();
                    for (int i5 = 0; i5 < b4; i5++) {
                        ViewHolder a3 = m1956a(this.f2940c.mo5198b(i5));
                        if (a3.mo5932l() && !a3.mo5934n() && !a3.mo5916c()) {
                            this.f2942e.f3019c.put(Long.valueOf(mo5499a(a3)), a3);
                            this.f2942e.f3017a.remove(a3);
                        }
                    }
                }
                arrayMap = null;
            }
            this.f2942e.f3021e = this.f2950o.getItemCount();
            int unused4 = this.f2942e.f3025i = 0;
            boolean unused5 = this.f2942e.f3027k = false;
            this.f2951p.onLayoutChildren(this.f2925a, this.f2942e);
            boolean unused6 = this.f2942e.f3026j = false;
            this.f2946k = null;
            boolean unused7 = this.f2942e.f3028l = this.f2942e.f3028l && this.f2941d != null;
            if (this.f2942e.f3028l) {
                ArrayMap arrayMap3 = this.f2942e.f3019c != null ? new ArrayMap() : null;
                int b5 = this.f2940c.mo5196b();
                for (int i6 = 0; i6 < b5; i6++) {
                    ViewHolder a4 = m1956a(this.f2940c.mo5198b(i6));
                    if (!a4.mo5916c()) {
                        View view2 = a4.itemView;
                        long a5 = mo5499a(a4);
                        if (arrayMap3 == null || this.f2942e.f3019c.get(Long.valueOf(a5)) == null) {
                            this.f2942e.f3018b.put(a4, new ItemHolderInfo(a4, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
                        } else {
                            arrayMap3.put(Long.valueOf(a5), a4);
                        }
                    }
                }
                m1960a((ArrayMap<View, Rect>) arrayMap);
                for (int size = this.f2942e.f3017a.size() - 1; size >= 0; size--) {
                    if (!this.f2942e.f3018b.containsKey(this.f2942e.f3017a.keyAt(size))) {
                        ItemHolderInfo valueAt = this.f2942e.f3017a.valueAt(size);
                        this.f2942e.f3017a.removeAt(size);
                        View view3 = valueAt.f2976a.itemView;
                        this.f2925a.mo5844d(valueAt.f2976a);
                        m1962a(valueAt);
                    }
                }
                int size2 = this.f2942e.f3018b.size();
                if (size2 > 0) {
                    for (int i7 = size2 - 1; i7 >= 0; i7--) {
                        ViewHolder keyAt = this.f2942e.f3018b.keyAt(i7);
                        ItemHolderInfo valueAt2 = this.f2942e.f3018b.valueAt(i7);
                        if (this.f2942e.f3017a.isEmpty() || !this.f2942e.f3017a.containsKey(keyAt)) {
                            this.f2942e.f3018b.removeAt(i7);
                            m1963a(keyAt, arrayMap != null ? (Rect) arrayMap.get(keyAt.itemView) : null, valueAt2.f2977b, valueAt2.f2978c);
                        }
                    }
                }
                int size3 = this.f2942e.f3018b.size();
                for (int i8 = 0; i8 < size3; i8++) {
                    ViewHolder keyAt2 = this.f2942e.f3018b.keyAt(i8);
                    ItemHolderInfo valueAt3 = this.f2942e.f3018b.valueAt(i8);
                    ItemHolderInfo itemHolderInfo = this.f2942e.f3017a.get(keyAt2);
                    if (!(itemHolderInfo == null || valueAt3 == null || (itemHolderInfo.f2977b == valueAt3.f2977b && itemHolderInfo.f2978c == valueAt3.f2978c))) {
                        keyAt2.setIsRecyclable(false);
                        if (this.f2941d.animateMove(keyAt2, itemHolderInfo.f2977b, itemHolderInfo.f2978c, valueAt3.f2977b, valueAt3.f2978c)) {
                            m1951A();
                        }
                    }
                }
                for (int size4 = (this.f2942e.f3019c != null ? this.f2942e.f3019c.size() : 0) - 1; size4 >= 0; size4--) {
                    long longValue = this.f2942e.f3019c.keyAt(size4).longValue();
                    ViewHolder viewHolder = this.f2942e.f3019c.get(Long.valueOf(longValue));
                    View view4 = viewHolder.itemView;
                    if (!viewHolder.mo5916c() && this.f2925a.f2996d != null && this.f2925a.f2996d.contains(viewHolder)) {
                        m1964a(viewHolder, (ViewHolder) arrayMap3.get(Long.valueOf(longValue)));
                    }
                }
            }
            mo5507a(false);
            this.f2951p.mo5704a(this.f2925a);
            int unused8 = this.f2942e.f3024h = this.f2942e.f3021e;
            this.f2908G = false;
            boolean unused9 = this.f2942e.f3028l = false;
            boolean unused10 = this.f2942e.f3029m = false;
            m2019x();
            boolean unused11 = this.f2951p.f2981a = false;
            if (this.f2925a.f2996d != null) {
                this.f2925a.f2996d.clear();
            }
            this.f2942e.f3019c = null;
            if (m1996g(this.f2933ah[0], this.f2933ah[1])) {
                mo5526d(0, 0);
            }
        }
    }

    public void invalidateItemDecorations() {
        if (this.f2953r.size() != 0) {
            if (this.f2951p != null) {
                this.f2951p.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            mo5568j();
            requestLayout();
        }
    }

    public boolean isAnimating() {
        return this.f2941d != null && this.f2941d.isRunning();
    }

    public boolean isAttachedToWindow() {
        return this.f2956u;
    }

    public boolean isComputingLayout() {
        return this.f2909H > 0;
    }

    public boolean isLayoutFrozen() {
        return this.f2961z;
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2934ai.isNestedScrollingEnabled();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5568j() {
        int c = this.f2940c.mo5199c();
        for (int i = 0; i < c; i++) {
            ((LayoutParams) this.f2940c.mo5200c(i).getLayoutParams()).f2988c = true;
        }
        this.f2925a.mo5851h();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo5569k() {
        int c = this.f2940c.mo5199c();
        for (int i = 0; i < c; i++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i));
            if (!a.mo5916c()) {
                a.mo5914b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo5570l() {
        int c = this.f2940c.mo5199c();
        for (int i = 0; i < c; i++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i));
            if (!a.mo5916c()) {
                a.mo5907a();
            }
        }
        this.f2925a.mo5848g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo5571m() {
        int b = this.f2940c.mo5196b();
        for (int i = 0; i < b; i++) {
            ViewHolder a = m1956a(this.f2940c.mo5198b(i));
            if (a != null && !a.mo5916c()) {
                if (a.mo5934n() || a.mo5930j()) {
                    requestLayout();
                } else if (!a.mo5931k()) {
                    continue;
                } else {
                    if (a.getItemViewType() != this.f2950o.getItemViewType(a.f3038a)) {
                        requestLayout();
                        return;
                    } else if (!a.mo5932l() || !m2021z()) {
                        this.f2950o.bindViewHolder(a, a.f3038a);
                    } else {
                        requestLayout();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo5572n() {
        int c = this.f2940c.mo5199c();
        for (int i = 0; i < c; i++) {
            ViewHolder a = m1956a(this.f2940c.mo5200c(i));
            if (a != null && !a.mo5916c()) {
                a.mo5915b(6);
            }
        }
        mo5568j();
        this.f2925a.mo5847f();
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.f2940c.mo5196b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f2940c.mo5198b(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int b = this.f2940c.mo5196b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f2940c.mo5198b(i2).offsetTopAndBottom(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2909H = 0;
        this.f2956u = true;
        this.f2958w = false;
        if (this.f2951p != null) {
            this.f2951p.mo5718b(this);
        }
        this.f2930ae = false;
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2941d != null) {
            this.f2941d.endAnimations();
        }
        this.f2958w = false;
        stopScroll();
        this.f2956u = false;
        if (this.f2951p != null) {
            this.f2951p.mo5706a(this, this.f2925a);
        }
        removeCallbacks(this.f2938am);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f2953r.size();
        for (int i = 0; i < size; i++) {
            this.f2953r.get(i).onDraw(canvas, this, this.f2942e);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.f2951p != null && !this.f2961z && (MotionEventCompat.getSource(motionEvent) & 2) != 0 && motionEvent.getAction() == 8) {
            float f = this.f2951p.canScrollVertically() ? -MotionEventCompat.getAxisValue(motionEvent, 9) : 0.0f;
            float axisValue = this.f2951p.canScrollHorizontally() ? MotionEventCompat.getAxisValue(motionEvent, 10) : 0.0f;
            if (!(f == BitmapDescriptorFactory.HUE_RED && axisValue == BitmapDescriptorFactory.HUE_RED)) {
                float scrollFactor = getScrollFactor();
                mo5508a((int) (axisValue * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i = -1;
        boolean z2 = true;
        if (this.f2961z) {
            return false;
        }
        if (m1972a(motionEvent)) {
            m2017v();
            return true;
        } else if (this.f2951p == null) {
            return false;
        } else {
            boolean canScrollHorizontally = this.f2951p.canScrollHorizontally();
            boolean canScrollVertically = this.f2951p.canScrollVertically();
            if (this.f2916O == null) {
                this.f2916O = VelocityTracker.obtain();
            }
            this.f2916O.addMovement(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            switch (actionMasked) {
                case 0:
                    if (this.f2902A) {
                        this.f2902A = false;
                    }
                    this.f2915N = MotionEventCompat.getPointerId(motionEvent, 0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.f2919R = x;
                    this.f2917P = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.f2920S = y;
                    this.f2918Q = y;
                    if (this.f2914M == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int i2 = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.f2916O.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f2915N);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                        int y2 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                        if (this.f2914M != 1) {
                            int i3 = x2 - this.f2917P;
                            int i4 = y2 - this.f2918Q;
                            if (!canScrollHorizontally || Math.abs(i3) <= this.f2921T) {
                                z = false;
                            } else {
                                this.f2919R = ((i3 < 0 ? -1 : 1) * this.f2921T) + this.f2917P;
                                z = true;
                            }
                            if (canScrollVertically && Math.abs(i4) > this.f2921T) {
                                int i5 = this.f2918Q;
                                int i6 = this.f2921T;
                                if (i4 >= 0) {
                                    i = 1;
                                }
                                this.f2920S = i5 + (i * i6);
                                z = true;
                            }
                            if (z) {
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                setScrollState(1);
                                break;
                            }
                        }
                    } else {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f2915N + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    m2017v();
                    break;
                case 5:
                    this.f2915N = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    int x3 = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                    this.f2919R = x3;
                    this.f2917P = x3;
                    int y3 = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                    this.f2920S = y3;
                    this.f2918Q = y3;
                    break;
                case 6:
                    m1984c(motionEvent);
                    break;
            }
            if (this.f2914M != 1) {
                z2 = false;
            }
            return z2;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mo5517b();
        TraceCompat.beginSection("RV OnLayout");
        mo5562i();
        TraceCompat.endSection();
        mo5507a(false);
        this.f2958w = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2904C) {
            mo5517b();
            m1953C();
            if (this.f2942e.f3029m) {
                boolean unused = this.f2942e.f3027k = true;
            } else {
                this.f2939b.mo5081e();
                boolean unused2 = this.f2942e.f3027k = false;
            }
            this.f2904C = false;
            mo5507a(false);
        }
        if (this.f2950o != null) {
            this.f2942e.f3021e = this.f2950o.getItemCount();
        } else {
            this.f2942e.f3021e = 0;
        }
        if (this.f2951p == null) {
            m1994f(i, i2);
        } else {
            this.f2951p.onMeasure(this.f2925a, this.f2942e, i, i2);
        }
        boolean unused3 = this.f2942e.f3027k = false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.f2946k = (SavedState) parcelable;
        super.onRestoreInstanceState(this.f2946k.getSuperState());
        if (this.f2951p != null && this.f2946k.f3002a != null) {
            this.f2951p.onRestoreInstanceState(this.f2946k.f3002a);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f2946k != null) {
            savedState.m2106a(this.f2946k);
        } else if (this.f2951p != null) {
            savedState.f3002a = this.f2951p.onSaveInstanceState();
        } else {
            savedState.f3002a = null;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            mo5540g();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        boolean z;
        boolean z2 = false;
        if (this.f2961z || this.f2902A) {
            return false;
        }
        if (m1980b(motionEvent)) {
            m2017v();
            return true;
        } else if (this.f2951p == null) {
            return false;
        } else {
            boolean canScrollHorizontally = this.f2951p.canScrollHorizontally();
            boolean canScrollVertically = this.f2951p.canScrollVertically();
            if (this.f2916O == null) {
                this.f2916O = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.f2937al;
                this.f2937al[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.f2937al[0], (float) this.f2937al[1]);
            switch (actionMasked) {
                case 0:
                    this.f2915N = MotionEventCompat.getPointerId(motionEvent, 0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.f2919R = x;
                    this.f2917P = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.f2920S = y;
                    this.f2918Q = y;
                    int i3 = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.f2916O.addMovement(obtain);
                    this.f2916O.computeCurrentVelocity(1000, (float) this.f2923V);
                    float f = canScrollHorizontally ? -VelocityTrackerCompat.getXVelocity(this.f2916O, this.f2915N) : 0.0f;
                    float f2 = canScrollVertically ? -VelocityTrackerCompat.getYVelocity(this.f2916O, this.f2915N) : 0.0f;
                    if ((f == BitmapDescriptorFactory.HUE_RED && f2 == BitmapDescriptorFactory.HUE_RED) || !fling((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    m2016u();
                    z2 = true;
                    break;
                case 2:
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f2915N);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                        int y2 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                        int i4 = this.f2919R - x2;
                        int i5 = this.f2920S - y2;
                        if (dispatchNestedPreScroll(i4, i5, this.f2936ak, this.f2935aj)) {
                            i4 -= this.f2936ak[0];
                            i5 -= this.f2936ak[1];
                            obtain.offsetLocation((float) this.f2935aj[0], (float) this.f2935aj[1]);
                            int[] iArr2 = this.f2937al;
                            iArr2[0] = iArr2[0] + this.f2935aj[0];
                            int[] iArr3 = this.f2937al;
                            iArr3[1] = iArr3[1] + this.f2935aj[1];
                        }
                        if (this.f2914M != 1) {
                            if (!canScrollHorizontally || Math.abs(i) <= this.f2921T) {
                                z = false;
                            } else {
                                i = i > 0 ? i - this.f2921T : i + this.f2921T;
                                z = true;
                            }
                            if (canScrollVertically && Math.abs(i2) > this.f2921T) {
                                i2 = i2 > 0 ? i2 - this.f2921T : i2 + this.f2921T;
                                z = true;
                            }
                            if (z) {
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                setScrollState(1);
                            }
                        }
                        if (this.f2914M == 1) {
                            this.f2919R = x2 - this.f2935aj[0];
                            this.f2920S = y2 - this.f2935aj[1];
                            if (!canScrollHorizontally) {
                                i = 0;
                            }
                            if (!canScrollVertically) {
                                i2 = 0;
                            }
                            if (mo5508a(i, i2, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    } else {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f2915N + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    m2017v();
                    break;
                case 5:
                    this.f2915N = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    int x3 = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                    this.f2919R = x3;
                    this.f2917P = x3;
                    int y3 = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                    this.f2920S = y3;
                    this.f2918Q = y3;
                    break;
                case 6:
                    m1984c(motionEvent);
                    break;
            }
            if (!z2) {
                this.f2916O.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        ViewHolder a = m1956a(view);
        if (a != null) {
            if (a.mo5935o()) {
                a.mo5927h();
            } else if (!a.mo5916c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + a);
            }
        }
        m1989d(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        if (this.f2951p != null) {
            this.f2951p.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.f2953r.remove(itemDecoration);
        if (this.f2953r.isEmpty()) {
            setWillNotDraw(ViewCompat.getOverScrollMode(this) == 2);
        }
        mo5568j();
        requestLayout();
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.f2907F != null) {
            this.f2907F.remove(onChildAttachStateChangeListener);
        }
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.f2954s.remove(onItemTouchListener);
        if (this.f2955t == onItemTouchListener) {
            this.f2955t = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        if (this.f2928ac != null) {
            this.f2928ac.remove(onScrollListener);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2951p.onRequestChildFocus(this, this.f2942e, view, view2) && view2 != null) {
            this.f2949n.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.f2988c) {
                    Rect rect = layoutParams2.f2987b;
                    this.f2949n.left -= rect.left;
                    this.f2949n.right += rect.right;
                    this.f2949n.top -= rect.top;
                    Rect rect2 = this.f2949n;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f2949n);
            offsetRectIntoDescendantCoords(view, this.f2949n);
            requestChildRectangleOnScreen(view, this.f2949n, !this.f2958w);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f2951p.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f2954s.size();
        for (int i = 0; i < size; i++) {
            this.f2954s.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.f2959x || this.f2961z) {
            this.f2960y = true;
        } else {
            super.requestLayout();
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.f2951p == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f2961z) {
            boolean canScrollHorizontally = this.f2951p.canScrollHorizontally();
            boolean canScrollVertically = this.f2951p.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                mo5508a(i, i2, (MotionEvent) null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollToPosition(int i) {
        if (!this.f2961z) {
            stopScroll();
            if (this.f2951p == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.f2951p.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!mo5509a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f2931af = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.f2931af);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        m1961a(adapter, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.f2932ag) {
            this.f2932ag = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.f2932ag != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f2947l) {
            mo5540g();
        }
        this.f2947l = z;
        super.setClipToPadding(z);
        if (this.f2958w) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.f2957v = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.f2941d != null) {
            this.f2941d.endAnimations();
            this.f2941d.mo5663a((ItemAnimator.ItemAnimatorListener) null);
        }
        this.f2941d = itemAnimator;
        if (this.f2941d != null) {
            this.f2941d.mo5663a(this.f2929ad);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f2925a.setViewCacheSize(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f2961z) {
            mo5519b("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f2961z = z;
                if (!(!this.f2960y || this.f2951p == null || this.f2950o == null)) {
                    requestLayout();
                }
                this.f2960y = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0));
            this.f2961z = z;
            this.f2902A = true;
            stopScroll();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.f2951p) {
            if (this.f2951p != null) {
                if (this.f2956u) {
                    this.f2951p.mo5706a(this, this.f2925a);
                }
                this.f2951p.mo5705a((RecyclerView) null);
            }
            this.f2925a.clear();
            this.f2940c.mo5190a();
            this.f2951p = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f2984r != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.f2984r);
                }
                this.f2951p.mo5705a(this);
                if (this.f2956u) {
                    this.f2951p.mo5718b(this);
                }
            }
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f2934ai.setNestedScrollingEnabled(z);
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f2927ab = onScrollListener;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.f2925a.mo5826a(recycledViewPool);
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f2952q = recyclerListener;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.f2921T = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f2921T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.f2925a.mo5827a(viewCacheExtension);
    }

    public void smoothScrollBy(int i, int i2) {
        int i3 = 0;
        if (this.f2951p == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f2961z) {
            if (!this.f2951p.canScrollHorizontally()) {
                i = 0;
            }
            if (this.f2951p.canScrollVertically()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.f2926aa.smoothScrollBy(i, i3);
            }
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.f2961z) {
            if (this.f2951p == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.f2951p.smoothScrollToPosition(this, this.f2942e, i);
            }
        }
    }

    public boolean startNestedScroll(int i) {
        return this.f2934ai.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f2934ai.stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        m2012s();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        m1961a(adapter, true, z);
        m1954D();
        requestLayout();
    }
}
