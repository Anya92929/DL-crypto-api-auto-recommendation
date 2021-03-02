package android.support.p021v7.p024c.p025a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0514j;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;

/* renamed from: android.support.v7.c.a.b */
public class C0517b extends Drawable {

    /* renamed from: b */
    private static final float f879b = ((float) Math.toRadians(45.0d));

    /* renamed from: a */
    private final Paint f880a = new Paint();

    /* renamed from: c */
    private float f881c;

    /* renamed from: d */
    private float f882d;

    /* renamed from: e */
    private float f883e;

    /* renamed from: f */
    private float f884f;

    /* renamed from: g */
    private boolean f885g;

    /* renamed from: h */
    private final Path f886h = new Path();

    /* renamed from: i */
    private final int f887i;

    /* renamed from: j */
    private boolean f888j = false;

    /* renamed from: k */
    private float f889k;

    /* renamed from: l */
    private float f890l;

    /* renamed from: m */
    private int f891m = 2;

    public C0517b(Context context) {
        this.f880a.setStyle(Paint.Style.STROKE);
        this.f880a.setStrokeJoin(Paint.Join.MITER);
        this.f880a.setStrokeCap(Paint.Cap.BUTT);
        this.f880a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, C0515k.DrawerArrowToggle, C0506b.drawerArrowStyle, C0514j.Base_Widget_AppCompat_DrawerArrowToggle);
        mo2173a(obtainStyledAttributes.getColor(C0515k.DrawerArrowToggle_color, 0));
        mo2175b(obtainStyledAttributes.getDimension(C0515k.DrawerArrowToggle_thickness, 0.0f));
        mo2174a(obtainStyledAttributes.getBoolean(C0515k.DrawerArrowToggle_spinBars, true));
        mo2177c((float) Math.round(obtainStyledAttributes.getDimension(C0515k.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f887i = obtainStyledAttributes.getDimensionPixelSize(C0515k.DrawerArrowToggle_drawableSize, 0);
        this.f882d = (float) Math.round(obtainStyledAttributes.getDimension(C0515k.DrawerArrowToggle_barLength, 0.0f));
        this.f881c = (float) Math.round(obtainStyledAttributes.getDimension(C0515k.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f883e = obtainStyledAttributes.getDimension(C0515k.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private static float m2171a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* renamed from: a */
    public void mo2173a(int i) {
        if (i != this.f880a.getColor()) {
            this.f880a.setColor(i);
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public void mo2174a(boolean z) {
        if (this.f885g != z) {
            this.f885g = z;
            invalidateSelf();
        }
    }

    /* renamed from: b */
    public void mo2175b(float f) {
        if (this.f880a.getStrokeWidth() != f) {
            this.f880a.setStrokeWidth(f);
            this.f890l = (float) (((double) (f / 2.0f)) * Math.cos((double) f879b));
            invalidateSelf();
        }
    }

    /* renamed from: b */
    public void mo2176b(boolean z) {
        if (this.f888j != z) {
            this.f888j = z;
            invalidateSelf();
        }
    }

    /* renamed from: c */
    public void mo2177c(float f) {
        if (f != this.f884f) {
            this.f884f = f;
            invalidateSelf();
        }
    }

    /* renamed from: d */
    public void mo2178d(float f) {
        if (this.f889k != f) {
            this.f889k = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        Rect bounds = getBounds();
        switch (this.f891m) {
            case 0:
                z = false;
                break;
            case 1:
                z = true;
                break;
            case 3:
                if (C0095a.m209g(this) != 0) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
            default:
                if (C0095a.m209g(this) != 1) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        float a = m2171a(this.f882d, (float) Math.sqrt((double) (this.f881c * this.f881c * 2.0f)), this.f889k);
        float a2 = m2171a(this.f882d, this.f883e, this.f889k);
        float round = (float) Math.round(m2171a(0.0f, this.f890l, this.f889k));
        float a3 = m2171a(0.0f, f879b, this.f889k);
        float a4 = m2171a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.f889k);
        float round2 = (float) Math.round(((double) a) * Math.cos((double) a3));
        float round3 = (float) Math.round(((double) a) * Math.sin((double) a3));
        this.f886h.rewind();
        float a5 = m2171a(this.f884f + this.f880a.getStrokeWidth(), -this.f890l, this.f889k);
        float f = (-a2) / 2.0f;
        this.f886h.moveTo(f + round, 0.0f);
        this.f886h.rLineTo(a2 - (round * 2.0f), 0.0f);
        this.f886h.moveTo(f, a5);
        this.f886h.rLineTo(round2, round3);
        this.f886h.moveTo(f, -a5);
        this.f886h.rLineTo(round2, -round3);
        this.f886h.close();
        canvas.save();
        float strokeWidth = this.f880a.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (float) (((double) ((float) ((((int) ((((float) bounds.height()) - (3.0f * strokeWidth)) - (this.f884f * 2.0f))) / 4) * 2))) + (((double) strokeWidth) * 1.5d) + ((double) this.f884f)));
        if (this.f885g) {
            canvas.rotate(((float) (z ^ this.f888j ? -1 : 1)) * a4);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f886h, this.f880a);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f887i;
    }

    public int getIntrinsicWidth() {
        return this.f887i;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        if (i != this.f880a.getAlpha()) {
            this.f880a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f880a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
