package android.support.p004v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.p001v4.internal.view.SupportMenu;
import android.support.p001v4.view.ActionProvider;
import android.support.p001v4.view.MenuItemCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.MenuItemImpl;
import android.support.p004v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.view.SupportMenuInflater */
public class SupportMenuInflater extends MenuInflater {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Class<?>[] f1648a = {Context.class};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Class<?>[] f1649b = f1648a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object[] f1650c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object[] f1651d = this.f1650c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f1652e;

    /* renamed from: f */
    private Object f1653f;

    public SupportMenuInflater(Context context) {
        super(context);
        this.f1652e = context;
        this.f1650c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f1652e.getResources().getLayout(i);
            m2998a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2998a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            r4 = 0
            r1 = 1
            r6 = 0
            android.support.v7.view.SupportMenuInflater$b r7 = new android.support.v7.view.SupportMenuInflater$b
            r7.<init>(r13)
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
            r7.mo3523a((android.util.AttributeSet) r12)
            r3 = r5
            goto L_0x0029
        L_0x0066:
            java.lang.String r8 = "item"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0073
            r7.mo3525b(r12)
            r3 = r5
            goto L_0x0029
        L_0x0073:
            java.lang.String r8 = "menu"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0084
            android.view.SubMenu r3 = r7.mo3526c()
            r10.m2998a(r11, r12, r3)
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
            r7.mo3522a()
            r3 = r5
            goto L_0x0029
        L_0x00a3:
            java.lang.String r8 = "item"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x00cd
            boolean r3 = r7.mo3527d()
            if (r3 != 0) goto L_0x0028
            android.support.v4.view.ActionProvider r3 = r7.f1682z
            if (r3 == 0) goto L_0x00c7
            android.support.v4.view.ActionProvider r3 = r7.f1682z
            boolean r3 = r3.hasSubMenu()
            if (r3 == 0) goto L_0x00c7
            r7.mo3526c()
            r3 = r5
            goto L_0x0029
        L_0x00c7:
            r7.mo3524b()
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p004v7.view.SupportMenuInflater.m2998a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Object m3002c() {
        if (this.f1653f == null) {
            this.f1653f = m2997a((Object) this.f1652e);
        }
        return this.f1653f;
    }

    /* renamed from: a */
    private Object m2997a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m2997a((Object) ((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* renamed from: android.support.v7.view.SupportMenuInflater$a */
    static class C0508a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f1654a = {MenuItem.class};

        /* renamed from: b */
        private Object f1655b;

        /* renamed from: c */
        private Method f1656c;

        public C0508a(Object obj, String str) {
            this.f1655b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1656c = cls.getMethod(str, f1654a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1656c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1656c.invoke(this.f1655b, new Object[]{menuItem})).booleanValue();
                }
                this.f1656c.invoke(this.f1655b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: android.support.v7.view.SupportMenuInflater$b */
    class C0509b {

        /* renamed from: b */
        private Menu f1658b;

        /* renamed from: c */
        private int f1659c;

        /* renamed from: d */
        private int f1660d;

        /* renamed from: e */
        private int f1661e;

        /* renamed from: f */
        private int f1662f;

        /* renamed from: g */
        private boolean f1663g;

        /* renamed from: h */
        private boolean f1664h;

        /* renamed from: i */
        private boolean f1665i;

        /* renamed from: j */
        private int f1666j;

        /* renamed from: k */
        private int f1667k;

        /* renamed from: l */
        private CharSequence f1668l;

        /* renamed from: m */
        private CharSequence f1669m;

        /* renamed from: n */
        private int f1670n;

        /* renamed from: o */
        private char f1671o;

        /* renamed from: p */
        private char f1672p;

        /* renamed from: q */
        private int f1673q;

        /* renamed from: r */
        private boolean f1674r;

        /* renamed from: s */
        private boolean f1675s;

        /* renamed from: t */
        private boolean f1676t;

        /* renamed from: u */
        private int f1677u;

        /* renamed from: v */
        private int f1678v;

        /* renamed from: w */
        private String f1679w;

        /* renamed from: x */
        private String f1680x;

        /* renamed from: y */
        private String f1681y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public ActionProvider f1682z;

        public C0509b(Menu menu) {
            this.f1658b = menu;
            mo3522a();
        }

        /* renamed from: a */
        public void mo3522a() {
            this.f1659c = 0;
            this.f1660d = 0;
            this.f1661e = 0;
            this.f1662f = 0;
            this.f1663g = true;
            this.f1664h = true;
        }

        /* renamed from: a */
        public void mo3523a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f1652e.obtainStyledAttributes(attributeSet, C0505R.styleable.MenuGroup);
            this.f1659c = obtainStyledAttributes.getResourceId(C0505R.styleable.MenuGroup_android_id, 0);
            this.f1660d = obtainStyledAttributes.getInt(C0505R.styleable.MenuGroup_android_menuCategory, 0);
            this.f1661e = obtainStyledAttributes.getInt(C0505R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f1662f = obtainStyledAttributes.getInt(C0505R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1663g = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuGroup_android_visible, true);
            this.f1664h = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void mo3525b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f1652e.obtainStyledAttributes(attributeSet, C0505R.styleable.MenuItem);
            this.f1666j = obtainStyledAttributes.getResourceId(C0505R.styleable.MenuItem_android_id, 0);
            this.f1667k = (obtainStyledAttributes.getInt(C0505R.styleable.MenuItem_android_menuCategory, this.f1660d) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(C0505R.styleable.MenuItem_android_orderInCategory, this.f1661e) & SupportMenu.USER_MASK);
            this.f1668l = obtainStyledAttributes.getText(C0505R.styleable.MenuItem_android_title);
            this.f1669m = obtainStyledAttributes.getText(C0505R.styleable.MenuItem_android_titleCondensed);
            this.f1670n = obtainStyledAttributes.getResourceId(C0505R.styleable.MenuItem_android_icon, 0);
            this.f1671o = m3005a(obtainStyledAttributes.getString(C0505R.styleable.MenuItem_android_alphabeticShortcut));
            this.f1672p = m3005a(obtainStyledAttributes.getString(C0505R.styleable.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0505R.styleable.MenuItem_android_checkable)) {
                this.f1673q = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1673q = this.f1662f;
            }
            this.f1674r = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuItem_android_checked, false);
            this.f1675s = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuItem_android_visible, this.f1663g);
            this.f1676t = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuItem_android_enabled, this.f1664h);
            this.f1677u = obtainStyledAttributes.getInt(C0505R.styleable.MenuItem_showAsAction, -1);
            this.f1681y = obtainStyledAttributes.getString(C0505R.styleable.MenuItem_android_onClick);
            this.f1678v = obtainStyledAttributes.getResourceId(C0505R.styleable.MenuItem_actionLayout, 0);
            this.f1679w = obtainStyledAttributes.getString(C0505R.styleable.MenuItem_actionViewClass);
            this.f1680x = obtainStyledAttributes.getString(C0505R.styleable.MenuItem_actionProviderClass);
            if (this.f1680x == null) {
                z = false;
            }
            if (z && this.f1678v == 0 && this.f1679w == null) {
                this.f1682z = (ActionProvider) m3007a(this.f1680x, SupportMenuInflater.f1649b, SupportMenuInflater.this.f1651d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1682z = null;
            }
            obtainStyledAttributes.recycle();
            this.f1665i = false;
        }

        /* renamed from: a */
        private char m3005a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private void m3008a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1674r).setVisible(this.f1675s).setEnabled(this.f1676t).setCheckable(this.f1673q >= 1).setTitleCondensed(this.f1669m).setIcon(this.f1670n).setAlphabeticShortcut(this.f1671o).setNumericShortcut(this.f1672p);
            if (this.f1677u >= 0) {
                MenuItemCompat.setShowAsAction(menuItem, this.f1677u);
            }
            if (this.f1681y != null) {
                if (SupportMenuInflater.this.f1652e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0508a(SupportMenuInflater.this.m3002c(), this.f1681y));
            }
            if (menuItem instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            }
            if (this.f1673q >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            if (this.f1679w != null) {
                MenuItemCompat.setActionView(menuItem, (View) m3007a(this.f1679w, SupportMenuInflater.f1648a, SupportMenuInflater.this.f1650c));
            } else {
                z = false;
            }
            if (this.f1678v > 0) {
                if (!z) {
                    MenuItemCompat.setActionView(menuItem, this.f1678v);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f1682z != null) {
                MenuItemCompat.setActionProvider(menuItem, this.f1682z);
            }
        }

        /* renamed from: b */
        public void mo3524b() {
            this.f1665i = true;
            m3008a(this.f1658b.add(this.f1659c, this.f1666j, this.f1667k, this.f1668l));
        }

        /* renamed from: c */
        public SubMenu mo3526c() {
            this.f1665i = true;
            SubMenu addSubMenu = this.f1658b.addSubMenu(this.f1659c, this.f1666j, this.f1667k, this.f1668l);
            m3008a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean mo3527d() {
            return this.f1665i;
        }

        /* renamed from: a */
        private <T> T m3007a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.f1652e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
