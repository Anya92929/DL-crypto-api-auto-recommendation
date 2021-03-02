package com.p046c.p049c.p050a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.c.c.a.a */
public final class C1201a extends Animation {

    /* renamed from: a */
    public static final boolean f3324a = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);

    /* renamed from: b */
    private static final WeakHashMap f3325b = new WeakHashMap();

    /* renamed from: c */
    private final WeakReference f3326c;

    /* renamed from: d */
    private final Camera f3327d = new Camera();

    /* renamed from: e */
    private boolean f3328e;

    /* renamed from: f */
    private float f3329f = 1.0f;

    /* renamed from: g */
    private float f3330g;

    /* renamed from: h */
    private float f3331h;

    /* renamed from: i */
    private float f3332i;

    /* renamed from: j */
    private float f3333j;

    /* renamed from: k */
    private float f3334k;

    /* renamed from: l */
    private float f3335l = 1.0f;

    /* renamed from: m */
    private float f3336m = 1.0f;

    /* renamed from: n */
    private float f3337n;

    /* renamed from: o */
    private float f3338o;

    /* renamed from: p */
    private final RectF f3339p = new RectF();

    /* renamed from: q */
    private final RectF f3340q = new RectF();

    /* renamed from: r */
    private final Matrix f3341r = new Matrix();

    private C1201a(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f3326c = new WeakReference(view);
    }

    /* renamed from: a */
    public static C1201a m5465a(View view) {
        C1201a aVar = (C1201a) f3325b.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        C1201a aVar2 = new C1201a(view);
        f3325b.put(view, aVar2);
        return aVar2;
    }

    /* renamed from: a */
    private void m5466a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f3328e;
        float f = z ? this.f3330g : width / 2.0f;
        float f2 = z ? this.f3331h : height / 2.0f;
        float f3 = this.f3332i;
        float f4 = this.f3333j;
        float f5 = this.f3334k;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f3327d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f3335l;
        float f7 = this.f3336m;
        if (!(f6 == 1.0f && f7 == 1.0f)) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.f3337n, this.f3338o);
    }

    /* renamed from: a */
    private void m5467a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f3341r;
        matrix.reset();
        m5466a(matrix, view);
        this.f3341r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    /* renamed from: o */
    private void m5468o() {
        View view = (View) this.f3326c.get();
        if (view != null) {
            m5467a(this.f3339p, view);
        }
    }

    /* renamed from: p */
    private void m5469p() {
        View view = (View) this.f3326c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f3340q;
            m5467a(rectF, view);
            rectF.union(this.f3339p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    /* renamed from: a */
    public float mo4606a() {
        return this.f3329f;
    }

    /* renamed from: a */
    public void mo4607a(float f) {
        if (this.f3329f != f) {
            this.f3329f = f;
            View view = (View) this.f3326c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f3326c.get();
        if (view != null) {
            transformation.setAlpha(this.f3329f);
            m5466a(transformation.getMatrix(), view);
        }
    }

    /* renamed from: b */
    public float mo4609b() {
        return this.f3330g;
    }

    /* renamed from: b */
    public void mo4610b(float f) {
        if (!this.f3328e || this.f3330g != f) {
            m5468o();
            this.f3328e = true;
            this.f3330g = f;
            m5469p();
        }
    }

    /* renamed from: c */
    public float mo4611c() {
        return this.f3331h;
    }

    /* renamed from: c */
    public void mo4612c(float f) {
        if (!this.f3328e || this.f3331h != f) {
            m5468o();
            this.f3328e = true;
            this.f3331h = f;
            m5469p();
        }
    }

    /* renamed from: d */
    public float mo4613d() {
        return this.f3334k;
    }

    /* renamed from: d */
    public void mo4614d(float f) {
        if (this.f3334k != f) {
            m5468o();
            this.f3334k = f;
            m5469p();
        }
    }

    /* renamed from: e */
    public float mo4615e() {
        return this.f3332i;
    }

    /* renamed from: e */
    public void mo4616e(float f) {
        if (this.f3332i != f) {
            m5468o();
            this.f3332i = f;
            m5469p();
        }
    }

    /* renamed from: f */
    public float mo4617f() {
        return this.f3333j;
    }

    /* renamed from: f */
    public void mo4618f(float f) {
        if (this.f3333j != f) {
            m5468o();
            this.f3333j = f;
            m5469p();
        }
    }

    /* renamed from: g */
    public float mo4619g() {
        return this.f3335l;
    }

    /* renamed from: g */
    public void mo4620g(float f) {
        if (this.f3335l != f) {
            m5468o();
            this.f3335l = f;
            m5469p();
        }
    }

    /* renamed from: h */
    public float mo4621h() {
        return this.f3336m;
    }

    /* renamed from: h */
    public void mo4622h(float f) {
        if (this.f3336m != f) {
            m5468o();
            this.f3336m = f;
            m5469p();
        }
    }

    /* renamed from: i */
    public int mo4623i() {
        View view = (View) this.f3326c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    /* renamed from: i */
    public void mo4624i(float f) {
        if (this.f3337n != f) {
            m5468o();
            this.f3337n = f;
            m5469p();
        }
    }

    /* renamed from: j */
    public int mo4625j() {
        View view = (View) this.f3326c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    /* renamed from: j */
    public void mo4626j(float f) {
        if (this.f3338o != f) {
            m5468o();
            this.f3338o = f;
            m5469p();
        }
    }

    /* renamed from: k */
    public float mo4627k() {
        return this.f3337n;
    }

    /* renamed from: k */
    public void mo4628k(float f) {
        View view = (View) this.f3326c.get();
        if (view != null) {
            mo4624i(f - ((float) view.getLeft()));
        }
    }

    /* renamed from: l */
    public float mo4629l() {
        return this.f3338o;
    }

    /* renamed from: l */
    public void mo4630l(float f) {
        View view = (View) this.f3326c.get();
        if (view != null) {
            mo4626j(f - ((float) view.getTop()));
        }
    }

    /* renamed from: m */
    public float mo4631m() {
        View view = (View) this.f3326c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f3337n;
    }

    /* renamed from: n */
    public float mo4632n() {
        View view = (View) this.f3326c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f3338o;
    }
}
