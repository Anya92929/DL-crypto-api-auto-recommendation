package com.tapcrowd.app.views.imageviewtouch.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.InputStream;

public class FastBitmapDrawable extends Drawable implements IBitmapDrawable {
    protected Bitmap mBitmap;
    protected Paint mPaint;

    public FastBitmapDrawable(Bitmap b) {
        this.mBitmap = b;
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setFilterBitmap(true);
    }

    public FastBitmapDrawable(Resources res, InputStream is) {
        this(BitmapFactory.decodeStream(is));
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.mBitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.mPaint);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.mPaint.setColorFilter(cf);
    }

    public int getIntrinsicWidth() {
        return this.mBitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.mBitmap.getHeight();
    }

    public int getMinimumWidth() {
        return this.mBitmap.getWidth();
    }

    public int getMinimumHeight() {
        return this.mBitmap.getHeight();
    }

    public void setAntiAlias(boolean value) {
        this.mPaint.setAntiAlias(value);
        invalidateSelf();
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }
}
