package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.NestedScrollingChild;
import android.support.p000v4.view.NestedScrollingChildHelper;
import android.support.p000v4.view.NestedScrollingParent;
import android.support.p000v4.view.NestedScrollingParentHelper;
import android.support.p000v4.view.ViewCompat;
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

    /* renamed from: c */
    private static final String f1645c = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: w */
    private static final int[] f1646w = {16842766};
    /* access modifiers changed from: private */

    /* renamed from: A */
    public MaterialProgressDrawable f1647A;

    /* renamed from: B */
    private Animation f1648B;

    /* renamed from: C */
    private Animation f1649C;

    /* renamed from: D */
    private Animation f1650D;

    /* renamed from: E */
    private Animation f1651E;

    /* renamed from: F */
    private Animation f1652F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public float f1653G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f1654H;

    /* renamed from: I */
    private int f1655I;

    /* renamed from: J */
    private int f1656J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f1657K;

    /* renamed from: L */
    private Animation.AnimationListener f1658L;

    /* renamed from: M */
    private final Animation f1659M;

    /* renamed from: N */
    private final Animation f1660N;

    /* renamed from: O */
    private final Animation f1661O;

    /* renamed from: a */
    protected int f1662a;

    /* renamed from: b */
    protected int f1663b;

    /* renamed from: d */
    private View f1664d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnRefreshListener f1665e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f1666f;

    /* renamed from: g */
    private int f1667g;

    /* renamed from: h */
    private float f1668h;

    /* renamed from: i */
    private float f1669i;

    /* renamed from: j */
    private final NestedScrollingParentHelper f1670j;

    /* renamed from: k */
    private final NestedScrollingChildHelper f1671k;

    /* renamed from: l */
    private final int[] f1672l;

    /* renamed from: m */
    private int f1673m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f1674n;

    /* renamed from: o */
    private boolean f1675o;

    /* renamed from: p */
    private float f1676p;

    /* renamed from: q */
    private float f1677q;

    /* renamed from: r */
    private boolean f1678r;

    /* renamed from: s */
    private int f1679s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f1680t;

    /* renamed from: u */
    private boolean f1681u;

    /* renamed from: v */
    private final DecelerateInterpolator f1682v;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public CircleImageView f1683x;

    /* renamed from: y */
    private int f1684y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public float f1685z;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener */
    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1666f = false;
        this.f1668h = -1.0f;
        this.f1672l = new int[2];
        this.f1675o = false;
        this.f1679s = -1;
        this.f1684y = -1;
        this.f1658L = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f1666f) {
                    SwipeRefreshLayout.this.f1647A.setAlpha(255);
                    SwipeRefreshLayout.this.f1647A.start();
                    if (SwipeRefreshLayout.this.f1654H && SwipeRefreshLayout.this.f1665e != null) {
                        SwipeRefreshLayout.this.f1665e.onRefresh();
                    }
                } else {
                    SwipeRefreshLayout.this.f1647A.stop();
                    SwipeRefreshLayout.this.f1683x.setVisibility(8);
                    SwipeRefreshLayout.this.setColorViewAlpha(255);
                    if (SwipeRefreshLayout.this.f1680t) {
                        SwipeRefreshLayout.this.setAnimationProgress(BitmapDescriptorFactory.HUE_RED);
                    } else {
                        SwipeRefreshLayout.this.m1168a(SwipeRefreshLayout.this.f1663b - SwipeRefreshLayout.this.f1674n, true);
                    }
                }
                int unused = SwipeRefreshLayout.this.f1674n = SwipeRefreshLayout.this.f1683x.getTop();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.f1659M = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.m1168a((((int) (((float) ((!SwipeRefreshLayout.this.f1657K ? (int) (SwipeRefreshLayout.this.f1653G - ((float) Math.abs(SwipeRefreshLayout.this.f1663b))) : (int) SwipeRefreshLayout.this.f1653G) - SwipeRefreshLayout.this.f1662a)) * f)) + SwipeRefreshLayout.this.f1662a) - SwipeRefreshLayout.this.f1683x.getTop(), false);
                SwipeRefreshLayout.this.f1647A.setArrowScale(1.0f - f);
            }
        };
        this.f1660N = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.m1168a((((int) (((float) ((!SwipeRefreshLayout.this.f1657K ? (int) (SwipeRefreshLayout.this.f1653G - ((float) Math.abs(SwipeRefreshLayout.this.f1663b))) : (int) SwipeRefreshLayout.this.f1653G) - SwipeRefreshLayout.this.f1662a)) * f)) + SwipeRefreshLayout.this.f1662a) - SwipeRefreshLayout.this.f1683x.getTop(), false);
                SwipeRefreshLayout.this.f1647A.setArrowScale(1.0f - f);
            }
        };
        this.f1661O = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.m1186c(f);
            }
        };
        this.f1667g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1673m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f1682v = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1646w);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1655I = (int) (displayMetrics.density * 40.0f);
        this.f1656J = (int) (displayMetrics.density * 40.0f);
        m1165a();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.f1653G = displayMetrics.density * 64.0f;
        this.f1668h = this.f1653G;
        this.f1670j = new NestedScrollingParentHelper(this);
        this.f1671k = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    /* renamed from: a */
    private float m1163a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    /* renamed from: a */
    private Animation m1164a(final int i, final int i2) {
        if (this.f1680t && m1184b()) {
            return null;
        }
        C02104 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.f1647A.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        r1.setDuration(300);
        this.f1683x.setAnimationListener((Animation.AnimationListener) null);
        this.f1683x.clearAnimation();
        this.f1683x.startAnimation(r1);
        return r1;
    }

    /* renamed from: a */
    private void m1165a() {
        this.f1683x = new CircleImageView(getContext(), -328966, 20.0f);
        this.f1647A = new MaterialProgressDrawable(getContext(), this);
        this.f1647A.setBackgroundColor(-328966);
        this.f1683x.setImageDrawable(this.f1647A);
        this.f1683x.setVisibility(8);
        addView(this.f1683x);
    }

    /* renamed from: a */
    private void m1166a(float f) {
        this.f1647A.showArrow(true);
        float min = Math.min(1.0f, Math.abs(f / this.f1668h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f1668h;
        float f2 = this.f1657K ? this.f1653G - ((float) this.f1663b) : this.f1653G;
        float max2 = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(abs, f2 * 2.0f) / f2);
        float pow = ((float) (((double) (max2 / 4.0f)) - Math.pow((double) (max2 / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + (f2 * pow * 2.0f))) + this.f1663b;
        if (this.f1683x.getVisibility() != 0) {
            this.f1683x.setVisibility(0);
        }
        if (!this.f1680t) {
            ViewCompat.setScaleX(this.f1683x, 1.0f);
            ViewCompat.setScaleY(this.f1683x, 1.0f);
        }
        if (f < this.f1668h) {
            if (this.f1680t) {
                setAnimationProgress(f / this.f1668h);
            }
            if (this.f1647A.getAlpha() > 76 && !m1177a(this.f1650D)) {
                m1185c();
            }
            this.f1647A.setStartEndTrim(BitmapDescriptorFactory.HUE_RED, Math.min(0.8f, max * 0.8f));
            this.f1647A.setArrowScale(Math.min(1.0f, max));
        } else if (this.f1647A.getAlpha() < 255 && !m1177a(this.f1651E)) {
            m1190d();
        }
        this.f1647A.setProgressRotation((-0.25f + (max * 0.4f) + (pow * 2.0f)) * 0.5f);
        m1168a(i - this.f1674n, true);
    }

    /* renamed from: a */
    private void m1167a(int i, Animation.AnimationListener animationListener) {
        this.f1662a = i;
        this.f1659M.reset();
        this.f1659M.setDuration(200);
        this.f1659M.setInterpolator(this.f1682v);
        if (animationListener != null) {
            this.f1683x.setAnimationListener(animationListener);
        }
        this.f1683x.clearAnimation();
        this.f1683x.startAnimation(this.f1659M);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1168a(int i, boolean z) {
        this.f1683x.bringToFront();
        this.f1683x.offsetTopAndBottom(i);
        this.f1674n = this.f1683x.getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    /* renamed from: a */
    private void m1173a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f1679s) {
            this.f1679s = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }

    /* renamed from: a */
    private void m1174a(Animation.AnimationListener animationListener) {
        this.f1683x.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f1647A.setAlpha(255);
        }
        this.f1648B = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.f1648B.setDuration((long) this.f1673m);
        if (animationListener != null) {
            this.f1683x.setAnimationListener(animationListener);
        }
        this.f1683x.clearAnimation();
        this.f1683x.startAnimation(this.f1648B);
    }

    /* renamed from: a */
    private void m1175a(boolean z, boolean z2) {
        if (this.f1666f != z) {
            this.f1654H = z2;
            m1192e();
            this.f1666f = z;
            if (this.f1666f) {
                m1167a(this.f1674n, this.f1658L);
            } else {
                m1183b(this.f1658L);
            }
        }
    }

    /* renamed from: a */
    private boolean m1177a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* renamed from: b */
    private void m1180b(float f) {
        if (f > this.f1668h) {
            m1175a(true, true);
            return;
        }
        this.f1666f = false;
        this.f1647A.setStartEndTrim(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        C02115 r0 = null;
        if (!this.f1680t) {
            r0 = new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f1680t) {
                        SwipeRefreshLayout.this.m1183b((Animation.AnimationListener) null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
        }
        m1181b(this.f1674n, (Animation.AnimationListener) r0);
        this.f1647A.showArrow(false);
    }

    /* renamed from: b */
    private void m1181b(int i, Animation.AnimationListener animationListener) {
        if (this.f1680t) {
            m1187c(i, animationListener);
            return;
        }
        this.f1662a = i;
        this.f1661O.reset();
        this.f1661O.setDuration(200);
        this.f1661O.setInterpolator(this.f1682v);
        if (animationListener != null) {
            this.f1683x.setAnimationListener(animationListener);
        }
        this.f1683x.clearAnimation();
        this.f1683x.startAnimation(this.f1661O);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1183b(Animation.AnimationListener animationListener) {
        this.f1649C = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.f1649C.setDuration(150);
        this.f1683x.setAnimationListener(animationListener);
        this.f1683x.clearAnimation();
        this.f1683x.startAnimation(this.f1649C);
    }

    /* renamed from: b */
    private boolean m1184b() {
        return Build.VERSION.SDK_INT < 11;
    }

    /* renamed from: c */
    private void m1185c() {
        this.f1650D = m1164a(this.f1647A.getAlpha(), 76);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1186c(float f) {
        m1168a((this.f1662a + ((int) (((float) (this.f1663b - this.f1662a)) * f))) - this.f1683x.getTop(), false);
    }

    /* renamed from: c */
    private void m1187c(int i, Animation.AnimationListener animationListener) {
        this.f1662a = i;
        if (m1184b()) {
            this.f1685z = (float) this.f1647A.getAlpha();
        } else {
            this.f1685z = ViewCompat.getScaleX(this.f1683x);
        }
        this.f1652F = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f1685z + ((-SwipeRefreshLayout.this.f1685z) * f));
                SwipeRefreshLayout.this.m1186c(f);
            }
        };
        this.f1652F.setDuration(150);
        if (animationListener != null) {
            this.f1683x.setAnimationListener(animationListener);
        }
        this.f1683x.clearAnimation();
        this.f1683x.startAnimation(this.f1652F);
    }

    /* renamed from: d */
    private void m1190d() {
        this.f1651E = m1164a(this.f1647A.getAlpha(), 255);
    }

    /* renamed from: e */
    private void m1192e() {
        if (this.f1664d == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f1683x)) {
                    this.f1664d = childAt;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (m1184b()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ViewCompat.setScaleX(this.f1683x, f);
        ViewCompat.setScaleY(this.f1683x, f);
    }

    /* access modifiers changed from: private */
    public void setColorViewAlpha(int i) {
        this.f1683x.getBackground().setAlpha(i);
        this.f1647A.setAlpha(i);
    }

    public boolean canChildScrollUp() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.f1664d, -1);
        }
        if (this.f1664d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f1664d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        if (ViewCompat.canScrollVertically(this.f1664d, -1) || this.f1664d.getScrollY() > 0) {
            z = true;
        }
        return z;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1671k.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1671k.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1671k.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1671k.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return this.f1684y < 0 ? i2 : i2 == i + -1 ? this.f1684y : i2 >= this.f1684y ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.f1670j.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        if (this.f1683x != null) {
            return this.f1683x.getMeasuredHeight();
        }
        return 0;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1671k.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1671k.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.f1666f;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m1192e();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.f1681u && actionMasked == 0) {
            this.f1681u = false;
        }
        if (!isEnabled() || this.f1681u || canChildScrollUp() || this.f1666f) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                m1168a(this.f1663b - this.f1683x.getTop(), true);
                this.f1679s = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f1678r = false;
                float a = m1163a(motionEvent, this.f1679s);
                if (a != -1.0f) {
                    this.f1677q = a;
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.f1678r = false;
                this.f1679s = -1;
                break;
            case 2:
                if (this.f1679s == -1) {
                    Log.e(f1645c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                float a2 = m1163a(motionEvent, this.f1679s);
                if (a2 != -1.0f) {
                    if (a2 - this.f1677q > ((float) this.f1667g) && !this.f1678r) {
                        this.f1676p = this.f1677q + ((float) this.f1667g);
                        this.f1678r = true;
                        this.f1647A.setAlpha(76);
                        break;
                    }
                } else {
                    return false;
                }
            case 6:
                m1173a(motionEvent);
                break;
        }
        return this.f1678r;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1664d == null) {
                m1192e();
            }
            if (this.f1664d != null) {
                View view = this.f1664d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f1683x.getMeasuredWidth();
                this.f1683x.layout((measuredWidth / 2) - (measuredWidth2 / 2), this.f1674n, (measuredWidth / 2) + (measuredWidth2 / 2), this.f1674n + this.f1683x.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1664d == null) {
            m1192e();
        }
        if (this.f1664d != null) {
            this.f1664d.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f1683x.measure(View.MeasureSpec.makeMeasureSpec(this.f1655I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f1656J, 1073741824));
            if (!this.f1657K && !this.f1675o) {
                this.f1675o = true;
                int i3 = -this.f1683x.getMeasuredHeight();
                this.f1663b = i3;
                this.f1674n = i3;
            }
            this.f1684y = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.f1683x) {
                    this.f1684y = i4;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f1669i > BitmapDescriptorFactory.HUE_RED) {
            if (((float) i2) > this.f1669i) {
                iArr[1] = i2 - ((int) this.f1669i);
                this.f1669i = BitmapDescriptorFactory.HUE_RED;
            } else {
                this.f1669i -= (float) i2;
                iArr[1] = i2;
            }
            m1166a(this.f1669i);
        }
        int[] iArr2 = this.f1672l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            this.f1669i = ((float) Math.abs(i4)) + this.f1669i;
            m1166a(this.f1669i);
        }
        dispatchNestedScroll(i, i2, i3, i, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1670j.onNestedScrollAccepted(view, view2, i);
        this.f1669i = BitmapDescriptorFactory.HUE_RED;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if (!isEnabled() || (i & 2) == 0) {
            return false;
        }
        startNestedScroll(i & 2);
        return true;
    }

    public void onStopNestedScroll(View view) {
        this.f1670j.onStopNestedScroll(view);
        if (this.f1669i > BitmapDescriptorFactory.HUE_RED) {
            m1180b(this.f1669i);
            this.f1669i = BitmapDescriptorFactory.HUE_RED;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.f1681u && actionMasked == 0) {
            this.f1681u = false;
        }
        if (!isEnabled() || this.f1681u || canChildScrollUp()) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.f1679s = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f1678r = false;
                break;
            case 1:
            case 3:
                if (this.f1679s != -1) {
                    this.f1678r = false;
                    m1180b((MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1679s)) - this.f1676p) * 0.5f);
                    this.f1679s = -1;
                    return false;
                } else if (actionMasked != 1) {
                    return false;
                } else {
                    Log.e(f1645c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
            case 2:
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1679s);
                if (findPointerIndex < 0) {
                    Log.e(f1645c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y = (MotionEventCompat.getY(motionEvent, findPointerIndex) - this.f1676p) * 0.5f;
                if (this.f1678r) {
                    if (y > BitmapDescriptorFactory.HUE_RED) {
                        m1166a(y);
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case 5:
                this.f1679s = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                break;
            case 6:
                m1173a(motionEvent);
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT < 21 && (this.f1664d instanceof AbsListView)) {
            return;
        }
        if (this.f1664d == null || ViewCompat.isNestedScrollingEnabled(this.f1664d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        m1192e();
        this.f1647A.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f1668h = (float) i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1671k.setNestedScrollingEnabled(z);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f1665e = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f1683x.setBackgroundColor(i);
        this.f1647A.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.f1653G = (float) i;
        this.f1680t = z;
        this.f1683x.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.f1680t = z;
        this.f1683x.setVisibility(8);
        this.f1674n = i;
        this.f1663b = i;
        this.f1653G = (float) i2;
        this.f1657K = true;
        this.f1683x.invalidate();
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f1666f == z) {
            m1175a(z, false);
            return;
        }
        this.f1666f = z;
        m1168a((!this.f1657K ? (int) (this.f1653G + ((float) this.f1663b)) : (int) this.f1653G) - this.f1674n, true);
        this.f1654H = false;
        m1174a(this.f1658L);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                int i2 = (int) (displayMetrics.density * 56.0f);
                this.f1655I = i2;
                this.f1656J = i2;
            } else {
                int i3 = (int) (displayMetrics.density * 40.0f);
                this.f1655I = i3;
                this.f1656J = i3;
            }
            this.f1683x.setImageDrawable((Drawable) null);
            this.f1647A.updateSizes(i);
            this.f1683x.setImageDrawable(this.f1647A);
        }
    }

    public boolean startNestedScroll(int i) {
        return this.f1671k.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f1671k.stopNestedScroll();
    }
}
