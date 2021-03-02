package org.commonwealthcu.mobile;

import android.app.Activity;
import android.graphics.Color;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.app.ActionBarActivity;
import android.support.p003v7.appcompat.C0137R;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: org.commonwealthcu.mobile.ak */
public final class C0594ak implements ActionBar.TabListener {

    /* renamed from: a */
    private Fragment f722a;

    /* renamed from: b */
    private final Activity f723b;

    /* renamed from: c */
    private final String f724c;

    /* renamed from: d */
    private final Class f725d;

    /* renamed from: e */
    private MobileBankingApp f726e;

    /* renamed from: f */
    private int f727f;

    /* renamed from: g */
    private int f728g;

    /* renamed from: h */
    private int f729h;

    /* renamed from: i */
    private int f730i;

    public C0594ak(ActionBarActivity actionBarActivity, String str, Class cls) {
        this.f723b = actionBarActivity;
        this.f724c = str;
        this.f725d = cls;
        this.f726e = (MobileBankingApp) actionBarActivity.getApplicationContext();
        String a = this.f726e.mo5460a("TabBarTextColor");
        String a2 = this.f726e.mo5460a("TabBarImageUnselectedColor");
        String a3 = this.f726e.mo5460a("TabBarImageColorHighlighted");
        String a4 = this.f726e.mo5460a("TabBarTextColorHighlighted");
        try {
            this.f727f = Color.parseColor(a);
        } catch (Exception e) {
            this.f727f = Color.parseColor("#777777");
        }
        try {
            this.f728g = Color.parseColor(a2);
        } catch (Exception e2) {
            this.f728g = Color.parseColor("#777777");
        }
        try {
            this.f729h = Color.parseColor(a4);
        } catch (Exception e3) {
            this.f729h = Color.parseColor("#007FFF");
        }
        try {
            this.f730i = Color.parseColor(a3);
        } catch (Exception e4) {
            this.f730i = Color.parseColor("#007FFF");
        }
    }

    public final void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public final void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f723b != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f723b.getSystemService("input_method");
            if (this.f723b.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f723b.getCurrentFocus().getWindowToken(), 0);
            }
        }
        if (this.f722a == null) {
            this.f722a = Fragment.instantiate(this.f723b, this.f725d.getName());
            fragmentTransaction.add(16908290, this.f722a, this.f724c);
        } else {
            fragmentTransaction.attach(this.f722a);
        }
        if (this.f724c.equalsIgnoreCase("tab_location")) {
            ((C0620bj) this.f722a).mo5547a(((MobileBankingApp) this.f723b.getApplicationContext()).mo5460a("LocationURL"));
        }
        ImageView imageView = (ImageView) tab.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        if (imageView != null) {
            imageView.setColorFilter(this.f730i);
        }
        ((TextView) tab.getCustomView().findViewById(C0137R.C0139id.tab_title)).setTextColor(this.f729h);
    }

    public final void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f722a != null) {
            fragmentTransaction.detach(this.f722a);
        }
        ImageView imageView = (ImageView) tab.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        if (imageView != null) {
            imageView.setColorFilter(this.f728g);
        }
        ((TextView) tab.getCustomView().findViewById(C0137R.C0139id.tab_title)).setTextColor(this.f727f);
    }
}
