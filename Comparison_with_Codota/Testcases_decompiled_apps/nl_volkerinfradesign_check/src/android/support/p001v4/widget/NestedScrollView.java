package android.support.p001v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.media.TransportMediator;
import android.support.p001v4.view.AccessibilityDelegateCompat;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.NestedScrollingChild;
import android.support.p001v4.view.NestedScrollingChildHelper;
import android.support.p001v4.view.NestedScrollingParent;
import android.support.p001v4.view.NestedScrollingParentHelper;
import android.support.p001v4.view.ScrollingView;
import android.support.p001v4.view.VelocityTrackerCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

/* renamed from: android.support.v4.widget.NestedScrollView */
public class NestedScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent, ScrollingView {

    /* renamed from: v */
    private static final C0423a f1251v = new C0423a();

    /* renamed from: w */
    private static final int[] f1252w = {16843130};

    /* renamed from: A */
    private OnScrollChangeListener f1253A;

    /* renamed from: a */
    private long f1254a;

    /* renamed from: b */
    private final Rect f1255b;

    /* renamed from: c */
    private ScrollerCompat f1256c;

    /* renamed from: d */
    private EdgeEffectCompat f1257d;

    /* renamed from: e */
    private EdgeEffectCompat f1258e;

    /* renamed from: f */
    private int f1259f;

    /* renamed from: g */
    private boolean f1260g;

    /* renamed from: h */
    private boolean f1261h;

    /* renamed from: i */
    private View f1262i;

    /* renamed from: j */
    private boolean f1263j;

    /* renamed from: k */
    private VelocityTracker f1264k;

    /* renamed from: l */
    private boolean f1265l;

    /* renamed from: m */
    private boolean f1266m;

    /* renamed from: n */
    private int f1267n;

    /* renamed from: o */
    private int f1268o;

    /* renamed from: p */
    private int f1269p;

    /* renamed from: q */
    private int f1270q;

    /* renamed from: r */
    private final int[] f1271r;

    /* renamed from: s */
    private final int[] f1272s;

    /* renamed from: t */
    private int f1273t;

    /* renamed from: u */
    private SavedState f1274u;

    /* renamed from: x */
    private final NestedScrollingParentHelper f1275x;

    /* renamed from: y */
    private final NestedScrollingChildHelper f1276y;

    /* renamed from: z */
    private float f1277z;

