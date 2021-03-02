package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;

abstract class SktProtocolInterface {
    private TSktScanObject _firstDecodedData;
    SktList m_InitializationProperties;
    SktTransport m_pTransport;

    interface EProtocolId {
        public static final int cordlessBtIscp = 2;
        public static final int cordlessSsi = 1;
        public static final int unidentified = 0;
    }

    interface EState {
        public static final int initialized = 2;
        public static final int initializing = 1;
        public static final int noInitialized = 0;
        public static final int outDatedVersion = 4;
        public static final int wrongProtocol = 3;
    }

    interface TSktPropertyMaskFunction {
        long MaskFunction(SktProtocolInterface sktProtocolInterface, SktScanTypes.TSktScanProperty tSktScanProperty);
    }

    public abstract long CheckIfInitialized(SktScanTypes.TSktScanInteger tSktScanInteger);

    public abstract long ContinueInitializing();

    public abstract long DoIoOperation(SktScanTypes.TSktScanBoolean tSktScanBoolean, SktPlatform.SktEvent[] sktEventArr, SktPlatform.SktEvent[] sktEventArr2, SktPlatform.SktEvent[] sktEventArr3);

    public abstract long GetProperty(TSktScanObject tSktScanObject, SktScanTypes.TSktScanBoolean tSktScanBoolean, TSktScanObject[] tSktScanObjectArr);

    public abstract int GetProtocolId();

    public abstract long RetrieveScanObject(TSktScanObject[] tSktScanObjectArr);

    public abstract long SetProperty(TSktScanObject tSktScanObject, SktScanTypes.TSktScanBoolean tSktScanBoolean, TSktScanObject[] tSktScanObjectArr);

    public abstract long StartInitializing();

    static class SktGetOrSetProperty {
        private SktScanTypes.TSktScanProperty m_Property = new SktScanTypes.TSktScanProperty();
        private long m_ResultToIgnore = 0;
        private boolean m_bPropertyGet = false;
        TSktPropertyMaskFunction m_pfnPropertyMask;

        public SktScanTypes.TSktScanProperty GetProperty() {
            return this.m_Property;
        }

        public void SetPropertyGet(boolean bGet) {
            this.m_bPropertyGet = bGet;
        }

        public boolean GetPropertyGet() {
            return this.m_bPropertyGet;
        }

        public void SetResultToIgnore(long ResultToIgnore) {
            this.m_ResultToIgnore = ResultToIgnore;
        }

        public long GetResultToIgnore() {
            return this.m_ResultToIgnore;
        }

        public void SetPropertyMaskFunction(TSktPropertyMaskFunction pfnFunction) {
            this.m_pfnPropertyMask = pfnFunction;
        }

        public TSktPropertyMaskFunction GetPropertyMaskFunction() {
            return this.m_pfnPropertyMask;
        }
    }

    static class SktChecksum {
        private char m_wChecksum = 0;
        private char m_wTemp = 0;

        public void Add(char ucByte) {
            this.m_wTemp = (char) (this.m_wTemp + ucByte);
            this.m_wChecksum = (char) (this.m_wChecksum + this.m_wTemp);
        }

        public char Get() {
            return this.m_wChecksum;
        }
    }

    public SktProtocolInterface() {
        this.m_pTransport = null;
        this.m_InitializationProperties = null;
        this._firstDecodedData = null;
    }

    public SktProtocolInterface(SktTransport pTransport) {
        this.m_pTransport = pTransport;
        this.m_InitializationProperties = new SktList();
        this._firstDecodedData = null;
    }

    public long GetScanApiVersionRequested(int[] pwMajor, int[] pwMiddle, int[] pwMinor) {
        if (pwMajor == null || pwMiddle == null || pwMinor == null) {
            return -18;
        }
        pwMajor[0] = 0;
        pwMiddle[0] = 0;
        pwMinor[0] = 0;
        return 0;
    }

    public long waitForDeviceReady(long timeout) {
        long Result = 0;
        char[] pData = new char[64];
        int[] size = new int[1];
        long count = timeout / 200;
        for (long i = 0; i < count; i++) {
            size[0] = 64;
            Result = this.m_pTransport.ReadBlock(pData, 0, size);
            if (!SktScanErrors.SKTSUCCESS(Result) || (Result == 0 && size[0] > 0)) {
                break;
            }
            SktPlatform.SktSystem.sleep(200);
        }
        return Result;
    }

