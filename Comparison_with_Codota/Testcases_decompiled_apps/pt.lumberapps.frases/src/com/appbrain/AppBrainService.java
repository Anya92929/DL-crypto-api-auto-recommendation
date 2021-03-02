package com.appbrain;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.appbrain.p032a.C0842cd;
import com.appbrain.p032a.C0860cv;
import com.appbrain.p032a.C0900eh;

public class AppBrainService extends IntentService {
    public AppBrainService() {
        super("AppBrain service");
    }

    public void onCreate() {
        super.onCreate();
        C1121k.m5210b(this);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            Context applicationContext = getApplicationContext();
            if (!C0900eh.m3871a(applicationContext, intent)) {
                if (intent.hasExtra("event")) {
                    C0860cv.m3776a(intent.getStringExtra("key"), intent.getStringExtra("event"));
                }
                if ("com.appbrain.CHECK".equals(intent.getAction())) {
                    C0860cv.m3775a(applicationContext, "com.appbrain.CHECK", C0842cd.m3715a(applicationContext));
                }
                if (C0860cv.m3777b(applicationContext)) {
                    C0860cv.m3775a(applicationContext, (String) null, -1);
                } else {
                    C0860cv.m3775a(applicationContext, (String) null, 450000);
                }
            }
        }
    }
}
