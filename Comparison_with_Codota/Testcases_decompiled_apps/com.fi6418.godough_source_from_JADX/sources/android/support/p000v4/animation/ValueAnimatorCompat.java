package android.support.p000v4.animation;

import android.view.View;

/* renamed from: android.support.v4.animation.ValueAnimatorCompat */
public interface ValueAnimatorCompat {
    void addListener(AnimatorListenerCompat animatorListenerCompat);

    void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat);

    void cancel();

    float getAnimatedFraction();

    void setDuration(long j);

    void setTarget(View view);

    void start();
}
