package android.support.p009v4.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p009v4.p018e.C0131d;
import android.support.p009v4.widget.C0363af;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: android.support.v4.view.ViewPager */
public class ViewPager extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int[] f235a = {16842931};

    /* renamed from: aj */
    private static final C0306ec f236aj = new C0306ec();

    /* renamed from: c */
    private static final Comparator f237c = new C0292dp();

    /* renamed from: d */
    private static final Interpolator f238d = new C0293dq();

    /* renamed from: A */
    private int f239A = 1;

    /* renamed from: B */
    private boolean f240B;

    /* renamed from: C */
    private boolean f241C;

    /* renamed from: D */
    private int f242D;

    /* renamed from: E */
    private int f243E;

    /* renamed from: F */
    private int f244F;

    /* renamed from: G */
    private float f245G;

    /* renamed from: H */
    private float f246H;

    /* renamed from: I */
    private float f247I;

    /* renamed from: J */
    private float f248J;

    /* renamed from: K */
    private int f249K = -1;

    /* renamed from: L */
    private VelocityTracker f250L;

    /* renamed from: M */
    private int f251M;

    /* renamed from: N */
    private int f252N;

    /* renamed from: O */
    private int f253O;

    /* renamed from: P */
    private int f254P;

    /* renamed from: Q */
    private boolean f255Q;

    /* renamed from: R */
    private long f256R;

    /* renamed from: S */
    private C0363af f257S;

    /* renamed from: T */
    private C0363af f258T;

    /* renamed from: U */
    private boolean f259U = true;

    /* renamed from: V */
    private boolean f260V = false;

    /* renamed from: W */
    private boolean f261W;

    /* renamed from: aa */
    private int f262aa;

    /* renamed from: ab */
    private List f263ab;

    /* renamed from: ac */
    private C0301dy f264ac;

    /* renamed from: ad */
    private C0301dy f265ad;

    /* renamed from: ae */
    private C0300dx f266ae;

    /* renamed from: af */
    private C0302dz f267af;

    /* renamed from: ag */
    private Method f268ag;

    /* renamed from: ah */
    private int f269ah;

    /* renamed from: ai */
    private ArrayList f270ai;

    /* renamed from: ak */
    private final Runnable f271ak = new C0294dr(this);

    /* renamed from: al */
    private int f272al = 0;

    /* renamed from: b */
    private int f273b;

    /* renamed from: e */
    private final ArrayList f274e = new ArrayList();

    /* renamed from: f */
    private final C0297du f275f = new C0297du();

    /* renamed from: g */
    private final Rect f276g = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0239bq f277h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f278i;

    /* renamed from: j */
    private int f279j = -1;

    /* renamed from: k */
    private Parcelable f280k = null;

    /* renamed from: l */
    private ClassLoader f281l = null;

    /* renamed from: m */
    private Scroller f282m;

    /* renamed from: n */
    private boolean f283n;

    /* renamed from: o */
    private C0304ea f284o;

    /* renamed from: p */
    private int f285p;

    /* renamed from: q */
    private Drawable f286q;

    /* renamed from: r */
    private int f287r;

    /* renamed from: s */
    private int f288s;

    /* renamed from: t */
    private float f289t = -3.4028235E38f;

    /* renamed from: u */
    private float f290u = Float.MAX_VALUE;

    /* renamed from: v */
    private int f291v;

    /* renamed from: w */
    private int f292w;

    /* renamed from: x */
    private boolean f293x;

    /* renamed from: y */
    private boolean f294y;

    /* renamed from: z */
    private boolean f295z;

    /* renamed from: android.support.v4.view.ViewPager$SavedState */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = C0131d.m320a(new C0305eb());

        /* renamed from: a */
        int f296a;

        /* renamed from: b */
        Parcelable f297b;

        /* renamed from: c */
        ClassLoader f298c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f296a = parcel.readInt();
            this.f297b = parcel.readParcelable(classLoader);
            this.f298c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f296a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f296a);
            parcel.writeParcelable(this.f297b, i);
        }
    }

    public ViewPager(Context context) {
        super(context);
        mo1183a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1183a();
    }

    /* renamed from: a */
    private int m402a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f253O || Math.abs(i2) <= this.f251M) {
            i = (int) ((i >= this.f278i ? 0.4f : 0.6f) + ((float) i) + f);
        } else if (i2 <= 0) {
            i++;
        }
        return this.f274e.size() > 0 ? Math.max(((C0297du) this.f274e.get(0)).f370b, Math.min(i, ((C0297du) this.f274e.get(this.f274e.size() - 1)).f370b)) : i;
    }

    /* renamed from: a */
    private Rect m403a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    /* renamed from: a */
    private void m405a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f274e.isEmpty()) {
            C0297du b = mo1195b(this.f278i);
            int min = (int) ((b != null ? Math.min(b.f373e, this.f290u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m410a(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.f282m.isFinished()) {
            this.f282m.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        }
    }

    /* renamed from: a */
    private void m406a(int i, boolean z, int i2, boolean z2) {
        int i3;
        C0297du b = mo1195b(i);
        if (b != null) {
            i3 = (int) (Math.max(this.f289t, Math.min(b.f373e, this.f290u)) * ((float) getClientWidth()));
        } else {
            i3 = 0;
        }
        if (z) {
            mo1186a(i3, 0, i2);
            if (z2) {
                m418e(i);
                return;
            }
            return;
        }
        if (z2) {
            m418e(i);
        }
        m410a(false);
        scrollTo(i3, 0);
        m417d(i3);
    }

    /* renamed from: a */
    private void m408a(C0297du duVar, int i, C0297du duVar2) {
        C0297du duVar3;
        C0297du duVar4;
        int count = this.f277h.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.f285p) / ((float) clientWidth) : 0.0f;
        if (duVar2 != null) {
            int i2 = duVar2.f370b;
            if (i2 < duVar.f370b) {
                float f2 = duVar2.f373e + duVar2.f372d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= duVar.f370b && i4 < this.f274e.size()) {
                    Object obj = this.f274e.get(i4);
                    while (true) {
                        duVar4 = (C0297du) obj;
                        if (i3 > duVar4.f370b && i4 < this.f274e.size() - 1) {
                            i4++;
                            obj = this.f274e.get(i4);
                        }
                    }
                    while (i3 < duVar4.f370b) {
                        f2 += this.f277h.getPageWidth(i3) + f;
                        i3++;
                    }
                    duVar4.f373e = f2;
                    f2 += duVar4.f372d + f;
                    i3++;
                }
            } else if (i2 > duVar.f370b) {
                int size = this.f274e.size() - 1;
                float f3 = duVar2.f373e;
                int i5 = i2 - 1;
                while (i5 >= duVar.f370b && size >= 0) {
                    Object obj2 = this.f274e.get(size);
                    while (true) {
                        duVar3 = (C0297du) obj2;
                        if (i5 < duVar3.f370b && size > 0) {
                            size--;
                            obj2 = this.f274e.get(size);
                        }
                    }
                    while (i5 > duVar3.f370b) {
                        f3 -= this.f277h.getPageWidth(i5) + f;
                        i5--;
                    }
                    f3 -= duVar3.f372d + f;
                    duVar3.f373e = f3;
                    i5--;
                }
            }
        }
        int size2 = this.f274e.size();
        float f4 = duVar.f373e;
        int i6 = duVar.f370b - 1;
        this.f289t = duVar.f370b == 0 ? duVar.f373e : -3.4028235E38f;
        this.f290u = duVar.f370b == count + -1 ? (duVar.f373e + duVar.f372d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            C0297du duVar5 = (C0297du) this.f274e.get(i7);
            float f5 = f4;
            while (i6 > duVar5.f370b) {
                f5 -= this.f277h.getPageWidth(i6) + f;
                i6--;
            }
            f4 = f5 - (duVar5.f372d + f);
            duVar5.f373e = f4;
            if (duVar5.f370b == 0) {
                this.f289t = f4;
            }
            i6--;
        }
        float f6 = duVar.f373e + duVar.f372d + f;
        int i8 = duVar.f370b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            C0297du duVar6 = (C0297du) this.f274e.get(i9);
            float f7 = f6;
            while (i8 < duVar6.f370b) {
                f7 = this.f277h.getPageWidth(i8) + f + f7;
                i8++;
            }
            if (duVar6.f370b == count - 1) {
                this.f290u = (duVar6.f372d + f7) - 1.0f;
            }
            duVar6.f373e = f7;
            f6 = f7 + duVar6.f372d + f;
            i8++;
        }
        this.f260V = false;
    }

    /* renamed from: a */
    private void m409a(MotionEvent motionEvent) {
        int b = C0223ba.m830b(motionEvent);
        if (C0223ba.m831b(motionEvent, b) == this.f249K) {
            int i = b == 0 ? 1 : 0;
            this.f245G = C0223ba.m832c(motionEvent, i);
            this.f249K = C0223ba.m831b(motionEvent, i);
            if (this.f250L != null) {
                this.f250L.clear();
            }
        }
    }

    /* renamed from: a */
    private void m410a(boolean z) {
        boolean z2 = this.f272al == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f282m.isFinished()) {
                this.f282m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f282m.getCurrX();
                int currY = this.f282m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m417d(currX);
                    }
                }
            }
        }
        this.f295z = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f274e.size(); i++) {
            C0297du duVar = (C0297du) this.f274e.get(i);
            if (duVar.f371c) {
                duVar.f371c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            C0247by.m897a((View) this, this.f271ak);
        } else {
            this.f271ak.run();
        }
    }

    /* renamed from: a */
    private boolean m411a(float f, float f2) {
        return (f < ((float) this.f243E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f243E)) && f2 < 0.0f);
    }

    /* renamed from: b */
    private void m413b(int i, float f, int i2) {
        if (this.f264ac != null) {
            this.f264ac.mo1535a(i, f, i2);
        }
        if (this.f263ab != null) {
            int size = this.f263ab.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0301dy dyVar = (C0301dy) this.f263ab.get(i3);
                if (dyVar != null) {
                    dyVar.mo1535a(i, f, i2);
                }
            }
        }
        if (this.f265ad != null) {
            this.f265ad.mo1535a(i, f, i2);
        }
    }

    /* renamed from: b */
    private void m414b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0247by.m892a(getChildAt(i), z ? 2 : 0, (Paint) null);
        }
    }

    /* renamed from: c */
    private void m415c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: c */
    private boolean m416c(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        this.f245G = f;
        float scrollX = ((float) getScrollX()) + (this.f245G - f);
        int clientWidth = getClientWidth();
        float f3 = ((float) clientWidth) * this.f289t;
        float f4 = ((float) clientWidth) * this.f290u;
        C0297du duVar = (C0297du) this.f274e.get(0);
        C0297du duVar2 = (C0297du) this.f274e.get(this.f274e.size() - 1);
        if (duVar.f370b != 0) {
            f3 = duVar.f373e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (duVar2.f370b != this.f277h.getCount() - 1) {
            f2 = duVar2.f373e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f4;
        }
        if (scrollX < f3) {
            if (z) {
                z3 = this.f257S.mo1782a(Math.abs(f3 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f258T.mo1782a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f3 = f2;
        } else {
            f3 = scrollX;
        }
        this.f245G += f3 - ((float) ((int) f3));
        scrollTo((int) f3, getScrollY());
        m417d((int) f3);
        return z3;
    }

    /* renamed from: d */
    private boolean m417d(int i) {
        if (this.f274e.size() == 0) {
            this.f261W = false;
            mo1185a(0, 0.0f, 0);
            if (this.f261W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0297du m = m424m();
        int clientWidth = getClientWidth();
        int i2 = this.f285p + clientWidth;
        float f = ((float) this.f285p) / ((float) clientWidth);
        int i3 = m.f370b;
        float f2 = ((((float) i) / ((float) clientWidth)) - m.f373e) / (m.f372d + f);
        this.f261W = false;
        mo1185a(i3, f2, (int) (((float) i2) * f2));
        if (this.f261W) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* renamed from: e */
    private void m418e(int i) {
        if (this.f264ac != null) {
            this.f264ac.mo1534a(i);
        }
        if (this.f263ab != null) {
            int size = this.f263ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0301dy dyVar = (C0301dy) this.f263ab.get(i2);
                if (dyVar != null) {
                    dyVar.mo1534a(i);
                }
            }
        }
        if (this.f265ad != null) {
            this.f265ad.mo1534a(i);
        }
    }

    /* renamed from: f */
    private void m419f(int i) {
        if (this.f264ac != null) {
            this.f264ac.mo1536b(i);
        }
        if (this.f263ab != null) {
            int size = this.f263ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0301dy dyVar = (C0301dy) this.f263ab.get(i2);
                if (dyVar != null) {
                    dyVar.mo1536b(i);
                }
            }
        }
        if (this.f265ad != null) {
            this.f265ad.mo1536b(i);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: j */
    private void m421j() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((C0298dv) getChildAt(i2).getLayoutParams()).f374a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: k */
    private void m422k() {
        if (this.f269ah != 0) {
            if (this.f270ai == null) {
                this.f270ai = new ArrayList();
            } else {
                this.f270ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f270ai.add(getChildAt(i));
            }
            Collections.sort(this.f270ai, f236aj);
        }
    }

    /* renamed from: l */
    private boolean m423l() {
        this.f249K = -1;
        m425n();
        return this.f257S.mo1787c() | this.f258T.mo1787c();
    }

    /* renamed from: m */
    private C0297du m424m() {
        int i;
        C0297du duVar;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f285p) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        C0297du duVar2 = null;
        while (i3 < this.f274e.size()) {
            C0297du duVar3 = (C0297du) this.f274e.get(i3);
            if (z || duVar3.f370b == i2 + 1) {
                C0297du duVar4 = duVar3;
                i = i3;
                duVar = duVar4;
            } else {
                C0297du duVar5 = this.f275f;
                duVar5.f373e = f2 + f3 + f;
                duVar5.f370b = i2 + 1;
                duVar5.f372d = this.f277h.getPageWidth(duVar5.f370b);
                C0297du duVar6 = duVar5;
                i = i3 - 1;
                duVar = duVar6;
            }
            float f4 = duVar.f373e;
            float f5 = duVar.f372d + f4 + f;
            if (!z && scrollX < f4) {
                return duVar2;
            }
            if (scrollX < f5 || i == this.f274e.size() - 1) {
                return duVar;
            }
            f3 = f4;
            i2 = duVar.f370b;
            z = false;
            f2 = duVar.f372d;
            duVar2 = duVar;
            i3 = i + 1;
        }
        return duVar2;
    }

    /* renamed from: n */
    private void m425n() {
        this.f240B = false;
        this.f241C = false;
        if (this.f250L != null) {
            this.f250L.recycle();
            this.f250L = null;
        }
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f272al != i) {
            this.f272al = i;
            if (this.f267af != null) {
                m414b(i != 0);
            }
            m419f(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f294y != z) {
            this.f294y = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo1180a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0297du mo1181a(int i, int i2) {
        C0297du duVar = new C0297du();
        duVar.f370b = i;
        duVar.f369a = this.f277h.instantiateItem((ViewGroup) this, i);
        duVar.f372d = this.f277h.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f274e.size()) {
            this.f274e.add(duVar);
        } else {
            this.f274e.add(i2, duVar);
        }
        return duVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0297du mo1182a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f274e.size()) {
                return null;
            }
            C0297du duVar = (C0297du) this.f274e.get(i2);
            if (this.f277h.isViewFromObject(view, duVar.f369a)) {
                return duVar;
            }
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1183a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f282m = new Scroller(context, f238d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f244F = C0275cz.m1119a(viewConfiguration);
        this.f251M = (int) (400.0f * f);
        this.f252N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f257S = new C0363af(context);
        this.f258T = new C0363af(context);
        this.f253O = (int) (25.0f * f);
        this.f254P = (int) (2.0f * f);
        this.f242D = (int) (16.0f * f);
        C0247by.m895a((View) this, (C0152a) new C0299dw(this));
        if (C0247by.m901b(this) == 0) {
            C0247by.m908c((View) this, 1);
        }
        C0247by.m896a((View) this, (C0238bp) new C0295ds(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f0, code lost:
        if (r2.f370b == r17.f278i) goto L_0x00f2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1184a(int r18) {
        /*
            r17 = this;
            r2 = 0
            r0 = r17
            int r3 = r0.f278i
            r0 = r18
            if (r3 == r0) goto L_0x0323
            r0 = r17
            int r2 = r0.f278i
            r0 = r17
            android.support.v4.view.du r2 = r0.mo1195b((int) r2)
            r0 = r18
            r1 = r17
            r1.f278i = r0
            r3 = r2
        L_0x001a:
            r0 = r17
            android.support.v4.view.bq r2 = r0.f277h
            if (r2 != 0) goto L_0x0024
            r17.m422k()
        L_0x0023:
            return
        L_0x0024:
            r0 = r17
            boolean r2 = r0.f295z
            if (r2 == 0) goto L_0x002e
            r17.m422k()
            goto L_0x0023
        L_0x002e:
            android.os.IBinder r2 = r17.getWindowToken()
            if (r2 == 0) goto L_0x0023
            r0 = r17
            android.support.v4.view.bq r2 = r0.f277h
            r0 = r17
            r2.startUpdate((android.view.ViewGroup) r0)
            r0 = r17
            int r2 = r0.f239A
            r4 = 0
            r0 = r17
            int r5 = r0.f278i
            int r5 = r5 - r2
            int r10 = java.lang.Math.max(r4, r5)
            r0 = r17
            android.support.v4.view.bq r4 = r0.f277h
            int r11 = r4.getCount()
            int r4 = r11 + -1
            r0 = r17
            int r5 = r0.f278i
            int r2 = r2 + r5
            int r12 = java.lang.Math.min(r4, r2)
            r0 = r17
            int r2 = r0.f273b
            if (r11 == r2) goto L_0x00cb
            android.content.res.Resources r2 = r17.getResources()     // Catch:{ NotFoundException -> 0x00c1 }
            int r3 = r17.getId()     // Catch:{ NotFoundException -> 0x00c1 }
            java.lang.String r2 = r2.getResourceName(r3)     // Catch:{ NotFoundException -> 0x00c1 }
        L_0x0070:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            java.lang.StringBuilder r4 = r4.append(r5)
            r0 = r17
            int r5 = r0.f273b
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = ", found: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r11)
            java.lang.String r5 = " Pager id: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = " Pager class: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.Class r4 = r17.getClass()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = " Problematic adapter: "
            java.lang.StringBuilder r2 = r2.append(r4)
            r0 = r17
            android.support.v4.view.bq r4 = r0.f277h
            java.lang.Class r4 = r4.getClass()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        L_0x00c1:
            r2 = move-exception
            int r2 = r17.getId()
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            goto L_0x0070
        L_0x00cb:
            r5 = 0
            r2 = 0
            r4 = r2
        L_0x00ce:
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            int r2 = r2.size()
            if (r4 >= r2) goto L_0x0320
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r4)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
            int r6 = r2.f370b
            r0 = r17
            int r7 = r0.f278i
            if (r6 < r7) goto L_0x01bc
            int r6 = r2.f370b
            r0 = r17
            int r7 = r0.f278i
            if (r6 != r7) goto L_0x0320
        L_0x00f2:
            if (r2 != 0) goto L_0x031d
            if (r11 <= 0) goto L_0x031d
            r0 = r17
            int r2 = r0.f278i
            r0 = r17
            android.support.v4.view.du r2 = r0.mo1181a((int) r2, (int) r4)
            r9 = r2
        L_0x0101:
            if (r9 == 0) goto L_0x016d
            r8 = 0
            int r7 = r4 + -1
            if (r7 < 0) goto L_0x01c1
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
        L_0x0112:
            int r13 = r17.getClientWidth()
            if (r13 > 0) goto L_0x01c4
            r5 = 0
        L_0x0119:
            r0 = r17
            int r6 = r0.f278i
            int r6 = r6 + -1
            r15 = r6
            r6 = r8
            r8 = r15
            r16 = r7
            r7 = r4
            r4 = r16
        L_0x0127:
            if (r8 < 0) goto L_0x0131
            int r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r14 < 0) goto L_0x0203
            if (r8 >= r10) goto L_0x0203
            if (r2 != 0) goto L_0x01d3
        L_0x0131:
            float r5 = r9.f372d
            int r8 = r7 + 1
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0168
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            int r2 = r2.size()
            if (r8 >= r2) goto L_0x0239
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r8)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
            r6 = r2
        L_0x0150:
            if (r13 > 0) goto L_0x023c
            r2 = 0
            r4 = r2
        L_0x0154:
            r0 = r17
            int r2 = r0.f278i
            int r2 = r2 + 1
            r15 = r2
            r2 = r6
            r6 = r8
            r8 = r15
        L_0x015e:
            if (r8 >= r11) goto L_0x0168
            int r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r10 < 0) goto L_0x0283
            if (r8 <= r12) goto L_0x0283
            if (r2 != 0) goto L_0x0249
        L_0x0168:
            r0 = r17
            r0.m408a((android.support.p009v4.view.C0297du) r9, (int) r7, (android.support.p009v4.view.C0297du) r3)
        L_0x016d:
            r0 = r17
            android.support.v4.view.bq r3 = r0.f277h
            r0 = r17
            int r4 = r0.f278i
            if (r9 == 0) goto L_0x02cd
            java.lang.Object r2 = r9.f369a
        L_0x0179:
            r0 = r17
            r3.setPrimaryItem((android.view.ViewGroup) r0, (int) r4, (java.lang.Object) r2)
            r0 = r17
            android.support.v4.view.bq r2 = r0.f277h
            r0 = r17
            r2.finishUpdate((android.view.ViewGroup) r0)
            int r4 = r17.getChildCount()
            r2 = 0
            r3 = r2
        L_0x018d:
            if (r3 >= r4) goto L_0x02d0
            r0 = r17
            android.view.View r5 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.support.v4.view.dv r2 = (android.support.p009v4.view.C0298dv) r2
            r2.f379f = r3
            boolean r6 = r2.f374a
            if (r6 != 0) goto L_0x01b8
            float r6 = r2.f376c
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01b8
            r0 = r17
            android.support.v4.view.du r5 = r0.mo1182a((android.view.View) r5)
            if (r5 == 0) goto L_0x01b8
            float r6 = r5.f372d
            r2.f376c = r6
            int r5 = r5.f370b
            r2.f378e = r5
        L_0x01b8:
            int r2 = r3 + 1
            r3 = r2
            goto L_0x018d
        L_0x01bc:
            int r2 = r4 + 1
            r4 = r2
            goto L_0x00ce
        L_0x01c1:
            r2 = 0
            goto L_0x0112
        L_0x01c4:
            r5 = 1073741824(0x40000000, float:2.0)
            float r6 = r9.f372d
            float r5 = r5 - r6
            int r6 = r17.getPaddingLeft()
            float r6 = (float) r6
            float r14 = (float) r13
            float r6 = r6 / r14
            float r5 = r5 + r6
            goto L_0x0119
        L_0x01d3:
            int r14 = r2.f370b
            if (r8 != r14) goto L_0x01fd
            boolean r14 = r2.f371c
            if (r14 != 0) goto L_0x01fd
            r0 = r17
            java.util.ArrayList r14 = r0.f274e
            r14.remove(r4)
            r0 = r17
            android.support.v4.view.bq r14 = r0.f277h
            java.lang.Object r2 = r2.f369a
            r0 = r17
            r14.destroyItem((android.view.ViewGroup) r0, (int) r8, (java.lang.Object) r2)
            int r4 = r4 + -1
            int r7 = r7 + -1
            if (r4 < 0) goto L_0x0201
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r4)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
        L_0x01fd:
            int r8 = r8 + -1
            goto L_0x0127
        L_0x0201:
            r2 = 0
            goto L_0x01fd
        L_0x0203:
            if (r2 == 0) goto L_0x021d
            int r14 = r2.f370b
            if (r8 != r14) goto L_0x021d
            float r2 = r2.f372d
            float r6 = r6 + r2
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x021b
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r4)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
            goto L_0x01fd
        L_0x021b:
            r2 = 0
            goto L_0x01fd
        L_0x021d:
            int r2 = r4 + 1
            r0 = r17
            android.support.v4.view.du r2 = r0.mo1181a((int) r8, (int) r2)
            float r2 = r2.f372d
            float r6 = r6 + r2
            int r7 = r7 + 1
            if (r4 < 0) goto L_0x0237
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r4)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
            goto L_0x01fd
        L_0x0237:
            r2 = 0
            goto L_0x01fd
        L_0x0239:
            r6 = 0
            goto L_0x0150
        L_0x023c:
            int r2 = r17.getPaddingRight()
            float r2 = (float) r2
            float r4 = (float) r13
            float r2 = r2 / r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 + r4
            r4 = r2
            goto L_0x0154
        L_0x0249:
            int r10 = r2.f370b
            if (r8 != r10) goto L_0x0318
            boolean r10 = r2.f371c
            if (r10 != 0) goto L_0x0318
            r0 = r17
            java.util.ArrayList r10 = r0.f274e
            r10.remove(r6)
            r0 = r17
            android.support.v4.view.bq r10 = r0.f277h
            java.lang.Object r2 = r2.f369a
            r0 = r17
            r10.destroyItem((android.view.ViewGroup) r0, (int) r8, (java.lang.Object) r2)
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            int r2 = r2.size()
            if (r6 >= r2) goto L_0x0281
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r6)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
        L_0x0277:
            r15 = r5
            r5 = r2
            r2 = r15
        L_0x027a:
            int r8 = r8 + 1
            r15 = r2
            r2 = r5
            r5 = r15
            goto L_0x015e
        L_0x0281:
            r2 = 0
            goto L_0x0277
        L_0x0283:
            if (r2 == 0) goto L_0x02a8
            int r10 = r2.f370b
            if (r8 != r10) goto L_0x02a8
            float r2 = r2.f372d
            float r5 = r5 + r2
            int r6 = r6 + 1
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            int r2 = r2.size()
            if (r6 >= r2) goto L_0x02a6
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r6)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
        L_0x02a2:
            r15 = r5
            r5 = r2
            r2 = r15
            goto L_0x027a
        L_0x02a6:
            r2 = 0
            goto L_0x02a2
        L_0x02a8:
            r0 = r17
            android.support.v4.view.du r2 = r0.mo1181a((int) r8, (int) r6)
            int r6 = r6 + 1
            float r2 = r2.f372d
            float r5 = r5 + r2
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            int r2 = r2.size()
            if (r6 >= r2) goto L_0x02cb
            r0 = r17
            java.util.ArrayList r2 = r0.f274e
            java.lang.Object r2 = r2.get(r6)
            android.support.v4.view.du r2 = (android.support.p009v4.view.C0297du) r2
        L_0x02c7:
            r15 = r5
            r5 = r2
            r2 = r15
            goto L_0x027a
        L_0x02cb:
            r2 = 0
            goto L_0x02c7
        L_0x02cd:
            r2 = 0
            goto L_0x0179
        L_0x02d0:
            r17.m422k()
            boolean r2 = r17.hasFocus()
            if (r2 == 0) goto L_0x0023
            android.view.View r2 = r17.findFocus()
            if (r2 == 0) goto L_0x0316
            r0 = r17
            android.support.v4.view.du r2 = r0.mo1196b((android.view.View) r2)
        L_0x02e5:
            if (r2 == 0) goto L_0x02ef
            int r2 = r2.f370b
            r0 = r17
            int r3 = r0.f278i
            if (r2 == r3) goto L_0x0023
        L_0x02ef:
            r2 = 0
        L_0x02f0:
            int r3 = r17.getChildCount()
            if (r2 >= r3) goto L_0x0023
            r0 = r17
            android.view.View r3 = r0.getChildAt(r2)
            r0 = r17
            android.support.v4.view.du r4 = r0.mo1182a((android.view.View) r3)
            if (r4 == 0) goto L_0x0313
            int r4 = r4.f370b
            r0 = r17
            int r5 = r0.f278i
            if (r4 != r5) goto L_0x0313
            r4 = 2
            boolean r3 = r3.requestFocus(r4)
            if (r3 != 0) goto L_0x0023
        L_0x0313:
            int r2 = r2 + 1
            goto L_0x02f0
        L_0x0316:
            r2 = 0
            goto L_0x02e5
        L_0x0318:
            r15 = r5
            r5 = r2
            r2 = r15
            goto L_0x027a
        L_0x031d:
            r9 = r2
            goto L_0x0101
        L_0x0320:
            r2 = r5
            goto L_0x00f2
        L_0x0323:
            r3 = r2
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.view.ViewPager.mo1184a(int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1185a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.f262aa > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                C0298dv dvVar = (C0298dv) childAt.getLayoutParams();
                if (!dvVar.f374a) {
                    int i6 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i6;
                } else {
                    switch (dvVar.f375b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i7 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i7;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i8 = paddingLeft;
                            i4 = paddingRight;
                            i3 = width2;
                            measuredWidth = i8;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            i4 = measuredWidth2;
                            break;
                        default:
                            measuredWidth = paddingLeft;
                            int i9 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i9;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                }
                i5++;
                int i10 = i4;
                paddingLeft = i3;
                paddingRight = i10;
            }
        }
        m413b(i, f, i2);
        if (this.f267af != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((C0298dv) childAt2.getLayoutParams()).f374a) {
                    this.f267af.mo1537a(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.f261W = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1186a(int i, int i2, int i3) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (this.f282m != null && !this.f282m.isFinished()) {
            int currX = this.f283n ? this.f282m.getCurrX() : this.f282m.getStartX();
            this.f282m.abortAnimation();
            setScrollingCacheEnabled(false);
            scrollX = currX;
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m410a(false);
            mo1199c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * mo1180a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        int min = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4 : (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f277h.getPageWidth(this.f278i)) + ((float) this.f285p))) + 1.0f) * 100.0f), 600);
        this.f283n = false;
        this.f282m.startScroll(scrollX, scrollY, i4, i5, min);
        C0247by.postInvalidateOnAnimation(this);
    }

    /* renamed from: a */
    public void mo1187a(int i, boolean z) {
        this.f295z = false;
        mo1188a(i, z, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1188a(int i, boolean z, boolean z2) {
        mo1189a(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1189a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f277h == null || this.f277h.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f278i != i || this.f274e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f277h.getCount()) {
                i = this.f277h.getCount() - 1;
            }
            int i3 = this.f239A;
            if (i > this.f278i + i3 || i < this.f278i - i3) {
                for (int i4 = 0; i4 < this.f274e.size(); i4++) {
                    ((C0297du) this.f274e.get(i4)).f371c = true;
                }
            }
            if (this.f278i != i) {
                z3 = true;
            }
            if (this.f259U) {
                this.f278i = i;
                if (z3) {
                    m418e(i);
                }
                requestLayout();
                return;
            }
            mo1184a(i);
            m406a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* renamed from: a */
    public boolean mo1190a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return mo1200c(17);
            case 22:
                return mo1200c(66);
            case C0515k.AppCompatTheme_popupMenuStyle /*61*/:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0352v.m1339a(keyEvent)) {
                    return mo1200c(2);
                }
                if (C0352v.m1340a(keyEvent, 1)) {
                    return mo1200c(1);
                }
                return false;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo1191a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (mo1191a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && C0247by.m900a(view, -i);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        C0297du a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a = mo1182a(childAt)) != null && a.f370b == this.f278i) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        C0297du a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo1182a(childAt)) != null && a.f370b == this.f278i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        C0298dv dvVar = (C0298dv) generateLayoutParams;
        dvVar.f374a |= view instanceof C0296dt;
        if (!this.f293x) {
            super.addView(view, i, generateLayoutParams);
        } else if (dvVar == null || !dvVar.f374a) {
            dvVar.f377d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0297du mo1195b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f274e.size()) {
                return null;
            }
            C0297du duVar = (C0297du) this.f274e.get(i3);
            if (duVar.f370b == i) {
                return duVar;
            }
            i2 = i3 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0297du mo1196b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo1182a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1197b() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int count = this.f277h.getCount();
        this.f273b = count;
        boolean z3 = this.f274e.size() < (this.f239A * 2) + 1 && this.f274e.size() < count;
        boolean z4 = false;
        int i3 = this.f278i;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.f274e.size()) {
            C0297du duVar = (C0297du) this.f274e.get(i4);
            int itemPosition = this.f277h.getItemPosition(duVar.f369a);
            if (itemPosition == -1) {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.f274e.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.f277h.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.f277h.destroyItem((ViewGroup) this, duVar.f370b, duVar.f369a);
                if (this.f278i == duVar.f370b) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.f278i, count - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i3;
                    z2 = true;
                }
            } else if (duVar.f370b != itemPosition) {
                if (duVar.f370b == this.f278i) {
                    i3 = itemPosition;
                }
                duVar.f370b = itemPosition;
                i = i4;
                z = z4;
                i2 = i3;
                z2 = true;
            } else {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            }
            z5 = z2;
            i3 = i2;
            z4 = z;
            i4 = i + 1;
        }
        if (z4) {
            this.f277h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f274e, f237c);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                C0298dv dvVar = (C0298dv) getChildAt(i6).getLayoutParams();
                if (!dvVar.f374a) {
                    dvVar.f376c = 0.0f;
                }
            }
            mo1188a(i3, false, true);
            requestLayout();
        }
    }

    /* renamed from: b */
    public void mo1198b(float f) {
        if (!this.f255Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.f277h != null) {
            this.f245G += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f2 = ((float) clientWidth) * this.f289t;
            float f3 = ((float) clientWidth) * this.f290u;
            C0297du duVar = (C0297du) this.f274e.get(0);
            C0297du duVar2 = (C0297du) this.f274e.get(this.f274e.size() - 1);
            float f4 = duVar.f370b != 0 ? duVar.f373e * ((float) clientWidth) : f2;
            float f5 = duVar2.f370b != this.f277h.getCount() + -1 ? duVar2.f373e * ((float) clientWidth) : f3;
            if (scrollX >= f4) {
                f4 = scrollX > f5 ? f5 : scrollX;
            }
            this.f245G += f4 - ((float) ((int) f4));
            scrollTo((int) f4, getScrollY());
            m417d((int) f4);
            MotionEvent obtain = MotionEvent.obtain(this.f256R, SystemClock.uptimeMillis(), 2, this.f245G, 0.0f, 0);
            this.f250L.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1199c() {
        mo1184a(this.f278i);
    }

    /* renamed from: c */
    public boolean mo1200c(int i) {
        View view;
        boolean z;
        boolean z2;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                z2 = mo1211g();
            } else {
                if (i == 66 || i == 2) {
                    z2 = mo1220h();
                }
                z2 = false;
            }
        } else if (i == 17) {
            z2 = (view == null || m403a(this.f276g, findNextFocus).left < m403a(this.f276g, view).left) ? findNextFocus.requestFocus() : mo1211g();
        } else {
            if (i == 66) {
                z2 = (view == null || m403a(this.f276g, findNextFocus).left > m403a(this.f276g, view).left) ? findNextFocus.requestFocus() : mo1220h();
            }
            z2 = false;
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f277h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f289t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f290u))) {
                z = false;
            }
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0298dv) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f283n = true;
        if (this.f282m.isFinished() || !this.f282m.computeScrollOffset()) {
            m410a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f282m.getCurrX();
        int currY = this.f282m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m417d(currX)) {
                this.f282m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C0247by.postInvalidateOnAnimation(this);
    }

    /* renamed from: d */
    public boolean mo1204d() {
        if (this.f240B) {
            return false;
        }
        this.f255Q = true;
        setScrollState(1);
        this.f245G = 0.0f;
        this.f247I = 0.0f;
        if (this.f250L == null) {
            this.f250L = VelocityTracker.obtain();
        } else {
            this.f250L.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f250L.addMovement(obtain);
        obtain.recycle();
        this.f256R = uptimeMillis;
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo1190a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0297du a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo1182a(childAt)) != null && a.f370b == this.f278i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int a = C0247by.m888a(this);
        if (a == 0 || (a == 1 && this.f277h != null && this.f277h.getCount() > 1)) {
            if (!this.f257S.mo1781a()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f289t * ((float) width));
                this.f257S.mo1780a(height, width);
                z = false | this.f257S.mo1785a(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f258T.mo1781a()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f290u + 1.0f)) * ((float) width2));
                this.f258T.mo1780a(height2, width2);
                z |= this.f258T.mo1785a(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f257S.mo1786b();
            this.f258T.mo1786b();
        }
        if (z) {
            C0247by.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f286q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: e */
    public void mo1209e() {
        if (!this.f255Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f277h != null) {
            VelocityTracker velocityTracker = this.f250L;
            velocityTracker.computeCurrentVelocity(1000, (float) this.f252N);
            int a = (int) C0242bt.m877a(velocityTracker, this.f249K);
            this.f295z = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            C0297du m = m424m();
            mo1189a(m402a(m.f370b, ((((float) scrollX) / ((float) clientWidth)) - m.f373e) / m.f372d, a, (int) (this.f245G - this.f247I)), true, true, a);
        }
        m425n();
        this.f255Q = false;
    }

    /* renamed from: f */
    public boolean mo1210f() {
        return this.f255Q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo1211g() {
        if (this.f278i <= 0) {
            return false;
        }
        mo1187a(this.f278i - 1, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0298dv();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0298dv(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public C0239bq getAdapter() {
        return this.f277h;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f269ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0298dv) ((View) this.f270ai.get(i2)).getLayoutParams()).f379f;
    }

    public int getCurrentItem() {
        return this.f278i;
    }

    public int getOffscreenPageLimit() {
        return this.f239A;
    }

    public int getPageMargin() {
        return this.f285p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo1220h() {
        if (this.f277h == null || this.f278i >= this.f277h.getCount() - 1) {
            return false;
        }
        mo1187a(this.f278i + 1, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f259U = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f271ak);
        if (this.f282m != null && !this.f282m.isFinished()) {
            this.f282m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f285p > 0 && this.f286q != null && this.f274e.size() > 0 && this.f277h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = ((float) this.f285p) / ((float) width);
            C0297du duVar = (C0297du) this.f274e.get(0);
            float f3 = duVar.f373e;
            int size = this.f274e.size();
            int i = duVar.f370b;
            int i2 = ((C0297du) this.f274e.get(size - 1)).f370b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                while (i4 > duVar.f370b && i3 < size) {
                    i3++;
                    duVar = (C0297du) this.f274e.get(i3);
                }
                if (i4 == duVar.f370b) {
                    f = (duVar.f373e + duVar.f372d) * ((float) width);
                    f3 = duVar.f373e + duVar.f372d + f2;
                } else {
                    float pageWidth = this.f277h.getPageWidth(i4);
                    f = (f3 + pageWidth) * ((float) width);
                    f3 += pageWidth + f2;
                }
                if (((float) this.f285p) + f > ((float) scrollX)) {
                    this.f286q.setBounds(Math.round(f), this.f287r, Math.round(((float) this.f285p) + f), this.f288s);
                    this.f286q.draw(canvas);
                }
                if (f <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m423l();
            return false;
        }
        if (action != 0) {
            if (this.f240B) {
                return true;
            }
            if (this.f241C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f247I = x;
                this.f245G = x;
                float y = motionEvent.getY();
                this.f248J = y;
                this.f246H = y;
                this.f249K = C0223ba.m831b(motionEvent, 0);
                this.f241C = false;
                this.f283n = true;
                this.f282m.computeScrollOffset();
                if (this.f272al == 2 && Math.abs(this.f282m.getFinalX() - this.f282m.getCurrX()) > this.f254P) {
                    this.f282m.abortAnimation();
                    this.f295z = false;
                    mo1199c();
                    this.f240B = true;
                    m415c(true);
                    setScrollState(1);
                    break;
                } else {
                    m410a(false);
                    this.f240B = false;
                    break;
                }
            case 2:
                int i = this.f249K;
                if (i != -1) {
                    int a = C0223ba.m829a(motionEvent, i);
                    float c = C0223ba.m832c(motionEvent, a);
                    float f = c - this.f245G;
                    float abs = Math.abs(f);
                    float d = C0223ba.m834d(motionEvent, a);
                    float abs2 = Math.abs(d - this.f248J);
                    if (f != 0.0f && !m411a(this.f245G, f)) {
                        if (mo1191a(this, false, (int) f, (int) c, (int) d)) {
                            this.f245G = c;
                            this.f246H = d;
                            this.f241C = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.f244F) && 0.5f * abs > abs2) {
                        this.f240B = true;
                        m415c(true);
                        setScrollState(1);
                        this.f245G = f > 0.0f ? this.f247I + ((float) this.f244F) : this.f247I - ((float) this.f244F);
                        this.f246H = d;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.f244F)) {
                        this.f241C = true;
                    }
                    if (this.f240B && m416c(c)) {
                        C0247by.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                m409a(motionEvent);
                break;
        }
        if (this.f250L == null) {
            this.f250L = VelocityTracker.obtain();
        }
        this.f250L.addMovement(motionEvent);
        return this.f240B;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0297du a;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i3 - i;
        int i11 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C0298dv dvVar = (C0298dv) childAt.getLayoutParams();
                if (dvVar.f374a) {
                    int i14 = dvVar.f375b & 7;
                    int i15 = dvVar.f375b & C0515k.AppCompatTheme_spinnerStyle;
                    switch (i14) {
                        case 1:
                            i7 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            i7 = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i7 = measuredWidth;
                            break;
                        default:
                            i7 = paddingLeft;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i16 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i16;
                            break;
                        case C0515k.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case C0515k.AppCompatTheme_panelMenuListWidth /*80*/:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            i9 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i18 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i18;
                            break;
                    }
                    int i19 = i7 + scrollX;
                    childAt.layout(i19, measuredHeight, childAt.getMeasuredWidth() + i19, childAt.getMeasuredHeight() + measuredHeight);
                    i5 = i12 + 1;
                    i6 = i8;
                    paddingBottom = i9;
                    i13++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingRight;
                    paddingTop = i6;
                    i12 = i5;
                }
            }
            i5 = i12;
            i6 = paddingTop;
            i13++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i6;
            i12 = i5;
        }
        int i20 = (i10 - paddingLeft) - paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                C0298dv dvVar2 = (C0298dv) childAt2.getLayoutParams();
                if (!dvVar2.f374a && (a = mo1182a(childAt2)) != null) {
                    int i22 = ((int) (a.f373e * ((float) i20))) + paddingLeft;
                    if (dvVar2.f377d) {
                        dvVar2.f377d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (dvVar2.f376c * ((float) i20)), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f287r = paddingTop;
        this.f288s = i11 - paddingBottom;
        this.f262aa = i12;
        if (this.f259U) {
            m406a(this.f278i, false, 0, false);
        }
        this.f259U = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r0 = getDefaultSize(r0, r14)
            r1 = 0
            int r1 = getDefaultSize(r1, r15)
            r13.setMeasuredDimension(r0, r1)
            int r0 = r13.getMeasuredWidth()
            int r1 = r0 / 10
            int r2 = r13.f242D
            int r1 = java.lang.Math.min(r1, r2)
            r13.f243E = r1
            int r1 = r13.getPaddingLeft()
            int r0 = r0 - r1
            int r1 = r13.getPaddingRight()
            int r3 = r0 - r1
            int r0 = r13.getMeasuredHeight()
            int r1 = r13.getPaddingTop()
            int r0 = r0 - r1
            int r1 = r13.getPaddingBottom()
            int r5 = r0 - r1
            int r9 = r13.getChildCount()
            r0 = 0
            r8 = r0
        L_0x003b:
            if (r8 >= r9) goto L_0x00bc
            android.view.View r10 = r13.getChildAt(r8)
            int r0 = r10.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x00a5
            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
            android.support.v4.view.dv r0 = (android.support.p009v4.view.C0298dv) r0
            if (r0 == 0) goto L_0x00a5
            boolean r1 = r0.f374a
            if (r1 == 0) goto L_0x00a5
            int r1 = r0.f375b
            r6 = r1 & 7
            int r1 = r0.f375b
            r4 = r1 & 112(0x70, float:1.57E-43)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 48
            if (r4 == r7) goto L_0x0069
            r7 = 80
            if (r4 != r7) goto L_0x00a9
        L_0x0069:
            r4 = 1
            r7 = r4
        L_0x006b:
            r4 = 3
            if (r6 == r4) goto L_0x0071
            r4 = 5
            if (r6 != r4) goto L_0x00ac
        L_0x0071:
            r4 = 1
            r6 = r4
        L_0x0073:
            if (r7 == 0) goto L_0x00af
            r2 = 1073741824(0x40000000, float:2.0)
        L_0x0077:
            int r4 = r0.width
            r11 = -2
            if (r4 == r11) goto L_0x010f
            r4 = 1073741824(0x40000000, float:2.0)
            int r2 = r0.width
            r11 = -1
            if (r2 == r11) goto L_0x010c
            int r2 = r0.width
        L_0x0085:
            int r11 = r0.height
            r12 = -2
            if (r11 == r12) goto L_0x010a
            r1 = 1073741824(0x40000000, float:2.0)
            int r11 = r0.height
            r12 = -1
            if (r11 == r12) goto L_0x010a
            int r0 = r0.height
        L_0x0093:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r10.measure(r2, r0)
            if (r7 == 0) goto L_0x00b4
            int r0 = r10.getMeasuredHeight()
            int r5 = r5 - r0
        L_0x00a5:
            int r0 = r8 + 1
            r8 = r0
            goto L_0x003b
        L_0x00a9:
            r4 = 0
            r7 = r4
            goto L_0x006b
        L_0x00ac:
            r4 = 0
            r6 = r4
            goto L_0x0073
        L_0x00af:
            if (r6 == 0) goto L_0x0077
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x0077
        L_0x00b4:
            if (r6 == 0) goto L_0x00a5
            int r0 = r10.getMeasuredWidth()
            int r3 = r3 - r0
            goto L_0x00a5
        L_0x00bc:
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r0)
            r13.f291v = r0
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            r13.f292w = r0
            r0 = 1
            r13.f293x = r0
            r13.mo1199c()
            r0 = 0
            r13.f293x = r0
            int r2 = r13.getChildCount()
            r0 = 0
            r1 = r0
        L_0x00db:
            if (r1 >= r2) goto L_0x0109
            android.view.View r4 = r13.getChildAt(r1)
            int r0 = r4.getVisibility()
            r5 = 8
            if (r0 == r5) goto L_0x0105
            android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
            android.support.v4.view.dv r0 = (android.support.p009v4.view.C0298dv) r0
            if (r0 == 0) goto L_0x00f5
            boolean r5 = r0.f374a
            if (r5 != 0) goto L_0x0105
        L_0x00f5:
            float r5 = (float) r3
            float r0 = r0.f376c
            float r0 = r0 * r5
            int r0 = (int) r0
            r5 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            int r5 = r13.f292w
            r4.measure(r0, r5)
        L_0x0105:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x00db
        L_0x0109:
            return
        L_0x010a:
            r0 = r5
            goto L_0x0093
        L_0x010c:
            r2 = r3
            goto L_0x0085
        L_0x010f:
            r4 = r2
            r2 = r3
            goto L_0x0085
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.view.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        C0297du a;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a = mo1182a(childAt)) != null && a.f370b == this.f278i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f277h != null) {
            this.f277h.restoreState(savedState.f297b, savedState.f298c);
            mo1188a(savedState.f296a, false, true);
            return;
        }
        this.f279j = savedState.f296a;
        this.f280k = savedState.f297b;
        this.f281l = savedState.f298c;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f296a = this.f278i;
        if (this.f277h != null) {
            savedState.f297b = this.f277h.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m405a(i, i3, this.f285p, this.f285p);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f255Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f277h == null || this.f277h.getCount() == 0) {
            return false;
        }
        if (this.f250L == null) {
            this.f250L = VelocityTracker.obtain();
        }
        this.f250L.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f282m.abortAnimation();
                this.f295z = false;
                mo1199c();
                float x = motionEvent.getX();
                this.f247I = x;
                this.f245G = x;
                float y = motionEvent.getY();
                this.f248J = y;
                this.f246H = y;
                this.f249K = C0223ba.m831b(motionEvent, 0);
                break;
            case 1:
                if (this.f240B) {
                    VelocityTracker velocityTracker = this.f250L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f252N);
                    int a = (int) C0242bt.m877a(velocityTracker, this.f249K);
                    this.f295z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0297du m = m424m();
                    mo1189a(m402a(m.f370b, ((((float) scrollX) / ((float) clientWidth)) - m.f373e) / (m.f372d + (((float) this.f285p) / ((float) clientWidth))), a, (int) (C0223ba.m832c(motionEvent, C0223ba.m829a(motionEvent, this.f249K)) - this.f247I)), true, true, a);
                    z = m423l();
                    break;
                }
                break;
            case 2:
                if (!this.f240B) {
                    int a2 = C0223ba.m829a(motionEvent, this.f249K);
                    if (a2 == -1) {
                        z = m423l();
                        break;
                    } else {
                        float c = C0223ba.m832c(motionEvent, a2);
                        float abs = Math.abs(c - this.f245G);
                        float d = C0223ba.m834d(motionEvent, a2);
                        float abs2 = Math.abs(d - this.f246H);
                        if (abs > ((float) this.f244F) && abs > abs2) {
                            this.f240B = true;
                            m415c(true);
                            this.f245G = c - this.f247I > 0.0f ? this.f247I + ((float) this.f244F) : this.f247I - ((float) this.f244F);
                            this.f246H = d;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f240B) {
                    z = false | m416c(C0223ba.m832c(motionEvent, C0223ba.m829a(motionEvent, this.f249K)));
                    break;
                }
                break;
            case 3:
                if (this.f240B) {
                    m406a(this.f278i, true, 0, false);
                    z = m423l();
                    break;
                }
                break;
            case 5:
                int b = C0223ba.m830b(motionEvent);
                this.f245G = C0223ba.m832c(motionEvent, b);
                this.f249K = C0223ba.m831b(motionEvent, b);
                break;
            case 6:
                m409a(motionEvent);
                this.f245G = C0223ba.m832c(motionEvent, C0223ba.m829a(motionEvent, this.f249K));
                break;
        }
        if (z) {
            C0247by.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f293x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(C0239bq bqVar) {
        if (this.f277h != null) {
            this.f277h.setViewPagerObserver((DataSetObserver) null);
            this.f277h.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f274e.size(); i++) {
                C0297du duVar = (C0297du) this.f274e.get(i);
                this.f277h.destroyItem((ViewGroup) this, duVar.f370b, duVar.f369a);
            }
            this.f277h.finishUpdate((ViewGroup) this);
            this.f274e.clear();
            m421j();
            this.f278i = 0;
            scrollTo(0, 0);
        }
        C0239bq bqVar2 = this.f277h;
        this.f277h = bqVar;
        this.f273b = 0;
        if (this.f277h != null) {
            if (this.f284o == null) {
                this.f284o = new C0304ea(this, (C0292dp) null);
            }
            this.f277h.setViewPagerObserver(this.f284o);
            this.f295z = false;
            boolean z = this.f259U;
            this.f259U = true;
            this.f273b = this.f277h.getCount();
            if (this.f279j >= 0) {
                this.f277h.restoreState(this.f280k, this.f281l);
                mo1188a(this.f279j, false, true);
                this.f279j = -1;
                this.f280k = null;
                this.f281l = null;
            } else if (!z) {
                mo1199c();
            } else {
                requestLayout();
            }
        }
        if (this.f266ae != null && bqVar2 != bqVar) {
            this.f266ae.mo1533a(bqVar2, bqVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f268ag == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.f268ag = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f268ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f295z = false;
        mo1188a(i, !this.f259U, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f239A) {
            this.f239A = i;
            mo1199c();
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(C0300dx dxVar) {
        this.f266ae = dxVar;
    }

    @Deprecated
    public void setOnPageChangeListener(C0301dy dyVar) {
        this.f264ac = dyVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f285p;
        this.f285p = i;
        int width = getWidth();
        m405a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f286q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f286q;
    }
}
