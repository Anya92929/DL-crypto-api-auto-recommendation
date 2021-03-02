package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p009v4.view.C0209an;
import android.support.p009v4.view.C0214as;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0347q;
import android.support.p021v7.p022a.C0453b;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0528i;
import android.support.p021v7.view.menu.C0538ae;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.support.p021v7.view.menu.C0566s;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.Toolbar */
public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private int f1299A;

    /* renamed from: B */
    private boolean f1300B;

    /* renamed from: C */
    private boolean f1301C;

    /* renamed from: D */
    private final ArrayList f1302D;

    /* renamed from: E */
    private final ArrayList f1303E;

    /* renamed from: F */
    private final int[] f1304F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C0676dt f1305G;

    /* renamed from: H */
    private final C0703y f1306H;

    /* renamed from: I */
    private C0678dv f1307I;

    /* renamed from: J */
    private C0689k f1308J;

    /* renamed from: K */
    private C0674dr f1309K;

    /* renamed from: L */
    private C0539af f1310L;

    /* renamed from: M */
    private C0563p f1311M;

    /* renamed from: N */
    private boolean f1312N;

    /* renamed from: O */
    private final Runnable f1313O;

    /* renamed from: P */
    private final C0591ap f1314P;

    /* renamed from: a */
    View f1315a;

    /* renamed from: b */
    private ActionMenuView f1316b;

    /* renamed from: c */
    private TextView f1317c;

    /* renamed from: d */
    private TextView f1318d;

    /* renamed from: e */
    private ImageButton f1319e;

    /* renamed from: f */
    private ImageView f1320f;

    /* renamed from: g */
    private Drawable f1321g;

    /* renamed from: h */
    private CharSequence f1322h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ImageButton f1323i;

    /* renamed from: j */
    private Context f1324j;

    /* renamed from: k */
    private int f1325k;

    /* renamed from: l */
    private int f1326l;

    /* renamed from: m */
    private int f1327m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f1328n;

    /* renamed from: o */
    private int f1329o;

    /* renamed from: p */
    private int f1330p;

    /* renamed from: q */
    private int f1331q;

    /* renamed from: r */
    private int f1332r;

    /* renamed from: s */
    private int f1333s;

    /* renamed from: t */
    private final C0651cv f1334t;

    /* renamed from: u */
    private int f1335u;

    /* renamed from: v */
    private int f1336v;

    /* renamed from: w */
    private int f1337w;

    /* renamed from: x */
    private CharSequence f1338x;

    /* renamed from: y */
    private CharSequence f1339y;

    /* renamed from: z */
    private int f1340z;

    /* renamed from: android.support.v7.widget.Toolbar$SavedState */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C0677du();

        /* renamed from: a */
        int f1341a;

        /* renamed from: b */
        boolean f1342b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1341a = parcel.readInt();
            this.f1342b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1341a);
            parcel.writeInt(this.f1342b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1334t = new C0651cv();
        this.f1337w = 8388627;
        this.f1302D = new ArrayList();
        this.f1303E = new ArrayList();
        this.f1304F = new int[2];
        this.f1306H = new C0671do(this);
        this.f1313O = new C0672dp(this);
        C0670dn a = C0670dn.m3014a(getContext(), attributeSet, C0515k.Toolbar, i, 0);
        this.f1326l = a.mo3331g(C0515k.Toolbar_titleTextAppearance, 0);
        this.f1327m = a.mo3331g(C0515k.Toolbar_subtitleTextAppearance, 0);
        this.f1337w = a.mo3323c(C0515k.Toolbar_android_gravity, this.f1337w);
        this.f1328n = a.mo3323c(C0515k.Toolbar_buttonGravity, 48);
        int d = a.mo3325d(C0515k.Toolbar_titleMargin, 0);
        d = a.mo3332g(C0515k.Toolbar_titleMargins) ? a.mo3325d(C0515k.Toolbar_titleMargins, d) : d;
        this.f1333s = d;
        this.f1332r = d;
        this.f1331q = d;
        this.f1330p = d;
        int d2 = a.mo3325d(C0515k.Toolbar_titleMarginStart, -1);
        if (d2 >= 0) {
            this.f1330p = d2;
        }
        int d3 = a.mo3325d(C0515k.Toolbar_titleMarginEnd, -1);
        if (d3 >= 0) {
            this.f1331q = d3;
        }
        int d4 = a.mo3325d(C0515k.Toolbar_titleMarginTop, -1);
        if (d4 >= 0) {
            this.f1332r = d4;
        }
        int d5 = a.mo3325d(C0515k.Toolbar_titleMarginBottom, -1);
        if (d5 >= 0) {
            this.f1333s = d5;
        }
        this.f1329o = a.mo3327e(C0515k.Toolbar_maxButtonHeight, -1);
        int d6 = a.mo3325d(C0515k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d7 = a.mo3325d(C0515k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f1334t.mo3272b(a.mo3327e(C0515k.Toolbar_contentInsetLeft, 0), a.mo3327e(C0515k.Toolbar_contentInsetRight, 0));
        if (!(d6 == Integer.MIN_VALUE && d7 == Integer.MIN_VALUE)) {
            this.f1334t.mo3269a(d6, d7);
        }
        this.f1335u = a.mo3325d(C0515k.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1336v = a.mo3325d(C0515k.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1321g = a.mo3318a(C0515k.Toolbar_collapseIcon);
        this.f1322h = a.mo3324c(C0515k.Toolbar_collapseContentDescription);
        CharSequence c = a.mo3324c(C0515k.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        CharSequence c2 = a.mo3324c(C0515k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c2)) {
            setSubtitle(c2);
        }
        this.f1324j = getContext();
        setPopupTheme(a.mo3331g(C0515k.Toolbar_popupTheme, 0));
        Drawable a2 = a.mo3318a(C0515k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        CharSequence c3 = a.mo3324c(C0515k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c3)) {
            setNavigationContentDescription(c3);
        }
        Drawable a3 = a.mo3318a(C0515k.Toolbar_logo);
        if (a3 != null) {
            setLogo(a3);
        }
        CharSequence c4 = a.mo3324c(C0515k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c4)) {
            setLogoDescription(c4);
        }
        if (a.mo3332g(C0515k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.mo3321b(C0515k.Toolbar_titleTextColor, -1));
        }
        if (a.mo3332g(C0515k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.mo3321b(C0515k.Toolbar_subtitleTextColor, -1));
        }
        a.mo3319a();
        this.f1314P = C0591ap.m2736a();
    }

    /* renamed from: a */
    private int m2641a(int i) {
        int i2 = i & C0515k.AppCompatTheme_spinnerStyle;
        switch (i2) {
            case 16:
            case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
            case C0515k.AppCompatTheme_panelMenuListWidth:
                return i2;
            default:
                return this.f1337w & C0515k.AppCompatTheme_spinnerStyle;
        }
    }

    /* renamed from: a */
    private int m2642a(View view, int i) {
        int max;
        C0675ds dsVar = (C0675ds) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m2641a(dsVar.f643a)) {
            case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                return getPaddingTop() - i2;
            case C0515k.AppCompatTheme_panelMenuListWidth:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - dsVar.bottomMargin) - i2;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < dsVar.topMargin) {
                    max = dsVar.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    max = i4 < dsVar.bottomMargin ? Math.max(0, i3 - (dsVar.bottomMargin - i4)) : i3;
                }
                return max + paddingTop;
        }
    }

    /* renamed from: a */
    private int m2643a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: a */
    private int m2644a(View view, int i, int[] iArr, int i2) {
        C0675ds dsVar = (C0675ds) view.getLayoutParams();
        int i3 = dsVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int a = m2642a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a, max + measuredWidth, view.getMeasuredHeight() + a);
        return dsVar.rightMargin + measuredWidth + max;
    }

    /* renamed from: a */
    private int m2645a(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0675ds dsVar = (C0675ds) view.getLayoutParams();
            int i7 = dsVar.leftMargin - i6;
            int i8 = dsVar.rightMargin - i5;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            i6 = Math.max(0, -i7);
            i5 = Math.max(0, -i8);
            i3++;
            i4 += view.getMeasuredWidth() + max + max2;
        }
        return i4;
    }

    /* renamed from: a */
    private void m2647a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    private void m2648a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C0675ds i = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (C0675ds) layoutParams;
        i.f1658b = 1;
        if (!z || this.f1315a == null) {
            addView(view, i);
            return;
        }
        view.setLayoutParams(i);
        this.f1303E.add(view);
    }

    /* renamed from: a */
    private void m2649a(List list, int i) {
        boolean z = true;
        if (C0247by.m909d(this) != 1) {
            z = false;
        }
        int childCount = getChildCount();
        int a = C0347q.m1334a(i, C0247by.m909d(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                C0675ds dsVar = (C0675ds) childAt.getLayoutParams();
                if (dsVar.f1658b == 0 && m2650a(childAt) && m2651b(dsVar.f643a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            C0675ds dsVar2 = (C0675ds) childAt2.getLayoutParams();
            if (dsVar2.f1658b == 0 && m2650a(childAt2) && m2651b(dsVar2.f643a) == a) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: a */
    private boolean m2650a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: b */
    private int m2651b(int i) {
        int d = C0247by.m909d(this);
        int a = C0347q.m1334a(i, d) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return d == 1 ? 5 : 3;
        }
    }

    /* renamed from: b */
    private int m2652b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C0209an.m775b(marginLayoutParams) + C0209an.m774a(marginLayoutParams);
    }

    /* renamed from: b */
    private int m2653b(View view, int i, int[] iArr, int i2) {
        C0675ds dsVar = (C0675ds) view.getLayoutParams();
        int i3 = dsVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a = m2642a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a, max, view.getMeasuredHeight() + a);
        return max - (dsVar.leftMargin + measuredWidth);
    }

    /* renamed from: c */
    private int m2655c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    /* renamed from: d */
    private boolean m2658d(View view) {
        return view.getParent() == this || this.f1303E.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0528i(getContext());
    }

    /* renamed from: l */
    private void m2659l() {
        if (this.f1320f == null) {
            this.f1320f = new ImageView(getContext());
        }
    }

    /* renamed from: m */
    private void m2660m() {
        m2661n();
        if (this.f1316b.mo2715d() == null) {
            C0562o oVar = (C0562o) this.f1316b.getMenu();
            if (this.f1309K == null) {
                this.f1309K = new C0674dr(this, (C0671do) null);
            }
            this.f1316b.setExpandedActionViewsExclusive(true);
            oVar.mo2450a((C0538ae) this.f1309K, this.f1324j);
        }
    }

    /* renamed from: n */
    private void m2661n() {
        if (this.f1316b == null) {
            this.f1316b = new ActionMenuView(getContext());
            this.f1316b.setPopupTheme(this.f1325k);
            this.f1316b.setOnMenuItemClickListener(this.f1306H);
            this.f1316b.mo2707a(this.f1310L, this.f1311M);
            C0675ds i = generateDefaultLayoutParams();
            i.f643a = 8388613 | (this.f1328n & C0515k.AppCompatTheme_spinnerStyle);
            this.f1316b.setLayoutParams(i);
            m2648a((View) this.f1316b, false);
        }
    }

    /* renamed from: o */
    private void m2662o() {
        if (this.f1319e == null) {
            this.f1319e = new ImageButton(getContext(), (AttributeSet) null, C0506b.toolbarNavigationButtonStyle);
            C0675ds i = generateDefaultLayoutParams();
            i.f643a = 8388611 | (this.f1328n & C0515k.AppCompatTheme_spinnerStyle);
            this.f1319e.setLayoutParams(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m2663p() {
        if (this.f1323i == null) {
            this.f1323i = new ImageButton(getContext(), (AttributeSet) null, C0506b.toolbarNavigationButtonStyle);
            this.f1323i.setImageDrawable(this.f1321g);
            this.f1323i.setContentDescription(this.f1322h);
            C0675ds i = generateDefaultLayoutParams();
            i.f643a = 8388611 | (this.f1328n & C0515k.AppCompatTheme_spinnerStyle);
            i.f1658b = 2;
            this.f1323i.setLayoutParams(i);
            this.f1323i.setOnClickListener(new C0673dq(this));
        }
    }

    /* renamed from: q */
    private void m2664q() {
        removeCallbacks(this.f1313O);
        post(this.f1313O);
    }

    /* renamed from: r */
    private boolean m2665r() {
        if (!this.f1312N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2650a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public C0675ds generateLayoutParams(AttributeSet attributeSet) {
        return new C0675ds(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0675ds generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0675ds ? new C0675ds((C0675ds) layoutParams) : layoutParams instanceof C0453b ? new C0675ds((C0453b) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0675ds((ViewGroup.MarginLayoutParams) layoutParams) : new C0675ds(layoutParams);
    }

    /* renamed from: a */
    public void mo2820a(int i, int i2) {
        this.f1334t.mo3269a(i, i2);
    }

    /* renamed from: a */
    public void mo2821a(Context context, int i) {
        this.f1326l = i;
        if (this.f1317c != null) {
            this.f1317c.setTextAppearance(context, i);
        }
    }

    /* renamed from: a */
    public void mo2822a(C0539af afVar, C0563p pVar) {
        this.f1310L = afVar;
        this.f1311M = pVar;
        if (this.f1316b != null) {
            this.f1316b.mo2707a(afVar, pVar);
        }
    }

    /* renamed from: a */
    public void mo2823a(C0562o oVar, C0689k kVar) {
        if (oVar != null || this.f1316b != null) {
            m2661n();
            C0562o d = this.f1316b.mo2715d();
            if (d != oVar) {
                if (d != null) {
                    d.mo2468b((C0538ae) this.f1308J);
                    d.mo2468b((C0538ae) this.f1309K);
                }
                if (this.f1309K == null) {
                    this.f1309K = new C0674dr(this, (C0671do) null);
                }
                kVar.mo3357d(true);
                if (oVar != null) {
                    oVar.mo2450a((C0538ae) kVar, this.f1324j);
                    oVar.mo2450a((C0538ae) this.f1309K, this.f1324j);
                } else {
                    kVar.mo2308a(this.f1324j, (C0562o) null);
                    this.f1309K.mo2308a(this.f1324j, (C0562o) null);
                    kVar.mo2336b(true);
                    this.f1309K.mo2336b(true);
                }
                this.f1316b.setPopupTheme(this.f1325k);
                this.f1316b.setPresenter(kVar);
                this.f1308J = kVar;
            }
        }
    }

    /* renamed from: a */
    public boolean mo2824a() {
        return getVisibility() == 0 && this.f1316b != null && this.f1316b.mo2708a();
    }

    /* renamed from: b */
    public void mo2825b(Context context, int i) {
        this.f1327m = i;
        if (this.f1318d != null) {
            this.f1318d.setTextAppearance(context, i);
        }
    }

    /* renamed from: b */
    public boolean mo2826b() {
        return this.f1316b != null && this.f1316b.mo2719g();
    }

    /* renamed from: c */
    public boolean mo2827c() {
        return this.f1316b != null && this.f1316b.mo2727h();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0675ds);
    }

    /* renamed from: d */
    public boolean mo2829d() {
        return this.f1316b != null && this.f1316b.mo2717e();
    }

    /* renamed from: e */
    public boolean mo2830e() {
        return this.f1316b != null && this.f1316b.mo2718f();
    }

    /* renamed from: f */
    public void mo2831f() {
        if (this.f1316b != null) {
            this.f1316b.mo2728i();
        }
    }

    /* renamed from: g */
    public boolean mo2832g() {
        return (this.f1309K == null || this.f1309K.f1656b == null) ? false : true;
    }

    public int getContentInsetEnd() {
        return this.f1334t.mo3274d();
    }

    public int getContentInsetEndWithActions() {
        return this.f1336v != Integer.MIN_VALUE ? this.f1336v : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.f1334t.mo3268a();
    }

    public int getContentInsetRight() {
        return this.f1334t.mo3271b();
    }

    public int getContentInsetStart() {
        return this.f1334t.mo3273c();
    }

    public int getContentInsetStartWithNavigation() {
        return this.f1335u != Integer.MIN_VALUE ? this.f1335u : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z;
        if (this.f1316b != null) {
            C0562o d = this.f1316b.mo2715d();
            z = d != null && d.hasVisibleItems();
        } else {
            z = false;
        }
        return z ? Math.max(getContentInsetEnd(), Math.max(this.f1336v, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1335u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        if (this.f1320f != null) {
            return this.f1320f.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.f1320f != null) {
            return this.f1320f.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m2660m();
        return this.f1316b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.f1319e != null) {
            return this.f1319e.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.f1319e != null) {
            return this.f1319e.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        m2660m();
        return this.f1316b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f1325k;
    }

    public CharSequence getSubtitle() {
        return this.f1339y;
    }

    public CharSequence getTitle() {
        return this.f1338x;
    }

    public int getTitleMarginBottom() {
        return this.f1333s;
    }

    public int getTitleMarginEnd() {
        return this.f1331q;
    }

    public int getTitleMarginStart() {
        return this.f1330p;
    }

    public int getTitleMarginTop() {
        return this.f1332r;
    }

    public C0623bu getWrapper() {
        if (this.f1307I == null) {
            this.f1307I = new C0678dv(this, true);
        }
        return this.f1307I;
    }

    /* renamed from: h */
    public void mo2860h() {
        C0566s sVar = this.f1309K == null ? null : this.f1309K.f1656b;
        if (sVar != null) {
            sVar.collapseActionView();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C0675ds generateDefaultLayoutParams() {
        return new C0675ds(-2, -2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo2862j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0675ds) childAt.getLayoutParams()).f1658b == 2 || childAt == this.f1316b)) {
                removeViewAt(childCount);
                this.f1303E.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo2863k() {
        for (int size = this.f1303E.size() - 1; size >= 0; size--) {
            addView((View) this.f1303E.get(size));
        }
        this.f1303E.clear();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1313O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0223ba.m828a(motionEvent);
        if (a == 9) {
            this.f1301C = false;
        }
        if (!this.f1301C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1301C = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1301C = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int max;
        boolean z2 = C0247by.m909d(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = width - paddingRight;
        int[] iArr = this.f1304F;
        iArr[1] = 0;
        iArr[0] = 0;
        int i16 = C0247by.m916i(this);
        if (!m2650a((View) this.f1319e)) {
            i5 = paddingLeft;
        } else if (z2) {
            i15 = m2653b(this.f1319e, i15, iArr, i16);
            i5 = paddingLeft;
        } else {
            i5 = m2644a(this.f1319e, paddingLeft, iArr, i16);
        }
        if (m2650a((View) this.f1323i)) {
            if (z2) {
                i15 = m2653b(this.f1323i, i15, iArr, i16);
            } else {
                i5 = m2644a(this.f1323i, i5, iArr, i16);
            }
        }
        if (m2650a((View) this.f1316b)) {
            if (z2) {
                i5 = m2644a(this.f1316b, i5, iArr, i16);
            } else {
                i15 = m2653b(this.f1316b, i15, iArr, i16);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i15));
        int max2 = Math.max(i5, currentContentInsetLeft);
        int min = Math.min(i15, (width - paddingRight) - currentContentInsetRight);
        if (m2650a(this.f1315a)) {
            if (z2) {
                min = m2653b(this.f1315a, min, iArr, i16);
            } else {
                max2 = m2644a(this.f1315a, max2, iArr, i16);
            }
        }
        if (!m2650a((View) this.f1320f)) {
            i6 = min;
            i7 = max2;
        } else if (z2) {
            i6 = m2653b(this.f1320f, min, iArr, i16);
            i7 = max2;
        } else {
            i6 = min;
            i7 = m2644a(this.f1320f, max2, iArr, i16);
        }
        boolean a = m2650a((View) this.f1317c);
        boolean a2 = m2650a((View) this.f1318d);
        int i17 = 0;
        if (a) {
            C0675ds dsVar = (C0675ds) this.f1317c.getLayoutParams();
            i17 = 0 + dsVar.bottomMargin + dsVar.topMargin + this.f1317c.getMeasuredHeight();
        }
        if (a2) {
            C0675ds dsVar2 = (C0675ds) this.f1318d.getLayoutParams();
            i8 = dsVar2.bottomMargin + dsVar2.topMargin + this.f1318d.getMeasuredHeight() + i17;
        } else {
            i8 = i17;
        }
        if (a || a2) {
            TextView textView = a ? this.f1317c : this.f1318d;
            TextView textView2 = a2 ? this.f1318d : this.f1317c;
            C0675ds dsVar3 = (C0675ds) textView.getLayoutParams();
            C0675ds dsVar4 = (C0675ds) textView2.getLayoutParams();
            boolean z3 = (a && this.f1317c.getMeasuredWidth() > 0) || (a2 && this.f1318d.getMeasuredWidth() > 0);
            switch (this.f1337w & C0515k.AppCompatTheme_spinnerStyle) {
                case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                    i9 = dsVar3.topMargin + getPaddingTop() + this.f1332r;
                    break;
                case C0515k.AppCompatTheme_panelMenuListWidth:
                    i9 = (((height - paddingBottom) - dsVar4.bottomMargin) - this.f1333s) - i8;
                    break;
                default:
                    int i18 = (((height - paddingTop) - paddingBottom) - i8) / 2;
                    if (i18 < dsVar3.topMargin + this.f1332r) {
                        max = dsVar3.topMargin + this.f1332r;
                    } else {
                        int i19 = (((height - paddingBottom) - i8) - i18) - paddingTop;
                        max = i19 < dsVar3.bottomMargin + this.f1333s ? Math.max(0, i18 - ((dsVar4.bottomMargin + this.f1333s) - i19)) : i18;
                    }
                    i9 = paddingTop + max;
                    break;
            }
            if (z2) {
                int i20 = (z3 ? this.f1330p : 0) - iArr[1];
                int max3 = i6 - Math.max(0, i20);
                iArr[1] = Math.max(0, -i20);
                if (a) {
                    int measuredWidth = max3 - this.f1317c.getMeasuredWidth();
                    int measuredHeight = this.f1317c.getMeasuredHeight() + i9;
                    this.f1317c.layout(measuredWidth, i9, max3, measuredHeight);
                    int i21 = measuredWidth - this.f1331q;
                    i9 = measuredHeight + ((C0675ds) this.f1317c.getLayoutParams()).bottomMargin;
                    i13 = i21;
                } else {
                    i13 = max3;
                }
                if (a2) {
                    C0675ds dsVar5 = (C0675ds) this.f1318d.getLayoutParams();
                    int i22 = dsVar5.topMargin + i9;
                    int measuredHeight2 = this.f1318d.getMeasuredHeight() + i22;
                    this.f1318d.layout(max3 - this.f1318d.getMeasuredWidth(), i22, max3, measuredHeight2);
                    int i23 = dsVar5.bottomMargin + measuredHeight2;
                    i14 = max3 - this.f1331q;
                } else {
                    i14 = max3;
                }
                i6 = z3 ? Math.min(i13, i14) : max3;
            } else {
                int i24 = (z3 ? this.f1330p : 0) - iArr[0];
                i7 += Math.max(0, i24);
                iArr[0] = Math.max(0, -i24);
                if (a) {
                    int measuredWidth2 = this.f1317c.getMeasuredWidth() + i7;
                    int measuredHeight3 = this.f1317c.getMeasuredHeight() + i9;
                    this.f1317c.layout(i7, i9, measuredWidth2, measuredHeight3);
                    int i25 = ((C0675ds) this.f1317c.getLayoutParams()).bottomMargin + measuredHeight3;
                    i10 = measuredWidth2 + this.f1331q;
                    i11 = i25;
                } else {
                    i10 = i7;
                    i11 = i9;
                }
                if (a2) {
                    C0675ds dsVar6 = (C0675ds) this.f1318d.getLayoutParams();
                    int i26 = i11 + dsVar6.topMargin;
                    int measuredWidth3 = this.f1318d.getMeasuredWidth() + i7;
                    int measuredHeight4 = this.f1318d.getMeasuredHeight() + i26;
                    this.f1318d.layout(i7, i26, measuredWidth3, measuredHeight4);
                    int i27 = dsVar6.bottomMargin + measuredHeight4;
                    i12 = this.f1331q + measuredWidth3;
                } else {
                    i12 = i7;
                }
                if (z3) {
                    i7 = Math.max(i10, i12);
                }
            }
        }
        m2649a((List) this.f1302D, 3);
        int size = this.f1302D.size();
        int i28 = i7;
        for (int i29 = 0; i29 < size; i29++) {
            i28 = m2644a((View) this.f1302D.get(i29), i28, iArr, i16);
        }
        m2649a((List) this.f1302D, 5);
        int size2 = this.f1302D.size();
        for (int i30 = 0; i30 < size2; i30++) {
            i6 = m2653b((View) this.f1302D.get(i30), i6, iArr, i16);
        }
        m2649a((List) this.f1302D, 1);
        int a3 = m2645a((List) this.f1302D, iArr);
        int i31 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (a3 / 2);
        int i32 = a3 + i31;
        if (i31 < i28) {
            i31 = i28;
        } else if (i32 > i6) {
            i31 -= i32 - i6;
        }
        int size3 = this.f1302D.size();
        int i33 = i31;
        for (int i34 = 0; i34 < size3; i34++) {
            i33 = m2644a((View) this.f1302D.get(i34), i33, iArr, i16);
        }
        this.f1302D.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1304F;
        if (C0682dz.m3095a(this)) {
            c = 0;
            c2 = 1;
        } else {
            c = 1;
            c2 = 0;
        }
        int i7 = 0;
        if (m2650a((View) this.f1319e)) {
            m2647a((View) this.f1319e, i, 0, i2, 0, this.f1329o);
            i7 = this.f1319e.getMeasuredWidth() + m2652b((View) this.f1319e);
            int max = Math.max(0, this.f1319e.getMeasuredHeight() + m2655c((View) this.f1319e));
            i6 = C0682dz.m3093a(0, C0247by.m914g(this.f1319e));
            i5 = max;
        }
        if (m2650a((View) this.f1323i)) {
            m2647a((View) this.f1323i, i, 0, i2, 0, this.f1329o);
            i7 = this.f1323i.getMeasuredWidth() + m2652b((View) this.f1323i);
            i5 = Math.max(i5, this.f1323i.getMeasuredHeight() + m2655c((View) this.f1323i));
            i6 = C0682dz.m3093a(i6, C0247by.m914g(this.f1323i));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[c2] = Math.max(0, currentContentInsetStart - i7);
        int i8 = 0;
        if (m2650a((View) this.f1316b)) {
            m2647a((View) this.f1316b, i, max2, i2, 0, this.f1329o);
            i8 = this.f1316b.getMeasuredWidth() + m2652b((View) this.f1316b);
            i5 = Math.max(i5, this.f1316b.getMeasuredHeight() + m2655c((View) this.f1316b));
            i6 = C0682dz.m3093a(i6, C0247by.m914g(this.f1316b));
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max2 + Math.max(currentContentInsetEnd, i8);
        iArr[c] = Math.max(0, currentContentInsetEnd - i8);
        if (m2650a(this.f1315a)) {
            max3 += m2643a(this.f1315a, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f1315a.getMeasuredHeight() + m2655c(this.f1315a));
            i6 = C0682dz.m3093a(i6, C0247by.m914g(this.f1315a));
        }
        if (m2650a((View) this.f1320f)) {
            max3 += m2643a((View) this.f1320f, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f1320f.getMeasuredHeight() + m2655c((View) this.f1320f));
            i6 = C0682dz.m3093a(i6, C0247by.m914g(this.f1320f));
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = i5;
        int i11 = i6;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (((C0675ds) childAt.getLayoutParams()).f1658b != 0) {
                i3 = i11;
                i4 = i10;
            } else if (!m2650a(childAt)) {
                i3 = i11;
                i4 = i10;
            } else {
                max3 += m2643a(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i10, childAt.getMeasuredHeight() + m2655c(childAt));
                i3 = C0682dz.m3093a(i11, C0247by.m914g(childAt));
                i4 = max4;
            }
            i9++;
            i11 = i3;
            i10 = i4;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = this.f1332r + this.f1333s;
        int i15 = this.f1330p + this.f1331q;
        if (m2650a((View) this.f1317c)) {
            m2643a((View) this.f1317c, i, max3 + i15, i2, i14, iArr);
            i12 = m2652b((View) this.f1317c) + this.f1317c.getMeasuredWidth();
            i13 = this.f1317c.getMeasuredHeight() + m2655c((View) this.f1317c);
            i11 = C0682dz.m3093a(i11, C0247by.m914g(this.f1317c));
        }
        if (m2650a((View) this.f1318d)) {
            i12 = Math.max(i12, m2643a((View) this.f1318d, i, max3 + i15, i2, i14 + i13, iArr));
            i13 += this.f1318d.getMeasuredHeight() + m2655c((View) this.f1318d);
            i11 = C0682dz.m3093a(i11, C0247by.m914g(this.f1318d));
        }
        int max5 = Math.max(i10, i13);
        int paddingLeft = i12 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int a = C0247by.m887a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i11);
        int a2 = C0247by.m887a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i11 << 16);
        if (m2665r()) {
            a2 = 0;
        }
        setMeasuredDimension(a, a2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        C0562o d = this.f1316b != null ? this.f1316b.mo2715d() : null;
        if (!(savedState.f1341a == 0 || this.f1309K == null || d == null || (findItem = d.findItem(savedState.f1341a)) == null)) {
            C0214as.m789b(findItem);
        }
        if (savedState.f1342b) {
            m2664q();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        C0651cv cvVar = this.f1334t;
        if (i != 1) {
            z = false;
        }
        cvVar.mo3270a(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f1309K == null || this.f1309K.f1656b == null)) {
            savedState.f1341a = this.f1309K.f1656b.getItemId();
        }
        savedState.f1342b = mo2826b();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0223ba.m828a(motionEvent);
        if (a == 0) {
            this.f1300B = false;
        }
        if (!this.f1300B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1300B = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1300B = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f1312N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1336v) {
            this.f1336v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1335u) {
            this.f1335u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(this.f1314P.mo2982a(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2659l();
            if (!m2658d((View) this.f1320f)) {
                m2648a((View) this.f1320f, true);
            }
        } else if (this.f1320f != null && m2658d((View) this.f1320f)) {
            removeView(this.f1320f);
            this.f1303E.remove(this.f1320f);
        }
        if (this.f1320f != null) {
            this.f1320f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2659l();
        }
        if (this.f1320f != null) {
            this.f1320f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2662o();
        }
        if (this.f1319e != null) {
            this.f1319e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1314P.mo2982a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2662o();
            if (!m2658d((View) this.f1319e)) {
                m2648a((View) this.f1319e, true);
            }
        } else if (this.f1319e != null && m2658d((View) this.f1319e)) {
            removeView(this.f1319e);
            this.f1303E.remove(this.f1319e);
        }
        if (this.f1319e != null) {
            this.f1319e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m2662o();
        this.f1319e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(C0676dt dtVar) {
        this.f1305G = dtVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        m2660m();
        this.f1316b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f1325k != i) {
            this.f1325k = i;
            if (i == 0) {
                this.f1324j = getContext();
            } else {
                this.f1324j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1318d == null) {
                Context context = getContext();
                this.f1318d = new TextView(context);
                this.f1318d.setSingleLine();
                this.f1318d.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f1327m != 0) {
                    this.f1318d.setTextAppearance(context, this.f1327m);
                }
                if (this.f1299A != 0) {
                    this.f1318d.setTextColor(this.f1299A);
                }
            }
            if (!m2658d((View) this.f1318d)) {
                m2648a((View) this.f1318d, true);
            }
        } else if (this.f1318d != null && m2658d((View) this.f1318d)) {
            removeView(this.f1318d);
            this.f1303E.remove(this.f1318d);
        }
        if (this.f1318d != null) {
            this.f1318d.setText(charSequence);
        }
        this.f1339y = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f1299A = i;
        if (this.f1318d != null) {
            this.f1318d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1317c == null) {
                Context context = getContext();
                this.f1317c = new TextView(context);
                this.f1317c.setSingleLine();
                this.f1317c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f1326l != 0) {
                    this.f1317c.setTextAppearance(context, this.f1326l);
                }
                if (this.f1340z != 0) {
                    this.f1317c.setTextColor(this.f1340z);
                }
            }
            if (!m2658d((View) this.f1317c)) {
                m2648a((View) this.f1317c, true);
            }
        } else if (this.f1317c != null && m2658d((View) this.f1317c)) {
            removeView(this.f1317c);
            this.f1303E.remove(this.f1317c);
        }
        if (this.f1317c != null) {
            this.f1317c.setText(charSequence);
        }
        this.f1338x = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.f1333s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f1331q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f1330p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f1332r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.f1340z = i;
        if (this.f1317c != null) {
            this.f1317c.setTextColor(i);
        }
    }
}
