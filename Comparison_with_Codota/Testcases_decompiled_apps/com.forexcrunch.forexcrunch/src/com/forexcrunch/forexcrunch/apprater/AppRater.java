package com.forexcrunch.forexcrunch.apprater;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import com.forexcrunch.forexcrunch.C0089R;

public class AppRater {
    private static final String APP_PNAME = "com.forexcrunch.forexcrunch";
    private static final int DAYS_UNTIL_PROMPT = 5;
    private static final int LAUNCHES_UNTIL_PROMPT = 5;
    /* access modifiers changed from: private */
    public static Long date_firstLaunch;

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (!prefs.getBoolean("dontshowagain", false)) {
            SharedPreferences.Editor editor = prefs.edit();
            long launch_count = prefs.getLong("launch_count", 0) + 1;
            editor.putLong("launch_count", launch_count);
            date_firstLaunch = Long.valueOf(prefs.getLong("date_firstlaunch", 0));
            if (date_firstLaunch.longValue() == 0) {
                date_firstLaunch = Long.valueOf(System.currentTimeMillis());
                editor.putLong("date_firstlaunch", date_firstLaunch.longValue());
            }
            if (launch_count >= 5 && System.currentTimeMillis() >= date_firstLaunch.longValue() + 432000000) {
                showRateDialog(mContext, editor);
            }
            editor.commit();
        }
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.app_rater_dialog_backgorund);
        dialog.setContentView(C0089R.layout.app_rater_dialog);
        ((Button) dialog.findViewById(C0089R.C0090id.app_rater_dialog_bRate)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.forexcrunch.forexcrunch")));
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(C0089R.C0090id.app_rater_dialog_bRemind)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AppRater.date_firstLaunch = Long.valueOf(System.currentTimeMillis());
                if (editor != null) {
                    editor.putLong("date_firstlaunch", AppRater.date_firstLaunch.longValue());
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(C0089R.C0090id.app_rater_dialog_bNo)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
