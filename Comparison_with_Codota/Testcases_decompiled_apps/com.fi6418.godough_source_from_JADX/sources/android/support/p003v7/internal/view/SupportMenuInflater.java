package android.support.p003v7.internal.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.ActionProvider;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuItemImpl;
import android.support.p003v7.internal.view.menu.MenuItemWrapperICS;
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

/* renamed from: android.support.v7.internal.view.SupportMenuInflater */
public class SupportMenuInflater extends MenuInflater {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Class<?>[] f1989a = {Context.class};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Class<?>[] f1990b = f1989a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object[] f1991c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object[] f1992d = this.f1991c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f1993e;

    /* renamed from: f */
    private Object f1994f;

    /* renamed from: android.support.v7.internal.view.SupportMenuInflater$InflatedOnMenuItemClickListener */
    class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f1995a = {MenuItem.class};

        /* renamed from: b */
        private Object f1996b;

        /* renamed from: c */
        private Method f1997c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f1996b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1997c = cls.getMethod(str, f1995a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1997c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1997c.invoke(this.f1996b, new Object[]{menuItem})).booleanValue();
                }
                this.f1997c.invoke(this.f1996b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: android.support.v7.internal.view.SupportMenuInflater$MenuState */
    class MenuState {

        /* renamed from: b */
        private Menu f1999b;

        /* renamed from: c */
        private int f2000c;

        /* renamed from: d */
        private int f2001d;

        /* renamed from: e */
        private int f2002e;

        /* renamed from: f */
        private int f2003f;

        /* renamed from: g */
        private boolean f2004g;

        /* renamed from: h */
        private boolean f2005h;

        /* renamed from: i */
        private boolean f2006i;

        /* renamed from: j */
        private int f2007j;

        /* renamed from: k */
        private int f2008k;

        /* renamed from: l */
        private CharSequence f2009l;

        /* renamed from: m */
        private CharSequence f2010m;

        /* renamed from: n */
        private int f2011n;

        /* renamed from: o */
        private char f2012o;

        /* renamed from: p */
        private char f2013p;

        /* renamed from: q */
        private int f2014q;

        /* renamed from: r */
        private boolean f2015r;

        /* renamed from: s */
        private boolean f2016s;

        /* renamed from: t */
        private boolean f2017t;

        /* renamed from: u */
        private int f2018u;

        /* renamed from: v */
        private int f2019v;

        /* renamed from: w */
        private String f2020w;

        /* renamed from: x */
        private String f2021x;

        /* renamed from: y */
        private String f2022y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public ActionProvider f2023z;

        public MenuState(Menu menu) {
            this.f1999b = menu;
            resetGroup();
        }

        /* renamed from: a */
        private char m1383a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private <T> T m1385a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.f1993e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* renamed from: a */
        private void m1386a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f2015r).setVisible(this.f2016s).setEnabled(this.f2017t).setCheckable(this.f2014q >= 1).setTitleCondensed(this.f2010m).setIcon(this.f2011n).setAlphabeticShortcut(this.f2012o).setNumericShortcut(this.f2013p);
            if (this.f2018u >= 0) {
                MenuItemCompat.setShowAsAction(menuItem, this.f2018u);
            }
            if (this.f2022y != null) {
                if (SupportMenuInflater.this.f1993e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.m1380c(), this.f2022y));
            }
            if (menuItem instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            }
            if (this.f2014q >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            if (this.f2020w != null) {
                MenuItemCompat.setActionView(menuItem, (View) m1385a(this.f2020w, SupportMenuInflater.f1989a, SupportMenuInflater.this.f1991c));
            } else {
                z = false;
            }
            if (this.f2019v > 0) {
                if (!z) {
                    MenuItemCompat.setActionView(menuItem, this.f2019v);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f2023z != null) {
                MenuItemCompat.setActionProvider(menuItem, this.f2023z);
            }
        }

        public void addItem() {
            this.f2006i = true;
            m1386a(this.f1999b.add(this.f2000c, this.f2007j, this.f2008k, this.f2009l));
        }

        public SubMenu addSubMenuItem() {
            this.f2006i = true;
            SubMenu addSubMenu = this.f1999b.addSubMenu(this.f2000c, this.f2007j, this.f2008k, this.f2009l);
            m1386a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.f2006i;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f1993e.obtainStyledAttributes(attributeSet, C0235R.styleable.MenuGroup);
            this.f2000c = obtainStyledAttributes.getResourceId(C0235R.styleable.MenuGroup_android_id, 0);
            this.f2001d = obtainStyledAttributes.getInt(C0235R.styleable.MenuGroup_android_menuCategory, 0);
            this.f2002e = obtainStyledAttributes.getInt(C0235R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f2003f = obtainStyledAttributes.getInt(C0235R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f2004g = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuGroup_android_visible, true);
            this.f2005h = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f1993e.obtainStyledAttributes(attributeSet, C0235R.styleable.MenuItem);
            this.f2007j = obtainStyledAttributes.getResourceId(C0235R.styleable.MenuItem_android_id, 0);
            this.f2008k = (obtainStyledAttributes.getInt(C0235R.styleable.MenuItem_android_menuCategory, this.f2001d) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(C0235R.styleable.MenuItem_android_orderInCategory, this.f2002e) & SupportMenu.USER_MASK);
            this.f2009l = obtainStyledAttributes.getText(C0235R.styleable.MenuItem_android_title);
            this.f2010m = obtainStyledAttributes.getText(C0235R.styleable.MenuItem_android_titleCondensed);
            this.f2011n = obtainStyledAttributes.getResourceId(C0235R.styleable.MenuItem_android_icon, 0);
            this.f2012o = m1383a(obtainStyledAttributes.getString(C0235R.styleable.MenuItem_android_alphabeticShortcut));
            this.f2013p = m1383a(obtainStyledAttributes.getString(C0235R.styleable.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0235R.styleable.MenuItem_android_checkable)) {
                this.f2014q = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f2014q = this.f2003f;
            }
            this.f2015r = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuItem_android_checked, false);
            this.f2016s = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuItem_android_visible, this.f2004g);
            this.f2017t = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuItem_android_enabled, this.f2005h);
            this.f2018u = obtainStyledAttributes.getInt(C0235R.styleable.MenuItem_showAsAction, -1);
            this.f2022y = obtainStyledAttributes.getString(C0235R.styleable.MenuItem_android_onClick);
            this.f2019v = obtainStyledAttributes.getResourceId(C0235R.styleable.MenuItem_actionLayout, 0);
            this.f2020w = obtainStyledAttributes.getString(C0235R.styleable.MenuItem_actionViewClass);
            this.f2021x = obtainStyledAttributes.getString(C0235R.styleable.MenuItem_actionProviderClass);
            if (this.f2021x == null) {
                z = false;
            }
            if (z && this.f2019v == 0 && this.f2020w == null) {
                this.f2023z = (ActionProvider) m1385a(this.f2021x, SupportMenuInflater.f1990b, SupportMenuInflater.this.f1992d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f2023z = null;
            }
            obtainStyledAttributes.recycle();
            this.f2006i = false;
        }

        public void resetGroup() {
            this.f2000c = 0;
            this.f2001d = 0;
            this.f2002e = 0;
            this.f2003f = 0;
            this.f2004g = true;
            this.f2005h = true;
        }
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f1993e = context;
        this.f1991c = new Object[]{context};
    }

    /* renamed from: a */
    private Object m1375a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m1375a((Object) ((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1376a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
            r10 = this;
            r4 = 0
            r1 = 1
            r6 = 0
            android.support.v7.internal.view.SupportMenuInflater$MenuState r7 = new android.support.v7.internal.view.SupportMenuInflater$MenuState
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
            r7.readGroup(r12)
            r3 = r5
            goto L_0x0029
        L_0x0066:
            java.lang.String r8 = "item"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0073
            r7.readItem(r12)
            r3 = r5
            goto L_0x0029
        L_0x0073:
            java.lang.String r8 = "menu"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x0084
            android.view.SubMenu r3 = r7.addSubMenuItem()
            r10.m1376a(r11, r12, r3)
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
            r7.resetGroup()
            r3 = r5
            goto L_0x0029
        L_0x00a3:
            java.lang.String r8 = "item"
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x00cd
            boolean r3 = r7.hasAddedItem()
            if (r3 != 0) goto L_0x0028
            android.support.v4.view.ActionProvider r3 = r7.f2023z
            if (r3 == 0) goto L_0x00c7
            android.support.v4.view.ActionProvider r3 = r7.f2023z
            boolean r3 = r3.hasSubMenu()
            if (r3 == 0) goto L_0x00c7
            r7.addSubMenuItem()
            r3 = r5
            goto L_0x0029
        L_0x00c7:
            r7.addItem()
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.view.SupportMenuInflater.m1376a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Object m1380c() {
        if (this.f1994f == null) {
            this.f1994f = m1375a((Object) this.f1993e);
        }
        return this.f1994f;
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f1993e.getResources().getLayout(i);
            m1376a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
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
