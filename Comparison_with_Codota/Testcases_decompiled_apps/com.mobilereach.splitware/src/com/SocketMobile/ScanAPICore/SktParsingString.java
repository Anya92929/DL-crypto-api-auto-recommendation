package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;

public class SktParsingString {
    private int _flags;
    private int _startIndex;
    private int _stopIndex;
    private StringBuffer _string;

    public SktParsingString() {
        this._startIndex = 0;
        this._stopIndex = 0;
        this._flags = 0;
    }

    public SktParsingString(String newString) {
        this._startIndex = 0;
        this._stopIndex = 0;
        this._flags = 0;
        this._string = new StringBuffer(newString);
        this._stopIndex = newString.length();
    }

    public SktParsingString(SktParsingString parsingString) {
        this._startIndex = parsingString._startIndex;
        this._stopIndex = parsingString._stopIndex;
        this._flags = parsingString._flags;
        this._string = parsingString._string;
    }

    public SktParsingString Extract(char cOpen, char cClose) {
        SktParsingString newParsingString = new SktParsingString(this);
        int nOpenCount = 0;
        int nStartIndex = 0;
        int nStopIndex = 0;
        int i = this._startIndex;
        while (true) {
            if (i >= this._stopIndex) {
                break;
            }
            if (this._string.charAt(i) != cOpen) {
                if (this._string.charAt(i) == cClose && nOpenCount > 0 && nOpenCount - 1 == 0) {
                    nStopIndex = i;
                    break;
                }
            } else {
                nOpenCount++;
                if (nStartIndex == 0) {
                    nStartIndex = i + 1;
                }
            }
            i++;
        }
        if (nStopIndex != 0) {
            memmove(this._string, nStartIndex - 1, this._string, nStartIndex, nStopIndex - nStartIndex);
            int nStopIndex2 = nStopIndex - 1;
            this._string.setCharAt(nStopIndex2, cOpen);
            newParsingString._startIndex = nStartIndex - 1;
            newParsingString._stopIndex = nStopIndex2;
            this._startIndex = nStopIndex2;
        } else {
            this._startIndex = 0;
            this._stopIndex = 0;
        }
        return newParsingString;
    }

    public SktParsingString ExtractBefore(char cOpen) {
        SktParsingString extractBefore = new SktParsingString(this);
        int i = this._startIndex;
        while (true) {
            if (i >= this._stopIndex) {
                break;
            } else if (this._string.charAt(i) == cOpen) {
                extractBefore._stopIndex = i;
                break;
            } else {
                i++;
            }
        }
        this._startIndex = extractBefore._stopIndex;
        return extractBefore;
    }

    public SktParsingString ExtractBeforeIndex(int index) {
        SktParsingString extractBefore = new SktParsingString(this);
        if (this._startIndex + index < this._stopIndex) {
            extractBefore._stopIndex = this._startIndex + index;
        }
        this._startIndex = extractBefore._stopIndex;
        return extractBefore;
    }

    public long Remove(SktParsingString Remove) {
        long Result = 0;
        if (Remove.isEmpty()) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int nIndex = this._string.toString().indexOf(Remove._string.toString(), this._startIndex);
        if (nIndex <= 0 || nIndex >= this._stopIndex) {
            return -17;
        }
        this._startIndex = nIndex;
        this._startIndex += Remove.getLength();
        return Result;
    }

    public boolean isEmpty() {
        return this._startIndex == this._stopIndex;
    }

    public boolean isNumber() {
        if (this._string.length() <= this._startIndex) {
            return false;
        }
        if (this._string.charAt(this._startIndex) >= '0' && this._string.charAt(this._startIndex) <= '9') {
            return true;
        }
        if (this._string.charAt(this._startIndex) != '-' || this._string.length() <= this._startIndex + 1 || this._string.charAt(this._startIndex + 1) < '0' || this._string.charAt(this._startIndex + 1) > '9') {
            return false;
        }
        return true;
    }

    public char[] getString() {
        if (this._string == null || this._string.length() <= this._startIndex) {
            return null;
        }
        return this._string.toString().substring(this._startIndex, this._stopIndex).toCharArray();
    }

    public long WriteString(String string) {
        this._string = new StringBuffer(string);
        this._startIndex = 0;
        this._stopIndex = this._string.length();
        return 0;
    }

    public int getLength() {
        return this._stopIndex - this._startIndex;
    }

    public int getFlag() {
        return this._flags;
    }

    public void setFlag(int nFlag) {
        this._flags = nFlag;
    }

    /* access modifiers changed from: protected */
    public void memmove(StringBuffer destination, int destinationOffset, StringBuffer source, int sourceOffset, int nSize) {
        int max = source.length();
        if (max > destination.length()) {
            max = destination.length();
        }
        if (nSize > max) {
            nSize = max;
        }
        for (int i = 0; i < nSize; i++) {
            destination.setCharAt(destinationOffset + i, source.charAt(sourceOffset + i));
        }
    }

    /* access modifiers changed from: package-private */
    public int find(char c) {
        for (int i = this._startIndex; i < this._stopIndex; i++) {
            if (this._string.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void DbgFormatDump(boolean bError, String szFormat) {
        String szContent;
        String szContent2 = "";
        int length = getLength();
        if (length > 0) {
            szContent2 = String.valueOf(getString(), 0, length);
        }
        if (bError) {
        }
        int index = szFormat.indexOf("%s");
        if (index != -1) {
            szContent = (szFormat.substring(0, index) + szContent2) + szFormat.substring(index + 2);
        } else {
            szContent = szFormat + szContent2;
        }
        SktDebug.DBGSKT_MSG(1, szContent);
    }
}
