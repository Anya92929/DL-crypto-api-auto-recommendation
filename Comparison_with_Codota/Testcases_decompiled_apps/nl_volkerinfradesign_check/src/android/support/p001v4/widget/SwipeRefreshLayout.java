package android.support.p001v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.NestedScrollingChild;
import android.support.p001v4.view.NestedScrollingChildHelper;
import android.support.p001v4.view.NestedScrollingParent;
import android.support.p001v4.view.NestedScrollingParentHelper;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.widget.SwipeRefreshLayout */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;

    /* renamed from: a */
    private static final String f1330a = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: w */
    private static final int[] f1331w = {16842766};
    /* access modifiers changed from: private */

    /* renamed from: A */
    public MaterialProgressDrawable f1332A;

    /* renamed from: B */
    private Animation f1333B;

    /* renamed from: C */
    private Animation f1334C;

    /* renamed from: D */
    private Animation f1335D;

    /* renamed from: E */
    private Animation f1336E;

    /* renamed from: F */
    private Animation f1337F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public float f1338G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f1339H;

    /* renamed from: I */
    private int f1340I;

    /* renamed from: J */
    private int f1341J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f1342K;

    /* renamed from: L */
    private Animation.AnimationListener f1343L;

    /* renamed from: M */
    private final Animation f1344M;

    /* renamed from: N */
    private final Animation f1345N;

    /* renamed from: b */
    private View f1346b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnRefreshListener f1347c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f1348d;

    /* renamed from: e */
    private int f1349e;

    /* renamed from: f */
    private float f1350f;

    /* renamed from: g */
    private float f1351g;

    /* renamed from: h */
    private final NestedScrollingParentHelper f1352h;

    /* renamed from: i */
    private final NestedScrollingChildHelper f1353i;

    /* renamed from: j */
    private final int[] f1354j;

    /* renamed from: k */
    private final int[] f1355k;

    /* renamed from: l */
    private boolean f1356l;

    /* renamed from: m */
    private int f1357m;
    protected int mFrom;
    protected int mOriginalOffsetTop;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f1358n;

    /* renamed from: o */
    private boolean f1359o;

    /* renamed from: p */
    private float f1360p;

    /* renamed from: q */
    private float f1361q;

    /* renamed from: r */
    private boolean f1362r;

    /* renamed from: s */
    private int f1363s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f1364t;

    /* renamed from: u */
    private boolean f1365u;

    /* renamed from: v */
    private final DecelerateInterpolator f1366v;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C1108fb f1367x;

    /* renamed from: y */
    private int f1368y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public float f1369z;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* access modifiers changed from: private */
    public void setColorViewAlpha(int i) {
        this.f1367x.getBackground().setAlpha(i);
        this.f1332A.setAlpha(i);
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.f1364t = z;
        this.f1367x.setVisibility(8);
        this.f1358n = i;
        this.mOriginalOffsetTop = i;
        this.f1338G = (float) i2;
        this.f1342K = true;
        this.f1367x.invalidate();
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.f1338G = (float) i;
        this.f1364t = z;
        this.f1367x.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                int i2 = (int) (displayMetrics.density * 56.0f);
                this.f1340I = i2;
                this.f1341J = i2;
            } else {
                int i3 = (int) (displayMetrics.density * 40.0f);
                this.f1340I = i3;
                this.f1341J = i3;
            }
            this.f1367x.setImageDrawable((Drawable) null);
            this.f1332A.mo2774a(i);
            this.f1367x.setImageDrawable(this.f1332A);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1348d = false;
        this.f1350f = -1.0f;
        this.f1354j = new int[2];
        this.f1355k = new int[2];
        this.f1359o = false;
        this.f1363s = -1;
        this.f1368y = -1;
        this.f1343L = new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f1348d) {
                    SwipeRefreshLayout.this.f1332A.setAlpha(255);
                    SwipeRefreshLayout.this.f1332A.start();
                    if (SwipeRefreshLayout.this.f1339H && SwipeRefreshLayout.this.f1347c != null) {
                        SwipeRefreshLayout.this.f1347c.onRefresh();
                    }
                } else {
                    SwipeRefreshLayout.this.f1332A.stop();
                    SwipeRefreshLayout.this.f1367x.setVisibility(8);
                    SwipeRefreshLayout.this.setColorViewAlpha(255);
                    if (SwipeRefreshLayout.this.f1364t) {
                        SwipeRefreshLayout.this.setAnimationProgress(BitmapDescriptorFactory.HUE_RED);
                    } else {
                        SwipeRefreshLayout.this.m2779a(SwipeRefreshLayout.this.mOriginalOffsetTop - SwipeRefreshLayout.this.f1358n, true);
                    }
                }
                int unused = SwipeRefreshLayout.this.f1358n = SwipeRefreshLayout.this.f1367x.getTop();
            }
        };
        this.f1344M = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.f1342K) {
                    i = (int) (SwipeRefreshLayout.this.f1338G - ((float) Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop)));
                } else {
                    i = (int) SwipeRefreshLayout.this.f1338G;
                }
                SwipeRefreshLayout.this.m2779a((((int) (((float) (i - SwipeRefreshLayout.this.mFrom)) * f)) + SwipeRefreshLayout.this.mFrom) - SwipeRefreshLayout.this.f1367x.getTop(), false);
                SwipeRefreshLayout.this.f1332A.mo2772a(1.0f - f);
            }
        };
        this.f1345N = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.m2797c(f);
            }
        };
        this.f1349e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1357m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f1366v = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1331w);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1340I = (int) (displayMetrics.density * 40.0f);
        this.f1341J = (int) (displayMetrics.density * 40.0f);
        m2776a();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.f1338G = displayMetrics.density * 64.0f;
        this.f1350f = this.f1338G;
        this.f1352h = new NestedScrollingParentHelper(this);
        this.f1353i = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f1368y < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f1368y;
        }
        if (i2 >= this.f1368y) {
            return i2 + 1;
        }
        return i2;
    }

    /* renamed from: a */
    private void m2776a() {
        this.f1367x = new C1108fb(getContext(), -328966, 20.0f);
        this.f1332A = new MaterialProgressDrawable(getContext(), this);
        this.f1332A.mo2778b(-328966);
        this.f1367x.setImageDrawable(this.f1332A);
        this.f1367x.setVisibility(8);
        addView(this.f1367x);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f1347c = onRefreshListener;
    }

    /* renamed from: b */
    private boolean m2795b() {
        return Build.VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (!z || this.f1348d == z) {
            m2786a(z, false);
            return;
        }
        this.f1348d = z;
        if (!this.f1342K) {
            i = (int) (this.f1338G + ((float) this.mOriginalOffsetTop));
        } else {
            i = (int) this.f1338G;
        }
        m2779a(i - this.f1358n, true);
        this.f1339H = false;
        m2785a(this.f1343L);
    }

    /* renamed from: a */
    private void m2785a(Animation.AnimationListener animationListener) {
        this.f1367x.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f1332A.setAlpha(255);
        }
        this.f1333B = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.f1333B.setDuration((long) this.f1357m);
        if (animationListener != null) {
            this.f1367x.mo8102a(animationListener);
        }
        this.f1367x.clearAnimation();
        this.f1367x.startAnimation(this.f1333B);
    }

    /* access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (m2795b()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ViewCompat.setScaleX(this.f1367x, f);
        ViewCompat.setScaleY(this.f1367x, f);
    }

    /* renamed from: a */
    private void m2786a(boolean z, boolean z2) {
        if (this.f1348d != z) {
            this.f1339H = z2;
            m2803e();
            this.f1348d = z;
            if (this.f1348d) {
                m2778a(this.f1358n, this.f1343L);
            } else {
                m2794b(this.f1343L);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2794b(Animation.AnimationListener animationListener) {
        this.f1334C = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.f1334C.setDuration(150);
        this.f1367x.mo8102a(animationListener);
        this.f1367x.clearAnimation();
        this.f1367x.startAnimation(this.f1334C);
    }

    /* renamed from: c */
    private void m2796c() {
        this.f1335D = m2775a(this.f1332A.getAlpha(), 76);
    }

    /* renamed from: d */
    private void m2801d() {
        this.f1336E = m2775a(this.f1332A.getAlpha(), 255);
    }

    /* renamed from: a */
    private Animation m2775a(final int i, final int i2) {
        if (this.f1364t && m2795b()) {
            return null;
        }
        C04554 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.f1332A.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        r1.setDuration(300);
        this.f1367x.mo8102a((Animation.AnimationListener) null);
        this.f1367x.clearAnimation();
        this.f1367x.startAnimation(r1);
        return r1;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i) {
        this.f1367x.setBackgroundColor(i);
        this.f1332A.mo2778b(i);
    }

    @Deprecated
    public void setColorScheme(@ColorInt int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    @ColorInt
    public void setColorSchemeColors(int... iArr) {
        m2803e();
        this.f1332A.mo2776a(iArr);
    }

    public boolean isRefreshing() {
        return this.f1348d;
    }

    /* renamed from: e */
    private void m2803e() {
        if (this.f1346b == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f1367x)) {
                    this.f1346b = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f1350f = (float) i;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1346b == null) {
                m2803e();
            }
            if (this.f1346b != null) {
                View view = this.f1346b;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f1367x.getMeasuredWidth();
                this.f1367x.layout((measuredWidth / 2) - (measuredWidth2 / 2), this.f1358n, (measuredWidth / 2) + (measuredWidth2 / 2), this.f1358n + this.f1367x.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1346b == null) {
            m2803e();
        }
        if (this.f1346b != null) {
            this.f1346b.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f1367x.measure(View.MeasureSpec.makeMeasureSpec(this.f1340I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f1341J, 1073741824));
            if (!this.f1342K && !this.f1359o) {
                this.f1359o = true;
                int i3 = -this.f1367x.getMeasuredHeight();
                this.mOriginalOffsetTop = i3;
                this.f1358n = i3;
            }
            this.f1368y = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.f1367x) {
                    this.f1368y = i4;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        if (this.f1367x != null) {
            return this.f1367x.getMeasuredHeight();
        }
        return 0;
    }

    public boolean canChildScrollUp() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.f1346b, -1);
        }
        if (this.f1346b instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f1346b;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        if (ViewCompat.canScrollVertically(this.f1346b, -1) || this.f1346b.getScrollY() > 0) {
            z = true;
        }
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m2803e();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.f1365u && actionMasked == 0) {
            this.f1365u = false;
        }
        if (!isEnabled() || this.f1365u || canChildScrollUp() || this.f1348d || this.f1356l) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                m2779a(this.mOriginalOffsetTop - this.f1367x.getTop(), true);
                this.f1363s = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f1362r = false;
                float a = m2774a(motionEvent, this.f1363s);
                if (a != -1.0f) {
                    this.f1361q = a;
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.f1362r = false;
                this.f1363s = -1;
                break;
            case 2:
                if (this.f1363s == -1) {
                    Log.e(f1330a, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                float a2 = m2774a(motionEvent, this.f1363s);
                if (a2 != -1.0f) {
                    if (a2 - this.f1361q > ((float) this.f1349e) && !this.f1362r) {
                        this.f1360p = this.f1361q + ((float) this.f1349e);
                        this.f1362r = true;
                        this.f1332A.setAlpha(76);
                        break;
                    }
                } else {
                    return false;
                }
            case 6:
                m2784a(motionEvent);
                break;
        }
        return this.f1362r;
    }

    /* renamed from: a */
    private float m2774a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT < 21 && (this.f1346b instanceof AbsListView)) {
            return;
        }
        if (this.f1346b == null || ViewCompat.isNestedScrollingEnabled(this.f1346b)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return isEnabled() && !this.f1365u && !this.f1348d && (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1352h.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f1351g = BitmapDescriptorFactory.HUE_RED;
        this.f1356l = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f1351g > BitmapDescriptorFactory.HUE_RED) {
            if (((float) i2) > this.f1351g) {
                iArr[1] = i2 - ((int) this.f1351g);
                this.f1351g = BitmapDescriptorFactory.HUE_RED;
            } else {
                this.f1351g -= (float) i2;
                iArr[1] = i2;
            }
            m2777a(this.f1351g);
        }
        if (this.f1342K && i2 > 0 && this.f1351g == BitmapDescriptorFactory.HUE_RED && Math.abs(i2 - iArr[1]) > 0) {
            this.f1367x.setVisibility(8);
        }
        int[] iArr2 = this.f1354j;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f1352h.getNestedScrollAxes();
    }

    public void onStopNestedScroll(View view) {
        this.f1352h.onStopNestedScroll(view);
        this.f1356l = false;
        if (this.f1351g > BitmapDescriptorFactory.HUE_RED) {
            m2791b(this.f1351g);
            this.f1351g = BitmapDescriptorFactory.HUE_RED;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f1355k);
        int i5 = this.f1355k[1] + i4;
        if (i5 < 0) {
            this.f1351g = ((float) Math.abs(i5)) + this.f1351g;
            m2777a(this.f1351g);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1353i.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1353i.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.f1353i.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f1353i.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1353i.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1353i.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1353i.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1353i.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1353i.dispatchNestedPreFling(f, f2);
    }

    /* renamed from: a */
    private boolean m2788a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* renamed from: a */
    private void m2777a(float f) {
        this.f1332A.mo2775a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f1350f));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f1350f;
        float f2 = this.f1342K ? this.f1338G - ((float) this.mOriginalOffsetTop) : this.f1338G;
        float max2 = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(abs, f2 * 2.0f) / f2);
        float pow = ((float) (((double) (max2 / 4.0f)) - Math.pow((double) (max2 / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + (f2 * pow * 2.0f))) + this.mOriginalOffsetTop;
        if (this.f1367x.getVisibility() != 0) {
            this.f1367x.setVisibility(0);
        }
        if (!this.f1364t) {
            ViewCompat.setScaleX(this.f1367x, 1.0f);
            ViewCompat.setScaleY(this.f1367x, 1.0f);
        }
        if (f < this.f1350f) {
            if (this.f1364t) {
                setAnimationProgress(f / this.f1350f);
            }
            if (this.f1332A.getAlpha() > 76 && !m2788a(this.f1335D)) {
                m2796c();
            }
            this.f1332A.mo2773a((float) BitmapDescriptorFactory.HUE_RED, Math.min(0.8f, max * 0.8f));
            this.f1332A.mo2772a(Math.min(1.0f, max));
        } else if (this.f1332A.getAlpha() < 255 && !m2788a(this.f1336E)) {
            m2801d();
        }
        this.f1332A.mo2777b((-0.25f + (max * 0.4f) + (pow * 2.0f)) * 0.5f);
        m2779a(i - this.f1358n, true);
    }

    /* renamed from: b */
    private void m2791b(float f) {
        if (f > this.f1350f) {
            m2786a(true, true);
            return;
        }
        this.f1348d = false;
        this.f1332A.mo2773a((float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
        C04565 r0 = null;
        if (!this.f1364t) {
            r0 = new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f1364t) {
                        SwipeRefreshLayout.this.m2794b((Animation.AnimationListener) null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }
            };
        }
        m2792b(this.f1358n, (Animation.AnimationListener) r0);
        this.f1332A.mo2775a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.f1365u && actionMasked == 0) {
            this.f1365u = false;
        }
        if (!isEnabled() || this.f1365u || canChildScrollUp() || this.f1356l) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.f1363s = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f1362r = false;
                break;
            case 1:
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1363s);
                if (findPointerIndex < 0) {
                    Log.e(f1330a, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                this.f1362r = false;
                m2791b((MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f1360p) * 0.5f);
                this.f1363s = -1;
                return false;
            case 2:
                int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, this.f1363s);
                if (findPointerIndex2 < 0) {
                    Log.e(f1330a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y = (MotionEventCompat.getY(motionEvent, findPointerIndex2) - this.f1360p) * 0.5f;
                if (this.f1362r) {
                    if (y > BitmapDescriptorFactory.HUE_RED) {
                        m2777a(y);
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case 3:
                return false;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (actionIndex >= 0) {
                    this.f1363s = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    break;
                } else {
                    Log.e(f1330a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
            case 6:
                m2784a(motionEvent);
                break;
        }
        return true;
    }

    /* renamed from: a */
    private void m2778a(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.f1344M.reset();
        this.f1344M.setDuration(200);
        this.f1344M.setInterpolator(this.f1366v);
        if (animationListener != null) {
            this.f1367x.mo8102a(animationListener);
        }
        this.f1367x.clearAnimation();
        this.f1367x.startAnimation(this.f1344M);
    }

    /* renamed from: b */
    private void m2792b(int i, Animation.AnimationListener animationListener) {
        if (this.f1364t) {
            m2798c(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.f1345N.reset();
        this.f1345N.setDuration(200);
        this.f1345N.setInterpolator(this.f1366v);
        if (animationListener != null) {
            this.f1367x.mo8102a(animationListener);
        }
        this.f1367x.clearAnimation();
        this.f1367x.startAnimation(this.f1345N);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2797c(float f) {
        m2779a((this.mFrom + ((int) (((float) (this.mOriginalOffsetTop - this.mFrom)) * f))) - this.f1367x.getTop(), false);
    }

    /* renamed from: c */
    private void m2798c(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        if (m2795b()) {
            this.f1369z = (float) this.f1332A.getAlpha();
        } else {
            this.f1369z = ViewCompat.getScaleX(this.f1367x);
        }
        this.f1337F = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f1369z + ((-SwipeRefreshLayout.this.f1369z) * f));
                SwipeRefreshLayout.this.m2797c(f);
            }
        };
        this.f1337F.setDuration(150);
        if (animationListener != null) {
            this.f1367x.mo8102a(animationListener);
        }
        this.f1367x.clearAnimation();
        this.f1367x.startAnimation(this.f1337F);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2779a(int i, boolean z) {
        this.f1367x.bringToFront();
        this.f1367x.offsetTopAndBottom(i);
        this.f1358n = this.f1367x.getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    /* renamed from: a */
    private void m2784a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f1363s) {
            this.f1363s = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }
}
