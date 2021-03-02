package android.support.p021v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.p014c.p015a.C0124b;
import android.support.p009v4.view.C0219ax;
import android.support.p009v4.view.C0344n;
import android.support.p009v4.view.C0346p;
import android.support.p021v7.widget.C0591ap;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.view.menu.s */
public final class C0566s implements C0124b {

    /* renamed from: w */
    private static String f1133w;

    /* renamed from: x */
    private static String f1134x;

    /* renamed from: y */
    private static String f1135y;

    /* renamed from: z */
    private static String f1136z;

    /* renamed from: a */
    private final int f1137a;

    /* renamed from: b */
    private final int f1138b;

    /* renamed from: c */
    private final int f1139c;

    /* renamed from: d */
    private final int f1140d;

    /* renamed from: e */
    private CharSequence f1141e;

    /* renamed from: f */
    private CharSequence f1142f;

    /* renamed from: g */
    private Intent f1143g;

    /* renamed from: h */
    private char f1144h;

    /* renamed from: i */
    private char f1145i;

    /* renamed from: j */
    private Drawable f1146j;

    /* renamed from: k */
    private int f1147k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C0562o f1148l;

    /* renamed from: m */
    private C0547an f1149m;

    /* renamed from: n */
    private Runnable f1150n;

    /* renamed from: o */
    private MenuItem.OnMenuItemClickListener f1151o;

    /* renamed from: p */
    private int f1152p = 16;

    /* renamed from: q */
    private int f1153q = 0;

    /* renamed from: r */
    private View f1154r;

    /* renamed from: s */
    private C0344n f1155s;

    /* renamed from: t */
    private C0219ax f1156t;

    /* renamed from: u */
    private boolean f1157u = false;

    /* renamed from: v */
    private ContextMenu.ContextMenuInfo f1158v;

    C0566s(C0562o oVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1148l = oVar;
        this.f1137a = i2;
        this.f1138b = i;
        this.f1139c = i3;
        this.f1140d = i4;
        this.f1141e = charSequence;
        this.f1153q = i5;
    }

