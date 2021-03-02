package org.commonwealthcu.mobile;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.ActionBarActivity;
import android.util.Log;
import java.util.Timer;

/* renamed from: org.commonwealthcu.mobile.aa */
public class C0584aa extends ActionBarActivity {

    /* renamed from: c */
    private static String f708c;

    /* renamed from: a */
    private boolean f709a = false;

    /* renamed from: b */
    private boolean f710b = false;

    /* renamed from: a */
    private void m1287a(Intent intent) {
        ComponentName component = intent.getComponent();
        this.f710b = false;
        if (component != null && component.getPackageName() != null && component.getPackageName().equals(f708c)) {
            this.f710b = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f708c = getApplicationContext().getPackageName();
    }

    public void onPause() {
        super.onPause();
        if (!isFinishing() && (getApplication() instanceof MobileBankingApp)) {
            MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplication();
        }
        Log.d("MBABA", "onPause");
        try {
            if (((MobileBankingApp) getApplication()).f678b && !((MobileBankingApp) getApplication()).mo5463a()) {
                ((MobileBankingApp) getApplication()).f677a = new Timer();
                ((MobileBankingApp) getApplication()).f677a.schedule(new C0585ab(this), 150000);
                ((MobileBankingApp) getApplication()).f677a.schedule(new C0587ad(this), 180000);
            } else if (!((MobileBankingApp) getApplication()).f678b && !((MobileBankingApp) getApplication()).mo5463a()) {
                ((MobileBankingApp) getApplication()).f677a = new Timer();
                ((MobileBankingApp) getApplication()).f677a.schedule(new C0588ae(this), 420000);
                Log.d("MBABA - onPause", "close app timer set");
            }
        } catch (Exception e) {
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f709a || !(getApplication() instanceof MobileBankingApp)) {
            this.f709a = true;
        } else {
            MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplication();
            this.f710b = false;
        }
        try {
            ((MobileBankingApp) getApplication()).f677a.cancel();
            ((MobileBankingApp) getApplication()).f677a.purge();
        } catch (Exception e) {
        }
    }

    public void startActivity(Intent intent) {
        m1287a(intent);
        super.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        m1287a(intent);
        super.startActivityForResult(intent, i);
    }
}
