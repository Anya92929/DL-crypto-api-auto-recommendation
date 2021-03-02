package android.support.p001v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p001v4.view.AccessibilityDelegateCompat;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.view.KeyEventCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewGroupCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.widget.DrawerLayout */
public class DrawerLayout extends ViewGroup implements C1117fh {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    static final C0404c f1143a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int[] f1144b = {16842931};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f1145c = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: d */
    private static final boolean f1146d;

    /* renamed from: A */
    private Drawable f1147A;

    /* renamed from: B */
    private CharSequence f1148B;

    /* renamed from: C */
    private CharSequence f1149C;

    /* renamed from: D */
    private Object f1150D;

    /* renamed from: E */
    private boolean f1151E;

    /* renamed from: F */
    private Drawable f1152F;

    /* renamed from: G */
    private Drawable f1153G;

    /* renamed from: H */
    private Drawable f1154H;

    /* renamed from: I */
    private Drawable f1155I;

    /* renamed from: J */
    private final ArrayList<View> f1156J;

    /* renamed from: e */
    private final C0403b f1157e;

    /* renamed from: f */
    private float f1158f;

    /* renamed from: g */
    private int f1159g;

    /* renamed from: h */
    private int f1160h;

    /* renamed from: i */
    private float f1161i;

    /* renamed from: j */
    private Paint f1162j;

    /* renamed from: k */
    private final ViewDragHelper f1163k;

    /* renamed from: l */
    private final ViewDragHelper f1164l;

    /* renamed from: m */
    private final C0407f f1165m;

    /* renamed from: n */
    private final C0407f f1166n;

    /* renamed from: o */
    private int f1167o;

    /* renamed from: p */
    private boolean f1168p;

    /* renamed from: q */
    private boolean f1169q;

    /* renamed from: r */
    private int f1170r;

    /* renamed from: s */
    private int f1171s;

    /* renamed from: t */
    private boolean f1172t;

    /* renamed from: u */
    private boolean f1173u;

    /* renamed from: v */
    private DrawerListener f1174v;

    /* renamed from: w */
    private float f1175w;

    /* renamed from: x */
    private float f1176x;

    /* renamed from: y */
    private Drawable f1177y;

    /* renamed from: z */
    private Drawable f1178z;

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerListener */
    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$c */
    interface C0404c {
        /* renamed from: a */
        int mo2724a(Object obj);

        /* renamed from: a */
        Drawable mo2725a(Context context);

        /* renamed from: a */
        void mo2726a(View view);

        /* renamed from: a */
        void mo2727a(View view, Object obj, int i);

