package android.support.p000v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider */
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {

    /* renamed from: a */
    private TimeInterpolator f250a;

    /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper */
    class AnimatorListenerCompatWrapper implements Animator.AnimatorListener {

        /* renamed from: a */
        final AnimatorListenerCompat f251a;

        /* renamed from: b */
        final ValueAnimatorCompat f252b;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.f251a = animatorListenerCompat;
            this.f252b = valueAnimatorCompat;
        }

        public void onAnimationCancel(Animator animator) {
            this.f251a.onAnimationCancel(this.f252b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f251a.onAnimationEnd(this.f252b);
        }

        public void onAnimationRepeat(Animator animator) {
            this.f251a.onAnimationRepeat(this.f252b);
        }

        public void onAnimationStart(Animator animator) {
            this.f251a.onAnimationStart(this.f252b);
        }
    }

    /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat */
    class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {

        /* renamed from: a */
        final Animator f253a;

        public HoneycombValueAnimatorCompat(Animator animator) {
            this.f253a = animator;
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.f253a.addListener(new AnimatorListenerCompatWrapper(animatorListenerCompat, this));
        }

        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            if (this.f253a instanceof ValueAnimator) {
                ((ValueAnimator) this.f253a).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.onAnimationUpdate(HoneycombValueAnimatorCompat.this);
                    }
                });
            }
        }

        public void cancel() {
            this.f253a.cancel();
        }

        public float getAnimatedFraction() {
            return ((ValueAnimator) this.f253a).getAnimatedFraction();
        }

        public void setDuration(long j) {
            this.f253a.setDuration(j);
        }

        public void setTarget(View view) {
            this.f253a.setTarget(view);
        }

        public void start() {
            this.f253a.start();
        }
    }

    HoneycombMr1AnimatorCompatProvider() {
    }

    public void clearInterpolator(View view) {
        if (this.f250a == null) {
            this.f250a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f250a);
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f}));
    }
}
