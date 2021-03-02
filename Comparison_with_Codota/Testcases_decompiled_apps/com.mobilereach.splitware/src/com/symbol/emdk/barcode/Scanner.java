package com.symbol.emdk.barcode;

public class Scanner {
    public TriggerType triggerType;

    public interface DataListener {
        void onData(ScanDataCollection scanDataCollection);
    }

    public interface StatusListener {
        void onStatus(StatusData statusData);
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class TriggerType extends Enum<TriggerType> {
        public static final TriggerType HARD = null;
        public static final TriggerType SOFT_ALWAYS = null;
        public static final TriggerType SOFT_ONCE = null;

        public static TriggerType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static TriggerType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public void addDataListener(DataListener dataListener) {
        throw new RuntimeException("stub");
    }

    public void addStatusListener(StatusListener statusListener) {
        throw new RuntimeException("stub");
    }

    public void cancelRead() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public void disable() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public void enable() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public ScannerConfig getConfig() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public InterfaceConfig getInterfaceConfig() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public ScannerInfo getScannerInfo() {
        throw new RuntimeException("stub");
    }

    public boolean isEnabled() {
        throw new RuntimeException("stub");
    }

    public boolean isReadPending() {
        throw new RuntimeException("stub");
    }

    public void read() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public void release() throws ScannerException {
        throw new RuntimeException("stub");
    }

    public void removeDataListener(DataListener dataListener) {
        throw new RuntimeException("stub");
    }

    public void removeStatusListener(StatusListener statusListener) {
        throw new RuntimeException("stub");
    }

    public void setConfig(ScannerConfig scannerConfig) throws ScannerException {
        throw new RuntimeException("stub");
    }

    public void setInterfaceConfig(InterfaceConfig interfaceConfig) throws ScannerException {
        throw new RuntimeException("stub");
    }
}
