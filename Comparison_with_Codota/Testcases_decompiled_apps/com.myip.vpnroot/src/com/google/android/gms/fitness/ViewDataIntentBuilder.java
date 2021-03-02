package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.C0355c;
import com.google.android.gms.fitness.data.DataSource;

public class ViewDataIntentBuilder {

    /* renamed from: KL */
    private long f1276KL;

    /* renamed from: Sh */
    private DataSource f1277Sh;

    /* renamed from: Si */
    private long f1278Si;

    /* renamed from: Sj */
    private String f1279Sj;
    private final Context mContext;

    public ViewDataIntentBuilder(Context context) {
        this.mContext = context;
    }

    /* renamed from: i */
    private Intent m1760i(Intent intent) {
        boolean z = false;
        if (this.f1279Sj == null) {
            return intent;
        }
        Intent intent2 = new Intent(intent).setPackage(this.f1279Sj);
        if (this.mContext.getPackageManager().resolveActivity(intent2, 0) != null) {
            z = true;
        }
        return z ? intent2 : intent;
    }

    public Intent build() {
        boolean z = true;
        C0348n.m852a(this.f1277Sh != null, "Data source must be set");
        C0348n.m852a(this.f1276KL > 0, "Start time must be set");
        if (this.f1278Si <= this.f1276KL) {
            z = false;
        }
        C0348n.m852a(z, "End time must be set and after start time");
        Intent intent = new Intent(FitnessIntents.ACTION_VIEW);
        intent.setType(FitnessIntents.getDataTypeMimeType(this.f1277Sh.getDataType()));
        intent.putExtra(FitnessIntents.EXTRA_START_TIME, this.f1276KL);
        intent.putExtra(FitnessIntents.EXTRA_END_TIME, this.f1278Si);
        C0355c.m944a(this.f1277Sh, intent, FitnessIntents.EXTRA_DATA_SOURCE);
        return m1760i(intent);
    }

    public ViewDataIntentBuilder setDataSource(DataSource dataSource) {
        this.f1277Sh = dataSource;
        return this;
    }

    public ViewDataIntentBuilder setPreferredApplication(String packageName) {
        this.f1279Sj = packageName;
        return this;
    }

    public ViewDataIntentBuilder setTimeInterval(long startTimeMillis, long endTimeMillis) {
        this.f1276KL = startTimeMillis;
        this.f1278Si = endTimeMillis;
        return this;
    }
}
