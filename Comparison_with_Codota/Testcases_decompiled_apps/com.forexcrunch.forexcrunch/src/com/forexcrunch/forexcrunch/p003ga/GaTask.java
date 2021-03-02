package com.forexcrunch.forexcrunch.p003ga;

import android.content.Context;
import android.os.AsyncTask;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/* renamed from: com.forexcrunch.forexcrunch.ga.GaTask */
public class GaTask extends AsyncTask<Void, Void, Void> {
    public static final int EVENT = 0;
    private static final long OPT_VALUE = 1;
    private String action;
    private String category;
    private String label;
    private GoogleAnalytics mGaInstance;
    private Tracker mGaTracker = this.mGaInstance.getTracker("UA-1185746-1");
    private int type;
    private String viewName;

    public GaTask(Context ctx, int type2, String category2, String action2, String label2) {
        this.mGaInstance = GoogleAnalytics.getInstance(ctx);
        this.type = type2;
        this.action = action2;
        this.category = category2;
        this.label = label2;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... params) {
        switch (this.type) {
            case 0:
                callGAEvent();
                return null;
            default:
                return null;
        }
    }

    private void callGAEvent() {
        this.mGaTracker.sendEvent(this.category, this.action, this.label, (Long) null);
    }
}
