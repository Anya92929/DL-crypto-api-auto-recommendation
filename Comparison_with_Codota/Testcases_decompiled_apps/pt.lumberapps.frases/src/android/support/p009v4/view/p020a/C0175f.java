package android.support.p009v4.view.p020a;

import android.graphics.Rect;
import android.os.Build;
import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import android.view.View;

/* renamed from: android.support.v4.view.a.f */
public class C0175f {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C0180k f309a;

    /* renamed from: b */
    private final Object f310b;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f309a = new C0178i();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f309a = new C0177h();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f309a = new C0184o();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f309a = new C0183n();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f309a = new C0182m();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f309a = new C0181l();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f309a = new C0179j();
        } else {
            f309a = new C0185p();
        }
    }

    public C0175f(Object obj) {
        this.f310b = obj;
    }

    /* renamed from: a */
    public static C0175f m519a(C0175f fVar) {
        return m520a(f309a.mo1342a(fVar.f310b));
    }

    /* renamed from: a */
    static C0175f m520a(Object obj) {
        if (obj != null) {
            return new C0175f(obj);
        }
        return null;
    }

    /* renamed from: b */
    private static String m521b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case NotificationCompat.FLAG_HIGH_PRIORITY:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case NotificationCompat.FLAG_LOCAL_ONLY:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case FragmentTransaction.TRANSIT_ENTER_MASK:
                return "ACTION_SCROLL_FORWARD";
            case FragmentTransaction.TRANSIT_EXIT_MASK:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    /* renamed from: a */
    public Object mo1290a() {
        return this.f310b;
    }

    /* renamed from: a */
    public void mo1291a(int i) {
        f309a.mo1343a(this.f310b, i);
    }

    /* renamed from: a */
    public void mo1292a(Rect rect) {
        f309a.mo1344a(this.f310b, rect);
    }

    /* renamed from: a */
    public void mo1293a(CharSequence charSequence) {
        f309a.mo1354c(this.f310b, charSequence);
    }

    /* renamed from: a */
    public void mo1294a(boolean z) {
        f309a.mo1355c(this.f310b, z);
    }

    /* renamed from: a */
    public boolean mo1295a(C0176g gVar) {
        return f309a.mo1339a(this.f310b, gVar.f333w);
    }

    public void addChild(View view) {
        f309a.mo1353c(this.f310b, view);
    }

    /* renamed from: b */
    public int mo1297b() {
        return f309a.mo1347b(this.f310b);
    }

    /* renamed from: b */
    public void mo1298b(Rect rect) {
        f309a.mo1352c(this.f310b, rect);
    }

    /* renamed from: b */
    public void mo1299b(CharSequence charSequence) {
        f309a.mo1345a(this.f310b, charSequence);
    }

    /* renamed from: b */
    public void mo1300b(boolean z) {
        f309a.mo1359d(this.f310b, z);
    }

    /* renamed from: c */
    public void mo1301c(Rect rect) {
        f309a.mo1348b(this.f310b, rect);
    }

    /* renamed from: c */
    public void mo1302c(CharSequence charSequence) {
        f309a.mo1349b(this.f310b, charSequence);
    }

    /* renamed from: c */
    public void mo1303c(boolean z) {
        f309a.mo1379h(this.f310b, z);
    }

    /* renamed from: c */
    public boolean mo1304c() {
        return f309a.mo1366g(this.f310b);
    }

    /* renamed from: d */
    public void mo1305d(Rect rect) {
        f309a.mo1357d(this.f310b, rect);
    }

    /* renamed from: d */
    public void mo1306d(boolean z) {
        f309a.mo1380i(this.f310b, z);
    }

    /* renamed from: d */
    public boolean mo1307d() {
        return f309a.mo1367h(this.f310b);
    }

    /* renamed from: e */
    public void mo1308e(boolean z) {
        f309a.mo1365g(this.f310b, z);
    }

    /* renamed from: e */
    public boolean mo1309e() {
        return f309a.mo1370k(this.f310b);
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
        C0175f fVar = (C0175f) obj;
        return this.f310b == null ? fVar.f310b == null : this.f310b.equals(fVar.f310b);
    }

    /* renamed from: f */
    public void mo1311f(boolean z) {
        f309a.mo1346a(this.f310b, z);
    }

    /* renamed from: f */
    public boolean mo1312f() {
        return f309a.mo1371l(this.f310b);
    }

    /* renamed from: g */
    public void mo1313g(boolean z) {
        f309a.mo1362e(this.f310b, z);
    }

    /* renamed from: g */
    public boolean mo1314g() {
        return f309a.mo1381r(this.f310b);
    }

    /* renamed from: h */
    public void mo1315h(boolean z) {
        f309a.mo1350b(this.f310b, z);
    }

    /* renamed from: h */
    public boolean mo1316h() {
        return f309a.mo1382s(this.f310b);
    }

    public int hashCode() {
        if (this.f310b == null) {
            return 0;
        }
        return this.f310b.hashCode();
    }

    /* renamed from: i */
    public void mo1318i(boolean z) {
        f309a.mo1364f(this.f310b, z);
    }

    /* renamed from: i */
    public boolean mo1319i() {
        return f309a.mo1375p(this.f310b);
    }

    /* renamed from: j */
    public boolean mo1320j() {
        return f309a.mo1368i(this.f310b);
    }

    /* renamed from: k */
    public boolean mo1321k() {
        return f309a.mo1372m(this.f310b);
    }

    /* renamed from: l */
    public boolean mo1322l() {
        return f309a.mo1369j(this.f310b);
    }

    /* renamed from: m */
    public boolean mo1323m() {
        return f309a.mo1373n(this.f310b);
    }

    /* renamed from: n */
    public boolean mo1324n() {
        return f309a.mo1374o(this.f310b);
    }

    /* renamed from: o */
    public CharSequence mo1325o() {
        return f309a.mo1360e(this.f310b);
    }

    /* renamed from: p */
    public CharSequence mo1326p() {
        return f309a.mo1351c(this.f310b);
    }

    /* renamed from: q */
    public CharSequence mo1327q() {
        return f309a.mo1363f(this.f310b);
    }

    /* renamed from: r */
    public CharSequence mo1328r() {
        return f309a.mo1356d(this.f310b);
    }

    /* renamed from: s */
    public void mo1329s() {
        f309a.mo1376q(this.f310b);
    }

    public void setLabelFor(View view) {
        f309a.mo1377f(this.f310b, view);
    }

    public void setLabeledBy(View view) {
        f309a.mo1378g(this.f310b, view);
    }

    public void setParent(View view) {
        f309a.mo1358d(this.f310b, view);
    }

    public void setSource(View view) {
        f309a.mo1361e(this.f310b, view);
    }

    public void setTraversalAfter(View view) {
        f309a.mo1341b(this.f310b, view);
    }

    public void setTraversalBefore(View view) {
        f309a.mo1340a(this.f310b, view);
    }

    /* renamed from: t */
    public String mo1336t() {
        return f309a.mo1383t(this.f310b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        mo1292a(rect);
        sb.append("; boundsInParent: " + rect);
        mo1301c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(mo1325o());
        sb.append("; className: ").append(mo1326p());
        sb.append("; text: ").append(mo1327q());
        sb.append("; contentDescription: ").append(mo1328r());
        sb.append("; viewId: ").append(mo1336t());
        sb.append("; checkable: ").append(mo1304c());
        sb.append("; checked: ").append(mo1307d());
        sb.append("; focusable: ").append(mo1309e());
        sb.append("; focused: ").append(mo1312f());
        sb.append("; selected: ").append(mo1319i());
        sb.append("; clickable: ").append(mo1320j());
        sb.append("; longClickable: ").append(mo1321k());
        sb.append("; enabled: ").append(mo1322l());
        sb.append("; password: ").append(mo1323m());
        sb.append("; scrollable: " + mo1324n());
        sb.append("; [");
        int b = mo1297b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            sb.append(m521b(numberOfTrailingZeros));
            if (b != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
