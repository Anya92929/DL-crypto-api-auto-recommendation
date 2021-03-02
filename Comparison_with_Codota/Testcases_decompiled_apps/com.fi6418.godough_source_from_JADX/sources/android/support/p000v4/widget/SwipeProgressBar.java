package android.support.p000v4.widget;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.p000v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.SwipeProgressBar */
final class SwipeProgressBar {

    /* renamed from: a */
    private static final Interpolator f1636a = new FastOutSlowInInterpolator();

    /* renamed from: b */
    private final Paint f1637b = new Paint();

    /* renamed from: c */
    private final RectF f1638c = new RectF();

    /* renamed from: d */
    private int f1639d;

    /* renamed from: e */
    private int f1640e;

    /* renamed from: f */
    private int f1641f;

    /* renamed from: g */
    private int f1642g;

    /* renamed from: h */
    private View f1643h;

    /* renamed from: i */
    private Rect f1644i = new Rect();

    public SwipeProgressBar(View view) {
        this.f1643h = view;
        this.f1639d = -1291845632;
        this.f1640e = Integer.MIN_VALUE;
        this.f1641f = 1291845632;
        this.f1642g = 436207616;
    }
}
