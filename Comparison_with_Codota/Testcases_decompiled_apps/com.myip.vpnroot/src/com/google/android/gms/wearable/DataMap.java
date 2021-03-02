package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.C1702pb;
import com.google.android.gms.internal.C1704pc;
import com.google.android.gms.internal.C1717pl;
import com.google.android.gms.internal.C1718pm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap {
    public static final String TAG = "DataMap";
    private final HashMap<String, Object> auL = new HashMap<>();

    /* renamed from: a */
    private static void m7456a(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            bundle.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof String[]) {
            bundle.putStringArray(str, (String[]) obj);
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof float[]) {
            bundle.putFloatArray(str, (float[]) obj);
        } else if (obj instanceof Asset) {
            bundle.putParcelable(str, (Asset) obj);
        } else if (obj instanceof DataMap) {
            bundle.putParcelable(str, ((DataMap) obj).toBundle());
        } else if (obj instanceof ArrayList) {
            switch (m7462d((ArrayList) obj)) {
                case 0:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 1:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 2:
                    bundle.putIntegerArrayList(str, (ArrayList) obj);
                    return;
                case 3:
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 4:
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((ArrayList) obj).iterator();
                    while (it.hasNext()) {
                        arrayList.add(((DataMap) it.next()).toBundle());
                    }
                    bundle.putParcelableArrayList(str, arrayList);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private static void m7457a(DataMap dataMap, String str, Object obj) {
        if (obj instanceof String) {
            dataMap.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            dataMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            dataMap.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            dataMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Float) {
            dataMap.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Boolean) {
            dataMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            dataMap.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof byte[]) {
            dataMap.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof String[]) {
            dataMap.putStringArray(str, (String[]) obj);
        } else if (obj instanceof long[]) {
            dataMap.putLongArray(str, (long[]) obj);
        } else if (obj instanceof float[]) {
            dataMap.putFloatArray(str, (float[]) obj);
        } else if (obj instanceof Asset) {
            dataMap.putAsset(str, (Asset) obj);
        } else if (obj instanceof Bundle) {
            dataMap.putDataMap(str, fromBundle((Bundle) obj));
        } else if (obj instanceof ArrayList) {
            switch (m7462d((ArrayList) obj)) {
                case 0:
                    dataMap.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 1:
                    dataMap.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 2:
                    dataMap.putIntegerArrayList(str, (ArrayList) obj);
                    return;
                case 3:
                    dataMap.putStringArrayList(str, (ArrayList) obj);
                    return;
                case 5:
                    dataMap.putDataMapArrayList(str, arrayListFromBundleArrayList((ArrayList) obj));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m7458a(String str, Object obj, String str2, ClassCastException classCastException) {
        m7459a(str, obj, str2, "<null>", classCastException);
    }

    /* renamed from: a */
    private void m7459a(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        Log.w(TAG, "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        Log.w(TAG, "Attempt to cast generated internal exception:", classCastException);
    }

    /* renamed from: a */
    private static boolean m7460a(Asset asset, Asset asset2) {
        return (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.getDigest()) ? asset.getDigest().equals(asset2.getDigest()) : Arrays.equals(asset.getData(), asset2.getData());
    }

    /* renamed from: a */
    private static boolean m7461a(DataMap dataMap, DataMap dataMap2) {
        if (dataMap.size() != dataMap2.size()) {
            return false;
        }
        for (String next : dataMap.keySet()) {
            Object obj = dataMap.get(next);
            Object obj2 = dataMap2.get(next);
            if (obj instanceof Asset) {
                if (!(obj2 instanceof Asset) || !m7460a((Asset) obj, (Asset) obj2)) {
                    return false;
                }
            } else if (obj instanceof String[]) {
                if (!(obj2 instanceof String[]) || !Arrays.equals((String[]) obj, (String[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof long[]) {
                if (!(obj2 instanceof long[]) || !Arrays.equals((long[]) obj, (long[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof float[]) {
                if (!(obj2 instanceof float[]) || !Arrays.equals((float[]) obj, (float[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else if (obj == null || obj2 == null) {
                return obj == obj2;
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> bundleArrayList) {
        ArrayList<DataMap> arrayList = new ArrayList<>();
        Iterator<Bundle> it = bundleArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(fromBundle(it.next()));
        }
        return arrayList;
    }

    /* renamed from: d */
    private static int m7462d(ArrayList<?> arrayList) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                if (next instanceof Integer) {
                    return 2;
                }
                if (next instanceof String) {
                    return 3;
                }
                if (next instanceof DataMap) {
                    return 4;
                }
                if (next instanceof Bundle) {
                    return 5;
                }
            }
        }
        return 1;
    }

    public static DataMap fromBundle(Bundle bundle) {
        bundle.setClassLoader(Asset.class.getClassLoader());
        DataMap dataMap = new DataMap();
        for (String str : bundle.keySet()) {
            m7457a(dataMap, str, bundle.get(str));
        }
        return dataMap;
    }

    public static DataMap fromByteArray(byte[] bytes) {
        try {
            return C1702pb.m5935a(new C1702pb.C1703a(C1704pc.m5939n(bytes), new ArrayList()));
        } catch (C1717pl e) {
            throw new IllegalArgumentException("Unable to convert data", e);
        }
    }

    public void clear() {
        this.auL.clear();
    }

    public boolean containsKey(String key) {
        return this.auL.containsKey(key);
    }

    public boolean equals(Object o) {
        if (!(o instanceof DataMap)) {
            return false;
        }
        return m7461a(this, (DataMap) o);
    }

    public <T> T get(String key) {
        return this.auL.get(key);
    }

    public Asset getAsset(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "Asset", e);
            return null;
        }
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return defaultValue;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e) {
            m7459a(key, obj, "Boolean", Boolean.valueOf(defaultValue), e);
            return defaultValue;
        }
    }

    public byte getByte(String key) {
        return getByte(key, (byte) 0);
    }

    public byte getByte(String key, byte defaultValue) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return defaultValue;
        }
        try {
            return ((Byte) obj).byteValue();
        } catch (ClassCastException e) {
            m7459a(key, obj, "Byte", Byte.valueOf(defaultValue), e);
            return defaultValue;
        }
    }

    public byte[] getByteArray(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "byte[]", e);
            return null;
        }
    }

    public DataMap getDataMap(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (DataMap) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, TAG, e);
            return null;
        }
    }

    public ArrayList<DataMap> getDataMapArrayList(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "ArrayList<DataMap>", e);
            return null;
        }
    }

    public double getDouble(String key) {
        return getDouble(key, 0.0d);
    }

    public double getDouble(String key, double defaultValue) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return defaultValue;
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException e) {
            m7459a(key, obj, "Double", Double.valueOf(defaultValue), e);
            return defaultValue;
        }
    }

    public float getFloat(String key) {
        return getFloat(key, 0.0f);
    }

    public float getFloat(String key, float defaultValue) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return defaultValue;
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException e) {
            m7459a(key, obj, "Float", Float.valueOf(defaultValue), e);
            return defaultValue;
        }
    }

    public float[] getFloatArray(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (float[]) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "float[]", e);
            return null;
        }
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return defaultValue;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            m7458a(key, obj, "Integer", e);
            return defaultValue;
        }
    }

    public ArrayList<Integer> getIntegerArrayList(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "ArrayList<Integer>", e);
            return null;
        }
    }

    public long getLong(String key) {
        return getLong(key, 0);
    }

    public long getLong(String key, long defaultValue) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return defaultValue;
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException e) {
            m7458a(key, obj, "long", e);
            return defaultValue;
        }
    }

    public long[] getLongArray(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (long[]) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "long[]", e);
            return null;
        }
    }

    public String getString(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "String", e);
            return null;
        }
    }

    public String getString(String key, String defaultValue) {
        String defaultValue2 = getString(key);
        return defaultValue2 == null ? defaultValue : defaultValue2;
    }

    public String[] getStringArray(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (String[]) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "String[]", e);
            return null;
        }
    }

    public ArrayList<String> getStringArrayList(String key) {
        Object obj = this.auL.get(key);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            m7458a(key, obj, "ArrayList<String>", e);
            return null;
        }
    }

    public int hashCode() {
        return this.auL.hashCode() * 29;
    }

    public boolean isEmpty() {
        return this.auL.isEmpty();
    }

    public Set<String> keySet() {
        return this.auL.keySet();
    }

    public void putAll(DataMap dataMap) {
        for (String next : dataMap.keySet()) {
            this.auL.put(next, dataMap.get(next));
        }
    }

    public void putAsset(String key, Asset value) {
        this.auL.put(key, value);
    }

    public void putBoolean(String key, boolean value) {
        this.auL.put(key, Boolean.valueOf(value));
    }

    public void putByte(String key, byte value) {
        this.auL.put(key, Byte.valueOf(value));
    }

    public void putByteArray(String key, byte[] value) {
        this.auL.put(key, value);
    }

    public void putDataMap(String key, DataMap value) {
        this.auL.put(key, value);
    }

    public void putDataMapArrayList(String key, ArrayList<DataMap> value) {
        this.auL.put(key, value);
    }

    public void putDouble(String key, double value) {
        this.auL.put(key, Double.valueOf(value));
    }

    public void putFloat(String key, float value) {
        this.auL.put(key, Float.valueOf(value));
    }

    public void putFloatArray(String key, float[] value) {
        this.auL.put(key, value);
    }

    public void putInt(String key, int value) {
        this.auL.put(key, Integer.valueOf(value));
    }

    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        this.auL.put(key, value);
    }

    public void putLong(String key, long value) {
        this.auL.put(key, Long.valueOf(value));
    }

    public void putLongArray(String key, long[] value) {
        this.auL.put(key, value);
    }

    public void putString(String key, String value) {
        this.auL.put(key, value);
    }

    public void putStringArray(String key, String[] value) {
        this.auL.put(key, value);
    }

    public void putStringArrayList(String key, ArrayList<String> value) {
        this.auL.put(key, value);
    }

    public Object remove(String key) {
        return this.auL.remove(key);
    }

    public int size() {
        return this.auL.size();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        for (String next : this.auL.keySet()) {
            m7456a(bundle, next, this.auL.get(next));
        }
        return bundle;
    }

    public byte[] toByteArray() {
        return C1718pm.m6092f(C1702pb.m5933a(this).avQ);
    }

    public String toString() {
        return this.auL.toString();
    }
}
