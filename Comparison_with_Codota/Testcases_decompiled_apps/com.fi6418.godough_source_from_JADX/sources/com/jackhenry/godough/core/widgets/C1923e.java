package com.jackhenry.godough.core.widgets;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.jackhenry.godough.core.widgets.e */
class C1923e extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ TouchImageView f6884a;

    C1923e(TouchImageView touchImageView) {
        this.f6884a = touchImageView;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        this.f6884a.fitToScreen();
        this.f6884a.invalidate();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f6884a.f6861a.getValues(this.f6884a.f6867g);
        float f3 = this.f6884a.f6867g[2];
        float f4 = (((float) this.f6884a.f6868h) - (this.f6884a.f6871k * this.f6884a.f6870j)) - f3;
        if (this.f6884a.f6879s && (this.f6884a.f6870j == 1.0f || f3 == BitmapDescriptorFactory.HUE_RED || f4 == BitmapDescriptorFactory.HUE_RED)) {
            float y = motionEvent.getY() - motionEvent2.getY();
            float x = motionEvent.getX() - motionEvent2.getX();
            if (Math.abs(x) >= 300.0f && Math.abs(f) >= 600.0f) {
                this.f6884a.getFlingCallBack().execute(x > BitmapDescriptorFactory.HUE_RED);
                return true;
            }
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
