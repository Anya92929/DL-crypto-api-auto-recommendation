package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktProtocolInterface;
import com.SocketMobile.ScanAPICore.SktScanTypes;

class SktDeviceInterface {
    public final int cannotInitialize = 5;
    public final int initialized = 4;
    public final int initializingDeviceInterface = 2;
    public final int initializingProtocol = 0;
    public final int initializingScanApiConfig = 3;
    final int kMaxProtocolToTry = 2;
    final long kSktDeviceReadyTimeout = 1000;
    final long kSktInitializationTimeout = 4000;
    final long kSktPropertyTimeout = 5000;
    private int m_InitState;
    private SktScanTypes.TSktScanProperty m_LastPropertyForApp;
    private SktScanTypes.TSktScanProperty m_LastPropertyForScanAPI;
    private SktPlatform.SktLock m_LastPropertySentLock;
    private int m_TransportType;
    private boolean m_bArrivalAlreadyNotified;
    private boolean m_bInitGetCompleteProperty;
    private int m_nDeviceInitializationCount;
    private int m_nProtocolTry;
    private int m_nScanApiInitializationCount;
    private SktScanTypes.TSktScanProperty m_pInitCompleteProperty;
    SktProtocolInterface m_pProtocol;
    private SktScanTypes.TSktScanProperty m_pTimedOutProperty;
    private SktTransport m_pTransport;
    private String m_pszDeviceName;
    private long m_ulDeviceType;
    private long m_ulInitializationTimeout;
    public final int restartProtocol = 1;

    interface EInitStatus {
        public static final int deviceInitialized = 4;
        public static final int initializing = 0;
        public static final int justDoneWithDeviceInitialization = 1;
        public static final int justDoneWithInitialization = 2;
        public static final int outDatedScanAPI = 5;
        public static final int unableToInitialize = 3;
    }

    interface ESktDestination {
        public static final int kSktDestinationApp = 1;
        public static final int kSktDestinationScanAPI = 0;
    }

    public SktDeviceInterface(int TransportType, SktTransport pTransport) {
        this.m_TransportType = TransportType;
        this.m_pTransport = pTransport;
        this.m_pProtocol = null;
        this.m_pszDeviceName = null;
        this.m_ulDeviceType = (long) SktScanDeviceType.kSktScanDeviceTypeNone;
        this.m_bArrivalAlreadyNotified = false;
        this.m_InitState = 0;
        this.m_pTimedOutProperty = null;
        this.m_pInitCompleteProperty = null;
        this.m_bInitGetCompleteProperty = false;
        this.m_nDeviceInitializationCount = 0;
        this.m_nScanApiInitializationCount = 0;
        this.m_LastPropertySentLock = new SktPlatform.SktLock();
        this.m_LastPropertyForScanAPI = new SktScanTypes.TSktScanProperty();
        this.m_LastPropertyForApp = new SktScanTypes.TSktScanProperty();
        this.m_ulInitializationTimeout = 0;
    }

    public SktTransport GetTransport() {
        return this.m_pTransport;
    }

    public long GetScanApiVersionRequested(int[] pwMajor, int[] pwMiddle, int[] pwMinor) {
        if (this.m_pProtocol != null) {
            return SktDebug.DBGSKT_EVAL(this.m_pProtocol.GetScanApiVersionRequested(pwMajor, pwMiddle, pwMinor), "m_pProtocol.GetScanApiVersionRequested(pwMajor, pwMiddle, pwMinor)");
        }
        return -19;
    }

