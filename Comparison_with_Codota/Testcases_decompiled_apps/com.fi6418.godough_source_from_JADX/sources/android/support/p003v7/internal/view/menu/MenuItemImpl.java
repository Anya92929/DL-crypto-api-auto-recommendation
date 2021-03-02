package android.support.p003v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.view.ActionProvider;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.widget.TintManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.internal.view.menu.MenuItemImpl */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: w */
    private static String f2132w;

    /* renamed from: x */
    private static String f2133x;

    /* renamed from: y */
    private static String f2134y;

    /* renamed from: z */
    private static String f2135z;

    /* renamed from: a */
    private final int f2136a;

    /* renamed from: b */
    private final int f2137b;

    /* renamed from: c */
    private final int f2138c;

    /* renamed from: d */
    private final int f2139d;

    /* renamed from: e */
    private CharSequence f2140e;

    /* renamed from: f */
    private CharSequence f2141f;

    /* renamed from: g */
    private Intent f2142g;

    /* renamed from: h */
    private char f2143h;

    /* renamed from: i */
    private char f2144i;

    /* renamed from: j */
    private Drawable f2145j;

    /* renamed from: k */
    private int f2146k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MenuBuilder f2147l;

    /* renamed from: m */
    private SubMenuBuilder f2148m;

    /* renamed from: n */
    private Runnable f2149n;

    /* renamed from: o */
    private MenuItem.OnMenuItemClickListener f2150o;

    /* renamed from: p */
    private int f2151p = 16;

    /* renamed from: q */
    private int f2152q = 0;

    /* renamed from: r */
    private View f2153r;

    /* renamed from: s */
    private ActionProvider f2154s;

    /* renamed from: t */
    private MenuItemCompat.OnActionExpandListener f2155t;

    /* renamed from: u */
    private boolean f2156u = false;

    /* renamed from: v */
    private ContextMenu.ContextMenuInfo f2157v;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f2147l = menuBuilder;
        this.f2136a = i2;
        this.f2137b = i;
        this.f2138c = i3;
        this.f2139d = i4;
        this.f2140e = charSequence;
        this.f2152q = i5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public char mo4159a() {
        return this.f2147l.isQwertyMode() ? this.f2144i : this.f2143h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo4160a(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4161a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f2157v = contextMenuInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4162a(boolean z) {
        int i = this.f2151p;
        this.f2151p = (z ? 2 : 0) | (this.f2151p & -3);
        if (i != this.f2151p) {
            this.f2147l.onItemsChanged(false);
        }
    }

    public void actionFormatChanged() {
        this.f2147l.mo4098b(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4164b() {
        char a = mo4159a();
        if (a == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f2132w);
        switch (a) {
            case 8:
                sb.append(f2134y);
                break;
            case 10:
                sb.append(f2133x);
                break;
            case ' ':
                sb.append(f2135z);
                break;
            default:
                sb.append(a);
                break;
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4165b(boolean z) {
        int i = this.f2151p;
        this.f2151p = (z ? 0 : 8) | (this.f2151p & -9);
        return i != this.f2151p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4166c() {
        return this.f2147l.isShortcutsVisible() && mo4159a() != 0;
    }

    public boolean collapseActionView() {
        if ((this.f2152q & 8) == 0) {
            return false;
        }
        if (this.f2153r == null) {
            return true;
        }
        if (this.f2155t == null || this.f2155t.onMenuItemActionCollapse(this)) {
            return this.f2147l.collapseItemActionView(this);
        }
        return false;
    }

    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        if (this.f2155t == null || this.f2155t.onMenuItemActionExpand(this)) {
            return this.f2147l.expandItemActionView(this);
        }
        return false;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f2153r != null) {
            return this.f2153r;
        }
        if (this.f2154s == null) {
            return null;
        }
        this.f2153r = this.f2154s.onCreateActionView(this);
        return this.f2153r;
    }

    public char getAlphabeticShortcut() {
        return this.f2144i;
    }

    public int getGroupId() {
        return this.f2137b;
    }

    public Drawable getIcon() {
        if (this.f2145j != null) {
            return this.f2145j;
        }
        if (this.f2146k == 0) {
            return null;
        }
        Drawable drawable = TintManager.getDrawable(this.f2147l.getContext(), this.f2146k);
        this.f2146k = 0;
        this.f2145j = drawable;
        return drawable;
    }

    public Intent getIntent() {
        return this.f2142g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f2136a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f2157v;
    }

    public char getNumericShortcut() {
        return this.f2143h;
    }

    public int getOrder() {
        return this.f2138c;
    }

    public int getOrdering() {
        return this.f2139d;
    }

    public SubMenu getSubMenu() {
        return this.f2148m;
    }

    public ActionProvider getSupportActionProvider() {
        return this.f2154s;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f2140e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2141f != null ? this.f2141f : this.f2140e;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public boolean hasCollapsibleActionView() {
        if ((this.f2152q & 8) == 0) {
            return false;
        }
        if (this.f2153r == null && this.f2154s != null) {
            this.f2153r = this.f2154s.onCreateActionView(this);
        }
        return this.f2153r != null;
    }

    public boolean hasSubMenu() {
        return this.f2148m != null;
    }

    public boolean invoke() {
        if ((this.f2150o != null && this.f2150o.onMenuItemClick(this)) || this.f2147l.mo4086a(this.f2147l.getRootMenu(), (MenuItem) this)) {
            return true;
        }
        if (this.f2149n != null) {
            this.f2149n.run();
            return true;
        }
        if (this.f2142g != null) {
            try {
                this.f2147l.getContext().startActivity(this.f2142g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f2154s != null && this.f2154s.onPerformDefaultAction();
    }

    public boolean isActionButton() {
        return (this.f2151p & 32) == 32;
    }

    public boolean isActionViewExpanded() {
        return this.f2156u;
    }

    public boolean isCheckable() {
        return (this.f2151p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f2151p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f2151p & 16) != 0;
    }

    public boolean isExclusiveCheckable() {
        return (this.f2151p & 4) != 0;
    }

    public boolean isVisible() {
        return (this.f2154s == null || !this.f2154s.overridesItemVisibility()) ? (this.f2151p & 8) == 0 : (this.f2151p & 8) == 0 && this.f2154s.isVisible();
    }

    public boolean requestsActionButton() {
        return (this.f2152q & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.f2152q & 2) == 2;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public SupportMenuItem setActionView(int i) {
        Context context = this.f2147l.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public SupportMenuItem setActionView(View view) {
        this.f2153r = view;
        this.f2154s = null;
        if (view != null && view.getId() == -1 && this.f2136a > 0) {
            view.setId(this.f2136a);
        }
        this.f2147l.mo4098b(this);
        return this;
    }

    public void setActionViewExpanded(boolean z) {
        this.f2156u = z;
        this.f2147l.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f2144i != c) {
            this.f2144i = Character.toLowerCase(c);
            this.f2147l.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.f2149n = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f2151p;
        this.f2151p = (z ? 1 : 0) | (this.f2151p & -2);
        if (i != this.f2151p) {
            this.f2147l.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f2151p & 4) != 0) {
            this.f2147l.mo4084a((MenuItem) this);
        } else {
            mo4162a(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2151p |= 16;
        } else {
            this.f2151p &= -17;
        }
        this.f2147l.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        this.f2151p = (z ? 4 : 0) | (this.f2151p & -5);
    }

    public MenuItem setIcon(int i) {
        this.f2145j = null;
        this.f2146k = i;
        this.f2147l.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2146k = 0;
        this.f2145j = drawable;
        this.f2147l.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2142g = intent;
        return this;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.f2151p |= 32;
        } else {
            this.f2151p &= -33;
        }
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f2143h != c) {
            this.f2143h = c;
            this.f2147l.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2150o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2143h = c;
        this.f2144i = Character.toLowerCase(c2);
        this.f2147l.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f2152q = i;
                this.f2147l.mo4098b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.f2148m = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.f2154s != null) {
            this.f2154s.reset();
        }
        this.f2153r = null;
        this.f2154s = actionProvider;
        this.f2147l.onItemsChanged(true);
        if (this.f2154s != null) {
            this.f2154s.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.f2147l.mo4083a(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        this.f2155t = onActionExpandListener;
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f2147l.getContext().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2140e = charSequence;
        this.f2147l.onItemsChanged(false);
        if (this.f2148m != null) {
            this.f2148m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2141f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f2140e;
        }
        this.f2147l.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (mo4165b(z)) {
            this.f2147l.mo4083a(this);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        return this.f2147l.mo4099b();
    }

    public boolean showsTextAsAction() {
        return (this.f2152q & 4) == 4;
    }

    public String toString() {
        return this.f2140e.toString();
    }
}
