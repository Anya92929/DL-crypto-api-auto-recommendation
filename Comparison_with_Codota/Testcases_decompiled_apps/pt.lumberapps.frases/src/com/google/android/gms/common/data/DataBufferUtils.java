package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
    private DataBufferUtils() {
    }

    public static ArrayList freezeAndClose(DataBuffer dataBuffer) {
        ArrayList arrayList = new ArrayList(dataBuffer.getCount());
        try {
            Iterator it = dataBuffer.iterator();
            while (it.hasNext()) {
                arrayList.add(((Freezable) it.next()).freeze());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(DataBuffer dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer dataBuffer) {
        Bundle zzarc = dataBuffer.zzarc();
        return (zzarc == null || zzarc.getString("next_page_token") == null) ? false : true;
    }

    public static boolean hasPrevPage(DataBuffer dataBuffer) {
        Bundle zzarc = dataBuffer.zzarc();
        return (zzarc == null || zzarc.getString("prev_page_token") == null) ? false : true;
    }
}
