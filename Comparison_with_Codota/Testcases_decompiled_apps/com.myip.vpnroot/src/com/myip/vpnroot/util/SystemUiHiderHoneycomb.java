package com.myip.vpnroot.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;

@TargetApi(11)
public class SystemUiHiderHoneycomb extends SystemUiHiderBase {
    private int mHideFlags = 1;
    /* access modifiers changed from: private */
    public int mShowFlags = 0;
    private View.OnSystemUiVisibilityChangeListener mSystemUiVisibilityChangeListener = new View.OnSystemUiVisibilityChangeListener() {
        public void onSystemUiVisibilityChange(int vis) {
            if ((SystemUiHiderHoneycomb.this.mTestFlags & vis) != 0) {
                if (Build.VERSION.SDK_INT < 16) {
                    SystemUiHiderHoneycomb.this.mActivity.getActionBar().hide();
                    SystemUiHiderHoneycomb.this.mActivity.getWindow().setFlags(1024, 1024);
                }
                SystemUiHiderHoneycomb.this.mOnVisibilityChangeListener.onVisibilityChange(false);
                boolean unused = SystemUiHiderHoneycomb.this.mVisible = false;
                return;
            }
            SystemUiHiderHoneycomb.this.mAnchorView.setSystemUiVisibility(SystemUiHiderHoneycomb.this.mShowFlags);
            if (Build.VERSION.SDK_INT < 16) {
                SystemUiHiderHoneycomb.this.mActivity.getActionBar().show();
                SystemUiHiderHoneycomb.this.mActivity.getWindow().setFlags(0, 1024);
            }
            SystemUiHiderHoneycomb.this.mOnVisibilityChangeListener.onVisibilityChange(true);
            boolean unused2 = SystemUiHiderHoneycomb.this.mVisible = true;
        }
    };
    /* access modifiers changed from: private */
    public int mTestFlags = 1;
    /* access modifiers changed from: private */
    public boolean mVisible = true;

    protected SystemUiHiderHoneycomb(Activity activity, View anchorView, int flags) {
        super(activity, anchorView, flags);
        if ((this.mFlags & 2) != 0) {
            this.mShowFlags |= 1024;
            this.mHideFlags |= 1028;
        }
        if ((this.mFlags & 6) != 0) {
            this.mShowFlags |= 512;
            this.mHideFlags |= 514;
            this.mTestFlags |= 2;
        }
    }

    public void setup() {
        this.mAnchorView.setOnSystemUiVisibilityChangeListener(this.mSystemUiVisibilityChangeListener);
    }

    public void hide() {
        this.mAnchorView.setSystemUiVisibility(this.mHideFlags);
    }

    public void show() {
        this.mAnchorView.setSystemUiVisibility(this.mShowFlags);
    }

    public boolean isVisible() {
        return this.mVisible;
    }
}
