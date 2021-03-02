package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import java.util.Hashtable;

public class SktOperationDictionary {
    private Hashtable _hashMap;

    public long initialize() {
        long result = 0;
        this._hashMap = new Hashtable();
        if (SktScanErrors.SKTSUCCESS(0)) {
            result = SktDebug.DBGSKT_EVAL(add("DecodedData", new SktOperationFactoryDecodedData()), "add(\"DecodedData\",new SktOperationFactoryDecodedData()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("TruncateFromBeginning", new SktOperationFactoryTruncateFromBeginning()), "add(\"TruncateFromBeginning\",new SktOperationFactoryTruncateFromBeginning()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("TruncateFromEnd", new SktOperationFactoryTruncateFromEnd()), "add(\"TruncateFromEnd\",new SktOperationFactoryTruncateFromEnd()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("Replace", new SktOperationFactoryReplace()), "add(\"Replace\",new SktOperationFactoryReplace()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("Substitute", new SktOperationFactorySubstitute()), "add(\"Substitute\",new SktOperationFactorySubstitute()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("EscapeCharacter", new SktOperationFactoryEscapeCharacter()), "add(\"EscapeCharacter\",new SktOperationFactoryEscapeCharacter()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("InsertAfterIndex", new SktOperationFactoryInsertAfterIndex()), "add(\"InsertAfterIndex\",new SktOperationFactoryInsertAfterIndex()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("InsertBeforeIndex", new SktOperationFactoryInsertBeforeIndex()), "add(\"InsertBeforeIndex\",new SktOperationFactoryInsertBeforeIndex()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("FindFirstFromIndex", new SktOperationFactoryFindFirstFromIndex()), "add(\"FindFirstFromIndex\",new SktOperationFactoryFindFirstFromIndex()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("FindLastFromIndex", new SktOperationFactoryFindLastFromIndex()), "add(\"FindLastFromIndex\",new SktOperationFactoryFindLastFromIndex()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("MakeUpperCase", new SktOperationFactoryMakeUpperCase()), "add(\"MakeUpperCase\",new SktOperationFactoryMakeUpperCase()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("MakeLowerCase", new SktOperationFactoryMakeLowerCase()), "add(\"MakeLowerCase\",new SktOperationFactoryMakeLowerCase()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("ReplaceNonPrintableCharacters", new SktOperationFactoryReplaceNonPrintableCharacters()), "add(\"ReplaceNonPrintableCharacters\",new SktOperationFactoryReplaceNonPrintableCharacters()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("DecodedDataWithoutTrailer", new SktOperationFactoryDecodedDataWithoutTrailer()), "add(\"DecodedDataWithoutTrailer\",new SktOperationFactoryDecodedDataWithoutTrailer()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("TruncateAfterIndex", new SktOperationFactoryTruncateAfterIndex()), "add(\"TruncateAfterIndex\",new SktOperationFactoryTruncateAfterIndex()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("TruncateBeforeIndex", new SktOperationFactoryTruncateBeforeIndex()), "add(\"TruncateBeforeIndex\",new SktOperationFactoryTruncateBeforeIndex()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(add("Substring", new SktOperationFactorySubstring()), "add(\"Substring\",new SktOperationFactorySubstring()");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            return SktDebug.DBGSKT_EVAL(add("Extract", new SktOperationFactoryExtract()), "add(\"Extract\",new SktOperationFactoryExtract()");
        }
        return result;
    }

    public SktOperationFactory getValue(char[] szCommandName, int nLength) {
        if (this._hashMap != null) {
            return (SktOperationFactory) this._hashMap.get(String.valueOf(szCommandName));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public long add(String szKey, SktOperationFactory factory) {
        if (this._hashMap == null) {
            return -19;
        }
        this._hashMap.put(szKey, factory);
        return 0;
    }
}
