package com.myip.vpnroot.util;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.myip.vpnroot.MainActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

public abstract class GoogleGetName extends AsyncTask<Void, Void, Void> {
    public static String GOOGLE_USER_DATA = "No_data";
    private static final String TAG = "MyIP.io";
    protected MainActivity mActivity;
    protected String mEmail;
    protected int mRequestCode;
    protected String mScope;

    /* access modifiers changed from: protected */
    public abstract String fetchToken() throws IOException;

    GoogleGetName(MainActivity activity, String email, String scope) {
        this.mActivity = activity;
        this.mScope = scope;
        this.mEmail = email;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... params) {
        try {
            fetchNameFromProfileServer();
            return null;
        } catch (IOException ex) {
            onError("Following Error occured, please try again. " + ex.getMessage(), ex);
            return null;
        } catch (JSONException e) {
            onError("Bad response: " + e.getMessage(), e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onError(String msg, Exception e) {
        if (e != null) {
            Log.e(TAG, "Exception: ", e);
        }
    }

    private void fetchNameFromProfileServer() throws IOException, JSONException {
        String token = fetchToken();
        HttpURLConnection con = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + token).openConnection();
        int sc = con.getResponseCode();
        if (sc == 200) {
            InputStream is = con.getInputStream();
            GOOGLE_USER_DATA = readResponse(is);
            is.close();
        } else if (sc == 401) {
            GoogleAuthUtil.invalidateToken(this.mActivity, token);
            onError("Server auth error, please try again.", (Exception) null);
            Toast.makeText(this.mActivity, "Please try again", 0).show();
            this.mActivity.finish();
        } else {
            onError("Server returned the following error code: " + sc, (Exception) null);
        }
    }

    private static String readResponse(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[2048];
        while (true) {
            int len = is.read(data, 0, data.length);
            if (len < 0) {
                return new String(bos.toByteArray(), "UTF-8");
            }
            bos.write(data, 0, len);
        }
    }
}
