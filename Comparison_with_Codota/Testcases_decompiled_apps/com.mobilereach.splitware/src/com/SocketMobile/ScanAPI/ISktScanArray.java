package com.SocketMobile.ScanAPI;

public interface ISktScanArray {
    int getLength();

    char[] getValue();

    void setLength(int i);

    void setValue(char[] cArr, int i);
}
