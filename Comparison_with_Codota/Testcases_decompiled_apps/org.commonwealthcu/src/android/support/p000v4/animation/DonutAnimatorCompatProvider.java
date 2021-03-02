package android.support.p000v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider */
class DonutAnimatorCompatProvider implements AnimatorProvider {

    /* renamed from: android.support.v4.animation.DonutAnimatorCompatProvider$DonutFloatValueAnimator */
    class DonutFloatValueAnimator implements ValueAnimatorCompat {
        /* access modifiers changed from: private */
        public long mDuration = 200;
        private boolean mEnded = false;
        /* access modifiers changed from: private */
        public float mFraction = 0.0f;
        List mListeners = new ArrayList();
        /* access modifiers changed from: private */
        public Runnable mLoopRunnable = new Runnable() {
            public void run() {
                float access$000 = ((float) (DonutFloatValueAnimator.this.getTime() - DonutFloatValueAnimator.this.mStartTime)) / ((float) DonutFloatValueAnimator.this.mDuration);
                if (access$000 > 1.0f || DonutFloatValueAnimator.this.mTarget.getParent() == null) {
                    access$000 = 1.0f;
                }
                float unused = DonutFloatValueAnimator.this.mFraction = access$000;
                DonutFloatValueAnimator.this.notifyUpdateListeners();
                if (DonutFloatValueAnimator.this.mFraction >= 1.0f) {
                    DonutFloatValueAnimator.this.dispatchEnd();
                } else {
                    DonutFloatValueAnimator.this.mTarget.postDelayed(DonutFloatValueAnimator.this.mLoopRunnable, 16);
                }
            }
        };
        /* access modifiers changed from: private */
        public long mStartTime;
        private boolean mStarted = false;
        View mTarget;
        List mUpdateListeners = new ArrayList();

        private void dispatchCancel() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                ((AnimatorListenerCompat) this.mListeners.get(size)).onAnimationCancel(this);
            }
        }

        /* access modifiers changed from: private */
        public void dispatchEnd() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                ((AnimatorListenerCompat) this.mListeners.get(size)).onAnimationEnd(this);
            }
        }

        private void dispatchStart() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                ((AnimatorListenerCompat) this.mListeners.get(size)).onAnimationStart(this);
            }
        }

        /* access modifiers changed from: private */
        public long getTime() {
            return this.mTarget.getDrawingTime();
        }

        /* access modifiers changed from: private */
        public void notifyUpdateListeners() {
            for (int size = this.mUpdateListeners.size() - 1; size >= 0; size--) {
                ((AnimatorUpdateListenerCompat) this.mUpdateListeners.get(size)).onAnimationUpdate(this);
            }
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.mListeners.add(animatorListenerCompat);
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            this.mUpdateListeners.add(animatorUpdateListenerCompat);
        }

        public void cancel() {
            if (!this.mEnded) {
                this.mEnded = true;
                if (this.mStarted) {
                    dispatchCancel();
                }
                dispatchEnd();
            }
        }

        public float getAnimatedFraction() {
            return this.mFraction;
        }

        public void setDuration(long j) {
            if (!this.mStarted) {
                this.mDuration = j;
            }
        }

        public void setTarget(View view) {
            this.mTarget = view;
        }

        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                dispatchStart();
                this.mFraction = 0.0f;
                this.mStartTime = getTime();
                this.mTarget.postDelayed(this.mLoopRunnable, 16);
            }
        }
    }

    DonutAnimatorCompatProvider() {
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new DonutFloatValueAnimator();
    }
}
