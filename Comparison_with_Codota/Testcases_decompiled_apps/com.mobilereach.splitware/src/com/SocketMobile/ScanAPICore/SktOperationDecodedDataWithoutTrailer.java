package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;

/* compiled from: SktOperation */
class SktOperationDecodedDataWithoutTrailer extends SktOperation {
    public SktOperationDecodedDataWithoutTrailer(SktDataEditingProfile dataEditingProfile) {
        super(dataEditingProfile);
    }

    public boolean checkIfParametersAreCorrect() {
        if (((long) this._operationsList.GetCount()) == getParameterCount()) {
            return true;
        }
        return false;
    }

    public long run(SktOperationResult[] result) {
        long InternalResult = 0;
        char[] pszResult = this._dataEditing.getOriginalDecodedData().toCharArray();
        int index = pszResult.length;
        while (index > 0) {
            index--;
            if (pszResult[index] >= ' ' && pszResult[index] <= 127) {
                break;
            }
        }
        if (SktScanErrors.SKTSUCCESS(0) && result == null) {
            InternalResult = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(InternalResult)) {
            return InternalResult;
        }
        result[0] = new SktOperationResult();
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(this._dataEditing.getOriginalDecodedData().substring(0, index + 1)), "result[0].WriteResult(_dataEditing.getOriginalDecodedData().substring(0,index))");
    }

    public int getResultType() {
        return 1;
    }
}
