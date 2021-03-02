package android.support.p009v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p009v4.view.C0152a;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0234bl;
import android.support.p009v4.view.C0235bm;
import android.support.p009v4.view.C0236bn;
import android.support.p009v4.view.C0237bo;
import android.support.p009v4.view.C0240br;
import android.support.p009v4.view.C0242bt;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0515k;
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
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.NestedScrollView */
public class NestedScrollView extends FrameLayout implements C0234bl, C0236bn, C0240br {

    /* renamed from: v */
    private static final C0374aq f455v = new C0374aq();

    /* renamed from: w */
    private static final int[] f456w = {16843130};

    /* renamed from: A */
    private C0375ar f457A;

    /* renamed from: a */
    private long f458a;

    /* renamed from: b */
    private final Rect f459b;

    /* renamed from: c */
    private C0390bf f460c;

    /* renamed from: d */
    private C0363af f461d;

    /* renamed from: e */
    private C0363af f462e;

    /* renamed from: f */
    private int f463f;

    /* renamed from: g */
    private boolean f464g;

    /* renamed from: h */
    private boolean f465h;

    /* renamed from: i */
    private View f466i;

    /* renamed from: j */
    private boolean f467j;

    /* renamed from: k */
    private VelocityTracker f468k;

    /* renamed from: l */
    private boolean f469l;

    /* renamed from: m */
    private boolean f470m;

    /* renamed from: n */
    private int f471n;

    /* renamed from: o */
    private int f472o;

    /* renamed from: p */
    private int f473p;

    /* renamed from: q */
    private int f474q;

    /* renamed from: r */
    private final int[] f475r;

    /* renamed from: s */
    private final int[] f476s;

    /* renamed from: t */
    private int f477t;

    /* renamed from: u */
    private SavedState f478u;

    /* renamed from: x */
    private final C0237bo f479x;

    /* renamed from: y */
    private final C0235bm f480y;

    /* renamed from: z */
    private float f481z;

