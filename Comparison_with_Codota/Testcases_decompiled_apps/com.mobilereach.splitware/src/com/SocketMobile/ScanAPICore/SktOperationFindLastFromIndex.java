package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationFindLastFromIndex extends SktOperation {
    public SktOperationFindLastFromIndex(SktDataEditingProfile dataEditingProfile) {
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
            result[0].setResult(findIndex(ResultParam1[0], ResultParam2[0].getResultInteger(), ResultParam3[0]));
            return InternalResult;
        } else if (ResultParam2[0].getResultInteger() >= ResultParam1[0].getResultString().length()) {
            return -43;
        } else {
            int nOffset = ResultParam4[0].getResultInteger();
            int index = findIndex(ResultParam1[0], ResultParam2[0].getResultInteger(), ResultParam3[0]);
            if (index >= 0) {
                index += nOffset;
            }
            result[0].setResult(index);
            return InternalResult;
        }
    }

    public int getResultType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int findIndex(SktOperationResult originalString, int fromIndex, SktOperationResult searchString) {
        if (originalString.getResultString().length() - searchString.getResultString().length() <= 0) {
            return -2;
        }
        if (fromIndex == -1) {
            fromIndex = originalString.getResultString().length();
        }
        int searchIndex = 0;
        int indexFound = -1;
        int offsetSearch = 0;
        while (searchIndex != -1) {
            searchIndex = originalString.getResultString().substring(offsetSearch, fromIndex).indexOf(searchString.getResultString());
            if (searchIndex != -1) {
                indexFound = offsetSearch + searchIndex;
                offsetSearch += searchString.getResultString().length() + searchIndex;
            }
        }
        if (indexFound != -1) {
            return indexFound;
        }
        return -2;
    }
}
