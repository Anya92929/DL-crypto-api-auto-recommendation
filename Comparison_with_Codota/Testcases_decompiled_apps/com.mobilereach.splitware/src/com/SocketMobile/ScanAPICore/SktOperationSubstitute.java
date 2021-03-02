package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationSubstitute extends SktOperation {
    public SktOperationSubstitute(SktDataEditingProfile dataEditingProfile) {
        super(dataEditingProfile);
    }

    public long getParameterCount() {
        return 3;
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
        SktOperationResult[] ResultParam2 = new SktOperationResult[1];
        SktOperationResult[] ResultParam3 = new SktOperationResult[1];
        SktOperation operation = null;
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            operation = (SktOperation) Pos.GetNext();
        }
        if (SktScanErrors.SKTSUCCESS(0)) {
            InternalResult = SktDebug.DBGSKT_EVAL(operation.run(ResultParam1), "operation.run(ResultParam1)");
        }
        if (Pos.IsValid()) {
            operation = (SktOperation) Pos.GetNext();
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult)) {
            InternalResult = SktDebug.DBGSKT_EVAL(operation.run(ResultParam2), "operation.run(ResultParam2)");
        }
        if (Pos.IsValid()) {
            operation = (SktOperation) Pos.GetNext();
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult)) {
            InternalResult = SktDebug.DBGSKT_EVAL(operation.run(ResultParam3), "operation.run(ResultParam3)");
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult) && result == null) {
            InternalResult = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        if (ResultParam2[0].getResultString().length() <= 0) {
            return -43;
        }
        char[] pszSearch = ResultParam2[0].getResultString().toCharArray();
        char[] pszInput = ResultParam1[0].getResultString().toCharArray();
        StringBuffer stringResult = new StringBuffer();
        if (stringResult == null) {
            InternalResult = -2;
        } else {
            for (int i = 0; i < pszInput.length; i++) {
                stringResult.append(pszInput[i]);
                int j = 0;
                while (true) {
                    if (j >= pszSearch.length) {
                        break;
                    } else if (pszInput[i] == pszSearch[j]) {
                        stringResult.deleteCharAt(stringResult.length() - 1);
                        stringResult.append(ResultParam3[0].getResultString());
                        break;
                    } else {
                        j++;
                    }
                }
            }
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
