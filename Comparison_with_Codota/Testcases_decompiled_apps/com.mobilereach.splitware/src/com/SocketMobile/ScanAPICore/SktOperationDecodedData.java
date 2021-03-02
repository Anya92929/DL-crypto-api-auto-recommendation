package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationDecodedData extends SktOperation {
    public SktOperationDecodedData(SktDataEditingProfile dataEditingProfile) {
        super(dataEditingProfile);
    }

    public boolean checkIfParametersAreCorrect() {
        if (((long) this._operationsList.GetCount()) == getParameterCount()) {
            return true;
        }
        return false;
    }

    public long run(SktOperationResult[] result) {
        if (result == null) {
            return -18;
        }
        result[0] = new SktOperationResult();
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(this._dataEditing.getOriginalDecodedData()), "result[0].WriteResult(_dataEditing.getOriginalDecodedData())");
    }

    public int getResultType() {
        return 1;
    }
}
