package p000;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.p001v4.animation.AnimatorListenerCompat;
import android.support.p001v4.animation.AnimatorUpdateListenerCompat;
import android.support.p001v4.animation.ValueAnimatorCompat;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: h */
public class C1184h implements C1106f {

    /* renamed from: a */
    private TimeInterpolator f4231a;

    /* renamed from: a */
    public ValueAnimatorCompat mo8099a() {
        return new C1186b(ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f}));
    }

    /* renamed from: h$b */
    static class C1186b implements ValueAnimatorCompat {

        /* renamed from: a */
        final Animator f4234a;

        public C1186b(Animator animator) {
            this.f4234a = animator;
        }

        public void setTarget(View view) {
            this.f4234a.setTarget(view);
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.f4234a.addListener(new C1185a(animatorListenerCompat, this));
        }

        public void setDuration(long j) {
            this.f4234a.setDuration(j);
        }

        public void start() {
            this.f4234a.start();
        }

        public void cancel() {
            this.f4234a.cancel();
        }

        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            if (this.f4234a instanceof ValueAnimator) {
                ((ValueAnimator) this.f4234a).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.onAnimationUpdate(C1186b.this);
                    }
                });
            }
        }

        public float getAnimatedFraction() {
            return ((ValueAnimator) this.f4234a).getAnimatedFraction();
        }
    }

    /* renamed from: h$a */
    static class C1185a implements Animator.AnimatorListener {

        /* renamed from: a */
        final AnimatorListenerCompat f4232a;

        /* renamed from: b */
        final ValueAnimatorCompat f4233b;

        public C1185a(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.f4232a = animatorListenerCompat;
            this.f4233b = valueAnimatorCompat;
        }

        public void onAnimationStart(Animator animator) {
            this.f4232a.onAnimationStart(this.f4233b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f4232a.onAnimationEnd(this.f4233b);
        }

        public void onAnimationCancel(Animator animator) {
            this.f4232a.onAnimationCancel(this.f4233b);
        }

        public void onAnimationRepeat(Animator animator) {
            this.f4232a.onAnimationRepeat(this.f4233b);
        }
    }

    /* renamed from: a */
    public void mo8100a(View view) {
        if (this.f4231a == null) {
            this.f4231a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f4231a);
    }
}
