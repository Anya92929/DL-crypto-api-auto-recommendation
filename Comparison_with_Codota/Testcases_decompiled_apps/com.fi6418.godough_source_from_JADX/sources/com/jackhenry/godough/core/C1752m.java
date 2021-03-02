package com.jackhenry.godough.core;

import android.content.Context;
import android.support.p000v4.content.AsyncTaskLoader;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.core.p038e.C1588q;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;

/* renamed from: com.jackhenry.godough.core.m */
public abstract class C1752m<D> extends AsyncTaskLoader<D> {

    /* renamed from: f */
    private C1389d f6498f;

    /* renamed from: g */
    private D f6499g;

    public C1752m(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final D mo1140d() {
        return loadInBackground();
    }

    public void deliverResult(D d) {
        this.f6499g = d;
        if (isStarted()) {
            super.deliverResult(d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1158e() {
        if (GoDoughApp.getUserSettings() == null) {
            this.f6499g = null;
        }
        if (this.f6499g != null) {
            deliverResult(this.f6499g);
        } else {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo1159f() {
        cancelLoad();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo1160g() {
        super.mo1160g();
        mo1159f();
        this.f6499g = null;
    }

    /* renamed from: i */
    public C1389d mo10081i() {
        return this.f6498f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract D mo9582j();

    public final D loadInBackground() {
        try {
            return mo9582j();
        } catch (C1389d e) {
            this.f6498f = e;
            if (!(e instanceof C1392g) || Redirect.RedirectType.getEnum(e.getMessage().toUpperCase()) != Redirect.RedirectType.USERSETTINGS) {
                return null;
            }
            try {
                GoDoughApp.setUserSettings((UserSettings) null);
                C1588q.m6215a();
                return null;
            } catch (C1389d e2) {
                this.f6498f = e2;
                return null;
            }
        }
    }
}