    public long AddInitialization(boolean bGet, SktScanTypes.TSktScanProperty pProperty, long ResultToIgnore) {
        long Result = 0;
        SktDebug.DBGSKT_MSG(1, "Add a Get Or Set property in the list");
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.AddInitializationProperty(bGet, pProperty, ResultToIgnore, (SktList.Position) null, (SktProtocolInterface.TSktPropertyMaskFunction) null), "m_pProtocol.AddInitializationProperty(bGet,pProperty,ResultToIgnore,null,null)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_InitState = 3;
            this.m_nScanApiInitializationCount++;
        }
        return Result;
    }

    public long StartInitializing(boolean bInitializeProtocol) {
        this.m_ulInitializationTimeout = System.currentTimeMillis() + 1000;
        if (bInitializeProtocol) {
            long Result = SktDebug.DBGSKT_EVAL(this.m_LastPropertySentLock.Initialize(), "m_LastPropertySentLock.Initialize()");
            this.m_nProtocolTry = 2;
            this.m_InitState = 0;
            this.m_pProtocol = null;
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (this.m_TransportType) {
                    case 1:
                        this.m_pProtocol = new SktBtIscpProtocol(this.m_pTransport);
                        if (this.m_pProtocol == null) {
                            Result = -2;
                            break;
                        }
                        break;
                    case 2:
                        this.m_pProtocol = new SktSsiProtocol(this.m_pTransport);
                        if (this.m_pProtocol == null) {
                            Result = -2;
                            break;
                        }
                        break;
                    default:
                        Result = -23;
                        break;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddNecessaryPropertiesRequests(), "AddNecessaryPropertiesRequests()");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_MSG(257, "Wait for device ready");
                Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.waitForDeviceReady(1000), "m_pProtocol.waitForDeviceReady(kSktDeviceReadyTimeout)");
                SktDebug.DBGSKT_MSG(257, "Done waiting for device ready");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.StartInitializing(), "m_pProtocol.StartInitializing()");
            }
            this.m_nProtocolTry--;
            return Result;
        }
        this.m_InitState = 3;
        return SktDebug.DBGSKT_EVAL(ContinueInitializing(), "ContinueInitializing()");
    }

    public long ContinueInitializing() {
        long Result = 0;
        if (this.m_pProtocol == null) {
            Result = -19;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        switch (this.m_InitState) {
            case 0:
            case 2:
            case 3:
                long Result2 = SktDebug.DBGSKT_EVAL(this.m_pProtocol.ContinueInitializing(), "m_pProtocol.ContinueInitializing()");
                this.m_ulInitializationTimeout = System.currentTimeMillis();
                return Result2;
            case 1:
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddNecessaryPropertiesRequests(), "AddNecessaryPropertiesRequests()");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.StartInitializing(), "m_pProtocol.StartInitializing()");
                }
                this.m_nProtocolTry--;
                this.m_InitState = 0;
                this.m_ulInitializationTimeout = System.currentTimeMillis();
                return Result;
            default:
                return Result;
        }
    }

    public long CheckIfInitialized(SktScanTypes.TSktScanInteger pInitStatus) {
        long Result;
        long Result2 = 0;
        TSktScanObject[] pScanObj = new TSktScanObject[1];
        SktScanTypes.TSktScanInteger Destination = new SktScanTypes.TSktScanInteger(0);
        SktProtocolInterface.TSktPropertyMaskFunction[] pfnMaskFunction = new SktProtocolInterface.TSktPropertyMaskFunction[1];
        boolean decodedData = false;
        if (this.m_pProtocol == null) {
            Result2 = -19;
        }
        if (!SktScanErrors.SKTSUCCESS(Result2)) {
            return Result2;
        }
        pInitStatus.setValue(0);
        if (HasInitializationTimedout()) {
            this.m_InitState = 5;
            this.m_ulInitializationTimeout = 0;
        }
        switch (this.m_InitState) {
            case 0:
                SktScanTypes.TSktScanInteger CProtocolInitState = new SktScanTypes.TSktScanInteger(0);
                long Result3 = SktDebug.DBGSKT_EVAL(this.m_pProtocol.CheckIfInitialized(CProtocolInitState), "m_pProtocol.CheckIfInitialized(CProtocolInitState)");
                int ProtocolInitState = CProtocolInitState.getValue();
                if (!SktScanErrors.SKTSUCCESS(Result3)) {
                    return Result3;
                }
                switch (ProtocolInitState) {
                    case 2:
                        this.m_InitState = 2;
                        return Result3;
                    case 3:
                        SktDebug.DBGSKT_MSG(SktSsiProtocol.kSsiSubCmdBatteryStateInquiry, "WRONG PROTOCOL???");
                        if (this.m_nProtocolTry == 0) {
                            this.m_InitState = 5;
                            return Result3;
                        }
                        SktTransport pTransport = this.m_pProtocol.GetTransport();
                        this.m_InitState = 1;
                        switch (this.m_pProtocol.GetProtocolId()) {
                            case 1:
                                this.m_pProtocol = null;
                                this.m_pProtocol = new SktBtIscpProtocol(pTransport);
                                if (this.m_pProtocol == null) {
                                    return -2;
                                }
                                return Result3;
                            case 2:
                                this.m_pProtocol = null;
                                this.m_pProtocol = new SktSsiProtocol(pTransport);
                                if (this.m_pProtocol == null) {
                                    return -2;
                                }
                                return Result3;
                            default:
                                this.m_InitState = 5;
                                return Result3;
                        }
                    case 4:
                        pInitStatus.setValue(5);
                        return Result3;
                    default:
                        return Result3;
                }
            case 2:
            case 3:
                long Result4 = SktDebug.DBGSKT_EVAL(RetrieveScanObject(pScanObj, Destination), "RetrieveScanObject(pScanObj,Destination)");
                if (SktScanErrors.SKTSUCCESS(Result4) && pScanObj[0].Msg.MsgID == 6 && pScanObj[0].Msg.Event.f12ID == 1) {
                    this.m_pProtocol.StoreFirstDecodedData(pScanObj[0]);
                    decodedData = true;
                }
                if (decodedData) {
                    return Result4;
                }
                if (SktScanErrors.SKTSUCCESS(Result4)) {
                    Result4 = pScanObj[0].Msg.Result;
                    if (!SktScanErrors.SKTSUCCESS(Result4)) {
                        SktUtilities.ReleaseScanObject(pScanObj[0]);
                    }
                }
                if (!SktScanErrors.SKTSUCCESS(Result4)) {
                    return Result4;
                }
                SktScanTypes.TSktScanBoolean bGet = new SktScanTypes.TSktScanBoolean(false);
                SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
                if (SktScanErrors.SKTSUCCESS(Result4)) {
                    Result4 = SktDebug.DBGSKT_EVAL(this.m_pProtocol.RemoveInitializationProperty(bGet, Property, (SktScanTypes.TSktScanLong) null, pfnMaskFunction), "m_pProtocol.RemoveInitializationProperty(bGet,Property,null)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (pScanObj[0].Property.f13ID == Property.f13ID) {
                        SktUtilities.ReleaseProperty(Property);
                        Result = SktDebug.DBGSKT_EVAL(SaveInitializationConfiguration(pScanObj[0].Property), "SaveInitializationConfiguration(pScanObj[0].Property)");
                        if (this.m_nDeviceInitializationCount > 0) {
                            this.m_nDeviceInitializationCount--;
                        } else if (this.m_nScanApiInitializationCount > 0) {
                            this.m_nScanApiInitializationCount--;
                        }
                    } else {
                        SktDebug.DBGSKT_MSG(1, "Put back a Get Or Set property from the list");
                        Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.AddInitializationProperty(bGet.getValue(), Property, 0, this.m_pProtocol.GetInitializationHeadPosition(), pfnMaskFunction[0]), "m_pProtocol.AddInitializationProperty(bGet.getValue(),Property,SktScanErrors.ESKT_NOERROR,headPosition)");
                    }
                    if (this.m_nDeviceInitializationCount == 0) {
                        if (this.m_InitState == 2) {
                            SktDebug.DBGSKT_MSG(257, "Protocol and Device Interface Initialized");
                            pInitStatus.setValue(1);
                            this.m_InitState = 4;
                            this.m_ulInitializationTimeout = 0;
                        } else if (this.m_InitState == 3 && this.m_nScanApiInitializationCount == 0) {
                            SktDebug.DBGSKT_MSG(257, "Protocol and Device Interface Initialized and ScanAPI config applied");
                            this.m_InitState = 4;
                            pInitStatus.setValue(2);
                            this.m_ulInitializationTimeout = 0;
                        }
                    }
                }
                SktUtilities.ReleaseScanObject(pScanObj[0]);
                return Result;
            case 4:
                pInitStatus.setValue(4);
                this.m_ulInitializationTimeout = 0;
                return Result2;
            case 5:
                pInitStatus.setValue(3);
                return Result2;
            default:
                return Result2;
        }
    }

    public long SaveInitializationCompleteProperty(SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanBoolean bGetComplete) {
        long Result = 0;
        if (this.m_pInitCompleteProperty != null) {
            SktUtilities.ReleaseProperty(this.m_pInitCompleteProperty);
            this.m_pInitCompleteProperty = null;
        }
        this.m_pInitCompleteProperty = new SktScanTypes.TSktScanProperty();
        if (this.m_pInitCompleteProperty == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(this.m_pInitCompleteProperty, pProperty), "SktUtilities.AllocateAndCopyProperty(m_pInitCompleteProperty,pProperty)");
        }
        this.m_bInitGetCompleteProperty = bGetComplete.getValue();
        return Result;
    }

    public long RemoveInitializationCompleteProperty(SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanBoolean pGetComplete) {
        long Result = 0;
        if (pProperty == null || pGetComplete == null) {
            Result = -18;
        } else {
            pGetComplete.setValue(this.m_bInitGetCompleteProperty);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pProperty, this.m_pInitCompleteProperty), "SktUtilities.AllocateAndCopyProperty(pProperty,m_pInitCompleteProperty)");
        }
        SktUtilities.ReleaseProperty(this.m_pInitCompleteProperty);
        this.m_pInitCompleteProperty = null;
        return Result;
    }

    public boolean IsThereInitializationCompleteProperty() {
        return this.m_pInitCompleteProperty != null;
    }

    public void ForceInitializationStatus(int status) {
        switch (status) {
            case 0:
                this.m_InitState = 0;
                return;
            case 1:
                this.m_InitState = 3;
                return;
            case 2:
                this.m_InitState = 4;
                return;
            case 3:
                this.m_InitState = 5;
                return;
            case 4:
                this.m_InitState = 4;
                return;
            default:
                return;
        }
    }

    public boolean IsArrivalAlreadyNotified() {
        return this.m_bArrivalAlreadyNotified;
    }

    public void SetArrivalAlreadyNotified(boolean bIsArrivalAlreadyNotified) {
        this.m_bArrivalAlreadyNotified = bIsArrivalAlreadyNotified;
    }

    public long GetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        SktScanTypes.TSktScanBoolean bGetOperation = new SktScanTypes.TSktScanBoolean(true);
        if (this.m_pProtocol == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SaveLastPropertySent(pScanObj.Property, Destination, true), "SaveLastPropertySent(pScanObj.Property,Destination,true)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this.m_pProtocol.GetProperty(pScanObj, pbImmediateResponse, ppResponseScanObj), "m_pProtocol.GetProperty(pScanObj,pbImmediateResponse,ppResponseScanObj)");
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            return (pbImmediateResponse == null || ppResponseScanObj == null || !pbImmediateResponse.getValue()) ? Result2 : SktDebug.DBGSKT_EVAL(RemoveLastPropertySent(ppResponseScanObj[0].Property, new SktScanTypes.TSktScanInteger(Destination), bGetOperation), "RemoveLastPropertySent((ppResponseScanObj[0]).Property,new TSktScanInteger(Destination),bGetOperation)");
        }
        RemoveLastPropertySent(pScanObj.Property, new SktScanTypes.TSktScanInteger(Destination), bGetOperation);
        return Result2;
    }

    public long SetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        SktScanTypes.TSktScanBoolean bGetOperation = new SktScanTypes.TSktScanBoolean(false);
        if (this.m_pProtocol == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SaveLastPropertySent(pScanObj.Property, Destination, false), "SaveLastPropertySent(pScanObj.Property,Destination,false)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this.m_pProtocol.SetProperty(pScanObj, pbImmediateResponse, ppResponseScanObj), "m_pProtocol.SetProperty(pScanObj,pbImmediateResponse,ppResponseScanObj)");
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            return (pbImmediateResponse == null || ppResponseScanObj == null || !pbImmediateResponse.getValue()) ? Result2 : SktDebug.DBGSKT_EVAL(RemoveLastPropertySent(ppResponseScanObj[0].Property, new SktScanTypes.TSktScanInteger(Destination), bGetOperation), "RemoveLastPropertySent((ppResponseScanObj[0]).Property,new TSktScanInteger(Destination),bGetOperation)");
        }
        RemoveLastPropertySent(pScanObj.Property, new SktScanTypes.TSktScanInteger(Destination), bGetOperation);
        return Result2;
    }

    public long RetrieveScanObject(TSktScanObject[] ppScanObject, SktScanTypes.TSktScanInteger pDestination) {
        long Result = 0;
        SktScanTypes.TSktScanBoolean bGetOperation = new SktScanTypes.TSktScanBoolean(false);
        boolean bDeleteInCaseOfError = false;
        if (this.m_pProtocol == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (ppScanObject == null || pDestination == null)) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pDestination.setValue(1);
            ppScanObject[0] = new TSktScanObject();
            if (ppScanObject[0] == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            bDeleteInCaseOfError = true;
            if (HasInitializationTimedout()) {
                ppScanObject[0].Msg.MsgID = 6;
                ppScanObject[0].Msg.Event.f12ID = 0;
                ppScanObject[0].Msg.Result = -21;
                this.m_ulInitializationTimeout = 0;
            } else if (!HasPropertyTimedOut()) {
                Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.RetrieveScanObject(ppScanObject), "m_pProtocol.RetrieveScanObject(ppScanObject)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    switch (ppScanObject[0].Msg.MsgID) {
                        case 4:
                        case 5:
                            Result = SktDebug.DBGSKT_EVAL(RemoveLastPropertySent(ppScanObject[0].Property, pDestination, bGetOperation), "RemoveLastPropertySent((ppScanObject[0]).Property,pDestination,bGetOperation)");
                            break;
                        default:
                            ppScanObject[0].Property.Context = null;
                            break;
                    }
                } else {
                    ppScanObject[0].Msg.MsgID = 6;
                    ppScanObject[0].Msg.Event.f12ID = 0;
                    ppScanObject[0].Msg.Result = Result;
                    Result = 0;
                }
            } else {
                SktDebug.DBGSKT_MSG(SktSsiProtocol.kSsiSubCmdBatteryStateInquiry, "A Property has timed out");
                Result = SktDebug.DBGSKT_EVAL(RetrieveTimedOutProperty(ppScanObject[0].Property, pDestination, bGetOperation), "RetrieveTimedOutProperty((ppScanObject[0]).Property,pDestination,bGetOperation)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (bGetOperation.getValue()) {
                        ppScanObject[0].Msg.MsgID = 5;
                    } else {
                        ppScanObject[0].Msg.MsgID = 4;
                    }
                    ppScanObject[0].Msg.Result = -42;
                }
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) && bDeleteInCaseOfError) {
            ppScanObject[0] = null;
        }
        return Result;
    }

    public long DoIoOperation(SktScanTypes.TSktScanBoolean pbPacketReady, SktPlatform.SktEvent[] ppReadCompletionEvent, SktPlatform.SktEvent[] ppWriteCompletionEvent, SktPlatform.SktEvent[] ppPacketReadyToSend) {
        long Result = 0;
        if (this.m_pProtocol == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.DoIoOperation(pbPacketReady, ppReadCompletionEvent, ppWriteCompletionEvent, ppPacketReadyToSend), "m_pProtocol.DoIoOperation(pbPacketReady,ppReadCompletionEvent,ppWriteCompletionEvent,ppPacketReadyToSend)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || pbPacketReady.getValue()) {
            return Result;
        }
        if (this.m_ulInitializationTimeout > 0) {
            pbPacketReady.setValue(HasInitializationTimedout());
            return Result;
        }
        long PreviousResult = Result;
        long Result2 = SktDebug.DBGSKT_EVAL(CheckForPropertyTimeout(pbPacketReady), "CheckForPropertyTimeout(pbPacketReady)");
        if (!SktScanErrors.SKTSUCCESS(Result2) || pbPacketReady.getValue()) {
            return Result2;
        }
        return PreviousResult;
    }

    public long WriteDeviceName(String pszName, int nLength) {
        long Result = 0;
        if (pszName == null && nLength > 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_pszDeviceName = pszName;
        }
        return Result;
    }

    public String GetDeviceName() {
        return this.m_pszDeviceName;
    }

    public void SetDeviceType(long ulDeviceType) {
        this.m_ulDeviceType = ulDeviceType;
    }

    public long GetDeviceType() {
        return this.m_ulDeviceType;
    }

    /* access modifiers changed from: protected */
    public long AddNecessaryPropertiesRequests() {
        long Result = 0;
        this.m_nDeviceInitializationCount = 0;
        int nCurrentInitializationPropertyCount = this.m_pProtocol.GetInitializationPropertyCount();
        SktList.Position headPosition = this.m_pProtocol.GetInitializationHeadPosition();
        SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdFriendlyNameDevice;
        Property.Type = 0;
        SktDebug.DBGSKT_MSG(1, "Add Necessary a Get Or Set property in the list");
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "m_pProtocol.AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktScanTypes.TSktScanProperty Property2 = new SktScanTypes.TSktScanProperty();
            Property2.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceType;
            Property2.Type = 0;
            SktDebug.DBGSKT_MSG(1, "Add Necessary a Get Or Set property in the list");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_pProtocol.AddInitializationProperty(true, Property2, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "m_pProtocol.AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition)");
            }
        }
        this.m_nDeviceInitializationCount = this.m_pProtocol.GetInitializationPropertyCount() - nCurrentInitializationPropertyCount;
        return Result;
    }

    /* access modifiers changed from: protected */
    public long InsertDeviceInterfaceContext(SktScanTypes.TSktScanProperty pProperty, int Destination, boolean bGetOperation) {
        long Result = 0;
        if (pProperty == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktDeviceInterfacePropertyContext pDeviceInterfaceContext = new SktDeviceInterfacePropertyContext();
            if (pDeviceInterfaceContext != null) {
                pDeviceInterfaceContext.SetContext(pProperty.Context);
                pDeviceInterfaceContext.SetDestination(Destination);
                pDeviceInterfaceContext.SetRequestOperation(bGetOperation);
                pDeviceInterfaceContext.SetTickCount(System.currentTimeMillis());
                pProperty.Context = pDeviceInterfaceContext;
            } else {
                Result = -2;
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ExtractDeviceInterfaceContext(SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanInteger pDestination, SktScanTypes.TSktScanBoolean pGetOperation) {
        long Result = 0;
        if (pProperty == null || pDestination == null || pGetOperation == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktDeviceInterfacePropertyContext pDeviceInterfaceContext = (SktDeviceInterfacePropertyContext) pProperty.Context;
        if (pDeviceInterfaceContext == null) {
            return -17;
        }
        pProperty.Context = pDeviceInterfaceContext.GetContext();
        pDestination.setValue(pDeviceInterfaceContext.GetDestination());
        pGetOperation.setValue(pDeviceInterfaceContext.GetRequestOperation());
        return Result;
    }

    /* access modifiers changed from: protected */
    public long SaveLastPropertySent(SktScanTypes.TSktScanProperty pProperty, int Destination, boolean bGetOperation) {
        long Result = 0;
        SktScanTypes.TSktScanProperty pLastProperty = null;
        if (pProperty == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_LastPropertySentLock.Lock(), "m_LastPropertySentLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (Destination == 0) {
                if (this.m_LastPropertyForScanAPI.f13ID != 0) {
                    Result = -16;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    SktDebug.DBGSKT_MSG(257, "Saving Last Property Sent for ScanAPI");
                    pLastProperty = this.m_LastPropertyForScanAPI;
                }
            } else {
                if (this.m_LastPropertyForApp.f13ID != 0) {
                    Result = -16;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    SktDebug.DBGSKT_MSG(257, "Saving Last Property Sent for App");
                    pLastProperty = this.m_LastPropertyForApp;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pLastProperty, pProperty), "SktUtilities.AllocateAndCopyProperty(pLastProperty,pProperty)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(InsertDeviceInterfaceContext(pLastProperty, Destination, bGetOperation), "InsertDeviceInterfaceContext(pLastProperty,Destination,bGetOperation)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pLastProperty = null;
            }
            if (pLastProperty != null) {
                SktUtilities.ReleaseProperty(pLastProperty);
                pLastProperty.f13ID = 0;
            }
            this.m_LastPropertySentLock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long RemoveLastPropertySent(SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanInteger pDestination, SktScanTypes.TSktScanBoolean pGetOperation) {
        long Result = 0;
        if (pProperty == null || pDestination == null || pGetOperation == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_LastPropertySentLock.Lock(), "m_LastPropertySentLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (this.m_LastPropertyForScanAPI.f13ID == pProperty.f13ID) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(ExtractDeviceInterfaceContext(this.m_LastPropertyForScanAPI, pDestination, pGetOperation), "ExtractDeviceInterfaceContext(m_LastPropertyForScanAPI,pDestination,pGetOperation)");
                }
                pProperty.Context = this.m_LastPropertyForScanAPI.Context;
                SktUtilities.ReleaseProperty(this.m_LastPropertyForScanAPI);
                this.m_LastPropertyForApp = new SktScanTypes.TSktScanProperty();
                SktDebug.DBGSKT_MSG(257, "Remove Last Property Sent for ScanAPI");
            } else if (this.m_LastPropertyForApp.f13ID == pProperty.f13ID) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(ExtractDeviceInterfaceContext(this.m_LastPropertyForApp, pDestination, pGetOperation), "ExtractDeviceInterfaceContext(m_LastPropertyForApp,pDestination,pGetOperation)");
                }
                pProperty.Context = this.m_LastPropertyForApp.Context;
                SktUtilities.ReleaseProperty(this.m_LastPropertyForApp);
                this.m_LastPropertyForApp = new SktScanTypes.TSktScanProperty();
                SktDebug.DBGSKT_MSG(257, "Remove Last Property Sent for App");
            }
            this.m_LastPropertySentLock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long CheckForPropertyTimeout(SktScanTypes.TSktScanBoolean pbPropertyTimedOut) {
        SktDeviceInterfacePropertyContext pContext;
        long Result = 0;
        this.m_pTimedOutProperty = null;
        if (pbPropertyTimedOut == null) {
            Result = -18;
        } else {
            pbPropertyTimedOut.setValue(false);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_LastPropertySentLock.Lock(), "m_LastPropertySentLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktDeviceInterfacePropertyContext pContext2 = (SktDeviceInterfacePropertyContext) this.m_LastPropertyForScanAPI.Context;
            if (pContext2 != null && System.currentTimeMillis() - pContext2.GetTickCount() > 5000) {
                pbPropertyTimedOut.setValue(true);
                this.m_pTimedOutProperty = this.m_LastPropertyForScanAPI;
            }
            if (!pbPropertyTimedOut.getValue() && (pContext = (SktDeviceInterfacePropertyContext) this.m_LastPropertyForApp.Context) != null && System.currentTimeMillis() - pContext.GetTickCount() > 5000) {
                pbPropertyTimedOut.setValue(true);
                this.m_pTimedOutProperty = this.m_LastPropertyForApp;
            }
            this.m_LastPropertySentLock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public boolean HasPropertyTimedOut() {
        return this.m_pTimedOutProperty != null;
    }

    /* access modifiers changed from: protected */
    public long RetrieveTimedOutProperty(SktScanTypes.TSktScanProperty pProperty, SktScanTypes.TSktScanInteger pDestination, SktScanTypes.TSktScanBoolean pGetOperation) {
        long Result = 0;
        if (pProperty == null || pDestination == null || pGetOperation == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_LastPropertySentLock.Lock(), "m_LastPropertySentLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (this.m_pTimedOutProperty == this.m_LastPropertyForScanAPI) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(ExtractDeviceInterfaceContext(this.m_LastPropertyForScanAPI, pDestination, pGetOperation), "ExtractDeviceInterfaceContext(m_LastPropertyForScanAPI,pDestination,pGetOperation)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pProperty, this.m_LastPropertyForScanAPI), "SktUtilities.AllocateAndCopyProperty(pProperty,m_LastPropertyForScanAPI)");
                }
                SktUtilities.ReleaseProperty(this.m_LastPropertyForScanAPI);
                this.m_LastPropertyForApp = new SktScanTypes.TSktScanProperty();
            } else if (this.m_pTimedOutProperty == this.m_LastPropertyForApp) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(ExtractDeviceInterfaceContext(this.m_LastPropertyForApp, pDestination, pGetOperation), "ExtractDeviceInterfaceContext(m_LastPropertyForApp,pDestination,pGetOperation)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(pProperty, this.m_LastPropertyForApp), "SktUtilities.AllocateAndCopyProperty(pProperty,m_LastPropertyForApp)");
                }
                SktUtilities.ReleaseProperty(this.m_LastPropertyForApp);
                this.m_LastPropertyForApp = new SktScanTypes.TSktScanProperty();
            } else {
                Result = -17;
            }
            this.m_pTimedOutProperty = null;
            this.m_LastPropertySentLock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long SaveInitializationConfiguration(SktScanTypes.TSktScanProperty pProperty) {
        if (pProperty.f13ID == 327936) {
            if (pProperty.Type != 5) {
                return -18;
            }
            SktDebug.DBGSKT_MSG(1, "Device Friendly Name: " + pProperty.String.m_Value);
            return SktDebug.DBGSKT_EVAL(WriteDeviceName(pProperty.String.m_Value, pProperty.String.nLength), "WriteDeviceName(pProperty.String.m_Value,pProperty.String.nLength)");
        } else if (pProperty.f13ID != 65538) {
            return 0;
        } else {
            if (pProperty.Type != 3) {
                return -18;
            }
            SetDeviceType(pProperty.Ulong);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean HasInitializationTimedout() {
        boolean bResult = false;
        if (this.m_ulInitializationTimeout > 0) {
            bResult = System.currentTimeMillis() > this.m_ulInitializationTimeout + 4000;
            if (bResult) {
                SktDebug.DBGSKT_MSG(2, "SktDeviceInterface: Initialization has timed out");
            }
        }
        return bResult;
    }

    public TSktScanObject GetFirstDecodedData() {
        if (this.m_pProtocol != null) {
            return this.m_pProtocol.GetFirstDecodedData();
        }
        return null;
    }

    public void StoreFirstDecodedData(TSktScanObject decodedData) {
        if (this.m_pProtocol != null) {
            this.m_pProtocol.StoreFirstDecodedData(decodedData);
        }
    }

    public static boolean Test() {
        return true;
    }
}
