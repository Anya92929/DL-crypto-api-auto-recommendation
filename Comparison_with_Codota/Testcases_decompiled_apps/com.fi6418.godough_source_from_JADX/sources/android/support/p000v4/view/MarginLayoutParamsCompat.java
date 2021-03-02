package android.support.p000v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.MarginLayoutParamsCompat */
public class MarginLayoutParamsCompat {

    /* renamed from: a */
    static final MarginLayoutParamsCompatImpl f1189a;

    /* renamed from: android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl */
    interface MarginLayoutParamsCompatImpl {
        int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams);

        int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams);

        int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams);

        boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams);

        void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i);
    }

    /* renamed from: android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase */
    class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplBase() {
        }

        public int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return 0;
        }

        public int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }

        public int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return false;
        }

        public void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        }

        public void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        }

        public void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.rightMargin = i;
        }

        public void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.leftMargin = i;
        }
    }

    /* renamed from: android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImplJbMr1 */
    class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplJbMr1() {
        }

        public int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(marginLayoutParams);
        }

        public int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(marginLayoutParams);
        }

        public int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(marginLayoutParams);
        }

        public boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(marginLayoutParams);
        }

        public void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(marginLayoutParams, i);
        }

        public void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(marginLayoutParams, i);
        }

        public void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(marginLayoutParams, i);
        }

        public void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            MarginLayoutParamsCompatJellybeanMr1.setMarginStart(marginLayoutParams, i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f1189a = new MarginLayoutParamsCompatImplJbMr1();
        } else {
            f1189a = new MarginLayoutParamsCompatImplBase();
        }
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f1189a.getLayoutDirection(marginLayoutParams);
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f1189a.getMarginEnd(marginLayoutParams);
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f1189a.getMarginStart(marginLayoutParams);
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f1189a.isMarginRelative(marginLayoutParams);
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f1189a.resolveLayoutDirection(marginLayoutParams, i);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f1189a.setLayoutDirection(marginLayoutParams, i);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f1189a.setMarginEnd(marginLayoutParams, i);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f1189a.setMarginStart(marginLayoutParams, i);
    }
}
