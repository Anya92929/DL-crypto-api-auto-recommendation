package android.support.p004v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.support.p001v4.view.ActionProvider;
import android.support.p001v4.view.MenuItemCompat;
import android.support.p004v7.view.menu.MenuView;
import android.support.p004v7.widget.TintManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.view.menu.MenuItemImpl */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: w */
    private static String f1777w;

    /* renamed from: x */
    private static String f1778x;

    /* renamed from: y */
    private static String f1779y;

    /* renamed from: z */
    private static String f1780z;

    /* renamed from: a */
    private final int f1781a;

    /* renamed from: b */
    private final int f1782b;

    /* renamed from: c */
    private final int f1783c;

    /* renamed from: d */
    private final int f1784d;

    /* renamed from: e */
    private CharSequence f1785e;

    /* renamed from: f */
    private CharSequence f1786f;

    /* renamed from: g */
    private Intent f1787g;

    /* renamed from: h */
    private char f1788h;

    /* renamed from: i */
    private char f1789i;

    /* renamed from: j */
    private Drawable f1790j;

    /* renamed from: k */
    private int f1791k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MenuBuilder f1792l;

    /* renamed from: m */
    private SubMenuBuilder f1793m;

    /* renamed from: n */
    private Runnable f1794n;

    /* renamed from: o */
    private MenuItem.OnMenuItemClickListener f1795o;

    /* renamed from: p */
    private int f1796p = 16;

    /* renamed from: q */
    private int f1797q = 0;

    /* renamed from: r */
    private View f1798r;

    /* renamed from: s */
    private ActionProvider f1799s;

    /* renamed from: t */
    private MenuItemCompat.OnActionExpandListener f1800t;

    /* renamed from: u */
    private boolean f1801u = false;

    /* renamed from: v */
    private ContextMenu.ContextMenuInfo f1802v;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1792l = menuBuilder;
        this.f1781a = i2;
        this.f1782b = i;
        this.f1783c = i3;
        this.f1784d = i4;
        this.f1785e = charSequence;
        this.f1797q = i5;
    }

    public boolean invoke() {
        if ((this.f1795o != null && this.f1795o.onMenuItemClick(this)) || this.f1792l.mo3664a(this.f1792l.getRootMenu(), (MenuItem) this)) {
            return true;
        }
        if (this.f1794n != null) {
            this.f1794n.run();
            return true;
        }
        if (this.f1787g != null) {
            try {
                this.f1792l.getContext().startActivity(this.f1787g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f1799s == null || !this.f1799s.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f1796p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1796p |= 16;
        } else {
            this.f1796p &= -17;
        }
        this.f1792l.onItemsChanged(false);
        return this;
    }

    public int getGroupId() {
        return this.f1782b;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1781a;
    }

    public int getOrder() {
        return this.f1783c;
    }

    public int getOrdering() {
        return this.f1784d;
    }

    public Intent getIntent() {
        return this.f1787g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1787g = intent;
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.f1794n = runnable;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f1789i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1789i != c) {
            this.f1789i = Character.toLowerCase(c);
            this.f1792l.onItemsChanged(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f1788h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1788h != c) {
            this.f1788h = c;
            this.f1792l.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1788h = c;
        this.f1789i = Character.toLowerCase(c2);
        this.f1792l.onItemsChanged(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public char mo3737a() {
        return this.f1792l.isQwertyMode() ? this.f1789i : this.f1788h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo3742b() {
        char a = mo3737a();
        if (a == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f1777w);
        switch (a) {
            case 8:
                sb.append(f1779y);
                break;
            case 10:
                sb.append(f1778x);
                break;
            case ' ':
                sb.append(f1780z);
                break;
            default:
                sb.append(a);
                break;
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo3744c() {
        return this.f1792l.isShortcutsVisible() && mo3737a() != 0;
    }

    public SubMenu getSubMenu() {
        return this.f1793m;
    }

    public boolean hasSubMenu() {
        return this.f1793m != null;
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.f1793m = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1785e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo3738a(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1785e = charSequence;
        this.f1792l.onItemsChanged(false);
        if (this.f1793m != null) {
            this.f1793m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f1792l.getContext().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1786f != null ? this.f1786f : this.f1785e;
        if (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1786f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1785e;
        }
        this.f1792l.onItemsChanged(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f1790j != null) {
            return this.f1790j;
        }
        if (this.f1791k == 0) {
            return null;
        }
        Drawable drawable = TintManager.getDrawable(this.f1792l.getContext(), this.f1791k);
        this.f1791k = 0;
        this.f1790j = drawable;
        return drawable;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1791k = 0;
        this.f1790j = drawable;
        this.f1792l.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1790j = null;
        this.f1791k = i;
        this.f1792l.onItemsChanged(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f1796p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1796p;
        this.f1796p = (z ? 1 : 0) | (this.f1796p & -2);
        if (i != this.f1796p) {
            this.f1792l.onItemsChanged(false);
        }
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        this.f1796p = (z ? 4 : 0) | (this.f1796p & -5);
    }

    public boolean isExclusiveCheckable() {
        return (this.f1796p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f1796p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1796p & 4) != 0) {
            this.f1792l.mo3662a((MenuItem) this);
        } else {
            mo3740a(z);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3740a(boolean z) {
        int i;
        int i2 = this.f1796p;
        int i3 = this.f1796p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f1796p = i | i3;
        if (i2 != this.f1796p) {
            this.f1792l.onItemsChanged(false);
        }
    }

    public boolean isVisible() {
        if (this.f1799s == null || !this.f1799s.overridesItemVisibility()) {
            if ((this.f1796p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f1796p & 8) != 0 || !this.f1799s.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3743b(boolean z) {
        int i = this.f1796p;
        this.f1796p = (z ? 0 : 8) | (this.f1796p & -9);
        if (i != this.f1796p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (mo3743b(z)) {
            this.f1792l.mo3661a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1795o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f1785e != null) {
            return this.f1785e.toString();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3739a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1802v = contextMenuInfo;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1802v;
    }

    public void actionFormatChanged() {
        this.f1792l.mo3677b(this);
    }

    public boolean shouldShowIcon() {
        return this.f1792l.mo3678b();
    }

    public boolean isActionButton() {
        return (this.f1796p & 32) == 32;
    }

    public boolean requestsActionButton() {
        return (this.f1797q & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.f1797q & 2) == 2;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.f1796p |= 32;
        } else {
            this.f1796p &= -33;
        }
    }

    public boolean showsTextAsAction() {
        return (this.f1797q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1797q = i;
                this.f1792l.mo3677b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public SupportMenuItem setActionView(View view) {
        this.f1798r = view;
        this.f1799s = null;
        if (view != null && view.getId() == -1 && this.f1781a > 0) {
            view.setId(this.f1781a);
        }
        this.f1792l.mo3677b(this);
        return this;
    }

    public SupportMenuItem setActionView(int i) {
        Context context = this.f1792l.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public View getActionView() {
        if (this.f1798r != null) {
            return this.f1798r;
        }
        if (this.f1799s == null) {
            return null;
        }
        this.f1798r = this.f1799s.onCreateActionView(this);
        return this.f1798r;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public ActionProvider getSupportActionProvider() {
        return this.f1799s;
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.f1799s != null) {
            this.f1799s.reset();
        }
        this.f1798r = null;
        this.f1799s = actionProvider;
        this.f1792l.onItemsChanged(true);
        if (this.f1799s != null) {
            this.f1799s.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.f1792l.mo3661a(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        if (this.f1800t == null || this.f1800t.onMenuItemActionExpand(this)) {
            return this.f1792l.expandItemActionView(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f1797q & 8) == 0) {
            return false;
        }
        if (this.f1798r == null) {
            return true;
        }
        if (this.f1800t == null || this.f1800t.onMenuItemActionCollapse(this)) {
            return this.f1792l.collapseItemActionView(this);
        }
        return false;
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        this.f1800t = onActionExpandListener;
        return this;
    }

    public boolean hasCollapsibleActionView() {
        if ((this.f1797q & 8) == 0) {
            return false;
        }
        if (this.f1798r == null && this.f1799s != null) {
            this.f1798r = this.f1799s.onCreateActionView(this);
        }
        if (this.f1798r != null) {
            return true;
        }
        return false;
    }

    public void setActionViewExpanded(boolean z) {
        this.f1801u = z;
        this.f1792l.onItemsChanged(false);
    }

    public boolean isActionViewExpanded() {
        return this.f1801u;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
