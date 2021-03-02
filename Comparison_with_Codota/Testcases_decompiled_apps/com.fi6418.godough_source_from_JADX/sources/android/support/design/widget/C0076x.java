package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: android.support.design.widget.x */
final class C0076x extends SwipeDismissBehavior<Snackbar.SnackbarLayout> {

    /* renamed from: a */
    final /* synthetic */ Snackbar f225a;

    C0076x(Snackbar snackbar) {
        this.f225a = snackbar;
    }

    /* renamed from: a */
    public boolean mo60b(CoordinatorLayout coordinatorLayout, Snackbar.SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.mo75a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    C0009aa.m171a().mo172c(this.f225a.f71e);
                    break;
                case 1:
                case 3:
                    C0009aa.m171a().mo173d(this.f225a.f71e);
                    break;
            }
        }
        return super.mo60b(coordinatorLayout, snackbarLayout, motionEvent);
    }
}
