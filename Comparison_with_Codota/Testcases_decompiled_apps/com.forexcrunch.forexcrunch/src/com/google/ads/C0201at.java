package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.internal.C0232a;
import com.google.ads.util.C0284b;
import java.lang.ref.WeakReference;
import java.util.Date;

/* renamed from: com.google.ads.at */
public final class C0201at {

    /* renamed from: a */
    private static final C0232a f363a = C0232a.f474a.mo3484b();

    /* renamed from: com.google.ads.at$a */
    private static class C0203a implements Runnable {

        /* renamed from: a */
        private final WeakReference<Activity> f365a;

        /* renamed from: b */
        private final SharedPreferences.Editor f366b;

        public C0203a(Activity activity) {
            this(activity, (SharedPreferences.Editor) null);
        }

        C0203a(Activity activity, SharedPreferences.Editor editor) {
            this.f365a = new WeakReference<>(activity);
            this.f366b = editor;
        }

        /* renamed from: a */
        private SharedPreferences.Editor m115a(Context context) {
            if (this.f366b == null) {
                return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
            }
            return this.f366b;
        }

        public void run() {
            String str;
            try {
                Activity activity = (Activity) this.f365a.get();
                if (activity == null) {
                    C0284b.m480a("Activity was null while making a doritos cookie request.");
                    return;
                }
                Cursor query = activity.getContentResolver().query(C0200as.f361a, C0200as.f362b, (String) null, (String[]) null, (String) null);
                if (query == null || !query.moveToFirst() || query.getColumnNames().length <= 0) {
                    C0284b.m480a("Google+ app not installed, not storing doritos cookie");
                    str = null;
                } else {
                    str = query.getString(query.getColumnIndex(query.getColumnName(0)));
                }
                SharedPreferences.Editor a = m115a(activity);
                if (!TextUtils.isEmpty(str)) {
                    a.putString("drt", str);
                    a.putLong("drt_ts", new Date().getTime());
                } else {
                    a.putString("drt", "");
                    a.putLong("drt_ts", 0);
                }
                a.commit();
            } catch (Throwable th) {
                C0284b.m489d("An unknown error occurred while sending a doritos request.", th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m113a(final Context context, long j) {
        if (!m114a(context, j, PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()))) {
            return false;
        }
        new Thread(new Runnable() {
            public void run() {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
                edit.putString("drt", "");
                edit.putLong("drt_ts", 0);
                edit.commit();
            }
        }).start();
        return true;
    }

    /* renamed from: a */
    static boolean m114a(Context context, long j, SharedPreferences sharedPreferences) {
        if (!sharedPreferences.contains("drt") || !sharedPreferences.contains("drt_ts") || sharedPreferences.getLong("drt_ts", 0) < new Date().getTime() - j) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m112a(Activity activity) {
        new Thread(new C0203a(activity)).start();
    }
}
