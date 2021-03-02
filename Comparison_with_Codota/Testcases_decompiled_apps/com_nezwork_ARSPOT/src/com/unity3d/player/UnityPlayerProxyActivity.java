package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import java.util.Map;

public class UnityPlayerProxyActivity extends Activity {
    protected static void copyPlayerPrefs(Context context, String[] strArr) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
        if (sharedPreferences.getAll().isEmpty()) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (String sharedPreferences2 : strArr) {
                Map<String, ?> all = context.getSharedPreferences(sharedPreferences2, 0).getAll();
                if (!all.isEmpty()) {
                    for (Map.Entry next : all.entrySet()) {
                        Object value = next.getValue();
                        if (value.getClass() == Integer.class) {
                            edit.putInt((String) next.getKey(), ((Integer) value).intValue());
                        } else if (value.getClass() == Float.class) {
                            edit.putFloat((String) next.getKey(), ((Float) value).floatValue());
                        } else if (value.getClass() == String.class) {
                            edit.putString((String) next.getKey(), (String) value);
                        }
                    }
                    edit.commit();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        char c = 1;
        super.onCreate(bundle);
        String[] strArr = {"com.unity3d.player.UnityPlayerActivity", "com.unity3d.player.UnityPlayerNativeActivity"};
        copyPlayerPrefs(this, strArr);
        try {
            if (!(Build.VERSION.SDK_INT >= 9)) {
                c = 0;
            }
            Intent intent = new Intent(this, Class.forName(strArr[c]));
            intent.addFlags(65536);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }
}
