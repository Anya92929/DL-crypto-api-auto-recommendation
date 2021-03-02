package com.appbrain.p032a;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cmn.C0709ad;
import cmn.C0752n;

/* renamed from: com.appbrain.a.cp */
public final class C0854cp extends C0929fj {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f2261a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WebView f2262b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f2263c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0844cf f2264d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f2265e;

    public C0854cp(C0930fk fkVar) {
        super(fkVar);
    }

    /* renamed from: a */
    private String m3755a(String str) {
        if (this.f2264d == null) {
            return null;
        }
        return C0842cd.m3717a(this.f2264d.f2227d, str);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m3756a(C0854cp cpVar, String str) {
        boolean z = false;
        if (!TextUtils.equals(str, "about:blank")) {
            if (cpVar.mo3829j()) {
                return true;
            }
            if (TextUtils.equals(cpVar.m3755a("inthndl"), "1") && str.startsWith("intent://")) {
                if (!str.contains(cpVar.f2264d.f2225b)) {
                    z = C0842cd.m3730c(cpVar.mo3827h(), str, cpVar.f2264d);
                }
                if (!z) {
                    C0842cd.m3723a(cpVar.mo3827h(), Uri.parse(cpVar.f2265e));
                }
                cpVar.mo3727f();
                return true;
            } else if (C0842cd.m3728b(cpVar.mo3827h(), str, cpVar.f2264d)) {
                cpVar.mo3727f();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo3662a(Bundle bundle, Bundle bundle2) {
        this.f2264d = (C0844cf) bundle.getSerializable("clk");
        ProgressBar progressBar = new ProgressBar(mo3827h());
        TextView textView = new TextView(mo3827h());
        textView.setGravity(1);
        textView.setText("It seems you are not connected to the internet.");
        Button button = new Button(mo3827h());
        button.setText("Retry");
        button.setOnClickListener(new C0857cs(this));
        int b = C0709ad.m3188b(16.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, b, 0, 0);
        LinearLayout linearLayout = new LinearLayout(mo3827h());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setPadding(b, b, b, b);
        linearLayout.addView(textView, -1, -2);
        linearLayout.addView(button, layoutParams);
        this.f2263c = linearLayout;
        this.f2263c.setVisibility(8);
        String a = m3755a("ua");
        if (a == null) {
            a = C0752n.m3278b().mo3445s();
            if (C0932fm.m3968a().mo3840a("nocustua", 0) == 0) {
                a = a + " AppBrain";
            }
        }
        this.f2262b = new WebView(mo3827h());
        this.f2262b.getSettings().setJavaScriptEnabled(true);
        this.f2262b.getSettings().setUserAgentString(a);
        this.f2262b.setWebViewClient(new C0855cq(this, progressBar));
        this.f2265e = bundle.getString("url");
        this.f2262b.loadUrl(this.f2265e);
        FrameLayout frameLayout = new FrameLayout(mo3827h());
        frameLayout.addView(this.f2262b, -1, -1);
        frameLayout.addView(progressBar, new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.addView(this.f2263c, -1, -1);
        return frameLayout;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo3665d() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo3727f() {
        if (this.f2262b != null) {
            this.f2262b.stopLoading();
        }
        super.mo3727f();
    }
}
