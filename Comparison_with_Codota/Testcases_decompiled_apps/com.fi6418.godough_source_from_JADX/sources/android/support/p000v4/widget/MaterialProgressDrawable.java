package android.support.p000v4.widget;

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
import android.support.p000v4.view.animation.FastOutSlowInInterpolator;
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
    private static final Interpolator f1507b = new LinearInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Interpolator f1508c = new FastOutSlowInInterpolator();

    /* renamed from: a */
    boolean f1509a;

    /* renamed from: d */
    private final int[] f1510d = {-16777216};

    /* renamed from: e */
    private final ArrayList<Animation> f1511e = new ArrayList<>();

    /* renamed from: f */
    private final Ring f1512f;

    /* renamed from: g */
    private float f1513g;

    /* renamed from: h */
    private Resources f1514h;

    /* renamed from: i */
    private View f1515i;

    /* renamed from: j */
    private Animation f1516j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f1517k;

    /* renamed from: l */
    private double f1518l;

    /* renamed from: m */
    private double f1519m;

    /* renamed from: n */
    private final Drawable.Callback f1520n = new Drawable.Callback() {
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

    /* renamed from: android.support.v4.widget.MaterialProgressDrawable$Ring */
    class Ring {

        /* renamed from: a */
        private final RectF f1526a = new RectF();

        /* renamed from: b */
        private final Paint f1527b = new Paint();

        /* renamed from: c */
        private final Paint f1528c = new Paint();

        /* renamed from: d */
        private final Drawable.Callback f1529d;

        /* renamed from: e */
        private float f1530e = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: f */
        private float f1531f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g */
        private float f1532g = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: h */
        private float f1533h = 5.0f;

        /* renamed from: i */
        private float f1534i = 2.5f;

        /* renamed from: j */
        private int[] f1535j;

        /* renamed from: k */
        private int f1536k;

        /* renamed from: l */
        private float f1537l;

        /* renamed from: m */
        private float f1538m;

        /* renamed from: n */
        private float f1539n;

        /* renamed from: o */
        private boolean f1540o;

        /* renamed from: p */
        private Path f1541p;

        /* renamed from: q */
        private float f1542q;

        /* renamed from: r */
        private double f1543r;

        /* renamed from: s */
        private int f1544s;

        /* renamed from: t */
        private int f1545t;

        /* renamed from: u */
        private int f1546u;

        /* renamed from: v */
        private final Paint f1547v = new Paint(1);

        /* renamed from: w */
        private int f1548w;

        /* renamed from: x */
        private int f1549x;

        public Ring(Drawable.Callback callback) {
            this.f1529d = callback;
            this.f1527b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1527b.setAntiAlias(true);
            this.f1527b.setStyle(Paint.Style.STROKE);
            this.f1528c.setStyle(Paint.Style.FILL);
            this.f1528c.setAntiAlias(true);
        }

        /* renamed from: a */
        private int m1101a() {
            return (this.f1536k + 1) % this.f1535j.length;
        }

        /* renamed from: a */
        private void m1102a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f1540o) {
                if (this.f1541p == null) {
                    this.f1541p = new Path();
                    this.f1541p.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.f1541p.reset();
                }
                float f3 = ((float) (((int) this.f1534i) / 2)) * this.f1542q;
                float cos = (float) ((this.f1543r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                this.f1541p.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                this.f1541p.lineTo(((float) this.f1544s) * this.f1542q, BitmapDescriptorFactory.HUE_RED);
                this.f1541p.lineTo((((float) this.f1544s) * this.f1542q) / 2.0f, ((float) this.f1545t) * this.f1542q);
                this.f1541p.offset(cos - f3, (float) ((this.f1543r * Math.sin(0.0d)) + ((double) rect.exactCenterY())));
                this.f1541p.close();
                this.f1528c.setColor(this.f1549x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f1541p, this.f1528c);
            }
        }

        /* renamed from: b */
        private void m1103b() {
            this.f1529d.invalidateDrawable((Drawable) null);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.f1526a;
            rectF.set(rect);
            rectF.inset(this.f1534i, this.f1534i);
            float f = (this.f1530e + this.f1532g) * 360.0f;
            float f2 = ((this.f1531f + this.f1532g) * 360.0f) - f;
            this.f1527b.setColor(this.f1549x);
            canvas.drawArc(rectF, f, f2, false, this.f1527b);
            m1102a(canvas, f, f2, rect);
            if (this.f1546u < 255) {
                this.f1547v.setColor(this.f1548w);
                this.f1547v.setAlpha(255 - this.f1546u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f1547v);
            }
        }

        public int getAlpha() {
            return this.f1546u;
        }

        public double getCenterRadius() {
            return this.f1543r;
        }

        public float getEndTrim() {
            return this.f1531f;
        }

        public float getInsets() {
            return this.f1534i;
        }

        public int getNextColor() {
            return this.f1535j[m1101a()];
        }

        public float getRotation() {
            return this.f1532g;
        }

        public float getStartTrim() {
            return this.f1530e;
        }

        public int getStartingColor() {
            return this.f1535j[this.f1536k];
        }

        public float getStartingEndTrim() {
            return this.f1538m;
        }

        public float getStartingRotation() {
            return this.f1539n;
        }

        public float getStartingStartTrim() {
            return this.f1537l;
        }

        public float getStrokeWidth() {
            return this.f1533h;
        }

        public void goToNextColor() {
            setColorIndex(m1101a());
        }

        public void resetOriginals() {
            this.f1537l = BitmapDescriptorFactory.HUE_RED;
            this.f1538m = BitmapDescriptorFactory.HUE_RED;
            this.f1539n = BitmapDescriptorFactory.HUE_RED;
            setStartTrim(BitmapDescriptorFactory.HUE_RED);
            setEndTrim(BitmapDescriptorFactory.HUE_RED);
            setRotation(BitmapDescriptorFactory.HUE_RED);
        }

        public void setAlpha(int i) {
            this.f1546u = i;
        }

        public void setArrowDimensions(float f, float f2) {
            this.f1544s = (int) f;
            this.f1545t = (int) f2;
        }

        public void setArrowScale(float f) {
            if (f != this.f1542q) {
                this.f1542q = f;
                m1103b();
            }
        }

        public void setBackgroundColor(int i) {
            this.f1548w = i;
        }

        public void setCenterRadius(double d) {
            this.f1543r = d;
        }

        public void setColor(int i) {
            this.f1549x = i;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f1527b.setColorFilter(colorFilter);
            m1103b();
        }

        public void setColorIndex(int i) {
            this.f1536k = i;
            this.f1549x = this.f1535j[this.f1536k];
        }

        public void setColors(int[] iArr) {
            this.f1535j = iArr;
            setColorIndex(0);
        }

        public void setEndTrim(float f) {
            this.f1531f = f;
            m1103b();
        }

        public void setInsets(int i, int i2) {
            float min = (float) Math.min(i, i2);
            this.f1534i = (this.f1543r <= 0.0d || min < BitmapDescriptorFactory.HUE_RED) ? (float) Math.ceil((double) (this.f1533h / 2.0f)) : (float) (((double) (min / 2.0f)) - this.f1543r);
        }

        public void setRotation(float f) {
            this.f1532g = f;
            m1103b();
        }

        public void setShowArrow(boolean z) {
            if (this.f1540o != z) {
                this.f1540o = z;
                m1103b();
            }
        }

        public void setStartTrim(float f) {
            this.f1530e = f;
            m1103b();
        }

        public void setStrokeWidth(float f) {
            this.f1533h = f;
            this.f1527b.setStrokeWidth(f);
            m1103b();
        }

        public void storeOriginals() {
            this.f1537l = this.f1530e;
            this.f1538m = this.f1531f;
            this.f1539n = this.f1532g;
        }
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.f1515i = view;
        this.f1514h = context.getResources();
        this.f1512f = new Ring(this.f1520n);
        this.f1512f.setColors(this.f1510d);
        updateSizes(1);
        m1097b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m1088a(Ring ring) {
        return (float) Math.toRadians(((double) ring.getStrokeWidth()) / (6.283185307179586d * ring.getCenterRadius()));
    }

    /* renamed from: a */
    private int m1092a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (i6 + ((int) (((float) ((intValue2 & 255) - i6)) * f))) | ((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8);
    }

    /* renamed from: a */
    private void m1094a(double d, double d2, double d3, double d4, float f, float f2) {
        Ring ring = this.f1512f;
        float f3 = this.f1514h.getDisplayMetrics().density;
        this.f1518l = ((double) f3) * d;
        this.f1519m = ((double) f3) * d2;
        ring.setStrokeWidth(((float) d4) * f3);
        ring.setCenterRadius(((double) f3) * d3);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f * f3, f3 * f2);
        ring.setInsets((int) this.f1518l, (int) this.f1519m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1095a(float f, Ring ring) {
        if (f > 0.75f) {
            ring.setColor(m1092a((f - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        }
    }

    /* renamed from: b */
    private void m1097b() {
        final Ring ring = this.f1512f;
        C01971 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                if (MaterialProgressDrawable.this.f1509a) {
                    MaterialProgressDrawable.this.m1098b(f, ring);
                    return;
                }
                float a = MaterialProgressDrawable.this.m1088a(ring);
                float startingEndTrim = ring.getStartingEndTrim();
                float startingStartTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                MaterialProgressDrawable.this.m1095a(f, ring);
                if (f <= 0.5f) {
                    ring.setStartTrim(startingStartTrim + (MaterialProgressDrawable.f1508c.getInterpolation(f / 0.5f) * (0.8f - a)));
                }
                if (f > 0.5f) {
                    ring.setEndTrim(((0.8f - a) * MaterialProgressDrawable.f1508c.getInterpolation((f - 0.5f) / 0.5f)) + startingEndTrim);
                }
                ring.setRotation((0.25f * f) + startingRotation);
                MaterialProgressDrawable.this.mo3195a((216.0f * f) + (1080.0f * (MaterialProgressDrawable.this.f1517k / 5.0f)));
            }
        };
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(f1507b);
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                ring.storeOriginals();
                ring.goToNextColor();
                ring.setStartTrim(ring.getEndTrim());
                if (MaterialProgressDrawable.this.f1509a) {
                    MaterialProgressDrawable.this.f1509a = false;
                    animation.setDuration(1332);
                    ring.setShowArrow(false);
                    return;
                }
                float unused = MaterialProgressDrawable.this.f1517k = (MaterialProgressDrawable.this.f1517k + 1.0f) % 5.0f;
            }

            public void onAnimationStart(Animation animation) {
                float unused = MaterialProgressDrawable.this.f1517k = BitmapDescriptorFactory.HUE_RED;
            }
        });
        this.f1516j = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1098b(float f, Ring ring) {
        m1095a(f, ring);
        float a = m1088a(ring);
        ring.setStartTrim((((ring.getStartingEndTrim() - a) - ring.getStartingStartTrim()) * f) + ring.getStartingStartTrim());
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(((((float) (Math.floor((double) (ring.getStartingRotation() / 0.8f)) + 1.0d)) - ring.getStartingRotation()) * f) + ring.getStartingRotation());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3195a(float f) {
        this.f1513g = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f1513g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1512f.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public int getAlpha() {
        return this.f1512f.getAlpha();
    }

    public int getIntrinsicHeight() {
        return (int) this.f1519m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f1518l;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f1511e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i) {
        this.f1512f.setAlpha(i);
    }

    public void setArrowScale(float f) {
        this.f1512f.setArrowScale(f);
    }

    public void setBackgroundColor(int i) {
        this.f1512f.setBackgroundColor(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1512f.setColorFilter(colorFilter);
    }

    public void setColorSchemeColors(int... iArr) {
        this.f1512f.setColors(iArr);
        this.f1512f.setColorIndex(0);
    }

    public void setProgressRotation(float f) {
        this.f1512f.setRotation(f);
    }

    public void setStartEndTrim(float f, float f2) {
        this.f1512f.setStartTrim(f);
        this.f1512f.setEndTrim(f2);
    }

    public void showArrow(boolean z) {
        this.f1512f.setShowArrow(z);
    }

    public void start() {
        this.f1516j.reset();
        this.f1512f.storeOriginals();
        if (this.f1512f.getEndTrim() != this.f1512f.getStartTrim()) {
            this.f1509a = true;
            this.f1516j.setDuration(666);
            this.f1515i.startAnimation(this.f1516j);
            return;
        }
        this.f1512f.setColorIndex(0);
        this.f1512f.resetOriginals();
        this.f1516j.setDuration(1332);
        this.f1515i.startAnimation(this.f1516j);
    }

    public void stop() {
        this.f1515i.clearAnimation();
        mo3195a((float) BitmapDescriptorFactory.HUE_RED);
        this.f1512f.setShowArrow(false);
        this.f1512f.setColorIndex(0);
        this.f1512f.resetOriginals();
    }

    public void updateSizes(@ProgressDrawableSize int i) {
        if (i == 0) {
            m1094a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m1094a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }
}
