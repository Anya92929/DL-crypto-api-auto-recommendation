package android.support.p001v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.p001v4.p003os.ParcelableCompat;
import android.support.p001v4.p003os.ParcelableCompatCreatorCallbacks;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p001v4.widget.EdgeEffectCompat;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

/* renamed from: android.support.v4.view.ViewPager */
public class ViewPager extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int[] f991a = {16842931};

    /* renamed from: ai */
    private static final C0340f f992ai = new C0340f();

    /* renamed from: c */
    private static final Comparator<C0336b> f993c = new Comparator<C0336b>() {
        /* renamed from: a */
        public int compare(C0336b bVar, C0336b bVar2) {
            return bVar.f1060b - bVar2.f1060b;
        }
    };

    /* renamed from: d */
    private static final Interpolator f994d = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: A */
    private boolean f995A;

    /* renamed from: B */
    private boolean f996B;

    /* renamed from: C */
    private int f997C;

    /* renamed from: D */
    private int f998D;

    /* renamed from: E */
    private int f999E;

    /* renamed from: F */
    private float f1000F;

    /* renamed from: G */
    private float f1001G;

    /* renamed from: H */
    private float f1002H;

    /* renamed from: I */
    private float f1003I;

    /* renamed from: J */
    private int f1004J = -1;

    /* renamed from: K */
    private VelocityTracker f1005K;

    /* renamed from: L */
    private int f1006L;

    /* renamed from: M */
    private int f1007M;

    /* renamed from: N */
    private int f1008N;

    /* renamed from: O */
    private int f1009O;

    /* renamed from: P */
    private boolean f1010P;

    /* renamed from: Q */
    private long f1011Q;

    /* renamed from: R */
    private EdgeEffectCompat f1012R;

    /* renamed from: S */
    private EdgeEffectCompat f1013S;

    /* renamed from: T */
    private boolean f1014T = true;

    /* renamed from: U */
    private boolean f1015U = false;

    /* renamed from: V */
    private boolean f1016V;

    /* renamed from: W */
    private int f1017W;

    /* renamed from: aa */
    private List<OnPageChangeListener> f1018aa;

    /* renamed from: ab */
    private OnPageChangeListener f1019ab;

    /* renamed from: ac */
    private OnPageChangeListener f1020ac;

    /* renamed from: ad */
    private C0338d f1021ad;

    /* renamed from: ae */
    private PageTransformer f1022ae;

    /* renamed from: af */
    private Method f1023af;

    /* renamed from: ag */
    private int f1024ag;

    /* renamed from: ah */
    private ArrayList<View> f1025ah;

    /* renamed from: aj */
    private final Runnable f1026aj = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.mo2026c();
        }
    };

    /* renamed from: ak */
    private int f1027ak = 0;

    /* renamed from: b */
    private int f1028b;

    /* renamed from: e */
    private final ArrayList<C0336b> f1029e = new ArrayList<>();

    /* renamed from: f */
    private final C0336b f1030f = new C0336b();

    /* renamed from: g */
    private final Rect f1031g = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PagerAdapter f1032h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f1033i;

    /* renamed from: j */
    private int f1034j = -1;

    /* renamed from: k */
    private Parcelable f1035k = null;

    /* renamed from: l */
    private ClassLoader f1036l = null;

    /* renamed from: m */
    private Scroller f1037m;

    /* renamed from: n */
    private C0339e f1038n;

    /* renamed from: o */
    private int f1039o;

    /* renamed from: p */
    private Drawable f1040p;

    /* renamed from: q */
    private int f1041q;

    /* renamed from: r */
    private int f1042r;

    /* renamed from: s */
    private float f1043s = -3.4028235E38f;

    /* renamed from: t */
    private float f1044t = Float.MAX_VALUE;

    /* renamed from: u */
    private int f1045u;

    /* renamed from: v */
    private int f1046v;

    /* renamed from: w */
    private boolean f1047w;

    /* renamed from: x */
    private boolean f1048x;

    /* renamed from: y */
    private boolean f1049y;

    /* renamed from: z */
    private int f1050z = 1;

    /* renamed from: android.support.v4.view.ViewPager$OnPageChangeListener */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager$PageTransformer */
    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    /* renamed from: android.support.v4.view.ViewPager$a */
    interface C0335a {
    }

    /* renamed from: android.support.v4.view.ViewPager$d */
    interface C0338d {
        /* renamed from: a */
        void mo1870a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* renamed from: android.support.v4.view.ViewPager$b */
    static class C0336b {

        /* renamed from: a */
        Object f1059a;

        /* renamed from: b */
        int f1060b;

        /* renamed from: c */
        boolean f1061c;

        /* renamed from: d */
        float f1062d;

        /* renamed from: e */
        float f1063e;

        C0336b() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$SimpleOnPageChangeListener */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        public void onPageScrollStateChanged(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        mo2012a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo2012a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2012a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1037m = new Scroller(context, f994d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f999E = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f1006L = (int) (400.0f * f);
        this.f1007M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1012R = new EdgeEffectCompat(context);
        this.f1013S = new EdgeEffectCompat(context);
        this.f1008N = (int) (25.0f * f);
        this.f1009O = (int) (2.0f * f);
        this.f997C = (int) (16.0f * f);
        ViewCompat.setAccessibilityDelegate(this, new C0337c());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1026aj);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f1027ak != i) {
            this.f1027ak = i;
            if (this.f1022ae != null) {
                m1576b(i != 0);
            }
            m1581e(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f1032h != null) {
            this.f1032h.unregisterDataSetObserver(this.f1038n);
            this.f1032h.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f1029e.size(); i++) {
                C0336b bVar = this.f1029e.get(i);
                this.f1032h.destroyItem((ViewGroup) this, bVar.f1060b, bVar.f1059a);
            }
            this.f1032h.finishUpdate((ViewGroup) this);
            this.f1029e.clear();
            m1583g();
            this.f1033i = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f1032h;
        this.f1032h = pagerAdapter;
        this.f1028b = 0;
        if (this.f1032h != null) {
            if (this.f1038n == null) {
                this.f1038n = new C0339e();
            }
            this.f1032h.registerDataSetObserver(this.f1038n);
            this.f1049y = false;
            boolean z = this.f1014T;
            this.f1014T = true;
            this.f1028b = this.f1032h.getCount();
            if (this.f1034j >= 0) {
                this.f1032h.restoreState(this.f1035k, this.f1036l);
                mo2015a(this.f1034j, false, true);
                this.f1034j = -1;
                this.f1035k = null;
                this.f1036l = null;
            } else if (!z) {
                mo2026c();
            } else {
                requestLayout();
            }
        }
        if (this.f1021ad != null && pagerAdapter2 != pagerAdapter) {
            this.f1021ad.mo1870a(pagerAdapter2, pagerAdapter);
        }
    }

    /* renamed from: g */
    private void m1583g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public PagerAdapter getAdapter() {
        return this.f1032h;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(C0338d dVar) {
        this.f1021ad = dVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f1049y = false;
        if (!this.f1014T) {
            z = true;
        } else {
            z = false;
        }
        mo2015a(i, z, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f1049y = false;
        mo2015a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f1033i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2015a(int i, boolean z, boolean z2) {
        mo2016a(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2016a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f1032h == null || this.f1032h.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f1033i != i || this.f1029e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f1032h.getCount()) {
                i = this.f1032h.getCount() - 1;
            }
            int i3 = this.f1050z;
            if (i > this.f1033i + i3 || i < this.f1033i - i3) {
                for (int i4 = 0; i4 < this.f1029e.size(); i4++) {
                    this.f1029e.get(i4).f1061c = true;
                }
            }
            if (this.f1033i != i) {
                z3 = true;
            }
            if (this.f1014T) {
                this.f1033i = i;
                if (z3) {
                    m1580d(i);
                }
                requestLayout();
                return;
            }
            mo2013a(i);
            m1569a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* renamed from: a */
    private void m1569a(int i, boolean z, int i2, boolean z2) {
        int i3;
        C0336b b = mo2022b(i);
        if (b != null) {
            i3 = (int) (Math.max(this.f1043s, Math.min(b.f1063e, this.f1044t)) * ((float) getClientWidth()));
        } else {
            i3 = 0;
        }
        if (z) {
            mo2014a(i3, 0, i2);
            if (z2) {
                m1580d(i);
                return;
            }
            return;
        }
        if (z2) {
            m1580d(i);
        }
        m1573a(false);
        scrollTo(i3, 0);
        m1579c(i3);
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f1019ab = onPageChangeListener;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f1018aa == null) {
            this.f1018aa = new ArrayList();
        }
        this.f1018aa.add(onPageChangeListener);
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f1018aa != null) {
            this.f1018aa.remove(onPageChangeListener);
        }
    }

    public void clearOnPageChangeListeners() {
        if (this.f1018aa != null) {
            this.f1018aa.clear();
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        boolean z2;
        int i = 1;
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z3 = pageTransformer != null;
            if (this.f1022ae != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z3 != z2;
            this.f1022ae = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z) {
                    i = 2;
                }
                this.f1024ag = i;
            } else {
                this.f1024ag = 0;
            }
            if (z4) {
                mo2026c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f1023af == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.f1023af = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f1023af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f1024ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f1025ah.get(i2).getLayoutParams()).f1055d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public OnPageChangeListener mo2009a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f1020ac;
        this.f1020ac = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.f1050z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f1050z) {
            this.f1050z = i;
            mo2026c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f1039o;
        this.f1039o = i;
        int width = getWidth();
        m1568a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f1039o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1040p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1040p;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1040p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo2008a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2014a(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m1573a(false);
            mo2026c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * mo2008a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(a / ((float) abs2))) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f1032h.getPageWidth(this.f1033i)) + ((float) this.f1039o))) + 1.0f) * 100.0f);
        }
        this.f1037m.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0336b mo2010a(int i, int i2) {
        C0336b bVar = new C0336b();
        bVar.f1060b = i;
        bVar.f1059a = this.f1032h.instantiateItem((ViewGroup) this, i);
        bVar.f1062d = this.f1032h.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f1029e.size()) {
            this.f1029e.add(bVar);
        } else {
            this.f1029e.add(i2, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2024b() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int count = this.f1032h.getCount();
        this.f1028b = count;
        boolean z3 = this.f1029e.size() < (this.f1050z * 2) + 1 && this.f1029e.size() < count;
        boolean z4 = false;
        int i3 = this.f1033i;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.f1029e.size()) {
            C0336b bVar = this.f1029e.get(i4);
            int itemPosition = this.f1032h.getItemPosition(bVar.f1059a);
            if (itemPosition == -1) {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.f1029e.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.f1032h.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.f1032h.destroyItem((ViewGroup) this, bVar.f1060b, bVar.f1059a);
                if (this.f1033i == bVar.f1060b) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.f1033i, count - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i3;
                    z2 = true;
                }
            } else if (bVar.f1060b != itemPosition) {
                if (bVar.f1060b == this.f1033i) {
                    i3 = itemPosition;
                }
                bVar.f1060b = itemPosition;
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
            this.f1032h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f1029e, f993c);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f1052a = BitmapDescriptorFactory.HUE_RED;
                }
            }
            mo2015a(i3, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2026c() {
        mo2013a(this.f1033i);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ff, code lost:
        if (r2.f1060b == r18.f1033i) goto L_0x0101;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2013a(int r19) {
        /*
            r18 = this;
            r3 = 0
            r2 = 2
            r0 = r18
            int r4 = r0.f1033i
            r0 = r19
            if (r4 == r0) goto L_0x033f
            r0 = r18
            int r2 = r0.f1033i
            r0 = r19
            if (r2 >= r0) goto L_0x0030
            r2 = 66
        L_0x0014:
            r0 = r18
            int r3 = r0.f1033i
            r0 = r18
            android.support.v4.view.ViewPager$b r3 = r0.mo2022b((int) r3)
            r0 = r19
            r1 = r18
            r1.f1033i = r0
            r4 = r3
            r3 = r2
        L_0x0026:
            r0 = r18
            android.support.v4.view.PagerAdapter r2 = r0.f1032h
            if (r2 != 0) goto L_0x0033
            r18.m1584h()
        L_0x002f:
            return
        L_0x0030:
            r2 = 17
            goto L_0x0014
        L_0x0033:
            r0 = r18
            boolean r2 = r0.f1049y
            if (r2 == 0) goto L_0x003d
            r18.m1584h()
            goto L_0x002f
        L_0x003d:
            android.os.IBinder r2 = r18.getWindowToken()
            if (r2 == 0) goto L_0x002f
            r0 = r18
            android.support.v4.view.PagerAdapter r2 = r0.f1032h
            r0 = r18
            r2.startUpdate((android.view.ViewGroup) r0)
            r0 = r18
            int r2 = r0.f1050z
            r5 = 0
            r0 = r18
            int r6 = r0.f1033i
            int r6 = r6 - r2
            int r11 = java.lang.Math.max(r5, r6)
            r0 = r18
            android.support.v4.view.PagerAdapter r5 = r0.f1032h
            int r12 = r5.getCount()
            int r5 = r12 + -1
            r0 = r18
            int r6 = r0.f1033i
            int r2 = r2 + r6
            int r13 = java.lang.Math.min(r5, r2)
            r0 = r18
            int r2 = r0.f1028b
            if (r12 == r2) goto L_0x00da
            android.content.res.Resources r2 = r18.getResources()     // Catch:{ NotFoundException -> 0x00d0 }
            int r3 = r18.getId()     // Catch:{ NotFoundException -> 0x00d0 }
            java.lang.String r2 = r2.getResourceName(r3)     // Catch:{ NotFoundException -> 0x00d0 }
        L_0x007f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            java.lang.StringBuilder r4 = r4.append(r5)
            r0 = r18
            int r5 = r0.f1028b
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = ", found: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r5 = " Pager id: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = " Pager class: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.Class r4 = r18.getClass()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = " Problematic adapter: "
            java.lang.StringBuilder r2 = r2.append(r4)
            r0 = r18
            android.support.v4.view.PagerAdapter r4 = r0.f1032h
            java.lang.Class r4 = r4.getClass()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        L_0x00d0:
            r2 = move-exception
            int r2 = r18.getId()
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            goto L_0x007f
        L_0x00da:
            r6 = 0
            r2 = 0
            r5 = r2
        L_0x00dd:
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            int r2 = r2.size()
            if (r5 >= r2) goto L_0x033c
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
            int r7 = r2.f1060b
            r0 = r18
            int r8 = r0.f1033i
            if (r7 < r8) goto L_0x01cf
            int r7 = r2.f1060b
            r0 = r18
            int r8 = r0.f1033i
            if (r7 != r8) goto L_0x033c
        L_0x0101:
            if (r2 != 0) goto L_0x0339
            if (r12 <= 0) goto L_0x0339
            r0 = r18
            int r2 = r0.f1033i
            r0 = r18
            android.support.v4.view.ViewPager$b r2 = r0.mo2010a((int) r2, (int) r5)
            r10 = r2
        L_0x0110:
            if (r10 == 0) goto L_0x0180
            r9 = 0
            int r8 = r5 + -1
            if (r8 < 0) goto L_0x01d4
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r8)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
        L_0x0121:
            int r14 = r18.getClientWidth()
            if (r14 > 0) goto L_0x01d7
            r6 = 0
        L_0x0128:
            r0 = r18
            int r7 = r0.f1033i
            int r7 = r7 + -1
            r16 = r7
            r7 = r9
            r9 = r16
            r17 = r8
            r8 = r5
            r5 = r17
        L_0x0138:
            if (r9 < 0) goto L_0x0142
            int r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r15 < 0) goto L_0x0216
            if (r9 >= r11) goto L_0x0216
            if (r2 != 0) goto L_0x01e6
        L_0x0142:
            float r6 = r10.f1062d
            int r9 = r8 + 1
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x017b
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            int r2 = r2.size()
            if (r9 >= r2) goto L_0x024c
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r9)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
            r7 = r2
        L_0x0161:
            if (r14 > 0) goto L_0x024f
            r2 = 0
            r5 = r2
        L_0x0165:
            r0 = r18
            int r2 = r0.f1033i
            int r2 = r2 + 1
            r16 = r2
            r2 = r7
            r7 = r9
            r9 = r16
        L_0x0171:
            if (r9 >= r12) goto L_0x017b
            int r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x029a
            if (r9 <= r13) goto L_0x029a
            if (r2 != 0) goto L_0x025c
        L_0x017b:
            r0 = r18
            r0.m1570a((android.support.p001v4.view.ViewPager.C0336b) r10, (int) r8, (android.support.p001v4.view.ViewPager.C0336b) r4)
        L_0x0180:
            r0 = r18
            android.support.v4.view.PagerAdapter r4 = r0.f1032h
            r0 = r18
            int r5 = r0.f1033i
            if (r10 == 0) goto L_0x02e8
            java.lang.Object r2 = r10.f1059a
        L_0x018c:
            r0 = r18
            r4.setPrimaryItem((android.view.ViewGroup) r0, (int) r5, (java.lang.Object) r2)
            r0 = r18
            android.support.v4.view.PagerAdapter r2 = r0.f1032h
            r0 = r18
            r2.finishUpdate((android.view.ViewGroup) r0)
            int r5 = r18.getChildCount()
            r2 = 0
            r4 = r2
        L_0x01a0:
            if (r4 >= r5) goto L_0x02eb
            r0 = r18
            android.view.View r6 = r0.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.support.v4.view.ViewPager$LayoutParams r2 = (android.support.p001v4.view.ViewPager.LayoutParams) r2
            r2.f1055d = r4
            boolean r7 = r2.isDecor
            if (r7 != 0) goto L_0x01cb
            float r7 = r2.f1052a
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x01cb
            r0 = r18
            android.support.v4.view.ViewPager$b r6 = r0.mo2011a((android.view.View) r6)
            if (r6 == 0) goto L_0x01cb
            float r7 = r6.f1062d
            r2.f1052a = r7
            int r6 = r6.f1060b
            r2.f1054c = r6
        L_0x01cb:
            int r2 = r4 + 1
            r4 = r2
            goto L_0x01a0
        L_0x01cf:
            int r2 = r5 + 1
            r5 = r2
            goto L_0x00dd
        L_0x01d4:
            r2 = 0
            goto L_0x0121
        L_0x01d7:
            r6 = 1073741824(0x40000000, float:2.0)
            float r7 = r10.f1062d
            float r6 = r6 - r7
            int r7 = r18.getPaddingLeft()
            float r7 = (float) r7
            float r15 = (float) r14
            float r7 = r7 / r15
            float r6 = r6 + r7
            goto L_0x0128
        L_0x01e6:
            int r15 = r2.f1060b
            if (r9 != r15) goto L_0x0210
            boolean r15 = r2.f1061c
            if (r15 != 0) goto L_0x0210
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r15 = r0.f1029e
            r15.remove(r5)
            r0 = r18
            android.support.v4.view.PagerAdapter r15 = r0.f1032h
            java.lang.Object r2 = r2.f1059a
            r0 = r18
            r15.destroyItem((android.view.ViewGroup) r0, (int) r9, (java.lang.Object) r2)
            int r5 = r5 + -1
            int r8 = r8 + -1
            if (r5 < 0) goto L_0x0214
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
        L_0x0210:
            int r9 = r9 + -1
            goto L_0x0138
        L_0x0214:
            r2 = 0
            goto L_0x0210
        L_0x0216:
            if (r2 == 0) goto L_0x0230
            int r15 = r2.f1060b
            if (r9 != r15) goto L_0x0230
            float r2 = r2.f1062d
            float r7 = r7 + r2
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x022e
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
            goto L_0x0210
        L_0x022e:
            r2 = 0
            goto L_0x0210
        L_0x0230:
            int r2 = r5 + 1
            r0 = r18
            android.support.v4.view.ViewPager$b r2 = r0.mo2010a((int) r9, (int) r2)
            float r2 = r2.f1062d
            float r7 = r7 + r2
            int r8 = r8 + 1
            if (r5 < 0) goto L_0x024a
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
            goto L_0x0210
        L_0x024a:
            r2 = 0
            goto L_0x0210
        L_0x024c:
            r7 = 0
            goto L_0x0161
        L_0x024f:
            int r2 = r18.getPaddingRight()
            float r2 = (float) r2
            float r5 = (float) r14
            float r2 = r2 / r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 + r5
            r5 = r2
            goto L_0x0165
        L_0x025c:
            int r11 = r2.f1060b
            if (r9 != r11) goto L_0x0332
            boolean r11 = r2.f1061c
            if (r11 != 0) goto L_0x0332
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r11 = r0.f1029e
            r11.remove(r7)
            r0 = r18
            android.support.v4.view.PagerAdapter r11 = r0.f1032h
            java.lang.Object r2 = r2.f1059a
            r0 = r18
            r11.destroyItem((android.view.ViewGroup) r0, (int) r9, (java.lang.Object) r2)
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x0298
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
        L_0x028a:
            r16 = r6
            r6 = r2
            r2 = r16
        L_0x028f:
            int r9 = r9 + 1
            r16 = r2
            r2 = r6
            r6 = r16
            goto L_0x0171
        L_0x0298:
            r2 = 0
            goto L_0x028a
        L_0x029a:
            if (r2 == 0) goto L_0x02c1
            int r11 = r2.f1060b
            if (r9 != r11) goto L_0x02c1
            float r2 = r2.f1062d
            float r6 = r6 + r2
            int r7 = r7 + 1
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x02bf
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
        L_0x02b9:
            r16 = r6
            r6 = r2
            r2 = r16
            goto L_0x028f
        L_0x02bf:
            r2 = 0
            goto L_0x02b9
        L_0x02c1:
            r0 = r18
            android.support.v4.view.ViewPager$b r2 = r0.mo2010a((int) r9, (int) r7)
            int r7 = r7 + 1
            float r2 = r2.f1062d
            float r6 = r6 + r2
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x02e6
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$b> r2 = r0.f1029e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.ViewPager$b r2 = (android.support.p001v4.view.ViewPager.C0336b) r2
        L_0x02e0:
            r16 = r6
            r6 = r2
            r2 = r16
            goto L_0x028f
        L_0x02e6:
            r2 = 0
            goto L_0x02e0
        L_0x02e8:
            r2 = 0
            goto L_0x018c
        L_0x02eb:
            r18.m1584h()
            boolean r2 = r18.hasFocus()
            if (r2 == 0) goto L_0x002f
            android.view.View r2 = r18.findFocus()
            if (r2 == 0) goto L_0x0330
            r0 = r18
            android.support.v4.view.ViewPager$b r2 = r0.mo2023b((android.view.View) r2)
        L_0x0300:
            if (r2 == 0) goto L_0x030a
            int r2 = r2.f1060b
            r0 = r18
            int r4 = r0.f1033i
            if (r2 == r4) goto L_0x002f
        L_0x030a:
            r2 = 0
        L_0x030b:
            int r4 = r18.getChildCount()
            if (r2 >= r4) goto L_0x002f
            r0 = r18
            android.view.View r4 = r0.getChildAt(r2)
            r0 = r18
            android.support.v4.view.ViewPager$b r5 = r0.mo2011a((android.view.View) r4)
            if (r5 == 0) goto L_0x032d
            int r5 = r5.f1060b
            r0 = r18
            int r6 = r0.f1033i
            if (r5 != r6) goto L_0x032d
            boolean r4 = r4.requestFocus(r3)
            if (r4 != 0) goto L_0x002f
        L_0x032d:
            int r2 = r2 + 1
            goto L_0x030b
        L_0x0330:
            r2 = 0
            goto L_0x0300
        L_0x0332:
            r16 = r6
            r6 = r2
            r2 = r16
            goto L_0x028f
        L_0x0339:
            r10 = r2
            goto L_0x0110
        L_0x033c:
            r2 = r6
            goto L_0x0101
        L_0x033f:
            r4 = r3
            r3 = r2
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.view.ViewPager.mo2013a(int):void");
    }

    /* renamed from: h */
    private void m1584h() {
        if (this.f1024ag != 0) {
            if (this.f1025ah == null) {
                this.f1025ah = new ArrayList<>();
            } else {
                this.f1025ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f1025ah.add(getChildAt(i));
            }
            Collections.sort(this.f1025ah, f992ai);
        }
    }

    /* renamed from: a */
    private void m1570a(C0336b bVar, int i, C0336b bVar2) {
        float f;
        C0336b bVar3;
        C0336b bVar4;
        int count = this.f1032h.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f1039o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            int i2 = bVar2.f1060b;
            if (i2 < bVar.f1060b) {
                float f2 = bVar2.f1063e + bVar2.f1062d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.f1060b && i4 < this.f1029e.size()) {
                    Object obj = this.f1029e.get(i4);
                    while (true) {
                        bVar4 = (C0336b) obj;
                        if (i3 > bVar4.f1060b && i4 < this.f1029e.size() - 1) {
                            i4++;
                            obj = this.f1029e.get(i4);
                        }
                    }
                    while (i3 < bVar4.f1060b) {
                        f2 += this.f1032h.getPageWidth(i3) + f;
                        i3++;
                    }
                    bVar4.f1063e = f2;
                    f2 += bVar4.f1062d + f;
                    i3++;
                }
            } else if (i2 > bVar.f1060b) {
                int size = this.f1029e.size() - 1;
                float f3 = bVar2.f1063e;
                int i5 = i2 - 1;
                while (i5 >= bVar.f1060b && size >= 0) {
                    Object obj2 = this.f1029e.get(size);
                    while (true) {
                        bVar3 = (C0336b) obj2;
                        if (i5 < bVar3.f1060b && size > 0) {
                            size--;
                            obj2 = this.f1029e.get(size);
                        }
                    }
                    while (i5 > bVar3.f1060b) {
                        f3 -= this.f1032h.getPageWidth(i5) + f;
                        i5--;
                    }
                    f3 -= bVar3.f1062d + f;
                    bVar3.f1063e = f3;
                    i5--;
                }
            }
        }
        int size2 = this.f1029e.size();
        float f4 = bVar.f1063e;
        int i6 = bVar.f1060b - 1;
        this.f1043s = bVar.f1060b == 0 ? bVar.f1063e : -3.4028235E38f;
        this.f1044t = bVar.f1060b == count + -1 ? (bVar.f1063e + bVar.f1062d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            C0336b bVar5 = this.f1029e.get(i7);
            float f5 = f4;
            while (i6 > bVar5.f1060b) {
                f5 -= this.f1032h.getPageWidth(i6) + f;
                i6--;
            }
            f4 = f5 - (bVar5.f1062d + f);
            bVar5.f1063e = f4;
            if (bVar5.f1060b == 0) {
                this.f1043s = f4;
            }
            i6--;
        }
        float f6 = bVar.f1063e + bVar.f1062d + f;
        int i8 = bVar.f1060b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            C0336b bVar6 = this.f1029e.get(i9);
            float f7 = f6;
            while (i8 < bVar6.f1060b) {
                f7 = this.f1032h.getPageWidth(i8) + f + f7;
                i8++;
            }
            if (bVar6.f1060b == count - 1) {
                this.f1044t = (bVar6.f1062d + f7) - 1.0f;
            }
            bVar6.f1063e = f7;
            f6 = f7 + bVar6.f1062d + f;
            i8++;
        }
        this.f1015U = false;
    }

    /* renamed from: android.support.v4.view.ViewPager$SavedState */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a */
        int f1056a;

        /* renamed from: b */
        Parcelable f1057b;

        /* renamed from: c */
        ClassLoader f1058c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1056a);
            parcel.writeParcelable(this.f1057b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1056a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f1056a = parcel.readInt();
            this.f1057b = parcel.readParcelable(classLoader);
            this.f1058c = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1056a = this.f1033i;
        if (this.f1032h != null) {
            savedState.f1057b = this.f1032h.saveState();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f1032h != null) {
            this.f1032h.restoreState(savedState.f1057b, savedState.f1058c);
            mo2015a(savedState.f1056a, false, true);
            return;
        }
        this.f1034j = savedState.f1056a;
        this.f1035k = savedState.f1057b;
        this.f1036l = savedState.f1058c;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2;
        if (!checkLayoutParams(layoutParams)) {
            layoutParams2 = generateLayoutParams(layoutParams);
        } else {
            layoutParams2 = layoutParams;
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.isDecor |= view instanceof C0335a;
        if (!this.f1047w) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.isDecor) {
            layoutParams3.f1053b = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f1047w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0336b mo2011a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1029e.size()) {
                return null;
            }
            C0336b bVar = this.f1029e.get(i2);
            if (this.f1032h.isViewFromObject(view, bVar.f1059a)) {
                return bVar;
            }
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0336b mo2023b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo2011a(view);
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
    public C0336b mo2022b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f1029e.size()) {
                return null;
            }
            C0336b bVar = this.f1029e.get(i3);
            if (bVar.f1060b == i) {
                return bVar;
            }
            i2 = i3 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1014T = true;
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
            int r2 = r13.f997C
            int r1 = java.lang.Math.min(r1, r2)
            r13.f998D = r1
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
            android.support.v4.view.ViewPager$LayoutParams r0 = (android.support.p001v4.view.ViewPager.LayoutParams) r0
            if (r0 == 0) goto L_0x00a5
            boolean r1 = r0.isDecor
            if (r1 == 0) goto L_0x00a5
            int r1 = r0.gravity
            r6 = r1 & 7
            int r1 = r0.gravity
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
            r13.f1045u = r0
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            r13.f1046v = r0
            r0 = 1
            r13.f1047w = r0
            r13.mo2026c()
            r0 = 0
            r13.f1047w = r0
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
            android.support.v4.view.ViewPager$LayoutParams r0 = (android.support.p001v4.view.ViewPager.LayoutParams) r0
            if (r0 == 0) goto L_0x00f5
            boolean r5 = r0.isDecor
            if (r5 != 0) goto L_0x0105
        L_0x00f5:
            float r5 = (float) r3
            float r0 = r0.f1052a
            float r0 = r0 * r5
            int r0 = (int) r0
            r5 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            int r5 = r13.f1046v
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.view.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1568a(i, i3, this.f1039o, this.f1039o);
        }
    }

    /* renamed from: a */
    private void m1568a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f1029e.isEmpty()) {
            C0336b b = mo2022b(this.f1033i);
            int min = (int) ((b != null ? Math.min(b.f1063e, this.f1044t) : BitmapDescriptorFactory.HUE_RED) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1573a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f1037m.isFinished()) {
            this.f1037m.startScroll(paddingLeft, 0, (int) (mo2022b(this.f1033i).f1063e * ((float) i)), 0, this.f1037m.getDuration() - this.f1037m.timePassed());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0336b a;
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
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i14 = layoutParams.gravity & 7;
                    int i15 = layoutParams.gravity & 112;
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
                        case 48:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case 80:
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
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (a = mo2011a(childAt2)) != null) {
                    int i22 = ((int) (a.f1063e * ((float) i20))) + paddingLeft;
                    if (layoutParams2.f1053b) {
                        layoutParams2.f1053b = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (layoutParams2.f1052a * ((float) i20)), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f1041q = paddingTop;
        this.f1042r = i11 - paddingBottom;
        this.f1017W = i12;
        if (this.f1014T) {
            m1569a(this.f1033i, false, 0, false);
        }
        this.f1014T = false;
    }

    public void computeScroll() {
        if (this.f1037m.isFinished() || !this.f1037m.computeScrollOffset()) {
            m1573a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1037m.getCurrX();
        int currY = this.f1037m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1579c(currX)) {
                this.f1037m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* renamed from: c */
    private boolean m1579c(int i) {
        if (this.f1029e.size() == 0) {
            this.f1016V = false;
            onPageScrolled(0, BitmapDescriptorFactory.HUE_RED, 0);
            if (this.f1016V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0336b j = m1586j();
        int clientWidth = getClientWidth();
        int i2 = this.f1039o + clientWidth;
        float f = ((float) this.f1039o) / ((float) clientWidth);
        int i3 = j.f1060b;
        float f2 = ((((float) i) / ((float) clientWidth)) - j.f1063e) / (j.f1062d + f);
        this.f1016V = false;
        onPageScrolled(i3, f2, (int) (((float) i2) * f2));
        if (this.f1016V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onPageScrolled(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.f1017W > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!layoutParams.isDecor) {
                    int i6 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i6;
                } else {
                    switch (layoutParams.gravity & 7) {
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
        m1567a(i, f, i2);
        if (this.f1022ae != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.f1022ae.transformPage(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.f1016V = true;
    }

    /* renamed from: a */
    private void m1567a(int i, float f, int i2) {
        if (this.f1019ab != null) {
            this.f1019ab.onPageScrolled(i, f, i2);
        }
        if (this.f1018aa != null) {
            int size = this.f1018aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = this.f1018aa.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.f1020ac != null) {
            this.f1020ac.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: d */
    private void m1580d(int i) {
        if (this.f1019ab != null) {
            this.f1019ab.onPageSelected(i);
        }
        if (this.f1018aa != null) {
            int size = this.f1018aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = this.f1018aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        if (this.f1020ac != null) {
            this.f1020ac.onPageSelected(i);
        }
    }

    /* renamed from: e */
    private void m1581e(int i) {
        if (this.f1019ab != null) {
            this.f1019ab.onPageScrollStateChanged(i);
        }
        if (this.f1018aa != null) {
            int size = this.f1018aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = this.f1018aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.f1020ac != null) {
            this.f1020ac.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: a */
    private void m1573a(boolean z) {
        boolean z2 = this.f1027ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f1037m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1037m.getCurrX();
            int currY = this.f1037m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    m1579c(currX);
                }
            }
        }
        this.f1049y = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f1029e.size(); i++) {
            C0336b bVar = this.f1029e.get(i);
            if (bVar.f1061c) {
                bVar.f1061c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.f1026aj);
        } else {
            this.f1026aj.run();
        }
    }

    /* renamed from: a */
    private boolean m1574a(float f, float f2) {
        return (f < ((float) this.f998D) && f2 > BitmapDescriptorFactory.HUE_RED) || (f > ((float) (getWidth() - this.f998D)) && f2 < BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: b */
    private void m1576b(boolean z) {
        int i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (z) {
                i = 2;
            } else {
                i = 0;
            }
            ViewCompat.setLayerType(getChildAt(i2), i, (Paint) null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m1585i();
            return false;
        }
        if (action != 0) {
            if (this.f995A) {
                return true;
            }
            if (this.f996B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f1002H = x;
                this.f1000F = x;
                float y = motionEvent.getY();
                this.f1003I = y;
                this.f1001G = y;
                this.f1004J = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f996B = false;
                this.f1037m.computeScrollOffset();
                if (this.f1027ak == 2 && Math.abs(this.f1037m.getFinalX() - this.f1037m.getCurrX()) > this.f1009O) {
                    this.f1037m.abortAnimation();
                    this.f1049y = false;
                    mo2026c();
                    this.f995A = true;
                    m1578c(true);
                    setScrollState(1);
                    break;
                } else {
                    m1573a(false);
                    this.f995A = false;
                    break;
                }
            case 2:
                int i = this.f1004J;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float f = x2 - this.f1000F;
                    float abs = Math.abs(f);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f1003I);
                    if (f != BitmapDescriptorFactory.HUE_RED && !m1574a(this.f1000F, f)) {
                        if (canScroll(this, false, (int) f, (int) x2, (int) y2)) {
                            this.f1000F = x2;
                            this.f1001G = y2;
                            this.f996B = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.f999E) && 0.5f * abs > abs2) {
                        this.f995A = true;
                        m1578c(true);
                        setScrollState(1);
                        this.f1000F = f > BitmapDescriptorFactory.HUE_RED ? this.f1002H + ((float) this.f999E) : this.f1002H - ((float) this.f999E);
                        this.f1001G = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.f999E)) {
                        this.f996B = true;
                    }
                    if (this.f995A && m1577b(x2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                m1572a(motionEvent);
                break;
        }
        if (this.f1005K == null) {
            this.f1005K = VelocityTracker.obtain();
        }
        this.f1005K.addMovement(motionEvent);
        return this.f995A;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        boolean z = false;
        if (this.f1010P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f1032h == null || this.f1032h.getCount() == 0) {
            return false;
        }
        if (this.f1005K == null) {
            this.f1005K = VelocityTracker.obtain();
        }
        this.f1005K.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f1037m.abortAnimation();
                this.f1049y = false;
                mo2026c();
                float x = motionEvent.getX();
                this.f1002H = x;
                this.f1000F = x;
                float y = motionEvent.getY();
                this.f1003I = y;
                this.f1001G = y;
                this.f1004J = MotionEventCompat.getPointerId(motionEvent, 0);
                break;
            case 1:
                if (this.f995A) {
                    VelocityTracker velocityTracker = this.f1005K;
                    velocityTracker.computeCurrentVelocity(LogTable.MAX_SIZE, (float) this.f1007M);
                    int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f1004J);
                    this.f1049y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0336b j = m1586j();
                    mo2016a(m1564a(j.f1060b, ((((float) scrollX) / ((float) clientWidth)) - j.f1063e) / j.f1062d, xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1004J)) - this.f1002H)), true, true, xVelocity);
                    z = m1585i();
                    break;
                }
                break;
            case 2:
                if (!this.f995A) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1004J);
                    if (findPointerIndex == -1) {
                        z = m1585i();
                        break;
                    } else {
                        float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs = Math.abs(x2 - this.f1000F);
                        float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f1001G);
                        if (abs > ((float) this.f999E) && abs > abs2) {
                            this.f995A = true;
                            m1578c(true);
                            if (x2 - this.f1002H > BitmapDescriptorFactory.HUE_RED) {
                                f = this.f1002H + ((float) this.f999E);
                            } else {
                                f = this.f1002H - ((float) this.f999E);
                            }
                            this.f1000F = f;
                            this.f1001G = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f995A) {
                    z = false | m1577b(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1004J)));
                    break;
                }
                break;
            case 3:
                if (this.f995A) {
                    m1569a(this.f1033i, true, 0, false);
                    z = m1585i();
                    break;
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f1000F = MotionEventCompat.getX(motionEvent, actionIndex);
                this.f1004J = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                m1572a(motionEvent);
                this.f1000F = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1004J));
                break;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* renamed from: i */
    private boolean m1585i() {
        this.f1004J = -1;
        m1587k();
        return this.f1012R.onRelease() | this.f1013S.onRelease();
    }

    /* renamed from: c */
    private void m1578c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: b */
    private boolean m1577b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        this.f1000F = f;
        float scrollX = ((float) getScrollX()) + (this.f1000F - f);
        int clientWidth = getClientWidth();
        float f3 = ((float) clientWidth) * this.f1043s;
        float f4 = ((float) clientWidth) * this.f1044t;
        C0336b bVar = this.f1029e.get(0);
        C0336b bVar2 = this.f1029e.get(this.f1029e.size() - 1);
        if (bVar.f1060b != 0) {
            f3 = bVar.f1063e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f1060b != this.f1032h.getCount() - 1) {
            f2 = bVar2.f1063e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f4;
        }
        if (scrollX < f3) {
            if (z) {
                z3 = this.f1012R.onPull(Math.abs(f3 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f1013S.onPull(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f3 = f2;
        } else {
            f3 = scrollX;
        }
        this.f1000F += f3 - ((float) ((int) f3));
        scrollTo((int) f3, getScrollY());
        m1579c((int) f3);
        return z3;
    }

    /* renamed from: j */
    private C0336b m1586j() {
        float f;
        int i;
        C0336b bVar;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f1039o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        C0336b bVar2 = null;
        while (i3 < this.f1029e.size()) {
            C0336b bVar3 = this.f1029e.get(i3);
            if (z || bVar3.f1060b == i2 + 1) {
                C0336b bVar4 = bVar3;
                i = i3;
                bVar = bVar4;
            } else {
                C0336b bVar5 = this.f1030f;
                bVar5.f1063e = f2 + f3 + f;
                bVar5.f1060b = i2 + 1;
                bVar5.f1062d = this.f1032h.getPageWidth(bVar5.f1060b);
                C0336b bVar6 = bVar5;
                i = i3 - 1;
                bVar = bVar6;
            }
            float f4 = bVar.f1063e;
            float f5 = bVar.f1062d + f4 + f;
            if (!z && scrollX < f4) {
                return bVar2;
            }
            if (scrollX < f5 || i == this.f1029e.size() - 1) {
                return bVar;
            }
            f3 = f4;
            i2 = bVar.f1060b;
            z = false;
            f2 = bVar.f1062d;
            bVar2 = bVar;
            i3 = i + 1;
        }
        return bVar2;
    }

    /* renamed from: a */
    private int m1564a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f1008N || Math.abs(i2) <= this.f1006L) {
            i = (int) ((i >= this.f1033i ? 0.4f : 0.6f) + ((float) i) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f1029e.size() > 0) {
            return Math.max(this.f1029e.get(0).f1060b, Math.min(i, this.f1029e.get(this.f1029e.size() - 1).f1060b));
        }
        return i;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f1032h != null && this.f1032h.getCount() > 1)) {
            if (!this.f1012R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f1043s * ((float) width));
                this.f1012R.setSize(height, width);
                z = false | this.f1012R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f1013S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f1044t + 1.0f)) * ((float) width2));
                this.f1013S.setSize(height2, width2);
                z |= this.f1013S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f1012R.finish();
            this.f1013S.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f1039o > 0 && this.f1040p != null && this.f1029e.size() > 0 && this.f1032h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = ((float) this.f1039o) / ((float) width);
            C0336b bVar = this.f1029e.get(0);
            float f3 = bVar.f1063e;
            int size = this.f1029e.size();
            int i = bVar.f1060b;
            int i2 = this.f1029e.get(size - 1).f1060b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                while (i4 > bVar.f1060b && i3 < size) {
                    i3++;
                    bVar = this.f1029e.get(i3);
                }
                if (i4 == bVar.f1060b) {
                    f = (bVar.f1063e + bVar.f1062d) * ((float) width);
                    f3 = bVar.f1063e + bVar.f1062d + f2;
                } else {
                    float pageWidth = this.f1032h.getPageWidth(i4);
                    f = (f3 + pageWidth) * ((float) width);
                    f3 += pageWidth + f2;
                }
                if (((float) this.f1039o) + f > ((float) scrollX)) {
                    this.f1040p.setBounds((int) f, this.f1041q, (int) (((float) this.f1039o) + f + 0.5f), this.f1042r);
                    this.f1040p.draw(canvas);
                }
                if (f <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.f995A) {
            return false;
        }
        this.f1010P = true;
        setScrollState(1);
        this.f1000F = BitmapDescriptorFactory.HUE_RED;
        this.f1002H = BitmapDescriptorFactory.HUE_RED;
        if (this.f1005K == null) {
            this.f1005K = VelocityTracker.obtain();
        } else {
            this.f1005K.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1005K.addMovement(obtain);
        obtain.recycle();
        this.f1011Q = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (!this.f1010P) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.f1005K;
        velocityTracker.computeCurrentVelocity(LogTable.MAX_SIZE, (float) this.f1007M);
        int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f1004J);
        this.f1049y = true;
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        C0336b j = m1586j();
        mo2016a(m1564a(j.f1060b, ((((float) scrollX) / ((float) clientWidth)) - j.f1063e) / j.f1062d, xVelocity, (int) (this.f1000F - this.f1002H)), true, true, xVelocity);
        m1587k();
        this.f1010P = false;
    }

    public void fakeDragBy(float f) {
        float f2;
        float f3;
        if (!this.f1010P) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.f1000F += f;
        float scrollX = ((float) getScrollX()) - f;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f1043s;
        float f5 = ((float) clientWidth) * this.f1044t;
        C0336b bVar = this.f1029e.get(0);
        C0336b bVar2 = this.f1029e.get(this.f1029e.size() - 1);
        if (bVar.f1060b != 0) {
            f2 = bVar.f1063e * ((float) clientWidth);
        } else {
            f2 = f4;
        }
        if (bVar2.f1060b != this.f1032h.getCount() - 1) {
            f3 = bVar2.f1063e * ((float) clientWidth);
        } else {
            f3 = f5;
        }
        if (scrollX >= f2) {
            if (scrollX > f3) {
                f2 = f3;
            } else {
                f2 = scrollX;
            }
        }
        this.f1000F += f2 - ((float) ((int) f2));
        scrollTo((int) f2, getScrollY());
        m1579c((int) f2);
        MotionEvent obtain = MotionEvent.obtain(this.f1011Q, SystemClock.uptimeMillis(), 2, this.f1000F, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1005K.addMovement(obtain);
        obtain.recycle();
    }

    public boolean isFakeDragging() {
        return this.f1010P;
    }

    /* renamed from: a */
    private void m1572a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f1004J) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f1000F = MotionEventCompat.getX(motionEvent, i);
            this.f1004J = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.f1005K != null) {
                this.f1005K.clear();
            }
        }
    }

    /* renamed from: k */
    private void m1587k() {
        this.f995A = false;
        this.f996B = false;
        if (this.f1005K != null) {
            this.f1005K.recycle();
            this.f1005K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1048x != z) {
            this.f1048x = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f1032h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f1043s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f1044t))) {
                z = false;
            }
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollHorizontally(view, -i)) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    return arrowScroll(2);
                }
                if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                    return arrowScroll(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean arrowScroll(int i) {
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
                z2 = mo2032d();
            } else {
                if (i == 66 || i == 2) {
                    z2 = mo2037e();
                }
                z2 = false;
            }
        } else if (i == 17) {
            z2 = (view == null || m1565a(this.f1031g, findNextFocus).left < m1565a(this.f1031g, view).left) ? findNextFocus.requestFocus() : mo2032d();
        } else {
            if (i == 66) {
                z2 = (view == null || m1565a(this.f1031g, findNextFocus).left > m1565a(this.f1031g, view).left) ? findNextFocus.requestFocus() : mo2037e();
            }
            z2 = false;
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* renamed from: a */
    private Rect m1565a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
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

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo2032d() {
        if (this.f1033i <= 0) {
            return false;
        }
        setCurrentItem(this.f1033i - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo2037e() {
        if (this.f1032h == null || this.f1033i >= this.f1032h.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f1033i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C0336b a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a = mo2011a(childAt)) != null && a.f1060b == this.f1033i) {
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

    public void addTouchables(ArrayList<View> arrayList) {
        C0336b a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo2011a(childAt)) != null && a.f1060b == this.f1033i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        C0336b a;
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
            if (childAt.getVisibility() == 0 && (a = mo2011a(childAt)) != null && a.f1060b == this.f1033i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0336b a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo2011a(childAt)) != null && a.f1060b == this.f1033i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: android.support.v4.view.ViewPager$c */
    class C0337c extends AccessibilityDelegateCompat {
        C0337c() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(m1606b());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f1032h != null) {
                obtain.setItemCount(ViewPager.this.f1032h.getCount());
                obtain.setFromIndex(ViewPager.this.f1033i);
                obtain.setToIndex(ViewPager.this.f1033i);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(m1606b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!ViewPager.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.f1033i + 1);
                    return true;
                case 8192:
                    if (!ViewPager.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.f1033i - 1);
                    return true;
                default:
                    return false;
            }
        }

        /* renamed from: b */
        private boolean m1606b() {
            return ViewPager.this.f1032h != null && ViewPager.this.f1032h.getCount() > 1;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$e */
    class C0339e extends DataSetObserver {
        private C0339e() {
        }

        public void onChanged() {
            ViewPager.this.mo2024b();
        }

        public void onInvalidated() {
            ViewPager.this.mo2024b();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$LayoutParams */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        float f1052a = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: b */
        boolean f1053b;

        /* renamed from: c */
        int f1054c;

        /* renamed from: d */
        int f1055d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f991a);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$f */
    static class C0340f implements Comparator<View> {
        C0340f() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.isDecor != layoutParams2.isDecor) {
                return layoutParams.isDecor ? 1 : -1;
            }
            return layoutParams.f1054c - layoutParams2.f1054c;
        }
    }
}
