package com.SocketMobile.ScanAPI;

public interface ISktScanProperty {

    public interface deviceGeneralGroup {
        public static final int kSktScanIdDeviceApplyConfig = 6;
        public static final int kSktScanIdDeviceCapabilities = 9;
        public static final int kSktScanIdDeviceChangeId = 10;
        public static final int kSktScanIdDeviceDataFormat = 11;
        public static final int kSktScanIdDeviceInterfaceVersion = 1;
        public static final int kSktScanIdDevicePostamble = 8;
        public static final int kSktScanIdDevicePreamble = 7;
        public static final int kSktScanIdDeviceSpecific = 3;
        public static final int kSktScanIdDeviceSymbology = 4;
        public static final int kSktScanIdDeviceTrigger = 5;
        public static final int kSktScanIdDeviceType = 2;
        public static final int kSktScanIdDeviceVersion = 0;
        public static final int kSktScanLastDeviceGeneralGroup = 12;
    }

    public interface deviceLocalFunctionsGroup {
        public static final int kSktScanIdDeviceBatteryLevel = 11;
        public static final int kSktScanIdDeviceBluetoothAddress = 13;
        public static final int kSktScanIdDeviceButtonsStatus = 6;
        public static final int kSktScanIdDeviceConnectReason = 20;
        public static final int kSktScanIdDeviceConnectionBeepConfig = 23;
        public static final int kSktScanIdDeviceDataConfirmation = 10;
        public static final int kSktScanIdDeviceDataStore = 18;
        public static final int kSktScanIdDeviceDeletePairingBonding = 3;
        public static final int kSktScanIdDeviceDisconnect = 17;
        public static final int kSktScanIdDeviceFlash = 24;
        public static final int kSktScanIdDeviceFriendlyName = 0;
        public static final int kSktScanIdDeviceLocalAcknowledgement = 9;
        public static final int kSktScanIdDeviceLocalDecodeAction = 12;
        public static final int kSktScanIdDeviceNotifications = 19;
        public static final int kSktScanIdDeviceOverlayView = 25;
        public static final int kSktScanIdDevicePinCode = 2;
        public static final int kSktScanIdDevicePowerState = 21;
        public static final int kSktScanIdDeviceProfileConfig = 16;
        public static final int kSktScanIdDeviceRestoreFactoryDefaults = 4;
        public static final int kSktScanIdDeviceRumbleConfig = 15;
        public static final int kSktScanIdDeviceSecurityMode = 1;
        public static final int kSktScanIdDeviceSetPowerOff = 5;
        public static final int kSktScanIdDeviceSoundConfig = 7;
        public static final int kSktScanIdDeviceStandConfig = 26;
        public static final int kSktScanIdDeviceStartUpRoleSPP = 22;
        public static final int kSktScanIdDeviceStatisticCounters = 14;
        public static final int kSktScanIdDeviceTimers = 8;
        public static final int kSktScanLastDeviceLocalFunctions = 27;
    }

    public interface groupId {
        public static final int kSktScanGroupGeneral = 0;
        public static final int kSktScanGroupLocalFunctions = 1;
    }

