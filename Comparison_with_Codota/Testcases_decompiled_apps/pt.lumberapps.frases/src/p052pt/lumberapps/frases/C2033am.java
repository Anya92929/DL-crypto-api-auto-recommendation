package p052pt.lumberapps.frases;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: pt.lumberapps.frases.am */
final class C2033am extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ C2031ak f7700a;

    private C2033am(C2031ak akVar) {
        this.f7700a = akVar;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent.getX() - motionEvent2.getX() > 130.0f && Math.abs(f) > 100.0f) {
            this.f7700a.mo10170a();
            return true;
        } else if (motionEvent2.getX() - motionEvent.getX() > 130.0f && Math.abs(f) > 100.0f) {
            this.f7700a.mo10171b();
            return true;
        } else if (motionEvent.getY() - motionEvent2.getY() <= 130.0f || Math.abs(f2) <= 100.0f) {
            return motionEvent2.getY() - motionEvent.getY() > 130.0f && Math.abs(f2) > 100.0f;
        } else {
            return true;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.f7700a.mo10172c();
        return true;
    }
}
