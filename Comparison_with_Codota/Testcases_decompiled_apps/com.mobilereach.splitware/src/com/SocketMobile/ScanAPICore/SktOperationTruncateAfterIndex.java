package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationTruncateAfterIndex extends SktOperation {
    public SktOperationTruncateAfterIndex(SktDataEditingProfile dataEditingProfile) {
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
        if (ResultParam2[0].getResultInteger() == -2 || ResultParam2[0].getResultInteger() == -1) {
            result[0] = new SktOperationResult();
            return SktDebug.DBGSKT_EVAL(result[0].WriteResult(ResultParam1[0].getResultString()), "result[0].WriteResult(ResultParam1[0].getResultString())");
        } else if (ResultParam2[0].getResultInteger() < 0) {
            return InternalResult;
        } else {
            int size = ResultParam2[0].getResultInteger();
            if (ResultParam3[0].getResultInteger() > 0) {
                size += ResultParam3[0].getResultInteger();
            }
            if (size > ResultParam1[0].getResultString().length()) {
                size = ResultParam1[0].getResultString().length();
            }
            String stringResult = new String(ResultParam1[0].getResultString());
            if (stringResult == null) {
                return -2;
            }
            result[0] = new SktOperationResult();
            return SktDebug.DBGSKT_EVAL(result[0].WriteResult(stringResult.substring(0, size)), "result[0].WriteResult(stringResult.toString())");
        }
    }

    public int getResultType() {
        return 1;
    }
}
