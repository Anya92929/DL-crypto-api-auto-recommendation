package android.support.p000v4.graphics.drawable;

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
    final Bitmap f795a;

    /* renamed from: b */
    final Rect f796b = new Rect();

    /* renamed from: c */
    private int f797c = 160;

    /* renamed from: d */
    private int f798d = 119;

    /* renamed from: e */
    private final Paint f799e = new Paint(3);

    /* renamed from: f */
    private final BitmapShader f800f;

    /* renamed from: g */
    private final Matrix f801g = new Matrix();

    /* renamed from: h */
    private float f802h;

    /* renamed from: i */
    private final RectF f803i = new RectF();

    /* renamed from: j */
    private boolean f804j = true;

    /* renamed from: k */
    private boolean f805k;

    /* renamed from: l */
    private int f806l;

    /* renamed from: m */
    private int f807m;

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f797c = resources.getDisplayMetrics().densityDpi;
        }
        this.f795a = bitmap;
        if (this.f795a != null) {
            m660b();
            this.f800f = new BitmapShader(this.f795a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            return;
        }
        this.f807m = -1;
        this.f806l = -1;
        this.f800f = null;
    }

    /* renamed from: a */
    private static boolean m659a(float f) {
        return f > 0.05f;
    }

    /* renamed from: b */
    private void m660b() {
        this.f806l = this.f795a.getScaledWidth(this.f797c);
        this.f807m = this.f795a.getScaledHeight(this.f797c);
    }

    /* renamed from: c */
    private void m661c() {
        this.f802h = (float) (Math.min(this.f807m, this.f806l) / 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1286a() {
        if (this.f804j) {
            if (this.f805k) {
                int min = Math.min(this.f806l, this.f807m);
                mo1287a(this.f798d, min, min, getBounds(), this.f796b);
                int min2 = Math.min(this.f796b.width(), this.f796b.height());
                this.f796b.inset(Math.max(0, (this.f796b.width() - min2) / 2), Math.max(0, (this.f796b.height() - min2) / 2));
                this.f802h = ((float) min2) * 0.5f;
            } else {
                mo1287a(this.f798d, this.f806l, this.f807m, getBounds(), this.f796b);
            }
            this.f803i.set(this.f796b);
            if (this.f800f != null) {
                this.f801g.setTranslate(this.f803i.left, this.f803i.top);
                this.f801g.preScale(this.f803i.width() / ((float) this.f795a.getWidth()), this.f803i.height() / ((float) this.f795a.getHeight()));
                this.f800f.setLocalMatrix(this.f801g);
                this.f799e.setShader(this.f800f);
            }
            this.f804j = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1287a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f795a;
        if (bitmap != null) {
            mo1286a();
            if (this.f799e.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f796b, this.f799e);
            } else {
                canvas.drawRoundRect(this.f803i, this.f802h, this.f802h, this.f799e);
            }
        }
    }

    public int getAlpha() {
        return this.f799e.getAlpha();
    }

    public final Bitmap getBitmap() {
        return this.f795a;
    }

    public ColorFilter getColorFilter() {
        return this.f799e.getColorFilter();
    }

    public float getCornerRadius() {
        return this.f802h;
    }

    public int getGravity() {
        return this.f798d;
    }

    public int getIntrinsicHeight() {
        return this.f807m;
    }

    public int getIntrinsicWidth() {
        return this.f806l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = r3.f795a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOpacity() {
        /*
            r3 = this;
            r0 = -3
            int r1 = r3.f798d
            r2 = 119(0x77, float:1.67E-43)
            if (r1 != r2) goto L_0x000b
            boolean r1 = r3.f805k
            if (r1 == 0) goto L_0x000c
        L_0x000b:
            return r0
        L_0x000c:
            android.graphics.Bitmap r1 = r3.f795a
            if (r1 == 0) goto L_0x000b
            boolean r1 = r1.hasAlpha()
            if (r1 != 0) goto L_0x000b
            android.graphics.Paint r1 = r3.f799e
            int r1 = r1.getAlpha()
            r2 = 255(0xff, float:3.57E-43)
            if (r1 < r2) goto L_0x000b
            float r1 = r3.f802h
            boolean r1 = m659a(r1)
            if (r1 != 0) goto L_0x000b
            r0 = -1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.drawable.RoundedBitmapDrawable.getOpacity():int");
    }

    public final Paint getPaint() {
        return this.f799e;
    }

    public boolean hasAntiAlias() {
        return this.f799e.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.f805k;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f805k) {
            m661c();
        }
        this.f804j = true;
    }

    public void setAlpha(int i) {
        if (i != this.f799e.getAlpha()) {
            this.f799e.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.f799e.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.f805k = z;
        this.f804j = true;
        if (z) {
            m661c();
            this.f799e.setShader(this.f800f);
            invalidateSelf();
            return;
        }
        setCornerRadius(BitmapDescriptorFactory.HUE_RED);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f799e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        if (this.f802h != f) {
            this.f805k = false;
            if (m659a(f)) {
                this.f799e.setShader(this.f800f);
            } else {
                this.f799e.setShader((Shader) null);
            }
            this.f802h = f;
            invalidateSelf();
        }
    }

    public void setDither(boolean z) {
        this.f799e.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.f799e.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.f798d != i) {
            this.f798d = i;
            this.f804j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(int i) {
        if (this.f797c != i) {
            if (i == 0) {
                i = 160;
            }
            this.f797c = i;
            if (this.f795a != null) {
                m660b();
            }
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }
}
