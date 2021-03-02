package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.p009v4.widget.C0377at;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0544ak;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.cg */
public class C0636cg implements C0544ak {

    /* renamed from: a */
    private static Method f1522a;

    /* renamed from: d */
    private static Method f1523d;

    /* renamed from: e */
    private static Method f1524e;

    /* renamed from: A */
    private final C0643cn f1525A;

    /* renamed from: B */
    private final C0642cm f1526B;

    /* renamed from: C */
    private final C0640ck f1527C;

    /* renamed from: D */
    private Runnable f1528D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public final Handler f1529E;

    /* renamed from: F */
    private final Rect f1530F;

    /* renamed from: G */
    private Rect f1531G;

    /* renamed from: H */
    private boolean f1532H;

    /* renamed from: b */
    int f1533b;

    /* renamed from: c */
    PopupWindow f1534c;

    /* renamed from: f */
    private Context f1535f;

    /* renamed from: g */
    private ListAdapter f1536g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0625bw f1537h;

    /* renamed from: i */
    private int f1538i;

    /* renamed from: j */
    private int f1539j;

    /* renamed from: k */
    private int f1540k;

    /* renamed from: l */
    private int f1541l;

    /* renamed from: m */
    private int f1542m;

    /* renamed from: n */
    private boolean f1543n;

    /* renamed from: o */
    private boolean f1544o;

    /* renamed from: p */
    private int f1545p;

    /* renamed from: q */
    private boolean f1546q;

    /* renamed from: r */
    private boolean f1547r;

    /* renamed from: s */
    private View f1548s;

    /* renamed from: t */
    private int f1549t;

    /* renamed from: u */
    private DataSetObserver f1550u;

    /* renamed from: v */
    private View f1551v;

    /* renamed from: w */
    private Drawable f1552w;

    /* renamed from: x */
    private AdapterView.OnItemClickListener f1553x;

