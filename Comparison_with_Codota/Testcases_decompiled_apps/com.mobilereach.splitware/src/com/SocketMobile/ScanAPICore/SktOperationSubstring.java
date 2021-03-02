package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationSubstring extends SktOperation {
    public SktOperationSubstring(SktDataEditingProfile dataEditingProfile) {
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
        if (!Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAnInteger() || !Pos.IsValid()) {
            return false;
        }
        return ((SktOperation) Pos.GetNext()).canResultBeAnInteger();
    }

    public long run(SktOperationResult[] result) {
        long InternalResult = 0;
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktOperationResult[] ResultParam2 = new SktOperationResult[1];
        SktOperationResult[] ResultParam3 = new SktOperationResult[1];
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam1), "operation.run(ResultParam1)");
        }
        if (Pos.IsValid()) {
            InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam2), "operation.run(ResultParam2)");
        }
        if (Pos.IsValid()) {
            InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam3), "operation.run(ResultParam3)");
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        int startIndex = ResultParam2[0].getResultInteger();
        int stopIndex = ResultParam3[0].getResultInteger();
        if (ResultParam2[0].getResultInteger() == -2 || ResultParam2[0].getResultInteger() == -1) {
            startIndex = 0;
        }
        if (ResultParam3[0].getResultInteger() == -2 || ResultParam3[0].getResultInteger() == -1) {
            stopIndex = ResultParam1[0].getResultString().length();
        }
        if (startIndex > ResultParam1[0].getResultString().length()) {
            startIndex = ResultParam1[0].getResultString().length();
        }
        if (stopIndex > ResultParam1[0].getResultString().length()) {
            stopIndex = ResultParam1[0].getResultString().length();
        }
        if (startIndex > stopIndex) {
            startIndex = stopIndex;
        }
        String stringResult = new String(ResultParam1[0].getResultString());
        if (stringResult == null) {
            return -2;
        }
        result[0] = new SktOperationResult();
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(stringResult.substring(startIndex, stopIndex)), "result[0].WriteResult(stringResult.toString())");
    }

    public int getResultType() {
        return 1;
    }
}
