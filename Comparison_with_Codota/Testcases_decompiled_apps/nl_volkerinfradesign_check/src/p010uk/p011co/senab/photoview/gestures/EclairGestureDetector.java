package p010uk.p011co.senab.photoview.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import p010uk.p011co.senab.photoview.Compat;

@TargetApi(5)
/* renamed from: uk.co.senab.photoview.gestures.EclairGestureDetector */
public class EclairGestureDetector extends CupcakeGestureDetector {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;

    public EclairGestureDetector(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public float getActiveX(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    /* access modifiers changed from: package-private */
    public float getActiveY(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                break;
            case 1:
            case 3:
                this.mActivePointerId = -1;
                break;
            case 6:
                int pointerIndex = Compat.getPointerIndex(motionEvent.getAction());
                if (motionEvent.getPointerId(pointerIndex) == this.mActivePointerId) {
                    if (pointerIndex == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(i);
                    this.mLastTouchX = motionEvent.getX(i);
                    this.mLastTouchY = motionEvent.getY(i);
                    break;
                }
                break;
        }
        if (this.mActivePointerId != -1) {
            i2 = this.mActivePointerId;
        }
        this.mActivePointerIndex = motionEvent.findPointerIndex(i2);
        return super.onTouchEvent(motionEvent);
    }
}
