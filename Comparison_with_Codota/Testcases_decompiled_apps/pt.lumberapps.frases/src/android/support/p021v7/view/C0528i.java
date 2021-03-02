package android.support.p021v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.p009v4.p014c.p015a.C0123a;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.view.i */
public class C0528i extends MenuInflater {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Class[] f912a = {Context.class};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Class[] f913b = f912a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object[] f914c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object[] f915d = this.f914c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f916e;

    /* renamed from: f */
    private Object f917f;

    public C0528i(Context context) {
        super(context);
        this.f916e = context;
        this.f914c = new Object[]{context};
    }

    /* renamed from: a */
    private Object m2234a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m2234a((Object) ((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2235a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
            r10 = this;
            r4 = 0
            r1 = 1
            r6 = 0
            android.support.v7.view.k r7 = new android.support.v7.view.k
            r7.<init>(r10, r13)
            int r0 = r11.getEventType()
        L_0x000c:
            r2 = 2
            if (r0 != r2) goto L_0x004a
            java.lang.String r0 = r11.getName()
            java.lang.String r2 = "menu"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0031
            int r0 = r11.next()
        L_0x001f:
            r2 = r4
            r5 = r6
            r3 = r0
            r0 = r6
        L_0x0023:
            if (r0 != 0) goto L_0x00e1
            switch(r3) {
                case 1: goto L_0x00d9;
                case 2: goto L_0x0051;
                case 3: goto L_0x0087;
                default: goto L_0x0028;
            }
        L_0x0028:
            r3 = r5
        L_0x0029:
            int r5 = r11.next()
            r9 = r3
            r3 = r5
            r5 = r9
            goto L_0x0023
        L_0x0031:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expecting menu, got "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x004a:
            int r0 = r11.next()
            if (r0 != r1) goto L_0x000c
            goto L_0x001f
        L_0x0051:
            if (r5 == 0) goto L_0x0055
            r3 = r5
            goto L_0x0029
        L_0x0055:
            java.lang.String r3 = r11.getName()
            java.lang.String r8 = "group"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0066
            r7.mo2225a((android.util.AttributeSet) r12)
            r3 = r5
            goto L_0x0029
        L_0x0066:
            java.lang.String r8 = "item"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0073
            r7.mo2227b(r12)
            r3 = r5
            goto L_0x0029
        L_0x0073:
            java.lang.String r8 = "menu"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0084
            android.view.SubMenu r3 = r7.mo2228c()
            r10.m2235a(r11, r12, r3)
            r3 = r5
            goto L_0x0029
        L_0x0084:
            r2 = r3
            r3 = r1
            goto L_0x0029
        L_0x0087:
            java.lang.String r3 = r11.getName()
            if (r5 == 0) goto L_0x0096
            boolean r8 = r3.equals(r2)
            if (r8 == 0) goto L_0x0096
            r2 = r4
            r3 = r6
            goto L_0x0029
        L_0x0096:
            java.lang.String r8 = "group"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x00a3
            r7.mo2224a()
            r3 = r5
            goto L_0x0029
        L_0x00a3:
            java.lang.String r8 = "item"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x00cd
            boolean r3 = r7.mo2229d()
            if (r3 != 0) goto L_0x0028
            android.support.v4.view.n r3 = r7.f946z
            if (r3 == 0) goto L_0x00c7
            android.support.v4.view.n r3 = r7.f946z
            boolean r3 = r3.mo1624e()
            if (r3 == 0) goto L_0x00c7
            r7.mo2228c()
            r3 = r5
            goto L_0x0029
        L_0x00c7:
            r7.mo2226b()
            r3 = r5
            goto L_0x0029
        L_0x00cd:
            java.lang.String r8 = "menu"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x0028
            r0 = r1
            r3 = r5
            goto L_0x0029
        L_0x00d9:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Unexpected end of document"
            r0.<init>(r1)
            throw r0
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.view.C0528i.m2235a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Object m2239c() {
        if (this.f917f == null) {
            this.f917f = m2234a((Object) this.f916e);
        }
        return this.f917f;
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof C0123a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f916e.getResources().getLayout(i);
            m2235a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
