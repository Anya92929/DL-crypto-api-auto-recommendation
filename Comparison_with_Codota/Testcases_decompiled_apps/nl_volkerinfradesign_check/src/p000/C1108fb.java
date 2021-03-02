package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.p001v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: fb */
public class C1108fb extends ImageView {

    /* renamed from: a */
    private Animation.AnimationListener f4076a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f4077b;

    public C1108fb(Context context, int i, float f) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (f * f2 * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (BitmapDescriptorFactory.HUE_RED * f2);
        this.f4077b = (int) (3.5f * f2);
        if (m5039a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C1109a(this.f4077b, i2));
            ViewCompat.setLayerType(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f4077b, (float) i4, (float) i3, 503316480);
            int i5 = this.f4077b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    /* renamed from: a */
    private boolean m5039a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m5039a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f4077b * 2), getMeasuredHeight() + (this.f4077b * 2));
        }
    }

    /* renamed from: a */
    public void mo8102a(Animation.AnimationListener animationListener) {
        this.f4076a = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f4076a != null) {
            this.f4076a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f4076a != null) {
            this.f4076a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    /* renamed from: fb$a */
    class C1109a extends OvalShape {

        /* renamed from: b */
        private RadialGradient f4079b;

        /* renamed from: c */
        private Paint f4080c = new Paint();

        /* renamed from: d */
        private int f4081d;

        public C1109a(int i, int i2) {
            int unused = C1108fb.this.f4077b = i;
            this.f4081d = i2;
            this.f4079b = new RadialGradient((float) (this.f4081d / 2), (float) (this.f4081d / 2), (float) C1108fb.this.f4077b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f4080c.setShader(this.f4079b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = C1108fb.this.getWidth();
            int height = C1108fb.this.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f4081d / 2) + C1108fb.this.f4077b), this.f4080c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f4081d / 2), paint);
        }
    }
}
