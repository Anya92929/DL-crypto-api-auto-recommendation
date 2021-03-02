package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktHardwareNotificationTypes;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;

abstract class SktEnumerator {
    final int kSktInstanceNameMax = 256;
    final int kSktManufacturerNameMax = 64;
    final int kSktProductNameMax = 64;
    protected SktPlatform.SktEvent m_Event = new SktPlatform.SktEvent();
    protected SktList m_RegisteredDevices = new SktList();
    protected SktList m_Transports = new SktList();
    protected boolean m_bRegisteredDevicesModified = false;

    public abstract long Check(SktHardwareNotificationTypes.TSktHardware tSktHardware);

    public abstract long Wait(long j, SktHardwareNotificationTypes.TSktHardware[] tSktHardwareArr, SktTransport[] sktTransportArr);

    public static class SktEnumDeviceInstance {
        protected String m_pszInstanceName;

        public SktEnumDeviceInstance() {
            SetInstanceName((String) null);
        }

        public long Copy(SktEnumDeviceInstance Source) {
            if (SktScanErrors.SKTSUCCESS(0)) {
                return SktDebug.DBGSKT_EVAL(SetInstanceName(Source.GetInstanceName()), "SetInstanceName(Source.GetInstanceName()");
            }
            return 0;
        }

        public String GetInstanceName() {
            return this.m_pszInstanceName;
        }

        public long SetInstanceName(String pszInstanceName) {
            long Result = 0;
            this.m_pszInstanceName = null;
            if (pszInstanceName != null) {
                if (pszInstanceName.length() >= 256) {
                    Result = -26;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    this.m_pszInstanceName = pszInstanceName;
                }
            }
            return Result;
        }
    }

    public static class SktEnumDevice {
        protected SktList m_EnumDeviceInstances = new SktList();
        protected String m_pszManufacturerName;
        protected String m_pszProductName;

        public SktEnumDevice() {
            SetManufacturerName((String) null);
            SetProductName((String) null);
        }

        public String GetManufacturerName() {
            return this.m_pszManufacturerName;
        }

        public long SetManufacturerName(String pszManufacturerName) {
            long Result = 0;
            this.m_pszManufacturerName = null;
            if (pszManufacturerName != null) {
                if (pszManufacturerName.length() >= 256) {
                    Result = -26;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    this.m_pszManufacturerName = pszManufacturerName;
                }
            }
            return Result;
        }

        public String GetProductName() {
            return this.m_pszProductName;
        }

        public long SetProductName(String pszProductName) {
            long Result = 0;
            this.m_pszProductName = null;
            if (pszProductName != null) {
                if (pszProductName.length() >= 256) {
                    Result = -26;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    this.m_pszProductName = pszProductName;
                }
            }
            return Result;
        }

