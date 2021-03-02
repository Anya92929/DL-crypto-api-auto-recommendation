package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.ISktScanSymbology;
import com.SocketMobile.ScanAPI.SktScan;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktProtocolInterface;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktTranslator;

final class SktSsiProtocol extends SktProtocolInterface {
    static final char DEVICE_CONFIG_ACKNAK_MASK = '\u0004';
    static DataConfirmationToSsiIndicator[] DataConfirmationToSsiIndicatorTable = {new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 0), 0), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 0), 4), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 1), 5), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 1), 6), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 2, 0), 7), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 2), 8), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 2, 2), 9), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 0, 0), 10), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 1, 0), 11), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 0, 1), 12), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 1, 1), 13), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 0, 0), 14), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 2, 0), 15), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 0, 2), 16), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 2, 2), 17)};
    static DataConfirmationToSsiIndicator[] DataConfirmationToSsiIndicatorTableCrsV2 = {new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 0), 0), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 0), 1), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 1), 2), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 1), 3), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 2, 0), 7), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 2), 8), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 2, 2), 9), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 0, 0), 10), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 1, 0), 11), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 0, 1), 12), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 1, 1), 13), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 0, 0), 14), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 2, 0), 15), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 0, 2), 16), new DataConfirmationToSsiIndicator((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 2, 2), 17)};
    static final SupportedEngineVersion[] EngineVersions = {new SupportedEngineVersion(k655VersionString, 0), new SupportedEngineVersion(k955VersionString, 1), new SupportedEngineVersion(k955VersionString1, 1), new SupportedEngineVersion(k955VersionString2, 1), new SupportedEngineVersion(k955VersionString3, 1), new SupportedEngineVersion(kPL3307VersionString, 3)};
    static final long[] StatisticIdentifier = {9, 8, 7, 6, 12, 13, 14, 15, 16, 17, 11, 4, 18, 19, 20, 21, 22, 23};
    static final long[] StatisticIdentifierSeries8 = {28, 29, 7, 6, 12, 13, 14, 15, 16, 17, 11, 4, 18, 19, 20, 21, 22, 23};
    static TSktSsiSymbologyTranslator[] SymbologyTranslator = {new TSktSsiSymbologyTranslator((byte) 0, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 1, 35, 35, (char[]) null), new TSktSsiSymbologyTranslator((byte) 2, 45, kSsiAztec, (char[]) null), new TSktSsiSymbologyTranslator((byte) 3, 22, 83, (char[]) null), new TSktSsiSymbologyTranslator((byte) 4, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 5, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 6, kSsiSymbologyIdChinese2of5, kSsiChinese2of5, (char[]) null), new TSktSsiSymbologyTranslator((byte) 7, 2, 7, new char[]{24, 0, 25, 0}), new TSktSsiSymbologyTranslator((byte) 8, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 9, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 10, 12, 10, new char[]{28, 0, 29, 0}), new TSktSsiSymbologyTranslator((byte) 11, 1, 0, new char[]{18, 0, 19, 0}), new TSktSsiSymbologyTranslator((byte) 12, 19, 17, (char[]) null), new TSktSsiSymbologyTranslator((byte) 13, 21, 13, (char[]) null), new TSktSsiSymbologyTranslator((byte) 14, 7, 9, new char[]{26, 0, 27, 0}), new TSktSsiSymbologyTranslator((byte) 15, 3, 8, new char[]{209, 0, 210, 0}), new TSktSsiSymbologyTranslator((byte) 16, 27, kSsiDataMatrix, (char[]) null), new TSktSsiSymbologyTranslator((byte) 17, 36, 65535, (char[]) null), new TSktSsiSymbologyTranslator(ISktScanSymbology.C0165id.kSktScanSymbologyEan8, 10, 4, (char[]) null), new TSktSsiSymbologyTranslator((byte) 19, 11, 3, (char[]) null), new TSktSsiSymbologyTranslator((byte) 20, 15, 14, (char[]) null), new TSktSsiSymbologyTranslator((byte) 21, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 22, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 23, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 24, 48, kSsiGs1Databar, (char[]) null), new TSktSsiSymbologyTranslator((byte) 25, 49, kSsiGs1DatabarLimited, (char[]) null), new TSktSsiSymbologyTranslator((byte) 26, 50, kSsiGs1DatabarExpanded, (char[]) null), new TSktSsiSymbologyTranslator((byte) 27, 6, 6, new char[]{22, 0, 23, 0}), new TSktSsiSymbologyTranslator((byte) 28, 25, 84, (char[]) null), new TSktSsiSymbologyTranslator((byte) 29, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 30, kSsiSymbologyIdMatrix2of5, kSsiMatrix2of5, new char[]{241, 'k', 0, 241, 'l', 0}), new TSktSsiSymbologyTranslator((byte) 31, 37, kSsiMaxicode, (char[]) null), new TSktSsiSymbologyTranslator((byte) 32, 14, 11, new char[]{30, 0, 31, 0}), new TSktSsiSymbologyTranslator((byte) 33, 17, 15, (char[]) null), new TSktSsiSymbologyTranslator((byte) 34, 26, 227, (char[]) null), new TSktSsiSymbologyTranslator((byte) 35, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 36, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 37, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 38, 28, kSsiQRCode, (char[]) null), new TSktSsiSymbologyTranslator((byte) 39, 4, 5, new char[]{20, 0, 21, 0}), new TSktSsiSymbologyTranslator((byte) 40, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 41, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 42, 8, 1, (char[]) null), new TSktSsiSymbologyTranslator((byte) 43, 9, 2, (char[]) null), new TSktSsiSymbologyTranslator((byte) 44, 16, 12, (char[]) null), new TSktSsiSymbologyTranslator((byte) 45, 0, kSsiUspsIntelligentMail, (char[]) null), new TSktSsiSymbologyTranslator((byte) 46, 0, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 47, kSsiSymbologyIdHanXin, kSsiHanXin, (char[]) null), new TSktSsiSymbologyTranslator((byte) 39, 5, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 0, 13, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 0, 18, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 12, 19, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 26, 23, 85, (char[]) null), new TSktSsiSymbologyTranslator((byte) 0, 24, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 0, 40, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 38, 44, kSsiMicroQR, (char[]) null), new TSktSsiSymbologyTranslator((byte) 42, 72, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 43, 73, 65535, (char[]) null), new TSktSsiSymbologyTranslator(ISktScanSymbology.C0165id.kSktScanSymbologyEan8, 74, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 19, 75, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 44, 80, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 42, 136, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 43, 137, 65535, (char[]) null), new TSktSsiSymbologyTranslator(ISktScanSymbology.C0165id.kSktScanSymbologyEan8, 138, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 19, kSsiSymbologyIdEan135Supps, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 19, 144, 65535, (char[]) null), new TSktSsiSymbologyTranslator((byte) 0, 154, 65535, (char[]) null)};
    static final char[] k655VersionString = "PAAAXS00".toCharArray();
    static final char[] k955VersionString = {'N', 'B', 'R', 'S', 'Y', 'P', 'A', 'I', ' ', 'F', ' ', 153, ' ', '&', 172};
    static final char[] k955VersionString1 = {'C', 'B', 'R', 'S', 'Y', 'P', 'F', 'B', ' ', 'F', ' ', 152, ' ', '&', 172};
    static final char[] k955VersionString2 = {'N', 'B', 'R', 'S', 'Y', 'P', 'A', 'H', ' ', 'F', ' ', 153, ' ', '&', 172, 0};
    static final char[] k955VersionString3 = {'N', 'B', 'R', 'S', 'Y', 'P', 'A', 'H', ' ', 'F', ' ', 152, ' ', '&', 172, 0};
    public static final int kBlockMaxSize = 2048;
    public static final int kChs7DeviceMaxVersionSupportedNotIncluded = 1024;
    public static final int kChsDeviceVersionNoLongerSupportingFeatureBits = 773;
    public static final int kChsDeviceVersionNotRequiredToAck = 770;
    public static final int kChsDeviceVersionSupportingEngineRevision = 773;
    public static final int kChsDeviceVersionSupportingFeatureBits = 770;
    public static final int kMaxRetransmitCount = 2;
    public static final int kMaxSendDataBufferSize = 257;
    static final int kMin655EngineVersion = 4;
    public static final int kMinimumDelayBeforeRetry = 500;
    static final char[] kPL3307VersionString = "PAABLS00".toCharArray();
    static final int kProductTypeCHS = 1;
    static final int kProductTypeCHS8 = 3;
    static final int kProductTypeCRS = 2;
    static final int kSelfTestExBuildHighVersionOffset = 14;
    static final int kSelfTestExBuildLowVersionOffset = 15;
    static final int kSelfTestExCapabilities = 17;
    static final int kSelfTestExEngineVersion = 20;
    static final int kSelfTestExEngineVersionSize = 19;
    static final int kSelfTestExHourMinuteOffset = 6;
    static final int kSelfTestExMajorVersionOffset = 12;
    static final int kSelfTestExMinorVersionOffset = 13;
    static final int kSelfTestExMonthDayOffset = 4;
    static final int kSelfTestExProductTypeOffset = 11;
    static final int kSelfTestExSupportedFeaturesOffset = 16;
    static final int kSelfTestExYearOffset = 2;
    public static final char kSktCapabilityPrefixSuffixInEngine = '\u0000';
    public static final char kSktCapabilityPrefixSuffixInFriendlyName = '\u0001';
    public static final char kSktCapabilityPrefixSuffixSupport = '\u0003';
    public static final char kSktCapabilityProductSubType = '\u0002';
    public static final char kSktCapabilityScanAPIMinVersion = '\u0001';
    public static final int kSsiAimDuration = 237;
    public static final int kSsiAllParameters = 254;
    public static final int kSsiAztec = 61758;
    public static final int kSsiBeepAfterGoodDecode = 56;
    public static final int kSsiBeepCodeNone = 255;
    public static final int kSsiBeeperFrequencyAdjustment = 61585;
    public static final int kSsiBeeperTone = 145;
    public static final int kSsiBeeperVolume = 140;
    public static final int kSsiBidirectionalRedundancy = 67;
    public static final byte kSsiChecksumSize = 2;
    public static final int kSsiChinese2of5 = 61592;
    public static final int kSsiCodabar = 7;
    public static final int kSsiCodabarLengthL1 = 24;
    public static final int kSsiCodabarLengthL2 = 25;
    public static final int kSsiCode11 = 10;
    public static final int kSsiCode11LengthL1 = 28;
    public static final int kSsiCode11LengthL2 = 29;
    public static final int kSsiCode128 = 8;
    public static final int kSsiCode128Isbt128 = 84;
    public static final int kSsiCode128LengthL1 = 209;
    public static final int kSsiCode128LengthL2 = 210;
    public static final int kSsiCode128UccEan128 = 14;
    public static final int kSsiCode39 = 0;
    public static final int kSsiCode39FullAscii = 17;
    public static final int kSsiCode39LengthL1 = 18;
    public static final int kSsiCode39LengthL2 = 19;
    public static final int kSsiCode39Trioptic = 13;
    public static final int kSsiCode93 = 9;
    public static final int kSsiCode93LengthL1 = 26;
    public static final int kSsiCode93LengthL2 = 27;
    public static final int kSsiDataMatrix = 61476;
    public static final int kSsiDataOptionDataTransmissionFormat = 235;
    public static final int kSsiDataOptionPrefix = 105;
    public static final int kSsiDataOptionSuffix1 = 104;
    public static final int kSsiDataOptionSuffix2 = 106;
    public static final int kSsiDataTransmissionFormatAsIs = 0;
    public static final int kSsiDataTransmissionFormatPrefix = 4;
    public static final int kSsiDataTransmissionFormatPrefixSuffix1 = 5;
    public static final int kSsiDataTransmissionFormatPrefixSuffix1Suffix2 = 7;
    public static final int kSsiDataTransmissionFormatPrefixSuffix2 = 6;
    public static final int kSsiDataTransmissionFormatSuffix1 = 1;
    public static final int kSsiDataTransmissionFormatSuffix1Suffix2 = 3;
    public static final int kSsiDataTransmissionFormatSuffix2 = 2;
    public static final int kSsiDiscrete2of5 = 5;
    public static final int kSsiDiscrete2of5LengthL1 = 20;
    public static final int kSsiDiscrete2of5LengthL2 = 21;
    static final int kSsiEngine3307 = 3;
    static final int kSsiEngine655 = 0;
    static final int kSsiEngine955 = 1;
    static final int kSsiEngine965 = 2;
    public static final int kSsiEventReportingDecodeEvent = 61440;
    public static final int kSsiFriendlyName = 1;
    public static final int kSsiGs1Databar = 61522;
    public static final int kSsiGs1DatabarExpanded = 61524;
    public static final int kSsiGs1DatabarLimited = 61523;
    public static final int kSsiHanXin = 16254095;
    public static final byte kSsiHeaderSizeWithoutPayload = 4;
    public static final int kSsiInterleaved2of5 = 6;
    public static final int kSsiInterleaved2of5LengthL1 = 22;
    public static final int kSsiInterleaved2of5LengthL2 = 23;
    public static final int kSsiLaserOnTime = 136;
    public static final int kSsiLinearCodeTypeSecurityLevel = 78;
    public static final int kSsiLocalDecodeActionBeep = 1;
    public static final int kSsiLocalDecodeActionBeepFlash = 3;
    public static final int kSsiLocalDecodeActionBeepFlashRumble = 7;
    public static final int kSsiLocalDecodeActionBeepRumble = 5;
    public static final int kSsiLocalDecodeActionFlash = 2;
    public static final int kSsiLocalDecodeActionFlashRumble = 6;
    public static final int kSsiLocalDecodeActionNone = 0;
    public static final int kSsiLocalDecodeActionRumble = 4;
    public static final int kSsiMatrix2of5 = 61802;
    public static final int kSsiMatrix2of5LengthL1 = 61803;
    public static final int kSsiMatrix2of5LengthL2 = 61804;
    static final int kSsiMaxFriendlyNameLength = 28;
    public static final int kSsiMaxicode = 61478;
    public static final int kSsiMicroPDF417 = 227;
    public static final int kSsiMicroQR = 61757;
    public static final int kSsiMsi = 11;
    public static final int kSsiMsiLengthL1 = 30;
    public static final int kSsiMsiLengthL2 = 31;
    public static final int kSsiNakReasonBadContext = 2;
    public static final int kSsiNakReasonDenied = 6;
    public static final int kSsiNakReasonResend = 1;
    public static final byte kSsiNormalNakSize = 5;
    public static final int kSsiNotSupported = 65535;
    public static final int kSsiOpcodeAimOff = 196;
    public static final int kSsiOpcodeAimOn = 197;
    public static final int kSsiOpcodeBeep = 230;
    public static final int kSsiOpcodeCmdAck = 208;
    public static final int kSsiOpcodeCmdNak = 209;
    public static final int kSsiOpcodeCustomdefaults = 18;
    public static final int kSsiOpcodeDecodeData = 243;
    public static final int kSsiOpcodeEvent = 246;
    public static final int kSsiOpcodeLedOff = 232;
    public static final int kSsiOpcodeLedOn = 231;
    public static final int kSsiOpcodeParamDefaults = 200;
    public static final int kSsiOpcodeParamRequest = 199;
    public static final int kSsiOpcodeParamSend = 198;
    public static final int kSsiOpcodeReplyRevision = 164;
    public static final int kSsiOpcodeRequestRevision = 163;
    public static final int kSsiOpcodeScanDisable = 234;
    public static final int kSsiOpcodeScanEnable = 233;
    public static final int kSsiOpcodeSleep = 235;
    public static final int kSsiOpcodeStartDecode = 228;
    public static final int kSsiOpcodeStopDecode = 229;
    public static final int kSsiPDF417 = 15;
    static final int kSsiParamSendParamDataOffset = 1;
    public static final int kSsiParameterScanning = 236;
    public static final int kSsiPostamble = 3;
    public static final byte kSsiPostamble1Offset = 4;
    public static final byte kSsiPostamble2Offset = 6;
    static final int kSsiPostambleDelimiter = 254;
    public static final int kSsiPowerMode = 128;
    public static final int kSsiPreamble = 2;
    static final int kSsiPreambleDelimiter = 255;
    public static final byte kSsiPreambleOffset = 4;
    public static final int kSsiQRCode = 61477;
    public static final int kSsiScanAngle = 191;
    public static final int kSsiSerialInterfaceBaudrate = 156;
    public static final int kSsiSerialInterfaceDecodeDataPacketFormat = 238;
    public static final int kSsiSerialInterfaceHostCharacterTimeout = 239;
    public static final int kSsiSerialInterfaceHostSerialResponseTimeout = 155;
    public static final int kSsiSerialInterfaceIntercharacterDelay = 110;
    public static final int kSsiSerialInterfaceParity = 158;
    public static final int kSsiSerialInterfaceSoftwareHandshaking = 159;
    public static final int kSsiSerialInterfaceStopBitSelect = 157;
    public static final byte kSsiSourceDecoder = 0;
    public static final byte kSsiSourceHost = 4;
    public static final byte kSsiStatusContinuous = 2;
    public static final byte kSsiStatusNormal = 0;
    public static final byte kSsiStatusPermanent = 8;
    public static final byte kSsiStatusRetransmit = 1;
    public static final int kSsiSubCmdAutoOffTimersInquiry = 290;
    public static final int kSsiSubCmdAutoOffTimersResponse = 291;
    public static final int kSsiSubCmdBatteryStateExInquiry = 273;
    public static final int kSsiSubCmdBatteryStateInquiry = 258;
    public static final int kSsiSubCmdBatteryStateResponse = 259;
    public static final int kSsiSubCmdBluetoothDeviceAddressInquiry = 306;
    public static final int kSsiSubCmdBluetoothDeviceAddressResponse = 307;
    public static final int kSsiSubCmdButtonResponse = 265;
    public static final int kSsiSubCmdButtonStatusInquiry = 268;
    public static final int kSsiSubCmdConfigurationModeInquiry = 295;
    public static final int kSsiSubCmdConfigurationModeResponse = 296;
    public static final int kSsiSubCmdDataFormatInquiry = 309;
    public static final int kSsiSubCmdDataFormatResponse = 310;
    public static final int kSsiSubCmdDeletePairingBonding = 6;
    public static final int kSsiSubCmdDeveloperDataInquiry = 327;
    public static final int kSsiSubCmdDeveloperDataResponse = 328;
    public static final int kSsiSubCmdDeviceBatteryState2Response = 336;
    public static final int kSsiSubCmdDeviceBatteryStateInquiry2 = 335;
    public static final int kSsiSubCmdDeviceConfigurationInquiry = 279;
    public static final int kSsiSubCmdDeviceConfigurationResponse = 280;
    public static final int kSsiSubCmdDeviceDetailsInquiry = 333;
    public static final int kSsiSubCmdDeviceDetailsResponse = 334;
    public static final int kSsiSubCmdFriendlyNameInquiry = 262;
    public static final int kSsiSubCmdFriendlyNameResponse = 263;
    public static final int kSsiSubCmdLocalDecodeActionInquiry = 301;
    public static final int kSsiSubCmdLocalDecodeActionResponse = 302;
    public static final int kSsiSubCmdModemStatusModeInquiry = 277;
    public static final int kSsiSubCmdModemStatusModeResponse = 278;
    public static final int kSsiSubCmdPicControl = 271;
    public static final int kSsiSubCmdRadioPowerInquiry = 287;
    public static final int kSsiSubCmdRadioPowerResponse = 288;
    public static final int kSsiSubCmdResetStateInquiry = 274;
    public static final int kSsiSubCmdResetStateResponse = 275;
    public static final int kSsiSubCmdRestoreFactoryDefaults = 240;
    public static final int kSsiSubCmdRoleConfigurationInquiry = 298;
    public static final int kSsiSubCmdRoleConfigurationResponse = 299;
    public static final byte kSsiSubCmdRumbleActionTypeBadScanHost = 4;
    public static final byte kSsiSubCmdRumbleActionTypeBadScanLocal = 3;
    public static final byte kSsiSubCmdRumbleActionTypeGoodScanHost = 2;
    public static final byte kSsiSubCmdRumbleActionTypeGoodScanLocal = 1;
    public static final byte kSsiSubCmdRumbleActionTypeNone = 0;
    public static final int kSsiSubCmdRumbleConfigurationInquiry = 303;
    public static final int kSsiSubCmdRumbleConfigurationResponse = 304;
    public static final int kSsiSubCmdScanAPIInvalidCommandToReplyNotSupported = 4095;
    public static final int kSsiSubCmdScannerDataWrapper = 272;
    public static final byte kSsiSubCmdSecurityModeAuthentication = 1;
    public static final byte kSsiSubCmdSecurityModeAuthenticationEncryption = 2;
    public static final byte kSsiSubCmdSecurityModeAuthenticationEncryptionSingleBDAddress = 3;
    public static final int kSsiSubCmdSecurityModeInquiry = 269;
    public static final byte kSsiSubCmdSecurityModeNone = 0;
    public static final int kSsiSubCmdSecurityModeResponse = 270;
    public static final int kSsiSubCmdSelfTestExInquiry = 266;
    public static final int kSsiSubCmdSelfTestExResponse = 267;
    public static final int kSsiSubCmdSelfTestInquiry = 260;
    public static final int kSsiSubCmdSelfTestResponse = 261;
    public static final int kSsiSubCmdSetAutoOffTimers = 289;
    public static final int kSsiSubCmdSetClassOfDevice = 1;
    public static final int kSsiSubCmdSetConfigurationMode = 294;
    public static final int kSsiSubCmdSetDataFormat = 308;
    public static final int kSsiSubCmdSetDeveloperData = 326;
    public static final int kSsiSubCmdSetDeviceConfiguration = 7;
    public static final int kSsiSubCmdSetFriendlyName = 2;
    public static final int kSsiSubCmdSetIndicator = 257;
    public static final int kSsiSubCmdSetLocalDecodeAction = 300;
    public static final int kSsiSubCmdSetModemStatusMode = 276;
    public static final int kSsiSubCmdSetPinCode = 5;
    public static final int kSsiSubCmdSetPowerOff = 254;
    public static final int kSsiSubCmdSetRadioPower = 286;
    public static final int kSsiSubCmdSetRoleConfiguration = 297;
    public static final int kSsiSubCmdSetRumbleConfiguration = 305;
    public static final int kSsiSubCmdSetSecurityMode = 4;
    public static final int kSsiSubCmdSetServiceName = 3;
    public static final int kSsiSubCmdSetSniffModeParameters = 8;
    public static final int kSsiSubCmdSetSoundConfiguration = 281;
    public static final int kSsiSubCmdSize = 2;
    public static final byte kSsiSubCmdSoundActionTypeBadScan = 5;
    public static final byte kSsiSubCmdSoundActionTypeConnected = 2;
    public static final byte kSsiSubCmdSoundActionTypeDisconnected = 3;
    public static final byte kSsiSubCmdSoundActionTypeDisconnectedState = 10;
    public static final byte kSsiSubCmdSoundActionTypeFactoryReset = 9;
    public static final byte kSsiSubCmdSoundActionTypeFactoryResetStart = 11;
    public static final byte kSsiSubCmdSoundActionTypeGoodScan = 4;
    public static final byte kSsiSubCmdSoundActionTypeGoodScanLocal = 14;
    public static final byte kSsiSubCmdSoundActionTypeInitiatorNoConnect = 12;
    public static final byte kSsiSubCmdSoundActionTypePanic = 8;
    public static final byte kSsiSubCmdSoundActionTypePowerOff = 7;
    public static final byte kSsiSubCmdSoundActionTypePowerOn = 6;
    public static final byte kSsiSubCmdSoundActionTypeSpecialBarcodeAccept = 13;
    public static final int kSsiSubCmdSoundConfigurationInquiry = 282;
    public static final int kSsiSubCmdSoundConfigurationResponse = 283;
    public static final int kSsiSubCmdStatisticInquiry = 292;
    public static final int kSsiSubCmdStatisticResponse = 293;
    public static final byte kSsiSubCmdSupportedFeatureHid = 2;
    public static final byte kSsiSubCmdSupportedFeatureRumble = 1;
    public static final byte kSsiSubCmdSupportedFeatureSpp = 4;
    public static final int kSsiSymbologyIdAustralianPostal = 35;
    public static final int kSsiSymbologyIdAztec = 45;
    public static final int kSsiSymbologyIdBooklandEan = 22;
    public static final int kSsiSymbologyIdChinese2of5 = 114;
    public static final int kSsiSymbologyIdCodabar = 2;
    public static final int kSsiSymbologyIdCode11 = 12;
    public static final int kSsiSymbologyIdCode128 = 3;
    public static final int kSsiSymbologyIdCode128Isbt = 25;
    public static final int kSsiSymbologyIdCode16K = 18;
    public static final int kSsiSymbologyIdCode39 = 1;
    public static final int kSsiSymbologyIdCode39Extended = 19;
    public static final int kSsiSymbologyIdCode49 = 13;
    public static final int kSsiSymbologyIdCode93 = 7;
    public static final int kSsiSymbologyIdCouponCode = 23;
    public static final int kSsiSymbologyIdDataMatrix = 27;
    public static final int kSsiSymbologyIdDiscrete2of5 = 4;
    public static final int kSsiSymbologyIdDutchPostal = 36;
    public static final int kSsiSymbologyIdEan128 = 15;
    public static final int kSsiSymbologyIdEan13 = 11;
    public static final int kSsiSymbologyIdEan132Supps = 75;
    public static final int kSsiSymbologyIdEan135Supps = 139;
    public static final int kSsiSymbologyIdEan8 = 10;
    public static final int kSsiSymbologyIdEan82Supps = 74;
    public static final int kSsiSymbologyIdEan85Supps = 138;
    public static final int kSsiSymbologyIdGs1Databar = 48;
    public static final int kSsiSymbologyIdGs1DatabarExpanded = 50;
    public static final int kSsiSymbologyIdGs1DatabarLimited = 49;
    public static final int kSsiSymbologyIdHanXin = 183;
    public static final int kSsiSymbologyIdIata2of5 = 5;
    public static final int kSsiSymbologyIdInterleaved2of5 = 6;
    public static final int kSsiSymbologyIdMacroMicroPDF = 154;
    public static final int kSsiSymbologyIdMacroPDF = 40;
    public static final int kSsiSymbologyIdMatrix2of5 = 113;
    public static final int kSsiSymbologyIdMaxicode = 37;
    public static final int kSsiSymbologyIdMicroQRCode = 44;
    public static final int kSsiSymbologyIdMsi = 14;
    public static final int kSsiSymbologyIdNW7 = 24;
    public static final int kSsiSymbologyIdNotApplicable = 0;
    public static final int kSsiSymbologyIdPdf417 = 17;
    public static final int kSsiSymbologyIdPdf417Micro = 26;
    public static final int kSsiSymbologyIdQRCode = 28;
    public static final int kSsiSymbologyIdTriopticCode39 = 21;
    public static final int kSsiSymbologyIdUpcA = 8;
    public static final int kSsiSymbologyIdUpcA2Supps = 72;
    public static final int kSsiSymbologyIdUpcA5Supps = 136;
    public static final int kSsiSymbologyIdUpcE0 = 9;
    public static final int kSsiSymbologyIdUpcE02Supps = 73;
    public static final int kSsiSymbologyIdUpcE05Supps = 137;
    public static final int kSsiSymbologyIdUpcE1 = 16;
    public static final int kSsiSymbologyIdUpcE12Supps = 80;
    public static final int kSsiSymbologyIdUpcE15Supps = 144;
    public static final int kSsiTimeoutBetweenSameSymbol = 137;
    public static final int kSsiTransmitNoReadMessage = 94;
    public static final int kSsiTriggerMode = 138;
    public static final byte kSsiTriggeringModeBlinking = 7;
    public static final byte kSsiTriggeringModeContinous = 4;
    public static final byte kSsiTriggeringModeHost = 8;
    public static final byte kSsiTriggeringModeLevel = 0;
    public static final byte kSsiTriggeringModePulse = 2;
    public static final int kSsiUccCouponCode = 85;
    public static final int kSsiUpcEanBookland = 83;
    public static final int kSsiUpcEanEan13 = 3;
    public static final int kSsiUpcEanEan8 = 4;
    public static final int kSsiUpcEanUpcA = 1;
    public static final int kSsiUpcEanUpcE = 2;
    public static final int kSsiUpcEanUpcE1 = 12;
    public static final int kSsiUspsIntelligentMail = 61776;
    public static final int kSsiVersionCDataFormatOffset = 16;
    public static final int kSsiVersionCDataTransmissionCr = 18;
    public static final int kSsiVersionCDataTransmissionCrLf = 17;
    public static final int kSsiVersionCDataTransmissionFormatAsIs = 16;
    public static final int kSsiVersionCDataTransmissionFormatPrefix = 23;
    public static final int kSsiVersionCDataTransmissionFormatPrefixSuffix1 = 24;
    public static final int kSsiVersionCDataTransmissionFormatPrefixSuffix1Suffix2 = 26;
    public static final int kSsiVersionCDataTransmissionFormatPrefixSuffix2 = 25;
    public static final int kSsiVersionCDataTransmissionFormatSuffix1 = 20;
    public static final int kSsiVersionCDataTransmissionFormatSuffix1Suffix2 = 22;
    public static final int kSsiVersionCDataTransmissionFormatSuffix2 = 21;
    public static final int kSsiVersionCDataTransmissionLf = 19;
    public static final int kStateErrorProtocol = 3;
    public static final int kStateInitDone = 4;
    public static final int kStateInitializationList = 1;
    public static final int kStateInitializationListSent = 2;
    public static final int kStateNoStarted = 0;
    public static final int sizeofBdAddress = 6;
    public static final int sizeofCOD = 3;
    public static final int sizeofUChar = 1;
    public static final int sizeofUlong = 4;
    public static final int sizeofUshort = 2;
    final char[] BTISCP_RESPONSE;
    final char CONFIG_ROLE_FLAGS_PERMANENT;
    final char CONFIG_ROLE_TYPE_INITIATOR;
    TSktCapabilityDescriptor[] CapabilityDescriptorTable;
    final short DEFAULT_MTU;
    final char[] GET_CONFIG_MODE;
    final char[] GET_DEVICE_CONFIG;
    PropertySupport[] PropertySupportTable;
    final ResponseInquiry[] ResponseInquiryTable;
    final char[] SET_CONFIG_MODE;
    final char[] SET_DEVICE_CONFIG;
    final char[] SSI_DECODE_PACKET_FORMAT;
    final char[] SSI_DEVICE_DETAILS_INQUIRY;
    final char[] SSI_GET_DATA_TRANSMISSION;
    final char[] SSI_PROTOCOL_DETECTION;
    final char[] SSI_ROLE_CONFIGURATION_PERMANENT_INITIATOR;
    final char[] SSI_SET_DATA_TRANSMISSION;
    final char[] SSI_SOFTWARE_HANDSHAKE;
    final char[] SSI_TRIGGERING_MODE;
    TSaveValue[] SaveValueTable;
    SktTranslator.TSktTranslator[] TablePropertyFromSsiPrimitive;
    SktTranslator.TSktTranslator[] TablePropertyToSsiPrimitive;
    final int kSktSsiV2TranslatorIndex;
    int m_InitState;
    private SktList m_LastCommandsSent;
    private SktPlatform.SktEvent m_PacketReadyToSendEvent;
    private SktStream m_ReadDataStream;
    private SktList m_SsiPacketsReceived;
    /* access modifiers changed from: private */
    public TSktSsiRoleConfiguration m_SsiRoleConfiguration;
    private SktList m_WriteBuffer;
    private SktPlatform.SktLock m_WriteBufferLock;
    /* access modifiers changed from: private */
    public boolean m_b3ByteParameterSupported;
    /* access modifiers changed from: private */
    public boolean m_bEngine655V4;
    /* access modifiers changed from: private */
    public boolean m_bOutdatedScanAPI;
    private boolean m_bV2Initialized;
    private int m_nFriendlyNameLength;
    private int m_nInitializationPropertiesCount;
    /* access modifiers changed from: private */
    public int m_nPostambleLength;
    /* access modifiers changed from: private */
    public int m_nPreambleLength;
    private int m_nRetransmitCount;
    private long m_nTickCountLastWrite;
    private String m_pszFriendlyName;
    /* access modifiers changed from: private */
    public String m_pszPostamble;
    /* access modifiers changed from: private */
    public String m_pszPreamble;
    /* access modifiers changed from: private */
    public String m_szProductSubType;
    /* access modifiers changed from: private */
    public char m_ucCapabilityFriendlyName;
    /* access modifiers changed from: private */
    public int m_ucLastButtonsStatus;
    /* access modifiers changed from: private */
    public char m_ucMajorMinScanAPI;
    /* access modifiers changed from: private */
    public char m_ucMiddleMinScanAPI;
    /* access modifiers changed from: private */
    public char m_ucMinorMinScanAPI;
    /* access modifiers changed from: private */
    public char m_ucSsiConfigurationMode;
    /* access modifiers changed from: private */
    public char m_ucSsiDataTransmissionFormat;
    /* access modifiers changed from: private */
    public char m_ucSsiDeviceConfigurationModeSelect;
    /* access modifiers changed from: private */
    public char m_ucSsiDeviceConfigurationTriggerButton;
    /* access modifiers changed from: private */
    public char m_ucSsiLocalDecodeAction;
    /* access modifiers changed from: private */
    public char m_ucSsiSupportedFeatures;
    /* access modifiers changed from: private */
    public char m_ucSsiTriggerLockOutTimeout;
    /* access modifiers changed from: private */
    public char m_ucSsiVersionMajor;
    /* access modifiers changed from: private */
    public char m_ucSsiVersionMinor;
    /* access modifiers changed from: private */
    public long m_ulDeviceType;
    /* access modifiers changed from: private */
    public long m_ulNotifications;
    private int m_wMtu;
    /* access modifiers changed from: private */
    public int m_wSsiConnectedTimerOff;
    /* access modifiers changed from: private */
    public int m_wSsiDisconnectedTimerOff;
    /* access modifiers changed from: private */
    public char m_wSsiVersionMajorMinor;

    interface EPacketState {
        public static final int complete = 1;
        public static final int discarded = 3;
        public static final int notComplete = 0;
        public static final int wrongProtocol = 2;
    }

    interface ESsiSubCmdIndicators {
        public static final int kSsiSubCmdIndicatorBadScanBeep = 7;
        public static final int kSsiSubCmdIndicatorBadScanBeepFlashRumble = 17;
        public static final int kSsiSubCmdIndicatorBadScanBeepLed = 9;
        public static final int kSsiSubCmdIndicatorBadScanBeepRumble = 15;
        public static final int kSsiSubCmdIndicatorBadScanFlashRumble = 16;
        public static final int kSsiSubCmdIndicatorBadScanLed = 8;
        public static final int kSsiSubCmdIndicatorBadScanRumble = 14;
        public static final int kSsiSubCmdIndicatorBeep = 1;
        public static final int kSsiSubCmdIndicatorBeepLed = 3;
        public static final int kSsiSubCmdIndicatorGoodScanBeep = 4;
        public static final int kSsiSubCmdIndicatorGoodScanBeepFlashRumble = 13;
        public static final int kSsiSubCmdIndicatorGoodScanBeepLed = 6;
        public static final int kSsiSubCmdIndicatorGoodScanBeepRumble = 11;
        public static final int kSsiSubCmdIndicatorGoodScanFlashRumble = 12;
        public static final int kSsiSubCmdIndicatorGoodScanLed = 5;
        public static final int kSsiSubCmdIndicatorGoodScanRumble = 10;
        public static final int kSsiSubCmdIndicatorLed = 2;
        public static final int kSsiSubCmdIndicatorNone = 0;
    }

    interface ISktSaveCapability {
        long SktSaveCapabilityFunction(TSktCapabilityContext tSktCapabilityContext);
    }

    interface ISktSaveValueFunction {
        long SktSaveValueFunction(TSaveValueData tSaveValueData);
    }

    static class SktBufferAndCommand extends SktBuffer {
        public SktSsiLastCommand m_CommandInfo = new SktSsiLastCommand();
    }

    static /* synthetic */ int access$1012(SktSsiProtocol x0, int x1) {
        int i = x0.m_wSsiDisconnectedTimerOff + x1;
        x0.m_wSsiDisconnectedTimerOff = i;
        return i;
    }

    static /* synthetic */ int access$1060(SktSsiProtocol x0, int x1) {
        int i = x0.m_wSsiDisconnectedTimerOff << x1;
        x0.m_wSsiDisconnectedTimerOff = i;
        return i;
    }

    static /* synthetic */ char access$1612(SktSsiProtocol x0, int x1) {
        char c = (char) (x0.m_wSsiVersionMajorMinor + x1);
        x0.m_wSsiVersionMajorMinor = c;
        return c;
    }

    static /* synthetic */ char access$1660(SktSsiProtocol x0, int x1) {
        char c = (char) (x0.m_wSsiVersionMajorMinor << x1);
        x0.m_wSsiVersionMajorMinor = c;
        return c;
    }

    static /* synthetic */ char access$372(SktSsiProtocol x0, int x1) {
        char c = (char) (x0.m_ucSsiConfigurationMode & x1);
        x0.m_ucSsiConfigurationMode = c;
        return c;
    }

    static /* synthetic */ char access$376(SktSsiProtocol x0, int x1) {
        char c = (char) (x0.m_ucSsiConfigurationMode | x1);
        x0.m_ucSsiConfigurationMode = c;
        return c;
    }

    static /* synthetic */ char access$576(SktSsiProtocol x0, int x1) {
        char c = (char) (x0.m_ucSsiDeviceConfigurationModeSelect | x1);
        x0.m_ucSsiDeviceConfigurationModeSelect = c;
        return c;
    }

    static /* synthetic */ int access$912(SktSsiProtocol x0, int x1) {
        int i = x0.m_wSsiConnectedTimerOff + x1;
        x0.m_wSsiConnectedTimerOff = i;
        return i;
    }

    static /* synthetic */ int access$960(SktSsiProtocol x0, int x1) {
        int i = x0.m_wSsiConnectedTimerOff << x1;
        x0.m_wSsiConnectedTimerOff = i;
        return i;
    }

    static class TSktSsiRoleConfiguration {
        char[] BluetoothAddress = new char[6];
        int ucRoleFlags;
        int ucRoleType;

        TSktSsiRoleConfiguration() {
        }

        public int getLength() {
            return 8;
        }

        public char[] getCharArray() {
            char[] result = new char[getLength()];
            result[0] = (char) this.ucRoleFlags;
            result[1] = (char) this.ucRoleType;
            for (int i = 0; i < 6; i++) {
                result[i + 2] = this.BluetoothAddress[i];
            }
            return result;
        }
    }

    static class TSaveValueData {
        SktSsiPacket pPacket;
        SktSsiProtocol pThis;

        TSaveValueData() {
        }
    }

    static class TSaveValue {
        ISktSaveValueFunction pfnFunction;
        int ucOpCode;
        int wSocketCmd;

        public TSaveValue(int OpCode, int SocketCmd, ISktSaveValueFunction function) {
            this.ucOpCode = OpCode;
            this.wSocketCmd = SocketCmd;
            this.pfnFunction = function;
        }
    }

    static class TSktCapabilityContext {
        SktSsiProtocol pThis;
        char[] pucData;
        char ucIndex;
        char ucLength;

        TSktCapabilityContext() {
        }
    }

    static class TSktCapabilityDescriptor {
        ISktSaveCapability pfnFunction;
        char ucCapabilityId;

        public TSktCapabilityDescriptor(char capabilityId, ISktSaveCapability function) {
            this.ucCapabilityId = capabilityId;
            this.pfnFunction = function;
        }
    }

    static class SktPayload {
        public char[] pucData;
        public int uLength;

        public long AddPayload(SktPayload payload, int payloadOffset) {
            long result = 0;
            if (payload == null) {
                result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(result)) {
                return result;
            }
            char[] pTemp = this.pucData;
            char[] pSourceData = payload.pucData;
            int sourceLength = payload.uLength - payloadOffset;
            this.pucData = new char[(this.uLength + sourceLength)];
            if (this.pucData != null) {
                for (int i = 0; i < this.uLength; i++) {
                    this.pucData[i] = pTemp[i];
                }
                for (int i2 = 0; i2 < sourceLength; i2++) {
                    this.pucData[this.uLength + i2] = pSourceData[payloadOffset + i2];
                }
                this.uLength += sourceLength;
                return result;
            }
            this.pucData = pTemp;
            return -2;
        }
    }

    static class SktSsiPacket {
        public SktPayload m_Payload = new SktPayload();
        public boolean m_bWrongProtocol;
        public int m_uLength = 0;
        public char m_ucOpcode = 0;
        public char m_ucSource = 0;
        public char m_ucStatus = 0;
        public int m_wChecksum = 0;

        public long CopyHeaderToBuffer(char[] pucData, SktScanTypes.TSktScanInteger pnLength) {
            long Result = 0;
            if (pnLength == null) {
                Result = -18;
            } else if (pnLength.getValue() < 4) {
                Result = -26;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pucData[0] = (char) this.m_uLength;
                pucData[1] = this.m_ucOpcode;
                pucData[2] = this.m_ucSource;
                pucData[3] = this.m_ucStatus;
                pnLength.setValue(4);
            }
            return Result;
        }

        public long CopyBufferToHeader(char[] pucData, SktScanTypes.TSktScanInteger pnLength) {
            long Result = 0;
            if (pnLength == null) {
                Result = -18;
            } else if (pnLength.getValue() < 4) {
                Result = -26;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this.m_uLength = pucData[0];
                this.m_ucOpcode = pucData[1];
                this.m_ucSource = pucData[2];
                this.m_ucStatus = pucData[3];
                pnLength.setValue(4);
            }
            return Result;
        }

        public boolean IsSocketCmd() {
            if (this.m_ucOpcode != 209 || this.m_uLength < 6) {
                return false;
            }
            return true;
        }

        public long AddSsiPacket(SktSsiPacket SsiPacket) {
            long result = 0;
            if (SsiPacket == null) {
                result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(result)) {
                return result;
            }
            int payloadOffset = 0;
            int uLength = SsiPacket.m_uLength;
            if (SsiPacket.m_ucOpcode == 198) {
                payloadOffset = 1;
            } else if (SsiPacket.m_ucOpcode == 243 && this.m_uLength != 0) {
                payloadOffset = 1;
            }
            this.m_uLength += uLength - payloadOffset;
            return SktDebug.DBGSKT_EVAL(this.m_Payload.AddPayload(SsiPacket.m_Payload, payloadOffset), "m_Payload.AddPayload(SsiPacket.m_Payload,payloadOffset)");
        }
    }

    static class SktSsiLastCommand {
        private boolean m_bGetOperation = false;
        private boolean m_bResponseExpected = true;
        private int m_nNumberOfAck = 0;
        private int m_nSsiSymbologyId = 0;
        private int m_ucCapabilityGroupRequest = 0;
        private int m_ucOpCode = 0;
        private long m_ulPropertyID = 0;
        private int m_wSocketOpCode = 0;

        public void SetOpCode(int ucOpCode) {
            this.m_ucOpCode = ucOpCode;
        }

        public int GetOpCode() {
            return this.m_ucOpCode;
        }

        public void SetPropertyID(long ulPropertyID) {
            this.m_ulPropertyID = ulPropertyID;
        }

        public long GetPropertyID() {
            return this.m_ulPropertyID;
        }

        public void SetSocketOpCode(int wSocketOpCode) {
            this.m_wSocketOpCode = wSocketOpCode;
        }

        public int GetSocketOpCode() {
            return this.m_wSocketOpCode;
        }

        public void SetGetOperation(boolean bGetOperation) {
            this.m_bGetOperation = bGetOperation;
        }

        public boolean IsGetOperation() {
            return this.m_bGetOperation;
        }

        public void SetCapabilityGroupRequest(int ucCapabilityGroupRequest) {
            this.m_ucCapabilityGroupRequest = ucCapabilityGroupRequest;
        }

        public int GetCapabilityGroupRequest() {
            return this.m_ucCapabilityGroupRequest;
        }

        public long CopyFrom(SktSsiLastCommand pSource) {
            if (pSource == null) {
                return -18;
            }
            SetOpCode(pSource.GetOpCode());
            SetPropertyID(pSource.GetPropertyID());
            SetSocketOpCode(pSource.GetSocketOpCode());
            SetGetOperation(pSource.IsGetOperation());
            SetCapabilityGroupRequest(pSource.GetCapabilityGroupRequest());
            SetResponseExpected(pSource.IsResponseExpected());
            this.m_nNumberOfAck = pSource.GetNumberOfAck();
            SetSsiSymbologyId(pSource.GetSsiSymbologyId());
            return 0;
        }

        public boolean IsResponseExpected() {
            return this.m_bResponseExpected;
        }

        public void SetResponseExpected(boolean bExpected) {
            this.m_bResponseExpected = bExpected;
        }

        public int GetNumberOfAck() {
            return this.m_nNumberOfAck;
        }

        public void DecreaseNumberOfAck() {
            this.m_nNumberOfAck--;
        }

        public long ComputeNumberOfAck(char[] pBuffer) {
            int index = 0;
            while (index < pBuffer.length) {
                index += (pBuffer[index] & 255) + 2;
                this.m_nNumberOfAck++;
            }
            return 0;
        }

        public void SetSsiSymbologyId(int nSsiSymbologyId) {
            this.m_nSsiSymbologyId = nSsiSymbologyId;
        }

        public int GetSsiSymbologyId() {
            return this.m_nSsiSymbologyId;
        }
    }

    static class SupportedEngineVersion {
        public final int engineType;
        public final char[] pszVersion;

        public SupportedEngineVersion(char[] szVersion, int type) {
            this.pszVersion = szVersion;
            this.engineType = type;
        }
    }

    static class DataConfirmationToSsiIndicator {
        int ucSsiIndicator;
        long ulDataConfirmation;

        public DataConfirmationToSsiIndicator(long DataConfirmation, int SsiIndicator) {
            this.ulDataConfirmation = DataConfirmation;
            this.ucSsiIndicator = SsiIndicator;
        }
    }

    static class PropertySupport {
        int ucMajorVersion;
        int ucMinorVersion;
        long ulProductType;
        long ulProperty;

        public PropertySupport(long Property, long ProductType, int MajorVersion, int MinorVersion) {
            this.ulProperty = Property;
            this.ulProductType = ProductType;
            this.ucMajorVersion = MajorVersion;
            this.ucMinorVersion = MinorVersion;
        }
    }

    static class ResponseInquiry {
        int wInquiry;
        int wInquirySecondChoice;
        int wResponse;

        public ResponseInquiry(int Response, int Inquiry, int InquirySecondChoice) {
            this.wResponse = Response;
            this.wInquiry = Inquiry;
            this.wInquirySecondChoice = InquirySecondChoice;
        }
    }

    static class TSktSsiSymbologyTranslator {
        int SktSymbologyID;
        char[] extraParameter;
        int uSsiSymbologyCommand;
        int wSsiSymbologyID;

        public TSktSsiSymbologyTranslator(byte ID, int SsiSymbologyID, int SsiSymbologyCommand, char[] extraParam) {
            this.SktSymbologyID = ID;
            this.wSsiSymbologyID = SsiSymbologyID;
            this.uSsiSymbologyCommand = SsiSymbologyCommand;
            this.extraParameter = extraParam;
        }
    }

    protected SktSsiProtocol() {
        this.m_SsiRoleConfiguration = null;
        this.SSI_PROTOCOL_DETECTION = new char[]{19, 209, 4, 0, 1, 10, 2, 6, 13, 0, '@', 251, 136, 0, 0, '`', 9, 133, 3};
        this.BTISCP_RESPONSE = new char[]{2, 6, 13, 0, 'P', 251, 136, 0, 1, '`', 9, 231, 3};
        this.SSI_SOFTWARE_HANDSHAKE = new char[]{7, 198, 4, 8, 255, 159, 1};
        this.SSI_GET_DATA_TRANSMISSION = new char[]{5, 199, 4, 0, 235};
        this.SSI_SET_DATA_TRANSMISSION = new char[]{7, 198, 4, 0, 255, 235, 0};
        this.SSI_DECODE_PACKET_FORMAT = new char[]{7, 198, 4, 0, 255, 238, 1};
        this.SSI_TRIGGERING_MODE = new char[]{7, 198, 4, 0, 255, 138, 8};
        this.GET_CONFIG_MODE = new char[]{6, 209, 4, 0, 1, '\''};
        this.SET_CONFIG_MODE = new char[]{7, 209, 4, 0, 1, '&', '0'};
        this.GET_DEVICE_CONFIG = new char[]{6, 209, 4, 0, 1, 23};
        this.SET_DEVICE_CONFIG = new char[]{7, 209, 4, 0, 0, 7, 21};
        this.CONFIG_ROLE_FLAGS_PERMANENT = 4;
        this.CONFIG_ROLE_TYPE_INITIATOR = 1;
        this.SSI_ROLE_CONFIGURATION_PERMANENT_INITIATOR = new char[]{14, 209, 4, 0, 1, ')', 4, 1, 0, 0, 0, 0, 0, 0};
        this.SSI_DEVICE_DETAILS_INQUIRY = new char[]{6, 209, 4, 0, 1, 'M'};
        this.DEFAULT_MTU = 255;
        this.CapabilityDescriptorTable = new TSktCapabilityDescriptor[]{new TSktCapabilityDescriptor(1, new SaveCapabilityScanAPIMinVersion()), new TSktCapabilityDescriptor(2, new SaveCapabilityProductSubType()), new TSktCapabilityDescriptor(3, new SaveCapabilityPrefixSuffixSupport())};
        this.SaveValueTable = new TSaveValue[]{new TSaveValue(209, kSsiSubCmdSetConfigurationMode, new SaveConfigurationMode()), new TSaveValue(209, kSsiSubCmdConfigurationModeResponse, new SaveConfigurationMode()), new TSaveValue(209, 7, new SaveDeviceConfiguration()), new TSaveValue(209, kSsiSubCmdDeviceConfigurationResponse, new SaveDeviceConfiguration()), new TSaveValue(209, kSsiSubCmdSelfTestExResponse, new SaveDeviceVersionTypeAndFeature()), new TSaveValue(209, kSsiSubCmdSetLocalDecodeAction, new SaveLocalDecodeAction()), new TSaveValue(209, kSsiSubCmdLocalDecodeActionResponse, new SaveLocalDecodeAction()), new TSaveValue(209, kSsiSubCmdSetAutoOffTimers, new SaveDisconnectedConnectedOffTimers()), new TSaveValue(209, kSsiSubCmdAutoOffTimersResponse, new SaveDisconnectedConnectedOffTimers()), new TSaveValue(198, 235, new SaveDataTransmissionFormat()), new TSaveValue(199, 235, new SaveDataTransmissionFormat()), new TSaveValue(209, kSsiSubCmdRoleConfigurationResponse, new SaveRoleConfiguration()), new TSaveValue(209, kSsiSubCmdSetRoleConfiguration, new SaveRoleConfiguration()), new TSaveValue(209, kSsiSubCmdDeviceDetailsResponse, new SaveDeviceDetails())};
        this.PropertySupportTable = new PropertySupport[]{new PropertySupport(65805, (long) SktScanDeviceType.kSktScanDeviceTypeScanner7, 3, 2), new PropertySupport(2359567, (long) SktScanDeviceType.kSktScanDeviceTypeScanner7, 3, 2), new PropertySupport(65805, (long) SktScanDeviceType.kSktScanDeviceTypeScanner9, 255, 255), new PropertySupport(2359567, (long) SktScanDeviceType.kSktScanDeviceTypeScanner9, 255, 255)};
        this.kSktSsiV2TranslatorIndex = 4;
        this.TablePropertyToSsiPrimitive = new SktTranslator.TSktTranslator[]{new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(199, 105, 0), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, false), new SktTranslator.TSktTranslatorTo(198, 105, 0), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(199, 104, (int) kSsiDataOptionSuffix2), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, false), new SktTranslator.TSktTranslatorTo(198, 104, (int) kSsiDataOptionSuffix2), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65536, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456451, true), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456451, false), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(199, 0, 0), new TranslateSymbologyToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, false), new SktTranslator.TSktTranslatorTo(198, 0, 0), new TranslateSymbologyToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179653, false), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateTriggerToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, false), new SktTranslator.TSktTranslatorTo(209, 2, 2), new TranslatePreamblePostambleFriendlyNameToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, false), new SktTranslator.TSktTranslatorTo(209, 2, 3), new TranslatePreamblePostambleFriendlyNameToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2162697, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65546, true), new SktTranslator.TSktTranslatorTo(199, 254, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDataFormatInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, false), new SktTranslator.TSktTranslatorTo(209, 308, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, false), new SktTranslator.TSktTranslatorTo(209, 2, 1), new TranslatePreamblePostambleFriendlyNameToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSecurityModeInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, false), new SktTranslator.TSktTranslatorTo(209, 4, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1376514, false), new SktTranslator.TSktTranslatorTo(209, 5, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179907, false), new SktTranslator.TSktTranslatorTo(209, 6, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048836, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRestoreFactoryDefaults, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048837, false), new SktTranslator.TSktTranslatorTo(209, 254, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65798, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdButtonStatusInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSoundConfigurationInquiry, 0), new TranslateSoundConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetSoundConfiguration, 0), new TranslateSoundConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdAutoOffTimersInquiry, 0), new TranslateTimersToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetAutoOffTimers, 0), new TranslateTimersToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeInquiry, 0), new TranslateLocalAcknowledgmentToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetConfigurationMode, 0), new TranslateLocalAcknowledgmentToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1245450, false), new SktTranslator.TSktTranslatorTo(209, 257, 0), new TranslateDataConfirmationToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65803, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdBatteryStateExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdLocalDecodeActionInquiry, 0), new TranslateLocalDecodeActionToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetLocalDecodeAction, 0), new TranslateLocalDecodeActionToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65805, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdBluetoothDeviceAddressInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65806, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdStatisticInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRumbleConfigurationInquiry, 0), new TranslateRumbleConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetRumbleConfiguration, 0), new TranslateRumbleConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRoleConfigurationInquiry, 0), new TranslateProfileConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetRoleConfiguration, 0), new TranslateProfileConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179921, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetRoleConfiguration, 0), new TranslateDisconnectToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeveloperDataInquiry, 0), new TranslateDataStoreToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetDeveloperData, 0), new TranslateDataStoreToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeviceConfigurationInquiry, 0), new TranslateNotificationsToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, false), new SktTranslator.TSktTranslatorTo(209, 7, 0), new TranslateNotificationsToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeInquiry, 0), new TranslateStartUpRoleSPPToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetConfigurationMode, 0), new TranslateStartUpRoleSPPToSsiPacket())};
        this.TablePropertyFromSsiPrimitive = new SktTranslator.TSktTranslator[]{new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2162697, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExResponse, 0), new FillScanObjectPropertyFromCapabilities()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65536, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExResponse, 0), new FillScanObjectPropertyForVersionDevice()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExResponse, 0), new FillScanObjectPropertyForDeviceType()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 1, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 2, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 12, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 4, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 3, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 83, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 8, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 14, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 84, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 0, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 13, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 17, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 9, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 10, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 6, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 5, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiChinese2of5, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 7, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiMatrix2of5, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 11, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiGs1Databar, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiGs1DatabarLimited, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiGs1DatabarExpanded, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 15, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 227, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiDataMatrix, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiMaxicode, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiQRCode, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiAztec, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiHanXin, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65546, true), new SktTranslator.TSktTranslatorTo(198, 0, 0), new FillScanObjectPropertyFromAllParametersResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDataFormatResponse, 0), new FillScanObjectPropertyFromDataFormatResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(198, 235, 0), new FillScanObjectPropertyFromPreamble()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(198, 235, 0), new FillScanObjectPropertyFromPostamble()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameResponse, 0), new FillScanObjectPropertyFromFriendlyNameResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSecurityModeResponse, 0), new FillScanObjectPropertyFromSecurityModeResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65798, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdButtonResponse, 0), new FillScanObjectPropertyFromButtonResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSoundConfigurationResponse, 0), new FillScanObjectPropertyFromSoundConfigurationResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdAutoOffTimersResponse, 0), new FillScanObjectPropertyFromAutoOffTimersResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeResponse, 0), new FillScanObjectPropertyFromConfigurationModeResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65803, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdBatteryStateResponse, 0), new FillScanObjectPropertyFromBatteryStateResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdLocalDecodeActionResponse, 0), new FillScanObjectPropertyFromLocalDecodeActionResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65805, true), new SktTranslator.TSktTranslatorTo(209, 307, 0), new FillScanObjectPropertyFromDeviceAddressResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65806, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdStatisticResponse, 0), new FillScanObjectPropertyFromStatisticResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRumbleConfigurationResponse, 0), new FillScanObjectPropertyFromRumbleConfigurationResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRoleConfigurationResponse, 0), new FillScanObjectPropertyFromProfileConfigurationResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeveloperDataResponse, 0), new FillScanObjectPropertyFromDataStoreResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeviceConfigurationResponse, 0), new FillScanObjectPropertyForNotifications()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeResponse, 0), new FillScanObjectPropertyForStartUpRoleSPP()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo((int) kSsiOpcodeDecodeData, 0, 0), new FillScanObjectPropertyFromDecodedData()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(198, 0, 0), new FillScanObjectPropertyFromParamSendResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(209, 0, 0), new FillScanObjectPropertyFromNakResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(208, 0, 0), new FillScanObjectPropertyFromAckResponse())};
        this.ResponseInquiryTable = new ResponseInquiry[]{new ResponseInquiry(kSsiSubCmdBatteryStateResponse, kSsiSubCmdBatteryStateInquiry, kSsiSubCmdBatteryStateExInquiry), new ResponseInquiry(kSsiSubCmdSelfTestResponse, kSsiSubCmdSelfTestInquiry, 0), new ResponseInquiry(kSsiSubCmdFriendlyNameResponse, kSsiSubCmdFriendlyNameInquiry, 0), new ResponseInquiry(kSsiSubCmdButtonResponse, kSsiSubCmdButtonStatusInquiry, 0), new ResponseInquiry(kSsiSubCmdSelfTestExResponse, kSsiSubCmdSelfTestExInquiry, 0), new ResponseInquiry(kSsiSubCmdSecurityModeResponse, kSsiSubCmdSecurityModeInquiry, 0), new ResponseInquiry(kSsiSubCmdResetStateResponse, kSsiSubCmdResetStateInquiry, 0), new ResponseInquiry(kSsiSubCmdModemStatusModeResponse, kSsiSubCmdModemStatusModeInquiry, 0), new ResponseInquiry(kSsiSubCmdDeviceConfigurationResponse, kSsiSubCmdDeviceConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdSoundConfigurationResponse, kSsiSubCmdSoundConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdRadioPowerResponse, kSsiSubCmdRadioPowerInquiry, 0), new ResponseInquiry(kSsiSubCmdAutoOffTimersResponse, kSsiSubCmdAutoOffTimersInquiry, 0), new ResponseInquiry(kSsiSubCmdStatisticResponse, kSsiSubCmdStatisticInquiry, 0), new ResponseInquiry(kSsiSubCmdConfigurationModeResponse, kSsiSubCmdConfigurationModeInquiry, 0), new ResponseInquiry(kSsiSubCmdRoleConfigurationResponse, kSsiSubCmdRoleConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdLocalDecodeActionResponse, kSsiSubCmdLocalDecodeActionInquiry, 0), new ResponseInquiry(307, kSsiSubCmdBluetoothDeviceAddressInquiry, 0), new ResponseInquiry(kSsiSubCmdRumbleConfigurationResponse, kSsiSubCmdRumbleConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdDataFormatResponse, kSsiSubCmdDataFormatInquiry, 0), new ResponseInquiry(kSsiSubCmdDeveloperDataResponse, kSsiSubCmdDeveloperDataInquiry, 0), new ResponseInquiry(kSsiSubCmdDeviceDetailsResponse, kSsiSubCmdDeviceDetailsInquiry, 0), new ResponseInquiry(kSsiSubCmdDeviceBatteryState2Response, kSsiSubCmdDeviceBatteryStateInquiry2, 0)};
        this.m_pszFriendlyName = null;
        this.m_pszPreamble = null;
        this.m_pszPostamble = null;
        this.m_nRetransmitCount = 0;
        this.m_InitState = 0;
        this.m_ulDeviceType = (long) SktScanDeviceType.kSktScanDeviceTypeNone;
        this.m_nFriendlyNameLength = 0;
        this.m_nPreambleLength = 0;
        this.m_nPostambleLength = 0;
        this.m_ucSsiConfigurationMode = 0;
        this.m_ucSsiDeviceConfigurationModeSelect = 0;
        this.m_ucSsiDeviceConfigurationTriggerButton = 0;
        this.m_SsiRoleConfiguration = new TSktSsiRoleConfiguration();
        this.m_SsiPacketsReceived = new SktList();
        this.m_ReadDataStream = new SktStream();
        this.m_WriteBuffer = new SktList();
        this.m_WriteBufferLock = new SktPlatform.SktLock();
        this.m_PacketReadyToSendEvent = new SktPlatform.SktEvent();
        this.m_LastCommandsSent = new SktList();
        this.m_ucMajorMinScanAPI = 0;
        this.m_ucMiddleMinScanAPI = 0;
        this.m_ucMinorMinScanAPI = 0;
        this.m_szProductSubType = null;
        this.m_ucCapabilityFriendlyName = 0;
        this.m_b3ByteParameterSupported = false;
    }

    public SktSsiProtocol(SktTransport pTransport) {
        super(pTransport);
        this.m_SsiRoleConfiguration = null;
        this.SSI_PROTOCOL_DETECTION = new char[]{19, 209, 4, 0, 1, 10, 2, 6, 13, 0, '@', 251, 136, 0, 0, '`', 9, 133, 3};
        this.BTISCP_RESPONSE = new char[]{2, 6, 13, 0, 'P', 251, 136, 0, 1, '`', 9, 231, 3};
        this.SSI_SOFTWARE_HANDSHAKE = new char[]{7, 198, 4, 8, 255, 159, 1};
        this.SSI_GET_DATA_TRANSMISSION = new char[]{5, 199, 4, 0, 235};
        this.SSI_SET_DATA_TRANSMISSION = new char[]{7, 198, 4, 0, 255, 235, 0};
        this.SSI_DECODE_PACKET_FORMAT = new char[]{7, 198, 4, 0, 255, 238, 1};
        this.SSI_TRIGGERING_MODE = new char[]{7, 198, 4, 0, 255, 138, 8};
        this.GET_CONFIG_MODE = new char[]{6, 209, 4, 0, 1, '\''};
        this.SET_CONFIG_MODE = new char[]{7, 209, 4, 0, 1, '&', '0'};
        this.GET_DEVICE_CONFIG = new char[]{6, 209, 4, 0, 1, 23};
        this.SET_DEVICE_CONFIG = new char[]{7, 209, 4, 0, 0, 7, 21};
        this.CONFIG_ROLE_FLAGS_PERMANENT = 4;
        this.CONFIG_ROLE_TYPE_INITIATOR = 1;
        this.SSI_ROLE_CONFIGURATION_PERMANENT_INITIATOR = new char[]{14, 209, 4, 0, 1, ')', 4, 1, 0, 0, 0, 0, 0, 0};
        this.SSI_DEVICE_DETAILS_INQUIRY = new char[]{6, 209, 4, 0, 1, 'M'};
        this.DEFAULT_MTU = 255;
        this.CapabilityDescriptorTable = new TSktCapabilityDescriptor[]{new TSktCapabilityDescriptor(1, new SaveCapabilityScanAPIMinVersion()), new TSktCapabilityDescriptor(2, new SaveCapabilityProductSubType()), new TSktCapabilityDescriptor(3, new SaveCapabilityPrefixSuffixSupport())};
        this.SaveValueTable = new TSaveValue[]{new TSaveValue(209, kSsiSubCmdSetConfigurationMode, new SaveConfigurationMode()), new TSaveValue(209, kSsiSubCmdConfigurationModeResponse, new SaveConfigurationMode()), new TSaveValue(209, 7, new SaveDeviceConfiguration()), new TSaveValue(209, kSsiSubCmdDeviceConfigurationResponse, new SaveDeviceConfiguration()), new TSaveValue(209, kSsiSubCmdSelfTestExResponse, new SaveDeviceVersionTypeAndFeature()), new TSaveValue(209, kSsiSubCmdSetLocalDecodeAction, new SaveLocalDecodeAction()), new TSaveValue(209, kSsiSubCmdLocalDecodeActionResponse, new SaveLocalDecodeAction()), new TSaveValue(209, kSsiSubCmdSetAutoOffTimers, new SaveDisconnectedConnectedOffTimers()), new TSaveValue(209, kSsiSubCmdAutoOffTimersResponse, new SaveDisconnectedConnectedOffTimers()), new TSaveValue(198, 235, new SaveDataTransmissionFormat()), new TSaveValue(199, 235, new SaveDataTransmissionFormat()), new TSaveValue(209, kSsiSubCmdRoleConfigurationResponse, new SaveRoleConfiguration()), new TSaveValue(209, kSsiSubCmdSetRoleConfiguration, new SaveRoleConfiguration()), new TSaveValue(209, kSsiSubCmdDeviceDetailsResponse, new SaveDeviceDetails())};
        this.PropertySupportTable = new PropertySupport[]{new PropertySupport(65805, (long) SktScanDeviceType.kSktScanDeviceTypeScanner7, 3, 2), new PropertySupport(2359567, (long) SktScanDeviceType.kSktScanDeviceTypeScanner7, 3, 2), new PropertySupport(65805, (long) SktScanDeviceType.kSktScanDeviceTypeScanner9, 255, 255), new PropertySupport(2359567, (long) SktScanDeviceType.kSktScanDeviceTypeScanner9, 255, 255)};
        this.kSktSsiV2TranslatorIndex = 4;
        this.TablePropertyToSsiPrimitive = new SktTranslator.TSktTranslator[]{new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(199, 105, 0), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, false), new SktTranslator.TSktTranslatorTo(198, 105, 0), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(199, 104, (int) kSsiDataOptionSuffix2), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, false), new SktTranslator.TSktTranslatorTo(198, 104, (int) kSsiDataOptionSuffix2), new TranslatePreamblePostambleToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65536, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456451, true), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456451, false), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(199, 0, 0), new TranslateSymbologyToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, false), new SktTranslator.TSktTranslatorTo(198, 0, 0), new TranslateSymbologyToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179653, false), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateTriggerToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, false), new SktTranslator.TSktTranslatorTo(209, 2, 2), new TranslatePreamblePostambleFriendlyNameToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, false), new SktTranslator.TSktTranslatorTo(209, 2, 3), new TranslatePreamblePostambleFriendlyNameToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2162697, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65546, true), new SktTranslator.TSktTranslatorTo(199, 254, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDataFormatInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, false), new SktTranslator.TSktTranslatorTo(209, 308, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, false), new SktTranslator.TSktTranslatorTo(209, 2, 1), new TranslatePreamblePostambleFriendlyNameToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSecurityModeInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, false), new SktTranslator.TSktTranslatorTo(209, 4, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1376514, false), new SktTranslator.TSktTranslatorTo(209, 5, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179907, false), new SktTranslator.TSktTranslatorTo(209, 6, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048836, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRestoreFactoryDefaults, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048837, false), new SktTranslator.TSktTranslatorTo(209, 254, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65798, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdButtonStatusInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSoundConfigurationInquiry, 0), new TranslateSoundConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetSoundConfiguration, 0), new TranslateSoundConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdAutoOffTimersInquiry, 0), new TranslateTimersToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetAutoOffTimers, 0), new TranslateTimersToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeInquiry, 0), new TranslateLocalAcknowledgmentToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetConfigurationMode, 0), new TranslateLocalAcknowledgmentToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1245450, false), new SktTranslator.TSktTranslatorTo(209, 257, 0), new TranslateDataConfirmationToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65803, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdBatteryStateExInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdLocalDecodeActionInquiry, 0), new TranslateLocalDecodeActionToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetLocalDecodeAction, 0), new TranslateLocalDecodeActionToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65805, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdBluetoothDeviceAddressInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65806, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdStatisticInquiry, 0), new TranslateToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRumbleConfigurationInquiry, 0), new TranslateRumbleConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetRumbleConfiguration, 0), new TranslateRumbleConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRoleConfigurationInquiry, 0), new TranslateProfileConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetRoleConfiguration, 0), new TranslateProfileConfigToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179921, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetRoleConfiguration, 0), new TranslateDisconnectToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeveloperDataInquiry, 0), new TranslateDataStoreToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetDeveloperData, 0), new TranslateDataStoreToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeviceConfigurationInquiry, 0), new TranslateNotificationsToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, false), new SktTranslator.TSktTranslatorTo(209, 7, 0), new TranslateNotificationsToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeInquiry, 0), new TranslateStartUpRoleSPPToSsiPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, false), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSetConfigurationMode, 0), new TranslateStartUpRoleSPPToSsiPacket())};
        this.TablePropertyFromSsiPrimitive = new SktTranslator.TSktTranslator[]{new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2162697, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExResponse, 0), new FillScanObjectPropertyFromCapabilities()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65536, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExResponse, 0), new FillScanObjectPropertyForVersionDevice()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSelfTestExResponse, 0), new FillScanObjectPropertyForDeviceType()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 1, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 2, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 12, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 4, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 3, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 83, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 8, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 14, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 84, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 0, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 13, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 17, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 9, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 10, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 6, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 5, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiChinese2of5, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 7, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiMatrix2of5, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 11, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiGs1Databar, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiGs1DatabarLimited, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiGs1DatabarExpanded, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 15, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, 227, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiDataMatrix, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiMaxicode, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiQRCode, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiAztec, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(198, (int) kSsiHanXin, 0), new FillScanObjectPropertyFromSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65546, true), new SktTranslator.TSktTranslatorTo(198, 0, 0), new FillScanObjectPropertyFromAllParametersResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDataFormatResponse, 0), new FillScanObjectPropertyFromDataFormatResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(198, 235, 0), new FillScanObjectPropertyFromPreamble()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(198, 235, 0), new FillScanObjectPropertyFromPostamble()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdFriendlyNameResponse, 0), new FillScanObjectPropertyFromFriendlyNameResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSecurityModeResponse, 0), new FillScanObjectPropertyFromSecurityModeResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65798, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdButtonResponse, 0), new FillScanObjectPropertyFromButtonResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdSoundConfigurationResponse, 0), new FillScanObjectPropertyFromSoundConfigurationResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdAutoOffTimersResponse, 0), new FillScanObjectPropertyFromAutoOffTimersResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeResponse, 0), new FillScanObjectPropertyFromConfigurationModeResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65803, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdBatteryStateResponse, 0), new FillScanObjectPropertyFromBatteryStateResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdLocalDecodeActionResponse, 0), new FillScanObjectPropertyFromLocalDecodeActionResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65805, true), new SktTranslator.TSktTranslatorTo(209, 307, 0), new FillScanObjectPropertyFromDeviceAddressResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65806, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdStatisticResponse, 0), new FillScanObjectPropertyFromStatisticResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRumbleConfigurationResponse, 0), new FillScanObjectPropertyFromRumbleConfigurationResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdRoleConfigurationResponse, 0), new FillScanObjectPropertyFromProfileConfigurationResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeveloperDataResponse, 0), new FillScanObjectPropertyFromDataStoreResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdDeviceConfigurationResponse, 0), new FillScanObjectPropertyForNotifications()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, true), new SktTranslator.TSktTranslatorTo(209, (int) kSsiSubCmdConfigurationModeResponse, 0), new FillScanObjectPropertyForStartUpRoleSPP()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo((int) kSsiOpcodeDecodeData, 0, 0), new FillScanObjectPropertyFromDecodedData()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(198, 0, 0), new FillScanObjectPropertyFromParamSendResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(209, 0, 0), new FillScanObjectPropertyFromNakResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(208, 0, 0), new FillScanObjectPropertyFromAckResponse())};
        this.ResponseInquiryTable = new ResponseInquiry[]{new ResponseInquiry(kSsiSubCmdBatteryStateResponse, kSsiSubCmdBatteryStateInquiry, kSsiSubCmdBatteryStateExInquiry), new ResponseInquiry(kSsiSubCmdSelfTestResponse, kSsiSubCmdSelfTestInquiry, 0), new ResponseInquiry(kSsiSubCmdFriendlyNameResponse, kSsiSubCmdFriendlyNameInquiry, 0), new ResponseInquiry(kSsiSubCmdButtonResponse, kSsiSubCmdButtonStatusInquiry, 0), new ResponseInquiry(kSsiSubCmdSelfTestExResponse, kSsiSubCmdSelfTestExInquiry, 0), new ResponseInquiry(kSsiSubCmdSecurityModeResponse, kSsiSubCmdSecurityModeInquiry, 0), new ResponseInquiry(kSsiSubCmdResetStateResponse, kSsiSubCmdResetStateInquiry, 0), new ResponseInquiry(kSsiSubCmdModemStatusModeResponse, kSsiSubCmdModemStatusModeInquiry, 0), new ResponseInquiry(kSsiSubCmdDeviceConfigurationResponse, kSsiSubCmdDeviceConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdSoundConfigurationResponse, kSsiSubCmdSoundConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdRadioPowerResponse, kSsiSubCmdRadioPowerInquiry, 0), new ResponseInquiry(kSsiSubCmdAutoOffTimersResponse, kSsiSubCmdAutoOffTimersInquiry, 0), new ResponseInquiry(kSsiSubCmdStatisticResponse, kSsiSubCmdStatisticInquiry, 0), new ResponseInquiry(kSsiSubCmdConfigurationModeResponse, kSsiSubCmdConfigurationModeInquiry, 0), new ResponseInquiry(kSsiSubCmdRoleConfigurationResponse, kSsiSubCmdRoleConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdLocalDecodeActionResponse, kSsiSubCmdLocalDecodeActionInquiry, 0), new ResponseInquiry(307, kSsiSubCmdBluetoothDeviceAddressInquiry, 0), new ResponseInquiry(kSsiSubCmdRumbleConfigurationResponse, kSsiSubCmdRumbleConfigurationInquiry, 0), new ResponseInquiry(kSsiSubCmdDataFormatResponse, kSsiSubCmdDataFormatInquiry, 0), new ResponseInquiry(kSsiSubCmdDeveloperDataResponse, kSsiSubCmdDeveloperDataInquiry, 0), new ResponseInquiry(kSsiSubCmdDeviceDetailsResponse, kSsiSubCmdDeviceDetailsInquiry, 0), new ResponseInquiry(kSsiSubCmdDeviceBatteryState2Response, kSsiSubCmdDeviceBatteryStateInquiry2, 0)};
        this.m_nRetransmitCount = 0;
        this.m_InitState = 0;
        this.m_ulDeviceType = (long) SktScanDeviceType.kSktScanDeviceTypeNone;
        this.m_pszFriendlyName = null;
        this.m_nFriendlyNameLength = 0;
        this.m_pszPreamble = null;
        this.m_nPreambleLength = 0;
        this.m_pszPostamble = null;
        this.m_nPostambleLength = 0;
        this.m_ucSsiConfigurationMode = 0;
        this.m_ucSsiDeviceConfigurationModeSelect = 0;
        this.m_ucSsiDeviceConfigurationTriggerButton = 0;
        this.m_SsiRoleConfiguration = new TSktSsiRoleConfiguration();
        this.m_wMtu = 255;
        this.m_ucMajorMinScanAPI = 0;
        this.m_ucMiddleMinScanAPI = 0;
        this.m_ucMinorMinScanAPI = 0;
        this.m_szProductSubType = null;
        this.m_ucCapabilityFriendlyName = 0;
        this.m_SsiPacketsReceived = new SktList();
        this.m_ReadDataStream = new SktStream();
        this.m_WriteBuffer = new SktList();
        this.m_WriteBufferLock = new SktPlatform.SktLock();
        this.m_PacketReadyToSendEvent = new SktPlatform.SktEvent();
        this.m_LastCommandsSent = new SktList();
    }

    public int GetProtocolId() {
        return 1;
    }

    public long GetScanApiVersionRequested(int[] pwMajor, int[] pwMiddle, int[] pwMinor) {
        long result = super.GetScanApiVersionRequested(pwMajor, pwMiddle, pwMinor);
        if (SktScanErrors.SKTSUCCESS(result)) {
            pwMajor[0] = this.m_ucMajorMinScanAPI;
            pwMiddle[0] = this.m_ucMiddleMinScanAPI;
            pwMinor[0] = this.m_ucMinorMinScanAPI;
        }
        return result;
    }

    public long StartInitializing() {
        long Result = 0;
        SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
        this.m_bV2Initialized = false;
        this.m_InitState = 0;
        this.m_nTickCountLastWrite = 0;
        this.m_ulNotifications = 0;
        this.m_ucLastButtonsStatus = 0;
        this.m_bEngine655V4 = false;
        this.m_bOutdatedScanAPI = false;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_WriteBufferLock.Initialize(), "m_WriteBufferLock.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_PacketReadyToSendEvent.Create(false, false), "m_PacketReadyToSendEvent.Create(false,false)");
        }
        SktDebug.DBGSKT_MSG(65, "Start initializing protocol");
        this.m_nInitializationPropertiesCount = GetInitializationPropertyCount();
        SktList.Position headPosition = GetInitializationHeadPosition();
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_PROTOCOL_DETECTION;
        Property.Array.Size = this.SSI_PROTOCOL_DETECTION.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_SOFTWARE_HANDSHAKE;
        Property.Array.Size = this.SSI_SOFTWARE_HANDSHAKE.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_TRIGGERING_MODE;
        Property.Array.Size = this.SSI_TRIGGERING_MODE.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_GET_DATA_TRANSMISSION;
        Property.Array.Size = this.SSI_GET_DATA_TRANSMISSION.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.GET_DEVICE_CONFIG;
        Property.Array.Size = this.GET_DEVICE_CONFIG.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SET_DEVICE_CONFIG;
        Property.Array.Size = this.SET_DEVICE_CONFIG.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, new MaskForDeviceConfigAckActivation()), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,new MaskForDeviceConfigAckActivation())");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.GET_CONFIG_MODE;
        Property.Array.Size = this.GET_CONFIG_MODE.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdLocalDecodeActionDevice;
        Property.Type = 0;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_DEVICE_DETAILS_INQUIRY;
        Property.Array.Size = this.SSI_DEVICE_DETAILS_INQUIRY.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        this.m_nInitializationPropertiesCount = GetInitializationPropertyCount() - this.m_nInitializationPropertiesCount;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(SendInitializationProperties(), "SendInitializationProperties()");
        }
        return Result;
    }

    public long InitializeV2Device(long ulDeviceType) {
        long Result = 0;
        SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
        int nPropertiesCount = GetInitializationPropertyCount();
        SktList.Position headPosition = GetInitializationHeadPosition();
        SktDebug.DBGSKT_MSG(65, "Protocol initialization adding the V2 initialization");
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_SET_DATA_TRANSMISSION;
        Property.Array.Size = this.SSI_SET_DATA_TRANSMISSION.length;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.pData = this.SSI_DECODE_PACKET_FORMAT;
        Property.Array.Size = this.SSI_DECODE_PACKET_FORMAT.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        if (ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeScanner9)) {
            SktDebug.DBGSKT_MSG(65, "CRS V2 initialization: adding permanent pair");
            Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
            Property.Type = 4;
            Property.Array.pData = this.SSI_ROLE_CONFIGURATION_PERMANENT_INITIATOR;
            Property.Array.Size = this.SSI_ROLE_CONFIGURATION_PERMANENT_INITIATOR.length;
            Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(false, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(false,Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
        }
        this.m_nInitializationPropertiesCount += GetInitializationPropertyCount() - nPropertiesCount;
        return Result;
    }

    public long ContinueInitializing() {
        long Result = 0;
        SktScanTypes.TSktScanLong ResultToIgnore = new SktScanTypes.TSktScanLong(0);
        TSktScanObject ScanObj = new TSktScanObject();
        boolean bContinue = true;
        SktScanTypes.TSktScanBoolean bGet = new SktScanTypes.TSktScanBoolean(false);
        while (bContinue) {
            bContinue = false;
            long Result2 = SktDebug.DBGSKT_EVAL(ReadHeadInitializationProperty(bGet, ScanObj.Property, ResultToIgnore), "ReadHeadInitializationProperty(bGet,ScanObj.Property,ResultToIgnore)");
            if (bGet.getValue()) {
                if (SktScanErrors.SKTSUCCESS(Result2)) {
                    Result2 = SktDebug.DBGSKT_EVAL(GetProperty(ScanObj, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "GetProperty(ScanObj,null,null)");
                }
            } else if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SktDebug.DBGSKT_EVAL(SetProperty(ScanObj, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "SetProperty(ScanObj,null,null)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == ResultToIgnore.getValue()) {
                Result = 0;
                SktUtilities.ReleaseProperty(ScanObj.Property);
                if (SktScanErrors.SKTSUCCESS(0)) {
                    Result = SktDebug.DBGSKT_EVAL(RemoveInitializationProperty(bGet, ScanObj.Property, ResultToIgnore, (SktProtocolInterface.TSktPropertyMaskFunction[]) null), "RemoveInitializationProperty(bGet,ScanObj.Property,ResultToIgnore,null)");
                }
                this.m_nInitializationPropertiesCount--;
                bContinue = true;
            }
            SktUtilities.ReleaseProperty(ScanObj.Property);
        }
        return Result;
    }

    public long CheckIfInitialized(SktScanTypes.TSktScanInteger state) {
        long Result;
        long Result2 = 0;
        SktScanTypes.TSktScanLong ResultToIgnore = new SktScanTypes.TSktScanLong(0);
        TSktScanObject[] ScanObj = new TSktScanObject[1];
        SktScanTypes.TSktScanProperty property = new SktScanTypes.TSktScanProperty();
        SktScanTypes.TSktScanBoolean bGet = new SktScanTypes.TSktScanBoolean(false);
        SktProtocolInterface.TSktPropertyMaskFunction[] pfnMaskFunction = new SktProtocolInterface.TSktPropertyMaskFunction[1];
        this.m_nTickCountLastWrite = 0;
        if (state == null) {
            Result2 = -18;
        }
        if (this.m_nInitializationPropertiesCount > 0) {
            state.setValue(1);
            this.m_nInitializationPropertiesCount--;
            SktDebug.DBGSKT_MSG(65, "initialization Receives Response");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveScanObject(ScanObj), "RetrieveScanObject(ScanObj)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RemoveInitializationProperty(bGet, property, ResultToIgnore, pfnMaskFunction), "RemoveInitializationProperty(bGet,Property,ResultToIgnore)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (ScanObj[0].Property.f13ID == property.f13ID) {
                    if (!SktScanErrors.SKTSUCCESS(ScanObj[0].Msg.Result) && ScanObj[0].Msg.Result == ResultToIgnore.getValue()) {
                        ScanObj[0].Msg.Result = 0;
                    }
                    if (!SktScanErrors.SKTSUCCESS(ScanObj[0].Msg.Result)) {
                        SktDebug.DBGSKT_MSG(66, "Error " + ScanObj[0].Msg.Result + " during initialization property:0x" + Integer.toHexString(ScanObj[0].Property.f13ID));
                        this.m_InitState = 3;
                    } else if (ScanObj[0].Property.Type == 6) {
                        SktDebug.DBGSKT_MSG(65, "Version:" + ScanObj[0].Property.Version.wMajor + "." + ScanObj[0].Property.Version.wMiddle + "." + ScanObj[0].Property.Version.wMinor + "." + ScanObj[0].Property.Version.dwBuild);
                    }
                    Result = SktDebug.DBGSKT_EVAL(SktUtilities.ReleaseProperty(property), "SktUtilities.ReleaseProperty(Property)");
                    if (this.m_nInitializationPropertiesCount == 0 && ((this.m_wSsiVersionMajorMinor < 770 || this.m_ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeScanner9)) && !this.m_bV2Initialized)) {
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(InitializeV2Device(this.m_ulDeviceType), "InitializeV2Device(m_ulDeviceType)");
                        }
                        this.m_bV2Initialized = true;
                    }
                    if (this.m_nInitializationPropertiesCount == 0) {
                        state.setValue(2);
                    }
                } else {
                    SktList.Position headPosition = GetInitializationHeadPosition();
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(bGet.getValue(), property, 0, headPosition, pfnMaskFunction[0]), "AddInitializationProperty(bGet.getValue(),Property,SktScanErrors.ESKT_NOERROR,headPosition,null)");
                    }
                    this.m_nInitializationPropertiesCount++;
                }
            }
            if (ScanObj[0] != null) {
                SktUtilities.ReleaseProperty(ScanObj[0].Property);
            }
            if (this.m_bOutdatedScanAPI) {
                this.m_bOutdatedScanAPI = false;
                Result = -48;
            }
        } else {
            state.setValue(2);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (Result == -44) {
            state.setValue(3);
            return 0;
        } else if (Result != -48) {
            return Result;
        } else {
            state.setValue(4);
            return 0;
        }
    }

    public long GetProperty(TSktScanObject pScanObj, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        return SktDebug.DBGSKT_EVAL(GetOrSetProperty(true, pScanObj, pbImmediateResponse, ppResponseScanObj), "GetOrSetProperty(true,pScanObj,pbImmediateResponse,ppResponseScanObj)");
    }

    public long SetProperty(TSktScanObject pScanObj, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        return SktDebug.DBGSKT_EVAL(GetOrSetProperty(false, pScanObj, pbImmediateResponse, ppResponseScanObj), "GetOrSetProperty(false,pScanObj,pbImmediateResponse,ppResponseScanObj)");
    }

    public long RetrieveScanObject(TSktScanObject[] pScanObj) {
        long Result;
        int i;
        long Result2 = 0;
        SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
        SktSsiPacket[] pReassembledSsiPacket = new SktSsiPacket[1];
        SktSsiLastCommand[] pLastCommand = new SktSsiLastCommand[1];
        SktTranslator Translator = new SktTranslator();
        SktTranslator.TSktTranslatorData Data = new SktTranslator.TSktTranslatorData();
        int nSocketCmd = 0;
        if (pScanObj == null) {
            Result2 = -18;
        }
        boolean[] pbContinue = {true};
        while (SktScanErrors.SKTSUCCESS(Result) && pbContinue[0]) {
            Result = SktDebug.DBGSKT_EVAL(this.m_SsiPacketsReceived.RemoveHead(pSsiPacket), "m_SsiPacketsReceived.RemoveHead(pSsiPacket)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReassembleSsiPacket(pSsiPacket[0], pReassembledSsiPacket, pbContinue), "ReassembleSsiPacket(pSsiPacket, pReassembledSsiPacket, pbContinue)");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pReassembledSsiPacket[0].m_bWrongProtocol) {
            Result = -44;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.InitializeTable(this.TablePropertyFromSsiPrimitive, this.TablePropertyFromSsiPrimitive.length), "Translator.InitializeTable(TablePropertyFromSsiPrimitive,TablePropertyFromSsiPrimitive.length)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            char[] pPayloadData = pReassembledSsiPacket[0].m_Payload.pucData;
            int uLength = pReassembledSsiPacket[0].m_Payload.uLength;
            switch (pReassembledSsiPacket[0].m_ucOpcode) {
                case 198:
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(RemoveLastCommandInfo(pLastCommand), "RemoveLastCommandInfo(pLastCommand)");
                    }
                    if (1 >= uLength) {
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            nSocketCmd = pLastCommand[0].GetSsiSymbologyId() & 65535;
                            break;
                        }
                    } else {
                        if (uLength >= 1) {
                            i = 1 + 1;
                            nSocketCmd = 0 + pPayloadData[1];
                        } else {
                            i = 1;
                        }
                        if (nSocketCmd < 248 || uLength < 3) {
                            if (nSocketCmd >= 240 && uLength >= 2) {
                                int i2 = i + 1;
                                nSocketCmd = (nSocketCmd << 8) + pPayloadData[i];
                                break;
                            }
                        } else {
                            int i3 = i + 1;
                            int i4 = i3 + 1;
                            nSocketCmd = (((nSocketCmd << 8) + pPayloadData[i]) << 8) + pPayloadData[i3];
                            break;
                        }
                    }
                    break;
                case 208:
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(RemoveLastCommandInfo(pLastCommand), "RemoveLastCommandInfo(pLastCommand)");
                        break;
                    }
                    break;
                case 209:
                    if (pReassembledSsiPacket[0].m_uLength == 5) {
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(RemoveLastCommandInfo(pLastCommand), "RemoveLastCommandInfo(pLastCommand)");
                            break;
                        }
                    } else {
                        nSocketCmd = ((pPayloadData[0] << 8) & 65535) | pPayloadData[1];
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(RemoveLastCommandInfoFromSocketOpCodeResponse(nSocketCmd, pLastCommand), "RemoveLastCommandInfoFromSocketOpCodeResponse(wSocketCmd,pLastCommand)");
                            break;
                        }
                    }
                    break;
                case kSsiOpcodeDecodeData /*243*/:
                case kSsiOpcodeEvent /*246*/:
                    break;
                default:
                    Result = SktDebug.DBGSKT_EVAL(RemoveLastCommandInfo(pLastCommand), "RemoveLastCommandInfo(pLastCommand)");
                    break;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Data.f16To.ucFrameType = pReassembledSsiPacket[0].m_ucOpcode;
            Data.f16To.wGroupId = nSocketCmd;
            if (pScanObj[0] == null) {
                pScanObj[0] = new TSktScanObject();
            }
            if (pLastCommand[0] != null) {
                pScanObj[0].Property.f13ID = (int) pLastCommand[0].GetPropertyID();
                Data.From.PropId = pLastCommand[0].GetPropertyID();
                if (pScanObj[0].Property.f13ID == 0) {
                    pScanObj[0].Msg.MsgID = 6;
                } else if (pLastCommand[0].IsGetOperation()) {
                    pScanObj[0].Msg.MsgID = 5;
                } else {
                    pScanObj[0].Msg.MsgID = 4;
                }
                if (pLastCommand[0].GetNumberOfAck() > 0) {
                    SktDebug.DBGSKT_EVAL(SaveLastCommandInfo(pLastCommand[0], true), "SaveLastCommandInfo(pLastCommand[0],true)");
                    pScanObj[0].Msg.MsgID = 0;
                }
            }
            Data.pThis = this;
            Data.pExtraParam = pLastCommand[0];
            Data.pDataIn = pReassembledSsiPacket[0];
            Data.nDataInSize = pReassembledSsiPacket[0].m_uLength;
            Data.pDataOut = pScanObj[0];
            if (pScanObj[0] != null) {
                Data.nDataOutSize = pScanObj[0].Property.Array.Size;
            } else {
                Data.nDataOutSize = 0;
            }
            if (pScanObj[0].Property.f13ID == 4456451) {
                FillScanObjectPropertyFromDeviceSpecific aa = new FillScanObjectPropertyFromDeviceSpecific();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(aa.SktTranslatorFunction(Data), "aa.SktTranslatorFunction(Data)");
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(Translator.TranslateFromPrimitive(Data, (SktScanTypes.TSktScanInteger) null), "Translator.TranslateFromPrimitive(Data,null)");
            }
        }
        return Result;
    }

    public long DoIoOperation(SktScanTypes.TSktScanBoolean pbPacketReady, SktPlatform.SktEvent[] ppReadCompletionEvent, SktPlatform.SktEvent[] ppWriteCompletionEvent, SktPlatform.SktEvent[] ppPacketReadyToSend) {
        long Result = SktDebug.DBGSKT_EVAL(DoReadOperation(pbPacketReady, ppReadCompletionEvent), "DoReadOperation(pbPacketReady,ppReadCompletionEvent)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(DoWriteOperation(ppWriteCompletionEvent), "DoWriteOperation(ppWriteCompletionEvent)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (ppReadCompletionEvent[0] == null && ppWriteCompletionEvent[0] == null) {
            return Result;
        }
        if (ppPacketReadyToSend != null) {
            if (ppWriteCompletionEvent[0] != null) {
                ppPacketReadyToSend[0] = null;
            } else {
                ppPacketReadyToSend[0] = this.m_PacketReadyToSendEvent;
            }
        }
        return 3;
    }

    /* access modifiers changed from: protected */
    public long DoReadOperation(SktScanTypes.TSktScanBoolean pbPacketReady, SktPlatform.SktEvent[] ppReadCompletionEvent) {
        long Result = 0;
        SktScanTypes.TSktScanInteger nPacketSizeFound = new SktScanTypes.TSktScanInteger(0);
        int[] nReadSize = {0};
        SktScanTypes.TSktScanInteger PacketState = new SktScanTypes.TSktScanInteger(0);
        if (ppReadCompletionEvent == null || pbPacketReady == null) {
            Result = -18;
        } else {
            pbPacketReady.setValue(false);
            ppReadCompletionEvent[0] = null;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && GetTransport() == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && this.m_ReadDataStream.GetData() == null) {
            Result = SktDebug.DBGSKT_EVAL(this.m_ReadDataStream.Initialize(2048), "m_ReadDataStream.Initialize(kBlockMaxSize)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(CheckIfPacketIsComplete(this.m_ReadDataStream, nPacketSizeFound, PacketState), "CheckIfPacketIsComplete(m_ReadDataStream,nPacketSizeFound,PacketState)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            nReadSize[0] = this.m_ReadDataStream.GetWriteSizeMax();
            if (PacketState.getValue() == 0) {
                Result = SktDebug.DBGSKT_EVAL(GetTransport().ReadBlock(this.m_ReadDataStream.GetData(), this.m_ReadDataStream.GetWriteDataOffset(), nReadSize), "GetTransport().ReadBlock(pData,nWriteOffset,nReadSize)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (nReadSize[0] > 0) {
                        SktDebug.DBGSKT_MSG(1, "SSI Read " + nReadSize[0] + " bytes");
                    }
                    if (Result != 3) {
                        Result = SktDebug.DBGSKT_EVAL(this.m_ReadDataStream.MoveWriteDataPointer(nReadSize[0]), "m_ReadDataStream.MoveWriteDataPointer(nReadSize[0])");
                    } else {
                        ppReadCompletionEvent[0] = GetTransport().GetReadCompletionEvent();
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(CheckIfPacketIsComplete(this.m_ReadDataStream, nPacketSizeFound, PacketState), "CheckIfPacketIsComplete(m_ReadDataStream,nPacketSizeFound,PacketState)");
                    }
                }
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (PacketState.getValue() == 3) {
                SktSsiPacket pSsiPacket = new SktSsiPacket();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    SktDebug.DBGSKT_MSG(65, "Generate a SSI NAK to report Packet has been discarded");
                    pSsiPacket.m_uLength = 5;
                    pSsiPacket.m_ucOpcode = 209;
                    pSsiPacket.m_ucSource = 0;
                    pSsiPacket.m_ucStatus = 0;
                    pSsiPacket.m_Payload.uLength = 1;
                    pSsiPacket.m_Payload.pucData = new char[1];
                    if (pSsiPacket.m_Payload.pucData != null) {
                        pSsiPacket.m_Payload.pucData[0] = 2;
                        pbPacketReady.setValue(true);
                        Result = SktDebug.DBGSKT_EVAL(this.m_SsiPacketsReceived.AddTail(pSsiPacket), "m_SsiPacketsReceived.AddTail(pSsiPacket)");
                        if (!SktScanErrors.SKTSUCCESS(Result)) {
                            pSsiPacket.m_Payload.pucData = null;
                        }
                    } else {
                        Result = -2;
                    }
                }
            } else if (PacketState.getValue() == 2) {
                SktSsiPacket pSsiPacket2 = new SktSsiPacket();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pbPacketReady.setValue(true);
                    this.m_nTickCountLastWrite = 0;
                    pSsiPacket2.m_bWrongProtocol = true;
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(this.m_SsiPacketsReceived.AddTail(pSsiPacket2), "m_SsiPacketsReceived.AddTail(pSsiPacket)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                    }
                }
            } else if (PacketState.getValue() == 1) {
                SktSsiPacket pSsiPacket3 = new SktSsiPacket();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pbPacketReady.setValue(true);
                    Result = SktDebug.DBGSKT_EVAL(TransformRawByteToPacket(this.m_ReadDataStream, nPacketSizeFound.getValue(), pSsiPacket3), "TransformRawByteToPacket(m_ReadDataStream,nPacketSizeFound.getValue(),pSsiPacket)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (pSsiPacket3.m_ucOpcode == 209 && pSsiPacket3.m_uLength == 5 && (pSsiPacket3.m_ucStatus & 1) == 1 && this.m_nRetransmitCount < 2) {
                        pbPacketReady.setValue(false);
                        pSsiPacket3 = null;
                    }
                    if (pbPacketReady.getValue()) {
                        this.m_nTickCountLastWrite = 0;
                        if ((pSsiPacket3.m_ucStatus & 2) == 2) {
                            pbPacketReady.setValue(false);
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(this.m_SsiPacketsReceived.AddTail(pSsiPacket3), "m_SsiPacketsReceived.AddTail(pSsiPacket)");
                        }
                        if (!SktScanErrors.SKTSUCCESS(Result)) {
                        }
                    }
                }
            } else if (this.m_nInitializationPropertiesCount > 0 && this.m_nTickCountLastWrite > 0 && System.currentTimeMillis() > this.m_nTickCountLastWrite + 500) {
                SktSsiLastCommand[] lastCommand = new SktSsiLastCommand[1];
                if (SktScanErrors.SKTSUCCESS(RemoveLastCommandInfo(lastCommand))) {
                    lastCommand[0] = null;
                    SktDebug.DBGSKT_MSG(2, "Ask to resend the last command sent in the initialization");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(SendInitializationProperties(), "SendInitializationProperties()");
                    }
                    this.m_nTickCountLastWrite = 0;
                } else {
                    SktDebug.DBGSKT_MSG(2, "Command timeout occured but no command has been sent...");
                }
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || ppReadCompletionEvent[0] == null) {
            return Result;
        }
        return 3;
    }

    /* access modifiers changed from: protected */
    public long DoWriteOperation(SktPlatform.SktEvent[] ppWriteCompletionEvent) {
        long Result;
        long Result2 = 0;
        SktBufferAndCommand[] pBuffer = new SktBufferAndCommand[1];
        int[] nByteSent = {0};
        if (ppWriteCompletionEvent == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            ppWriteCompletionEvent[0] = null;
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_WriteBufferLock.Lock(), "m_WriteBufferLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position position = this.m_WriteBuffer.GetHeadPosition();
            if (position.IsValid()) {
                Result = SktDebug.DBGSKT_EVAL(this.m_WriteBuffer.RemoveAt(position, pBuffer), "m_WriteBuffer.RemoveAt(position,pBuffer)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetTransport().WriteBlock(pBuffer[0].m_pucData, pBuffer[0].m_nLength, nByteSent), "GetTransport().WriteBlock(pBuffer[0].m_pucData,pBuffer[0].m_nLength,nByteSent)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (Result == 3) {
                        ppWriteCompletionEvent[0] = GetTransport().GetWriteCompletionEvent();
                        if (nByteSent[0] == 0) {
                            Result = SktDebug.DBGSKT_EVAL(this.m_WriteBuffer.AddHead(pBuffer), "m_WriteBuffer.AddHead(pBuffer)");
                            if (SktScanErrors.SKTSUCCESS(Result)) {
                                pBuffer = null;
                            }
                        }
                    }
                    if (nByteSent[0] > 0 && SktScanErrors.SKTSUCCESS(Result)) {
                        if (0 == 1 && ppWriteCompletionEvent[0] == null) {
                            ppWriteCompletionEvent[0] = GetTransport().GetWriteCompletionEvent();
                            ppWriteCompletionEvent[0].Set();
                        }
                        Result = SktDebug.DBGSKT_EVAL(SaveLastCommandInfo(pBuffer[0].m_CommandInfo, false), "SaveLastCommandInfo(pBuffer[0].m_CommandInfo,false)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result) && ppWriteCompletionEvent[0] != null) {
                        Result = 3;
                    }
                }
            }
            if (this.m_WriteBuffer.GetCount() == 0) {
                this.m_PacketReadyToSendEvent.Reset();
            }
            this.m_nTickCountLastWrite = 0;
            if (SktScanErrors.SKTSUCCESS(Result) && Result != 3 && nByteSent[0] > 0) {
                this.m_nTickCountLastWrite = System.currentTimeMillis();
            }
            this.m_WriteBufferLock.Unlock();
        }
        return Result;
    }

    public static class TranslateToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result;
            long Result2 = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int[] OutSize = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result2 = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, OutSize), "RetrievePropertyData(pProperty,pucPropertyData,OutSize)");
            }
            int nPropertyDataSize = OutSize[0];
            OutSize[0] = 0;
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char[][] DataOut = new char[1][];
                if (pData.From.PropId == 4456451) {
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatRawSsiCmd(pucPropertyData[0], nPropertyDataSize, DataOut, OutSize), "pThis[0].FormatRawSsiCmd(pucPropertyData[0],nPropertyDataSize,DataOut,OutSize)");
                    pProperty[0].Array.pData = DataOut[0];
                    pProperty[0].Array.Size = OutSize[0];
                    pData.nDataOutSize = OutSize[0];
                } else if (pData.f16To.ucFrameType == 209) {
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, DataOut, OutSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,OutSize)");
                    pProperty[0].Array.pData = DataOut[0];
                    pProperty[0].Array.Size = OutSize[0];
                    pData.nDataOutSize = OutSize[0];
                } else if (pData.f16To.ucFrameType == 199) {
                    int nSize = 1;
                    char[] pValue = {0};
                    if (pData.f16To.wGroupId > 255) {
                        pValue[0] = (char) pData.f16To.wGroupId;
                        nSize = 2;
                    } else if (pData.f16To.ucFunctionId == 0) {
                        pValue[0] = (char) pData.f16To.wGroupId;
                    } else {
                        nSize = 2;
                        pValue = new char[]{(char) (pData.f16To.wGroupId & 255), pData.f16To.ucFunctionId};
                    }
                    char[][] pucBlockData = new char[1][];
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSsiCmd(pData.f16To.ucFrameType, 0, pValue, nSize, pucBlockData, OutSize), "pThis[0].FormatSsiCmd(pData.To.ucFrameType,pValue,nSize,pData.pDataOut,OutSize)");
                    pProperty[0].Array.pData = pucBlockData[0];
                    pProperty[0].Array.Size = OutSize[0];
                    pData.nDataOutSize = OutSize[0];
                } else {
                    char[][] pucBlockData2 = new char[1][];
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSsiCmd(pData.f16To.ucFrameType, pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, pucBlockData2, OutSize), "pThis[0].FormatSsiCmd(pData.To.ucFrameType,pucPropertyData[0],nPropertyDataSize,pData.pDataOut,OutSize)");
                    pProperty[0].Array.pData = pucBlockData2[0];
                    pProperty[0].Array.Size = OutSize[0];
                    pData.nDataOutSize = OutSize[0];
                }
                TSktScanObject pDataOut = new TSktScanObject();
                pDataOut.Property = pProperty[0];
                pData.pDataOut = pDataOut;
            }
            return Result;
        }
    }

    public static class TranslateSymbologyToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            int nIndex;
            long Result = 0;
            SktScanTypes.TSktScanInteger ucSsiSymbologyID = new SktScanTypes.TSktScanInteger(0);
            SktScanTypes.TSktScanInteger ucSsiSymbologyIDExtendedCode = new SktScanTypes.TSktScanInteger(0);
            SktScanTypes.TSktScanInteger tSktScanInteger = new SktScanTypes.TSktScanInteger(0);
            SktSsiPacket SsiPacket = new SktSsiPacket();
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] extraParameter = new char[1][];
            int extraParameterLength = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.TranslateToSsiSymbologyId(pProperty[0].Symbology.f14ID, ucSsiSymbologyID, ucSsiSymbologyIDExtendedCode, tSktScanInteger, extraParameter), "TranslateToSsiSymbologyId(pProperty[0].Symbology.ID,ucSsiSymbologyID,ucSsiSymbologyIDExtendedCode,extraParameter)");
            }
            if (SktScanErrors.SKTSUCCESS(Result) && tSktScanInteger.m_value != 0 && !pThis[0].m_b3ByteParameterSupported) {
                Result = -15;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pData.From.bGetOperation) {
                    SsiPacket.m_Payload.uLength = 1;
                    SsiPacket.m_ucOpcode = 199;
                    SsiPacket.m_ucStatus = 0;
                } else {
                    SsiPacket.m_Payload.uLength = 3;
                    SsiPacket.m_ucOpcode = 198;
                    SsiPacket.m_ucStatus = 8;
                    if (extraParameter[0] != null) {
                        extraParameterLength = extraParameter[0].length;
                    }
                }
                if (ucSsiSymbologyIDExtendedCode.m_value != 0) {
                    SsiPacket.m_Payload.uLength++;
                }
                if (tSktScanInteger.m_value != 0) {
                    SsiPacket.m_Payload.uLength++;
                }
                SsiPacket.m_Payload.uLength += extraParameterLength;
                SsiPacket.m_uLength = (char) (SsiPacket.m_Payload.uLength + 4);
                SsiPacket.m_ucSource = 4;
                SsiPacket.m_Payload.pucData = new char[SsiPacket.m_Payload.uLength];
                if (SsiPacket.m_Payload.pucData == null) {
                    Result = -2;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    int nIndex2 = 0;
                    if (!pData.From.bGetOperation) {
                        SsiPacket.m_Payload.pucData[0] = 255;
                        nIndex2 = 0 + 1;
                    }
                    if (tSktScanInteger.m_value != 0) {
                        SsiPacket.m_Payload.pucData[nIndex2] = (char) tSktScanInteger.getValue();
                        nIndex2++;
                    }
                    if (ucSsiSymbologyIDExtendedCode.m_value != 0) {
                        SsiPacket.m_Payload.pucData[nIndex2] = (char) ucSsiSymbologyIDExtendedCode.getValue();
                        nIndex2++;
                    }
                    int nIndex3 = nIndex2 + 1;
                    SsiPacket.m_Payload.pucData[nIndex2] = (char) ucSsiSymbologyID.getValue();
                    if (!pData.From.bGetOperation) {
                        if (pProperty[0].Symbology.Status == 1) {
                            nIndex = nIndex3 + 1;
                            SsiPacket.m_Payload.pucData[nIndex3] = 1;
                        } else {
                            nIndex = nIndex3 + 1;
                            SsiPacket.m_Payload.pucData[nIndex3] = 0;
                        }
                        if (extraParameterLength > 0) {
                            int i = 0;
                            nIndex3 = nIndex;
                            while (i < extraParameterLength) {
                                SsiPacket.m_Payload.pucData[nIndex3] = extraParameter[0][i];
                                i++;
                                nIndex3++;
                            }
                        }
                        SktScanTypes.TSktScanInteger wChecksum = new SktScanTypes.TSktScanInteger(0);
                        Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(SsiPacket, wChecksum), "ComputeChecksum(SsiPacket,wChecksum)");
                        SsiPacket.m_wChecksum = wChecksum.m_value;
                    }
                    SktScanTypes.TSktScanInteger wChecksum2 = new SktScanTypes.TSktScanInteger(0);
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ComputeChecksum(SsiPacket, wChecksum2), "ComputeChecksum(SsiPacket,wChecksum)");
                    SsiPacket.m_wChecksum = wChecksum2.m_value;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pData.nDataOutSize = SsiPacket.m_uLength + 2;
                    TSktScanObject pDataOut = new TSktScanObject();
                    pData.pDataOut = pDataOut;
                    pDataOut.Property.Array.pData = new char[pData.nDataOutSize];
                    if (pData.pDataOut == null) {
                        Result = -2;
                    }
                    int[] OutSize = {pData.nDataOutSize};
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(pThis[0].TransformPacketToRawByte(SsiPacket, pDataOut.Property.Array.pData, OutSize), "pThis[0].TransformPacketToRawByte(SsiPacket,pDataout.Property.Array.pData,OutSize)");
                    }
                    pData.nDataOutSize = OutSize[0];
                    pDataOut.Property.Array.Size = pDataOut.Property.Array.pData.length;
                }
            }
            return Result;
        }
    }

    public static class TranslatePreamblePostambleFriendlyNameToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            if (SktScanErrors.SKTSUCCESS(0)) {
                long Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            long Result2 = SktDebug.DBGSKT_EVAL(pThis[0].AddPostamblePreambleOrFriendlyName(pData.f16To.ucFunctionId, pProperty[0]), "pThis[0].AddPostamblePreambleOrFriendlyName(pData.To.ucFunctionId,pProperty[0])");
            char[] value = pProperty[0].String.m_Value.toCharArray();
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                char[][] DataOut = new char[1][];
                Result2 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, value, pProperty[0].String.nLength, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,value,pProperty[0].String.nLength,DataOut,DataSize)");
                TSktScanObject pDataout = new TSktScanObject();
                pDataout.Property.Array.pData = DataOut[0];
                pData.pDataOut = pDataout;
            }
            pData.nDataOutSize = DataSize[0];
            return Result2;
        }
    }

    public static class TranslateSoundConfigToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int nDataOffset = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pData.From.bGetOperation) {
                    char[] SoundAction = {0, 0};
                    SoundAction[1] = pProperty[0].Byte;
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ConvertSoundAction(false, SoundAction, SoundAction.length), "ConvertSoundAction(false,SoundAction,SoundAction.length)");
                    pProperty[0].Byte = SoundAction[1];
                } else {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ConvertFrequency(false, pProperty[0].Array.pData, pProperty[0].Array.Size), "ConvertFrequency(false,pProperty[0].Array.pData,pProperty[0].Array.Size)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ConvertSoundAction(false, pProperty[0].Array.pData, pProperty[0].Array.Size), "ConvertSoundAction(false,pProperty[0].Array.pData,pProperty[0].Array.Size)");
                    }
                    nDataOffset = 1;
                }
            }
            int[] DataSize = {0};
            pucPropertyData[0] = new char[pProperty[0].Array.Size];
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty[0],pucPropertyData,DataSize)");
            }
            int nPropertyDataSize = DataSize[0];
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pucPropertyData[0] = arrays.copy(pucPropertyData[0], nDataOffset, pucPropertyData[0].length - nDataOffset);
            char[][] DataOut = new char[1][];
            long Result2 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize - nDataOffset, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,DataSize)");
            TSktScanObject pDataout = new TSktScanObject();
            pDataout.Property.Array.pData = DataOut[0];
            pData.pDataOut = pDataout;
            pData.nDataOutSize = DataSize[0];
            return Result2;
        }
    }

    public static class TranslateRumbleConfigToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int[] nPropertyDataSize = {0};
            int wAction = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pData.From.bGetOperation) {
                    wAction = pProperty[0].Byte;
                } else {
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, nPropertyDataSize), "RetrievePropertyData(pProperty[0],pucPropertyData,nPropertyDataSize)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        wAction = ((pucPropertyData[0][0] << 8) & 65535) + pucPropertyData[0][1];
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (wAction) {
                    case 0:
                        wAction = 2;
                        break;
                    case 1:
                        wAction = 1;
                        break;
                    case 2:
                        wAction = 4;
                        break;
                    case 3:
                        wAction = 3;
                        break;
                    default:
                        Result = -18;
                        break;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (!pData.From.bGetOperation) {
                    pucPropertyData[0][0] = (char) (wAction >> 8);
                    pucPropertyData[0][1] = (char) (wAction & 255);
                } else {
                    SktProtocolInterface.MarshallWordToPrimitive(new int[]{wAction});
                    pucPropertyData[0] = new char[2];
                    pucPropertyData[0][0] = (char) ((wAction >> 8) & 255);
                    pucPropertyData[0][1] = (char) (wAction & 255);
                    nPropertyDataSize[0] = 2;
                }
            }
            char[][] DataOut = new char[1][];
            long Result2 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize[0], DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize[0],DataOut,DataSize)");
            TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
            if (pDataout == null) {
                pDataout = new TSktScanObject();
            }
            pDataout.Property.Array.pData = DataOut[0];
            pData.pDataOut = pDataout;
            pData.nDataOutSize = DataSize[0];
            return Result2;
        }
    }

    public static class TranslateProfileConfigToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result;
            int index;
            long Result2 = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int[] nPropertyDataSize = {0};
            int wRole = 0;
            int index2 = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result2 = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result) && !pData.From.bGetOperation) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, nPropertyDataSize), "RetrievePropertyData(pProperty[0],pucPropertyData,nPropertyDataSize)");
                if (SktScanErrors.SKTSUCCESS(Result) && nPropertyDataSize[0] < 10) {
                    Result = -18;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    int index3 = 0 + 1;
                    int index4 = index3 + 1;
                    int wProfile = ((pucPropertyData[0][0] << 8) & 65535) + pucPropertyData[0][index3];
                    int index5 = index4 + 1;
                    index2 = index5 + 1;
                    wRole = ((pucPropertyData[0][index4] << 8) & 65535) + pucPropertyData[0][index5];
                    if (wProfile != 1) {
                        Result = -15;
                    }
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pThis[0].m_SsiRoleConfiguration.ucRoleFlags = 2;
                    if (wRole == 1) {
                        pThis[0].m_SsiRoleConfiguration.ucRoleType = 0;
                    } else {
                        pThis[0].m_SsiRoleConfiguration.ucRoleType = 1;
                    }
                    int i = 0;
                    while (true) {
                        index = index2;
                        if (i >= 6) {
                            break;
                        }
                        index2 = index + 1;
                        pThis[0].m_SsiRoleConfiguration.BluetoothAddress[i] = pucPropertyData[0][index];
                        i++;
                    }
                    pucPropertyData[0] = pThis[0].m_SsiRoleConfiguration.getCharArray();
                    nPropertyDataSize[0] = pThis[0].m_SsiRoleConfiguration.getLength();
                    int i2 = index;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char[][] DataOut = new char[1][];
                Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize[0], DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize[0],DataOut,DataSize)");
                TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
                if (pDataout == null) {
                    pDataout = new TSktScanObject();
                }
                pDataout.Property.Array.pData = DataOut[0];
                pData.pDataOut = pDataout;
                pData.nDataOutSize = DataSize[0];
            }
            return Result;
        }
    }

    public static class TranslateDataStoreToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int[] nPropertyDataSize = {0};
            int index = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, nPropertyDataSize), "RetrievePropertyData(pProperty[0],pucPropertyData,nPropertyDataSize)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (nPropertyDataSize[0] >= 2) {
                        int index2 = 0 + 1;
                        index = index2 + 1;
                        int wDataStoreId = ((pucPropertyData[0][0] << 8) & 65535) + pucPropertyData[0][index2];
                        nPropertyDataSize[0] = nPropertyDataSize[0] - 2;
                        if (wDataStoreId != 0) {
                            Result = -15;
                        }
                    } else {
                        Result = -18;
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result) && !pData.From.bGetOperation) {
                if (nPropertyDataSize[0] < 2) {
                    Result = -18;
                } else if (pucPropertyData[0][index] == 0) {
                    index++;
                    nPropertyDataSize[0] = nPropertyDataSize[0] - 1;
                } else {
                    Result = -18;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pucPropertyData[0] = arrays.copy(pucPropertyData[0], index, nPropertyDataSize[0]);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char[][] DataOut = new char[1][];
                Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize[0], DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize[0],DataOut,DataSize)");
                TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
                if (pDataout == null) {
                    pDataout = new TSktScanObject();
                }
                pDataout.Property.Array.pData = DataOut[0];
                pData.pDataOut = pDataout;
                pData.nDataOutSize = DataSize[0];
            }
            return Result;
        }
    }

    public static class TranslateLocalDecodeActionToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int nPropertyDataSize = 0;
            char[] LocalDecodeActionAndTriggerLockoutTime = {0, '('};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktSsiProtocol.ExtractParameter(pData, pThis, pProperty);
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (!pData.From.bGetOperation) {
                    LocalDecodeActionAndTriggerLockoutTime[1] = pThis[0].m_ucSsiTriggerLockOutTimeout;
                    if (pProperty[0].Byte == 1) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 1;
                    } else if (pProperty[0].Byte == 2) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 2;
                    } else if (pProperty[0].Byte == 4) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 4;
                    } else if (pProperty[0].Byte == 3) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 3;
                    } else if (pProperty[0].Byte == 5) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 5;
                    } else if (pProperty[0].Byte == 7) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 7;
                    } else if (pProperty[0].Byte == 6) {
                        LocalDecodeActionAndTriggerLockoutTime[0] = 6;
                    }
                    pucPropertyData[0] = LocalDecodeActionAndTriggerLockoutTime;
                    nPropertyDataSize = LocalDecodeActionAndTriggerLockoutTime.length;
                } else {
                    long Result2 = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty,pucPropertyData,DataSize)");
                    nPropertyDataSize = DataSize[0];
                }
            }
            char[][] DataOut = new char[1][];
            long Result3 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,DataSize)");
            TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
            if (pDataout == null) {
                pDataout = new TSktScanObject();
            }
            pDataout.Property.Array.pData = DataOut[0];
            pData.pDataOut = pDataout;
            pData.nDataOutSize = DataSize[0];
            return Result3;
        }
    }

    public static class TranslateLocalAcknowledgmentToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int nPropertyDataSize = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (!pData.From.bGetOperation) {
                    if (pProperty[0].Byte == 0) {
                        SktSsiProtocol.access$372(pThis[0], 207);
                        SktSsiProtocol.access$376(pThis[0], 48);
                    } else if (pProperty[0].Byte == 1) {
                        SktSsiProtocol.access$372(pThis[0], 207);
                        SktSsiProtocol.access$376(pThis[0], 16);
                    }
                    pucPropertyData[0] = new char[1];
                    pucPropertyData[0][0] = pThis[0].m_ucSsiConfigurationMode;
                    nPropertyDataSize = 1;
                } else {
                    long Result2 = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty,pucPropertyData,DataSize)");
                    nPropertyDataSize = DataSize[0];
                }
            }
            char[][] DataOut = new char[1][];
            long Result3 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,DataSize)");
            TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
            if (pDataout == null) {
                pDataout = new TSktScanObject();
            }
            pDataout.Property.Array.pData = DataOut[0];
            pData.pDataOut = pDataout;
            pData.nDataOutSize = DataSize[0];
            return Result3;
        }
    }

    public static class TranslateStartUpRoleSPPToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int nPropertyDataSize = 0;
            char[] pDataTemp = null;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (!pData.From.bGetOperation) {
                    if (pProperty[0].Byte == 0) {
                        SktSsiProtocol.access$372(pThis[0], SktSsiProtocol.kSsiScanAngle);
                        pThis[0].m_SsiRoleConfiguration.ucRoleType = 0;
                        pThis[0].m_SsiRoleConfiguration.ucRoleFlags = 2;
                        pDataTemp = new char[8];
                        pDataTemp[0] = (char) (pThis[0].m_SsiRoleConfiguration.ucRoleFlags & 255);
                        pDataTemp[1] = (char) (pThis[0].m_SsiRoleConfiguration.ucRoleType & 255);
                        for (int i = 0; i < 6; i++) {
                            pDataTemp[i + 2] = pThis[0].m_SsiRoleConfiguration.BluetoothAddress[i];
                        }
                    } else if (pProperty[0].Byte == 1) {
                        SktSsiProtocol.access$376(pThis[0], 64);
                    } else {
                        Result = -15;
                    }
                    pucPropertyData[0] = new char[1];
                    pucPropertyData[0][0] = pThis[0].m_ucSsiConfigurationMode;
                    nPropertyDataSize = 1;
                } else {
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty,pucPropertyData,DataSize)");
                    nPropertyDataSize = DataSize[0];
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char[][] DataOut = new char[1][];
                Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,DataSize)");
                TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
                if (pDataout == null) {
                    pDataout = new TSktScanObject();
                }
                pDataout.Property.Array.pData = DataOut[0];
                pDataout.Property.Array.Size = DataSize[0];
                pData.pDataOut = pDataout;
                pData.nDataOutSize = DataSize[0];
            }
            if (pDataTemp != null) {
                char[][] ppDataOut = new char[1][];
                int[] pDataOutSize = new int[1];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(SktSsiProtocol.kSsiSubCmdSetRoleConfiguration, pDataTemp, pDataTemp.length, ppDataOut, pDataOutSize), "pThis[0].FormatSocketCmd(kSsiSubCmdSetRoleConfiguration,pDataTemp,pDataTemp.length,ppDataOut,pDataOutSize)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    TSktScanObject pDataout2 = (TSktScanObject) pData.pDataOut;
                    char[] previousDataOut = pDataout2.Property.Array.pData;
                    int previousDataOutSize = pDataout2.Property.Array.Size;
                    pDataout2.Property.Array.pData = new char[(pDataOutSize[0] + previousDataOutSize)];
                    pDataout2.Property.Array.Size = pDataOutSize[0] + previousDataOutSize;
                    for (int i2 = 0; i2 < previousDataOutSize; i2++) {
                        pDataout2.Property.Array.pData[i2] = previousDataOut[i2];
                    }
                    for (int i3 = 0; i3 < pDataOutSize[0]; i3++) {
                        pDataout2.Property.Array.pData[i3 + previousDataOutSize] = ppDataOut[0][i3];
                    }
                    pData.nDataOutSize = pDataout2.Property.Array.Size;
                    ppDataOut[0] = null;
                    char[][] cArr = null;
                }
            }
            return Result;
        }
    }

    public static class TranslateDataConfirmationToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[] Byte = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pThis[0].TranslateDataConfirmationToSsiIndicator(pProperty[0].Ulong, DataSize), "pThis.TranslateDataConfirmationToSsiIndicator(pProperty[0].Ulong,DataSize)");
            }
            Byte[0] = (char) DataSize[0];
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char[][] DataOut = new char[1][];
                Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, Byte, 1, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,Byte,1,DataOut,DataSize)");
                TSktScanObject pDataout = (TSktScanObject) pData.pDataOut;
                if (pDataout == null) {
                    pDataout = new TSktScanObject();
                }
                pDataout.Property.Array.pData = DataOut[0];
                pData.pDataOut = pDataout;
            }
            pData.nDataOutSize = DataSize[0];
            return Result;
        }
    }

    public static class TranslateTriggerToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char ucSsiOpCode = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (pProperty[0].Byte) {
                    case 1:
                        ucSsiOpCode = 228;
                        break;
                    case 2:
                        ucSsiOpCode = 229;
                        break;
                    case 3:
                        ucSsiOpCode = 233;
                        break;
                    case 4:
                        ucSsiOpCode = 234;
                        break;
                    default:
                        Result = -15;
                        break;
                }
            }
            int[] dataSize = {0};
            char[][] data = new char[1][];
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            TSktScanObject DataOut = new TSktScanObject();
            pData.pDataOut = DataOut;
            long Result2 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSsiCmd(ucSsiOpCode, 0, (char[]) null, 0, data, dataSize), "pThis[0].FormatSsiCmd(ucSsiOpCode,null,0,data,DataSize)");
            DataOut.Property.Array.Size = dataSize[0];
            DataOut.Property.Array.pData = data[0];
            pData.nDataOutSize = dataSize[0];
            return Result2;
        }
    }

    public static class TranslateDisconnectToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (pProperty[0].Byte) {
                    case 0:
                        pThis[0].m_SsiRoleConfiguration.ucRoleFlags = 1;
                        break;
                    case 1:
                        pThis[0].m_SsiRoleConfiguration.ucRoleFlags = 1;
                        pThis[0].m_SsiRoleConfiguration.ucRoleType = 0;
                        break;
                    default:
                        Result = -15;
                        break;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int[] DataSize = {0};
            char[][] DataOut = new char[1][];
            long Result2 = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pThis[0].m_SsiRoleConfiguration.getCharArray(), pThis[0].m_SsiRoleConfiguration.getLength(), DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,value,RoleConfiguration.getLength(),DataOut,DataSize)");
            TSktScanObject pDataout = new TSktScanObject();
            pDataout.Property.Array.pData = DataOut[0];
            pData.pDataOut = pDataout;
            pData.nDataOutSize = DataSize[0];
            return Result2;
        }
    }

    public static class TranslateNotificationsToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int nPropertyDataSize = 0;
            char[] Data = {5, 0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (!pData.From.bGetOperation) {
                    int unused = pThis[0].m_ucLastButtonsStatus = 0;
                    Data[0] = pThis[0].m_ucSsiDeviceConfigurationModeSelect;
                    Data[1] = pThis[0].m_ucSsiDeviceConfigurationTriggerButton;
                    Data[0] = (char) (Data[0] & 127);
                    Data[1] = (char) (Data[1] & 15);
                    if ((pProperty[0].Ulong & 1) == 1) {
                        Data[0] = (char) (Data[0] | 128);
                        Data[1] = (char) (Data[1] | 192);
                    }
                    if ((pProperty[0].Ulong & 2) == 2) {
                        Result = -15;
                    }
                    if ((pProperty[0].Ulong & 4) == 4) {
                        Data[0] = (char) (Data[0] | 128);
                        Data[1] = (char) (Data[1] | ' ');
                    }
                    if ((pProperty[0].Ulong & 8) == 8) {
                        Data[0] = (char) (Data[0] | 128);
                        Data[1] = (char) (Data[1] | ' ');
                    }
                    if ((pProperty[0].Ulong & 16) == 16) {
                        Result = -15;
                    }
                    if ((pProperty[0].Ulong & 32) == 32) {
                        Result = -15;
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        long unused2 = pThis[0].m_ulNotifications = pProperty[0].Ulong;
                    }
                    pucPropertyData[0] = Data;
                    nPropertyDataSize = Data.length;
                } else {
                    Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty,pucPropertyData,DataSize)");
                    nPropertyDataSize = DataSize[0];
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                DataSize[0] = pData.nDataOutSize;
                char[][] DataOut = new char[1][];
                Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,DataSize)");
                TSktScanObject pDataout = new TSktScanObject();
                pDataout.Property.Array.pData = DataOut[0];
                pData.pDataOut = pDataout;
            }
            pData.nDataOutSize = DataSize[0];
            return Result;
        }
    }

    public static class TranslateTimersToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int wTimerMask = 0;
            int wLockout = 0;
            int wDisconnected = 0;
            int wConnected = 0;
            char[] pSsiPayload = null;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            }
            int[] DataSize = {0};
            pucPropertyData[0] = new char[pProperty[0].Array.Size];
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty,pucPropertyData,DataSize)");
            }
            int nPropertyDataSize = DataSize[0];
            if (SktScanErrors.SKTSUCCESS(Result) && !pData.From.bGetOperation) {
                if (nPropertyDataSize < 8) {
                    Result = -18;
                } else {
                    int index = 0 + 1;
                    int index2 = index + 1;
                    wTimerMask = (pucPropertyData[0][0] << 8) + pucPropertyData[0][index];
                    int index3 = index2 + 1;
                    int index4 = index3 + 1;
                    wLockout = (pucPropertyData[0][index2] << 8) + pucPropertyData[0][index3];
                    int index5 = index4 + 1;
                    int index6 = index5 + 1;
                    wDisconnected = (pucPropertyData[0][index4] << 8) + pucPropertyData[0][index5];
                    int index7 = index6 + 1;
                    int i = index7 + 1;
                    wConnected = (pucPropertyData[0][index6] << 8) + pucPropertyData[0][index7];
                    nPropertyDataSize = 4;
                    pSsiPayload = new char[4];
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pucPropertyData[0] = pSsiPayload;
                    if (wTimerMask == 1) {
                        pData.f16To.wGroupId = SktSsiProtocol.kSsiSubCmdSetLocalDecodeAction;
                        nPropertyDataSize = 2;
                        int index8 = 0 + 1;
                        pSsiPayload[0] = pThis[0].m_ucSsiLocalDecodeAction;
                        int i2 = index8 + 1;
                        pSsiPayload[index8] = (char) wLockout;
                        if (wLockout > 255) {
                            Result = -18;
                        }
                    } else if (wTimerMask == 6) {
                        int index9 = 0 + 1;
                        pSsiPayload[0] = (char) (wConnected >> 8);
                        int index10 = index9 + 1;
                        pSsiPayload[index9] = (char) (wConnected & 255);
                        int index11 = index10 + 1;
                        pSsiPayload[index10] = (char) (wDisconnected >> 8);
                        int i3 = index11 + 1;
                        pSsiPayload[index11] = (char) (wDisconnected & 255);
                    } else if (wTimerMask == 2) {
                        int index12 = 0 + 1;
                        pSsiPayload[0] = (char) (pThis[0].m_wSsiConnectedTimerOff >> 8);
                        int index13 = index12 + 1;
                        pSsiPayload[index12] = (char) pThis[0].m_wSsiConnectedTimerOff;
                        int index14 = index13 + 1;
                        pSsiPayload[index13] = (char) (wDisconnected >> 8);
                        int i4 = index14 + 1;
                        pSsiPayload[index14] = (char) (wDisconnected & 255);
                    } else if (wTimerMask == 4) {
                        int index15 = 0 + 1;
                        pSsiPayload[0] = (char) (wConnected >> 8);
                        int index16 = index15 + 1;
                        pSsiPayload[index15] = (char) (wConnected & 255);
                        int index17 = index16 + 1;
                        pSsiPayload[index16] = (char) (pThis[0].m_wSsiDisconnectedTimerOff >> 8);
                        int i5 = index17 + 1;
                        pSsiPayload[index17] = (char) (pThis[0].m_wSsiDisconnectedTimerOff & 255);
                    } else {
                        Result = -15;
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char[][] DataOut = new char[1][];
                Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSocketCmd(pData.f16To.wGroupId, pucPropertyData[0], nPropertyDataSize, DataOut, DataSize), "pThis[0].FormatSocketCmd(pData.To.wGroupId,pucPropertyData[0],nPropertyDataSize,DataOut,DataSize)");
                TSktScanObject pDataout = new TSktScanObject();
                pDataout.Property.Array.pData = DataOut[0];
                pData.pDataOut = pDataout;
            }
            pData.nDataOutSize = DataSize[0];
            return Result;
        }
    }

    public static class TranslatePreamblePostambleToSsiPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            SktScanTypes.TSktScanProperty[] pProperty = new SktScanTypes.TSktScanProperty[1];
            char[][] pucPropertyData = new char[1][];
            int nPropertyDataSize = 0;
            char[] ssiCmd = null;
            int offsetSsiCmd1 = 7;
            int offsetSsiCmd2 = 9;
            char[] setPreambleOrPostambleSsiCmd = {11, 198, 4, 8, 255, 235, 0, 'h', 10, 'j', 13};
            char[] getPreambleOrPostambleSsiCmd = {7, 199, 4, 0, 235, 'h', 'j'};
            long Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pProperty), "ExtractParameter(pData,pThis,pProperty)");
            int[] DataSize = {0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.RetrievePropertyData(pProperty[0], pucPropertyData, DataSize), "RetrievePropertyData(pProperty,pucPropertyData,DataSize)");
                nPropertyDataSize = DataSize[0];
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pData.From.bGetOperation) {
                    ssiCmd = getPreambleOrPostambleSsiCmd;
                    offsetSsiCmd1 = 5;
                    offsetSsiCmd2 = 6;
                } else {
                    ssiCmd = setPreambleOrPostambleSsiCmd;
                }
                ssiCmd[offsetSsiCmd1] = (char) (pData.f16To.wGroupId & 255);
                ssiCmd[offsetSsiCmd2] = (char) (pData.f16To.ucFunctionId & 255);
                if (!pData.From.bGetOperation) {
                    if (pProperty[0].f13ID == 327687) {
                        if (nPropertyDataSize == 0) {
                            pThis[0].RemovePrefixFromDataFormat();
                            ssiCmd[0] = 7;
                        } else {
                            pThis[0].AddPrefixInDataFormat();
                            ssiCmd[0] = 9;
                        }
                    } else if (nPropertyDataSize == 0) {
                        pThis[0].RemoveSuffix1FromDataFormat();
                        pThis[0].RemoveSuffix2FromDataFormat();
                        ssiCmd[0] = 7;
                    } else {
                        int maxChar = nPropertyDataSize;
                        if (maxChar > 2) {
                            Result = -18;
                        } else {
                            pThis[0].AddSuffix1InDataFormat();
                            if (maxChar > 1) {
                                pThis[0].AddSuffix2InDataFormat();
                            } else {
                                pThis[0].RemoveSuffix2FromDataFormat();
                                ssiCmd[0] = 9;
                            }
                        }
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        ssiCmd[6] = pThis[0].GetDataTransmissionFormatToSendToProtocol();
                        if (nPropertyDataSize > 0) {
                            ssiCmd[offsetSsiCmd1 + 1] = pucPropertyData[0][0];
                        }
                        if (nPropertyDataSize > 1) {
                            ssiCmd[offsetSsiCmd2 + 1] = pucPropertyData[0][1];
                        }
                    }
                } else if (pProperty[0].f13ID == 327687) {
                    ssiCmd[0] = 6;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            char[][] DataOut = new char[1][];
            long Result2 = SktDebug.DBGSKT_EVAL(pThis[0].FormatRawSsiCmd(ssiCmd, ssiCmd[0], DataOut, DataSize), "pThis[0].FormatRawSsiCmd(ssiCmd,ssiCmd[0],DataOut,DataSize)");
            TSktScanObject pDataout = new TSktScanObject();
            pDataout.Property.Array.pData = DataOut[0];
            pDataout.Property.Array.Size = DataSize[0];
            pData.pDataOut = pDataout;
            pData.nDataOutSize = DataSize[0];
            return Result2;
        }
    }

    public static class FillScanObjectPropertyForVersionDevice implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 6;
                if (ucLength[0] > 13) {
                    pScanObj[0].Property.Version.wYear = pPayloadData[0][2];
                    pScanObj[0].Property.Version.wYear = (pScanObj[0].Property.Version.wYear << 8) & 65535;
                    pScanObj[0].Property.Version.wYear += pPayloadData[0][3];
                    pScanObj[0].Property.Version.wMonth = pPayloadData[0][4];
                    pScanObj[0].Property.Version.wDay = pPayloadData[0][5];
                    pScanObj[0].Property.Version.wHour = pPayloadData[0][6];
                    pScanObj[0].Property.Version.wMinute = pPayloadData[0][7];
                    pScanObj[0].Property.Version.wMajor = pPayloadData[0][12];
                    pScanObj[0].Property.Version.wMiddle = pPayloadData[0][13];
                    pScanObj[0].Property.Version.wMinor = 0;
                } else {
                    Result = -39;
                }
                if (ucLength[0] > 15) {
                    pScanObj[0].Property.Version.dwBuild = pPayloadData[0][14];
                    pScanObj[0].Property.Version.dwBuild <<= 8;
                    pScanObj[0].Property.Version.dwBuild |= pPayloadData[0][15];
                } else {
                    pScanObj[0].Property.Version.dwBuild = 0;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyForDeviceType implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 3;
                if (pThis[0].m_ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeNone)) {
                    long unused = pThis[0].m_ulDeviceType = SktSsiProtocol.ConvertProductTypeToDeviceType(pPayloadData[0][11], (long) SktScanDeviceType.kSktScanDeviceTypeNone);
                }
                pScanObj[0].Property.Ulong = pThis[0].m_ulDeviceType;
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromCapabilities implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            SktSsiLastCommand pLastCommand = (SktSsiLastCommand) pData.pExtraParam;
            if (pLastCommand == null) {
                return -18;
            }
            pScanObj[0].Property.Type = 3;
            pScanObj[0].Property.Ulong = 0;
            switch (pLastCommand.GetCapabilityGroupRequest()) {
                case 1:
                    pScanObj[0].Property.Ulong = 1;
                    return Result;
                case 2:
                    if (pSsiPacket[0].m_Payload.uLength <= 13) {
                        return Result;
                    }
                    int wVersion = ((pSsiPacket[0].m_Payload.pucData[12] << 8) & 65535) + pSsiPacket[0].m_Payload.pucData[13];
                    SktDebug.DBGSKT_MSG(65, "Scanner Version:0x" + Integer.toHexString(wVersion));
                    if (wVersion < 770 || wVersion >= 773 || pSsiPacket[0].m_Payload.pucData[11] != 1) {
                        if (!SktScanErrors.SKTSUCCESS(pThis[0].CheckPropertySupport(2359567))) {
                            return Result;
                        }
                        pScanObj[0].Property.Ulong = 1;
                        return Result;
                    } else if (pSsiPacket[0].m_Payload.uLength <= 16 || (pSsiPacket[0].m_Payload.pucData[16] & 1) != 1) {
                        return Result;
                    } else {
                        pScanObj[0].Property.Ulong = 1;
                        return Result;
                    }
                default:
                    return -15;
            }
        }
    }

    public static class FillScanObjectPropertyFromDeviceSpecific implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 4;
                pScanObj[0].Property.Array.Size = pSsiPacket[0].m_uLength + 2;
                pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
                if (pScanObj[0].Property.Array.pData == null) {
                    Result = -2;
                }
                int[] OutSize = {pScanObj[0].Property.Array.Size};
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].TransformPacketToRawByte(pSsiPacket[0], pScanObj[0].Property.Array.pData, OutSize), "pThis[0].TransformPacketToRawByte(pSsiPacket,pScanObj[0].Property.Array.pData,OutSize)");
                }
                pScanObj[0].Property.Array.Size = OutSize[0];
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromSymbology implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            int[] SymbologyId = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 7;
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.TranslateFromSsiSymbologyId(pData.f16To.wGroupId, SymbologyId), "TranslateFromSsiSymbologyId(pData.To.wGroupId,SymbologyId)");
                pScanObj[0].Property.Symbology.f14ID = SymbologyId[0];
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Symbology.Flags = 1;
            int index = 2;
            if (pData.f16To.wGroupId > 255) {
                index = 2 + 1;
                if (((long) pData.f16To.wGroupId) > SktUtilities.kMaxWord) {
                    index++;
                }
            }
            if (index < ucLength[0]) {
                switch (pPayloadData[0][index]) {
                    case 0:
                        pScanObj[0].Property.Symbology.Status = 0;
                        return Result;
                    case 1:
                        pScanObj[0].Property.Symbology.Status = 1;
                        return Result;
                    default:
                        return -18;
                }
            } else {
                pScanObj[0].Property.Symbology.Status = 2;
                return Result;
            }
        }
    }

    public static class FillScanObjectPropertyFromFriendlyNameResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] Length = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, Length), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,Length)");
            }
            int ucLength = Length[0];
            pPayloadData[0] = arrays.copy(pPayloadData[0], 2, ucLength - 2);
            int ucLength2 = ucLength - 2;
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pThis[0].StoreFriendlyNamePreamblePostamble(pPayloadData[0], ucLength2), "pThis[0].StoreFriendlyNamePreamblePostamble(pPayloadData[0],ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 5;
            if (pScanObj[0].Property.f13ID == 327936) {
                if (ucLength2 <= 0) {
                    return Result;
                }
                pScanObj[0].Property.String.nLength = ucLength2;
                try {
                    int length = String.valueOf(pPayloadData[0]).indexOf(0);
                    if (length != -1) {
                        pScanObj[0].Property.String.nLength = length;
                    }
                    pScanObj[0].Property.String.m_Value = String.valueOf(pPayloadData[0], 0, pScanObj[0].Property.String.nLength);
                } catch (Exception e) {
                    SktDebug.DBGSKT_MSG(4, "SSI FriendlyName String Exception: " + e.getMessage());
                }
                SktDebug.DBGSKT_MSG(1, "SSI Fill ScanObject with FriendlyName: " + pScanObj[0].Property.String.m_Value);
                return Result;
            } else if (pScanObj[0].Property.f13ID == 327687) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    return SktDebug.DBGSKT_EVAL(pThis[0].RetrievePreamblePostambleFromFriendlyName(true, pPayloadData[0], ucLength2 - 2, pScanObj[0].Property.String), "pThis[0].RetrievePreamblePostambleFromFriendlyName(true,pPayloadData[0],ucLength-kSsiSubCmdSize,pScanObj[0].Property.String)");
                }
                return Result;
            } else if (pScanObj[0].Property.f13ID != 327688 || !SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            } else {
                return SktDebug.DBGSKT_EVAL(pThis[0].RetrievePreamblePostambleFromFriendlyName(false, pPayloadData[0], ucLength2 - 2, pScanObj[0].Property.String), "pThis[0].RetrievePreamblePostambleFromFriendlyName(false,pPayloadData[0],ucLength-kSsiSubCmdSize,pScanObj[0].Property.String)");
            }
        }
    }

    public static class FillScanObjectPropertyFromDataFormatResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            char[][] pPayloadData = new char[1][];
            int[] nLength = {0};
            SktTranslator.TSktTranslatorData tSktTranslatorData = pData;
            long result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(tSktTranslatorData, new SktSsiProtocol[1], new SktSsiPacket[1], pScanObj, pPayloadData, nLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,nLength)");
            if (!SktScanErrors.SKTSUCCESS(result)) {
                return result;
            }
            if (nLength[0] <= 2) {
                return -18;
            }
            pScanObj[0].Property.Type = 2;
            pScanObj[0].Property.Byte = pPayloadData[0][2];
            return result;
        }
    }

    public static class FillScanObjectPropertyFromAllParametersResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            SktProtocolInterface.SktChecksum Checksum = new SktProtocolInterface.SktChecksum();
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_MSG(65, "Parse Param Data for " + ucLength[0] + " bytes");
                int nMax = ucLength[0] - 1;
                for (int nIndex = 1; nIndex < nMax; nIndex++) {
                    Checksum.Add(pPayloadData[0][nIndex]);
                }
                pScanObj[0].Property.Type = 3;
                pScanObj[0].Property.Ulong = (long) Checksum.Get();
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromSecurityModeResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 2;
            if (ucLength[0] <= 2) {
                return -18;
            }
            if (pPayloadData[0][2] == 0) {
                pScanObj[0].Property.Byte = 0;
                return Result;
            } else if (pPayloadData[0][2] == 1) {
                pScanObj[0].Property.Byte = 1;
                return Result;
            } else if (pPayloadData[0][2] != 2) {
                return -23;
            } else {
                pScanObj[0].Property.Byte = 2;
                return Result;
            }
        }
    }

    public static class FillScanObjectPropertyFromButtonResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            int ButtonsResult;
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                char Buttons = pPayloadData[0][2];
                if (ucLength[0] - 2 > 1) {
                    char Buttons2 = pPayloadData[0][3];
                    ButtonsResult = 0 | SktScan.helper.SKTBUTTON_LEFTPRESSED(Buttons2 & 1) | SktScan.helper.SKTBUTTON_RIGHTPRESSED((Buttons2 & 2) >> 1) | SktScan.helper.SKTBUTTON_POWERPRESSED((Buttons2 & 4) >> 2) | SktScan.helper.SKTBUTTON_RINGDETACHED((Buttons2 & 8) >> 3);
                } else {
                    ButtonsResult = 0 | SktScan.helper.SKTBUTTON_MIDDLEPRESSED(Buttons & 1) | SktScan.helper.SKTBUTTON_POWERPRESSED((Buttons & 2) >> 1);
                }
                if (pScanObj[0].Msg.MsgID == 5) {
                    pScanObj[0].Msg.MsgID = 5;
                    pScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdButtonsStatusDevice;
                    pScanObj[0].Property.Type = 2;
                    pScanObj[0].Property.Byte = (char) ButtonsResult;
                } else {
                    pScanObj[0].Msg.MsgID = 6;
                    pScanObj[0].Msg.Event.f12ID = 3;
                    pScanObj[0].Msg.Event.Data.Type = 1;
                    pScanObj[0].Msg.Event.Data.Byte = (char) ButtonsResult;
                    SktScanTypes.TSktScanBoolean bSendNotification = new SktScanTypes.TSktScanBoolean(true);
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = pThis[0].TrapNotifications(ucLength, bSendNotification);
                    }
                    pScanObj[0].Msg.Event.Data.Byte = (char) ucLength[0];
                    if (!bSendNotification.getValue()) {
                        pScanObj[0].Msg.MsgID = 0;
                    }
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromSoundConfigurationResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] Length = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, Length), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            int ucLength = Length[0];
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 0;
            if (ucLength < 4) {
                return -18;
            }
            char wSoundAction = pPayloadData[0][2];
            int wNumberOfTones = pPayloadData[0][3] << 8;
            char wNumberOfTones2 = pPayloadData[0][4];
            if (ucLength != (wNumberOfTones2 * 6) + 1 + 2 + 2) {
                return -18;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = ucLength - 2;
            pScanObj[0].Property.Array.Size = (wNumberOfTones2 * 2 * 3) + 2 + 2;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            int nIndex = 0 + 1;
            pScanObj[0].Property.Array.pData[0] = (char) (wSoundAction >> 8);
            int nIndex2 = nIndex + 1;
            pScanObj[0].Property.Array.pData[nIndex] = (char) (wSoundAction & 255);
            int nIndex3 = nIndex2 + 1;
            pScanObj[0].Property.Array.pData[nIndex2] = (char) (wNumberOfTones2 >> 8);
            int i = nIndex3 + 1;
            pScanObj[0].Property.Array.pData[nIndex3] = (char) (wNumberOfTones2 & 255);
            for (int i2 = 0; i2 < pScanObj[0].Property.Array.Size - 4; i2++) {
                pScanObj[0].Property.Array.pData[i2 + 4] = pPayloadData[0][i2 + 5];
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ConvertFrequency(true, pScanObj[0].Property.Array.pData, pScanObj[0].Property.Array.Size), "ConvertFrequency(true,pScanObj[0].Property.Array.pData,pScanObj[0].Property.Array.Size)");
            }
            return SktScanErrors.SKTSUCCESS(Result) ? SktDebug.DBGSKT_EVAL(SktSsiProtocol.ConvertSoundAction(true, pScanObj[0].Property.Array.pData, pScanObj[0].Property.Array.Size), "ConvertSoundAction(true,pScanObj[0].Property.Array.pData,pScanObj[0].Property.Array.Size)") : Result;
        }
    }

    public static class FillScanObjectPropertyFromAutoOffTimersResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 4;
            if (ucLength[0] < 6) {
                return -18;
            }
            pScanObj[0].Property.Array.Size = 8;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            int wLockout = pThis[0].m_ucSsiTriggerLockOutTimeout;
            int index = 2 + 1;
            int index2 = index + 1;
            int wConnected = (pPayloadData[0][2] << 8) + pPayloadData[0][index];
            int index3 = index2 + 1;
            int i = index3 + 1;
            int wDisconnected = (pPayloadData[0][index2] << 8) + pPayloadData[0][index3];
            int index4 = 0 + 1;
            pScanObj[0].Property.Array.pData[0] = (char) 0;
            int index5 = index4 + 1;
            pScanObj[0].Property.Array.pData[index4] = (char) 7;
            int index6 = index5 + 1;
            pScanObj[0].Property.Array.pData[index5] = (char) (wLockout >> 8);
            int index7 = index6 + 1;
            pScanObj[0].Property.Array.pData[index6] = (char) (wLockout & 255);
            int index8 = index7 + 1;
            pScanObj[0].Property.Array.pData[index7] = (char) (wDisconnected >> 8);
            int index9 = index8 + 1;
            pScanObj[0].Property.Array.pData[index8] = (char) (wDisconnected & 255);
            int index10 = index9 + 1;
            pScanObj[0].Property.Array.pData[index9] = (char) (wConnected >> 8);
            int i2 = index10 + 1;
            pScanObj[0].Property.Array.pData[index10] = (char) (wConnected & 255);
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromConfigurationModeResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 2;
                if ((pThis[0].m_ucSsiConfigurationMode & ' ') == ' ') {
                    pScanObj[0].Property.Byte = 0;
                } else {
                    pScanObj[0].Property.Byte = 1;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyForStartUpRoleSPP implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 2;
                pScanObj[0].Property.Byte = 0;
                if ((pThis[0].m_ucSsiConfigurationMode & '@') == '@') {
                    pScanObj[0].Property.Byte = 1;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromBatteryStateResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 3;
            if (ucLength[0] < 3) {
                return -18;
            }
            pScanObj[0].Property.Ulong = (long) SktScan.helper.SKTBATTERY_SETMINLEVEL(0);
            pScanObj[0].Property.Ulong |= (long) SktScan.helper.SKTBATTERY_SETMAXLEVEL(100);
            pScanObj[0].Property.Ulong |= (long) SktScan.helper.SKTBATTERY_SETCURLEVEL(pPayloadData[0][2]);
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromLocalDecodeActionResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 2;
            if (ucLength[0] <= 2) {
                return -18;
            }
            switch (pPayloadData[0][2]) {
                case 0:
                    pScanObj[0].Property.Byte = 0;
                    return Result;
                case 1:
                    pScanObj[0].Property.Byte = 1;
                    return Result;
                case 2:
                    pScanObj[0].Property.Byte = 2;
                    return Result;
                case 3:
                    pScanObj[0].Property.Byte = 3;
                    return Result;
                case 4:
                    pScanObj[0].Property.Byte = 4;
                    return Result;
                case 5:
                    pScanObj[0].Property.Byte = 5;
                    return Result;
                case 6:
                    pScanObj[0].Property.Byte = 6;
                    return Result;
                case 7:
                    pScanObj[0].Property.Byte = 7;
                    return Result;
                default:
                    return -18;
            }
        }
    }

    public static class FillScanObjectPropertyFromDeviceAddressResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] Length = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, Length), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,Length)");
            }
            int ucLength = Length[0];
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = ucLength - 2;
            pScanObj[0].Property.Array.pData = new char[(ucLength - 2)];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            pScanObj[0].Property.Array.pData = arrays.copy(pPayloadData[0], 2, ucLength - 2);
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromStatisticResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long ulStatisticCounterIdentifier;
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 4;
            if (ucLength[0] - 2 <= 0) {
                return Result;
            }
            int wCount = (ucLength[0] - 2) / 4;
            pScanObj[0].Property.Array.Size = (wCount * 2 * 4) + 2;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            pScanObj[0].Property.Array.pData[0] = (char) ((wCount >> 8) & 255);
            pScanObj[0].Property.Array.pData[1] = (char) wCount;
            long[] statisticIdentifierList = SktSsiProtocol.StatisticIdentifier;
            if (pThis[0].m_ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeScanner8ci)) {
                statisticIdentifierList = SktSsiProtocol.StatisticIdentifierSeries8;
            }
            int nIndexSource = 2;
            int nIndex = 2;
            for (short i = 0; i < wCount; i = (short) (i + 1)) {
                if (i < statisticIdentifierList.length) {
                    ulStatisticCounterIdentifier = statisticIdentifierList[i];
                } else {
                    ulStatisticCounterIdentifier = 0;
                }
                int nIndex2 = nIndex + 1;
                pScanObj[0].Property.Array.pData[nIndex] = (char) ((int) (255 & (ulStatisticCounterIdentifier >> 24)));
                int nIndex3 = nIndex2 + 1;
                pScanObj[0].Property.Array.pData[nIndex2] = (char) ((int) (255 & (ulStatisticCounterIdentifier >> 16)));
                int nIndex4 = nIndex3 + 1;
                pScanObj[0].Property.Array.pData[nIndex3] = (char) ((int) (255 & (ulStatisticCounterIdentifier >> 8)));
                int nIndex5 = nIndex4 + 1;
                pScanObj[0].Property.Array.pData[nIndex4] = (char) ((int) (255 & ulStatisticCounterIdentifier));
                int nIndex6 = nIndex5 + 1;
                int nIndexSource2 = nIndexSource + 1;
                pScanObj[0].Property.Array.pData[nIndex5] = pPayloadData[0][nIndexSource];
                int nIndex7 = nIndex6 + 1;
                int nIndexSource3 = nIndexSource2 + 1;
                pScanObj[0].Property.Array.pData[nIndex6] = pPayloadData[0][nIndexSource2];
                int nIndex8 = nIndex7 + 1;
                int nIndexSource4 = nIndexSource3 + 1;
                pScanObj[0].Property.Array.pData[nIndex7] = pPayloadData[0][nIndexSource3];
                nIndex = nIndex8 + 1;
                nIndexSource = nIndexSource4 + 1;
                pScanObj[0].Property.Array.pData[nIndex8] = pPayloadData[0][nIndexSource4];
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromRumbleConfigurationResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            int wAction = 0;
            int wCount = 0;
            int nIndex = 2;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result) && ucLength[0] < 6) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 4;
                int nIndex2 = 2 + 1;
                int nIndex3 = nIndex2 + 1;
                wAction = ((pPayloadData[0][2] << 8) & 65535) + pPayloadData[0][nIndex2];
                int nIndex4 = nIndex3 + 1;
                nIndex = nIndex4 + 1;
                wCount = ((pPayloadData[0][nIndex3] << 8) & 65535) + pPayloadData[0][nIndex4];
                if (ucLength[0] < (wCount * 4) + 4) {
                    Result = -18;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (wAction) {
                    case 1:
                        wAction = 1;
                        break;
                    case 2:
                        wAction = 0;
                        break;
                    case 3:
                        wAction = 3;
                        break;
                    case 4:
                        wAction = 2;
                        break;
                    default:
                        SktDebug.DBGSKT_MSG(66, "Rumble Action " + wAction + " not supported");
                        Result = -18;
                        break;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Array.Size = (wCount * 2 * 2) + 4;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            pScanObj[0].Property.Array.pData[0] = (char) (wAction >> 8);
            pScanObj[0].Property.Array.pData[1] = (char) (wAction & 255);
            pScanObj[0].Property.Array.pData[2] = (char) (wCount >> 8);
            pScanObj[0].Property.Array.pData[3] = (char) (wCount & 255);
            for (int i = 0; i < wCount * 2 * 2; i++) {
                pScanObj[0].Property.Array.pData[i + 4] = pPayloadData[0][nIndex + i];
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromProfileConfigurationResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            int nIndex;
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            int wRole = 1;
            int nIndex2 = 2;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result) && ucLength[0] < 10) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int nIndex3 = 2 + 1;
                int nIndex4 = nIndex3 + 1;
                if (pPayloadData[0][nIndex3] == 1) {
                    wRole = 2;
                    nIndex2 = nIndex4;
                } else {
                    nIndex2 = nIndex4;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = 14;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            pScanObj[0].Property.Array.pData[0] = (char) 0;
            pScanObj[0].Property.Array.pData[1] = (char) 0;
            pScanObj[0].Property.Array.pData[2] = (char) (wRole >> 8);
            pScanObj[0].Property.Array.pData[3] = (char) (wRole & 255);
            int i = 0;
            while (true) {
                nIndex = nIndex2;
                if (i >= 6) {
                    break;
                }
                nIndex2 = nIndex + 1;
                pScanObj[0].Property.Array.pData[i + 4] = pPayloadData[0][nIndex];
                i++;
            }
            for (int i2 = 0; i2 < 3; i2++) {
                pScanObj[0].Property.Array.pData[i2 + 10] = 0;
            }
            int i3 = nIndex;
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromDataStoreResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result) && ucLength[0] < 3) {
                Result = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = pPayloadData[0][2] + 4;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            pScanObj[0].Property.Array.pData[3] = (char) (pPayloadData[0][2] & 255);
            for (int i = 0; i < pPayloadData[0][2]; i++) {
                pScanObj[0].Property.Array.pData[i + 4] = pPayloadData[0][i + 3];
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyForNotifications implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 3;
                pScanObj[0].Property.Ulong = 0;
                char ucModeSelect = pPayloadData[0][2];
                char ucTriggerSelect = pPayloadData[0][3];
                if ((ucModeSelect & 128) == 128) {
                    if ((ucTriggerSelect & ' ') == ' ') {
                        pScanObj[0].Property.Ulong |= pThis[0].m_ulNotifications;
                    }
                    if ((ucTriggerSelect & '@') == '@') {
                        pScanObj[0].Property.Ulong |= 1;
                    }
                    if ((ucTriggerSelect & 128) == 128) {
                        pScanObj[0].Property.Ulong |= 1;
                    }
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromDecodedData implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            int nBarcodeLength = 0;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                nBarcodeLength = ucLength[0] - 1;
                pScanObj[0].Msg.MsgID = 6;
                pScanObj[0].Msg.Event.f12ID = 1;
                pScanObj[0].Msg.Event.Data.Type = 5;
                pScanObj[0].Msg.Event.Data.DecodedData.SymbologyID = SktSsiProtocol.ConvertDecodedSymbolgy(pPayloadData[0][0]);
                pScanObj[0].Msg.Event.Data.DecodedData.String.nLength = nBarcodeLength;
                pScanObj[0].Msg.Event.Data.DecodedData.String.nLength += pThis[0].m_nPreambleLength;
                pScanObj[0].Msg.Event.Data.DecodedData.String.nLength += pThis[0].m_nPostambleLength;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                StringBuffer decodedBarcode = new StringBuffer(pThis[0].m_nPreambleLength + nBarcodeLength + pThis[0].m_nPostambleLength + 2);
                if (pThis[0].m_nPreambleLength > 0) {
                    decodedBarcode.append(pThis[0].m_pszPreamble);
                }
                decodedBarcode.append(pPayloadData[0], 1, nBarcodeLength);
                if (pThis[0].m_nPostambleLength > 0) {
                    decodedBarcode.append(pThis[0].m_pszPostamble);
                }
                pScanObj[0].Msg.Event.Data.DecodedData.String.m_Value = decodedBarcode.toString();
            }
            if (pThis[0].m_wSsiVersionMajorMinor < 770 || pThis[0].m_ulDeviceType != ((long) SktScanDeviceType.kSktScanDeviceTypeScanner7)) {
                SktBufferAndCommand pBuffer = new SktBufferAndCommand();
                pBuffer.m_CommandInfo.SetResponseExpected(false);
                char[][] data = new char[1][];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].FormatSsiCmd(208, 0, (char[]) null, 0, data, ucLength), "pThis[0].FormatSsiCmd((char)kSsiOpcodeCmdAck,null,0,pBuffer.m_pucData,ucLength)");
                }
                pBuffer.m_pucData = data[0];
                pBuffer.m_nLength = ucLength[0];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pThis[0].AddDataWriteBuffer(false, 4456451, pBuffer), "pThis[0].AddDataWriteBuffer(false,ISktScanProperty.propId.kSktScanPropIdDeviceSpecific,pBuffer)");
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromParamSendResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 0;
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromNakResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = {new char[]{0}};
            int[] ucLength = {0};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, pPayloadData, ucLength), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 0;
                switch (pPayloadData[0][0]) {
                    case 2:
                        pScanObj[0].Msg.Result = -39;
                        break;
                    case 6:
                        pScanObj[0].Msg.Result = -37;
                        break;
                    default:
                        pScanObj[0].Msg.Result = -38;
                        break;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromAckResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktSsiPacket[] pSsiPacket = new SktSsiPacket[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(pData, pThis, pSsiPacket, pScanObj, (char[][]) null, (int[]) null), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,null,null)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 0;
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromPreamble implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = new char[1][];
            SktTranslator.TSktTranslatorData tSktTranslatorData = pData;
            long result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(tSktTranslatorData, pThis, new SktSsiPacket[1], pScanObj, pPayloadData, new int[]{0}), "ExtractParameter(pData,&pThis,&pSsiPacket,&pScanObj,&pPayloadData,&ucLength)");
            if (SktScanErrors.SKTSUCCESS(result)) {
                pScanObj[0].Property.Type = 5;
                pScanObj[0].Property.String.nLength = pThis[0].GetPrefixSize();
                if (pScanObj[0].Property.String.nLength > 0) {
                    pScanObj[0].Property.String.m_Value = String.valueOf(pPayloadData[0], 0, pScanObj[0].Property.String.nLength);
                }
            }
            return result;
        }
    }

    public static class FillScanObjectPropertyFromPostamble implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktSsiProtocol[] pThis = new SktSsiProtocol[1];
            char[][] pPayloadData = new char[1][];
            SktTranslator.TSktTranslatorData tSktTranslatorData = pData;
            long result = SktDebug.DBGSKT_EVAL(SktSsiProtocol.ExtractParameter(tSktTranslatorData, pThis, new SktSsiPacket[1], pScanObj, pPayloadData, new int[]{0}), "ExtractParameter(pData,pThis,pSsiPacket,pScanObj,pPayloadData,ucLength)");
            if (SktScanErrors.SKTSUCCESS(result)) {
                pScanObj[0].Property.Type = 5;
                pScanObj[0].Property.String.nLength = pThis[0].GetSuffixSize();
                if (pScanObj[0].Property.String.nLength > 0) {
                    switch (pThis[0].m_ucSsiDataTransmissionFormat) {
                        case 17:
                            pScanObj[0].Property.String.m_Value = "\r";
                            StringBuilder sb = new StringBuilder();
                            SktScanTypes.TSktScanString tSktScanString = pScanObj[0].Property.String;
                            tSktScanString.m_Value = sb.append(tSktScanString.m_Value).append("\n").toString();
                            break;
                        case 18:
                            pScanObj[0].Property.String.m_Value = "\r";
                            break;
                        case 19:
                            pScanObj[0].Property.String.m_Value = "\n";
                            break;
                        default:
                            pScanObj[0].Property.String.m_Value = String.valueOf(pPayloadData[0], 4, 1);
                            if (pScanObj[0].Property.String.nLength > 1) {
                                StringBuilder sb2 = new StringBuilder();
                                SktScanTypes.TSktScanString tSktScanString2 = pScanObj[0].Property.String;
                                tSktScanString2.m_Value = sb2.append(tSktScanString2.m_Value).append(String.valueOf(pPayloadData[0], 6, 1)).toString();
                                break;
                            }
                            break;
                    }
                }
            }
            return result;
        }
    }

    public static class SaveConfigurationMode implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            int nIndex = 2;
            if ((((pData.pPacket.m_Payload.pucData[0] << 8) & 65535) | pData.pPacket.m_Payload.pucData[1]) == 296) {
                nIndex = 2 + 1;
            }
            if (nIndex < pData.pPacket.m_Payload.pucData.length) {
                char unused = pData.pThis.m_ucSsiConfigurationMode = pData.pPacket.m_Payload.pucData[nIndex];
            }
            return 0;
        }
    }

    public static class SaveDeviceConfiguration implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            char unused = pData.pThis.m_ucSsiDeviceConfigurationModeSelect = pData.pPacket.m_Payload.pucData[2];
            if (pData.pPacket.m_Payload.pucData.length < 4) {
                char unused2 = pData.pThis.m_ucSsiDeviceConfigurationTriggerButton = 253;
            } else {
                char unused3 = pData.pThis.m_ucSsiDeviceConfigurationTriggerButton = pData.pPacket.m_Payload.pucData[3];
            }
            return 0;
        }
    }

    public static class SaveDeviceVersionTypeAndFeature implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            long Result = 0;
            char unused = pData.pThis.m_ucSsiVersionMajor = 0;
            char unused2 = pData.pThis.m_ucSsiVersionMinor = 0;
            char unused3 = pData.pThis.m_ucSsiSupportedFeatures = 0;
            char unused4 = pData.pThis.m_wSsiVersionMajorMinor = 0;
            if (pData.pPacket.m_Payload.uLength > 11 && pData.pThis.m_ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeNone)) {
                long unused5 = pData.pThis.m_ulDeviceType = SktSsiProtocol.ConvertProductTypeToDeviceType(pData.pPacket.m_Payload.pucData[11], (long) SktScanDeviceType.kSktScanDeviceTypeNone);
            }
            if (pData.pPacket.m_Payload.uLength > 13) {
                char unused6 = pData.pThis.m_ucSsiVersionMajor = pData.pPacket.m_Payload.pucData[12];
                char unused7 = pData.pThis.m_ucSsiVersionMinor = pData.pPacket.m_Payload.pucData[13];
            }
            char unused8 = pData.pThis.m_wSsiVersionMajorMinor = pData.pThis.m_ucSsiVersionMajor;
            SktSsiProtocol.access$1660(pData.pThis, 8);
            SktSsiProtocol.access$1612(pData.pThis, pData.pThis.m_ucSsiVersionMinor);
            if (pData.pPacket.m_Payload.uLength > 16) {
                char unused9 = pData.pThis.m_ucSsiSupportedFeatures = pData.pPacket.m_Payload.pucData[16];
            }
            char unused10 = pData.pThis.m_ucCapabilityFriendlyName = 0;
            if (pData.pThis.m_wSsiVersionMajorMinor < 770 || pData.pThis.m_ulDeviceType != ((long) SktScanDeviceType.kSktScanDeviceTypeScanner7)) {
                char unused11 = pData.pThis.m_ucCapabilityFriendlyName = 1;
            }
            if (pData.pPacket.m_Payload.uLength > 17) {
                if (pData.pThis.m_wSsiVersionMajorMinor < 773) {
                    SktDebug.DBGSKT_MSG(1, "About to read Capabilities");
                    Result = SktDebug.DBGSKT_EVAL(pData.pThis.ReadCapabilities(pData.pPacket.m_Payload.pucData, 17, pData.pPacket.m_Payload.uLength), "pData.pThis.ReadCapabilities(pData.pPacket.m_Payload.pucData,kSelfTestExCapabilities,pData.pPacket.m_Payload.ucLength)");
                } else {
                    boolean bKnownVersion = false;
                    int i = 0;
                    while (true) {
                        if (i >= SktSsiProtocol.EngineVersions.length) {
                            break;
                        }
                        SupportedEngineVersion pEngineVersion = SktSsiProtocol.EngineVersions[i];
                        bKnownVersion = SktSsiProtocol.CompareVersion(pData.pPacket.m_Payload.pucData[19], pData.pPacket.m_Payload.pucData, 20, pEngineVersion.pszVersion.length, pEngineVersion.pszVersion);
                        if (bKnownVersion) {
                            boolean unused12 = pData.pThis.m_bEngine655V4 = pEngineVersion.engineType == 0;
                            boolean unused13 = pData.pThis.m_b3ByteParameterSupported = pEngineVersion.engineType == 3;
                            if (pData.pThis.m_bEngine655V4) {
                                int j = 0;
                                char k = pData.pPacket.m_Payload.pucData[19];
                                while (j < k && pData.pPacket.m_Payload.pucData[j + 20] != '-') {
                                    j++;
                                }
                                int j2 = j + 1;
                                if (j2 < pData.pPacket.m_Payload.pucData[19]) {
                                    String sVersion = new String();
                                    while (true) {
                                        if (!(pData.pPacket.m_Payload.pucData[j2 + 20] >= '0') || !(pData.pPacket.m_Payload.pucData[j2 + 20] <= '9')) {
                                            break;
                                        }
                                        sVersion = sVersion + pData.pPacket.m_Payload.pucData[j2 + 20];
                                        j2++;
                                    }
                                    boolean unused14 = pData.pThis.m_bEngine655V4 = Integer.parseInt(sVersion) >= 4;
                                    SktDebug.DBGSKT_MSG(65, "This is a 655 based scanner, engine rev " + sVersion + " (should be > " + Integer.toString(4) + "\"");
                                } else {
                                    SktDebug.DBGSKT_MSG(65, "Valid Engine version string not found...");
                                }
                            }
                        } else {
                            i++;
                        }
                    }
                    if (!bKnownVersion) {
                        SktDebug.DBGSKT_MSG(65, "This version is not known we assume it's a regular scanner not based on SE655, check if the suffix is working correctly");
                    }
                }
            }
            if (pData.pThis.m_wSsiVersionMajorMinor >= 1024) {
                boolean unused15 = pData.pThis.m_bOutdatedScanAPI = true;
            }
            SktDebug.DBGSKT_MSG(1, "Device Version: 0x" + Integer.toHexString(pData.pThis.m_wSsiVersionMajorMinor));
            return Result;
        }
    }

    public static class SaveLocalDecodeAction implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            if (pData.pPacket.m_Payload.uLength >= 4) {
                char unused = pData.pThis.m_ucSsiLocalDecodeAction = pData.pPacket.m_Payload.pucData[2];
                char unused2 = pData.pThis.m_ucSsiTriggerLockOutTimeout = pData.pPacket.m_Payload.pucData[3];
            }
            return 0;
        }
    }

    public static class SaveDisconnectedConnectedOffTimers implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            if (pData.pPacket.m_Payload.uLength >= 6) {
                int index = 2 + 1;
                int unused = pData.pThis.m_wSsiConnectedTimerOff = pData.pPacket.m_Payload.pucData[2];
                SktSsiProtocol.access$960(pData.pThis, 8);
                int index2 = index + 1;
                SktSsiProtocol.access$912(pData.pThis, pData.pPacket.m_Payload.pucData[index]);
                int index3 = index2 + 1;
                int unused2 = pData.pThis.m_wSsiDisconnectedTimerOff = pData.pPacket.m_Payload.pucData[index2];
                SktSsiProtocol.access$1060(pData.pThis, 8);
                int i = index3 + 1;
                SktSsiProtocol.access$1012(pData.pThis, pData.pPacket.m_Payload.pucData[index3]);
            }
            return 0;
        }
    }

    public static class SaveDataTransmissionFormat implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            boolean bVersionC = pData.pThis.m_bEngine655V4;
            if (bVersionC && pData.pThis.m_ucCapabilityFriendlyName != 0) {
                bVersionC = false;
            }
            if (pData.pPacket.m_ucOpcode == 198) {
                pData.pThis.SetDataTransmissionFormatReceivedFromProtocol(bVersionC, pData.pPacket.m_Payload.pucData[2]);
            } else {
                pData.pThis.SetDataTransmissionFormatReceivedFromProtocol(bVersionC, pData.pPacket.m_Payload.pucData[0]);
            }
            return 0;
        }
    }

    public static class SaveRoleConfiguration implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            if (pData.pPacket.m_Payload.uLength < pData.pThis.m_SsiRoleConfiguration.getLength() + 2) {
                return -18;
            }
            TSktSsiRoleConfiguration role = pData.pThis.m_SsiRoleConfiguration;
            int index = 2 + 1;
            role.ucRoleFlags = pData.pPacket.m_Payload.pucData[2];
            int index2 = index + 1;
            role.ucRoleType = pData.pPacket.m_Payload.pucData[index];
            int i = 0;
            while (true) {
                int index3 = index2;
                if (i >= 6) {
                    return 0;
                }
                index2 = index3 + 1;
                role.BluetoothAddress[i] = pData.pPacket.m_Payload.pucData[index3];
                i++;
            }
        }
    }

    public static class SaveDeviceDetails implements ISktSaveValueFunction {
        public long SktSaveValueFunction(TSaveValueData pData) {
            SktDebug.DBGSKT_MSG(65, "Calling SaveDeviceDetails payload size: " + pData.pPacket.m_Payload.uLength);
            if (pData.pPacket.m_Payload.uLength >= 2) {
                int i = 2 + 1;
                long unused = pData.pThis.m_ulDeviceType = SktSsiProtocol.ConvertProductTypeToDeviceType(pData.pPacket.m_Payload.pucData[2], (long) SktScanDeviceType.kSktScanDeviceTypeNone);
                if (pData.pThis.m_ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeScanner8ci)) {
                    boolean unused2 = pData.pThis.m_bEngine655V4 = true;
                }
            }
            return 0;
        }
    }

    public static class MaskForDeviceConfigAckActivation implements SktProtocolInterface.TSktPropertyMaskFunction {
        public long MaskFunction(SktProtocolInterface pThis, SktScanTypes.TSktScanProperty pProperty) {
            SktSsiProtocol pThisProtocol = (SktSsiProtocol) pThis;
            if (pThisProtocol == null || pProperty == null || pProperty.Type != 4 || pProperty.Array.Size < 6) {
                return -18;
            }
            SktSsiProtocol.access$576(pThisProtocol, 4);
            pProperty.Array.pData[6] = pThisProtocol.m_ucSsiDeviceConfigurationModeSelect;
            return 0;
        }
    }

    protected static long ExtractParameter(SktTranslator.TSktTranslatorData pData, SktSsiProtocol[] ppThis, SktScanTypes.TSktScanProperty[] ppProperty) {
        if (pData == null || ppThis == null || ppProperty == null) {
            return -18;
        }
        ppThis[0] = (SktSsiProtocol) pData.pThis;
        ppProperty[0] = (SktScanTypes.TSktScanProperty) pData.pDataIn;
        if (ppThis == null || ppProperty[0] == null) {
            return -18;
        }
        return 0;
    }

    protected static long ExtractParameter(SktTranslator.TSktTranslatorData pData, SktSsiProtocol[] ppThis, SktSsiPacket[] ppSsiPacket, TSktScanObject[] ppScanObj, char[][] ppPayload, int[] pnSize) {
        long Result = 0;
        if (pData == null || ppThis == null || ppSsiPacket == null || ppScanObj == null) {
            return -18;
        }
        ppThis[0] = (SktSsiProtocol) pData.pThis;
        ppSsiPacket[0] = (SktSsiPacket) pData.pDataIn;
        ppScanObj[0] = (TSktScanObject) pData.pDataOut;
        if (ppThis == null || ppSsiPacket == null || ppScanObj == null) {
            Result = -18;
        }
        if (ppPayload == null || pnSize == null) {
            return Result;
        }
        if (ppSsiPacket[0].m_Payload.pucData == null) {
            ppPayload[0] = null;
            pnSize[0] = 0;
        } else {
            ppPayload[0] = ppSsiPacket[0].m_Payload.pucData;
            pnSize[0] = ppSsiPacket[0].m_Payload.pucData.length;
        }
        if (ppPayload[0] != null || pnSize[0] <= 0) {
            return Result;
        }
        return -18;
    }

    protected static long ComputeChecksum(SktSsiPacket pSsiPacket, SktScanTypes.TSktScanInteger pwChecksum) {
        long Result = 0;
        if (pSsiPacket == null || pwChecksum == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pwChecksum.setValue(65536);
        pwChecksum.setValue(pwChecksum.getValue() - pSsiPacket.m_uLength);
        pwChecksum.setValue(pwChecksum.getValue() - pSsiPacket.m_ucOpcode);
        pwChecksum.setValue(pwChecksum.getValue() - pSsiPacket.m_ucSource);
        pwChecksum.setValue(pwChecksum.getValue() - pSsiPacket.m_ucStatus);
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.Eval(ComputeChecksum(pSsiPacket.m_Payload.pucData, pSsiPacket.m_Payload.uLength, pwChecksum), "ComputeChecksum(pSsiPacket.Payload.pucData,pSsiPacket.Payload.ucLength,wChecksum)");
        }
        return Result;
    }

    protected static long ComputeChecksum(char[] pData, int nSize, SktScanTypes.TSktScanInteger pwChecksum) {
        long Result = 0;
        if ((pData == null && nSize > 0) || pwChecksum == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int wChecksum = pwChecksum.getValue();
            for (int i = 0; i < nSize; i++) {
                wChecksum -= pData[i];
            }
            pwChecksum.setValue(wChecksum);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long TransformPacketToRawByte(SktSsiPacket pSsiPacket, char[] pucData, int[] pnDataSize) {
        long Result = 0;
        if (pSsiPacket == null || pucData == null || pnDataSize == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pnDataSize[0] < pSsiPacket.m_uLength + 2) {
                Result = -26;
            }
            pnDataSize[0] = pSsiPacket.m_uLength + 2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktScanTypes.TSktScanInteger Index = new SktScanTypes.TSktScanInteger(pnDataSize[0]);
            Result = SktDebug.DBGSKT_EVAL(pSsiPacket.CopyHeaderToBuffer(pucData, Index), "pSsiPacket.CopyHeaderToBuffer(pucData,Index)");
            int nIndex = Index.getValue();
            if (pSsiPacket.m_uLength > 4) {
                int i = 0;
                while (i < pSsiPacket.m_Payload.uLength) {
                    pucData[nIndex] = pSsiPacket.m_Payload.pucData[i];
                    i++;
                    nIndex++;
                }
            }
            int nIndex2 = nIndex + 1;
            pucData[nIndex] = (char) ((pSsiPacket.m_wChecksum >> 8) & 255);
            int i2 = nIndex2 + 1;
            pucData[nIndex2] = (char) (pSsiPacket.m_wChecksum & 255);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(SaveValue(pSsiPacket), "SaveValue(pSsiPacket)");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long TransformRawByteToPacket(SktStream pInputStream, int nPacketSize, SktSsiPacket pSsiPacket) {
        long Result = 0;
        char[] pucData = null;
        SktScanTypes.TSktScanInteger nIndex = new SktScanTypes.TSktScanInteger(0);
        if (pInputStream != null) {
            char[] Data = pInputStream.GetData();
            pucData = new char[Data.length];
            for (int i = 0; i < Data.length; i++) {
                pucData[i] = Data[i];
            }
        }
        if (pSsiPacket == null || pucData == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && nPacketSize < String.valueOf(pSsiPacket.m_wChecksum).length() + 4) {
            Result = -26;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            nIndex.setValue(pInputStream.GetDataSize());
            Result = SktDebug.DBGSKT_EVAL(pSsiPacket.CopyBufferToHeader(pucData, nIndex), "pSsiPacket.CopyBufferToHeader(pucData,nIndex)");
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pSsiPacket.m_uLength > 4) {
            pSsiPacket.m_Payload.uLength = (char) (pSsiPacket.m_uLength - 4);
            pSsiPacket.m_Payload.pucData = new char[pSsiPacket.m_Payload.uLength];
            if (pSsiPacket.m_Payload.pucData != null) {
                int index = nIndex.getValue();
                for (int i2 = 0; i2 < pSsiPacket.m_Payload.uLength; i2++) {
                    pSsiPacket.m_Payload.pucData[i2] = pucData[index + i2];
                }
                nIndex.setValue(pSsiPacket.m_Payload.uLength + index);
            } else {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pSsiPacket.m_wChecksum = pucData[nIndex.getValue()];
            pSsiPacket.m_wChecksum = (pSsiPacket.m_wChecksum << 8) & 65535;
            pSsiPacket.m_wChecksum |= pucData[nIndex.getValue() + 1];
            long Result2 = SktDebug.DBGSKT_EVAL(pInputStream.Discard(nPacketSize), "pInputStream.Discard(nPacketSize)");
        }
        return SktDebug.DBGSKT_EVAL(SaveValue(pSsiPacket), "SaveValue(pSsiPacket)");
    }

    /* access modifiers changed from: protected */
    public long CheckIfPacketIsComplete(SktStream pInputStream, SktScanTypes.TSktScanInteger pnPacketSizeFound, SktScanTypes.TSktScanInteger pPacketCompleteState) {
        int max;
        long Result = 0;
        char[] pucData = null;
        int nDataSize = 0;
        if (pInputStream != null) {
            pucData = pInputStream.GetData();
            nDataSize = pInputStream.GetDataSize();
        }
        if (pucData == null || pnPacketSizeFound == null || pPacketCompleteState == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pPacketCompleteState.setValue(0);
        pnPacketSizeFound.setValue(0);
        if (nDataSize <= 0) {
            return Result;
        }
        SktDebug.DBGSKT_MSG(1, "SSI Protocol about to check if the packet is complete DataSize:" + nDataSize);
        char nSize = pucData[0];
        if (nSize < 4) {
            boolean discard = true;
            if (nSize == this.BTISCP_RESPONSE[0]) {
                if (nDataSize > this.BTISCP_RESPONSE.length) {
                    max = this.BTISCP_RESPONSE.length;
                } else {
                    max = nDataSize;
                }
                if (arrays.equals(pucData, 0, this.BTISCP_RESPONSE, 0, max)) {
                    discard = false;
                    if (nDataSize >= this.BTISCP_RESPONSE.length) {
                        pPacketCompleteState.setValue(2);
                        SktDebug.DBGSKT_MSG(2, "Ask to discard a packet because wrong protocol");
                        Result = SktDebug.DBGSKT_EVAL(pInputStream.Discard(pInputStream.GetDataSize()), "pInputStream.Discard(pInputStream.GetDataSize())");
                    }
                }
            }
            if (!discard) {
                return Result;
            }
            SktDebug.DBGSKT_MSG(2, "Ask to discard a packet because incorrect Size:" + nSize);
            long Result2 = SktDebug.DBGSKT_EVAL(pInputStream.Discard(pInputStream.GetDataSize()), "pInputStream.Discard(pInputStream.GetDataSize())");
            pPacketCompleteState.setValue(3);
            return Result2;
        } else if (nSize + 2 <= nDataSize) {
            int wChecksum = 65536;
            for (int i = 0; i < nSize; i++) {
                wChecksum -= pucData[i];
            }
            int wchecksum1 = wChecksum >> 8;
            int wchecksum2 = wChecksum & 255;
            char pucData1 = pucData[nSize];
            int pucData2 = pucData[nSize + 1] & 255;
            if (pucData1 == wchecksum1 && pucData2 == wchecksum2) {
                pPacketCompleteState.setValue(1);
                pnPacketSizeFound.setValue(nSize + 2);
                return Result;
            }
            SktDebug.DBGSKT_MSG(2, "Ask to discard a packet because incorrect checksum 0x" + Integer.toHexString(wChecksum) + "!=" + "0x" + Integer.toHexString(pucData[nSize]) + Integer.toHexString(pucData[nSize + 1]));
            long Result3 = SktDebug.DBGSKT_EVAL(pInputStream.Discard(pInputStream.GetDataSize()), "pInputStream.Discard(pInputStream.GetDataSize())");
            pPacketCompleteState.setValue(3);
            return Result3;
        } else if (nSize < 4 || pucData[2] == 0 || pucData[2] == 4) {
            return Result;
        } else {
            SktDebug.DBGSKT_MSG(2, "Ask to discard a packet because incorrect Source (Engine in Raw mode?)");
            return SktDebug.DBGSKT_EVAL(pInputStream.Discard(pInputStream.GetDataSize()), "pInputStream.Discard(pInputStream.GetDataSize())");
        }
    }

    /* access modifiers changed from: protected */
    public long FormatRawSsiCmd(char[] pucParam, int nParamLength, char[][] ppucBlockData, int[] pnBlockSize) {
        long Result = 0;
        SktScanTypes.TSktScanInteger wChecksum = new SktScanTypes.TSktScanInteger(65536);
        if (pnBlockSize == null || ppucBlockData[0] != null || pucParam == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pnBlockSize[0] = nParamLength + 2;
            ppucBlockData[0] = new char[pnBlockSize[0]];
            for (int i = 0; i < nParamLength; i++) {
                ppucBlockData[0][i] = pucParam[i];
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ComputeChecksum(ppucBlockData[0], nParamLength, wChecksum), "ComputeChecksum(ppucBlockData[0],nParamLength,wChecksum)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppucBlockData[0][nParamLength] = (char) ((wChecksum.getValue() >> 8) & 255);
            ppucBlockData[0][nParamLength + 1] = (char) (wChecksum.getValue() & 255);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0102, code lost:
        r8 = r7 + 1;
        r4.m_Payload.pucData[r7] = (char) ((r18 >> 8) & 255);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long FormatSsiCmd(char r17, int r18, char[] r19, int r20, char[][] r21, int[] r22) {
        /*
            r16 = this;
            r2 = 0
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiPacket r4 = new com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiPacket
            r4.<init>()
            r9 = 0
            r5 = 0
            r7 = 0
            if (r22 == 0) goto L_0x000e
            if (r21 != 0) goto L_0x0010
        L_0x000e:
            r2 = -18
        L_0x0010:
            boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r11 == 0) goto L_0x0078
            if (r18 <= 0) goto L_0x002d
            r9 = 1
            r11 = 255(0xff, float:3.57E-43)
            r0 = r18
            if (r0 <= r11) goto L_0x002d
            int r9 = r9 + 1
            r0 = r18
            long r12 = (long) r0
            r14 = 65535(0xffff, double:3.23786E-319)
            int r11 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r11 <= 0) goto L_0x002d
            int r9 = r9 + 1
        L_0x002d:
            int r11 = r20 + 4
            int r11 = r11 + r9
            char r11 = (char) r11
            r4.m_uLength = r11
            r0 = r17
            r4.m_ucOpcode = r0
            r11 = 4
            r4.m_ucSource = r11
            r11 = 0
            r4.m_ucStatus = r11
            r11 = 198(0xc6, float:2.77E-43)
            r0 = r17
            if (r0 != r11) goto L_0x004b
            r5 = 1
            char r11 = r4.m_ucStatus
            r11 = r11 | 8
            char r11 = (char) r11
            r4.m_ucStatus = r11
        L_0x004b:
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            int r12 = r20 + r9
            char r12 = (char) r12
            r11.uLength = r12
            r11 = 1
            if (r5 != r11) goto L_0x0063
            int r11 = r4.m_uLength
            int r11 = r11 + 1
            r4.m_uLength = r11
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            int r12 = r11.uLength
            int r12 = r12 + 1
            r11.uLength = r12
        L_0x0063:
            if (r20 <= 0) goto L_0x0078
            if (r19 == 0) goto L_0x0078
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            int r12 = r20 + 2
            int r12 = r12 + r9
            char[] r12 = new char[r12]
            r11.pucData = r12
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            char[] r11 = r11.pucData
            if (r11 != 0) goto L_0x00ce
            r2 = -2
        L_0x0078:
            com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r10 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
            r11 = 65536(0x10000, float:9.18355E-41)
            r10.<init>(r11)
            boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r11 == 0) goto L_0x008f
            long r12 = ComputeChecksum(r4, r10)
            java.lang.String r11 = "ComputeChecksum(SsiPacket,wChecksum)"
            long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r12, r11)
        L_0x008f:
            int r11 = r10.getValue()
            r4.m_wChecksum = r11
            boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r11 == 0) goto L_0x00cd
            r11 = 0
            r11 = r21[r11]
            if (r11 != 0) goto L_0x00af
            r11 = 0
            int r12 = r4.m_uLength
            int r12 = r12 + 2
            r22[r11] = r12
            r11 = 0
            r12 = 0
            r12 = r22[r12]
            char[] r12 = new char[r12]
            r21[r11] = r12
        L_0x00af:
            r11 = 0
            r11 = r21[r11]
            if (r11 != 0) goto L_0x00b6
            r2 = -2
        L_0x00b6:
            boolean r11 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r11 == 0) goto L_0x00cd
            r11 = 0
            r11 = r21[r11]
            r0 = r16
            r1 = r22
            long r12 = r0.TransformPacketToRawByte(r4, r11, r1)
            java.lang.String r11 = "TransformPacketToRawByte(SsiPacket,ppucBlockData,pnBlockSize)"
            long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r12, r11)
        L_0x00cd:
            return r2
        L_0x00ce:
            r11 = 1
            if (r5 != r11) goto L_0x0123
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            char[] r11 = r11.pucData
            int r8 = r7 + 1
            r12 = 255(0xff, float:3.57E-43)
            r11[r7] = r12
        L_0x00db:
            if (r9 <= 0) goto L_0x00e0
            switch(r9) {
                case 1: goto L_0x010f;
                case 2: goto L_0x0121;
                case 3: goto L_0x00f5;
                default: goto L_0x00e0;
            }
        L_0x00e0:
            r7 = r8
            r6 = 0
            r8 = r7
        L_0x00e3:
            r0 = r20
            if (r6 >= r0) goto L_0x011e
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            char[] r11 = r11.pucData
            int r7 = r8 + 1
            char r12 = r19[r6]
            r11[r8] = r12
            int r6 = r6 + 1
            r8 = r7
            goto L_0x00e3
        L_0x00f5:
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            char[] r11 = r11.pucData
            int r7 = r8 + 1
            int r12 = r18 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            char r12 = (char) r12
            r11[r8] = r12
        L_0x0102:
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            char[] r11 = r11.pucData
            int r8 = r7 + 1
            int r12 = r18 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            char r12 = (char) r12
            r11[r7] = r12
        L_0x010f:
            r7 = r8
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r11 = r4.m_Payload
            char[] r11 = r11.pucData
            int r8 = r7 + 1
            r0 = r18
            r12 = r0 & 255(0xff, float:3.57E-43)
            char r12 = (char) r12
            r11[r7] = r12
            goto L_0x00e0
        L_0x011e:
            r7 = r8
            goto L_0x0078
        L_0x0121:
            r7 = r8
            goto L_0x0102
        L_0x0123:
            r8 = r7
            goto L_0x00db
        */
        throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktSsiProtocol.FormatSsiCmd(char, int, char[], int, char[][], int[]):long");
    }

    /* access modifiers changed from: protected */
    public long FormatSocketCmd(int nCommand, char[] pucParam, int nParamLength, char[][] ppucBlockData, int[] pnBlockSize) {
        long Result = 0;
        SktSsiPacket SsiPacket = new SktSsiPacket();
        if (pnBlockSize == null || ppucBlockData == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SsiPacket.m_uLength = (char) ((nParamLength + 6) & 255);
            SsiPacket.m_ucOpcode = 209;
            SsiPacket.m_ucSource = 4;
            SsiPacket.m_ucStatus = 0;
            SsiPacket.m_Payload.uLength = (char) ((nParamLength + 2) & 255);
            SsiPacket.m_Payload.pucData = new char[SsiPacket.m_Payload.uLength];
            if (SsiPacket.m_Payload.pucData == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SsiPacket.m_Payload.pucData[0] = (char) ((nCommand >> 8) & 255);
            SsiPacket.m_Payload.pucData[1] = (char) (nCommand & 255);
            if (pucParam != null) {
                for (int i = 0; i < nParamLength; i++) {
                    SsiPacket.m_Payload.pucData[i + 2] = pucParam[i];
                }
            }
            SktScanTypes.TSktScanInteger wChecksum = new SktScanTypes.TSktScanInteger(65536);
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.Eval(ComputeChecksum(SsiPacket, wChecksum), "ComputeChecksum(SsiPacket,wChecksum)");
            }
            SsiPacket.m_wChecksum = wChecksum.getValue();
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pnBlockSize[0] = SsiPacket.m_uLength + 2;
        ppucBlockData[0] = new char[pnBlockSize[0]];
        if (ppucBlockData[0] == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(TransformPacketToRawByte(SsiPacket, ppucBlockData[0], pnBlockSize), "TransformPacketToRawByte(SsiPacket,ppucBlockData[0],pnBlockSize)");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long SendInitializationProperties() {
        long Result = 0;
        SktScanTypes.TSktScanLong ResultToIgnore = new SktScanTypes.TSktScanLong(0);
        boolean bContinue = true;
        SktScanTypes.TSktScanBoolean bGet = new SktScanTypes.TSktScanBoolean(false);
        TSktScanObject[] ScanObj = {new TSktScanObject()};
        while (bContinue) {
            bContinue = false;
            Result = SktDebug.DBGSKT_EVAL(ReadHeadInitializationProperty(bGet, ScanObj[0].Property, ResultToIgnore), "ReadHeadInitializationProperty(bGet,ScanObj[0].Property,ResultToIgnore)");
            if (bGet.getValue()) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetProperty(ScanObj[0], (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "GetProperty(ScanObj[0],null,null)");
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SetProperty(ScanObj[0], (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "SetProperty(ScanObj[0],null,null)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == ResultToIgnore.getValue()) {
                bContinue = true;
            }
            SktUtilities.ReleaseProperty(ScanObj[0].Property);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r4v0, types: [int, char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long AddDataWriteBuffer(boolean r15, long r16, com.SocketMobile.ScanAPICore.SktSsiProtocol.SktBufferAndCommand r18) {
        /*
            r14 = this;
            r12 = 6
            r11 = 5
            r10 = 4
            r9 = 1
            r2 = 0
            r5 = 0
            if (r18 != 0) goto L_0x000b
            r2 = -18
        L_0x000b:
            boolean r6 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r6 == 0) goto L_0x001d
            com.SocketMobile.ScanAPICore.SktPlatform$SktLock r6 = r14.m_WriteBufferLock
            long r6 = r6.Lock()
            java.lang.String r8 = "m_WriteBufferLock.Lock()"
            long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r6, r8)
        L_0x001d:
            boolean r6 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r6 == 0) goto L_0x0094
            com.SocketMobile.ScanAPICore.SktPlatform$SktEvent r6 = r14.m_PacketReadyToSendEvent
            long r6 = r6.Set()
            java.lang.String r8 = "m_PacketReadyToSendEvent.Set()"
            long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r6, r8)
            com.SocketMobile.ScanAPICore.SktList r6 = r14.m_WriteBuffer
            r0 = r18
            long r6 = r6.AddTail(r0)
            java.lang.String r8 = "m_WriteBuffer.AddTail(pBuffer)"
            long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r6, r8)
            boolean r6 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r6 == 0) goto L_0x008f
            r0 = r18
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r6 = r0.m_CommandInfo
            r0 = r18
            char[] r7 = r0.m_pucData
            r6.ComputeNumberOfAck(r7)
            r0 = r18
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r6 = r0.m_CommandInfo
            r0 = r18
            char[] r7 = r0.m_pucData
            char r7 = r7[r9]
            r6.SetOpCode(r7)
            r0 = r18
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r6 = r0.m_CommandInfo
            r0 = r16
            r6.SetPropertyID(r0)
            r0 = r18
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r6 = r0.m_CommandInfo
            r6.SetGetOperation(r15)
            r0 = r18
            char[] r6 = r0.m_pucData
            char r6 = r6[r9]
            r7 = 209(0xd1, float:2.93E-43)
            if (r6 != r7) goto L_0x0095
            r0 = r18
            char[] r6 = r0.m_pucData
            char r6 = r6[r10]
            short r5 = (short) r6
            int r6 = r5 << 8
            short r5 = (short) r6
            r0 = r18
            char[] r6 = r0.m_pucData
            char r6 = r6[r11]
            short r6 = (short) r6
            r6 = r6 | r5
            short r5 = (short) r6
            r0 = r18
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r6 = r0.m_CommandInfo
            r6.SetSocketOpCode(r5)
        L_0x008f:
            com.SocketMobile.ScanAPICore.SktPlatform$SktLock r6 = r14.m_WriteBufferLock
            r6.Unlock()
        L_0x0094:
            return r2
        L_0x0095:
            r0 = r18
            char[] r6 = r0.m_pucData
            char r6 = r6[r9]
            r7 = 199(0xc7, float:2.79E-43)
            if (r6 != r7) goto L_0x008f
            r0 = r18
            int r6 = r0.m_nLength
            if (r6 <= r10) goto L_0x008f
            r0 = r18
            char[] r6 = r0.m_pucData
            char r4 = r6[r10]
            r6 = 240(0xf0, float:3.36E-43)
            if (r4 < r6) goto L_0x00d2
            r0 = r18
            int r6 = r0.m_nLength
            if (r6 <= r11) goto L_0x00d2
            int r4 = r4 << 8
            r0 = r18
            char[] r6 = r0.m_pucData
            char r6 = r6[r11]
            r4 = r4 | r6
            r6 = 63488(0xf800, float:8.8966E-41)
            if (r4 < r6) goto L_0x00d2
            r0 = r18
            int r6 = r0.m_nLength
            if (r6 <= r12) goto L_0x00d2
            int r4 = r4 << 8
            r0 = r18
            char[] r6 = r0.m_pucData
            char r6 = r6[r12]
            r4 = r4 | r6
        L_0x00d2:
            r0 = r18
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r6 = r0.m_CommandInfo
            r6.SetSsiSymbologyId(r4)
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktSsiProtocol.AddDataWriteBuffer(boolean, long, com.SocketMobile.ScanAPICore.SktSsiProtocol$SktBufferAndCommand):long");
    }

    protected static long TranslateToSsiSymbologyId(int ID, SktScanTypes.TSktScanInteger pucSsiSymbologyCommand, SktScanTypes.TSktScanInteger pucSsiSymbologyIDExtendedCode, SktScanTypes.TSktScanInteger pucSsiSymbologyIDExtendedCode2, char[][] extraParameter) {
        long Result = 0;
        int nSsiCode = 0;
        if (pucSsiSymbologyCommand == null || pucSsiSymbologyIDExtendedCode == null || pucSsiSymbologyIDExtendedCode2 == null || extraParameter == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (((long) ID) >= ((long) SymbologyTranslator.length) || ID >= 48) {
                Result = -41;
            } else {
                nSsiCode = SymbologyTranslator[ID].uSsiSymbologyCommand;
                extraParameter[0] = SymbologyTranslator[ID].extraParameter;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (nSsiCode == 65535) {
            return -15;
        }
        pucSsiSymbologyCommand.setValue(nSsiCode & 255);
        pucSsiSymbologyIDExtendedCode.setValue((nSsiCode >> 8) & 255);
        pucSsiSymbologyIDExtendedCode2.setValue((nSsiCode >> 16) & 255);
        if (SymbologyTranslator[ID].extraParameter == null || SymbologyTranslator[ID].extraParameter.length <= 0) {
            return Result;
        }
        extraParameter[0] = SymbologyTranslator[ID].extraParameter;
        return Result;
    }

    protected static long TranslateFromSsiSymbologyId(int nSymbologyCommand, int[] pID) {
        long Result = 0;
        boolean found = false;
        if (pID == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pID[0] = 0;
        int nCount = SymbologyTranslator.length;
        int i = 0;
        while (true) {
            if (i >= nCount) {
                break;
            } else if (SymbologyTranslator[i].uSsiSymbologyCommand == nSymbologyCommand) {
                pID[0] = SymbologyTranslator[i].SktSymbologyID;
                found = true;
                break;
            } else {
                i++;
            }
        }
        if (!found) {
            return -17;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long TranslateDataConfirmationToSsiIndicator(long ulDataConfirmation, int[] pucSsiIndicator) {
        long Result = 0;
        DataConfirmationToSsiIndicator[] indicatorTable = DataConfirmationToSsiIndicatorTable;
        if (pucSsiIndicator == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (this.m_ulDeviceType == ((long) SktScanDeviceType.kSktScanDeviceTypeScanner9)) {
            indicatorTable = DataConfirmationToSsiIndicatorTableCrsV2;
        }
        pucSsiIndicator[0] = 0;
        boolean bFound = false;
        int nCount = indicatorTable.length;
        int i = 0;
        while (true) {
            if (i >= nCount) {
                break;
            } else if (indicatorTable[i].ulDataConfirmation == ulDataConfirmation) {
                pucSsiIndicator[0] = indicatorTable[i].ucSsiIndicator;
                bFound = true;
                break;
            } else {
                i++;
            }
        }
        if (!bFound) {
            return -18;
        }
        return Result;
    }

    protected static int ConvertDecodedSymbolgy(int ucSsiSymbologyId) {
        int max = SymbologyTranslator.length;
        for (int i = 0; i < max; i++) {
            if (SymbologyTranslator[i].wSsiSymbologyID == ucSsiSymbologyId) {
                return SymbologyTranslator[i].SktSymbologyID;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long BuildErrorResponseScanObject(TSktScanObject pScanObj, long ResultToReport, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        if (ppResponseScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppResponseScanObj[0] = new TSktScanObject();
            if (ppResponseScanObj != null) {
                ppResponseScanObj[0].Msg.MsgID = 5;
                ppResponseScanObj[0].Msg.Result = ResultToReport;
                Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(ppResponseScanObj[0].Property, pScanObj.Property), "SktUtilities.AllocateAndCopyProperty(ppResponseScanObj[0].Property,pScanObj.Property)");
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                }
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long SaveLastCommandInfo(SktSsiLastCommand pLastCommandSent, boolean reinsert) {
        long Result = 0;
        if (pLastCommandSent == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || !pLastCommandSent.IsResponseExpected()) {
            return Result;
        }
        SktSsiLastCommand pNewCommandInfo = new SktSsiLastCommand();
        long Result2 = SktDebug.DBGSKT_EVAL(pNewCommandInfo.CopyFrom(pLastCommandSent), "pNewCommandInfo.CopyFrom(pLastCommandSent)");
        if (!SktScanErrors.SKTSUCCESS(Result2)) {
            return Result2;
        }
        if (!reinsert) {
            return SktDebug.DBGSKT_EVAL(this.m_LastCommandsSent.AddTail(pNewCommandInfo), "m_LastCommandsSent.AddTail(pNewCommandInfo)");
        }
        return SktDebug.DBGSKT_EVAL(this.m_LastCommandsSent.AddHead(pNewCommandInfo), "m_LastCommandsSent.AddHead(pNewCommandInfo)");
    }

    /* access modifiers changed from: protected */
    public long RemoveLastCommandInfo(SktSsiLastCommand[] ppLastCommandSent) {
        long Result = 0;
        if (ppLastCommandSent == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_LastCommandsSent.RemoveHead(ppLastCommandSent), "m_LastCommandsSent.RemoveHead(ppLastCommandSent)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppLastCommandSent[0].DecreaseNumberOfAck();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074 A[EDGE_INSN: B:32:0x0074->B:21:0x0074 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long RemoveLastCommandInfoFromSocketOpCodeResponse(int r12, com.SocketMobile.ScanAPICore.SktSsiProtocol.SktSsiLastCommand[] r13) {
        /*
            r11 = this;
            r10 = 0
            r0 = 0
            com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r6 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
            r6.<init>(r10)
            r4 = 0
            r5 = 0
            r3 = 0
            if (r13 != 0) goto L_0x000f
            r0 = -18
        L_0x000f:
            com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r2 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
            r2.<init>(r12)
            boolean r7 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r0)
            if (r7 == 0) goto L_0x0024
            long r8 = r11.ConvertResponseToInquiry(r12, r2, r6)
            java.lang.String r7 = "ConvertResponseToInquiry(wSocketOpCode,TSocketOpCode,wSocketOpCodeSecondChoice)"
            long r0 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r8, r7)
        L_0x0024:
            boolean r7 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r0)
            if (r7 == 0) goto L_0x009a
            com.SocketMobile.ScanAPICore.SktList r7 = r11.m_LastCommandsSent
            com.SocketMobile.ScanAPICore.SktList$Position r4 = r7.GetHeadPosition()
        L_0x0030:
            boolean r7 = r4.IsValid()
            if (r7 == 0) goto L_0x0074
            r5 = r4
            com.SocketMobile.ScanAPICore.SktList$Position r5 = r4.Copy()
            boolean r7 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r0)
            if (r7 == 0) goto L_0x0049
            java.lang.Object r7 = r4.GetNext()
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r7 = (com.SocketMobile.ScanAPICore.SktSsiProtocol.SktSsiLastCommand) r7
            r13[r10] = r7
        L_0x0049:
            boolean r7 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r0)
            if (r7 == 0) goto L_0x0074
            r7 = r13[r10]
            int r7 = r7.GetSocketOpCode()
            int r8 = r2.getValue()
            if (r7 == r8) goto L_0x0067
            r7 = r13[r10]
            int r7 = r7.GetSocketOpCode()
            int r8 = r6.getValue()
            if (r7 != r8) goto L_0x0030
        L_0x0067:
            com.SocketMobile.ScanAPICore.SktList r7 = r11.m_LastCommandsSent
            long r8 = r7.RemoveAt(r5, r13)
            java.lang.String r7 = "m_LastCommandsSent.RemoveAt(removePosition,ppLastCommandSent)"
            long r0 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r8, r7)
            r3 = 1
        L_0x0074:
            boolean r7 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r0)
            if (r7 == 0) goto L_0x009a
            if (r3 != 0) goto L_0x009a
            r7 = 268(0x10c, float:3.76E-43)
            if (r12 != r7) goto L_0x00a6
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand r7 = new com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand
            r7.<init>()
            r13[r10] = r7
            r7 = r13[r10]
            r8 = 209(0xd1, float:2.93E-43)
            r7.SetOpCode(r8)
            r7 = r13[r10]
            r8 = 0
            r7.SetPropertyID(r8)
            r7 = r13[r10]
            r7.SetSocketOpCode(r10)
        L_0x009a:
            boolean r7 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r0)
            if (r7 == 0) goto L_0x00a5
            r7 = r13[r10]
            r7.DecreaseNumberOfAck()
        L_0x00a5:
            return r0
        L_0x00a6:
            r7 = 0
            r13[r10] = r7
            r0 = -17
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktSsiProtocol.RemoveLastCommandInfoFromSocketOpCodeResponse(int, com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiLastCommand[]):long");
    }

    /* access modifiers changed from: protected */
    public long ConvertResponseToInquiry(int wSocketOpCodeResponse, SktScanTypes.TSktScanInteger pwInquiry, SktScanTypes.TSktScanInteger pwInquirySecondChoice) {
        long Result = 0;
        boolean bFound = false;
        if (pwInquiry == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int nCount = this.ResponseInquiryTable.length;
        int i = 0;
        while (true) {
            if (i >= nCount) {
                break;
            } else if (this.ResponseInquiryTable[i].wResponse == wSocketOpCodeResponse) {
                pwInquiry.setValue(this.ResponseInquiryTable[i].wInquiry);
                pwInquirySecondChoice.setValue(this.ResponseInquiryTable[i].wInquirySecondChoice);
                bFound = true;
                break;
            } else {
                i++;
            }
        }
        if (!bFound) {
            return -17;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long CheckPreamblePostambleFriendlyNameSize(int nType, SktScanTypes.TSktScanProperty pProperty) {
        long Result = 0;
        int nLength = 0;
        if (pProperty == null) {
            Result = -2;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (nType != 1) {
            nLength = 0 + this.m_nFriendlyNameLength;
        }
        if (nType != 2) {
            nLength += this.m_nPreambleLength;
        }
        if (nType != 3) {
            nLength += this.m_nPostambleLength;
        }
        if (pProperty.String.nLength + nLength >= 28) {
            return -18;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long AddPostamblePreambleOrFriendlyName(int nType, SktScanTypes.TSktScanProperty pProperty) {
        long Result = 0;
        if (pProperty == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(CheckPreamblePostambleFriendlyNameSize(nType, pProperty), "CheckPreamblePostambleFriendlyNameSize(nType,pProperty)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (nType == 1) {
                this.m_pszFriendlyName = new String(pProperty.String.m_Value);
                this.m_nFriendlyNameLength = pProperty.String.nLength;
            } else if (nType == 2) {
                this.m_pszPreamble = new String(pProperty.String.m_Value);
                this.m_nPreambleLength = pProperty.String.nLength;
            } else if (nType == 3) {
                this.m_pszPostamble = new String(pProperty.String.m_Value);
                this.m_nPostambleLength = pProperty.String.nLength;
            } else {
                Result = -18;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pProperty.String.nLength = this.m_nFriendlyNameLength;
            pProperty.String.nLength += 5;
            pProperty.String.nLength += this.m_nPreambleLength;
            pProperty.String.nLength += this.m_nPostambleLength;
            pProperty.String.m_Value = "";
            char[] value = new char[pProperty.String.nLength];
            for (int i = 0; i < this.m_nFriendlyNameLength; i++) {
                value[i] = this.m_pszFriendlyName.charAt(i);
            }
            value[this.m_nFriendlyNameLength] = 0;
            value[this.m_nFriendlyNameLength + 1] = 255;
            value[this.m_nFriendlyNameLength + 2] = (char) this.m_nPreambleLength;
            for (int i2 = 0; i2 < this.m_nPreambleLength; i2++) {
                value[this.m_nFriendlyNameLength + 3 + i2] = this.m_pszPreamble.charAt(i2);
            }
            value[this.m_nFriendlyNameLength + 3 + this.m_nPreambleLength] = 254;
            value[this.m_nFriendlyNameLength + 3 + this.m_nPreambleLength + 1] = (char) this.m_nPostambleLength;
            for (int i3 = 0; i3 < this.m_nPostambleLength; i3++) {
                value[this.m_nFriendlyNameLength + 3 + this.m_nPreambleLength + 2 + i3] = this.m_pszPostamble.charAt(i3);
            }
            pProperty.String.m_Value = String.valueOf(value, 0, pProperty.String.nLength);
        }
        return Result;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r11v0 ?, r11v1 ?, r11v2 ?, r11v3 ?, r11v4 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    protected long RetrievePreamblePostambleFromFriendlyName(boolean r9, char[] r10, 
/*
Method generation error in method: com.SocketMobile.ScanAPICore.SktSsiProtocol.RetrievePreamblePostambleFromFriendlyName(boolean, char[], int, com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanString):long, dex: classes.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    /* access modifiers changed from: protected */
    public long StoreFriendlyNamePreamblePostamble(char[] pucData, int nLength) {
        long Result = 0;
        this.m_pszFriendlyName = null;
        this.m_pszPreamble = null;
        this.m_pszPostamble = null;
        this.m_nFriendlyNameLength = pucData.length;
        int i = 0;
        while (true) {
            if (i >= this.m_nFriendlyNameLength) {
                break;
            } else if ((pucData[i] & 255) == 0) {
                this.m_nFriendlyNameLength = i;
                break;
            } else {
                i++;
            }
        }
        if (this.m_nFriendlyNameLength > 0) {
            this.m_pszFriendlyName = new String(pucData, 0, this.m_nFriendlyNameLength);
        }
        SktScanTypes.TSktScanString String = new SktScanTypes.TSktScanString();
        String.m_Value = null;
        String.nLength = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(RetrievePreamblePostambleFromFriendlyName(true, pucData, nLength, String), "RetrievePreamblePostambleFromFriendlyName(true,pucData,nLength,String)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_pszPreamble = String.m_Value;
            this.m_nPreambleLength = String.nLength;
        }
        String.m_Value = null;
        String.nLength = 0;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrievePreamblePostambleFromFriendlyName(false, pucData, nLength, String), "RetrievePreamblePostambleFromFriendlyName(false,pucData,nLength,String)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_pszPostamble = String.m_Value;
            this.m_nPostambleLength = String.nLength;
        }
        String.m_Value = null;
        String.nLength = 0;
        return Result;
    }

    /* access modifiers changed from: protected */
    public boolean CheckIfValidFriendlyNameFormat(char[] pData, int nLength) {
        boolean bCorrectFormat = false;
        int nPostambleDelimiterIndex = 0;
        int nState = 0;
        for (int i = 0; i < nLength; i++) {
            switch (nState) {
                case 0:
                    if (pData[i] != 0) {
                        break;
                    } else {
                        nState = 1;
                        break;
                    }
                case 1:
                    if (pData[i] != 255) {
                        break;
                    } else {
                        nState = 2;
                        break;
                    }
                case 2:
                    nPostambleDelimiterIndex = pData[i] + i + 1;
                    nState = 3;
                    break;
                case 3:
                    if (pData[i] == 254 && i == nPostambleDelimiterIndex) {
                        bCorrectFormat = true;
                        break;
                    }
            }
        }
        return bCorrectFormat;
    }

    protected static long ConvertFrequency(boolean bFromDevice, char[] pData, int nSize) {
        long Result = 0;
        if (nSize < 4) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int wNbTones = (pData[2] << 8) + pData[3];
        if (nSize < (wNbTones * 6) + 4) {
            return -18;
        }
        for (int i = 0; i < wNbTones; i++) {
            int wFrequency = (pData[(i * 6) + 4] << 8) + pData[(i * 6) + 5];
            if (!bFromDevice) {
                switch (wFrequency) {
                    case 0:
                        wFrequency = 0;
                        break;
                    case 1:
                        wFrequency = 6;
                        break;
                    case 2:
                        wFrequency = 3;
                        break;
                    case 3:
                        wFrequency = 1;
                        break;
                    default:
                        Result = -18;
                        break;
                }
            } else if (wFrequency == 0) {
                wFrequency = 0;
            } else if (wFrequency < 3) {
                wFrequency = 3;
            } else if (wFrequency < 3 || wFrequency >= 5) {
                wFrequency = 1;
            } else {
                wFrequency = 2;
            }
            pData[(i * 6) + 4] = (char) (wFrequency >> 8);
            pData[(i * 6) + 5] = (char) (wFrequency & 255);
        }
        return Result;
    }

    protected static long ConvertSoundAction(boolean bFromDevice, char[] pData, int nSize) {
        long Result = 0;
        if (nSize < 2) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int wSoundAction = (pData[0] << 8) + pData[1];
            if (bFromDevice) {
                switch (wSoundAction) {
                    case 4:
                        wSoundAction = 0;
                        break;
                    case 5:
                        wSoundAction = 2;
                        break;
                    case 14:
                        wSoundAction = 1;
                        break;
                    default:
                        Result = -18;
                        break;
                }
            } else {
                switch (wSoundAction) {
                    case 0:
                        wSoundAction = 4;
                        break;
                    case 1:
                        wSoundAction = 14;
                        break;
                    case 2:
                        wSoundAction = 5;
                        break;
                    case 3:
                        Result = -15;
                        break;
                    default:
                        Result = -18;
                        break;
                }
            }
            pData[0] = (char) (wSoundAction >> 8);
            pData[1] = (char) (wSoundAction & 255);
        }
        return Result;
    }

    protected static long RetrievePropertyData(SktScanTypes.TSktScanProperty pProperty, char[][] ppPropertyData, int[] pnPropertyDataSize) {
        long Result = 0;
        if (pProperty == null || ppPropertyData == null || pnPropertyDataSize == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        switch (pProperty.Type) {
            case 0:
                ppPropertyData[0] = null;
                pnPropertyDataSize[0] = 0;
                return Result;
            case 2:
                ppPropertyData[0] = new char[1];
                ppPropertyData[0][0] = pProperty.Byte;
                pnPropertyDataSize[0] = 1;
                return Result;
            case 3:
                ppPropertyData[0] = new char[4];
                ppPropertyData[0][3] = (char) ((((int) pProperty.Ulong) >> 24) & 255);
                ppPropertyData[0][2] = (char) ((((int) pProperty.Ulong) >> 16) & 255);
                ppPropertyData[0][1] = (char) ((((int) pProperty.Ulong) >> 8) & 255);
                ppPropertyData[0][0] = (char) ((int) (pProperty.Ulong & 255));
                pnPropertyDataSize[0] = 4;
                return Result;
            case 4:
                ppPropertyData[0] = pProperty.Array.pData;
                pnPropertyDataSize[0] = pProperty.Array.Size;
                return Result;
            case 5:
                ppPropertyData[0] = pProperty.String.m_Value.toCharArray();
                pnPropertyDataSize[0] = pProperty.String.nLength;
                return Result;
            default:
                return -18;
        }
    }

    /* access modifiers changed from: protected */
    public long GetOrSetProperty(boolean bGetOperation, TSktScanObject pScanObj, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        SktBufferAndCommand pBuffer = null;
        SktTranslator Translator = new SktTranslator();
        SktTranslator.TSktTranslatorData Data = new SktTranslator.TSktTranslatorData();
        if (GetTransport() == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pbImmediateResponse != null) {
                pbImmediateResponse.setValue(false);
            }
            if (ppResponseScanObj != null) {
                ppResponseScanObj[0] = null;
            }
            pBuffer = new SktBufferAndCommand();
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(CheckPropertySupport((long) pScanObj.Property.f13ID), "CheckPropertySupport(pScanObj.Property.ID)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.InitializeTable(this.TablePropertyToSsiPrimitive, this.TablePropertyToSsiPrimitive.length), "Translator.InitializeTable(TablePropertyToSsiPrimitive,TablePropertyToSsiPrimitive.length)");
        }
        Data.From.PropId = (long) pScanObj.Property.f13ID;
        Data.From.bGetOperation = bGetOperation;
        Data.pThis = this;
        Data.pDataIn = pScanObj.Property;
        if (pScanObj.Property.Array.pData != null) {
            Data.nDataInSize = pScanObj.Property.Array.pData.length;
        } else {
            Data.nDataInSize = pScanObj.Property.Array.Size;
        }
        int nStartIndex = 0;
        if (this.m_ucCapabilityFriendlyName == 1) {
            nStartIndex = 4;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.TranslateToPrimitive(nStartIndex, Data, (SktScanTypes.TSktScanInteger) null), "Translator.TranslateToPrimitive(nStartIndex,Data,null)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pBuffer.m_pucData = ((TSktScanObject) Data.pDataOut).Property.Array.pData;
            pBuffer.m_nLength = Data.nDataOutSize;
            if (pScanObj.Property.f13ID == 2162697) {
                pBuffer.m_CommandInfo.SetCapabilityGroupRequest(pScanObj.Property.Byte);
            }
        } else if (Result == -17) {
            Result = -15;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddDataWriteBuffer(bGetOperation, (long) pScanObj.Property.f13ID, pBuffer), "AddDataWriteBuffer(bGetOperation,pScanObj.Property.ID,pBuffer)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
        }
        if (!SktScanErrors.SKTSUCCESS(Result) && Result == -15 && pbImmediateResponse != null && ppResponseScanObj != null) {
            Result = SktDebug.DBGSKT_EVAL(BuildErrorResponseScanObject(pScanObj, Result, ppResponseScanObj), "BuildErrorResponseScanObject(pScanObj,Result,ppResponseScanObj)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                ppResponseScanObj[0].Msg.MsgID = bGetOperation ? 5 : 4;
                if (pScanObj.Property.f13ID == 7798788) {
                    ppResponseScanObj[0].Property.Symbology.Status = 2;
                    ppResponseScanObj[0].Msg.Result = 0;
                }
                pbImmediateResponse.setValue(true);
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r5v3, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r5v4, types: [char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long SaveValue(com.SocketMobile.ScanAPICore.SktSsiProtocol.SktSsiPacket r11) {
        /*
            r10 = this;
            r9 = 0
            r8 = 1
            r2 = 0
            r5 = 0
            com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValueData r0 = new com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValueData
            r0.<init>()
            com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValue[] r6 = r10.SaveValueTable
            int r4 = r6.length
            r1 = 0
        L_0x000e:
            if (r1 >= r4) goto L_0x0056
            com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValue[] r6 = r10.SaveValueTable
            r6 = r6[r1]
            int r6 = r6.ucOpCode
            char r7 = r11.m_ucOpcode
            if (r6 != r7) goto L_0x007b
            boolean r6 = r11.IsSocketCmd()
            if (r6 != r8) goto L_0x0057
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r6 = r11.m_Payload
            char[] r6 = r6.pucData
            char r5 = r6[r9]
            int r6 = r5 << 8
            r7 = 65535(0xffff, float:9.1834E-41)
            r5 = r6 & r7
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r6 = r11.m_Payload
            char[] r6 = r6.pucData
            char r6 = r6[r8]
            r5 = r5 | r6
        L_0x0034:
            com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValue[] r6 = r10.SaveValueTable
            r6 = r6[r1]
            int r6 = r6.wSocketCmd
            if (r6 != r5) goto L_0x007b
            r0.pPacket = r11
            r0.pThis = r10
            boolean r6 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r2)
            if (r6 == 0) goto L_0x0056
            com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValue[] r6 = r10.SaveValueTable
            r6 = r6[r1]
            com.SocketMobile.ScanAPICore.SktSsiProtocol$ISktSaveValueFunction r6 = r6.pfnFunction
            long r6 = r6.SktSaveValueFunction(r0)
            java.lang.String r8 = "(SaveValueTable[i].pfnFunction.SktSaveValueFunction(Data))"
            long r2 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r6, r8)
        L_0x0056:
            return r2
        L_0x0057:
            com.SocketMobile.ScanAPICore.SktSsiProtocol$TSaveValue[] r6 = r10.SaveValueTable
            r6 = r6[r1]
            int r6 = r6.ucOpCode
            r7 = 198(0xc6, float:2.77E-43)
            if (r6 != r7) goto L_0x006e
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r6 = r11.m_Payload
            int r6 = r6.uLength
            if (r6 <= r8) goto L_0x0034
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r6 = r11.m_Payload
            char[] r6 = r6.pucData
            char r5 = r6[r8]
            goto L_0x0034
        L_0x006e:
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r6 = r11.m_Payload
            int r6 = r6.uLength
            if (r6 <= 0) goto L_0x0034
            com.SocketMobile.ScanAPICore.SktSsiProtocol$SktPayload r6 = r11.m_Payload
            char[] r6 = r6.pucData
            char r5 = r6[r9]
            goto L_0x0034
        L_0x007b:
            int r1 = r1 + 1
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktSsiProtocol.SaveValue(com.SocketMobile.ScanAPICore.SktSsiProtocol$SktSsiPacket):long");
    }

    /* access modifiers changed from: protected */
    public long CheckPropertySupport(long ulPropertyID) {
        int nCount = this.PropertySupportTable.length;
        for (int i = 0; i < nCount; i++) {
            if (this.PropertySupportTable[i].ulProperty == ulPropertyID && this.PropertySupportTable[i].ulProductType == this.m_ulDeviceType && (this.PropertySupportTable[i].ucMajorVersion << 8) + this.PropertySupportTable[i].ucMinorVersion > (this.m_ucSsiVersionMajor << 8) + this.m_ucSsiVersionMinor) {
                SktDebug.DBGSKT_MSG(66, "This property 0x" + ulPropertyID + " is not supported");
                return -15;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long TrapNotifications(int[] pucButtons, SktScanTypes.TSktScanBoolean pbSendNotification) {
        long Result = 0;
        if (pucButtons == null || pbSendNotification == null) {
            Result = -18;
        }
        int buttons = pucButtons[0];
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pbSendNotification.setValue(true);
            if (SktScan.helper.SKTBUTTON_ISPOWERPRESSED(this.m_ucLastButtonsStatus) != SktScan.helper.SKTBUTTON_ISPOWERPRESSED(buttons)) {
                if (SktScan.helper.SKTBUTTON_ISPOWERPRESSED(buttons)) {
                    if ((this.m_ulNotifications & 4) != 4) {
                        buttons &= 247;
                    }
                } else if ((this.m_ulNotifications & 8) != 8) {
                    buttons |= 8;
                }
                if ((this.m_ucLastButtonsStatus & 8) == (buttons & 8) && this.m_ucLastButtonsStatus == buttons) {
                    pbSendNotification.setValue(false);
                }
                this.m_ucLastButtonsStatus = buttons;
            } else {
                this.m_ucLastButtonsStatus = buttons;
            }
        }
        pucButtons[0] = buttons;
        return Result;
    }

    /* access modifiers changed from: protected */
    public int GetMtu() {
        return this.m_wMtu;
    }

    /* access modifiers changed from: protected */
    public char GetDataTransmissionFormatToSendToProtocol() {
        char ucDataFormat = this.m_ucSsiDataTransmissionFormat;
        if (ucDataFormat >= 16) {
            return (char) (ucDataFormat - 16);
        }
        return ucDataFormat;
    }

    /* access modifiers changed from: protected */
    public void SetDataTransmissionFormatReceivedFromProtocol(boolean bVersionC, char ucDataFormat) {
        this.m_ucSsiDataTransmissionFormat = ucDataFormat;
        if (bVersionC && this.m_ucSsiDataTransmissionFormat < 16) {
            this.m_ucSsiDataTransmissionFormat = (char) (this.m_ucSsiDataTransmissionFormat + 16);
        }
    }

    /* access modifiers changed from: protected */
    public long AddPrefixInDataFormat() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 0:
                this.m_ucSsiDataTransmissionFormat = 4;
                break;
            case 1:
                this.m_ucSsiDataTransmissionFormat = 5;
                break;
            case 2:
                this.m_ucSsiDataTransmissionFormat = 6;
                break;
            case 3:
                this.m_ucSsiDataTransmissionFormat = 7;
                break;
            case 16:
                this.m_ucSsiDataTransmissionFormat = 23;
                break;
            case 17:
            case 22:
                this.m_ucSsiDataTransmissionFormat = 26;
                break;
            case 18:
            case 19:
            case 20:
                this.m_ucSsiDataTransmissionFormat = 24;
                break;
            case 21:
                this.m_ucSsiDataTransmissionFormat = 25;
                break;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long RemovePrefixFromDataFormat() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 4:
                this.m_ucSsiDataTransmissionFormat = 0;
                break;
            case 5:
                this.m_ucSsiDataTransmissionFormat = 1;
                break;
            case 6:
                this.m_ucSsiDataTransmissionFormat = 2;
                break;
            case 7:
                this.m_ucSsiDataTransmissionFormat = 3;
                break;
            case 23:
                this.m_ucSsiDataTransmissionFormat = 16;
                break;
            case 24:
                this.m_ucSsiDataTransmissionFormat = 20;
                break;
            case 25:
                this.m_ucSsiDataTransmissionFormat = 21;
                break;
            case 26:
                this.m_ucSsiDataTransmissionFormat = 22;
                break;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long AddSuffix1InDataFormat() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 0:
                this.m_ucSsiDataTransmissionFormat = 1;
                break;
            case 2:
                this.m_ucSsiDataTransmissionFormat = 3;
                break;
            case 4:
                this.m_ucSsiDataTransmissionFormat = 5;
                break;
            case 6:
                this.m_ucSsiDataTransmissionFormat = 7;
                break;
            case 16:
            case 18:
            case 19:
                this.m_ucSsiDataTransmissionFormat = 20;
                break;
            case 17:
            case 21:
                this.m_ucSsiDataTransmissionFormat = 22;
                break;
            case 23:
                this.m_ucSsiDataTransmissionFormat = 24;
                break;
            case 25:
                this.m_ucSsiDataTransmissionFormat = 26;
                break;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long RemoveSuffix1FromDataFormat() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 1:
                this.m_ucSsiDataTransmissionFormat = 0;
                break;
            case 3:
                this.m_ucSsiDataTransmissionFormat = 2;
                break;
            case 5:
                this.m_ucSsiDataTransmissionFormat = 4;
                break;
            case 7:
                this.m_ucSsiDataTransmissionFormat = 6;
                break;
            case 17:
            case 22:
                this.m_ucSsiDataTransmissionFormat = 21;
                break;
            case 18:
            case 19:
            case 20:
                this.m_ucSsiDataTransmissionFormat = 16;
                break;
            case 24:
                this.m_ucSsiDataTransmissionFormat = 23;
                break;
            case 26:
                this.m_ucSsiDataTransmissionFormat = 25;
                break;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long AddSuffix2InDataFormat() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 0:
                this.m_ucSsiDataTransmissionFormat = 2;
                break;
            case 1:
                this.m_ucSsiDataTransmissionFormat = 3;
                break;
            case 4:
                this.m_ucSsiDataTransmissionFormat = 6;
                break;
            case 5:
                this.m_ucSsiDataTransmissionFormat = 7;
                break;
            case 16:
                this.m_ucSsiDataTransmissionFormat = 21;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                this.m_ucSsiDataTransmissionFormat = 22;
                break;
            case 23:
                this.m_ucSsiDataTransmissionFormat = 25;
                break;
            case 24:
                this.m_ucSsiDataTransmissionFormat = 26;
                break;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long RemoveSuffix2FromDataFormat() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 2:
                this.m_ucSsiDataTransmissionFormat = 0;
                break;
            case 3:
                this.m_ucSsiDataTransmissionFormat = 1;
                break;
            case 6:
                this.m_ucSsiDataTransmissionFormat = 4;
                break;
            case 7:
                this.m_ucSsiDataTransmissionFormat = 5;
                break;
            case 17:
            case 18:
            case 19:
            case 22:
                this.m_ucSsiDataTransmissionFormat = 20;
                break;
            case 21:
                this.m_ucSsiDataTransmissionFormat = 16;
                break;
            case 25:
                this.m_ucSsiDataTransmissionFormat = 23;
                break;
            case 26:
                this.m_ucSsiDataTransmissionFormat = 24;
                break;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int GetPrefixSize() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 23:
            case 24:
            case 25:
            case 26:
                return 1;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public int GetSuffixSize() {
        switch (this.m_ucSsiDataTransmissionFormat) {
            case 1:
            case 2:
            case 5:
            case 6:
            case 18:
            case 19:
            case 20:
            case 21:
            case 24:
            case 25:
                return 1;
            case 3:
            case 7:
            case 17:
            case 22:
            case 26:
                return 2;
            default:
                return 0;
        }
    }

    protected static class SaveCapabilityScanAPIMinVersion implements ISktSaveCapability {
        protected SaveCapabilityScanAPIMinVersion() {
        }

        public long SktSaveCapabilityFunction(TSktCapabilityContext context) {
            if (context.ucLength - context.ucIndex < 3) {
                return -41;
            }
            SktSsiProtocol sktSsiProtocol = context.pThis;
            char[] cArr = context.pucData;
            char c = context.ucIndex;
            context.ucIndex = (char) (c + 1);
            char unused = sktSsiProtocol.m_ucMajorMinScanAPI = cArr[c];
            SktSsiProtocol sktSsiProtocol2 = context.pThis;
            char[] cArr2 = context.pucData;
            char c2 = context.ucIndex;
            context.ucIndex = (char) (c2 + 1);
            char unused2 = sktSsiProtocol2.m_ucMiddleMinScanAPI = cArr2[c2];
            SktSsiProtocol sktSsiProtocol3 = context.pThis;
            char[] cArr3 = context.pucData;
            char c3 = context.ucIndex;
            context.ucIndex = (char) (c3 + 1);
            char unused3 = sktSsiProtocol3.m_ucMinorMinScanAPI = cArr3[c3];
            SktDebug.DBGSKT_MSG(65, "Capability ScanAPI Min Version:" + Integer.toString(context.pThis.m_ucMajorMinScanAPI) + "." + Integer.toString(context.pThis.m_ucMiddleMinScanAPI) + "." + Integer.toString(context.pThis.m_ucMinorMinScanAPI));
            return 0;
        }
    }

    protected static class SaveCapabilityProductSubType implements ISktSaveCapability {
        protected SaveCapabilityProductSubType() {
        }

        public long SktSaveCapabilityFunction(TSktCapabilityContext context) {
            char ucStartIndex = context.ucIndex;
            while (true) {
                if (context.ucIndex >= context.ucLength) {
                    break;
                }
                char[] cArr = context.pucData;
                char c = context.ucIndex;
                context.ucIndex = (char) (c + 1);
                if (cArr[c] == 0) {
                    String unused = context.pThis.m_szProductSubType = String.valueOf(arrays.copy(context.pucData, ucStartIndex, (context.ucIndex - ucStartIndex) - 1));
                    SktDebug.DBGSKT_MSG(65, "Product SubType:" + context.pThis.m_szProductSubType);
                    if (arrays.equals(context.pucData, ucStartIndex, new char[]{'7', 'C'}, 0, 2)) {
                        boolean unused2 = context.pThis.m_bEngine655V4 = true;
                    }
                }
            }
            return 0;
        }
    }

    protected static class SaveCapabilityPrefixSuffixSupport implements ISktSaveCapability {
        protected SaveCapabilityPrefixSuffixSupport() {
        }

        public long SktSaveCapabilityFunction(TSktCapabilityContext context) {
            char[] cArr = context.pucData;
            char c = context.ucIndex;
            context.ucIndex = (char) (c + 1);
            switch (cArr[c]) {
                case 0:
                    char unused = context.pThis.m_ucCapabilityFriendlyName = 0;
                    SktDebug.DBGSKT_MSG(65, "Capability Prefix Suffix in Engine");
                    return 0;
                case 1:
                    char unused2 = context.pThis.m_ucCapabilityFriendlyName = 1;
                    SktDebug.DBGSKT_MSG(65, "Capability Prefix Suffix in Friendly Name");
                    return 0;
                default:
                    return -41;
            }
        }
    }

    /* access modifiers changed from: protected */
    public long ReassembleSsiPacket(SktSsiPacket SsiPacket, SktSsiPacket[] ReassembledSsiPacket, boolean[] pbContinue) {
        pbContinue[0] = false;
        if ((SsiPacket.m_ucStatus & 2) == 2) {
            pbContinue[0] = true;
            SktDebug.DBGSKT_MSG(65, "SSI Packet has a Continuous flag set");
        }
        if (ReassembledSsiPacket[0] != null) {
            SktDebug.DBGSKT_MSG(65, "Assemble SSI Packet with the previous one");
            return SktDebug.DBGSKT_EVAL(ReassembledSsiPacket[0].AddSsiPacket(SsiPacket), "ReassembleSsiPacket[0].AddSsiPacket(SsiPacket)");
        }
        ReassembledSsiPacket[0] = SsiPacket;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long ReadCapabilities(char[] data, int offset, int length) {
        long result = 0;
        TSktCapabilityContext context = new TSktCapabilityContext();
        context.pThis = this;
        context.pucData = data;
        context.ucIndex = (char) offset;
        context.ucLength = (char) length;
        while (context.ucIndex < context.ucLength) {
            char[] cArr = context.pucData;
            char c = context.ucIndex;
            context.ucIndex = (char) (c + 1);
            char ucCapabilityId = cArr[c];
            if (!SktScanErrors.SKTSUCCESS(result)) {
                break;
            }
            result = SktDebug.DBGSKT_EVAL(ReadCapability(ucCapabilityId, context), "ReadCapability(ucCapabilityId,context)");
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public long ReadCapability(int CapabilityId, TSktCapabilityContext context) {
        long result = 0;
        boolean bFound = false;
        int nCount = this.CapabilityDescriptorTable.length;
        int i = 0;
        while (true) {
            if (i >= nCount) {
                break;
            } else if (this.CapabilityDescriptorTable[i].ucCapabilityId == CapabilityId) {
                bFound = true;
                result = SktDebug.DBGSKT_EVAL(this.CapabilityDescriptorTable[i].pfnFunction.SktSaveCapabilityFunction(context), "CapabilityDescriptorTable[i].pfnFunction.SktSaveCapabilityFunction(context)(context)");
                break;
            } else {
                i++;
            }
        }
        if (!bFound) {
            context.ucIndex = context.ucLength;
        }
        return result;
    }

    protected static boolean CompareVersion(int nLength, char[] engineVersion, int offset, int nReferenceLength, char[] referenceVersion) {
        SktDebug.DBGSKT_MSG(65, "About to compare 2 engine revision strings");
        if (nLength < nReferenceLength || !arrays.equals(engineVersion, offset, referenceVersion, 0, nReferenceLength)) {
            return false;
        }
        SktDebug.DBGSKT_MSG(65, "This is a known of scan engine");
        return true;
    }

    protected static long ConvertProductTypeToDeviceType(char productType, long defaultDeviceType) {
        long deviceType = defaultDeviceType;
        if (productType == 1) {
            long deviceType2 = (long) SktScanDeviceType.kSktScanDeviceTypeScanner7;
            SktDebug.DBGSKT_MSG(65, "This is a CHS 7");
            return deviceType2;
        } else if (productType == 2) {
            long deviceType3 = (long) SktScanDeviceType.kSktScanDeviceTypeScanner9;
            SktDebug.DBGSKT_MSG(65, "This is a CRS 9");
            return deviceType3;
        } else if (productType == 3) {
            long deviceType4 = (long) SktScanDeviceType.kSktScanDeviceTypeScanner8ci;
            SktDebug.DBGSKT_MSG(65, "This is a CHS 8Ci");
            return deviceType4;
        } else {
            SktDebug.DBGSKT_MSG(65, "This is an unknown type: " + productType);
            return deviceType;
        }
    }

    public static boolean Test() {
        return true;
    }
}
