package android.support.p021v7.p022a;

import android.content.Context;
import android.support.p021v7.widget.C0591ap;
import android.support.p021v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* renamed from: android.support.v7.a.bf */
class C0459bf extends ContentFrameLayout {

    /* renamed from: a */
    final /* synthetic */ C0447au f650a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0459bf(C0447au auVar, Context context) {
        super(context);
        this.f650a = auVar;
    }

    /* renamed from: a */
    private boolean m1951a(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f650a.mo1999a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m1951a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f650a.mo2023d(0);
        return true;
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(C0591ap.m2736a().mo2982a(getContext(), i));
    }
}
