package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;

/* compiled from: SktOperation */
class SktOperationExtract extends SktOperation {
    public SktOperationExtract(SktDataEditingProfile dataEditingProfile) {
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
        if (!Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid() || !((SktOperation) Pos.GetNext()).canResultBeAString() || !Pos.IsValid()) {
            return false;
        }
        return ((SktOperation) Pos.GetNext()).canResultBeAString();
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
        int startIndex = 0;
        int stopIndex = ResultParam1[0].getResultString().length();
        if (ResultParam1[0].getResultString().length() <= 0 || ResultParam2[0].getResultString().length() <= 0 || ResultParam3[0].getResultString().length() <= 0) {
            return -43;
        }
        int index = getOccurrenceIndex(ResultParam1[0].getResultString(), ResultParam2[0].getResultString(), true);
        if (index >= 0) {
            startIndex = index;
        }
        int index2 = getOccurrenceIndex(ResultParam1[0].getResultString(), ResultParam3[0].getResultString(), false);
        if (index2 >= 0) {
            stopIndex = index2;
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

    /* access modifiers changed from: package-private */
    public int getOccurrenceIndex(String input, String search, boolean first) {
        int index;
        if (first) {
            index = input.indexOf(search);
            if (index >= 0) {
                index += search.length();
            }
        } else {
            index = lastIndexOf(input, search);
        }
        if (index < 0) {
            return -2;
        }
        return index;
    }

    static int lastIndexOf(String text, String search) {
        int searchIndex = 0;
        int lastIndex = -1;
        while (searchIndex >= 0) {
            searchIndex = text.substring(lastIndex + 1).indexOf(search);
            if (searchIndex > 0) {
                lastIndex = searchIndex + lastIndex + 1;
            }
        }
        return lastIndex;
    }
}
