package p052pt.lumberapps.frases;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: pt.lumberapps.frases.a */
public class C2020a {

    /* renamed from: c */
    public static ArrayList f7666c;

    /* renamed from: d */
    public static ArrayList f7667d;

    /* renamed from: e */
    public static ArrayList f7668e;

    /* renamed from: f */
    public static ArrayList f7669f;

    /* renamed from: g */
    public static ArrayList f7670g;

    /* renamed from: h */
    public static ArrayList f7671h;

    /* renamed from: i */
    private static int f7672i = 0;

    /* renamed from: a */
    Resources f7673a;

    /* renamed from: b */
    String f7674b = "portugues";

    public C2020a(Context context) {
        if (f7671h == null) {
            try {
                mo10150a(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f7673a = context.getResources();
        this.f7674b = new C2056h(context).mo10202a(context);
        if (f7667d == null) {
            mo10151a(this.f7673a);
        }
    }

    /* renamed from: a */
    public static void m8290a(C2038ar arVar) {
        f7667d.add(0, arVar);
    }

    /* renamed from: b */
    public static int m8291b() {
        return f7667d.size() - 1;
    }

    /* renamed from: a */
    public String mo10148a(int i) {
        return ((C2038ar) f7667d.get(i)).mo10181b();
    }

    /* renamed from: a */
    public void mo10149a() {
        if (f7667d == null) {
            mo10151a(this.f7673a);
        }
    }

    /* renamed from: a */
    public void mo10150a(Context context) {
        f7671h = new C2055g(context).mo10196a();
        if (f7671h.size() == 0) {
            throw new Exception("Sem favoritos");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01cb, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01d1, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01d7, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01da, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d6 A[ExcHandler: all (r0v13 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x003c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10151a(android.content.res.Resources r10) {
        /*
            r9 = this;
            r4 = 0
            r0 = 0
            java.lang.String r1 = r9.f7674b
            java.lang.String r2 = "port"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x0075
            r0 = 2131034117(0x7f050005, float:1.7678742E38)
            android.content.res.XmlResourceParser r0 = r10.getXml(r0)
            r2 = r0
        L_0x0014:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            f7668e = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            f7666c = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            f7669f = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            f7670g = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            f7667d = r0
            java.lang.String r0 = r9.f7674b
            p052pt.lumberapps.frases.C2049bb.m8326b(r0)
            java.lang.String r0 = r9.f7674b     // Catch:{ IOException -> 0x01ca, XmlPullParserException -> 0x01d0, all -> 0x01d6 }
            java.lang.String r1 = "ingles"
            boolean r5 = r0.contains(r1)     // Catch:{ IOException -> 0x01ca, XmlPullParserException -> 0x01d0, all -> 0x01d6 }
            int r0 = r2.getEventType()     // Catch:{ IOException -> 0x01ca, XmlPullParserException -> 0x01d0, all -> 0x01d6 }
            r3 = r4
        L_0x0049:
            r1 = 1
            if (r0 == r1) goto L_0x01a4
            r1 = 2
            if (r0 != r1) goto L_0x0129
            java.lang.String r0 = r2.getName()     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "frase"
            boolean r0 = r0.equals(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x0129
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r6.<init>()     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0 = r4
        L_0x0061:
            int r1 = r2.getAttributeCount()     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 >= r1) goto L_0x00b0
            java.lang.String r1 = r2.getAttributeName(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r7 = r2.getAttributeValue(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r6.put(r1, r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            int r0 = r0 + 1
            goto L_0x0061
        L_0x0075:
            java.lang.String r1 = r9.f7674b
            java.lang.String r2 = "espa"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x0088
            r0 = 2131034114(0x7f050002, float:1.7678736E38)
            android.content.res.XmlResourceParser r0 = r10.getXml(r0)
            r2 = r0
            goto L_0x0014
        L_0x0088:
            java.lang.String r1 = r9.f7674b
            java.lang.String r2 = "ingl"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x009c
            r0 = 2131034116(0x7f050004, float:1.767874E38)
            android.content.res.XmlResourceParser r0 = r10.getXml(r0)
            r2 = r0
            goto L_0x0014
        L_0x009c:
            java.lang.String r1 = r9.f7674b
            java.lang.String r2 = "fran"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x01e1
            r0 = 2131034115(0x7f050003, float:1.7678738E38)
            android.content.res.XmlResourceParser r0 = r10.getXml(r0)
            r2 = r0
            goto L_0x0014
        L_0x00b0:
            pt.lumberapps.frases.ar r7 = new pt.lumberapps.frases.ar     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = "id"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "fr"
            java.lang.Object r1 = r6.get(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r8 = p052pt.lumberapps.frases.outros.C2068e.m8360a(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "aut"
            java.lang.Object r1 = r6.get(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r7.<init>(r0, r8, r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r5 == 0) goto L_0x012f
            java.lang.String r0 = "id"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "pensamento"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x00e8
            java.util.ArrayList r0 = f7668e     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x00e8:
            java.lang.String r0 = "id"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "amor"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x00fd
            java.util.ArrayList r0 = f7666c     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x00fd:
            java.lang.String r0 = "id"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "proverbio"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x0112
            java.util.ArrayList r0 = f7669f     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x0112:
            java.lang.String r0 = "id"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "amizade"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x0127
            java.util.ArrayList r0 = f7670g     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x0127:
            int r3 = r3 + 1
        L_0x0129:
            int r0 = r2.next()     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            goto L_0x0049
        L_0x012f:
            java.lang.String r0 = "tema"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "pensamento"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = "tema"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r8 = "biblia"
            boolean r0 = r0.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0 = r0 | r1
            if (r0 == 0) goto L_0x0153
            java.util.ArrayList r0 = f7668e     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x0153:
            java.lang.String r0 = "tema"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "amor"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = "tema"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r8 = "mae"
            boolean r0 = r0.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0 = r0 | r1
            if (r0 == 0) goto L_0x0177
            java.util.ArrayList r0 = f7666c     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x0177:
            java.lang.String r0 = "tema"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "proverbio"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x018c
            java.util.ArrayList r0 = f7669f     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x018c:
            java.lang.String r0 = "tema"
            java.lang.Object r0 = r6.get(r0)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            java.lang.String r1 = "amizade"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            if (r0 == 0) goto L_0x01a1
            java.util.ArrayList r0 = f7670g     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
            r0.add(r7)     // Catch:{ IOException -> 0x01de, XmlPullParserException -> 0x01db, all -> 0x01d6 }
        L_0x01a1:
            int r3 = r3 + 1
            goto L_0x0129
        L_0x01a4:
            r2.close()
            r0 = r3
        L_0x01a8:
            java.lang.String r1 = "Chama ktos loops"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            android.util.Log.i(r1, r0)
            java.util.ArrayList r0 = f7670g
            java.util.Collections.shuffle(r0)
            java.util.ArrayList r0 = f7669f
            java.util.Collections.shuffle(r0)
            java.util.ArrayList r0 = f7666c
            java.util.Collections.shuffle(r0)
            java.util.ArrayList r0 = f7668e
            java.util.Collections.shuffle(r0)
            java.util.ArrayList r0 = f7668e
            f7667d = r0
            return
        L_0x01ca:
            r0 = move-exception
            r0 = r4
        L_0x01cc:
            r2.close()
            goto L_0x01a8
        L_0x01d0:
            r0 = move-exception
            r0 = r4
        L_0x01d2:
            r2.close()
            goto L_0x01a8
        L_0x01d6:
            r0 = move-exception
            r2.close()
            throw r0
        L_0x01db:
            r0 = move-exception
            r0 = r3
            goto L_0x01d2
        L_0x01de:
            r0 = move-exception
            r0 = r3
            goto L_0x01cc
        L_0x01e1:
            r2 = r0
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: p052pt.lumberapps.frases.C2020a.mo10151a(android.content.res.Resources):void");
    }

    /* renamed from: b */
    public String mo10152b(int i) {
        return ((C2038ar) f7667d.get(i)).mo10179a();
    }

    /* renamed from: c */
    public C2038ar mo10153c(int i) {
        return (C2038ar) f7667d.get(i);
    }

    /* renamed from: c */
    public void mo10154c() {
        f7670g.clear();
        f7669f.clear();
        f7666c.clear();
        f7668e.clear();
        f7667d.clear();
        f7667d = null;
    }

    /* renamed from: d */
    public void mo10155d(int i) {
        switch (i) {
            case 0:
                f7667d = f7668e;
                return;
            case 1:
                f7667d = f7666c;
                return;
            case 2:
                f7667d = f7670g;
                return;
            case 3:
                f7667d = f7669f;
                return;
            case 4:
                f7667d.clear();
                f7667d.addAll(f7668e);
                f7667d.addAll(f7666c);
                f7667d.addAll(f7670g);
                f7667d.addAll(f7669f);
                Collections.shuffle(f7667d);
                return;
            case 5:
                f7667d = f7671h;
                return;
            default:
                return;
        }
    }
}
