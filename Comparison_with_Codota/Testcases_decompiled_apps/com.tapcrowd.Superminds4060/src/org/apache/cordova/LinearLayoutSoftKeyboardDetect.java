package org.apache.cordova;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import org.apache.cordova.api.LOG;

public class LinearLayoutSoftKeyboardDetect extends LinearLayout {
    private static final String TAG = "SoftKeyboardDetect";
    private DroidGap app = null;
    private int oldHeight = 0;
    private int oldWidth = 0;
    private int screenHeight = 0;
    private int screenWidth = 0;

    public LinearLayoutSoftKeyboardDetect(Context context, int width, int height) {
        super(context);
        this.screenWidth = width;
        this.screenHeight = height;
        this.app = (DroidGap) context;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LOG.m2224v(TAG, "We are in our onMeasure method");
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        LOG.m2226v(TAG, "Old Height = %d", Integer.valueOf(this.oldHeight));
        LOG.m2226v(TAG, "Height = %d", Integer.valueOf(height));
        LOG.m2226v(TAG, "Old Width = %d", Integer.valueOf(this.oldWidth));
        LOG.m2226v(TAG, "Width = %d", Integer.valueOf(width));
        if (this.oldHeight == 0 || this.oldHeight == height) {
            LOG.m2215d(TAG, "Ignore this event");
        } else if (this.screenHeight == width) {
            int tmp_var = this.screenHeight;
            this.screenHeight = this.screenWidth;
            this.screenWidth = tmp_var;
            LOG.m2224v(TAG, "Orientation Change");
        } else if (height > this.oldHeight) {
            if (this.app != null) {
                this.app.appView.sendJavascript("cordova.fireDocumentEvent('hidekeyboard');");
            }
        } else if (height < this.oldHeight && this.app != null) {
            this.app.appView.sendJavascript("cordova.fireDocumentEvent('showkeyboard');");
        }
        this.oldHeight = height;
        this.oldWidth = width;
    }
}
