package android.support.p003v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p003v7.appcompat.C0235R;
import android.util.AttributeSet;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v7.graphics.drawable.DrawerArrowDrawable */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;

    /* renamed from: b */
    private static final float f1885b = ((float) Math.toRadians(45.0d));

    /* renamed from: a */
    private final Paint f1886a = new Paint();

    /* renamed from: c */
    private float f1887c;

    /* renamed from: d */
    private float f1888d;

    /* renamed from: e */
    private float f1889e;

    /* renamed from: f */
    private float f1890f;

    /* renamed from: g */
    private boolean f1891g;

    /* renamed from: h */
    private final Path f1892h = new Path();

    /* renamed from: i */
    private final int f1893i;

    /* renamed from: j */
    private boolean f1894j = false;

    /* renamed from: k */
    private float f1895k;

    /* renamed from: l */
    private float f1896l;

    /* renamed from: m */
    private int f1897m = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.graphics.drawable.DrawerArrowDrawable$ArrowDirection */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        this.f1886a.setStyle(Paint.Style.STROKE);
        this.f1886a.setStrokeJoin(Paint.Join.MITER);
        this.f1886a.setStrokeCap(Paint.Cap.BUTT);
        this.f1886a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, C0235R.styleable.DrawerArrowToggle, C0235R.attr.drawerArrowStyle, C0235R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(C0235R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(C0235R.styleable.DrawerArrowToggle_thickness, BitmapDescriptorFactory.HUE_RED));
        setSpinEnabled(obtainStyledAttributes.getBoolean(C0235R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(C0235R.styleable.DrawerArrowToggle_gapBetweenBars, BitmapDescriptorFactory.HUE_RED)));
        this.f1893i = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f1888d = (float) Math.round(obtainStyledAttributes.getDimension(C0235R.styleable.DrawerArrowToggle_barLength, BitmapDescriptorFactory.HUE_RED));
        this.f1887c = (float) Math.round(obtainStyledAttributes.getDimension(C0235R.styleable.DrawerArrowToggle_arrowHeadLength, BitmapDescriptorFactory.HUE_RED));
        this.f1889e = obtainStyledAttributes.getDimension(C0235R.styleable.DrawerArrowToggle_arrowShaftLength, BitmapDescriptorFactory.HUE_RED);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private static float m1329a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Rect bounds = getBounds();
        switch (this.f1897m) {
            case 0:
                z = false;
                break;
            case 1:
                z = true;
                break;
            case 3:
                if (DrawableCompat.getLayoutDirection(this) != 0) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
            default:
                if (DrawableCompat.getLayoutDirection(this) != 1) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        float a = m1329a(this.f1888d, (float) Math.sqrt((double) (this.f1887c * this.f1887c * 2.0f)), this.f1895k);
        float a2 = m1329a(this.f1888d, this.f1889e, this.f1895k);
        float round = (float) Math.round(m1329a(BitmapDescriptorFactory.HUE_RED, this.f1896l, this.f1895k));
        float a3 = m1329a(BitmapDescriptorFactory.HUE_RED, f1885b, this.f1895k);
        float a4 = m1329a(z ? 0.0f : -180.0f, z ? 180.0f : BitmapDescriptorFactory.HUE_RED, this.f1895k);
        float round2 = (float) Math.round(((double) a) * Math.cos((double) a3));
        float round3 = (float) Math.round(((double) a) * Math.sin((double) a3));
        this.f1892h.rewind();
        float a5 = m1329a(this.f1890f + this.f1886a.getStrokeWidth(), -this.f1896l, this.f1895k);
        float f = (-a2) / 2.0f;
        this.f1892h.moveTo(f + round, BitmapDescriptorFactory.HUE_RED);
        this.f1892h.rLineTo(a2 - (round * 2.0f), BitmapDescriptorFactory.HUE_RED);
        this.f1892h.moveTo(f, a5);
        this.f1892h.rLineTo(round2, round3);
        this.f1892h.moveTo(f, -a5);
        this.f1892h.rLineTo(round2, -round3);
        this.f1892h.close();
        canvas.save();
        float strokeWidth = this.f1886a.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (float) (((double) ((float) ((((int) ((((float) bounds.height()) - (3.0f * strokeWidth)) - (this.f1890f * 2.0f))) / 4) * 2))) + (((double) strokeWidth) * 1.5d) + ((double) this.f1890f)));
        if (this.f1891g) {
            canvas.rotate(((float) (z ^ this.f1894j ? -1 : 1)) * a4);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1892h, this.f1886a);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.f1887c;
    }

    public float getArrowShaftLength() {
        return this.f1889e;
    }

    public float getBarLength() {
        return this.f1888d;
    }

    public float getBarThickness() {
        return this.f1886a.getStrokeWidth();
    }

    public int getColor() {
        return this.f1886a.getColor();
    }

    public int getDirection() {
        return this.f1897m;
    }

    public float getGapSize() {
        return this.f1890f;
    }

    public int getIntrinsicHeight() {
        return this.f1893i;
    }

    public int getIntrinsicWidth() {
        return this.f1893i;
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgress() {
        return this.f1895k;
    }

    public boolean isSpinEnabled() {
        return this.f1891g;
    }

    public void setAlpha(int i) {
        if (i != this.f1886a.getAlpha()) {
            this.f1886a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f) {
        if (this.f1887c != f) {
            this.f1887c = f;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f) {
        if (this.f1889e != f) {
            this.f1889e = f;
            invalidateSelf();
        }
    }

    public void setBarLength(float f) {
        if (this.f1888d != f) {
            this.f1888d = f;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f) {
        if (this.f1886a.getStrokeWidth() != f) {
            this.f1886a.setStrokeWidth(f);
            this.f1896l = (float) (((double) (f / 2.0f)) * Math.cos((double) f1885b));
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        if (i != this.f1886a.getColor()) {
            this.f1886a.setColor(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1886a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i) {
        if (i != this.f1897m) {
            this.f1897m = i;
            invalidateSelf();
        }
    }

    public void setGapSize(float f) {
        if (f != this.f1890f) {
            this.f1890f = f;
            invalidateSelf();
        }
    }

    public void setProgress(float f) {
        if (this.f1895k != f) {
            this.f1895k = f;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.f1891g != z) {
            this.f1891g = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.f1894j != z) {
            this.f1894j = z;
            invalidateSelf();
        }
    }
}
