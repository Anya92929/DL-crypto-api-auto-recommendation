package com.jackhenry.godough.core.p036c;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1350b;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.p038e.C1586o;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.c.b */
public class C1546b {

    /* renamed from: a */
    C1350b<GodoughMenuItem> f6074a;

    /* renamed from: b */
    GodoughMenuItem.Type f6075b;

    /* renamed from: c */
    ListView f6076c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbstractActivity f6077d;

    /* renamed from: e */
    private String f6078e;

    /* renamed from: f */
    private DrawerLayout f6079f;

    /* renamed from: g */
    private ActionBarDrawerToggle f6080g;

    /* renamed from: h */
    private Toolbar f6081h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Runnable f6082i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f6083j = new Handler();

    public C1546b(AbstractActivity abstractActivity) {
        this.f6077d = abstractActivity;
        this.f6074a = new C1350b<>(abstractActivity, new C1545a(), C1496ak.flyout_single_row, C1496ak.flyout_single_row, C1496ak.flyout_single_row, C1496ak.flyout_single_row);
    }

    /* renamed from: a */
    private void m6081a(ListView listView) {
        Resources resources = GoDoughApp.getApp().getResources();
        ColorDrawable colorDrawable = new ColorDrawable(C1586o.m6203b());
        ((LayerDrawable) resources.getDrawable(C1493ah.flyout_row_pressed)).setDrawableByLayerId(C1494ai.color_layer, colorDrawable);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, colorDrawable);
        stateListDrawable.addState(new int[]{16842908}, resources.getDrawable(C1493ah.flyout_row_normal));
        stateListDrawable.addState(new int[0], resources.getDrawable(C1493ah.flyout_row_normal));
        listView.setSelector(stateListDrawable);
    }

    /* renamed from: a */
    public View mo9748a(View view, boolean z) {
        if (mo9751a()) {
            LinearLayout linearLayout = (LinearLayout) this.f6077d.getLayoutInflater().inflate(C1496ak.flyout_menu, (ViewGroup) null, false);
            this.f6079f = (DrawerLayout) linearLayout.findViewById(C1494ai.drawer_layout);
            this.f6081h = (Toolbar) linearLayout.findViewById(C1494ai.toolbar);
            this.f6077d.setSupportActionBar(this.f6081h);
            this.f6076c = (ListView) this.f6079f.findViewById(C1494ai.left_drawer);
            this.f6076c.setAdapter(this.f6074a);
            this.f6080g = new C1547c(this, this.f6077d, this.f6079f, C1506am.drawer_open, C1506am.drawer_close);
            if (z) {
                this.f6080g.setDrawerIndicatorEnabled(false);
                this.f6077d.getSupportActionBar().setHomeButtonEnabled(true);
            }
            this.f6079f.setDrawerListener(this.f6080g);
            this.f6080g.syncState();
            this.f6077d.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.f6077d.getSupportActionBar().setHomeButtonEnabled(true);
            ((FrameLayout) this.f6079f.findViewById(C1494ai.content_frame)).addView(view);
            C1548d dVar = new C1548d(this);
            mo9754c();
            m6081a(this.f6076c);
            this.f6076c.setOnItemClickListener(dVar);
            C1586o.m6208d(this.f6076c);
            return linearLayout;
        }
        LinearLayout linearLayout2 = (LinearLayout) this.f6077d.getLayoutInflater().inflate(C1496ak.base_activity_layout, (ViewGroup) null, false);
        this.f6081h = (Toolbar) linearLayout2.findViewById(C1494ai.toolbar);
        this.f6077d.setSupportActionBar(this.f6081h);
        if (this.f6077d.getSupportActionBar() != null && z) {
            this.f6077d.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else if (this.f6077d.getSupportActionBar() != null) {
            this.f6077d.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            this.f6077d.getSupportActionBar().setHomeButtonEnabled(false);
        }
        ((FrameLayout) linearLayout2.findViewById(C1494ai.content_frame)).addView(view);
        return linearLayout2;
    }

    /* renamed from: a */
    public void mo9749a(Configuration configuration) {
        if (this.f6080g != null) {
            this.f6080g.onConfigurationChanged(configuration);
        }
    }

    /* renamed from: a */
    public void mo9750a(String str) {
        this.f6078e = str;
    }

    /* renamed from: a */
    public boolean mo9751a() {
        return GoDoughApp.getUserSettings() != null;
    }

    /* renamed from: a */
    public boolean mo9752a(MenuItem menuItem) {
        return this.f6080g.onOptionsItemSelected(menuItem);
    }

    /* renamed from: b */
    public void mo9753b() {
        if (this.f6080g != null) {
            this.f6080g.syncState();
            if (this.f6077d.getSupportActionBar() != null && GoDoughApp.getUserSettings() != null) {
                mo9750a(this.f6077d.getSupportActionBar().getTitle().toString());
            }
        }
    }

    /* renamed from: c */
    public void mo9754c() {
        List<GodoughMenuItem> menuItems = GoDoughApp.getUserSettings().getUserMenu().getMenuItems();
        this.f6074a.mo9264a();
        this.f6074a.mo9265a(menuItems);
        this.f6074a.notifyDataSetChanged();
    }

    /* renamed from: d */
    public String mo9755d() {
        return this.f6078e;
    }

    /* renamed from: e */
    public DrawerLayout mo9756e() {
        return this.f6079f;
    }
}
