package android.support.p021v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.support.p009v4.p014c.p015a.C0123a;
import android.support.p009v4.p014c.p015a.C0124b;
import android.support.p009v4.p014c.p015a.C0125c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.view.menu.ai */
public final class C0542ai {
    /* renamed from: a */
    public static Menu m2331a(Context context, C0123a aVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new C0543aj(context, aVar);
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static MenuItem m2332a(Context context, C0124b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new C0573z(context, bVar);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new C0568u(context, bVar);
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static SubMenu m2333a(Context context, C0125c cVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new C0548ao(context, cVar);
        }
        throw new UnsupportedOperationException();
    }
}
