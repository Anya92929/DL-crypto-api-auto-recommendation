package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;

class SktThread {
    final int kSktTimeoutMax = 30000;
    Object m_Sync = new Object();
    Thread m_hThread = null;

    static class PrimeRun implements Runnable {
        public boolean m_stop;

        public PrimeRun(boolean b_stop) {
            this.m_stop = b_stop;
        }

        public void run() {
            while (!this.m_stop) {
                System.out.println("Thread running");
                Delay();
            }
        }

        public long stop() {
            this.m_stop = true;
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void Delay() {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    public long CreateThread(Runnable target) {
        long result = 0;
        synchronized (this.m_Sync) {
            if (this.m_hThread == null) {
                this.m_hThread = new Thread(target);
                if (this.m_hThread == null) {
                    result = -12;
                } else {
                    this.m_hThread.start();
                }
            } else {
                result = -13;
            }
        }
        return result;
    }

    public long DeleteThread() {
        synchronized (this.m_Sync) {
            if (this.m_hThread != null) {
                if (this.m_hThread.isAlive()) {
                    this.m_hThread.interrupt();
                    this.m_hThread = null;
                } else {
                    this.m_hThread = null;
                }
            }
        }
        return 0;
    }

    public synchronized long WaitForThreadTermination(long ulTimeoutMilliseconds) {
        long result;
        Thread hThread;
        result = 0;
        synchronized (this.m_Sync) {
            hThread = this.m_hThread;
        }
        if (hThread == null) {
            result = -11;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            if (ulTimeoutMilliseconds < 0 || ulTimeoutMilliseconds > 30000) {
                result = -20;
            } else {
                int count = ((int) ulTimeoutMilliseconds) / 100;
                int i = 0;
                while (i < count) {
                    try {
                        if (hThread.isAlive()) {
                            Thread.sleep(100);
                            i++;
                        }
                    } catch (InterruptedException e) {
                        result = -35;
                    }
                }
                if (hThread.isAlive()) {
                    result = 1;
                }
            }
        }
        return result;
    }

    static boolean Test() {
        boolean bResult = true;
        SktThread thread = new SktThread();
        PrimeRun p = new PrimeRun(false);
        if (1 == 1) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.DeleteThread(), "thread.DeleteThread()", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.WaitForThreadTermination(10), "thread.WaitForThreadTermination(10)", -11);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.CreateThread(p), "thread.CreateThread(p)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.WaitForThreadTermination(50000), "thread.WaitForThreadTermination(50000)", -20);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.WaitForThreadTermination(10), "thread.WaitForThreadTermination(10)", 1);
        }
        if (bResult && p.m_stop) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.DeleteThread(), "thread.DeleteThread()", -14);
        }
        if (bResult) {
            p.stop();
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.WaitForThreadTermination(200), "thread.WaitForThreadTermination(200)", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.CreateThread(p), "thread.CreateThread(p)", -13);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.DeleteThread(), "thread.DeleteThread()", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(thread.CreateThread(p), "thread.CreateThread(p)", 0);
        }
        if (bResult) {
            p.stop();
            bResult = SktDebug.DBGSKT_EXPECTING(thread.WaitForThreadTermination(100), "thread.WaitForThreadTermination(100)", 0);
        }
        if (bResult) {
            return SktDebug.DBGSKT_EXPECTING(thread.DeleteThread(), "thread.DeleteThread()", 0);
        }
        return bResult;
    }
}
