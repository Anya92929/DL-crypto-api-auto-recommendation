package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationEscapeCharacter extends SktOperation {
    public SktOperationEscapeCharacter(SktDataEditingProfile dataEditingProfile) {
        super(dataEditingProfile);
    }

    public long getParameterCount() {
        return 1;
    }

    public boolean checkIfParametersAreCorrect() {
        if (((long) this._operationsList.GetCount()) != getParameterCount()) {
            return false;
        }
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        while (Pos.IsValid()) {
            if (!((SktOperation) Pos.GetNext()).canResultBeAString()) {
                return false;
            }
        }
        return true;
    }

    public long run(SktOperationResult[] result) {
        long InternalResult = 0;
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktOperation operation = null;
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            operation = (SktOperation) Pos.GetNext();
        }
        if (SktScanErrors.SKTSUCCESS(0)) {
            InternalResult = SktDebug.DBGSKT_EVAL(operation.run(ResultParam1), "operation.run(ResultParam1)");
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        if (ResultParam1[0].getResultString().length() <= 0) {
            return -43;
        }
        char[] pszEscapeHexa = ResultParam1[0].getResultString().toCharArray();
        int size = ResultParam1[0].getResultString().length();
        StringBuffer stringResult = new StringBuffer();
        if (stringResult == null) {
            InternalResult = -2;
        } else {
            char cResult = 0;
            int count = 0;
            for (int i = 0; i < size; i++) {
                cResult = (char) (cResult << 4);
                count++;
                if (pszEscapeHexa[i] >= 'a' && pszEscapeHexa[i] <= 'f') {
                    cResult = (char) ((pszEscapeHexa[i] - 'a') + 10 + cResult);
                } else if (pszEscapeHexa[i] >= 'A' && pszEscapeHexa[i] <= 'F') {
                    cResult = (char) ((pszEscapeHexa[i] - 'A') + 10 + cResult);
                } else if (pszEscapeHexa[i] < '0' || pszEscapeHexa[i] > '9') {
                    count = 0;
                } else {
                    cResult = (char) ((pszEscapeHexa[i] - '0') + cResult);
                }
                if (count == 2) {
                    stringResult.append(cResult);
                    cResult = 0;
                    count = 0;
                }
            }
            if (cResult > 0) {
                stringResult.append(cResult);
            }
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult) && result == null) {
            InternalResult = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        result[0] = new SktOperationResult();
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(stringResult.toString()), "result[0].WriteResult(stringResult.toString())");
    }

    public int getResultType() {
        return 1;
    }
}
