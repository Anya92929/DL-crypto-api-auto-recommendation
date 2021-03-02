package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class FadeInBitmapDisplayer implements BitmapDisplayer {
    private final int durationMillis;

    public FadeInBitmapDisplayer(int durationMillis2) {
        this.durationMillis = durationMillis2;
    }

    public Bitmap display(Bitmap bitmap, ImageView imageView) {
        imageView.setImageBitmap(bitmap);
        animate(imageView, this.durationMillis);
        return bitmap;
    }

    public static void animate(ImageView imageView, int durationMillis2) {
        AlphaAnimation fadeImage = new AlphaAnimation(BitmapDescriptorFactory.HUE_RED, 1.0f);
        fadeImage.setDuration((long) durationMillis2);
        fadeImage.setInterpolator(new DecelerateInterpolator());
        imageView.startAnimation(fadeImage);
    }
}
