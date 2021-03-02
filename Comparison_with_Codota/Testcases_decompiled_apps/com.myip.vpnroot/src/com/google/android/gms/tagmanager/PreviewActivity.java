package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    /* renamed from: d */
    private void m6711d(String str, String str2, String str3) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            C2028bh.m6817U("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).mo11519i(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                C2028bh.m6819W(str);
                m6711d("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                C2028bh.m6817U("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            C2028bh.m6817U("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            C2028bh.m6816T("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
