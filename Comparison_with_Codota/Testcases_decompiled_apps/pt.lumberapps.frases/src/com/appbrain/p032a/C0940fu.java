package com.appbrain.p032a;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.support.p009v4.app.NotificationCompat;
import android.support.p021v7.p023b.C0515k;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0709ad;
import cmn.C0720ao;
import cmn.C0738bf;
import cmn.C0739bg;
import cmn.C0740bh;
import com.appbrain.C1025d;
import com.appbrain.C1033f;
import com.appbrain.p036e.C1028a;
import com.appbrain.p037f.C1042ah;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.fu */
public class C0940fu extends C0929fj {

    /* renamed from: a */
    static final String f2461a = (C0940fu.class.getName() + ".ao");

    /* renamed from: b */
    static final String f2462b = (C0940fu.class.getName() + ".wm");

    /* renamed from: c */
    private static final Class[] f2463c = {C0937fr.class, C0938fs.class, C0939ft.class};

    /* renamed from: d */
    private static final String f2464d = C0940fu.class.getName();

    /* renamed from: e */
    private static final String f2465e = (f2464d + ".ImpressionCounted");

    /* renamed from: f */
    private static final String f2466f = (f2464d + ".Selected");

    /* renamed from: g */
    private static final String f2467g = (f2464d + ".Light");

    /* renamed from: h */
    private static final String f2468h = (f2464d + ".Starburst");

    /* renamed from: i */
    private static final String f2469i = (f2464d + ".Layout");

    /* renamed from: j */
    private boolean f2470j;

    /* renamed from: k */
    private boolean f2471k;

    /* renamed from: l */
    private int f2472l;

    /* renamed from: m */
    private String f2473m;

    /* renamed from: n */
    private Integer f2474n;

    /* renamed from: o */
    private String f2475o;

    /* renamed from: p */
    private boolean f2476p;

    /* renamed from: q */
    private int f2477q;

    public C0940fu(C0930fk fkVar) {
        super(fkVar);
    }

    /* renamed from: a */
    private Drawable m4015a(int i, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(i);
        return C1028a.m4301a(mo3827h(), (Drawable) shapeDrawable);
    }

    /* renamed from: a */
    private Drawable m4016a(int i, int i2) {
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStrokeWidth((float) C0709ad.m3188b(1.5f));
        paint.setAntiAlias(true);
        C0944fy fyVar = new C0944fy(this, new OvalShape(), paint);
        fyVar.getPaint().setColor(i);
        fyVar.setIntrinsicWidth(C0709ad.m3188b(26.0f));
        fyVar.setIntrinsicHeight(C0709ad.m3188b(26.0f));
        return fyVar;
    }

