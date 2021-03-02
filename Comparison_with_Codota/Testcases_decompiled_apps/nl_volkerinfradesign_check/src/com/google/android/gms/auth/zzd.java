package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zza;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzas;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = (Build.VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName");
    public static final String KEY_CALLER_UID = (Build.VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid");
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    /* renamed from: a */
    private static final ComponentName f2555a = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");

    /* renamed from: b */
    private static final ComponentName f2556b = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    /* renamed from: com.google.android.gms.auth.zzd$a */
    interface C0675a<T> {
        /* renamed from: b */
        T mo4935b(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException;
    }

    zzd() {
    }

    /* renamed from: a */
    private static <T> T m3652a(Context context, ComponentName componentName, C0675a<T> aVar) throws IOException, GoogleAuthException {
        zza zza = new zza();
        zzl zzau = zzl.zzau(context);
        if (zzau.zza(componentName, (ServiceConnection) zza, "GoogleAuthUtil")) {
            try {
                T b = aVar.mo4935b(zza.zzoJ());
                zzau.zzb(componentName, (ServiceConnection) zza, "GoogleAuthUtil");
                return b;
            } catch (RemoteException | InterruptedException e) {
                Log.i("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            } catch (Throwable th) {
                zzau.zzb(componentName, (ServiceConnection) zza, "GoogleAuthUtil");
                throw th;
            }
        } else {
            throw new IOException("Could not bind to service.");
        }
    }

    /* renamed from: a */
    private static void m3654a(Context context) throws GoogleAuthException {
        try {
            zze.zzad(context.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    /* renamed from: a */
    static void m3655a(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m3656b(T t) throws IOException {
        if (t != null) {
            return t;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    public static void clearToken(Context context, final String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        m3654a(context);
        final Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        m3652a(context, f2555a, new C0675a<Void>() {
            /* renamed from: a */
            public Void mo4935b(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                Bundle bundle = (Bundle) zzd.m3656b(zzas.zza.zza(iBinder).zza(str, bundle));
                String string = bundle.getString("Error");
                if (bundle.getBoolean("booleanResult")) {
                    return null;
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, final int i, final String str) throws GoogleAuthException, IOException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        m3654a(context);
        return (List) m3652a(context, f2555a, new C0675a<List<AccountChangeEvent>>() {
            /* renamed from: a */
            public List<AccountChangeEvent> mo4935b(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return ((AccountChangeEventsResponse) zzd.m3656b(zzas.zza.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(str).setEventIndex(i)))).getEvents();
            }
        });
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        m3654a(context);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzc(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    public static TokenData zzc(Context context, final Account account, final String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        m3654a(context);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) m3652a(context, f2555a, new C0675a<TokenData>() {
            /* renamed from: a */
            public TokenData mo4935b(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                Bundle bundle = (Bundle) zzd.m3656b(zzas.zza.zza(iBinder).zza(account, str, bundle2));
                TokenData zzc = TokenData.zzc(bundle, "tokenDetails");
                if (zzc != null) {
                    return zzc;
                }
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                com.google.android.gms.auth.firstparty.shared.zzd zzbY = com.google.android.gms.auth.firstparty.shared.zzd.zzbY(string);
                if (com.google.android.gms.auth.firstparty.shared.zzd.zza(zzbY)) {
                    throw new UserRecoverableAuthException(string, intent);
                } else if (com.google.android.gms.auth.firstparty.shared.zzd.zzc(zzbY)) {
                    throw new IOException(string);
                } else {
                    throw new GoogleAuthException(string);
                }
            }
        });
    }
}
