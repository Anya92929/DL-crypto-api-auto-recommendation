package com.symbol.emdk.barcode;

public class StatusData {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ScannerStates extends Enum<ScannerStates> {
        public static final ScannerStates DISABLED = null;
        public static final ScannerStates ERROR = null;
        public static final ScannerStates IDLE = null;
        public static final ScannerStates SCANNING = null;
        public static final ScannerStates WAITING = null;

        public static ScannerStates valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ScannerStates[] values() {
            throw new RuntimeException("stub");
        }
    }

    public String getFriendlyName() {
        throw new RuntimeException("stub");
    }

    public ScannerStates getState() {
        throw new RuntimeException("stub");
    }
}
