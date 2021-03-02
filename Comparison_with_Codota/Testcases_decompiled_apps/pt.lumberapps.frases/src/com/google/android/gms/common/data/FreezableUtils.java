package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils {
    public static ArrayList freeze(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((Freezable) arrayList.get(i)).freeze());
        }
        return arrayList2;
    }

    public static ArrayList freeze(Freezable[] freezableArr) {
        ArrayList arrayList = new ArrayList(freezableArr.length);
        for (Freezable freeze : freezableArr) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }

    public static ArrayList freezeIterable(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((Freezable) it.next()).freeze());
        }
        return arrayList;
    }
}
