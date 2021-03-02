package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanApi;
import com.SocketMobile.ScanAPI.ISktScanDevice;
import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.SktScan;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;

class SktScanAPI {
    static String[] DBG_GENERALPROPIDDEVICE_NAME = {"kSktScanIdDeviceVersion", "kSktScanIdDeviceInterfaceVersion", "kSktScanIdDeviceType", "kSktScanIdDeviceSpecific", "kSktScanIdDeviceSymbology", "kSktScanIdDeviceTrigger", "kSktScanIdDeviceApplyConfig", "kSktScanIdDevicePreamble", "kSktScanIdDevicePostamble", "kSktScanIdDeviceCapabilities", "kSktScanIdDeviceChangeId", "kSktScanIdDeviceDataFormat"};
    static String[] DBG_LOCALFUNCTIONSPROPID_NAME = {"kSktScanIdDeviceFriendlyName", "kSktScanIdDeviceSecurityMode", "kSktScanIdDevicePinCode", "kSktScanIdDeviceDeletePairingBonding", "kSktScanIdDeviceRestoreFactoryDefaults", "kSktScanIdDeviceSetPowerOff", "kSktScanIdDeviceButtonsStatus", "kSktScanIdDeviceSoundConfig", "kSktScanIdDeviceTimers", "kSktScanIdDeviceLocalAcknowledgement", "kSktScanIdDeviceDataConfirmation", "kSktScanIdDeviceBatteryLevel", "kSktScanIdDeviceLocalDecodeAction", "kSktScanIdDeviceBluetoothAddress", "kSktScanIdDeviceStatisticCounters", "kSktScanIdDeviceRumbleConfig", "kSktScanIdDeviceProfileConfig", "kSktScanIdDeviceDisconnect", "kSktScanIdDeviceDataStore", "kSktScanIdDeviceNotifications", "kSktScanIdDeviceConnectReason", "kSktScanIdDevicePowerState", "kSktScanIdDeviceStartUpRoleSPP", "kSktScanIdDeviceConnectionBeepConfig", "kSktScanIdDeviceFlashDevice", "kSktScanIdOverlayViewDevice", "kSktScanIdDeviceStandConfig"};
    static String SKTSCANAPIINTERFACE_VERSION = "1.3.0";
    static String[] SktScanSymbologyNames = {"Not Specified", "Australia Post", "Aztec", "Bookland Ean", "British Post", "Canada Post", "Chinese 2 of 5", "Codabar", "Codablock A", "Codablock F", "Code 11", "Code 39", "Code 39 Extended", "Code 39 Trioptic", "Code 93", "Code 128", "Data Matrix", "Dutch Post", "Ean 8", "Ean 13", "GS1-128", "GS1-128 Irregular", "GS1 Composite AB", "GS1 Composite C", "GS1 Databar", "GS1 Databar Limited", "GS1 Databar Expanded", "Interleaved 2 of 5", "Isbt 128", "Japan Post", "Matrix 2 of 5", "Maxicode", "Msi", "Pdf417", "Pdf417 Micro", "Planet", "Plessey", "Postnet", "QR Code", "Standard 2 of 5", "Telepen", "Tlc39", "UPC A", "UPC E0", "UPC E1", "USPS Int. Mail", "Direct Part Marking", "Unknown Symbology"};
    String[] DBG_GENERALPROPID_NAME = {"kSktScanIdAbort", "kSktScanIdVersion", "kSktScanIdInterfaceVersion", "kSktScanIdConfiguration", "kSktScanIdDataConfirmationMode", "kSktScanIdDataConfirmationAction", "kSktScanIdMonitorMode", "kSktScanIdSoftScanStatus", "kSktScanIdDataEditingProfile", "kSktScanIdDataEditingCurrentProfile", "kSktScanIdDataEditingTriggerSymbologies", "kSktScanIdDataEditingTriggerMinLength", "kSktScanIdDataEditingTriggerMaxLength", "kSktScanIdDataEditingTriggerStartsWith", "kSktScanIdDataEditingTriggerEndsWith", "kSktScanIdDataEditingTriggerContains", "kSktScanIdDataEditingOperation", "kSktScanIdDataEditingImportExport"};
    String[] DBG_MSGID_NAME = {"kSktScanMsgIdNotInitialized", "kSktScanMsgIdDeviceArrival", "kSktScanMsgIdDeviceRemoval", "kSktScanMsgIdTerminate", "kSktScanMsgSetComplete", "kSktScanMsgGetComplete", "kSktScanMsgEvent"};
    final String SCANAPI_BUILD = "149";
    final String SCANAPI_DATE = "$Date: 2014-10-17 04:11:46 (Fri,17 Oct 2014) $";
    final String SCANAPI_REVISION = "$Rev: 12578 $";
    final String SCANAPI_VERSION = "10.1";
    private ISktScanApi _handle;
    String kConfigurationChangeEvent = "SktScanConfigNotify";
    final int kQueueMaximumItems = 20;
    final String kSktDefaultSoftScannerName = "SoftScanner";
    final long kThreadTerminationTimeout = 10000;
    private SktConfigurationBase m_Configuration;
    SktPlatform.SktFlipFlop m_ConfigurationFlipFlopEvent;
    SktDataEditingProfile m_DataEditingProfile;
    private SktList m_DeviceObjects;
    private SktPlatform.SktLock m_DeviceObjectsLock;
    SktPlatform.SktFlipFlop.State m_FlipFlopEventState;
    private SktThread m_ListenerThread;
    private SktQueue m_MessageQueue;
    private SktPlatform.SktLock m_MessageQueueLock;
    private volatile boolean m_bShouldListenerThreadStop;
    private volatile boolean m_bStopAndRestartListenerThreadProcess;
    private boolean m_bWithOpeningTransport;
    private int m_nReferenceCount;

    public SktScanAPI(ISktScanApi handle) {
        this._handle = handle;
        this.m_bShouldListenerThreadStop = false;
        this.m_bStopAndRestartListenerThreadProcess = false;
        this.m_bWithOpeningTransport = true;
        this.m_nReferenceCount = 0;
        this.m_MessageQueue = new SktQueue();
        this.m_MessageQueueLock = new SktPlatform.SktLock();
        this.m_ListenerThread = new SktThread();
        this.m_DeviceObjects = new SktList();
        this.m_DeviceObjectsLock = new SktPlatform.SktLock();
        this.m_Configuration = new SktScanAPIConfiguration();
        this.m_ConfigurationFlipFlopEvent = new SktPlatform.SktFlipFlop();
    }

    public ISktScanApi getHandle() {
        return this._handle;
    }

    public void IncrementReferenceCount() {
        this.m_nReferenceCount++;
    }

    public void DecrementReferenceCount() {
        if (this.m_nReferenceCount > 0) {
            this.m_nReferenceCount--;
        }
    }

    public final int GetReferenceCount() {
        return this.m_nReferenceCount;
    }