    /* renamed from: a */
    static /* synthetic */ void m4017a(C0940fu fuVar, C1042ah ahVar, C0945fz fzVar, boolean z) {
        String b;
        int i;
        Context h = fuVar.mo3827h();
        if (ahVar == null || h == null) {
            fuVar.mo3727f();
            return;
        }
        if (fuVar.f2477q < 0 || fuVar.f2477q >= ahVar.mo4194g()) {
            fuVar.f2477q = C0956gj.m4057a().mo3884a(h, ahVar);
        }
        if (fuVar.f2477q < 0) {
            fuVar.mo3727f();
            return;
        }
        String e = ahVar.mo4192e(fuVar.f2477q);
        boolean k = ahVar.mo4202k();
        String a = ahVar.mo4188a(fuVar.f2477q);
        String str = ahVar.mo4199i() + fuVar.f2473m;
        String f = ahVar.mo4193f(fuVar.f2477q);
        int j = ahVar.mo4207p() > fuVar.f2477q ? ahVar.mo4200j(fuVar.f2477q) : 0;
        if (!fuVar.f2476p) {
            fuVar.f2476p = true;
            C0802ar.m3609b(h, str);
        }
        C0943fx fxVar = new C0943fx(fuVar, h, e, k, a, str, f, j);
        fzVar.f2493b.setVisibility(0);
        fzVar.f2493b.setOnClickListener(fxVar);
        fzVar.f2492a.setVisibility(8);
        fzVar.f2495d.setVisibility(0);
        fzVar.f2496e.setVisibility(0);
        if (z) {
            b = ahVar.mo4203l() > fuVar.f2477q ? ahVar.mo4196h(fuVar.f2477q) : null;
            if (TextUtils.isEmpty(b)) {
                String b2 = ahVar.mo4189b(fuVar.f2477q);
                fzVar.f2499h.setScaleType(ImageView.ScaleType.FIT_CENTER);
                fzVar.f2499h.setBackgroundColor(fuVar.f2470j ? 570425344 : -2013265920);
                fzVar.f2499h.mo3869b();
                b = b2;
            } else {
                fzVar.f2499h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        } else {
            b = ahVar.mo4189b(fuVar.f2477q);
            fzVar.f2499h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        fzVar.f2499h.setVisibility(0);
        fzVar.f2499h.setOnClickListener(fxVar);
        C0948gb gbVar = fzVar.f2499h;
        int i2 = gbVar.getLayoutParams().width;
        int i3 = gbVar.getLayoutParams().height;
        if (i2 <= 0 || i3 <= 0) {
            Point a2 = C0705a.m3174a().mo3375a(gbVar.getContext());
            i = (Math.min(a2.x, a2.y) * 2) / 3;
        } else {
            i = Math.max(i2, i3);
        }
        C0720ao.m3213a().mo3407b(fzVar.f2499h, C0739bg.m3252a(b, i, C0740bh.SIZE));
        fzVar.f2497f.setText(ahVar.mo4190c(fuVar.f2477q));
        fzVar.f2497f.setVisibility(0);
        fzVar.f2497f.setOnClickListener(fxVar);
        fzVar.f2498g.setText(ahVar.mo4191d(fuVar.f2477q));
        fzVar.f2498g.setVisibility(0);
        fzVar.f2498g.setOnClickListener(fxVar);
        fzVar.f2500i.setVisibility(0);
        fzVar.f2500i.getChildAt(0).setOnClickListener(fxVar);
        fzVar.f2501j.setVisibility(0);
    }

    /* renamed from: m */
    private View m4018m() {
        Context h = mo3827h();
        Configuration configuration = h.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        boolean z = configuration.orientation == 2;
        int i = this.f2470j ? -16777216 : -1;
        C0947ga o = m4020o();
        C0945fz fzVar = new C0945fz(this);
        C0941fv fvVar = new C0941fv(this);
        fzVar.f2492a = new ProgressBar(h);
        fzVar.f2493b = new TextView(h);
        fzVar.f2493b.setVisibility(8);
        C0705a.m3174a().mo3378a(fzVar.f2493b, m4015a(-1954001, (float) C0709ad.m3188b(4.0f)));
        fzVar.f2493b.setTextColor(-1);
        fzVar.f2493b.setText(C0801aq.m3606a(8, language).toUpperCase());
        fzVar.f2493b.setTextSize(14.0f);
        fzVar.f2493b.setPadding(C0709ad.m3188b(8.0f), C0709ad.m3188b(4.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(4.0f));
        fzVar.f2493b.setTypeface(fzVar.f2493b.getTypeface(), 1);
        fzVar.f2494c = new ImageView(h);
        ImageView imageView = fzVar.f2494c;
        int i2 = this.f2470j ? -4605768 : -1;
        int i3 = this.f2470j ? -10724517 : -7829368;
        int i4 = this.f2470j ? -1 : -16777216;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, m4016a(i3, i4));
        stateListDrawable.addState(new int[0], m4016a(i2, i4));
        imageView.setImageDrawable(stateListDrawable);
        fzVar.f2494c.setOnClickListener(fvVar);
        fzVar.f2495d = new TextView(h);
        fzVar.f2495d.setVisibility(8);
        fzVar.f2495d.setTypeface(fzVar.f2495d.getTypeface(), 1);
        fzVar.f2495d.setTextColor(i);
        fzVar.f2495d.setTextSize(18.0f);
        fzVar.f2495d.setText(C0801aq.m3606a(14, language));
        fzVar.f2496e = new TextView(h);
        fzVar.f2496e.setVisibility(8);
        fzVar.f2496e.setTextColor(i);
        fzVar.f2496e.setTextSize(14.0f);
        fzVar.f2496e.setText(C0801aq.m3606a(15, language) + ":");
        if (Build.VERSION.SDK_INT >= 16) {
            fzVar.f2496e.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        fzVar.f2499h = new C0948gb(h);
        fzVar.f2499h.setVisibility(8);
        if (o.mo3860a()) {
            fzVar.f2499h.mo3868a();
        }
        fzVar.f2497f = new TextView(h);
        fzVar.f2497f.setVisibility(8);
        fzVar.f2497f.setTypeface(fzVar.f2497f.getTypeface(), 1);
        fzVar.f2497f.setTextColor(i);
        fzVar.f2497f.setTextSize(14.0f);
        fzVar.f2498g = new TextView(h);
        fzVar.f2498g.setVisibility(8);
        fzVar.f2498g.setTextColor(i);
        fzVar.f2498g.setTextSize(14.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            fzVar.f2498g.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        TextView textView = new TextView(h);
        textView.setGravity(16);
        textView.setTextColor(-1);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextSize(14.0f);
        textView.setText(C0801aq.m3606a(4, language));
        textView.setCompoundDrawablePadding(C0709ad.m3188b(8.0f));
        C0705a.m3174a().mo3378a(textView, m4015a(-8343745, (float) C0709ad.m3188b(4.0f)));
        ShapeDrawable a = C0838c.m3701a(-1, (C0977x) null);
        a.setBounds(0, 0, C0709ad.m3188b(28.0f), C0709ad.m3188b(28.0f));
        textView.setCompoundDrawables(a, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setPadding(C0709ad.m3188b(16.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(16.0f), C0709ad.m3188b(8.0f));
        TextView textView2 = new TextView(h);
        textView2.setOnClickListener(fvVar);
        textView2.setGravity(16);
        textView2.setTextColor(-1);
        textView2.setTypeface(textView2.getTypeface(), 1);
        textView2.setTextSize(14.0f);
        textView2.setText(C0801aq.m3606a(12, language));
        C0705a.m3174a().mo3378a(textView2, m4015a(-8355712, (float) C0709ad.m3188b(4.0f)));
        textView2.setPadding(C0709ad.m3188b(16.0f), C0709ad.m3188b(8.0f), C0709ad.m3188b(16.0f), C0709ad.m3188b(8.0f));
        fzVar.f2500i = new LinearLayout(h);
        fzVar.f2500i.setVisibility(8);
        fzVar.f2500i.setOrientation(0);
        fzVar.f2500i.addView(textView, new LinearLayout.LayoutParams(0, -1, 1.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.leftMargin = C0709ad.m3188b(4.0f);
        fzVar.f2500i.addView(textView2, layoutParams);
        fzVar.f2501j = new TextView(h);
        fzVar.f2501j.setVisibility(8);
        fzVar.f2501j.setTextColor(ColorStateList.valueOf(i).withAlpha(C0515k.AppCompatTheme_spinnerStyle));
        fzVar.f2501j.setTextSize(11.0f);
        fzVar.f2501j.setText(C0801aq.m3606a(13, language));
        ViewGroup b = z ? o.mo3861b(h, fzVar) : o.mo3859a(h, fzVar);
        b.setBackgroundColor(this.f2470j ? -1 : -13421773);
        if (Build.VERSION.SDK_INT >= 11) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(200);
            layoutTransition.setStartDelay(2, 0);
            layoutTransition.setStartDelay(3, 0);
            layoutTransition.setStartDelay(0, 0);
            layoutTransition.setStartDelay(1, 0);
            b.setLayoutTransition(layoutTransition);
        }
        C0956gj.m4057a().mo3885a(h, C1054at.SINGLE_APP_INTERSTITIAL, this.f2474n, this.f2475o, new C0942fw(this, fzVar, o), true);
        if (!mo3830k()) {
            return b;
        }
        View a2 = m3940a((View) b);
        C0705a.m3174a().mo3378a(a2, m4019n());
        return a2;
    }

    /* renamed from: n */
    private Drawable m4019n() {
        if (!this.f2471k) {
            return new ColorDrawable(-1442840576);
        }
        Point a = C0705a.m3174a().mo3375a(mo3827h());
        Bitmap createBitmap = Bitmap.createBitmap((a.x / 5) + NotificationCompat.FLAG_LOCAL_ONLY, (a.y / 5) + NotificationCompat.FLAG_LOCAL_ONLY, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(-13312);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(((float) (-createBitmap.getWidth())) * 0.5f, ((float) (-createBitmap.getHeight())) * 0.5f, ((float) createBitmap.getWidth()) * 1.5f, ((float) createBitmap.getHeight()) * 1.5f);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-133694);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 360) {
                return new BitmapDrawable(mo3827h().getResources(), createBitmap);
            }
            canvas.drawArc(rectF, (float) i2, 6.0f, true, paint);
            i = i2 + 12;
        }
    }

    /* renamed from: o */
    private C0947ga m4020o() {
        try {
            return (C0947ga) f2463c[this.f2472l].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo3661a() {
        return m4018m();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo3662a(Bundle bundle, Bundle bundle2) {
        int i = 0;
        C1025d dVar = (C1025d) bundle.getSerializable(f2461a);
        if (bundle2 == null) {
            this.f2476p = false;
            this.f2477q = -1;
            C1033f b = dVar == null ? null : dVar.mo4036b();
            this.f2470j = b == C1033f.LIGHT ? true : b == C1033f.DARK ? false : C0738bf.m3251a();
            this.f2471k = mo3830k() && C0738bf.m3251a();
            this.f2472l = C0738bf.m3250a(f2463c.length);
        } else {
            this.f2476p = bundle2.getBoolean(f2465e);
            this.f2477q = bundle2.getInt(f2466f);
            this.f2470j = bundle2.getBoolean(f2467g);
            this.f2471k = bundle2.getBoolean(f2468h);
            this.f2472l = bundle2.getInt(f2469i);
        }
        this.f2475o = dVar.mo4038d();
        C0803as a = new C0803as().mo3646a("single_app");
        int i2 = ((this.f2471k ? 1 : 0) << 12) + ((this.f2472l & 15) << 4) + (this.f2470j ? 1 : 0);
        if (!mo3830k()) {
            i = 1;
        }
        C0803as b2 = a.mo3645a(i2 + (i << 16)).mo3647a(dVar.mo4037c()).mo3649b(bundle.getBoolean(f2462b));
        if (dVar.mo4041g() != null && dVar.mo4041g().mo3617b()) {
            this.f2474n = Integer.valueOf(dVar.mo4041g().mo3616a());
            b2.mo3650c(this.f2474n.intValue());
        }
        this.f2473m = b2.toString();
        return m4018m();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo3825a(Bundle bundle) {
        bundle.putInt(f2466f, this.f2477q);
        bundle.putBoolean(f2467g, this.f2470j);
        bundle.putBoolean(f2468h, this.f2471k);
        bundle.putInt(f2469i, this.f2472l);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo3665d() {
        return true;
    }
}
