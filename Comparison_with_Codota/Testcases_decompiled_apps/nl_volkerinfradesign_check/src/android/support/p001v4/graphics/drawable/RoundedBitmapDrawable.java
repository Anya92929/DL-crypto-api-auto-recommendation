package android.support.p001v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawable */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a */
    public final Bitmap f491a;

    /* renamed from: b */
    public final Rect f492b = new Rect();

    /* renamed from: c */
    private int f493c = 160;

    /* renamed from: d */
    private int f494d = 119;

    /* renamed from: e */
    private final Paint f495e = new Paint(3);

    /* renamed from: f */
    private final BitmapShader f496f;

    /* renamed from: g */
    private final Matrix f497g = new Matrix();

    /* renamed from: h */
    private float f498h;

    /* renamed from: i */
    private final RectF f499i = new RectF();

    /* renamed from: j */
    private boolean f500j = true;

    /* renamed from: k */
    private boolean f501k;

    /* renamed from: l */
    private int f502l;

    /* renamed from: m */
    private int f503m;

    public final Paint getPaint() {
        return this.f495e;
    }

    public final Bitmap getBitmap() {
        return this.f491a;
    }

    /* renamed from: b */
    private void m532b() {
        this.f502l = this.f491a.getScaledWidth(this.f493c);
        this.f503m = this.f491a.getScaledHeight(this.f493c);
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i) {
        if (this.f493c != i) {
            if (i == 0) {
                i = 160;
            }
            this.f493c = i;
            if (this.f491a != null) {
                m532b();
            }
            invalidateSelf();
        }
    }

    public int getGravity() {
        return this.f494d;
    }

    public void setGravity(int i) {
        if (this.f494d != i) {
            this.f494d = i;
            this.f500j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public void setAntiAlias(boolean z) {
        this.f495e.setAntiAlias(z);
        invalidateSelf();
    }

    public boolean hasAntiAlias() {
        return this.f495e.isAntiAlias();
    }

    public void setFilterBitmap(boolean z) {
        this.f495e.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f495e.setDither(z);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo884a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo883a() {
        if (this.f500j) {
            if (this.f501k) {
                int min = Math.min(this.f502l, this.f503m);
                mo884a(this.f494d, min, min, getBounds(), this.f492b);
                int min2 = Math.min(this.f492b.width(), this.f492b.height());
                this.f492b.inset(Math.max(0, (this.f492b.width() - min2) / 2), Math.max(0, (this.f492b.height() - min2) / 2));
                this.f498h = ((float) min2) * 0.5f;
            } else {
                mo884a(this.f494d, this.f502l, this.f503m, getBounds(), this.f492b);
            }
            this.f499i.set(this.f492b);
            if (this.f496f != null) {
                this.f497g.setTranslate(this.f499i.left, this.f499i.top);
                this.f497g.preScale(this.f499i.width() / ((float) this.f491a.getWidth()), this.f499i.height() / ((float) this.f491a.getHeight()));
                this.f496f.setLocalMatrix(this.f497g);
                this.f495e.setShader(this.f496f);
            }
            this.f500j = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f491a;
        if (bitmap != null) {
            mo883a();
            if (this.f495e.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f492b, this.f495e);
            } else {
                canvas.drawRoundRect(this.f499i, this.f498h, this.f498h, this.f495e);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.f495e.getAlpha()) {
            this.f495e.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f495e.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f495e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f495e.getColorFilter();
    }

    public void setCircular(boolean z) {
        this.f501k = z;
        this.f500j = true;
        if (z) {
            m533c();
            this.f495e.setShader(this.f496f);
            invalidateSelf();
            return;
        }
        setCornerRadius(BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: c */
    private void m533c() {
        this.f498h = (float) (Math.min(this.f503m, this.f502l) / 2);
    }

    public boolean isCircular() {
        return this.f501k;
    }

    public void setCornerRadius(float f) {
        if (this.f498h != f) {
            this.f501k = false;
            if (m531a(f)) {
                this.f495e.setShader(this.f496f);
            } else {
                this.f495e.setShader((Shader) null);
            }
            this.f498h = f;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f501k) {
            m533c();
        }
        this.f500j = true;
    }

    public float getCornerRadius() {
        return this.f498h;
    }

    public int getIntrinsicWidth() {
        return this.f502l;
    }

    public int getIntrinsicHeight() {
        return this.f503m;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.f494d != 119 || this.f501k || (bitmap = this.f491a) == null || bitmap.hasAlpha() || this.f495e.getAlpha() < 255 || m531a(this.f498h)) {
            return -3;
        }
        return -1;
    }

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f493c = resources.getDisplayMetrics().densityDpi;
        }
        this.f491a = bitmap;
        if (this.f491a != null) {
            m532b();
            this.f496f = new BitmapShader(this.f491a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            return;
        }
        this.f503m = -1;
        this.f502l = -1;
        this.f496f = null;
    }

    /* renamed from: a */
    private static boolean m531a(float f) {
        return f > 0.05f;
    }
}
