package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1026d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.di */
class C2114di {
    private static final Object arJ = null;
    private static Long arK = new Long(0);
    private static Double arL = new Double(0.0d);
    private static C2113dh arM = C2113dh.m7094z(0);
    private static String arN = new String("");
    private static Boolean arO = new Boolean(false);
    private static List<Object> arP = new ArrayList(0);
    private static Map<Object, Object> arQ = new HashMap();
    private static C1026d.C1027a arR = m7124u(arN);

    /* renamed from: cU */
    public static C1026d.C1027a m7101cU(String str) {
        C1026d.C1027a aVar = new C1026d.C1027a();
        aVar.type = 5;
        aVar.f3078gA = str;
        return aVar;
    }

    /* renamed from: cV */
    private static C2113dh m7102cV(String str) {
        try {
            return C2113dh.m7093cT(str);
        } catch (NumberFormatException e) {
            C2028bh.m6816T("Failed to convert '" + str + "' to a number.");
            return arM;
        }
    }

    /* renamed from: cW */
    private static Long m7103cW(String str) {
        C2113dh cV = m7102cV(str);
        return cV == arM ? arK : Long.valueOf(cV.longValue());
    }

    /* renamed from: cX */
    private static Double m7104cX(String str) {
        C2113dh cV = m7102cV(str);
        return cV == arM ? arL : Double.valueOf(cV.doubleValue());
    }

    /* renamed from: cY */
    private static Boolean m7105cY(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : arO;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        C2028bh.m6816T("getDouble received non-Number");
        return 0.0d;
    }

    /* renamed from: j */
    public static String m7106j(C1026d.C1027a aVar) {
        return m7112p(m7111o(aVar));
    }

    /* renamed from: k */
    public static C2113dh m7107k(C1026d.C1027a aVar) {
        return m7120q(m7111o(aVar));
    }

    /* renamed from: l */
    public static Long m7108l(C1026d.C1027a aVar) {
        return m7121r(m7111o(aVar));
    }

    /* renamed from: m */
    public static Double m7109m(C1026d.C1027a aVar) {
        return m7122s(m7111o(aVar));
    }

    /* renamed from: n */
    public static Boolean m7110n(C1026d.C1027a aVar) {
        return m7123t(m7111o(aVar));
    }

