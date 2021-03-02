package com.tapcrowd.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.Locale;

public class TCApplication extends Application {
    public void onCreate() {
        super.onCreate();
        TCAnalytics.initalizeTCAnalytics(getBaseContext());
    }

    public static void updatelanguage(Context context) {
        SharedPreferences pref = context.getSharedPreferences("TapCrowd", 0);
        Configuration config = context.getResources().getConfiguration();
        String lang = pref.getString("language", "");
        if (!lang.equals("") && !lang.equals(Locale.getDefault().getLanguage().split("_")[0])) {
            Locale locale = new Locale(lang);
            config.locale = locale;
            Locale.setDefault(locale);
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        }
    }

    public static void updatelanguage(Context context, String lang) {
        Configuration config = context.getResources().getConfiguration();
        Locale locale = new Locale(lang);
        config.locale = locale;
        Locale.setDefault(locale);
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}
