package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ActivityChooserModel extends DataSetObservable {
    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    /* access modifiers changed from: private */
    public static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    private static final Executor SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private static final Object sRegistryLock = new Object();
    private final List<ActivityResolveInfo> mActivites = new ArrayList();
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter = new DefaultSorter(this, (DefaultSorter) null);
    private boolean mCanReadHistoricalData = true;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    /* access modifiers changed from: private */
    public boolean mHistoricalRecordsChanged = true;
    /* access modifiers changed from: private */
    public final String mHistoryFileName;
    private int mHistoryMaxSize = 50;
    /* access modifiers changed from: private */
    public final Object mInstanceLock = new Object();
    private Intent mIntent;
    private boolean mReadShareHistoryCalled = DEBUG;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public static ActivityChooserModel get(Context context, String historyFileName) {
        ActivityChooserModel dataModel;
        synchronized (sRegistryLock) {
            dataModel = sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
            dataModel.readHistoricalData();
        }
        return dataModel;
    }

    private ActivityChooserModel(Context context, String historyFileName) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(historyFileName) || historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = historyFileName;
        } else {
            this.mHistoryFileName = String.valueOf(historyFileName) + HISTORY_FILE_EXTENSION;
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent != intent) {
                this.mIntent = intent;
                loadActivitiesLocked();
            }
        }
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            size = this.mActivites.size();
        }
        return size;
    }

    public ResolveInfo getActivity(int index) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            resolveInfo = this.mActivites.get(index).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityIndex(ResolveInfo activity) {
        List<ActivityResolveInfo> activities = this.mActivites;
        int activityCount = activities.size();
        for (int i = 0; i < activityCount; i++) {
            if (activities.get(i).resolveInfo == activity) {
                return i;
            }
        }
        return -1;
    }

    public Intent chooseActivity(int index) {
        ActivityResolveInfo chosenActivity = this.mActivites.get(index);
        ComponentName chosenName = new ComponentName(chosenActivity.resolveInfo.activityInfo.packageName, chosenActivity.resolveInfo.activityInfo.name);
        Intent choiceIntent = new Intent(this.mIntent);
        choiceIntent.setComponent(chosenName);
        if (this.mActivityChoserModelPolicy != null) {
            if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(choiceIntent))) {
                return null;
            }
        }
        addHisoricalRecord(new HistoricalRecord(chosenName, System.currentTimeMillis(), (float) DEFAULT_HISTORICAL_RECORD_WEIGHT));
        return choiceIntent;
    }

    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        this.mActivityChoserModelPolicy = listener;
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            if (this.mActivites.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.mActivites.get(0).resolveInfo;
            return resolveInfo;
        }
    }

    public void setDefaultActivity(int index) {
        float weight;
        ActivityResolveInfo newDefaultActivity = this.mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity = this.mActivites.get(0);
        if (oldDefaultActivity != null) {
            weight = (oldDefaultActivity.weight - newDefaultActivity.weight) + 5.0f;
        } else {
            weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        }
        addHisoricalRecord(new HistoricalRecord(new ComponentName(newDefaultActivity.resolveInfo.activityInfo.packageName, newDefaultActivity.resolveInfo.activityInfo.name), System.currentTimeMillis(), weight));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readHistoricalData() {
        /*
            r4 = this;
            java.lang.Object r1 = r4.mInstanceLock
            monitor-enter(r1)
            boolean r0 = r4.mCanReadHistoricalData     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x000b
            boolean r0 = r4.mHistoricalRecordsChanged     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
        L_0x000c:
            return
        L_0x000d:
            r0 = 0
            r4.mCanReadHistoricalData = r0     // Catch:{ all -> 0x0028 }
            r0 = 1
            r4.mReadShareHistoryCalled = r0     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = r4.mHistoryFileName     // Catch:{ all -> 0x0028 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0026
            java.util.concurrent.Executor r0 = SERIAL_EXECUTOR     // Catch:{ all -> 0x0028 }
            com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader r2 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader     // Catch:{ all -> 0x0028 }
            r3 = 0
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0028 }
            r0.execute(r2)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x000c
        L_0x0028:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.readHistoricalData():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void persistHistoricalData() {
        /*
            r4 = this;
            java.lang.Object r1 = r4.mInstanceLock
            monitor-enter(r1)
            boolean r0 = r4.mReadShareHistoryCalled     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0012
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r2 = "No preceding call to #readHistoricalData"
            r0.<init>(r2)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x000f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            throw r0
        L_0x0012:
            boolean r0 = r4.mHistoricalRecordsChanged     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0018
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
        L_0x0017:
            return
        L_0x0018:
            r0 = 0
            r4.mHistoricalRecordsChanged = r0     // Catch:{ all -> 0x000f }
            r0 = 1
            r4.mCanReadHistoricalData = r0     // Catch:{ all -> 0x000f }
            java.lang.String r0 = r4.mHistoryFileName     // Catch:{ all -> 0x000f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0031
            java.util.concurrent.Executor r0 = SERIAL_EXECUTOR     // Catch:{ all -> 0x000f }
            com.actionbarsherlock.widget.ActivityChooserModel$HistoryPersister r2 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryPersister     // Catch:{ all -> 0x000f }
            r3 = 0
            r2.<init>(r4, r3)     // Catch:{ all -> 0x000f }
            r0.execute(r2)     // Catch:{ all -> 0x000f }
        L_0x0031:
            monitor-exit(r1)     // Catch:{ all -> 0x000f }
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.persistHistoricalData():void");
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter != activitySorter) {
                this.mActivitySorter = activitySorter;
                sortActivities();
            }
        }
    }

    /* access modifiers changed from: private */
    public void sortActivities() {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter != null && !this.mActivites.isEmpty()) {
                this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList(this.mHistoricalRecords));
                notifyChanged();
            }
        }
    }

    public void setHistoryMaxSize(int historyMaxSize) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize != historyMaxSize) {
                this.mHistoryMaxSize = historyMaxSize;
                pruneExcessiveHistoricalRecordsLocked();
                sortActivities();
            }
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        boolean added;
        synchronized (this.mInstanceLock) {
            added = this.mHistoricalRecords.add(historicalRecord);
            if (added) {
                this.mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            }
        }
        return added;
    }

    /* access modifiers changed from: private */
    public void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords = this.mHistoricalRecords;
        int pruneCount = choiceRecords.size() - this.mHistoryMaxSize;
        if (pruneCount > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i = 0; i < pruneCount; i++) {
                HistoricalRecord remove = choiceRecords.remove(0);
            }
        }
    }

    private void loadActivitiesLocked() {
        this.mActivites.clear();
        if (this.mIntent != null) {
            List<ResolveInfo> resolveInfos = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            int resolveInfoCount = resolveInfos.size();
            for (int i = 0; i < resolveInfoCount; i++) {
                this.mActivites.add(new ActivityResolveInfo(resolveInfos.get(i)));
            }
            sortActivities();
            return;
        }
        notifyChanged();
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String activityName, long time2, float weight2) {
            this(ComponentName.unflattenFromString(activityName), time2, weight2);
        }

        public HistoricalRecord(ComponentName activityName, long time2, float weight2) {
            this.activity = activityName;
            this.time = time2;
            this.weight = weight2;
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return ActivityChooserModel.DEBUG;
            }
            if (getClass() != obj.getClass()) {
                return ActivityChooserModel.DEBUG;
            }
            HistoricalRecord other = (HistoricalRecord) obj;
            if (this.activity == null) {
                if (other.activity != null) {
                    return ActivityChooserModel.DEBUG;
                }
            } else if (!this.activity.equals(other.activity)) {
                return ActivityChooserModel.DEBUG;
            }
            if (this.time != other.time) {
                return ActivityChooserModel.DEBUG;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(other.weight)) {
                return ActivityChooserModel.DEBUG;
            }
            return true;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(this.activity);
            builder.append("; time:").append(this.time);
            builder.append("; weight:").append(new BigDecimal((double) this.weight));
            builder.append("]");
            return builder.toString();
        }
    }

    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return ActivityChooserModel.DEBUG;
            }
            if (getClass() != obj.getClass()) {
                return ActivityChooserModel.DEBUG;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return ActivityChooserModel.DEBUG;
            }
            return true;
        }

        public int compareTo(ActivityResolveInfo another) {
            return Float.floatToIntBits(another.weight) - Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(this.resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal((double) this.weight));
            builder.append("]");
            return builder.toString();
        }
    }

    private final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap;

        private DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        /* synthetic */ DefaultSorter(ActivityChooserModel activityChooserModel, DefaultSorter defaultSorter) {
            this();
        }

        public void sort(Intent intent, List<ActivityResolveInfo> activities, List<HistoricalRecord> historicalRecords) {
            Map<String, ActivityResolveInfo> packageNameToActivityMap = this.mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            int activityCount = activities.size();
            for (int i = 0; i < activityCount; i++) {
                ActivityResolveInfo activity = activities.get(i);
                activity.weight = BitmapDescriptorFactory.HUE_RED;
                packageNameToActivityMap.put(activity.resolveInfo.activityInfo.packageName, activity);
            }
            float nextRecordWeight = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
            for (int i2 = historicalRecords.size() - 1; i2 >= 0; i2--) {
                HistoricalRecord historicalRecord = historicalRecords.get(i2);
                ActivityResolveInfo activity2 = packageNameToActivityMap.get(historicalRecord.activity.getPackageName());
                if (activity2 != null) {
                    activity2.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(activities);
        }
    }

    private final class HistoryLoader implements Runnable {
        private HistoryLoader() {
        }

        /* synthetic */ HistoryLoader(ActivityChooserModel activityChooserModel, HistoryLoader historyLoader) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
            r22 = com.actionbarsherlock.widget.ActivityChooserModel.access$2(r24.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
            monitor-enter(r22);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r0 = new java.util.LinkedHashSet(r14);
            r7 = com.actionbarsherlock.widget.ActivityChooserModel.access$3(r24.this$0);
            r9 = r7.size() - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b1, code lost:
            if (r9 >= 0) goto L_0x015f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bf, code lost:
            if (r7.size() != r0.size()) goto L_0x016e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
            monitor-exit(r22);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c2, code lost:
            if (r4 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r0.add(r7.get(r9));
            r9 = r9 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x016e, code lost:
            r7.clear();
            r7.addAll(r0);
            com.actionbarsherlock.widget.ActivityChooserModel.access$4(r24.this$0, true);
            com.actionbarsherlock.widget.ActivityChooserModel.access$5(r24.this$0).post(new com.actionbarsherlock.widget.ActivityChooserModel.HistoryLoader.C00681(r24));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x019b, code lost:
            monitor-exit(r22);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x019c, code lost:
            if (r4 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r24 = this;
                r4 = 0
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x0077 }
                r21 = r0
                android.content.Context r21 = r21.mContext     // Catch:{ FileNotFoundException -> 0x0077 }
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x0077 }
                r22 = r0
                java.lang.String r22 = r22.mHistoryFileName     // Catch:{ FileNotFoundException -> 0x0077 }
                java.io.FileInputStream r4 = r21.openFileInput(r22)     // Catch:{ FileNotFoundException -> 0x0077 }
                org.xmlpull.v1.XmlPullParser r12 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r21 = 0
                r0 = r21
                r12.setInput(r4, r0)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r17 = 0
            L_0x0026:
                r21 = 1
                r0 = r17
                r1 = r21
                if (r0 == r1) goto L_0x0036
                r21 = 2
                r0 = r17
                r1 = r21
                if (r0 != r1) goto L_0x0079
            L_0x0036:
                java.lang.String r21 = "historical-records"
                java.lang.String r22 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                boolean r21 = r21.equals(r22)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                if (r21 != 0) goto L_0x007e
                org.xmlpull.v1.XmlPullParserException r21 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                java.lang.String r22 = "Share records file does not start with historical-records tag."
                r21.<init>(r22)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                throw r21     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            L_0x004a:
                r20 = move-exception
                java.lang.String r21 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0158 }
                java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
                java.lang.String r23 = "Error reading historical recrod file: "
                r22.<init>(r23)     // Catch:{ all -> 0x0158 }
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0158 }
                r23 = r0
                java.lang.String r23 = r23.mHistoryFileName     // Catch:{ all -> 0x0158 }
                java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ all -> 0x0158 }
                java.lang.String r22 = r22.toString()     // Catch:{ all -> 0x0158 }
                r0 = r21
                r1 = r22
                r2 = r20
                android.util.Log.e(r0, r1, r2)     // Catch:{ all -> 0x0158 }
                if (r4 == 0) goto L_0x0076
                r4.close()     // Catch:{ IOException -> 0x01a9 }
            L_0x0076:
                return
            L_0x0077:
                r5 = move-exception
                goto L_0x0076
            L_0x0079:
                int r17 = r12.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                goto L_0x0026
            L_0x007e:
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r14.<init>()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            L_0x0083:
                int r17 = r12.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r21 = 1
                r0 = r17
                r1 = r21
                if (r0 != r1) goto L_0x00ca
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r21 = r0
                java.lang.Object r22 = r21.mInstanceLock     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                monitor-enter(r22)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                java.util.LinkedHashSet r18 = new java.util.LinkedHashSet     // Catch:{ all -> 0x01a6 }
                r0 = r18
                r0.<init>(r14)     // Catch:{ all -> 0x01a6 }
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x01a6 }
                r21 = r0
                java.util.List r7 = r21.mHistoricalRecords     // Catch:{ all -> 0x01a6 }
                int r8 = r7.size()     // Catch:{ all -> 0x01a6 }
                int r9 = r8 + -1
            L_0x00b1:
                if (r9 >= 0) goto L_0x015f
                int r21 = r7.size()     // Catch:{ all -> 0x01a6 }
                int r23 = r18.size()     // Catch:{ all -> 0x01a6 }
                r0 = r21
                r1 = r23
                if (r0 != r1) goto L_0x016e
                monitor-exit(r22)     // Catch:{ all -> 0x01a6 }
                if (r4 == 0) goto L_0x0076
                r4.close()     // Catch:{ IOException -> 0x00c8 }
                goto L_0x0076
            L_0x00c8:
                r21 = move-exception
                goto L_0x0076
            L_0x00ca:
                r21 = 3
                r0 = r17
                r1 = r21
                if (r0 == r1) goto L_0x0083
                r21 = 4
                r0 = r17
                r1 = r21
                if (r0 == r1) goto L_0x0083
                java.lang.String r11 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                java.lang.String r21 = "historical-record"
                r0 = r21
                boolean r21 = r0.equals(r11)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                if (r21 != 0) goto L_0x011f
                org.xmlpull.v1.XmlPullParserException r21 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                java.lang.String r22 = "Share records file not well-formed."
                r21.<init>(r22)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                throw r21     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            L_0x00f0:
                r10 = move-exception
                java.lang.String r21 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0158 }
                java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
                java.lang.String r23 = "Error reading historical recrod file: "
                r22.<init>(r23)     // Catch:{ all -> 0x0158 }
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0158 }
                r23 = r0
                java.lang.String r23 = r23.mHistoryFileName     // Catch:{ all -> 0x0158 }
                java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ all -> 0x0158 }
                java.lang.String r22 = r22.toString()     // Catch:{ all -> 0x0158 }
                r0 = r21
                r1 = r22
                android.util.Log.e(r0, r1, r10)     // Catch:{ all -> 0x0158 }
                if (r4 == 0) goto L_0x0076
                r4.close()     // Catch:{ IOException -> 0x011c }
                goto L_0x0076
            L_0x011c:
                r21 = move-exception
                goto L_0x0076
            L_0x011f:
                r21 = 0
                java.lang.String r22 = "activity"
                r0 = r21
                r1 = r22
                java.lang.String r3 = r12.getAttributeValue(r0, r1)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r21 = 0
                java.lang.String r22 = "time"
                r0 = r21
                r1 = r22
                java.lang.String r21 = r12.getAttributeValue(r0, r1)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                long r15 = java.lang.Long.parseLong(r21)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r21 = 0
                java.lang.String r22 = "weight"
                r0 = r21
                r1 = r22
                java.lang.String r21 = r12.getAttributeValue(r0, r1)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                float r19 = java.lang.Float.parseFloat(r21)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                com.actionbarsherlock.widget.ActivityChooserModel$HistoricalRecord r13 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoricalRecord     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r0 = r15
                r2 = r19
                r13.<init>((java.lang.String) r3, (long) r0, (float) r2)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                r14.add(r13)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
                goto L_0x0083
            L_0x0158:
                r21 = move-exception
                if (r4 == 0) goto L_0x015e
                r4.close()     // Catch:{ IOException -> 0x01ac }
            L_0x015e:
                throw r21
            L_0x015f:
                java.lang.Object r6 = r7.get(r9)     // Catch:{ all -> 0x01a6 }
                com.actionbarsherlock.widget.ActivityChooserModel$HistoricalRecord r6 = (com.actionbarsherlock.widget.ActivityChooserModel.HistoricalRecord) r6     // Catch:{ all -> 0x01a6 }
                r0 = r18
                r0.add(r6)     // Catch:{ all -> 0x01a6 }
                int r9 = r9 + -1
                goto L_0x00b1
            L_0x016e:
                r7.clear()     // Catch:{ all -> 0x01a6 }
                r0 = r18
                r7.addAll(r0)     // Catch:{ all -> 0x01a6 }
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x01a6 }
                r21 = r0
                r23 = 1
                r0 = r21
                r1 = r23
                r0.mHistoricalRecordsChanged = r1     // Catch:{ all -> 0x01a6 }
                r0 = r24
                com.actionbarsherlock.widget.ActivityChooserModel r0 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x01a6 }
                r21 = r0
                android.os.Handler r21 = r21.mHandler     // Catch:{ all -> 0x01a6 }
                com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader$1 r23 = new com.actionbarsherlock.widget.ActivityChooserModel$HistoryLoader$1     // Catch:{ all -> 0x01a6 }
                r23.<init>()     // Catch:{ all -> 0x01a6 }
                r0 = r21
                r1 = r23
                r0.post(r1)     // Catch:{ all -> 0x01a6 }
                monitor-exit(r22)     // Catch:{ all -> 0x01a6 }
                if (r4 == 0) goto L_0x0076
                r4.close()     // Catch:{ IOException -> 0x01a3 }
                goto L_0x0076
            L_0x01a3:
                r21 = move-exception
                goto L_0x0076
            L_0x01a6:
                r21 = move-exception
                monitor-exit(r22)     // Catch:{ all -> 0x01a6 }
                throw r21     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x00f0 }
            L_0x01a9:
                r21 = move-exception
                goto L_0x0076
            L_0x01ac:
                r22 = move-exception
                goto L_0x015e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.HistoryLoader.run():void");
        }
    }

    private final class HistoryPersister implements Runnable {
        private HistoryPersister() {
        }

        /* synthetic */ HistoryPersister(ActivityChooserModel activityChooserModel, HistoryPersister historyPersister) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r10.setOutput(r1, (java.lang.String) null);
            r10.startDocument("UTF-8", true);
            r10.startTag((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.TAG_HISTORICAL_RECORDS);
            r7 = r9.size();
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
            if (r2 < r7) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
            r10.endTag((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.TAG_HISTORICAL_RECORDS);
            r10.endDocument();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
            android.util.Log.e(com.actionbarsherlock.widget.ActivityChooserModel.access$8(), "Error writing historical recrod file: " + com.actionbarsherlock.widget.ActivityChooserModel.access$1(r15.this$0), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r6 = (com.actionbarsherlock.widget.ActivityChooserModel.HistoricalRecord) r9.remove(0);
            r10.startTag((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.TAG_HISTORICAL_RECORD);
            r10.attribute((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.ATTRIBUTE_ACTIVITY, r6.activity.flattenToString());
            r10.attribute((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.ATTRIBUTE_TIME, java.lang.String.valueOf(r6.time));
            r10.attribute((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.ATTRIBUTE_WEIGHT, java.lang.String.valueOf(r6.weight));
            r10.endTag((java.lang.String) null, com.actionbarsherlock.widget.ActivityChooserModel.TAG_HISTORICAL_RECORD);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ac, code lost:
            r2 = r2 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00af, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            android.util.Log.e(com.actionbarsherlock.widget.ActivityChooserModel.access$8(), "Error writing historical recrod file: " + com.actionbarsherlock.widget.ActivityChooserModel.access$1(r15.this$0), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cc, code lost:
            if (r1 != null) goto L_0x00ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            android.util.Log.e(com.actionbarsherlock.widget.ActivityChooserModel.access$8(), "Error writing historical recrod file: " + com.actionbarsherlock.widget.ActivityChooserModel.access$1(r15.this$0), r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f1, code lost:
            if (r1 != null) goto L_0x00f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fb, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            android.util.Log.e(com.actionbarsherlock.widget.ActivityChooserModel.access$8(), "Error writing historical recrod file: " + com.actionbarsherlock.widget.ActivityChooserModel.access$1(r15.this$0), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0118, code lost:
            if (r1 != null) goto L_0x011a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0122, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0123, code lost:
            if (r1 != null) goto L_0x0125;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0128, code lost:
            throw r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            r1 = com.actionbarsherlock.widget.ActivityChooserModel.access$0(r15.this$0).openFileOutput(com.actionbarsherlock.widget.ActivityChooserModel.access$1(r15.this$0), 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
            r10 = android.util.Xml.newSerializer();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                r1 = 0
                r8 = 0
                com.actionbarsherlock.widget.ActivityChooserModel r11 = com.actionbarsherlock.widget.ActivityChooserModel.this
                java.lang.Object r12 = r11.mInstanceLock
                monitor-enter(r12)
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
                com.actionbarsherlock.widget.ActivityChooserModel r11 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0054 }
                java.util.List r11 = r11.mHistoricalRecords     // Catch:{ all -> 0x0054 }
                r9.<init>(r11)     // Catch:{ all -> 0x0054 }
                monitor-exit(r12)     // Catch:{ all -> 0x012e }
                com.actionbarsherlock.widget.ActivityChooserModel r11 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x0057 }
                android.content.Context r11 = r11.mContext     // Catch:{ FileNotFoundException -> 0x0057 }
                com.actionbarsherlock.widget.ActivityChooserModel r12 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x0057 }
                java.lang.String r12 = r12.mHistoryFileName     // Catch:{ FileNotFoundException -> 0x0057 }
                r13 = 0
                java.io.FileOutputStream r1 = r11.openFileOutput(r12, r13)     // Catch:{ FileNotFoundException -> 0x0057 }
                org.xmlpull.v1.XmlSerializer r10 = android.util.Xml.newSerializer()
                r11 = 0
                r10.setOutput(r1, r11)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                java.lang.String r11 = "UTF-8"
                r12 = 1
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r10.startDocument(r11, r12)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r11 = 0
                java.lang.String r12 = "historical-records"
                r10.startTag(r11, r12)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                int r7 = r9.size()     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r2 = 0
            L_0x0043:
                if (r2 < r7) goto L_0x0075
                r11 = 0
                java.lang.String r12 = "historical-records"
                r10.endTag(r11, r12)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r10.endDocument()     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                if (r1 == 0) goto L_0x0053
                r1.close()     // Catch:{ IOException -> 0x012b }
            L_0x0053:
                return
            L_0x0054:
                r11 = move-exception
            L_0x0055:
                monitor-exit(r12)     // Catch:{ all -> 0x0054 }
                throw r11
            L_0x0057:
                r0 = move-exception
                java.lang.String r11 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "Error writing historical recrod file: "
                r12.<init>(r13)
                com.actionbarsherlock.widget.ActivityChooserModel r13 = com.actionbarsherlock.widget.ActivityChooserModel.this
                java.lang.String r13 = r13.mHistoryFileName
                java.lang.StringBuilder r12 = r12.append(r13)
                java.lang.String r12 = r12.toString()
                android.util.Log.e(r11, r12, r0)
                goto L_0x0053
            L_0x0075:
                r11 = 0
                java.lang.Object r6 = r9.remove(r11)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                com.actionbarsherlock.widget.ActivityChooserModel$HistoricalRecord r6 = (com.actionbarsherlock.widget.ActivityChooserModel.HistoricalRecord) r6     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r11 = 0
                java.lang.String r12 = "historical-record"
                r10.startTag(r11, r12)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r11 = 0
                java.lang.String r12 = "activity"
                android.content.ComponentName r13 = r6.activity     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                java.lang.String r13 = r13.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r10.attribute(r11, r12, r13)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r11 = 0
                java.lang.String r12 = "time"
                long r13 = r6.time     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r10.attribute(r11, r12, r13)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r11 = 0
                java.lang.String r12 = "weight"
                float r13 = r6.weight     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r10.attribute(r11, r12, r13)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                r11 = 0
                java.lang.String r12 = "historical-record"
                r10.endTag(r11, r12)     // Catch:{ IllegalArgumentException -> 0x00af, IllegalStateException -> 0x00d4, IOException -> 0x00fb }
                int r2 = r2 + 1
                goto L_0x0043
            L_0x00af:
                r3 = move-exception
                java.lang.String r11 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = "Error writing historical recrod file: "
                r12.<init>(r13)     // Catch:{ all -> 0x0122 }
                com.actionbarsherlock.widget.ActivityChooserModel r13 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = r13.mHistoryFileName     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x0122 }
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0122 }
                android.util.Log.e(r11, r12, r3)     // Catch:{ all -> 0x0122 }
                if (r1 == 0) goto L_0x0053
                r1.close()     // Catch:{ IOException -> 0x00d2 }
                goto L_0x0053
            L_0x00d2:
                r11 = move-exception
                goto L_0x0053
            L_0x00d4:
                r5 = move-exception
                java.lang.String r11 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = "Error writing historical recrod file: "
                r12.<init>(r13)     // Catch:{ all -> 0x0122 }
                com.actionbarsherlock.widget.ActivityChooserModel r13 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = r13.mHistoryFileName     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x0122 }
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0122 }
                android.util.Log.e(r11, r12, r5)     // Catch:{ all -> 0x0122 }
                if (r1 == 0) goto L_0x0053
                r1.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x0053
            L_0x00f8:
                r11 = move-exception
                goto L_0x0053
            L_0x00fb:
                r4 = move-exception
                java.lang.String r11 = com.actionbarsherlock.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = "Error writing historical recrod file: "
                r12.<init>(r13)     // Catch:{ all -> 0x0122 }
                com.actionbarsherlock.widget.ActivityChooserModel r13 = com.actionbarsherlock.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = r13.mHistoryFileName     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x0122 }
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0122 }
                android.util.Log.e(r11, r12, r4)     // Catch:{ all -> 0x0122 }
                if (r1 == 0) goto L_0x0053
                r1.close()     // Catch:{ IOException -> 0x011f }
                goto L_0x0053
            L_0x011f:
                r11 = move-exception
                goto L_0x0053
            L_0x0122:
                r11 = move-exception
                if (r1 == 0) goto L_0x0128
                r1.close()     // Catch:{ IOException -> 0x0129 }
            L_0x0128:
                throw r11
            L_0x0129:
                r12 = move-exception
                goto L_0x0128
            L_0x012b:
                r11 = move-exception
                goto L_0x0053
            L_0x012e:
                r11 = move-exception
                r8 = r9
                goto L_0x0055
            */
            throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.widget.ActivityChooserModel.HistoryPersister.run():void");
        }
    }
}
