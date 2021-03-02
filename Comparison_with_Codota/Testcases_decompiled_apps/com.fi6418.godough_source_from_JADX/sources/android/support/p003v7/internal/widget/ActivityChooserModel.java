package android.support.p003v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.p000v4.p002os.AsyncTaskCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.internal.widget.ActivityChooserModel */
public class ActivityChooserModel extends DataSetObservable {
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f2257a = ActivityChooserModel.class.getSimpleName();

    /* renamed from: b */
    private static final Object f2258b = new Object();

    /* renamed from: c */
    private static final Map<String, ActivityChooserModel> f2259c = new HashMap();

    /* renamed from: d */
    private final Object f2260d = new Object();

    /* renamed from: e */
    private final List<ActivityResolveInfo> f2261e = new ArrayList();

    /* renamed from: f */
    private final List<HistoricalRecord> f2262f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Context f2263g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f2264h;

    /* renamed from: i */
    private Intent f2265i;

    /* renamed from: j */
    private ActivitySorter f2266j = new DefaultSorter();

    /* renamed from: k */
    private int f2267k = 50;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2268l = true;

    /* renamed from: m */
    private boolean f2269m = false;

    /* renamed from: n */
    private boolean f2270n = true;

    /* renamed from: o */
    private boolean f2271o = false;

