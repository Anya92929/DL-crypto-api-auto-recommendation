package com.symbol.emdk.scanandpair;

public class StatusData {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ScanAndPairStates extends Enum<ScanAndPairStates> {
        public static final ScanAndPairStates DISCOVERING = null;
        public static final ScanAndPairStates ERROR = null;
        public static final ScanAndPairStates PAIRED = null;
        public static final ScanAndPairStates SCANNING = null;
        public static final ScanAndPairStates UNDEFINED = null;
        public static final ScanAndPairStates UNPAIRED = null;
        public static final ScanAndPairStates WAITING = null;

        public static ScanAndPairStates valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ScanAndPairStates[] values() {
            throw new RuntimeException("stub");
        }
    }

    public StatusData() {
        throw new RuntimeException("stub");
    }

    public ScanAndPairResults getResult() {
        throw new RuntimeException("stub");
    }

    public ScanAndPairStates getState() {
        throw new RuntimeException("stub");
    }
}
