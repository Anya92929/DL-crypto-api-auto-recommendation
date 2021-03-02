package com.tapcrowd.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.p000v4.view.MotionEventCompat;
import android.util.TypedValue;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tapcrowd.Superminds4060.C0846R;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;

public class IconProvider implements ClusteringSettings.IconDataProvider {
    Bitmap base;
    Context context;
    int five;
    private Paint paint = new Paint(1);

    public IconProvider(Context context2) {
        this.context = context2;
        this.base = ((BitmapDrawable) context2.getResources().getDrawable(C0846R.drawable.cluster)).getBitmap();
        int pixel = (int) TypedValue.applyDimension(1, 18.0f, context2.getResources().getDisplayMetrics());
        this.five = (int) TypedValue.applyDimension(1, 5.0f, context2.getResources().getDisplayMetrics());
        this.paint.setTextAlign(Paint.Align.CENTER);
        this.paint.setTextSize((float) pixel);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        this.paint.setAntiAlias(true);
        this.paint.setARGB(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
    }

    public MarkerOptions getIconData(int markersCount) {
        Bitmap marker = this.base.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(marker);
        canvas.drawText(String.valueOf(markersCount), (float) (canvas.getWidth() / 2), (float) ((int) (((float) (canvas.getHeight() / 2)) - ((this.paint.descent() + this.paint.ascent()) / 2.0f))), this.paint);
        return new MarkerOptions().anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(marker));
    }
}
