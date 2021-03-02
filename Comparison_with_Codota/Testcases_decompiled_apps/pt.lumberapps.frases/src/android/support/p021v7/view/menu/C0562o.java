package android.support.p021v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.p014c.p015a.C0123a;
import android.support.p009v4.view.C0214as;
import android.support.p009v4.view.C0344n;
import android.support.p021v7.p023b.C0507c;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.view.menu.o */
public class C0562o implements C0123a {

    /* renamed from: d */
    private static final int[] f1103d = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    CharSequence f1104a;

    /* renamed from: b */
    Drawable f1105b;

    /* renamed from: c */
    View f1106c;

    /* renamed from: e */
    private final Context f1107e;

    /* renamed from: f */
    private final Resources f1108f;

    /* renamed from: g */
    private final boolean f1109g;

    /* renamed from: h */
    private boolean f1110h;

    /* renamed from: i */
    private boolean f1111i;

    /* renamed from: j */
    private C0563p f1112j;

    /* renamed from: k */
    private ArrayList f1113k;

    /* renamed from: l */
    private ArrayList f1114l;

    /* renamed from: m */
    private boolean f1115m;

    /* renamed from: n */
    private ArrayList f1116n;

    /* renamed from: o */
    private ArrayList f1117o;

    /* renamed from: p */
    private boolean f1118p;

    /* renamed from: q */
    private int f1119q = 0;

    /* renamed from: r */
    private ContextMenu.ContextMenuInfo f1120r;

    /* renamed from: s */
    private boolean f1121s = false;

    /* renamed from: t */
    private boolean f1122t = false;

    /* renamed from: u */
    private boolean f1123u = false;

    /* renamed from: v */
    private boolean f1124v = false;

    /* renamed from: w */
    private ArrayList f1125w = new ArrayList();

    /* renamed from: x */
    private CopyOnWriteArrayList f1126x = new CopyOnWriteArrayList();

    /* renamed from: y */
    private C0566s f1127y;

    /* renamed from: z */
    private boolean f1128z;

    public C0562o(Context context) {
        this.f1107e = context;
        this.f1108f = context.getResources();
        this.f1109g = context.getResources().getBoolean(C0507c.abc_config_enableCascadingSubmenus);
        this.f1113k = new ArrayList();
        this.f1114l = new ArrayList();
        this.f1115m = true;
        this.f1116n = new ArrayList();
        this.f1117o = new ArrayList();
        this.f1118p = true;
        m2447e(true);
    }