    public interface propId {
        public static final int kSktScanPropIdAbort = -2146435072;
        public static final int kSktScanPropIdApplyConfigDevice = 1048582;
        public static final int kSktScanPropIdBatteryLevelDevice = 65803;
        public static final int kSktScanPropIdBluetoothAddressDevice = 65805;
        public static final int kSktScanPropIdButtonsStatusDevice = 65798;
        public static final int kSktScanPropIdCapabilitiesDevice = 2162697;
        public static final int kSktScanPropIdChangeIdDevice = 65546;
        public static final int kSktScanPropIdConfiguration = -2141913085;
        public static final int kSktScanPropIdConnectReasonDevice = 65812;
        public static final int kSktScanPropIdConnectionBeepConfigDevice = 131351;
        public static final int kSktScanPropIdDataConfirmationAction = -2147287035;
        public static final int kSktScanPropIdDataConfirmationDevice = 1245450;
        public static final int kSktScanPropIdDataConfirmationMode = -2147352572;
        public static final int kSktScanPropIdDataEditingCurrentProfile = -2147155958;
        public static final int kSktScanPropIdDataEditingImportExport = -2141913070;
        public static final int kSktScanPropIdDataEditingOperation = -2141913071;
        public static final int kSktScanPropIdDataEditingProfile = -2147155959;
        public static final int kSktScanPropIdDataEditingTriggerContains = -2141913072;
        public static final int kSktScanPropIdDataEditingTriggerEndsWith = -2141913073;
        public static final int kSktScanPropIdDataEditingTriggerMaxLength = -2141913075;
        public static final int kSktScanPropIdDataEditingTriggerMinLength = -2141913076;
        public static final int kSktScanPropIdDataEditingTriggerStartsBy = -2141913074;
        public static final int kSktScanPropIdDataEditingTriggerSymbologies = -2141913077;
        public static final int kSktScanPropIdDataFormatDevice = 131083;
        public static final int kSktScanPropIdDataStoreDevice = 4456722;
        public static final int kSktScanPropIdDeletePairingBondingDevice = 1179907;
        public static final int kSktScanPropIdDeviceSpecific = 4456451;
        public static final int kSktScanPropIdDeviceType = 65538;
        public static final int kSktScanPropIdDisconnectDevice = 1179921;
        public static final int kSktScanPropIdFlashDevice = 131352;
        public static final int kSktScanPropIdFriendlyNameDevice = 327936;
        public static final int kSktScanPropIdInterfaceVersion = -2147418110;
        public static final int kSktScanPropIdLocalAcknowledgmentDevice = 131337;
        public static final int kSktScanPropIdLocalDecodeActionDevice = 131340;
        public static final int kSktScanPropIdMonitorMode = -2145124346;
        public static final int kSktScanPropIdNotificationsDevice = 196883;
        public static final int kSktScanPropIdOverlayViewDevice = 590105;
        public static final int kSktScanPropIdPinCodeDevice = 1376514;
        public static final int kSktScanPropIdPostambleDevice = 327688;
        public static final int kSktScanPropIdPowerStateDevice = 65813;
        public static final int kSktScanPropIdPreambleDevice = 327687;
        public static final int kSktScanPropIdProfileConfigDevice = 262416;
        public static final int kSktScanPropIdRestoreFactoryDefaultsDevice = 1048836;
        public static final int kSktScanPropIdRumbleConfigDevice = 2359567;
        public static final int kSktScanPropIdSecurityModeDevice = 131329;
        public static final int kSktScanPropIdSetPowerOffDevice = 1048837;
        public static final int kSktScanPropIdSoftScanStatus = -2145255417;
        public static final int kSktScanPropIdSoundConfigDevice = 2359559;
        public static final int kSktScanPropIdStandConfigDevice = 196889;
        public static final int kSktScanPropIdStartUpRoleSPPDevice = 131350;
        public static final int kSktScanPropIdStatisticCountersDevice = 65806;
        public static final int kSktScanPropIdSymbologyDevice = 7798788;
        public static final int kSktScanPropIdTimersDevice = 262408;
        public static final int kSktScanPropIdTriggerDevice = 1179653;
        public static final int kSktScanPropIdVersion = -2147418111;
        public static final int kSktScanPropIdVersionDevice = 65536;
    }

    public interface scanAPIgroup {
        public static final int kSktScanIdAbort = 0;
        public static final int kSktScanIdConfiguration = 3;
        public static final int kSktScanIdDataConfirmationAction = 5;
        public static final int kSktScanIdDataConfirmationMode = 4;
        public static final int kSktScanIdDataEditingCurrentProfile = 10;
        public static final int kSktScanIdDataEditingImportExport = 18;
        public static final int kSktScanIdDataEditingOperation = 17;
        public static final int kSktScanIdDataEditingProfile = 9;
        public static final int kSktScanIdDataEditingTriggerContains = 16;
        public static final int kSktScanIdDataEditingTriggerEndsWith = 15;
        public static final int kSktScanIdDataEditingTriggerMaxLength = 13;
        public static final int kSktScanIdDataEditingTriggerMinLength = 12;
        public static final int kSktScanIdDataEditingTriggerStartsBy = 14;
        public static final int kSktScanIdDataEditingTriggerSymbologies = 11;
        public static final int kSktScanIdInterfaceVersion = 2;
        public static final int kSktScanIdMonitorMode = 6;
        public static final int kSktScanIdSoftScanStatus = 7;
        public static final int kSktScanIdSymbologyInfo = 8;
        public static final int kSktScanIdVersion = 1;
        public static final int kSktScanLastGeneralGroup = 19;
    }

