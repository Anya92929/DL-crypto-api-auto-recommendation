package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.media.TransportMediator;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.NestedScrollingChild;
import android.support.p000v4.view.NestedScrollingChildHelper;
import android.support.p000v4.view.NestedScrollingParent;
import android.support.p000v4.view.NestedScrollingParentHelper;
import android.support.p000v4.view.VelocityTrackerCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
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

/* renamed from: android.support.v4.widget.NestedScrollView */
public class NestedScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {

    /* renamed from: v */
    private static final AccessibilityDelegate f1550v = new AccessibilityDelegate();

    /* renamed from: w */
    private static final int[] f1551w = {16843130};

    /* renamed from: a */
    private long f1552a;

    /* renamed from: b */
    private final Rect f1553b;

    /* renamed from: c */
    private ScrollerCompat f1554c;

    /* renamed from: d */
    private EdgeEffectCompat f1555d;

    /* renamed from: e */
    private EdgeEffectCompat f1556e;

    /* renamed from: f */
    private int f1557f;

    /* renamed from: g */
    private boolean f1558g;

    /* renamed from: h */
    private boolean f1559h;

    /* renamed from: i */
    private View f1560i;

    /* renamed from: j */
    private boolean f1561j;

    /* renamed from: k */
    private VelocityTracker f1562k;

    /* renamed from: l */
    private boolean f1563l;

    /* renamed from: m */
    private boolean f1564m;

    /* renamed from: n */
    private int f1565n;

    /* renamed from: o */
    private int f1566o;

    /* renamed from: p */
    private int f1567p;

    /* renamed from: q */
    private int f1568q;

    /* renamed from: r */
    private final int[] f1569r;

    /* renamed from: s */
    private final int[] f1570s;

    /* renamed from: t */
    private int f1571t;

    /* renamed from: u */
    private SavedState f1572u;

    /* renamed from: x */
    private final NestedScrollingParentHelper f1573x;

    /* renamed from: y */
    private final NestedScrollingChildHelper f1574y;

    /* renamed from: z */
    private float f1575z;

