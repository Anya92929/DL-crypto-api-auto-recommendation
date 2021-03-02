package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationTruncateFromBeginning extends SktOperation {
    public SktOperationTruncateFromBeginning(SktDataEditingProfile dataEditingProfile) {
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
        if (!((SktOperation) Pos.GetNext()).canResultBeAString() || !((SktOperation) Pos.GetNext()).canResultBeAnInteger()) {
            return false;
        }
        return true;
    }

    public long run(SktOperationResult[] result) {
        long InternalResult = 0;
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktOperationResult[] ResultParam2 = new SktOperationResult[2];
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
        if (SktScanErrors.SKTSUCCESS(InternalResult) && result == null) {
            InternalResult = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        result[0] = new SktOperationResult();
        if (ResultParam1[0].getResultString().length() > ResultParam2[0].getResultInteger()) {
            return SktDebug.DBGSKT_EVAL(result[0].WriteResult(ResultParam1[0].getResultString().substring(ResultParam2[0].getResultInteger())), "result[0].WriteResult(ResultParam1[0].getResultString().substring(ResultParam2[0].getResultInteger()))");
        }
        return -43;
    }

    public int getResultType() {
        return 1;
    }
}
