package android.support.p001v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.p001v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.MaterialProgressDrawable */
class MaterialProgressDrawable extends Drawable implements Animatable {

    /* renamed from: b */
    private static final Interpolator f1208b = new LinearInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Interpolator f1209c = new FastOutSlowInInterpolator();

    /* renamed from: a */
    boolean f1210a;

    /* renamed from: d */
    private final int[] f1211d = {-16777216};

    /* renamed from: e */
    private final ArrayList<Animation> f1212e = new ArrayList<>();

    /* renamed from: f */
    private final C0421a f1213f;

    /* renamed from: g */
    private float f1214g;

    /* renamed from: h */
    private Resources f1215h;

    /* renamed from: i */
    private View f1216i;

    /* renamed from: j */
    private Animation f1217j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f1218k;

    /* renamed from: l */
    private double f1219l;

    /* renamed from: m */
    private double f1220m;

    /* renamed from: n */
    private final Drawable.Callback f1221n = new Drawable.Callback() {
        public void invalidateDrawable(Drawable drawable) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            MaterialProgressDrawable.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MaterialProgressDrawable.this.unscheduleSelf(runnable);
        }
    };

    @Retention(RetentionPolicy.CLASS)
    /* renamed from: android.support.v4.widget.MaterialProgressDrawable$ProgressDrawableSize */
    public @interface ProgressDrawableSize {
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.f1216i = view;
        this.f1215h = context.getResources();
        this.f1213f = new C0421a(this.f1221n);
        this.f1213f.mo2806a(this.f1211d);
        mo2774a(1);
        m2537b();
    }

    /* renamed from: a */
    private void m2534a(double d, double d2, double d3, double d4, float f, float f2) {
        C0421a aVar = this.f1213f;
        float f3 = this.f1215h.getDisplayMetrics().density;
        this.f1219l = ((double) f3) * d;
        this.f1220m = ((double) f3) * d2;
        aVar.mo2799a(((float) d4) * f3);
        aVar.mo2798a(((double) f3) * d3);
        aVar.mo2812c(0);
        aVar.mo2800a(f * f3, f3 * f2);
        aVar.mo2802a((int) this.f1219l, (int) this.f1220m);
    }

    /* renamed from: a */
    public void mo2774a(@ProgressDrawableSize int i) {
        if (i == 0) {
            m2534a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m2534a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    /* renamed from: a */
    public void mo2775a(boolean z) {
        this.f1213f.mo2805a(z);
    }

    /* renamed from: a */
    public void mo2772a(float f) {
        this.f1213f.mo2817e(f);
    }

    /* renamed from: a */
    public void mo2773a(float f, float f2) {
        this.f1213f.mo2808b(f);
        this.f1213f.mo2811c(f2);
    }

    /* renamed from: b */
    public void mo2777b(float f) {
        this.f1213f.mo2814d(f);
    }

    /* renamed from: b */
    public void mo2778b(int i) {
        this.f1213f.mo2801a(i);
    }

    /* renamed from: a */
    public void mo2776a(int... iArr) {
        this.f1213f.mo2806a(iArr);
        this.f1213f.mo2812c(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f1220m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f1219l;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f1214g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1213f.mo2803a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f1213f.mo2815d(i);
    }

    public int getAlpha() {
        return this.f1213f.mo2810c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1213f.mo2804a(colorFilter);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2779c(float f) {
        this.f1214g = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f1212e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f1217j.reset();
        this.f1213f.mo2824l();
        if (this.f1213f.mo2821i() != this.f1213f.mo2816e()) {
            this.f1210a = true;
            this.f1217j.setDuration(666);
            this.f1216i.startAnimation(this.f1217j);
            return;
        }
        this.f1213f.mo2812c(0);
        this.f1213f.mo2825m();
        this.f1217j.setDuration(1332);
        this.f1216i.startAnimation(this.f1217j);
    }

    public void stop() {
        this.f1216i.clearAnimation();
        mo2779c(BitmapDescriptorFactory.HUE_RED);
        this.f1213f.mo2805a(false);
        this.f1213f.mo2812c(0);
        this.f1213f.mo2825m();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m2528a(C0421a aVar) {
        return (float) Math.toRadians(((double) aVar.mo2813d()) / (6.283185307179586d * aVar.mo2822j()));
    }

    /* renamed from: a */
    private int m2532a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (i6 + ((int) (((float) ((intValue2 & 255) - i6)) * f))) | ((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2535a(float f, C0421a aVar) {
        if (f > 0.75f) {
            aVar.mo2809b(m2532a((f - 0.75f) / 0.25f, aVar.mo2820h(), aVar.mo2797a()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2538b(float f, C0421a aVar) {
        m2535a(f, aVar);
        float a = m2528a(aVar);
        aVar.mo2808b((((aVar.mo2819g() - a) - aVar.mo2818f()) * f) + aVar.mo2818f());
        aVar.mo2811c(aVar.mo2819g());
        aVar.mo2814d(((((float) (Math.floor((double) (aVar.mo2823k() / 0.8f)) + 1.0d)) - aVar.mo2823k()) * f) + aVar.mo2823k());
    }

    /* renamed from: b */
    private void m2537b() {
        final C0421a aVar = this.f1213f;
        C04181 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                if (MaterialProgressDrawable.this.f1210a) {
                    MaterialProgressDrawable.this.m2538b(f, aVar);
                    return;
                }
                float a = MaterialProgressDrawable.this.m2528a(aVar);
                float g = aVar.mo2819g();
                float f2 = aVar.mo2818f();
                float k = aVar.mo2823k();
                MaterialProgressDrawable.this.m2535a(f, aVar);
                if (f <= 0.5f) {
                    aVar.mo2808b(f2 + (MaterialProgressDrawable.f1209c.getInterpolation(f / 0.5f) * (0.8f - a)));
                }
                if (f > 0.5f) {
                    aVar.mo2811c(((0.8f - a) * MaterialProgressDrawable.f1209c.getInterpolation((f - 0.5f) / 0.5f)) + g);
                }
                aVar.mo2814d((0.25f * f) + k);
                MaterialProgressDrawable.this.mo2779c((216.0f * f) + (1080.0f * (MaterialProgressDrawable.this.f1218k / 5.0f)));
            }
        };
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(f1208b);
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                float unused = MaterialProgressDrawable.this.f1218k = BitmapDescriptorFactory.HUE_RED;
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                aVar.mo2824l();
                aVar.mo2807b();
                aVar.mo2808b(aVar.mo2821i());
                if (MaterialProgressDrawable.this.f1210a) {
                    MaterialProgressDrawable.this.f1210a = false;
                    animation.setDuration(1332);
                    aVar.mo2805a(false);
                    return;
                }
                float unused = MaterialProgressDrawable.this.f1218k = (MaterialProgressDrawable.this.f1218k + 1.0f) % 5.0f;
            }
        });
        this.f1217j = r1;
    }

    /* renamed from: android.support.v4.widget.MaterialProgressDrawable$a */
    static class C0421a {

        /* renamed from: a */
        private final RectF f1227a = new RectF();

        /* renamed from: b */
        private final Paint f1228b = new Paint();

        /* renamed from: c */
        private final Paint f1229c = new Paint();

        /* renamed from: d */
        private final Drawable.Callback f1230d;

        /* renamed from: e */
        private float f1231e = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: f */
        private float f1232f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g */
        private float f1233g = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: h */
        private float f1234h = 5.0f;

        /* renamed from: i */
        private float f1235i = 2.5f;

        /* renamed from: j */
        private int[] f1236j;

        /* renamed from: k */
        private int f1237k;

        /* renamed from: l */
        private float f1238l;

        /* renamed from: m */
        private float f1239m;

        /* renamed from: n */
        private float f1240n;

        /* renamed from: o */
        private boolean f1241o;

        /* renamed from: p */
        private Path f1242p;

        /* renamed from: q */
        private float f1243q;

        /* renamed from: r */
        private double f1244r;

        /* renamed from: s */
        private int f1245s;

        /* renamed from: t */
        private int f1246t;

        /* renamed from: u */
        private int f1247u;

        /* renamed from: v */
        private final Paint f1248v = new Paint(1);

        /* renamed from: w */
        private int f1249w;

        /* renamed from: x */
        private int f1250x;

        public C0421a(Drawable.Callback callback) {
            this.f1230d = callback;
            this.f1228b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1228b.setAntiAlias(true);
            this.f1228b.setStyle(Paint.Style.STROKE);
            this.f1229c.setStyle(Paint.Style.FILL);
            this.f1229c.setAntiAlias(true);
        }

        /* renamed from: a */
        public void mo2801a(int i) {
            this.f1249w = i;
        }

        /* renamed from: a */
        public void mo2800a(float f, float f2) {
            this.f1245s = (int) f;
            this.f1246t = (int) f2;
        }

        /* renamed from: a */
        public void mo2803a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1227a;
            rectF.set(rect);
            rectF.inset(this.f1235i, this.f1235i);
            float f = (this.f1231e + this.f1233g) * 360.0f;
            float f2 = ((this.f1232f + this.f1233g) * 360.0f) - f;
            this.f1228b.setColor(this.f1250x);
            canvas.drawArc(rectF, f, f2, false, this.f1228b);
            m2548a(canvas, f, f2, rect);
            if (this.f1247u < 255) {
                this.f1248v.setColor(this.f1249w);
                this.f1248v.setAlpha(255 - this.f1247u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f1248v);
            }
        }

        /* renamed from: a */
        private void m2548a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f1241o) {
                if (this.f1242p == null) {
                    this.f1242p = new Path();
                    this.f1242p.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.f1242p.reset();
                }
                float f3 = ((float) (((int) this.f1235i) / 2)) * this.f1243q;
                float cos = (float) ((this.f1244r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                this.f1242p.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                this.f1242p.lineTo(((float) this.f1245s) * this.f1243q, BitmapDescriptorFactory.HUE_RED);
                this.f1242p.lineTo((((float) this.f1245s) * this.f1243q) / 2.0f, ((float) this.f1246t) * this.f1243q);
                this.f1242p.offset(cos - f3, (float) ((this.f1244r * Math.sin(0.0d)) + ((double) rect.exactCenterY())));
                this.f1242p.close();
                this.f1229c.setColor(this.f1250x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f1242p, this.f1229c);
            }
        }

        /* renamed from: a */
        public void mo2806a(@NonNull int[] iArr) {
            this.f1236j = iArr;
            mo2812c(0);
        }

        /* renamed from: b */
        public void mo2809b(int i) {
            this.f1250x = i;
        }

        /* renamed from: c */
        public void mo2812c(int i) {
            this.f1237k = i;
            this.f1250x = this.f1236j[this.f1237k];
        }

        /* renamed from: a */
        public int mo2797a() {
            return this.f1236j[m2549n()];
        }

        /* renamed from: n */
        private int m2549n() {
            return (this.f1237k + 1) % this.f1236j.length;
        }

        /* renamed from: b */
        public void mo2807b() {
            mo2812c(m2549n());
        }

        /* renamed from: a */
        public void mo2804a(ColorFilter colorFilter) {
            this.f1228b.setColorFilter(colorFilter);
            m2550o();
        }

        /* renamed from: d */
        public void mo2815d(int i) {
            this.f1247u = i;
        }

        /* renamed from: c */
        public int mo2810c() {
            return this.f1247u;
        }

        /* renamed from: a */
        public void mo2799a(float f) {
            this.f1234h = f;
            this.f1228b.setStrokeWidth(f);
            m2550o();
        }

        /* renamed from: d */
        public float mo2813d() {
            return this.f1234h;
        }

        /* renamed from: b */
        public void mo2808b(float f) {
            this.f1231e = f;
            m2550o();
        }

        /* renamed from: e */
        public float mo2816e() {
            return this.f1231e;
        }

        /* renamed from: f */
        public float mo2818f() {
            return this.f1238l;
        }

        /* renamed from: g */
        public float mo2819g() {
            return this.f1239m;
        }

        /* renamed from: h */
        public int mo2820h() {
            return this.f1236j[this.f1237k];
        }

        /* renamed from: c */
        public void mo2811c(float f) {
            this.f1232f = f;
            m2550o();
        }

        /* renamed from: i */
        public float mo2821i() {
            return this.f1232f;
        }

        /* renamed from: d */
        public void mo2814d(float f) {
            this.f1233g = f;
            m2550o();
        }

        /* renamed from: a */
        public void mo2802a(int i, int i2) {
            float f;
            float min = (float) Math.min(i, i2);
            if (this.f1244r <= 0.0d || min < BitmapDescriptorFactory.HUE_RED) {
                f = (float) Math.ceil((double) (this.f1234h / 2.0f));
            } else {
                f = (float) (((double) (min / 2.0f)) - this.f1244r);
            }
            this.f1235i = f;
        }

        /* renamed from: a */
        public void mo2798a(double d) {
            this.f1244r = d;
        }

        /* renamed from: j */
        public double mo2822j() {
            return this.f1244r;
        }

        /* renamed from: a */
        public void mo2805a(boolean z) {
            if (this.f1241o != z) {
                this.f1241o = z;
                m2550o();
            }
        }

        /* renamed from: e */
        public void mo2817e(float f) {
            if (f != this.f1243q) {
                this.f1243q = f;
                m2550o();
            }
        }

        /* renamed from: k */
        public float mo2823k() {
            return this.f1240n;
        }

        /* renamed from: l */
        public void mo2824l() {
            this.f1238l = this.f1231e;
            this.f1239m = this.f1232f;
            this.f1240n = this.f1233g;
        }

        /* renamed from: m */
        public void mo2825m() {
            this.f1238l = BitmapDescriptorFactory.HUE_RED;
            this.f1239m = BitmapDescriptorFactory.HUE_RED;
            this.f1240n = BitmapDescriptorFactory.HUE_RED;
            mo2808b((float) BitmapDescriptorFactory.HUE_RED);
            mo2811c((float) BitmapDescriptorFactory.HUE_RED);
            mo2814d((float) BitmapDescriptorFactory.HUE_RED);
        }

        /* renamed from: o */
        private void m2550o() {
            this.f1230d.invalidateDrawable((Drawable) null);
        }
    }
}
