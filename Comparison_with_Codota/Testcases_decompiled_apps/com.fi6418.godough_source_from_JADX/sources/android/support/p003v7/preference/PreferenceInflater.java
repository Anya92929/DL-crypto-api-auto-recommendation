package android.support.p003v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.preference.PreferenceInflater */
class PreferenceInflater {

    /* renamed from: a */
    private static final Class<?>[] f2502a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final HashMap<String, Constructor> f2503b = new HashMap<>();

    /* renamed from: c */
    private final Context f2504c;

    /* renamed from: d */
    private final Object[] f2505d = new Object[2];

    /* renamed from: e */
    private PreferenceManager f2506e;

    /* renamed from: f */
    private String[] f2507f;

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        this.f2504c = context;
        m1625a(preferenceManager);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        r1 = new android.view.InflateException(r10.getPositionDescription() + ": Error inflating class " + r8);
        r1.initCause(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a1, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:2:0x000b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.p003v7.preference.Preference m1623a(java.lang.String r8, java.lang.String[] r9, android.util.AttributeSet r10) {
        /*
            r7 = this;
            r1 = 0
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> r0 = f2503b
            java.lang.Object r0 = r0.get(r8)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            if (r0 != 0) goto L_0x0029
            android.content.Context r0 = r7.f2504c     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.ClassLoader r3 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            if (r9 == 0) goto L_0x0016
            int r0 = r9.length     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            if (r0 != 0) goto L_0x0035
        L_0x0016:
            java.lang.Class r1 = r3.loadClass(r8)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
        L_0x001a:
            java.lang.Class<?>[] r0 = f2502a     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.reflect.Constructor r0 = r1.getConstructor(r0)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> r1 = f2503b     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            r1.put(r8, r0)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
        L_0x0029:
            java.lang.Object[] r1 = r7.f2505d     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            r2 = 1
            r1[r2] = r10     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            android.support.v7.preference.Preference r0 = (android.support.p003v7.preference.Preference) r0     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            return r0
        L_0x0035:
            int r4 = r9.length     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            r0 = 0
            r2 = r0
            r0 = r1
        L_0x0039:
            if (r2 >= r4) goto L_0x0055
            r5 = r9[r2]     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x00a2, Exception -> 0x007d }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x00a2, Exception -> 0x007d }
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ ClassNotFoundException -> 0x00a2, Exception -> 0x007d }
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ ClassNotFoundException -> 0x00a2, Exception -> 0x007d }
            java.lang.String r5 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x00a2, Exception -> 0x007d }
            java.lang.Class r1 = r3.loadClass(r5)     // Catch:{ ClassNotFoundException -> 0x00a2, Exception -> 0x007d }
        L_0x0052:
            int r2 = r2 + 1
            goto L_0x0039
        L_0x0055:
            if (r1 != 0) goto L_0x001a
            if (r0 != 0) goto L_0x007c
            android.view.InflateException r0 = new android.view.InflateException     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.String r2 = r10.getPositionDescription()     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.String r2 = ": Error inflating class "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
            throw r0     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
        L_0x007a:
            r0 = move-exception
            throw r0
        L_0x007c:
            throw r0     // Catch:{ ClassNotFoundException -> 0x007a, Exception -> 0x007d }
        L_0x007d:
            r0 = move-exception
            android.view.InflateException r1 = new android.view.InflateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r10.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ": Error inflating class "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r1.initCause(r0)
            throw r1
        L_0x00a2:
            r0 = move-exception
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.preference.PreferenceInflater.m1623a(java.lang.String, java.lang.String[], android.util.AttributeSet):android.support.v7.preference.Preference");
    }

    /* renamed from: a */
    private PreferenceGroup m1624a(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.mo4783a(this.f2506e);
        return preferenceGroup2;
    }

    /* renamed from: a */
    private void m1625a(PreferenceManager preferenceManager) {
        this.f2506e = preferenceManager;
        if (Build.VERSION.SDK_INT >= 14) {
            setDefaultPackages(new String[]{"android.support.v14.preference.", "android.support.v7.preference."});
            return;
        }
        setDefaultPackages(new String[]{"android.support.v7.preference."});
    }

    /* renamed from: a */
    private static void m1626a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m1627a(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.setIntent(Intent.parseIntent(getContext().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    getContext().getResources().parseBundleExtra("extra", attributeSet, preference.getExtras());
                    try {
                        m1626a(xmlPullParser);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference b = m1628b(name, attributeSet);
                    ((PreferenceGroup) preference).addItemFromInflater(b);
                    m1627a(xmlPullParser, b, attributeSet);
                }
            }
        }
    }

    /* renamed from: b */
    private Preference m1628b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? mo4903a(str, attributeSet) : m1623a(str, (String[]) null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Preference mo4903a(String str, AttributeSet attributeSet) {
        return m1623a(str, this.f2507f, attributeSet);
    }

    public Context getContext() {
        return this.f2504c;
    }

    public String[] getDefaultPackages() {
        return this.f2507f;
    }

    public Preference inflate(int i, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = getContext().getResources().getXml(i);
        try {
            return inflate((XmlPullParser) xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a A[Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c A[SYNTHETIC, Splitter:B:18:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.support.p003v7.preference.Preference inflate(org.xmlpull.v1.XmlPullParser r7, android.support.p003v7.preference.PreferenceGroup r8) {
        /*
            r6 = this;
            r5 = 2
            java.lang.Object[] r1 = r6.f2505d
            monitor-enter(r1)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r0 = r6.f2505d     // Catch:{ all -> 0x0039 }
            r3 = 0
            android.content.Context r4 = r6.f2504c     // Catch:{ all -> 0x0039 }
            r0[r3] = r4     // Catch:{ all -> 0x0039 }
        L_0x000f:
            int r0 = r7.next()     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            if (r0 == r5) goto L_0x0018
            r3 = 1
            if (r0 != r3) goto L_0x000f
        L_0x0018:
            if (r0 == r5) goto L_0x003c
            android.view.InflateException r0 = new android.view.InflateException     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            r2.<init>()     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            java.lang.String r3 = r7.getPositionDescription()     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            java.lang.String r3 = ": No start tag found!"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            java.lang.String r2 = r2.toString()     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            r0.<init>(r2)     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            throw r0     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
        L_0x0037:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            throw r0
        L_0x003c:
            java.lang.String r0 = r7.getName()     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            android.support.v7.preference.Preference r0 = r6.m1628b(r0, r2)     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            android.support.v7.preference.PreferenceGroup r0 = (android.support.p003v7.preference.PreferenceGroup) r0     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            android.support.v7.preference.PreferenceGroup r0 = r6.m1624a((android.support.p003v7.preference.PreferenceGroup) r8, (android.support.p003v7.preference.PreferenceGroup) r0)     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            r6.m1627a((org.xmlpull.v1.XmlPullParser) r7, (android.support.p003v7.preference.Preference) r0, (android.util.AttributeSet) r2)     // Catch:{ InflateException -> 0x0037, XmlPullParserException -> 0x004f, IOException -> 0x005d }
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            return r0
        L_0x004f:
            r0 = move-exception
            android.view.InflateException r2 = new android.view.InflateException     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0039 }
            r2.<init>(r3)     // Catch:{ all -> 0x0039 }
            r2.initCause(r0)     // Catch:{ all -> 0x0039 }
            throw r2     // Catch:{ all -> 0x0039 }
        L_0x005d:
            r0 = move-exception
            android.view.InflateException r2 = new android.view.InflateException     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = r7.getPositionDescription()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = ": "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0039 }
            r2.<init>(r3)     // Catch:{ all -> 0x0039 }
            r2.initCause(r0)     // Catch:{ all -> 0x0039 }
            throw r2     // Catch:{ all -> 0x0039 }
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.preference.PreferenceInflater.inflate(org.xmlpull.v1.XmlPullParser, android.support.v7.preference.PreferenceGroup):android.support.v7.preference.Preference");
    }

    public void setDefaultPackages(String[] strArr) {
        this.f2507f = strArr;
    }
}
