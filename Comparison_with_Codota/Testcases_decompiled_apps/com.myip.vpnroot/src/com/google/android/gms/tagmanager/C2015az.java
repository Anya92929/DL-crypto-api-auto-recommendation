package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.az */
class C2015az extends C1998aj {

    /* renamed from: ID */
    private static final String f4542ID = C0880a.JOINER.toString();
    private static final String aoU = C0929b.ARG0.toString();
    private static final String app = C0929b.ITEM_SEPARATOR.toString();
    private static final String apq = C0929b.KEY_VALUE_SEPARATOR.toString();
    private static final String apr = C0929b.ESCAPE.toString();

    /* renamed from: com.google.android.gms.tagmanager.az$a */
    private enum C2017a {
        NONE,
        URL,
        BACKSLASH
    }

    public C2015az() {
        super(f4542ID, aoU);
    }

    /* renamed from: a */
    private String m6796a(String str, C2017a aVar, Set<Character> set) {
        switch (aVar) {
            case URL:
                try {
                    return C2118dm.m7154db(str);
                } catch (UnsupportedEncodingException e) {
                    C2028bh.m6820b("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                Iterator<Character> it = set.iterator();
                while (true) {
                    String str2 = replace;
                    if (!it.hasNext()) {
                        return str2;
                    }
                    String ch = it.next().toString();
                    replace = str2.replace(ch, "\\" + ch);
                }
            default:
                return str;
        }
    }

    /* renamed from: a */
    private void m6797a(StringBuilder sb, String str, C2017a aVar, Set<Character> set) {
        sb.append(m6796a(str, aVar, set));
    }

    /* renamed from: a */
    private void m6798a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        HashSet hashSet;
        C2017a aVar;
        C1026d.C1027a aVar2 = map.get(aoU);
        if (aVar2 == null) {
            return C2114di.m7119pI();
        }
        C1026d.C1027a aVar3 = map.get(app);
        String j = aVar3 != null ? C2114di.m7106j(aVar3) : "";
        C1026d.C1027a aVar4 = map.get(apq);
        String j2 = aVar4 != null ? C2114di.m7106j(aVar4) : "=";
        C2017a aVar5 = C2017a.NONE;
        C1026d.C1027a aVar6 = map.get(apr);
        if (aVar6 != null) {
            String j3 = C2114di.m7106j(aVar6);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                aVar = C2017a.URL;
                hashSet = null;
            } else if ("backslash".equals(j3)) {
                aVar = C2017a.BACKSLASH;
                hashSet = new HashSet();
                m6798a(hashSet, j);
                m6798a(hashSet, j2);
                hashSet.remove('\\');
            } else {
                C2028bh.m6816T("Joiner: unsupported escape type: " + j3);
                return C2114di.m7119pI();
            }
        } else {
            hashSet = null;
            aVar = aVar5;
        }
        StringBuilder sb = new StringBuilder();
        switch (aVar2.type) {
            case 2:
                boolean z = true;
                C1026d.C1027a[] aVarArr = aVar2.f3085gw;
                int length = aVarArr.length;
                int i = 0;
                while (i < length) {
                    C1026d.C1027a aVar7 = aVarArr[i];
                    if (!z) {
                        sb.append(j);
                    }
                    m6797a(sb, C2114di.m7106j(aVar7), aVar, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < aVar2.f3086gx.length; i2++) {
                    if (i2 > 0) {
                        sb.append(j);
                    }
                    String j4 = C2114di.m7106j(aVar2.f3086gx[i2]);
                    String j5 = C2114di.m7106j(aVar2.f3087gy[i2]);
                    m6797a(sb, j4, aVar, hashSet);
                    sb.append(j2);
                    m6797a(sb, j5, aVar, hashSet);
                }
                break;
            default:
                m6797a(sb, C2114di.m7106j(aVar2), aVar, hashSet);
                break;
        }
        return C2114di.m7124u(sb.toString());
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
