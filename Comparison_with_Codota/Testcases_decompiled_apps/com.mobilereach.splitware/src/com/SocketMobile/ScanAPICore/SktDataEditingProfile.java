package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanDecodedData;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import java.nio.IntBuffer;

public class SktDataEditingProfile {
    private SktList _operations = new SktList();
    private String _originalDecodedData = null;
    private String _triggerContains = null;
    private String _triggerEndsWith = null;
    private int _triggerMaximumSize = this.kAnySize;
    private int _triggerMinimumSize = this.kAnySize;
    private String _triggerStartsWith = null;
    private int[] _triggerSymbologyId = null;
    private int kAnySize = 0;

    public long parse(String operation) {
        long result = 0;
        char cOpen = 0;
        char cClose = 0;
        removeAllOperations();
        if (operation == null || operation.length() < 3) {
            result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(result) && (cOpen = operation.charAt(0)) == (cClose = operation.charAt(1))) {
            result = -85;
        }
        SktOperationDictionary dictionary = new SktOperationDictionary();
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(dictionary.initialize(), "dictionary.Initialize()");
        }
        SktParsingString parsingString = new SktParsingString();
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(parsingString.WriteString(operation.substring(2)), "parsingString.WriteString(operation.substring(2))");
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(SktOperation.Parse(this, dictionary, cOpen, cClose, parsingString, this._operations), "SktOperation.Parse(this,dictionary,cOpen,cClose,parsingString,_operations)");
        }
        if (!SktScanErrors.SKTSUCCESS(result)) {
            removeAllOperations();
        }
        return result;
    }

    public long edit(ISktScanDecodedData decodedData) {
        int newDecodedDataLength = 0;
        SktList results = new SktList();
        SktScanTypes.TSktScanDecodedData internalDecodedData = (SktScanTypes.TSktScanDecodedData) decodedData;
        long Result = SktDebug.DBGSKT_EVAL(writeOriginalDecodedData(String.valueOf(internalDecodedData.getData())), "writeOriginalDecodedData(String.valueOf(decodedData[0].getData()))");
        if (!checkIfTriggerConditionsAreMet(internalDecodedData)) {
            return Result;
        }
        SktList.Position Pos = this._operations.GetHeadPosition();
        SktOperationResult[] operationResult = new SktOperationResult[1];
        while (SktScanErrors.SKTSUCCESS(Result) && Pos.IsValid()) {
            SktOperation operation = (SktOperation) Pos.GetNext();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(operation.run(operationResult), "operation.run(OperationResult)");
            }
            SktOperationResult newString = new SktOperationResult(operationResult[0]);
            if (newString == null) {
                Result = -2;
            } else {
                results.AddTail(newString);
                newDecodedDataLength += newString.getResultString().length();
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || newDecodedDataLength <= 0) {
            return Result;
        }
        StringBuffer newDecodedData = new StringBuffer(newDecodedDataLength);
        if (newDecodedData == null) {
            return -2;
        }
        SktOperationResult[] resultString = new SktOperationResult[1];
        while (SktScanErrors.SKTSUCCESS(results.RemoveHead(resultString))) {
            newDecodedData.append(resultString[0].getResultString());
            resultString[0] = null;
        }
        internalDecodedData.String.m_Value = null;
        internalDecodedData.String.nLength = 0;
        internalDecodedData.String.setValue(newDecodedData.toString());
        return Result;
    }

    public long resetTrigger() {
        this._originalDecodedData = null;
        this._triggerMinimumSize = this.kAnySize;
        this._triggerMaximumSize = this.kAnySize;
        this._triggerSymbologyId = null;
        this._triggerContains = null;
        this._triggerStartsWith = null;
        this._triggerEndsWith = null;
        return 0;
    }

    public long addTriggerSymbology(int symbologyId) {
        long result = 0;
        int count = 0;
        if (this._triggerSymbologyId != null) {
            count = this._triggerSymbologyId.length;
        }
        IntBuffer symbologyIdList = IntBuffer.wrap(new int[(count + 1)]);
        if (symbologyIdList == null) {
            result = -2;
        } else {
            if (this._triggerSymbologyId != null) {
                symbologyIdList.put(this._triggerSymbologyId, 0, this._triggerSymbologyId.length);
            }
            symbologyIdList.put(symbologyId);
            this._triggerSymbologyId = null;
            this._triggerSymbologyId = symbologyIdList.array();
        }
        return result;
    }

    public long writeTriggerContains(String contains) {
        this._triggerContains = contains;
        return 0;
    }

    public long writeTriggerStartsWith(String startsWith) {
        this._triggerStartsWith = startsWith;
        return 0;
    }

    public long writeTriggerEndsWith(String endsWith) {
        this._triggerEndsWith = endsWith;
        return 0;
    }

    public long writeTriggerMinimumSize(int minimumSize) {
        this._triggerMinimumSize = minimumSize;
        return 0;
    }

    public long writeTriggerMaximumSize(int maximumSize) {
        this._triggerMaximumSize = maximumSize;
        return 0;
    }

    public String getOriginalDecodedData() {
        return this._originalDecodedData;
    }

    public void removeAllOperations() {
        SktOperation[] operation = new SktOperation[1];
        while (this._operations.GetCount() > 0) {
            this._operations.RemoveHead(operation);
            operation[0] = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkIfTriggerConditionsAreMet(ISktScanDecodedData decodedData) {
        boolean conditionsAreMet = true;
        if (decodedData == null) {
            conditionsAreMet = false;
        }
        if (conditionsAreMet && this._triggerMinimumSize != this.kAnySize && decodedData.getData().length < this._triggerMinimumSize) {
            conditionsAreMet = false;
        }
        if (conditionsAreMet && this._triggerMaximumSize != this.kAnySize && decodedData.getData().length > this._triggerMaximumSize) {
            conditionsAreMet = false;
        }
        if (conditionsAreMet && this._triggerSymbologyId != null && this._triggerSymbologyId.length != 0) {
            conditionsAreMet = false;
            int i = 0;
            while (true) {
                if (i >= this._triggerSymbologyId.length) {
                    break;
                } else if (decodedData.getSymbologyID() == this._triggerSymbologyId[i]) {
                    conditionsAreMet = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (conditionsAreMet && this._triggerStartsWith != null && this._triggerStartsWith.length() > 0) {
            conditionsAreMet = doesStartWith(this._triggerStartsWith, String.valueOf(decodedData.getData()));
        }
        if (conditionsAreMet && this._triggerEndsWith != null && this._triggerEndsWith.length() > 0) {
            conditionsAreMet = doesEndWith(this._triggerEndsWith, String.valueOf(decodedData.getData()));
        }
        if (!conditionsAreMet || this._triggerContains == null || this._triggerContains.length() <= 0) {
            return conditionsAreMet;
        }
        return doesContain(this._triggerContains, String.valueOf(decodedData.getData()));
    }

    /* access modifiers changed from: protected */
    public boolean doesStartWith(String startsWith, String decodedData) {
        return decodedData.startsWith(startsWith);
    }

    /* access modifiers changed from: protected */
    public boolean doesEndWith(String endsWith, String decodedData) {
        return decodedData.endsWith(endsWith);
    }

    /* access modifiers changed from: protected */
    public boolean doesContain(String contains, String decodedData) {
        return decodedData.indexOf(contains) != -1;
    }

    /* access modifiers changed from: protected */
    public long writeOriginalDecodedData(String decodedData) {
        this._originalDecodedData = decodedData;
        return 0;
    }
}
