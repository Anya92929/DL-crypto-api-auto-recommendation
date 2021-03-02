package android.support.p009v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p009v4.view.C0152a;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0284dh;
import android.support.p009v4.view.C0347q;
import android.support.p009v4.view.C0352v;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.widget.DrawerLayout */
public class DrawerLayout extends ViewGroup implements C0362ae {

    /* renamed from: a */
    static final C0420u f411a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int[] f412b = {16842931};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f413c = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: d */
    private static final boolean f414d;

    /* renamed from: A */
    private float f415A;

    /* renamed from: B */
    private Drawable f416B;

    /* renamed from: C */
    private Drawable f417C;

    /* renamed from: D */
    private Drawable f418D;

    /* renamed from: E */
    private CharSequence f419E;

    /* renamed from: F */
    private CharSequence f420F;

    /* renamed from: G */
    private Object f421G;

    /* renamed from: H */
    private boolean f422H;

    /* renamed from: I */
    private Drawable f423I;

    /* renamed from: J */
    private Drawable f424J;

    /* renamed from: K */
    private Drawable f425K;

    /* renamed from: L */
    private Drawable f426L;

    /* renamed from: M */
    private final ArrayList f427M;

    /* renamed from: e */
    private final C0419t f428e;

    /* renamed from: f */
    private float f429f;

    /* renamed from: g */
    private int f430g;

    /* renamed from: h */
    private int f431h;

    /* renamed from: i */
    private float f432i;

    /* renamed from: j */
    private Paint f433j;

    /* renamed from: k */
    private final C0398bn f434k;

    /* renamed from: l */
    private final C0398bn f435l;

    /* renamed from: m */
    private final C0358aa f436m;

    /* renamed from: n */
    private final C0358aa f437n;

    /* renamed from: o */
    private int f438o;

    /* renamed from: p */
    private boolean f439p;

    /* renamed from: q */
    private boolean f440q;

    /* renamed from: r */
    private int f441r;

    /* renamed from: s */
    private int f442s;

    /* renamed from: t */
    private int f443t;

    /* renamed from: u */
    private int f444u;

    /* renamed from: v */
    private boolean f445v;

    /* renamed from: w */
    private boolean f446w;
    @Deprecated

    /* renamed from: x */
    private C0423x f447x;

    /* renamed from: y */
    private List f448y;

    /* renamed from: z */
    private float f449z;

    /* renamed from: android.support.v4.widget.DrawerLayout$SavedState */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C0425z();

        /* renamed from: a */
        int f450a = 0;

        /* renamed from: b */
        int f451b;

        /* renamed from: c */
        int f452c;

        /* renamed from: d */
        int f453d;

