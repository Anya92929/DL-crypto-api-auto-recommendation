package com.jackhenry.godough.core.widgets;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.jackhenry.godough.core.widgets.d */
class C1922d implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ TouchImageView f6883a;

    C1922d(TouchImageView touchImageView) {
        this.f6883a = touchImageView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f6883a.f6878r.onTouchEvent(motionEvent)) {
            this.f6883a.f6876p.onTouchEvent(motionEvent);
        }
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getAction()) {
            case 0:
                this.f6883a.f6863c.set(pointF);
                this.f6883a.f6864d.set(this.f6883a.f6863c);
                this.f6883a.f6862b = 1;
                break;
            case 1:
                this.f6883a.f6862b = 0;
                int abs = (int) Math.abs(pointF.x - this.f6883a.f6864d.x);
                int abs2 = (int) Math.abs(pointF.y - this.f6883a.f6864d.y);
                if (abs < 3 && abs2 < 3) {
                    this.f6883a.performClick();
                    break;
                }
            case 2:
                if (this.f6883a.f6862b == 1) {
                    float f = pointF.x - this.f6883a.f6863c.x;
                    float f2 = pointF.y - this.f6883a.f6863c.y;
                    this.f6883a.f6861a.postTranslate(this.f6883a.mo11178b(f, (float) this.f6883a.f6868h, this.f6883a.f6871k * this.f6883a.f6870j), this.f6883a.mo11178b(f2, (float) this.f6883a.f6869i, this.f6883a.f6872l * this.f6883a.f6870j));
                    this.f6883a.mo11177a();
                    this.f6883a.f6863c.set(pointF.x, pointF.y);
                    break;
                }
                break;
            case 6:
                this.f6883a.f6862b = 0;
                break;
        }
        this.f6883a.setImageMatrix(this.f6883a.f6861a);
        this.f6883a.invalidate();
        return true;
    }
}
