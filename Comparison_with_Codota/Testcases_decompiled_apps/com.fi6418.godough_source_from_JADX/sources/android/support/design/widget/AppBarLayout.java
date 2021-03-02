package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.C0007h;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.support.p000v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.List;

@C0060h(mo275a = Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a */
    boolean f6a;

    /* renamed from: b */
    private int f7b;

    /* renamed from: c */
    private int f8c;

    /* renamed from: d */
    private int f9d;

    /* renamed from: e */
    private float f10e;

    /* renamed from: f */
    private int f11f;

    /* renamed from: g */
    private WindowInsetsCompat f12g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<C0058f> f13h;

    public class Behavior extends C0048bm<AppBarLayout> {

        /* renamed from: a */
        private int f14a;

        /* renamed from: b */
        private boolean f15b;

        /* renamed from: c */
        private Runnable f16c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public ScrollerCompat f17d;

        /* renamed from: e */
        private C0026ar f18e;

        /* renamed from: f */
        private int f19f = -1;

        /* renamed from: g */
        private boolean f20g;

        /* renamed from: h */
        private float f21h;

        /* renamed from: i */
        private boolean f22i;

        /* renamed from: j */
        private int f23j = -1;

        /* renamed from: k */
        private int f24k;

        /* renamed from: l */
        private int f25l = -1;

        /* renamed from: m */
        private WeakReference<View> f26m;

        public class SavedState extends View.BaseSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new C0056d();

            /* renamed from: a */
            int f27a;

            /* renamed from: b */
            float f28b;

            /* renamed from: c */
            boolean f29c;

            public SavedState(Parcel parcel) {
                super(parcel);
                this.f27a = parcel.readInt();
                this.f28b = parcel.readFloat();
                this.f29c = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f27a);
                parcel.writeFloat(this.f28b);
                parcel.writeByte((byte) (this.f29c ? 1 : 0));
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        private int m9a(AppBarLayout appBarLayout, int i) {
            int i2;
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = appBarLayout.getChildAt(i3);
                C0057e eVar = (C0057e) childAt.getLayoutParams();
                Interpolator b = eVar.mo266b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b == null) {
                    return i;
                } else {
                    int a = eVar.mo265a();
                    if ((a & 1) != 0) {
                        i2 = eVar.bottomMargin + childAt.getHeight() + eVar.topMargin + 0;
                        if ((a & 2) != 0) {
                            i2 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    } else {
                        i2 = 0;
                    }
                    if (i2 <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) i2)) * ((float) i2)) + childAt.getTop());
                }
            }
            return i;
        }

        /* renamed from: a */
        private void m11a(AppBarLayout appBarLayout) {
            List a = appBarLayout.f13h;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0058f fVar = (C0058f) a.get(i);
                if (fVar != null) {
                    fVar.mo267a(appBarLayout, mo57b());
                }
            }
        }

        /* renamed from: a */
        private boolean m12a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, float f) {
            if (this.f16c != null) {
                appBarLayout.removeCallbacks(this.f16c);
            }
            if (this.f17d == null) {
                this.f17d = ScrollerCompat.create(appBarLayout.getContext());
            }
            this.f17d.fling(0, mo36a(), 0, Math.round(f), 0, 0, i, i2);
            if (this.f17d.computeScrollOffset()) {
                this.f16c = new C0055c(this, coordinatorLayout, appBarLayout);
                ViewCompat.postOnAnimation(appBarLayout, this.f16c);
                return true;
            }
            this.f16c = null;
            return false;
        }

        /* renamed from: b */
        private int m13b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            return mo37a(coordinatorLayout, appBarLayout, mo36a() - i, i2, i3);
        }

        /* renamed from: c */
        private void m14c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            if (this.f18e == null) {
                this.f18e = C0050bo.m298a();
                this.f18e.mo228a(C0008a.f109c);
                this.f18e.mo227a((C0031aw) new C0035b(this, coordinatorLayout, appBarLayout));
            } else {
                this.f18e.mo231d();
            }
            this.f18e.mo225a(mo36a(), i);
            this.f18e.mo222a();
        }

        /* renamed from: c */
        private boolean m15c() {
            if (this.f26m == null) {
                return false;
            }
            View view = (View) this.f26m.get();
            return view != null && view.isShown() && !ViewCompat.canScrollVertically(view, -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final int mo36a() {
            return mo57b() + this.f14a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final int mo37a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a;
            int a2 = mo36a();
            if (i2 == 0 || a2 < i2 || a2 > i3 || a2 == (a = C0068p.m357a(i, i2, i3))) {
                return 0;
            }
            int a3 = appBarLayout.mo18b() ? m9a(appBarLayout, a) : a;
            boolean a4 = mo48a(a3);
            int i4 = a2 - a;
            this.f14a = a - a3;
            if (!a4 && appBarLayout.mo18b()) {
                coordinatorLayout.mo78b((View) appBarLayout);
            }
            m11a(appBarLayout);
            return i4;
        }

        /* renamed from: a */
        public Parcelable mo39a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable a = super.mo39a(coordinatorLayout, appBarLayout);
            int b = mo57b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b;
                if (childAt.getTop() + b > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(a);
                    savedState.f27a = i;
                    if (bottom == ViewCompat.getMinimumHeight(childAt)) {
                        z = true;
                    }
                    savedState.f29c = z;
                    savedState.f28b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return a;
        }

        /* renamed from: a */
        public void mo44a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo44a(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.f19f = savedState.f27a;
                this.f21h = savedState.f28b;
                this.f20g = savedState.f29c;
                return;
            }
            super.mo44a(coordinatorLayout, appBarLayout, parcelable);
            this.f19f = -1;
        }

        /* renamed from: a */
        public void mo45a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            this.f15b = false;
            this.f26m = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void mo46a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m13b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f15b = true;
                return;
            }
            this.f15b = false;
        }

        /* renamed from: a */
        public void mo47a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            int i3;
            int i4;
            if (i2 != 0 && !this.f15b) {
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    i4 = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    i4 = 0;
                }
                iArr[1] = m13b(coordinatorLayout, appBarLayout, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo48a(int i) {
            return super.mo48a(i);
        }

        /* renamed from: a */
        public boolean mo53a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.mo53a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i2 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        m14c(coordinatorLayout, appBarLayout, i2);
                    } else {
                        mo58b(coordinatorLayout, appBarLayout, i2);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        m14c(coordinatorLayout, appBarLayout, 0);
                    } else {
                        mo58b(coordinatorLayout, appBarLayout, 0);
                    }
                }
                appBarLayout.mo21d();
            } else if (this.f19f >= 0) {
                View childAt = appBarLayout.getChildAt(this.f19f);
                int i3 = -childAt.getBottom();
                mo48a(this.f20g ? ViewCompat.getMinimumHeight(childAt) + i3 : Math.round(((float) childAt.getHeight()) * this.f21h) + i3);
                this.f19f = -1;
            }
            m11a(appBarLayout);
            return a;
        }

        /* renamed from: a */
        public boolean mo60b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
            int findPointerIndex;
            if (this.f25l < 0) {
                this.f25l = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            if (motionEvent.getAction() == 2 && this.f22i) {
                return true;
            }
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 0:
                    this.f22i = false;
                    int y = (int) motionEvent.getY();
                    if (coordinatorLayout.mo75a((View) appBarLayout, (int) motionEvent.getX(), y) && m15c()) {
                        this.f24k = y;
                        this.f23j = MotionEventCompat.getPointerId(motionEvent, 0);
                        break;
                    }
                case 1:
                case 3:
                    this.f22i = false;
                    this.f23j = -1;
                    break;
                case 2:
                    int i = this.f23j;
                    if (!(i == -1 || (findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i)) == -1)) {
                        int y2 = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
                        if (Math.abs(y2 - this.f24k) > this.f25l) {
                            this.f22i = true;
                            this.f24k = y2;
                            break;
                        }
                    }
                    break;
            }
            return this.f22i;
        }

        /* renamed from: a */
        public boolean mo55a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            int i;
            if (!z) {
                return m12a(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            }
            if (f2 < BitmapDescriptorFactory.HUE_RED) {
                i = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (mo36a() > i) {
                    return false;
                }
            } else {
                i = -appBarLayout.getUpNestedPreScrollRange();
                if (mo36a() < i) {
                    return false;
                }
            }
            if (mo36a() == i) {
                return false;
            }
            m14c(coordinatorLayout, appBarLayout, i);
            return true;
        }

        /* renamed from: a */
        public boolean mo56a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.mo19c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f18e != null) {
                this.f18e.mo231d();
            }
            this.f26m = null;
            return z;
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo57b() {
            return super.mo57b();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final int mo58b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return mo37a(coordinatorLayout, appBarLayout, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        /* renamed from: b */
        public boolean mo54a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
            if (this.f25l < 0) {
                this.f25l = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 0:
                    if (coordinatorLayout.mo75a((View) appBarLayout, x, y) && m15c()) {
                        this.f24k = y;
                        this.f23j = MotionEventCompat.getPointerId(motionEvent, 0);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                case 3:
                    this.f22i = false;
                    this.f23j = -1;
                    break;
                case 2:
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f23j);
                    if (findPointerIndex != -1) {
                        int y2 = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
                        int i = this.f24k - y2;
                        if (!this.f22i && Math.abs(i) > this.f25l) {
                            this.f22i = true;
                            i = i > 0 ? i - this.f25l : i + this.f25l;
                        }
                        if (this.f22i) {
                            this.f24k = y2;
                            m13b(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
                            break;
                        }
                    } else {
                        return false;
                    }
                    break;
            }
            return true;
        }
    }

    public class ScrollingViewBehavior extends C0048bm<View> {

        /* renamed from: a */
        private int f30a;

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0007h.ScrollingViewBehavior_Params);
            this.f30a = obtainStyledAttributes.getDimensionPixelSize(C0007h.ScrollingViewBehavior_Params_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        private static AppBarLayout m41a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo48a(int i) {
            return super.mo48a(i);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo53a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo53a(coordinatorLayout, view, i);
        }

        /* renamed from: a */
        public boolean mo62a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AppBarLayout a;
            int i5 = view.getLayoutParams().height;
            if (i5 != -1 && i5 != -2) {
                return false;
            }
            List<View> c = coordinatorLayout.mo81c(view);
            if (c.isEmpty() || (a = m41a(c)) == null || !ViewCompat.isLaidOut(a)) {
                return false;
            }
            if (ViewCompat.getFitsSystemWindows(a)) {
                ViewCompat.setFitsSystemWindows(view, true);
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.mo70a(view, i, i2, View.MeasureSpec.makeMeasureSpec(a.getTotalScrollRange() + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo57b() {
            return super.mo57b();
        }

        /* renamed from: b */
        public boolean mo63b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        /* renamed from: c */
        public boolean mo64c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0059g b = ((C0061i) view2.getLayoutParams()).mo282b();
            if (!(b instanceof Behavior)) {
                return false;
            }
            int a = ((Behavior) b).mo36a();
            int height = view2.getHeight() - this.f30a;
            int height2 = coordinatorLayout.getHeight() - view.getHeight();
            if (this.f30a == 0 || !(view2 instanceof AppBarLayout)) {
                mo48a(a + (view2.getHeight() - this.f30a));
                return false;
            }
            mo48a(C0008a.m170a(height, height2, ((float) Math.abs(a)) / ((float) ((AppBarLayout) view2).getTotalScrollRange())));
            return false;
        }
    }

    private void setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.f7b = -1;
        this.f12g = windowInsetsCompat;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount) {
            windowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat);
            if (!windowInsetsCompat.isConsumed()) {
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0057e generateDefaultLayoutParams() {
        return new C0057e(-1, -2);
    }

    /* renamed from: a */
    public C0057e generateLayoutParams(AttributeSet attributeSet) {
        return new C0057e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0057e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new C0057e((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0057e((ViewGroup.MarginLayoutParams) layoutParams) : new C0057e(layoutParams);
    }

    /* renamed from: a */
    public void mo17a(boolean z, boolean z2) {
        this.f11f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo18b() {
        return this.f6a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo19c() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0057e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo21d() {
        this.f11f = 0;
    }

    /* access modifiers changed from: package-private */
    public final int getDownNestedPreScrollRange() {
        int i;
        if (this.f8c != -1) {
            return this.f8c;
        }
        int i2 = 0;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0057e eVar = (C0057e) childAt.getLayoutParams();
            int height = ViewCompat.isLaidOut(childAt) ? childAt.getHeight() : childAt.getMeasuredHeight();
            int i3 = eVar.f198a;
            if ((i3 & 5) == 5) {
                int i4 = eVar.bottomMargin + eVar.topMargin + i2;
                i = (i3 & 8) != 0 ? i4 + ViewCompat.getMinimumHeight(childAt) : i4 + height;
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        this.f8c = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final int getDownNestedScrollRange() {
        if (this.f9d != -1) {
            return this.f9d;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0057e eVar = (C0057e) childAt.getLayoutParams();
            int height = (ViewCompat.isLaidOut(childAt) ? childAt.getHeight() : childAt.getMeasuredHeight()) + eVar.topMargin + eVar.bottomMargin;
            int i3 = eVar.f198a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += height;
            if ((i3 & 2) != 0) {
                return i - ViewCompat.getMinimumHeight(childAt);
            }
        }
        this.f9d = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int systemWindowInsetTop = this.f12g != null ? this.f12g.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + systemWindowInsetTop;
        }
        int childCount = getChildCount();
        if (childCount >= 1) {
            return (ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) * 2) + systemWindowInsetTop;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f11f;
    }

    public float getTargetElevation() {
        return this.f10e;
    }

    public final int getTotalScrollRange() {
        int i;
        if (this.f7b != -1) {
            return this.f7b;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C0057e eVar = (C0057e) childAt.getLayoutParams();
            int height = ViewCompat.isLaidOut(childAt) ? childAt.getHeight() : childAt.getMeasuredHeight();
            int i4 = eVar.f198a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += eVar.bottomMargin + height + eVar.topMargin;
            if ((i4 & 2) != 0) {
                i = i3 - ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        i = i3;
        int systemWindowInsetTop = i - (this.f12g != null ? this.f12g.getSystemWindowInsetTop() : 0);
        this.f7b = systemWindowInsetTop;
        return systemWindowInsetTop;
    }

    /* access modifiers changed from: package-private */
    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7b = -1;
        this.f8c = -1;
        this.f8c = -1;
        this.f6a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0057e) getChildAt(i5).getLayoutParams()).mo266b() != null) {
                this.f6a = true;
                return;
            }
        }
    }

    public void setExpanded(boolean z) {
        mo17a(z, ViewCompat.isLaidOut(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setTargetElevation(float f) {
        this.f10e = f;
    }
}
