package com.jackhenry.godough.core.widgets;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class TouchImageView extends ImageView {

    /* renamed from: a */
    Matrix f6861a;

    /* renamed from: b */
    int f6862b = 0;

    /* renamed from: c */
    PointF f6863c = new PointF();

    /* renamed from: d */
    PointF f6864d = new PointF();

    /* renamed from: e */
    float f6865e = 1.0f;

    /* renamed from: f */
    float f6866f = 3.0f;

    /* renamed from: g */
    float[] f6867g;

    /* renamed from: h */
    int f6868h;

    /* renamed from: i */
    int f6869i;

    /* renamed from: j */
    float f6870j = 1.0f;

    /* renamed from: k */
    protected float f6871k;

    /* renamed from: l */
    protected float f6872l;

    /* renamed from: m */
    int f6873m;

    /* renamed from: n */
    int f6874n;

    /* renamed from: o */
    FlingCallBack f6875o;

    /* renamed from: p */
    ScaleGestureDetector f6876p;

    /* renamed from: q */
    Context f6877q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public GestureDetector f6878r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f6879s = false;

    public interface FlingCallBack {
        public static final boolean NEXT_TRANSACTION = true;
        public static final boolean PREVIOUS_TRANSACTION = false;

        void execute(boolean z);
    }

    public TouchImageView(Context context) {
        super(context);
        m6951a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6951a(context);
    }

    /* renamed from: a */
    private void m6951a(Context context) {
        super.setClickable(true);
        this.f6877q = context;
        this.f6876p = new ScaleGestureDetector(context, new C1924f(this, (C1922d) null));
        this.f6861a = new Matrix();
        this.f6867g = new float[9];
        setImageMatrix(this.f6861a);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f6878r = new GestureDetector(context, new C1923e(this));
        setOnTouchListener(new C1922d(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo11176a(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 <= f2) {
            f5 = f2 - f3;
            f4 = 0.0f;
        } else {
            f4 = f2 - f3;
            f5 = 0.0f;
        }
        return f < f4 ? (-f) + f4 : f > f5 ? (-f) + f5 : BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11177a() {
        this.f6861a.getValues(this.f6867g);
        float f = this.f6867g[2];
        float f2 = this.f6867g[5];
        float a = mo11176a(f, (float) this.f6868h, this.f6871k * this.f6870j);
        float a2 = mo11176a(f2, (float) this.f6869i, this.f6872l * this.f6870j);
        if (a != BitmapDescriptorFactory.HUE_RED || a2 != BitmapDescriptorFactory.HUE_RED) {
            this.f6861a.postTranslate(a, a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo11178b(float f, float f2, float f3) {
        return f3 <= f2 ? BitmapDescriptorFactory.HUE_RED : f;
    }

    public void fitToScreen() {
        this.f6870j = 1.0f;
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float min = Math.min(((float) this.f6868h) / ((float) intrinsicWidth), ((float) this.f6869i) / ((float) intrinsicHeight));
            this.f6861a.setScale(min, min);
            float f = (((float) this.f6869i) - (((float) intrinsicHeight) * min)) / 2.0f;
            float f2 = (((float) this.f6868h) - (((float) intrinsicWidth) * min)) / 2.0f;
            this.f6861a.postTranslate(f2, f);
            this.f6871k = ((float) this.f6868h) - (f2 * 2.0f);
            this.f6872l = ((float) this.f6869i) - (f * 2.0f);
            setImageMatrix(this.f6861a);
        }
    }

    public FlingCallBack getFlingCallBack() {
        return this.f6875o;
    }

    public boolean isSwipeEnable() {
        return this.f6879s;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f6868h = View.MeasureSpec.getSize(i);
        this.f6869i = View.MeasureSpec.getSize(i2);
        if ((this.f6874n != this.f6868h || this.f6874n != this.f6869i) && this.f6868h != 0 && this.f6869i != 0) {
            this.f6874n = this.f6869i;
            this.f6873m = this.f6868h;
            if (this.f6870j == 1.0f) {
                fitToScreen();
            }
            mo11177a();
        }
    }

    public void setFlingCallBack(FlingCallBack flingCallBack) {
        this.f6875o = flingCallBack;
    }

    public void setMaxZoom(float f) {
        this.f6866f = f;
    }

    public void setSwipeEnable(boolean z) {
        this.f6879s = z;
    }
}