    /* renamed from: a */
    private static int m2440a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0566s) arrayList.get(size)).mo2516c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private C0566s m2441a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0566s(this, i, i2, i3, i4, charSequence, i5);
    }

    /* renamed from: a */
    private void m2442a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = mo2476d();
        if (view != null) {
            this.f1106c = view;
            this.f1104a = null;
            this.f1105b = null;
        } else {
            if (i > 0) {
                this.f1104a = d.getText(i);
            } else if (charSequence != null) {
                this.f1104a = charSequence;
            }
            if (i2 > 0) {
                this.f1105b = C0025a.getDrawable(mo2477e(), i2);
            } else if (drawable != null) {
                this.f1105b = drawable;
            }
            this.f1106c = null;
        }
        mo2470b(false);
    }

    /* renamed from: a */
    private void m2443a(int i, boolean z) {
        if (i >= 0 && i < this.f1113k.size()) {
            this.f1113k.remove(i);
            if (z) {
                mo2470b(true);
            }
        }
    }

    /* renamed from: a */
    private boolean m2444a(C0547an anVar, C0538ae aeVar) {
        boolean z = false;
        if (this.f1126x.isEmpty()) {
            return false;
        }
        if (aeVar != null) {
            z = aeVar.mo2335a(anVar);
        }
        Iterator it = this.f1126x.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            WeakReference weakReference = (WeakReference) it.next();
            C0538ae aeVar2 = (C0538ae) weakReference.get();
            if (aeVar2 == null) {
                this.f1126x.remove(weakReference);
            } else if (!z2) {
                z2 = aeVar2.mo2335a(anVar);
            }
            z = z2;
        }
    }

    /* renamed from: d */
    private static int m2445d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1103d.length) {
            return (f1103d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: d */
    private void m2446d(boolean z) {
        if (!this.f1126x.isEmpty()) {
            mo2480g();
            Iterator it = this.f1126x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0538ae aeVar = (C0538ae) weakReference.get();
                if (aeVar == null) {
                    this.f1126x.remove(weakReference);
                } else {
                    aeVar.mo2336b(z);
                }
            }
            mo2482h();
        }
    }

    /* renamed from: e */
    private void m2447e(boolean z) {
        boolean z2 = true;
        if (!z || this.f1108f.getConfiguration().keyboard == 1 || !this.f1108f.getBoolean(C0507c.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z2 = false;
        }
        this.f1111i = z2;
    }

    /* renamed from: a */
    public int mo2441a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0566s) this.f1113k.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public C0562o mo2442a(int i) {
        this.f1119q = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0562o mo2443a(Drawable drawable) {
        m2442a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0562o mo2444a(View view) {
        m2442a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0562o mo2445a(CharSequence charSequence) {
        m2442a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0566s mo2446a(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1125w;
        arrayList.clear();
        mo2453a((List) arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (C0566s) arrayList.get(0);
        }
        boolean b = mo2372b();
        for (int i2 = 0; i2 < size; i2++) {
            C0566s sVar = (C0566s) arrayList.get(i2);
            char alphabeticShortcut = b ? sVar.getAlphabeticShortcut() : sVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return sVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return sVar;
            }
            if (b && alphabeticShortcut == 8 && i == 67) {
                return sVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuItem mo2447a(int i, int i2, int i3, CharSequence charSequence) {
        int d = m2445d(i3);
        C0566s a = m2441a(i, i2, i3, d, charSequence, this.f1119q);
        if (this.f1120r != null) {
            a.mo2511a(this.f1120r);
        }
        this.f1113k.add(m2440a(this.f1113k, d), a);
        mo2470b(true);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo2369a() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: a */
    public void mo2448a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0214as.m786a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0214as.m790c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0547an) item.getSubMenu()).mo2448a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo2369a(), sparseArray);
        }
    }

    /* renamed from: a */
    public void mo2449a(C0538ae aeVar) {
        mo2450a(aeVar, this.f1107e);
    }

    /* renamed from: a */
    public void mo2450a(C0538ae aeVar, Context context) {
        this.f1126x.add(new WeakReference(aeVar));
        aeVar.mo2308a(context, this);
        this.f1118p = true;
    }

    /* renamed from: a */
    public void mo2370a(C0563p pVar) {
        this.f1112j = pVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2451a(C0566s sVar) {
        this.f1115m = true;
        mo2470b(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2452a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1113k.size();
        for (int i = 0; i < size; i++) {
            C0566s sVar = (C0566s) this.f1113k.get(i);
            if (sVar.getGroupId() == groupId && sVar.mo2523g() && sVar.isCheckable()) {
                sVar.mo2514b(sVar == menuItem);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2453a(List list, int i, KeyEvent keyEvent) {
        boolean b = mo2372b();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1113k.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0566s sVar = (C0566s) this.f1113k.get(i2);
                if (sVar.hasSubMenu()) {
                    ((C0562o) sVar.getSubMenu()).mo2453a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? sVar.getAlphabeticShortcut() : sVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == 8 && i == 67)) && sVar.isEnabled())) {
                    list.add(sVar);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo2454a(boolean z) {
        if (!this.f1124v) {
            this.f1124v = true;
            Iterator it = this.f1126x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0538ae aeVar = (C0538ae) weakReference.get();
                if (aeVar == null) {
                    this.f1126x.remove(weakReference);
                } else {
                    aeVar.mo2334a(this, z);
                }
            }
            this.f1124v = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2371a(C0562o oVar, MenuItem menuItem) {
        return this.f1112j != null && this.f1112j.mo2030a(oVar, menuItem);
    }

    /* renamed from: a */
    public boolean mo2455a(MenuItem menuItem, int i) {
        return mo2456a(menuItem, (C0538ae) null, i);
    }

    /* renamed from: a */
    public boolean mo2456a(MenuItem menuItem, C0538ae aeVar, int i) {
        C0566s sVar = (C0566s) menuItem;
        if (sVar == null || !sVar.isEnabled()) {
            return false;
        }
        boolean b = sVar.mo2515b();
        C0344n a = sVar.mo1018a();
        boolean z = a != null && a.mo1624e();
        if (sVar.mo2547n()) {
            boolean expandActionView = sVar.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            mo2454a(true);
            return expandActionView;
        } else if (sVar.hasSubMenu() || z) {
            if (!this.f1109g) {
                mo2454a(false);
            }
            if (!sVar.hasSubMenu()) {
                sVar.mo2510a(new C0547an(mo2477e(), this, sVar));
            }
            C0547an anVar = (C0547an) sVar.getSubMenu();
            if (z) {
                a.mo1619a((SubMenu) anVar);
            }
            boolean a2 = m2444a(anVar, aeVar) | b;
            if (a2) {
                return a2;
            }
            mo2454a(true);
            return a2;
        } else {
            if ((i & 1) == 0) {
                mo2454a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return mo2447a(0, 0, 0, this.f1108f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo2447a(i, i2, i3, this.f1108f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo2447a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo2447a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1107e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f1108f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.f1108f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0566s sVar = (C0566s) mo2447a(i, i2, i3, charSequence);
        C0547an anVar = new C0547an(this.f1107e, this, sVar);
        sVar.mo2510a(anVar);
        return anVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* renamed from: b */
    public int mo2466b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0566s) this.f1113k.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public void mo2467b(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo2369a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View a = C0214as.m786a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0547an) item.getSubMenu()).mo2467b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                C0214as.m789b(findItem);
            }
        }
    }

    /* renamed from: b */
    public void mo2468b(C0538ae aeVar) {
        Iterator it = this.f1126x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0538ae aeVar2 = (C0538ae) weakReference.get();
            if (aeVar2 == null || aeVar2 == aeVar) {
                this.f1126x.remove(weakReference);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2469b(C0566s sVar) {
        this.f1118p = true;
        mo2470b(true);
    }

    /* renamed from: b */
    public void mo2470b(boolean z) {
        if (!this.f1121s) {
            if (z) {
                this.f1115m = true;
                this.f1118p = true;
            }
            m2446d(z);
            return;
        }
        this.f1122t = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo2372b() {
        return this.f1110h;
    }

    /* renamed from: c */
    public int mo2471c(int i) {
        return mo2441a(i, 0);
    }

    /* renamed from: c */
    public void mo2472c(boolean z) {
        this.f1128z = z;
    }

    /* renamed from: c */
    public boolean mo2373c() {
        return this.f1111i;
    }

    /* renamed from: c */
    public boolean mo2374c(C0566s sVar) {
        boolean z = false;
        if (!this.f1126x.isEmpty()) {
            mo2480g();
            Iterator it = this.f1126x.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                C0538ae aeVar = (C0538ae) weakReference.get();
                if (aeVar == null) {
                    this.f1126x.remove(weakReference);
                    z = z2;
                } else {
                    z = aeVar.mo2313a(this, sVar);
                    if (z) {
                        break;
                    }
                }
            }
            mo2482h();
            if (z) {
                this.f1127y = sVar;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f1127y != null) {
            mo2375d(this.f1127y);
        }
        this.f1113k.clear();
        mo2470b(true);
    }

    public void clearHeader() {
        this.f1105b = null;
        this.f1104a = null;
        this.f1106c = null;
        mo2470b(false);
    }

    public void close() {
        mo2454a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Resources mo2476d() {
        return this.f1108f;
    }

    /* renamed from: d */
    public boolean mo2375d(C0566s sVar) {
        boolean z = false;
        if (!this.f1126x.isEmpty() && this.f1127y == sVar) {
            mo2480g();
            Iterator it = this.f1126x.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                C0538ae aeVar = (C0538ae) weakReference.get();
                if (aeVar == null) {
                    this.f1126x.remove(weakReference);
                    z = z2;
                } else {
                    z = aeVar.mo2315b(this, sVar);
                    if (z) {
                        break;
                    }
                }
            }
            mo2482h();
            if (z) {
                this.f1127y = null;
            }
        }
        return z;
    }

    /* renamed from: e */
    public Context mo2477e() {
        return this.f1107e;
    }

    /* renamed from: f */
    public void mo2478f() {
        if (this.f1112j != null) {
            this.f1112j.mo2028a(this);
        }
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0566s sVar = (C0566s) this.f1113k.get(i2);
            if (sVar.getItemId() == i) {
                return sVar;
            }
            if (sVar.hasSubMenu() && (findItem = sVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    /* renamed from: g */
    public void mo2480g() {
        if (!this.f1121s) {
            this.f1121s = true;
            this.f1122t = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1113k.get(i);
    }

    /* renamed from: h */
    public void mo2482h() {
        this.f1121s = false;
        if (this.f1122t) {
            this.f1122t = false;
            mo2470b(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1128z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0566s) this.f1113k.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public ArrayList mo2484i() {
        if (!this.f1115m) {
            return this.f1114l;
        }
        this.f1114l.clear();
        int size = this.f1113k.size();
        for (int i = 0; i < size; i++) {
            C0566s sVar = (C0566s) this.f1113k.get(i);
            if (sVar.isVisible()) {
                this.f1114l.add(sVar);
            }
        }
        this.f1115m = false;
        this.f1118p = true;
        return this.f1114l;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return mo2446a(i, keyEvent) != null;
    }

    /* renamed from: j */
    public void mo2486j() {
        boolean b;
        ArrayList i = mo2484i();
        if (this.f1118p) {
            Iterator it = this.f1126x.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0538ae aeVar = (C0538ae) weakReference.get();
                if (aeVar == null) {
                    this.f1126x.remove(weakReference);
                    b = z;
                } else {
                    b = aeVar.mo2337b() | z;
                }
                z = b;
            }
            if (z) {
                this.f1116n.clear();
                this.f1117o.clear();
                int size = i.size();
                for (int i2 = 0; i2 < size; i2++) {
                    C0566s sVar = (C0566s) i.get(i2);
                    if (sVar.mo2543j()) {
                        this.f1116n.add(sVar);
                    } else {
                        this.f1117o.add(sVar);
                    }
                }
            } else {
                this.f1116n.clear();
                this.f1117o.clear();
                this.f1117o.addAll(mo2484i());
            }
            this.f1118p = false;
        }
    }

    /* renamed from: k */
    public ArrayList mo2487k() {
        mo2486j();
        return this.f1116n;
    }

    /* renamed from: l */
    public ArrayList mo2488l() {
        mo2486j();
        return this.f1117o;
    }

    /* renamed from: m */
    public CharSequence mo2489m() {
        return this.f1104a;
    }

    /* renamed from: n */
    public Drawable mo2490n() {
        return this.f1105b;
    }

    /* renamed from: o */
    public View mo2491o() {
        return this.f1106c;
    }

    /* renamed from: p */
    public C0562o mo2377p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return mo2455a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C0566s a = mo2446a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = mo2455a((MenuItem) a, i2);
        }
        if ((i2 & 2) != 0) {
            mo2454a(true);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo2494q() {
        return this.f1123u;
    }

    /* renamed from: r */
    public C0566s mo2495r() {
        return this.f1127y;
    }

    public void removeGroup(int i) {
        int c = mo2471c(i);
        if (c >= 0) {
            int size = this.f1113k.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0566s) this.f1113k.get(c)).getGroupId() != i) {
                    mo2470b(true);
                } else {
                    m2443a(c, false);
                    i2 = i3;
                }
            }
            mo2470b(true);
        }
    }

    public void removeItem(int i) {
        m2443a(mo2466b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1113k.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0566s sVar = (C0566s) this.f1113k.get(i2);
            if (sVar.getGroupId() == i) {
                sVar.mo2512a(z2);
                sVar.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1113k.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0566s sVar = (C0566s) this.f1113k.get(i2);
            if (sVar.getGroupId() == i) {
                sVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1113k.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0566s sVar = (C0566s) this.f1113k.get(i2);
            i2++;
            z2 = (sVar.getGroupId() != i || !sVar.mo2517c(z)) ? z2 : true;
        }
        if (z2) {
            mo2470b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f1110h = z;
        mo2470b(false);
    }

    public int size() {
        return this.f1113k.size();
    }
}
