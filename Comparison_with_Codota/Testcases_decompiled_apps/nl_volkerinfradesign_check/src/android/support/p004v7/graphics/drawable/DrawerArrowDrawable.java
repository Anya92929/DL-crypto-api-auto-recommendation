package android.support.p004v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p004v7.appcompat.C0505R;
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
    private static final float f1615b = ((float) Math.toRadians(45.0d));

    /* renamed from: a */
    private final Paint f1616a = new Paint();

    /* renamed from: c */
    private float f1617c;

    /* renamed from: d */
    private float f1618d;

    /* renamed from: e */
    private float f1619e;

    /* renamed from: f */
    private float f1620f;

    /* renamed from: g */
    private boolean f1621g;

    /* renamed from: h */
    private final Path f1622h = new Path();

    /* renamed from: i */
    private final int f1623i;

    /* renamed from: j */
    private boolean f1624j = false;

    /* renamed from: k */
    private float f1625k;

    /* renamed from: l */
    private float f1626l;

    /* renamed from: m */
    private int f1627m = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.graphics.drawable.DrawerArrowDrawable$ArrowDirection */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        this.f1616a.setStyle(Paint.Style.STROKE);
        this.f1616a.setStrokeJoin(Paint.Join.MITER);
        this.f1616a.setStrokeCap(Paint.Cap.BUTT);
        this.f1616a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, C0505R.styleable.DrawerArrowToggle, C0505R.attr.drawerArrowStyle, C0505R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(C0505R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(C0505R.styleable.DrawerArrowToggle_thickness, BitmapDescriptorFactory.HUE_RED));
        setSpinEnabled(obtainStyledAttributes.getBoolean(C0505R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(C0505R.styleable.DrawerArrowToggle_gapBetweenBars, BitmapDescriptorFactory.HUE_RED)));
        this.f1623i = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f1618d = (float) Math.round(obtainStyledAttributes.getDimension(C0505R.styleable.DrawerArrowToggle_barLength, BitmapDescriptorFactory.HUE_RED));
        this.f1617c = (float) Math.round(obtainStyledAttributes.getDimension(C0505R.styleable.DrawerArrowToggle_arrowHeadLength, BitmapDescriptorFactory.HUE_RED));
        this.f1619e = obtainStyledAttributes.getDimension(C0505R.styleable.DrawerArrowToggle_arrowShaftLength, BitmapDescriptorFactory.HUE_RED);
        obtainStyledAttributes.recycle();
    }

    public void setArrowHeadLength(float f) {
        if (this.f1617c != f) {
            this.f1617c = f;
            invalidateSelf();
        }
    }

    public float getArrowHeadLength() {
        return this.f1617c;
    }

    public void setArrowShaftLength(float f) {
        if (this.f1619e != f) {
            this.f1619e = f;
            invalidateSelf();
        }
    }

    public float getArrowShaftLength() {
        return this.f1619e;
    }

    public float getBarLength() {
        return this.f1618d;
    }

    public void setBarLength(float f) {
        if (this.f1618d != f) {
            this.f1618d = f;
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i) {
        if (i != this.f1616a.getColor()) {
            this.f1616a.setColor(i);
            invalidateSelf();
        }
    }

    @ColorInt
    public int getColor() {
        return this.f1616a.getColor();
    }

    public void setBarThickness(float f) {
        if (this.f1616a.getStrokeWidth() != f) {
            this.f1616a.setStrokeWidth(f);
            this.f1626l = (float) (((double) (f / 2.0f)) * Math.cos((double) f1615b));
            invalidateSelf();
        }
    }

    public float getBarThickness() {
        return this.f1616a.getStrokeWidth();
    }

    public float getGapSize() {
        return this.f1620f;
    }

    public void setGapSize(float f) {
        if (f != this.f1620f) {
            this.f1620f = f;
            invalidateSelf();
        }
    }

    public void setDirection(int i) {
        if (i != this.f1627m) {
            this.f1627m = i;
            invalidateSelf();
        }
    }

    public boolean isSpinEnabled() {
        return this.f1621g;
    }

    public void setSpinEnabled(boolean z) {
        if (this.f1621g != z) {
            this.f1621g = z;
            invalidateSelf();
        }
    }

    public int getDirection() {
        return this.f1627m;
    }

    public void setVerticalMirror(boolean z) {
        if (this.f1624j != z) {
            this.f1624j = z;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        float f;
        float f2;
        Rect bounds = getBounds();
        switch (this.f1627m) {
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
        float a = m2993a(this.f1618d, (float) Math.sqrt((double) (this.f1617c * this.f1617c * 2.0f)), this.f1625k);
        float a2 = m2993a(this.f1618d, this.f1619e, this.f1625k);
        float round = (float) Math.round(m2993a(BitmapDescriptorFactory.HUE_RED, this.f1626l, this.f1625k));
        float a3 = m2993a(BitmapDescriptorFactory.HUE_RED, f1615b, this.f1625k);
        if (z) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (z) {
            f2 = 180.0f;
        } else {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        float a4 = m2993a(f, f2, this.f1625k);
        float round2 = (float) Math.round(((double) a) * Math.cos((double) a3));
        float round3 = (float) Math.round(((double) a) * Math.sin((double) a3));
        this.f1622h.rewind();
        float a5 = m2993a(this.f1620f + this.f1616a.getStrokeWidth(), -this.f1626l, this.f1625k);
        float f3 = (-a2) / 2.0f;
        this.f1622h.moveTo(f3 + round, BitmapDescriptorFactory.HUE_RED);
        this.f1622h.rLineTo(a2 - (round * 2.0f), BitmapDescriptorFactory.HUE_RED);
        this.f1622h.moveTo(f3, a5);
        this.f1622h.rLineTo(round2, round3);
        this.f1622h.moveTo(f3, -a5);
        this.f1622h.rLineTo(round2, -round3);
        this.f1622h.close();
        canvas.save();
        float strokeWidth = this.f1616a.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (float) (((double) ((float) ((((int) ((((float) bounds.height()) - (3.0f * strokeWidth)) - (this.f1620f * 2.0f))) / 4) * 2))) + (((double) strokeWidth) * 1.5d) + ((double) this.f1620f)));
        if (this.f1621g) {
            canvas.rotate(((float) (z ^ this.f1624j ? -1 : 1)) * a4);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1622h, this.f1616a);
        canvas.restore();
    }

    public void setAlpha(int i) {
        if (i != this.f1616a.getAlpha()) {
            this.f1616a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1616a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f1623i;
    }

    public int getIntrinsicWidth() {
        return this.f1623i;
    }

    public int getOpacity() {
        return -3;
    }

    @FloatRange(from = 0.0d, mo4to = 1.0d)
    public float getProgress() {
        return this.f1625k;
    }

    public void setProgress(@FloatRange(from = 0.0d, mo4to = 1.0d) float f) {
        if (this.f1625k != f) {
            this.f1625k = f;
            invalidateSelf();
        }
    }

    public final Paint getPaint() {
        return this.f1616a;
    }

    /* renamed from: a */
    private static float m2993a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
