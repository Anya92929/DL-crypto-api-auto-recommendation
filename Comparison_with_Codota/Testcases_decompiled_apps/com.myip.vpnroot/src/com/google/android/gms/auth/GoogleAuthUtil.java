package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.C0265a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1313if;
import com.google.android.gms.internal.C1728r;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;

    /* renamed from: Dn */
    private static final ComponentName f367Dn = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.auth.GetToken");

    /* renamed from: Do */
    private static final ComponentName f368Do = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.recovery.RecoveryService");

    /* renamed from: Dp */
    private static final Intent f369Dp = new Intent().setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE).setComponent(f367Dn);

    /* renamed from: Dq */
    private static final Intent f370Dq = new Intent().setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE).setComponent(f368Do);
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = (Build.VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName");
    public static final String KEY_CALLER_UID = (Build.VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid");
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    /* renamed from: com.google.android.gms.auth.GoogleAuthUtil$a */
    private static class C0226a extends Handler {

        /* renamed from: mD */
        private final Context f371mD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0226a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f371mD = context;
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f371mD);
                if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                    GooglePlayServicesUtil.showErrorNotification(isGooglePlayServicesAvailable, this.f371mD);
                    return;
                }
                return;
            }
            Log.wtf("GoogleAuthUtil", "Don't know how to handle this message: " + msg.what);
        }
    }

    private GoogleAuthUtil() {
    }

    /* renamed from: D */
    private static void m346D(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.m460D(context);
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    /* renamed from: a */
    private static String m347a(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            return getToken(context, str, str2, bundle);
        } catch (GooglePlayServicesAvailabilityException e) {
            int connectionStatusCode = e.getConnectionStatusCode();
            if (m350b(context, connectionStatusCode)) {
                C0226a aVar = new C0226a(context.getApplicationContext());
                aVar.sendMessageDelayed(aVar.obtainMessage(1), 30000);
            } else {
                GooglePlayServicesUtil.showErrorNotification(connectionStatusCode, context);
            }
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e2) {
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    /* renamed from: aw */
    private static boolean m348aw(String str) {
        return "NetworkError".equals(str) || "ServiceUnavailable".equals(str) || "Timeout".equals(str);
    }

    /* renamed from: ax */
    private static boolean m349ax(String str) {
        return "BadAuthentication".equals(str) || "CaptchaRequired".equals(str) || "DeviceManagementRequiredOrSyncDisabled".equals(str) || "NeedPermission".equals(str) || "NeedsBrowser".equals(str) || "UserCancel".equals(str) || "AppDownloadRequired".equals(str) || C1313if.DM_SYNC_DISABLED.mo8823fu().equals(str) || C1313if.DM_ADMIN_BLOCKED.mo8823fu().equals(str) || C1313if.DM_ADMIN_PENDING_APPROVAL.mo8823fu().equals(str) || C1313if.DM_STALE_SYNC_REQUIRED.mo8823fu().equals(str) || C1313if.DM_DEACTIVATED.mo8823fu().equals(str) || C1313if.DM_REQUIRED.mo8823fu().equals(str);
    }

    /* renamed from: b */
    private static boolean m350b(Context context, int i) {
        if (i == 1) {
            try {
                if (context.getPackageManager().getApplicationInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 8192).enabled) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return false;
    }

    public static void clearToken(Context context, String token) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Context applicationContext = context.getApplicationContext();
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        m346D(applicationContext);
        Bundle bundle = new Bundle();
        String str = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        C0265a aVar = new C0265a();
        if (applicationContext.bindService(f369Dp, aVar, 1)) {
            try {
                Bundle a = C1728r.C1729a.m6153a(aVar.mo4180fX()).mo10128a(token, bundle);
                String string = a.getString(C1313if.f3967Ev);
                if (!a.getBoolean("booleanResult")) {
                    throw new GoogleAuthException(string);
                }
                applicationContext.unbindService(aVar);
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(aVar);
                throw th;
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context ctx, int eventIndex, String accountName) throws GoogleAuthException, IOException {
        C0348n.m858b(accountName, (Object) "accountName must be provided");
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        Context applicationContext = ctx.getApplicationContext();
        m346D(applicationContext);
        C0265a aVar = new C0265a();
        if (applicationContext.bindService(f369Dp, aVar, 1)) {
            try {
                List<AccountChangeEvent> events = C1728r.C1729a.m6153a(aVar.mo4180fX()).mo10130a(new AccountChangeEventsRequest().setAccountName(accountName).setEventIndex(eventIndex)).getEvents();
                applicationContext.unbindService(aVar);
                return events;
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(aVar);
                throw th;
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getAccountId(Context ctx, String accountName) throws GoogleAuthException, IOException {
        C0348n.m858b(accountName, (Object) "accountName must be provided");
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        m346D(ctx.getApplicationContext());
        return getToken(ctx, accountName, "^^_account_id_^^", new Bundle());
    }

    public static String getAppCert(Context context, String packageNameToCertify) {
        return "spatula";
    }

    public static String getToken(Context context, String accountName, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, accountName, scope, new Bundle());
    }

    public static String getToken(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Context applicationContext = context.getApplicationContext();
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        m346D(applicationContext);
        Bundle extras2 = extras == null ? new Bundle() : new Bundle(extras);
        String str = context.getApplicationInfo().packageName;
        extras2.putString("clientPackageName", str);
        if (!extras2.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            extras2.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        C0265a aVar = new C0265a();
        if (applicationContext.bindService(f369Dp, aVar, 1)) {
            try {
                Bundle a = C1728r.C1729a.m6153a(aVar.mo4180fX()).mo10129a(accountName, scope, extras2);
                String string = a.getString("authtoken");
                if (!TextUtils.isEmpty(string)) {
                    applicationContext.unbindService(aVar);
                    return string;
                }
                String string2 = a.getString("Error");
                Intent intent = (Intent) a.getParcelable("userRecoveryIntent");
                if (m349ax(string2)) {
                    throw new UserRecoverableAuthException(string2, intent);
                } else if (m348aw(string2)) {
                    throw new IOException(string2);
                } else {
                    throw new GoogleAuthException(string2);
                }
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(aVar);
                throw th;
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("handle_notification", true);
        return m347a(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, Intent callback) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        m351h(callback);
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("callback_intent", callback);
        extras.putBoolean("handle_notification", true);
        return m347a(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, String authority, Bundle syncBundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        if (extras == null) {
            extras = new Bundle();
        }
        if (syncBundle == null) {
            syncBundle = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(syncBundle);
        extras.putString("authority", authority);
        extras.putBundle("sync_extras", syncBundle);
        extras.putBoolean("handle_notification", true);
        return m347a(context, accountName, scope, extras);
    }

    /* renamed from: h */
    private static void m351h(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    @Deprecated
    public static void invalidateToken(Context context, String token) {
        AccountManager.get(context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, token);
    }
}
