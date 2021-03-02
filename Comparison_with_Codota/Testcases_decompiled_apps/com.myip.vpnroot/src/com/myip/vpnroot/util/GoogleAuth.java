package com.myip.vpnroot.util;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.myip.vpnroot.MainActivity;
import java.io.IOException;

public class GoogleAuth extends GoogleGetName {
    public static final Boolean debug = false;

    public GoogleAuth(MainActivity activity, String email, String scope) {
        super(activity, email, scope);
    }

    /* access modifiers changed from: protected */
    public String fetchToken() throws IOException {
        try {
            return GoogleAuthUtil.getToken(this.mActivity, this.mEmail, this.mScope);
        } catch (GooglePlayServicesAvailabilityException e) {
            if (debug.booleanValue()) {
                System.out.println("no google auth enable");
            }
        } catch (UserRecoverableAuthException userRecoverableException) {
            if (debug.booleanValue()) {
                System.out.println("Problem with googleauth");
            }
            this.mActivity.startActivityForResult(userRecoverableException.getIntent(), this.mRequestCode);
            if (debug.booleanValue()) {
                System.out.println("starting google auth in background 2");
            }
        } catch (GoogleAuthException fatalException) {
            onError("Unrecoverable error " + fatalException.getMessage(), fatalException);
        }
        return null;
    }
}
