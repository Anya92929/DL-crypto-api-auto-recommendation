package com.SocketMobile.ScanAPICore;

import android.bluetooth.BluetoothAdapter;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

final class SktPlatform {
    static final String SKTDEBUG_MODULE_NAME = "SktPlatform";
    static final int kSktTimeoutMax = 30000;
    static final int kSktTryLockTimeout = 2000;
    final long kSktMaxSerialName = 256;

    SktPlatform() {
    }

    static class SktBluetoothAdapter {
        /* access modifiers changed from: private */
        public static BluetoothAdapter _sbluetoothAdapter;

        SktBluetoothAdapter() {
        }

        public static synchronized void initializeDefaultBluetoothAdapter() {
            synchronized (SktBluetoothAdapter.class) {
                final boolean[] ok = {false};
                if (_sbluetoothAdapter == null) {
                    new Thread() {
                        public void run() {
                            setName("BluetoothAdapterDaemon");
                            Looper.prepare();
                            BluetoothAdapter unused = SktBluetoothAdapter._sbluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                            synchronized (ok) {
                                ok[0] = true;
                                ok.notify();
                            }
                            Looper.loop();
                        }
                    }.start();
                    synchronized (ok) {
                        if (!ok[0]) {
                            try {
                                ok.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    static class SktOutput {
        public static final int kDebug = 1;
        public static final int kError = 3;
        public static final int kWarning = 2;

        SktOutput() {
        }

        public static void print(int level, String tag, String text) {
            if (level == 1) {
                Log.d(tag, text);
            } else if (level == 2) {
                Log.w(tag, text);
            } else if (level == 3) {
                Log.e(tag, text);
            } else {
                Log.i(tag, text);
            }
        }
    }

    static class SktMutex {
        Thread m_CurrentOwner = null;
        boolean m_bInitialized = false;
        boolean m_bSignaled = false;
        int m_nCount = 0;

        public long Create(boolean bSignaled) {
            if (this.m_bInitialized) {
                return -25;
            }
            this.m_bSignaled = bSignaled;
            this.m_bInitialized = true;
            return 0;
        }

        public long Delete() {
            if (this.m_bInitialized) {
                this.m_bSignaled = false;
                this.m_bInitialized = false;
            }
            return 0;
        }

        /* access modifiers changed from: protected */
        public long waitForSingleObject(long ulTimeout) {
            long Result = 0;
            boolean bWait = false;
            if (!this.m_bInitialized) {
                Result = -19;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                synchronized (this) {
                    if (this.m_nCount == 0) {
                        this.m_CurrentOwner = Thread.currentThread();
                        this.m_nCount++;
                        reset();
                    } else if (this.m_CurrentOwner == Thread.currentThread()) {
                        this.m_nCount++;
                    } else {
                        bWait = true;
                    }
                    while (true) {
                        if (bWait) {
                            try {
                                long t1 = System.currentTimeMillis();
                                wait(ulTimeout);
                                long t2 = System.currentTimeMillis();
                                if (t2 >= t1 + ulTimeout) {
                                    Result = 1;
                                    break;
                                } else if (this.m_bSignaled) {
                                    this.m_CurrentOwner = Thread.currentThread();
                                    this.m_nCount = 1;
                                    reset();
                                    break;
                                } else {
                                    ulTimeout = (t1 + ulTimeout) - t2;
                                }
                            } catch (InterruptedException e) {
                                Result = -35;
                            } catch (IllegalMonitorStateException e2) {
                                Result = -35;
                            }
                        }
                    }
                    break;
                }
            }
            return Result;
        }

        public synchronized long releaseMutex() {
            long Result;
            Result = 0;
            if (this.m_CurrentOwner == null) {
                Result = -17;
            } else if (this.m_CurrentOwner == Thread.currentThread()) {
                if (this.m_nCount > 0) {
                    this.m_nCount--;
                    if (this.m_nCount == 0) {
                        this.m_CurrentOwner = null;
                        signal();
                    }
                } else {
                    Result = 2;
                }
            }
            return Result;
        }

        /* access modifiers changed from: protected */
        public synchronized void signal() {
            this.m_bSignaled = true;
            notify();
        }

        /* access modifiers changed from: protected */
        public synchronized void reset() {
            this.m_bSignaled = false;
        }

        static boolean Test() {
            return true;
        }
    }

    static class SktLock {
        private SktMutex m_Mutex;

        public long Initialize() {
            this.m_Mutex = new SktMutex();
            if (SktScanErrors.SKTSUCCESS(0)) {
                return SktDebug.DBGSKT_EVAL(this.m_Mutex.Create(false), "m_Mutex.Create(false)");
            }
            return 0;
        }

        public long Deinitialize() {
            if (this.m_Mutex != null) {
                this.m_Mutex.Delete();
            }
            this.m_Mutex = null;
            return 0;
        }

        public long Lock() {
            long Result = 0;
            if (this.m_Mutex == null) {
                Result = -19;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                return SktDebug.DBGSKT_EVAL(this.m_Mutex.waitForSingleObject(2000), "m_Mutex.waitForSingleObject(kSktTryLockTimeout)");
            }
            return Result;
        }

        public long Unlock() {
            if (this.m_Mutex == null || SktScanErrors.SKTSUCCESS(this.m_Mutex.releaseMutex())) {
                return 0;
            }
            return -5;
        }

        static boolean Test() {
            boolean bResult = true;
            SktLock Lock = new SktLock();
            if (1 == 1 && Lock.Lock() != -19) {
                bResult = false;
            }
            if (bResult && Lock.Unlock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Initialize() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Unlock() != -5) {
                bResult = false;
            }
            if (bResult && Lock.Unlock() != -5) {
                bResult = false;
            }
            if (bResult && Lock.Lock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Unlock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Lock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Lock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Unlock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Unlock() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Deinitialize() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Deinitialize() != 0) {
                bResult = false;
            }
            if (bResult && Lock.Lock() != -19) {
                bResult = false;
            }
            if (!bResult || Lock.Unlock() == 0) {
                return bResult;
            }
            return false;
        }
    }

    static class SktEvent {
        static final int INTERRUPT = 3;
        static final int NOTOWNED = 2;
        static final int SUCCESS = 0;
        static final int TIMEOUT = 1;
        boolean bAuto = false;
        boolean bCreated = false;
        boolean bSignaled = false;
        Object sync = this;

        public long Create(boolean bManual, boolean bSignaled2) {
            this.bSignaled = bSignaled2;
            this.bAuto = !bManual;
            this.bCreated = true;
            return 0;
        }

        public long CreateNamedEvent(String name, boolean bManual, boolean bSignaled2) {
            this.bSignaled = bSignaled2;
            this.bAuto = !bManual;
            this.bCreated = true;
            return 0;
        }

        public long Delete() {
            this.bSignaled = false;
            this.bAuto = false;
            this.bCreated = false;
            this.sync = this;
            return 0;
        }

        public long Set() {
            if (!this.bCreated) {
                return -10;
            }
            synchronized (this.sync) {
                this.bSignaled = true;
                if (this.bAuto) {
                    this.sync.notify();
                } else {
                    this.sync.notifyAll();
                }
            }
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
            if (r13.bSignaled != false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
            r2 = 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long Wait(long r14) {
            /*
                r13 = this;
                r2 = 0
                boolean r1 = r13.bCreated
                if (r1 != 0) goto L_0x0008
                r2 = -10
            L_0x0008:
                boolean r1 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
                if (r1 == 0) goto L_0x001c
                r8 = 0
                int r1 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
                if (r1 < 0) goto L_0x001a
                r8 = 30000(0x7530, double:1.4822E-319)
                int r1 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
                if (r1 <= 0) goto L_0x001c
            L_0x001a:
                r2 = -20
            L_0x001c:
                boolean r1 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
                if (r1 == 0) goto L_0x004a
                java.lang.Object r8 = r13.sync
                monitor-enter(r8)
            L_0x0025:
                boolean r1 = r13.bSignaled     // Catch:{ all -> 0x008e }
                if (r1 != 0) goto L_0x0042
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x004b, IllegalMonitorStateException -> 0x006a }
                java.lang.Object r1 = r13.sync     // Catch:{ InterruptedException -> 0x004b, IllegalMonitorStateException -> 0x006a }
                r1.wait(r14)     // Catch:{ InterruptedException -> 0x004b, IllegalMonitorStateException -> 0x006a }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x004b, IllegalMonitorStateException -> 0x006a }
                long r10 = r4 + r14
                int r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
                if (r1 < 0) goto L_0x0089
                boolean r1 = r13.bSignaled     // Catch:{ all -> 0x008e }
                if (r1 != 0) goto L_0x0042
                r2 = 1
            L_0x0042:
                boolean r1 = r13.bAuto     // Catch:{ all -> 0x008e }
                if (r1 == 0) goto L_0x0049
                r13.Reset()     // Catch:{ all -> 0x008e }
            L_0x0049:
                monitor-exit(r8)     // Catch:{ all -> 0x008e }
            L_0x004a:
                return r2
            L_0x004b:
                r0 = move-exception
                r1 = 4
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
                r9.<init>()     // Catch:{ all -> 0x008e }
                java.lang.String r10 = "Error during wait: "
                java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x008e }
                java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x008e }
                java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x008e }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x008e }
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r1, r9)     // Catch:{ all -> 0x008e }
                r2 = -35
                goto L_0x0042
            L_0x006a:
                r0 = move-exception
                r1 = 4
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
                r9.<init>()     // Catch:{ all -> 0x008e }
                java.lang.String r10 = "Error during wait: "
                java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x008e }
                java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x008e }
                java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x008e }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x008e }
                com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_MSG(r1, r9)     // Catch:{ all -> 0x008e }
                r2 = -35
                goto L_0x0042
            L_0x0089:
                long r10 = r4 + r14
                long r14 = r10 - r6
                goto L_0x0025
            L_0x008e:
                r1 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x008e }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktPlatform.SktEvent.Wait(long):long");
        }

        public long Reset() {
            if (!this.bCreated) {
                return -10;
            }
            synchronized (this.sync) {
                this.bSignaled = false;
            }
            return 0;
        }

        public void SetSync(Object newSync) {
            this.sync = newSync;
        }

        static boolean Test() {
            boolean bResult = true;
            SktEvent Event = new SktEvent();
            if (1 == 1) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Set(), "Event.Set()", -10);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(10), "Event.Wait(10)", -10);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Create(false, false), "Event.Create(false, false)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(50000), "Event.Wait(50000)", -20);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 1);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Set(), "Event.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(-1), "Event.Wait((long)-1)", -20);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 1);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Set(), "Event.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Set(), "Event.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 1);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Reset(), "Event.Reset()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 1);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Set(), "Event.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event.Reset(), "Event.Reset()", 0);
            }
            if (bResult) {
                return SktDebug.DBGSKT_EXPECTING(Event.Wait(100), "Event.Wait(100)", 1);
            }
            return bResult;
        }
    }

    static class SktFlipFlop {
        private SktEvent m_FlipEvent = new SktEvent();
        private SktEvent m_FlopEvent = new SktEvent();
        private boolean m_bCreated = false;

        static class State {
            /* access modifiers changed from: private */
            public SktEvent _event;

            State() {
            }
        }

        public long Create(String pszName) {
            long Result = 0;
            if (pszName == null || pszName.length() == 0) {
                Result = -18;
            }
            String pszEventName = pszName + "1";
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_FlipEvent.CreateNamedEvent(pszEventName, false, false), "m_FlipEvent.CreateNamedEvent(pszEventName,false,false)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pszEventName = pszName + "2";
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_FlopEvent.CreateNamedEvent(pszEventName, false, false), "m_FlopEvent.CreateNamedEvent(pszEventName,false,false)");
            }
            this.m_bCreated = SktScanErrors.SKTSUCCESS(Result);
            return Result;
        }

        public long Delete() {
            this.m_bCreated = false;
            return 0;
        }

        public long Signal(State state) {
            SktEvent pResetEvent;
            long Result = 0;
            SktEvent[] pEvent = new SktEvent[1];
            if (!this.m_bCreated) {
                Result = -19;
            } else if (state == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveEventFromState(state, pEvent), "RetrieveEventFromState(pState,pEvent)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pEvent[0] == this.m_FlipEvent) {
                    pResetEvent = this.m_FlopEvent;
                } else {
                    pResetEvent = this.m_FlipEvent;
                }
                pResetEvent.Reset();
                pEvent[0].Set();
                SktEvent unused = state._event = pResetEvent;
            }
            return Result;
        }

        public long Wait(State state, long ulTimeoutMilliseconds) {
            long Result = 0;
            SktEvent[] pEvent = new SktEvent[1];
            if (!this.m_bCreated) {
                Result = -19;
            } else if (state == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveEventFromState(state, pEvent), "RetrieveEventFromState(state,pEvent)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pEvent[0].Wait(ulTimeoutMilliseconds), "pEvent[0].Wait(ulTimeoutMilliseconds)");
            }
            if (SktScanErrors.SKTSUCCESS(Result) && Result != 1) {
                if (pEvent[0] == this.m_FlipEvent) {
                    pEvent[0] = this.m_FlopEvent;
                } else {
                    pEvent[0] = this.m_FlipEvent;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktEvent unused = state._event = pEvent[0];
            }
            return Result;
        }

        public static boolean Test() {
            SktDebug.DBGSKT_MSG(1, "SktFlipFlop Test pass");
            return true;
        }

        /* access modifiers changed from: protected */
        public long RetrieveEventFromState(State State2, SktEvent[] ppEvent) {
            long Result = 0;
            ppEvent[0] = State2._event;
            if (ppEvent[0] == this.m_FlipEvent || ppEvent[0] == this.m_FlopEvent) {
                ppEvent[0] = State2._event;
            } else {
                Result = this.m_FlipEvent.Wait(1);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (Result != 1) {
                        ppEvent[0] = this.m_FlopEvent;
                    } else {
                        ppEvent[0] = this.m_FlipEvent;
                    }
                }
            }
            return Result;
        }
    }

    static class SktWait {
        protected SktList m_EventParamsList = new SktList();

        class SktEventParam {
            public SktEvent _Event = null;
            public Object _Param = null;

            public SktEventParam() {
            }
        }

        public long AddEvent(SktEvent Event, Object pParam) {
            long Result = 0;
            if (Event == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktList.Position position = this.m_EventParamsList.GetHeadPosition();
                while (true) {
                    if (!position.IsValid()) {
                        break;
                    }
                    SktEventParam pCurrentEventParam = (SktEventParam) position.GetNext();
                    if (SktScanErrors.SKTSUCCESS(Result) && pCurrentEventParam._Event == Event) {
                        pCurrentEventParam._Param = pParam;
                        Result = 2;
                        break;
                    }
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result) || Result == 2) {
                return Result;
            }
            SktEventParam NewEventParam = new SktEventParam();
            if (NewEventParam == null) {
                Result = -2;
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            NewEventParam._Event = Event;
            NewEventParam._Param = pParam;
            Event.SetSync(this);
            return SktDebug.DBGSKT_EVAL(this.m_EventParamsList.AddTail(NewEventParam), "m_EventParamsList.AddTail(NewEventParam)");
        }

        public long RemoveAllEvent() {
            SktEventParam[] EventParam = new SktEventParam[1];
            while (SktScanErrors.SKTSUCCESS(this.m_EventParamsList.RemoveHead(EventParam))) {
                EventParam[0]._Event.SetSync(EventParam[0]._Event);
                EventParam[0] = null;
            }
            return 0;
        }

        public long Wait(long ulTimeoutInMilliSeconds, Object[] param) {
            long t1;
            long t2;
            long result = 0;
            boolean bSignaled = false;
            if (this.m_EventParamsList.GetCount() == 0) {
                result = -6;
            }
            if (!SktScanErrors.SKTSUCCESS(result)) {
                return result;
            }
            SktList.Position position = this.m_EventParamsList.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                SktEventParam EventParam = (SktEventParam) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(result) && EventParam._Event.bSignaled) {
                    if (param != null) {
                        param[0] = EventParam._Param;
                    }
                    if (EventParam._Event.bAuto) {
                        EventParam._Event.Reset();
                    }
                    bSignaled = true;
                }
            }
            while (!bSignaled) {
                try {
                    synchronized (this) {
                        t1 = System.currentTimeMillis();
                        wait(ulTimeoutInMilliSeconds);
                        t2 = System.currentTimeMillis();
                    }
                    SktList.Position position2 = this.m_EventParamsList.GetHeadPosition();
                    while (true) {
                        if (!position2.IsValid()) {
                            break;
                        }
                        SktEventParam EventParam2 = (SktEventParam) position2.GetNext();
                        if (SktScanErrors.SKTSUCCESS(result) && EventParam2._Event.bSignaled) {
                            bSignaled = true;
                            if (param != null) {
                                param[0] = EventParam2._Param;
                            }
                            if (EventParam2._Event.bAuto) {
                                EventParam2._Event.Reset();
                            }
                        }
                    }
                    if (t2 < t1 + ulTimeoutInMilliSeconds) {
                        ulTimeoutInMilliSeconds = (t1 + ulTimeoutInMilliSeconds) - t2;
                    } else if (!bSignaled) {
                        return 1;
                    } else {
                        return result;
                    }
                } catch (InterruptedException e) {
                    return -35;
                }
            }
            return result;
        }

        public long RemoveEvents(Object Param) {
            long Result = 0;
            SktEventParam[] EventParam = new SktEventParam[1];
            boolean bFound = false;
            SktList.Position position = this.m_EventParamsList.GetHeadPosition();
            while (position.IsValid()) {
                SktList.Position removePosition = position.Copy();
                EventParam[0] = (SktEventParam) position.GetNext();
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    break;
                } else if (EventParam[0]._Param == Param) {
                    EventParam[0]._Event.SetSync(EventParam[0]._Event);
                    Result = SktDebug.DBGSKT_EVAL(this.m_EventParamsList.RemoveAt(removePosition, EventParam), "m_EventParamsList.RemoveAt(removePosition,EventParam)");
                    bFound = true;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result) || bFound) {
                return Result;
            }
            return 2;
        }

        /* access modifiers changed from: package-private */
        public int GetEventCount() {
            return this.m_EventParamsList.GetCount();
        }

        public static boolean Test() {
            boolean bResult = true;
            SktWait Wait = new SktWait();
            SktEvent Event1 = new SktEvent();
            SktEvent Event2 = new SktEvent();
            SktEvent Event3 = new SktEvent();
            Integer Param1 = new Integer(1);
            Integer Param2 = new Integer(2);
            Integer Param3 = new Integer(3);
            if (1 == 1) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.AddEvent((SktEvent) null, Param1), "Wait.AddEvent(null,Param1)", -18);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event1.Create(false, false), "Event1.Create(false,false)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event2.Create(false, false), "Event2.Create(false,false)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event3.Create(false, false), "Event3.Create(false,false)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.AddEvent(Event1, Param1), "Wait.AddEvent(Event1,Param1)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.AddEvent(Event2, Param2), "Wait.AddEvent(Event2,Param2)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.AddEvent(Event3, Param3), "Wait.AddEvent(Event3,Param3)", 0);
            }
            if (bResult && Wait.GetEventCount() != 3) {
                SktDebug.DBGSKT_MSG(4, "The Wait doesn't have the expected event count: " + Wait.GetEventCount() + " instead of 3");
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(200, (Object[]) null), "Wait.Wait(200,null)", 1);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event2.Set(), "Event2.Set()", 0);
            }
            Object[] param = new Object[1];
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(10, param), "Wait.Wait(10,param)", 0);
            }
            if (bResult && param[0] != Param2) {
                SktDebug.DBGSKT_MSG(4, "The Wait didn't return the expected event " + param[0] + " instead of 2");
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event1.Set(), "Event1.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(10, param), "Wait.Wait(10,param)", 0);
            }
            if (bResult && param[0] != Param1) {
                SktDebug.DBGSKT_MSG(4, "The Wait didn't return the expected event " + param[0] + " instead of " + Param1);
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event3.Set(), "Event3.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(10, param), "Wait.Wait(10,param)", 0);
            }
            if (bResult && param[0] != Param3) {
                SktDebug.DBGSKT_MSG(4, "The Wait didn't return the expected event " + param[0] + " instead of " + Param3);
                bResult = false;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Event2.Set(), "Event2.Set()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(10, (Object[]) null), "Wait.Wait(10,null)", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(200, (Object[]) null), "Wait.Wait(200,null)", 1);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.RemoveAllEvent(), "Wait.RemoveAllEvent()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.RemoveAllEvent(), "Wait.RemoveAllEvent()", 0);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Wait.Wait(10, (Object[]) null), "Wait.Wait(10,null)", -6);
            }
            if (bResult) {
                SktDebug.DBGSKT_MSG(1, "SktWait Test pass");
            }
            return bResult;
        }
    }

    static class SktGuid {
        static int basenum = 0;

        SktGuid() {
        }

        private static String GetLong8(String source) {
            if (source.length() < 8) {
                return "00000000".substring(0, 8 - source.length()) + source;
            }
            return source.substring(0, 8);
        }

        public static long Create(String[] stringGuid) {
            long result = 0;
            if (stringGuid == null) {
                result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(result)) {
                Random rdm = new Random(((long) basenum) + System.currentTimeMillis() + ((long) "android_id".hashCode()));
                String str1 = GetLong8(Integer.toHexString(rdm.nextInt()));
                String str2 = GetLong8(Integer.toHexString(rdm.nextInt()));
                String str3 = GetLong8(Integer.toHexString(rdm.nextInt()));
                stringGuid[0] = new String(str1 + "-" + str2.substring(0, 4) + "-" + str2.substring(4, 8) + "-" + str3.substring(0, 4) + "-" + str2.substring(4, 8) + GetLong8(Integer.toHexString(rdm.nextInt())));
                basenum++;
                SktDebug.DBGSKT_MSG(1, "NEW GUID:" + stringGuid[0]);
            }
            return result;
        }

        public static long Copy(String[] destination, String source) {
            long Result = 0;
            if (destination == null || source == null) {
                Result = -18;
            }
            if (Result == 0) {
                destination[0] = source;
            }
            return Result;
        }

        static boolean Test() {
            boolean bResult = true;
            String[] Guid = new String[1];
            String[] Guid1 = new String[1];
            if (1 == 1 && Create(Guid) != 0) {
                bResult = false;
            }
            if (bResult && Create(Guid1) != 0) {
                bResult = false;
            }
            if (bResult && Guid[0].equals(Guid1[0])) {
                bResult = false;
            }
            if (bResult) {
                SktDebug.DBGSKT_MSG(1, "SktGuid Test pass");
            }
            return bResult;
        }
    }

    public static class SktFile {
        public static final int READ = 1;
        public static final int READ_WRITE = 3;
        public static final int WRITE = 2;
        private File m_hFile = null;

        public long Open(String fileName, int mode) {
            Close();
            this.m_hFile = new File(fileName);
            if (this.m_hFile.exists()) {
                return 0;
            }
            if (mode > 1) {
                try {
                    this.m_hFile.createNewFile();
                    return 0;
                } catch (IOException e) {
                    this.m_hFile = null;
                    SktDebug.DBGSKT_MSG(4, "unable to open " + fileName + " " + e.getMessage());
                    return -53;
                }
            } else {
                this.m_hFile = null;
                SktDebug.DBGSKT_MSG(4, "unable to open " + fileName + " it doesn't exist");
                return -53;
            }
        }

        public long Close() {
            if (this.m_hFile != null) {
                this.m_hFile = null;
            }
            return 0;
        }

        public long GetLength() {
            if (this.m_hFile == null) {
                return 0;
            }
            try {
                return this.m_hFile.length();
            } catch (SecurityException e) {
                e.printStackTrace();
                return 0;
            }
        }

        public long Read(byte[] pBuffer, long ulBufferSize, long[] pulSizeRead) {
            try {
                FileInputStream input = new FileInputStream(this.m_hFile);
                input.read(pBuffer);
                pulSizeRead[0] = (long) pBuffer.length;
                input.close();
                return 0;
            } catch (IOException e) {
                return -34;
            }
        }

        public long Write(byte[] pBuffer, long ulBufferSize, long pulSizeWritten) {
            try {
                FileOutputStream output = new FileOutputStream(this.m_hFile);
                output.write(pBuffer);
                output.flush();
                output.close();
                return 0;
            } catch (Exception e) {
                return -34;
            }
        }

        static long Delete(String pszPathName, String pszFileName) {
            String pszFullPathName;
            long Result = 0;
            if (pszFileName.length() == 0) {
                Result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            if (pszPathName.length() != 0) {
                pszFullPathName = pszPathName + pszFileName;
            } else {
                pszFullPathName = pszFileName;
            }
            try {
                File file = new File(pszFullPathName.toString());
                if (!file.exists()) {
                    return -53;
                }
                file.delete();
                return Result;
            } catch (SecurityException e) {
                SktDebug.DBGSKT_MSG(4, "Security Exception " + e.getMessage() + " while deleting " + pszFullPathName.toString());
                return -56;
            }
        }

        static boolean Test() {
            SktDebug.DBGSKT_MSG(1, "SktFile Test pass");
            return true;
        }
    }

    static class SktSystem {
        SktSystem() {
        }

        public static long ReadApplicationDataPath(String[] applicationDataPath, int nLength) {
            applicationDataPath[0] = GetRootPath();
            if (!SktScanErrors.SKTSUCCESS(0)) {
                return 0;
            }
            applicationDataPath[0] = applicationDataPath[0] + "/SocketMobile/";
            if (!SktDirectory.DoesExist(applicationDataPath[0])) {
                return SktDebug.DBGSKT_EVAL(SktDirectory.Create(applicationDataPath[0]), "SktDirectory.Create(applicationDataPath[0])");
            }
            return 0;
        }

        public static long ReadTempPath(String[] tempPath, int nLength) {
            long Result = 0;
            if (tempPath == null) {
                Result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            tempPath[0] = GetRootPath() + "/temp/";
            SktDebug.DBGSKT_MSG(1, "ReadTempPath: Root path: " + tempPath[0]);
            try {
                File fc = new File(tempPath[0]);
                try {
                    if (!fc.exists()) {
                        SktDebug.DBGSKT_MSG(1, "the path: " + tempPath[0] + " doesn't exist so create it here");
                        if (!fc.mkdirs()) {
                            SktDebug.DBGSKT_MSG(4, "unable to create: " + tempPath[0]);
                            Result = -54;
                        }
                    }
                    File file = fc;
                    return Result;
                } catch (SecurityException e) {
                    File file2 = fc;
                    SktDebug.DBGSKT_MSG(4, "Security Error trying to open: " + tempPath[0].toString());
                    return -54;
                }
            } catch (SecurityException e2) {
                SktDebug.DBGSKT_MSG(4, "Security Error trying to open: " + tempPath[0].toString());
                return -54;
            }
        }

        private static String GetRootPath() {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return Environment.getExternalStorageDirectory().getPath();
            }
            SktDebug.DBGSKT_MSG(1, "The SD Storage is not mounted so let's use the /data/data/com.SocketMobile.ScanAPICore Directory");
            return Environment.getDataDirectory().getPath() + "/data/com.SocketMobile.ScanAPICore";
        }

        static void sleep(long timeoutInMilliseconds) {
            try {
                Thread.sleep(timeoutInMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SktDirectory {
        SktDirectory() {
        }

        public static long Create(String pszDirectory) {
            long Result = 0;
            if (pszDirectory.length() == 0) {
                Result = -18;
            }
            try {
                File Dir = new File(pszDirectory);
                if (Dir.exists()) {
                    return Result;
                }
                SktDebug.DBGSKT_MSG(1, "Directory " + pszDirectory.toString() + " doesn't exist so we create it here");
                SktDebug.DBGSKT_MSG(1, "Directory " + Dir.getName());
                SktDebug.DBGSKT_MSG(1, "Directory " + Dir.getPath());
                if (Dir.mkdirs()) {
                    return Result;
                }
                SktDebug.DBGSKT_MSG(4, "unable to create " + pszDirectory.toString());
                return -55;
            } catch (Exception e) {
                SktDebug.DBGSKT_MSG(4, "Exception " + e.getMessage());
                SktDebug.DBGSKT_MSG(4, "unable to create " + pszDirectory.toString());
                return -55;
            }
        }

        public static boolean DoesExist(String pszDirectory) {
            try {
                if (new File(pszDirectory).exists()) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