    public interface shift {
        public static final int GETTYPE = 20;
        public static final int GROUPID = 8;
        public static final int PROPID = 0;
        public static final int SCANAPI = 31;
        public static final int SETTYPE = 16;
    }

    public interface types {
        public static final byte kSktScanPropTypeArray = 4;
        public static final byte kSktScanPropTypeByte = 2;
        public static final byte kSktScanPropTypeEnum = 8;
        public static final byte kSktScanPropTypeLastType = 10;
        public static final byte kSktScanPropTypeNone = 0;
        public static final byte kSktScanPropTypeNotApplicable = 1;
        public static final byte kSktScanPropTypeObject = 9;
        public static final byte kSktScanPropTypeString = 5;
        public static final byte kSktScanPropTypeSymbology = 7;
        public static final byte kSktScanPropTypeUlong = 3;
        public static final byte kSktScanPropTypeVersion = 6;
    }

    public interface values {

        public interface capabilityGeneral {
            public static final int kSktScanCapabilityGeneralLocalFunctions = 1;
        }

        public interface capabilityGroup {
            public static final int kSktScanCapabilityGeneral = 1;
            public static final int kSktScanCapabilityLocalFunctions = 2;
        }

        public interface capabilityLocalFunctions {
            public static final int kSktScanCapabilityLocalFunctionChangeID = 2;
            public static final int kSktScanCapabilityLocalFunctionRumble = 1;
        }

        public interface configuration {
            public static final String kSktScanConfigMonitorDbgChannel = "MonitorDbgChannel";
            public static final String kSktScanConfigMonitorDbgFileLineLevel = "MonitorDbgFileLineLevel";
            public static final String kSktScanConfigMonitorDbgLevel = "MonitorDbgLevel";
            public static final String kSktScanConfigPath = "ConfigPath";
            public static final String kSktScanConfigSerialComPort = "SerialPorts";
        }

        public interface confirmationMode {
            public static final char kSktScanDataConfirmationModeApp = '\u0003';
            public static final char kSktScanDataConfirmationModeDevice = '\u0001';
            public static final char kSktScanDataConfirmationModeOff = '\u0000';
            public static final char kSktScanDataConfirmationModeScanAPI = '\u0002';
        }

        public interface connectBeepConfig {
            public static final int kSktScanConnectBeepConfigBeep = 1;
            public static final int kSktScanConnectBeepConfigNoBeep = 0;
        }

        public interface connectReason {
            public static final int kSktScanConnectReasonBarcode = 2;
            public static final int kSktScanConnectReasonHostChange = 4;
            public static final int kSktScanConnectReasonPowerOn = 1;
            public static final int kSktScanConnectReasonRetry = 5;
            public static final int kSktScanConnectReasonUnknown = 0;
            public static final int kSktScanConnectReasonUserAction = 3;
        }

