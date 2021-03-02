package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktScanTypes;

final class SktTranslator {
    private int m_nCount = 0;
    private TSktTranslator[] m_pTable = null;

    interface ISktTranslatorFunction {
        long SktTranslatorFunction(TSktTranslatorData tSktTranslatorData);
    }

    static class TSktTranslatorData {
        TSktTranslatorFrom From = new TSktTranslatorFrom(0, false);

        /* renamed from: To */
        TSktTranslatorTo f16To = new TSktTranslatorTo(0, 0, 0);
        int Type;
        int nDataInSize;
        int nDataOutSize;
        Object pDataIn;
        Object pDataOut;
        Object pExtraParam;
        Object pThis;
    }

    static class TSktTranslatorFrom {
        long PropId;
        boolean bGetOperation;

        public TSktTranslatorFrom(long id, boolean bget) {
            this.PropId = id;
            this.bGetOperation = bget;
        }
    }

    static class TSktTranslatorTo {
        char ucFrameType;
        char ucFunctionId;
        int wGroupId;

        public TSktTranslatorTo(char FrameType, int GroupId, char FunctionId) {
            this.ucFrameType = FrameType;
            this.wGroupId = GroupId;
            this.ucFunctionId = FunctionId;
        }

        public TSktTranslatorTo(int FrameType, int GroupId, int FunctionId) {
            this.ucFrameType = (char) FrameType;
            this.wGroupId = GroupId;
            this.ucFunctionId = (char) FunctionId;
        }
    }

    static class TSktTranslator {
        TSktTranslatorFrom From;

        /* renamed from: To */
        TSktTranslatorTo f15To;
        ISktTranslatorFunction pFunction;

        public TSktTranslator(TSktTranslatorFrom from, TSktTranslatorTo to, ISktTranslatorFunction pfunction) {
            this.From = from;
            this.f15To = to;
            this.pFunction = pfunction;
        }
    }

    public long InitializeTable(TSktTranslator[] pTable, int nCount) {
        this.m_pTable = pTable;
        this.m_nCount = nCount;
        return 0;
    }

    public long TranslateToPrimitive(int nStartIndex, TSktTranslatorData pData, SktScanTypes.TSktScanInteger pnIndex) {
        long Result = 0;
        boolean bFound = false;
        if (this.m_pTable == null) {
            Result = -19;
        } else if (pData == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pnIndex != null) {
                pnIndex.setValue(-1);
            }
            int i = nStartIndex;
            while (true) {
                if (i >= this.m_nCount) {
                    break;
                } else if (this.m_pTable[i].From.PropId == pData.From.PropId && this.m_pTable[i].From.bGetOperation == pData.From.bGetOperation) {
                    bFound = true;
                    pData.f16To.ucFrameType = this.m_pTable[i].f15To.ucFrameType;
                    pData.f16To.wGroupId = this.m_pTable[i].f15To.wGroupId;
                    pData.f16To.ucFunctionId = this.m_pTable[i].f15To.ucFunctionId;
                    if (this.m_pTable[i].pFunction != null) {
                        Result = SktDebug.DBGSKT_EVAL(this.m_pTable[i].pFunction.SktTranslatorFunction(pData), "m_pTable[i].pFunction.SktTranslatorFunction(pData)");
                        if (pnIndex != null) {
                            pnIndex.setValue(i);
                        }
                    } else {
                        Result = -43;
                    }
                } else {
                    i++;
                }
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || bFound) {
            return Result;
        }
        SktDebug.DBGSKT_MSG(68, "Cannot find a match for property 0x" + Integer.toHexString((int) pData.From.PropId) + " Get:" + (pData.From.bGetOperation ? "true" : "false"));
        return -17;
    }

    public long TranslateFromPrimitive(TSktTranslatorData pData, SktScanTypes.TSktScanInteger pnIndex) {
        long Result = 0;
        boolean bFound = false;
        if (this.m_pTable == null) {
            Result = -19;
        } else if (pData == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pnIndex != null) {
                pnIndex.setValue(-1);
            }
            int i = 0;
            while (true) {
                if (i >= this.m_nCount) {
                    break;
                } else if (!(this.m_pTable[i].f15To.ucFrameType == pData.f16To.ucFrameType && ((this.m_pTable[i].f15To.wGroupId == 0 || this.m_pTable[i].f15To.wGroupId == pData.f16To.wGroupId) && ((this.m_pTable[i].f15To.ucFunctionId == 0 || this.m_pTable[i].f15To.ucFunctionId == pData.f16To.ucFunctionId) && (this.m_pTable[i].From.PropId == 0 || this.m_pTable[i].From.PropId == pData.From.PropId || pData.From.PropId == 0))))) {
                    i++;
                }
            }
            bFound = true;
            if (this.m_pTable[i].pFunction != null) {
                pData.From.PropId = this.m_pTable[i].From.PropId;
                pData.From.bGetOperation = this.m_pTable[i].From.bGetOperation;
                Result = SktDebug.DBGSKT_EVAL(this.m_pTable[i].pFunction.SktTranslatorFunction(pData), "m_pTable[i].pFunction.SktTranslatorFunction(pData)");
                if (pnIndex != null) {
                    pnIndex.setValue(i);
                }
            } else {
                Result = -43;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || bFound) {
            return Result;
        }
        SktDebug.DBGSKT_MSG(68, "Cannot find a match for property 0x" + Integer.toHexString((int) pData.From.PropId) + " Get:" + (pData.From.bGetOperation ? "true" : "false"));
        return -17;
    }

    public static boolean Test() {
        boolean bResult = true;
        SktTranslator Translator = new SktTranslator();
        TSktTranslator[] Table = {new TSktTranslator(new TSktTranslatorFrom(65538, true), new TSktTranslatorTo(0, 0, 0), new TranslatorData()), new TSktTranslator(new TSktTranslatorFrom(65538, false), new TSktTranslatorTo(0, 0, 0), new TranslatorData())};
        if (1 == 1 && Translator.InitializeTable(Table, Table.length) != 0) {
            bResult = false;
        }
        TSktTranslatorData Data = new TSktTranslatorData();
        Data.pThis = Translator;
        Data.pDataIn = null;
        Data.nDataInSize = 0;
        Data.pDataOut = null;
        Data.nDataOutSize = 0;
        Data.From.PropId = 65538;
        Data.From.bGetOperation = true;
        if (!bResult || Translator.TranslateToPrimitive(0, Data, (SktScanTypes.TSktScanInteger) null) == 0) {
            return bResult;
        }
        return false;
    }

    public static class TranslatorData implements ISktTranslatorFunction {
        public long SktTranslatorFunction(TSktTranslatorData pData) {
            return 0;
        }
    }
}
