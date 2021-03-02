package com.myip.vpnroot.util;

import android.app.Activity;
import android.view.View;

public class SystemUiHiderBase extends SystemUiHider {
    private boolean mVisible = true;

    protected SystemUiHiderBase(Activity activity, View anchorView, int flags) {
        super(activity, anchorView, flags);
    }

    public void setup() {
        if ((this.mFlags & 1) == 0) {
            this.mActivity.getWindow().setFlags(768, 768);
        }
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public void hide() {
        if ((this.mFlags & 2) != 0) {
            this.mActivity.getWindow().setFlags(1024, 1024);
        }
        this.mOnVisibilityChangeListener.onVisibilityChange(false);
        this.mVisible = false;
    }

    public void show() {
        if ((this.mFlags & 2) != 0) {
            this.mActivity.getWindow().setFlags(0, 1024);
        }
        this.mOnVisibilityChangeListener.onVisibilityChange(true);
        this.mVisible = true;
    }
}
