package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationReplace extends SktOperation {
    public SktOperationReplace(SktDataEditingProfile dataEditingProfile) {
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
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            SktOperation operation = (SktOperation) Pos.GetNext();
            if (SktScanErrors.SKTSUCCESS(0)) {
                InternalResult = SktDebug.DBGSKT_EVAL(operation.run(ResultParam1), "operation.run(ResultParam1)");
            }
        }
        if (Pos.IsValid()) {
            SktOperation operation2 = (SktOperation) Pos.GetNext();
            if (SktScanErrors.SKTSUCCESS(InternalResult)) {
                InternalResult = SktDebug.DBGSKT_EVAL(operation2.run(ResultParam2), "operation.run(ResultParam2)");
            }
        }
        if (Pos.IsValid()) {
            SktOperation operation3 = (SktOperation) Pos.GetNext();
            if (SktScanErrors.SKTSUCCESS(InternalResult)) {
                InternalResult = SktDebug.DBGSKT_EVAL(operation3.run(ResultParam3), "operation.run(ResultParam3)");
            }
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult)) {
            if (result == null) {
                InternalResult = -18;
            } else {
                result[0] = new SktOperationResult();
            }
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        if (ResultParam1[0].getResultString().length() <= ResultParam2[0].getResultString().length()) {
            return -43;
        }
        int index = ResultParam1[0].getResultString().indexOf(ResultParam2[0].getResultString());
        if (index == -1) {
            return InternalResult;
        }
        StringBuffer stringResult = new StringBuffer();
        if (stringResult == null) {
            InternalResult = -2;
        } else {
            int indexStart = index;
            stringResult.append(ResultParam1[0].getResultString().substring(0, indexStart));
            stringResult.append(ResultParam3[0].getResultString());
            stringResult.append(ResultParam1[0].getResultString().substring(indexStart + ResultParam2[0].getResultString().length()));
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult)) {
            return SktDebug.DBGSKT_EVAL(result[0].WriteResult(stringResult.toString()), "result[0].WriteResult(stringResult.toString())");
        }
        return InternalResult;
    }

    public int getResultType() {
        return 1;
    }
}
