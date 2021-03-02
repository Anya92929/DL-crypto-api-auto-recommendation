package com.appbrain.p032a;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0709ad;
import cmn.C0756r;
import com.appbrain.p037f.C1054at;
import com.appbrain.p038g.C1101b;
import com.appbrain.p038g.C1105f;
import com.appbrain.p039h.C1109b;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.appbrain.a.br */
public final class C0829br extends C0929fj {

    /* renamed from: a */
    private static final C1105f f2185a = new C1105f(new C1101b());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0853co f2186b;

    /* renamed from: c */
    private final C0800ap f2187c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WebView f2188d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f2189e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f2190f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1054at f2191g;

    public C0829br(C0930fk fkVar) {
        this(fkVar, C1054at.UNKNOWN_SOURCE);
    }

    private C0829br(C0930fk fkVar, C1054at atVar) {
        super(fkVar);
        this.f2191g = atVar;
        this.f2186b = new C0866da(mo3827h());
        this.f2187c = new C0800ap(mo3827h(), true, new C0830bs(this));
    }

    /* renamed from: a */
    static String m3684a(C1109b bVar) {
        byte[] b = f2185a.mo4381a(bVar).mo3915b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(b);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
        } catch (Exception e) {
        }
        return "data=" + C0756r.m3312b(byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo3662a(Bundle bundle, Bundle bundle2) {
        this.f2191g = C1054at.m4682a(bundle.getInt("src", -1));
        String a = C0932fm.m3968a().mo3841a("owserver", C0793ai.f2084d);
        if (this.f2191g == C1054at.NO_PLAY_STORE) {
            this.f2190f = a + C0932fm.m3968a().mo3841a("noplaypath", "/no-google-play");
        } else {
            this.f2190f = a + C0932fm.m3968a().mo3841a("offer_url", "/offerwall/");
        }
        this.f2188d = new WebView(mo3827h());
        C0842cd.m3722a(this.f2188d);
        this.f2188d.addJavascriptInterface(this.f2187c, "adApi");
        this.f2188d.setWebChromeClient(new C0833bv(this, (byte) 0));
        this.f2188d.setBackgroundColor(0);
        this.f2188d.setWebViewClient(new C0831bt(this));
        this.f2188d.setVerticalScrollBarEnabled(true);
        this.f2188d.setHorizontalScrollBarEnabled(false);
        int b = C0709ad.m3188b(16.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-2013265920);
        gradientDrawable.setCornerRadius((float) b);
        ProgressBar progressBar = new ProgressBar(mo3827h());
        progressBar.setIndeterminate(true);
        if (Build.VERSION.SDK_INT >= 21) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(-3355444));
        }
        TextView textView = new TextView(mo3827h());
        textView.setText(C0801aq.m3606a(18, mo3827h().getResources().getConfiguration().locale.getLanguage()));
        textView.setTextColor(-3355444);
        textView.setPadding(0, b, 0, 0);
        LinearLayout linearLayout = new LinearLayout(mo3827h());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        C0705a.m3174a().mo3378a(linearLayout, gradientDrawable);
        linearLayout.setPadding(b, b, b, b);
        linearLayout.addView(progressBar, -2, -2);
        linearLayout.addView(textView, -2, -2);
        this.f2189e = linearLayout;
        View a2 = C0934fo.m3994a((View) this.f2188d, this.f2189e);
        this.f2189e.setVisibility(0);
        new C0832bu(this, bundle).mo3410a((Object[]) new Void[0]);
        C0884ds.m3838b();
        return a2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo3663b() {
        this.f2187c.sendImpression();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo3664c() {
        if (this.f2188d != null) {
            this.f2188d.getSettings().setJavaScriptEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo3665d() {
        return this.f2191g == C1054at.SKIPPED_INTERSTITIAL || this.f2191g == C1054at.DIRECT;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final boolean mo3699e() {
        if (this.f2188d == null || !this.f2188d.canGoBack()) {
            return false;
        }
        this.f2188d.goBack();
        return true;
    }
}
