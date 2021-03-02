package android.support.p021v7.p022a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.p009v4.app.NavUtils;
import android.support.p009v4.app.NotificationCompat;
import android.support.p009v4.view.C0198ac;
import android.support.p009v4.view.C0208am;
import android.support.p009v4.view.C0238bp;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0275cz;
import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.widget.C0377at;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0508d;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.support.p021v7.view.C0524e;
import android.support.p021v7.view.C0525f;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.support.p021v7.widget.ActionBarContextView;
import android.support.p021v7.widget.C0622bt;
import android.support.p021v7.widget.C0626bx;
import android.support.p021v7.widget.C0682dz;
import android.support.p021v7.widget.ContentFrameLayout;
import android.support.p021v7.widget.Toolbar;
import android.support.p021v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* renamed from: android.support.v7.a.au */
class C0447au extends C0436aj implements C0208am, C0563p {

    /* renamed from: A */
    private boolean f613A;

    /* renamed from: B */
    private C0460bg[] f614B;

    /* renamed from: C */
    private C0460bg f615C;

    /* renamed from: D */
    private boolean f616D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f617E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f618F;

    /* renamed from: G */
    private final Runnable f619G = new C0448av(this);

    /* renamed from: H */
    private boolean f620H;

    /* renamed from: I */
    private Rect f621I;

    /* renamed from: J */
    private Rect f622J;

    /* renamed from: K */
    private C0463bj f623K;

    /* renamed from: m */
    C0521b f624m;

    /* renamed from: n */
    ActionBarContextView f625n;

    /* renamed from: o */
    PopupWindow f626o;

    /* renamed from: p */
    Runnable f627p;

    /* renamed from: q */
    C0314ek f628q = null;

    /* renamed from: r */
    private C0622bt f629r;

    /* renamed from: s */
    private C0456bc f630s;

    /* renamed from: t */
    private C0461bh f631t;

    /* renamed from: u */
    private boolean f632u;

    /* renamed from: v */
    private ViewGroup f633v;

    /* renamed from: w */
    private TextView f634w;

    /* renamed from: x */
    private View f635x;

    /* renamed from: y */
    private boolean f636y;

    /* renamed from: z */
    private boolean f637z;

