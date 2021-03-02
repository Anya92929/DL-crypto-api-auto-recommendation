package android.support.p021v7.widget;

/* renamed from: android.support.v7.widget.cb */
class C0631cb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0628bz f1502a;

    private C0631cb(C0628bz bzVar) {
        this.f1502a = bzVar;
    }

    public void run() {
        this.f1502a.f1495d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
