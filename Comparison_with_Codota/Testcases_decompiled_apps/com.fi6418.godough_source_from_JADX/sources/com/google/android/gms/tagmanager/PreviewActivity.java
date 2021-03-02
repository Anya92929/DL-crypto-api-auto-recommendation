package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    /* renamed from: a */
    private void m5249a(String str, String str2, String str3) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C1318i(this));
        create.show();
    }

    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            C1333x.m5443c("Preview activity");
            Uri data = getIntent().getData();
            if (!C1319j.m5419a((Context) this).mo9172a(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                C1333x.m5442b(str);
                m5249a("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                C1333x.m5443c("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            C1333x.m5443c("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            C1333x.m5440a("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
