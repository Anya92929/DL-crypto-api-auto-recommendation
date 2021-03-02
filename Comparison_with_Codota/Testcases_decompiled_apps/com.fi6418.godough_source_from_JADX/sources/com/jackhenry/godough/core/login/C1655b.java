package com.jackhenry.godough.core.login;

import android.os.Build;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Credentials;
import com.jackhenry.godough.core.p038e.p039a.C1572e;
import com.jackhenry.godough.p024a.C1373a;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;
import java.io.UnsupportedEncodingException;

/* renamed from: com.jackhenry.godough.core.login.b */
public class C1655b extends C1628a<String> {

    /* renamed from: e */
    private Credentials f6394e;

    public C1655b(Credentials credentials, C1759p<String> pVar) {
        super(pVar);
        this.f6394e = credentials;
    }

    /* renamed from: f */
    private void m6413f() {
        if (Build.VERSION.SDK_INT > 17) {
            try {
                if (GoDoughApp.getSettings().isRememberMeEnabled()) {
                    C1373a.m5617a(GoDoughApp.getApp().getString(C1506am.remember_me_switch), this.f6394e.isRememberMe() ? GoDoughApp.getApp().getString(C1506am.remember_me_enabled) : GoDoughApp.getApp().getString(C1506am.remember_me_disabled), GoDoughApp.getApp().getString(C1506am.remember_me_label));
                }
                C1572e eVar = new C1572e();
                if (this.f6394e.isRememberMe()) {
                    eVar.mo9785a("DATA2", this.f6394e.getUserName().getBytes("UTF-8"));
                } else {
                    eVar.mo9787b("DATA2");
                }
            } catch (C1389d e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public String mo9943b(Void... voidArr) {
        C1650av.m6405a();
        try {
            String a = new C1689cg().mo10001a(this.f6394e);
            m6413f();
            return a;
        } catch (C1392g e) {
            throw e;
        } catch (Throwable th) {
            if (1 != 0) {
                m6413f();
            }
            throw th;
        }
    }
}
