package android.support.p021v7.view;

import android.content.res.TypedArray;
import android.support.p009v4.view.C0214as;
import android.support.p009v4.view.C0344n;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0566s;
import android.support.p021v7.view.menu.C0568u;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

/* renamed from: android.support.v7.view.k */
class C0530k {

    /* renamed from: a */
    final /* synthetic */ C0528i f921a;

    /* renamed from: b */
    private Menu f922b;

    /* renamed from: c */
    private int f923c;

    /* renamed from: d */
    private int f924d;

    /* renamed from: e */
    private int f925e;

    /* renamed from: f */
    private int f926f;

    /* renamed from: g */
    private boolean f927g;

    /* renamed from: h */
    private boolean f928h;

    /* renamed from: i */
    private boolean f929i;

    /* renamed from: j */
    private int f930j;

    /* renamed from: k */
    private int f931k;

    /* renamed from: l */
    private CharSequence f932l;

    /* renamed from: m */
    private CharSequence f933m;

    /* renamed from: n */
    private int f934n;

    /* renamed from: o */
    private char f935o;

    /* renamed from: p */
    private char f936p;

    /* renamed from: q */
    private int f937q;

    /* renamed from: r */
    private boolean f938r;

    /* renamed from: s */
    private boolean f939s;

    /* renamed from: t */
    private boolean f940t;

    /* renamed from: u */
    private int f941u;

    /* renamed from: v */
    private int f942v;

    /* renamed from: w */
    private String f943w;

    /* renamed from: x */
    private String f944x;

    /* renamed from: y */
    private String f945y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C0344n f946z;

    public C0530k(C0528i iVar, Menu menu) {
        this.f921a = iVar;
        this.f922b = menu;
        mo2224a();
    }

    /* renamed from: a */
    private char m2242a(String str) {
        if (str == null) {
            return 0;
        }
        return str.charAt(0);
    }

    /* renamed from: a */
    private Object m2244a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = this.f921a.f916e.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    /* renamed from: a */
    private void m2245a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.f938r).setVisible(this.f939s).setEnabled(this.f940t).setCheckable(this.f937q >= 1).setTitleCondensed(this.f933m).setIcon(this.f934n).setAlphabeticShortcut(this.f935o).setNumericShortcut(this.f936p);
        if (this.f941u >= 0) {
            C0214as.m787a(menuItem, this.f941u);
        }
        if (this.f945y != null) {
            if (this.f921a.f916e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new C0529j(this.f921a.m2239c(), this.f945y));
        }
        if (menuItem instanceof C0566s) {
            C0566s sVar = (C0566s) menuItem;
        }
        if (this.f937q >= 2) {
            if (menuItem instanceof C0566s) {
                ((C0566s) menuItem).mo2512a(true);
            } else if (menuItem instanceof C0568u) {
                ((C0568u) menuItem).mo2566a(true);
            }
        }
        if (this.f943w != null) {
            C0214as.m785a(menuItem, (View) m2244a(this.f943w, C0528i.f912a, this.f921a.f914c));
        } else {
            z = false;
        }
        if (this.f942v > 0) {
            if (!z) {
                C0214as.m788b(menuItem, this.f942v);
            } else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        if (this.f946z != null) {
            C0214as.m784a(menuItem, this.f946z);
        }
    }

    /* renamed from: a */
    public void mo2224a() {
        this.f923c = 0;
        this.f924d = 0;
        this.f925e = 0;
        this.f926f = 0;
        this.f927g = true;
        this.f928h = true;
    }

    /* renamed from: a */
    public void mo2225a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f921a.f916e.obtainStyledAttributes(attributeSet, C0515k.MenuGroup);
        this.f923c = obtainStyledAttributes.getResourceId(C0515k.MenuGroup_android_id, 0);
        this.f924d = obtainStyledAttributes.getInt(C0515k.MenuGroup_android_menuCategory, 0);
        this.f925e = obtainStyledAttributes.getInt(C0515k.MenuGroup_android_orderInCategory, 0);
        this.f926f = obtainStyledAttributes.getInt(C0515k.MenuGroup_android_checkableBehavior, 0);
        this.f927g = obtainStyledAttributes.getBoolean(C0515k.MenuGroup_android_visible, true);
        this.f928h = obtainStyledAttributes.getBoolean(C0515k.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    public void mo2226b() {
        this.f929i = true;
        m2245a(this.f922b.add(this.f923c, this.f930j, this.f931k, this.f932l));
    }

    /* renamed from: b */
    public void mo2227b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.f921a.f916e.obtainStyledAttributes(attributeSet, C0515k.MenuItem);
        this.f930j = obtainStyledAttributes.getResourceId(C0515k.MenuItem_android_id, 0);
        this.f931k = (obtainStyledAttributes.getInt(C0515k.MenuItem_android_menuCategory, this.f924d) & -65536) | (obtainStyledAttributes.getInt(C0515k.MenuItem_android_orderInCategory, this.f925e) & 65535);
        this.f932l = obtainStyledAttributes.getText(C0515k.MenuItem_android_title);
        this.f933m = obtainStyledAttributes.getText(C0515k.MenuItem_android_titleCondensed);
        this.f934n = obtainStyledAttributes.getResourceId(C0515k.MenuItem_android_icon, 0);
        this.f935o = m2242a(obtainStyledAttributes.getString(C0515k.MenuItem_android_alphabeticShortcut));
        this.f936p = m2242a(obtainStyledAttributes.getString(C0515k.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(C0515k.MenuItem_android_checkable)) {
            this.f937q = obtainStyledAttributes.getBoolean(C0515k.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.f937q = this.f926f;
        }
        this.f938r = obtainStyledAttributes.getBoolean(C0515k.MenuItem_android_checked, false);
        this.f939s = obtainStyledAttributes.getBoolean(C0515k.MenuItem_android_visible, this.f927g);
        this.f940t = obtainStyledAttributes.getBoolean(C0515k.MenuItem_android_enabled, this.f928h);
        this.f941u = obtainStyledAttributes.getInt(C0515k.MenuItem_showAsAction, -1);
        this.f945y = obtainStyledAttributes.getString(C0515k.MenuItem_android_onClick);
        this.f942v = obtainStyledAttributes.getResourceId(C0515k.MenuItem_actionLayout, 0);
        this.f943w = obtainStyledAttributes.getString(C0515k.MenuItem_actionViewClass);
        this.f944x = obtainStyledAttributes.getString(C0515k.MenuItem_actionProviderClass);
        if (this.f944x == null) {
            z = false;
        }
        if (z && this.f942v == 0 && this.f943w == null) {
            this.f946z = (C0344n) m2244a(this.f944x, C0528i.f913b, this.f921a.f915d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f946z = null;
        }
        obtainStyledAttributes.recycle();
        this.f929i = false;
    }

    /* renamed from: c */
    public SubMenu mo2228c() {
        this.f929i = true;
        SubMenu addSubMenu = this.f922b.addSubMenu(this.f923c, this.f930j, this.f931k, this.f932l);
        m2245a(addSubMenu.getItem());
        return addSubMenu;
    }

    /* renamed from: d */
    public boolean mo2229d() {
        return this.f929i;
    }
}
