package com.symbol.emdk;

public class VersionManager extends EMDKBase {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class VERSION_TYPE extends Enum<VERSION_TYPE> {
        public static final VERSION_TYPE BARCODE = null;
        public static final VERSION_TYPE EMDK = null;

        /* renamed from: MX */
        public static final VERSION_TYPE f27MX = null;

        public static VERSION_TYPE valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static VERSION_TYPE[] values() {
            throw new RuntimeException("stub");
        }
    }

    public String getVersion(VERSION_TYPE version_type) {
        throw new RuntimeException("stub");
    }
}
