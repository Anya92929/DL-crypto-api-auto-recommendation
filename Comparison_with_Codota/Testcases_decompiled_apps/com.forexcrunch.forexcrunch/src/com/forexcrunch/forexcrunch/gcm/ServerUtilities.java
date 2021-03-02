package com.forexcrunch.forexcrunch.gcm;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.forexcrunch.forexcrunch.C0089R;
import com.google.android.gcm.GCMRegistrar;
import com.parse.ParseFacebookUtils;
import com.parse.entity.mime.MIME;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public final class ServerUtilities {
    private static final int BACKOFF_MILLI_SECONDS = 2000;
    private static final int MAX_ATTEMPTS = 5;
    private static final Random random = new Random();

    public static void register(Context context, String name, String email, String regId) {
        Log.i(CommonUtilities.TAG, "registering device (regId = " + regId + ")");
        Map<String, String> params = new HashMap<>();
        params.put("regId", regId);
        long backoff = (long) (random.nextInt(1000) + 2000);
        int i = 1;
        while (i <= 5) {
            Log.d(CommonUtilities.TAG, "Attempt #" + i + " to register");
            try {
                CommonUtilities.displayMessage(context, context.getString(C0089R.string.server_registering, new Object[]{Integer.valueOf(i), 5}));
                post("http://forexcrunch.wpengine.com/pushNotification/android/register.php", params);
                GCMRegistrar.setRegisteredOnServer(context, true);
                CommonUtilities.displayMessage(context, context.getString(C0089R.string.server_registered));
                return;
            } catch (IOException e) {
                Log.e(CommonUtilities.TAG, "Failed to register on attempt " + i + ":" + e);
                if (i == 5) {
                    break;
                }
                try {
                    Log.d(CommonUtilities.TAG, "Sleeping for " + backoff + " ms before retry");
                    Thread.sleep(backoff);
                    backoff *= 2;
                    i++;
                } catch (InterruptedException e2) {
                    Log.d(CommonUtilities.TAG, "Thread interrupted: abort remaining retries!");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        CommonUtilities.displayMessage(context, context.getString(C0089R.string.server_register_error, new Object[]{5}));
    }

    static void unregister(final Context context, final String regId) {
        Log.i(CommonUtilities.TAG, "unregistering device (regId = " + regId + ")");
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                try {
                    Map<String, String> parameters = new HashMap<>();
                    parameters.put("regId", regId);
                    ServerUtilities.post("http://forexcrunch.wpengine.com/pushNotification/android/unregister.php", parameters);
                    return null;
                } catch (IOException e) {
                    CommonUtilities.displayMessage(context, context.getString(C0089R.string.server_unregister_error, new Object[]{e.getMessage()}));
                    return null;
                }
            }
        }.execute(new Void[0]);
        CommonUtilities.displayMessage(context, context.getString(C0089R.string.server_unregistered));
    }

    /* access modifiers changed from: private */
    public static void post(String endpoint, Map<String, String> params) throws IOException {
        try {
            URL url = new URL(endpoint);
            StringBuilder bodyBuilder = new StringBuilder();
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> param = iterator.next();
                bodyBuilder.append(param.getKey()).append('=').append(param.getValue());
                if (iterator.hasNext()) {
                    bodyBuilder.append('&');
                }
            }
            String body = bodyBuilder.toString();
            Log.v(CommonUtilities.TAG, "Posting '" + body + "' to " + url);
            byte[] bytes = body.getBytes();
            HttpURLConnection conn = null;
            try {
                Log.e("URL", "> " + url);
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setUseCaches(false);
                conn.setFixedLengthStreamingMode(bytes.length);
                conn.setRequestMethod("POST");
                conn.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
                OutputStream out = conn.getOutputStream();
                out.write(bytes);
                out.close();
                int status = conn.getResponseCode();
                if (status != 200) {
                    throw new IOException("Post failed with error code " + status);
                }
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("invalid url: " + endpoint);
        }
    }

    public static void gcmRegister(Context ctx) {
        GCMRegistrar.checkDevice(ctx);
        GCMRegistrar.checkManifest(ctx);
        final String regId = GCMRegistrar.getRegistrationId(ctx);
        if (regId.equals("")) {
            GCMRegistrar.register(ctx, CommonUtilities.SENDER_ID);
        } else if (GCMRegistrar.isRegisteredOnServer(ctx)) {
            Log.i(CommonUtilities.TAG, "Already registered with GCM");
        } else {
            final Context context = ctx;
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... params) {
                    ServerUtilities.register(context, "name", ParseFacebookUtils.Permissions.User.EMAIL, regId);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void gcmUnregister(Context ctx) {
        GCMRegistrar.checkDevice(ctx);
        GCMRegistrar.checkManifest(ctx);
        String regId = GCMRegistrar.getRegistrationId(ctx);
        if (!regId.equals("")) {
            if (GCMRegistrar.isRegisteredOnServer(ctx)) {
                GCMRegistrar.unregister(ctx);
            }
            unregister(ctx, regId);
        }
    }
}
