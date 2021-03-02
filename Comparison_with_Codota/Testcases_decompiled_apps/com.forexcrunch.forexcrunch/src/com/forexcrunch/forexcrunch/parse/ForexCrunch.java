package com.forexcrunch.forexcrunch.parse;

import android.app.Application;
import android.preference.PreferenceManager;
import com.forexcrunch.forexcrunch.gui.SplashScreen;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class ForexCrunch extends Application {
    public void onCreate() {
        super.onCreate();
        boolean register = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("notif", true);
        Parse.initialize(this, "I2cIF5J4GligCnIVZdqoFxQALVgd4hRnoOl6Vawa", "kPk8StEEztce32L26Lc0gW8vTrIomnM46o6Qzqoc");
        PushService.setDefaultPushCallback(this, SplashScreen.class);
        if (register) {
            PushService.subscribe(this, "forex", SplashScreen.class);
            PushService.subscribe(this, "pruebas", SplashScreen.class);
        }
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
