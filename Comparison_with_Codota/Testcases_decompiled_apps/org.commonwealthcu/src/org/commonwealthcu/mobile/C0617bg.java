package org.commonwealthcu.mobile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.app.ActionBarActivity;
import android.support.p003v7.appcompat.C0137R;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.bg */
public final class C0617bg implements ActionBar.TabListener {

    /* renamed from: a */
    private Fragment f818a = this.f822e.getSupportFragmentManager().findFragmentByTag(this.f820c);

    /* renamed from: b */
    private final Activity f819b;

    /* renamed from: c */
    private final String f820c;

    /* renamed from: d */
    private final Class f821d;

    /* renamed from: e */
    private final ActionBarActivity f822e;

    /* renamed from: f */
    private MobileBankingApp f823f;

    /* renamed from: g */
    private int f824g;

    /* renamed from: h */
    private int f825h;

    /* renamed from: i */
    private int f826i;

    /* renamed from: j */
    private int f827j;

    public C0617bg(Activity activity, String str, Class cls) {
        this.f819b = activity;
        this.f820c = str;
        this.f821d = cls;
        this.f822e = (ActionBarActivity) activity;
        this.f823f = (MobileBankingApp) activity.getApplicationContext();
        String a = this.f823f.mo5460a("TabBarTextColor");
        String a2 = this.f823f.mo5460a("TabBarImageUnselectedColor");
        String a3 = this.f823f.mo5460a("TabBarImageColorHighlighted");
        String a4 = this.f823f.mo5460a("TabBarTextColorHighlighted");
        try {
            this.f824g = Color.parseColor(a);
        } catch (Exception e) {
            this.f824g = Color.parseColor("#777777");
        }
        try {
            this.f825h = Color.parseColor(a2);
        } catch (Exception e2) {
            this.f825h = Color.parseColor("#777777");
        }
        try {
            this.f826i = Color.parseColor(a4);
        } catch (Exception e3) {
            this.f826i = Color.parseColor("#007FFF");
        }
        try {
            this.f827j = Color.parseColor(a3);
        } catch (Exception e4) {
            this.f827j = Color.parseColor("#007FFF");
        }
    }

    public final void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        System.out.println("OnTabReelected");
    }

    public final void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        System.out.println("OnTabSelected");
        if (this.f819b != null) {
            System.out.println("OnTabS - mActivity is null");
            InputMethodManager inputMethodManager = (InputMethodManager) this.f819b.getSystemService("input_method");
            if (this.f819b.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f819b.getCurrentFocus().getWindowToken(), 0);
            }
        }
        if (this.f818a == null) {
            System.out.println("OnTabS - mFragment is null");
            this.f818a = Fragment.instantiate(this.f819b, this.f821d.getName());
            fragmentTransaction.add(16908290, this.f818a, this.f820c);
        } else {
            System.out.println("OnTabS - reattaching old");
            fragmentTransaction.attach(this.f818a);
        }
        ImageView imageView = (ImageView) tab.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        if (imageView != null) {
            imageView.setColorFilter(this.f827j);
        }
        TextView textView = (TextView) tab.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView.setTextColor(this.f826i);
        textView.setTypeface(C0250b.m81a((Context) this.f819b));
    }

    public final void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        System.out.println("OnTabUnselected");
        if (this.f818a != null) {
            fragmentTransaction.detach(this.f818a);
        }
        ImageView imageView = (ImageView) tab.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        if (imageView != null) {
            imageView.setColorFilter(this.f825h);
        }
        TextView textView = (TextView) tab.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView.setTextColor(this.f824g);
        textView.setTypeface(C0250b.m81a((Context) this.f819b));
    }
}
