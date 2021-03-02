package com.appbrain.p036e;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import cmn.C0709ad;

/* renamed from: com.appbrain.e.e */
public class C1032e extends Drawable {

    /* renamed from: a */
    private Paint f2690a = new Paint();

    public C1032e(int i, int i2) {
        int b = C0709ad.m3188b(4.0f);
        Bitmap createBitmap = Bitmap.createBitmap(b, b, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStrokeWidth(((float) b) / 5.0f);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(i);
        canvas.drawLine(0.0f, (float) b, (float) b, 0.0f, paint);
        canvas.drawLine((float) (-b), (float) b, (float) b, (float) (-b), paint);
        canvas.drawLine(0.0f, (float) (b * 2), (float) (b * 2), 0.0f, paint);
        this.f2690a.setShader(new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    public void draw(Canvas canvas) {
        canvas.drawPaint(this.f2690a);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
