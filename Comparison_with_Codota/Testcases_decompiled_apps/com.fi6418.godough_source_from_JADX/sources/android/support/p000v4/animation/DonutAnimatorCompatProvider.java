package android.support.p000v4.animation;

import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider */
class DonutAnimatorCompatProvider implements AnimatorProvider {

    /* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider$DonutFloatValueAnimator */
    class DonutFloatValueAnimator implements ValueAnimatorCompat {

        /* renamed from: a */
        List<AnimatorListenerCompat> f240a = new ArrayList();

        /* renamed from: b */
        List<AnimatorUpdateListenerCompat> f241b = new ArrayList();

        /* renamed from: c */
        View f242c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public long f243d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f244e = 200;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public float f245f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g */
        private boolean f246g = false;

        /* renamed from: h */
        private boolean f247h = false;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Runnable f248i = new Runnable() {
            public void run() {
                float a = (((float) (DonutFloatValueAnimator.this.m383b() - DonutFloatValueAnimator.this.f243d)) * 1.0f) / ((float) DonutFloatValueAnimator.this.f244e);
                if (a > 1.0f || DonutFloatValueAnimator.this.f242c.getParent() == null) {
                    a = 1.0f;
                }
                float unused = DonutFloatValueAnimator.this.f245f = a;
                DonutFloatValueAnimator.this.m382a();
                if (DonutFloatValueAnimator.this.f245f >= 1.0f) {
                    DonutFloatValueAnimator.this.m387d();
                } else {
                    DonutFloatValueAnimator.this.f242c.postDelayed(DonutFloatValueAnimator.this.f248i, 16);
                }
            }
        };

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m382a() {
            for (int size = this.f241b.size() - 1; size >= 0; size--) {
                this.f241b.get(size).onAnimationUpdate(this);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m383b() {
            return this.f242c.getDrawingTime();
        }

        /* renamed from: c */
        private void m386c() {
            for (int size = this.f240a.size() - 1; size >= 0; size--) {
                this.f240a.get(size).onAnimationStart(this);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m387d() {
            for (int size = this.f240a.size() - 1; size >= 0; size--) {
                this.f240a.get(size).onAnimationEnd(this);
            }
        }

        /* renamed from: e */
        private void m390e() {
            for (int size = this.f240a.size() - 1; size >= 0; size--) {
                this.f240a.get(size).onAnimationCancel(this);
            }
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.f240a.add(animatorListenerCompat);
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            this.f241b.add(animatorUpdateListenerCompat);
        }

        public void cancel() {
            if (!this.f247h) {
                this.f247h = true;
                if (this.f246g) {
                    m390e();
                }
                m387d();
            }
        }

        public float getAnimatedFraction() {
            return this.f245f;
        }

        public void setDuration(long j) {
            if (!this.f246g) {
                this.f244e = j;
            }
        }

        public void setTarget(View view) {
            this.f242c = view;
        }

        public void start() {
            if (!this.f246g) {
                this.f246g = true;
                m386c();
                this.f245f = BitmapDescriptorFactory.HUE_RED;
                this.f243d = m383b();
                this.f242c.postDelayed(this.f248i, 16);
            }
        }
    }

    DonutAnimatorCompatProvider() {
    }

    public void clearInterpolator(View view) {
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new DonutFloatValueAnimator();
    }
}
