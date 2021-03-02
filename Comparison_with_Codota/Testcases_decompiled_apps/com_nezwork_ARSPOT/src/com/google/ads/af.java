package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Locale;

public final class af {
    private static final com.google.ads.internal.a a = com.google.ads.internal.a.a.b();

    private static class a implements Runnable {
        private final WeakReference<Activity> a;
        private final SharedPreferences.Editor b;

        public a(Activity activity) {
            this(activity, (SharedPreferences.Editor) null);
        }

        a(Activity activity, SharedPreferences.Editor editor) {
            this.a = new WeakReference<>(activity);
            this.b = editor;
        }

        private SharedPreferences.Editor a(Activity activity) {
            if (this.b == null) {
                return PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext()).edit();
            }
            return this.b;
        }

        public void run() {
            String str;
            try {
                Activity activity = (Activity) this.a.get();
                if (activity == null) {
                    com.google.ads.util.b.a("Activity was null while making a doritos cookie request.");
                    return;
                }
                Cursor query = activity.getContentResolver().query(ae.b, ae.d, (String) null, (String[]) null, (String) null);
                if (query == null || !query.moveToFirst() || query.getColumnNames().length <= 0) {
                    com.google.ads.util.b.a("Google+ app not installed, not storing doritos cookie");
                    str = null;
                } else {
                    str = query.getString(query.getColumnIndex(query.getColumnName(0)));
                }
                SharedPreferences.Editor a2 = a(activity);
                if (!TextUtils.isEmpty(str)) {
                    a2.putString("drt", str);
                    a2.putLong("drt_ts", new Date().getTime());
                } else {
                    a2.putString("drt", "");
                    a2.putLong("drt_ts", 0);
                }
                a2.commit();
            } catch (Throwable th) {
                com.google.ads.util.b.b("An unknown error occurred while sending a doritos request.", th);
            }
        }
    }

    private static class b implements Runnable {
        private final WeakReference<Activity> a;
        private final WebView b;
        private final String c;

        public b(Activity activity, WebView webView, String str) {
            this.a = new WeakReference<>(activity);
            this.c = str;
            this.b = webView;
        }

        public void run() {
            boolean z;
            try {
                Uri withAppendedPath = Uri.withAppendedPath(ae.a, this.c);
                Activity activity = (Activity) this.a.get();
                if (activity == null) {
                    com.google.ads.util.b.a("Activity was null while getting the +1 button state.");
                    return;
                }
                Cursor query = activity.getContentResolver().query(withAppendedPath, ae.c, (String) null, (String[]) null, (String) null);
                if (query == null || !query.moveToFirst()) {
                    com.google.ads.util.b.a("Google+ app not installed, showing ad as not +1'd");
                    z = false;
                } else {
                    z = query.getInt(query.getColumnIndex("has_plus1")) == 1;
                }
                this.b.post(new c(this.b, z));
            } catch (Throwable th) {
                com.google.ads.util.b.b("An unknown error occurred while updating the +1 state.", th);
            }
        }
    }

    static class c implements Runnable {
        private final boolean a;
        private final WebView b;

        public c(WebView webView, boolean z) {
            this.b = webView;
            this.a = z;
        }

        public void run() {
            af.a(this.b, this.a);
        }
    }

    public static void a(WebView webView, boolean z) {
        a.a(webView, String.format(Locale.US, "(G_updatePlusOne(%b))", new Object[]{Boolean.valueOf(z)}));
    }

    public static void a(WebView webView, String str) {
        a.a(webView, String.format(Locale.US, "(G_resizeIframe(%s))", new Object[]{str}));
    }

    public static void a(Activity activity, WebView webView, String str) {
        new Thread(new b(activity, webView, str)).start();
    }

    public static boolean a(Context context, long j) {
        return a(context, j, PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
    }

    static boolean a(Context context, long j, SharedPreferences sharedPreferences) {
        return ag.a(context) && (!sharedPreferences.contains("drt") || !sharedPreferences.contains("drt_ts") || sharedPreferences.getLong("drt_ts", 0) < new Date().getTime() - j);
    }

    public static void a(Activity activity) {
        new Thread(new a(activity)).start();
    }
}
