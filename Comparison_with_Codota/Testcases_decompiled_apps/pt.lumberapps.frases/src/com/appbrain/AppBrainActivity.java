package com.appbrain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import cmn.C0705a;
import cmn.C0725at;
import com.appbrain.p032a.C0930fk;
import com.appbrain.p032a.C0931fl;

public class AppBrainActivity extends Activity implements C0930fk {

    /* renamed from: a */
    private final C0931fl f2044a = new C0931fl();

    /* renamed from: a */
    public static void m3569a(Context context, Bundle bundle) {
        Intent intent = new Intent(context, AppBrainActivity.class);
        if (C0725at.m3226a(context) == null) {
            intent.addFlags(268435456);
            intent.addFlags(8388608);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public boolean mo3583a() {
        return false;
    }

    /* renamed from: b */
    public void mo3584b() {
        finish();
    }

    /* renamed from: c */
    public boolean mo3585c() {
        return isFinishing();
    }

    /* renamed from: d */
    public boolean mo3586d() {
        return true;
    }

    public Bundle getArguments() {
        Bundle extras = getIntent().getExtras();
        return extras == null ? new Bundle() : extras;
    }

    public Context getContext() {
        return this;
    }

    public void onBackPressed() {
        if (!this.f2044a.mo3834b()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        View a = this.f2044a.mo3831a();
        if (a != null) {
            setContentView(a);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C0705a.m3174a().mo3376a((Activity) this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(this.f2044a.mo3832a(this, bundle));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f2044a.mo3838f();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f2044a.mo3836d();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f2044a.mo3835c();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.f2044a.mo3833a(bundle);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f2044a.mo3837e();
        super.onStop();
    }
}
