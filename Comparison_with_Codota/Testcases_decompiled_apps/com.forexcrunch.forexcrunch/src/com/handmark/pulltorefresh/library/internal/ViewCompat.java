package com.handmark.pulltorefresh.library.internal;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewCompat {
    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            SDK16.postOnAnimation(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    public static void setBackground(View view, Drawable background) {
        if (Build.VERSION.SDK_INT >= 16) {
            SDK16.setBackground(view, background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    public static void setLayerType(View view, int layerType) {
        if (Build.VERSION.SDK_INT >= 11) {
            SDK11.setLayerType(view, layerType);
        }
    }

    @TargetApi(11)
    static class SDK11 {
        SDK11() {
        }

        public static void setLayerType(View view, int layerType) {
            view.setLayerType(layerType, (Paint) null);
        }
    }

    @TargetApi(16)
    static class SDK16 {
        SDK16() {
        }

        public static void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void setBackground(View view, Drawable background) {
            view.setBackground(background);
        }
    }
}