    /* renamed from: android.support.v4.widget.NestedScrollView$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C0376as();

        /* renamed from: a */
        public int f482a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f482a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f482a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f482a);
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
        this.f459b = new Rect();
        this.f464g = true;
        this.f465h = false;
        this.f466i = null;
        this.f467j = false;
        this.f470m = true;
        this.f474q = -1;
        this.f475r = new int[2];
        this.f476s = new int[2];
        m1403a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f456w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f479x = new C0237bo(this);
        this.f480y = new C0235bm(this);
        setNestedScrollingEnabled(true);
        C0247by.m895a((View) this, (C0152a) f455v);
    }

    /* renamed from: a */
    private View m1402a(boolean z, int i, int i2) {
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
    private void m1403a() {
        this.f460c = C0390bf.m1565a(getContext(), (Interpolator) null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f471n = viewConfiguration.getScaledTouchSlop();
        this.f472o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f473p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    private void m1404a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (C0223ba.m831b(motionEvent, action) == this.f474q) {
            int i = action == 0 ? 1 : 0;
            this.f463f = (int) C0223ba.m834d(motionEvent, i);
            this.f474q = C0223ba.m831b(motionEvent, i);
            if (this.f468k != null) {
                this.f468k.clear();
            }
        }
    }

    /* renamed from: a */
    private boolean m1405a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m1402a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m1417e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m1406a(Rect rect, boolean z) {
        int a = mo1696a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                mo1697a(0, a);
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m1407a(View view) {
        return !m1408a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m1408a(View view, int i, int i2) {
        view.getDrawingRect(this.f459b);
        offsetDescendantRectToMyCoords(view, this.f459b);
        return this.f459b.bottom + i >= getScrollY() && this.f459b.top - i <= getScrollY() + i2;
    }

    /* renamed from: a */
    private static boolean m1409a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m1409a((View) parent, view2);
    }

    /* renamed from: b */
    private static int m1410b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* renamed from: b */
    private void m1411b(View view) {
        view.getDrawingRect(this.f459b);
        offsetDescendantRectToMyCoords(view, this.f459b);
        int a = mo1696a(this.f459b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    /* renamed from: b */
    private boolean m1412b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    /* renamed from: c */
    private void m1413c() {
        if (this.f468k == null) {
            this.f468k = VelocityTracker.obtain();
        } else {
            this.f468k.clear();
        }
    }

    /* renamed from: c */
    private boolean m1414c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* renamed from: d */
    private void m1415d() {
        if (this.f468k == null) {
            this.f468k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m1416e() {
        if (this.f468k != null) {
            this.f468k.recycle();
            this.f468k = null;
        }
    }

    /* renamed from: e */
    private void m1417e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f470m) {
            mo1697a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    /* renamed from: f */
    private void m1418f() {
        this.f467j = false;
        m1416e();
        stopNestedScroll();
        if (this.f461d != null) {
            this.f461d.mo1787c();
            this.f462e.mo1787c();
        }
    }

    /* renamed from: f */
    private void m1419f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                mo1709d(i);
            }
        }
    }

    /* renamed from: g */
    private void m1420g() {
        if (C0247by.m888a(this) == 2) {
            this.f461d = null;
            this.f462e = null;
        } else if (this.f461d == null) {
            Context context = getContext();
            this.f461d = new C0363af(context);
            this.f462e = new C0363af(context);
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
        if (this.f481z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f481z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f481z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1696a(Rect rect) {
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

    /* renamed from: a */
    public final void mo1697a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f458a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f460c.mo1807a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                C0247by.postInvalidateOnAnimation(this);
            } else {
                if (!this.f460c.mo1811a()) {
                    this.f460c.mo1819h();
                }
                scrollBy(i, i2);
            }
            this.f458a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: a */
    public boolean mo1698a(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f459b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f459b.top + height > childAt.getBottom()) {
                    this.f459b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f459b.top = getScrollY() - height;
            if (this.f459b.top < 0) {
                this.f459b.top = 0;
            }
        }
        this.f459b.bottom = this.f459b.top + height;
        return m1405a(i, this.f459b.top, this.f459b.bottom);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1699a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = C0247by.m888a(this);
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = a == 0 || (a == 1 && z4);
        boolean z7 = a == 0 || (a == 1 && z5);
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
            this.f460c.mo1812a(i12, i14, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i14, z2, z3);
        return z2 || z3;
    }

    /* renamed from: a */
    public boolean mo1700a(KeyEvent keyEvent) {
        int i = 33;
        this.f459b.setEmpty();
        if (!m1412b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    return !keyEvent.isAltPressed() ? mo1707c(33) : mo1706b(33);
                case 20:
                    return !keyEvent.isAltPressed() ? mo1707c(130) : mo1706b(130);
                case C0515k.AppCompatTheme_popupWindowStyle /*62*/:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    mo1698a(i);
                    return false;
                default:
                    return false;
            }
        }
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

    /* renamed from: b */
    public final void mo1705b(int i, int i2) {
        mo1697a(i - getScrollX(), i2 - getScrollY());
    }

    /* renamed from: b */
    public boolean mo1706b(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.f459b.top = 0;
        this.f459b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.f459b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            this.f459b.top = this.f459b.bottom - height;
        }
        return m1405a(i, this.f459b.top, this.f459b.bottom);
    }

    /* renamed from: c */
    public boolean mo1707c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m1408a(findNextFocus, maxScrollAmount, getHeight())) {
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
            m1417e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f459b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f459b);
            m1417e(mo1696a(this.f459b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m1407a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f460c.mo1818g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f460c.mo1813b();
            int c = this.f460c.mo1814c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = C0247by.m888a(this);
                boolean z = a == 0 || (a == 1 && scrollRange > 0);
                mo1699a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (z) {
                    m1420g();
                    if (c <= 0 && scrollY > 0) {
                        this.f461d.mo1784a((int) this.f460c.mo1817f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f462e.mo1784a((int) this.f460c.mo1817f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
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
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    /* renamed from: d */
    public void mo1709d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int i2 = height / 2;
            int i3 = i;
            this.f460c.mo1810a(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, i2);
            C0247by.postInvalidateOnAnimation(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo1700a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f480y.mo1424a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f480y.mo1423a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f480y.mo1427a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f480y.mo1426a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f461d != null) {
            int scrollY = getScrollY();
            if (!this.f461d.mo1781a()) {
                int save = canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f461d.mo1780a(width, getHeight());
                if (this.f461d.mo1785a(canvas)) {
                    C0247by.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f462e.mo1781a()) {
                int save2 = canvas.save();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width2) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f462e.mo1780a(width2, height);
                if (this.f462e.mo1785a(canvas)) {
                    C0247by.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
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
        return this.f479x.mo1438a();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f480y.mo1428b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f480y.mo1422a();
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
        this.f465h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((C0223ba.m835d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f467j) {
                    return false;
                }
                float e = C0223ba.m836e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
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
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f467j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent.getY();
                if (m1414c((int) motionEvent.getX(), y)) {
                    this.f463f = y;
                    this.f474q = C0223ba.m831b(motionEvent, 0);
                    m1413c();
                    this.f468k.addMovement(motionEvent);
                    this.f460c.mo1818g();
                    if (!this.f460c.mo1811a()) {
                        z = true;
                    }
                    this.f467j = z;
                    startNestedScroll(2);
                    break;
                } else {
                    this.f467j = false;
                    m1416e();
                    break;
                }
            case 1:
            case 3:
                this.f467j = false;
                this.f474q = -1;
                m1416e();
                if (this.f460c.mo1812a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0247by.postInvalidateOnAnimation(this);
                }
                stopNestedScroll();
                break;
            case 2:
                int i = this.f474q;
                if (i != -1) {
                    int a = C0223ba.m829a(motionEvent, i);
                    if (a != -1) {
                        int d = (int) C0223ba.m834d(motionEvent, a);
                        if (Math.abs(d - this.f463f) > this.f471n && (getNestedScrollAxes() & 2) == 0) {
                            this.f467j = true;
                            this.f463f = d;
                            m1415d();
                            this.f468k.addMovement(motionEvent);
                            this.f477t = 0;
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
                m1404a(motionEvent);
                break;
        }
        return this.f467j;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f464g = false;
        if (this.f466i != null && m1409a(this.f466i, (View) this)) {
            m1411b(this.f466i);
        }
        this.f466i = null;
        if (!this.f465h) {
            if (this.f478u != null) {
                scrollTo(getScrollX(), this.f478u.f482a);
                this.f478u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f465h = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f469l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
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
        m1419f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, (int[]) null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f479x.mo1439a(view, view2, i);
        startNestedScroll(2);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, (View) null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus != null && !m1407a(findNextFocus)) {
            return findNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f478u = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f482a = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f457A != null) {
            this.f457A.mo1797a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m1408a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f459b);
            offsetDescendantRectToMyCoords(findFocus, this.f459b);
            m1417e(mo1696a(this.f459b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f479x.onStopNestedScroll(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        ViewParent parent;
        m1415d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0223ba.m828a(motionEvent);
        if (a == 0) {
            this.f477t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f477t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f460c.mo1811a();
                    this.f467j = z;
                    if (z && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!this.f460c.mo1811a()) {
                        this.f460c.mo1819h();
                    }
                    this.f463f = (int) motionEvent.getY();
                    this.f474q = C0223ba.m831b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                } else {
                    return false;
                }
            case 1:
                if (this.f467j) {
                    VelocityTracker velocityTracker = this.f468k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f473p);
                    int b = (int) C0242bt.m878b(velocityTracker, this.f474q);
                    if (Math.abs(b) > this.f472o) {
                        m1419f(-b);
                    } else if (this.f460c.mo1812a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        C0247by.postInvalidateOnAnimation(this);
                    }
                }
                this.f474q = -1;
                m1418f();
                break;
            case 2:
                int a2 = C0223ba.m829a(motionEvent, this.f474q);
                if (a2 != -1) {
                    int d = (int) C0223ba.m834d(motionEvent, a2);
                    int i2 = this.f463f - d;
                    if (dispatchNestedPreScroll(0, i2, this.f476s, this.f475r)) {
                        i2 -= this.f476s[1];
                        obtain.offsetLocation(0.0f, (float) this.f475r[1]);
                        this.f477t += this.f475r[1];
                    }
                    if (this.f467j || Math.abs(i2) <= this.f471n) {
                        i = i2;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f467j = true;
                        i = i2 > 0 ? i2 - this.f471n : i2 + this.f471n;
                    }
                    if (this.f467j) {
                        this.f463f = d - this.f475r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int a3 = C0247by.m888a(this);
                        boolean z2 = a3 == 0 || (a3 == 1 && scrollRange > 0);
                        if (mo1699a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f468k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f475r)) {
                            if (z2) {
                                m1420g();
                                int i3 = scrollY + i;
                                if (i3 < 0) {
                                    this.f461d.mo1783a(((float) i) / ((float) getHeight()), C0223ba.m832c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f462e.mo1781a()) {
                                        this.f462e.mo1787c();
                                    }
                                } else if (i3 > scrollRange) {
                                    this.f462e.mo1783a(((float) i) / ((float) getHeight()), 1.0f - (C0223ba.m832c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f461d.mo1781a()) {
                                        this.f461d.mo1787c();
                                    }
                                }
                                if (this.f461d != null && (!this.f461d.mo1781a() || !this.f462e.mo1781a())) {
                                    C0247by.postInvalidateOnAnimation(this);
                                    break;
                                }
                            }
                        } else {
                            this.f463f -= this.f475r[1];
                            obtain.offsetLocation(0.0f, (float) this.f475r[1]);
                            this.f477t += this.f475r[1];
                            break;
                        }
                    }
                } else {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f474q + " in onTouchEvent");
                    break;
                }
                break;
            case 3:
                if (this.f467j && getChildCount() > 0 && this.f460c.mo1812a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0247by.postInvalidateOnAnimation(this);
                }
                this.f474q = -1;
                m1418f();
                break;
            case 5:
                int b2 = C0223ba.m830b(motionEvent);
                this.f463f = (int) C0223ba.m834d(motionEvent, b2);
                this.f474q = C0223ba.m831b(motionEvent, b2);
                break;
            case 6:
                m1404a(motionEvent);
                this.f463f = (int) C0223ba.m834d(motionEvent, C0223ba.m829a(motionEvent, this.f474q));
                break;
        }
        if (this.f468k != null) {
            this.f468k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f464g) {
            m1411b(view2);
        } else {
            this.f466i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m1406a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m1416e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f464g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m1410b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m1410b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f469l) {
            this.f469l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f480y.mo1421a(z);
    }

    public void setOnScrollChangeListener(C0375ar arVar) {
        this.f457A = arVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f470m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f480y.mo1425a(i);
    }

    public void stopNestedScroll() {
        this.f480y.mo1429c();
    }
}