    /* renamed from: p */
    private OnChooseActivityListener f2272p;

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$ActivityChooserModelClient */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$ActivityResolveInfo */
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.resolveInfo.toString());
            sb.append("; weight:").append(new BigDecimal((double) this.weight));
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$ActivitySorter */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$DefaultSorter */
    final class DefaultSorter implements ActivitySorter {

        /* renamed from: b */
        private final Map<ComponentName, ActivityResolveInfo> f2275b;

        private DefaultSorter() {
            this.f2275b = new HashMap();
        }

        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            float f;
            Map<ComponentName, ActivityResolveInfo> map = this.f2275b;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = BitmapDescriptorFactory.HUE_RED;
                map.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
            }
            float f2 = 1.0f;
            int size2 = list2.size() - 1;
            while (size2 >= 0) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight = (historicalRecord.weight * f2) + activityResolveInfo2.weight;
                    f = 0.95f * f2;
                } else {
                    f = f2;
                }
                size2--;
                f2 = f;
            }
            Collections.sort(list);
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$HistoricalRecord */
    public final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            if (this.activity == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!this.activity.equals(historicalRecord.activity)) {
                return false;
            }
            if (this.time != historicalRecord.time) {
                return false;
            }
            return Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.activity);
            sb.append("; time:").append(this.time);
            sb.append("; weight:").append(new BigDecimal((double) this.weight));
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$OnChooseActivityListener */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* renamed from: android.support.v7.internal.widget.ActivityChooserModel$PersistHistoryAsyncTask */
    final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        private PersistHistoryAsyncTask() {
        }

        public Void doInBackground(Object... objArr) {
            List list = objArr[0];
            String str = objArr[1];
            try {
                FileOutputStream openFileOutput = ActivityChooserModel.this.f2263g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, (String) null);
                    newSerializer.startDocument("UTF-8", true);
                    newSerializer.startTag((String) null, "historical-records");
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                        newSerializer.startTag((String) null, "historical-record");
                        newSerializer.attribute((String) null, "activity", historicalRecord.activity.flattenToString());
                        newSerializer.attribute((String) null, "time", String.valueOf(historicalRecord.time));
                        newSerializer.attribute((String) null, "weight", String.valueOf(historicalRecord.weight));
                        newSerializer.endTag((String) null, "historical-record");
                    }
                    newSerializer.endTag((String) null, "historical-records");
                    newSerializer.endDocument();
                    boolean unused = ActivityChooserModel.this.f2268l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    Log.e(ActivityChooserModel.f2257a, "Error writing historical recrod file: " + ActivityChooserModel.this.f2264h, e2);
                    boolean unused2 = ActivityChooserModel.this.f2268l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    Log.e(ActivityChooserModel.f2257a, "Error writing historical recrod file: " + ActivityChooserModel.this.f2264h, e4);
                    boolean unused3 = ActivityChooserModel.this.f2268l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    Log.e(ActivityChooserModel.f2257a, "Error writing historical recrod file: " + ActivityChooserModel.this.f2264h, e6);
                    boolean unused4 = ActivityChooserModel.this.f2268l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    boolean unused5 = ActivityChooserModel.this.f2268l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                Log.e(ActivityChooserModel.f2257a, "Error writing historical recrod file: " + str, e9);
            }
            return null;
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.f2263g = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f2264h = str;
        } else {
            this.f2264h = str + ".xml";
        }
    }

    /* renamed from: a */
    private boolean m1473a(HistoricalRecord historicalRecord) {
        boolean add = this.f2262f.add(historicalRecord);
        if (add) {
            this.f2270n = true;
            m1481g();
            m1476b();
            m1478d();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: b */
    private void m1476b() {
        if (!this.f2269m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2270n) {
            this.f2270n = false;
            if (!TextUtils.isEmpty(this.f2264h)) {
                AsyncTaskCompat.executeParallel(new PersistHistoryAsyncTask(), new ArrayList(this.f2262f), this.f2264h);
            }
        }
    }

    /* renamed from: c */
    private void m1477c() {
        boolean e = m1479e() | m1480f();
        m1481g();
        if (e) {
            m1478d();
            notifyChanged();
        }
    }

    /* renamed from: d */
    private boolean m1478d() {
        if (this.f2266j == null || this.f2265i == null || this.f2261e.isEmpty() || this.f2262f.isEmpty()) {
            return false;
        }
        this.f2266j.sort(this.f2265i, this.f2261e, Collections.unmodifiableList(this.f2262f));
        return true;
    }

    /* renamed from: e */
    private boolean m1479e() {
        if (!this.f2271o || this.f2265i == null) {
            return false;
        }
        this.f2271o = false;
        this.f2261e.clear();
        List<ResolveInfo> queryIntentActivities = this.f2263g.getPackageManager().queryIntentActivities(this.f2265i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2261e.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: f */
    private boolean m1480f() {
        if (!this.f2268l || !this.f2270n || TextUtils.isEmpty(this.f2264h)) {
            return false;
        }
        this.f2268l = false;
        this.f2269m = true;
        m1482h();
        return true;
    }

    /* renamed from: g */
    private void m1481g() {
        int size = this.f2262f.size() - this.f2267k;
        if (size > 0) {
            this.f2270n = true;
            for (int i = 0; i < size; i++) {
                HistoricalRecord remove = this.f2262f.remove(0);
            }
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f2258b) {
            activityChooserModel = f2259c.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                f2259c.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    /* renamed from: h */
    private void m1482h() {
        try {
            FileInputStream openFileInput = this.f2263g.openFileInput(this.f2264h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<HistoricalRecord> list = this.f2262f;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!(next == 3 || next == 4)) {
                        if (!"historical-record".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new HistoricalRecord(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                    }
                }
            } catch (XmlPullParserException e2) {
                Log.e(f2257a, "Error reading historical recrod file: " + this.f2264h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                Log.e(f2257a, "Error reading historical recrod file: " + this.f2264h, e4);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
        }
    }

    public Intent chooseActivity(int i) {
        synchronized (this.f2260d) {
            if (this.f2265i == null) {
                return null;
            }
            m1477c();
            ActivityResolveInfo activityResolveInfo = this.f2261e.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.f2265i);
            intent.setComponent(componentName);
            if (this.f2272p != null) {
                if (this.f2272p.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            m1473a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2260d) {
            m1477c();
            resolveInfo = this.f2261e.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.f2260d) {
            m1477c();
            size = this.f2261e.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.f2260d) {
            m1477c();
            List<ActivityResolveInfo> list = this.f2261e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.f2260d) {
            m1477c();
            if (this.f2261e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f2261e.get(0).resolveInfo;
            return resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.f2260d) {
            i = this.f2267k;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.f2260d) {
            m1477c();
            size = this.f2262f.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.f2260d) {
            intent = this.f2265i;
        }
        return intent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setActivitySorter(android.support.p003v7.internal.widget.ActivityChooserModel.ActivitySorter r3) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f2260d
            monitor-enter(r1)
            android.support.v7.internal.widget.ActivityChooserModel$ActivitySorter r0 = r2.f2266j     // Catch:{ all -> 0x0016 }
            if (r0 != r3) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
        L_0x0008:
            return
        L_0x0009:
            r2.f2266j = r3     // Catch:{ all -> 0x0016 }
            boolean r0 = r2.m1478d()     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            r2.notifyChanged()     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0008
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.ActivityChooserModel.setActivitySorter(android.support.v7.internal.widget.ActivityChooserModel$ActivitySorter):void");
    }

    public void setDefaultActivity(int i) {
        synchronized (this.f2260d) {
            m1477c();
            ActivityResolveInfo activityResolveInfo = this.f2261e.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.f2261e.get(0);
            m1473a(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setHistoryMaxSize(int r3) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f2260d
            monitor-enter(r1)
            int r0 = r2.f2267k     // Catch:{ all -> 0x0019 }
            if (r0 != r3) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        L_0x0008:
            return
        L_0x0009:
            r2.f2267k = r3     // Catch:{ all -> 0x0019 }
            r2.m1481g()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2.m1478d()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            r2.notifyChanged()     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x0008
        L_0x0019:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.ActivityChooserModel.setHistoryMaxSize(int):void");
    }

    public void setIntent(Intent intent) {
        synchronized (this.f2260d) {
            if (this.f2265i != intent) {
                this.f2265i = intent;
                this.f2271o = true;
                m1477c();
            }
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.f2260d) {
            this.f2272p = onChooseActivityListener;
        }
    }
}