        public interface counters {
            public static final int kSktScanCounterAbnormalShutDowns = 25;
            public static final int kSktScanCounterBatteryChangeCount = 27;
            public static final int kSktScanCounterBatteryChargeCycles = 26;
            public static final int kSktScanCounterButtonLeftPress = 18;
            public static final int kSktScanCounterButtonLeftRelease = 19;
            public static final int kSktScanCounterButtonRightPress = 20;
            public static final int kSktScanCounterButtonRightRelease = 21;
            public static final int kSktScanCounterConnect = 1;
            public static final int kSktScanCounterDecodedBytes = 24;
            public static final int kSktScanCounterDisconnect = 2;
            public static final int kSktScanCounterFactoryReset = 4;
            public static final int kSktScanCounterLast = 31;
            public static final int kSktScanCounterPowerButtonDown = 9;
            public static final int kSktScanCounterPowerButtonUp = 8;
            public static final int kSktScanCounterPowerOff = 29;
            public static final int kSktScanCounterPowerOn = 28;
            public static final int kSktScanCounterPowerOnACTimeInMinutes = 10;
            public static final int kSktScanCounterPowerOnBatTimeInMinutes = 11;
            public static final int kSktScanCounterRfcommReceive = 13;
            public static final int kSktScanCounterRfcommReceiveDiscarded = 14;
            public static final int kSktScanCounterRfcommSend = 12;
            public static final int kSktScanCounterRingUnitAttachEvents = 23;
            public static final int kSktScanCounterRingUnitDetachEvents = 22;
            public static final int kSktScanCounterScanButtonDown = 7;
            public static final int kSktScanCounterScanButtonUp = 6;
            public static final int kSktScanCounterScans = 5;
            public static final int kSktScanCounterStandModeChange = 30;
            public static final int kSktScanCounterUartReceive = 16;
            public static final int kSktScanCounterUartReceiveDiscarded = 17;
            public static final int kSktScanCounterUartSend = 15;
            public static final int kSktScanCounterUnbond = 3;
            public static final int kSktScanCounterUnknown = 0;
        }

        public interface dataConfirmation {
            public static final int kSktScanDataConfirmationBeepBad = 2;
            public static final int kSktScanDataConfirmationBeepGood = 1;
            public static final int kSktScanDataConfirmationBeepNone = 0;
            public static final int kSktScanDataConfirmationLedGreen = 1;
            public static final int kSktScanDataConfirmationLedNone = 0;
            public static final int kSktScanDataConfirmationLedRed = 2;
            public static final int kSktScanDataConfirmationRumbleBad = 2;
            public static final int kSktScanDataConfirmationRumbleGood = 1;
            public static final int kSktScanDataConfirmationRumbleNone = 0;
        }

        public interface dataFormat {
            public static final int kSktScanDataFormatPacket = 1;
            public static final int kSktScanDataFormatRaw = 0;
        }

        public interface deletePairing {
            public static final int kSktScanDeletePairingAll = 1;
            public static final int kSktScanDeletePairingCurrent = 0;
        }

        public interface deviceDataAcknowledgment {
            public static final char kSktScanDeviceDataAcknowledgmentOff = '\u0000';
            public static final char kSktScanDeviceDataAcknowledgmentOn = '\u0001';
        }

        public interface disconnect {
            public static final int kSktScanDisconnectDisableRadio = 1;
            public static final int kSktScanDisconnectStartProfile = 0;
        }

        public interface enableordisableSoftScan {
            public static final char kSktScanDisableSoftScan = '\u0000';
            public static final char kSktScanEnableSoftScan = '\u0001';
            public static final char kSktScanSoftScanNotSupported = '\u0002';
            public static final char kSktScanSoftScanSupported = '\u0003';
        }

        public interface localDecodeAction {
            public static final int kSktScanLocalDecodeActionBeep = 1;
            public static final int kSktScanLocalDecodeActionFlash = 2;
            public static final int kSktScanLocalDecodeActionNone = 0;
            public static final int kSktScanLocalDecodeActionRumble = 4;
        }

        public interface monitor {
            public static final int kSktScanMonitorDbgChannel = 2;
            public static final int kSktScanMonitorDbgFileLineLevel = 3;
            public static final int kSktScanMonitorDbgLevel = 1;
            public static final int kSktScanMonitorLast = 4;
        }

        public interface notifications {
            public static final int kSktScanNotificationsBatteryLevelChange = 32;
            public static final int kSktScanNotificationsPowerButtonPress = 4;
            public static final int kSktScanNotificationsPowerButtonRelease = 8;
            public static final int kSktScanNotificationsPowerState = 16;
            public static final int kSktScanNotificationsScanButtonPress = 1;
            public static final int kSktScanNotificationsScanButtonRelease = 2;
        }

