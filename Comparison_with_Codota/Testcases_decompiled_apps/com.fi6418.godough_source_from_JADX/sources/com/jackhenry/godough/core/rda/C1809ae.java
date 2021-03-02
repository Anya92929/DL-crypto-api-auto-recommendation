package com.jackhenry.godough.core.rda;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* renamed from: com.jackhenry.godough.core.rda.ae */
public class C1809ae {
    /* renamed from: a */
    public static Bitmap m6713a(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        matrix.setRotate((float) i, ((float) width) / 2.0f, ((float) height) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return bitmap != createBitmap ? createBitmap : bitmap;
    }
}
