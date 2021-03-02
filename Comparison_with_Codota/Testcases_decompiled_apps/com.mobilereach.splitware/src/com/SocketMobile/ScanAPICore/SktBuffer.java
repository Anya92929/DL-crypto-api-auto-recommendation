package com.SocketMobile.ScanAPICore;

class SktBuffer {
    public int m_nLength;
    public int m_nMaxLength;
    public char[] m_pucData = null;

    public SktBuffer() {
        setLength(0);
        setMaxLength(0);
    }

    public long Allocate(int nSize) {
        this.m_pucData = null;
        setLength(0);
        setMaxLength(0);
        if (nSize <= 0) {
            return 0;
        }
        this.m_pucData = new char[nSize];
        if (this.m_pucData == null) {
            return -2;
        }
        setMaxLength(nSize);
        return 0;
    }

    public void setLength(int m_nLength2) {
        this.m_nLength = m_nLength2;
    }

    public int getLength() {
        return this.m_nLength;
    }

    public void setMaxLength(int m_nMaxLength2) {
        this.m_nMaxLength = m_nMaxLength2;
    }

    public int getMaxLength() {
        return this.m_nMaxLength;
    }
}