        public interface powerStates {
            public static final int kSktScanPowerStatusOnAc = 4;
            public static final int kSktScanPowerStatusOnBattery = 1;
            public static final int kSktScanPowerStatusOnCradle = 2;
            public static final int kSktScanPowerStatusUnknown = 0;
        }

        public interface profile {
            public static final int kSktScanProfileSelectHid = 2;
            public static final int kSktScanProfileSelectNone = 0;
            public static final int kSktScanProfileSelectSpp = 1;
        }

        public interface profileConfig {
            public static final int kProfileConfigSize = 14;
            public static final int kSktScanProfileConfigAcceptor = 1;
            public static final int kSktScanProfileConfigInitiator = 2;
            public static final int kSktScanProfileConfigNone = 0;
        }

        public interface rumbleActionType {
            public static final int kSktScanRumbleActionTypeBadScan = 2;
            public static final int kSktScanRumbleActionTypeBadScanLocal = 3;
            public static final int kSktScanRumbleActionTypeGoodScan = 0;
            public static final int kSktScanRumbleActionTypeGoodScanLocal = 1;
        }

        public interface securityMode {
            public static final char kSktScanSecurityModeAuthentication = '\u0001';
            public static final char kSktScanSecurityModeAuthenticationEncryption = '\u0002';
            public static final char kSktScanSecurityModeNone = 0;
        }

        public interface softScanContext {
            public static final String kSktScanSoftScanCancelButton = "SoftScanCancelButton";
            public static final String kSktScanSoftScanContext = "SoftScanContext";
            public static final String kSktScanSoftScanDirectionText = "SoftScanDirectionText";
            public static final String kSktScanSoftScanFlashButton = "SoftScanFlashButton";
            public static final String kSktScanSoftScanFlashButtonId = "SoftScanFlashButtonId";
            public static final String kSktScanSoftScanLayoutId = "SoftScanLayoutId";
            public static final String kSktScanSoftScanViewFinderId = "SoftScanViewFinderId";
        }

        public interface softScanFlashConfig {
            public static final byte kSktScanFlashOff = 0;
            public static final byte kSktScanFlashOn = 1;
        }

        public interface soundActionType {
            public static final int kSktScanSoundActionTypeBadScan = 2;
            public static final int kSktScanSoundActionTypeBadScanLocal = 3;
            public static final int kSktScanSoundActionTypeGoodScan = 0;
            public static final int kSktScanSoundActionTypeGoodScanLocal = 1;
        }

        public interface soundFrequency {
            public static final int kSktScanSoundFrequencyHigh = 3;
            public static final int kSktScanSoundFrequencyLast = 4;
            public static final int kSktScanSoundFrequencyLow = 1;
            public static final int kSktScanSoundFrequencyMedium = 2;
            public static final int kSktScanSoundFrequencyNone = 0;
        }

        public interface standConfig {
            public static final int kSktScanStandConfigAutoMode = 3;
            public static final int kSktScanStandConfigDetectMode = 2;
            public static final int kSktScanStandConfigMobileMode = 0;
            public static final int kSktScanStandConfigStandMode = 1;
        }

        public interface startUpRoleSpp {
            public static final int kSktScanStartUpRolSPPLastRole = 1;
            public static final int kSktScanStartUpRoleSPPAcceptor = 0;
        }

        public interface timers {
            public static final int kSktScanTimerPowerOffConnected = 4;
            public static final int kSktScanTimerPowerOffDisconnected = 2;
            public static final int kSktScanTimerTriggerAutoLockTimeout = 1;
        }

        public interface trigger {
            public static final char kSktScanTriggerDisable = '\u0004';
            public static final char kSktScanTriggerEnable = '\u0003';
            public static final char kSktScanTriggerStart = '\u0001';
            public static final char kSktScanTriggerStop = '\u0002';
        }
    }

    ISktScanArray getArray();

    char getByte();

    Object getContext();

    int getID();

    ISktScanString getString();

    ISktScanSymbology getSymbology();

    int getType();

    long getUlong();

    ISktScanVersion getVersion();

    void setByte(char c);

    void setContext(Object obj);

    void setID(int i);

    void setObject(Object obj);

    void setType(int i);

    void setUlong(long j);
}
