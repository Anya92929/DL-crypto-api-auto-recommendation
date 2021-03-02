package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.app.NotificationCompat;
import android.support.p009v4.view.C0236bn;
import android.support.p009v4.view.C0237bo;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.widget.C0390bf;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0539af;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* renamed from: android.support.v7.widget.ActionBarOverlayLayout */
public class ActionBarOverlayLayout extends ViewGroup implements C0236bn, C0622bt {

    /* renamed from: a */
    static final int[] f1188a = {C0506b.actionBarSize, 16842841};

    /* renamed from: A */
    private final Runnable f1189A;

    /* renamed from: B */
    private final C0237bo f1190B;

    /* renamed from: b */
    private int f1191b;

    /* renamed from: c */
    private int f1192c;

    /* renamed from: d */
    private ContentFrameLayout f1193d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ActionBarContainer f1194e;

    /* renamed from: f */
    private C0623bu f1195f;

    /* renamed from: g */
    private Drawable f1196g;

    /* renamed from: h */
    private boolean f1197h;

    /* renamed from: i */
    private boolean f1198i;

    /* renamed from: j */
    private boolean f1199j;

    /* renamed from: k */
    private boolean f1200k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f1201l;

    /* renamed from: m */
    private int f1202m;

    /* renamed from: n */
    private int f1203n;

    /* renamed from: o */
    private final Rect f1204o;

    /* renamed from: p */
    private final Rect f1205p;

    /* renamed from: q */
    private final Rect f1206q;

    /* renamed from: r */
    private final Rect f1207r;

    /* renamed from: s */
    private final Rect f1208s;

    /* renamed from: t */
    private final Rect f1209t;

    /* renamed from: u */
    private C0687i f1210u;

    /* renamed from: v */
    private final int f1211v;

    /* renamed from: w */
    private C0390bf f1212w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C0314ek f1213x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final C0332fb f1214y;

