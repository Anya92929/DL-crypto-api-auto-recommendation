package com.jackhenry.godough.core.p036c;

import android.app.Activity;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.view.View;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.c.c */
class C1547c extends ActionBarDrawerToggle {

    /* renamed from: a */
    final /* synthetic */ C1546b f6084a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1547c(C1546b bVar, Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        super(activity, drawerLayout, i, i2);
        this.f6084a = bVar;
    }

    public void onDrawerClosed(View view) {
        this.f6084a.f6077d.getSupportActionBar().setTitle((CharSequence) this.f6084a.mo9755d());
        if (this.f6084a.f6082i != null) {
            this.f6084a.f6083j.post(this.f6084a.f6082i);
            Runnable unused = this.f6084a.f6082i = null;
        }
    }

    public void onDrawerOpened(View view) {
        this.f6084a.f6077d.getSupportActionBar().setTitle((CharSequence) this.f6084a.f6077d.getString(C1506am.app_name));
    }
}