        /* renamed from: a */
        void mo2728a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        f1146d = z;
        if (Build.VERSION.SDK_INT >= 21) {
            f1143a = new C0405d();
        } else {
            f1143a = new C0406e();
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SimpleDrawerListener */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerClosed(View view) {
        }

        public void onDrawerStateChanged(int i) {
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$e */
    static class C0406e implements C0404c {
        C0406e() {
        }

        /* renamed from: a */
        public void mo2726a(View view) {
        }

        /* renamed from: a */
        public void mo2727a(View view, Object obj, int i) {
        }

        /* renamed from: a */
        public void mo2728a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        /* renamed from: a */
        public int mo2724a(Object obj) {
            return 0;
        }

        /* renamed from: a */
        public Drawable mo2725a(Context context) {
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$d */
    static class C0405d implements C0404c {
        C0405d() {
        }

        /* renamed from: a */
        public void mo2726a(View view) {
            C1115fg.m5053a(view);
        }

        /* renamed from: a */
        public void mo2727a(View view, Object obj, int i) {
            C1115fg.m5054a(view, obj, i);
        }

        /* renamed from: a */
        public void mo2728a(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
            C1115fg.m5055a(marginLayoutParams, obj, i);
        }

        /* renamed from: a */
        public int mo2724a(Object obj) {
            return C1115fg.m5051a(obj);
        }

        /* renamed from: a */
        public Drawable mo2725a(Context context) {
            return C1115fg.m5052a(context);
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
        this.f1157e = new C0403b();
        this.f1160h = -1728053248;
        this.f1162j = new Paint();
        this.f1169q = true;
        this.f1152F = null;
        this.f1153G = null;
        this.f1154H = null;
        this.f1155I = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f1159g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f1165m = new C0407f(3);
        this.f1166n = new C0407f(5);
        this.f1163k = ViewDragHelper.create(this, 1.0f, this.f1165m);
        this.f1163k.setEdgeTrackingEnabled(1);
        this.f1163k.setMinVelocity(f2);
        this.f1165m.mo2730a(this.f1163k);
        this.f1164l = ViewDragHelper.create(this, 1.0f, this.f1166n);
        this.f1164l.setEdgeTrackingEnabled(2);
        this.f1164l.setMinVelocity(f2);
        this.f1166n.mo2730a(this.f1164l);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new C0402a());
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            f1143a.mo2726a((View) this);
            this.f1177y = f1143a.mo2725a(context);
        }
        this.f1158f = f * 10.0f;
        this.f1156J = new ArrayList<>();
    }

    public void setDrawerElevation(float f) {
        this.f1158f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (mo2677f(childAt)) {
                ViewCompat.setElevation(childAt, this.f1158f);
            }
        }
    }

    public float getDrawerElevation() {
        if (f1146d) {
            return this.f1158f;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.f1150D = obj;
        this.f1151E = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (!f1146d) {
            if ((i & GravityCompat.START) == 8388611) {
                this.f1152F = drawable;
            } else if ((i & GravityCompat.END) == 8388613) {
                this.f1153G = drawable;
            } else if ((i & 3) == 3) {
                this.f1154H = drawable;
            } else if ((i & 5) == 5) {
                this.f1155I = drawable;
            } else {
                return;
            }
            m2433e();
            invalidate();
        }
    }

    public void setDrawerShadow(@DrawableRes int i, int i2) {
        setDrawerShadow(getResources().getDrawable(i), i2);
    }

    public void setScrimColor(@ColorInt int i) {
        this.f1160h = i;
        invalidate();
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.f1174v = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f1170r = i;
        } else if (absoluteGravity == 5) {
            this.f1171s = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f1163k : this.f1164l).cancel();
        }
        switch (i) {
            case 1:
                View a = mo2657a(absoluteGravity);
                if (a != null) {
                    closeDrawer(a);
                    return;
                }
                return;
            case 2:
                View a2 = mo2657a(absoluteGravity);
                if (a2 != null) {
                    openDrawer(a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (!mo2677f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
        }
        setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).gravity);
    }

    public int getDrawerLockMode(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f1170r;
        }
        if (absoluteGravity == 5) {
            return this.f1171s;
        }
        return 0;
    }

    public int getDrawerLockMode(View view) {
        int d = mo2674d(view);
        if (d == 3) {
            return this.f1170r;
        }
        if (d == 5) {
            return this.f1171s;
        }
        return 0;
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f1148B = charSequence;
        } else if (absoluteGravity == 5) {
            this.f1149C = charSequence;
        }
    }

