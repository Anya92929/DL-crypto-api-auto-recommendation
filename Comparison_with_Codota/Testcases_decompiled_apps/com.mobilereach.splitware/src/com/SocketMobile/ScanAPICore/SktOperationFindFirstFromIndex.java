package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationFindFirstFromIndex extends SktOperation {
    public SktOperationFindFirstFromIndex(SktDataEditingProfile dataEditingProfile) {
        super(dataEditingProfile);
    }

    public long getParameterCount() {
        return 4;
    }

    public boolean checkIfParametersAreCorrect() {
        if (((long) this._operationsList.GetCount()) != getParameterCount()) {
            return false;
        }
        SktList.Position Pos = this._operationsList.GetHeadPosition();
        if (!Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAnInteger() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAnInteger()) {
            return false;
        }
        return true;
    }

    public long run(SktOperationResult[] result) {
        int index;
        int index2;
        long InternalResult = 0;
        SktOperationResult[] ResultParam1 = new SktOperationResult[1];
        SktOperationResult[] ResultParam2 = new SktOperationResult[1];
        SktOperationResult[] ResultParam3 = new SktOperationResult[1];
        SktOperationResult[] ResultParam4 = new SktOperationResult[1];
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
        if (Pos.IsValid()) {
            operation = (SktOperation) Pos.GetNext();
        }
        if (SktScanErrors.SKTSUCCESS(InternalResult)) {
            InternalResult = SktDebug.DBGSKT_EVAL(operation.run(ResultParam4), "operation.run(ResultParam4)");
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
            result[0].setResult(-2);
            return InternalResult;
        } else if (ResultParam2[0].getResultInteger() == -1) {
            int index3 = ResultParam1[0].getResultString().indexOf(ResultParam3[0].getResultString());
            if (index3 != -1) {
                index2 = index3 + ResultParam4[0].getResultInteger();
            } else {
                index2 = -2;
            }
            result[0].setResult(index2);
            return InternalResult;
        } else if (ResultParam2[0].getResultInteger() >= ResultParam1[0].getResultString().length()) {
            return -43;
        } else {
            int index4 = ResultParam1[0].getResultString().substring(ResultParam2[0].getResultInteger()).indexOf(ResultParam3[0].getResultString());
            if (index4 != -1) {
                index = index4 + ResultParam2[0].getResultInteger() + ResultParam4[0].getResultInteger();
            } else {
                index = -2;
            }
            result[0].setResult(index);
            return InternalResult;
        }
    }

    public int getResultType() {
        return 2;
    }
}