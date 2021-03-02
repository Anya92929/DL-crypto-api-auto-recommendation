package android.support.p009v4.p014c.p015a;

import android.support.p009v4.view.C0219ax;
import android.support.p009v4.view.C0344n;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.c.a.b */
public interface C0124b extends MenuItem {
    /* renamed from: a */
    C0124b mo1016a(C0219ax axVar);

    /* renamed from: a */
    C0124b mo1017a(C0344n nVar);

    /* renamed from: a */
    C0344n mo1018a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
