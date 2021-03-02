package com.jackhenry.godough.core.p038e.p039a;

import android.annotation.TargetApi;
import android.util.Base64;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.p027b.C1389d;
import javax.crypto.Cipher;

@TargetApi(18)
/* renamed from: com.jackhenry.godough.core.e.a.e */
public class C1572e implements C1570c {

    /* renamed from: a */
    C1568a f6135a = new C1568a(this);

    /* renamed from: a */
    public void mo9782a() {
        mo9787b("DATA2");
    }

    /* renamed from: a */
    public void mo9785a(String str, byte[] bArr) {
        C1584m mVar = new C1584m(GoDoughApp.getApp());
        if (str != null) {
            try {
                mVar.mo9801b(str, new String(Base64.encode(this.f6135a.mo9779b(1).doFinal(bArr), 0), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new C1389d(GoDoughApp.getApp().getString(C1506am.dg_no_account_msg), 1000);
            }
        }
    }

    /* renamed from: a */
    public byte[] mo9786a(String str) {
        byte[] doFinal;
        C1584m mVar = new C1584m(GoDoughApp.getApp());
        try {
            Cipher b = this.f6135a.mo9779b(2);
            String a = mVar.mo9798a(str, (String) null);
            if (!(a == null || (doFinal = b.doFinal(Base64.decode(a.getBytes("UTF-8"), 0))) == null)) {
                return doFinal;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: b */
    public void mo9787b(String str) {
        new C1584m(GoDoughApp.getApp()).mo9799a(str);
    }
}
