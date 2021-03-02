package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPICore.SktScanTypes;

final class SktCache {
    private int m_EndIndex = 0;
    private int m_ReadIndex = 0;
    private int m_nCacheSize = 0;
    private char[] m_pucBuffer = null;
    private char[] m_pucRead = null;

    /* access modifiers changed from: package-private */
    public long Initialize(int nCacheSize) {
        Deinitialize();
        if (nCacheSize <= 0) {
            return 0;
        }
        this.m_pucBuffer = new char[nCacheSize];
        if (this.m_pucBuffer == null) {
            return -2;
        }
        this.m_nCacheSize = nCacheSize;
        this.m_pucRead = this.m_pucBuffer;
        this.m_ReadIndex = 0;
        this.m_EndIndex = 0;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public long Deinitialize() {
        this.m_nCacheSize = 0;
        this.m_pucBuffer = null;
        this.m_pucRead = null;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int GetCacheSize() {
        return this.m_nCacheSize;
    }

    /* access modifiers changed from: package-private */
    public void SetDataSize(int nSize) {
        this.m_pucRead = this.m_pucBuffer;
        this.m_ReadIndex = 0;
        this.m_EndIndex = nSize;
    }

    /* access modifiers changed from: package-private */
    public int GetDataSize() {
        return this.m_EndIndex - this.m_ReadIndex;
    }

    /* access modifiers changed from: package-private */
    public char[] GetPointer() {
        return this.m_pucBuffer;
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.m_ReadIndex >= this.m_EndIndex;
    }

    /* access modifiers changed from: package-private */
    public long ReadByte(SktScanTypes.TSktScanChar pByte) {
        if (pByte == null) {
            return -18;
        }
        if (this.m_pucRead == null) {
            return -19;
        }
        if (isEmpty()) {
            return -6;
        }
        pByte.setValue(this.m_pucRead[this.m_ReadIndex]);
        this.m_ReadIndex++;
        return 0;
    }

    static boolean Test() {
        boolean bResult = true;
        SktCache MyCache = new SktCache();
        SktScanTypes.TSktScanChar ucTest = new SktScanTypes.TSktScanChar(0);
        if (1 == 1 && MyCache.ReadByte(ucTest) != -19) {
            bResult = false;
        }
        if (bResult && !MyCache.isEmpty()) {
            bResult = false;
        }
        if (bResult && ((long) MyCache.GetCacheSize()) != 0) {
            bResult = false;
        }
        if (bResult && MyCache.Deinitialize() != 0) {
            bResult = false;
        }
        if (bResult && MyCache.Initialize(20) != 0) {
            bResult = false;
        }
        if (bResult && !(bResult = MyCache.isEmpty())) {
            bResult = false;
        }
        if (bResult) {
            byte i = 0;
            while (i < MyCache.GetCacheSize()) {
                MyCache.GetPointer()[i] = (char) i;
                i = (byte) (i + 1);
            }
            MyCache.SetDataSize(i);
        }
        if (bResult && MyCache.isEmpty()) {
            bResult = false;
        }
        if (bResult) {
            for (byte i2 = 0; i2 < MyCache.GetCacheSize(); i2 = (byte) (i2 + 1)) {
                if (bResult && MyCache.ReadByte(ucTest) != 0) {
                    bResult = false;
                }
                if (ucTest.getValue() != i2) {
                    SktDebug.DBGSKT_MSG(4, "Cache doesn't return expected value:" + ucTest + "!=" + i2);
                    bResult = false;
                }
            }
        }
        if (bResult && !MyCache.isEmpty()) {
            bResult = false;
        }
        if (bResult) {
            SktDebug.DBGSKT_MSG(1, "SktCache Test pass");
        }
        return bResult;
    }
}
