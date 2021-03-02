package com.symbol.emdk;

import android.content.Context;

public class EMDKManager {

    public interface EMDKListener {
        void onClosed();

        void onOpened(EMDKManager eMDKManager);
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class FEATURE_TYPE extends Enum<FEATURE_TYPE> {
        public static final FEATURE_TYPE BARCODE = null;
        public static final FEATURE_TYPE PAYMENT = null;
        public static final FEATURE_TYPE PROFILE = null;
        public static final FEATURE_TYPE SCANANDPAIR = null;
        public static final FEATURE_TYPE VERSION = null;

        public static FEATURE_TYPE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static FEATURE_TYPE[] values() {
            throw new RuntimeException("stub");
        }
    }

    public static EMDKResults getEMDKManager(Context context, EMDKListener eMDKListener) {
        throw new RuntimeException("stub");
    }

    public EMDKBase getInstance(FEATURE_TYPE feature_type) {
        throw new RuntimeException("stub");
    }

    public void release() {
        throw new RuntimeException("stub");
    }

    public void release(FEATURE_TYPE feature_type) {
        throw new RuntimeException("stub");
    }
}
