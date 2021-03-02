package com.flurry.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    private static volatile String f11a = "<html><body><table height='100%' width='100%' border='0'><tr><td style='vertical-align:middle;text-align:center'>No recommendations available<p><button type='input' onClick='activity.finish()'>Back</button></td></tr></table></body></html>";

    /* renamed from: b */
    private WebView f12b;

    /* renamed from: c */
    private C0122x f13c;

    /* renamed from: d */
    private List f14d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0120v f15e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0114p f16f;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Long valueOf;
        setTheme(16973839);
        super.onCreate(bundle);
        this.f15e = FlurryAgent.m29b();
        Intent intent = getIntent();
        if (!(intent.getExtras() == null || (valueOf = Long.valueOf(intent.getExtras().getLong("o"))) == null)) {
            this.f16f = this.f15e.mo3351b(valueOf.longValue());
        }
        C0089ac acVar = new C0089ac(this, this);
        acVar.setId(1);
        acVar.setBackgroundColor(-16777216);
        this.f12b = new WebView(this);
        this.f12b.setId(2);
        this.f12b.setScrollBarStyle(0);
        this.f12b.setBackgroundColor(-1);
        if (this.f16f != null) {
            this.f12b.setWebViewClient(new C0115q(this));
        }
        this.f12b.getSettings().setJavaScriptEnabled(true);
        this.f12b.addJavascriptInterface(this, "activity");
        this.f13c = new C0122x(this, this);
        this.f13c.setId(3);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, acVar.getId());
        relativeLayout.addView(acVar, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, acVar.getId());
        layoutParams2.addRule(2, this.f13c.getId());
        relativeLayout.addView(this.f12b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12, acVar.getId());
        relativeLayout.addView(this.f13c, layoutParams3);
        Bundle extras = getIntent().getExtras();
        String string = extras == null ? null : extras.getString("u");
        if (string == null) {
            this.f12b.loadDataWithBaseURL((String) null, f11a, "text/html", "utf-8", (String) null);
        } else {
            this.f12b.loadUrl(string);
        }
        setContentView(relativeLayout);
    }

    public void finish() {
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f15e.mo3359g();
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view instanceof C0124z) {
            C0123y yVar = new C0123y();
            yVar.f271a = this.f12b.getUrl();
            yVar.f272b = new ArrayList(this.f13c.mo3373b());
            this.f14d.add(yVar);
            if (this.f14d.size() > 5) {
                this.f14d.remove(0);
            }
            C0123y yVar2 = new C0123y();
            C0124z zVar = (C0124z) view;
            this.f16f = this.f15e.mo3352b(zVar.mo3374a());
            zVar.mo3375a(this.f16f);
            yVar2.f271a = this.f15e.mo3361i() + this.f15e.mo3335a(zVar.mo3374a());
            yVar2.f272b = this.f13c.mo3370a(view.getContext());
            m4a(yVar2);
        } else if (view.getId() == 10000) {
            finish();
        } else if (view.getId() == 10002) {
            this.f13c.mo3371a();
        } else if (this.f14d.isEmpty()) {
            finish();
        } else {
            m4a((C0123y) this.f14d.remove(this.f14d.size() - 1));
        }
    }

    /* renamed from: a */
    private void m4a(C0123y yVar) {
        try {
            this.f12b.loadUrl(yVar.f271a);
            this.f13c.mo3372a(yVar.f272b);
        } catch (Exception e) {
            C0095ai.m96a("FlurryAgent", "Error loading url: " + yVar.f271a);
        }
    }
}
