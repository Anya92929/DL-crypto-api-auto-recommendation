package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;

class SktStream {
    private char[] m_Data = null;
    private int m_WriteOffset = 0;
    private int m_nMaxSize = 0;
    private int m_pData = 0;
    int m_pWrite = 0;

    public long Initialize(int nMaxSize) {
        long Result = 0;
        if (nMaxSize == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Deinitialize(), "Deinitialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_Data = new char[nMaxSize];
            if (this.m_Data == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_nMaxSize = nMaxSize;
            this.m_WriteOffset = 0;
        }
        return Result;
    }

    public long Deinitialize() {
        this.m_Data = null;
        this.m_WriteOffset = 0;
        this.m_nMaxSize = 0;
        return 0;
    }

    public int GetWriteDataOffset() {
        return this.m_WriteOffset;
    }

    public int GetWriteSizeMax() {
        return this.m_nMaxSize - this.m_WriteOffset;
    }

    public char[] GetData() {
        return this.m_Data;
    }

    public int GetDataSize() {
        return this.m_WriteOffset;
    }

    public long MoveWriteDataPointer(int nOffset) {
        long Result = 0;
        if (this.m_Data == null) {
            Result = -19;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (GetWriteSizeMax() <= nOffset) {
            return -26;
        }
        this.m_WriteOffset += nOffset;
        return Result;
    }

    public long Extract(char[] pData, int nDataSize) {
        long Result = 0;
        if (this.m_Data == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && nDataSize > GetDataSize()) {
            Result = -26;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            try {
                System.arraycopy(this.m_Data, 0, pData, 0, nDataSize);
            } catch (Exception e) {
                Result = -26;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(Discard(nDataSize), "Discard(nDataSize)");
        }
        return Result;
    }

    public long Discard(int nDataSize) {
        long Result = 0;
        if (nDataSize > GetDataSize()) {
            Result = -26;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            try {
                System.arraycopy(this.m_Data, nDataSize, this.m_Data, 0, this.m_nMaxSize - nDataSize);
            } catch (Exception e) {
                Result = -26;
            }
            this.m_WriteOffset -= nDataSize;
            arrays.fill(this.m_Data, 0, this.m_WriteOffset, this.m_nMaxSize - this.m_WriteOffset);
        }
        return Result;
    }

    public static boolean Test() {
        boolean bResult = true;
        SktStream Stream = new SktStream();
        if (1 == 1) {
            bResult = SktDebug.DBGSKT_EXPECTING(Stream.Initialize(255), "Stream.Initialize(255)", 0);
        }
        if (bResult) {
            char[] pWrite = Stream.GetData();
            int i = 0;
            while (i < 128) {
                pWrite[i] = (char) i;
                i++;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Stream.MoveWriteDataPointer(i), "Stream.MoveWriteDataPointer(i)", 0);
            }
        }
        if (bResult && Stream.GetDataSize() != 128) {
            SktDebug.DBGSKT_MSG(4, "DataSize " + Stream.GetDataSize() + " expected " + 128);
            bResult = false;
        }
        char[] pTemp = new char[128];
        if (bResult) {
            if (pTemp == null) {
                SktDebug.DBGSKT_MSG(4, "Not enough memory to complete this test");
                bResult = false;
            }
            if (bResult && SktDebug.DBGSKT_EVAL(Stream.Extract(pTemp, 128), "Stream.Extract(pTemp,128)") != 0) {
                bResult = false;
            }
        }
        if (bResult) {
            int i2 = 0;
            while (true) {
                if (i2 >= 128) {
                    break;
                } else if (pTemp[i2] != i2) {
                    SktDebug.DBGSKT_MSG(4, "The extracted content doesn't match " + pTemp[i2] + " != " + i2);
                    bResult = false;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (bResult) {
            char[] pWrite2 = Stream.GetData();
            int i3 = 0;
            while (true) {
                if (i3 >= 128) {
                    break;
                } else if (pWrite2[i3] != 0) {
                    SktDebug.DBGSKT_MSG(4, "The remaining content doesn't match [" + i3 + "] " + pWrite2[i3] + " != " + 0);
                    bResult = false;
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (bResult) {
            char[] pWrite3 = Stream.GetData();
            for (char i4 = 0; i4 < 10; i4 = (char) (i4 + 1)) {
                pWrite3[i4] = i4;
            }
            if (bResult) {
                bResult = SktDebug.DBGSKT_EXPECTING(Stream.MoveWriteDataPointer(10), "Stream.MoveWriteDataPointer(10)", 0);
            }
        }
        if (bResult) {
            bResult = SktDebug.DBGSKT_EXPECTING(Stream.Discard(5), "Stream.Discard(5)", 0);
        }
        if (bResult) {
            char[] pWrite4 = Stream.GetData();
            int writeOffset = Stream.GetWriteDataOffset();
            for (char i5 = 0; i5 < 10; i5 = (char) (i5 + 1)) {
                pWrite4[i5 + writeOffset] = i5;
            }
            bResult = SktDebug.DBGSKT_EXPECTING(Stream.MoveWriteDataPointer(10), "Stream.MoveWriteDataPointer(10)", 0);
        }
        char[] pVerify = null;
        if (bResult) {
            pVerify = Stream.GetData();
            byte i6 = 0;
            while (true) {
                if (i6 >= 5) {
                    break;
                } else if (pVerify[i6] != i6 + 5) {
                    SktDebug.DBGSKT_MSG(4, "Content doesn't match after discard[" + i6 + "] " + pVerify[i6] + " != " + i6 + 5);
                    bResult = false;
                    break;
                } else {
                    i6 = (byte) (i6 + 1);
                }
            }
        }
        if (bResult) {
            char i7 = 0;
            while (true) {
                if (i7 >= 10) {
                    break;
                } else if (pVerify[i7 + 5] != i7) {
                    SktDebug.DBGSKT_MSG(4, "Content doesn't match after discard and add[5" + i7 + "] " + pVerify[i7 + 5] + " != " + i7);
                    bResult = false;
                    break;
                } else {
                    i7 = (char) (i7 + 1);
                }
            }
        }
        if (bResult) {
            SktDebug.DBGSKT_MSG(1, "SktStream Test pass");
        }
        return bResult;
    }
}
