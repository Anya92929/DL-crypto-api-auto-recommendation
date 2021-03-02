package p052pt.lumberapps.frases.outros;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.outros.a */
public class C2064a {

    /* renamed from: a */
    private static String f7767a = "1000 Frases";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Activity f7768b;

    /* renamed from: a */
    public static boolean m8358a(Activity activity) {
        f7767a = activity.getString(C1204R.string.app_name);
        f7768b = activity;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("apprater", 0);
        if (sharedPreferences.getBoolean("dontshowagain", false)) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        long j = sharedPreferences.getLong("launch_count", 0) + 1;
        edit.putLong("launch_count", j);
        Long valueOf = Long.valueOf(sharedPreferences.getLong("date_firstlaunch", 0));
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(System.currentTimeMillis());
            edit.putLong("date_firstlaunch", valueOf.longValue());
        }
        if (j >= 5 && System.currentTimeMillis() >= valueOf.longValue() + 0) {
            return m8359a(activity, edit);
        }
        edit.commit();
        return false;
    }

    /* renamed from: a */
    public static boolean m8359a(Context context, SharedPreferences.Editor editor) {
        new Dialog(context);
        String[] stringArray = context.getResources().getStringArray(C1204R.array.avaliar);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(stringArray[0]).setTitle(stringArray[1] + f7767a).setIcon(context.getApplicationInfo().icon).setCancelable(false).setPositiveButton(stringArray[1], new C2067d(editor, context)).setNeutralButton(stringArray[2], new C2066c()).setNegativeButton(stringArray[3], new C2065b(editor));
        builder.create().show();
        return true;
    }
}
