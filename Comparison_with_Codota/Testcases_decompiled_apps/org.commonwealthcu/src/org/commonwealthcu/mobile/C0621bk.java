package org.commonwealthcu.mobile;

import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;

/* renamed from: org.commonwealthcu.mobile.bk */
final class C0621bk extends WebChromeClient {
    C0621bk(C0620bj bjVar) {
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }
}
