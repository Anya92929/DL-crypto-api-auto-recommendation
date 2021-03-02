package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanDevice;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;

abstract class SktDeviceObjectInterface {
    protected String m_Guid;
    protected SktPlatform.SktLock m_Lock = new SktPlatform.SktLock();
    protected int m_Status = 0;
    protected ISktScanDevice m_hDevice;
    protected int m_nReferenceCount = 0;
    protected SktDeviceInterface m_pDeviceInterface = null;
    protected String m_pszFriendlyName = null;
    protected long m_ulDeviceType = ((long) SktScanDeviceType.kSktScanDeviceTypeNone);

    interface EStatus {
        public static final byte active = 0;
        public static final byte removed = 1;
        public static final byte toDelete = 2;
    }

    public abstract long GetProperty(TSktScanObject tSktScanObject, int i, SktScanTypes.TSktScanBoolean tSktScanBoolean, TSktScanObject[] tSktScanObjectArr);

    public abstract long SetProperty(TSktScanObject tSktScanObject, int i, SktScanTypes.TSktScanBoolean tSktScanBoolean, TSktScanObject[] tSktScanObjectArr);

    public long Initialize(String pszFriendlyName, long ulDeviceType) {
        long Result = 0;
        if (pszFriendlyName == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_ulDeviceType = ulDeviceType;
            this.m_pszFriendlyName = pszFriendlyName;
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Initialize(), "m_Lock.Initialize()");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            Deinitialize();
        }
        return Result;
    }

    public long Deinitialize() {
        this.m_ulDeviceType = (long) SktScanDeviceType.kSktScanDeviceTypeNone;
        this.m_pszFriendlyName = null;
        this.m_Lock.Deinitialize();
        return 0;
    }

    public boolean IsPhysicalDevice() {
        return true;
    }

    public long Open() {
        SetReferenceCount(GetReferenceCount() + 1);
        return 0;
    }

    public long Close() {
        SetReferenceCount(GetReferenceCount() - 1);
        return 0;
    }

    public void SetReferenceCount(int nNewReferenceCount) {
        this.m_nReferenceCount = nNewReferenceCount;
    }

    public int GetReferenceCount() {
        return this.m_nReferenceCount;
    }

    public void SetDeviceInterface(SktDeviceInterface pDeviceInterface) {
        this.m_pDeviceInterface = pDeviceInterface;
    }

    public SktDeviceInterface GetDeviceInterface() {
        return this.m_pDeviceInterface;
    }

    public String GetFriendlyName() {
        return this.m_pszFriendlyName;
    }

    public long GetDeviceType() {
        return this.m_ulDeviceType;
    }

    public String GetGuidAsString() {
        return this.m_Guid;
    }

    public long GetGuid(SktScanTypes.TSktScanString pGuid) {
        long Result = 0;
        if (pGuid == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pGuid.setValue(this.m_Guid);
        }
        return Result;
    }

    public void SetStatus(int status) {
        this.m_Status = status;
    }

    public int GetStatus() {
        return this.m_Status;
    }

    public long Lock() {
        return SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
    }

    public long Unlock() {
        return SktDebug.DBGSKT_EVAL(this.m_Lock.Unlock(), "m_Lock.Unlock()");
    }

    public ISktScanDevice getHandle() {
        return this.m_hDevice;
    }

    public void setHandle(ISktScanDevice hDevice) {
        this.m_hDevice = hDevice;
    }

    public TSktScanObject getFirstDecodedData() {
        if (this.m_pDeviceInterface != null) {
            return this.m_pDeviceInterface.GetFirstDecodedData();
        }
        return null;
    }

    public void storeFirstDecodedData(TSktScanObject decodedData) {
        if (this.m_pDeviceInterface != null) {
            this.m_pDeviceInterface.StoreFirstDecodedData(decodedData);
        }
    }
}
