package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.C1196fz;

@C1130ez
/* renamed from: com.google.android.gms.internal.v */
public class C1741v {

    /* renamed from: lZ */
    private C1742a f4400lZ;

    /* renamed from: ma */
    private boolean f4401ma;

    /* renamed from: mb */
    private boolean f4402mb;

    /* renamed from: com.google.android.gms.internal.v$a */
    public interface C1742a {
        /* renamed from: e */
        void mo10156e(String str);
    }

    @C1130ez
    /* renamed from: com.google.android.gms.internal.v$b */
    public static class C1743b implements C1742a {

        /* renamed from: mc */
        private final C1196fz.C1197a f4403mc;

        /* renamed from: md */
        private final C1232gv f4404md;

        public C1743b(C1196fz.C1197a aVar, C1232gv gvVar) {
            this.f4403mc = aVar;
            this.f4404md = gvVar;
        }

        /* renamed from: e */
        public void mo10156e(String str) {
            C1229gs.m4675S("An auto-clicking creative is blocked");
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.f4403mc == null || this.f4403mc.f3692vw == null || TextUtils.isEmpty(this.f4403mc.f3692vw.f3567tN))) {
                builder.appendQueryParameter("debugDialog", this.f4403mc.f3692vw.f3567tN);
            }
            C1213gj.m4631c(this.f4404md.getContext(), this.f4404md.mo8634dy().f3777wD, builder.toString());
        }
    }

    public C1741v() {
        boolean z = false;
        Bundle bD = C1201gb.m4562bD();
        if (bD != null && bD.getBoolean("gads:block_autoclicks", false)) {
            z = true;
        }
        this.f4402mb = z;
    }

    public C1741v(boolean z) {
        this.f4402mb = z;
    }

    /* renamed from: a */
    public void mo10152a(C1742a aVar) {
        this.f4400lZ = aVar;
    }

    /* renamed from: ar */
    public void mo10153ar() {
        this.f4401ma = true;
    }

    /* renamed from: av */
    public boolean mo10154av() {
        return !this.f4402mb || this.f4401ma;
    }

    /* renamed from: d */
    public void mo10155d(String str) {
        C1229gs.m4675S("Action was blocked because no click was detected.");
        if (this.f4400lZ != null) {
            this.f4400lZ.mo10156e(str);
        }
    }
}
