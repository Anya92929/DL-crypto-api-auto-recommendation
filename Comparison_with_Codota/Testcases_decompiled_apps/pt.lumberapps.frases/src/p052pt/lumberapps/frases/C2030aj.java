package p052pt.lumberapps.frases;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.p009v4.app.NotificationCompat;
import com.google.android.gms.C1204R;
import java.util.Calendar;
import java.util.Random;

/* renamed from: pt.lumberapps.frases.aj */
public class C2030aj {

    /* renamed from: e */
    public static int f7691e = 0;

    /* renamed from: a */
    Context f7692a;

    /* renamed from: b */
    C2020a f7693b;

    /* renamed from: c */
    Resources f7694c;

    /* renamed from: d */
    Calendar f7695d;

    /* renamed from: f */
    C2056h f7696f;

    /* renamed from: g */
    C2038ar f7697g;

    /* renamed from: h */
    final int f7698h = 901379310;

    public C2030aj(Context context) {
        this.f7692a = context;
        this.f7694c = this.f7692a.getResources();
        this.f7693b = new C2020a(this.f7692a);
        this.f7693b.mo10149a();
        this.f7696f = new C2056h(context);
        this.f7697g = this.f7693b.mo10153c(new Random().nextInt(C2020a.m8291b() - 1));
    }

    /* renamed from: a */
    public void mo10165a() {
        if (this.f7696f.mo10205a()) {
            Context context = this.f7692a;
            String b = this.f7697g.mo10181b();
            Intent intent = new Intent(context, MainActivity.class);
            MApp.m8271a(intent, this.f7697g, f7691e);
            PendingIntent activity = PendingIntent.getActivity(context, 901379310, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) this.f7692a.getSystemService("notification");
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this.f7692a).setContentTitle("Frase do dia").setContentText(b).setSmallIcon(C1204R.drawable.ic_launcher).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(activity);
            if (this.f7696f.mo10207b()) {
                contentIntent.setDefaults(1);
            }
            notificationManager.notify(1, contentIntent.build());
        }
    }

    /* renamed from: a */
    public void mo10166a(int i, int i2, int i3, int i4, int i5) {
        this.f7695d = Calendar.getInstance();
        this.f7695d.set(2, i2);
        this.f7695d.set(1, i3);
        this.f7695d.set(5, i);
        this.f7695d.set(11, i4);
        this.f7695d.set(12, i5);
        mo10168b();
    }

    /* renamed from: a */
    public void mo10167a(Calendar calendar) {
        this.f7695d = Calendar.getInstance();
        int i = this.f7695d.get(11);
        int i2 = calendar.get(11);
        if (i2 < i) {
            this.f7695d.add(5, 1);
        }
        if (i2 == i && calendar.get(12) < this.f7695d.get(12)) {
            this.f7695d.add(5, 1);
        }
        this.f7695d.set(11, calendar.get(11));
        this.f7695d.set(12, calendar.get(12));
        mo10168b();
    }

    /* renamed from: b */
    public void mo10168b() {
        if (this.f7696f.mo10205a()) {
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f7692a.getApplicationContext(), 901379310, new Intent(this.f7692a.getApplicationContext(), AlarmReceiver.class), 134217728);
            AlarmManager alarmManager = (AlarmManager) this.f7692a.getSystemService("alarm");
            alarmManager.cancel(broadcast);
            alarmManager.setRepeating(0, this.f7695d.getTimeInMillis(), 86400000, broadcast);
        }
    }

    /* renamed from: c */
    public void mo10169c() {
        if (this.f7696f.mo10205a()) {
            Calendar instance = Calendar.getInstance();
            instance.add(5, 1);
            mo10166a(instance.get(5), instance.get(2), instance.get(1), this.f7696f.mo10209d(), this.f7696f.mo10208c());
        }
    }
}
