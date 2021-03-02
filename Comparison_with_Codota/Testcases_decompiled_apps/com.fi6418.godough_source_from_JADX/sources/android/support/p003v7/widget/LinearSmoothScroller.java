package android.support.p003v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.p003v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.widget.LinearSmoothScroller */
public abstract class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;

    /* renamed from: a */
    private final float f2818a;

    /* renamed from: b */
    protected final LinearInterpolator f2819b = new LinearInterpolator();

    /* renamed from: c */
    protected final DecelerateInterpolator f2820c = new DecelerateInterpolator();

    /* renamed from: d */
    protected PointF f2821d;

    /* renamed from: e */
    protected int f2822e = 0;

    /* renamed from: f */
    protected int f2823f = 0;

    public LinearSmoothScroller(Context context) {
        this.f2818a = mo5372a(context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    private int m1907a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo5372a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo5373a(int i) {
        return (int) Math.ceil(((double) mo5378b(i)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5374a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5375a(int i, int i2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (getChildCount() == 0) {
            mo5862e();
            return;
        }
        this.f2822e = m1907a(this.f2822e, i);
        this.f2823f = m1907a(this.f2823f, i2);
        if (this.f2822e == 0 && this.f2823f == 0) {
            mo5376a(action);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5376a(RecyclerView.SmoothScroller.Action action) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition == null || (computeScrollVectorForPosition.x == BitmapDescriptorFactory.HUE_RED && computeScrollVectorForPosition.y == BitmapDescriptorFactory.HUE_RED)) {
            Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
            action.jumpTo(getTargetPosition());
            mo5862e();
            return;
        }
        mo5859a(computeScrollVectorForPosition);
        this.f2821d = computeScrollVectorForPosition;
        this.f2822e = (int) (computeScrollVectorForPosition.x * 10000.0f);
        this.f2823f = (int) (computeScrollVectorForPosition.y * 10000.0f);
        action.update((int) (((float) this.f2822e) * 1.2f), (int) (((float) this.f2823f) * 1.2f), (int) (((float) mo5378b(10000)) * 1.2f), this.f2819b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5377a(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, mo5380c());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, mo5384d());
        int a = mo5373a((int) Math.sqrt((double) ((calculateDxToMakeVisible * calculateDxToMakeVisible) + (calculateDyToMakeVisible * calculateDyToMakeVisible))));
        if (a > 0) {
            action.update(-calculateDxToMakeVisible, -calculateDyToMakeVisible, a, this.f2820c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo5378b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f2818a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5379b() {
        this.f2823f = 0;
        this.f2822e = 0;
        this.f2821d = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo5380c() {
        if (this.f2821d == null || this.f2821d.x == BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return this.f2821d.x > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                int i7 = i4 - i2;
                if (i7 >= 0) {
                    return 0;
                }
                return i7;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int calculateDxToMakeVisible(View view, int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (!layoutManager.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
    }

    public int calculateDyToMakeVisible(View view, int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (!layoutManager.canScrollVertically()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedTop(view) - layoutParams.topMargin, layoutManager.getDecoratedBottom(view) + layoutParams.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
    }

    public abstract PointF computeScrollVectorForPosition(int i);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo5384d() {
        if (this.f2821d == null || this.f2821d.y == BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return this.f2821d.y > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }
}
