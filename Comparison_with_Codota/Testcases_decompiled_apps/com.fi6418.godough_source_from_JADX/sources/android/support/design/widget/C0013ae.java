package android.support.design.widget;

import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.widget.ViewDragHelper;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.design.widget.ae */
class C0013ae extends ViewDragHelper.Callback {

    /* renamed from: a */
    final /* synthetic */ SwipeDismissBehavior f118a;

    /* renamed from: b */
    private int f119b;

    C0013ae(SwipeDismissBehavior swipeDismissBehavior) {
        this.f118a = swipeDismissBehavior;
    }

    /* renamed from: a */
    private boolean m189a(View view, float f) {
        if (f != BitmapDescriptorFactory.HUE_RED) {
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (this.f118a.f82f == 2) {
                return true;
            }
            if (this.f118a.f82f == 0) {
                return z ? f < BitmapDescriptorFactory.HUE_RED : f > BitmapDescriptorFactory.HUE_RED;
            }
            if (this.f118a.f82f == 1) {
                return z ? f > BitmapDescriptorFactory.HUE_RED : f < BitmapDescriptorFactory.HUE_RED;
            }
            return false;
        }
        return Math.abs(view.getLeft() - this.f119b) >= Math.round(((float) view.getWidth()) * this.f118a.f83g);
    }

    public int clampViewPositionHorizontal(View view, int i, int i2) {
        int width;
        int width2;
        boolean z = ViewCompat.getLayoutDirection(view) == 1;
        if (this.f118a.f82f == 0) {
            if (z) {
                width = this.f119b - view.getWidth();
                width2 = this.f119b;
            } else {
                width = this.f119b;
                width2 = this.f119b + view.getWidth();
            }
        } else if (this.f118a.f82f != 1) {
            width = this.f119b - view.getWidth();
            width2 = this.f119b + view.getWidth();
        } else if (z) {
            width = this.f119b;
            width2 = this.f119b + view.getWidth();
        } else {
            width = this.f119b - view.getWidth();
            width2 = this.f119b;
        }
        return SwipeDismissBehavior.m118b(width, i, width2);
    }

    public int clampViewPositionVertical(View view, int i, int i2) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        return view.getWidth();
    }

    public void onViewDragStateChanged(int i) {
        if (this.f118a.f78b != null) {
            this.f118a.f78b.mo185a(i);
        }
    }

    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.f119b) + (((float) view.getWidth()) * this.f118a.f84h);
        float width2 = ((float) this.f119b) + (((float) view.getWidth()) * this.f118a.f85i);
        if (((float) i) <= width) {
            ViewCompat.setAlpha(view, 1.0f);
        } else if (((float) i) >= width2) {
            ViewCompat.setAlpha(view, BitmapDescriptorFactory.HUE_RED);
        } else {
            ViewCompat.setAlpha(view, SwipeDismissBehavior.m120c(BitmapDescriptorFactory.HUE_RED, 1.0f - SwipeDismissBehavior.m113a(width, width2, (float) i), 1.0f));
        }
    }

    public void onViewReleased(View view, float f, float f2) {
        int i;
        int width = view.getWidth();
        boolean z = false;
        if (m189a(view, f)) {
            i = view.getLeft() < this.f119b ? this.f119b - width : this.f119b + width;
            z = true;
        } else {
            i = this.f119b;
        }
        if (this.f118a.f77a.settleCapturedViewAt(i, view.getTop())) {
            ViewCompat.postOnAnimation(view, new C0015ag(this.f118a, view, z));
        } else if (z && this.f118a.f78b != null) {
            this.f118a.f78b.mo186a(view);
        }
    }

    public boolean tryCaptureView(View view, int i) {
        this.f119b = view.getLeft();
        return true;
    }
}
