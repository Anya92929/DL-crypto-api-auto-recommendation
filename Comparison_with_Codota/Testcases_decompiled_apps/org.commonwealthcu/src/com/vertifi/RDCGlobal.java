package com.vertifi;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;

public class RDCGlobal extends Application {
    public static final int BACK_IMAGE = 2001;
    public static final int DIALOG_SHOW_ERRORS = 1000;
    public static final int FRONT_IMAGE = 2000;
    public static String VIP_LOG_TITLE = "VIPSample";
    public static ArrayList mListErrors = new ArrayList();
    public static byte[] mRawImage;
    public static Rect mRectFront;
    public static RectF mRectViewportPhoto = null;
    public static RectF mRectViewportPreview = null;
    public static float mScreenDensity = 0.0f;
    public static Camera.Size mSizePreview;
    public static Camera.Size mSizeRawImage;
    public static int mWindowHeight = 0;
    public static int mWindowWidth = 0;

    public static int getWindowHeight(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public static int getWindowWidth(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public static void init(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        mWindowWidth = point.x;
        mWindowHeight = point.y;
        if (mWindowWidth > mWindowHeight) {
            int i = mWindowWidth;
            mWindowWidth = mWindowHeight;
            mWindowHeight = i;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        mScreenDensity = displayMetrics.density;
    }

    public static void onGC() {
        try {
            System.gc();
            Thread.sleep(10);
        } catch (Exception e) {
        }
    }
}
