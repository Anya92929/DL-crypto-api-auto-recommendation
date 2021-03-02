package android.support.p003v7.widget.helper;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.p000v4.animation.AnimatorCompatHelper;
import android.support.p000v4.animation.AnimatorListenerCompat;
import android.support.p000v4.animation.AnimatorUpdateListenerCompat;
import android.support.p000v4.animation.ValueAnimatorCompat;
import android.support.p000v4.view.GestureDetectorCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.VelocityTrackerCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.recyclerview.C0273R;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.helper.ItemTouchUIUtilImpl;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.helper.ItemTouchHelper */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;

    /* renamed from: UP */
    public static final int f3289UP = 1;

    /* renamed from: A */
    private long f3290A;

    /* renamed from: a */
    final List<View> f3291a = new ArrayList();

    /* renamed from: b */
    RecyclerView.ViewHolder f3292b = null;

    /* renamed from: c */
    float f3293c;

    /* renamed from: d */
    float f3294d;

    /* renamed from: e */
    float f3295e;

    /* renamed from: f */
    float f3296f;

    /* renamed from: g */
    float f3297g;

    /* renamed from: h */
    float f3298h;

    /* renamed from: i */
    int f3299i = -1;

    /* renamed from: j */
    Callback f3300j;

    /* renamed from: k */
    int f3301k = 0;

    /* renamed from: l */
    int f3302l;

    /* renamed from: m */
    List<RecoverAnimation> f3303m = new ArrayList();

    /* renamed from: n */
    private final float[] f3304n = new float[2];

    /* renamed from: o */
    private int f3305o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RecyclerView f3306p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final Runnable f3307q = new Runnable() {
        public void run() {
            if (ItemTouchHelper.this.f3292b != null && ItemTouchHelper.this.m2437e()) {
                if (ItemTouchHelper.this.f3292b != null) {
                    ItemTouchHelper.this.m2428b(ItemTouchHelper.this.f3292b);
                }
                ItemTouchHelper.this.f3306p.removeCallbacks(ItemTouchHelper.this.f3307q);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.f3306p, this);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public VelocityTracker f3308r;

    /* renamed from: s */
    private List<RecyclerView.ViewHolder> f3309s;

    /* renamed from: t */
    private List<Integer> f3310t;

    /* renamed from: u */
    private RecyclerView.ChildDrawingOrderCallback f3311u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View f3312v = null;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f3313w = -1;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public GestureDetectorCompat f3314x;

    /* renamed from: y */
    private final RecyclerView.OnItemTouchListener f3315y = new RecyclerView.OnItemTouchListener() {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation a;
            ItemTouchHelper.this.f3314x.onTouchEvent(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                ItemTouchHelper.this.f3299i = MotionEventCompat.getPointerId(motionEvent, 0);
                ItemTouchHelper.this.f3293c = motionEvent.getX();
                ItemTouchHelper.this.f3294d = motionEvent.getY();
                ItemTouchHelper.this.m2439f();
                if (ItemTouchHelper.this.f3292b == null && (a = ItemTouchHelper.this.m2432c(motionEvent)) != null) {
                    ItemTouchHelper.this.f3293c -= a.f3340j;
                    ItemTouchHelper.this.f3294d -= a.f3341k;
                    int unused = ItemTouchHelper.this.m2402a(a.f3338h, true);
                    if (ItemTouchHelper.this.f3291a.remove(a.f3338h.itemView)) {
                        ItemTouchHelper.this.f3300j.clearView(ItemTouchHelper.this.f3306p, a.f3338h);
                    }
                    ItemTouchHelper.this.m2409a(a.f3338h, a.f3339i);
                    ItemTouchHelper.this.m2416a(motionEvent, ItemTouchHelper.this.f3302l, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.f3299i = -1;
                ItemTouchHelper.this.m2409a((RecyclerView.ViewHolder) null, 0);
            } else if (ItemTouchHelper.this.f3299i != -1 && (findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, ItemTouchHelper.this.f3299i)) >= 0) {
                boolean unused2 = ItemTouchHelper.this.m2419a(actionMasked, motionEvent, findPointerIndex);
            }
            if (ItemTouchHelper.this.f3308r != null) {
                ItemTouchHelper.this.f3308r.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.f3292b != null;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.m2409a((RecyclerView.ViewHolder) null, 0);
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int i = 0;
            ItemTouchHelper.this.f3314x.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.f3308r != null) {
                ItemTouchHelper.this.f3308r.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f3299i != -1) {
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, ItemTouchHelper.this.f3299i);
                if (findPointerIndex >= 0) {
                    boolean unused = ItemTouchHelper.this.m2419a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.f3292b;
                if (viewHolder != null) {
                    switch (actionMasked) {
                        case 1:
                        case 3:
                            if (ItemTouchHelper.this.f3308r != null) {
                                ItemTouchHelper.this.f3308r.computeCurrentVelocity(1000, (float) ItemTouchHelper.this.f3306p.getMaxFlingVelocity());
                            }
                            ItemTouchHelper.this.m2409a((RecyclerView.ViewHolder) null, 0);
                            ItemTouchHelper.this.f3299i = -1;
                            return;
                        case 2:
                            if (findPointerIndex >= 0) {
                                ItemTouchHelper.this.m2416a(motionEvent, ItemTouchHelper.this.f3302l, findPointerIndex);
                                ItemTouchHelper.this.m2428b(viewHolder);
                                ItemTouchHelper.this.f3306p.removeCallbacks(ItemTouchHelper.this.f3307q);
                                ItemTouchHelper.this.f3307q.run();
                                ItemTouchHelper.this.f3306p.invalidate();
                                return;
                            }
                            return;
                        case 6:
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == ItemTouchHelper.this.f3299i) {
                                if (ItemTouchHelper.this.f3308r != null) {
                                    ItemTouchHelper.this.f3308r.computeCurrentVelocity(1000, (float) ItemTouchHelper.this.f3306p.getMaxFlingVelocity());
                                }
                                if (actionIndex == 0) {
                                    i = 1;
                                }
                                ItemTouchHelper.this.f3299i = MotionEventCompat.getPointerId(motionEvent, i);
                                ItemTouchHelper.this.m2416a(motionEvent, ItemTouchHelper.this.f3302l, actionIndex);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    };

    /* renamed from: z */
    private Rect f3316z;

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$Callback */
    public abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: a */
        private static final ItemTouchUIUtil f3326a;

        /* renamed from: b */
        private static final Interpolator f3327b = new Interpolator() {
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };

        /* renamed from: c */
        private static final Interpolator f3328c = new Interpolator() {
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };

        /* renamed from: d */
        private int f3329d = -1;

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                f3326a = new ItemTouchUIUtilImpl.Lollipop();
            } else if (Build.VERSION.SDK_INT >= 11) {
                f3326a = new ItemTouchUIUtilImpl.Honeycomb();
            } else {
                f3326a = new ItemTouchUIUtilImpl.Gingerbread();
            }
        }

        /* renamed from: a */
        private int m2445a(RecyclerView recyclerView) {
            if (this.f3329d == -1) {
                this.f3329d = recyclerView.getResources().getDimensionPixelSize(C0273R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f3329d;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2446a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.f3338h, recoverAnimation.f3340j, recoverAnimation.f3341k, recoverAnimation.f3339i, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m2449b(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            boolean z;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.f3338h, recoverAnimation.f3340j, recoverAnimation.f3341k, recoverAnimation.f3339i, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            boolean z2 = false;
            int i3 = size - 1;
            while (i3 >= 0) {
                RecoverAnimation recoverAnimation2 = list.get(i3);
                if (!recoverAnimation2.f3333c || recoverAnimation2.mIsPendingCleanup) {
                    z = !recoverAnimation2.f3333c ? true : z2;
                } else {
                    list.remove(i3);
                    recoverAnimation2.f3338h.setIsRecyclable(true);
                    z = z2;
                }
                i3--;
                z2 = z;
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public boolean m2451b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (mo6224a(recyclerView, viewHolder) & 16711680) != 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean m2453c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (mo6224a(recyclerView, viewHolder) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) != 0;
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3 = i & 789516;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            return i2 == 0 ? i4 | (i3 << 2) : i4 | ((i3 << 1) & -789517) | (((i3 << 1) & 789516) << 2);
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return f3326a;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(0, i2 | i) | makeFlag(1, i2) | makeFlag(2, i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final int mo6224a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            RecyclerView.ViewHolder viewHolder2;
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView.ViewHolder viewHolder3;
            int bottom;
            int abs;
            int top;
            int left;
            int right;
            int abs2;
            int width = i + viewHolder.itemView.getWidth();
            int height = i2 + viewHolder.itemView.getHeight();
            RecyclerView.ViewHolder viewHolder4 = null;
            int i7 = -1;
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            int i8 = 0;
            while (i8 < size) {
                RecyclerView.ViewHolder viewHolder5 = list.get(i8);
                if (left2 <= 0 || (right = viewHolder5.itemView.getRight() - width) >= 0 || viewHolder5.itemView.getRight() <= viewHolder.itemView.getRight() || (abs2 = Math.abs(right)) <= i7) {
                    viewHolder2 = viewHolder4;
                    i3 = i7;
                } else {
                    i3 = abs2;
                    viewHolder2 = viewHolder5;
                }
                if (left2 >= 0 || (left = viewHolder5.itemView.getLeft() - i) <= 0 || viewHolder5.itemView.getLeft() >= viewHolder.itemView.getLeft() || (i4 = Math.abs(left)) <= i3) {
                    i4 = i3;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 >= 0 || (top = viewHolder5.itemView.getTop() - i2) <= 0 || viewHolder5.itemView.getTop() >= viewHolder.itemView.getTop() || (i5 = Math.abs(top)) <= i4) {
                    i5 = i4;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 <= 0 || (bottom = viewHolder5.itemView.getBottom() - height) >= 0 || viewHolder5.itemView.getBottom() <= viewHolder.itemView.getBottom() || (abs = Math.abs(bottom)) <= i5) {
                    i6 = i5;
                    viewHolder3 = viewHolder2;
                } else {
                    int i9 = abs;
                    viewHolder3 = viewHolder5;
                    i6 = i9;
                }
                i8++;
                viewHolder4 = viewHolder3;
                i7 = i6;
            }
            return viewHolder4;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            f3326a.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            return i2 == 0 ? i4 | (i3 >> 2) : i4 | ((i3 >> 1) & -3158065) | (((i3 >> 1) & 3158064) >> 2);
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200 : 250 : i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int a = (int) (((float) (m2445a(recyclerView) * ((int) Math.signum((float) i2)))) * f3328c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (f3327b.getInterpolation(f) * ((float) a));
            return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            f3326a.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            f3326a.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                f3326a.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$ItemTouchHelperGestureListener */
    class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private ItemTouchHelperGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder;
            View b = ItemTouchHelper.this.m2425b(motionEvent);
            if (b != null && (childViewHolder = ItemTouchHelper.this.f3306p.getChildViewHolder(b)) != null && ItemTouchHelper.this.f3300j.m2451b(ItemTouchHelper.this.f3306p, childViewHolder) && MotionEventCompat.getPointerId(motionEvent, 0) == ItemTouchHelper.this.f3299i) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, ItemTouchHelper.this.f3299i);
                float x = MotionEventCompat.getX(motionEvent, findPointerIndex);
                float y = MotionEventCompat.getY(motionEvent, findPointerIndex);
                ItemTouchHelper.this.f3293c = x;
                ItemTouchHelper.this.f3294d = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                ItemTouchHelper.this.f3296f = BitmapDescriptorFactory.HUE_RED;
                itemTouchHelper.f3295e = BitmapDescriptorFactory.HUE_RED;
                if (ItemTouchHelper.this.f3300j.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.m2409a(childViewHolder, 2);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation */
    class RecoverAnimation implements AnimatorListenerCompat {

        /* renamed from: a */
        private final ValueAnimatorCompat f3331a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f3332b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f3333c = false;

        /* renamed from: d */
        final float f3334d;

        /* renamed from: e */
        final float f3335e;

        /* renamed from: f */
        final float f3336f;

        /* renamed from: g */
        final float f3337g;

        /* renamed from: h */
        final RecyclerView.ViewHolder f3338h;

        /* renamed from: i */
        final int f3339i;

        /* renamed from: j */
        float f3340j;

        /* renamed from: k */
        float f3341k;

        /* renamed from: l */
        boolean f3342l = false;
        public boolean mIsPendingCleanup;

        /* renamed from: n */
        private float f3344n;

        public RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.f3339i = i2;
            this.f3332b = i;
            this.f3338h = viewHolder;
            this.f3334d = f;
            this.f3335e = f2;
            this.f3336f = f3;
            this.f3337g = f4;
            this.f3331a = AnimatorCompatHelper.emptyValueAnimator();
            this.f3331a.addUpdateListener(new AnimatorUpdateListenerCompat(ItemTouchHelper.this) {
                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    RecoverAnimation.this.setFraction(valueAnimatorCompat.getAnimatedFraction());
                }
            });
            this.f3331a.setTarget(viewHolder.itemView);
            this.f3331a.addListener(this);
            setFraction(BitmapDescriptorFactory.HUE_RED);
        }

        public void cancel() {
            this.f3331a.cancel();
        }

        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
            setFraction(1.0f);
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            this.f3333c = true;
        }

        public void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void setDuration(long j) {
            this.f3331a.setDuration(j);
        }

        public void setFraction(float f) {
            this.f3344n = f;
        }

        public void start() {
            this.f3338h.setIsRecyclable(false);
            this.f3331a.start();
        }

        public void update() {
            if (this.f3334d == this.f3336f) {
                this.f3340j = ViewCompat.getTranslationX(this.f3338h.itemView);
            } else {
                this.f3340j = this.f3334d + (this.f3344n * (this.f3336f - this.f3334d));
            }
            if (this.f3335e == this.f3337g) {
                this.f3341k = ViewCompat.getTranslationY(this.f3338h.itemView);
            } else {
                this.f3341k = this.f3335e + (this.f3344n * (this.f3337g - this.f3335e));
            }
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$SimpleCallback */
    public abstract class SimpleCallback extends Callback {

        /* renamed from: a */
        private int f3347a;

        /* renamed from: b */
        private int f3348b;

        public SimpleCallback(int i, int i2) {
            this.f3347a = i2;
            this.f3348b = i;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f3348b;
        }

        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f3347a;
        }

        public void setDefaultDragDirs(int i) {
            this.f3348b = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.f3347a = i;
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$ViewDropHandler */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(Callback callback) {
        this.f3300j = callback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m2402a(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.f3303m.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f3303m.get(size);
            if (recoverAnimation.f3338h == viewHolder) {
                recoverAnimation.f3342l |= z;
                if (!recoverAnimation.f3333c) {
                    recoverAnimation.cancel();
                }
                this.f3303m.remove(size);
                recoverAnimation.f3338h.setIsRecyclable(true);
                return recoverAnimation.f3332b;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private RecyclerView.ViewHolder m2405a(MotionEvent motionEvent) {
        View b;
        RecyclerView.LayoutManager layoutManager = this.f3306p.getLayoutManager();
        if (this.f3299i == -1) {
            return null;
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f3299i);
        float abs = Math.abs(MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f3293c);
        float abs2 = Math.abs(MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f3294d);
        if (abs < ((float) this.f3305o) && abs2 < ((float) this.f3305o)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (b = m2425b(motionEvent)) != null) {
            return this.f3306p.getChildViewHolder(b);
        }
        return null;
    }

    /* renamed from: a */
    private List<RecyclerView.ViewHolder> m2407a(RecyclerView.ViewHolder viewHolder) {
        if (this.f3309s == null) {
            this.f3309s = new ArrayList();
            this.f3310t = new ArrayList();
        } else {
            this.f3309s.clear();
            this.f3310t.clear();
        }
        int boundingBoxMargin = this.f3300j.getBoundingBoxMargin();
        int round = Math.round(this.f3297g + this.f3295e) - boundingBoxMargin;
        int round2 = Math.round(this.f3298h + this.f3296f) - boundingBoxMargin;
        int width = viewHolder.itemView.getWidth() + round + (boundingBoxMargin * 2);
        int height = viewHolder.itemView.getHeight() + round2 + (boundingBoxMargin * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f3306p.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.f3306p.getChildViewHolder(childAt);
                if (this.f3300j.canDropOver(this.f3306p, this.f3292b, childViewHolder)) {
                    int abs = Math.abs(i - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i2 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i4 = (abs * abs) + (abs2 * abs2);
                    int size = this.f3309s.size();
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < size && i4 > this.f3310t.get(i6).intValue()) {
                        i5++;
                        i6++;
                    }
                    this.f3309s.add(i5, childViewHolder);
                    this.f3310t.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.f3309s;
    }

    /* renamed from: a */
    private void m2408a() {
        this.f3305o = ViewConfiguration.get(this.f3306p.getContext()).getScaledTouchSlop();
        this.f3306p.addItemDecoration(this);
        this.f3306p.addOnItemTouchListener(this.f3315y);
        this.f3306p.addOnChildAttachStateChangeListener(this);
        m2433c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2409a(RecyclerView.ViewHolder viewHolder, int i) {
        float f;
        float signum;
        if (viewHolder != this.f3292b || i != this.f3301k) {
            this.f3290A = Long.MIN_VALUE;
            int i2 = this.f3301k;
            m2402a(viewHolder, true);
            this.f3301k = i;
            if (i == 2) {
                this.f3312v = viewHolder.itemView;
                m2442h();
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            boolean z = false;
            if (this.f3292b != null) {
                RecyclerView.ViewHolder viewHolder2 = this.f3292b;
                if (viewHolder2.itemView.getParent() != null) {
                    final int c = i2 == 2 ? 0 : m2429c(viewHolder2);
                    m2441g();
                    switch (c) {
                        case 1:
                        case 2:
                            f = BitmapDescriptorFactory.HUE_RED;
                            signum = Math.signum(this.f3296f) * ((float) this.f3306p.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = BitmapDescriptorFactory.HUE_RED;
                            f = Math.signum(this.f3295e) * ((float) this.f3306p.getWidth());
                            break;
                        default:
                            f = BitmapDescriptorFactory.HUE_RED;
                            signum = BitmapDescriptorFactory.HUE_RED;
                            break;
                    }
                    int i4 = i2 == 2 ? 8 : c > 0 ? 2 : 4;
                    m2418a(this.f3304n);
                    float f2 = this.f3304n[0];
                    float f3 = this.f3304n[1];
                    final RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                    C03363 r0 = new RecoverAnimation(viewHolder2, i4, i2, f2, f3, f, signum) {
                        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
                            super.onAnimationEnd(valueAnimatorCompat);
                            if (!this.f3342l) {
                                if (c <= 0) {
                                    ItemTouchHelper.this.f3300j.clearView(ItemTouchHelper.this.f3306p, viewHolder3);
                                } else {
                                    ItemTouchHelper.this.f3291a.add(viewHolder3.itemView);
                                    this.mIsPendingCleanup = true;
                                    if (c > 0) {
                                        ItemTouchHelper.this.m2410a((RecoverAnimation) this, c);
                                    }
                                }
                                if (ItemTouchHelper.this.f3312v == viewHolder3.itemView) {
                                    ItemTouchHelper.this.m2417a(viewHolder3.itemView);
                                }
                            }
                        }
                    };
                    r0.setDuration(this.f3300j.getAnimationDuration(this.f3306p, i4, f - f2, signum - f3));
                    this.f3303m.add(r0);
                    r0.start();
                    z = true;
                } else {
                    m2417a(viewHolder2.itemView);
                    this.f3300j.clearView(this.f3306p, viewHolder2);
                }
                this.f3292b = null;
            }
            boolean z2 = z;
            if (viewHolder != null) {
                this.f3302l = (this.f3300j.mo6224a(this.f3306p, viewHolder) & i3) >> (this.f3301k * 8);
                this.f3297g = (float) viewHolder.itemView.getLeft();
                this.f3298h = (float) viewHolder.itemView.getTop();
                this.f3292b = viewHolder;
                if (i == 2) {
                    this.f3292b.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.f3306p.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.f3292b != null);
            }
            if (!z2) {
                this.f3306p.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.f3300j.onSelectedChanged(this.f3292b, this.f3301k);
            this.f3306p.invalidate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2410a(final RecoverAnimation recoverAnimation, final int i) {
        this.f3306p.post(new Runnable() {
            public void run() {
                if (ItemTouchHelper.this.f3306p != null && ItemTouchHelper.this.f3306p.isAttachedToWindow() && !recoverAnimation.f3342l && recoverAnimation.f3338h.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.f3306p.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !ItemTouchHelper.this.m2435d()) {
                        ItemTouchHelper.this.f3300j.onSwiped(recoverAnimation.f3338h, i);
                    } else {
                        ItemTouchHelper.this.f3306p.post(this);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2416a(MotionEvent motionEvent, int i, int i2) {
        float x = MotionEventCompat.getX(motionEvent, i2);
        float y = MotionEventCompat.getY(motionEvent, i2);
        this.f3295e = x - this.f3293c;
        this.f3296f = y - this.f3294d;
        if ((i & 4) == 0) {
            this.f3295e = Math.max(BitmapDescriptorFactory.HUE_RED, this.f3295e);
        }
        if ((i & 8) == 0) {
            this.f3295e = Math.min(BitmapDescriptorFactory.HUE_RED, this.f3295e);
        }
        if ((i & 1) == 0) {
            this.f3296f = Math.max(BitmapDescriptorFactory.HUE_RED, this.f3296f);
        }
        if ((i & 2) == 0) {
            this.f3296f = Math.min(BitmapDescriptorFactory.HUE_RED, this.f3296f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2417a(View view) {
        if (view == this.f3312v) {
            this.f3312v = null;
            if (this.f3311u != null) {
                this.f3306p.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback) null);
            }
        }
    }

    /* renamed from: a */
    private void m2418a(float[] fArr) {
        if ((this.f3302l & 12) != 0) {
            fArr[0] = (this.f3297g + this.f3295e) - ((float) this.f3292b.itemView.getLeft());
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.f3292b.itemView);
        }
        if ((this.f3302l & 3) != 0) {
            fArr[1] = (this.f3298h + this.f3296f) - ((float) this.f3292b.itemView.getTop());
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.f3292b.itemView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2419a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder a;
        int a2;
        if (this.f3292b != null || i != 2 || this.f3301k == 2 || !this.f3300j.isItemViewSwipeEnabled() || this.f3306p.getScrollState() == 1 || (a = m2405a(motionEvent)) == null || (a2 = (this.f3300j.mo6224a(this.f3306p, a) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) == 0) {
            return false;
        }
        float x = MotionEventCompat.getX(motionEvent, i2);
        float y = MotionEventCompat.getY(motionEvent, i2);
        float f = x - this.f3293c;
        float f2 = y - this.f3294d;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (abs < ((float) this.f3305o) && abs2 < ((float) this.f3305o)) {
            return false;
        }
        if (abs > abs2) {
            if (f < BitmapDescriptorFactory.HUE_RED && (a2 & 4) == 0) {
                return false;
            }
            if (f > BitmapDescriptorFactory.HUE_RED && (a2 & 8) == 0) {
                return false;
            }
        } else if (f2 < BitmapDescriptorFactory.HUE_RED && (a2 & 1) == 0) {
            return false;
        } else {
            if (f2 > BitmapDescriptorFactory.HUE_RED && (a2 & 2) == 0) {
                return false;
            }
        }
        this.f3296f = BitmapDescriptorFactory.HUE_RED;
        this.f3295e = BitmapDescriptorFactory.HUE_RED;
        this.f3299i = MotionEventCompat.getPointerId(motionEvent, 0);
        m2409a(a, 1);
        return true;
    }

    /* renamed from: a */
    private static boolean m2422a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    /* renamed from: b */
    private int m2423b(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.f3295e > BitmapDescriptorFactory.HUE_RED ? 8 : 4;
            if (this.f3308r != null && this.f3299i > -1) {
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.f3308r, this.f3299i);
                if (xVelocity <= BitmapDescriptorFactory.HUE_RED) {
                    i2 = 4;
                }
                if ((i2 & i) != 0 && i3 == i2 && Math.abs(xVelocity) >= ((float) this.f3306p.getMinFlingVelocity())) {
                    return i2;
                }
            }
            float width = ((float) this.f3306p.getWidth()) * this.f3300j.getSwipeThreshold(viewHolder);
            if ((i & i3) == 0 || Math.abs(this.f3295e) <= width) {
                return 0;
            }
            return i3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public View m2425b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f3292b != null) {
            View view = this.f3292b.itemView;
            if (m2422a(view, x, y, this.f3297g + this.f3295e, this.f3298h + this.f3296f)) {
                return view;
            }
        }
        for (int size = this.f3303m.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f3303m.get(size);
            View view2 = recoverAnimation.f3338h.itemView;
            if (m2422a(view2, x, y, recoverAnimation.f3340j, recoverAnimation.f3341k)) {
                return view2;
            }
        }
        return this.f3306p.findChildViewUnder(x, y);
    }

    /* renamed from: b */
    private void m2427b() {
        this.f3306p.removeItemDecoration(this);
        this.f3306p.removeOnItemTouchListener(this.f3315y);
        this.f3306p.removeOnChildAttachStateChangeListener(this);
        for (int size = this.f3303m.size() - 1; size >= 0; size--) {
            this.f3300j.clearView(this.f3306p, this.f3303m.get(0).f3338h);
        }
        this.f3303m.clear();
        this.f3312v = null;
        this.f3313w = -1;
        m2441g();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2428b(RecyclerView.ViewHolder viewHolder) {
        if (!this.f3306p.isLayoutRequested() && this.f3301k == 2) {
            float moveThreshold = this.f3300j.getMoveThreshold(viewHolder);
            int i = (int) (this.f3297g + this.f3295e);
            int i2 = (int) (this.f3298h + this.f3296f);
            if (((float) Math.abs(i2 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i - viewHolder.itemView.getLeft())) >= moveThreshold * ((float) viewHolder.itemView.getWidth())) {
                List<RecyclerView.ViewHolder> a = m2407a(viewHolder);
                if (a.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.f3300j.chooseDropTarget(viewHolder, a, i, i2);
                    if (chooseDropTarget == null) {
                        this.f3309s.clear();
                        this.f3310t.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.f3300j.onMove(this.f3306p, viewHolder, chooseDropTarget)) {
                        this.f3300j.onMoved(this.f3306p, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private int m2429c(RecyclerView.ViewHolder viewHolder) {
        if (this.f3301k == 2) {
            return 0;
        }
        int movementFlags = this.f3300j.getMovementFlags(this.f3306p, viewHolder);
        int convertToAbsoluteDirection = (this.f3300j.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.f3306p)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (Math.abs(this.f3295e) > Math.abs(this.f3296f)) {
            int b = m2423b(viewHolder, convertToAbsoluteDirection);
            if (b > 0) {
                return (i & b) == 0 ? Callback.convertToRelativeDirection(b, ViewCompat.getLayoutDirection(this.f3306p)) : b;
            }
            int c = m2430c(viewHolder, convertToAbsoluteDirection);
            if (c > 0) {
                return c;
            }
            return 0;
        }
        int c2 = m2430c(viewHolder, convertToAbsoluteDirection);
        if (c2 > 0) {
            return c2;
        }
        int b2 = m2423b(viewHolder, convertToAbsoluteDirection);
        if (b2 > 0) {
            return (i & b2) == 0 ? Callback.convertToRelativeDirection(b2, ViewCompat.getLayoutDirection(this.f3306p)) : b2;
        }
        return 0;
    }

    /* renamed from: c */
    private int m2430c(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.f3296f > BitmapDescriptorFactory.HUE_RED ? 2 : 1;
            if (this.f3308r != null && this.f3299i > -1) {
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.f3308r, this.f3299i);
                if (yVelocity <= BitmapDescriptorFactory.HUE_RED) {
                    i2 = 1;
                }
                if ((i2 & i) != 0 && i2 == i3 && Math.abs(yVelocity) >= ((float) this.f3306p.getMinFlingVelocity())) {
                    return i2;
                }
            }
            float height = ((float) this.f3306p.getHeight()) * this.f3300j.getSwipeThreshold(viewHolder);
            if ((i & i3) == 0 || Math.abs(this.f3296f) <= height) {
                return 0;
            }
            return i3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public RecoverAnimation m2432c(MotionEvent motionEvent) {
        if (this.f3303m.isEmpty()) {
            return null;
        }
        View b = m2425b(motionEvent);
        for (int size = this.f3303m.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f3303m.get(size);
            if (recoverAnimation.f3338h.itemView == b) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* renamed from: c */
    private void m2433c() {
        if (this.f3314x == null) {
            this.f3314x = new GestureDetectorCompat(this.f3306p.getContext(), new ItemTouchHelperGestureListener());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m2435d() {
        int size = this.f3303m.size();
        for (int i = 0; i < size; i++) {
            if (!this.f3303m.get(i).f3333c) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r4 < 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        if (r8 < 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e4, code lost:
        if (r4 > 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010c, code lost:
        if (r8 > 0) goto L_0x0075;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2437e() {
        /*
            r14 = this;
            r12 = -9223372036854775808
            r0 = 0
            r5 = 0
            android.support.v7.widget.RecyclerView$ViewHolder r1 = r14.f3292b
            if (r1 != 0) goto L_0x000b
            r14.f3290A = r12
        L_0x000a:
            return r0
        L_0x000b:
            long r10 = java.lang.System.currentTimeMillis()
            long r2 = r14.f3290A
            int r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x00bb
            r6 = 0
        L_0x0017:
            android.support.v7.widget.RecyclerView r1 = r14.f3306p
            android.support.v7.widget.RecyclerView$LayoutManager r1 = r1.getLayoutManager()
            android.graphics.Rect r2 = r14.f3316z
            if (r2 != 0) goto L_0x0028
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r14.f3316z = r2
        L_0x0028:
            android.support.v7.widget.RecyclerView$ViewHolder r2 = r14.f3292b
            android.view.View r2 = r2.itemView
            android.graphics.Rect r3 = r14.f3316z
            r1.calculateItemDecorationsForChild(r2, r3)
            boolean r2 = r1.canScrollHorizontally()
            if (r2 == 0) goto L_0x00e6
            float r2 = r14.f3297g
            float r3 = r14.f3295e
            float r2 = r2 + r3
            int r2 = (int) r2
            android.graphics.Rect r3 = r14.f3316z
            int r3 = r3.left
            int r3 = r2 - r3
            android.support.v7.widget.RecyclerView r4 = r14.f3306p
            int r4 = r4.getPaddingLeft()
            int r4 = r3 - r4
            float r3 = r14.f3295e
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x00c1
            if (r4 >= 0) goto L_0x00c1
        L_0x0053:
            boolean r1 = r1.canScrollVertically()
            if (r1 == 0) goto L_0x010e
            float r1 = r14.f3298h
            float r2 = r14.f3296f
            float r1 = r1 + r2
            int r1 = (int) r1
            android.graphics.Rect r2 = r14.f3316z
            int r2 = r2.top
            int r2 = r1 - r2
            android.support.v7.widget.RecyclerView r3 = r14.f3306p
            int r3 = r3.getPaddingTop()
            int r8 = r2 - r3
            float r2 = r14.f3296f
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x00e9
            if (r8 >= 0) goto L_0x00e9
        L_0x0075:
            if (r4 == 0) goto L_0x0117
            android.support.v7.widget.helper.ItemTouchHelper$Callback r1 = r14.f3300j
            android.support.v7.widget.RecyclerView r2 = r14.f3306p
            android.support.v7.widget.RecyclerView$ViewHolder r3 = r14.f3292b
            android.view.View r3 = r3.itemView
            int r3 = r3.getWidth()
            android.support.v7.widget.RecyclerView r5 = r14.f3306p
            int r5 = r5.getWidth()
            int r4 = r1.interpolateOutOfBoundsScroll(r2, r3, r4, r5, r6)
            r9 = r4
        L_0x008e:
            if (r8 == 0) goto L_0x0115
            android.support.v7.widget.helper.ItemTouchHelper$Callback r1 = r14.f3300j
            android.support.v7.widget.RecyclerView r2 = r14.f3306p
            android.support.v7.widget.RecyclerView$ViewHolder r3 = r14.f3292b
            android.view.View r3 = r3.itemView
            int r3 = r3.getHeight()
            android.support.v7.widget.RecyclerView r4 = r14.f3306p
            int r5 = r4.getHeight()
            r4 = r8
            int r1 = r1.interpolateOutOfBoundsScroll(r2, r3, r4, r5, r6)
        L_0x00a7:
            if (r9 != 0) goto L_0x00ab
            if (r1 == 0) goto L_0x0111
        L_0x00ab:
            long r2 = r14.f3290A
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x00b3
            r14.f3290A = r10
        L_0x00b3:
            android.support.v7.widget.RecyclerView r0 = r14.f3306p
            r0.scrollBy(r9, r1)
            r0 = 1
            goto L_0x000a
        L_0x00bb:
            long r2 = r14.f3290A
            long r6 = r10 - r2
            goto L_0x0017
        L_0x00c1:
            float r3 = r14.f3295e
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e6
            android.support.v7.widget.RecyclerView$ViewHolder r3 = r14.f3292b
            android.view.View r3 = r3.itemView
            int r3 = r3.getWidth()
            int r2 = r2 + r3
            android.graphics.Rect r3 = r14.f3316z
            int r3 = r3.right
            int r2 = r2 + r3
            android.support.v7.widget.RecyclerView r3 = r14.f3306p
            int r3 = r3.getWidth()
            android.support.v7.widget.RecyclerView r4 = r14.f3306p
            int r4 = r4.getPaddingRight()
            int r3 = r3 - r4
            int r4 = r2 - r3
            if (r4 > 0) goto L_0x0053
        L_0x00e6:
            r4 = r0
            goto L_0x0053
        L_0x00e9:
            float r2 = r14.f3296f
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x010e
            android.support.v7.widget.RecyclerView$ViewHolder r2 = r14.f3292b
            android.view.View r2 = r2.itemView
            int r2 = r2.getHeight()
            int r1 = r1 + r2
            android.graphics.Rect r2 = r14.f3316z
            int r2 = r2.bottom
            int r1 = r1 + r2
            android.support.v7.widget.RecyclerView r2 = r14.f3306p
            int r2 = r2.getHeight()
            android.support.v7.widget.RecyclerView r3 = r14.f3306p
            int r3 = r3.getPaddingBottom()
            int r2 = r2 - r3
            int r8 = r1 - r2
            if (r8 > 0) goto L_0x0075
        L_0x010e:
            r8 = r0
            goto L_0x0075
        L_0x0111:
            r14.f3290A = r12
            goto L_0x000a
        L_0x0115:
            r1 = r8
            goto L_0x00a7
        L_0x0117:
            r9 = r4
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.helper.ItemTouchHelper.m2437e():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2439f() {
        if (this.f3308r != null) {
            this.f3308r.recycle();
        }
        this.f3308r = VelocityTracker.obtain();
    }

    /* renamed from: g */
    private void m2441g() {
        if (this.f3308r != null) {
            this.f3308r.recycle();
            this.f3308r = null;
        }
    }

    /* renamed from: h */
    private void m2442h() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f3311u == null) {
                this.f3311u = new RecyclerView.ChildDrawingOrderCallback() {
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.f3312v == null) {
                            return i2;
                        }
                        int i3 = ItemTouchHelper.this.f3313w;
                        if (i3 == -1) {
                            i3 = ItemTouchHelper.this.f3306p.indexOfChild(ItemTouchHelper.this.f3312v);
                            int unused = ItemTouchHelper.this.f3313w = i3;
                        }
                        return i2 == i + -1 ? i3 : i2 >= i3 ? i2 + 1 : i2;
                    }
                };
            }
            this.f3306p.setChildDrawingOrderCallback(this.f3311u);
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (this.f3306p != recyclerView) {
            if (this.f3306p != null) {
                m2427b();
            }
            this.f3306p = recyclerView;
            if (this.f3306p != null) {
                m2408a();
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        m2417a(view);
        RecyclerView.ViewHolder childViewHolder = this.f3306p.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.f3292b == null || childViewHolder != this.f3292b) {
                m2402a(childViewHolder, false);
                if (this.f3291a.remove(childViewHolder.itemView)) {
                    this.f3300j.clearView(this.f3306p, childViewHolder);
                    return;
                }
                return;
            }
            m2409a((RecyclerView.ViewHolder) null, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        this.f3313w = -1;
        if (this.f3292b != null) {
            m2418a(this.f3304n);
            f = this.f3304n[0];
            f2 = this.f3304n[1];
        } else {
            f = 0.0f;
        }
        this.f3300j.m2446a(canvas, recyclerView, this.f3292b, this.f3303m, this.f3301k, f, f2);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        if (this.f3292b != null) {
            m2418a(this.f3304n);
            f = this.f3304n[0];
            f2 = this.f3304n[1];
        } else {
            f = 0.0f;
        }
        this.f3300j.m2449b(canvas, recyclerView, this.f3292b, this.f3303m, this.f3301k, f, f2);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.f3300j.m2451b(this.f3306p, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.f3306p) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            m2439f();
            this.f3296f = BitmapDescriptorFactory.HUE_RED;
            this.f3295e = BitmapDescriptorFactory.HUE_RED;
            m2409a(viewHolder, 2);
        }
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.f3300j.m2453c(this.f3306p, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.f3306p) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            m2439f();
            this.f3296f = BitmapDescriptorFactory.HUE_RED;
            this.f3295e = BitmapDescriptorFactory.HUE_RED;
            m2409a(viewHolder, 1);
        }
    }
}
