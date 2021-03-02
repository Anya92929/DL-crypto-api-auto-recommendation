package android.support.p021v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.p014c.p015a.C0124b;
import android.support.p009v4.view.C0219ax;
import android.support.p009v4.view.C0344n;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.a */
public class C0533a implements C0124b {

    /* renamed from: a */
    private final int f985a;

    /* renamed from: b */
    private final int f986b;

    /* renamed from: c */
    private final int f987c;

    /* renamed from: d */
    private final int f988d;

    /* renamed from: e */
    private CharSequence f989e;

    /* renamed from: f */
    private CharSequence f990f;

    /* renamed from: g */
    private Intent f991g;

    /* renamed from: h */
    private char f992h;

    /* renamed from: i */
    private char f993i;

    /* renamed from: j */
    private Drawable f994j;

    /* renamed from: k */
    private int f995k = 0;

    /* renamed from: l */
    private Context f996l;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f997m;

    /* renamed from: n */
    private int f998n = 16;

    public C0533a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f996l = context;
        this.f985a = i2;
        this.f986b = i;
        this.f987c = i3;
        this.f988d = i4;
        this.f989e = charSequence;
    }

    /* renamed from: a */
    public C0124b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0124b mo1016a(C0219ax axVar) {
        return this;
    }

    /* renamed from: a */
    public C0124b mo1017a(C0344n nVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0124b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0344n mo1018a() {
        return null;
    }

    /* renamed from: b */
    public C0124b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
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
        return this.f993i;
    }

    public int getGroupId() {
        return this.f986b;
    }

    public Drawable getIcon() {
        return this.f994j;
    }

    public Intent getIntent() {
        return this.f991g;
    }

    public int getItemId() {
        return this.f985a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f992h;
    }

    public int getOrder() {
        return this.f988d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f989e;
    }

    public CharSequence getTitleCondensed() {
        return this.f990f != null ? this.f990f : this.f989e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f998n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f998n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f998n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f998n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f993i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f998n = (z ? 1 : 0) | (this.f998n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f998n = (z ? 2 : 0) | (this.f998n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f998n = (z ? 16 : 0) | (this.f998n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f995k = i;
        this.f994j = C0025a.getDrawable(this.f996l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f994j = drawable;
        this.f995k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f991g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f992h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f997m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f992h = c;
        this.f993i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setTitle(int i) {
        this.f989e = this.f996l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f989e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f990f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f998n = (z ? 0 : 8) | (this.f998n & 8);
        return this;
    }
}
