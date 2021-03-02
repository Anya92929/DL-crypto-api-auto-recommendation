package com.SocketMobile.ScanAPI;

public interface ISktScanDevice {
    long Close();

    long GetProperty(ISktScanObject iSktScanObject);

    long Open(String str);

    long SetProperty(ISktScanObject iSktScanObject);
}