    /* renamed from: o */
    public static Object m7111o(C1026d.C1027a aVar) {
        int i = 0;
        if (aVar == null) {
            return arJ;
        }
        switch (aVar.type) {
            case 1:
                return aVar.f3084gv;
            case 2:
                ArrayList arrayList = new ArrayList(aVar.f3085gw.length);
                C1026d.C1027a[] aVarArr = aVar.f3085gw;
                int length = aVarArr.length;
                while (i < length) {
                    Object o = m7111o(aVarArr[i]);
                    if (o == arJ) {
                        return arJ;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case 3:
                if (aVar.f3086gx.length != aVar.f3087gy.length) {
                    C2028bh.m6816T("Converting an invalid value to object: " + aVar.toString());
                    return arJ;
                }
                HashMap hashMap = new HashMap(aVar.f3087gy.length);
                while (i < aVar.f3086gx.length) {
                    Object o2 = m7111o(aVar.f3086gx[i]);
                    Object o3 = m7111o(aVar.f3087gy[i]);
                    if (o2 == arJ || o3 == arJ) {
                        return arJ;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case 4:
                C2028bh.m6816T("Trying to convert a macro reference to object");
                return arJ;
            case 5:
                C2028bh.m6816T("Trying to convert a function id to object");
                return arJ;
            case 6:
                return Long.valueOf(aVar.f3079gB);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                C1026d.C1027a[] aVarArr2 = aVar.f3081gD;
                int length2 = aVarArr2.length;
                while (i < length2) {
                    String j = m7106j(aVarArr2[i]);
                    if (j == arN) {
                        return arJ;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.f3080gC);
            default:
                C2028bh.m6816T("Failed to convert a value of type: " + aVar.type);
                return arJ;
        }
    }

    /* renamed from: p */
    public static String m7112p(Object obj) {
        return obj == null ? arN : obj.toString();
    }

    /* renamed from: pC */
    public static Object m7113pC() {
        return arJ;
    }

    /* renamed from: pD */
    public static Long m7114pD() {
        return arK;
    }

    /* renamed from: pE */
    public static Double m7115pE() {
        return arL;
    }

    /* renamed from: pF */
    public static Boolean m7116pF() {
        return arO;
    }

    /* renamed from: pG */
    public static C2113dh m7117pG() {
        return arM;
    }

    /* renamed from: pH */
    public static String m7118pH() {
        return arN;
    }

    /* renamed from: pI */
    public static C1026d.C1027a m7119pI() {
        return arR;
    }

    /* renamed from: q */
    public static C2113dh m7120q(Object obj) {
        return obj instanceof C2113dh ? (C2113dh) obj : m7126w(obj) ? C2113dh.m7094z(m7127x(obj)) : m7125v(obj) ? C2113dh.m7092a(Double.valueOf(getDouble(obj))) : m7102cV(m7112p(obj));
    }

    /* renamed from: r */
    public static Long m7121r(Object obj) {
        return m7126w(obj) ? Long.valueOf(m7127x(obj)) : m7103cW(m7112p(obj));
    }

    /* renamed from: s */
    public static Double m7122s(Object obj) {
        return m7125v(obj) ? Double.valueOf(getDouble(obj)) : m7104cX(m7112p(obj));
    }

    /* renamed from: t */
    public static Boolean m7123t(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m7105cY(m7112p(obj));
    }

    /* renamed from: u */
    public static C1026d.C1027a m7124u(Object obj) {
        boolean z = false;
        C1026d.C1027a aVar = new C1026d.C1027a();
        if (obj instanceof C1026d.C1027a) {
            return (C1026d.C1027a) obj;
        }
        if (obj instanceof String) {
            aVar.type = 1;
            aVar.f3084gv = (String) obj;
        } else if (obj instanceof List) {
            aVar.type = 2;
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z2 = false;
            for (Object u : list) {
                C1026d.C1027a u2 = m7124u(u);
                if (u2 == arR) {
                    return arR;
                }
                boolean z3 = z2 || u2.f3083gF;
                arrayList.add(u2);
                z2 = z3;
            }
            aVar.f3085gw = (C1026d.C1027a[]) arrayList.toArray(new C1026d.C1027a[0]);
            z = z2;
        } else if (obj instanceof Map) {
            aVar.type = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z4 = false;
            for (Map.Entry entry : entrySet) {
                C1026d.C1027a u3 = m7124u(entry.getKey());
                C1026d.C1027a u4 = m7124u(entry.getValue());
                if (u3 == arR || u4 == arR) {
                    return arR;
                }
                boolean z5 = z4 || u3.f3083gF || u4.f3083gF;
                arrayList2.add(u3);
                arrayList3.add(u4);
                z4 = z5;
            }
            aVar.f3086gx = (C1026d.C1027a[]) arrayList2.toArray(new C1026d.C1027a[0]);
            aVar.f3087gy = (C1026d.C1027a[]) arrayList3.toArray(new C1026d.C1027a[0]);
            z = z4;
        } else if (m7125v(obj)) {
            aVar.type = 1;
            aVar.f3084gv = obj.toString();
        } else if (m7126w(obj)) {
            aVar.type = 6;
            aVar.f3079gB = m7127x(obj);
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.f3080gC = ((Boolean) obj).booleanValue();
        } else {
            C2028bh.m6816T("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return arR;
        }
        aVar.f3083gF = z;
        return aVar;
    }

    /* renamed from: v */
    private static boolean m7125v(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof C2113dh) && ((C2113dh) obj).mo11744px());
    }

    /* renamed from: w */
    private static boolean m7126w(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof C2113dh) && ((C2113dh) obj).mo11745py());
    }

    /* renamed from: x */
    private static long m7127x(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        C2028bh.m6816T("getInt64 received non-Number");
        return 0;
    }
}
