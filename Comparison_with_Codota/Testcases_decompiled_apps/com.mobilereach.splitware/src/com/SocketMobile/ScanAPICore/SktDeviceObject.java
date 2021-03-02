package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;

final class SktDeviceObject extends SktDeviceObjectInterface {
    public long Initialize(String pszFriendlyName, long ulDeviceType) {
        String[] guid = new String[1];
        long Result = SktDebug.DBGSKT_EVAL(super.Initialize(pszFriendlyName, ulDeviceType), "super.Initialize(pszFriendlyName,ulDeviceType)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktGuid.Create(guid), "SktGuid.Create(guid)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_Guid = guid[0];
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            Deinitialize();
        }
        return Result;
    }

    public long Deinitialize() {
        return SktDebug.DBGSKT_EVAL(super.Deinitialize(), "super.Deinitialize()");
    }

    public long GetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponse) {
        if (GetDeviceInterface() != null) {
            return SktDebug.DBGSKT_EVAL(GetDeviceInterface().GetProperty(pScanObj, 1, pbImmediateResponse, ppResponse), "GetDeviceInterface().GetProperty(pScanObj,SktDeviceInterface.ESktDestination.kSktDestinationApp,pbImmediateResponse,ppResponse)");
        }
        return -32;
    }

    public long SetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponse) {
        if (GetDeviceInterface() != null) {
            return SktDebug.DBGSKT_EVAL(GetDeviceInterface().SetProperty(pScanObj, 1, pbImmediateResponse, ppResponse), "GetDeviceInterface().SetProperty(pScanObj,SktDeviceInterface.ESktDestination.kSktDestinationApp,pbImmediateResponse,ppResponse)");
        }
        return -32;
    }
}
