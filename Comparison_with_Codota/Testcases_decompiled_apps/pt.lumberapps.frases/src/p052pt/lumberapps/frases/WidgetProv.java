package p052pt.lumberapps.frases;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.google.android.gms.C1204R;
import java.util.Collections;

/* renamed from: pt.lumberapps.frases.WidgetProv */
public class WidgetProv extends AppWidgetProvider {

    /* renamed from: a */
    public static int f7662a = 0;

    /* renamed from: b */
    public static String f7663b = "ActionReceiverRefresh";

    /* renamed from: c */
    public static String f7664c = "ActionReceiverAbout";

    /* renamed from: d */
    public static String f7665d = "";

    /* renamed from: a */
    public static void m8289a(RemoteViews remoteViews, String str) {
        if (str.length() > 80) {
            str = str.substring(0, 77) + " (...)";
        }
        remoteViews.setTextViewText(C1204R.C1205id.tv_widget, str);
    }

    public void onReceive(Context context, Intent intent) {
        new C2020a(context);
        C2038ar arVar = (C2038ar) C2020a.f7667d.get(0);
        if (intent.getAction().equals(f7663b)) {
            Collections.shuffle(C2020a.f7667d);
            f7665d = ((C2038ar) C2020a.f7667d.get(0)).mo10181b();
            Intent intent2 = new Intent(context, UpdateService.class);
            intent2.putExtra("_FRASE_", f7665d);
            context.startService(intent2);
        }
        if (intent.getAction().equals(f7664c)) {
            Intent intent3 = new Intent(context, MainActivity.class);
            MApp.m8271a(intent3, arVar, 0);
            intent3.addFlags(268435456);
            context.startActivity(intent3);
        }
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        System.out.println("*---Update Started--*");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C1204R.layout.widget_layout);
        if (f7665d.length() == 0) {
            new C2020a(context);
            Collections.shuffle(C2020a.f7667d);
            f7665d = ((C2038ar) C2020a.f7667d.get(0)).mo10181b();
            m8289a(remoteViews, f7665d);
        }
        Intent intent = new Intent(context, WidgetProv.class);
        intent.setAction(f7663b);
        remoteViews.setOnClickPendingIntent(C1204R.C1205id.bt_widget, PendingIntent.getBroadcast(context, 0, intent, 0));
        Intent intent2 = new Intent(context, WidgetProv.class);
        intent2.setAction(f7664c);
        remoteViews.setOnClickPendingIntent(C1204R.C1205id.tv_widget, PendingIntent.getBroadcast(context, 0, intent2, 0));
        appWidgetManager.updateAppWidget(iArr, remoteViews);
    }
}
