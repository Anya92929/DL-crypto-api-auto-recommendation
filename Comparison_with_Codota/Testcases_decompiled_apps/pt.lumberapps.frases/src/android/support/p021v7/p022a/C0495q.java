package android.support.p021v7.p022a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.widget.NestedScrollView;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0515k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/* renamed from: android.support.v7.a.q */
class C0495q {

    /* renamed from: A */
    private TextView f776A;

    /* renamed from: B */
    private TextView f777B;

    /* renamed from: C */
    private View f778C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ListAdapter f779D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f780E = -1;

    /* renamed from: F */
    private int f781F;

    /* renamed from: G */
    private int f782G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f783H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f784I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public int f785J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f786K;

    /* renamed from: L */
    private int f787L = 0;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public Handler f788M;

    /* renamed from: N */
    private final View.OnClickListener f789N = new C0496r(this);

    /* renamed from: a */
    private final Context f790a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0462bi f791b;

    /* renamed from: c */
    private final Window f792c;

    /* renamed from: d */
    private CharSequence f793d;

    /* renamed from: e */
    private CharSequence f794e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ListView f795f;

    /* renamed from: g */
    private View f796g;

    /* renamed from: h */
    private int f797h;

    /* renamed from: i */
    private int f798i;

    /* renamed from: j */
    private int f799j;

    /* renamed from: k */
    private int f800k;

    /* renamed from: l */
    private int f801l;

    /* renamed from: m */
    private boolean f802m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Button f803n;

    /* renamed from: o */
    private CharSequence f804o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Message f805p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Button f806q;

    /* renamed from: r */
    private CharSequence f807r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Message f808s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Button f809t;

    /* renamed from: u */
    private CharSequence f810u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Message f811v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public NestedScrollView f812w;

    /* renamed from: x */
    private int f813x = 0;

    /* renamed from: y */
    private Drawable f814y;

    /* renamed from: z */
    private ImageView f815z;

