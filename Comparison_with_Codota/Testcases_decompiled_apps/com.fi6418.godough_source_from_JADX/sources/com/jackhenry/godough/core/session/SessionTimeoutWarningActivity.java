package com.jackhenry.godough.core.session;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.login.SplashActivity;

public class SessionTimeoutWarningActivity extends Activity {
    public static final String EXTRA_TIMEOUT = "EXTRA_TIMEOUT";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Handler f6776a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f6777b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f6778c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ProgressBar f6779d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f6780e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AlertDialog f6781f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f6782g = new C1892h(this);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Runnable f6783h = new C1893i(this);

    public static int getPercentage(long j) {
        return 100 - ((int) ((((float) (j - System.currentTimeMillis())) / 60000.0f) * 100.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11113a() {
        this.f6776a.removeCallbacks(this.f6783h);
        this.f6779d.setIndeterminate(true);
        new C1894j(this).execute(new Void[0]);
        Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6780e = this;
        this.f6777b = getIntent().getLongExtra(EXTRA_TIMEOUT, Long.MIN_VALUE);
        View inflate = LayoutInflater.from(this).inflate(C1496ak.session_timeout_warning_activity, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setTitle(C1506am.stw_title);
        this.f6779d = (ProgressBar) inflate.findViewById(C1494ai.progress_bar);
        this.f6778c = (TextView) inflate.findViewById(C1494ai.message);
        builder.setNegativeButton(getString(C1506am.stw_btn_continue), new C1889e(this, builder));
        builder.setPositiveButton(getString(C1506am.stw_btn_exit), new C1891g(this));
        this.f6781f = builder.create();
        this.f6781f.show();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f6776a.removeCallbacks(this.f6783h);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f6776a.post(this.f6783h);
    }
}
