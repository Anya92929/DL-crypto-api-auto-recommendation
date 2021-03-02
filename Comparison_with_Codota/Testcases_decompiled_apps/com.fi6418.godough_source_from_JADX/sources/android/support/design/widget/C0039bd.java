package android.support.design.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.bd */
class C0039bd extends C0033ay {

    /* renamed from: a */
    final ValueAnimator f176a = new ValueAnimator();

    C0039bd() {
    }

    /* renamed from: a */
    public void mo239a() {
        this.f176a.start();
    }

    /* renamed from: a */
    public void mo240a(float f, float f2) {
        this.f176a.setFloatValues(new float[]{f, f2});
    }

    /* renamed from: a */
    public void mo241a(int i) {
        this.f176a.setDuration((long) i);
    }

    /* renamed from: a */
    public void mo242a(int i, int i2) {
        this.f176a.setIntValues(new int[]{i, i2});
    }

    /* renamed from: a */
    public void mo243a(C0034az azVar) {
        this.f176a.addListener(new C0041bf(this, azVar));
    }

    /* renamed from: a */
    public void mo244a(C0036ba baVar) {
        this.f176a.addUpdateListener(new C0040be(this, baVar));
    }

    /* renamed from: a */
    public void mo245a(Interpolator interpolator) {
        this.f176a.setInterpolator(interpolator);
    }

    /* renamed from: b */
    public boolean mo246b() {
        return this.f176a.isRunning();
    }

    /* renamed from: c */
    public int mo247c() {
        return ((Integer) this.f176a.getAnimatedValue()).intValue();
    }

    /* renamed from: d */
    public void mo248d() {
        this.f176a.cancel();
    }

    /* renamed from: e */
    public float mo249e() {
        return this.f176a.getAnimatedFraction();
    }
}
