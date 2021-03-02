package com.tapcrowd.tcanalytics.actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import com.tapcrowd.tcanalytics.actions.fragment.ActionWebviewFragment;
import org.json.JSONObject;

public class ActionActivity extends FragmentActivity {
    private final int CONTENT_ID = 3254;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout content = new FrameLayout(this);
        content.setId(3254);
        setContentView(content);
        handlePayload(getIntent());
    }

    private void handlePayload(Intent intent) {
        try {
            JSONObject json = new JSONObject(intent.getStringExtra("payload"));
            if (json.getString("action").equals("webview")) {
                actionWebview(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionWebview(JSONObject json) {
        try {
            startFragment(ActionWebviewFragment.newInstance(json.getString("path")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(3254, fragment);
        transaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        intent.addFlags(67108864);
        startActivity(intent);
    }
}