        /* renamed from: e */
        int f454e;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f450a = parcel.readInt();
            this.f451b = parcel.readInt();
            this.f452c = parcel.readInt();
            this.f453d = parcel.readInt();
            this.f454e = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f450a);
            parcel.writeInt(this.f451b);
            parcel.writeInt(this.f452c);
            parcel.writeInt(this.f453d);
            parcel.writeInt(this.f454e);
        }
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        f414d = z;
        if (Build.VERSION.SDK_INT >= 21) {
            f411a = new C0421v();
        } else {
            f411a = new C0422w();
        }
    }

    public DrawerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f428e = new C0419t(this);
        this.f431h = -1728053248;
        this.f433j = new Paint();
        this.f440q = true;
        this.f441r = 3;
        this.f442s = 3;
        this.f443t = 3;
        this.f444u = 3;
        this.f423I = null;
        this.f424J = null;
        this.f425K = null;
        this.f426L = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f430g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f436m = new C0358aa(this, 3);
        this.f437n = new C0358aa(this, 5);
        this.f434k = C0398bn.m1639a((ViewGroup) this, 1.0f, (C0401bq) this.f436m);
        this.f434k.mo1838a(1);
        this.f434k.mo1837a(f2);
        this.f436m.mo1770a(this.f434k);
        this.f435l = C0398bn.m1639a((ViewGroup) this, 1.0f, (C0401bq) this.f437n);
        this.f435l.mo1838a(2);
        this.f435l.mo1837a(f2);
        this.f437n.mo1770a(this.f435l);
        setFocusableInTouchMode(true);
        C0247by.m908c((View) this, 1);
        C0247by.m895a((View) this, (C0152a) new C0418s(this));
        C0284dh.m1141a(this, false);
        if (C0247by.m920m(this)) {
            f411a.configureApplyInsets(this);
            this.f416B = f411a.mo1899a(context);
        }
        this.f429f = f * 10.0f;
        this.f427M = new ArrayList();
    }

    /* renamed from: a */
    private void m1359a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || mo1664g(childAt)) && (!z || childAt != view)) {
                C0247by.m908c(childAt, 4);
            } else {
                C0247by.m908c(childAt, 1);
            }
        }
    }

    /* renamed from: a */
    private boolean m1360a(Drawable drawable, int i) {
        if (drawable == null || !C0095a.m204b(drawable)) {
            return false;
        }
        C0095a.m203b(drawable, i);
        return true;
    }

    /* renamed from: d */
    static String m1361d(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* renamed from: f */
    private void m1364f() {
        if (!f414d) {
            this.f417C = m1365g();
            this.f418D = m1366h();
        }
    }

    /* renamed from: g */
    private Drawable m1365g() {
        int d = C0247by.m909d(this);
        if (d == 0) {
            if (this.f423I != null) {
                m1360a(this.f423I, d);
                return this.f423I;
            }
        } else if (this.f424J != null) {
            m1360a(this.f424J, d);
            return this.f424J;
        }
        return this.f425K;
    }

    /* renamed from: h */
    private Drawable m1366h() {
        int d = C0247by.m909d(this);
        if (d == 0) {
            if (this.f424J != null) {
                m1360a(this.f424J, d);
                return this.f424J;
            }
        } else if (this.f423I != null) {
            m1360a(this.f423I, d);
            return this.f423I;
        }
        return this.f426L;
    }

    /* renamed from: i */
    private boolean m1367i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0424y) getChildAt(i).getLayoutParams()).f575c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private boolean m1368j() {
        return m1370k() != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public View m1370k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mo1664g(childAt) && mo1672i(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: k */
    private static boolean m1371k(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static boolean m1372l(View view) {
        return (C0247by.m901b(view) == 4 || C0247by.m901b(view) == 2) ? false : true;
    }

    /* renamed from: a */
    public int mo1634a(int i) {
        int d = C0247by.m909d(this);
        switch (i) {
            case 3:
                if (this.f441r != 3) {
                    return this.f441r;
                }
                int i2 = d == 0 ? this.f443t : this.f444u;
                if (i2 != 3) {
                    return i2;
                }
                break;
            case 5:
                if (this.f442s != 3) {
                    return this.f442s;
                }
                int i3 = d == 0 ? this.f444u : this.f443t;
                if (i3 != 3) {
                    return i3;
                }
                break;
            case 8388611:
                if (this.f443t != 3) {
                    return this.f443t;
                }
                int i4 = d == 0 ? this.f441r : this.f442s;
                if (i4 != 3) {
                    return i4;
                }
                break;
            case 8388613:
                if (this.f444u != 3) {
                    return this.f444u;
                }
                int i5 = d == 0 ? this.f442s : this.f441r;
                if (i5 != 3) {
                    return i5;
                }
                break;
        }
        return 0;
    }

    /* renamed from: a */
    public int mo1635a(View view) {
        if (mo1664g(view)) {
            return mo1634a(((C0424y) view.getLayoutParams()).f573a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo1636a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0424y) childAt.getLayoutParams()).f576d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo1637a(int i, int i2) {
        int a = C0347q.m1334a(i2, C0247by.m909d(this));
        switch (i2) {
            case 3:
                this.f441r = i;
                break;
            case 5:
                this.f442s = i;
                break;
            case 8388611:
                this.f443t = i;
                break;
            case 8388613:
                this.f444u = i;
                break;
        }
        if (i != 0) {
            (a == 3 ? this.f434k : this.f435l).mo1856e();
        }
        switch (i) {
            case 1:
                View c = mo1651c(a);
                if (c != null) {
                    closeDrawer(c);
                    return;
                }
                return;
            case 2:
                View c2 = mo1651c(a);
                if (c2 != null) {
                    openDrawer(c2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1638a(int i, int i2, View view) {
        int a = this.f434k.mo1836a();
        int a2 = this.f435l.mo1836a();
        int i3 = (a == 1 || a2 == 1) ? 1 : (a == 2 || a2 == 2) ? 2 : 0;
        if (view != null && i2 == 0) {
            C0424y yVar = (C0424y) view.getLayoutParams();
            if (yVar.f574b == 0.0f) {
                mo1649b(view);
            } else if (yVar.f574b == 1.0f) {
                mo1653c(view);
            }
        }
        if (i3 != this.f438o) {
            this.f438o = i3;
            if (this.f448y != null) {
                for (int size = this.f448y.size() - 1; size >= 0; size--) {
                    ((C0423x) this.f448y.get(size)).onDrawerStateChanged(i3);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1639a(C0423x xVar) {
        if (xVar != null) {
            if (this.f448y == null) {
                this.f448y = new ArrayList();
            }
            this.f448y.add(xVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1640a(View view, float f) {
        if (this.f448y != null) {
            for (int size = this.f448y.size() - 1; size >= 0; size--) {
                ((C0423x) this.f448y.get(size)).onDrawerSlide(view, f);
            }
        }
    }

    /* renamed from: a */
    public void mo1641a(Object obj, boolean z) {
        this.f421G = obj;
        this.f422H = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1642a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0424y yVar = (C0424y) childAt.getLayoutParams();
            if (mo1664g(childAt) && (!z || yVar.f575c)) {
                z2 = mo1643a(childAt, 3) ? z2 | this.f434k.mo1842a(childAt, -childAt.getWidth(), childAt.getTop()) : z2 | this.f435l.mo1842a(childAt, getWidth(), childAt.getTop());
                boolean unused = yVar.f575c = false;
            }
        }
        this.f436m.mo1767a();
        this.f437n.mo1767a();
        if (z2) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1643a(View view, int i) {
        return (mo1659e(view) & i) == i;
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!mo1664g(childAt)) {
                    this.f427M.add(childAt);
                } else if (mo1671h(childAt)) {
                    z = true;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (!z) {
                int size = this.f427M.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.f427M.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f427M.clear();
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (mo1636a() != null || mo1664g(view)) {
            C0247by.m908c(view, 4);
        } else {
            C0247by.m908c(view, 1);
        }
        if (!f413c) {
            C0247by.m895a(view, (C0152a) this.f428e);
        }
    }

    /* renamed from: b */
    public CharSequence mo1646b(int i) {
        int a = C0347q.m1334a(i, C0247by.m909d(this));
        if (a == 3) {
            return this.f419E;
        }
        if (a == 5) {
            return this.f420F;
        }
        return null;
    }

    /* renamed from: b */
    public void mo1647b() {
        mo1642a(false);
    }

    /* renamed from: b */
    public void mo1648b(C0423x xVar) {
        if (xVar != null && this.f448y != null) {
            this.f448y.remove(xVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1649b(View view) {
        View rootView;
        C0424y yVar = (C0424y) view.getLayoutParams();
        if ((yVar.f576d & 1) == 1) {
            int unused = yVar.f576d = 0;
            if (this.f448y != null) {
                for (int size = this.f448y.size() - 1; size >= 0; size--) {
                    ((C0423x) this.f448y.get(size)).onDrawerClosed(view);
                }
            }
            m1359a(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1650b(View view, float f) {
        C0424y yVar = (C0424y) view.getLayoutParams();
        if (f != yVar.f574b) {
            float unused = yVar.f574b = f;
            mo1640a(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo1651c(int i) {
        int a = C0347q.m1334a(i, C0247by.m909d(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo1659e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1652c() {
        if (!this.f446w) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f446w = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1653c(View view) {
        C0424y yVar = (C0424y) view.getLayoutParams();
        if ((yVar.f576d & 1) == 0) {
            int unused = yVar.f576d = 1;
            if (this.f448y != null) {
                for (int size = this.f448y.size() - 1; size >= 0; size--) {
                    ((C0423x) this.f448y.get(size)).onDrawerOpened(view);
                }
            }
            m1359a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0424y) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(View view) {
        if (!mo1664g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        C0424y yVar = (C0424y) view.getLayoutParams();
        if (this.f440q) {
            float unused = yVar.f574b = 0.0f;
            int unused2 = yVar.f576d = 0;
        } else {
            int unused3 = yVar.f576d = yVar.f576d | 4;
            if (mo1643a(view, 3)) {
                this.f434k.mo1842a(view, -view.getWidth(), view.getTop());
            } else {
                this.f435l.mo1842a(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0424y) getChildAt(i).getLayoutParams()).f574b);
        }
        this.f432i = f;
        if (this.f434k.mo1843a(true) || this.f435l.mo1843a(true)) {
            C0247by.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo1657d(View view) {
        return ((C0424y) view.getLayoutParams()).f574b;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = mo1662f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m1371k(childAt) && mo1664g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (mo1643a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right <= i2) {
                            right = i2;
                        }
                        i2 = right;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        int i4 = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f432i > 0.0f && f) {
            this.f433j.setColor((((int) (((float) ((this.f431h & -16777216) >>> 24)) * this.f432i)) << 24) | (this.f431h & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i4, (float) getHeight(), this.f433j);
        } else if (this.f417C != null && mo1643a(view, 3)) {
            int intrinsicWidth = this.f417C.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f434k.mo1844b()), 1.0f));
            this.f417C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f417C.setAlpha((int) (255.0f * max));
            this.f417C.draw(canvas);
        } else if (this.f418D != null && mo1643a(view, 5)) {
            int intrinsicWidth2 = this.f418D.getIntrinsicWidth();
            int left = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left)) / ((float) this.f435l.mo1844b()), 1.0f));
            this.f418D.setBounds(left - intrinsicWidth2, view.getTop(), left, view.getBottom());
            this.f418D.setAlpha((int) (255.0f * max2));
            this.f418D.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo1659e(View view) {
        return C0347q.m1334a(((C0424y) view.getLayoutParams()).f573a, C0247by.m909d(this));
    }

    /* renamed from: e */
    public void mo1660e(int i) {
        View c = mo1651c(i);
        if (c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m1361d(i));
        }
        openDrawer(c);
    }

    /* renamed from: f */
    public void mo1661f(int i) {
        View c = mo1651c(i);
        if (c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m1361d(i));
        }
        closeDrawer(c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo1662f(View view) {
        return ((C0424y) view.getLayoutParams()).f573a == 0;
    }

    /* renamed from: g */
    public boolean mo1663g(int i) {
        View c = mo1651c(i);
        if (c != null) {
            return mo1671h(c);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo1664g(View view) {
        int a = C0347q.m1334a(((C0424y) view.getLayoutParams()).f573a, C0247by.m909d(view));
        if ((a & 3) != 0) {
            return true;
        }
        return (a & 5) != 0;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0424y(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0424y(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0424y ? new C0424y((C0424y) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0424y((ViewGroup.MarginLayoutParams) layoutParams) : new C0424y(layoutParams);
    }

    public float getDrawerElevation() {
        if (f414d) {
            return this.f429f;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f416B;
    }

    /* renamed from: h */
    public boolean mo1670h(int i) {
        View c = mo1651c(i);
        if (c != null) {
            return mo1672i(c);
        }
        return false;
    }

    /* renamed from: h */
    public boolean mo1671h(View view) {
        if (mo1664g(view)) {
            return (((C0424y) view.getLayoutParams()).f576d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: i */
    public boolean mo1672i(View view) {
        if (mo1664g(view)) {
            return ((C0424y) view.getLayoutParams()).f574b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f440q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f440q = true;
    }

    public void onDraw(Canvas canvas) {
        int a;
        super.onDraw(canvas);
        if (this.f422H && this.f416B != null && (a = f411a.mo1898a(this.f421G)) > 0) {
            this.f416B.setBounds(0, 0, getWidth(), a);
            this.f416B.draw(canvas);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r0 = r7.f434k.mo1854d((int) r0, (int) r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            int r0 = android.support.p009v4.view.C0223ba.m828a(r8)
            android.support.v4.widget.bn r3 = r7.f434k
            boolean r3 = r3.mo1841a((android.view.MotionEvent) r8)
            android.support.v4.widget.bn r4 = r7.f435l
            boolean r4 = r4.mo1841a((android.view.MotionEvent) r8)
            r3 = r3 | r4
            switch(r0) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0065;
                case 2: goto L_0x0050;
                case 3: goto L_0x0065;
                default: goto L_0x0016;
            }
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r3 != 0) goto L_0x0025
            if (r0 != 0) goto L_0x0025
            boolean r0 = r7.m1367i()
            if (r0 != 0) goto L_0x0025
            boolean r0 = r7.f446w
            if (r0 == 0) goto L_0x0026
        L_0x0025:
            r2 = r1
        L_0x0026:
            return r2
        L_0x0027:
            float r0 = r8.getX()
            float r4 = r8.getY()
            r7.f449z = r0
            r7.f415A = r4
            float r5 = r7.f432i
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x006d
            android.support.v4.widget.bn r5 = r7.f434k
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r0 = r5.mo1854d(r0, r4)
            if (r0 == 0) goto L_0x006d
            boolean r0 = r7.mo1662f((android.view.View) r0)
            if (r0 == 0) goto L_0x006d
            r0 = r1
        L_0x004b:
            r7.f445v = r2
            r7.f446w = r2
            goto L_0x0017
        L_0x0050:
            android.support.v4.widget.bn r0 = r7.f434k
            r4 = 3
            boolean r0 = r0.mo1855d(r4)
            if (r0 == 0) goto L_0x0016
            android.support.v4.widget.aa r0 = r7.f436m
            r0.mo1767a()
            android.support.v4.widget.aa r0 = r7.f437n
            r0.mo1767a()
            r0 = r2
            goto L_0x0017
        L_0x0065:
            r7.mo1642a((boolean) r1)
            r7.f445v = r2
            r7.f446w = r2
            goto L_0x0016
        L_0x006d:
            r0 = r2
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m1368j()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0352v.m1341b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View k = m1370k();
        if (k != null && mo1635a(k) == 0) {
            mo1647b();
        }
        return k != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int a;
        float f;
        this.f439p = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0424y yVar = (C0424y) childAt.getLayoutParams();
                if (mo1662f(childAt)) {
                    childAt.layout(yVar.leftMargin, yVar.topMargin, yVar.leftMargin + childAt.getMeasuredWidth(), yVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo1643a(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * yVar.f574b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * yVar.f574b));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    boolean z2 = f != yVar.f574b;
                    switch (yVar.f573a & C0515k.AppCompatTheme_spinnerStyle) {
                        case 16:
                            int i7 = i4 - i2;
                            int i8 = (i7 - measuredHeight) / 2;
                            if (i8 < yVar.topMargin) {
                                i8 = yVar.topMargin;
                            } else if (i8 + measuredHeight > i7 - yVar.bottomMargin) {
                                i8 = (i7 - yVar.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i8, measuredWidth + a, measuredHeight + i8);
                            break;
                        case C0515k.AppCompatTheme_panelMenuListWidth /*80*/:
                            int i9 = i4 - i2;
                            childAt.layout(a, (i9 - yVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i9 - yVar.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, yVar.topMargin, measuredWidth + a, measuredHeight + yVar.topMargin);
                            break;
                    }
                    if (z2) {
                        mo1650b(childAt, f);
                    }
                    int i10 = yVar.f574b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f439p = false;
        this.f440q = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            int r2 = android.view.View.MeasureSpec.getMode(r14)
            int r3 = android.view.View.MeasureSpec.getMode(r15)
            int r1 = android.view.View.MeasureSpec.getSize(r14)
            int r0 = android.view.View.MeasureSpec.getSize(r15)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r2 != r4) goto L_0x0018
            r4 = 1073741824(0x40000000, float:2.0)
            if (r3 == r4) goto L_0x0169
        L_0x0018:
            boolean r4 = r13.isInEditMode()
            if (r4 == 0) goto L_0x0061
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r4) goto L_0x0055
        L_0x0022:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 != r2) goto L_0x005a
            r2 = r1
            r1 = r0
        L_0x0028:
            r13.setMeasuredDimension(r2, r1)
            java.lang.Object r0 = r13.f421G
            if (r0 == 0) goto L_0x0069
            boolean r0 = android.support.p009v4.view.C0247by.m920m(r13)
            if (r0 == 0) goto L_0x0069
            r0 = 1
            r3 = r0
        L_0x0037:
            int r8 = android.support.p009v4.view.C0247by.m909d(r13)
            r5 = 0
            r4 = 0
            int r9 = r13.getChildCount()
            r0 = 0
            r7 = r0
        L_0x0043:
            if (r7 >= r9) goto L_0x0168
            android.view.View r10 = r13.getChildAt(r7)
            int r0 = r10.getVisibility()
            r6 = 8
            if (r0 != r6) goto L_0x006c
        L_0x0051:
            int r0 = r7 + 1
            r7 = r0
            goto L_0x0043
        L_0x0055:
            if (r2 != 0) goto L_0x0022
            r1 = 300(0x12c, float:4.2E-43)
            goto L_0x0022
        L_0x005a:
            if (r3 != 0) goto L_0x0169
            r0 = 300(0x12c, float:4.2E-43)
            r2 = r1
            r1 = r0
            goto L_0x0028
        L_0x0061:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
            r0.<init>(r1)
            throw r0
        L_0x0069:
            r0 = 0
            r3 = r0
            goto L_0x0037
        L_0x006c:
            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
            android.support.v4.widget.y r0 = (android.support.p009v4.widget.C0424y) r0
            if (r3 == 0) goto L_0x0087
            int r6 = r0.f573a
            int r6 = android.support.p009v4.view.C0347q.m1334a(r6, r8)
            boolean r11 = android.support.p009v4.view.C0247by.m920m(r10)
            if (r11 == 0) goto L_0x00ac
            android.support.v4.widget.u r11 = f411a
            java.lang.Object r12 = r13.f421G
            r11.mo1900a((android.view.View) r10, (java.lang.Object) r12, (int) r6)
        L_0x0087:
            boolean r6 = r13.mo1662f((android.view.View) r10)
            if (r6 == 0) goto L_0x00b4
            int r6 = r0.leftMargin
            int r6 = r2 - r6
            int r11 = r0.rightMargin
            int r6 = r6 - r11
            r11 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r11)
            int r11 = r0.topMargin
            int r11 = r1 - r11
            int r0 = r0.bottomMargin
            int r0 = r11 - r0
            r11 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r11)
            r10.measure(r6, r0)
            goto L_0x0051
        L_0x00ac:
            android.support.v4.widget.u r11 = f411a
            java.lang.Object r12 = r13.f421G
            r11.mo1901a((android.view.ViewGroup.MarginLayoutParams) r0, (java.lang.Object) r12, (int) r6)
            goto L_0x0087
        L_0x00b4:
            boolean r6 = r13.mo1664g((android.view.View) r10)
            if (r6 == 0) goto L_0x0139
            boolean r6 = f414d
            if (r6 == 0) goto L_0x00cd
            float r6 = android.support.p009v4.view.C0247by.m918k(r10)
            float r11 = r13.f429f
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x00cd
            float r6 = r13.f429f
            android.support.p009v4.view.C0247by.m907c((android.view.View) r10, (float) r6)
        L_0x00cd:
            int r6 = r13.mo1659e((android.view.View) r10)
            r11 = r6 & 7
            r6 = 3
            if (r11 != r6) goto L_0x0114
            r6 = 1
        L_0x00d7:
            if (r6 == 0) goto L_0x00db
            if (r5 != 0) goto L_0x00df
        L_0x00db:
            if (r6 != 0) goto L_0x0116
            if (r4 == 0) goto L_0x0116
        L_0x00df:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Child drawer has absolute gravity "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = m1361d((int) r11)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " but this "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "DrawerLayout"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " already has a "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "drawer view along that edge"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0114:
            r6 = 0
            goto L_0x00d7
        L_0x0116:
            if (r6 == 0) goto L_0x0137
            r5 = 1
        L_0x0119:
            int r6 = r13.f430g
            int r11 = r0.leftMargin
            int r6 = r6 + r11
            int r11 = r0.rightMargin
            int r6 = r6 + r11
            int r11 = r0.width
            int r6 = getChildMeasureSpec(r14, r6, r11)
            int r11 = r0.topMargin
            int r12 = r0.bottomMargin
            int r11 = r11 + r12
            int r0 = r0.height
            int r0 = getChildMeasureSpec(r15, r11, r0)
            r10.measure(r6, r0)
            goto L_0x0051
        L_0x0137:
            r4 = 1
            goto L_0x0119
        L_0x0139:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Child "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r2 = " at index "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0168:
            return
        L_0x0169:
            r2 = r1
            r1 = r0
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View c;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f450a == 0 || (c = mo1651c(savedState.f450a)) == null)) {
            openDrawer(c);
        }
        if (savedState.f451b != 3) {
            mo1637a(savedState.f451b, 3);
        }
        if (savedState.f452c != 3) {
            mo1637a(savedState.f452c, 5);
        }
        if (savedState.f453d != 3) {
            mo1637a(savedState.f453d, 8388611);
        }
        if (savedState.f454e != 3) {
            mo1637a(savedState.f454e, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        m1364f();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0424y yVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            yVar = (C0424y) getChildAt(i).getLayoutParams();
            boolean z = yVar.f576d == 1;
            boolean z2 = yVar.f576d == 2;
            if (z || z2) {
                savedState.f450a = yVar.f573a;
            } else {
                i++;
            }
        }
        savedState.f450a = yVar.f573a;
        savedState.f451b = this.f441r;
        savedState.f452c = this.f442s;
        savedState.f453d = this.f443t;
        savedState.f454e = this.f444u;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View a;
        this.f434k.mo1845b(motionEvent);
        this.f435l.mo1845b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f449z = x;
                this.f415A = y;
                this.f445v = false;
                this.f446w = false;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View d = this.f434k.mo1854d((int) x2, (int) y2);
                if (d != null && mo1662f(d)) {
                    float f = x2 - this.f449z;
                    float f2 = y2 - this.f415A;
                    int d2 = this.f434k.mo1853d();
                    if ((f * f) + (f2 * f2) < ((float) (d2 * d2)) && (a = mo1636a()) != null) {
                        z = mo1635a(a) == 2;
                        mo1642a(z);
                        this.f445v = false;
                        break;
                    }
                }
                z = true;
                mo1642a(z);
                this.f445v = false;
            case 3:
                mo1642a(true);
                this.f445v = false;
                this.f446w = false;
                break;
        }
        return true;
    }

    public void openDrawer(View view) {
        if (!mo1664g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        C0424y yVar = (C0424y) view.getLayoutParams();
        if (this.f440q) {
            float unused = yVar.f574b = 1.0f;
            int unused2 = yVar.f576d = 1;
            m1359a(view, true);
        } else {
            int unused3 = yVar.f576d = yVar.f576d | 2;
            if (mo1643a(view, 3)) {
                this.f434k.mo1842a(view, 0, view.getTop());
            } else {
                this.f435l.mo1842a(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f445v = z;
        if (z) {
            mo1642a(true);
        }
    }

    public void requestLayout() {
        if (!this.f439p) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f) {
        this.f429f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (mo1664g(childAt)) {
                C0247by.m907c(childAt, this.f429f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(C0423x xVar) {
        if (this.f447x != null) {
            mo1648b(this.f447x);
        }
        if (xVar != null) {
            mo1639a(xVar);
        }
        this.f447x = xVar;
    }

    public void setDrawerLockMode(int i) {
        mo1637a(i, 3);
        mo1637a(i, 5);
    }

    public void setScrimColor(int i) {
        this.f431h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f416B = i != 0 ? C0025a.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f416B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f416B = new ColorDrawable(i);
        invalidate();
    }
}
