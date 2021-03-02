package com.jackhenry.godough.core;

import android.content.Intent;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.u */
public class C1916u {

    /* renamed from: a */
    C1409aa f6844a;

    public C1916u(C1409aa aaVar) {
        this.f6844a = aaVar;
    }

    /* renamed from: a */
    private void m6938a(String str, ArrayList<String> arrayList, int i) {
        if (str != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new C1574c(-1, this.f6844a.mo9533a(C1506am.btn_ok)));
            C1576e eVar = new C1576e(C1577f.SUCCESS, 1, this.f6844a.mo9533a(C1506am.permission_needed), str, (List<C1574c>) arrayList2);
            eVar.mo9791a((C1578g) new C1917v(this, arrayList, i));
            this.f6844a.mo9536a(eVar);
        }
    }

    /* renamed from: a */
    private void m6939a(String str, boolean z) {
        if (str != null) {
            Intent intent = new Intent("android.settings.APPLICATION_SETTINGS");
            boolean z2 = false;
            if (intent.resolveActivity(GoDoughApp.getApp().getPackageManager()) != null) {
                z2 = true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, this.f6844a.mo9533a(C1506am.btn_continue)));
            if (z2) {
                arrayList.add(new C1574c(-2, this.f6844a.mo9533a(C1506am.view_settings)));
            }
            C1576e eVar = new C1576e(C1577f.SUCCESS, 1, this.f6844a.mo9533a(C1506am.permission_needed), str, (List<C1574c>) arrayList);
            eVar.mo9791a((C1578g) new C1918w(this, intent, z));
            this.f6844a.mo9536a(eVar);
        }
    }

    /* renamed from: a */
    public boolean mo11156a(int i, String str, boolean z) {
        if (i == 0) {
            return true;
        }
        m6939a(str, z);
        return false;
    }

    /* renamed from: a */
    public boolean mo11157a(String str, String str2, int i) {
        return mo11158a(str, new String[]{str2}, i);
    }

    /* renamed from: a */
    public boolean mo11158a(String str, String[] strArr, int i) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (String str2 : strArr) {
            if (this.f6844a.mo9532a(str2) != 0) {
                if (this.f6844a.mo9538b(str2)) {
                    z = true;
                }
                arrayList.add(str2);
            }
        }
        if (z && str != null) {
            m6938a(str, (ArrayList<String>) arrayList, i);
            return false;
        } else if (arrayList.size() <= 0) {
            return true;
        } else {
            this.f6844a.mo9537a((String[]) arrayList.toArray(new String[arrayList.size()]), i);
            return false;
        }
    }
}
