package p010uk.p011co.senab.photoview.gestures;

import android.view.MotionEvent;

/* renamed from: uk.co.senab.photoview.gestures.GestureDetector */
public interface GestureDetector {
    boolean isDragging();

    boolean isScaling();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setOnGestureListener(OnGestureListener onGestureListener);
}
