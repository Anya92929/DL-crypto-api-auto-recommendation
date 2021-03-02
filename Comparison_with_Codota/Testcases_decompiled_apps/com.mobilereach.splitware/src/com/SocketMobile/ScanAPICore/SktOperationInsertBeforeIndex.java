package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationInsertBeforeIndex extends SktOperation {
    public SktOperationInsertBeforeIndex(SktDataEditingProfile dataEditingProfile) {
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
        if (!Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAnInteger() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString()) {
            return false;
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
        if (ResultParam2[0].getResultInteger() == -2) {
            return SktDebug.DBGSKT_EVAL(result[0].WriteResult(ResultParam1[0].getResultString()), "result[0].WriteResult(ResultParam1[0].getResultString())");
        }
        if (ResultParam2[0].getResultInteger() == -1) {
            StringBuffer stringResult = new StringBuffer();
            if (stringResult == null) {
                return -2;
            }
            stringResult.append(ResultParam1[0].getResultString());
            int insertAt = stringResult.length() - 1;
            if (insertAt >= 1) {
                stringResult.insert(insertAt - 1, ResultParam3[0].getResultString());
            }
            if (SktScanErrors.SKTSUCCESS(InternalResult)) {
                return SktDebug.DBGSKT_EVAL(result[0].WriteResult(stringResult.toString()), "result[0].WriteResult(stringResult.toString())");
            }
            return InternalResult;
        } else if (ResultParam2[0].getResultInteger() >= ResultParam1[0].getResultString().length()) {
            return -43;
        } else {
            StringBuffer stringResult2 = new StringBuffer();
            if (stringResult2 == null) {
                return -2;
            }
            int insertBefore = ResultParam2[0].getResultInteger();
            if (insertBefore > 0) {
                insertBefore--;
            }
            stringResult2.append(ResultParam1[0].getResultString());
            stringResult2.insert(insertBefore, ResultParam3[0].getResultString());
            if (SktScanErrors.SKTSUCCESS(InternalResult)) {
                return SktDebug.DBGSKT_EVAL(result[0].WriteResult(stringResult2.toString()), "result[0].WriteResult(stringResult.toString())");
            }
            return InternalResult;
        }
    }

    public int getResultType() {
        return 1;
    }
}
