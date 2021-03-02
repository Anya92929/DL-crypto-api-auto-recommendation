package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanApi;
import com.SocketMobile.ScanAPI.ISktScanDevice;
import com.SocketMobile.ScanAPI.ISktScanObject;
import com.SocketMobile.ScanAPI.SktScan;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktSimpleXml;

public final class SktScanCore implements ISktScanApi {
    SktScanAPI _ScanAPI = null;
    boolean _device = false;
    boolean _open = false;

    public SktScanCore() {
    }

    public SktScanCore(ISktScanApi scanApi) {
        SktScanCore scanCore = (SktScanCore) scanApi;
        if (scanApi != null) {
            this._ScanAPI = scanCore._ScanAPI;
        }
        this._device = true;
    }

    public long Open(String deviceName) {
        long Result = 0;
        if (deviceName == null || deviceName == ISktScanApi.SKTSCANAPI_CONFIGURATOR_GUID) {
            boolean bWithOpeningTransport = true;
            if (!this._device) {
                if (deviceName != null && deviceName == ISktScanApi.SKTSCANAPI_CONFIGURATOR_GUID) {
                    bWithOpeningTransport = false;
                }
                if (this._ScanAPI == null && !Test()) {
                    Result = -1;
                }
            } else {
                Result = -43;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (this._ScanAPI == null) {
                    this._ScanAPI = new SktScanAPI(this);
                }
                if (this._ScanAPI == null) {
                    Result = -2;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            this._ScanAPI.IncrementReferenceCount();
            return this._ScanAPI.GetReferenceCount() == 1 ? this._ScanAPI.Initialize(bWithOpeningTransport) : Result;
        }
        if (!this._device) {
            Result = -43;
        } else if (this._ScanAPI == null) {
            Result = -19;
        } else if (this._open) {
            Result = -25;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this._ScanAPI.Open(deviceName, this);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        this._open = true;
        return Result;
    }

    public long Close() {
        long Result = 0;
        if (this._ScanAPI == null) {
            Result = -19;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (!this._device) {
            this._ScanAPI.DecrementReferenceCount();
            if (this._ScanAPI.GetReferenceCount() != 0) {
                return Result;
            }
            this._ScanAPI.Deinitialize();
            this._ScanAPI = null;
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this._ScanAPI.Close(this), "_ScanAPI.Close(this)");
        this._open = false;
        return Result2;
    }

    public long SetProperty(ISktScanObject pScanObj) {
        long Result = 0;
        TSktScanObject scanObj = (TSktScanObject) pScanObj;
        if (this._ScanAPI == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pScanObj == null) {
                Result = -18;
            } else if (SktScan.helper.SKTRETRIEVESETTYPE(scanObj.Property.f13ID) != scanObj.Property.Type) {
                Result = -18;
            } else if (SktScan.helper.SKTRETRIEVESETTYPE(scanObj.Property.f13ID) == 1) {
                Result = -43;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (!this._device) {
            if (SktScan.helper.SKTISSCANAPI(scanObj.Property.f13ID) != 0) {
                return SktDebug.DBGSKT_EVAL(this._ScanAPI.SetLocalProperty(scanObj), "ScanAPI.SetLocalProperty(pScanObj)");
            }
            return -11;
        } else if (SktScan.helper.SKTISSCANAPI(scanObj.Property.f13ID) == 0) {
            return SktDebug.DBGSKT_EVAL(this._ScanAPI.SetProperty(this, scanObj), "_ScanAPI.SetProperty(_deviceHandle,pScanObj)");
        } else {
            return -11;
        }
    }

    public long GetProperty(ISktScanObject pScanObj) {
        long Result = 0;
        TSktScanObject scanObj = (TSktScanObject) pScanObj;
        if (this._ScanAPI == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pScanObj == null) {
                Result = -18;
            } else if (SktScan.helper.SKTRETRIEVEGETTYPE(scanObj.Property.f13ID) != scanObj.Property.Type) {
                Result = -18;
            } else if (SktScan.helper.SKTRETRIEVEGETTYPE(scanObj.Property.f13ID) == 1) {
                Result = -43;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (!this._device) {
            if (SktScan.helper.SKTISSCANAPI(scanObj.Property.f13ID) != 0) {
                return SktDebug.DBGSKT_EVAL(this._ScanAPI.GetLocalProperty(scanObj), "_ScanAPI.GetLocalProperty(pScanObj)");
            }
            return -11;
        } else if (SktScan.helper.SKTISSCANAPI(scanObj.Property.f13ID) == 0) {
            return SktDebug.DBGSKT_EVAL(this._ScanAPI.GetProperty(this, scanObj), "_ScanAPI.GetProperty(_deviceHandle,pScanObj)");
        } else {
            return -11;
        }
    }

    public long WaitForScanObject(ISktScanObject[] ScanObj, long ulTimeout) {
        long Result = 0;
        TSktScanObject[] scanObj = new TSktScanObject[1];
        if (this._ScanAPI == null) {
            Result = -19;
        } else if (this._device) {
            Result = -43;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && ScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this._ScanAPI.WaitForQueueNotEmpty(ulTimeout), "_ScanAPI.WaitForQueueNotEmpty(ulTimeout)");
            if (SktScanErrors.SKTSUCCESS(Result) && Result != 1) {
                SktDebug.DBGSKT_MSG(1, "Receive a Message from the Message Queue");
                Result = SktDebug.DBGSKT_EVAL(this._ScanAPI.RemoveFromQueue(scanObj), "_ScanAPI.RemoveFromQueue(scanObj)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    ScanObj[0] = scanObj[0];
                }
            }
        }
        return Result;
    }

    public long ReleaseScanObject(ISktScanObject ScanObj) {
        long Result = 0;
        TSktScanObject scanObj = (TSktScanObject) ScanObj;
        if (this._ScanAPI == null) {
            Result = -19;
        } else if (this._device) {
            Result = -43;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && this._ScanAPI == null) {
            Result = -11;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(this._ScanAPI.ReleaseScanObject(scanObj), "_ScanAPI.ReleaseScanObject(scanObj)");
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public boolean Test() {
        SktDebug.DBGSKT_MSG(1, "=============================");
        SktDebug.DBGSKT_MSG(1, "Start the tests");
        boolean bResult = SktDebug.DBGSKT_TEST();
        if (bResult) {
            bResult = SktPlatform.SktEvent.Test();
        }
        if (bResult) {
            bResult = SktPlatform.SktWait.Test();
        }
        if (bResult) {
            bResult = SktPlatform.SktLock.Test();
        }
        if (bResult) {
            bResult = SktThread.Test();
        }
        if (bResult) {
            bResult = SktPlatform.SktGuid.Test();
        }
        if (bResult) {
            bResult = SktList.Test();
        }
        if (bResult) {
            bResult = SktQueue.Test();
        }
        if (bResult) {
            bResult = SktSerialTransport.Test();
        }
        if (bResult) {
            bResult = SktBtIscpProtocol.Test();
        }
        if (bResult) {
            bResult = SktSsiProtocol.Test();
        }
        if (bResult) {
            bResult = SktStream.Test();
        }
        if (bResult) {
            bResult = SktCache.Test();
        }
        if (bResult) {
            bResult = SktDeviceInterface.Test();
        }
        if (bResult) {
            bResult = SktSimpleXml.CSktXmlParser.Test();
        }
        if (bResult) {
            bResult = SktPlatform.SktFile.Test();
        }
        if (bResult) {
            bResult = SktConfigXml.Test();
        }
        if (bResult) {
            bResult = SktScanAPI.Test();
        }
        SktDebug.DBGSKT_MSG(1, "Tests completed result: " + (bResult ? "true" : "false"));
        SktDebug.DBGSKT_MSG(1, "=============================");
        return bResult;
    }

    public long Close(ISktScanDevice device) {
        return 0;
    }
}
