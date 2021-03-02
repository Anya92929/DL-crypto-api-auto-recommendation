package com.google.android.gms.internal;

import com.google.android.gms.internal.C1704pc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.pb */
public final class C1702pb {

    /* renamed from: com.google.android.gms.internal.pb$a */
    public static class C1703a {
        public final C1704pc avQ;
        public final List<Asset> avR;

        public C1703a(C1704pc pcVar, List<Asset> list) {
            this.avQ = pcVar;
            this.avR = list;
        }
    }

    /* renamed from: a */
    private static int m5931a(String str, C1704pc.C1705a.C1706a[] aVarArr) {
        int i = 14;
        for (C1704pc.C1705a.C1706a aVar : aVarArr) {
            if (i == 14) {
                if (aVar.type == 9 || aVar.type == 2 || aVar.type == 6) {
                    i = aVar.type;
                } else if (aVar.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + aVar.type + " for key " + str);
                }
            } else if (aVar.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + aVar.type);
            }
        }
        return i;
    }

    /* renamed from: a */
    static int m5932a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    /* renamed from: a */
    public static C1703a m5933a(DataMap dataMap) {
        C1704pc pcVar = new C1704pc();
        ArrayList arrayList = new ArrayList();
        pcVar.avS = m5938a(dataMap, (List<Asset>) arrayList);
        return new C1703a(pcVar, arrayList);
    }

    /* renamed from: a */
    private static C1704pc.C1705a.C1706a m5934a(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        C1704pc.C1705a.C1706a aVar = new C1704pc.C1705a.C1706a();
        if (obj == null) {
            aVar.type = 14;
            return aVar;
        }
        aVar.avW = new C1704pc.C1705a.C1706a.C1707a();
        if (obj instanceof String) {
            aVar.type = 2;
            aVar.avW.avY = (String) obj;
        } else if (obj instanceof Integer) {
            aVar.type = 6;
            aVar.avW.awc = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            aVar.type = 5;
            aVar.avW.awb = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            aVar.type = 3;
            aVar.avW.avZ = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            aVar.type = 4;
            aVar.avW.awa = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.avW.awe = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            aVar.type = 7;
            aVar.avW.awd = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            aVar.type = 1;
            aVar.avW.avX = (byte[]) obj;
        } else if (obj instanceof String[]) {
            aVar.type = 11;
            aVar.avW.awh = (String[]) obj;
        } else if (obj instanceof long[]) {
            aVar.type = 12;
            aVar.avW.awi = (long[]) obj;
        } else if (obj instanceof float[]) {
            aVar.type = 15;
            aVar.avW.awj = (float[]) obj;
        } else if (obj instanceof Asset) {
            aVar.type = 13;
            aVar.avW.awk = (long) m5932a(list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            aVar.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            C1704pc.C1705a[] aVarArr = new C1704pc.C1705a[keySet.size()];
            Iterator<String> it = keySet.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                aVarArr[i3] = new C1704pc.C1705a();
                aVarArr[i3].name = next;
                aVarArr[i3].avU = m5934a(list, dataMap.get(next));
                i2 = i3 + 1;
            }
            aVar.avW.awf = aVarArr;
        } else if (obj instanceof ArrayList) {
            aVar.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            C1704pc.C1705a.C1706a[] aVarArr2 = new C1704pc.C1705a.C1706a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 14;
            while (i4 < size) {
                Object obj3 = arrayList.get(i4);
                C1704pc.C1705a.C1706a a = m5934a(list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i5 == 14 && a.type != 14) {
                        i = a.type;
                    } else if (a.type != i5) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        i = i5;
                    }
                    aVarArr2[i4] = a;
                    i4++;
                    i5 = i;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            aVar.avW.awg = aVarArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return aVar;
    }

    /* renamed from: a */
    public static DataMap m5935a(C1703a aVar) {
        DataMap dataMap = new DataMap();
        for (C1704pc.C1705a aVar2 : aVar.avQ.avS) {
            m5937a(aVar.avR, dataMap, aVar2.name, aVar2.avU);
        }
        return dataMap;
    }

    /* renamed from: a */
    private static ArrayList m5936a(List<Asset> list, C1704pc.C1705a.C1706a.C1707a aVar, int i) {
        ArrayList arrayList = new ArrayList(aVar.awg.length);
        for (C1704pc.C1705a.C1706a aVar2 : aVar.awg) {
            if (aVar2.type == 14) {
                arrayList.add((Object) null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (C1704pc.C1705a aVar3 : aVar2.avW.awf) {
                    m5937a(list, dataMap, aVar3.name, aVar3.avU);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(aVar2.avW.avY);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(aVar2.avW.awc));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m5937a(List<Asset> list, DataMap dataMap, String str, C1704pc.C1705a.C1706a aVar) {
        int i = aVar.type;
        if (i == 14) {
            dataMap.putString(str, (String) null);
            return;
        }
        C1704pc.C1705a.C1706a.C1707a aVar2 = aVar.avW;
        if (i == 1) {
            dataMap.putByteArray(str, aVar2.avX);
        } else if (i == 11) {
            dataMap.putStringArray(str, aVar2.awh);
        } else if (i == 12) {
            dataMap.putLongArray(str, aVar2.awi);
        } else if (i == 15) {
            dataMap.putFloatArray(str, aVar2.awj);
        } else if (i == 2) {
            dataMap.putString(str, aVar2.avY);
        } else if (i == 3) {
            dataMap.putDouble(str, aVar2.avZ);
        } else if (i == 4) {
            dataMap.putFloat(str, aVar2.awa);
        } else if (i == 5) {
            dataMap.putLong(str, aVar2.awb);
        } else if (i == 6) {
            dataMap.putInt(str, aVar2.awc);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) aVar2.awd);
        } else if (i == 8) {
            dataMap.putBoolean(str, aVar2.awe);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, list.get((int) aVar2.awk));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (C1704pc.C1705a aVar3 : aVar2.awf) {
                m5937a(list, dataMap2, aVar3.name, aVar3.avU);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            int a = m5931a(str, aVar2.awg);
            ArrayList a2 = m5936a(list, aVar2, a);
            if (a == 14) {
                dataMap.putStringArrayList(str, a2);
            } else if (a == 9) {
                dataMap.putDataMapArrayList(str, a2);
            } else if (a == 2) {
                dataMap.putStringArrayList(str, a2);
            } else if (a == 6) {
                dataMap.putIntegerArrayList(str, a2);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + a);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    /* renamed from: a */
    private static C1704pc.C1705a[] m5938a(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        C1704pc.C1705a[] aVarArr = new C1704pc.C1705a[keySet.size()];
        int i = 0;
        Iterator<String> it = keySet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return aVarArr;
            }
            String next = it.next();
            Object obj = dataMap.get(next);
            aVarArr[i2] = new C1704pc.C1705a();
            aVarArr[i2].name = next;
            aVarArr[i2].avU = m5934a(list, obj);
            i = i2 + 1;
        }
    }
}
