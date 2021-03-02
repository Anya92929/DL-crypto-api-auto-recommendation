package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.nostra13.universalimageloader.utils.C0847L;
import org.achartengine.renderer.DefaultRenderer;

public class RoundedBitmapDisplayer implements BitmapDisplayer {
    private final int roundPixels;

    public RoundedBitmapDisplayer(int roundPixels2) {
        this.roundPixels = roundPixels2;
    }

    public Bitmap display(Bitmap bitmap, ImageView imageView) {
        Bitmap roundedBitmap = roundCorners(bitmap, imageView, this.roundPixels);
        imageView.setImageBitmap(roundedBitmap);
        return roundedBitmap;
    }

    public static Bitmap roundCorners(Bitmap bitmap, ImageView imageView, int roundPixels2) {
        int width;
        int height;
        Rect srcRect;
        Rect destRect;
        int srcWidth;
        int srcHeight;
        int x;
        int y;
        int destWidth;
        int destHeight;
        int bw = bitmap.getWidth();
        int bh = bitmap.getHeight();
        int vw = imageView.getWidth();
        int vh = imageView.getHeight();
        if (vw <= 0) {
            vw = bw;
        }
        if (vh <= 0) {
            vh = bh;
        }
        switch (C08461.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
            case 1:
                if (((float) vw) / ((float) vh) > ((float) bw) / ((float) bh)) {
                    destHeight = Math.min(vh, bh);
                    destWidth = (int) (((float) bw) / (((float) bh) / ((float) destHeight)));
                } else {
                    destWidth = Math.min(vw, bw);
                    destHeight = (int) (((float) bh) / (((float) bw) / ((float) destWidth)));
                }
                int x2 = (vw - destWidth) / 2;
                int y2 = (vh - destHeight) / 2;
                srcRect = new Rect(0, 0, bw, bh);
                destRect = new Rect(x2, y2, x2 + destWidth, y2 + destHeight);
                width = vw;
                height = vh;
                break;
            case 5:
                if (((float) vw) / ((float) vh) > ((float) bw) / ((float) bh)) {
                    srcWidth = bw;
                    srcHeight = (int) (((float) vh) * (((float) bw) / ((float) vw)));
                    x = 0;
                    y = (bh - srcHeight) / 2;
                } else {
                    srcWidth = (int) (((float) vw) * (((float) bh) / ((float) vh)));
                    srcHeight = bh;
                    x = (bw - srcWidth) / 2;
                    y = 0;
                }
                width = Math.min(vw, bw);
                height = Math.min(vh, bh);
                srcRect = new Rect(x, y, x + srcWidth, y + srcHeight);
                destRect = new Rect(0, 0, width, height);
                break;
            case 6:
                width = vw;
                height = vh;
                srcRect = new Rect(0, 0, bw, bh);
                destRect = new Rect(0, 0, width, height);
                break;
            case 7:
            case 8:
                width = Math.min(vw, bw);
                height = Math.min(vh, bh);
                int x3 = (bw - width) / 2;
                int y3 = (bh - height) / 2;
                srcRect = new Rect(x3, y3, x3 + width, y3 + height);
                destRect = new Rect(0, 0, width, height);
                break;
            default:
                if (((float) vw) / ((float) vh) > ((float) bw) / ((float) bh)) {
                    width = (int) (((float) bw) / (((float) bh) / ((float) vh)));
                    height = vh;
                } else {
                    width = vw;
                    height = (int) (((float) bh) / (((float) bw) / ((float) vw)));
                }
                srcRect = new Rect(0, 0, bw, bh);
                destRect = new Rect(0, 0, width, height);
                break;
        }
        try {
            return getRoundedCornerBitmap(bitmap, roundPixels2, srcRect, destRect, width, height);
        } catch (OutOfMemoryError e) {
            C0847L.m2148e(e, "Can't create bitmap with rounded corners. Not enough memory.", new Object[0]);
            return bitmap;
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer$1 */
    static /* synthetic */ class C08461 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int roundPixels2, Rect srcRect, Rect destRect, int width, int height) {
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        RectF destRectF = new RectF(destRect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(DefaultRenderer.BACKGROUND_COLOR);
        canvas.drawRoundRect(destRectF, (float) roundPixels2, (float) roundPixels2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, srcRect, destRectF, paint);
        return output;
    }
}