    public C0495q(Context context, C0462bi biVar, Window window) {
        this.f790a = context;
        this.f791b = biVar;
        this.f792c = window;
        this.f788M = new C0429ac(biVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, C0515k.AlertDialog, C0506b.alertDialogStyle, 0);
        this.f781F = obtainStyledAttributes.getResourceId(C0515k.AlertDialog_android_layout, 0);
        this.f782G = obtainStyledAttributes.getResourceId(C0515k.AlertDialog_buttonPanelSideLayout, 0);
        this.f783H = obtainStyledAttributes.getResourceId(C0515k.AlertDialog_listLayout, 0);
        this.f784I = obtainStyledAttributes.getResourceId(C0515k.AlertDialog_multiChoiceItemLayout, 0);
        this.f785J = obtainStyledAttributes.getResourceId(C0515k.AlertDialog_singleChoiceItemLayout, 0);
        this.f786K = obtainStyledAttributes.getResourceId(C0515k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        biVar.mo2055a(1);
    }

    /* renamed from: a */
    private ViewGroup m2128a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    /* renamed from: a */
    private void m2133a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f796g != null ? this.f796g : this.f797h != 0 ? LayoutInflater.from(this.f790a).inflate(this.f797h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!z || !m2135a(inflate)) {
            this.f792c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f792c.findViewById(C0511g.custom);
            frameLayout.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f802m) {
                frameLayout.setPadding(this.f798i, this.f799j, this.f800k, this.f801l);
            }
            if (this.f795f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    private void m2134a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f792c.findViewById(C0511g.scrollIndicatorUp);
        View findViewById2 = this.f792c.findViewById(C0511g.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            C0247by.m891a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f794e != null) {
                this.f812w.setOnScrollChangeListener(new C0497s(this, findViewById, view2));
                this.f812w.post(new C0498t(this, findViewById, view2));
            } else if (this.f795f != null) {
                this.f795f.setOnScrollListener(new C0499u(this, findViewById, view2));
                this.f795f.post(new C0500v(this, findViewById, view2));
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m2135a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m2135a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private int m2136b() {
        return this.f782G == 0 ? this.f781F : this.f787L == 1 ? this.f782G : this.f781F;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2138b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(C0247by.m905b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!C0247by.m905b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: b */
    private void m2139b(ViewGroup viewGroup) {
        if (this.f778C != null) {
            viewGroup.addView(this.f778C, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f792c.findViewById(C0511g.title_template).setVisibility(8);
            return;
        }
        this.f815z = (ImageView) this.f792c.findViewById(16908294);
        if (!TextUtils.isEmpty(this.f793d)) {
            this.f776A = (TextView) this.f792c.findViewById(C0511g.alertTitle);
            this.f776A.setText(this.f793d);
            if (this.f813x != 0) {
                this.f815z.setImageResource(this.f813x);
            } else if (this.f814y != null) {
                this.f815z.setImageDrawable(this.f814y);
            } else {
                this.f776A.setPadding(this.f815z.getPaddingLeft(), this.f815z.getPaddingTop(), this.f815z.getPaddingRight(), this.f815z.getPaddingBottom());
                this.f815z.setVisibility(8);
            }
        } else {
            this.f792c.findViewById(C0511g.title_template).setVisibility(8);
            this.f815z.setVisibility(8);
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m2141c() {
        View findViewById;
        View findViewById2 = this.f792c.findViewById(C0511g.parentPanel);
        View findViewById3 = findViewById2.findViewById(C0511g.topPanel);
        View findViewById4 = findViewById2.findViewById(C0511g.contentPanel);
        View findViewById5 = findViewById2.findViewById(C0511g.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(C0511g.customPanel);
        m2133a(viewGroup);
        View findViewById6 = viewGroup.findViewById(C0511g.topPanel);
        View findViewById7 = viewGroup.findViewById(C0511g.contentPanel);
        View findViewById8 = viewGroup.findViewById(C0511g.buttonPanel);
        ViewGroup a = m2128a(findViewById6, findViewById3);
        ViewGroup a2 = m2128a(findViewById7, findViewById4);
        ViewGroup a3 = m2128a(findViewById8, findViewById5);
        m2142c(a2);
        m2144d(a3);
        m2139b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null || (findViewById = a2.findViewById(C0511g.textSpacerNoButtons)) == null)) {
            findViewById.setVisibility(0);
        }
        if (z2 && this.f812w != null) {
            this.f812w.setClipToPadding(true);
        }
        if (!z) {
            ViewGroup viewGroup2 = this.f795f != null ? this.f795f : this.f812w;
            if (viewGroup2 != null) {
                m2134a(a2, (View) viewGroup2, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f795f;
        if (listView != null && this.f779D != null) {
            listView.setAdapter(this.f779D);
            int i = this.f780E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    /* renamed from: c */
    private void m2142c(ViewGroup viewGroup) {
        this.f812w = (NestedScrollView) this.f792c.findViewById(C0511g.scrollView);
        this.f812w.setFocusable(false);
        this.f812w.setNestedScrollingEnabled(false);
        this.f777B = (TextView) viewGroup.findViewById(16908299);
        if (this.f777B != null) {
            if (this.f794e != null) {
                this.f777B.setText(this.f794e);
                return;
            }
            this.f777B.setVisibility(8);
            this.f812w.removeView(this.f777B);
            if (this.f795f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f812w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f812w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f795f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: d */
    private void m2144d(ViewGroup viewGroup) {
        boolean z;
        boolean z2 = true;
        this.f803n = (Button) viewGroup.findViewById(16908313);
        this.f803n.setOnClickListener(this.f789N);
        if (TextUtils.isEmpty(this.f804o)) {
            this.f803n.setVisibility(8);
            z = false;
        } else {
            this.f803n.setText(this.f804o);
            this.f803n.setVisibility(0);
            z = true;
        }
        this.f806q = (Button) viewGroup.findViewById(16908314);
        this.f806q.setOnClickListener(this.f789N);
        if (TextUtils.isEmpty(this.f807r)) {
            this.f806q.setVisibility(8);
        } else {
            this.f806q.setText(this.f807r);
            this.f806q.setVisibility(0);
            z |= true;
        }
        this.f809t = (Button) viewGroup.findViewById(16908315);
        this.f809t.setOnClickListener(this.f789N);
        if (TextUtils.isEmpty(this.f810u)) {
            this.f809t.setVisibility(8);
        } else {
            this.f809t.setText(this.f810u);
            this.f809t.setVisibility(0);
            z |= true;
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo2116a() {
        this.f791b.setContentView(m2136b());
        m2141c();
    }

    /* renamed from: a */
    public void mo2117a(int i) {
        this.f796g = null;
        this.f797h = i;
        this.f802m = false;
    }

    /* renamed from: a */
    public void mo2118a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f788M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f810u = charSequence;
                this.f811v = message;
                return;
            case -2:
                this.f807r = charSequence;
                this.f808s = message;
                return;
            case -1:
                this.f804o = charSequence;
                this.f805p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: a */
    public void mo2119a(Drawable drawable) {
        this.f814y = drawable;
        this.f813x = 0;
        if (this.f815z == null) {
            return;
        }
        if (drawable != null) {
            this.f815z.setVisibility(0);
            this.f815z.setImageDrawable(drawable);
            return;
        }
        this.f815z.setVisibility(8);
    }

    /* renamed from: a */
    public void mo2120a(View view, int i, int i2, int i3, int i4) {
        this.f796g = view;
        this.f797h = 0;
        this.f802m = true;
        this.f798i = i;
        this.f799j = i2;
        this.f800k = i3;
        this.f801l = i4;
    }

    /* renamed from: a */
    public void mo2121a(CharSequence charSequence) {
        this.f793d = charSequence;
        if (this.f776A != null) {
            this.f776A.setText(charSequence);
        }
    }

    /* renamed from: a */
    public boolean mo2122a(int i, KeyEvent keyEvent) {
        return this.f812w != null && this.f812w.mo1700a(keyEvent);
    }

    /* renamed from: b */
    public void mo2123b(int i) {
        this.f814y = null;
        this.f813x = i;
        if (this.f815z == null) {
            return;
        }
        if (i != 0) {
            this.f815z.setVisibility(0);
            this.f815z.setImageResource(this.f813x);
            return;
        }
        this.f815z.setVisibility(8);
    }

    /* renamed from: b */
    public void mo2124b(CharSequence charSequence) {
        this.f794e = charSequence;
        if (this.f777B != null) {
            this.f777B.setText(charSequence);
        }
    }

    /* renamed from: b */
    public boolean mo2125b(int i, KeyEvent keyEvent) {
        return this.f812w != null && this.f812w.mo1700a(keyEvent);
    }

    /* renamed from: c */
    public int mo2126c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f790a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void setCustomTitle(View view) {
        this.f778C = view;
    }

    public void setView(View view) {
        this.f796g = view;
        this.f797h = 0;
        this.f802m = false;
    }
}
