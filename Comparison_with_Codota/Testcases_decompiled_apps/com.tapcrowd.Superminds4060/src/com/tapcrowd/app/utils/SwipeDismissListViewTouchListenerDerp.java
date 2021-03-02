package com.tapcrowd.app.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ListView;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwipeDismissListViewTouchListenerDerp implements View.OnTouchListener {
    private long mAnimationTime;
    /* access modifiers changed from: private */
    public DismissCallbacks mCallbacks;
    /* access modifiers changed from: private */
    public int mDismissAnimationRefCount = 0;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    /* access modifiers changed from: private */
    public boolean mFirst = true;
    /* access modifiers changed from: private */
    public ListView mListView;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mPaused;
    /* access modifiers changed from: private */
    public List<PendingDismissData> mPendingDismisses = new ArrayList();
    private int mSlop;
    private boolean mSwiping;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        boolean canDismiss(int i);

        void onDismiss(ListView listView, int[] iArr);
    }

    public SwipeDismissListViewTouchListenerDerp(ListView listView, DismissCallbacks callbacks) {
        ViewConfiguration vc = ViewConfiguration.get(listView.getContext());
        this.mSlop = vc.getScaledTouchSlop();
        this.mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long) listView.getContext().getResources().getInteger(17694720);
        this.mListView = listView;
        this.mCallbacks = callbacks;
    }

    public void setEnabled(boolean enabled) {
        this.mPaused = !enabled;
    }

    public AbsListView.OnScrollListener makeScrollListener() {
        return new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                boolean z = true;
                SwipeDismissListViewTouchListenerDerp swipeDismissListViewTouchListenerDerp = SwipeDismissListViewTouchListenerDerp.this;
                if (scrollState == 1) {
                    z = false;
                }
                swipeDismissListViewTouchListenerDerp.setEnabled(z);
            }

            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
            }
        };
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mListView.getWidth();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.mPaused) {
                    return false;
                }
                Rect rect = new Rect();
                int childCount = this.mListView.getChildCount();
                int[] listViewCoords = new int[2];
                this.mListView.getLocationOnScreen(listViewCoords);
                int x = ((int) motionEvent.getRawX()) - listViewCoords[0];
                int y = ((int) motionEvent.getRawY()) - listViewCoords[1];
                int i2 = 0;
                while (true) {
                    if (i2 < childCount) {
                        View child = this.mListView.getChildAt(i2);
                        child.getHitRect(rect);
                        if (rect.contains(x, y)) {
                            this.mDownView = child;
                        } else {
                            i2++;
                        }
                    }
                }
                if (this.mDownView != null) {
                    this.mDownX = motionEvent.getRawX();
                    this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
                    if (this.mCallbacks.canDismiss(this.mDownPosition)) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                        this.mVelocityTracker.addMovement(motionEvent);
                    } else {
                        this.mDownView = null;
                    }
                }
                return false;
            case 1:
                if (this.mVelocityTracker != null) {
                    float deltaX = motionEvent.getRawX() - this.mDownX;
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
                    float velocityX = this.mVelocityTracker.getXVelocity();
                    float absVelocityX = Math.abs(velocityX);
                    float absVelocityY = Math.abs(this.mVelocityTracker.getYVelocity());
                    boolean dismiss = false;
                    boolean dismissRight = false;
                    if (Math.abs(deltaX) > ((float) (this.mViewWidth / 2))) {
                        dismiss = true;
                        dismissRight = deltaX > BitmapDescriptorFactory.HUE_RED;
                    } else if (((float) this.mMinFlingVelocity) <= absVelocityX && absVelocityX <= ((float) this.mMaxFlingVelocity) && absVelocityY < absVelocityX) {
                        dismiss = ((velocityX > BitmapDescriptorFactory.HUE_RED ? 1 : (velocityX == BitmapDescriptorFactory.HUE_RED ? 0 : -1)) < 0) == ((deltaX > BitmapDescriptorFactory.HUE_RED ? 1 : (deltaX == BitmapDescriptorFactory.HUE_RED ? 0 : -1)) < 0);
                        dismissRight = this.mVelocityTracker.getXVelocity() > BitmapDescriptorFactory.HUE_RED;
                    }
                    if (dismiss) {
                        View downView = this.mDownView;
                        final int downPosition = this.mDownPosition;
                        this.mDismissAnimationRefCount++;
                        if (Build.VERSION.SDK_INT > 11) {
                            ViewPropertyAnimator animate = this.mDownView.animate();
                            if (dismissRight) {
                                i = this.mViewWidth;
                            } else {
                                i = -this.mViewWidth;
                            }
                            final View view2 = downView;
                            animate.translationX((float) i).alpha(BitmapDescriptorFactory.HUE_RED).setDuration(this.mAnimationTime).setListener(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animation) {
                                    SwipeDismissListViewTouchListenerDerp.this.performDismiss(view2, downPosition);
                                }
                            });
                        } else {
                            performDismiss(downView, downPosition);
                        }
                    } else if (Build.VERSION.SDK_INT > 11) {
                        this.mDownView.animate().translationX(BitmapDescriptorFactory.HUE_RED).alpha(1.0f).setDuration(this.mAnimationTime).setListener((Animator.AnimatorListener) null);
                    } else {
                        TranslateAnimation translateAnimation = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                        translateAnimation.setDuration(1);
                        translateAnimation.setFillAfter(true);
                        this.mDownView.startAnimation(translateAnimation);
                        AlphaAnimation alpha = new AlphaAnimation(1.0f, 1.0f);
                        alpha.setDuration(0);
                        alpha.setFillAfter(true);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(alpha);
                        animationSet.addAnimation(translateAnimation);
                        this.mDownView.startAnimation(animationSet);
                    }
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mDownX = BitmapDescriptorFactory.HUE_RED;
                    this.mDownView = null;
                    this.mDownPosition = -1;
                    this.mSwiping = false;
                    break;
                }
                break;
            case 2:
                if (this.mVelocityTracker != null && !this.mPaused) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    float deltaX2 = motionEvent.getRawX() - this.mDownX;
                    if (Math.abs(deltaX2) > ((float) this.mSlop)) {
                        this.mSwiping = true;
                        this.mListView.requestDisallowInterceptTouchEvent(true);
                        MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                        cancelEvent.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mListView.onTouchEvent(cancelEvent);
                        cancelEvent.recycle();
                    }
                    if (this.mSwiping) {
                        if (Build.VERSION.SDK_INT > 11) {
                            this.mDownView.setTranslationX(deltaX2);
                            this.mDownView.setAlpha(Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(1.0f, 1.0f - ((2.0f * Math.abs(deltaX2)) / ((float) this.mViewWidth)))));
                        } else {
                            TranslateAnimation translateAnimation2 = new TranslateAnimation(deltaX2, this.mDownX, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                            translateAnimation2.setDuration(1);
                            translateAnimation2.setFillAfter(true);
                            float f = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(1.0f, 1.0f - ((2.0f * Math.abs(deltaX2)) / ((float) this.mViewWidth))));
                            AlphaAnimation alpha2 = new AlphaAnimation(f, f);
                            alpha2.setDuration(0);
                            alpha2.setFillAfter(true);
                            AnimationSet animationSet2 = new AnimationSet(true);
                            animationSet2.addAnimation(alpha2);
                            animationSet2.addAnimation(translateAnimation2);
                            this.mDownView.startAnimation(animationSet2);
                        }
                        return true;
                    }
                }
                break;
            case 3:
                if (this.mVelocityTracker != null) {
                    if (this.mDownView != null && this.mSwiping) {
                        this.mDownView.animate().translationX(BitmapDescriptorFactory.HUE_RED).alpha(1.0f).setDuration(this.mAnimationTime).setListener((Animator.AnimatorListener) null);
                    }
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mDownX = BitmapDescriptorFactory.HUE_RED;
                    this.mDownView = null;
                    this.mDownPosition = -1;
                    this.mSwiping = false;
                    break;
                }
                break;
        }
        return false;
    }

    class PendingDismissData implements Comparable<PendingDismissData> {
        public int position;
        public View view;

        public PendingDismissData(int position2, View view2) {
            this.position = position2;
            this.view = view2;
        }

        public int compareTo(PendingDismissData other) {
            return other.position - this.position;
        }
    }

    /* access modifiers changed from: private */
    public void performDismiss(View dismissView, int dismissPosition) {
        final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        final int originalHeight = dismissView.getHeight();
        if (Build.VERSION.SDK_INT > 11) {
            ValueAnimator animator = ValueAnimator.ofInt(new int[]{originalHeight, 1}).setDuration(this.mAnimationTime);
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    SwipeDismissListViewTouchListenerDerp swipeDismissListViewTouchListenerDerp = SwipeDismissListViewTouchListenerDerp.this;
                    swipeDismissListViewTouchListenerDerp.mDismissAnimationRefCount = swipeDismissListViewTouchListenerDerp.mDismissAnimationRefCount - 1;
                    if (SwipeDismissListViewTouchListenerDerp.this.mDismissAnimationRefCount == 0) {
                        Collections.sort(SwipeDismissListViewTouchListenerDerp.this.mPendingDismisses);
                        int[] dismissPositions = new int[SwipeDismissListViewTouchListenerDerp.this.mPendingDismisses.size()];
                        for (int i = SwipeDismissListViewTouchListenerDerp.this.mPendingDismisses.size() - 1; i >= 0; i--) {
                            dismissPositions[i] = ((PendingDismissData) SwipeDismissListViewTouchListenerDerp.this.mPendingDismisses.get(i)).position;
                        }
                        SwipeDismissListViewTouchListenerDerp.this.mCallbacks.onDismiss(SwipeDismissListViewTouchListenerDerp.this.mListView, dismissPositions);
                        for (PendingDismissData pendingDismiss : SwipeDismissListViewTouchListenerDerp.this.mPendingDismisses) {
                            pendingDismiss.view.setAlpha(1.0f);
                            pendingDismiss.view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                            ViewGroup.LayoutParams lp = pendingDismiss.view.getLayoutParams();
                            lp.height = originalHeight;
                            pendingDismiss.view.setLayoutParams(lp);
                        }
                        if (SwipeDismissListViewTouchListenerDerp.this.mFirst) {
                            SwipeDismissListViewTouchListenerDerp.this.mFirst = false;
                        }
                        SwipeDismissListViewTouchListenerDerp.this.mPendingDismisses.clear();
                    }
                }
            });
            final View view = dismissView;
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!SwipeDismissListViewTouchListenerDerp.this.mFirst) {
                        lp.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    }
                    view.setLayoutParams(lp);
                }
            });
            this.mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
            animator.start();
            return;
        }
        this.mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        if (!this.mFirst) {
            for (int i = originalHeight; i > 0; i--) {
                lp.height = i;
                dismissView.setLayoutParams(lp);
            }
        }
        this.mDismissAnimationRefCount--;
        if (this.mDismissAnimationRefCount == 0) {
            Collections.sort(this.mPendingDismisses);
            int[] dismissPositions = new int[this.mPendingDismisses.size()];
            for (int i2 = this.mPendingDismisses.size() - 1; i2 >= 0; i2--) {
                dismissPositions[i2] = this.mPendingDismisses.get(i2).position;
            }
            this.mCallbacks.onDismiss(this.mListView, dismissPositions);
            for (PendingDismissData pendingDismiss : this.mPendingDismisses) {
                TranslateAnimation swipe = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                swipe.setDuration(1);
                swipe.setFillAfter(true);
                AlphaAnimation alpha = new AlphaAnimation(1.0f, 1.0f);
                alpha.setDuration(0);
                alpha.setFillAfter(true);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alpha);
                animationSet.addAnimation(swipe);
                pendingDismiss.view.startAnimation(animationSet);
                pendingDismiss.view.getLayoutParams().height = originalHeight;
                pendingDismiss.view.setLayoutParams(lp);
            }
            if (this.mFirst) {
                this.mFirst = false;
            }
            this.mPendingDismisses.clear();
        }
    }

    public void setFirst() {
        this.mFirst = true;
    }
}
