package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.ActionMenuItem */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a */
    private final int f2034a;

    /* renamed from: b */
    private final int f2035b;

    /* renamed from: c */
    private final int f2036c;

    /* renamed from: d */
    private final int f2037d;

    /* renamed from: e */
    private CharSequence f2038e;

    /* renamed from: f */
    private CharSequence f2039f;

    /* renamed from: g */
    private Intent f2040g;

    /* renamed from: h */
    private char f2041h;

    /* renamed from: i */
    private char f2042i;

    /* renamed from: j */
    private Drawable f2043j;

    /* renamed from: k */
    private int f2044k = 0;

    /* renamed from: l */
    private Context f2045l;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f2046m;

    /* renamed from: n */
    private int f2047n = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f2045l = context;
        this.f2034a = i2;
        this.f2035b = i;
        this.f2036c = i3;
        this.f2037d = i4;
        this.f2038e = charSequence;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f2042i;
    }

    public int getGroupId() {
        return this.f2035b;
    }

    public Drawable getIcon() {
        return this.f2043j;
    }

    public Intent getIntent() {
        return this.f2040g;
    }

    public int getItemId() {
        return this.f2034a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f2041h;
    }

    public int getOrder() {
        return this.f2037d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public android.support.p000v4.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f2038e;
    }

    public CharSequence getTitleCondensed() {
        return this.f2039f != null ? this.f2039f : this.f2038e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        if (this.f2046m != null && this.f2046m.onMenuItemClick(this)) {
            return true;
        }
        if (this.f2040g == null) {
            return false;
        }
        this.f2045l.startActivity(this.f2040g);
        return true;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f2047n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f2047n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f2047n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f2047n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f2042i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f2047n = (z ? 1 : 0) | (this.f2047n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f2047n = (z ? 2 : 0) | (this.f2047n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f2047n = (z ? 16 : 0) | (this.f2047n & -17);
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z) {
        this.f2047n = (z ? 4 : 0) | (this.f2047n & -5);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2044k = i;
        this.f2043j = ContextCompat.getDrawable(this.f2045l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2043j = drawable;
        this.f2044k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2040g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f2041h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2046m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2041h = c;
        this.f2042i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public SupportMenuItem setSupportActionProvider(android.support.p000v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f2038e = this.f2045l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2038e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2039f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f2047n = (z ? 0 : 8) | (this.f2047n & 8);
        return this;
    }
}
