package org.commonwealthcu.mobile.p038a;

import android.app.Activity;
import android.os.AsyncTask;
import org.commonwealthcu.mobile.MainActivity;
import org.json.JSONException;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0261h;
import org.p004a.p005a.p025g.p027b.C0421f;
import org.p004a.p005a.p025g.p027b.C0426k;
import org.p004a.p005a.p034j.C0543a;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.commonwealthcu.mobile.a.b */
public final class C0580b extends AsyncTask {

    /* renamed from: a */
    private Activity f695a;

    /* renamed from: b */
    private String f696b;

    public C0580b(Activity activity) {
        this.f695a = activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        int length = strArr.length;
        String str2 = "";
        int i = 0;
        while (i < length) {
            C0261h hVar = new C0261h(strArr[i]);
            C0543a aVar = new C0543a();
            C0250b.m104b((C0544b) aVar, 3000);
            C0250b.m104b((C0544b) aVar, 5000);
            try {
                str = (String) new C0426k(aVar).mo4935a(hVar, new C0421f());
                try {
                    this.f696b = str;
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                str = str2;
            }
            i++;
            str2 = str;
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        try {
            ((MainActivity) this.f695a).mo5457a(this.f696b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
