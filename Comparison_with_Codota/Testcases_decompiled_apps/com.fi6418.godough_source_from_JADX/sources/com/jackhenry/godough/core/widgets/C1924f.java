package com.jackhenry.godough.core.widgets;

import android.view.ScaleGestureDetector;

/* renamed from: com.jackhenry.godough.core.widgets.f */
class C1924f extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: a */
    final /* synthetic */ TouchImageView f6885a;

    private C1924f(TouchImageView touchImageView) {
        this.f6885a = touchImageView;
    }

    /* synthetic */ C1924f(TouchImageView touchImageView, C1922d dVar) {
        this(touchImageView);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float f = this.f6885a.f6870j;
        this.f6885a.f6870j *= scaleFactor;
        if (this.f6885a.f6870j > this.f6885a.f6866f) {
            this.f6885a.f6870j = this.f6885a.f6866f;
            scaleFactor = this.f6885a.f6866f / f;
        } else if (this.f6885a.f6870j < this.f6885a.f6865e) {
            this.f6885a.f6870j = this.f6885a.f6865e;
            scaleFactor = this.f6885a.f6865e / f;
        }
        if (this.f6885a.f6871k * this.f6885a.f6870j <= ((float) this.f6885a.f6868h) || this.f6885a.f6872l * this.f6885a.f6870j <= ((float) this.f6885a.f6869i)) {
            this.f6885a.f6861a.postScale(scaleFactor, scaleFactor, (float) (this.f6885a.f6868h / 2), (float) (this.f6885a.f6869i / 2));
        } else {
            this.f6885a.f6861a.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        }
        this.f6885a.mo11177a();
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f6885a.f6862b = 2;
        return true;
    }
}
