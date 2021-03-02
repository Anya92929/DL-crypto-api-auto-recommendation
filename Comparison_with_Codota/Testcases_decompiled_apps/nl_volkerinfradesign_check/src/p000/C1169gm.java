package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p001v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: gm */
public class C1169gm extends C1168gl implements SubMenu {
    public C1169gm(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    /* renamed from: b */
    public SupportSubMenu getWrappedObject() {
        return (SupportSubMenu) this.f4162b;
    }

    public SubMenu setHeaderTitle(int i) {
        getWrappedObject().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        getWrappedObject().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        getWrappedObject().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        getWrappedObject().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        getWrappedObject().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        getWrappedObject().clearHeader();
    }

    public SubMenu setIcon(int i) {
        getWrappedObject().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        getWrappedObject().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return mo8130a(getWrappedObject().getItem());
    }
}
