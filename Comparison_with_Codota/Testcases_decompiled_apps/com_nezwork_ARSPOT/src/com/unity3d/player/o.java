package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES10;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class o extends ImageView {
    private Bitmap a = null;

    public o(Context context) {
        super(context);
    }

    public final void a() {
        if (this.a != null) {
            setImageBitmap(this.a);
            setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight(), 51));
            setPadding(0, 0, 0, 0);
        }
    }

    public final void a(int i, int i2) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.position(0);
        GLES10.glReadPixels(0, 0, i, i2, 6408, 5121, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        allocateDirect.position(0);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        this.a = Bitmap.createBitmap(createBitmap, 0, 0, i, i2, matrix, false);
    }
}
