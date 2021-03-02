package com.jackhenry.godough.p024a.p026b;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.jackhenry.godough.a.b.b */
public class C1378b {

    /* renamed from: a */
    HashMap<String, HashMap<String, String>> f5730a = new HashMap<>();

    public C1378b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m5643a("Login", C1379c.Start.name()));
        arrayList.add(m5643a("Cancel", C1379c.Cancel.name()));
        m5642a("LoginActivity", (ArrayList<String[]>) arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(m5643a("Submit", C1379c.Start.name()));
        arrayList2.add(m5643a("Cancel", C1379c.Cancel.name()));
        m5642a("BillPayFragmentActivity", (ArrayList<String[]>) arrayList2);
    }

    /* renamed from: a */
    private void m5642a(String str, ArrayList<String[]> arrayList) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(arrayList.get(i)[0], arrayList.get(i)[1]);
        }
        this.f5730a.put(str, hashMap);
    }

    /* renamed from: a */
    private String[] m5643a(String str, String str2) {
        return new String[]{str, str2};
    }

    /* renamed from: a */
    public HashMap<String, HashMap<String, String>> mo9431a() {
        return this.f5730a;
    }
}
