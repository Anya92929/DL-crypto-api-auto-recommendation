package com.tapcrowd.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.facebook.DialogError;
import com.tapcrowd.app.utils.facebook.Facebook;
import com.tapcrowd.app.utils.facebook.FacebookError;

public abstract class FBFragment extends TCFragment {
    protected Facebook facebook;
    /* access modifiers changed from: private */
    public SharedPreferences prefs;

    public abstract void onAuthorize();

    /* access modifiers changed from: protected */
    public void authorize() {
        String fbappid = C1199DB.getFirstObject("social").get("facebookappid", "0");
        if (fbappid.equals("0")) {
            fbappid = App.act.getString(C0846R.string.fb_appid);
        }
        if (this.facebook == null) {
            this.facebook = new Facebook(fbappid);
        }
        this.prefs = getActivity().getPreferences(0);
        String access_token = this.prefs.getString("access_token", (String) null);
        long expires = this.prefs.getLong("access_expires", 0);
        if (access_token != null) {
            this.facebook.setAccessToken(access_token);
        }
        if (expires != 0) {
            this.facebook.setAccessExpires(expires);
        }
        if (!this.facebook.isSessionValid()) {
            this.facebook.authorize(App.act, new String[]{"publish_stream", "publish_actions"}, new Facebook.DialogListener() {
                public void onComplete(Bundle values) {
                    SharedPreferences.Editor editor = FBFragment.this.prefs.edit();
                    editor.putString("access_token", FBFragment.this.facebook.getAccessToken());
                    editor.putLong("access_expires", FBFragment.this.facebook.getAccessExpires());
                    editor.commit();
                    FBFragment.this.onAuthorize();
                }

                public void onFacebookError(FacebookError error) {
                }

                public void onError(DialogError e) {
                }

                public void onCancel() {
                }
            });
            return;
        }
        onAuthorize();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.facebook.authorizeCallback(requestCode, resultCode, data);
    }
}
