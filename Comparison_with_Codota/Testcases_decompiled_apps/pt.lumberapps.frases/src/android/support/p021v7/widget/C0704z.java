package android.support.p021v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.p009v4.p018e.C0128a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.widget.z */
class C0704z extends DataSetObservable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f1727a = C0704z.class.getSimpleName();

    /* renamed from: b */
    private static final Object f1728b = new Object();

    /* renamed from: c */
    private static final Map f1729c = new HashMap();

    /* renamed from: d */
    private final Object f1730d;

    /* renamed from: e */
    private final List f1731e;

    /* renamed from: f */
    private final List f1732f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Context f1733g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f1734h;

    /* renamed from: i */
    private Intent f1735i;

    /* renamed from: j */
    private C0578ac f1736j;

    /* renamed from: k */
    private int f1737k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f1738l;

    /* renamed from: m */
    private boolean f1739m;

    /* renamed from: n */
    private boolean f1740n;

    /* renamed from: o */
    private boolean f1741o;

    /* renamed from: p */
    private C0580ae f1742p;

    /* renamed from: a */
    private boolean m3157a(C0579ad adVar) {
        boolean add = this.f1732f.add(adVar);
        if (add) {
            this.f1740n = true;
            m3166i();
            m3161d();
            m3163f();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: d */
    private void m3161d() {
        if (!this.f1739m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1740n) {
            this.f1740n = false;
            if (!TextUtils.isEmpty(this.f1734h)) {
                C0128a.m317a(new C0581af(this), new ArrayList(this.f1732f), this.f1734h);
            }
        }
    }

    /* renamed from: e */
    private void m3162e() {
        boolean g = m3164g() | m3165h();
        m3166i();
        if (g) {
            m3163f();
            notifyChanged();
        }
    }

    /* renamed from: f */
    private boolean m3163f() {
        if (this.f1736j == null || this.f1735i == null || this.f1731e.isEmpty() || this.f1732f.isEmpty()) {
            return false;
        }
        this.f1736j.mo2918a(this.f1735i, this.f1731e, Collections.unmodifiableList(this.f1732f));
        return true;
    }

    /* renamed from: g */
    private boolean m3164g() {
        if (!this.f1741o || this.f1735i == null) {
            return false;
        }
        this.f1741o = false;
        this.f1731e.clear();
        List<ResolveInfo> queryIntentActivities = this.f1733g.getPackageManager().queryIntentActivities(this.f1735i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1731e.add(new C0577ab(this, queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: h */
    private boolean m3165h() {
        if (!this.f1738l || !this.f1740n || TextUtils.isEmpty(this.f1734h)) {
            return false;
        }
        this.f1738l = false;
        this.f1739m = true;
        m3167j();
        return true;
    }

    /* renamed from: i */
    private void m3166i() {
        int size = this.f1732f.size() - this.f1737k;
        if (size > 0) {
            this.f1740n = true;
            for (int i = 0; i < size; i++) {
                C0579ad adVar = (C0579ad) this.f1732f.remove(0);
            }
        }
    }

    /* renamed from: j */
    private void m3167j() {
        try {
            FileInputStream openFileInput = this.f1733g.openFileInput(this.f1734h);
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
                List list = this.f1732f;
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
                        list.add(new C0579ad(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                    }
                }
            } catch (XmlPullParserException e2) {
                Log.e(f1727a, "Error reading historical recrod file: " + this.f1734h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                Log.e(f1727a, "Error reading historical recrod file: " + this.f1734h, e4);
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

    /* renamed from: a */
    public int mo3367a() {
        int size;
        synchronized (this.f1730d) {
            m3162e();
            size = this.f1731e.size();
        }
        return size;
    }

    /* renamed from: a */
    public int mo3368a(ResolveInfo resolveInfo) {
        synchronized (this.f1730d) {
            m3162e();
            List list = this.f1731e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0577ab) list.get(i)).f1356a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public ResolveInfo mo3369a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1730d) {
            m3162e();
            resolveInfo = ((C0577ab) this.f1731e.get(i)).f1356a;
        }
        return resolveInfo;
    }

    /* renamed from: b */
    public Intent mo3370b(int i) {
        synchronized (this.f1730d) {
            if (this.f1735i == null) {
                return null;
            }
            m3162e();
            C0577ab abVar = (C0577ab) this.f1731e.get(i);
            ComponentName componentName = new ComponentName(abVar.f1356a.activityInfo.packageName, abVar.f1356a.activityInfo.name);
            Intent intent = new Intent(this.f1735i);
            intent.setComponent(componentName);
            if (this.f1742p != null) {
                if (this.f1742p.mo2922a(this, new Intent(intent))) {
                    return null;
                }
            }
            m3157a(new C0579ad(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: b */
    public ResolveInfo mo3371b() {
        synchronized (this.f1730d) {
            m3162e();
            if (this.f1731e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0577ab) this.f1731e.get(0)).f1356a;
            return resolveInfo;
        }
    }

    /* renamed from: c */
    public void mo3372c(int i) {
        synchronized (this.f1730d) {
            m3162e();
            C0577ab abVar = (C0577ab) this.f1731e.get(i);
            C0577ab abVar2 = (C0577ab) this.f1731e.get(0);
            m3157a(new C0579ad(new ComponentName(abVar.f1356a.activityInfo.packageName, abVar.f1356a.activityInfo.name), System.currentTimeMillis(), abVar2 != null ? (abVar2.f1357b - abVar.f1357b) + 5.0f : 1.0f));
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.f1730d) {
            if (this.f1735i != intent) {
                this.f1735i = intent;
                this.f1741o = true;
                m3162e();
            }
        }
    }
}