    /* renamed from: android.support.v4.widget.NestedScrollView$OnScrollChangeListener */
    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1255b = new Rect();
        this.f1260g = true;
        this.f1261h = false;
        this.f1262i = null;
        this.f1263j = false;
        this.f1266m = true;
        this.f1270q = -1;
        this.f1271r = new int[2];
        this.f1272s = new int[2];
        m2582a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1252w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1275x = new NestedScrollingParentHelper(this);
        this.f1276y = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, f1251v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1276y.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1276y.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.f1276y.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f1276y.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1276y.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1276y.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1276y.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1276y.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1276y.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1275x.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f1275x.onStopNestedScroll(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, (int[]) null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2592b((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1275x.getNestedScrollAxes();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    /* renamed from: a */
    private void m2582a() {
        this.f1256c = new ScrollerCompat(getContext(), (Interpolator) null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1267n = viewConfiguration.getScaledTouchSlop();
        this.f1268o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1269p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.f1253A = onScrollChangeListener;
    }

    /* renamed from: b */
    private boolean m2594b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < childAt.getHeight() + getPaddingTop() + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public boolean isFillViewport() {
        return this.f1265l;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1265l) {
            this.f1265l = z;
            requestLayout();
        }
    }

    public boolean isSmoothScrollingEnabled() {
        return this.f1266m;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1266m = z;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1253A != null) {
            this.f1253A.onScrollChange(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1265l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i = 33;
        this.f1255b.setEmpty();
        if (!m2594b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, TransportMediator.KEYCODE_MEDIA_RECORD);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(33);
                    }
                    return fullScroll(33);
                case 20:
                    if (!keyEvent.isAltPressed()) {
                        return arrowScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                    }
                    return fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    pageScroll(i);
                    return false;
                default:
                    return false;
            }
        }
    }

    /* renamed from: a */
    private boolean m2585a(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private void m2595c() {
        if (this.f1264k == null) {
            this.f1264k = VelocityTracker.obtain();
        } else {
            this.f1264k.clear();
        }
    }

    /* renamed from: d */
    private void m2596d() {
        if (this.f1264k == null) {
            this.f1264k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m2597e() {
        if (this.f1264k != null) {
            this.f1264k.recycle();
            this.f1264k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2597e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1263j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent.getY();
                if (m2585a((int) motionEvent.getX(), y)) {
                    this.f1259f = y;
                    this.f1270q = MotionEventCompat.getPointerId(motionEvent, 0);
                    m2595c();
                    this.f1264k.addMovement(motionEvent);
                    if (!this.f1256c.isFinished()) {
                        z = true;
                    }
                    this.f1263j = z;
                    startNestedScroll(2);
                    break;
                } else {
                    this.f1263j = false;
                    m2597e();
                    break;
                }
            case 1:
            case 3:
                this.f1263j = false;
                this.f1270q = -1;
                m2597e();
                if (this.f1256c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                stopNestedScroll();
                break;
            case 2:
                int i = this.f1270q;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    if (findPointerIndex != -1) {
                        int y2 = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
                        if (Math.abs(y2 - this.f1259f) > this.f1267n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1263j = true;
                            this.f1259f = y2;
                            m2596d();
                            this.f1264k.addMovement(motionEvent);
                            this.f1273t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    } else {
                        Log.e("NestedScrollView", "Invalid pointerId=" + i + " in onInterceptTouchEvent");
                        break;
                    }
                }
                break;
            case 6:
                m2584a(motionEvent);
                break;
        }
        return this.f1263j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        ViewParent parent;
        m2596d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f1273t = 0;
        }
        obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f1273t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z2 = !this.f1256c.isFinished();
                    this.f1263j = z2;
                    if (z2 && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!this.f1256c.isFinished()) {
                        this.f1256c.abortAnimation();
                    }
                    this.f1259f = (int) motionEvent.getY();
                    this.f1270q = MotionEventCompat.getPointerId(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                } else {
                    return false;
                }
            case 1:
                if (this.f1263j) {
                    VelocityTracker velocityTracker = this.f1264k;
                    velocityTracker.computeCurrentVelocity(LogTable.MAX_SIZE, (float) this.f1269p);
                    int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.f1270q);
                    if (Math.abs(yVelocity) > this.f1268o) {
                        m2592b(-yVelocity);
                    } else if (this.f1256c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
                this.f1270q = -1;
                m2598f();
                break;
            case 2:
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1270q);
                if (findPointerIndex != -1) {
                    int y = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
                    int i2 = this.f1259f - y;
                    if (dispatchNestedPreScroll(0, i2, this.f1272s, this.f1271r)) {
                        i2 -= this.f1272s[1];
                        obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f1271r[1]);
                        this.f1273t += this.f1271r[1];
                    }
                    if (this.f1263j || Math.abs(i2) <= this.f1267n) {
                        i = i2;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1263j = true;
                        if (i2 > 0) {
                            i = i2 - this.f1267n;
                        } else {
                            i = i2 + this.f1267n;
                        }
                    }
                    if (this.f1263j) {
                        this.f1259f = y - this.f1271r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = ViewCompat.getOverScrollMode(this);
                        if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (mo2826a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1264k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1271r)) {
                            if (z) {
                                m2599g();
                                int i3 = scrollY + i;
                                if (i3 < 0) {
                                    this.f1257d.onPull(((float) i) / ((float) getHeight()), MotionEventCompat.getX(motionEvent, findPointerIndex) / ((float) getWidth()));
                                    if (!this.f1258e.isFinished()) {
                                        this.f1258e.onRelease();
                                    }
                                } else if (i3 > scrollRange) {
                                    this.f1258e.onPull(((float) i) / ((float) getHeight()), 1.0f - (MotionEventCompat.getX(motionEvent, findPointerIndex) / ((float) getWidth())));
                                    if (!this.f1257d.isFinished()) {
                                        this.f1257d.onRelease();
                                    }
                                }
                                if (this.f1257d != null && (!this.f1257d.isFinished() || !this.f1258e.isFinished())) {
                                    ViewCompat.postInvalidateOnAnimation(this);
                                    break;
                                }
                            }
                        } else {
                            this.f1259f -= this.f1271r[1];
                            obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f1271r[1]);
                            this.f1273t += this.f1271r[1];
                            break;
                        }
                    }
                } else {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f1270q + " in onTouchEvent");
                    break;
                }
                break;
            case 3:
                if (this.f1263j && getChildCount() > 0 && this.f1256c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.f1270q = -1;
                m2598f();
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f1259f = (int) MotionEventCompat.getY(motionEvent, actionIndex);
                this.f1270q = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                m2584a(motionEvent);
                this.f1259f = (int) MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1270q));
                break;
        }
        if (this.f1264k != null) {
            this.f1264k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* renamed from: a */
    private void m2584a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (MotionEventCompat.getPointerId(motionEvent, action) == this.f1270q) {
            int i = action == 0 ? 1 : 0;
            this.f1259f = (int) MotionEventCompat.getY(motionEvent, i);
            this.f1270q = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.f1264k != null) {
                this.f1264k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((MotionEventCompat.getSource(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1263j) {
                    return false;
                }
                float axisValue = MotionEventCompat.getAxisValue(motionEvent, 9);
                if (axisValue == BitmapDescriptorFactory.HUE_RED) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    scrollRange = 0;
                } else if (i <= scrollRange) {
                    scrollRange = i;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1277z == BitmapDescriptorFactory.HUE_RED) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1277z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1277z;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2826a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        if (!z6) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (!z7) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        int i13 = -i8;
        int i14 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i14) {
            z3 = true;
        } else if (i10 < i13) {
            z3 = true;
            i14 = i13;
        } else {
            z3 = false;
            i14 = i10;
        }
        if (z3) {
            this.f1256c.springBack(i12, i14, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i14, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    /* renamed from: a */
    private View m2581a(boolean z, int i, int i2) {
        boolean z2;
        View view;
        ArrayList focusables = getFocusables(2);
        View view2 = null;
        boolean z3 = false;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                boolean z4 = i < top && bottom < i2;
                if (view2 == null) {
                    boolean z5 = z4;
                    view = view3;
                    z2 = z5;
                } else {
                    boolean z6 = (z && top < view2.getTop()) || (!z && bottom > view2.getBottom());
                    if (z3) {
                        if (z4 && z6) {
                            view = view3;
                            z2 = z3;
                        }
                    } else if (z4) {
                        view = view3;
                        z2 = true;
                    } else if (z6) {
                        view = view3;
                        z2 = z3;
                    }
                }
                i3++;
                view2 = view;
                z3 = z2;
            }
            z2 = z3;
            view = view2;
            i3++;
            view2 = view;
            z3 = z2;
        }
        return view2;
    }

    public boolean pageScroll(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f1255b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f1255b.top + height > childAt.getBottom()) {
                    this.f1255b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1255b.top = getScrollY() - height;
            if (this.f1255b.top < 0) {
                this.f1255b.top = 0;
            }
        }
        this.f1255b.bottom = this.f1255b.top + height;
        return m2586a(i, this.f1255b.top, this.f1255b.bottom);
    }

    public boolean fullScroll(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.f1255b.top = 0;
        this.f1255b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.f1255b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            this.f1255b.top = this.f1255b.bottom - height;
        }
        return m2586a(i, this.f1255b.top, this.f1255b.bottom);
    }

    /* renamed from: a */
    private boolean m2586a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2581a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2583a(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2589a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2583a(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1255b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1255b);
            m2583a(computeScrollDeltaToGetChildRectOnScreen(this.f1255b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2588a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2588a(View view) {
        return !m2589a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m2589a(View view, int i, int i2) {
        view.getDrawingRect(this.f1255b);
        offsetDescendantRectToMyCoords(view, this.f1255b);
        return this.f1255b.bottom + i >= getScrollY() && this.f1255b.top - i <= getScrollY() + i2;
    }

    /* renamed from: a */
    private void m2583a(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1266m) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1254a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1256c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                if (!this.f1256c.isFinished()) {
                    this.f1256c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f1254a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f1256c.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1256c.getCurrX();
            int currY = this.f1256c.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                int overScrollMode = ViewCompat.getOverScrollMode(this);
                boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                mo2826a(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (z) {
                    m2599g();
                    if (currY <= 0 && scrollY > 0) {
                        this.f1257d.onAbsorb((int) this.f1256c.getCurrVelocity());
                    } else if (currY >= scrollRange && scrollY < scrollRange) {
                        this.f1258e.onAbsorb((int) this.f1256c.getCurrVelocity());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m2593b(View view) {
        view.getDrawingRect(this.f1255b);
        offsetDescendantRectToMyCoords(view, this.f1255b);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.f1255b);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    /* renamed from: a */
    private boolean m2587a(Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i;
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i4 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = (rect.top - scrollY) + 0;
            } else {
                i3 = (rect.bottom - i4) + 0;
            }
            i = Math.min(i3, getChildAt(0).getBottom() - i4);
        } else if (rect.top >= scrollY || rect.bottom >= i4) {
            i = 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i4 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            i = Math.max(i2, -getScrollY());
        }
        return i;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f1260g) {
            m2593b(view2);
        } else {
            this.f1262i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = TransportMediator.KEYCODE_MEDIA_RECORD;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, (View) null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus != null && !m2588a(findNextFocus)) {
            return findNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2587a(rect, z);
    }

    public void requestLayout() {
        this.f1260g = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1260g = false;
        if (this.f1262i != null && m2590a(this.f1262i, (View) this)) {
            m2593b(this.f1262i);
        }
        this.f1262i = null;
        if (!this.f1261h) {
            if (this.f1274u != null) {
                scrollTo(getScrollX(), this.f1274u.f1278a);
                this.f1274u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1261h = true;
    }

    public void onAttachedToWindow() {
        this.f1261h = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2589a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1255b);
            offsetDescendantRectToMyCoords(findFocus, this.f1255b);
            m2583a(computeScrollDeltaToGetChildRectOnScreen(this.f1255b));
        }
    }

    /* renamed from: a */
    private static boolean m2590a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m2590a((View) parent, view2);
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int i2 = height / 2;
            int i3 = i;
            this.f1256c.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, i2);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: b */
    private void m2592b(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(BitmapDescriptorFactory.HUE_RED, (float) i)) {
            dispatchNestedFling(BitmapDescriptorFactory.HUE_RED, (float) i, z);
            if (z) {
                fling(i);
            }
        }
    }

    /* renamed from: f */
    private void m2598f() {
        this.f1263j = false;
        m2597e();
        stopNestedScroll();
        if (this.f1257d != null) {
            this.f1257d.onRelease();
            this.f1258e.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2591b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2591b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    /* renamed from: g */
    private void m2599g() {
        if (ViewCompat.getOverScrollMode(this) == 2) {
            this.f1257d = null;
            this.f1258e = null;
        } else if (this.f1257d == null) {
            Context context = getContext();
            this.f1257d = new EdgeEffectCompat(context);
            this.f1258e = new EdgeEffectCompat(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1257d != null) {
            int scrollY = getScrollY();
            if (!this.f1257d.isFinished()) {
                int save = canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1257d.setSize(width, getHeight());
                if (this.f1257d.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1258e.isFinished()) {
                int save2 = canvas.save();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width2) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width2, BitmapDescriptorFactory.HUE_RED);
                this.f1258e.setSize(width2, height);
                if (this.f1258e.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* renamed from: b */
    private static int m2591b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1274u = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1278a = getScrollY();
        return savedState;
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$SavedState */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        public int f1278a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1278a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1278a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1278a + "}";
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$a */
    static class C0423a extends AccessibilityDelegateCompat {
        C0423a() {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            switch (i) {
                case 4096:
                    int min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, min);
                    return true;
                case 8192:
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max);
                    return true;
                default:
                    return false;
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int a;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (a = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (nestedScrollView.getScrollY() < a) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setScrollable(nestedScrollView.getScrollRange() > 0);
            asRecord.setScrollX(nestedScrollView.getScrollX());
            asRecord.setScrollY(nestedScrollView.getScrollY());
            asRecord.setMaxScrollX(nestedScrollView.getScrollX());
            asRecord.setMaxScrollY(nestedScrollView.getScrollRange());
        }
    }
}
