package com.SocketMobile.ScanAPICore;

class SktDeviceInterfacePropertyContext {
    int m_Destination = 1;
    boolean m_bOperationGet = false;
    Object m_pOriginalContext = null;
    long m_ulTickCountSent = 0;

    interface ESktDestination {
        public static final int kSktDestinationApp = 1;
        public static final int kSktDestinationScanAPI = 0;
    }

    public void SetContext(Object Context) {
        this.m_pOriginalContext = Context;
    }

    public Object GetContext() {
        return this.m_pOriginalContext;
    }

    /* access modifiers changed from: package-private */
    public void SetDestination(int Destination) {
        this.m_Destination = Destination;
    }

    public int GetDestination() {
        return this.m_Destination;
    }

    public void SetTickCount(long ulTickCount) {
        this.m_ulTickCountSent = ulTickCount;
    }

    public long GetTickCount() {
        return this.m_ulTickCountSent;
    }

    public void SetRequestOperation(boolean bGet) {
        this.m_bOperationGet = bGet;
    }

    public boolean GetRequestOperation() {
        return this.m_bOperationGet;
    }
}
