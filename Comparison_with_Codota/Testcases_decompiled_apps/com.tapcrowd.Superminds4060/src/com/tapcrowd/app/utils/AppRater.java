package com.tapcrowd.app.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tapcrowd.Superminds4060.C0846R;

public class AppRater {
    private static final int LAUNCHES_UNTIL_PROMPT = 3;

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (!prefs.getBoolean("dontshowagain", false)) {
            SharedPreferences.Editor editor = prefs.edit();
            long launch_count = prefs.getLong("launch_count", 0) + 1;
            editor.putLong("launch_count", launch_count);
            if (launch_count >= 3) {
                showRateDialog(mContext, editor);
            }
            editor.commit();
        }
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle("Rate " + mContext.getString(C0846R.string.app_name));
        dialog.setMessage("If you enjoy using " + mContext.getString(C0846R.string.app_name) + ", please take a moment to rate it. Thanks for your support!");
        dialog.setPositiveButton("Rate " + mContext.getString(C0846R.string.app_name), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + mContext.getPackageName())));
                editor.putBoolean("dontshowagain", true);
                editor.commit();
            }
        });
        dialog.setNeutralButton("Remind me later", (DialogInterface.OnClickListener) null);
        dialog.setNegativeButton("No, thanks", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
            }
        });
        dialog.show();
    }
}