    @Nullable
    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f1148B;
        }
        if (absoluteGravity == 5) {
            return this.f1149C;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2658a(int i, int i2, View view) {
        int i3 = 1;
        int viewDragState = this.f1163k.getViewDragState();
        int viewDragState2 = this.f1164l.getViewDragState();
        if (!(viewDragState == 1 || viewDragState2 == 1)) {
            i3 = (viewDragState == 2 || viewDragState2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f1179a == BitmapDescriptorFactory.HUE_RED) {
                mo2659a(view);
            } else if (layoutParams.f1179a == 1.0f) {
                mo2666b(view);
            }
        }
        if (i3 != this.f1167o) {
            this.f1167o = i3;
            if (this.f1174v != null) {
                this.f1174v.onDrawerStateChanged(i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2659a(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f1181c) {
            layoutParams.f1181c = false;
            if (this.f1174v != null) {
                this.f1174v.onDrawerClosed(view);
            }
            m2428a(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2666b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f1181c) {
            layoutParams.f1181c = true;
            if (this.f1174v != null) {
                this.f1174v.onDrawerOpened(view);
            }
            m2428a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    /* renamed from: a */
    private void m2428a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || mo2677f(childAt)) && (!z || childAt != view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2660a(View view, float f) {
        if (this.f1174v != null) {
            this.f1174v.onDrawerSlide(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2667b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f1179a) {
            layoutParams.f1179a = f;
            mo2660a(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo2668c(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1179a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo2674d(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2662a(View view, int i) {
        return (mo2674d(view) & i) == i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo2656a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f1181c) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo2657a(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo2674d(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: b */
    static String m2430b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1169q = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1169q = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r5 != 0) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r1 = 300(0x12c, float:4.2E-43)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            r12 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.getMode(r14)
            int r5 = android.view.View.MeasureSpec.getMode(r15)
            int r2 = android.view.View.MeasureSpec.getSize(r14)
            int r0 = android.view.View.MeasureSpec.getSize(r15)
            if (r3 != r12) goto L_0x001b
            if (r5 == r12) goto L_0x0056
        L_0x001b:
            boolean r6 = r13.isInEditMode()
            if (r6 == 0) goto L_0x0058
            if (r3 != r7) goto L_0x0050
        L_0x0023:
            if (r5 != r7) goto L_0x0054
            r1 = r0
        L_0x0026:
            r13.setMeasuredDimension(r2, r1)
            java.lang.Object r0 = r13.f1150D
            if (r0 == 0) goto L_0x0060
            boolean r0 = android.support.p001v4.view.ViewCompat.getFitsSystemWindows(r13)
            if (r0 == 0) goto L_0x0060
            r0 = 1
            r3 = r0
        L_0x0035:
            int r6 = android.support.p001v4.view.ViewCompat.getLayoutDirection(r13)
            int r7 = r13.getChildCount()
            r5 = r4
        L_0x003e:
            if (r5 >= r7) goto L_0x014b
            android.view.View r8 = r13.getChildAt(r5)
            int r0 = r8.getVisibility()
            r9 = 8
            if (r0 != r9) goto L_0x0062
        L_0x004c:
            int r0 = r5 + 1
            r5 = r0
            goto L_0x003e
        L_0x0050:
            if (r3 != 0) goto L_0x0023
            r2 = r1
            goto L_0x0023
        L_0x0054:
            if (r5 == 0) goto L_0x0026
        L_0x0056:
            r1 = r0
            goto L_0x0026
        L_0x0058:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
            r0.<init>(r1)
            throw r0
        L_0x0060:
            r3 = r4
            goto L_0x0035
        L_0x0062:
            android.view.ViewGroup$LayoutParams r0 = r8.getLayoutParams()
            android.support.v4.widget.DrawerLayout$LayoutParams r0 = (android.support.p001v4.widget.DrawerLayout.LayoutParams) r0
            if (r3 == 0) goto L_0x007d
            int r9 = r0.gravity
            int r9 = android.support.p001v4.view.GravityCompat.getAbsoluteGravity(r9, r6)
            boolean r10 = android.support.p001v4.view.ViewCompat.getFitsSystemWindows(r8)
            if (r10 == 0) goto L_0x009e
            android.support.v4.widget.DrawerLayout$c r10 = f1143a
            java.lang.Object r11 = r13.f1150D
            r10.mo2727a((android.view.View) r8, (java.lang.Object) r11, (int) r9)
        L_0x007d:
            boolean r9 = r13.mo2676e(r8)
            if (r9 == 0) goto L_0x00a6
            int r9 = r0.leftMargin
            int r9 = r2 - r9
            int r10 = r0.rightMargin
            int r9 = r9 - r10
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12)
            int r10 = r0.topMargin
            int r10 = r1 - r10
            int r0 = r0.bottomMargin
            int r0 = r10 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12)
            r8.measure(r9, r0)
            goto L_0x004c
        L_0x009e:
            android.support.v4.widget.DrawerLayout$c r10 = f1143a
            java.lang.Object r11 = r13.f1150D
            r10.mo2728a((android.view.ViewGroup.MarginLayoutParams) r0, (java.lang.Object) r11, (int) r9)
            goto L_0x007d
        L_0x00a6:
            boolean r9 = r13.mo2677f(r8)
            if (r9 == 0) goto L_0x011c
            boolean r9 = f1146d
            if (r9 == 0) goto L_0x00bf
            float r9 = android.support.p001v4.view.ViewCompat.getElevation(r8)
            float r10 = r13.f1158f
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x00bf
            float r9 = r13.f1158f
            android.support.p001v4.view.ViewCompat.setElevation(r8, r9)
        L_0x00bf:
            int r9 = r13.mo2674d(r8)
            r9 = r9 & 7
            r10 = r4 & r9
            if (r10 == 0) goto L_0x00fe
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Child drawer has absolute gravity "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = m2430b((int) r9)
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
        L_0x00fe:
            int r9 = r13.f1159g
            int r10 = r0.leftMargin
            int r9 = r9 + r10
            int r10 = r0.rightMargin
            int r9 = r9 + r10
            int r10 = r0.width
            int r9 = getChildMeasureSpec(r14, r9, r10)
            int r10 = r0.topMargin
            int r11 = r0.bottomMargin
            int r10 = r10 + r11
            int r0 = r0.height
            int r0 = getChildMeasureSpec(r15, r10, r0)
            r8.measure(r9, r0)
            goto L_0x004c
        L_0x011c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Child "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " at index "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x014b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    /* renamed from: e */
    private void m2433e() {
        if (!f1146d) {
            this.f1178z = m2434f();
            this.f1147A = m2435g();
        }
    }

    /* renamed from: f */
    private Drawable m2434f() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            if (this.f1152F != null) {
                m2429a(this.f1152F, layoutDirection);
                return this.f1152F;
            }
        } else if (this.f1153G != null) {
            m2429a(this.f1153G, layoutDirection);
            return this.f1153G;
        }
        return this.f1154H;
    }

    /* renamed from: g */
    private Drawable m2435g() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            if (this.f1153G != null) {
                m2429a(this.f1153G, layoutDirection);
                return this.f1153G;
            }
        } else if (this.f1152F != null) {
            m2429a(this.f1152F, layoutDirection);
            return this.f1152F;
        }
        return this.f1155I;
    }

    /* renamed from: a */
    private boolean m2429a(Drawable drawable, int i) {
        if (drawable == null || !DrawableCompat.isAutoMirrored(drawable)) {
            return false;
        }
        DrawableCompat.setLayoutDirection(drawable, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        this.f1168p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (mo2676e(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo2662a(childAt, 3)) {
                        i5 = ((int) (((float) measuredWidth) * layoutParams.f1179a)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i5)) / ((float) measuredWidth);
                    } else {
                        i5 = i6 - ((int) (((float) measuredWidth) * layoutParams.f1179a));
                        f = ((float) (i6 - i5)) / ((float) measuredWidth);
                    }
                    boolean z2 = f != layoutParams.f1179a;
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            int i9 = (i8 - measuredHeight) / 2;
                            if (i9 < layoutParams.topMargin) {
                                i9 = layoutParams.topMargin;
                            } else if (i9 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i9 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
                            break;
                        case 80:
                            int i10 = i4 - i2;
                            childAt.layout(i5, (i10 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i10 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (z2) {
                        mo2667b(childAt, f);
                    }
                    int i11 = layoutParams.f1179a > BitmapDescriptorFactory.HUE_RED ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        this.f1168p = false;
        this.f1169q = false;
    }

    public void requestLayout() {
        if (!this.f1168p) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f1179a);
        }
        this.f1161i = f;
        if (this.f1163k.continueSettling(true) || this.f1164l.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: h */
    private static boolean m2438h(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1177y = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1177y;
    }

    public void setStatusBarBackground(int i) {
        this.f1177y = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.f1177y = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        m2433e();
    }

    public void onDraw(Canvas canvas) {
        int a;
        super.onDraw(canvas);
        if (this.f1151E && this.f1177y != null && (a = f1143a.mo2724a(this.f1150D)) > 0) {
            this.f1177y.setBounds(0, 0, getWidth(), a);
            this.f1177y.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean e = mo2676e(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (e) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m2438h(childAt) && mo2677f(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (mo2662a(childAt, 3)) {
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
        if (this.f1161i > BitmapDescriptorFactory.HUE_RED && e) {
            this.f1162j.setColor((((int) (((float) ((this.f1160h & ViewCompat.MEASURED_STATE_MASK) >>> 24)) * this.f1161i)) << 24) | (this.f1160h & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) i2, BitmapDescriptorFactory.HUE_RED, (float) i4, (float) getHeight(), this.f1162j);
        } else if (this.f1178z != null && mo2662a(view, 3)) {
            int intrinsicWidth = this.f1178z.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(((float) right2) / ((float) this.f1163k.getEdgeSize()), 1.0f));
            this.f1178z.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f1178z.setAlpha((int) (255.0f * max));
            this.f1178z.draw(canvas);
        } else if (this.f1147A != null && mo2662a(view, 5)) {
            int intrinsicWidth2 = this.f1147A.getIntrinsicWidth();
            int left = view.getLeft();
            float max2 = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(((float) (getWidth() - left)) / ((float) this.f1164l.getEdgeSize()), 1.0f));
            this.f1147A.setBounds(left - intrinsicWidth2, view.getTop(), left, view.getBottom());
            this.f1147A.setAlpha((int) (255.0f * max2));
            this.f1147A.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo2676e(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo2677f(View view) {
        return (GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view)) & 7) != 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            int r0 = android.support.p001v4.view.MotionEventCompat.getActionMasked(r8)
            android.support.v4.widget.ViewDragHelper r3 = r7.f1163k
            boolean r3 = r3.shouldInterceptTouchEvent(r8)
            android.support.v4.widget.ViewDragHelper r4 = r7.f1164l
            boolean r4 = r4.shouldInterceptTouchEvent(r8)
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
            boolean r0 = r7.m2437h()
            if (r0 != 0) goto L_0x0025
            boolean r0 = r7.f1173u
            if (r0 == 0) goto L_0x0026
        L_0x0025:
            r2 = r1
        L_0x0026:
            return r2
        L_0x0027:
            float r0 = r8.getX()
            float r4 = r8.getY()
            r7.f1175w = r0
            r7.f1176x = r4
            float r5 = r7.f1161i
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x006d
            android.support.v4.widget.ViewDragHelper r5 = r7.f1163k
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r0 = r5.findTopChildUnder(r0, r4)
            if (r0 == 0) goto L_0x006d
            boolean r0 = r7.mo2676e(r0)
            if (r0 == 0) goto L_0x006d
            r0 = r1
        L_0x004b:
            r7.f1172t = r2
            r7.f1173u = r2
            goto L_0x0017
        L_0x0050:
            android.support.v4.widget.ViewDragHelper r0 = r7.f1163k
            r4 = 3
            boolean r0 = r0.checkTouchSlop(r4)
            if (r0 == 0) goto L_0x0016
            android.support.v4.widget.DrawerLayout$f r0 = r7.f1165m
            r0.mo2729a()
            android.support.v4.widget.DrawerLayout$f r0 = r7.f1166n
            r0.mo2729a()
            r0 = r2
            goto L_0x0017
        L_0x0065:
            r7.mo2661a((boolean) r1)
            r7.f1172t = r2
            r7.f1173u = r2
            goto L_0x0016
        L_0x006d:
            r0 = r2
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View a;
        this.f1163k.processTouchEvent(motionEvent);
        this.f1164l.processTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f1175w = x;
                this.f1176x = y;
                this.f1172t = false;
                this.f1173u = false;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View findTopChildUnder = this.f1163k.findTopChildUnder((int) x2, (int) y2);
                if (findTopChildUnder != null && mo2676e(findTopChildUnder)) {
                    float f = x2 - this.f1175w;
                    float f2 = y2 - this.f1176x;
                    int touchSlop = this.f1163k.getTouchSlop();
                    if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && (a = mo2656a()) != null) {
                        z = getDrawerLockMode(a) == 2;
                        mo2661a(z);
                        this.f1172t = false;
                        break;
                    }
                }
                z = true;
                mo2661a(z);
                this.f1172t = false;
            case 3:
                mo2661a(true);
                this.f1172t = false;
                this.f1173u = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1172t = z;
        if (z) {
            mo2661a(true);
        }
    }

    public void closeDrawers() {
        mo2661a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2661a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (mo2677f(childAt) && (!z || layoutParams.f1180b)) {
                int width = childAt.getWidth();
                if (mo2662a(childAt, 3)) {
                    z2 |= this.f1163k.smoothSlideViewTo(childAt, -width, childAt.getTop());
                } else {
                    z2 |= this.f1164l.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f1180b = false;
            }
        }
        this.f1165m.mo2729a();
        this.f1166n.mo2729a();
        if (z2) {
            invalidate();
        }
    }

    public void openDrawer(View view) {
        if (!mo2677f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.f1169q) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f1179a = 1.0f;
            layoutParams.f1181c = true;
            m2428a(view, true);
        } else if (mo2662a(view, 3)) {
            this.f1163k.smoothSlideViewTo(view, 0, view.getTop());
        } else {
            this.f1164l.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    public void openDrawer(int i) {
        View a = mo2657a(i);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2430b(i));
        }
        openDrawer(a);
    }

    public void closeDrawer(View view) {
        if (!mo2677f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.f1169q) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f1179a = BitmapDescriptorFactory.HUE_RED;
            layoutParams.f1181c = false;
        } else if (mo2662a(view, 3)) {
            this.f1163k.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
        } else {
            this.f1164l.smoothSlideViewTo(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    public void closeDrawer(int i) {
        View a = mo2657a(i);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2430b(i));
        }
        closeDrawer(a);
    }

    public boolean isDrawerOpen(View view) {
        if (mo2677f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1181c;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerOpen(int i) {
        View a = mo2657a(i);
        if (a != null) {
            return isDrawerOpen(a);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        if (mo2677f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1179a > BitmapDescriptorFactory.HUE_RED;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i) {
        View a = mo2657a(i);
        if (a != null) {
            return isDrawerVisible(a);
        }
        return false;
    }

    /* renamed from: h */
    private boolean m2437h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f1180b) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!mo2677f(childAt)) {
                    this.f1156J.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    z = true;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (!z) {
                int size = this.f1156J.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.f1156J.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f1156J.clear();
        }
    }

    /* renamed from: i */
    private boolean m2439i() {
        return m2441j() != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public View m2441j() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mo2677f(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2665b() {
        if (!this.f1173u) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f1173u = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2439i()) {
            return super.onKeyDown(i, keyEvent);
        }
        KeyEventCompat.startTracking(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View j = m2441j();
        if (j != null && getDrawerLockMode(j) == 0) {
            closeDrawers();
        }
        return j != null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View a;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f1182a == 0 || (a = mo2657a(savedState.f1182a)) == null)) {
            openDrawer(a);
        }
        setDrawerLockMode(savedState.f1183b, 3);
        setDrawerLockMode(savedState.f1184c, 5);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        View a = mo2656a();
        if (a != null) {
            savedState.f1182a = ((LayoutParams) a.getLayoutParams()).gravity;
        }
        savedState.f1183b = this.f1170r;
        savedState.f1184c = this.f1171s;
        return savedState;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (mo2656a() != null || mo2677f(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (!f1145c) {
            ViewCompat.setAccessibilityDelegate(view, this.f1157e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m2440i(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SavedState */
    public static class SavedState extends View.BaseSavedState {
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
        int f1182a = 0;

        /* renamed from: b */
        int f1183b = 0;

        /* renamed from: c */
        int f1184c = 0;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1182a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1182a);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$f */
    class C0407f extends ViewDragHelper.Callback {

        /* renamed from: b */
        private final int f1189b;

        /* renamed from: c */
        private ViewDragHelper f1190c;

        /* renamed from: d */
        private final Runnable f1191d = new Runnable() {
            public void run() {
                C0407f.this.m2477c();
            }
        };

        public C0407f(int i) {
            this.f1189b = i;
        }

        /* renamed from: a */
        public void mo2730a(ViewDragHelper viewDragHelper) {
            this.f1190c = viewDragHelper;
        }

        /* renamed from: a */
        public void mo2729a() {
            DrawerLayout.this.removeCallbacks(this.f1191d);
        }

        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.mo2677f(view) && DrawerLayout.this.mo2662a(view, this.f1189b) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }

        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.mo2658a(this.f1189b, i, this.f1190c.getCapturedView());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width;
            int width2 = view.getWidth();
            if (DrawerLayout.this.mo2662a(view, 3)) {
                width = ((float) (width2 + i)) / ((float) width2);
            } else {
                width = ((float) (DrawerLayout.this.getWidth() - i)) / ((float) width2);
            }
            DrawerLayout.this.mo2667b(view, width);
            view.setVisibility(width == BitmapDescriptorFactory.HUE_RED ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f1180b = false;
            m2476b();
        }

        /* renamed from: b */
        private void m2476b() {
            int i = 3;
            if (this.f1189b == 3) {
                i = 5;
            }
            View a = DrawerLayout.this.mo2657a(i);
            if (a != null) {
                DrawerLayout.this.closeDrawer(a);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            int width;
            float c = DrawerLayout.this.mo2668c(view);
            int width2 = view.getWidth();
            if (DrawerLayout.this.mo2662a(view, 3)) {
                width = (f > BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && c > 0.5f)) ? 0 : -width2;
            } else {
                width = DrawerLayout.this.getWidth();
                if (f < BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && c > 0.5f)) {
                    width -= width2;
                }
            }
            this.f1190c.settleCapturedViewAt(width, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f1191d, 160);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m2477c() {
            View view;
            int i;
            int i2 = 0;
            int edgeSize = this.f1190c.getEdgeSize();
            boolean z = this.f1189b == 3;
            if (z) {
                View a = DrawerLayout.this.mo2657a(3);
                if (a != null) {
                    i2 = -a.getWidth();
                }
                int i3 = i2 + edgeSize;
                view = a;
                i = i3;
            } else {
                View a2 = DrawerLayout.this.mo2657a(5);
                int width = DrawerLayout.this.getWidth() - edgeSize;
                view = a2;
                i = width;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.f1190c.smoothSlideViewTo(view, i, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f1180b = true;
                DrawerLayout.this.invalidate();
                m2476b();
                DrawerLayout.this.mo2665b();
            }
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeDragStarted(int i, int i2) {
            View a;
            if ((i & 1) == 1) {
                a = DrawerLayout.this.mo2657a(3);
            } else {
                a = DrawerLayout.this.mo2657a(5);
            }
            if (a != null && DrawerLayout.this.getDrawerLockMode(a) == 0) {
                this.f1190c.captureChildView(a, i2);
            }
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.mo2677f(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.mo2662a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        float f1179a;

        /* renamed from: b */
        boolean f1180b;

        /* renamed from: c */
        boolean f1181c;
        public int gravity;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f1144b);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$a */
    class C0402a extends AccessibilityDelegateCompat {

        /* renamed from: c */
        private final Rect f1186c = new Rect();

        C0402a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f1145c) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                m2458a(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                m2459a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = DrawerLayout.this.m2441j();
            if (!(a == null || (drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.mo2674d(a))) == null)) {
                text.add(drawerTitle);
            }
            return true;
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f1145c || DrawerLayout.m2440i(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        /* renamed from: a */
        private void m2459a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m2440i(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        /* renamed from: a */
        private void m2458a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1186c;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$b */
    final class C0403b extends AccessibilityDelegateCompat {
        C0403b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m2440i(view)) {
                accessibilityNodeInfoCompat.setParent((View) null);
            }
        }
    }
}
