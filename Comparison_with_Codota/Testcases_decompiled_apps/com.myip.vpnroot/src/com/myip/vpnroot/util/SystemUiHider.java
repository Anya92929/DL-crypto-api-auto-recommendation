package com.myip.vpnroot.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;

public abstract class SystemUiHider {
    public static final int FLAG_FULLSCREEN = 2;
    public static final int FLAG_HIDE_NAVIGATION = 6;
    public static final int FLAG_LAYOUT_IN_SCREEN_OLDER_DEVICES = 1;
    private static OnVisibilityChangeListener sDummyListener = new OnVisibilityChangeListener() {
        public void onVisibilityChange(boolean visible) {
        }
    };
    protected Activity mActivity;
    protected View mAnchorView;
    protected int mFlags;
    protected OnVisibilityChangeListener mOnVisibilityChangeListener = sDummyListener;

    public interface OnVisibilityChangeListener {
        void onVisibilityChange(boolean z);
    }

    public abstract void hide();

    public abstract boolean isVisible();

    public abstract void setup();

    public abstract void show();

    public static SystemUiHider getInstance(Activity activity, View anchorView, int flags) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new SystemUiHiderHoneycomb(activity, anchorView, flags);
        }
        return new SystemUiHiderBase(activity, anchorView, flags);
    }

    protected SystemUiHider(Activity activity, View anchorView, int flags) {
        this.mActivity = activity;
        this.mAnchorView = anchorView;
        this.mFlags = flags;
    }

    public void toggle() {
        if (isVisible()) {
            hide();
        } else {
            show();
        }
    }

    public void setOnVisibilityChangeListener(OnVisibilityChangeListener listener) {
        if (listener == null) {
            listener = sDummyListener;
        }
        this.mOnVisibilityChangeListener = listener;
    }
}