    /* renamed from: android.support.v4.widget.NestedScrollView$AccessibilityDelegate */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
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
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int scrollPosition;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
        }
    }

    public NestedScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1553b = new Rect();
        this.f1558g = true;
        this.f1559h = false;
        this.f1560i = null;
        this.f1561j = false;
        this.f1564m = true;
        this.f1568q = -1;
        this.f1569r = new int[2];
        this.f1570s = new int[2];
        m1106a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1551w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1573x = new NestedScrollingParentHelper(this);
        this.f1574y = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, f1550v);
    }

    /* renamed from: a */
    private View m1105a(boolean z, int i, int i2) {
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

    /* renamed from: a */
    private void m1106a() {
        this.f1554c = new ScrollerCompat(getContext(), (Interpolator) null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1565n = viewConfiguration.getScaledTouchSlop();
        this.f1566o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1567p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    private void m1107a(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1564m) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    /* renamed from: a */
    private void m1108a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (MotionEventCompat.getPointerId(motionEvent, action) == this.f1568q) {
            int i = action == 0 ? 1 : 0;
            this.f1557f = (int) MotionEventCompat.getY(motionEvent, i);
            this.f1568q = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.f1562k != null) {
                this.f1562k.clear();
            }
        }
    }

    /* renamed from: a */
    private boolean m1109a(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* renamed from: a */
    private boolean m1110a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m1105a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m1107a(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m1111a(Rect rect, boolean z) {
        int a = mo3251a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                smoothScrollBy(0, a);
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m1112a(View view) {
        return !m1113a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m1113a(View view, int i, int i2) {
        view.getDrawingRect(this.f1553b);
        offsetDescendantRectToMyCoords(view, this.f1553b);
        return this.f1553b.bottom + i >= getScrollY() && this.f1553b.top - i <= getScrollY() + i2;
    }

    /* renamed from: a */
    private static boolean m1114a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m1114a((View) parent, view2);
    }

    /* renamed from: b */
    private static int m1115b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* renamed from: b */
    private void m1116b(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(BitmapDescriptorFactory.HUE_RED, (float) i)) {
            dispatchNestedFling(BitmapDescriptorFactory.HUE_RED, (float) i, z);
            if (z) {
                fling(i);
            }
        }
    }

    /* renamed from: b */
    private void m1117b(View view) {
        view.getDrawingRect(this.f1553b);
        offsetDescendantRectToMyCoords(view, this.f1553b);
        int a = mo3251a(this.f1553b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    /* renamed from: b */
    private boolean m1118b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    /* renamed from: c */
    private void m1119c() {
        if (this.f1562k == null) {
            this.f1562k = VelocityTracker.obtain();
        } else {
            this.f1562k.clear();
        }
    }

    /* renamed from: d */
    private void m1120d() {
        if (this.f1562k == null) {
            this.f1562k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m1121e() {
        if (this.f1562k != null) {
            this.f1562k.recycle();
            this.f1562k = null;
        }
    }

    /* renamed from: f */
    private void m1122f() {
        this.f1561j = false;
        m1121e();
        stopNestedScroll();
        if (this.f1555d != null) {
            this.f1555d.onRelease();
            this.f1556e.onRelease();
        }
    }

    /* renamed from: g */
    private void m1123g() {
        if (ViewCompat.getOverScrollMode(this) == 2) {
            this.f1555d = null;
            this.f1556e = null;
        } else if (this.f1555d == null) {
            Context context = getContext();
            this.f1555d = new EdgeEffectCompat(context);
            this.f1556e = new EdgeEffectCompat(context);
        }
    }

    /* access modifiers changed from: private */
    public int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1575z == BitmapDescriptorFactory.HUE_RED) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1575z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1575z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo3251a(Rect rect) {
        int i;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i2 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i2 && rect.top > scrollY) {
            i = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i2) + 0, getChildAt(0).getBottom() - i2);
        } else if (rect.top >= scrollY || rect.bottom >= i2) {
            i = 0;
        } else {
            i = Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3252a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z3 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z4 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z5 = overScrollMode == 0 || (overScrollMode == 1 && z3);
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        int i9 = i3 + i;
        if (!z5) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (!z6) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        int i13 = -i8;
        int i14 = i8 + i6;
        if (i9 > i12) {
            i11 = i12;
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
        } else {
            z2 = false;
            i11 = i9;
        }
        boolean z7 = false;
        if (i10 > i14) {
            z7 = true;
        } else if (i10 < i13) {
            z7 = true;
            i14 = i13;
        } else {
            i14 = i10;
        }
        onOverScrolled(i11, i14, z2, z7);
        return z2 || z7;
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

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m1113a(findNextFocus, maxScrollAmount, getHeight())) {
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
            m1107a(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1553b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1553b);
            m1107a(mo3251a(this.f1553b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m1112a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public void computeScroll() {
        if (this.f1554c.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1554c.getCurrX();
            int currY = this.f1554c.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                int overScrollMode = ViewCompat.getOverScrollMode(this);
                boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                mo3252a(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (z) {
                    m1123g();
                    if (currY <= 0 && scrollY > 0) {
                        this.f1555d.onAbsorb((int) this.f1554c.getCurrVelocity());
                    } else if (currY >= scrollRange && scrollY < scrollRange) {
                        this.f1556e.onAbsorb((int) this.f1554c.getCurrVelocity());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1574y.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1574y.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1574y.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1574y.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1555d != null) {
            int scrollY = getScrollY();
            if (!this.f1555d.isFinished()) {
                int save = canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1555d.setSize(width, getHeight());
                if (this.f1555d.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1556e.isFinished()) {
                int save2 = canvas.save();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width2) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width2, BitmapDescriptorFactory.HUE_RED);
                this.f1556e.setSize(width2, height);
                if (this.f1556e.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int i = 33;
        this.f1553b.setEmpty();
        if (!m1118b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, TransportMediator.KEYCODE_MEDIA_RECORD);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(TransportMediator.KEYCODE_MEDIA_RECORD)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    return !keyEvent.isAltPressed() ? arrowScroll(33) : fullScroll(33);
                case 20:
                    return !keyEvent.isAltPressed() ? arrowScroll(TransportMediator.KEYCODE_MEDIA_RECORD) : fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
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

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int i2 = height / 2;
            int i3 = i;
            this.f1554c.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, i2);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean fullScroll(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.f1553b.top = 0;
        this.f1553b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.f1553b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            this.f1553b.top = this.f1553b.bottom - height;
        }
        return m1110a(i, this.f1553b.top, this.f1553b.bottom);
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

    public int getNestedScrollAxes() {
        return this.f1573x.getNestedScrollAxes();
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

    public boolean hasNestedScrollingParent() {
        return this.f1574y.hasNestedScrollingParent();
    }

    public boolean isFillViewport() {
        return this.f1563l;
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1574y.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.f1564m;
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

    public void onAttachedToWindow() {
        this.f1559h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((MotionEventCompat.getSource(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1561j) {
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

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1561j) {
            return true;
        }
        if (getScrollY() == 0 && !ViewCompat.canScrollVertically(this, 1)) {
            return false;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent.getY();
                if (m1109a((int) motionEvent.getX(), y)) {
                    this.f1557f = y;
                    this.f1568q = MotionEventCompat.getPointerId(motionEvent, 0);
                    m1119c();
                    this.f1562k.addMovement(motionEvent);
                    if (this.f1554c.isFinished()) {
                        z = false;
                    }
                    this.f1561j = z;
                    startNestedScroll(2);
                    break;
                } else {
                    this.f1561j = false;
                    m1121e();
                    break;
                }
            case 1:
            case 3:
                this.f1561j = false;
                this.f1568q = -1;
                m1121e();
                stopNestedScroll();
                break;
            case 2:
                int i = this.f1568q;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    if (findPointerIndex != -1) {
                        int y2 = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
                        if (Math.abs(y2 - this.f1557f) > this.f1565n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1561j = true;
                            this.f1557f = y2;
                            m1120d();
                            this.f1562k.addMovement(motionEvent);
                            this.f1571t = 0;
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
                m1108a(motionEvent);
                break;
        }
        return this.f1561j;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1558g = false;
        if (this.f1560i != null && m1114a(this.f1560i, (View) this)) {
            m1117b(this.f1560i);
        }
        this.f1560i = null;
        if (!this.f1559h) {
            if (this.f1572u != null) {
                scrollTo(getScrollX(), this.f1572u.scrollPosition);
                this.f1572u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1559h = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1563l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m1116b((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1573x.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = TransportMediator.KEYCODE_MEDIA_RECORD;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, (View) null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus != null && !m1112a(findNextFocus)) {
            return findNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1572u = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m1113a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1553b);
            offsetDescendantRectToMyCoords(findFocus, this.f1553b);
            m1107a(mo3251a(this.f1553b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        ViewParent parent;
        m1120d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f1571t = 0;
        }
        obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f1571t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f1554c.isFinished();
                    this.f1561j = z;
                    if (z && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!this.f1554c.isFinished()) {
                        this.f1554c.abortAnimation();
                    }
                    this.f1557f = (int) motionEvent.getY();
                    this.f1568q = MotionEventCompat.getPointerId(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                } else {
                    return false;
                }
            case 1:
                if (this.f1561j) {
                    VelocityTracker velocityTracker = this.f1562k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1567p);
                    int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.f1568q);
                    if (Math.abs(yVelocity) > this.f1566o) {
                        m1116b(-yVelocity);
                    }
                    this.f1568q = -1;
                    m1122f();
                    break;
                }
                break;
            case 2:
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1568q);
                if (findPointerIndex != -1) {
                    int y = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
                    int i2 = this.f1557f - y;
                    if (dispatchNestedPreScroll(0, i2, this.f1570s, this.f1569r)) {
                        i2 -= this.f1570s[1];
                        obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f1569r[1]);
                        this.f1571t += this.f1569r[1];
                    }
                    if (this.f1561j || Math.abs(i2) <= this.f1565n) {
                        i = i2;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1561j = true;
                        i = i2 > 0 ? i2 - this.f1565n : i2 + this.f1565n;
                    }
                    if (this.f1561j) {
                        this.f1557f = y - this.f1569r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = ViewCompat.getOverScrollMode(this);
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (mo3252a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1562k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1569r)) {
                            if (z2) {
                                m1123g();
                                int i3 = scrollY + i;
                                if (i3 < 0) {
                                    this.f1555d.onPull(((float) i) / ((float) getHeight()), MotionEventCompat.getX(motionEvent, findPointerIndex) / ((float) getWidth()));
                                    if (!this.f1556e.isFinished()) {
                                        this.f1556e.onRelease();
                                    }
                                } else if (i3 > scrollRange) {
                                    this.f1556e.onPull(((float) i) / ((float) getHeight()), 1.0f - (MotionEventCompat.getX(motionEvent, findPointerIndex) / ((float) getWidth())));
                                    if (!this.f1555d.isFinished()) {
                                        this.f1555d.onRelease();
                                    }
                                }
                                if (this.f1555d != null && (!this.f1555d.isFinished() || !this.f1556e.isFinished())) {
                                    ViewCompat.postInvalidateOnAnimation(this);
                                    break;
                                }
                            }
                        } else {
                            this.f1557f -= this.f1569r[1];
                            obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f1569r[1]);
                            this.f1571t += this.f1569r[1];
                            break;
                        }
                    }
                } else {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f1568q + " in onTouchEvent");
                    break;
                }
                break;
            case 3:
                if (this.f1561j && getChildCount() > 0) {
                    this.f1568q = -1;
                    m1122f();
                    break;
                }
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f1557f = (int) MotionEventCompat.getY(motionEvent, actionIndex);
                this.f1568q = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                m1108a(motionEvent);
                this.f1557f = (int) MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1568q));
                break;
        }
        if (this.f1562k != null) {
            this.f1562k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public boolean pageScroll(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f1553b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f1553b.top + height > childAt.getBottom()) {
                    this.f1553b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1553b.top = getScrollY() - height;
            if (this.f1553b.top < 0) {
                this.f1553b.top = 0;
            }
        }
        this.f1553b.bottom = this.f1553b.top + height;
        return m1110a(i, this.f1553b.top, this.f1553b.bottom);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f1558g) {
            m1117b(view2);
        } else {
            this.f1560i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m1111a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m1121e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f1558g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m1115b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m1115b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1563l) {
            this.f1563l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1574y.setNestedScrollingEnabled(z);
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1564m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1552a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1554c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                if (!this.f1554c.isFinished()) {
                    this.f1554c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f1552a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    public boolean startNestedScroll(int i) {
        return this.f1574y.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f1574y.stopNestedScroll();
    }
}