    public long AddInitializationProperty(boolean bGet, SktScanTypes.TSktScanProperty pProperty, long ResultToIgnore, SktList.Position InsertBefore, TSktPropertyMaskFunction pfnMaskFunction) {
        long Result = 0;
        SktGetOrSetProperty pGetOrSetProperty = new SktGetOrSetProperty();
        if (pGetOrSetProperty == null) {
            Result = -2;
        } else {
            pGetOrSetProperty.SetPropertyGet(bGet);
            pGetOrSetProperty.SetResultToIgnore(ResultToIgnore);
            pGetOrSetProperty.SetPropertyMaskFunction(pfnMaskFunction);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pGetOrSetProperty.GetProperty(), pProperty), "SktUtilities.AllocateAndCopyProperty(pGetOrSetProperty.GetProperty(),pProperty)");
        }
        if (InsertBefore == null || !InsertBefore.IsValid()) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_InitializationProperties.AddTail(pGetOrSetProperty), "m_InitializationProperties.AddTail(pGetOrSetProperty)");
            }
        } else if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_InitializationProperties.InsertBefore(InsertBefore, pGetOrSetProperty), "m_InitializationProperties.InsertBefore(InsertBefore,pGetOrSetProperty)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
        }
        return Result;
    }

    public long ReadHeadInitializationProperty(SktScanTypes.TSktScanBoolean pbGet, SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanLong pResultToIgnore) {
        long Result = 0;
        SktGetOrSetProperty[] pGetOrSetProperty = new SktGetOrSetProperty[1];
        SktList.Position position = this.m_InitializationProperties.GetHeadPosition();
        if (pbGet == null || pResultToIgnore == null) {
            Result = -18;
        } else if (!position.IsValid()) {
            Result = -6;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_InitializationProperties.GetAt(position, pGetOrSetProperty), "m_InitializationProperties.GetAt(position,pGetOrSetProperty)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pProperty, pGetOrSetProperty[0].GetProperty()), "SktUtilities.AllocateAndCopyProperty(pProperty,pGetOrSetProperty[0].GetProperty())");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pGetOrSetProperty[0].GetPropertyMaskFunction() != null && SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pGetOrSetProperty[0].GetPropertyMaskFunction().MaskFunction(this, pProperty), "pGetOrSetProperty[0].GetPropertyMaskFunction().MaskFunction(this,pProperty)");
            }
            pbGet.setValue(pGetOrSetProperty[0].GetPropertyGet());
            pResultToIgnore.setValue(pGetOrSetProperty[0].GetResultToIgnore());
        }
        return Result;
    }

    public long RemoveInitializationProperty(SktScanTypes.TSktScanBoolean pbGet, SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanLong pResultToIgnore, TSktPropertyMaskFunction[] ppfnPropertyMaskFunction) {
        SktGetOrSetProperty[] pGetOrSetProperty = new SktGetOrSetProperty[1];
        long Result = SktDebug.DBGSKT_EVAL(this.m_InitializationProperties.RemoveHead(pGetOrSetProperty), "m_InitializationProperties.RemoveHead(pGetOrSetProperty)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pProperty, pGetOrSetProperty[0].GetProperty()), "SktUtilities.AllocateAndCopyProperty(pProperty,pGetOrSetProperty[0].GetProperty())");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pbGet.setValue(pGetOrSetProperty[0].GetPropertyGet());
            if (pResultToIgnore != null) {
                pResultToIgnore.setValue(pGetOrSetProperty[0].GetResultToIgnore());
            }
            if (ppfnPropertyMaskFunction != null) {
                ppfnPropertyMaskFunction[0] = pGetOrSetProperty[0].GetPropertyMaskFunction();
            }
            pGetOrSetProperty[0] = null;
        }
        return Result;
    }

    public int GetInitializationPropertyCount() {
        return this.m_InitializationProperties.GetCount();
    }

    public SktList.Position GetInitializationHeadPosition() {
        return this.m_InitializationProperties.GetHeadPosition();
    }

    public SktTransport GetTransport() {
        return this.m_pTransport;
    }

    public void StoreFirstDecodedData(TSktScanObject decodedData) {
        this._firstDecodedData = decodedData;
    }

    public TSktScanObject GetFirstDecodedData() {
        return this._firstDecodedData;
    }

    protected static void MarshallWordToPrimitive(int[] pwWord) {
    }
}
