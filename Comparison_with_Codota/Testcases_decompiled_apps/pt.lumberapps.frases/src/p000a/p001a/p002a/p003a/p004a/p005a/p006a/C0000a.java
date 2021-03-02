package p000a.p001a.p002a.p003a.p004a.p005a.p006a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.p009v4.app.NotificationCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: a.a.a.a.a.a.a.a */
public final class C0000a {

    /* renamed from: a */
    private final CharSequence f0a;

    /* renamed from: b */
    private final C0002c f1b;

    /* renamed from: c */
    private final View f2c;

    /* renamed from: d */
    private Activity f3d;

    /* renamed from: e */
    private FrameLayout f4e;

    /* renamed from: f */
    private Animation f5f;

    /* renamed from: g */
    private Animation f6g;

    private C0000a(Activity activity, CharSequence charSequence, C0002c cVar) {
        if (activity == null || charSequence == null || cVar == null) {
            throw new IllegalArgumentException("Null parameters are not accepted");
        }
        this.f3d = activity;
        this.f0a = charSequence;
        this.f1b = cVar;
        this.f2c = null;
    }

    /* renamed from: a */
    public static C0000a m0a(Activity activity, CharSequence charSequence, C0002c cVar) {
        return new C0000a(activity, charSequence, cVar);
    }

    /* renamed from: a */
    public static void m1a() {
        C0001b.m11a().mo10b();
    }

    /* renamed from: j */
    private void m2j() {
        Resources resources = this.f3d.getResources();
        this.f4e = new FrameLayout(this.f3d);
        int i = this.f1b.f18j;
        if (this.f1b.f19k > 0) {
            i = resources.getDimensionPixelSize(this.f1b.f19k);
        }
        this.f4e.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
        if (this.f1b.f15g != -1) {
            this.f4e.setBackgroundColor(this.f1b.f15g);
        } else {
            this.f4e.setBackgroundColor(resources.getColor(this.f1b.f13e));
        }
        if (this.f1b.f14f != 0) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, this.f1b.f14f));
            if (this.f1b.f16h) {
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            }
            this.f4e.setBackgroundDrawable(bitmapDrawable);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f3d);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i2 = this.f1b.f32x;
        if (this.f1b.f33y > 0) {
            i2 = resources.getDimensionPixelSize(this.f1b.f33y);
        }
        relativeLayout.setPadding(i2, i2, i2, i2);
        ImageView imageView = null;
        if (!(this.f1b.f21m == null && this.f1b.f22n == 0)) {
            imageView = new ImageView(this.f3d);
            imageView.setId(NotificationCompat.FLAG_LOCAL_ONLY);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(this.f1b.f23o);
            if (this.f1b.f21m != null) {
                imageView.setImageDrawable(this.f1b.f21m);
            }
            if (this.f1b.f22n != 0) {
                imageView.setImageResource(this.f1b.f22n);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9, -1);
            layoutParams.addRule(15, -1);
            relativeLayout.addView(imageView, layoutParams);
        }
        TextView textView = new TextView(this.f3d);
        textView.setId(257);
        textView.setText(this.f0a);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(this.f1b.f20l);
        if (this.f1b.f17i != 0) {
            textView.setTextColor(resources.getColor(this.f1b.f17i));
        }
        if (this.f1b.f24p != 0) {
            textView.setTextSize(2, (float) this.f1b.f24p);
        }
        if (this.f1b.f25q != 0) {
            textView.setShadowLayer(this.f1b.f26r, this.f1b.f28t, this.f1b.f27s, resources.getColor(this.f1b.f25q));
        }
        if (this.f1b.f29u != 0) {
            textView.setTextAppearance(this.f3d, this.f1b.f29u);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        if (imageView != null) {
            layoutParams2.addRule(1, imageView.getId());
        }
        relativeLayout.addView(textView, layoutParams2);
        this.f4e.addView(relativeLayout);
    }

    /* renamed from: b */
    public void mo1b() {
        C0001b.m11a().mo9a(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo2c() {
        return (this.f3d == null || this.f4e == null || this.f4e.getParent() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo3d() {
        this.f3d = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0002c mo4e() {
        return this.f1b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Activity mo5f() {
        return this.f3d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public View mo6g() {
        if (this.f2c != null) {
            return this.f2c;
        }
        if (this.f4e == null) {
            m2j();
        }
        return this.f4e;
    }

    /* renamed from: h */
    public Animation mo7h() {
        if (this.f5f == null && this.f3d != null) {
            this.f5f = AnimationUtils.loadAnimation(mo5f(), mo4e().f30v);
        }
        return this.f5f;
    }

    /* renamed from: i */
    public Animation mo8i() {
        if (this.f6g == null && this.f3d != null) {
            this.f6g = AnimationUtils.loadAnimation(mo5f(), mo4e().f31w);
        }
        return this.f6g;
    }
}
