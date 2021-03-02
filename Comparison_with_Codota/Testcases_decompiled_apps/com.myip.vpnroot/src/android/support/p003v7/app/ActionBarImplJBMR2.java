package android.support.p003v7.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.p003v7.app.ActionBar;

/* renamed from: android.support.v7.app.ActionBarImplJBMR2 */
public class ActionBarImplJBMR2 extends ActionBarImplJB {
    public ActionBarImplJBMR2(Activity activity, ActionBar.Callback callback) {
        super(activity, callback);
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        this.mActionBar.setHomeAsUpIndicator(indicator);
    }

    public void setHomeAsUpIndicator(int resId) {
        this.mActionBar.setHomeAsUpIndicator(resId);
    }

    public void setHomeActionContentDescription(CharSequence description) {
        this.mActionBar.setHomeActionContentDescription(description);
    }

    public void setHomeActionContentDescription(int resId) {
        this.mActionBar.setHomeActionContentDescription(resId);
    }
}
