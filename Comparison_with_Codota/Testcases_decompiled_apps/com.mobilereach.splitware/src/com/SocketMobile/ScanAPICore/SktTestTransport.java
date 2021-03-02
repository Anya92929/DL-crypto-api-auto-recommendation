package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktSsiProtocol;
import com.SocketMobile.ScanAPICore.SktTransport;

final class SktTestTransport extends SktTransport {
    public final int kBufferSizeMax = 2048;
    public final byte kSktIoCtlGetModemStatus = 1;
    public final int kSktModemStatusRsld = 128;
    private SktList m_SsiPacketToRead = new SktList();
    private SktStream m_WriteStream = new SktStream();
    private boolean m_bSendData = true;

    public long Open(String pszDeviceName, boolean bQuery) {
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SetDeviceName(pszDeviceName);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return this.m_WriteStream.Initialize(2048);
        }
        return Result;
    }

    public long Close() {
        this.m_WriteStream.Deinitialize();
        return 0;
    }

    public long ReadBlock(char[] pData, int offset, int[] pnBlockSize) {
        long Result;
        long Result2 = 0;
        SktSsiProtocol.SktSsiPacket SsiPacket = new SktSsiProtocol.SktSsiPacket();
        SktSsiProtocol.SktSsiPacket[] pSsiPacket = new SktSsiProtocol.SktSsiPacket[1];
        SktSsiProtocol SsiProtocol = new SktSsiProtocol();
        if (pnBlockSize == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktScanTypes.TSktScanInteger Checksum = new SktScanTypes.TSktScanInteger(SsiPacket.m_wChecksum);
            if (this.m_SsiPacketToRead.GetHeadPosition().IsValid()) {
                Result = SktDebug.DBGSKT_EVAL(this.m_SsiPacketToRead.RemoveHead(pSsiPacket), "m_SsiPacketToRead.RemoveHead(pSsiPacket)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(pSsiPacket[0], Checksum), "SktSsiProtocol.ComputeChecksum(pSsiPacket[0],Checksum)");
                    pSsiPacket[0].m_wChecksum = Checksum.getValue();
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SsiProtocol.TransformPacketToRawByte(pSsiPacket[0], pData, pnBlockSize), "SsiProtocol.TransformPacketToRawByte(pSsiPacket[0],(char[])pData,pnBlockSize)");
                }
                if (pSsiPacket[0] != null) {
                    pSsiPacket[0] = null;
                }
            } else if (this.m_bSendData) {
                SsiPacket.m_uLength = 17;
                SsiPacket.m_ucOpcode = 243;
                SsiPacket.m_ucSource = 0;
                SsiPacket.m_ucStatus = 0;
                SsiPacket.m_Payload.uLength = 13;
                SsiPacket.m_Payload.pucData = new char[13];
                if (SsiPacket.m_Payload.pucData != null) {
                    SsiPacket.m_Payload.pucData = " This is Test".toCharArray();
                }
                SktSsiProtocol.ComputeChecksum(SsiPacket, Checksum);
                SsiPacket.m_wChecksum = Checksum.getValue();
                SsiProtocol.TransformPacketToRawByte(SsiPacket, pData, pnBlockSize);
            } else {
                pnBlockSize[0] = 0;
            }
            SktDebug.DBGSKT_DUMPBYTE(129, "<-", pData, pnBlockSize[0]);
        }
        return Result;
    }

    public long WriteBlock(char[] pData, int nBlockSize, int[] pnBlockSizeWritten) {
        long Result = 0;
        SktDebug.DBGSKT_DUMPBYTE(129, "->", pData, nBlockSize);
        SktSsiProtocol.SktSsiPacket SsiPacket = new SktSsiProtocol.SktSsiPacket();
        SktSsiProtocol SsiProtocol = new SktSsiProtocol();
        if (this.m_WriteStream.GetData() == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (pData == null || pnBlockSizeWritten == null)) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            System.arraycopy(pData, 0, this.m_WriteStream.GetData(), this.m_WriteStream.GetWriteDataOffset(), nBlockSize);
            Result = SktDebug.DBGSKT_EVAL(this.m_WriteStream.MoveWriteDataPointer(nBlockSize), "m_WriteStream.MoveWriteDataPointer(nBlockSize)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SsiProtocol.TransformRawByteToPacket(this.m_WriteStream, this.m_WriteStream.GetDataSize(), SsiPacket), "SsiProtocol.TransformRawByteToPacket(m_WriteStream,m_WriteStream.GetDataSize(),SsiPacket)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pnBlockSizeWritten[0] = nBlockSize;
        switch (SsiPacket.m_ucOpcode) {
            case 198:
                SktSsiProtocol.SktSsiPacket SsiPacketResponse = new SktSsiProtocol.SktSsiPacket();
                if (SsiPacketResponse == null) {
                    return -2;
                }
                long Result2 = SktDebug.DBGSKT_EVAL(BuildSsiPacketResponseFromParamSend(SsiPacket.m_Payload.pucData, SsiPacket.m_Payload.uLength, SsiPacketResponse), "BuildSsiPacketResponseFromParamSend(SsiPacket.m_Payload.pucData,SsiPacket.m_Payload.ucLength,pSsiPacket)");
                if (SsiPacketResponse.m_uLength == 0) {
                    return Result2;
                }
                this.m_SsiPacketToRead.AddTail(SsiPacketResponse);
                return Result2;
            case 209:
                SktSsiProtocol.SktSsiPacket SsiPacketResponse2 = new SktSsiProtocol.SktSsiPacket();
                if (SsiPacketResponse2 == null) {
                    return -2;
                }
                long Result3 = SktDebug.DBGSKT_EVAL(BuildSsiPacketResponseFromSubCmdPayload(SsiPacket.m_Payload.pucData, SsiPacket.m_Payload.uLength, SsiPacketResponse2), "BuildSsiPacketResponseFromSubCmdPayload(SsiPacket.m_Payload.pucData,SsiPacket.m_Payload.ucLength,pSsiPacket)");
                if (SsiPacket.m_uLength == 0) {
                    return Result3;
                }
                this.m_SsiPacketToRead.AddTail(SsiPacketResponse2);
                return Result3;
            default:
                SktSsiProtocol.SktSsiPacket SsiPacketResponse3 = new SktSsiProtocol.SktSsiPacket();
                if (SsiPacketResponse3 == null) {
                    return -2;
                }
                SsiPacketResponse3.m_ucOpcode = 209;
                SsiPacketResponse3.m_ucSource = 0;
                SsiPacketResponse3.m_ucStatus = 0;
                SsiPacketResponse3.m_uLength = 5;
                SsiPacketResponse3.m_Payload.pucData = new char[1];
                if (SsiPacketResponse3.m_Payload.pucData == null) {
                    Result = -2;
                } else {
                    SsiPacketResponse3.m_Payload.pucData[0] = 2;
                    SsiPacketResponse3.m_Payload.uLength = 1;
                }
                SktScanTypes.TSktScanInteger Checksum = new SktScanTypes.TSktScanInteger(SsiPacket.m_wChecksum);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(SsiPacketResponse3, Checksum), "SktSsiProtocol.ComputeChecksum(SsiPacketResponse,Checksum)");
                    SsiPacketResponse3.m_wChecksum = Checksum.getValue();
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(this.m_SsiPacketToRead.AddTail(SsiPacketResponse3), "m_SsiPacketToRead.AddTail(SsiPacketResponse)");
                }
                return !SktScanErrors.SKTSUCCESS(Result) ? Result : Result;
        }
    }

    public long IoControl(int nIoControl, Object pDataIn, int nDataInSize, Object pDataOut, int[] pnDataOutSize) {
        long Result = 0;
        if (!SktScanErrors.SKTSUCCESS(0)) {
            return 0;
        }
        switch (nIoControl) {
            case 1:
                if (pDataOut == null || pnDataOutSize == null) {
                    Result = -18;
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    return Result;
                }
                ((long[]) pDataOut)[0] = 128;
                pnDataOutSize[0] = 4;
                return Result;
            default:
                return -15;
        }
    }

    public long ConfigureTimeouts(SktTransport.TSktTransportTimeouts Timeouts) {
        return 0;
    }

    public void SendData(boolean bSendData) {
        this.m_bSendData = bSendData;
    }

    /* access modifiers changed from: protected */
    public long BuildSsiPacketResponseFromSubCmdPayload(char[] pucData, int ucLength, SktSsiProtocol.SktSsiPacket pSsiPacket) {
        int wSocketCmd;
        long Result = 0;
        if (pucData == null || ucLength < 2 || pSsiPacket == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int wSocketCmd2 = ((pucData[0] << 8) & 65535) | pucData[1];
        switch (wSocketCmd2) {
            case SktSsiProtocol.kSsiSubCmdSelfTestInquiry /*260*/:
            case SktSsiProtocol.kSsiSubCmdSelfTestExInquiry /*266*/:
                pSsiPacket.m_uLength = 4;
                pSsiPacket.m_ucOpcode = 209;
                pSsiPacket.m_ucSource = 0;
                pSsiPacket.m_ucStatus = 0;
                if (wSocketCmd2 == 260) {
                    pSsiPacket.m_Payload.uLength = 10;
                } else {
                    pSsiPacket.m_Payload.uLength = 14;
                }
                pSsiPacket.m_uLength += pSsiPacket.m_Payload.uLength;
                pSsiPacket.m_Payload.pucData = new char[pSsiPacket.m_Payload.uLength];
                if (pSsiPacket.m_Payload.pucData == null) {
                    return -2;
                }
                if (wSocketCmd2 == 266) {
                    pSsiPacket.m_Payload.pucData[10] = 0;
                    pSsiPacket.m_Payload.pucData[11] = 1;
                    pSsiPacket.m_Payload.pucData[12] = 3;
                    pSsiPacket.m_Payload.pucData[13] = '!';
                    wSocketCmd = SktSsiProtocol.kSsiSubCmdSelfTestExResponse;
                } else {
                    wSocketCmd = SktSsiProtocol.kSsiSubCmdSelfTestResponse;
                }
                pSsiPacket.m_Payload.pucData[0] = (char) (wSocketCmd >> 8);
                pSsiPacket.m_Payload.pucData[1] = (char) (wSocketCmd & 255);
                pSsiPacket.m_Payload.pucData[2] = ' ';
                pSsiPacket.m_Payload.pucData[3] = 16;
                pSsiPacket.m_Payload.pucData[4] = 1;
                pSsiPacket.m_Payload.pucData[5] = 19;
                pSsiPacket.m_Payload.pucData[6] = 16;
                pSsiPacket.m_Payload.pucData[7] = ' ';
                pSsiPacket.m_Payload.pucData[8] = 1;
                pSsiPacket.m_Payload.pucData[9] = 0;
                SktScanTypes.TSktScanInteger Checksum = new SktScanTypes.TSktScanInteger(pSsiPacket.m_wChecksum);
                SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(pSsiPacket, Checksum), "SktSsiProtocol.ComputeChecksum(pSsiPacket,Checksum)");
                pSsiPacket.m_wChecksum = Checksum.getValue();
                return Result;
            case SktSsiProtocol.kSsiSubCmdFriendlyNameInquiry /*262*/:
                pSsiPacket.m_uLength = 20;
                pSsiPacket.m_ucOpcode = 209;
                pSsiPacket.m_ucSource = 0;
                pSsiPacket.m_ucStatus = 0;
                pSsiPacket.m_Payload.uLength = 16;
                pSsiPacket.m_Payload.pucData = new char[16];
                if (pSsiPacket.m_Payload.pucData == null) {
                    return -2;
                }
                pSsiPacket.m_Payload.pucData[0] = (char) 1;
                pSsiPacket.m_Payload.pucData[1] = (char) 7;
                pSsiPacket.m_Payload.pucData[2] = 'T';
                pSsiPacket.m_Payload.pucData[3] = 'E';
                pSsiPacket.m_Payload.pucData[4] = 'S';
                pSsiPacket.m_Payload.pucData[5] = 'T';
                pSsiPacket.m_Payload.pucData[6] = ' ';
                pSsiPacket.m_Payload.pucData[7] = 'T';
                pSsiPacket.m_Payload.pucData[8] = 'R';
                pSsiPacket.m_Payload.pucData[9] = 'A';
                pSsiPacket.m_Payload.pucData[10] = 'N';
                pSsiPacket.m_Payload.pucData[11] = 'S';
                pSsiPacket.m_Payload.pucData[12] = 'P';
                pSsiPacket.m_Payload.pucData[13] = 'O';
                pSsiPacket.m_Payload.pucData[14] = 'R';
                pSsiPacket.m_Payload.pucData[15] = 'T';
                SktScanTypes.TSktScanInteger Checksum2 = new SktScanTypes.TSktScanInteger(pSsiPacket.m_wChecksum);
                SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(pSsiPacket, Checksum2), "SktSsiProtocol.ComputeChecksum(pSsiPacket,Checksum)");
                pSsiPacket.m_wChecksum = Checksum2.getValue();
                return Result;
            case SktSsiProtocol.kSsiSubCmdConfigurationModeInquiry /*295*/:
                pSsiPacket.m_uLength = 7;
                pSsiPacket.m_ucOpcode = 209;
                pSsiPacket.m_ucSource = 0;
                pSsiPacket.m_ucStatus = 0;
                pSsiPacket.m_Payload.uLength = 3;
                pSsiPacket.m_Payload.pucData = new char[3];
                if (pSsiPacket.m_Payload.pucData == null) {
                    return -2;
                }
                pSsiPacket.m_Payload.pucData[0] = (char) 1;
                pSsiPacket.m_Payload.pucData[1] = (char) 40;
                pSsiPacket.m_Payload.pucData[2] = 239;
                SktScanTypes.TSktScanInteger Checksum3 = new SktScanTypes.TSktScanInteger(pSsiPacket.m_wChecksum);
                SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(pSsiPacket, Checksum3), "SktSsiProtocol.ComputeChecksum(pSsiPacket,Checksum)");
                pSsiPacket.m_wChecksum = Checksum3.getValue();
                return Result;
            default:
                pSsiPacket.m_uLength = 4;
                pSsiPacket.m_ucOpcode = 208;
                pSsiPacket.m_ucSource = 0;
                pSsiPacket.m_ucStatus = 0;
                pSsiPacket.m_Payload.uLength = 0;
                pSsiPacket.m_Payload.pucData = null;
                SktScanTypes.TSktScanInteger Checksum4 = new SktScanTypes.TSktScanInteger(pSsiPacket.m_wChecksum);
                SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(pSsiPacket, Checksum4), "SktSsiProtocol.ComputeChecksum(pSsiPacket,Checksum)");
                pSsiPacket.m_wChecksum = Checksum4.getValue();
                return Result;
        }
    }

    /* access modifiers changed from: protected */
    public long BuildSsiPacketResponseFromParamSend(char[] pucData, int ucLength, SktSsiProtocol.SktSsiPacket pSsiPacket) {
        long Result = 0;
        if (pucData == null || ucLength < 2 || pSsiPacket == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            char c = pucData[1];
            pSsiPacket.m_uLength = 4;
            pSsiPacket.m_ucOpcode = 208;
            pSsiPacket.m_ucSource = 0;
            pSsiPacket.m_ucStatus = 0;
            pSsiPacket.m_Payload.uLength = 0;
            pSsiPacket.m_Payload.pucData = null;
            SktScanTypes.TSktScanInteger Checksum = new SktScanTypes.TSktScanInteger(pSsiPacket.m_wChecksum);
            SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(pSsiPacket, Checksum), "SktSsiProtocol.ComputeChecksum(pSsiPacket,Checksum)");
            pSsiPacket.m_wChecksum = Checksum.getValue();
        }
        return Result;
    }
}