    /* renamed from: z */
    private final Runnable f1215z;

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1192c = 0;
        this.f1204o = new Rect();
        this.f1205p = new Rect();
        this.f1206q = new Rect();
        this.f1207r = new Rect();
        this.f1208s = new Rect();
        this.f1209t = new Rect();
        this.f1211v = 600;
        this.f1214y = new C0684f(this);
        this.f1215z = new C0685g(this);
        this.f1189A = new C0686h(this);
        m2552a(context);
        this.f1190B = new C0237bo(this);
    }

    /* renamed from: a */
    private C0623bu m2551a(View view) {
        if (view instanceof C0623bu) {
            return (C0623bu) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m2552a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1188a);
        this.f1191b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1196g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1196g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1197h = z;
        this.f1212w = C0390bf.m1564a(context);
    }

    /* renamed from: a */
    private boolean m2554a(float f, float f2) {
        this.f1212w.mo1809a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1212w.mo1816e() > this.f1194e.getHeight();
    }

    /* renamed from: a */
    private boolean m2556a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0688j jVar = (C0688j) view.getLayoutParams();
        if (z && jVar.leftMargin != rect.left) {
            jVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && jVar.topMargin != rect.top) {
            jVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && jVar.rightMargin != rect.right) {
            jVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || jVar.bottomMargin == rect.bottom) {
            return z5;
        }
        jVar.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m2559k() {
        removeCallbacks(this.f1215z);
        removeCallbacks(this.f1189A);
        if (this.f1213x != null) {
            this.f1213x.mo1559b();
        }
    }

    /* renamed from: l */
    private void m2560l() {
        m2559k();
        postDelayed(this.f1215z, 600);
    }

    /* renamed from: m */
    private void m2561m() {
        m2559k();
        postDelayed(this.f1189A, 600);
    }

    /* renamed from: n */
    private void m2562n() {
        m2559k();
        this.f1215z.run();
    }

    /* renamed from: o */
    private void m2563o() {
        m2559k();
        this.f1189A.run();
    }

    /* renamed from: a */
    public C0688j generateLayoutParams(AttributeSet attributeSet) {
        return new C0688j(getContext(), attributeSet);
    }

    /* renamed from: a */
    public void mo2665a(int i) {
        mo2669c();
        switch (i) {
            case 2:
                this.f1195f.mo3100f();
                return;
            case 5:
                this.f1195f.mo3101g();
                return;
            case C0515k.AppCompatTheme_ratingBarStyleIndicator:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo2666a(Menu menu, C0539af afVar) {
        mo2669c();
        this.f1195f.mo3087a(menu, afVar);
    }

    /* renamed from: a */
    public boolean mo2667a() {
        return this.f1198i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0688j generateDefaultLayoutParams() {
        return new C0688j(-1, -1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2669c() {
        if (this.f1193d == null) {
            this.f1193d = (ContentFrameLayout) findViewById(C0511g.action_bar_activity_content);
            this.f1194e = (ActionBarContainer) findViewById(C0511g.action_bar_container);
            this.f1195f = m2551a(findViewById(C0511g.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0688j;
    }

    /* renamed from: d */
    public boolean mo2671d() {
        mo2669c();
        return this.f1195f.mo3102h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1196g != null && !this.f1197h) {
            int bottom = this.f1194e.getVisibility() == 0 ? (int) (((float) this.f1194e.getBottom()) + C0247by.m915h(this.f1194e) + 0.5f) : 0;
            this.f1196g.setBounds(0, bottom, getWidth(), this.f1196g.getIntrinsicHeight() + bottom);
            this.f1196g.draw(canvas);
        }
    }

    /* renamed from: e */
    public boolean mo2673e() {
        mo2669c();
        return this.f1195f.mo3103i();
    }

    /* renamed from: f */
    public boolean mo2674f() {
        mo2669c();
        return this.f1195f.mo3104j();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo2669c();
        if ((C0247by.m919l(this) & NotificationCompat.FLAG_LOCAL_ONLY) != 0) {
        }
        boolean a = m2556a(this.f1194e, rect, true, true, false, true);
        this.f1207r.set(rect);
        C0682dz.m3094a(this, this.f1207r, this.f1204o);
        if (!this.f1205p.equals(this.f1204o)) {
            this.f1205p.set(this.f1204o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* renamed from: g */
    public boolean mo2676g() {
        mo2669c();
        return this.f1195f.mo3105k();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0688j(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.f1194e != null) {
            return -((int) C0247by.m915h(this.f1194e));
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.f1190B.mo1438a();
    }

    public CharSequence getTitle() {
        mo2669c();
        return this.f1195f.mo3099e();
    }

    /* renamed from: h */
    public boolean mo2683h() {
        mo2669c();
        return this.f1195f.mo3106l();
    }

    /* renamed from: i */
    public void mo2684i() {
        mo2669c();
        this.f1195f.mo3107m();
    }

    /* renamed from: j */
    public void mo2685j() {
        mo2669c();
        this.f1195f.mo3108n();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m2552a(getContext());
        C0247by.requestApplyInsets(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2559k();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0688j jVar = (C0688j) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = jVar.leftMargin + paddingLeft;
                int i7 = jVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        mo2669c();
        measureChildWithMargins(this.f1194e, i, 0, i2, 0);
        C0688j jVar = (C0688j) this.f1194e.getLayoutParams();
        int max = Math.max(0, this.f1194e.getMeasuredWidth() + jVar.leftMargin + jVar.rightMargin);
        int max2 = Math.max(0, jVar.bottomMargin + this.f1194e.getMeasuredHeight() + jVar.topMargin);
        int a = C0682dz.m3093a(0, C0247by.m914g(this.f1194e));
        boolean z = (C0247by.m919l(this) & NotificationCompat.FLAG_LOCAL_ONLY) != 0;
        if (z) {
            measuredHeight = this.f1191b;
            if (this.f1199j && this.f1194e.getTabContainer() != null) {
                measuredHeight += this.f1191b;
            }
        } else {
            measuredHeight = this.f1194e.getVisibility() != 8 ? this.f1194e.getMeasuredHeight() : 0;
        }
        this.f1206q.set(this.f1204o);
        this.f1208s.set(this.f1207r);
        if (this.f1198i || z) {
            Rect rect = this.f1208s;
            rect.top = measuredHeight + rect.top;
            this.f1208s.bottom += 0;
        } else {
            Rect rect2 = this.f1206q;
            rect2.top = measuredHeight + rect2.top;
            this.f1206q.bottom += 0;
        }
        m2556a(this.f1193d, this.f1206q, true, true, true, true);
        if (!this.f1209t.equals(this.f1208s)) {
            this.f1209t.set(this.f1208s);
            this.f1193d.mo2758a(this.f1208s);
        }
        measureChildWithMargins(this.f1193d, i, 0, i2, 0);
        C0688j jVar2 = (C0688j) this.f1193d.getLayoutParams();
        int max3 = Math.max(max, this.f1193d.getMeasuredWidth() + jVar2.leftMargin + jVar2.rightMargin);
        int max4 = Math.max(max2, jVar2.bottomMargin + this.f1193d.getMeasuredHeight() + jVar2.topMargin);
        int a2 = C0682dz.m3093a(a, C0247by.m914g(this.f1193d));
        setMeasuredDimension(C0247by.m887a(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, a2), C0247by.m887a(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1200k || !z) {
            return false;
        }
        if (m2554a(f, f2)) {
            m2563o();
        } else {
            m2562n();
        }
        this.f1201l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1202m += i2;
        setActionBarHideOffset(this.f1202m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1190B.mo1439a(view, view2, i);
        this.f1202m = getActionBarHideOffset();
        m2559k();
        if (this.f1210u != null) {
            this.f1210u.mo2086n();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1194e.getVisibility() != 0) {
            return false;
        }
        return this.f1200k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1200k && !this.f1201l) {
            if (this.f1202m <= this.f1194e.getHeight()) {
                m2560l();
            } else {
                m2561m();
            }
        }
        if (this.f1210u != null) {
            this.f1210u.mo2087o();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo2669c();
        int i2 = this.f1203n ^ i;
        this.f1203n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & NotificationCompat.FLAG_LOCAL_ONLY) != 0;
        if (this.f1210u != null) {
            C0687i iVar = this.f1210u;
            if (z3) {
                z = false;
            }
            iVar.mo2077h(z);
            if (z2 || !z3) {
                this.f1210u.mo2084l();
            } else {
                this.f1210u.mo2085m();
            }
        }
        if ((i2 & NotificationCompat.FLAG_LOCAL_ONLY) != 0 && this.f1210u != null) {
            C0247by.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1192c = i;
        if (this.f1210u != null) {
            this.f1210u.mo2076b(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m2559k();
        C0247by.m890a((View) this.f1194e, (float) (-Math.max(0, Math.min(i, this.f1194e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0687i iVar) {
        this.f1210u = iVar;
        if (getWindowToken() != null) {
            this.f1210u.mo2076b(this.f1192c);
            if (this.f1203n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1203n);
                C0247by.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1199j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1200k) {
            this.f1200k = z;
            if (!z) {
                m2559k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        mo2669c();
        this.f1195f.mo3083a(i);
    }

    public void setIcon(Drawable drawable) {
        mo2669c();
        this.f1195f.mo3084a(drawable);
    }

    public void setLogo(int i) {
        mo2669c();
        this.f1195f.mo3092b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1198i = z;
        this.f1197h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        mo2669c();
        this.f1195f.mo3088a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo2669c();
        this.f1195f.mo3089a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
