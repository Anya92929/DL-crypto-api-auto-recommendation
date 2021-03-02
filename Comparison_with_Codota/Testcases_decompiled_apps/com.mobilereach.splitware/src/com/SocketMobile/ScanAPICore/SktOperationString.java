package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationString extends SktOperation {
    protected String _string;

    public SktOperationString(SktDataEditingProfile dataEditingProfile, SktParsingString string) {
        super(dataEditingProfile);
        if (string == null || string.isEmpty()) {
            this._string = "";
        } else {
            this._string = String.valueOf(string.getString());
        }
    }

    public boolean checkIfParametersAreCorrect() {
        return true;
    }

    public long run(SktOperationResult[] result) {
        if (result == null) {
            return -18;
        }
        result[0] = new SktOperationResult();
        return SktDebug.DBGSKT_EVAL(result[0].WriteResult(this._string), "result[0].WriteResult(_string)");
    }

    public int getResultType() {
        return 1;
    }
}
