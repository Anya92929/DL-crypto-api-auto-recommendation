package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.widget.CircleImageView */
class CircleImageView extends ImageView {

    /* renamed from: a */
    private Animation.AnimationListener f1412a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f1413b;

    /* renamed from: android.support.v4.widget.CircleImageView$OvalShadow */
    class OvalShadow extends OvalShape {

        /* renamed from: b */
        private RadialGradient f1415b;

        /* renamed from: c */
        private Paint f1416c = new Paint();

        /* renamed from: d */
        private int f1417d;

        public OvalShadow(int i, int i2) {
            int unused = CircleImageView.this.f1413b = i;
            this.f1417d = i2;
            this.f1415b = new RadialGradient((float) (this.f1417d / 2), (float) (this.f1417d / 2), (float) CircleImageView.this.f1413b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f1416c.setShader(this.f1415b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth();
            int height = CircleImageView.this.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f1417d / 2) + CircleImageView.this.f1413b), this.f1416c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f1417d / 2), paint);
        }
    }

    public CircleImageView(Context context, int i, float f) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (f * f2 * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (BitmapDescriptorFactory.HUE_RED * f2);
        this.f1413b = (int) (3.5f * f2);
        if (m1014a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new OvalShadow(this.f1413b, i2));
            ViewCompat.setLayerType(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f1413b, (float) i4, (float) i3, 503316480);
            int i5 = this.f1413b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    /* renamed from: a */
    private boolean m1014a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f1412a != null) {
            this.f1412a.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f1412a != null) {
            this.f1412a.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m1014a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1413b * 2), getMeasuredHeight() + (this.f1413b * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f1412a = animationListener;
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(getContext().getResources().getColor(i));
    }
}