    /* renamed from: y */
    private AdapterView.OnItemSelectedListener f1554y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final C0644co f1555z;

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            f1522a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        Class<PopupWindow> cls2 = PopupWindow.class;
        try {
            f1523d = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f1524e = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public C0636cg(Context context) {
        this(context, (AttributeSet) null, C0506b.listPopupWindowStyle);
    }

    public C0636cg(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public C0636cg(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1538i = -2;
        this.f1539j = -2;
        this.f1542m = 1002;
        this.f1544o = true;
        this.f1545p = 0;
        this.f1546q = false;
        this.f1547r = false;
        this.f1533b = Integer.MAX_VALUE;
        this.f1549t = 0;
        this.f1555z = new C0644co(this, (C0637ch) null);
        this.f1525A = new C0643cn(this, (C0637ch) null);
        this.f1526B = new C0642cm(this, (C0637ch) null);
        this.f1527C = new C0640ck(this, (C0637ch) null);
        this.f1530F = new Rect();
        this.f1535f = context;
        this.f1529E = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.ListPopupWindow, i, i2);
        this.f1540k = obtainStyledAttributes.getDimensionPixelOffset(C0515k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1541l = obtainStyledAttributes.getDimensionPixelOffset(C0515k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1541l != 0) {
            this.f1543n = true;
        }
        obtainStyledAttributes.recycle();
        this.f1534c = new C0603ba(context, attributeSet, i);
        this.f1534c.setInputMethodMode(1);
    }

    /* renamed from: a */
    private int m2899a(View view, int i, boolean z) {
        if (f1523d != null) {
            try {
                return ((Integer) f1523d.invoke(this.f1534c, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1534c.getMaxAvailableHeight(view, i);
    }

    /* renamed from: b */
    private void mo3067b() {
        if (this.f1548s != null) {
            ViewParent parent = this.f1548s.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1548s);
            }
        }
    }

    /* renamed from: b */
    private void mo3220b(boolean z) {
        if (f1522a != null) {
            try {
                f1522a.invoke(this.f1534c, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: android.support.v7.widget.bw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: android.support.v7.widget.bw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: android.support.v7.widget.bw} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mo3068f() {
        /*
            r10 = this;
            r9 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = -1
            r1 = 1
            r2 = 0
            android.support.v7.widget.bw r0 = r10.f1537h
            if (r0 != 0) goto L_0x010c
            android.content.Context r5 = r10.f1535f
            android.support.v7.widget.ci r0 = new android.support.v7.widget.ci
            r0.<init>(r10)
            r10.f1528D = r0
            boolean r0 = r10.f1532H
            if (r0 != 0) goto L_0x00f8
            r0 = r1
        L_0x0019:
            android.support.v7.widget.bw r0 = r10.mo3168a(r5, r0)
            r10.f1537h = r0
            android.graphics.drawable.Drawable r0 = r10.f1552w
            if (r0 == 0) goto L_0x002a
            android.support.v7.widget.bw r0 = r10.f1537h
            android.graphics.drawable.Drawable r6 = r10.f1552w
            r0.setSelector(r6)
        L_0x002a:
            android.support.v7.widget.bw r0 = r10.f1537h
            android.widget.ListAdapter r6 = r10.f1536g
            r0.setAdapter(r6)
            android.support.v7.widget.bw r0 = r10.f1537h
            android.widget.AdapterView$OnItemClickListener r6 = r10.f1553x
            r0.setOnItemClickListener(r6)
            android.support.v7.widget.bw r0 = r10.f1537h
            r0.setFocusable(r1)
            android.support.v7.widget.bw r0 = r10.f1537h
            r0.setFocusableInTouchMode(r1)
            android.support.v7.widget.bw r0 = r10.f1537h
            android.support.v7.widget.cj r6 = new android.support.v7.widget.cj
            r6.<init>(r10)
            r0.setOnItemSelectedListener(r6)
            android.support.v7.widget.bw r0 = r10.f1537h
            android.support.v7.widget.cm r6 = r10.f1526B
            r0.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r0 = r10.f1554y
            if (r0 == 0) goto L_0x005e
            android.support.v7.widget.bw r0 = r10.f1537h
            android.widget.AdapterView$OnItemSelectedListener r6 = r10.f1554y
            r0.setOnItemSelectedListener(r6)
        L_0x005e:
            android.support.v7.widget.bw r0 = r10.f1537h
            android.view.View r7 = r10.f1548s
            if (r7 == 0) goto L_0x0196
            android.widget.LinearLayout r6 = new android.widget.LinearLayout
            r6.<init>(r5)
            r6.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r5.<init>(r3, r2, r8)
            int r8 = r10.f1549t
            switch(r8) {
                case 0: goto L_0x0102;
                case 1: goto L_0x00fb;
                default: goto L_0x0078;
            }
        L_0x0078:
            java.lang.String r0 = "ListPopupWindow"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "Invalid hint position "
            java.lang.StringBuilder r5 = r5.append(r8)
            int r8 = r10.f1549t
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
        L_0x0092:
            int r0 = r10.f1539j
            if (r0 < 0) goto L_0x0109
            int r0 = r10.f1539j
            r5 = r0
            r0 = r4
        L_0x009a:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            r7.measure(r0, r2)
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r7.getMeasuredHeight()
            int r7 = r0.topMargin
            int r5 = r5 + r7
            int r0 = r0.bottomMargin
            int r0 = r0 + r5
            r5 = r6
        L_0x00b2:
            android.widget.PopupWindow r6 = r10.f1534c
            r6.setContentView(r5)
            r6 = r0
        L_0x00b8:
            android.widget.PopupWindow r0 = r10.f1534c
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x012a
            android.graphics.Rect r5 = r10.f1530F
            r0.getPadding(r5)
            android.graphics.Rect r0 = r10.f1530F
            int r0 = r0.top
            android.graphics.Rect r5 = r10.f1530F
            int r5 = r5.bottom
            int r0 = r0 + r5
            boolean r5 = r10.f1543n
            if (r5 != 0) goto L_0x0190
            android.graphics.Rect r5 = r10.f1530F
            int r5 = r5.top
            int r5 = -r5
            r10.f1541l = r5
            r7 = r0
        L_0x00da:
            android.widget.PopupWindow r0 = r10.f1534c
            int r0 = r0.getInputMethodMode()
            r5 = 2
            if (r0 != r5) goto L_0x0131
        L_0x00e3:
            android.view.View r0 = r10.mo3184i()
            int r5 = r10.f1541l
            int r5 = r10.m2899a(r0, r5, r1)
            boolean r0 = r10.f1546q
            if (r0 != 0) goto L_0x00f5
            int r0 = r10.f1538i
            if (r0 != r3) goto L_0x0133
        L_0x00f5:
            int r0 = r5 + r7
        L_0x00f7:
            return r0
        L_0x00f8:
            r0 = r2
            goto L_0x0019
        L_0x00fb:
            r6.addView(r0, r5)
            r6.addView(r7)
            goto L_0x0092
        L_0x0102:
            r6.addView(r7)
            r6.addView(r0, r5)
            goto L_0x0092
        L_0x0109:
            r0 = r2
            r5 = r2
            goto L_0x009a
        L_0x010c:
            android.widget.PopupWindow r0 = r10.f1534c
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r5 = r10.f1548s
            if (r5 == 0) goto L_0x0193
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r5.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r0 = r0 + r5
            r6 = r0
            goto L_0x00b8
        L_0x012a:
            android.graphics.Rect r0 = r10.f1530F
            r0.setEmpty()
            r7 = r2
            goto L_0x00da
        L_0x0131:
            r1 = r2
            goto L_0x00e3
        L_0x0133:
            int r0 = r10.f1539j
            switch(r0) {
                case -2: goto L_0x015a;
                case -1: goto L_0x0175;
                default: goto L_0x0138;
            }
        L_0x0138:
            int r0 = r10.f1539j
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
        L_0x013e:
            android.support.v7.widget.bw r0 = r10.f1537h
            int r4 = r5 - r6
            r5 = r3
            int r0 = r0.mo3204a(r1, r2, r3, r4, r5)
            if (r0 <= 0) goto L_0x0158
            android.support.v7.widget.bw r1 = r10.f1537h
            int r1 = r1.getPaddingTop()
            android.support.v7.widget.bw r2 = r10.f1537h
            int r2 = r2.getPaddingBottom()
            int r1 = r1 + r2
            int r1 = r1 + r7
            int r6 = r6 + r1
        L_0x0158:
            int r0 = r0 + r6
            goto L_0x00f7
        L_0x015a:
            android.content.Context r0 = r10.f1535f
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.f1530F
            int r1 = r1.left
            android.graphics.Rect r8 = r10.f1530F
            int r8 = r8.right
            int r1 = r1 + r8
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L_0x013e
        L_0x0175:
            android.content.Context r0 = r10.f1535f
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.f1530F
            int r1 = r1.left
            android.graphics.Rect r4 = r10.f1530F
            int r4 = r4.right
            int r1 = r1 + r4
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
            goto L_0x013e
        L_0x0190:
            r7 = r0
            goto L_0x00da
        L_0x0193:
            r6 = r2
            goto L_0x00b8
        L_0x0196:
            r5 = r0
            r0 = r2
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0636cg.mo3068f():int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0625bw mo3168a(Context context, boolean z) {
        return new C0625bw(context, z);
    }

    /* renamed from: a */
    public void mo2362a() {
        int i;
        boolean z = true;
        boolean z2 = false;
        int i2 = -1;
        int f = mo3068f();
        boolean n = mo3190n();
        C0377at.m1543a(this.f1534c, this.f1542m);
        if (this.f1534c.isShowing()) {
            int width = this.f1539j == -1 ? -1 : this.f1539j == -2 ? mo3184i().getWidth() : this.f1539j;
            if (this.f1538i == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.f1534c.setWidth(this.f1539j == -1 ? -1 : 0);
                    this.f1534c.setHeight(0);
                    i = f;
                } else {
                    this.f1534c.setWidth(this.f1539j == -1 ? -1 : 0);
                    this.f1534c.setHeight(-1);
                    i = f;
                }
            } else {
                i = this.f1538i == -2 ? f : this.f1538i;
            }
            PopupWindow popupWindow = this.f1534c;
            if (!this.f1547r && !this.f1546q) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            PopupWindow popupWindow2 = this.f1534c;
            View i3 = mo3184i();
            int i4 = this.f1540k;
            int i5 = this.f1541l;
            if (width < 0) {
                width = -1;
            }
            if (i >= 0) {
                i2 = i;
            }
            popupWindow2.update(i3, i4, i5, width, i2);
            return;
        }
        int width2 = this.f1539j == -1 ? -1 : this.f1539j == -2 ? mo3184i().getWidth() : this.f1539j;
        if (this.f1538i == -1) {
            f = -1;
        } else if (this.f1538i != -2) {
            f = this.f1538i;
        }
        this.f1534c.setWidth(width2);
        this.f1534c.setHeight(f);
        mo3220b(true);
        PopupWindow popupWindow3 = this.f1534c;
        if (this.f1547r || this.f1546q) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.f1534c.setTouchInterceptor(this.f1525A);
        if (f1524e != null) {
            try {
                f1524e.invoke(this.f1534c, new Object[]{this.f1531G});
            } catch (Exception e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        C0377at.m1544a(this.f1534c, mo3184i(), this.f1540k, this.f1541l, this.f1545p);
        this.f1537h.setSelection(-1);
        if (!this.f1532H || this.f1537h.isInTouchMode()) {
            mo3189m();
        }
        if (!this.f1532H) {
            this.f1529E.post(this.f1527C);
        }
    }

    /* renamed from: a */
    public void mo3169a(int i) {
        this.f1549t = i;
    }

    /* renamed from: a */
    public void mo3170a(Rect rect) {
        this.f1531G = rect;
    }

    /* renamed from: a */
    public void mo3171a(Drawable drawable) {
        this.f1534c.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void mo3172a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1553x = onItemClickListener;
    }

    /* renamed from: a */
    public void mo3065a(ListAdapter listAdapter) {
        if (this.f1550u == null) {
            this.f1550u = new C0641cl(this, (C0637ch) null);
        } else if (this.f1536g != null) {
            this.f1536g.unregisterDataSetObserver(this.f1550u);
        }
        this.f1536g = listAdapter;
        if (this.f1536g != null) {
            listAdapter.registerDataSetObserver(this.f1550u);
        }
        if (this.f1537h != null) {
            this.f1537h.setAdapter(this.f1536g);
        }
    }

    /* renamed from: a */
    public void mo3173a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1534c.setOnDismissListener(onDismissListener);
    }

    /* renamed from: a */
    public void mo3174a(boolean z) {
        this.f1532H = z;
        this.f1534c.setFocusable(z);
    }

    /* renamed from: b */
    public void mo3175b(int i) {
        this.f1534c.setAnimationStyle(i);
    }

    /* renamed from: c */
    public void mo2363c() {
        this.f1534c.dismiss();
        mo3067b();
        this.f1534c.setContentView((View) null);
        this.f1537h = null;
        this.f1529E.removeCallbacks(this.f1555z);
    }

    /* renamed from: c */
    public void mo3176c(int i) {
        this.f1540k = i;
    }

    /* renamed from: d */
    public void mo3177d(int i) {
        this.f1541l = i;
        this.f1543n = true;
    }

    /* renamed from: d */
    public boolean mo2364d() {
        return this.f1534c.isShowing();
    }

    /* renamed from: e */
    public ListView mo2365e() {
        return this.f1537h;
    }

    /* renamed from: e */
    public void mo3178e(int i) {
        this.f1545p = i;
    }

    /* renamed from: f */
    public void mo3179f(int i) {
        this.f1539j = i;
    }

    /* renamed from: g */
    public void mo3180g(int i) {
        Drawable background = this.f1534c.getBackground();
        if (background != null) {
            background.getPadding(this.f1530F);
            this.f1539j = this.f1530F.left + this.f1530F.right + i;
            return;
        }
        mo3179f(i);
    }

    /* renamed from: g */
    public boolean mo3181g() {
        return this.f1532H;
    }

    /* renamed from: h */
    public Drawable mo3182h() {
        return this.f1534c.getBackground();
    }

    /* renamed from: h */
    public void mo3183h(int i) {
        this.f1534c.setInputMethodMode(i);
    }

    /* renamed from: i */
    public View mo3184i() {
        return this.f1551v;
    }

    /* renamed from: i */
    public void mo3185i(int i) {
        C0625bw bwVar = this.f1537h;
        if (mo2364d() && bwVar != null) {
            bwVar.setListSelectionHidden(false);
            bwVar.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && bwVar.getChoiceMode() != 0) {
                bwVar.setItemChecked(i, true);
            }
        }
    }

    /* renamed from: j */
    public int mo3186j() {
        return this.f1540k;
    }

    /* renamed from: k */
    public int mo3187k() {
        if (!this.f1543n) {
            return 0;
        }
        return this.f1541l;
    }

    /* renamed from: l */
    public int mo3188l() {
        return this.f1539j;
    }

    /* renamed from: m */
    public void mo3189m() {
        C0625bw bwVar = this.f1537h;
        if (bwVar != null) {
            bwVar.setListSelectionHidden(true);
            bwVar.requestLayout();
        }
    }

    /* renamed from: n */
    public boolean mo3190n() {
        return this.f1534c.getInputMethodMode() == 2;
    }

    public void setAnchorView(View view) {
        this.f1551v = view;
    }

    public void setPromptView(View view) {
        boolean d = mo2364d();
        if (d) {
            mo3067b();
        }
        this.f1548s = view;
        if (d) {
            mo2362a();
        }
    }
}
