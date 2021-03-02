package com.SocketMobile.ScanAPI;

public interface ISktScanDecodedData {
    char[] getData();

    int getDataSize();

    int getSymbologyID();

    String getSymbologyName();
}
