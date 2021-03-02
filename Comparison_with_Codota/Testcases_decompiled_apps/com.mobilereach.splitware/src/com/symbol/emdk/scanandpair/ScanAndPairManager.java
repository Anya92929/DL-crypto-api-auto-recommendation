package com.symbol.emdk.scanandpair;

import com.symbol.emdk.EMDKBase;

public class ScanAndPairManager extends EMDKBase {
    public ScanAndPairConfig config;

    public interface StatusListener {
        void onStatus(StatusData statusData);
    }

    /* renamed from: com.symbol.emdk.scanandpair.ScanAndPairManager$1 */
    class C03891 implements Runnable {
        public void run() {
            throw new RuntimeException("stub");
        }
    }

    public void addStatusListener(StatusListener statusListener) throws ScanAndPairException {
        throw new RuntimeException("stub");
    }

    public StatusData getStatus() {
        throw new RuntimeException("stub");
    }

    public boolean isPreviousCommandPending() {
        throw new RuntimeException("stub");
    }

    public void removeStatusListener(StatusListener statusListener) throws ScanAndPairException {
        throw new RuntimeException("stub");
    }

    public ScanAndPairResults scanAndPair(String str) {
        throw new RuntimeException("stub");
    }

    public ScanAndPairResults scanAndUnpair() {
        throw new RuntimeException("stub");
    }
}
