package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.NestedScrollingParent;
import android.support.p000v4.view.NestedScrollingParentHelper;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {

    /* renamed from: a */
    static final String f31a = CoordinatorLayout.class.getPackage().getName();

    /* renamed from: b */
    static final Class<?>[] f32b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    static final ThreadLocal<Map<String, Constructor<C0059g>>> f33c = new ThreadLocal<>();

    /* renamed from: e */
    static final Comparator<View> f34e;

    /* renamed from: f */
    static final C0065m f35f;

    /* renamed from: d */
    final Comparator<View> f36d;

    /* renamed from: g */
    private final List<View> f37g;

    /* renamed from: h */
    private final List<View> f38h;

    /* renamed from: i */
    private final List<View> f39i;

    /* renamed from: j */
    private final Rect f40j;

    /* renamed from: k */
    private final Rect f41k;

    /* renamed from: l */
    private final Rect f42l;

    /* renamed from: m */
    private final int[] f43m;

    /* renamed from: n */
    private Paint f44n;

    /* renamed from: o */
    private boolean f45o;

    /* renamed from: p */
    private int[] f46p;

    /* renamed from: q */
    private View f47q;

    /* renamed from: r */
    private View f48r;

    /* renamed from: s */
    private View f49s;

    /* renamed from: t */
    private C0062j f50t;

    /* renamed from: u */
    private boolean f51u;

    /* renamed from: v */
    private WindowInsetsCompat f52v;

    /* renamed from: w */
    private boolean f53w;

    /* renamed from: x */
    private Drawable f54x;

    /* renamed from: y */
    private ViewGroup.OnHierarchyChangeListener f55y;

    /* renamed from: z */
    private final NestedScrollingParentHelper f56z;

    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0063k();

        /* renamed from: a */
        SparseArray<Parcelable> f57a;

        public SavedState(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(CoordinatorLayout.class.getClassLoader());
            this.f57a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f57a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f57a != null ? this.f57a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f57a.keyAt(i2);
                parcelableArr[i2] = this.f57a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r2 = 0
            java.lang.Class<android.support.design.widget.CoordinatorLayout> r0 = android.support.design.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            java.lang.String r0 = r0.getName()
            f31a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x0038
            android.support.design.widget.l r0 = new android.support.design.widget.l
            r0.<init>()
            f34e = r0
            android.support.design.widget.n r0 = new android.support.design.widget.n
            r0.<init>()
            f35f = r0
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f32b = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f33c = r0
            return
        L_0x0038:
            f34e = r2
            f35f = r2
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.<clinit>():void");
    }

    /* renamed from: a */
    private int m48a(int i) {
        if (this.f46p == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f46p.length) {
            return this.f46p[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    /* renamed from: a */
    static C0059g m49a(Context context, AttributeSet attributeSet, String str) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            str = f31a + '.' + str;
        }
        try {
            Map map = f33c.get();
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                f33c.set(hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            Constructor<?> constructor = (Constructor) hashMap.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f32b);
                constructor.setAccessible(true);
                hashMap.put(str, constructor);
            }
            return (C0059g) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    /* renamed from: a */
    private void m50a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (!windowInsetsCompat.isConsumed()) {
            int childCount = getChildCount();
            WindowInsetsCompat windowInsetsCompat3 = windowInsetsCompat;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (ViewCompat.getFitsSystemWindows(childAt)) {
                    C0059g b = ((C0061i) childAt.getLayoutParams()).mo282b();
                    if (b != null) {
                        windowInsetsCompat2 = b.mo268a(this, childAt, windowInsetsCompat3);
                        if (windowInsetsCompat2.isConsumed()) {
                            return;
                        }
                    } else {
                        windowInsetsCompat2 = windowInsetsCompat3;
                    }
                    windowInsetsCompat3 = ViewCompat.dispatchApplyWindowInsets(childAt, windowInsetsCompat2);
                    if (windowInsetsCompat3.isConsumed()) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m51a(View view, View view2, int i) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        Rect rect = this.f40j;
        Rect rect2 = this.f41k;
        mo72a(view2, rect);
        mo71a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* renamed from: a */
    private void m52a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        if (f34e != null) {
            Collections.sort(list, f34e);
        }
    }

    /* renamed from: a */
    private boolean m53a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2;
        boolean z3 = false;
        boolean z4 = false;
        MotionEvent motionEvent3 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        List<View> list = this.f38h;
        m52a(list);
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                View view = list.get(i2);
                C0061i iVar = (C0061i) view.getLayoutParams();
                C0059g b = iVar.mo282b();
                if ((!z3 && !z4) || actionMasked == 0) {
                    if (!z3 && b != null) {
                        switch (i) {
                            case 0:
                                z3 = b.mo60b(this, view, motionEvent);
                                break;
                            case 1:
                                z3 = b.mo54a(this, view, motionEvent);
                                break;
                        }
                        if (z3) {
                            this.f47q = view;
                        }
                    }
                    z = z3;
                    boolean e = iVar.mo288e();
                    boolean a = iVar.mo280a(this, view);
                    boolean z5 = a && !e;
                    if (!a || z5) {
                        MotionEvent motionEvent4 = motionEvent3;
                        z2 = z5;
                        motionEvent2 = motionEvent4;
                    }
                } else if (b != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                    } else {
                        motionEvent2 = motionEvent3;
                    }
                    switch (i) {
                        case 0:
                            b.mo60b(this, view, motionEvent2);
                            break;
                        case 1:
                            b.mo54a(this, view, motionEvent2);
                            break;
                    }
                    z2 = z4;
                    z = z3;
                } else {
                    motionEvent2 = motionEvent3;
                    z = z3;
                    z2 = z4;
                }
                i2++;
                z4 = z2;
                z3 = z;
                motionEvent3 = motionEvent2;
            } else {
                z = z3;
            }
        }
        list.clear();
        return z;
    }

    /* renamed from: b */
    private static int m54b(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* renamed from: b */
    private void m55b(View view, int i, int i2) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(m56c(iVar.f202c), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a = m48a(i) - measuredWidth;
        int i5 = 0;
        switch (i3) {
            case 1:
                a += measuredWidth / 2;
                break;
            case 5:
                a += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i5 = 0 + (measuredHeight / 2);
                break;
            case 80:
                i5 = 0 + measuredHeight;
                break;
        }
        int max = Math.max(getPaddingLeft() + iVar.leftMargin, Math.min(a, ((width - getPaddingRight()) - measuredWidth) - iVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + iVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - iVar.bottomMargin));
        view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
    }

    /* renamed from: c */
    private static int m56c(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* renamed from: c */
    private void m57c(View view, int i) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        Rect rect = this.f40j;
        rect.set(getPaddingLeft() + iVar.leftMargin, getPaddingTop() + iVar.topMargin, (getWidth() - getPaddingRight()) - iVar.rightMargin, (getHeight() - getPaddingBottom()) - iVar.bottomMargin);
        if (this.f52v != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += this.f52v.getSystemWindowInsetLeft();
            rect.top += this.f52v.getSystemWindowInsetTop();
            rect.right -= this.f52v.getSystemWindowInsetRight();
            rect.bottom -= this.f52v.getSystemWindowInsetBottom();
        }
        Rect rect2 = this.f41k;
        GravityCompat.apply(m54b(iVar.f202c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* renamed from: d */
    private static int m58d(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    /* renamed from: e */
    private void m59e() {
        if (this.f47q != null) {
            C0059g b = ((C0061i) this.f47q.getLayoutParams()).mo282b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                b.mo54a(this, this.f47q, obtain);
                obtain.recycle();
            }
            this.f47q = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C0061i) getChildAt(i).getLayoutParams()).mo289f();
        }
    }

    /* renamed from: f */
    private void m60f() {
        int childCount = getChildCount();
        boolean z = this.f37g.size() != childCount;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0061i a = mo66a(childAt);
            if (!z && a.mo286c(this, childAt)) {
                z = true;
            }
            a.mo283b(this, childAt);
        }
        if (z) {
            this.f37g.clear();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f37g.add(getChildAt(i2));
            }
            Collections.sort(this.f37g, this.f36d);
        }
    }

    private void setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        boolean z = true;
        if (this.f52v != windowInsetsCompat) {
            this.f52v = windowInsetsCompat;
            this.f53w = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
            if (this.f53w || getBackground() != null) {
                z = false;
            }
            setWillNotDraw(z);
            m50a(windowInsetsCompat);
            requestLayout();
        }
    }

    /* renamed from: a */
    public C0061i generateLayoutParams(AttributeSet attributeSet) {
        return new C0061i(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0061i mo66a(View view) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        if (!iVar.f201b) {
            C0060h hVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                hVar = (C0060h) cls.getAnnotation(C0060h.class);
                if (hVar != null) {
                    break;
                }
            }
            C0060h hVar2 = hVar;
            if (hVar2 != null) {
                try {
                    iVar.mo278a((C0059g) hVar2.mo275a().newInstance());
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + hVar2.mo275a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            iVar.f201b = true;
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0061i generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0061i ? new C0061i((C0061i) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0061i((ViewGroup.MarginLayoutParams) layoutParams) : new C0061i(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo68a() {
        boolean z = false;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (mo86d(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z == this.f51u) {
            return;
        }
        if (z) {
            mo77b();
        } else {
            mo82c();
        }
    }

    /* renamed from: a */
    public void mo69a(View view, int i) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        if (iVar.mo287d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (iVar.f206g != null) {
            m51a(view, iVar.f206g, i);
        } else if (iVar.f204e >= 0) {
            m55b(view, iVar.f204e, i);
        } else {
            m57c(view, i);
        }
    }

    /* renamed from: a */
    public void mo70a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71a(View view, int i, Rect rect, Rect rect2) {
        int width;
        int height;
        C0061i iVar = (C0061i) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(m58d(iVar.f202c), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(m54b(iVar.f203d), i);
        int i2 = absoluteGravity & 7;
        int i3 = absoluteGravity & 112;
        int i4 = absoluteGravity2 & 7;
        int i5 = absoluteGravity2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (i4) {
            case 1:
                width = (rect.width() / 2) + rect.left;
                break;
            case 5:
                width = rect.right;
                break;
            default:
                width = rect.left;
                break;
        }
        switch (i5) {
            case 16:
                height = rect.top + (rect.height() / 2);
                break;
            case 80:
                height = rect.bottom;
                break;
            default:
                height = rect.top;
                break;
        }
        switch (i2) {
            case 1:
                width -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                width -= measuredWidth;
                break;
        }
        switch (i3) {
            case 16:
                height -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                height -= measuredHeight;
                break;
        }
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getPaddingLeft() + iVar.leftMargin, Math.min(width, ((width2 - getPaddingRight()) - measuredWidth) - iVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + iVar.topMargin, Math.min(height, ((height2 - getPaddingBottom()) - measuredHeight) - iVar.bottomMargin));
        rect2.set(max, max2, max + measuredWidth, max2 + measuredHeight);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72a(View view, Rect rect) {
        C0042bg.m283b(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo73a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            mo72a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo74a(boolean z) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f37g.size();
        for (int i = 0; i < size; i++) {
            View view = this.f37g.get(i);
            C0061i iVar = (C0061i) view.getLayoutParams();
            for (int i2 = 0; i2 < i; i2++) {
                if (iVar.f207h == this.f37g.get(i2)) {
                    mo79b(view, layoutDirection);
                }
            }
            Rect rect = this.f40j;
            Rect rect2 = this.f41k;
            mo83c(view, rect);
            mo73a(view, true, rect2);
            if (!rect.equals(rect2)) {
                mo80b(view, rect2);
                for (int i3 = i + 1; i3 < size; i3++) {
                    View view2 = this.f37g.get(i3);
                    C0061i iVar2 = (C0061i) view2.getLayoutParams();
                    C0059g b = iVar2.mo282b();
                    if (b != null && b.mo63b(this, view2, view)) {
                        if (z || !iVar2.mo292i()) {
                            boolean c = b.mo64c(this, view2, view);
                            if (z) {
                                iVar2.mo284b(c);
                            }
                        } else {
                            iVar2.mo293j();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo75a(View view, int i, int i2) {
        Rect rect = this.f40j;
        mo72a(view, rect);
        return rect.contains(i, i2);
    }

    /* renamed from: a */
    public boolean mo76a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rect = this.f40j;
        mo73a(view, view.getParent() != this, rect);
        Rect rect2 = this.f41k;
        mo73a(view2, view2.getParent() != this, rect2);
        return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo77b() {
        if (this.f45o) {
            if (this.f50t == null) {
                this.f50t = new C0062j(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f50t);
        }
        this.f51u = true;
    }

    /* renamed from: b */
    public void mo78b(View view) {
        boolean z;
        C0061i iVar;
        C0059g b;
        int size = this.f37g.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            View view2 = this.f37g.get(i);
            if (view2 == view) {
                z = true;
            } else {
                if (z2 && (b = iVar.mo282b()) != null && (iVar = (C0061i) view2.getLayoutParams()).mo281a(this, view2, view)) {
                    b.mo64c(this, view2, view);
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo79b(View view, int i) {
        C0059g b;
        C0061i iVar = (C0061i) view.getLayoutParams();
        if (iVar.f206g != null) {
            Rect rect = this.f40j;
            Rect rect2 = this.f41k;
            Rect rect3 = this.f42l;
            mo72a(iVar.f206g, rect);
            mo73a(view, false, rect2);
            mo71a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if ((i2 != 0 || i3 != 0) && (b = iVar.mo282b()) != null) {
                b.mo64c(this, view, iVar.f206g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo80b(View view, Rect rect) {
        ((C0061i) view.getLayoutParams()).mo277a(rect);
    }

    /* renamed from: c */
    public List<View> mo81c(View view) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        List<View> list = this.f39i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && iVar.mo281a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo82c() {
        if (this.f45o && this.f50t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f50t);
        }
        this.f51u = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo83c(View view, Rect rect) {
        rect.set(((C0061i) view.getLayoutParams()).mo285c());
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0061i) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0061i generateDefaultLayoutParams() {
        return new C0061i(-2, -2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo86d(View view) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        if (iVar.f206g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && iVar.mo281a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0061i iVar = (C0061i) view.getLayoutParams();
        if (iVar.f200a != null && iVar.f200a.mo272c(this, view) > BitmapDescriptorFactory.HUE_RED) {
            if (this.f44n == null) {
                this.f44n = new Paint();
            }
            this.f44n.setColor(iVar.f200a.mo270b(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f44n);
        }
        return super.drawChild(canvas, view, j);
    }

    public int getNestedScrollAxes() {
        return this.f56z.getNestedScrollAxes();
    }

    public Drawable getStatusBarBackground() {
        return this.f54x;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m59e();
        if (this.f51u) {
            if (this.f50t == null) {
                this.f50t = new C0062j(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f50t);
        }
        if (this.f52v == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.f45o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m59e();
        if (this.f51u && this.f50t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f50t);
        }
        if (this.f49s != null) {
            onStopNestedScroll(this.f49s);
        }
        this.f45o = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f53w && this.f54x != null) {
            int systemWindowInsetTop = this.f52v != null ? this.f52v.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f54x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f54x.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            m59e();
        }
        boolean a = m53a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            m59e();
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f37g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f37g.get(i5);
            C0059g b = ((C0061i) view.getLayoutParams()).mo282b();
            if (b == null || !b.mo53a(this, view, layoutDirection)) {
                mo69a(view, layoutDirection);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        m60f();
        mo68a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        boolean z = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.f52v != null && ViewCompat.getFitsSystemWindows(this);
        int size3 = this.f37g.size();
        int i7 = 0;
        int i8 = 0;
        int i9 = suggestedMinimumHeight;
        int i10 = suggestedMinimumWidth;
        while (i7 < size3) {
            View view = this.f37g.get(i7);
            C0061i iVar = (C0061i) view.getLayoutParams();
            int i11 = 0;
            if (iVar.f204e >= 0 && mode != 0) {
                int a = m48a(iVar.f204e);
                int absoluteGravity = GravityCompat.getAbsoluteGravity(m56c(iVar.f202c), layoutDirection) & 7;
                if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                    i11 = Math.max(0, (size - paddingRight) - a);
                } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                    i11 = Math.max(0, a - paddingLeft);
                }
            }
            if (!z2 || ViewCompat.getFitsSystemWindows(view)) {
                i3 = i2;
                i4 = i;
            } else {
                int systemWindowInsetLeft = this.f52v.getSystemWindowInsetLeft() + this.f52v.getSystemWindowInsetRight();
                int systemWindowInsetTop = this.f52v.getSystemWindowInsetTop() + this.f52v.getSystemWindowInsetBottom();
                i4 = View.MeasureSpec.makeMeasureSpec(size - systemWindowInsetLeft, mode);
                i3 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetTop, mode2);
            }
            C0059g b = iVar.mo282b();
            if (b == null || !b.mo62a(this, view, i4, i11, i3, 0)) {
                mo70a(view, i4, i11, i3, 0);
            }
            int max = Math.max(i10, view.getMeasuredWidth() + i5 + iVar.leftMargin + iVar.rightMargin);
            int max2 = Math.max(i9, view.getMeasuredHeight() + i6 + iVar.topMargin + iVar.bottomMargin);
            i7++;
            i8 = ViewCompat.combineMeasuredStates(i8, ViewCompat.getMeasuredState(view));
            i9 = max2;
            i10 = max;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i10, i, -16777216 & i8), ViewCompat.resolveSizeAndState(i9, i2, i8 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean a;
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            if (!iVar.mo291h()) {
                a = z2;
            } else {
                C0059g b = iVar.mo282b();
                a = b != null ? b.mo55a(this, childAt, view, f, f2, z) | z2 : z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            mo74a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        boolean a;
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            if (!iVar.mo291h()) {
                a = z;
            } else {
                C0059g b = iVar.mo282b();
                a = b != null ? b.mo269a(this, childAt, view, f, f2) | z : z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        boolean z;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        boolean z2 = false;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            if (!iVar.mo291h()) {
                z = z2;
                i3 = i5;
                i4 = i6;
            } else {
                C0059g b = iVar.mo282b();
                if (b != null) {
                    int[] iArr2 = this.f43m;
                    this.f43m[1] = 0;
                    iArr2[0] = 0;
                    b.mo47a(this, childAt, view, i, i2, this.f43m);
                    i3 = i > 0 ? Math.max(i5, this.f43m[0]) : Math.min(i5, this.f43m[0]);
                    i4 = i2 > 0 ? Math.max(i6, this.f43m[1]) : Math.min(i6, this.f43m[1]);
                    z = true;
                } else {
                    z = z2;
                    i3 = i5;
                    i4 = i6;
                }
            }
            i7++;
            i6 = i4;
            i5 = i3;
            z2 = z;
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            mo74a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            if (!iVar.mo291h()) {
                z = z2;
            } else {
                C0059g b = iVar.mo282b();
                if (b != null) {
                    b.mo46a(this, childAt, view, i, i2, i3, i4);
                    z = true;
                } else {
                    z = z2;
                }
            }
            i5++;
            z2 = z;
        }
        if (z2) {
            mo74a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        C0059g b;
        this.f56z.onNestedScrollAccepted(view, view2, i);
        this.f48r = view;
        this.f49s = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            if (iVar.mo291h() && (b = iVar.mo282b()) != null) {
                b.mo271b(this, childAt, view, view2, i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f57a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0059g b = mo66a(childAt).mo282b();
            if (!(id == -1 || b == null || (parcelable2 = sparseArray.get(id)) == null)) {
                b.mo44a(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable a;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0059g b = ((C0061i) childAt.getLayoutParams()).mo282b();
            if (!(id == -1 || b == null || (a = b.mo39a(this, childAt)) == null)) {
                sparseArray.append(id, a);
            }
        }
        savedState.f57a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z;
        int childCount = getChildCount();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            C0059g b = iVar.mo282b();
            if (b != null) {
                boolean a = b.mo56a(this, childAt, view, view2, i);
                z = z2 | a;
                iVar.mo279a(a);
            } else {
                iVar.mo279a(false);
                z = z2;
            }
            i2++;
            z2 = z;
        }
        return z2;
    }

    public void onStopNestedScroll(View view) {
        this.f56z.onStopNestedScroll(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0061i iVar = (C0061i) childAt.getLayoutParams();
            if (iVar.mo291h()) {
                C0059g b = iVar.mo282b();
                if (b != null) {
                    b.mo45a(this, childAt, view);
                }
                iVar.mo290g();
                iVar.mo293j();
            }
        }
        this.f48r = null;
        this.f49s = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            r4 = 3
            r10 = 1
            r5 = 0
            r7 = 0
            r2 = 0
            int r9 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r12)
            android.view.View r0 = r11.f47q
            if (r0 != 0) goto L_0x005d
            boolean r0 = r11.m53a((android.view.MotionEvent) r12, (int) r10)
            if (r0 == 0) goto L_0x005a
            r1 = r0
        L_0x0014:
            android.view.View r0 = r11.f47q
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.design.widget.i r0 = (android.support.design.widget.C0061i) r0
            android.support.design.widget.g r0 = r0.mo282b()
            if (r0 == 0) goto L_0x0058
            android.view.View r3 = r11.f47q
            boolean r0 = r0.mo54a((android.support.design.widget.CoordinatorLayout) r11, r3, (android.view.MotionEvent) r12)
            r8 = r0
        L_0x0029:
            android.view.View r0 = r11.f47q
            if (r0 != 0) goto L_0x0043
            boolean r0 = super.onTouchEvent(r12)
            r8 = r8 | r0
        L_0x0032:
            if (r8 != 0) goto L_0x0036
            if (r9 != 0) goto L_0x0036
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.recycle()
        L_0x003b:
            if (r9 == r10) goto L_0x003f
            if (r9 != r4) goto L_0x0042
        L_0x003f:
            r11.m59e()
        L_0x0042:
            return r8
        L_0x0043:
            if (r1 == 0) goto L_0x0032
            if (r2 != 0) goto L_0x0056
            long r0 = android.os.SystemClock.uptimeMillis()
            r2 = r0
            r6 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7)
        L_0x0051:
            super.onTouchEvent(r0)
            r2 = r0
            goto L_0x0032
        L_0x0056:
            r0 = r2
            goto L_0x0051
        L_0x0058:
            r8 = r7
            goto L_0x0029
        L_0x005a:
            r1 = r0
            r8 = r7
            goto L_0x0029
        L_0x005d:
            r1 = r7
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m59e();
        }
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f55y = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f54x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }
}
