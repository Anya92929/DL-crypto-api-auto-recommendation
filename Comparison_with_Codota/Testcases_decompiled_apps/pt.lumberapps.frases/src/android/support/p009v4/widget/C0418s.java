package android.support.p009v4.widget;

import android.graphics.Rect;
import android.support.p009v4.view.C0152a;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.p020a.C0175f;
import android.support.p009v4.view.p020a.C0176g;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* renamed from: android.support.v4.widget.s */
class C0418s extends C0152a {

    /* renamed from: b */
    final /* synthetic */ DrawerLayout f570b;

    /* renamed from: c */
    private final Rect f571c = new Rect();

    C0418s(DrawerLayout drawerLayout) {
        this.f570b = drawerLayout;
    }

    /* renamed from: a */
    private void m1736a(C0175f fVar, C0175f fVar2) {
        Rect rect = this.f571c;
        fVar2.mo1292a(rect);
        fVar.mo1298b(rect);
        fVar2.mo1301c(rect);
        fVar.mo1305d(rect);
        fVar.mo1303c(fVar2.mo1314g());
        fVar.mo1293a(fVar2.mo1325o());
        fVar.mo1299b(fVar2.mo1326p());
        fVar.mo1302c(fVar2.mo1328r());
        fVar.mo1315h(fVar2.mo1322l());
        fVar.mo1311f(fVar2.mo1320j());
        fVar.mo1294a(fVar2.mo1309e());
        fVar.mo1300b(fVar2.mo1312f());
        fVar.mo1306d(fVar2.mo1316h());
        fVar.mo1308e(fVar2.mo1319i());
        fVar.mo1313g(fVar2.mo1321k());
        fVar.mo1291a(fVar2.mo1297b());
    }

    /* renamed from: a */
    private void m1737a(C0175f fVar, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (DrawerLayout.m1372l(childAt)) {
                fVar.addChild(childAt);
            }
        }
    }

    /* renamed from: a */
    public void mo1248a(View view, C0175f fVar) {
        if (DrawerLayout.f413c) {
            super.mo1248a(view, fVar);
        } else {
            C0175f a = C0175f.m519a(fVar);
            super.mo1248a(view, a);
            fVar.setSource(view);
            ViewParent e = C0247by.m911e(view);
            if (e instanceof View) {
                fVar.setParent((View) e);
            }
            m1736a(fVar, a);
            a.mo1329s();
            m1737a(fVar, (ViewGroup) view);
        }
        fVar.mo1299b((CharSequence) DrawerLayout.class.getName());
        fVar.mo1294a(false);
        fVar.mo1300b(false);
        fVar.mo1295a(C0176g.f311a);
        fVar.mo1295a(C0176g.f312b);
    }

    /* renamed from: a */
    public boolean mo1251a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.f413c || DrawerLayout.m1372l(view)) {
            return super.mo1251a(viewGroup, view, accessibilityEvent);
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo1252b(View view, AccessibilityEvent accessibilityEvent) {
        CharSequence b;
        if (accessibilityEvent.getEventType() != 32) {
            return super.mo1252b(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View a = this.f570b.m1370k();
        if (!(a == null || (b = this.f570b.mo1646b(this.f570b.mo1659e(a))) == null)) {
            text.add(b);
        }
        return true;
    }

    /* renamed from: d */
    public void mo1254d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo1254d(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
}
