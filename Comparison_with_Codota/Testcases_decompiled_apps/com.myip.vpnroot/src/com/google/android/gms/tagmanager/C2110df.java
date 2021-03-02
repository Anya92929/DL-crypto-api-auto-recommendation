package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

/* renamed from: com.google.android.gms.tagmanager.df */
class C2110df {
    private GoogleAnalytics arF;
    private Context mContext;

    /* renamed from: xY */
    private Tracker f4583xY;

    /* renamed from: com.google.android.gms.tagmanager.df$a */
    static class C2111a implements Logger {
        C2111a() {
        }

        /* renamed from: fm */
        private static int m7088fm(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            C2028bh.m6820b("", exception);
        }

        public void error(String message) {
            C2028bh.m6816T(message);
        }

        public int getLogLevel() {
            return m7088fm(C2028bh.getLogLevel());
        }

        public void info(String message) {
            C2028bh.m6817U(message);
        }

        public void setLogLevel(int logLevel) {
            C2028bh.m6819W("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            C2028bh.m6818V(message);
        }

        public void warn(String message) {
            C2028bh.m6819W(message);
        }
    }

    C2110df(Context context) {
        this.mContext = context;
    }

    /* renamed from: cS */
    private synchronized void m7086cS(String str) {
        if (this.arF == null) {
            this.arF = GoogleAnalytics.getInstance(this.mContext);
            this.arF.setLogger(new C2111a());
            this.f4583xY = this.arF.newTracker(str);
        }
    }

    /* renamed from: cR */
    public Tracker mo11731cR(String str) {
        m7086cS(str);
        return this.f4583xY;
    }
}
