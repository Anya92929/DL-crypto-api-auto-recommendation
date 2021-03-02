package android.support.p000v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

/* renamed from: android.support.v4.app.ShareCompatICS */
class ShareCompatICS {
    ShareCompatICS() {
    }

    public static void configureMenuItem(MenuItem menuItem, Activity activity, Intent intent) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(activity) : (ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(".sharecompat_" + activity.getClass().getName());
        shareActionProvider.setShareIntent(intent);
        menuItem.setActionProvider(shareActionProvider);
    }
}
