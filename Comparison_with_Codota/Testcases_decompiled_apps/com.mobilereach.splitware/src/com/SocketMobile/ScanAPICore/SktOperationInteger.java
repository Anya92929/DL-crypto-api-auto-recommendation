package com.SocketMobile.ScanAPICore;

/* compiled from: SktOperation */
class SktOperationInteger extends SktOperationString {
    private Integer _integer;

    public SktOperationInteger(SktDataEditingProfile dataEditingProfile, SktParsingString string) {
        super(dataEditingProfile, string);
        StringBuffer number = new StringBuffer();
        int index = 0;
        char[] szString = string.getString();
        while (index < string.getLength() && ((szString[index] >= '0' && szString[index] <= '9') || szString[index] == '-')) {
            number.append(szString[index]);
            index++;
        }
        this._integer = Integer.valueOf(number.toString());
    }

    public boolean checkIfParametersAreCorrect() {
        return true;
    }

    public long run(SktOperationResult[] result) {
        if (result == null) {
            return -18;
        }
        result[0] = new SktOperationResult();
        long internalResult = SktDebug.DBGSKT_EVAL(result[0].WriteResult(this._string), "result[0].WriteResult(_string)");
        result[0].setResult(this._integer.intValue());
        return internalResult;
    }

    public int getResultType() {
        return 3;
    }
}