        public long AddNewInstance(SktEnumDeviceInstance EnumDeviceInstance) {
            long Result = 0;
            boolean bFound = false;
            SktList.Position position = this.m_EnumDeviceInstances.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                SktEnumDeviceInstance pLocal = (SktEnumDeviceInstance) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(0) && pLocal.GetInstanceName() == EnumDeviceInstance.GetInstanceName()) {
                    bFound = true;
                    Result = 2;
                    break;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result) && !bFound) {
                SktEnumDeviceInstance pLocal2 = new SktEnumDeviceInstance();
                if (pLocal2 == null) {
                    Result = -2;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pLocal2.Copy(EnumDeviceInstance), "pLocal.Copy(EnumDeviceInstance)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(this.m_EnumDeviceInstances.AddHead(pLocal2), "m_EnumDeviceInstances.AddHead(pLocal)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                    }
                }
            }
            return Result;
        }

        public long RemoveInstance(SktEnumDeviceInstance EnumDeviceInstance) {
            long Result = 0;
            boolean bDeleted = false;
            SktEnumDeviceInstance[] pLocal = new SktEnumDeviceInstance[1];
            SktList.Position position = this.m_EnumDeviceInstances.GetHeadPosition();
            SktList.Position position2 = position;
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                SktList.Position removePosition = position.Copy();
                pLocal[0] = (SktEnumDeviceInstance) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(0) && pLocal[0].GetInstanceName() == EnumDeviceInstance.GetInstanceName()) {
                    Result = SktDebug.DBGSKT_EVAL(this.m_EnumDeviceInstances.RemoveAt(removePosition, pLocal), "m_EnumDeviceInstances.RemoveAt(removePosition,pLocal)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        bDeleted = true;
                    }
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result) || bDeleted) {
                return Result;
            }
            return 2;
        }

        /* access modifiers changed from: package-private */
        public boolean HasThisInstance(SktEnumDeviceInstance EnumDeviceInstance) {
            SktList.Position position = this.m_EnumDeviceInstances.GetHeadPosition();
            while (position.IsValid()) {
                SktEnumDeviceInstance pLocal = (SktEnumDeviceInstance) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(0) && pLocal.GetInstanceName() == EnumDeviceInstance.GetInstanceName()) {
                    return true;
                }
            }
            return false;
        }
    }

    public long RegisterDevice(SktEnumDevice EnumDevice) {
        long Result = 0;
        SktEnumDevice pNewEnumDevice = null;
        SktList.Position position = this.m_RegisteredDevices.GetHeadPosition();
        while (true) {
            if (position.IsValid()) {
                if (AreIdentical((SktEnumDevice) position.GetNext(), EnumDevice)) {
                    Result = -25;
                    break;
                }
            } else {
                break;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (pNewEnumDevice = new SktEnumDevice()) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pNewEnumDevice.SetManufacturerName(EnumDevice.GetManufacturerName()), "pNewEnumDevice.SetManufacturerName(EnumDevice.GetManufacturerName())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pNewEnumDevice.SetProductName(EnumDevice.GetProductName()), "pNewEnumDevice.SetProductName(EnumDevice.GetProductName())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_RegisteredDevices.AddTail(pNewEnumDevice), "m_RegisteredDevices.AddTail(pNewEnumDevice)");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_bRegisteredDevicesModified = true;
        }
        return Result;
    }

    public long UnregisterDevice(SktEnumDevice EnumDevice) {
        SktEnumDevice[] pLocal = new SktEnumDevice[1];
        SktList.Position position = this.m_RegisteredDevices.GetHeadPosition();
        while (true) {
            if (!position.IsValid()) {
                break;
            }
            SktList.Position removePosition = position.Copy();
            pLocal[0] = (SktEnumDevice) position.GetNext();
            if (SktScanErrors.SKTSUCCESS(0) && AreIdentical(pLocal[0], EnumDevice)) {
                this.m_RegisteredDevices.RemoveAt(removePosition, pLocal);
                this.m_bRegisteredDevicesModified = true;
                break;
            }
        }
        return 0;
    }

    public long UnregisterAllDevices() {
        SktEnumDevice[] pDevice = new SktEnumDevice[1];
        while (SktScanErrors.SKTSUCCESS(this.m_RegisteredDevices.RemoveHead(pDevice))) {
            pDevice[0] = null;
        }
        return 0;
    }

    public long RemoveAllTransports() {
        SktTransport[] pTransport = new SktTransport[1];
        SktDebug.DBGSKT_MSG(1, "This enumerator has " + this.m_Transports.GetCount() + " transports to close");
        while (SktScanErrors.SKTSUCCESS(this.m_Transports.RemoveHead(pTransport))) {
            pTransport[0].Close();
            pTransport[0].Deinitialize();
            pTransport[0] = null;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long Search(String pszManufacturerName, String pszProductName, SktEnumDevice EnumDevice) {
        SktEnumDevice Reference = new SktEnumDevice();
        Reference.SetManufacturerName(pszManufacturerName);
        Reference.SetProductName(pszProductName);
        SktList.Position position = this.m_RegisteredDevices.GetHeadPosition();
        while (true) {
            if (!position.IsValid()) {
                break;
            }
            SktEnumDevice pLocal = (SktEnumDevice) position.GetNext();
            if (AreIdentical(Reference, pLocal)) {
                SktEnumDevice EnumDevice2 = pLocal;
                break;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean AreIdentical(SktEnumDevice pDevice1, SktEnumDevice pDevice2) {
        boolean bSameManufacturerName = false;
        boolean bSameProductName = false;
        if (!(pDevice1 == null || pDevice2 == null)) {
            if (pDevice1.GetManufacturerName() == null || pDevice2.GetManufacturerName() == null) {
                if (pDevice1.GetManufacturerName() == null && pDevice2.GetManufacturerName() == null) {
                    bSameManufacturerName = true;
                }
            } else if (pDevice1.GetManufacturerName() == pDevice2.GetManufacturerName()) {
                bSameManufacturerName = true;
            }
            if (bSameManufacturerName) {
                if (pDevice1.GetProductName() == null || pDevice2.GetProductName() == null) {
                    if (pDevice1.GetProductName() == null && pDevice2.GetProductName() == null) {
                        bSameProductName = true;
                    }
                } else if (pDevice1.GetProductName() == pDevice2.GetProductName()) {
                    bSameProductName = true;
                }
            }
        }
        if (bSameManufacturerName && bSameProductName) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long SearchTransport(String pszDeviceName, SktTransport[] ppTransport, SktList.Position[] pPosition) {
        long Result = 0;
        SktList.Position position = this.m_Transports.GetHeadPosition();
        if (ppTransport == null || pszDeviceName == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktTransport[] ppTransport2 = new SktTransport[1];
        while (true) {
            if (!position.IsValid()) {
                break;
            }
            SktList.Position currentPosition = position.Copy();
            SktTransport pTransport = (SktTransport) position.GetNext();
            if (SktScanErrors.SKTSUCCESS(Result) && pTransport.GetDeviceName() != null && pTransport.GetDeviceName() == pszDeviceName) {
                if (pPosition != null) {
                    pPosition[0] = currentPosition;
                }
                ppTransport2[0] = pTransport;
            }
        }
        if (ppTransport2 == null) {
            return -17;
        }
        return Result;
    }
}