    C0447au(Context context, Window window, C0434ah ahVar) {
        super(context, window, ahVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0460bg m1875a(Menu menu) {
        C0460bg[] bgVarArr = this.f614B;
        int length = bgVarArr != null ? bgVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0460bg bgVar = bgVarArr[i];
            if (bgVar != null && bgVar.f660j == menu) {
                return bgVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1876a(int i, C0460bg bgVar, Menu menu) {
        if (menu == null) {
            if (bgVar == null && i >= 0 && i < this.f614B.length) {
                bgVar = this.f614B[i];
            }
            if (bgVar != null) {
                menu = bgVar.f660j;
            }
        }
        if ((bgVar == null || bgVar.f665o) && !mo2006o()) {
            this.f591c.onPanelClosed(i, menu);
        }
    }

    /* renamed from: a */
    private void m1881a(C0460bg bgVar, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!bgVar.f665o && !mo2006o()) {
            if (bgVar.f651a == 0) {
                Context context = this.f589a;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback p = mo2007p();
            if (p == null || p.onMenuOpened(bgVar.f651a, bgVar.f660j)) {
                WindowManager windowManager = (WindowManager) this.f589a.getSystemService("window");
                if (windowManager != null && m1892b(bgVar, keyEvent)) {
                    if (bgVar.f657g == null || bgVar.f667q) {
                        if (bgVar.f657g == null) {
                            if (!m1885a(bgVar) || bgVar.f657g == null) {
                                return;
                            }
                        } else if (bgVar.f667q && bgVar.f657g.getChildCount() > 0) {
                            bgVar.f657g.removeAllViews();
                        }
                        if (m1895c(bgVar) && bgVar.mo2053a()) {
                            ViewGroup.LayoutParams layoutParams2 = bgVar.f658h.getLayoutParams();
                            ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                            bgVar.f657g.setBackgroundResource(bgVar.f652b);
                            ViewParent parent = bgVar.f658h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(bgVar.f658h);
                            }
                            bgVar.f657g.addView(bgVar.f658h, layoutParams3);
                            if (!bgVar.f658h.hasFocus()) {
                                bgVar.f658h.requestFocus();
                            }
                            i = -2;
                        } else {
                            return;
                        }
                    } else if (bgVar.f659i == null || (layoutParams = bgVar.f659i.getLayoutParams()) == null || layoutParams.width != -1) {
                        i = -2;
                    }
                    bgVar.f664n = false;
                    WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, bgVar.f654d, bgVar.f655e, 1002, 8519680, -3);
                    layoutParams4.gravity = bgVar.f653c;
                    layoutParams4.windowAnimations = bgVar.f656f;
                    windowManager.addView(bgVar.f657g, layoutParams4);
                    bgVar.f665o = true;
                    return;
                }
                return;
            }
            m1882a(bgVar, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1882a(C0460bg bgVar, boolean z) {
        if (!z || bgVar.f651a != 0 || this.f629r == null || !this.f629r.mo2673e()) {
            WindowManager windowManager = (WindowManager) this.f589a.getSystemService("window");
            if (!(windowManager == null || !bgVar.f665o || bgVar.f657g == null)) {
                windowManager.removeView(bgVar.f657g);
                if (z) {
                    m1876a(bgVar.f651a, bgVar, (Menu) null);
                }
            }
            bgVar.f663m = false;
            bgVar.f664n = false;
            bgVar.f665o = false;
            bgVar.f658h = null;
            bgVar.f667q = true;
            if (this.f615C == bgVar) {
                this.f615C = null;
                return;
            }
            return;
        }
        m1890b(bgVar.f660j);
    }

    /* renamed from: a */
    private void m1883a(C0562o oVar, boolean z) {
        if (this.f629r == null || !this.f629r.mo2671d() || (C0275cz.m1120b(ViewConfiguration.get(this.f589a)) && !this.f629r.mo2674f())) {
            C0460bg a = mo2027a(0, true);
            a.f667q = true;
            m1882a(a, false);
            m1881a(a, (KeyEvent) null);
            return;
        }
        Window.Callback p = mo2007p();
        if (this.f629r.mo2673e() && z) {
            this.f629r.mo2683h();
            if (!mo2006o()) {
                p.onPanelClosed(C0515k.AppCompatTheme_ratingBarStyle, mo2027a(0, true).f660j);
            }
        } else if (p != null && !mo2006o()) {
            if (this.f617E && (this.f618F & 1) != 0) {
                this.f590b.getDecorView().removeCallbacks(this.f619G);
                this.f619G.run();
            }
            C0460bg a2 = mo2027a(0, true);
            if (a2.f660j != null && !a2.f668r && p.onPreparePanel(0, a2.f659i, a2.f660j)) {
                p.onMenuOpened(C0515k.AppCompatTheme_ratingBarStyle, a2.f660j);
                this.f629r.mo2676g();
            }
        }
    }

    /* renamed from: a */
    private boolean m1885a(C0460bg bgVar) {
        bgVar.mo2051a(mo2004m());
        bgVar.f657g = new C0459bf(this, bgVar.f662l);
        bgVar.f653c = 81;
        return true;
    }

    /* renamed from: a */
    private boolean m1886a(C0460bg bgVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((bgVar.f663m || m1892b(bgVar, keyEvent)) && bgVar.f660j != null) {
                z = bgVar.f660j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f629r == null) {
                m1882a(bgVar, true);
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m1887a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f590b.getDecorView();
        for (ViewParent viewParent2 = viewParent; viewParent2 != null; viewParent2 = viewParent2.getParent()) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || C0247by.m925r((View) viewParent2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1890b(C0562o oVar) {
        if (!this.f613A) {
            this.f613A = true;
            this.f629r.mo2685j();
            Window.Callback p = mo2007p();
            if (p != null && !mo2006o()) {
                p.onPanelClosed(C0515k.AppCompatTheme_ratingBarStyle, oVar);
            }
            this.f613A = false;
        }
    }

    /* renamed from: b */
    private boolean m1891b(C0460bg bgVar) {
        Context context;
        Context context2 = this.f589a;
        if ((bgVar.f651a == 0 || bgVar.f651a == 108) && this.f629r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context2.getTheme();
            theme.resolveAttribute(C0506b.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context2.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0506b.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0506b.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context2.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Resources.Theme theme3 = theme2;
            if (theme3 != null) {
                context = new C0524e(context2, 0);
                context.getTheme().setTo(theme3);
                C0562o oVar = new C0562o(context);
                oVar.mo2370a((C0563p) this);
                bgVar.mo2052a(oVar);
                return true;
            }
        }
        context = context2;
        C0562o oVar2 = new C0562o(context);
        oVar2.mo2370a((C0563p) this);
        bgVar.mo2052a(oVar2);
        return true;
    }

    /* renamed from: b */
    private boolean m1892b(C0460bg bgVar, KeyEvent keyEvent) {
        if (mo2006o()) {
            return false;
        }
        if (bgVar.f663m) {
            return true;
        }
        if (!(this.f615C == null || this.f615C == bgVar)) {
            m1882a(this.f615C, false);
        }
        Window.Callback p = mo2007p();
        if (p != null) {
            bgVar.f659i = p.onCreatePanelView(bgVar.f651a);
        }
        boolean z = bgVar.f651a == 0 || bgVar.f651a == 108;
        if (z && this.f629r != null) {
            this.f629r.mo2684i();
        }
        if (bgVar.f659i == null && (!z || !(mo2003l() instanceof C0465bl))) {
            if (bgVar.f660j == null || bgVar.f668r) {
                if (bgVar.f660j == null && (!m1891b(bgVar) || bgVar.f660j == null)) {
                    return false;
                }
                if (z && this.f629r != null) {
                    if (this.f630s == null) {
                        this.f630s = new C0456bc(this, (C0448av) null);
                    }
                    this.f629r.mo2666a(bgVar.f660j, this.f630s);
                }
                bgVar.f660j.mo2480g();
                if (!p.onCreatePanelMenu(bgVar.f651a, bgVar.f660j)) {
                    bgVar.mo2052a((C0562o) null);
                    if (!z || this.f629r == null) {
                        return false;
                    }
                    this.f629r.mo2666a((Menu) null, this.f630s);
                    return false;
                }
                bgVar.f668r = false;
            }
            bgVar.f660j.mo2480g();
            if (bgVar.f669s != null) {
                bgVar.f660j.mo2467b(bgVar.f669s);
                bgVar.f669s = null;
            }
            if (!p.onPreparePanel(0, bgVar.f659i, bgVar.f660j)) {
                if (z && this.f629r != null) {
                    this.f629r.mo2666a((Menu) null, this.f630s);
                }
                bgVar.f660j.mo2482h();
                return false;
            }
            bgVar.f666p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            bgVar.f660j.setQwertyMode(bgVar.f666p);
            bgVar.f660j.mo2482h();
        }
        bgVar.f663m = true;
        bgVar.f664n = false;
        this.f615C = bgVar;
        return true;
    }

    /* renamed from: c */
    private boolean m1895c(C0460bg bgVar) {
        if (bgVar.f659i != null) {
            bgVar.f658h = bgVar.f659i;
            return true;
        } else if (bgVar.f660j == null) {
            return false;
        } else {
            if (this.f631t == null) {
                this.f631t = new C0461bh(this, (C0448av) null);
            }
            bgVar.f658h = (View) bgVar.mo2050a((C0539af) this.f631t);
            return bgVar.f658h != null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void mo2023d(int i) {
        m1882a(mo2027a(i, true), true);
    }

    /* renamed from: d */
    private boolean m1898d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0460bg a = mo2027a(i, true);
            if (!a.f665o) {
                return m1892b(a, keyEvent);
            }
        }
        return false;
    }

    /* renamed from: e */
    private void m1899e(int i) {
        this.f618F |= 1 << i;
        if (!this.f617E) {
            C0247by.m897a(this.f590b.getDecorView(), this.f619G);
            this.f617E = true;
        }
    }

    /* renamed from: e */
    private boolean m1900e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.f624m != null) {
            return false;
        }
        C0460bg a = mo2027a(i, true);
        if (i != 0 || this.f629r == null || !this.f629r.mo2671d() || C0275cz.m1120b(ViewConfiguration.get(this.f589a))) {
            if (a.f665o || a.f664n) {
                boolean z3 = a.f665o;
                m1882a(a, true);
                z2 = z3;
            } else {
                if (a.f663m) {
                    if (a.f668r) {
                        a.f663m = false;
                        z = m1892b(a, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        m1881a(a, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (!this.f629r.mo2673e()) {
            if (!mo2006o() && m1892b(a, keyEvent)) {
                z2 = this.f629r.mo2676g();
            }
            z2 = false;
        } else {
            z2 = this.f629r.mo2683h();
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.f589a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m1901f(int i) {
        C0460bg a;
        C0460bg a2 = mo2027a(i, true);
        if (a2.f660j != null) {
            Bundle bundle = new Bundle();
            a2.f660j.mo2448a(bundle);
            if (bundle.size() > 0) {
                a2.f669s = bundle;
            }
            a2.f660j.mo2480g();
            a2.f660j.clear();
        }
        a2.f668r = true;
        a2.f667q = true;
        if ((i == 108 || i == 0) && this.f629r != null && (a = mo2027a(0, false)) != null) {
            a.f663m = false;
            m1892b(a, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m1902g(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i2 = 0;
        if (this.f625n == null || !(this.f625n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f625n.getLayoutParams();
            if (this.f625n.isShown()) {
                if (this.f621I == null) {
                    this.f621I = new Rect();
                    this.f622J = new Rect();
                }
                Rect rect = this.f621I;
                Rect rect2 = this.f622J;
                rect.set(0, i, 0, 0);
                C0682dz.m3094a(this.f633v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f635x == null) {
                        this.f635x = new View(this.f589a);
                        this.f635x.setBackgroundColor(this.f589a.getResources().getColor(C0508d.abc_input_method_navigation_guard));
                        this.f633v.addView(this.f635x, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f635x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f635x.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                if (this.f635x == null) {
                    z4 = false;
                }
                if (!this.f598j && z4) {
                    i = 0;
                }
                boolean z5 = z3;
                z2 = z4;
                z4 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z4 = false;
                z2 = false;
            }
            if (z4) {
                this.f625n.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.f635x != null) {
            View view = this.f635x;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: h */
    private int m1903h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return C0515k.AppCompatTheme_ratingBarStyle;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return C0515k.AppCompatTheme_ratingBarStyleIndicator;
        }
    }

    /* renamed from: s */
    private void m1904s() {
        if (!this.f632u) {
            this.f633v = m1905t();
            CharSequence q = mo2008q();
            if (!TextUtils.isEmpty(q)) {
                mo2000b(q);
            }
            m1906u();
            mo2029a(this.f633v);
            this.f632u = true;
            C0460bg a = mo2027a(0, false);
            if (mo2006o()) {
                return;
            }
            if (a == null || a.f660j == null) {
                m1899e(C0515k.AppCompatTheme_ratingBarStyle);
            }
        }
    }

    /* renamed from: t */
    private ViewGroup m1905t() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f589a.obtainStyledAttributes(C0515k.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(C0515k.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(C0515k.AppCompatTheme_windowNoTitle, false)) {
            mo1987c(1);
        } else if (obtainStyledAttributes.getBoolean(C0515k.AppCompatTheme_windowActionBar, false)) {
            mo1987c((int) C0515k.AppCompatTheme_ratingBarStyle);
        }
        if (obtainStyledAttributes.getBoolean(C0515k.AppCompatTheme_windowActionBarOverlay, false)) {
            mo1987c((int) C0515k.AppCompatTheme_ratingBarStyleIndicator);
        }
        if (obtainStyledAttributes.getBoolean(C0515k.AppCompatTheme_windowActionModeOverlay, false)) {
            mo1987c(10);
        }
        this.f599k = obtainStyledAttributes.getBoolean(C0515k.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(this.f589a);
        if (this.f600l) {
            ViewGroup viewGroup2 = this.f598j ? (ViewGroup) from.inflate(C0512h.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(C0512h.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                C0247by.m896a((View) viewGroup2, (C0238bp) new C0449aw(this));
                viewGroup = viewGroup2;
            } else {
                ((C0626bx) viewGroup2).setOnFitSystemWindowsListener(new C0450ax(this));
                viewGroup = viewGroup2;
            }
        } else if (this.f599k) {
            this.f597i = false;
            this.f596h = false;
            viewGroup = (ViewGroup) from.inflate(C0512h.abc_dialog_title_material, (ViewGroup) null);
        } else if (this.f596h) {
            TypedValue typedValue = new TypedValue();
            this.f589a.getTheme().resolveAttribute(C0506b.actionBarTheme, typedValue, true);
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0524e(this.f589a, typedValue.resourceId) : this.f589a).inflate(C0512h.abc_screen_toolbar, (ViewGroup) null);
            this.f629r = (C0622bt) viewGroup3.findViewById(C0511g.decor_content_parent);
            this.f629r.setWindowCallback(mo2007p());
            if (this.f597i) {
                this.f629r.mo2665a(C0515k.AppCompatTheme_ratingBarStyleIndicator);
            }
            if (this.f636y) {
                this.f629r.mo2665a(2);
            }
            if (this.f637z) {
                this.f629r.mo2665a(5);
            }
            viewGroup = viewGroup3;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f596h + ", windowActionBarOverlay: " + this.f597i + ", android:windowIsFloating: " + this.f599k + ", windowActionModeOverlay: " + this.f598j + ", windowNoTitle: " + this.f600l + " }");
        }
        if (this.f629r == null) {
            this.f634w = (TextView) viewGroup.findViewById(C0511g.title);
        }
        C0682dz.makeOptionalFitsSystemWindows(viewGroup);
        ViewGroup viewGroup4 = (ViewGroup) this.f590b.findViewById(16908290);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0511g.action_bar_activity_content);
        while (viewGroup4.getChildCount() > 0) {
            View childAt = viewGroup4.getChildAt(0);
            viewGroup4.removeViewAt(0);
            contentFrameLayout.addView(childAt);
        }
        this.f590b.setContentView(viewGroup);
        viewGroup4.setId(-1);
        contentFrameLayout.setId(16908290);
        if (viewGroup4 instanceof FrameLayout) {
            ((FrameLayout) viewGroup4).setForeground((Drawable) null);
        }
        contentFrameLayout.setAttachListener(new C0451ay(this));
        return viewGroup;
    }

    /* renamed from: u */
    private void m1906u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f633v.findViewById(16908290);
        View decorView = this.f590b.getDecorView();
        contentFrameLayout.mo2757a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f589a.obtainStyledAttributes(C0515k.AppCompatTheme);
        obtainStyledAttributes.getValue(C0515k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0515k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0515k.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0515k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0515k.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0515k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0515k.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0515k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0515k.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0515k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m1907v() {
        if (this.f628q != null) {
            this.f628q.mo1559b();
        }
    }

    /* renamed from: w */
    private void m1908w() {
        if (this.f632u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m1909x() {
        if (this.f629r != null) {
            this.f629r.mo2685j();
        }
        if (this.f626o != null) {
            this.f590b.getDecorView().removeCallbacks(this.f627p);
            if (this.f626o.isShowing()) {
                try {
                    this.f626o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f626o = null;
        }
        m1907v();
        C0460bg a = mo2027a(0, false);
        if (a != null && a.f660j != null) {
            a.f660j.close();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0460bg mo2027a(int i, boolean z) {
        C0460bg[] bgVarArr = this.f614B;
        if (bgVarArr == null || bgVarArr.length <= i) {
            C0460bg[] bgVarArr2 = new C0460bg[(i + 1)];
            if (bgVarArr != null) {
                System.arraycopy(bgVarArr, 0, bgVarArr2, 0, bgVarArr.length);
            }
            this.f614B = bgVarArr2;
            bgVarArr = bgVarArr2;
        }
        C0460bg bgVar = bgVarArr[i];
        if (bgVar != null) {
            return bgVar;
        }
        C0460bg bgVar2 = new C0460bg(i);
        bgVarArr[i] = bgVar2;
        return bgVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0521b mo1995a(C0522c cVar) {
        C0521b bVar;
        Context context;
        m1907v();
        if (this.f624m != null) {
            this.f624m.mo2096c();
        }
        C0457bd bdVar = new C0457bd(this, cVar);
        if (this.f593e == null || mo2006o()) {
            bVar = null;
        } else {
            try {
                bVar = this.f593e.mo1949a((C0522c) bdVar);
            } catch (AbstractMethodError e) {
                bVar = null;
            }
        }
        if (bVar != null) {
            this.f624m = bVar;
        } else {
            if (this.f625n == null) {
                if (this.f599k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f589a.getTheme();
                    theme.resolveAttribute(C0506b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = this.f589a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        context = new C0524e(this.f589a, 0);
                        context.getTheme().setTo(newTheme);
                    } else {
                        context = this.f589a;
                    }
                    this.f625n = new ActionBarContextView(context);
                    this.f626o = new PopupWindow(context, (AttributeSet) null, C0506b.actionModePopupWindowStyle);
                    C0377at.m1543a(this.f626o, 2);
                    this.f626o.setContentView(this.f625n);
                    this.f626o.setWidth(-1);
                    context.getTheme().resolveAttribute(C0506b.actionBarSize, typedValue, true);
                    this.f625n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.f626o.setHeight(-2);
                    this.f627p = new C0452az(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f633v.findViewById(C0511g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(mo2004m()));
                        this.f625n = (ActionBarContextView) viewStubCompat.mo2898a();
                    }
                }
            }
            if (this.f625n != null) {
                m1907v();
                this.f625n.mo2643c();
                C0525f fVar = new C0525f(this.f625n.getContext(), this.f625n, bdVar, this.f626o == null);
                if (cVar.mo2044a((C0521b) fVar, fVar.mo2093b())) {
                    fVar.mo2097d();
                    this.f625n.mo2640a(fVar);
                    this.f624m = fVar;
                    C0247by.m903b((View) this.f625n, 0.0f);
                    this.f628q = C0247by.m917j(this.f625n).mo1552a(1.0f);
                    this.f628q.mo1554a((C0332fb) new C0455bb(this));
                    if (this.f626o != null) {
                        this.f590b.getDecorView().post(this.f627p);
                    }
                } else {
                    this.f624m = null;
                }
            }
        }
        if (!(this.f624m == null || this.f593e == null)) {
            this.f593e.mo1951a(this.f624m);
        }
        return this.f624m;
    }

    /* renamed from: a */
    public View mo1975a(int i) {
        m1904s();
        return this.f590b.findViewById(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo2022a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.f591c instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.f591c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1997a(int i, Menu menu) {
        if (i == 108) {
            C0426a a = mo1974a();
            if (a != null) {
                a.mo1926g(false);
            }
        } else if (i == 0) {
            C0460bg a2 = mo2027a(i, true);
            if (a2.f665o) {
                m1882a(a2, false);
            }
        }
    }

    /* renamed from: a */
    public void mo1976a(Configuration configuration) {
        C0426a a;
        if (this.f596h && this.f632u && (a = mo1974a()) != null) {
            a.mo1911a(configuration);
        }
    }

    /* renamed from: a */
    public void mo1977a(Bundle bundle) {
        if ((this.f591c instanceof Activity) && NavUtils.getParentActivityName((Activity) this.f591c) != null) {
            C0426a l = mo2003l();
            if (l == null) {
                this.f620H = true;
            } else {
                l.mo1922e(true);
            }
        }
    }

    /* renamed from: a */
    public void mo2028a(C0562o oVar) {
        m1883a(oVar, true);
    }

    /* renamed from: a */
    public void mo1978a(Toolbar toolbar) {
        if (this.f591c instanceof Activity) {
            C0426a a = mo1974a();
            if (a instanceof C0476bw) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f595g = null;
            if (a != null) {
                a.mo1928h();
            }
            if (toolbar != null) {
                C0465bl blVar = new C0465bl(toolbar, ((Activity) this.f589a).getTitle(), this.f592d);
                this.f594f = blVar;
                this.f590b.setCallback(blVar.mo2068i());
            } else {
                this.f594f = null;
                this.f590b.setCallback(this.f592d);
            }
            mo1989e();
        }
    }

    /* renamed from: a */
    public void mo1979a(View view, ViewGroup.LayoutParams layoutParams) {
        m1904s();
        ViewGroup viewGroup = (ViewGroup) this.f633v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f591c.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2029a(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1998a(int i, KeyEvent keyEvent) {
        C0426a a = mo1974a();
        if (a != null && a.mo1915a(i, keyEvent)) {
            return true;
        }
        if (this.f615C == null || !m1886a(this.f615C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f615C == null) {
                C0460bg a2 = mo2027a(0, true);
                m1892b(a2, keyEvent);
                boolean a3 = m1886a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f663m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f615C == null) {
            return true;
        } else {
            this.f615C.f664n = true;
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo2030a(C0562o oVar, MenuItem menuItem) {
        C0460bg a;
        Window.Callback p = mo2007p();
        if (p == null || mo2006o() || (a = m1875a((Menu) oVar.mo2377p())) == null) {
            return false;
        }
        return p.onMenuItemSelected(a.f651a, menuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1999a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.f591c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo2034c(keyCode, keyEvent) : mo2033b(keyCode, keyEvent);
    }

    /* renamed from: b */
    public C0521b mo2031b(C0522c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f624m != null) {
            this.f624m.mo2096c();
        }
        C0457bd bdVar = new C0457bd(this, cVar);
        C0426a a = mo1974a();
        if (a != null) {
            this.f624m = a.mo1908a((C0522c) bdVar);
            if (!(this.f624m == null || this.f593e == null)) {
                this.f593e.mo1951a(this.f624m);
            }
        }
        if (this.f624m == null) {
            this.f624m = mo1995a((C0522c) bdVar);
        }
        return this.f624m;
    }

    /* renamed from: b */
    public View mo2032b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        if (this.f623K == null) {
            this.f623K = new C0463bj();
        }
        return this.f623K.mo2064a(view, str, context, attributeSet, z && m1887a((ViewParent) view), z, true);
    }

    /* renamed from: b */
    public void mo1982b(int i) {
        m1904s();
        ViewGroup viewGroup = (ViewGroup) this.f633v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f589a).inflate(i, viewGroup);
        this.f591c.onContentChanged();
    }

    /* renamed from: b */
    public void mo1983b(Bundle bundle) {
        m1904s();
    }

    /* renamed from: b */
    public void mo1984b(View view, ViewGroup.LayoutParams layoutParams) {
        m1904s();
        ((ViewGroup) this.f633v.findViewById(16908290)).addView(view, layoutParams);
        this.f591c.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2000b(CharSequence charSequence) {
        if (this.f629r != null) {
            this.f629r.setWindowTitle(charSequence);
        } else if (mo2003l() != null) {
            mo2003l().mo1913a(charSequence);
        } else if (this.f634w != null) {
            this.f634w.setText(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo2033b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f616D;
                this.f616D = false;
                C0460bg a = mo2027a(0, false);
                if (a == null || !a.f665o) {
                    if (mo2035r()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m1882a(a, true);
                    return true;
                }
                break;
            case C0515k.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                m1900e(0, keyEvent);
                return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo2001b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0426a a = mo1974a();
        if (a == null) {
            return true;
        }
        a.mo1926g(true);
        return true;
    }

    /* renamed from: c */
    public void mo1985c() {
        C0426a a = mo1974a();
        if (a != null) {
            a.mo1924f(false);
        }
    }

    /* renamed from: c */
    public boolean mo1987c(int i) {
        int h = m1903h(i);
        if (this.f600l && h == 108) {
            return false;
        }
        if (this.f596h && h == 1) {
            this.f596h = false;
        }
        switch (h) {
            case 1:
                m1908w();
                this.f600l = true;
                return true;
            case 2:
                m1908w();
                this.f636y = true;
                return true;
            case 5:
                m1908w();
                this.f637z = true;
                return true;
            case 10:
                m1908w();
                this.f598j = true;
                return true;
            case C0515k.AppCompatTheme_ratingBarStyle /*108*/:
                m1908w();
                this.f596h = true;
                return true;
            case C0515k.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                m1908w();
                this.f597i = true;
                return true;
            default:
                return this.f590b.requestFeature(h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo2034c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                    z = false;
                }
                this.f616D = z;
                break;
            case C0515k.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                m1898d(0, keyEvent);
                return true;
        }
        if (Build.VERSION.SDK_INT < 11) {
            mo1998a(i, keyEvent);
        }
        return false;
    }

    /* renamed from: d */
    public void mo1988d() {
        C0426a a = mo1974a();
        if (a != null) {
            a.mo1924f(true);
        }
    }

    /* renamed from: e */
    public void mo1989e() {
        C0426a a = mo1974a();
        if (a == null || !a.mo1923e()) {
            m1899e(0);
        }
    }

    /* renamed from: f */
    public void mo1990f() {
        super.mo1990f();
        if (this.f594f != null) {
            this.f594f.mo1928h();
            this.f594f = null;
        }
    }

    /* renamed from: h */
    public void mo1992h() {
        LayoutInflater from = LayoutInflater.from(this.f589a);
        if (from.getFactory() == null) {
            C0198ac.m762a(from, this);
        } else if (!(C0198ac.m761a(from) instanceof C0447au)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* renamed from: k */
    public void mo2002k() {
        m1904s();
        if (this.f596h && this.f594f == null) {
            if (this.f591c instanceof Activity) {
                this.f594f = new C0476bw((Activity) this.f591c, this.f597i);
            } else if (this.f591c instanceof Dialog) {
                this.f594f = new C0476bw((Dialog) this.f591c);
            }
            if (this.f594f != null) {
                this.f594f.mo1922e(this.f620H);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo2022a(view, str, context, attributeSet);
        return a != null ? a : mo2032b(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean mo2035r() {
        if (this.f624m != null) {
            this.f624m.mo2096c();
            return true;
        }
        C0426a a = mo1974a();
        return a != null && a.mo1925f();
    }

    public void setContentView(View view) {
        m1904s();
        ViewGroup viewGroup = (ViewGroup) this.f633v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f591c.onContentChanged();
    }
}
