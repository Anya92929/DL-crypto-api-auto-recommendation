package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationReplaceNonPrintableCharacters extends SktOperation {
    public SktOperationReplaceNonPrintableCharacters(SktDataEditingProfile dataEditingProfile) {
        super(dataEditingProfile);
    }

    public long getParameterCount() {
        return 2;
    }

    public boolean checkIfParametersAreCorrect() {
        if (((long) this._operationsList.GetCount()) != getParameterCount()) {
            return false;
        }
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (!Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid()) {
            return false;
        }
        return ((SktOperation) Pos.GetNext()).canResultBeAString();
    }

    public long run(SktOperationResult[] result) {
        long InternalResult = 0;
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktOperationResult[] ResultParam2 = new SktOperationResult[1];
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam1), "operation.run(ResultParam1)");
        }
        if (Pos.IsValid()) {
            InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam2), "operation.run(ResultParam2)");
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        char[] pszInput = ResultParam1[0].getResultString().toCharArray();
        StringBuffer stringResult = new StringBuffer();
        if (stringResult == null) {
            InternalResult = -2;
        } else {
            for (int i = 0; i < pszInput.length; i++) {
                stringResult.append(pszInput[i]);
                if (pszInput[i] <= ' ' || pszInput[i] >= 128) {
                    stringResult.deleteCharAt(stringResult.length() - 1);
                    stringResult.append(ResultParam2[0].getResultString());
                }
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
