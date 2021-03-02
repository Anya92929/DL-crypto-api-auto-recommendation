package com.appbrain.p032a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0708ac;
import cmn.C0709ad;
import cmn.C0715aj;
import cmn.C0726au;
import com.appbrain.C0783a;
import com.appbrain.C1025d;
import com.appbrain.C1033f;
import com.appbrain.p036e.C1028a;
import com.appbrain.p037f.C1054at;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.appbrain.a.ay */
public class C0809ay extends C0929fj {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Future f2133a;

    /* renamed from: b */
    private static C0708ac f2134b;

    /* renamed from: c */
    private C0820bi f2135c;

    /* renamed from: d */
    private boolean f2136d;

    /* renamed from: e */
    private boolean f2137e;

    /* renamed from: f */
    private LinearLayout f2138f;

    /* renamed from: g */
    private LayerDrawable f2139g;

    /* renamed from: h */
    private boolean f2140h;

    /* renamed from: i */
    private boolean f2141i;

    /* renamed from: j */
    private String f2142j;

    /* renamed from: k */
    private Integer f2143k;

    public C0809ay(C0930fk fkVar) {
        super(fkVar);
    }

    /* renamed from: a */
    private static int m3629a(int i) {
        return (((int) Math.sqrt(Math.pow((double) i, 2.0d) / 2.0d)) / 2) + (i / 2);
    }

