package com.jackhenry.godough.core;

import android.os.AsyncTask;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.core.p038e.C1588q;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;

/* renamed from: com.jackhenry.godough.core.o */
public abstract class C1758o<Params, Result> extends AsyncTask<Params, Integer, Result> {

    /* renamed from: a */
    protected Boolean f6510a = false;

    /* renamed from: b */
    protected C1759p<Result> f6511b;

    /* renamed from: c */
    protected Result f6512c;

    /* renamed from: d */
    protected C1389d f6513d;

    public C1758o(C1759p<Result> pVar) {
        this.f6511b = pVar;
    }

    /* renamed from: a */
    public C1759p<Result> mo10922a() {
        return this.f6511b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo9592a(Params... paramsArr);

    /* renamed from: a */
    public void mo10923a(C1759p<Result> pVar) {
        this.f6511b = pVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f6511b != null) {
            this.f6511b.mo9587a(numArr[0]);
        }
    }

    /* renamed from: b */
    public Result mo10925b() {
        return this.f6512c;
    }

    /* renamed from: c */
    public boolean mo10926c() {
        return this.f6510a.booleanValue();
    }

    /* renamed from: d */
    public C1389d mo10927d() {
        return this.f6513d;
    }

    /* access modifiers changed from: protected */
    public final Result doInBackground(Params... paramsArr) {
        try {
            return mo9592a(paramsArr);
        } catch (C1389d e) {
            this.f6513d = e;
            if (!(e instanceof C1392g) || Redirect.RedirectType.getEnum(e.getMessage().toUpperCase()) != Redirect.RedirectType.USERSETTINGS) {
                return null;
            }
            try {
                GoDoughApp.setUserSettings((UserSettings) null);
                C1588q.m6215a();
                return null;
            } catch (C1389d e2) {
                this.f6513d = e2;
                return null;
            }
        }
    }

    /* renamed from: e */
    public boolean mo10929e() {
        return this.f6513d != null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
        this.f6512c = result;
        if (this.f6511b != null) {
            if (this.f6513d != null) {
                this.f6511b.mo9589a(this.f6513d);
            } else {
                this.f6511b.mo9588a(result);
            }
        }
        this.f6510a = true;
    }
}
