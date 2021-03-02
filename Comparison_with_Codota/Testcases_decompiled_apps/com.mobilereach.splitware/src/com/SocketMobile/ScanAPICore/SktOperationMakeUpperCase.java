package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationMakeUpperCase extends SktOperation {
    public SktOperationMakeUpperCase(SktDataEditingProfile dataEditingProfile) {
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
        if (Pos.IsValid()) {
            return ((SktOperation) Pos.GetNext()).canResultBeAString();
        }
        return false;
    }

    public long run(SktOperationResult[] result) {
        long InternalResult = 0;
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam1), "operation.run(ResultParam1)");
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
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(ResultParam1[0].getResultString().toUpperCase()), "result[0].WriteResult(stringResult)");
    }

    public int getResultType() {
        return 1;
    }
}
