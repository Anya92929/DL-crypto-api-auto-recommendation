package p006nl.volkerinfradesign.checkandroid.p007ui.drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.drawing.DrawingView */
public class DrawingView extends View {

    /* renamed from: a */
    List<PathPaint> f5012a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f5013b = ViewCompat.MEASURED_STATE_MASK;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f5014c = 5;

    /* renamed from: d */
    private Bitmap f5015d = null;

    /* renamed from: e */
    private Bitmap f5016e = null;

    /* renamed from: f */
    private Paint f5017f = new Paint();

    /* renamed from: g */
    private float f5018g = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: h */
    private float f5019h = BitmapDescriptorFactory.HUE_RED;

    public void undo() {
        if (this.f5012a.size() > 0) {
            this.f5012a.remove(this.f5012a.size() - 1);
        }
        invalidate();
    }

    public Bitmap getmBackground() {
        return this.f5016e;
    }

    public void setmBackground(Bitmap bitmap) {
        setOriginalBackground(bitmap);
        this.f5016e = m6065a(bitmap);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5018g = (float) i;
        this.f5019h = (float) i2;
        if (i != i3 || i2 != i4) {
            this.f5016e = m6065a(getOriginalBackground());
        }
    }

    /* renamed from: a */
    private Bitmap m6065a(Bitmap bitmap) {
        if (bitmap == null || this.f5018g == BitmapDescriptorFactory.HUE_RED || this.f5019h == BitmapDescriptorFactory.HUE_RED) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(this.f5018g / width, this.f5019h / height);
        matrix.postScale(max, max);
        if (bitmap.getWidth() > bitmap.getHeight() && this.f5018g < this.f5019h) {
            matrix.postRotate((float) 90);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }

    public void setPaintSize(int i) {
        this.f5014c = i;
    }

    public Bitmap getOriginalBackground() {
        return this.f5015d;
    }

    public void setOriginalBackground(Bitmap bitmap) {
        this.f5015d = bitmap;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.drawing.DrawingView$PathPaint */
    public class PathPaint {

        /* renamed from: a */
        Paint f5020a;

        /* renamed from: b */
        Path f5021b;

        PathPaint() {
            this.f5020a = new Paint();
            this.f5020a = new Paint();
            this.f5020a.setColor(DrawingView.this.f5013b);
            this.f5020a.setAntiAlias(true);
            this.f5020a.setStrokeWidth(((float) DrawingView.this.f5014c) * DrawingView.this.getResources().getDisplayMetrics().density);
            this.f5020a.setStyle(Paint.Style.STROKE);
            this.f5020a.setStrokeJoin(Paint.Join.ROUND);
            this.f5020a.setStrokeCap(Paint.Cap.ROUND);
            this.f5021b = new Path();
        }
    }

    public DrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setPaintColor(int i) {
        this.f5013b = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(-1);
        if (getmBackground() != null) {
            canvas.drawBitmap(getmBackground(), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.f5017f);
        }
        for (PathPaint next : this.f5012a) {
            canvas.drawPath(next.f5021b, next.f5020a);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                PathPaint pathPaint = new PathPaint();
                pathPaint.f5021b.moveTo(x, y);
                this.f5012a.add(pathPaint);
                return true;
            case 2:
                if (this.f5012a.size() > 0) {
                    this.f5012a.get(this.f5012a.size() - 1).f5021b.lineTo(x, y);
                }
                postInvalidate();
                return true;
            default:
                return false;
        }
    }
}