    /* renamed from: a */
    private View m3630a(int i, View view, int[] iArr) {
        FrameLayout frameLayout = new FrameLayout(mo3827h());
        view.setLayoutParams(new FrameLayout.LayoutParams(i, i));
        C0705a a = C0705a.m3174a();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setShaderFactory(new C0816be(this, iArr));
        a.mo3378a(view, C1028a.m4301a(mo3827h(), (Drawable) shapeDrawable));
        int sqrt = (i - ((int) Math.sqrt(Math.pow((double) i, 2.0d) / 2.0d))) / 2;
        view.setPadding(sqrt, sqrt, sqrt, sqrt);
        if ((iArr[0] & -16777216) == -16777216 && (iArr[1] & -16777216) == -16777216) {
            int b = C0709ad.m3188b(5.0f);
            int i2 = i + b;
            View view2 = new View(mo3827h());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i2, i2);
            marginLayoutParams.setMargins((-b) / 2, b, 0, 0);
            view2.setLayoutParams(marginLayoutParams);
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
            shapeDrawable2.setShaderFactory(new C0818bg(this, b));
            C0705a.m3174a().mo3378a(view2, shapeDrawable2);
            frameLayout.addView(view2);
        }
        frameLayout.addView(view);
        return frameLayout;
    }

    /* renamed from: a */
    private String m3631a(C0826bo boVar) {
        String a = C0932fm.m3968a().mo3841a("intclpr", "inst");
        if (this.f2136d) {
            return a + "_n";
        }
        String queryParameter = Uri.parse(boVar.mo3689c()).getQueryParameter("class");
        return queryParameter == null ? a + "_web" : a + "_web_" + queryParameter;
    }

    /* renamed from: a */
    public static synchronized void m3632a(Context context) {
        synchronized (C0809ay.class) {
            if (f2133a == null) {
                f2133a = C0726au.f1794a.submit(new C0812ba(context));
            } else {
                m3637m();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3633a(C0809ay ayVar) {
        ayVar.f2140h = true;
        C0794aj.m3604a(ayVar.mo3826g(), C0799ao.AD_CLICKED);
        ayVar.mo3828i();
        C0936fq fqVar = new C0936fq(ayVar.f2141i ? C1054at.MAYBE_INTERSTITIAL : C1054at.INTERSTITIAL);
        fqVar.f2454b = ayVar.mo3826g();
        fqVar.f2455c = ayVar.f2142j;
        fqVar.f2460h = ayVar.f2143k;
        C0934fo.m3998a(ayVar.mo3827h(), fqVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m3634a(C0809ay ayVar, int i, int i2) {
        ayVar.f2139g.getDrawable(1).setAlpha(255);
        Rect rect = new Rect();
        Point point = new Point();
        if (ayVar.f2138f.getGlobalVisibleRect(rect, point)) {
            int i3 = i - point.x;
            int i4 = i2 - point.y;
            int b = C0709ad.m3188b(300.0f) / 2;
            int i5 = i3 - b;
            int width = rect.width() - (i3 + b);
            ayVar.f2139g.setLayerInset(1, i5, i4 - b, width, rect.height() - (i4 + b));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static void m3637m() {
        new C0810az().mo3410a((Object[]) new Void[0]);
    }

    /* renamed from: n */
    private static C0826bo m3638n() {
        C0826bo boVar;
        try {
            synchronized (C0809ay.class) {
                boVar = (C0826bo) f2133a.get(0, TimeUnit.SECONDS);
            }
            return boVar;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            return null;
        }
    }

    /* renamed from: o */
    private View m3639o() {
        Configuration configuration = mo3827h().getResources().getConfiguration();
        boolean z = configuration.orientation == 2 && (Build.VERSION.SDK_INT < 13 ? 0 : configuration.screenHeightDp) < 400;
        String language = configuration.locale.getLanguage();
        C0822bk bkVar = new C0822bk(new C0825bn((byte) 0).mo3683a(this.f2137e ? C0822bk.m3649a().mo3681a(-1117707, -3618614).mo3680a(-13224394).mo3679a() : C0822bk.m3649a().mo3681a(-12303292, -15592942).mo3680a(-1).mo3679a()).mo3684b(C0822bk.m3649a().mo3681a(-8343745, -8343745).mo3680a(-1117707).mo3682b(0).mo3679a()).mo3685c(C0822bk.m3649a().mo3681a(-4991873, -7819699).mo3680a(-1).mo3682b(-10716373).mo3679a()).mo3686d(C0822bk.m3649a().mo3681a(-8289919, -12895429).mo3680a(-1).mo3682b(-14540254).mo3679a()), (byte) 0);
        int b = C0709ad.m3188b(20.0f);
        int b2 = C0709ad.m3188b(32.0f);
        TextView textView = null;
        if (this.f2143k != null && this.f2143k.equals(Integer.valueOf(C0783a.f2051e.mo3616a()))) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = b2;
            TextView textView2 = new TextView(mo3827h());
            textView2.setLayoutParams(layoutParams);
            textView2.setTextColor(bkVar.f2159b.f2165c);
            textView2.setTextSize(20.0f);
            textView2.setTypeface(textView2.getTypeface(), 1);
            textView2.setGravity(1);
            textView2.setText(C0926fg.m3925a().mo3821e() ? C0801aq.m3606a(9, language) : "AppBrain SDK requires changes to your proguard config as detailed in the documentation!");
            textView = textView2;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = b2;
        layoutParams2.weight = z ? 1.0f : 0.0f;
        TextView textView3 = new TextView(mo3827h());
        textView3.setLayoutParams(layoutParams2);
        textView3.setTextColor(bkVar.f2160c.f2165c);
        textView3.setTextSize(18.0f);
        textView3.setTypeface(textView3.getTypeface(), 1);
        C0705a a = C0705a.m3174a();
        C0823bl blVar = bkVar.f2160c;
        float[] fArr = new float[8];
        Arrays.fill(fArr, C0709ad.m3186a(1.0f));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(blVar.f2163a[0]);
        shapeDrawable.setPadding(C0709ad.m3188b(24.0f), C0709ad.m3188b(12.0f), C0709ad.m3188b(24.0f), C0709ad.m3188b(12.0f));
        a.mo3378a(textView3, shapeDrawable);
        textView3.setGravity(17);
        textView3.setText(C0801aq.m3606a(10, language));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(9);
        TextView textView4 = new TextView(mo3827h());
        textView4.setText(C0801aq.m3606a(11, language));
        textView4.setTextColor(bkVar.f2161d.f2165c);
        textView4.setTextSize(20.0f);
        textView4.setTypeface(textView4.getTypeface(), 1);
        textView4.setGravity(17);
        textView4.setOnClickListener(new C0813bb(this));
        textView4.getViewTreeObserver().addOnGlobalLayoutListener(new C0814bc(this, textView4));
        View a2 = m3630a(C0709ad.m3188b(120.0f), (View) textView4, bkVar.f2161d.f2163a);
        a2.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(12);
        layoutParams4.addRule(11);
        C0715aj ajVar = new C0715aj(mo3827h());
        ajVar.setTextColor(bkVar.f2162e.f2165c);
        ajVar.setTypeface(ajVar.getTypeface(), 1);
        ajVar.setGravity(17);
        ajVar.setOnClickListener(new C0815bd(this));
        String a3 = C0801aq.m3606a(12, language);
        ajVar.setMaxLines(Math.min(a3.split("\t").length, 3));
        ajVar.setTextSize(16.0f);
        ajVar.setText(a3);
        View a4 = m3630a(C0709ad.m3188b(80.0f), (View) ajVar, bkVar.f2162e.f2163a);
        a4.setLayoutParams(layoutParams4);
        int a5 = m3629a(textView4.getLayoutParams().width) + m3629a(ajVar.getLayoutParams().width);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(C0709ad.m3188b(18.0f) + a5, a5 - C0709ad.m3188b(20.0f));
        layoutParams5.leftMargin = z ? b : 0;
        RelativeLayout relativeLayout = new RelativeLayout(mo3827h());
        relativeLayout.setLayoutParams(layoutParams5);
        relativeLayout.addView(a4);
        relativeLayout.addView(a2);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 1;
        LinearLayout linearLayout = new LinearLayout(mo3827h());
        linearLayout.setLayoutParams(layoutParams6);
        linearLayout.setGravity(1);
        linearLayout.addView(textView3);
        linearLayout.addView(relativeLayout);
        linearLayout.setOrientation(z ? 0 : 1);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
        shapeDrawable2.setShaderFactory(new C0817bf(this));
        Drawable[] drawableArr = {new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, bkVar.f2159b.f2163a), shapeDrawable2};
        drawableArr[1].setAlpha(0);
        this.f2139g = new LayerDrawable(drawableArr);
        this.f2138f = new LinearLayout(mo3827h());
        this.f2138f.setOrientation(1);
        C0705a.m3174a().mo3378a(this.f2138f, this.f2139g);
        this.f2138f.setPadding(b, b2, b, b2);
        if (textView != null) {
            this.f2138f.addView(textView);
        }
        this.f2138f.addView(linearLayout);
        return this.f2138f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo3661a() {
        if (this.f2136d) {
            return m3639o();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo3662a(Bundle bundle, Bundle bundle2) {
        View view;
        C0926fg.m3925a().mo3817a(mo3827h(), true, false);
        this.f2141i = bundle.getBoolean("maybe");
        C1025d dVar = (C1025d) bundle.getSerializable("adop");
        this.f2137e = dVar.mo4036b() == C1033f.f2692b;
        this.f2142j = dVar.mo4038d();
        if (dVar.mo4041g() != null && dVar.mo4041g().mo3617b()) {
            this.f2143k = Integer.valueOf(dVar.mo4041g().mo3616a());
        }
        C0826bo n = m3638n();
        byte[] b = n != null ? n.mo3688b() : null;
        this.f2136d = b == null;
        if (bundle2 == null) {
            C0803as a = new C0803as().mo3646a(m3631a(n)).mo3647a(dVar.mo4037c()).mo3649b(this.f2141i).mo3645a((this.f2137e ? 1 : 0) + ((mo3830k() ? 0 : 1) << 4));
            if (this.f2143k != null) {
                a.mo3650c(this.f2143k.intValue());
            }
            C0802ar.m3609b(mo3827h(), a.toString());
        }
        if (this.f2136d) {
            view = m3639o();
        } else {
            this.f2135c = new C0820bi(this, mo3827h(), true, new C0819bh(this));
            WebView webView = new WebView(mo3827h());
            webView.setBackgroundColor(0);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(this.f2135c, "appbrain");
            webView.loadDataWithBaseURL((String) null, new String(b), "text/html", "UTF-8", (String) null);
            view = webView;
        }
        if (TextUtils.isEmpty(this.f2142j)) {
            this.f2142j = m3631a(n);
        } else {
            this.f2142j += "&" + m3631a(n);
        }
        return view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo3663b() {
        if (this.f2135c != null) {
            this.f2135c.sendImpression();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo3664c() {
        if (f2134b != null) {
            f2134b.mo3385a(Boolean.valueOf(this.f2140h));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo3665d() {
        return true;
    }
}
