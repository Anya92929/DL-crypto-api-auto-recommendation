package android.support.p007a.p008a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region;
import android.support.p009v4.p019f.C0136a;

/* renamed from: android.support.a.a.r */
class C0022r {

    /* renamed from: j */
    private static final Matrix f116j = new Matrix();

    /* renamed from: a */
    float f117a;

    /* renamed from: b */
    float f118b;

    /* renamed from: c */
    float f119c;

    /* renamed from: d */
    float f120d;

    /* renamed from: e */
    int f121e;

    /* renamed from: f */
    String f122f;

    /* renamed from: g */
    final C0136a f123g;

    /* renamed from: h */
    private final Path f124h;

    /* renamed from: i */
    private final Path f125i;

    /* renamed from: k */
    private final Matrix f126k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Paint f127l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Paint f128m;

    /* renamed from: n */
    private PathMeasure f129n;

    /* renamed from: o */
    private int f130o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C0020p f131p;

    public C0022r() {
        this.f126k = new Matrix();
        this.f117a = 0.0f;
        this.f118b = 0.0f;
        this.f119c = 0.0f;
        this.f120d = 0.0f;
        this.f121e = 255;
        this.f122f = null;
        this.f123g = new C0136a();
        this.f131p = new C0020p();
        this.f124h = new Path();
        this.f125i = new Path();
    }

    public C0022r(C0022r rVar) {
        this.f126k = new Matrix();
        this.f117a = 0.0f;
        this.f118b = 0.0f;
        this.f119c = 0.0f;
        this.f120d = 0.0f;
        this.f121e = 255;
        this.f122f = null;
        this.f123g = new C0136a();
        this.f131p = new C0020p(rVar.f131p, this.f123g);
        this.f124h = new Path(rVar.f124h);
        this.f125i = new Path(rVar.f125i);
        this.f117a = rVar.f117a;
        this.f118b = rVar.f118b;
        this.f119c = rVar.f119c;
        this.f120d = rVar.f120d;
        this.f130o = rVar.f130o;
        this.f121e = rVar.f121e;
        this.f122f = rVar.f122f;
        if (rVar.f122f != null) {
            this.f123g.put(rVar.f122f, this);
        }
    }

    /* renamed from: a */
    private static float m101a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    /* renamed from: a */
    private float m102a(Matrix matrix) {
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
        float a = m101a(fArr[0], fArr[1], fArr[2], fArr[3]);
        float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), hypot);
        if (max > 0.0f) {
            return Math.abs(a) / max;
        }
        return 0.0f;
    }

    /* renamed from: a */
    private void m105a(C0020p pVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        pVar.f101b.set(matrix);
        pVar.f101b.preConcat(pVar.f109j);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < pVar.f100a.size()) {
                Object obj = pVar.f100a.get(i4);
                if (obj instanceof C0020p) {
                    m105a((C0020p) obj, pVar.f101b, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0021q) {
                    m106a(pVar, (C0021q) obj, canvas, i, i2, colorFilter);
                }
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m106a(C0020p pVar, C0021q qVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = ((float) i) / this.f119c;
        float f2 = ((float) i2) / this.f120d;
        float min = Math.min(f, f2);
        Matrix b = pVar.f101b;
        this.f126k.set(b);
        this.f126k.postScale(f, f2);
        float a = m102a(b);
        if (a != 0.0f) {
            qVar.mo104a(this.f124h);
            Path path = this.f124h;
            this.f125i.reset();
            if (qVar.mo100a()) {
                this.f125i.addPath(path, this.f126k);
                canvas.clipPath(this.f125i, Region.Op.REPLACE);
                return;
            }
            C0019o oVar = (C0019o) qVar;
            if (!(oVar.f93g == 0.0f && oVar.f94h == 1.0f)) {
                float f3 = (oVar.f93g + oVar.f95i) % 1.0f;
                float f4 = (oVar.f94h + oVar.f95i) % 1.0f;
                if (this.f129n == null) {
                    this.f129n = new PathMeasure();
                }
                this.f129n.setPath(this.f124h, false);
                float length = this.f129n.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.f129n.getSegment(f5, length, path, true);
                    this.f129n.getSegment(0.0f, f6, path, true);
                } else {
                    this.f129n.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f125i.addPath(path, this.f126k);
            if (oVar.f89c != 0) {
                if (this.f128m == null) {
                    this.f128m = new Paint();
                    this.f128m.setStyle(Paint.Style.FILL);
                    this.f128m.setAntiAlias(true);
                }
                Paint paint = this.f128m;
                paint.setColor(C0016l.m79b(oVar.f89c, oVar.f92f));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.f125i, paint);
            }
            if (oVar.f87a != 0) {
                if (this.f127l == null) {
                    this.f127l = new Paint();
                    this.f127l.setStyle(Paint.Style.STROKE);
                    this.f127l.setAntiAlias(true);
                }
                Paint paint2 = this.f127l;
                if (oVar.f97k != null) {
                    paint2.setStrokeJoin(oVar.f97k);
                }
                if (oVar.f96j != null) {
                    paint2.setStrokeCap(oVar.f96j);
                }
                paint2.setStrokeMiter(oVar.f98l);
                paint2.setColor(C0016l.m79b(oVar.f87a, oVar.f90d));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(a * min * oVar.f88b);
                canvas.drawPath(this.f125i, paint2);
            }
        }
    }

    /* renamed from: a */
    public int mo106a() {
        return this.f121e;
    }

    /* renamed from: a */
    public void mo107a(float f) {
        mo108a((int) (255.0f * f));
    }

    /* renamed from: a */
    public void mo108a(int i) {
        this.f121e = i;
    }

    /* renamed from: a */
    public void mo109a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        m105a(this.f131p, f116j, canvas, i, i2, colorFilter);
    }

    /* renamed from: b */
    public float mo110b() {
        return ((float) mo106a()) / 255.0f;
    }
}
