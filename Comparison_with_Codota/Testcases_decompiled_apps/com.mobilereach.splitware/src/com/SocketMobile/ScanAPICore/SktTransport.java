package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPICore.SktPlatform;

abstract class SktTransport {
    public static final int kBufferSizeMax = 2048;
    public static final int kSktIoCtlGetModemStatus = 1;
    public static final int kSktModemStatusRsld = 128;
    protected String _deviceName = null;
    protected SktPlatform.SktEvent m_IoControlCompletionEvent = new SktPlatform.SktEvent();
    protected SktPlatform.SktEvent m_ReadCompletionEvent = new SktPlatform.SktEvent();
    protected SktPlatform.SktEvent m_WriteCompletionEvent = new SktPlatform.SktEvent();
    protected boolean m_bConnected = false;

    public abstract long Close();

    public abstract long ConfigureTimeouts(TSktTransportTimeouts tSktTransportTimeouts);

    public abstract long IoControl(int i, Object obj, int i2, Object obj2, int[] iArr);

    public abstract long Open(String str, boolean z);

    public abstract long ReadBlock(char[] cArr, int i, int[] iArr);

    public abstract long WriteBlock(char[] cArr, int i, int[] iArr);

    static class TSktTransportTimeouts {
        long ulReadIntervalTimeout;
        long ulReadTotalTimeoutConstant;
        long ulReadTotalTimeoutMultiplier;
        long ulWriteTotalTimeoutConstant;
        long ulWriteTotalTimeoutMultiplier;

        TSktTransportTimeouts() {
        }
    }

    /* access modifiers changed from: protected */
    public long SetDeviceName(String deviceName) {
        this._deviceName = deviceName;
        return 0;
    }

    public long Initialize() {
        return 0;
    }

    public long Deinitialize() {
        return 0;
    }

    public SktPlatform.SktEvent GetReadCompletionEvent() {
        return this.m_ReadCompletionEvent;
    }

    public SktPlatform.SktEvent GetWriteCompletionEvent() {
        return this.m_WriteCompletionEvent;
    }

    public SktPlatform.SktEvent GetIoControlCompletionEvent() {
        return this.m_IoControlCompletionEvent;
    }

    public String GetDeviceName() {
        return this._deviceName;
    }

    public void SetConnected(boolean bConnected) {
        this.m_bConnected = bConnected;
    }

    public boolean GetConnected() {
        return this.m_bConnected;
    }
}
