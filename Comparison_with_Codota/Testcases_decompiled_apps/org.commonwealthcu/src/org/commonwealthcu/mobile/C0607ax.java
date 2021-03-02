package org.commonwealthcu.mobile;

import android.os.AsyncTask;
import java.io.File;
import org.commonwealthcu.mobile.p038a.C0581c;

/* renamed from: org.commonwealthcu.mobile.ax */
final class C0607ax extends AsyncTask {

    /* renamed from: a */
    private /* synthetic */ C0599ap f780a;

    private C0607ax(C0599ap apVar) {
        this.f780a = apVar;
    }

    /* synthetic */ C0607ax(C0599ap apVar, byte b) {
        this(apVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        File fileStreamPath = this.f780a.f751i.getFileStreamPath("front_color.jpg");
        File fileStreamPath2 = this.f780a.f751i.getFileStreamPath("front.png");
        new C0581c(this.f780a.f764v, this.f780a.mo5508c("depositinit"), fileStreamPath2, fileStreamPath).execute(new String[]{this.f780a.f763u + "/commonfiles/iphone/asppages/vertifi.aspx", this.f780a.f762t});
        return null;
    }
}
