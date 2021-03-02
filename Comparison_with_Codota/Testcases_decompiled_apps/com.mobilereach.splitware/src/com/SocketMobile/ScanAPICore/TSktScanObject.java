package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanMsg;
import com.SocketMobile.ScanAPI.ISktScanObject;
import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPICore.SktScanTypes;

public final class TSktScanObject implements ISktScanObject {
    SktScanTypes.TSktScanMsg Msg = new SktScanTypes.TSktScanMsg();
    SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();

    public ISktScanMsg getMessage() {
        return this.Msg;
    }

    public ISktScanProperty getProperty() {
        return this.Property;
    }

    public void setProperty(ISktScanProperty property) {
        this.Property = (SktScanTypes.TSktScanProperty) property;
    }
}
