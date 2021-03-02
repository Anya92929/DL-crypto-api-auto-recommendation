package android.support.p004v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.p001v4.p003os.AsyncTaskCompat;
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
import org.apache.commons.lang3.CharEncoding;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.widget.ActivityChooserModel */
class ActivityChooserModel extends DataSetObservable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f1941a = ActivityChooserModel.class.getSimpleName();

    /* renamed from: b */
    private static final Object f1942b = new Object();

    /* renamed from: c */
    private static final Map<String, ActivityChooserModel> f1943c = new HashMap();

    /* renamed from: d */
    private final Object f1944d = new Object();

    /* renamed from: e */
    private final List<ActivityResolveInfo> f1945e = new ArrayList();

    /* renamed from: f */
    private final List<HistoricalRecord> f1946f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Context f1947g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f1948h;

    /* renamed from: i */
    private Intent f1949i;

    /* renamed from: j */
    private ActivitySorter f1950j = new C0537a();

    /* renamed from: k */
    private int f1951k = 50;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f1952l = true;

    /* renamed from: m */
    private boolean f1953m = false;

    /* renamed from: n */
    private boolean f1954n = true;

    /* renamed from: o */
    private boolean f1955o = false;

    /* renamed from: p */
    private OnChooseActivityListener f1956p;

    /* renamed from: android.support.v7.widget.ActivityChooserModel$ActivityChooserModelClient */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* renamed from: android.support.v7.widget.ActivityChooserModel$ActivitySorter */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* renamed from: android.support.v7.widget.ActivityChooserModel$OnChooseActivityListener */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* renamed from: a */
    public static ActivityChooserModel m3119a(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f1942b) {
            activityChooserModel = f1943c.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                f1943c.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private ActivityChooserModel(Context context, String str) {
        this.f1947g = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f1948h = str;
        } else {
            this.f1948h = str + ".xml";
        }
    }

    /* renamed from: a */
    public void mo4024a(Intent intent) {
        synchronized (this.f1944d) {
            if (this.f1949i != intent) {
                this.f1949i = intent;
                this.f1955o = true;
                m3125f();
            }
        }
    }

    /* renamed from: a */
    public int mo4021a() {
        int size;
        synchronized (this.f1944d) {
            m3125f();
            size = this.f1945e.size();
        }
        return size;
    }

    /* renamed from: a */
    public ResolveInfo mo4023a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1944d) {
            m3125f();
            resolveInfo = this.f1945e.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    /* renamed from: a */
    public int mo4022a(ResolveInfo resolveInfo) {
        synchronized (this.f1944d) {
            m3125f();
            List<ActivityResolveInfo> list = this.f1945e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    public Intent mo4026b(int i) {
        synchronized (this.f1944d) {
            if (this.f1949i == null) {
                return null;
            }
            m3125f();
            ActivityResolveInfo activityResolveInfo = this.f1945e.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.f1949i);
            intent.setComponent(componentName);
            if (this.f1956p != null) {
                if (this.f1956p.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            m3120a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: a */
    public void mo4025a(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.f1944d) {
            this.f1956p = onChooseActivityListener;
        }
    }

    /* renamed from: b */
    public ResolveInfo mo4027b() {
        synchronized (this.f1944d) {
            m3125f();
            if (this.f1945e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f1945e.get(0).resolveInfo;
            return resolveInfo;
        }
    }

    /* renamed from: c */
    public void mo4029c(int i) {
        float f;
        synchronized (this.f1944d) {
            m3125f();
            ActivityResolveInfo activityResolveInfo = this.f1945e.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.f1945e.get(0);
            if (activityResolveInfo2 != null) {
                f = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
            } else {
                f = 1.0f;
            }
            m3120a(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    /* renamed from: e */
    private void m3124e() {
        if (!this.f1953m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1954n) {
            this.f1954n = false;
            if (!TextUtils.isEmpty(this.f1948h)) {
                AsyncTaskCompat.executeParallel(new C0538b(), new ArrayList(this.f1946f), this.f1948h);
            }
        }
    }

    /* renamed from: c */
    public int mo4028c() {
        int size;
        synchronized (this.f1944d) {
            m3125f();
            size = this.f1946f.size();
        }
        return size;
    }

    /* renamed from: f */
    private void m3125f() {
        boolean h = m3127h() | m3128i();
        m3129j();
        if (h) {
            m3126g();
            notifyChanged();
        }
    }

    /* renamed from: g */
    private boolean m3126g() {
        if (this.f1950j == null || this.f1949i == null || this.f1945e.isEmpty() || this.f1946f.isEmpty()) {
            return false;
        }
        this.f1950j.sort(this.f1949i, this.f1945e, Collections.unmodifiableList(this.f1946f));
        return true;
    }

    /* renamed from: h */
    private boolean m3127h() {
        if (!this.f1955o || this.f1949i == null) {
            return false;
        }
        this.f1955o = false;
        this.f1945e.clear();
        List<ResolveInfo> queryIntentActivities = this.f1947g.getPackageManager().queryIntentActivities(this.f1949i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1945e.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: i */
    private boolean m3128i() {
        if (!this.f1952l || !this.f1954n || TextUtils.isEmpty(this.f1948h)) {
            return false;
        }
        this.f1952l = false;
        this.f1953m = true;
        m3130k();
        return true;
    }

    /* renamed from: a */
    private boolean m3120a(HistoricalRecord historicalRecord) {
        boolean add = this.f1946f.add(historicalRecord);
        if (add) {
            this.f1954n = true;
            m3129j();
            m3124e();
            m3126g();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: j */
    private void m3129j() {
        int size = this.f1946f.size() - this.f1951k;
        if (size > 0) {
            this.f1954n = true;
            for (int i = 0; i < size; i++) {
                HistoricalRecord remove = this.f1946f.remove(0);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserModel$HistoricalRecord */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
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
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(historicalRecord.weight)) {
                return false;
            }
            return true;
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

    /* renamed from: android.support.v7.widget.ActivityChooserModel$ActivityResolveInfo */
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
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return false;
            }
            return true;
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
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

    /* renamed from: android.support.v7.widget.ActivityChooserModel$a */
    final class C0537a implements ActivitySorter {

        /* renamed from: b */
        private final Map<ComponentName, ActivityResolveInfo> f1959b;

        private C0537a() {
            this.f1959b = new HashMap();
        }

        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            float f;
            Map<ComponentName, ActivityResolveInfo> map = this.f1959b;
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

    /* renamed from: k */
    private void m3130k() {
        try {
            FileInputStream openFileInput = this.f1947g.openFileInput(this.f1948h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, CharEncoding.UTF_8);
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<HistoricalRecord> list = this.f1946f;
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
                Log.e(f1941a, "Error reading historical recrod file: " + this.f1948h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                Log.e(f1941a, "Error reading historical recrod file: " + this.f1948h, e4);
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

    /* renamed from: android.support.v7.widget.ActivityChooserModel$b */
    final class C0538b extends AsyncTask<Object, Void, Void> {
        private C0538b() {
        }

        /* renamed from: a */
        public Void doInBackground(Object... objArr) {
            List list = objArr[0];
            String str = objArr[1];
            try {
                FileOutputStream openFileOutput = ActivityChooserModel.this.f1947g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, (String) null);
                    newSerializer.startDocument(CharEncoding.UTF_8, true);
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
                    boolean unused = ActivityChooserModel.this.f1952l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    Log.e(ActivityChooserModel.f1941a, "Error writing historical recrod file: " + ActivityChooserModel.this.f1948h, e2);
                    boolean unused2 = ActivityChooserModel.this.f1952l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    Log.e(ActivityChooserModel.f1941a, "Error writing historical recrod file: " + ActivityChooserModel.this.f1948h, e4);
                    boolean unused3 = ActivityChooserModel.this.f1952l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    Log.e(ActivityChooserModel.f1941a, "Error writing historical recrod file: " + ActivityChooserModel.this.f1948h, e6);
                    boolean unused4 = ActivityChooserModel.this.f1952l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    boolean unused5 = ActivityChooserModel.this.f1952l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                Log.e(ActivityChooserModel.f1941a, "Error writing historical recrod file: " + str, e9);
            }
            return null;
        }
    }
}
