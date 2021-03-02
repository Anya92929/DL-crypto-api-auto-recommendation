package com.tapcrowd.app.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tapcrowd.app.modules.map.MapV2Fragment;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Converter;
import java.util.List;

public class PathDrawer extends View {
    private List<MapV2Fragment.Vertex> Path;
    private Context context;
    private Matrix matrix;
    private float scale;

    public PathDrawer(Context context2, AttributeSet attrs) {
        super(context2, attrs);
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.Path != null) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int w = metrics.widthPixels;
            int h = metrics.heightPixels;
            Paint paint = new Paint(1);
            paint.setStrokeWidth((float) ((int) Converter.convertDpToPixel(4.0f, this.context)));
            paint.setColor(C1216LO.getLo(C1216LO.navigationColor));
            paint.setDither(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            Path path = new Path();
            boolean firstpoint = true;
            for (MapV2Fragment.Vertex point : this.Path) {
                float x = ((((float) point.getX()) / this.scale) * getValue(0)) + getValue(2);
                float y = ((((float) point.getY()) / this.scale) * getValue(4)) + getValue(5);
                if (x > ((float) (-(2048 - (w / 2)))) && y > ((float) (-(2048 - (h / 2)))) && x < ((float) ((w / 2) + 2048)) && y < ((float) ((h / 2) + 2048))) {
                    if (firstpoint) {
                        path.moveTo(x, y);
                        firstpoint = false;
                    } else {
                        path.lineTo(x, y);
                        path.moveTo(x, y);
                    }
                }
            }
            canvas.drawPath(path, paint);
        }
        super.onDraw(canvas);
    }

    public void setPath(List<MapV2Fragment.Vertex> Path2) {
        this.Path = Path2;
        invalidate();
    }

    public void setinitScale(float scale2) {
        this.scale = scale2;
    }

    public void UpdatePosition(Matrix matrix2) {
        this.matrix = matrix2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public float getValue(int whichValue) {
        float[] mMatrixValues = new float[9];
        this.matrix.getValues(mMatrixValues);
        return mMatrixValues[whichValue];
    }
}
