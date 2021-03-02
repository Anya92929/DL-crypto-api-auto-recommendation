package android.support.p007a.p008a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.a.a.c */
class C0007c implements Drawable.Callback {

    /* renamed from: a */
    final /* synthetic */ C0006b f66a;

    C0007c(C0006b bVar) {
        this.f66a = bVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f66a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f66a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f66a.unscheduleSelf(runnable);
    }
}
