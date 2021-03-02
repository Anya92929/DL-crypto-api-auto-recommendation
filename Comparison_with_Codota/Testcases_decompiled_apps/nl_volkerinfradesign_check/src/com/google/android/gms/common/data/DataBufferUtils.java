package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;

public final class DataBufferUtils {
    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        ArrayList<T> arrayList = new ArrayList<>(dataBuffer.getCount());
        try {
            for (E freeze : dataBuffer) {
                arrayList.add(freeze.freeze());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        Bundle zzpZ = dataBuffer.zzpZ();
        return (zzpZ == null || zzpZ.getString("next_page_token") == null) ? false : true;
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        Bundle zzpZ = dataBuffer.zzpZ();
        return (zzpZ == null || zzpZ.getString("prev_page_token") == null) ? false : true;
    }
}
