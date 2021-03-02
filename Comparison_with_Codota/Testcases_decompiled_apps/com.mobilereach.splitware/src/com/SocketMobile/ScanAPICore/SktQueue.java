package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;

class SktQueue {
    private SktList m_List = new SktList();
    private SktPlatform.SktEvent m_ListNotEmpty = new SktPlatform.SktEvent();
    private boolean m_bInitialized = false;

    public long Initialize() {
        long result = 0;
        if (!this.m_bInitialized) {
            result = this.m_ListNotEmpty.Create(false, false);
            if (SktScanErrors.SKTSUCCESS(result)) {
                this.m_bInitialized = true;
            }
        }
        return result;
    }

    public long Deinitialize() {
        long result = this.m_ListNotEmpty.Delete();
        this.m_bInitialized = false;
        return result;
    }

    public long AddTail(Object pData) {
        long result = 0;
        if (!this.m_bInitialized) {
            result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = this.m_List.AddTail(pData);
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            return this.m_ListNotEmpty.Set();
        }
        return result;
    }

    public long RemoveHead(Object[] ppData) {
        long result = 0;
        if (!this.m_bInitialized) {
            result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = this.m_List.RemoveHead(ppData);
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            if (IsEmpty()) {
                this.m_ListNotEmpty.Reset();
            } else {
                this.m_ListNotEmpty.Set();
            }
        }
        return result;
    }

    public long WaitForNotEmpty(long ulTimeoutMilliseconds) {
        long result = 0;
        if (!this.m_bInitialized) {
            result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            return this.m_ListNotEmpty.Wait(ulTimeoutMilliseconds);
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public boolean IsEmpty() {
        return this.m_List.GetCount() == 0;
    }

    /* access modifiers changed from: package-private */
    public int GetCount() {
        return this.m_List.GetCount();
    }

    public static boolean Test() {
        boolean bResult = true;
        SktQueue Queue = new SktQueue();
        TSktScanObject[] pScanObj = new TSktScanObject[1];
        String[] pRetrieveData = new String[1];
        if ("5" != 0) {
            if (1 == 1) {
                bResult = SktDebug.DBGSKT_EXPECTING(Queue.AddTail("5"), "Queue.AddTail(pData)", -19);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Queue.RemoveHead(pRetrieveData), "Queue.RemoveHead(pRetrieveData)", -19);
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Queue.WaitForNotEmpty(10), "Queue.WaitForNotEmpty(10)", -19);
            }
        } else {
            bResult = false;
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Queue.Initialize(), "Queue.Initialize()", 0);
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Queue.WaitForNotEmpty(200), "Queue.WaitForNotEmpty(200)", 1);
        }
        if (bResult) {
            int i = 0;
            while (true) {
                if (i >= 10) {
                    break;
                }
                pScanObj[0] = new TSktScanObject();
                if (pScanObj[0] == null) {
                    bResult = false;
                    break;
                }
                pScanObj[0].Msg.MsgID = i;
                if (bResult) {
                    bResult = SktDebug.DBGSKT_EXPECTING(Queue.AddTail(pScanObj[0]), "Queue.AddTail(pScanObj[0])", 0);
                }
                if (!bResult) {
                    break;
                }
                i++;
            }
        }
        if (bResult) {
            int i2 = 0;
            while (true) {
                if (i2 >= 10) {
                    break;
                }
                if (bResult) {
                    bResult = SktDebug.DBGSKT_EXPECTING(Queue.WaitForNotEmpty(10), "Queue.WaitForNotEmpty(10)", 0);
                }
                pScanObj[0] = null;
                if (bResult) {
                    bResult = SktDebug.DBGSKT_EXPECTING(Queue.RemoveHead(pScanObj), "Queue.RemoveHead(pScanObj)", 0);
                }
                if (!bResult) {
                    break;
                }
                if (pScanObj[0] != null) {
                    int nMsgID = pScanObj[0].Msg.MsgID;
                    pScanObj[0] = null;
                    if (nMsgID != i2) {
                        bResult = false;
                        break;
                    }
                }
                i2++;
            }
        }
        if (bResult) {
            bResult = Queue.IsEmpty();
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Queue.WaitForNotEmpty(200), "Queue.WaitForNotEmpty(200)", 1);
        }
        if (!bResult) {
            while (SktScanErrors.SKTSUCCESS(Queue.RemoveHead(pScanObj))) {
                pScanObj[0] = null;
            }
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Queue.Deinitialize(), "Queue.Deinitialize()", 0);
        }
        if (bResult) {
            SktDebug.DBGSKT_MSG(1, "SktQueue Test pass");
        }
        return bResult;
    }
}
