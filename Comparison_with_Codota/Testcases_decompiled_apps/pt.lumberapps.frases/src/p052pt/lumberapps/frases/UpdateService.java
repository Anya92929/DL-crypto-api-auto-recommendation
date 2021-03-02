package p052pt.lumberapps.frases;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.UpdateService */
public class UpdateService extends Service {
    /* renamed from: a */
    public static void m8288a(RemoteViews remoteViews, String str) {
        if (str.length() > 80) {
            str = str.substring(0, 75) + " (...)";
        }
        remoteViews.setTextViewText(C1204R.C1205id.tv_widget, str);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), C1204R.layout.widget_layout);
        m8288a(remoteViews, intent.getStringExtra("_FRASE_"));
        AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, WidgetProv.class), remoteViews);
        stopSelf();
    }
}
