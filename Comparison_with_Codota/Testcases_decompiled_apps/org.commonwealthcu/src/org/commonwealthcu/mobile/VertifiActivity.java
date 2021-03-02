package org.commonwealthcu.mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0137R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vertifi.RDCGlobal;
import org.p004a.p005a.p007b.p008a.C0250b;

public class VertifiActivity extends C0584aa {

    /* renamed from: a */
    private C0599ap f685a;

    /* renamed from: b */
    private C0612bb f686b;

    public void deletePressed(View view) {
        C0250b.m92a(getApplicationContext(), view);
        this.f686b = (C0612bb) getSupportFragmentManager().findFragmentByTag("review");
        if (this.f686b != null) {
            this.f686b.deletePressed(view);
        }
    }

    public void editList(View view) {
        C0250b.m92a(getApplicationContext(), view);
        this.f686b = (C0612bb) getSupportFragmentManager().findFragmentByTag("review");
        if (this.f686b != null) {
            this.f686b.editList(view);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        super.onCreate(bundle);
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplicationContext();
        RDCGlobal.init(getApplicationContext());
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setNavigationMode(2);
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setDisplayUseLogoEnabled(false);
        supportActionBar.setDisplayShowHomeEnabled(false);
        String a = mobileBankingApp.mo5460a("TabBarTextColor");
        String a2 = mobileBankingApp.mo5460a("TabBarImageUnselectedColor");
        try {
            z = true;
            i = Color.parseColor(a);
        } catch (Exception e) {
            i = 0;
            z = false;
        }
        try {
            parseColor = Color.parseColor(a2);
        } catch (Exception e2) {
            parseColor = Color.parseColor("#777777");
        }
        try {
            parseColor2 = Color.parseColor(mobileBankingApp.mo5460a("TabBarColor"));
        } catch (Exception e3) {
            parseColor2 = Color.parseColor("#FFFFFF");
        }
        supportActionBar.setStackedBackgroundDrawable(new ColorDrawable(parseColor2));
        getResources().getDrawable(C0137R.C0138drawable.indicator_hidden).setColorFilter(parseColor2, PorterDuff.Mode.SRC_ATOP);
        ActionBar.Tab tabListener = supportActionBar.newTab().setTabListener(new C0617bg(this, "deposit", C0599ap.class));
        tabListener.setCustomView((int) C0137R.layout.custom_tab);
        ImageView imageView = (ImageView) tabListener.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        imageView.setColorFilter(parseColor);
        imageView.setImageResource(C0137R.C0138drawable.ic_action_camera);
        TextView textView = (TextView) tabListener.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView.setText("Deposit");
        textView.setTypeface(C0250b.m81a(getApplicationContext()));
        textView.setTextSize(12.0f);
        if (z) {
            textView.setTextColor(i);
        }
        supportActionBar.addTab(tabListener);
        ActionBar.Tab tabListener2 = supportActionBar.newTab().setTabListener(new C0617bg(this, "review", C0612bb.class));
        tabListener2.setCustomView((int) C0137R.layout.custom_tab);
        ImageView imageView2 = (ImageView) tabListener2.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        imageView2.setColorFilter(parseColor);
        imageView2.setImageResource(C0137R.C0138drawable.ic_action_search);
        TextView textView2 = (TextView) tabListener2.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView2.setText("Review");
        textView2.setTypeface(C0250b.m81a(getApplicationContext()));
        textView2.setTextSize(12.0f);
        if (z) {
            textView2.setTextColor(i);
        }
        supportActionBar.addTab(tabListener2);
        ActionBar.Tab tabListener3 = supportActionBar.newTab().setTabListener(new C0617bg(this, "history", C0608ay.class));
        tabListener3.setCustomView((int) C0137R.layout.custom_tab);
        ImageView imageView3 = (ImageView) tabListener3.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        imageView3.setColorFilter(parseColor);
        imageView3.setImageResource(C0137R.C0138drawable.ic_action_collection);
        TextView textView3 = (TextView) tabListener3.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView3.setText("History");
        textView3.setTypeface(C0250b.m81a(getApplicationContext()));
        textView3.setTextSize(12.0f);
        if (z) {
            textView3.setTextColor(i);
        }
        supportActionBar.addTab(tabListener3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r0 = getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            r0 = 4
            if (r4 != r0) goto L_0x0027
            int r0 = r5.getRepeatCount()
            if (r0 != 0) goto L_0x0027
            android.support.v4.app.FragmentManager r0 = r3.getSupportFragmentManager()
            java.lang.String r1 = "Review_Browser"
            android.support.v4.app.Fragment r1 = r0.findFragmentByTag(r1)
            if (r1 == 0) goto L_0x0027
            boolean r2 = r1.isVisible()
            if (r2 == 0) goto L_0x0027
            android.support.v4.app.FragmentTransaction r0 = r0.beginTransaction()
            r0.remove(r1)
            r0.commit()
            r0 = 1
        L_0x0026:
            return r0
        L_0x0027:
            boolean r0 = super.onKeyDown(r4, r5)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonwealthcu.mobile.VertifiActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public void startCameraActivity(View view) {
        this.f685a = (C0599ap) getSupportFragmentManager().findFragmentByTag("deposit");
        C0250b.m92a(getApplicationContext(), view);
        this.f685a.startCameraActivity(view);
    }

    public void startCameraActivityBack(View view) {
        this.f685a = (C0599ap) getSupportFragmentManager().findFragmentByTag("deposit");
        C0250b.m92a(getApplicationContext(), view);
        this.f685a.startCameraActivityBack(view);
    }

    public void submitDeposit(View view) {
        this.f685a = (C0599ap) getSupportFragmentManager().findFragmentByTag("deposit");
        C0250b.m92a(getApplicationContext(), view);
        this.f685a.submitDeposit(view);
    }
}