    /* renamed from: a */
    public C0124b setActionView(int i) {
        Context e = this.f1148l.mo2477e();
        setActionView(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    /* renamed from: a */
    public C0124b mo1016a(C0219ax axVar) {
        this.f1156t = axVar;
        return this;
    }

    /* renamed from: a */
    public C0124b mo1017a(C0344n nVar) {
        if (this.f1155s != null) {
            this.f1155s.mo1625f();
        }
        this.f1154r = null;
        this.f1155s = nVar;
        this.f1148l.mo2470b(true);
        if (this.f1155s != null) {
            this.f1155s.mo1618a((C0346p) new C0567t(this));
        }
        return this;
    }

    /* renamed from: a */
    public C0124b setActionView(View view) {
        this.f1154r = view;
        this.f1155s = null;
        if (view != null && view.getId() == -1 && this.f1137a > 0) {
            view.setId(this.f1137a);
        }
        this.f1148l.mo2469b(this);
        return this;
    }

    /* renamed from: a */
    public C0344n mo1018a() {
        return this.f1155s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo2509a(C0541ah ahVar) {
        return (ahVar == null || !ahVar.mo2239a()) ? getTitle() : getTitleCondensed();
    }

    /* renamed from: a */
    public void mo2510a(C0547an anVar) {
        this.f1149m = anVar;
        anVar.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2511a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1158v = contextMenuInfo;
    }

    /* renamed from: a */
    public void mo2512a(boolean z) {
        this.f1152p = (z ? 4 : 0) | (this.f1152p & -5);
    }

    /* renamed from: b */
    public C0124b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2514b(boolean z) {
        int i = this.f1152p;
        this.f1152p = (z ? 2 : 0) | (this.f1152p & -3);
        if (i != this.f1152p) {
            this.f1148l.mo2470b(false);
        }
    }

    /* renamed from: b */
    public boolean mo2515b() {
        if ((this.f1151o != null && this.f1151o.onMenuItemClick(this)) || this.f1148l.mo2371a(this.f1148l.mo2377p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1150n != null) {
            this.f1150n.run();
            return true;
        }
        if (this.f1143g != null) {
            try {
                this.f1148l.mo2477e().startActivity(this.f1143g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1155s != null && this.f1155s.mo1623d();
    }

    /* renamed from: c */
    public int mo2516c() {
        return this.f1140d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo2517c(boolean z) {
        int i = this.f1152p;
        this.f1152p = (z ? 0 : 8) | (this.f1152p & -9);
        return i != this.f1152p;
    }

    public boolean collapseActionView() {
        if ((this.f1153q & 8) == 0) {
            return false;
        }
        if (this.f1154r == null) {
            return true;
        }
        if (this.f1156t == null || this.f1156t.mo1403b(this)) {
            return this.f1148l.mo2375d(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public char mo2518d() {
        return this.f1148l.mo2372b() ? this.f1145i : this.f1144h;
    }

    /* renamed from: d */
    public void mo2519d(boolean z) {
        if (z) {
            this.f1152p |= 32;
        } else {
            this.f1152p &= -33;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo2520e() {
        char d = mo2518d();
        if (d == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f1133w);
        switch (d) {
            case 8:
                sb.append(f1135y);
                break;
            case 10:
                sb.append(f1134x);
                break;
            case ' ':
                sb.append(f1136z);
                break;
            default:
                sb.append(d);
                break;
        }
        return sb.toString();
    }

    /* renamed from: e */
    public void mo2521e(boolean z) {
        this.f1157u = z;
        this.f1148l.mo2470b(false);
    }

    public boolean expandActionView() {
        if (!mo2547n()) {
            return false;
        }
        if (this.f1156t == null || this.f1156t.mo1402a(this)) {
            return this.f1148l.mo2374c(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo2522f() {
        return this.f1148l.mo2373c() && mo2518d() != 0;
    }

    /* renamed from: g */
    public boolean mo2523g() {
        return (this.f1152p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f1154r != null) {
            return this.f1154r;
        }
        if (this.f1155s == null) {
            return null;
        }
        this.f1154r = this.f1155s.mo1616a((MenuItem) this);
        return this.f1154r;
    }

    public char getAlphabeticShortcut() {
        return this.f1145i;
    }

    public int getGroupId() {
        return this.f1138b;
    }

    public Drawable getIcon() {
        if (this.f1146j != null) {
            return this.f1146j;
        }
        if (this.f1147k == 0) {
            return null;
        }
        Drawable a = C0591ap.m2736a().mo2982a(this.f1148l.mo2477e(), this.f1147k);
        this.f1147k = 0;
        this.f1146j = a;
        return a;
    }

    public Intent getIntent() {
        return this.f1143g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1137a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1158v;
    }

    public char getNumericShortcut() {
        return this.f1144h;
    }

    public int getOrder() {
        return this.f1139c;
    }

    public SubMenu getSubMenu() {
        return this.f1149m;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1141e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1142f != null ? this.f1142f : this.f1141e;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    /* renamed from: h */
    public void mo2536h() {
        this.f1148l.mo2469b(this);
    }

    public boolean hasSubMenu() {
        return this.f1149m != null;
    }

    /* renamed from: i */
    public boolean mo2538i() {
        return this.f1148l.mo2494q();
    }

    public boolean isActionViewExpanded() {
        return this.f1157u;
    }

    public boolean isCheckable() {
        return (this.f1152p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f1152p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f1152p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1155s == null || !this.f1155s.mo1621b()) ? (this.f1152p & 8) == 0 : (this.f1152p & 8) == 0 && this.f1155s.mo1622c();
    }

    /* renamed from: j */
    public boolean mo2543j() {
        return (this.f1152p & 32) == 32;
    }

    /* renamed from: k */
    public boolean mo2544k() {
        return (this.f1153q & 1) == 1;
    }

    /* renamed from: l */
    public boolean mo2545l() {
        return (this.f1153q & 2) == 2;
    }

    /* renamed from: m */
    public boolean mo2546m() {
        return (this.f1153q & 4) == 4;
    }

    /* renamed from: n */
    public boolean mo2547n() {
        if ((this.f1153q & 8) == 0) {
            return false;
        }
        if (this.f1154r == null && this.f1155s != null) {
            this.f1154r = this.f1155s.mo1616a((MenuItem) this);
        }
        return this.f1154r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1145i != c) {
            this.f1145i = Character.toLowerCase(c);
            this.f1148l.mo2470b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1152p;
        this.f1152p = (z ? 1 : 0) | (this.f1152p & -2);
        if (i != this.f1152p) {
            this.f1148l.mo2470b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1152p & 4) != 0) {
            this.f1148l.mo2452a((MenuItem) this);
        } else {
            mo2514b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1152p |= 16;
        } else {
            this.f1152p &= -17;
        }
        this.f1148l.mo2470b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1146j = null;
        this.f1147k = i;
        this.f1148l.mo2470b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1147k = 0;
        this.f1146j = drawable;
        this.f1148l.mo2470b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1143g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1144h != c) {
            this.f1144h = c;
            this.f1148l.mo2470b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1151o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1144h = c;
        this.f1145i = Character.toLowerCase(c2);
        this.f1148l.mo2470b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1153q = i;
                this.f1148l.mo2469b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f1148l.mo2477e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1141e = charSequence;
        this.f1148l.mo2470b(false);
        if (this.f1149m != null) {
            this.f1149m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1142f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1141e;
        }
        this.f1148l.mo2470b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (mo2517c(z)) {
            this.f1148l.mo2451a(this);
        }
        return this;
    }

    public String toString() {
        if (this.f1141e != null) {
            return this.f1141e.toString();
        }
        return null;
    }
}
