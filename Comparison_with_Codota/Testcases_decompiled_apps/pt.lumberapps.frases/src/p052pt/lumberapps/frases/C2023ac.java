package p052pt.lumberapps.frases;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.google.android.gms.C1204R;
import java.util.Iterator;

/* renamed from: pt.lumberapps.frases.ac */
class C2023ac extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f7677a;

    /* renamed from: b */
    final /* synthetic */ C2076w f7678b;

    C2023ac(C2076w wVar, String str) {
        this.f7678b = wVar;
        this.f7677a = str;
    }

    public void run() {
        boolean z;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", String.valueOf(this.f7677a));
        Iterator<ResolveInfo> it = this.f7678b.getBaseContext().getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo.name.contains("facebook")) {
                ActivityInfo activityInfo = next.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(270532608);
                intent.setComponent(componentName);
                z = true;
                this.f7678b.getBaseContext().startActivity(intent);
                break;
            }
        }
        if (!z) {
            this.f7678b.mo10212a("Sem app do Facebook");
            this.f7678b.mo10243e("todos");
        } else {
            this.f7678b.mo10212a(this.f7678b.mo10240c(C1204R.string.cole_a_frase));
        }
        super.run();
    }
}
