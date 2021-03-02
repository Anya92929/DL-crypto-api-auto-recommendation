package com.tapcrowd.app.modules;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCActivity;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;

public class NotificationToSessionDetail extends TCActivity {
    public void onCreate(Bundle savedInstanceState) {
        setContentView((int) C0846R.layout.splash);
        super.onCreate(savedInstanceState);
        Fragments.clear();
        C1199DB.openDataBase();
        C1216LO.downloadImages();
        Intent i = null;
        TCObject app = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
        if (app.has("apptypeid")) {
            i = new Intent(this, TCLauncher.class);
            App.typeid = app.get("apptypeid");
            if (App.typeid.equals("3")) {
                App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID);
                i.putExtra("eventid", App.curEventId);
            } else if (App.typeid.equals("5")) {
                i.putExtra("appid", App.f2123id);
            } else if (App.typeid.equals("10")) {
                App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID);
                i.putExtra("eventid", App.curEventId);
            }
        }
        i.putExtra("sessionid", getIntent().getStringExtra(DBFavorites.KEY_EVENT_ID));
        startActivity(i);
        finish();
    }
}
