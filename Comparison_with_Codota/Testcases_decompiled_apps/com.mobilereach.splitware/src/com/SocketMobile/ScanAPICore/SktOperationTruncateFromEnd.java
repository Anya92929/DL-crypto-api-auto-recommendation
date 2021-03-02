package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationTruncateFromEnd extends SktOperation {
    public SktOperationTruncateFromEnd(SktDataEditingProfile dataEditingProfile) {
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
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktOperationResult[] ResultParam2 = new SktOperationResult[1];
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (Pos.IsValid()) {
            long InternalResult = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam1), "operation.run(ResultParam1)");
        }
        if (!Pos.IsValid()) {
            return -84;
        }
        long InternalResult2 = SktDebug.DBGSKT_EVAL(((SktOperation) Pos.GetNext()).run(ResultParam2), "operation.run(ResultParam2)");
        if (SktScanErrors.SKTSUCCESS(InternalResult2) && result == null) {
            InternalResult2 = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult2)) {
            return InternalResult2;
        }
        if (ResultParam1[0].getResultString().length() <= ResultParam2[0].getResultInteger()) {
            return -43;
        }
        result[0] = new SktOperationResult();
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(ResultParam1[0].getResultString().substring(ResultParam1[0].getResultString().length() - ResultParam2[0].getResultInteger())), "result[0].WriteResult(ResultParam1[0].getResultString().substring(ResultParam1[0].getResultString().length()-ResultParam2[0].getResultInteger()))");
    }

    public int getResultType() {
        return 1;
    }
}
