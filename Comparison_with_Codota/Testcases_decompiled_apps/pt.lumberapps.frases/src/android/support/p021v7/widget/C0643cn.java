package android.support.p021v7.widget;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: android.support.v7.widget.cn */
class C0643cn implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C0636cg f1562a;

    private C0643cn(C0636cg cgVar) {
        this.f1562a = cgVar;
    }

    /* synthetic */ C0643cn(C0636cg cgVar, C0637ch chVar) {
        this(cgVar);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f1562a.f1534c != null && this.f1562a.f1534c.isShowing() && x >= 0 && x < this.f1562a.f1534c.getWidth() && y >= 0 && y < this.f1562a.f1534c.getHeight()) {
            this.f1562a.f1529E.postDelayed(this.f1562a.f1555z, 250);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f1562a.f1529E.removeCallbacks(this.f1562a.f1555z);
            return false;
        }
    }
}