    public long Initialize(boolean bWithOpeningTransport) {
        long Result = 0;
        SktDebug.DBGSKT_DISABLE(1536);
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Initialize(), "m_DeviceObjectsLock.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueueLock.Initialize(), "m_MessageQueueLock.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueue.Initialize(), "m_MessageQueue.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_ConfigurationFlipFlopEvent.Create(this.kConfigurationChangeEvent), "m_ConfigurationFlipFlopEvent.Create(kConfigurationChangeEvent)");
        }
        this.m_FlipFlopEventState = new SktPlatform.SktFlipFlop.State();
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_ConfigurationFlipFlopEvent.Wait(this.m_FlipFlopEventState, 1), "m_ConfigurationFlipFlopEvent.Wait(m_FlipFlopEventState,1)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().Initialize(), "GetScanApiConfiguration().Initialize()");
        }
        long[] pulValue = new long[1];
        if (SktScanErrors.SKTSUCCESS(GetScanApiConfiguration().ReadMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel, pulValue))) {
            SktDebug.DBGSKT_MSG(8, "New Debug Level:" + pulValue[0]);
            SktDebug.DBGSKT_SETLEVEL((int) pulValue[0]);
        }
        if (SktScanErrors.SKTSUCCESS(GetScanApiConfiguration().ReadMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel, pulValue))) {
            SktDebug.DBGSKT_SETFILELINELEVEL((int) pulValue[0]);
        }
        if (SktScanErrors.SKTSUCCESS(GetScanApiConfiguration().ReadMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel, pulValue))) {
            SktDebug.DBGSKT_MSG(8, "New Debug Channel:0x" + Long.toString(pulValue[0], 16));
            SktDebug.DBGSKT_SETCHANNEL((int) pulValue[0]);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddDeviceConfiguration(), "AddDeviceConfiguration()");
        }
        SktListener listener = new SktListener(this);
        this.m_bWithOpeningTransport = bWithOpeningTransport;
        if (bWithOpeningTransport && SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_ListenerThread.CreateThread(listener), "m_ListenerThread.CreateThread(listener)");
        }
        String[] pszSoftScanStatusOrFriendlyName = new String[1];
        if (SktScanErrors.SKTSUCCESS(GetScanApiConfiguration().ReadSoftscanStatus(pszSoftScanStatusOrFriendlyName, 1024)) && pszSoftScanStatusOrFriendlyName[0].equalsIgnoreCase("enabled")) {
            if (SktSoftScanDeviceObject.IsSupported()) {
                SktSoftScanDeviceObject pSoftscanDeviceObject = new SktSoftScanDeviceObject(this);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadSoftscanFriendlyName(pszSoftScanStatusOrFriendlyName, 1024), "GetScanApiConfiguration().ReadSoftscanFriendlyName(pszSoftScanStatusOrFriendlyName,nStringValueLength)");
                    if (Result == -17) {
                        pszSoftScanStatusOrFriendlyName[0] = "SoftScanner";
                    }
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pSoftscanDeviceObject.Initialize(pszSoftScanStatusOrFriendlyName[0], (long) SktScanDeviceType.kSktScanDeviceTypeSoftScan), "pSoftscanDeviceObject.Initialize(pszSoftScanStatusOrFriendlyName[0],SktScanDeviceType.kSktScanDeviceTypeSoftScan)");
                }
                SktScanTypes.TSktScanString DeviceGuid = new SktScanTypes.TSktScanString();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pSoftscanDeviceObject.GetGuid(DeviceGuid), "pSoftscanDeviceObject.GetGuid(DeviceGuid)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    SktDebug.DBGSKT_MSG(17, "Softscan GUID is " + DeviceGuid.m_Value);
                    if (DeviceGuid.nLength > 1) {
                        Result = SktDebug.DBGSKT_EVAL(NotifyNewDeviceArrival(pSoftscanDeviceObject), "NotifyNewDeviceArrival(pSoftscanDeviceObject)");
                    }
                }
            } else {
                SktDebug.DBGSKT_MSG(18, "SoftScan requirements have not been met.");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_DataEditingProfile = new SktDataEditingProfile();
            Result = SktDebug.DBGSKT_EVAL(LoadDataEditingCurrentProfile(), "LoadDataEditingCurrentProfile()");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(NotifyError(-82, (SktDeviceInterface) null, "Unable initialize current profile"), "NotifyError(Result,null,\"Unable initialize current profile\")");
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            Deinitialize();
        }
        return Result;
    }

    public long Deinitialize() {
        this.m_bShouldListenerThreadStop = true;
        this.m_bStopAndRestartListenerThreadProcess = false;
        long Result = SktDebug.DBGSKT_EVAL(this.m_ListenerThread.WaitForThreadTermination(10000), "m_ListenerThread.WaitForThreadTermination(kThreadTerminationTimeout)");
        if (SktScanErrors.SKTSUCCESS(Result) && Result == 1) {
            SktDebug.DBGSKT_MSG(18, "Thread didn't terminate on time");
        }
        this.m_ListenerThread.DeleteThread();
        this.m_MessageQueue.Deinitialize();
        SktDeviceObjectInterface[] pDeviceObject = new SktDeviceObjectInterface[1];
        while (SktScanErrors.SKTSUCCESS(this.m_DeviceObjects.RemoveHead(pDeviceObject))) {
            pDeviceObject[0] = null;
        }
        this.m_DeviceObjectsLock.Deinitialize();
        TSktScanObject[] pScanObj = new TSktScanObject[1];
        while (SktScanErrors.SKTSUCCESS(this.m_MessageQueue.RemoveHead(pScanObj))) {
            ReleaseScanObject(pScanObj[0]);
        }
        this.m_MessageQueueLock.Deinitialize();
        return Result;
    }

    public long AddIntoQueue(TSktScanObject pScanObj) {
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueueLock.Lock(), "m_MessageQueueLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (this.m_MessageQueue.GetCount() > 20) {
                SktDebug.DBGSKT_MSG(18, "Queue Full, about to empty " + this.m_MessageQueue.GetCount() + " items");
                TSktScanObject[] pScanObject = new TSktScanObject[1];
                while (SktScanErrors.SKTSUCCESS(this.m_MessageQueue.RemoveHead(pScanObject))) {
                    ReleaseScanObject(pScanObject[0]);
                }
                pScanObject[0] = new TSktScanObject();
                if (pScanObject[0] == null) {
                    Result = -2;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pScanObject[0].Msg.MsgID = 6;
                    pScanObject[0].Msg.Result = -45;
                    pScanObject[0].Msg.Event.f12ID = 0;
                    Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueue.AddTail(pScanObject[0]), "m_MessageQueue.AddTail(pScanObject[0])");
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        ReleaseScanObject(pScanObject[0]);
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_MSG(17, "Add " + this.DBG_MSGID_NAME[pScanObj.Msg.MsgID] + " Into Queue");
                if (pScanObj.Msg.MsgID == 5 || pScanObj.Msg.MsgID == 4) {
                    if (SktScan.helper.SKTRETRIEVEGROUPID(pScanObj.Property.f13ID) == 0) {
                        if (SktScan.helper.SKTISSCANAPI(pScanObj.Property.f13ID) != 0) {
                            int index = SktScan.helper.SKTRETRIEVEID(pScanObj.Property.f13ID);
                            if (index < this.DBG_GENERALPROPID_NAME.length) {
                                SktDebug.DBGSKT_MSG(17, "General Property: " + this.DBG_GENERALPROPID_NAME[index]);
                            } else {
                                SktDebug.DBGSKT_MSG(17, "General Property: 0x" + Integer.toHexString(pScanObj.Property.f13ID) + " is not in table");
                            }
                        } else {
                            int index2 = SktScan.helper.SKTRETRIEVEID(pScanObj.Property.f13ID);
                            if (index2 < DBG_GENERALPROPIDDEVICE_NAME.length) {
                                SktDebug.DBGSKT_MSG(17, "General Device Property: " + DBG_GENERALPROPIDDEVICE_NAME[index2]);
                            } else {
                                SktDebug.DBGSKT_MSG(17, "General Device Property: 0x" + Integer.toHexString(pScanObj.Property.f13ID) + " is not in table");
                            }
                        }
                    } else if (SktScan.helper.SKTRETRIEVEGROUPID(pScanObj.Property.f13ID) == 1) {
                        int index3 = SktScan.helper.SKTRETRIEVEID(pScanObj.Property.f13ID);
                        if (index3 < DBG_LOCALFUNCTIONSPROPID_NAME.length) {
                            SktDebug.DBGSKT_MSG(17, "Local Functions Property: " + DBG_LOCALFUNCTIONSPROPID_NAME[index3]);
                        } else {
                            SktDebug.DBGSKT_MSG(17, "Local Functions Property: 0x" + Integer.toHexString(pScanObj.Property.f13ID) + " is not in table");
                        }
                    } else {
                        SktDebug.DBGSKT_MSG(17, "Unknown Property: 0x" + Integer.toHexString(pScanObj.Property.f13ID));
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueue.AddTail(pScanObj), "m_MessageQueue.AddTail(pScanObj)");
            }
            this.m_MessageQueueLock.Unlock();
        }
        return Result;
    }

    public long RemoveFromQueue(TSktScanObject[] ppScanObj) {
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueueLock.Lock(), "m_MessageQueueLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_MessageQueue.RemoveHead(ppScanObj), "m_MessageQueue.RemoveHead(ppScanObj)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_MSG(17, "Remove " + this.DBG_MSGID_NAME[ppScanObj[0].Msg.MsgID] + " from Queue");
                if (ppScanObj[0].Msg.MsgID == 5 || ppScanObj[0].Msg.MsgID == 4) {
                    if (SktScan.helper.SKTRETRIEVEGROUPID(ppScanObj[0].Property.f13ID) == 0) {
                        if (SktScan.helper.SKTISSCANAPI(ppScanObj[0].Property.f13ID) != 0) {
                            int index = SktScan.helper.SKTRETRIEVEID(ppScanObj[0].Property.f13ID);
                            if (index < this.DBG_GENERALPROPID_NAME.length) {
                                SktDebug.DBGSKT_MSG(17, "General Property: " + this.DBG_GENERALPROPID_NAME[index]);
                            } else {
                                SktDebug.DBGSKT_MSG(17, "General Property: 0x" + Integer.toHexString(ppScanObj[0].Property.f13ID) + " is not in table");
                            }
                        } else {
                            int index2 = SktScan.helper.SKTRETRIEVEID(ppScanObj[0].Property.f13ID);
                            if (index2 < DBG_GENERALPROPIDDEVICE_NAME.length) {
                                SktDebug.DBGSKT_MSG(17, "General Device Property: " + DBG_GENERALPROPIDDEVICE_NAME[index2]);
                            } else {
                                SktDebug.DBGSKT_MSG(17, "General Device Property: 0x" + Integer.toHexString(ppScanObj[0].Property.f13ID) + " is not in table");
                            }
                        }
                    } else if (SktScan.helper.SKTRETRIEVEGROUPID(ppScanObj[0].Property.f13ID) == 1) {
                        int index3 = SktScan.helper.SKTRETRIEVEID(ppScanObj[0].Property.f13ID);
                        if (index3 < DBG_LOCALFUNCTIONSPROPID_NAME.length) {
                            SktDebug.DBGSKT_MSG(17, "Local Functions Property: " + DBG_LOCALFUNCTIONSPROPID_NAME[index3]);
                        } else {
                            SktDebug.DBGSKT_MSG(17, "Local Functions Property: 0x" + Integer.toHexString(ppScanObj[0].Property.f13ID) + " is not in table");
                        }
                    } else {
                        SktDebug.DBGSKT_MSG(17, "Unknown Property: 0x" + Integer.toHexString(ppScanObj[0].Property.f13ID));
                    }
                }
            }
            this.m_MessageQueueLock.Unlock();
        }
        return Result;
    }

    public long WaitForQueueNotEmpty(long ulTimeoutMilliseconds) {
        if (SktScanErrors.SKTSUCCESS(0)) {
            return SktDebug.DBGSKT_EVAL(this.m_MessageQueue.WaitForNotEmpty(ulTimeoutMilliseconds), "m_MessageQueue.WaitForNotEmpty(ulTimeoutMilliseconds)");
        }
        return 0;
    }

    public long Open(String name, ISktScanDevice deviceHandle) {
        long Result;
        long Result2 = 0;
        boolean found = false;
        SktDeviceObjectInterface[] deviceObject = null;
        if (deviceHandle == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            deviceObject = new SktDeviceObjectInterface[1];
            SktDebug.DBGSKT_MSG(17, "Open with a device name: " + name + ".");
            Result2 = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromDeviceName(name, deviceObject), "RetrieveAndLockDeviceObjectFromDeviceName(name,pDeviceObject)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (deviceObject[0].GetStatus() == 0) {
                Result = SktDebug.DBGSKT_EVAL(deviceObject[0].Open(), "pDeviceObject[0].Open()");
                deviceObject[0].setHandle(deviceHandle);
                found = true;
                TSktScanObject decodedData = deviceObject[0].getFirstDecodedData();
                if (decodedData != null) {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(FillMessageDeviceFromDeviceObject(decodedData.Msg.Device, deviceObject[0]), "FillMessageDeviceFromDeviceObject(decodedData.Msg.Device,deviceObject[0])");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(FillSymbologyName(decodedData.Msg.Event.Data.DecodedData.SymbologyID, decodedData.Msg.Event.Data.DecodedData.SymbologyName), "FillSymbologyName(decodedData.Msg.Event.Data.DecodedData.SymbologyID,decodedData.Msg.Event.Data.DecodedData.SymbologyName)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(decodedData), "AddIntoQueue(decodedData)");
                    }
                    deviceObject[0].storeFirstDecodedData((TSktScanObject) null);
                }
            } else {
                Result = -32;
            }
            deviceObject[0].Unlock();
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || found) {
            return Result;
        }
        return -17;
    }

    public long Close(ISktScanDevice device) {
        SktDeviceObjectInterface[] pDeviceObject = new SktDeviceObjectInterface[1];
        long Result = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromHandle(device, pDeviceObject), "RetrieveAndLockDeviceObjectFromHandle(device,pDeviceObject)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pDeviceObject[0].GetReferenceCount() == 0) {
                Result = 2;
            } else {
                Result = SktDebug.DBGSKT_EVAL(pDeviceObject[0].Close(), "pDeviceObject[0].Close()");
            }
            if (pDeviceObject[0].GetReferenceCount() <= 0) {
                pDeviceObject[0].SetReferenceCount(0);
                if (pDeviceObject[0].GetStatus() == 1) {
                    pDeviceObject[0].SetStatus(2);
                }
            }
            pDeviceObject[0].Unlock();
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || !this.m_bShouldListenerThreadStop || this.m_bStopAndRestartListenerThreadProcess || !AreAllDeviceObjectDeleted()) {
            return Result;
        }
        return SktDebug.DBGSKT_EVAL(SendTerminateToApp(), "SendTerminateToApp()");
    }

    public long SetProperty(ISktScanDevice device, TSktScanObject scanObj) {
        SktDeviceObjectInterface[] deviceObject = new SktDeviceObjectInterface[1];
        TSktScanObject[] response = new TSktScanObject[1];
        long Result = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromHandle(device, deviceObject), "RetrieveAndLockDeviceObjectFromHandle(device,pDeviceObject)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (deviceObject[0].GetStatus() != 0) {
                Result = -32;
            } else if (scanObj.Property.f13ID != 1048582) {
                SktScanTypes.TSktScanBoolean ImmediateResponse = new SktScanTypes.TSktScanBoolean(false);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(deviceObject[0].SetProperty(scanObj, 1, ImmediateResponse, response), "pDeviceObject[0].SetProperty(pScanObj,SktDeviceInterface.ESktDestination.kSktDestinationApp,ImmediateResponse,pResponse)");
                }
                boolean bImmediateResponse = ImmediateResponse.getValue();
                if (SktScanErrors.SKTSUCCESS(Result) && bImmediateResponse) {
                    response[0].Msg.Device.hDevice = scanObj.Msg.Device.hDevice;
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(response[0]), "AddIntoQueue(pResponse[0])");
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        SktUtilities.ReleaseScanObject(response[0]);
                    }
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(HandleApplyConfigDevice(deviceObject[0], scanObj), "HandleApplyConfigDevice(pDeviceObject[0],pScanObj)");
            }
            deviceObject[0].Unlock();
        }
        return Result;
    }

    public long GetProperty(ISktScanDevice device, TSktScanObject pScanObj) {
        SktDeviceObjectInterface[] pDeviceObject = new SktDeviceObjectInterface[1];
        TSktScanObject[] pResponse = new TSktScanObject[1];
        long Result = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromHandle(device, pDeviceObject), "RetrieveAndLockDeviceObjectFromHandle(device,pDeviceObject)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pDeviceObject[0].GetStatus() == 0) {
                SktScanTypes.TSktScanBoolean ImmediateResponse = new SktScanTypes.TSktScanBoolean(false);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pDeviceObject[0].GetProperty(pScanObj, 1, ImmediateResponse, pResponse), "pDeviceObject[0].GetProperty(pScanObj,SktDeviceInterface.ESktDestination.kSktDestinationApp,ImmediateResponse,pResponse)");
                }
                boolean bImmediateResponse = ImmediateResponse.getValue();
                if (SktScanErrors.SKTSUCCESS(Result) && bImmediateResponse) {
                    if (pResponse[0].Property.f13ID == 7798788) {
                        if (pResponse[0].Property.Symbology.Name == null) {
                            pResponse[0].Property.Symbology.Name = new SktScanTypes.TSktScanString();
                        }
                        long Result2 = SktDebug.DBGSKT_EVAL(FillSymbologyName(pResponse[0].Property.Symbology.f14ID, pResponse[0].Property.Symbology.Name), "FillSymbologyName(pResponse[0].Property.Symbology.ID,pResponse[0].Property.Symbology.Name)");
                    }
                    pResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
                    Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pResponse[0]), "AddIntoQueue(pResponse[0])");
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        SktUtilities.ReleaseScanObject(pResponse[0]);
                    }
                }
            } else {
                Result = -32;
            }
            pDeviceObject[0].Unlock();
        }
        return Result;
    }

    public long SetLocalProperty(TSktScanObject pScanObj) {
        if (pScanObj.Property.f13ID == -2146435072) {
            return SktDebug.DBGSKT_EVAL(HandleAbort(pScanObj.Property.Context), "HandleAbort(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913085) {
            return SktDebug.DBGSKT_EVAL(HandleSetConfiguration(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetConfiguration(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147352572) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataConfirmationMode(pScanObj.Property.Byte, pScanObj.Property.Context), "HandleSetDataConfirmationMode(pScanObj.Property.Byte,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147287035) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataConfirmationAction(pScanObj.Property.Ulong, pScanObj.Property.Context), "HandleSetDataConfirmationAction(pScanObj.Property.Ulong,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2145124346) {
            return SktDebug.DBGSKT_EVAL(HandleSetMonitorMode(pScanObj.Property.Array.pData, pScanObj.Property.Array.Size, pScanObj.Property.Context), "HandleSetMonitorMode(pScanObj.Property.Array.pData,pScanObj.Property.Array.Size,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2145255417) {
            return SktDebug.DBGSKT_EVAL(HandleSetSoftScanStatus(pScanObj.Property.Byte, pScanObj.Property.Context), "HandleSetSoftScanStatus(pScanObj.Property.Byte,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147155959) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingProfile(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingProfile(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147155958) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingCurrentProfile(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingCurrentProfile(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913077) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingSymbologies(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingSymbologies(pScanObj.Property.Byte,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913076) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingMinLength(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingMinLength(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913075) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingMaxLength(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingMaxLength(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913074) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingStartsBy(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingStartsBy(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913073) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingEndsWith(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingEndsWith(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913072) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingContains(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingContains(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913071) {
            return SktDebug.DBGSKT_EVAL(HandleSetDataEditingOperation(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleSetDataEditingOperation(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913070) {
            return SktDebug.DBGSKT_EVAL(HandleImportDataEditing(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleImportDataEditing(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        return -32;
    }

    public long GetLocalProperty(TSktScanObject pScanObj) {
        if (!SktScanErrors.SKTSUCCESS(0)) {
            return 0;
        }
        if (pScanObj.Property.f13ID == -2147418110) {
            return 0;
        }
        if (pScanObj.Property.f13ID == -2147418111) {
            return SktDebug.DBGSKT_EVAL(HandleVersion(false, pScanObj.Property.Context), "HandleVersion(bInterfaceVersion,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913085) {
            return SktDebug.DBGSKT_EVAL(HandleGetConfiguration(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetConfiguration(pScanObj.Property.String.m_Value,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147352572) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataConfirmationMode(pScanObj.Property.Context), "HandleGetDataConfirmationMode(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147287035) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataConfirmationAction(pScanObj.Property.Context), "HandleGetDataConfirmationAction(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2145124346) {
            return SktDebug.DBGSKT_EVAL(HandleGetMonitorMode(pScanObj.Property.Byte, pScanObj.Property.Context), "HandleGetMonitorMode((char)pScanObj.Property.Byte,pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2145255417) {
            return SktDebug.DBGSKT_EVAL(HandleGetSoftScanStatus(pScanObj.Property.Context), "HandleGetSoftScanStatus(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147155959) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingProfile(pScanObj.Property.Context), "HandleGetDataEditingProfile(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2147155958) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingCurrentProfile(pScanObj.Property.Context), "HandleGetDataEditingCurrentProfile(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913077) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingSymbologies(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingSymbologies(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913076) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingMinLength(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingMinLength(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913075) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingMaxLength(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingMaxLength(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913074) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingStartsBy(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingStartsBy(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913073) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingEndsWith(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingEndsWith(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913072) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingContains(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingContains(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913071) {
            return SktDebug.DBGSKT_EVAL(HandleGetDataEditingOperation(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleGetDataEditingOperation(pScanObj.Property.Context)");
        }
        if (pScanObj.Property.f13ID == -2141913070) {
            return SktDebug.DBGSKT_EVAL(HandleExportDataEditing(pScanObj.Property.String.m_Value, pScanObj.Property.Context), "HandleExportDataEditing(pScanObj.Property.Context)");
        }
        return -32;
    }

    public long ReleaseScanObject(TSktScanObject pScanObj) {
        return SktDebug.DBGSKT_EVAL(SktUtilities.ReleaseScanObject(pScanObj), "SktUtilities.ReleaseScanObject(pScanObj)");
    }

    public long ReadConfiguration(String name, TSktScanObject[] ppScanObj) {
        long Result = 0;
        String[] pszStringValue = new String[1];
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            pszStringValue = new String[1];
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdConfiguration;
            if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigSerialComPort)) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadSerialPorts(pszStringValue, 1024), "GetScanApiConfiguration().ReadSerialPorts(pszStringValue,nStringValueLength)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdConfiguration;
                    ppScanObj[0].Property.Type = 5;
                    ppScanObj[0].Property.String.nLength = pszStringValue[0].length();
                    ppScanObj[0].Property.String.m_Value = pszStringValue[0];
                    ppScanObj[0].Msg.Result = Result;
                } else {
                    ppScanObj[0].Msg.Result = -24;
                }
            } else if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigPath)) {
                String[] applicationDataPath = new String[1];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktSystem.ReadApplicationDataPath(applicationDataPath, 0), "SktSystem.ReadApplicationDataPath(applicationDataPath, nLength)");
                    applicationDataPath[0] = applicationDataPath[0] + SktConfigurationBase.kSktApplicationDataPath;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdConfiguration;
                    ppScanObj[0].Property.Type = 5;
                    ppScanObj[0].Property.String.nLength = applicationDataPath[0].length();
                    ppScanObj[0].Property.String.m_Value = applicationDataPath[0];
                    ppScanObj[0].Msg.Result = Result;
                } else {
                    ppScanObj[0].Msg.Result = -24;
                }
            } else if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel) || name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel) || name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel)) {
                long[] pulValue = new long[1];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadMonitorDbg(name, pulValue), "GetScanApiConfiguration().ReadMonitorDbg(name, pulValue)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    String value = "0x" + Integer.toHexString((int) pulValue[0]);
                    ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdConfiguration;
                    ppScanObj[0].Property.Type = 5;
                    ppScanObj[0].Property.String.nLength = value.length();
                    ppScanObj[0].Property.String.m_Value = value;
                    ppScanObj[0].Msg.Result = Result;
                } else {
                    ppScanObj[0].Msg.Result = -24;
                }
            } else if (name.equalsIgnoreCase(SktConfigurationBase.kSktIgnoreUnableInitializeConfig)) {
                long[] pulValue2 = new long[1];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadIgnoreUnableInitialize(pulValue2), "GetScanApiConfiguration().ReadIgnoreUnableInitialize(pulValue)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    String value2 = "0x" + Integer.toHexString((int) pulValue2[0]);
                    ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdConfiguration;
                    ppScanObj[0].Property.Type = 5;
                    ppScanObj[0].Property.String.nLength = value2.length();
                    ppScanObj[0].Property.String.m_Value = value2;
                    ppScanObj[0].Msg.Result = Result;
                } else {
                    ppScanObj[0].Msg.Result = -24;
                }
            } else {
                ppScanObj[0].Msg.Result = -23;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            ReleaseScanObject(ppScanObj[0]);
        }
        return Result;
    }

    public long WriteConfiguration(String nameAndValue) {
        long Result = 0;
        String value = null;
        String name = null;
        int nLength = nameAndValue.length();
        int i = nameAndValue.indexOf("=");
        if (i != -1) {
            name = nameAndValue.substring(0, i);
            value = nameAndValue.substring(i + 1, nLength);
        }
        if (value == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigSerialComPort)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteSerialPorts(value), "GetScanApiConfiguration().WriteSerialPorts(pszValue)");
            }
            return (!this.m_bWithOpeningTransport || !SktScanErrors.SKTSUCCESS(Result)) ? Result : SktDebug.DBGSKT_EVAL(StopAndRestartListenerThread(), "StopAndRestartListenerThread()");
        } else if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel)) {
            long ulValue = 0;
            try {
                ulValue = SktUtilities.ConvertAsciiHexaToUnsignedLong(value);
            } catch (Exception e) {
            }
            return SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel, ulValue), "GetScanApiConfiguration().WriteMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel,ulValue)");
        } else if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel)) {
            long ulValue2 = 0;
            try {
                ulValue2 = SktUtilities.ConvertAsciiHexaToUnsignedLong(value);
            } catch (Exception e2) {
            }
            return SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel, ulValue2), "GetScanApiConfiguration().WriteMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel,ulValue)");
        } else if (name.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel)) {
            long ulValue3 = 0;
            try {
                ulValue3 = SktUtilities.ConvertAsciiHexaToUnsignedLong(value);
            } catch (Exception e3) {
            }
            return SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel, ulValue3), "GetScanApiConfiguration().WriteMonitorDbg(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel,ulValue)");
        } else if (!name.equalsIgnoreCase(SktConfigurationBase.kSktIgnoreUnableInitializeConfig)) {
            return -23;
        } else {
            long ulValue4 = 0;
            try {
                ulValue4 = SktUtilities.ConvertAsciiHexaToUnsignedLong(value);
            } catch (Exception e4) {
            }
            return SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteIgnoreUnableInitialize(ulValue4), "GetScanApiConfiguration().WriteIgnoreUnableInitialize(ulValue)");
        }
    }

    public boolean HasConfigurationChanged(SktPlatform.SktFlipFlop.State pState) {
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_ConfigurationFlipFlopEvent.Wait(pState, 1), "m_ConfigurationFlipFlopEvent.Wait(pState,0)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || Result == 1) {
            return false;
        }
        return true;
    }

    public long NotifyDeviceArrival(SktDeviceInterface pDeviceInterface) {
        long Result = 0;
        if (pDeviceInterface == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(pDeviceInterface.StartInitializing(true), "pDeviceInterface.StartInitializing(true)");
        }
        return Result;
    }

    public long NotifyDeviceRemoval(SktDeviceInterface deviceInterface) {
        long Result = 0;
        TSktScanObject pScanObj = null;
        SktDeviceObjectInterface[] deviceObject = new SktDeviceObjectInterface[1];
        ISktScanDevice hDevice = null;
        SktScanTypes.TSktScanString DeviceObjectGuid = new SktScanTypes.TSktScanString();
        if (deviceInterface == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromDeviceInterface(deviceInterface, deviceObject), "RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface,pDeviceObject)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            deviceObject[0].SetDeviceInterface((SktDeviceInterface) null);
            if (deviceObject[0].GetReferenceCount() <= 0) {
                deviceObject[0].SetStatus(2);
            } else {
                deviceObject[0].SetStatus(1);
                hDevice = deviceObject[0].getHandle();
                Result = SktDebug.DBGSKT_EVAL(deviceObject[0].GetGuid(DeviceObjectGuid), "pDeviceObject[0].GetGuid(DeviceObjectGuid)");
            }
            deviceObject[0].Unlock();
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj = new TSktScanObject();
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj.Msg.MsgID = 2;
            pScanObj.Msg.Device.hDevice = hDevice;
            if (deviceInterface.GetDeviceName() == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (deviceInterface.GetDeviceName().length() >= 64) {
                }
                pScanObj.Msg.Device.szDeviceName = deviceInterface.GetDeviceName();
                pScanObj.Msg.Device.Guid = DeviceObjectGuid.getValue();
                Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                SktUtilities.ReleaseScanObject(pScanObj);
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || !this.m_bShouldListenerThreadStop || this.m_bStopAndRestartListenerThreadProcess || !AreAllDeviceObjectDeleted()) {
            return Result;
        }
        return SktDebug.DBGSKT_EVAL(SendTerminateToApp(), "SendTerminateToApp()");
    }

    public long NotifyDeviceRemoval(long ulDeviceType, boolean bNotFoundError) {
        long Result = 0;
        boolean bFound = false;
        SktDeviceObjectInterface[] deviceObject = new SktDeviceObjectInterface[1];
        ISktScanDevice hDevice = null;
        SktScanTypes.TSktScanString DeviceObjectGuid = new SktScanTypes.TSktScanString();
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Lock(), "m_DeviceObjectsLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktDeviceObjectInterface[] pCurrentDeviceObject = new SktDeviceObjectInterface[1];
            SktList.Position position = this.m_DeviceObjects.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                pCurrentDeviceObject[0] = (SktDeviceObjectInterface) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pCurrentDeviceObject[0].Lock(), "pCurrentDeviceObject[0].Lock()");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (pCurrentDeviceObject[0].GetDeviceInterface() == null && pCurrentDeviceObject[0].GetDeviceType() == ulDeviceType) {
                        deviceObject[0] = pCurrentDeviceObject[0];
                        bFound = true;
                        break;
                    }
                    pCurrentDeviceObject[0].Unlock();
                    if (0 == 1) {
                        pCurrentDeviceObject[0] = null;
                    }
                    pCurrentDeviceObject[0] = null;
                } else {
                    break;
                }
            }
            this.m_DeviceObjectsLock.Unlock();
        }
        if (bFound) {
            deviceObject[0].SetDeviceInterface((SktDeviceInterface) null);
            if (deviceObject[0].GetReferenceCount() <= 0) {
                deviceObject[0].SetStatus(2);
            } else {
                deviceObject[0].SetStatus(1);
                hDevice = deviceObject[0].getHandle();
                Result = SktDebug.DBGSKT_EVAL(deviceObject[0].GetGuid(DeviceObjectGuid), "pDeviceObject[0].GetGuid(DeviceObjectGuid)");
            }
            deviceObject[0].Unlock();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                TSktScanObject pScanObj = new TSktScanObject();
                pScanObj.Msg.MsgID = 2;
                pScanObj.Msg.Device.hDevice = hDevice;
                if (deviceObject[0].GetFriendlyName() == null) {
                    Result = -18;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (deviceObject[0].GetFriendlyName().length() >= 64) {
                    }
                    pScanObj.Msg.Device.szDeviceName = deviceObject[0].GetFriendlyName();
                    pScanObj.Msg.Device.Guid = DeviceObjectGuid.getValue();
                    Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    SktUtilities.ReleaseScanObject(pScanObj);
                }
            }
        } else if (bNotFoundError) {
            Result = -17;
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || !this.m_bShouldListenerThreadStop || this.m_bStopAndRestartListenerThreadProcess || !AreAllDeviceObjectDeleted()) {
            return Result;
        }
        return SktDebug.DBGSKT_EVAL(SendTerminateToApp(), "SendTerminateToApp()");
    }

    public long NotifyDataFromDeviceInterface(SktDeviceInterface pDeviceInterface) {
        long Result;
        long Result2;
        long Result3 = 0;
        SktDeviceObjectInterface[] pDeviceObject = new SktDeviceObjectInterface[1];
        if (pDeviceInterface == null) {
            Result3 = -18;
        }
        SktScanTypes.TSktScanInteger tSktScanInteger = new SktScanTypes.TSktScanInteger(4);
        if (SktScanErrors.SKTSUCCESS(Result3)) {
            Result3 = SktDebug.DBGSKT_EVAL(pDeviceInterface.CheckIfInitialized(tSktScanInteger), "pDeviceInterface.CheckIfInitialized(pDeviceInterfaceInitStatus)");
        }
        int DeviceInterfaceInitStatus = tSktScanInteger.getValue();
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (DeviceInterfaceInitStatus != 4) {
            if (DeviceInterfaceInitStatus == 5) {
                Result = SktDebug.DBGSKT_EVAL(NotifyError(-48, (SktDeviceInterface) null, (String) null), "NotifyError(SktScanErrors.ESKT_OUTDATEDVERSION,null,null)");
            } else if (DeviceInterfaceInitStatus == 3) {
                Result = SktDebug.DBGSKT_EVAL(NotifyError(-21, (SktDeviceInterface) null, (String) null), "NotifyError(SktScanErrors.ESKT_UNABLEINITIALIZE)");
                long[] pulValue = new long[1];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadIgnoreUnableInitialize(pulValue), "GetScanApiConfiguration().ReadIgnoreUnableInitialize(pulValue)");
                }
                if (SktScanErrors.SKTSUCCESS(Result) && pulValue[0] != 0) {
                    DeviceInterfaceInitStatus = 2;
                    pDeviceInterface.ForceInitializationStatus(4);
                }
            } else if (DeviceInterfaceInitStatus == 1) {
                int[] nConfigCount = {0};
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddInitializationFromConfiguration(pDeviceInterface, nConfigCount), "AddInitializationFromConfiguration(pDeviceInterface,nConfigCount)");
                }
                if (nConfigCount[0] == 0) {
                    DeviceInterfaceInitStatus = 2;
                }
            }
            if (DeviceInterfaceInitStatus == 2) {
                if (!pDeviceInterface.IsArrivalAlreadyNotified()) {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(NotifyApplicationNewDeviceArrival(pDeviceInterface), "NotifyApplicationNewDeviceArrival(pDeviceInterface)");
                    }
                    int[] pwMajor = new int[1];
                    int[] pwMiddle = new int[1];
                    int[] pwMinor = new int[1];
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.GetScanApiVersionRequested(pwMajor, pwMiddle, pwMinor), "pDeviceInterface.GetScanApiVersionRequested(pwMajor, pwMiddle, pwMinor)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(CheckScanApiVersion(pwMajor[0], pwMiddle[0], pwMinor[0], pDeviceInterface), "CheckScanApiVersion(pwMajor, pwMiddle, pwMinor,pDeviceInterface)");
                    }
                }
                if (!pDeviceInterface.IsThereInitializationCompleteProperty()) {
                    return Result;
                }
                SktScanTypes.TSktScanBoolean bGetComplete = new SktScanTypes.TSktScanBoolean(false);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface, pDeviceObject), "RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface,pDeviceObject)");
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    return Result;
                }
                if (pDeviceObject[0].GetReferenceCount() > 0) {
                    TSktScanObject pNewScanObject = new TSktScanObject();
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.RemoveInitializationCompleteProperty(pNewScanObject.Property, bGetComplete), "pDeviceInterface.RemoveInitializationCompleteProperty(pNewScanObject.Property,bGetComplete)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(FillMessageDeviceFromDeviceObject(pNewScanObject.Msg.Device, pDeviceObject[0]), "FillMessageDeviceFromDeviceObject(pNewScanObject.Msg.Device,pDeviceObject[0])");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        pNewScanObject.Msg.MsgID = 4;
                        if (bGetComplete.getValue()) {
                            pNewScanObject.Msg.MsgID = 5;
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pNewScanObject), "AddIntoQueue(pNewScanObject)");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            pNewScanObject = null;
                        }
                    }
                    ReleaseScanObject(pNewScanObject);
                }
                pDeviceObject[0].Unlock();
                return Result;
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                return SktDebug.DBGSKT_EVAL(pDeviceInterface.ContinueInitializing(), "pDeviceInterface.ContinueInitializing()");
            } else {
                return Result;
            }
        } else {
            SktScanTypes.TSktScanInteger tSktScanInteger2 = new SktScanTypes.TSktScanInteger(DeviceInterfaceInitStatus);
            TSktScanObject[] pScanObject = new TSktScanObject[1];
            long Result4 = SktDebug.DBGSKT_EVAL(pDeviceInterface.RetrieveScanObject(pScanObject, tSktScanInteger2), "pDeviceInterface.RetrieveScanObject(pScanObject,pDestination)");
            TSktScanObject pNewScanObject2 = pScanObject[0];
            int Destination = tSktScanInteger2.getValue();
            if (SktScanErrors.SKTSUCCESS(Result4)) {
                Result4 = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface, pDeviceObject), "RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface,pDeviceObject)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result2)) {
                return Result2;
            }
            if (pDeviceObject[0].GetReferenceCount() > 0) {
                Result2 = SktDebug.DBGSKT_EVAL(FillMessageDeviceFromDeviceObject(pNewScanObject2.Msg.Device, pDeviceObject[0]), "FillMessageDeviceFromDeviceObject(pNewScanObject.Msg.Device,pDeviceObject[0])");
                int EventID = pNewScanObject2.Msg.Event.f12ID;
                if (Destination != 1 || pNewScanObject2.Msg.MsgID == 0) {
                    ReleaseScanObject(pNewScanObject2);
                } else {
                    if (pNewScanObject2.Msg.MsgID == 5 && pNewScanObject2.Property.f13ID == 7798788) {
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            if (pNewScanObject2.Property.Symbology.Name == null) {
                                pNewScanObject2.Property.Symbology.Name = new SktScanTypes.TSktScanString();
                            }
                            Result2 = SktDebug.DBGSKT_EVAL(FillSymbologyName(pNewScanObject2.Property.Symbology.f14ID, pNewScanObject2.Property.Symbology.Name), "FillSymbologyName(pNewScanObject.Property.Symbology.ID,pNewScanObject.Property.Symbology.Name)");
                        }
                    } else if (EventID == 1) {
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(FillSymbologyName(pNewScanObject2.Msg.Event.Data.DecodedData.SymbologyID, pNewScanObject2.Msg.Event.Data.DecodedData.SymbologyName), "FillSymbologyName(pNewScanObject.Msg.Event.Data.DecodedData.SymbologyID,pNewScanObject.Msg.Event.Data.DecodedData.SymbologyName)");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.edit(pNewScanObject2.Msg.Event.Data.DecodedData), "m_DataEditingProfile.edit(pNewScanObject.Msg.Event.Data.DecodedData)");
                        }
                    }
                    if (SktScanErrors.SKTSUCCESS(Result2)) {
                        Result2 = SktDebug.DBGSKT_EVAL(AddIntoQueue(pNewScanObject2), "AddIntoQueue(pNewScanObject)");
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result2)) {
                        ReleaseScanObject(pNewScanObject2);
                    }
                }
                if (EventID == 1) {
                    int[] nMode = {2};
                    if (SktScanErrors.SKTSUCCESS(Result2)) {
                        Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataConfirmationMode(nMode), "GetScanApiConfiguration().ReadDataConfirmationMode(nMode)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result2) && nMode[0] == 2) {
                        TSktScanObject ScanObj = new TSktScanObject();
                        ScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataConfirmationDevice;
                        ScanObj.Property.Type = 3;
                        long[] data = {0};
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataConfirmationAction(data), "GetScanApiConfiguration().ReadDataConfirmationAction(data)");
                        }
                        ScanObj.Property.Ulong = data[0];
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(pDeviceInterface.SetProperty(ScanObj, 0, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "pDeviceInterface.SetProperty(ScanObj,SktDeviceInterface.ESktDestination.kSktDestinationScanAPI,null,null)");
                        }
                    }
                }
            } else {
                boolean decodedData = false;
                if (pNewScanObject2.Msg.MsgID == 6 && pNewScanObject2.Msg.Event.f12ID == 1) {
                    pDeviceObject[0].storeFirstDecodedData(pNewScanObject2);
                    decodedData = true;
                }
                if (!decodedData) {
                    ReleaseScanObject(pNewScanObject2);
                }
            }
            pDeviceObject[0].Unlock();
            return Result2;
        }
    }

    public long NotifyError(long ResultToReport, SktDeviceInterface pDeviceInterface, String szErrorDetails) {
        long Result = 0;
        TSktScanObject pNewScanObject = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0) && pDeviceInterface != null) {
            SktDeviceObjectInterface[] ppDeviceObject = new SktDeviceObjectInterface[1];
            Result = SktDebug.DBGSKT_EVAL(RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface, ppDeviceObject), "RetrieveAndLockDeviceObjectFromDeviceInterface(pDeviceInterface, ppDeviceObject)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(FillMessageDeviceFromDeviceObject(pNewScanObject.Msg.Device, ppDeviceObject[0]), "FillMessageDeviceFromDeviceObject(pNewScanObject.Msg.Device,ppDeviceObject[0], pDeviceObject)");
                ppDeviceObject[0].Unlock();
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pNewScanObject.Msg.MsgID = 6;
            pNewScanObject.Msg.Result = ResultToReport;
            pNewScanObject.Msg.Event.f12ID = 0;
            if (szErrorDetails != null) {
                pNewScanObject.Msg.Event.Data.Type = 4;
                pNewScanObject.Msg.Event.Data.String.m_Value = szErrorDetails;
                pNewScanObject.Msg.Event.Data.String.nLength = szErrorDetails.length();
            } else {
                pNewScanObject.Msg.Event.Data.Type = 0;
            }
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pNewScanObject), "AddIntoQueue(pNewScanObject)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pNewScanObject = null;
            }
        }
        ReleaseScanObject(pNewScanObject);
        return Result;
    }

    public long NotifyListenerThreadStarted() {
        long Result = 0;
        TSktScanObject pNewScanObject = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            pNewScanObject.Msg.MsgID = 6;
            pNewScanObject.Msg.Result = 0;
            pNewScanObject.Msg.Event.f12ID = 5;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pNewScanObject), "AddIntoQueue(pNewScanObject)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pNewScanObject = null;
            }
        }
        ReleaseScanObject(pNewScanObject);
        return Result;
    }

    public boolean ShouldListenerStop() {
        return this.m_bShouldListenerThreadStop;
    }

    private long NotifyApplicationNewDeviceArrival(SktDeviceInterface deviceInterface) {
        long Result = 0;
        TSktScanObject newScanObject = null;
        SktDeviceObject newDeviceObject = null;
        SktScanTypes.TSktScanString deviceGuid = new SktScanTypes.TSktScanString();
        if (SktScanErrors.SKTSUCCESS(0)) {
            newDeviceObject = new SktDeviceObject();
            newScanObject = new TSktScanObject();
            if (newDeviceObject == null || newScanObject == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(newDeviceObject.Initialize(deviceInterface.GetDeviceName(), deviceInterface.GetDeviceType()), "pNewDeviceObject.Initialize(pDeviceInterface.GetDeviceName(),pDeviceInterface.GetDeviceType()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(newDeviceObject.GetGuid(deviceGuid), "pNewDeviceObject.GetGuid(DeviceGuid)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            newDeviceObject.SetStatus(0);
            newDeviceObject.SetDeviceInterface(deviceInterface);
            Result = SktDebug.DBGSKT_EVAL(AddDeviceObject(newDeviceObject), "AddDeviceObject(pNewDeviceObject)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            newScanObject.Msg.MsgID = 1;
            int nSize = 0;
            if (deviceInterface.GetDeviceName() != null) {
                nSize = deviceInterface.GetDeviceName().length();
            }
            if (nSize >= 64) {
                nSize = 63;
            }
            if (nSize > 0) {
                newScanObject.Msg.Device.szDeviceName = deviceInterface.GetDeviceName();
            }
            newScanObject.Msg.Device.Guid = deviceGuid.getValue();
            newScanObject.Msg.Device.hDevice = null;
            newScanObject.Msg.Device.DeviceType = deviceInterface.GetDeviceType();
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(newScanObject), "AddIntoQueue(pNewScanObject)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                SktUtilities.ReleaseScanObject(newScanObject);
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            deviceInterface.SetArrivalAlreadyNotified(true);
        }
        return Result;
    }

    private long NotifyNewDeviceArrival(SktSoftScanDeviceObject softscanObject) {
        long Result = 0;
        TSktScanObject newScanObject = null;
        SktScanTypes.TSktScanString deviceGuid = new SktScanTypes.TSktScanString();
        if (SktScanErrors.SKTSUCCESS(0)) {
            newScanObject = new TSktScanObject();
            if (softscanObject == null || newScanObject == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(softscanObject.GetGuid(deviceGuid), "pNewDeviceObject.GetGuid(DeviceGuid)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            softscanObject.SetStatus(0);
            softscanObject.SetDeviceInterface((SktDeviceInterface) null);
            Result = SktDebug.DBGSKT_EVAL(AddDeviceObject(softscanObject), "AddDeviceObject(softscanObject)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            newScanObject.Msg.MsgID = 1;
            int nSize = 0;
            if (softscanObject.GetFriendlyName() != null) {
                nSize = softscanObject.GetFriendlyName().length();
            }
            if (nSize >= 64) {
                nSize = 63;
            }
            if (nSize > 0) {
                newScanObject.Msg.Device.szDeviceName = softscanObject.GetFriendlyName();
            }
            newScanObject.Msg.Device.Guid = deviceGuid.getValue();
            newScanObject.Msg.Device.hDevice = null;
            newScanObject.Msg.Device.DeviceType = softscanObject.GetDeviceType();
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(newScanObject), "AddIntoQueue(pNewScanObject)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                SktUtilities.ReleaseScanObject(newScanObject);
            }
        }
        return Result;
    }

    private long HandleVersion(boolean bInterfaceVersion, Object PropertyContext) {
        String szVersion;
        long Result = 0;
        int[] pwMajor = new int[1];
        int[] pwMiddle = new int[1];
        int[] pwMinor = new int[1];
        int[] pdwBuild = new int[1];
        String[] strVersion = new String[1];
        TSktScanObject pMessageScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            pMessageScanObj.Msg.MsgID = 5;
            pMessageScanObj.Property.Type = 6;
            pMessageScanObj.Property.Context = PropertyContext;
            if (bInterfaceVersion) {
                pMessageScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdInterfaceVersion;
                long Result2 = SktDebug.DBGSKT_EVAL(AssembleVersion(SKTSCANAPIINTERFACE_VERSION, "$Rev: 12578 $", "149", strVersion), "AssembleVersion(SKTSCANAPIINTERFACE_VERSION,SCANAPI_REVISION,strVersion)");
                szVersion = strVersion[0];
            } else {
                pMessageScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdVersion;
                long Result3 = SktDebug.DBGSKT_EVAL(AssembleVersion("10.1", "$Rev: 12578 $", "149", strVersion), "AssembleVersion(SCANAPI_VERSION,SCANAPI_REVISION,strVersion)");
                szVersion = strVersion[0];
            }
            Result = SktDebug.DBGSKT_EVAL(RetrieveVersion(szVersion, true, pwMajor, pwMiddle, pwMinor, pdwBuild), "RetrieveVersion(szVersion, true, pwMajor, pwMiddle, pwMinor,pdwBuild)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pMessageScanObj.Property.Version.wMajor = pwMajor[0];
            pMessageScanObj.Property.Version.wMiddle = pwMiddle[0];
            pMessageScanObj.Property.Version.wMinor = pwMinor[0];
            pMessageScanObj.Property.Version.dwBuild = pdwBuild[0];
            String Date = new String("$Date: 2014-10-17 04:11:46 (Fri,17 Oct 2014) $");
            StringBuffer Number = new StringBuffer(64);
            int nLength = Date.length();
            int nIndex = 0;
            boolean bRetrieveNumber = false;
            int i = 0;
            while (i < nLength) {
                if (Date.charAt(i) >= '0' && Date.charAt(i) <= '9') {
                    Number.append(Date.charAt(i));
                    bRetrieveNumber = true;
                } else if (bRetrieveNumber) {
                    bRetrieveNumber = false;
                    switch (nIndex) {
                        case 0:
                            pMessageScanObj.Property.Version.wYear = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 1:
                            pMessageScanObj.Property.Version.wMonth = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 2:
                            pMessageScanObj.Property.Version.wDay = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 3:
                            pMessageScanObj.Property.Version.wHour = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 4:
                            pMessageScanObj.Property.Version.wMinute = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        default:
                            i = nLength;
                            break;
                    }
                    nIndex++;
                    Number.setLength(0);
                }
                i++;
            }
            pMessageScanObj.Msg.Result = Result;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pMessageScanObj), "AddIntoQueue(pMessageScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pMessageScanObj);
            }
        }
        return Result;
    }

    private long HandleAbort(Object PropertyContext) {
        this.m_bShouldListenerThreadStop = true;
        if (SktScanErrors.SKTSUCCESS(0)) {
            TSktScanObject pMessageScanObj = new TSktScanObject();
            pMessageScanObj.Msg.Device.hDevice = this._handle;
            pMessageScanObj.Msg.MsgID = 4;
            pMessageScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdAbort;
            pMessageScanObj.Property.Type = 0;
            pMessageScanObj.Property.Context = PropertyContext;
            pMessageScanObj.Msg.Result = 0;
            if (!SktScanErrors.SKTSUCCESS(SktDebug.DBGSKT_EVAL(AddIntoQueue(pMessageScanObj), "AddIntoQueue(pMessageScanObj)"))) {
                ReleaseScanObject(pMessageScanObj);
            }
        }
        return SktDebug.DBGSKT_EVAL(NotifyDeviceRemoval((long) SktScanDeviceType.kSktScanDeviceTypeSoftScan, false), "NotifyDeviceRemoval(SktScanDeviceType.kSktScanDeviceTypeSoftScan)");
    }

    private long HandleSetConfiguration(String pszConfigurationAndValue, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            long Result2 = SktDebug.DBGSKT_EVAL(WriteConfiguration(pszConfigurationAndValue), "WriteConfiguration(pszConfigurationAndValue)");
            this.m_ConfigurationFlipFlopEvent.Signal(this.m_FlipFlopEventState);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdConfiguration;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetConfiguration(String pszConfiguration, Object PropertyContext) {
        TSktScanObject[] pScanObj = new TSktScanObject[1];
        long Result = SktDebug.DBGSKT_EVAL(ReadConfiguration(pszConfiguration, pScanObj), "ReadConfiguration(pszConfiguration,pScanObj)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj[0].Msg.Device.hDevice = this._handle;
            pScanObj[0].Msg.MsgID = 5;
            pScanObj[0].Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj[0]), "AddIntoQueue(pScanObj[0])");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj[0]);
            }
        }
        return Result;
    }

    private long HandleSetDataConfirmationMode(int nConfirmationMode, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteDataConfirmationMode(nConfirmationMode), "GetScanApiConfiguration().WriteDataConfirmationMode(nConfirmationMode)");
            if (SktScanErrors.SKTSUCCESS(Result) && nConfirmationMode != 0) {
                SktList.Position position = new SktList.Position();
                SktDeviceObjectInterface[] pDeviceObject = new SktDeviceObjectInterface[1];
                SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(InitializePropertyForDataConfirmationMode(nConfirmationMode, Property), "InitializePropertyForDataConfirmationMode(nConfirmationMode,Property)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    while (SktScanErrors.SKTSUCCESS(RetrieveAndLockDeviceObjectFromPosition(position, pDeviceObject))) {
                        if (pDeviceObject[0].GetDeviceInterface() != null) {
                            if (SktScanErrors.SKTSUCCESS(Result)) {
                                Result = SktDebug.DBGSKT_EVAL(pDeviceObject[0].GetDeviceInterface().AddInitialization(false, Property, 0), "pDeviceObject[0].GetDeviceInterface().AddInitialization(false,Property,SktScanErrors.ESKT_NOERROR)");
                            }
                            if (SktScanErrors.SKTSUCCESS(Result)) {
                                Result = SktDebug.DBGSKT_EVAL(pDeviceObject[0].GetDeviceInterface().StartInitializing(false), "pDeviceObject[0].GetDeviceInterface().StartInitializing(false)");
                            }
                        }
                        pDeviceObject[0].Unlock();
                        if (!position.IsValid()) {
                            break;
                        }
                    }
                }
                pScanObj.Msg.Device.hDevice = this._handle;
                pScanObj.Msg.MsgID = 4;
                pScanObj.Msg.Result = Result;
                pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataConfirmationMode;
                pScanObj.Property.Type = 0;
                pScanObj.Property.Context = PropertyContext;
                Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    ReleaseScanObject(pScanObj);
                }
            }
        }
        return Result;
    }

    private long HandleGetDataConfirmationMode(Object PropertyContext) {
        long Result = 0;
        int[] nConfirmationMode = {1};
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            long Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataConfirmationMode(nConfirmationMode), "GetScanApiConfiguration().ReadDataConfirmationMode(nConfirmationMode)");
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataConfirmationMode;
            pScanObj.Property.Type = 2;
            pScanObj.Property.Byte = (char) nConfirmationMode[0];
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataConfirmationAction(long ulConfirmationAction, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            long Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteDataConfirmationAction(ulConfirmationAction), "GetScanApiConfiguration().WriteDataConfirmationAction(ulConfirmationAction)");
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataConfirmationAction;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataConfirmationAction(Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            long[] pValue = {pScanObj.Property.Ulong};
            long Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataConfirmationAction(pValue), "GetScanApiConfiguration().ReadDataConfirmationAction(pValue)");
            pScanObj.Property.Ulong = pValue[0];
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataConfirmationAction;
            pScanObj.Property.Type = 3;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleApplyConfigDevice(SktDeviceObjectInterface pDeviceObj, TSktScanObject pScanObj) {
        long Result = 0;
        String[] Guid = new String[1];
        SktDeviceConfig[] pDeviceConfig = new SktDeviceConfig[1];
        SktList Properties = new SktList();
        SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
        SktDeviceInterface pDeviceInterface = null;
        SktScanTypes.TSktScanProperty PropertyComplete = new SktScanTypes.TSktScanProperty();
        if (pDeviceObj == null || pScanObj == null) {
            Result = -18;
        } else {
            pDeviceInterface = pDeviceObj.GetDeviceInterface();
            if (pDeviceInterface == null) {
                Result = -32;
            } else {
                PropertyComplete.f13ID = ISktScanProperty.propId.kSktScanPropIdApplyConfigDevice;
                PropertyComplete.Type = 0;
                PropertyComplete.Context = pScanObj.Property.Context;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadConfigGuid((int) pDeviceObj.GetDeviceType(), Guid), "GetScanApiConfiguration().ReadConfigGuid((int)pDeviceObj.GetDeviceType(),Guid)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = RetrieveAndLockDeviceObjectFromDeviceName(Guid[0], (SktDeviceObjectInterface[]) pDeviceConfig);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pDeviceConfig[0].Open(), "pDeviceConfig[0].Open()");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pDeviceConfig[0].RetrievePropertiesToApply(Properties), "pDeviceConfig[0].RetrievePropertiesToApply(Properties)");
                }
                pDeviceConfig[0].Close();
            }
            pDeviceConfig[0].Unlock();
        }
        SktList.Position position = Properties.GetHeadPosition();
        if (position.IsValid()) {
            while (position.IsValid() && SktScanErrors.SKTSUCCESS(Result)) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pProperty[0] = (SktScanTypes.TSktScanProperty) position.GetNext();
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.AddInitialization(false, pProperty[0], -15), "pDeviceInterface.AddInitialization(false,pProperty[0],SktScanErrors.ESKT_NOTSUPPORTED)");
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.SaveInitializationCompleteProperty(PropertyComplete, new SktScanTypes.TSktScanBoolean(false)), "pDeviceInterface.SaveInitializationCompleteProperty(PropertyComplete,new TSktScanBoolean(false))");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.StartInitializing(false), "pDeviceInterface.StartInitializing(false)");
            }
        }
        while (SktScanErrors.SKTSUCCESS(Properties.RemoveHead(pProperty))) {
            pProperty = null;
        }
        return Result;
    }

    private long HandleSetMonitorMode(char[] pucData, int nDataSize, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        long ulValue = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            if (nDataSize == 5) {
                for (int i = 0; i < 4; i++) {
                    ulValue = (ulValue << 8) + ((long) pucData[i + 1]);
                }
                switch (pucData[0]) {
                    case 1:
                        SktDebug.SktDbgSetLevel((int) ulValue);
                        break;
                    case 2:
                        SktDebug.SktDbgSetChannel((int) ulValue);
                        break;
                    case 3:
                        SktDebug.SktDbgSetFileLineLevel((int) ulValue);
                        break;
                    default:
                        Result = -15;
                        break;
                }
            } else {
                Result = -18;
            }
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdMonitorMode;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetMonitorMode(char ucMode, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            switch (ucMode) {
                case 1:
                    pScanObj.Property.Ulong = (long) SktDebug.SktDbgGetLevel();
                    break;
                case 2:
                    pScanObj.Property.Ulong = (long) SktDebug.SktDbgGetChannel();
                    break;
                case 3:
                    pScanObj.Property.Ulong = (long) SktDebug.SktDbgGetFileLineLevel();
                    break;
                default:
                    Result = -15;
                    break;
            }
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = Result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdMonitorMode;
            pScanObj.Property.Type = 3;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetSoftScanStatus(char ucStatus, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszSoftScanStatus = new String[1];
            long Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadSoftscanStatus(pszSoftScanStatus, 1024), "GetScanApiConfiguration().ReadSoftscanStatus(pszSoftScanStatus,nStringValueLength)");
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                if (pszSoftScanStatus[0].equalsIgnoreCase("notsupported")) {
                    if (ucStatus == 3) {
                        Result2 = this.m_Configuration.WriteSoftscanStatus("disabled");
                    } else {
                        SktDebug.DBGSKT_MSG(18, "Softscan is not supported");
                        Result2 = -15;
                    }
                } else if (pszSoftScanStatus[0].equalsIgnoreCase("enabled")) {
                    if (ucStatus == 0) {
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteSoftscanStatus("disabled"), "GetScanApiConfiguration().WriteSoftscanStatus(\"disabled\")");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(NotifyDeviceRemoval((long) SktScanDeviceType.kSktScanDeviceTypeSoftScan, true), "NotifyDeviceRemoval(SktScanDeviceType.kSktScanDeviceTypeSoftScan)");
                        }
                    } else if (ucStatus == 2) {
                        Result2 = -43;
                    }
                } else if (ucStatus == 2) {
                    Result2 = SktDebug.DBGSKT_EVAL(this.m_Configuration.WriteSoftscanStatus("notsupported"), "m_Configuration.WriteSoftscanStatus(\"notsupported\")");
                } else if (ucStatus == 3) {
                    Result2 = SktDebug.DBGSKT_EVAL(this.m_Configuration.WriteSoftscanStatus("disabled"), "m_Configuration.WriteSoftscanStatus(\"disabled\")");
                } else if (ucStatus == 1) {
                    if (SktSoftScanDeviceObject.IsSupported()) {
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteSoftscanStatus("enabled"), "GetScanApiConfiguration().WriteSoftscanStatus(\"enabled\")");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result2)) {
                            String[] pszSoftScanStatusOrFriendlyName = new String[1];
                            SktSoftScanDeviceObject pSoftscanDeviceObject = new SktSoftScanDeviceObject(this);
                            if (SktScanErrors.SKTSUCCESS(Result2) && SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadSoftscanFriendlyName(pszSoftScanStatusOrFriendlyName, 1024), "GetScanApiConfiguration().ReadSoftscanFriendlyName(pszSoftScanStatusOrFriendlyName,nStringValueLength)") == -17) {
                                pszSoftScanStatusOrFriendlyName[0] = "SoftScanner";
                            }
                            long Result3 = SktDebug.DBGSKT_EVAL(pSoftscanDeviceObject.Initialize(pszSoftScanStatusOrFriendlyName[0], (long) SktScanDeviceType.kSktScanDeviceTypeSoftScan), "pSoftscanDeviceObject.Initialize(pszSoftScanStatusOrFriendlyName[0],SktScanDeviceType.kSktScanDeviceTypeSoftScan)");
                            SktScanTypes.TSktScanString DeviceGuid = new SktScanTypes.TSktScanString();
                            Result2 = pSoftscanDeviceObject.GetGuid(DeviceGuid);
                            SktDebug.DBGSKT_MSG(17, "Softscan GUID is " + DeviceGuid.m_Value);
                            if (DeviceGuid.nLength > 1) {
                                Result2 = SktDebug.DBGSKT_EVAL(NotifyNewDeviceArrival(pSoftscanDeviceObject), "NotifyNewDeviceArrival(pSoftscanDeviceObject)");
                            }
                            if (SktScanErrors.SKTSUCCESS(Result2)) {
                            }
                        }
                    } else {
                        SktDebug.DBGSKT_MSG(18, "SoftScan requirements have not been met.");
                        Result2 = -15;
                    }
                }
            } else if (Result2 == -17) {
                Result2 = AddSoftScanDefaults();
                if (SktScanErrors.SKTSUCCESS(Result2)) {
                    Result2 = GetScanApiConfiguration().WriteSoftscanStatus("disabled");
                }
            }
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdSoftScanStatus;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetSoftScanStatus(Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            char ucStatus = 2;
            String[] pszSoftScanStatus = new String[1];
            if (SktScanErrors.SKTSUCCESS(GetScanApiConfiguration().ReadSoftscanStatus(pszSoftScanStatus, 1024))) {
                if (pszSoftScanStatus[0].equalsIgnoreCase("enabled")) {
                    ucStatus = 1;
                } else if (pszSoftScanStatus[0].equalsIgnoreCase("disabled")) {
                    ucStatus = 0;
                }
            }
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = 0;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdSoftScanStatus;
            pScanObj.Property.Type = 2;
            pScanObj.Property.Byte = ucStatus;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingProfile(String pszProfileNames, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingProfiles(pszProfileNames);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingProfile;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingProfile(Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszProfileNames = new String[1];
            long Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingProfiles(pszProfileNames), "GetScanApiConfiguration().ReadDataEditingProfiles(pszProfileNames)");
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingProfile;
            pScanObj.Property.Type = 5;
            pScanObj.Property.String.m_Value = pszProfileNames[0];
            if (pszProfileNames[0] == null) {
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.nLength = pszProfileNames[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingCurrentProfile(String pszProfileName, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        SktDebug.DBGSKT_MSG(17, "About to switch to the Data Editing Profile:" + pszProfileName);
        if (pszProfileName == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().WriteCurrentProfile(pszProfileName), "GetScanApiConfiguration().WriteCurrentProfile(pszProfileName)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(InitializeDataEditingProfile(pszProfileName), "InitializeDataEditingProfile(pszProfileName)");
        }
        pScanObj.Msg.Device.hDevice = this._handle;
        pScanObj.Msg.MsgID = 4;
        pScanObj.Msg.Result = Result;
        pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingCurrentProfile;
        pScanObj.Property.Type = 0;
        pScanObj.Property.Context = PropertyContext;
        long Result2 = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
        if (!SktScanErrors.SKTSUCCESS(Result2)) {
            ReleaseScanObject(pScanObj);
        }
        return Result2;
    }

    private long HandleGetDataEditingCurrentProfile(Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszProfileName = new String[1];
            long Result2 = GetScanApiConfiguration().ReadCurrentProfile(pszProfileName);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingCurrentProfile;
            pScanObj.Property.Type = 5;
            pScanObj.Property.String.m_Value = pszProfileName[0];
            pScanObj.Property.String.nLength = pszProfileName[0].length();
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingSymbologies(String pszProfileSymbologies, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileSymbologies.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingSymbologies(pszProfileSymbologies);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerSymbologies;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingSymbologies(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszSymbologies = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingSymbologies(pszProfile, pszSymbologies);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerSymbologies;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result)) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else if (pszSymbologies[0] == null) {
                pScanObj.Property.String.m_Value = pszProfile + "=";
                pScanObj.Property.String.nLength = pszProfile.length() + 1;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszSymbologies[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszSymbologies[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingMinLength(String pszProfileMinLength, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileMinLength.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingMinLength(pszProfileMinLength);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerMinLength;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingMinLength(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszMinLength = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingMinLength(pszProfile, pszMinLength);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerMinLength;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result) || pszMinLength[0] == null) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszMinLength[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszMinLength[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingMaxLength(String pszProfileMaxLength, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileMaxLength.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingMaxLength(pszProfileMaxLength);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerMaxLength;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingMaxLength(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszMaxLength = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingMaxLength(pszProfile, pszMaxLength);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerMaxLength;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result) || pszMaxLength[0] == null) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszMaxLength[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszMaxLength[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingStartsBy(String pszProfileStartsBy, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileStartsBy.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingStartsBy(pszProfileStartsBy);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerStartsBy;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingStartsBy(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszStartsBy = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingStartsBy(pszProfile, pszStartsBy);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerStartsBy;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result) || pszStartsBy[0] == null) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszStartsBy[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszStartsBy[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingEndsWith(String pszProfileEndsWith, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileEndsWith.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingEndsWith(pszProfileEndsWith);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerEndsWith;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingEndsWith(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszEndsWith = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingEndsWith(pszProfile, pszEndsWith);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerEndsWith;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result) || pszEndsWith[0] == null) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszEndsWith[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszEndsWith[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingContains(String pszProfileContains, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileContains.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long result = GetScanApiConfiguration().WriteDataEditingContains(pszProfileContains);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerContains;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingContains(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszContains = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingContains(pszProfile, pszContains);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingTriggerContains;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result) || pszContains[0] == null) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszContains[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszContains[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleSetDataEditingOperation(String pszProfileOperation, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszProfileOperation.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            long Result2 = GetScanApiConfiguration().WriteDataEditingOperation(pszProfileOperation);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingOperation;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleGetDataEditingOperation(String pszProfile, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszOperation = new String[1];
            long result = GetScanApiConfiguration().ReadDataEditingOperation(pszProfile, pszOperation);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = result;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingOperation;
            pScanObj.Property.Type = 5;
            if (!SktScanErrors.SKTSUCCESS(result) || pszOperation[0] == null) {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            } else {
                pScanObj.Property.String.m_Value = pszProfile + "=" + pszOperation[0];
                pScanObj.Property.String.nLength = pszProfile.length() + 1 + pszOperation[0].length();
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleImportDataEditing(String pszDataEditing, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (pszDataEditing.length() == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            String[] pszErrorDetail = new String[1];
            long Result2 = GetScanApiConfiguration().ImportDataEditing(pszDataEditing, pszErrorDetail);
            if (Result2 == -80) {
                NotifyError(Result2, (SktDeviceInterface) null, pszErrorDetail[0]);
            }
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 4;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingImportExport;
            pScanObj.Property.Type = 0;
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long HandleExportDataEditing(String pszProfiles, Object PropertyContext) {
        long Result = 0;
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            String[] pszDataEditing = new String[1];
            long Result2 = GetScanApiConfiguration().ExportDataEditing(pszProfiles, pszDataEditing);
            pScanObj.Msg.Device.hDevice = this._handle;
            pScanObj.Msg.MsgID = 5;
            pScanObj.Msg.Result = Result2;
            pScanObj.Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDataEditingImportExport;
            pScanObj.Property.Type = 5;
            if (pszDataEditing[0].length() > 0) {
                pScanObj.Property.String.m_Value = "<DataEditing ScanAPIInterfaceVersion=\"" + SKTSCANAPIINTERFACE_VERSION + "\">\n" + pszDataEditing[0] + "</DataEditing>";
                pScanObj.Property.String.nLength = pScanObj.Property.String.m_Value.length();
            } else {
                pScanObj.Property.String.m_Value = "";
                pScanObj.Property.String.nLength = 0;
            }
            pScanObj.Property.Context = PropertyContext;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pScanObj);
            }
        }
        return Result;
    }

    private long SendTerminateToApp() {
        long Result = 0;
        TSktScanObject pMessageScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(0)) {
            SktDebug.DBGSKT_MSG(17, "Send a Terminate to the App");
            pMessageScanObj.Msg.Device.hDevice = this._handle;
            pMessageScanObj.Msg.MsgID = 3;
            pMessageScanObj.Msg.Result = 0;
            Result = SktDebug.DBGSKT_EVAL(AddIntoQueue(pMessageScanObj), "AddIntoQueue(pMessageScanObj)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                ReleaseScanObject(pMessageScanObj);
            }
        }
        return Result;
    }

    private long AddDeviceObject(SktDeviceObjectInterface pNewDeviceObject) {
        long Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Lock(), "m_DeviceObjectsLock.Lock()");
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this.m_DeviceObjects.AddTail(pNewDeviceObject), "m_DeviceObjects.AddTail(pNewDeviceObject)");
        this.m_DeviceObjectsLock.Unlock();
        return Result2;
    }

    private long RetrieveAndLockDeviceObjectFromDeviceInterface(SktDeviceInterface pDeviceInterface, SktDeviceObjectInterface[] ppDeviceObject) {
        long Result = 0;
        if (ppDeviceObject == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Lock(), "m_DeviceObjectsLock.Lock()");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktDeviceObjectInterface[] pCurrentDeviceObject = new SktDeviceObjectInterface[1];
        SktList.Position position = this.m_DeviceObjects.GetHeadPosition();
        while (true) {
            if (!position.IsValid()) {
                break;
            }
            SktList.Position removePosition = position.Copy();
            pCurrentDeviceObject[0] = (SktDeviceObjectInterface) position.GetNext();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pCurrentDeviceObject[0].Lock(), "pCurrentDeviceObject[0].Lock()");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                break;
            }
            boolean bToDelete = false;
            if (pCurrentDeviceObject[0].GetStatus() != 2) {
                if (pCurrentDeviceObject[0].GetDeviceInterface() == pDeviceInterface) {
                    ppDeviceObject[0] = pCurrentDeviceObject[0];
                    break;
                }
            } else {
                bToDelete = true;
                this.m_DeviceObjects.RemoveAt(removePosition, pCurrentDeviceObject);
            }
            pCurrentDeviceObject[0].Unlock();
            if (bToDelete) {
                pCurrentDeviceObject[0] = null;
            }
            pCurrentDeviceObject[0] = null;
        }
        this.m_DeviceObjectsLock.Unlock();
        if (!SktScanErrors.SKTSUCCESS(Result) || pCurrentDeviceObject[0] != null) {
            return Result;
        }
        return -17;
    }

    private long RetrieveAndLockDeviceObjectFromDeviceName(String deviceName, SktDeviceObjectInterface[] deviceObject) {
        long Result = 0;
        boolean found = false;
        if (deviceObject == null || deviceName == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Lock(), "m_DeviceObjectsLock.Lock()");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktDeviceObjectInterface[] currentDeviceObject = new SktDeviceObjectInterface[1];
        SktList.Position position = this.m_DeviceObjects.GetHeadPosition();
        while (true) {
            if (!position.IsValid()) {
                break;
            }
            SktList.Position removePosition = position.Copy();
            currentDeviceObject[0] = (SktDeviceObjectInterface) position.GetNext();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(currentDeviceObject[0].Lock(), "pCurrentDeviceObject[0].Lock()");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                break;
            }
            boolean bToDelete = false;
            if (currentDeviceObject[0].GetStatus() != 2) {
                if (currentDeviceObject[0].GetGuidAsString().equalsIgnoreCase(deviceName) && currentDeviceObject[0].GetStatus() == 0) {
                    deviceObject[0] = currentDeviceObject[0];
                    found = true;
                    break;
                }
            } else {
                bToDelete = true;
                this.m_DeviceObjects.RemoveAt(removePosition, currentDeviceObject);
            }
            currentDeviceObject[0].Unlock();
            if (bToDelete) {
                currentDeviceObject[0] = null;
            }
        }
        this.m_DeviceObjectsLock.Unlock();
        if (!SktScanErrors.SKTSUCCESS(Result) || found) {
            return Result;
        }
        return -17;
    }

    private long RetrieveAndLockDeviceObjectFromHandle(ISktScanDevice scanDevice, SktDeviceObjectInterface[] deviceObject) {
        long Result = 0;
        boolean found = false;
        if (deviceObject == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_DeviceObjectsLock.Lock();
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position position = this.m_DeviceObjects.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                SktList.Position removePosition = position.Copy();
                deviceObject[0] = (SktDeviceObjectInterface) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(deviceObject[0].Lock(), "ppDeviceObject[0].Lock()");
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    break;
                }
                boolean bToDelete = false;
                if (deviceObject[0].GetStatus() != 2) {
                    if (scanDevice.equals(deviceObject[0].getHandle())) {
                        found = true;
                        break;
                    }
                } else {
                    bToDelete = true;
                    this.m_DeviceObjects.RemoveAt(removePosition, deviceObject);
                }
                deviceObject[0].Unlock();
                if (bToDelete) {
                    deviceObject[0] = null;
                }
            }
            this.m_DeviceObjectsLock.Unlock();
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || found) {
            return Result;
        }
        return -11;
    }

    private long RetrieveAndLockDeviceObjectFromPosition(SktList.Position position, SktDeviceObjectInterface[] ppDeviceObject) {
        long Result = 0;
        boolean bFound = false;
        if (ppDeviceObject == null || position.IsValid()) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Lock(), "m_DeviceObjectsLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position searchPosition = position;
            if (!searchPosition.IsValid()) {
                searchPosition = this.m_DeviceObjects.GetHeadPosition();
            }
            while (true) {
                if (!searchPosition.IsValid()) {
                    break;
                }
                SktList.Position removePosition = searchPosition.Copy();
                ppDeviceObject[0] = (SktDeviceObjectInterface) searchPosition.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(ppDeviceObject[0].Lock(), "ppDeviceObject[0].Lock()");
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    break;
                }
                boolean bToDelete = false;
                if (ppDeviceObject[0].GetStatus() != 2) {
                    if (ppDeviceObject[0].GetStatus() == 0) {
                        bFound = true;
                        SktList.Position position2 = searchPosition;
                        break;
                    }
                } else {
                    bToDelete = true;
                    this.m_DeviceObjects.RemoveAt(removePosition, ppDeviceObject);
                }
                ppDeviceObject[0].Unlock();
                if (bToDelete) {
                    ppDeviceObject[0] = null;
                }
            }
            this.m_DeviceObjectsLock.Unlock();
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || bFound) {
            return Result;
        }
        ppDeviceObject[0] = null;
        return -17;
    }

    private boolean AreAllDeviceObjectDeleted() {
        boolean bAreAllDeviceObjectDeleted = true;
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_DeviceObjectsLock.Lock(), "m_DeviceObjectsLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position position = this.m_DeviceObjects.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                SktDeviceObjectInterface pDeviceObject = (SktDeviceObjectInterface) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pDeviceObject.Lock(), "pDeviceObject.Lock()");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (pDeviceObject.GetStatus() != 2 && pDeviceObject.IsPhysicalDevice()) {
                        bAreAllDeviceObjectDeleted = false;
                        pDeviceObject.Unlock();
                        break;
                    }
                    pDeviceObject.Unlock();
                } else {
                    break;
                }
            }
            this.m_DeviceObjectsLock.Unlock();
        }
        return bAreAllDeviceObjectDeleted;
    }

    private long AddInitializationFromConfiguration(SktDeviceInterface pDeviceInterface, int[] pnConfigurationCount) {
        long Result;
        long Result2 = 0;
        int[] DataConfirmationMode = {0};
        SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
        if (pnConfigurationCount == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pnConfigurationCount[0] = 0;
            if (SktScanDeviceType.SKTRETRIEVE_INTERFACETYPE((int) pDeviceInterface.GetDeviceType()) == 3) {
                Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataConfirmationMode(DataConfirmationMode), "GetScanApiConfiguration().ReadDataConfirmationMode(DataConfirmationMode)");
                if (DataConfirmationMode[0] != 0) {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(InitializePropertyForDataConfirmationMode(DataConfirmationMode[0], Property), "InitializePropertyForDataConfirmationMode(DataConfirmationMode,&Property)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.AddInitialization(false, Property, 0), "pDeviceInterface.AddInitialization(false,Property,ESKT_NOERROR)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        pnConfigurationCount[0] = pnConfigurationCount[0] + 1;
                    }
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    SktScanTypes.TSktScanProperty beep = new SktScanTypes.TSktScanProperty();
                    beep.f13ID = ISktScanProperty.propId.kSktScanPropIdDataConfirmationDevice;
                    beep.Type = 3;
                    beep.Ulong = (long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 0);
                    Result = SktDebug.DBGSKT_EVAL(pDeviceInterface.AddInitialization(false, beep, 0), "pDeviceInterface.AddInitialization(false,beep,ESKT_NOERROR)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pnConfigurationCount[0] = pnConfigurationCount[0] + 1;
                }
            }
        }
        return Result;
    }

    private long AddDeviceConfiguration() {
        long Result = 0;
        AnonymousClass1stConfigDef[] configDefList = {new Object("ConfigChs7x.xml", (long) SktScanDeviceType.kSktScanDeviceTypeScanner7x, "{422C0329-3E8E-417a-A552-06FABF335B00}") {
            public long deviceType;
            public String fileName;
            public String guid;

            {
                this.fileName = fileName;
                this.deviceType = deviceType;
                this.guid = guid;
            }
        }, new Object(SktConfigurationBase.kSktDeviceConfigurationFileNameChs7xi, (long) SktScanDeviceType.kSktScanDeviceTypeScanner7xi, SktConfigurationBase.kSktDeviceConfigurationGuidChs7xi) {
            public long deviceType;
            public String fileName;
            public String guid;

            {
                this.fileName = fileName;
                this.deviceType = deviceType;
                this.guid = guid;
            }
        }, new Object(SktConfigurationBase.kSktDeviceConfigurationFileNameChs7, (long) SktScanDeviceType.kSktScanDeviceTypeScanner7, SktConfigurationBase.kSktDeviceConfigurationGuidChs7) {
            public long deviceType;
            public String fileName;
            public String guid;

            {
                this.fileName = fileName;
                this.deviceType = deviceType;
                this.guid = guid;
            }
        }, new Object(SktConfigurationBase.kSktDeviceConfigurationFileNameCrs9, (long) SktScanDeviceType.kSktScanDeviceTypeScanner9, SktConfigurationBase.kSktDeviceConfigurationGuidCrs9) {
            public long deviceType;
            public String fileName;
            public String guid;

            {
                this.fileName = fileName;
                this.deviceType = deviceType;
                this.guid = guid;
            }
        }, new Object(SktConfigurationBase.kSktDeviceConfigurationFileNameChs8ci, (long) SktScanDeviceType.kSktScanDeviceTypeScanner8ci, SktConfigurationBase.kSktDeviceConfigurationGuidChs8ci) {
            public long deviceType;
            public String fileName;
            public String guid;

            {
                this.fileName = fileName;
                this.deviceType = deviceType;
                this.guid = guid;
            }
        }};
        int count = configDefList.length;
        for (int i = 0; i < count; i++) {
            SktDeviceConfig pNewDeviceConfig = new SktDeviceConfig();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pNewDeviceConfig.Initialize(configDefList[i].fileName, configDefList[i].deviceType, configDefList[i].guid), "pNewDeviceConfig.Initialize(configDefList[i].fileName,configDefList[i].deviceType,configDefList[i].guid)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDeviceObject(pNewDeviceConfig), "AddDeviceObject(pNewDeviceConfig)");
            }
        }
        return Result;
    }

    private long StopAndRestartListenerThread() {
        this.m_bStopAndRestartListenerThreadProcess = true;
        this.m_bShouldListenerThreadStop = true;
        long Result = SktDebug.DBGSKT_EVAL(this.m_ListenerThread.WaitForThreadTermination(10000), "m_ListenerThread.WaitForThreadTermination(kThreadTerminationTimeout)");
        if (SktScanErrors.SKTSUCCESS(Result) && Result == 1) {
            SktDebug.DBGSKT_MSG(18, "Thread didn't terminate on time");
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this.m_ListenerThread.DeleteThread(), "m_ListenerThread.DeleteThread()");
        this.m_bStopAndRestartListenerThreadProcess = false;
        this.m_bShouldListenerThreadStop = false;
        return SktDebug.DBGSKT_EVAL(this.m_ListenerThread.CreateThread(new SktListener(this)), "m_ListenerThread.CreateThread(listener)");
    }

    private long InitializePropertyForDataConfirmationMode(int Mode, SktScanTypes.TSktScanProperty pProperty) {
        long Result = 0;
        if (pProperty == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pProperty.f13ID = ISktScanProperty.propId.kSktScanPropIdLocalAcknowledgmentDevice;
        pProperty.Type = 2;
        switch (Mode) {
            case 1:
                pProperty.Byte = 1;
                return Result;
            case 2:
            case 3:
                pProperty.Byte = 0;
                return Result;
            default:
                return -23;
        }
    }

    private static int CodeDecimalInHexa(int nDecimal) {
        int nDecimalInHexa = 0 + ((nDecimal / 100000) * 1048576);
        int nDecimal2 = nDecimal - ((nDecimal / 100000) * 100000);
        int nDecimalInHexa2 = nDecimalInHexa + ((nDecimal2 / 10000) * 65536);
        int nDecimal3 = nDecimal2 - ((nDecimal2 / 10000) * 10000);
        int nDecimalInHexa3 = nDecimalInHexa2 + ((nDecimal3 / 1000) * 4096);
        int nDecimal4 = nDecimal3 - ((nDecimal3 / 1000) * 1000);
        int nDecimalInHexa4 = nDecimalInHexa3 + ((nDecimal4 / 100) * 256);
        int nDecimal5 = nDecimal4 - ((nDecimal4 / 100) * 100);
        return nDecimalInHexa4 + ((nDecimal5 / 10) * 16) + (nDecimal5 - ((nDecimal5 / 10) * 10));
    }

    private static int getintvalue(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        StringBuffer bf = new StringBuffer();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                bf.append(c);
            } else if (c == ',') {
                continue;
            } else if (bf.length() == 0) {
            }
        }
        try {
            return Integer.parseInt(bf.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    private long FillMessageDeviceFromDeviceObject(SktScanTypes.TSktScanDevice pMsgDevice, SktDeviceObjectInterface pDeviceObject) {
        pMsgDevice.hDevice = pDeviceObject.getHandle();
        if (pDeviceObject.GetFriendlyName() != null) {
            if (pDeviceObject.GetFriendlyName().length() >= 64) {
            }
            pMsgDevice.szDeviceName = pDeviceObject.GetFriendlyName();
        }
        pMsgDevice.DeviceType = pDeviceObject.GetDeviceType();
        return 0;
    }

    private long FillSymbologyName(int SymbologyID, SktScanTypes.TSktScanString pSymbologyName) {
        long Result = 0;
        if (pSymbologyName == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int ulCount = SktScanSymbologyNames.length;
            int ulSymbologyId = SymbologyID;
            if (ulSymbologyId >= ulCount) {
                ulSymbologyId = ulCount - 1;
            }
            pSymbologyName.nLength = SktScanSymbologyNames[ulSymbologyId].length();
            pSymbologyName.setValue(SktScanSymbologyNames[ulSymbologyId]);
        }
        return Result;
    }

    public static long RetrieveVersion(String szVersion, boolean bCodeDecimalInHexa, int[] pwMajor, int[] pwMiddle, int[] pwMinor, int[] pdwBuild) {
        long result = 0;
        if (pwMajor == null || pwMiddle == null || pwMinor == null || pdwBuild == null) {
            result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            int[] nVersions = new int[4];
            String[] strVersions = SktUtilities.split(szVersion, ".");
            int max = strVersions.length > nVersions.length ? nVersions.length : strVersions.length;
            int nIndex = 0;
            while (nIndex < max) {
                try {
                    nVersions[nIndex] = Integer.parseInt(strVersions[nIndex]);
                    nIndex++;
                } catch (NumberFormatException e) {
                    result = -41;
                }
            }
            if (SktScanErrors.SKTSUCCESS(result)) {
                if (bCodeDecimalInHexa) {
                    if (max > 0) {
                        pwMajor[0] = CodeDecimalInHexa(nVersions[0]);
                    }
                    if (max > 1) {
                        pwMiddle[0] = CodeDecimalInHexa(nVersions[1]);
                    }
                    if (max > 2) {
                        pwMinor[0] = CodeDecimalInHexa(nVersions[2]);
                    }
                    if (max > 3) {
                        pdwBuild[0] = nVersions[3];
                    }
                } else {
                    if (max > 0) {
                        pwMajor[0] = nVersions[0];
                    }
                    if (max > 1) {
                        pwMiddle[0] = nVersions[1];
                    }
                    if (max > 2) {
                        pwMinor[0] = nVersions[2];
                    }
                    if (max > 3) {
                        pdwBuild[0] = nVersions[3];
                    }
                }
            }
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public long CheckScanApiVersion(int wMajor, int wMiddle, int wMinor, SktDeviceInterface pDeviceInterface) {
        boolean isOlder = true;
        int[] pwScanApiMajor = new int[1];
        int[] pwScanApiMiddle = new int[1];
        int[] pwScanApiMinor = new int[1];
        int[] pdwScanApiBuild = new int[1];
        String[] strVersion = new String[1];
        long result = SktDebug.DBGSKT_EVAL(AssembleVersion("10.1", "$Rev: 12578 $", "149", strVersion), "AssembleVersion(SCANAPI_VERSION,SCANAPI_REVISION,strVersion)");
        if (SktScanErrors.SKTSUCCESS(result)) {
            result = SktDebug.DBGSKT_EVAL(RetrieveVersion(strVersion[0], false, pwScanApiMajor, pwScanApiMiddle, pwScanApiMinor, pdwScanApiBuild), "RetrieveVersion(SCANAPI_VERSION,false,pwScanApiMajor,pwScanApiMiddle,pwScanApiMinor,pdwScanApiBuild)");
        }
        if (!SktScanErrors.SKTSUCCESS(result)) {
            return result;
        }
        if (pwScanApiMajor[0] >= wMajor) {
            if (pwScanApiMajor[0] != wMajor) {
                isOlder = false;
            } else if (pwScanApiMiddle[0] >= wMiddle) {
                if (pwScanApiMiddle[0] != wMiddle) {
                    isOlder = false;
                } else if (pwScanApiMinor[0] >= wMinor) {
                    isOlder = false;
                }
            }
        }
        if (!isOlder) {
            return result;
        }
        return SktDebug.DBGSKT_EVAL(NotifyError(-48, pDeviceInterface, wMajor + "." + wMiddle + "." + wMinor), "NotifyErrorWithString(SktScanErrors.ESKT_OUTDATEDVERSION,strVersion)");
    }

    /* access modifiers changed from: protected */
    public long AssembleVersion(String version, String revision, String build, String[] finalVersion) {
        String finalstr;
        String[] versionArray = version.split("\\.");
        String finalstr2 = "";
        if (versionArray.length >= 2) {
            finalstr2 = ((finalstr2 + versionArray[0]) + ".") + versionArray[1];
        }
        String finalstr3 = finalstr2 + ".";
        if (revision.length() > 0) {
            int max = revision.length();
            boolean bIn = false;
            for (int i = 0; i < max; i++) {
                if (revision.charAt(i) >= '0' && revision.charAt(i) <= '9') {
                    finalstr3 = finalstr3 + revision.charAt(i);
                    bIn = true;
                } else if (bIn) {
                    break;
                }
            }
        } else {
            finalstr3 = finalstr3 + "0";
        }
        String finalstr4 = finalstr3 + ".";
        if (build.length() > 0) {
            finalstr = finalstr4 + build;
        } else {
            finalstr = finalstr4 + "0";
        }
        finalVersion[0] = finalstr;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long AddSoftScanDefaults() {
        return SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().InsertSoftScanTags(), "GetScanApiConfiguration().InsertSoftScanTags()");
    }

    /* access modifiers changed from: package-private */
    public long InitializeDataEditingProfile(String pszProfileName) {
        String[] szValue = new String[1];
        long Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.resetTrigger(), "m_DataEditingProfile.ResetTrigger()");
        this.m_DataEditingProfile.removeAllOperations();
        if (!SktScanErrors.SKTSUCCESS(Result) || pszProfileName == null || pszProfileName.length() <= 0) {
            return Result;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingSymbologies(pszProfileName, szValue), "GetScanApiConfiguration().ReadDataEditingSymbologies(pszProfileName,szValue)");
        }
        int nIndex = 0;
        int[] nSymbologyId = {0};
        if (SktScanErrors.SKTSUCCESS(Result)) {
            while (true) {
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    break;
                }
                int nIndex2 = nIndex + 1;
                if (!SktScanErrors.SKTSUCCESS(EnumSymbology(nIndex, szValue[0], nSymbologyId))) {
                    break;
                }
                Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.addTriggerSymbology(nSymbologyId[0]), "m_DataEditingProfile.addTriggerSymbology(nSymbologyId)");
                nIndex = nIndex2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingContains(pszProfileName, szValue), "GetScanApiConfiguration().readDataEditingContains(pszProfileName,szValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.writeTriggerContains(szValue[0]), "m_DataEditingProfile.writeTriggerContains(szValue[0])");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingStartsBy(pszProfileName, szValue), "GetScanApiConfiguration().ReadDataEditingStartsWith(pszProfileName,szValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.writeTriggerStartsWith(szValue[0]), "m_DataEditingProfile.writeTriggerStartsWith(szValue)");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingEndsWith(pszProfileName, szValue), "GetScanApiConfiguration().ReadDataEditingEndsWith(pszProfileName,szValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.writeTriggerEndsWith(szValue[0]), "m_DataEditingProfile.writeTriggerEndsWith(szValue[0])");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingMinLength(pszProfileName, szValue), "GetScanApiConfiguration().ReadDataEditingMinLength(pszProfileName,szValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.writeTriggerMinimumSize(SktUtilities.ConvertStringToInt(szValue[0])), "m_DataEditingProfile.writeTriggerMinimumSize(SktUtilities.ConvertStringToInt(szValue[0]))");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingMaxLength(pszProfileName, szValue), "GetScanApiConfiguration().ReadDataEditingMaxLength(pszProfileName,szValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.writeTriggerMaximumSize(SktUtilities.ConvertStringToInt(szValue[0])), "m_DataEditingProfile.writeTriggerMaximumSize(SktUtilities.ConvertStringToInt(szValue[0]))");
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(GetScanApiConfiguration().ReadDataEditingOperation(pszProfileName, szValue), "GetScanApiConfiguration().ReadDataEditingOperation(pszProfileName,szValue)");
        if (!SktScanErrors.SKTSUCCESS(Result2) || szValue[0].length() <= 0) {
            return Result2;
        }
        return SktDebug.DBGSKT_EVAL(this.m_DataEditingProfile.parse(szValue[0]), "m_DataEditingProfile.parse(szValue[0])");
    }

    static long EnumSymbology(int nIndex, String symbologies, int[] pnSymbologyId) {
        long Result = 0;
        if (pnSymbologyId == null || symbologies == null) {
            Result = -18;
        } else {
            pnSymbologyId[0] = 48;
            String[] symbologiesArray = SktUtilities.split(symbologies, ";");
            if (nIndex < symbologiesArray.length) {
                int i = 0;
                while (true) {
                    if (i >= 48) {
                        break;
                    } else if (symbologiesArray[nIndex].equalsIgnoreCase(SktScanSymbologyNames[i])) {
                        pnSymbologyId[0] = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || pnSymbologyId[0] != 48) {
            return Result;
        }
        return -17;
    }

    /* access modifiers changed from: package-private */
    public SktConfigurationBase GetScanApiConfiguration() {
        return this.m_Configuration;
    }

    /* access modifiers changed from: package-private */
    public void SetScanApiConfiguration(SktConfigurationBase config) {
        this.m_Configuration = config;
    }

    /* access modifiers changed from: package-private */
    public long LoadDataEditingCurrentProfile() {
        long Result = 0;
        String[] pszCurrentProfile = new String[1];
        if (SktScanErrors.SKTSUCCESS(GetScanApiConfiguration().ReadCurrentProfile(pszCurrentProfile))) {
            Result = SktDebug.DBGSKT_EVAL(InitializeDataEditingProfile(pszCurrentProfile[0]), "InitializeDataEditingProfile(pszCurrentProfile[0])");
        }
        pszCurrentProfile[0] = null;
        return Result;
    }

    public static boolean Test() {
        boolean bResult = true;
        SktScanCore sktScanCore = new SktScanCore(new SktScanCore());
        SktScanAPI ScanApi = new SktScanAPI(new SktScanCore());
        SktTestTransport Transport = new SktTestTransport();
        SktDeviceInterface DeviceInterface = new SktDeviceInterface(2, Transport);
        TSktScanObject[] pScanObj = new TSktScanObject[1];
        SktPlatform.SktEvent[] pReadCompletionEvent = new SktPlatform.SktEvent[1];
        SktPlatform.SktEvent[] pWriteCompletionEvent = new SktPlatform.SktEvent[1];
        String DeviceGuid = null;
        Transport.SendData(false);
        if (1 == 1 && SktDebug.DBGSKT_EVAL(Transport.Open("test transport", false), "Transport.Open(\"test transport\",false)") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.m_MessageQueueLock.Initialize(), "ScanApi.m_MessageQueueLock.Initialize()") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.m_DeviceObjectsLock.Initialize(), "ScanApi.m_DeviceObjectsLock.Initialize()") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.m_MessageQueue.Initialize(), "ScanApi.m_MessageQueue.Initialize()") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.GetScanApiConfiguration().Initialize(), "ScanApi.GetScanApiConfiguration().Initialize()") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Open("test scanner", sktScanCore), "ScanApi.Open(\"test scanner\",new SktScanDevice())") != -17) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Open("test scanner", (ISktScanDevice) null), "ScanApi.Open(\"test scanner\",null)") != -18) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Close(sktScanCore), "ScanApi.Close(new SktScanDevice())") != -11) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.NotifyDeviceArrival(DeviceInterface), "ScanApi.NotifyDeviceArrival(DeviceInterface)") != 0) {
            bResult = false;
        }
        int nCount = 0;
        int Count = 0;
        for (boolean bContinue = bResult; bContinue; bContinue = bResult) {
            nCount++;
            SktScanTypes.TSktScanBoolean bPacketReady = new SktScanTypes.TSktScanBoolean(false);
            if (bResult) {
                long Result = DeviceInterface.DoIoOperation(bPacketReady, pReadCompletionEvent, pWriteCompletionEvent, (SktPlatform.SktEvent[]) null);
                if (Result != (Result == 3 ? 3 : 0)) {
                    bResult = false;
                }
            }
            if (bPacketReady.getValue()) {
                nCount = 0;
                Count++;
                if (Count == 15) {
                    Count = 14;
                }
                if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.NotifyDataFromDeviceInterface(DeviceInterface), "ScanApi.NotifyDataFromDeviceInterface(DeviceInterface)") != 0) {
                    bResult = false;
                }
            }
            if (nCount == 4) {
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.WaitForQueueNotEmpty(500), "ScanApi.WaitForQueueNotEmpty(500)") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.RemoveFromQueue(pScanObj), "ScanApi.RemoveFromQueue(pScanObj)") != 0) {
            bResult = false;
        }
        if (bResult) {
            if (pScanObj[0].Msg.MsgID == 1) {
                DeviceGuid = pScanObj[0].Msg.Device.Guid;
            } else {
                SktDebug.DBGSKT_MSG(4, "Receive something else than Insertion (0x" + Integer.toHexString(pScanObj[0].Msg.MsgID) + ")");
                bResult = false;
            }
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Open(DeviceGuid, sktScanCore), "ScanApi.Open(DeviceGuid,hDevice)") != 0) {
            bResult = false;
        }
        if (bResult) {
            while (true) {
                long Result2 = ScanApi.WaitForQueueNotEmpty(500);
                if (!SktScanErrors.SKTSUCCESS(Result2) || Result2 == 1) {
                    break;
                } else if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.RemoveFromQueue(pScanObj), "ScanApi.RemoveFromQueue(pScanObj)") != 0) {
                    bResult = false;
                }
            }
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Close(sktScanCore), "ScanApi.Close(hDevice)") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Close(sktScanCore), "ScanApi.Close(hDevice)") != 2) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.NotifyDeviceRemoval(DeviceInterface), "ScanApi.NotifyDeviceRemoval(DeviceInterface)") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.WaitForQueueNotEmpty(500), "ScanApi.WaitForQueueNotEmpty(500)") != 0) {
            bResult = false;
        }
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.RemoveFromQueue(pScanObj), "ScanApi.RemoveFromQueue(pScanObj)") != 0) {
            bResult = false;
        }
        if (bResult && pScanObj[0].Msg.MsgID != 2) {
            SktDebug.DBGSKT_MSG(4, "Receive something else than Device Removal (0x" + Integer.toHexString(pScanObj[0].Msg.MsgID) + ")");
            bResult = false;
        }
        ISktScanDevice hOtherScannerHandle = new SktScanCore(new SktScanCore());
        if (bResult && SktDebug.DBGSKT_EVAL(ScanApi.Open(DeviceGuid, hOtherScannerHandle), "ScanApi.Open(DeviceGuid,hOtherScannerHandle)") != -17) {
            bResult = false;
        }
        if (!bResult || SktDebug.DBGSKT_EVAL(ScanApi.Close(sktScanCore), "ScanApi.Close(hDevice)") == -11) {
            return bResult;
        }
        return false;
    }
}
