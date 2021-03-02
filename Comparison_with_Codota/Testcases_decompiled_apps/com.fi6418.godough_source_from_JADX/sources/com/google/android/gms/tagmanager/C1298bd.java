package com.google.android.gms.tagmanager;

import com.google.android.gms.p018c.C0661c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.bd */
public class C1298bd {

    /* renamed from: a */
    private static final Object f5368a = null;

    /* renamed from: b */
    private static Long f5369b = new Long(0);

    /* renamed from: c */
    private static Double f5370c = new Double(0.0d);

    /* renamed from: d */
    private static C1297bc f5371d = C1297bc.m5344a(0);

    /* renamed from: e */
    private static String f5372e = new String("");

    /* renamed from: f */
    private static Boolean f5373f = new Boolean(false);

    /* renamed from: g */
    private static List<Object> f5374g = new ArrayList(0);

    /* renamed from: h */
    private static Map<Object, Object> f5375h = new HashMap();

    /* renamed from: i */
    private static C0661c f5376i = m5357c((Object) f5372e);

    /* renamed from: a */
    public static C0661c m5351a() {
        return f5376i;
    }

    /* renamed from: a */
    private static Boolean m5352a(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : f5373f;
    }

    /* renamed from: a */
    public static String m5353a(C0661c cVar) {
        return m5354a(m5358c(cVar));
    }

    /* renamed from: a */
    public static String m5354a(Object obj) {
        return obj == null ? f5372e : obj.toString();
    }

    /* renamed from: b */
    public static Boolean m5355b(C0661c cVar) {
        return m5356b(m5358c(cVar));
    }

    /* renamed from: b */
    public static Boolean m5356b(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m5352a(m5354a(obj));
    }

    /* renamed from: c */
    public static C0661c m5357c(Object obj) {
        boolean z = false;
        C0661c cVar = new C0661c();
        if (obj instanceof C0661c) {
            return (C0661c) obj;
        }
        if (obj instanceof String) {
            cVar.f4347a = 1;
            cVar.f4348b = (String) obj;
        } else if (obj instanceof List) {
            cVar.f4347a = 2;
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z2 = false;
            for (Object c : list) {
                C0661c c2 = m5357c(c);
                if (c2 == f5376i) {
                    return f5376i;
                }
                boolean z3 = z2 || c2.f4358l;
                arrayList.add(c2);
                z2 = z3;
            }
            cVar.f4349c = (C0661c[]) arrayList.toArray(new C0661c[0]);
            z = z2;
        } else if (obj instanceof Map) {
            cVar.f4347a = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z4 = false;
            for (Map.Entry entry : entrySet) {
                C0661c c3 = m5357c(entry.getKey());
                C0661c c4 = m5357c(entry.getValue());
                if (c3 == f5376i || c4 == f5376i) {
                    return f5376i;
                }
                boolean z5 = z4 || c3.f4358l || c4.f4358l;
                arrayList2.add(c3);
                arrayList3.add(c4);
                z4 = z5;
            }
            cVar.f4350d = (C0661c[]) arrayList2.toArray(new C0661c[0]);
            cVar.f4351e = (C0661c[]) arrayList3.toArray(new C0661c[0]);
            z = z4;
        } else if (m5359d(obj)) {
            cVar.f4347a = 1;
            cVar.f4348b = obj.toString();
        } else if (m5360e(obj)) {
            cVar.f4347a = 6;
            cVar.f4354h = m5361f(obj);
        } else if (obj instanceof Boolean) {
            cVar.f4347a = 8;
            cVar.f4355i = ((Boolean) obj).booleanValue();
        } else {
            C1333x.m5440a("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return f5376i;
        }
        cVar.f4358l = z;
        return cVar;
    }

    /* renamed from: c */
    public static Object m5358c(C0661c cVar) {
        int i = 0;
        if (cVar == null) {
            return f5368a;
        }
        switch (cVar.f4347a) {
            case 1:
                return cVar.f4348b;
            case 2:
                ArrayList arrayList = new ArrayList(cVar.f4349c.length);
                C0661c[] cVarArr = cVar.f4349c;
                int length = cVarArr.length;
                while (i < length) {
                    Object c = m5358c(cVarArr[i]);
                    if (c == f5368a) {
                        return f5368a;
                    }
                    arrayList.add(c);
                    i++;
                }
                return arrayList;
            case 3:
                if (cVar.f4350d.length != cVar.f4351e.length) {
                    C1333x.m5440a("Converting an invalid value to object: " + cVar.toString());
                    return f5368a;
                }
                HashMap hashMap = new HashMap(cVar.f4351e.length);
                while (i < cVar.f4350d.length) {
                    Object c2 = m5358c(cVar.f4350d[i]);
                    Object c3 = m5358c(cVar.f4351e[i]);
                    if (c2 == f5368a || c3 == f5368a) {
                        return f5368a;
                    }
                    hashMap.put(c2, c3);
                    i++;
                }
                return hashMap;
            case 4:
                C1333x.m5440a("Trying to convert a macro reference to object");
                return f5368a;
            case 5:
                C1333x.m5440a("Trying to convert a function id to object");
                return f5368a;
            case 6:
                return Long.valueOf(cVar.f4354h);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                C0661c[] cVarArr2 = cVar.f4356j;
                int length2 = cVarArr2.length;
                while (i < length2) {
                    String a = m5353a(cVarArr2[i]);
                    if (a == f5372e) {
                        return f5368a;
                    }
                    stringBuffer.append(a);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(cVar.f4355i);
            default:
                C1333x.m5440a("Failed to convert a value of type: " + cVar.f4347a);
                return f5368a;
        }
    }

    /* renamed from: d */
    private static boolean m5359d(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof C1297bc) && ((C1297bc) obj).mo9125a());
    }

    /* renamed from: e */
    private static boolean m5360e(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof C1297bc) && ((C1297bc) obj).mo9126b());
    }

    /* renamed from: f */
    private static long m5361f(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        C1333x.m5440a("getInt64 received non-Number");
        return 0;
    }
}
