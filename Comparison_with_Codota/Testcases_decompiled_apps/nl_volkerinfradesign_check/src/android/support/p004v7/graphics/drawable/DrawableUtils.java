package android.support.p004v7.graphics.drawable;

import android.graphics.PorterDuff;
import android.os.Build;

/* renamed from: android.support.v7.graphics.drawable.DrawableUtils */
public class DrawableUtils {
    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                if (Build.VERSION.SDK_INT >= 11) {
                    return PorterDuff.Mode.valueOf("ADD");
                }
                return mode;
            default:
                return mode;
        }
    }
}
