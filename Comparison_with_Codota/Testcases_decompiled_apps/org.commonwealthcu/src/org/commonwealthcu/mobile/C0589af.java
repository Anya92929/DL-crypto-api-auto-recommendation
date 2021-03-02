package org.commonwealthcu.mobile;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import java.util.Timer;

/* renamed from: org.commonwealthcu.mobile.af */
public class C0589af extends FragmentActivity {

    /* renamed from: c */
    private static String f715c;

    /* renamed from: a */
    private boolean f716a = false;

    /* renamed from: b */
    private boolean f717b = false;

    /* renamed from: a */
    private void m1288a(Intent intent) {
        ComponentName component = intent.getComponent();
        this.f717b = false;
        if (component != null && component.getPackageName() != null && component.getPackageName().equals(f715c)) {
            this.f717b = true;
        }
    }

    /* renamed from: a */
    public final void mo5494a(boolean z) {
        super.onPause();
        if (!isFinishing() && (getApplication() instanceof MobileBankingApp)) {
            MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplication();
        }
        if (z) {
            Log.d("MBFA", "onPause");
            try {
                if (((MobileBankingApp) getApplication()).f678b && !((MobileBankingApp) getApplication()).mo5463a()) {
                    ((MobileBankingApp) getApplication()).f677a = new Timer();
                    ((MobileBankingApp) getApplication()).f677a.schedule(new C0590ag(this), 150000);
                    ((MobileBankingApp) getApplication()).f677a.schedule(new C0592ai(this), 180000);
                    Log.d("MBFA - onPause", "logout timers set");
                } else if (!((MobileBankingApp) getApplication()).f678b && !((MobileBankingApp) getApplication()).mo5463a()) {
                    ((MobileBankingApp) getApplication()).f677a = new Timer();
                    ((MobileBankingApp) getApplication()).f677a.schedule(new C0593aj(this), 420000);
                    Log.d("MBFA - onPause", "close app timer set");
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public final void mo5495b(boolean z) {
        super.onResume();
        if (!this.f716a || !(getApplication() instanceof MobileBankingApp)) {
            this.f716a = true;
        } else {
            MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplication();
            this.f717b = false;
        }
        if (z) {
            try {
                ((MobileBankingApp) getApplication()).f677a.cancel();
                ((MobileBankingApp) getApplication()).f677a.purge();
            } catch (Exception e) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f715c = getApplicationContext().getPackageName();
    }

    public void startActivity(Intent intent) {
        m1288a(intent);
        super.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        m1288a(intent);
        super.startActivityForResult(intent, i);
    }
}
