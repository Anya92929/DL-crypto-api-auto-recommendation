package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

final class PicassoDrawable extends Drawable {
    private static final Paint DEBUG_PAINT = new Paint();
    private static final float FADE_DURATION = 200.0f;
    boolean animating;
    private final boolean debugging;
    private final float density;
    final BitmapDrawable image;
    private final Picasso.LoadedFrom loadedFrom;
    Drawable placeholder;
    long startTimeMillis;

    static void setBitmap(ImageView target, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom2, boolean noFade, boolean debugging2) {
        target.setImageDrawable(new PicassoDrawable(context, target.getDrawable(), bitmap, loadedFrom2, noFade, debugging2));
    }

    static void setPlaceholder(ImageView target, int placeholderResId, Drawable placeholderDrawable) {
        if (placeholderResId != 0) {
            target.setImageResource(placeholderResId);
        } else {
            target.setImageDrawable(placeholderDrawable);
        }
    }

    PicassoDrawable(Context context, Drawable placeholder2, Bitmap bitmap, Picasso.LoadedFrom loadedFrom2, boolean noFade, boolean debugging2) {
        Resources res = context.getResources();
        this.debugging = debugging2;
        this.density = res.getDisplayMetrics().density;
        this.loadedFrom = loadedFrom2;
        this.image = new BitmapDrawable(res, bitmap);
        if (loadedFrom2 != Picasso.LoadedFrom.MEMORY && !noFade) {
            this.placeholder = placeholder2;
            this.animating = true;
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.animating) {
            this.image.draw(canvas);
        } else {
            float normalized = ((float) (SystemClock.uptimeMillis() - this.startTimeMillis)) / FADE_DURATION;
            if (normalized >= 1.0f) {
                this.animating = false;
                this.placeholder = null;
                this.image.draw(canvas);
            } else {
                if (this.placeholder != null) {
                    this.placeholder.draw(canvas);
                }
                this.image.setAlpha((int) (255.0f * normalized));
                this.image.draw(canvas);
                this.image.setAlpha(MotionEventCompat.ACTION_MASK);
                invalidateSelf();
            }
        }
        if (this.debugging) {
            drawDebugIndicator(canvas);
        }
    }

    public int getIntrinsicWidth() {
        return this.image.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.image.getIntrinsicHeight();
    }

    public void setAlpha(int alpha) {
        if (this.placeholder != null) {
            this.placeholder.setAlpha(alpha);
        }
        this.image.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        if (this.placeholder != null) {
            this.placeholder.setColorFilter(cf);
        }
        this.image.setColorFilter(cf);
    }

    public int getOpacity() {
        return this.image.getOpacity();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.image.setBounds(bounds);
        if (this.placeholder != null) {
            setBounds(this.placeholder);
        }
    }

    private void setBounds(Drawable drawable) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float ratio = ((float) width) / ((float) height);
        int drawableWidth = drawable.getIntrinsicWidth();
        int drawableHeight = drawable.getIntrinsicHeight();
        if (((float) drawableWidth) / ((float) drawableHeight) < ratio) {
            int scaledDrawableWidth = (int) (((float) drawableWidth) * (((float) height) / ((float) drawableHeight)));
            int drawableLeft = bounds.left - ((scaledDrawableWidth - width) / 2);
            int i = bounds.top;
            Drawable drawable2 = drawable;
            int i2 = i;
            drawable2.setBounds(drawableLeft, i2, drawableLeft + scaledDrawableWidth, bounds.bottom);
            return;
        }
        int scaledDrawableHeight = (int) (((float) drawableHeight) * (((float) width) / ((float) drawableWidth)));
        int drawableTop = bounds.top - ((scaledDrawableHeight - height) / 2);
        int i3 = bounds.left;
        drawable.setBounds(i3, drawableTop, bounds.right, drawableTop + scaledDrawableHeight);
    }

    private void drawDebugIndicator(Canvas canvas) {
        DEBUG_PAINT.setColor(-1);
        canvas.drawPath(getTrianglePath(new Point(0, 0), (int) (16.0f * this.density)), DEBUG_PAINT);
        DEBUG_PAINT.setColor(this.loadedFrom.debugColor);
        canvas.drawPath(getTrianglePath(new Point(0, 0), (int) (15.0f * this.density)), DEBUG_PAINT);
    }

    private static Path getTrianglePath(Point p1, int width) {
        Point p2 = new Point(p1.x + width, p1.y);
        Point p3 = new Point(p1.x, p1.y + width);
        Path path = new Path();
        path.moveTo((float) p1.x, (float) p1.y);
        path.lineTo((float) p2.x, (float) p2.y);
        path.lineTo((float) p3.x, (float) p3.y);
        return path;
    }
}
