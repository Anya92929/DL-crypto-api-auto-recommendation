package android.support.p004v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.support.p001v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.ActionMenuItem */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a */
    private final int f1693a;

    /* renamed from: b */
    private final int f1694b;

    /* renamed from: c */
    private final int f1695c;

    /* renamed from: d */
    private final int f1696d;

    /* renamed from: e */
    private CharSequence f1697e;

    /* renamed from: f */
    private CharSequence f1698f;

    /* renamed from: g */
    private Intent f1699g;

    /* renamed from: h */
    private char f1700h;

    /* renamed from: i */
    private char f1701i;

    /* renamed from: j */
    private Drawable f1702j;

    /* renamed from: k */
    private int f1703k = 0;

    /* renamed from: l */
    private Context f1704l;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f1705m;

    /* renamed from: n */
    private int f1706n = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1704l = context;
        this.f1693a = i2;
        this.f1694b = i;
        this.f1695c = i3;
        this.f1696d = i4;
        this.f1697e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f1701i;
    }

    public int getGroupId() {
        return this.f1694b;
    }

    public Drawable getIcon() {
        return this.f1702j;
    }

    public Intent getIntent() {
        return this.f1699g;
    }

    public int getItemId() {
        return this.f1693a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1700h;
    }

    public int getOrder() {
        return this.f1696d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1697e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1698f != null ? this.f1698f : this.f1697e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1706n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1706n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1706n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1706n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1701i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1706n = (z ? 1 : 0) | (this.f1706n & -2);
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z) {
        this.f1706n = (z ? 4 : 0) | (this.f1706n & -5);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1706n = (z ? 2 : 0) | (this.f1706n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1706n = (z ? 16 : 0) | (this.f1706n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1702j = drawable;
        this.f1703k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1703k = i;
        this.f1702j = ContextCompat.getDrawable(this.f1704l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1699g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1700h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1705m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1700h = c;
        this.f1701i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1697e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1697e = this.f1704l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1698f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1706n = (z ? 0 : 8) | (this.f1706n & 8);
        return this;
    }

    public boolean invoke() {
        if (this.f1705m != null && this.f1705m.onMenuItemClick(this)) {
            return true;
        }
        if (this.f1699g == null) {
            return false;
        }
        this.f1704l.startActivity(this.f1699g);
        return true;
    }

    public void setShowAsAction(int i) {
    }

    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public android.support.p001v4.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public SupportMenuItem setSupportActionProvider(android.support.p001v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return this;
    }
}
