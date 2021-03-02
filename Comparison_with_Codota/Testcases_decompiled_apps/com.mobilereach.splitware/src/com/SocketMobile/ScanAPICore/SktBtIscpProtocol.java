package com.SocketMobile.ScanAPICore;

import android.support.p000v4.view.InputDeviceCompat;
import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.SktScan;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktProtocolInterface;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktTranslator;

final class SktBtIscpProtocol extends SktProtocolInterface {
    /* access modifiers changed from: private */
    public static final char[] ISCP_WRONG_PROTOCOL = {186, 219, 173};
    static TSktLocalDecodeAction[] LocalDecodeActionTranslationTable = {new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 0), 0), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 0), 1), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 1), 2), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 1, 1), 3), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 0, 0), 4), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 1, 0), 5), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 0, 1), 6), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 1, 1, 1), 7), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 2, 0), 8), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 0, 2), 9), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 0, 2, 2), 10), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 0, 0), 11), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 2, 0), 12), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 0, 2), 13), new TSktLocalDecodeAction((long) SktScan.helper.SKTDATACONFIRMATION(0, 2, 2, 2), 14)};
    static final long[] StatisticIdentifier = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    static final long[] StatisticIdentifierEx = {0, 1, 2, 3, 4, 5, 24, 6, 7, 8, 9, 10, 11, 25, 26, 27, 30};
    static TSktDecodedSymbologyTranslator[] StcTranslator = {new TSktDecodedSymbologyTranslator((byte) 0, 0), new TSktDecodedSymbologyTranslator((byte) 1, 19), new TSktDecodedSymbologyTranslator((byte) 2, 18), new TSktDecodedSymbologyTranslator((byte) 3, 42), new TSktDecodedSymbologyTranslator((byte) 4, 43), new TSktDecodedSymbologyTranslator((byte) 5, 19), new TSktDecodedSymbologyTranslator((byte) 6, 18), new TSktDecodedSymbologyTranslator((byte) 7, 42), new TSktDecodedSymbologyTranslator((byte) 8, 43), new TSktDecodedSymbologyTranslator((byte) 9, 19), new TSktDecodedSymbologyTranslator((byte) 10, 18), new TSktDecodedSymbologyTranslator((byte) 11, 42), new TSktDecodedSymbologyTranslator((byte) 12, 43), new TSktDecodedSymbologyTranslator((byte) 13, 11), new TSktDecodedSymbologyTranslator((byte) 15, 27), new TSktDecodedSymbologyTranslator((byte) 16, 39), new TSktDecodedSymbologyTranslator((byte) 17, 30), new TSktDecodedSymbologyTranslator((byte) 19, 7), new TSktDecodedSymbologyTranslator((byte) 20, 0), new TSktDecodedSymbologyTranslator((byte) 21, 32), new TSktDecodedSymbologyTranslator((byte) 22, 36), new TSktDecodedSymbologyTranslator((byte) 23, 15), new TSktDecodedSymbologyTranslator((byte) 24, 0), new TSktDecodedSymbologyTranslator((byte) 25, 14), new TSktDecodedSymbologyTranslator((byte) 26, 10), new TSktDecodedSymbologyTranslator((byte) 27, 40), new TSktDecodedSymbologyTranslator((byte) 28, 0), new TSktDecodedSymbologyTranslator((byte) 29, 11), new TSktDecodedSymbologyTranslator((byte) 30, 8), new TSktDecodedSymbologyTranslator((byte) 31, 9), new TSktDecodedSymbologyTranslator((byte) 32, 8), new TSktDecodedSymbologyTranslator((byte) 33, 33), new TSktDecodedSymbologyTranslator((byte) 34, 20), new TSktDecodedSymbologyTranslator((byte) 35, 28), new TSktDecodedSymbologyTranslator((byte) 36, 34), new TSktDecodedSymbologyTranslator((byte) 37, 24), new TSktDecodedSymbologyTranslator((byte) 38, 25), new TSktDecodedSymbologyTranslator((byte) 39, 26), new TSktDecodedSymbologyTranslator((byte) 40, 16), new TSktDecodedSymbologyTranslator((byte) 41, 38), new TSktDecodedSymbologyTranslator((byte) 42, 31), new TSktDecodedSymbologyTranslator((byte) 43, 24), new TSktDecodedSymbologyTranslator((byte) 44, 25), new TSktDecodedSymbologyTranslator((byte) 45, 26), new TSktDecodedSymbologyTranslator((byte) 46, 20), new TSktDecodedSymbologyTranslator((byte) 47, 22), new TSktDecodedSymbologyTranslator((byte) 48, 22), new TSktDecodedSymbologyTranslator((byte) 49, 22), new TSktDecodedSymbologyTranslator((byte) 50, 22), new TSktDecodedSymbologyTranslator((byte) 51, 24), new TSktDecodedSymbologyTranslator((byte) 52, 25), new TSktDecodedSymbologyTranslator((byte) 53, 26), new TSktDecodedSymbologyTranslator((byte) 54, 20), new TSktDecodedSymbologyTranslator(kSymbologyIdEan13CompositeCCB, 19), new TSktDecodedSymbologyTranslator(kSymbologyIdEan8CompositeCCB, 18), new TSktDecodedSymbologyTranslator(kSymbologyIdUpcACompositeCCB, 42), new TSktDecodedSymbologyTranslator((byte) 58, 43), new TSktDecodedSymbologyTranslator(kSymbologyIdGs1CompositeGs1128CompositeCCC, 20), new TSktDecodedSymbologyTranslator(kSymbologyIdIsbn, 3), new TSktDecodedSymbologyTranslator(kSymbologyIdPostnet, 37), new TSktDecodedSymbologyTranslator(kSymbologyIdPlanet, 35), new TSktDecodedSymbologyTranslator(kSymbologyIdBpo, 4), new TSktDecodedSymbologyTranslator((byte) 64, 5), new TSktDecodedSymbologyTranslator((byte) 65, 1), new TSktDecodedSymbologyTranslator((byte) 66, 29), new TSktDecodedSymbologyTranslator((byte) 67, 17), new TSktDecodedSymbologyTranslator((byte) 68, 6), new TSktDecodedSymbologyTranslator((byte) 69, 0), new TSktDecodedSymbologyTranslator((byte) 70, 41), new TSktDecodedSymbologyTranslator((byte) 71, 13), new TSktDecodedSymbologyTranslator((byte) 72, 15), new TSktDecodedSymbologyTranslator((byte) 73, 15), new TSktDecodedSymbologyTranslator((byte) 74, 2), new TSktDecodedSymbologyTranslator((byte) 75, 0), new TSktDecodedSymbologyTranslator((byte) 76, 0), new TSktDecodedSymbologyTranslator((byte) 77, 0), new TSktDecodedSymbologyTranslator((byte) 78, 0), new TSktDecodedSymbologyTranslator((byte) 79, 45)};
    static TSktBtIscpSymbologyTranslator[] SymbologyTranslator = {new TSktBtIscpSymbologyTranslator(0, 0, 0), new TSktBtIscpSymbologyTranslator(1, 52, 64), new TSktBtIscpSymbologyTranslator(2, 83, 64), new TSktBtIscpSymbologyTranslator(3, 0, 0), new TSktBtIscpSymbologyTranslator(4, 50, 64), new TSktBtIscpSymbologyTranslator(5, 51, 64), new TSktBtIscpSymbologyTranslator(6, 0, 0), new TSktBtIscpSymbologyTranslator(7, 64, 64), new TSktBtIscpSymbologyTranslator(8, 77, 65), new TSktBtIscpSymbologyTranslator(9, 77, 64), new TSktBtIscpSymbologyTranslator(10, 74, 64), new TSktBtIscpSymbologyTranslator(11, 66, 64), new TSktBtIscpSymbologyTranslator(12, 66, 90), new TSktBtIscpSymbologyTranslator(13, 66, 65), new TSktBtIscpSymbologyTranslator(14, 65, 64), new TSktBtIscpSymbologyTranslator(15, 67, 64), new TSktBtIscpSymbologyTranslator(16, 84, 64), new TSktBtIscpSymbologyTranslator(17, 54, 64), new TSktBtIscpSymbologyTranslator(18, 75, 66), new TSktBtIscpSymbologyTranslator(19, 75, 67), new TSktBtIscpSymbologyTranslator(20, 67, 66), new TSktBtIscpSymbologyTranslator(21, 67, 67), new TSktBtIscpSymbologyTranslator(22, 86, 64), new TSktBtIscpSymbologyTranslator(23, 86, 65), new TSktBtIscpSymbologyTranslator(24, 79, 64), new TSktBtIscpSymbologyTranslator(25, 79, 65), new TSktBtIscpSymbologyTranslator(26, 79, 66), new TSktBtIscpSymbologyTranslator(27, 68, 64), new TSktBtIscpSymbologyTranslator(28, 67, 65), new TSktBtIscpSymbologyTranslator(29, 53, 64), new TSktBtIscpSymbologyTranslator(30, 69, 64), new TSktBtIscpSymbologyTranslator(31, 82, 64), new TSktBtIscpSymbologyTranslator(32, 70, 64), new TSktBtIscpSymbologyTranslator(33, 76, 64), new TSktBtIscpSymbologyTranslator(34, 76, 66), new TSktBtIscpSymbologyTranslator(35, 49, 64), new TSktBtIscpSymbologyTranslator(36, 71, 64), new TSktBtIscpSymbologyTranslator(37, 48, 64), new TSktBtIscpSymbologyTranslator(38, 85, 64), new TSktBtIscpSymbologyTranslator(39, 72, 64), new TSktBtIscpSymbologyTranslator(40, 73, 64), new TSktBtIscpSymbologyTranslator(41, 78, 64), new TSktBtIscpSymbologyTranslator(42, 75, 64), new TSktBtIscpSymbologyTranslator(43, 75, 65), new TSktBtIscpSymbologyTranslator(44, 75, 76), new TSktBtIscpSymbologyTranslator(45, 58, 64), new TSktBtIscpSymbologyTranslator(46, 123, 82), new TSktBtIscpSymbologyTranslator(47, 0, 0)};
    static SktTranslator.TSktTranslator[] TablePropertyFromBtIscpPrimitive = {new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65536, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 212), new FillScanObjectWithDeviceVersion()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 212), new FillScanObjectWithDeviceType()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(80, 0, 0), new FillScanObjectWithDeviceType()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 48, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 49, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 50, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 51, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 52, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 53, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 54, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 64, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 77, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 74, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 66, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 65, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 67, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 68, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 69, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 70, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 76, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 71, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 72, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 73, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 75, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 78, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 79, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 82, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 83, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 84, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 85, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 86, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 58, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(80, 123, 0), new FillScanObjectPropertySymbologyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(80, 96, 192), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(80, 96, 193), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65546, true), new SktTranslator.TSktTranslatorTo(83, 64, 192), new FillScanObjectWithArrayValueToUlong()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 155), new FillScanObjectWithWordValueToByte()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2162697, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionEchoRequest), new FillScanObjectWithCapabilities()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 193), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 129), new FillScanObjectPropertySecurityModeFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1376514, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 194), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179907, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 131), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048836, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 195), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048837, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionPowerOff), new FillScanObjectPropertyFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65798, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 145), new FillScanObjectPropertyButtonsStatusFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 209), new FillScanObjectWithArray()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionTimers), new FillScanObjectWithArray()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionTriggerMode), new FillScanObjectWithLocalAcknowlegmentMode()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65803, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 157), new FillScanObjectWithBatteryLevel()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionLocalDataConfirmation), new FillScanObjectPropertyLocalDecodeActionFromFunction()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65805, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 197), new FillScanObjectWithArray()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65806, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 213), new FillScanObjectWithStatisticCounters()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 210), new FillScanObjectWithArray()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 196), new FillScanObjectWithProfileConfig()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 214), new FillScanObjectWithArray()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 211), new FillScanObjectWithNotifications()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65812, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 133), new FillScanObjectWithWordValueToByte()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65813, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 154), new FillScanObjectWithPowerState()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 156), new FillScanObjectWithWordValueToByte()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131351, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, 158), new FillScanObjectWithWordValueToByte()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196889, true), new SktTranslator.TSktTranslatorTo(80, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionStandConfig), new FillScanObjectWithWordValueToUlong()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(81, 0, 0), new FillScanObjectWithResultResponse()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1, true), new SktTranslator.TSktTranslatorTo(96, 0, 0), new FillScanObjectWithBarcodeData()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1, true), new SktTranslator.TSktTranslatorTo(99, 0, 0), new FillScanObjectWithBarcodeDataEx()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1, true), new SktTranslator.TSktTranslatorTo(100, 0, 0), new FillScanObjectWithBarcodeDataEx2()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2, true), new SktTranslator.TSktTranslatorTo(97, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionPowerNotifications), new FillScanObjectWithPowerNotification()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(3, true), new SktTranslator.TSktTranslatorTo(97, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionButtonNotifications), new FillScanObjectWithButtonsNotification()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4, true), new SktTranslator.TSktTranslatorTo(97, (int) kSetupGroupSocketCommands, 227), new FillScanObjectWithBatteryNotification()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(80, 0, 0), new FillScanObjectPropertyFromErrorReply()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(0, true), new SktTranslator.TSktTranslatorTo(83, 0, 0), new FillScanObjectPropertyFromErrorReply())};
    static SktTranslator.TSktTranslator[] TablePropertyToBtIscpPrimitive = {new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65536, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 212), new TranslateVersionToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65538, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 212), new TranslateVersionToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456451, true), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateRawToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456451, false), new SktTranslator.TSktTranslatorTo(0, 0, 0), new TranslateRawToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, true), new SktTranslator.TSktTranslatorTo(64, 0, 0), new TranslateSymbologyToBtIscpSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(7798788, false), new SktTranslator.TSktTranslatorTo(65, 0, 0), new TranslateSymbologyToBtIscpSymbology()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179653, false), new SktTranslator.TSktTranslatorTo(65, 0, 0), new TranslateTriggerToBtIscpCommand()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, false), new SktTranslator.TSktTranslatorTo(65, 96, 192), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327687, true), new SktTranslator.TSktTranslatorTo(64, 96, 192), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, false), new SktTranslator.TSktTranslatorTo(65, 96, 193), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327688, true), new SktTranslator.TSktTranslatorTo(64, 96, 193), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2162697, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionEchoRequest), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65546, true), new SktTranslator.TSktTranslatorTo(67, 64, 192), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 155), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131083, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 155), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 193), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(327936, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 193), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 129), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131329, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 129), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1376514, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 194), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179907, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 131), new TranslateDeletePairingToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048836, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionRestoreFactoryDefaults), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1048837, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionPowerOff), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65798, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 145), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 209), new TranslateSoundOrRumbleConfigToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359559, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 209), new TranslateSoundOrRumbleConfigToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionTimers), new TranslateTimersToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262408, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionTimers), new TranslateTimersToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionTriggerMode), new TranslateLocalAcknowledgmentToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131337, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionTriggerMode), new TranslateLocalAcknowledgmentToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1245450, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionHostDataConfirmation), new TranslateDataConfirmationToBtIscpCommand()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65803, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 157), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionLocalDataConfirmation), new TranslateLocalDecodeActionToBtIscpCommand()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131340, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionLocalDataConfirmation), new TranslateLocalDecodeActionToBtIscpCommand()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65805, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 197), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65806, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 213), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 210), new TranslateSoundOrRumbleConfigToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(2359567, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 210), new TranslateSoundOrRumbleConfigToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 196), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(262416, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 196), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(1179921, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 132), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 214), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(4456722, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 214), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 211), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196883, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 211), new TranslateNotificationsToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65812, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 133), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(65813, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 154), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 156), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131350, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 156), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131351, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, 158), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(131351, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, 158), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196889, true), new SktTranslator.TSktTranslatorTo(64, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionStandConfig), new TranslateToBtIscpPacket()), new SktTranslator.TSktTranslator(new SktTranslator.TSktTranslatorFrom(196889, false), new SktTranslator.TSktTranslatorTo(65, (int) kSetupGroupSocketCommands, (int) kSetupSocketCommandsFunctionStandConfig), new TranslateToBtIscpPacket())};
    public static final byte kAdd = 64;
    static final int kBeepBadScanHost = 3;
    static final int kBeepBadScanLocal = 2;
    static final int kBeepGoodScanHost = 1;
    static final int kBeepGoodScanLocal = 0;
    static final int kBeepScanDisconnected = 4;
    public static final byte kBtIscpError = 16;
    public static final byte kBtIscpFirstFrame = 32;
    public static final byte kBtIscpLastFrame = 64;
    public static final byte kBtIscpPacketChecksumSize = 2;
    public static final byte kBtIscpPacketFrameTypeSize = 1;
    public static final byte kBtIscpPacketSizeWithoutPayload = 4;
    public static final byte kBtIscpPacketStxEtxSize = 2;
    public static final byte kBtIscpParamMinimumSize = 2;
    public static final byte kBtIscpRestart = 8;
    static final int kByteOffset = 6;
    private static final int kChs7xDeviceMaxVersionSupportedNotIncluded = 1280;
    public static final int kControlConfigurationFunctionDisableAllSymbologies = 3;
    public static final int kControlConfigurationFunctionResetFactoryDefaults = 2;
    public static final int kControlDecodingFunctionDecodeEfficiency = 65;
    public static final int kControlDecodingFunctionDecodeProceed = 68;
    public static final int kControlDecodingFunctionReadingSession = 64;
    public static final int kControlDecodingFunctionSendDecodeInformation = 67;
    public static final int kControlDecodingFunctionSendMemorySegment = 66;
    public static final byte kControlGroupConfiguration = 64;
    public static final byte kControlGroupDecoding = 32;
    public static final byte kControlGroupHardware = 48;
    public static final byte kControlGroupOperating = 80;
    public static final int kControlHardwareFunctionBadReadLed = 66;
    public static final int kControlHardwareFunctionBeep = 192;
    public static final int kControlHardwareFunctionBeepSequence = 65;
    public static final int kControlHardwareFunctionBluetoothLed = 67;
    public static final int kControlHardwareFunctionBluetoothPage = 7;
    public static final int kControlHardwareFunctionFlashMemoryUpgrade = 1;
    public static final int kControlHardwareFunctionGoodReadLed = 64;
    public static final int kControlHardwareFunctionPlayErrorSuccess = 69;
    public static final int kControlHardwareFunctionPowerDown = 6;
    public static final int kControlHardwareFunctionReset = 2;
    public static final int kControlHardwareFunctionSleep = 3;
    public static final int kControlHardwareFunctionVibrateAlert = 68;
    public static final int kControlOperatingFunctionEchoingFrames = 192;
    public static final int kControlOperatingFunctionEnableMode = 65;
    public static final int kControlOperatingFunctionLoggingMarker = 128;
    public static final int kControlOperatingFunctionSilentMode = 64;
    public static final int kControlOperatingFunctionVideoStartStop = 67;
    public static final byte kEsc = 16;
    public static final byte kEtx = 3;
    public static final int kEventConfigurationFunctionConfigurationBarcodeRejected = 32;
    public static final int kEventConfigurationFunctionSetupModifiedBarcode = 128;
    public static final byte kEventDecodingFunctionEndRead = 34;
    public static final byte kEventDecodingFunctionStartRead = 33;
    public static final byte kEventDecodingFunctionUnsuccessful = 32;
    public static final byte kEventGroupConfiguration = 64;
    public static final byte kEventGroupDecoding = 32;
    public static final byte kEventGroupHardware = 48;
    public static final byte kEventHardwareFunctionStartUp = 32;
    public static final byte kEventHardwareFunctionTriggerPulled = 33;
    public static final byte kEventHardwareFunctionTriggerReleased = 34;
    public static final byte kFrameSetupBarcodeData = 98;
    public static final byte kFrameTypeBarcodeData = 96;
    public static final byte kFrameTypeBarcodeDataEx = 99;
    public static final byte kFrameTypeBarcodeDataEx2 = 100;
    public static final byte kFrameTypeControl = 66;
    public static final byte kFrameTypeEventNotification = 97;
    static final int kFrameTypeOffset = 3;
    public static final byte kFrameTypeResult = 81;
    public static final byte kFrameTypeSetupPermissionRead = 68;
    public static final byte kFrameTypeSetupPermissionReply = 84;
    public static final byte kFrameTypeSetupPermissionWrite = 69;
    public static final byte kFrameTypeSetupRead = 64;
    public static final byte kFrameTypeSetupReply = 80;
    public static final byte kFrameTypeSetupWrite = 65;
    public static final byte kFrameTypeStatusRead = 67;
    public static final byte kFrameTypeStatusReply = 83;
    static final int kFunctionIdOffset = 5;
    static final int kGroupIdOffset = 4;
    static final int kHighAIMLengthOffset = 15;
    static final int kHighBarcodeLengthOffset = 11;
    static final int kHighLengthOffset = 6;
    static final int kHighPostambleLengthOffset = 13;
    static final int kHighPreambleLengthOffset = 7;
    static final int kHighSTCIdentifierOffset = 5;
    static final int kHighSymbologyIdLengthOffset = 9;
    static final int kHighWordOffset = 6;
    static final int kLowAIMLengthOffset = 16;
    static final int kLowBarcodeLengthOffset = 12;
    static final int kLowLengthOffset = 7;
    static final int kLowPostambleLengthOffset = 14;
    static final int kLowPreambleLengthOffset = 8;
    static final int kLowSTCIdentifierOffset = 6;
    static final int kLowSymbologyIdLengthOffset = 10;
    static final int kLowWordOffset = 7;
    static final int kParamTypeByte = 2;
    static final int kParamTypeNone = 1;
    static final int kParamTypeString = 4;
    static final int kParamTypeWord = 3;
    static final int kProfileConfigSize = 14;
    static final int kResponseIdOffset = 4;
    public static final int kResultDone = 0;
    public static final int kResultGroupUnknown = 129;
    public static final int kResultIdentifierUnknown = 130;
    public static final int kResultInvalidParameter = 131;
    public static final int kResultUnknownFrameType = 1;
    static final int kSequenceNumberOffset = 0;
    static final int kServiceNameMaxChar = 32;
    public static final int kSetupAustraliaFunctionActivation = 64;
    public static final int kSetupAustraliaFunctionCodeMark = 72;
    public static final int kSetupAustraliaFunctionUdsi = 192;
    public static final int kSetupAztecFunctionActivation = 64;
    public static final int kSetupAztecFunctionBarcodeLengthL1 = 144;
    public static final int kSetupAztecFunctionBarcodeLengthL2 = 145;
    public static final int kSetupAztecFunctionBarcodeLengthL3 = 146;
    public static final int kSetupAztecFunctionBarcodeLengthMode = 83;
    public static final int kSetupAztecFunctionCodeMark = 72;
    public static final int kSetupAztecFunctionEan128Emulation = 67;
    public static final int kSetupAztecFunctionRunes = 66;
    public static final int kSetupAztecFunctionStructureAppendMode = 65;
    public static final int kSetupAztecFunctionUdsi = 192;
    public static final int kSetupBeepLedIndicatorFunctionBeepVolume = 69;
    public static final int kSetupBeepLedIndicatorFunctionErrorBeep = 67;
    public static final int kSetupBeepLedIndicatorFunctionGoodReadBeepDuration = 129;
    public static final int kSetupBeepLedIndicatorFunctionGoodReadBeepsNumber = 65;
    public static final int kSetupBeepLedIndicatorFunctionGoodReadEventTiming = 66;
    public static final int kSetupBeepLedIndicatorFunctionGoodReadLedDuration = 130;
    public static final int kSetupBeepLedIndicatorFunctionPowerUpBeepLed = 64;
    public static final int kSetupBeepLedIndicatorFunctionSetupParameterBeep = 68;
    public static final int kSetupBeepLedIndicatorFunctionStackedCodeCrackle = 70;
    public static final int kSetupBeepLedIndicatorFunctionStackedCodeFlicker = 71;
    public static final int kSetupBeepLedIndicatorFunctionToneFrequency = 128;
    public static final int kSetupBeepLedIndicatorFunctionVibrateAlertActivation = 72;
    public static final int kSetupBeepLedIndicatorFunctionVibrateAlertDuration = 131;
    public static final int kSetupBluetoothFunctionBluetoothConnectDisconnect = 197;
    public static final int kSetupBluetoothFunctionConnectionTimeout = 199;
    public static final int kSetupBluetoothFunctionDeviceName = 194;
    public static final int kSetupBluetoothFunctionDevicePin = 193;
    public static final int kSetupBluetoothFunctionDeviceProfile = 192;
    public static final int kSetupBluetoothFunctionDeviceSecurity = 64;
    public static final int kSetupBluetoothFunctionDiscoverable = 65;
    public static final int kSetupBluetoothFunctionMaxReconnectionTime = 195;
    public static final int kSetupBluetoothFunctionPageableMode = 66;
    public static final int kSetupBritishFunctionActivation = 64;
    public static final int kSetupBritishFunctionCheckDigitTransmission = 84;
    public static final int kSetupBritishFunctionCodeMark = 72;
    public static final int kSetupBritishFunctionUdsi = 192;
    public static final int kSetupCanadaFunctionActivation = 64;
    public static final int kSetupCanadaFunctionCodeMark = 72;
    public static final int kSetupCanadaFunctionUdsi = 192;
    public static final byte kSetupCodabarFunctionActivation = 64;
    public static final byte kSetupCodabarFunctionCheckDigitVerification = 84;
    public static final byte kSetupCodabarFunctionClsi = 89;
    public static final byte kSetupCodabarFunctionCodeMark = 72;
    public static final byte kSetupCodabarFunctionLengthL1 = 80;
    public static final byte kSetupCodabarFunctionLengthL2 = 81;
    public static final byte kSetupCodabarFunctionLengthL3 = 82;
    public static final byte kSetupCodabarFunctionLengthMode = 83;
    public static final byte kSetupCodabarFunctionStartStopTransmission = 88;
    public static final byte kSetupCodablockFunctionACodeMark = 73;
    public static final byte kSetupCodablockFunctionCodablockA = 65;
    public static final byte kSetupCodablockFunctionCodablockF = 64;
    public static final byte kSetupCodablockFunctionFCodeMark = 72;
    public static final byte kSetupCode11FunctionActivation = 64;
    public static final byte kSetupCode11FunctionCheckDigitTransmission = 84;
    public static final byte kSetupCode11FunctionCheckDigitVerification = 76;
    public static final byte kSetupCode11FunctionCodeMark = 72;
    public static final byte kSetupCode11FunctionLengthL1 = 80;
    public static final byte kSetupCode11FunctionLengthL2 = 81;
    public static final byte kSetupCode11FunctionLengthL3 = 82;
    public static final byte kSetupCode11FunctionLengthMode = 83;
    public static final byte kSetupCode128FunctionActivation = 64;
    public static final byte kSetupCode128FunctionCheckDigitVerification = 76;
    public static final byte kSetupCode128FunctionCodeMark = 72;
    public static final byte kSetupCode128FunctionConcatenateAnyPairOfIsbtCodes = 91;
    public static final byte kSetupCode128FunctionEan128 = 66;
    public static final byte kSetupCode128FunctionEan128Identifier = 88;
    public static final byte kSetupCode128FunctionEan128Unconventional = 67;
    public static final byte kSetupCode128FunctionFnc1Conversion = 89;
    public static final byte kSetupCode128FunctionIsbt = 65;
    public static final byte kSetupCode128FunctionIsbtConcatenationTransmission = 90;
    public static final byte kSetupCode128FunctionLengthL1 = 80;
    public static final byte kSetupCode128FunctionLengthL2 = 81;
    public static final byte kSetupCode128FunctionLengthL3 = 82;
    public static final byte kSetupCode128FunctionLengthMode = 83;
    public static final byte kSetupCode39FunctionAcceptedStartCharacter = 89;
    public static final byte kSetupCode39FunctionActivation = 64;
    public static final byte kSetupCode39FunctionCheckDigitTransmission = 84;
    public static final byte kSetupCode39FunctionCheckDigitVerification = 76;
    public static final byte kSetupCode39FunctionCodeMark = 72;
    public static final byte kSetupCode39FunctionFullAsciiConversion = 90;
    public static final byte kSetupCode39FunctionLengthL1 = 80;
    public static final byte kSetupCode39FunctionLengthL2 = 81;
    public static final byte kSetupCode39FunctionLengthL3 = 82;
    public static final byte kSetupCode39FunctionLengthMode = 83;
    public static final byte kSetupCode39FunctionReadingRange = 71;
    public static final byte kSetupCode39FunctionStartStopTransmission = 88;
    public static final byte kSetupCode39FunctionTriopticActivation = 65;
    public static final byte kSetupCode39FunctionTriopticCodeMark = 73;
    public static final int kSetupCode39FunctionTriopticUdsi = 193;
    public static final byte kSetupCode93FunctionActivation = 64;
    public static final byte kSetupCode93FunctionCodeMark = 72;
    public static final byte kSetupCode93FunctionLengthL1 = 80;
    public static final byte kSetupCode93FunctionLengthL2 = 81;
    public static final byte kSetupCode93FunctionLengthL3 = 82;
    public static final byte kSetupCode93FunctionLengthMode = 83;
    public static final int kSetupConfigurationFunctionConfigurationUsingBarcodes = 64;
    public static final int kSetupConfigurationFunctionPermanentTransparantMode = 65;
    public static final int kSetupDataEditionFunctionScenario1ActionList = 208;
    public static final int kSetupDataEditionFunctionScenario1Activation = 64;
    public static final int kSetupDataEditionFunctionScenario1BarcodeLength = 128;
    public static final int kSetupDataEditionFunctionScenario1Mask = 192;
    public static final int kSetupDataEditionFunctionScenario1SymbologyIdentifier = 80;
    public static final int kSetupDataEditionFunctionScenario2ActionList = 209;
    public static final int kSetupDataEditionFunctionScenario2Activation = 65;
    public static final int kSetupDataEditionFunctionScenario2BarcodeLength = 129;
    public static final int kSetupDataEditionFunctionScenario2Mask = 193;
    public static final int kSetupDataEditionFunctionScenario2SymbologyIdentifier = 81;
    public static final int kSetupDataEditionFunctionScenario3ActionList = 210;
    public static final int kSetupDataEditionFunctionScenario3Activation = 66;
    public static final int kSetupDataEditionFunctionScenario3BarcodeLength = 130;
    public static final int kSetupDataEditionFunctionScenario3Mask = 194;
    public static final int kSetupDataEditionFunctionScenario3SymbologyIdentifier = 82;
    public static final int kSetupDataEditionFunctionScenario4ActionList = 211;
    public static final int kSetupDataEditionFunctionScenario4Activation = 67;
    public static final int kSetupDataEditionFunctionScenario4BarcodeLength = 131;
    public static final int kSetupDataEditionFunctionScenario4Mask = 195;
    public static final int kSetupDataEditionFunctionScenario4SymbologyIdentifier = 83;
    public static final int kSetupDataEditionFunctionScenario5ActionList = 212;
    public static final int kSetupDataEditionFunctionScenario5Activation = 68;
    public static final int kSetupDataEditionFunctionScenario5BarcodeLength = 132;
    public static final int kSetupDataEditionFunctionScenario5Mask = 196;
    public static final int kSetupDataEditionFunctionScenario5SymbologyIdentifier = 84;
    public static final int kSetupDataEditionFunctionScenario6ActionList = 213;
    public static final int kSetupDataEditionFunctionScenario6Activation = 69;
    public static final int kSetupDataEditionFunctionScenario6BarcodeLength = 133;
    public static final int kSetupDataEditionFunctionScenario6Mask = 197;
    public static final int kSetupDataEditionFunctionScenario6SymbologyIdentifier = 85;
    public static final int kSetupDataEditionFunctionScenario7ActionList = 214;
    public static final int kSetupDataEditionFunctionScenario7Activation = 70;
    public static final int kSetupDataEditionFunctionScenario7BarcodeLength = 134;
    public static final int kSetupDataEditionFunctionScenario7Mask = 198;
    public static final int kSetupDataEditionFunctionScenario7SymbologyIdentifier = 86;
    public static final int kSetupDataMatrixFunctionActivation = 64;
    public static final int kSetupDataMatrixFunctionBarcodeLengthL1 = 144;
    public static final int kSetupDataMatrixFunctionBarcodeLengthL2 = 145;
    public static final int kSetupDataMatrixFunctionBarcodeLengthL3 = 146;
    public static final int kSetupDataMatrixFunctionBarcodeLengthMode = 83;
    public static final int kSetupDataMatrixFunctionCodeMark = 72;
    public static final int kSetupDataMatrixFunctionUdsi = 192;
    public static final int kSetupDecodingSecurityFunctionConsecutiveSameReadDataValidation = 64;

    /* renamed from: kSetupDecodingSecurityFunctionTimeoutBetweenDifferentConsecutiveReads */
    public static final int f9xdbfea390 = 129;

    /* renamed from: kSetupDecodingSecurityFunctionTimeoutBetweenIdenticalConsecutiveReads */
    public static final int f10xeb1e400c = 128;
    public static final int kSetupDirectPartMarkingFunctionActivation = 82;
    public static final int kSetupDutchFunctionActivation = 64;
    public static final int kSetupDutchFunctionCodeMark = 72;
    public static final int kSetupDutchFunctionUdsi = 192;
    public static final byte kSetupGroupAustralia = 52;
    public static final byte kSetupGroupAztec = 83;
    public static final byte kSetupGroupBeepLedIndicator = 114;
    public static final byte kSetupGroupBluetooth = 102;
    public static final byte kSetupGroupBritish = 50;
    public static final byte kSetupGroupCanada = 51;
    public static final byte kSetupGroupCodabar = 64;
    public static final byte kSetupGroupCodablock = 77;
    public static final byte kSetupGroupCode11 = 74;
    public static final byte kSetupGroupCode128 = 67;
    public static final byte kSetupGroupCode39 = 66;
    public static final byte kSetupGroupCode93 = 65;
    public static final byte kSetupGroupConfiguration = 116;
    public static final byte kSetupGroupDataEditing = 101;
    public static final byte kSetupGroupDataMatrix = 84;
    public static final byte kSetupGroupDecodingSecurity = 113;
    public static final byte kSetupGroupDirectPartMarking = 123;
    public static final byte kSetupGroupDutch = 54;
    public static final byte kSetupGroupGs1Composite = 86;
    public static final byte kSetupGroupGs1Databar = 79;
    public static final byte kSetupGroupInterleaved2of5 = 68;
    public static final byte kSetupGroupIscpParameters = 115;
    public static final byte kSetupGroupJapan = 53;
    public static final byte kSetupGroupMatrix2of5 = 69;
    public static final byte kSetupGroupMaxicode = 82;
    public static final byte kSetupGroupMessageFormat = 96;
    public static final byte kSetupGroupMsiCode = 70;
    public static final byte kSetupGroupPdf417 = 76;
    public static final byte kSetupGroupPlanet = 49;
    public static final byte kSetupGroupPlesseyCode = 71;
    public static final byte kSetupGroupPostnet = 48;
    public static final byte kSetupGroupProtocol = 97;
    public static final byte kSetupGroupQrCode = 85;
    public static final byte kSetupGroupSerialInterface = 99;
    public static final int kSetupGroupSocketCommands = 251;
    public static final byte kSetupGroupStandard2of5 = 72;
    public static final byte kSetupGroupSystemCommands = 117;
    public static final byte kSetupGroupTelepen = 73;
    public static final byte kSetupGroupTlc39 = 78;
    public static final byte kSetupGroupTriggerSettings = 112;
    public static final byte kSetupGroupUpcEan = 75;
    public static final byte kSetupGroupUspsIntelligentMail = 58;
    public static final int kSetupGs1CompositeFunctionAbActivation = 64;
    public static final int kSetupGs1CompositeFunctionAbCodeMark = 72;
    public static final int kSetupGs1CompositeFunctionAbUdsi = 192;
    public static final int kSetupGs1CompositeFunctionCActivation = 65;
    public static final int kSetupGs1CompositeFunctionCCodeMark = 73;
    public static final int kSetupGs1CompositeFunctionCUsdi = 193;
    public static final int kSetupGs1CompositeFunctionLinearOnly = 68;
    public static final int kSetupGs1CompositeFunctionMessageDecoding = 94;
    public static final int kSetupGs1CompositeFunctionUccGs1Emulation = 67;
    public static final int kSetupGs1DatabarFunctionExpandedActivation = 66;
    public static final int kSetupGs1DatabarFunctionExpandedCodeMark = 74;
    public static final int kSetupGs1DatabarFunctionExpandedUdsi = 194;
    public static final int kSetupGs1DatabarFunctionLengthL1 = 80;
    public static final int kSetupGs1DatabarFunctionLengthL2 = 81;
    public static final int kSetupGs1DatabarFunctionLengthL3 = 82;
    public static final int kSetupGs1DatabarFunctionLengthMode = 83;
    public static final int kSetupGs1DatabarFunctionLimitedActivation = 65;
    public static final int kSetupGs1DatabarFunctionLimitedCodeMark = 73;
    public static final int kSetupGs1DatabarFunctionLimitedUdsi = 193;
    public static final int kSetupGs1DatabarFunctionOmniDirectionalActivation = 64;
    public static final int kSetupGs1DatabarFunctionOmniDirectionalCodeMark = 72;
    public static final int kSetupGs1DatabarFunctionOmniDirectionalUdsi = 192;
    public static final byte kSetupInterleaved2of5FunctionActivation = 64;
    public static final byte kSetupInterleaved2of5FunctionCheckDigitTransmission = 84;
    public static final byte kSetupInterleaved2of5FunctionCheckDigitVerification = 76;
    public static final byte kSetupInterleaved2of5FunctionCodeMark = 72;
    public static final byte kSetupInterleaved2of5FunctionLengthL1 = 80;
    public static final byte kSetupInterleaved2of5FunctionLengthL2 = 81;
    public static final byte kSetupInterleaved2of5FunctionLengthL3 = 82;
    public static final byte kSetupInterleaved2of5FunctionLengthMode = 83;
    public static final int kSetupIscpParametersFunctionBarcodeDataFrameFormat = 78;
    public static final int kSetupIscpParametersFunctionConfigurationBarcodeRejectedEvent = 66;
    public static final int kSetupIscpParametersFunctionDataFormat = 64;
    public static final int kSetupIscpParametersFunctionEndOfReadSession = 72;

    /* renamed from: kSetupIscpParametersFunctionSetupModificationByConfigurationBarcodeEvent */
    public static final int f11xe9b0c76b = 65;
    public static final int kSetupIscpParametersFunctionStartOfReadSession = 71;
    public static final int kSetupIscpParametersFunctionStartUpEvent = 73;
    public static final int kSetupIscpParametersFunctionTfs = 128;
    public static final int kSetupIscpParametersFunctionTriggerPulledEvent = 74;
    public static final int kSetupIscpParametersFunctionTriggerReleasedEvent = 75;
    public static final int kSetupIscpParametersFunctionUnsuccessfulDecodedEvent = 70;
    public static final int kSetupJapanFunctionActivation = 64;
    public static final int kSetupJapanFunctionCodeMark = 72;
    public static final int kSetupJapanFunctionUdsi = 192;
    public static final byte kSetupMatrix2of5FunctionActivation = 64;
    public static final byte kSetupMatrix2of5FunctionCheckDigitTransmission = 84;
    public static final byte kSetupMatrix2of5FunctionCheckDigitVerification = 76;
    public static final byte kSetupMatrix2of5FunctionCodeMark = 72;
    public static final byte kSetupMatrix2of5FunctionLengthL1 = 80;
    public static final byte kSetupMatrix2of5FunctionLengthL2 = 81;
    public static final byte kSetupMatrix2of5FunctionLengthL3 = 82;
    public static final byte kSetupMatrix2of5FunctionLengthMode = 83;
    public static final int kSetupMaxicodeFunctionActivation = 64;
    public static final int kSetupMaxicodeFunctionCodeMark = 72;
    public static final int kSetupMaxicodeFunctionUdsi = 192;
    public static final int kSetupMessageFormatFunctionInterCharacterDelay = 128;
    public static final int kSetupMessageFormatFunctionInterMessageDelay = 129;
    public static final int kSetupMessageFormatFunctionOutputMessageOnSuccessfulRead = 65;
    public static final int kSetupMessageFormatFunctionOutputMessageSelection = 194;
    public static final int kSetupMessageFormatFunctionPostamble = 193;
    public static final int kSetupMessageFormatFunctionPreamble = 192;
    public static final int kSetupMessageFormatFunctionSymbologyIdentifier = 64;
    public static final byte kSetupMsiCodeFunctionActivation = 64;
    public static final byte kSetupMsiCodeFunctionCheckDigitTransmission = 84;
    public static final byte kSetupMsiCodeFunctionCheckDigitVerification = 76;
    public static final byte kSetupMsiCodeFunctionCodeMark = 72;
    public static final byte kSetupMsiCodeFunctionLengthL1 = 80;
    public static final byte kSetupMsiCodeFunctionLengthL2 = 81;
    public static final byte kSetupMsiCodeFunctionLengthL3 = 82;
    public static final byte kSetupMsiCodeFunctionLengthMode = 83;
    public static final byte kSetupPdf417FunctionActivation = 64;
    public static final byte kSetupPdf417FunctionAddressee = 93;
    public static final byte kSetupPdf417FunctionChecksum = 95;
    public static final byte kSetupPdf417FunctionCodeMark = 72;
    public static final byte kSetupPdf417FunctionControlHeader = 88;
    public static final byte kSetupPdf417FunctionFileName = 89;
    public static final byte kSetupPdf417FunctionFileSize = 94;
    public static final byte kSetupPdf417FunctionMacroPdf = 65;
    public static final byte kSetupPdf417FunctionMicroPdf417Activation = 66;
    public static final byte kSetupPdf417FunctionMicroPdf417Emulation = 69;
    public static final byte kSetupPdf417FunctionSegment = 90;
    public static final byte kSetupPdf417FunctionSender = 92;
    public static final byte kSetupPdf417FunctionTimeStamp = 91;
    public static final int kSetupPlanetFunctionActivation = 64;
    public static final int kSetupPlanetFunctionCheckDigitTransmission = 84;
    public static final int kSetupPlanetFunctionCodeMark = 72;
    public static final int kSetupPlanetFunctionUdsi = 192;
    public static final byte kSetupPlesseyCodeFunctionActivation = 64;
    public static final byte kSetupPlesseyCodeFunctionCheckDigitTransmission = 84;
    public static final byte kSetupPlesseyCodeFunctionCodeMark = 72;
    public static final byte kSetupPlesseyCodeFunctionLengthL1 = 80;
    public static final byte kSetupPlesseyCodeFunctionLengthL2 = 81;
    public static final byte kSetupPlesseyCodeFunctionLengthL3 = 82;
    public static final byte kSetupPlesseyCodeFunctionLengthMode = 83;
    public static final byte kSetupPostnetFunctionActivation = 64;
    public static final int kSetupPostnetFunctionCheckDigitTransmission = 84;
    public static final int kSetupPostnetFunctionCodeMark = 72;
    public static final int kSetupPostnetFunctionUdsi = 192;
    public static final int kSetupProtocolFunctionActivation = 64;
    public static final int kSetupQrCodeFunctionActivation = 64;
    public static final int kSetupQrCodeFunctionBarcodeLengthL1 = 144;
    public static final int kSetupQrCodeFunctionBarcodeLengthL2 = 145;
    public static final int kSetupQrCodeFunctionBarcodeLengthL3 = 146;
    public static final int kSetupQrCodeFunctionBarcodeLengthMode = 83;
    public static final int kSetupQrCodeFunctionCodeMark = 72;
    public static final int kSetupQrCodeFunctionUdsi = 192;
    public static final int kSetupSerialInterfaceFunctionAck = 71;
    public static final int kSetupSerialInterfaceFunctionAckCharacter = 72;
    public static final int kSetupSerialInterfaceFunctionBaudrate = 64;
    public static final int kSetupSerialInterfaceFunctionDataBits = 66;
    public static final int kSetupSerialInterfaceFunctionEnq = 69;
    public static final int kSetupSerialInterfaceFunctionEnqCharacter = 70;
    public static final int kSetupSerialInterfaceFunctionFlowControlTimeout = 128;
    public static final int kSetupSerialInterfaceFunctionLrc = 76;
    public static final int kSetupSerialInterfaceFunctionNak = 73;
    public static final int kSetupSerialInterfaceFunctionNakCharacter = 74;
    public static final int kSetupSerialInterfaceFunctionParity = 67;
    public static final int kSetupSerialInterfaceFunctionRtsCtsHardwareProtocol = 65;
    public static final int kSetupSerialInterfaceFunctionStopBits = 68;
    public static final int kSetupSerialInterfaceFunctionXonXoff = 75;
    public static final int kSetupSocketCommandsFunctionBatteryNotifications = 227;
    public static final int kSetupSocketCommandsFunctionBatteryPercentage = 157;
    public static final int kSetupSocketCommandsFunctionBatteryState = 215;
    public static final int kSetupSocketCommandsFunctionBluetoothDeviceAddress = 197;
    public static final int kSetupSocketCommandsFunctionButtonAction = 146;
    public static final int kSetupSocketCommandsFunctionButtonNotifications = 225;
    public static final int kSetupSocketCommandsFunctionButtonState = 145;
    public static final int kSetupSocketCommandsFunctionConnectReason = 133;
    public static final int kSetupSocketCommandsFunctionConnectionBeepConfig = 158;
    public static final int kSetupSocketCommandsFunctionDataFormat = 155;
    public static final int kSetupSocketCommandsFunctionDataStore = 214;
    public static final int kSetupSocketCommandsFunctionDecodeStartStop = 149;
    public static final int kSetupSocketCommandsFunctionDeletePairingAndBonding = 131;
    public static final int kSetupSocketCommandsFunctionDisconnect = 132;
    public static final int kSetupSocketCommandsFunctionEchoRequest = 217;
    public static final int kSetupSocketCommandsFunctionFriendlyName = 193;
    public static final int kSetupSocketCommandsFunctionHostBluetoothAddress = 198;
    public static final int kSetupSocketCommandsFunctionHostDataConfirmation = 152;
    public static final int kSetupSocketCommandsFunctionLocalDataConfirmation = 153;
    public static final int kSetupSocketCommandsFunctionModemStatusModes = 130;
    public static final int kSetupSocketCommandsFunctionNotifications = 211;
    public static final int kSetupSocketCommandsFunctionPinCode = 194;
    public static final int kSetupSocketCommandsFunctionPowerNotifications = 226;
    public static final int kSetupSocketCommandsFunctionPowerOff = 150;
    public static final int kSetupSocketCommandsFunctionPowerState = 154;
    public static final int kSetupSocketCommandsFunctionProfileConfiguration = 196;
    public static final int kSetupSocketCommandsFunctionProtocolVersion = 136;
    public static final int kSetupSocketCommandsFunctionRadioPower = 195;
    public static final int kSetupSocketCommandsFunctionRestoreFactoryDefaults = 151;
    public static final int kSetupSocketCommandsFunctionRumble = 210;
    public static final int kSetupSocketCommandsFunctionScanMode = 134;
    public static final int kSetupSocketCommandsFunctionScanModeTimeout = 135;
    public static final int kSetupSocketCommandsFunctionSecurityMode = 129;
    public static final int kSetupSocketCommandsFunctionSound = 209;
    public static final int kSetupSocketCommandsFunctionStandConfig = 165;
    public static final int kSetupSocketCommandsFunctionStartupRoleSPP = 156;
    public static final int kSetupSocketCommandsFunctionStatisticCounters = 213;
    public static final int kSetupSocketCommandsFunctionTimers = 216;
    public static final int kSetupSocketCommandsFunctionTriggerLockUnlock = 148;
    public static final int kSetupSocketCommandsFunctionTriggerMode = 147;
    public static final int kSetupSocketCommandsFunctionVersionInformation = 212;
    public static final byte kSetupStandard2of5FunctionActivation = 64;
    public static final byte kSetupStandard2of5FunctionCheckDigitTransmission = 84;
    public static final byte kSetupStandard2of5FunctionCheckDigitVerification = 76;
    public static final byte kSetupStandard2of5FunctionCodeMark = 72;
    public static final byte kSetupStandard2of5FunctionLengthL1 = 80;
    public static final byte kSetupStandard2of5FunctionLengthL2 = 81;
    public static final byte kSetupStandard2of5FunctionLengthL3 = 82;
    public static final byte kSetupStandard2of5FunctionLengthMode = 83;
    public static final byte kSetupStandard2of5FunctionStandard2of5Format = 88;
    public static final int kSetupSystemCommandsFunctionLogging = 64;
    public static final int kSetupSystemCommandsFunctionNonReadAheadMode = 65;
    public static final int kSetupSystemCommandsFunctionOperatingFrequency = 128;
    public static final byte kSetupTelepenFunctionActivation = 64;
    public static final byte kSetupTelepenFunctionCodeMark = 72;
    public static final byte kSetupTelepenFunctionFormat = 72;
    public static final byte kSetupTelepenFunctionLengthL1 = 80;
    public static final byte kSetupTelepenFunctionLengthL2 = 81;
    public static final byte kSetupTelepenFunctionLengthL3 = 82;
    public static final byte kSetupTelepenFunctionLengthMode = 83;
    public static final byte kSetupTlc39FunctionActivation = 64;
    public static final int kSetupTlc39FunctionCodeMark = 72;
    public static final int kSetupTlc39FunctionLinearOnly = 68;
    public static final int kSetupTlc39FunctionSecurity = 71;
    public static final int kSetupTlc39FunctionUdsi = 192;
    public static final int kSetupTriggerSettingsFunctionAimingBeam = 69;
    public static final int kSetupTriggerSettingsFunctionAimingBeamDuration = 129;
    public static final int kSetupTriggerSettingsFunctionHardwareTrigger = 65;
    public static final int kSetupTriggerSettingsFunctionPowerHold = 71;
    public static final int kSetupTriggerSettingsFunctionSoftwareInputSynchronization = 66;
    public static final int kSetupTriggerSettingsFunctionStartCharacter = 67;
    public static final int kSetupTriggerSettingsFunctionStopCharacter = 68;
    public static final int kSetupTriggerSettingsFunctionTimeoutT1 = 128;
    public static final int kSetupTriggerSettingsFunctionTriggerMode = 64;
    public static final int kSetupTriggerSettingsFunctionTurnOffAfterGoodRead = 70;
    public static final byte kSetupUpcEanFunctionAddOn2 = 69;
    public static final byte kSetupUpcEanFunctionAddOn5 = 70;
    public static final byte kSetupUpcEanFunctionAddOnDigits = 93;
    public static final byte kSetupUpcEanFunctionCheckDigitEan13Transmitted = 87;
    public static final byte kSetupUpcEanFunctionCheckDigitEan8Transmitted = 86;
    public static final byte kSetupUpcEanFunctionCheckDigitUpcATransmitted = 84;
    public static final byte kSetupUpcEanFunctionCheckDigitUpcETransmitted = 85;
    public static final byte kSetupUpcEanFunctionEan13Activation = 67;
    public static final byte kSetupUpcEanFunctionEan13CodeMark = 75;
    public static final byte kSetupUpcEanFunctionEan8Activation = 66;
    public static final byte kSetupUpcEanFunctionEan8CodeMark = 74;
    public static final byte kSetupUpcEanFunctionEan8TransmittedAsEan13 = 92;
    public static final byte kSetupUpcEanFunctionIsbnConversionEan13Activation = 68;
    public static final byte kSetupUpcEanFunctionUpcAActivation = 64;
    public static final byte kSetupUpcEanFunctionUpcACodeMark = 72;
    public static final byte kSetupUpcEanFunctionUpcANumberSystemTransmitted = 88;
    public static final byte kSetupUpcEanFunctionUpcATransmittedAsEan13 = 90;
    public static final byte kSetupUpcEanFunctionUpcE1Activation = 76;
    public static final byte kSetupUpcEanFunctionUpcEActivation = 65;
    public static final byte kSetupUpcEanFunctionUpcECodeMark = 73;
    public static final byte kSetupUpcEanFunctionUpcENumberSystemTransmitted = 89;
    public static final byte kSetupUpcEanFunctionUpcETransmittedAsUpcA = 91;
    public static final int kSetupUspsIntelligentMailFunctionActivation = 64;
    public static final int kSocketBatteryLevelMask = 3840;
    public static final int kSocketBatteryLevelShift = 8;
    public static final int kSocketButtonPowerPressed = 1;
    public static final int kSocketButtonScanPressed = 2;
    public static final int kSocketDecodeStart = 0;
    public static final int kSocketDecodeStop = 1;
    public static final int kSocketLocalDecodeActionBadBeep = 8;
    public static final int kSocketLocalDecodeActionBadBeepFlash = 10;
    public static final int kSocketLocalDecodeActionBadBeepFlashRumble = 14;
    public static final int kSocketLocalDecodeActionBadBeepRumble = 12;
    public static final int kSocketLocalDecodeActionBadFlash = 9;
    public static final int kSocketLocalDecodeActionBadFlashRumble = 13;
    public static final int kSocketLocalDecodeActionBadRumble = 11;
    public static final int kSocketLocalDecodeActionBeep = 1;
    public static final int kSocketLocalDecodeActionBeepFlash = 3;
    public static final int kSocketLocalDecodeActionBeepFlashRumble = 7;
    public static final int kSocketLocalDecodeActionBeepRumble = 5;
    public static final int kSocketLocalDecodeActionFlash = 2;
    public static final int kSocketLocalDecodeActionFlashRumble = 6;
    public static final int kSocketLocalDecodeActionNone = 0;
    public static final int kSocketLocalDecodeActionRumble = 4;
    public static final int kSocketNotifyBatteryLevelChange = 32;
    public static final int kSocketNotifyPowerButtonPress = 4;
    public static final int kSocketNotifyPowerButtonRelease = 8;
    public static final int kSocketNotifyPowerState = 16;
    public static final int kSocketNotifyScanButtonPress = 1;
    public static final int kSocketNotifyScanButtonRelease = 2;
    public static final int kSocketPowerStateOnAc = 2;
    public static final int kSocketPowerStateOnBattery = 1;
    public static final int kSocketPowerStateOnCradle = 4;
    public static final byte kSocketSecurityModeAuthentication = 1;
    public static final byte kSocketSecurityModeAuthenticationEncryption = 2;
    public static final byte kSocketSecurityModeNone = 0;
    public static final int kSocketTriggerLock = 0;
    public static final int kSocketTriggerModeAutoLock = 1;
    public static final int kSocketTriggerModeNormal = 0;
    public static final int kSocketTriggerUnlock = 1;
    public static final int kStatusConfigurationFunctionDataEditingNumber = 64;
    public static final int kStatusConfigurationFunctionSignature = 192;
    public static final byte kStatusGroupConfiguration = 64;
    public static final byte kStatusGroupDecoding = 32;
    public static final byte kStatusGroupHardware = 48;
    public static final int kStatusHardwareFunctionBatteryStatus = 64;
    public static final int kStatusHardwareFunctionBluetoothAddress = 195;
    public static final int kStatusHardwareFunctionBluetoothRadioVersion = 197;
    public static final int kStatusHardwareFunctionCoProcessorVersion = 198;
    public static final int kStatusHardwareFunctionDecodeVersion = 194;
    public static final int kStatusHardwareFunctionDefault1dFilter = 208;
    public static final int kStatusHardwareFunctionDefaultStackedFilterSequence = 209;
    public static final int kStatusHardwareFunctionFilterList = 210;
    public static final int kStatusHardwareFunctionFirmwareVersion = 192;
    public static final int kStatusHardwareFunctionHardwareIdentifier = 130;
    public static final int kStatusHardwareFunctionMaxRxFrameSize = 128;
    public static final int kStatusHardwareFunctionMaxTxFrameSize = 129;
    public static final int kStatusHardwareFunctionShutterSpeed = 131;
    public static final int kStatusHardwareFunctionSubSystemVersion = 196;
    static final int kStringOffset = 8;
    public static final byte kStx = 2;
    public static final byte kSymbologyIdAll = 0;
    public static final byte kSymbologyIdAmes = 20;
    public static final byte kSymbologyIdAustralianPost = 65;
    public static final byte kSymbologyIdAztec = 74;
    public static final byte kSymbologyIdBpo = 63;
    public static final byte kSymbologyIdCanadaPost = 64;
    public static final byte kSymbologyIdChinaPost = 68;
    public static final byte kSymbologyIdCodabar = 19;
    public static final byte kSymbologyIdCodablock256 = 32;
    public static final byte kSymbologyIdCodablockA = 30;
    public static final byte kSymbologyIdCodablockF = 31;
    public static final byte kSymbologyIdCode11 = 26;
    public static final byte kSymbologyIdCode128 = 23;
    public static final byte kSymbologyIdCode16k = 24;
    public static final byte kSymbologyIdCode39 = 13;
    public static final byte kSymbologyIdCode39Cpi = 29;
    public static final byte kSymbologyIdCode49 = 28;
    public static final byte kSymbologyIdCode93 = 25;
    public static final byte kSymbologyIdDataMatrix = 40;
    public static final byte kSymbologyIdDutchPost = 67;
    public static final byte kSymbologyIdEan13 = 1;
    public static final byte kSymbologyIdEan13CompositeCCA = 47;
    public static final byte kSymbologyIdEan13CompositeCCB = 55;
    public static final byte kSymbologyIdEan13WithAddOn2 = 5;
    public static final byte kSymbologyIdEan13WithAddOn5 = 9;
    public static final byte kSymbologyIdEan8 = 2;
    public static final byte kSymbologyIdEan8CompositeCCA = 48;
    public static final byte kSymbologyIdEan8CompositeCCB = 56;
    public static final byte kSymbologyIdEan8WithAddOn2 = 6;
    public static final byte kSymbologyIdEan8WithAddOn5 = 10;
    public static final byte kSymbologyIdGS1DataBarExpandedCompositeCCB = 53;
    public static final byte kSymbologyIdGS1DataBarLimitedCompositeCCB = 52;
    public static final byte kSymbologyIdGS1DataBarOmniCompositeCCB = 51;
    public static final byte kSymbologyIdGs1128 = 34;
    public static final byte kSymbologyIdGs1CompositeGs1128CompositeCCA = 46;
    public static final byte kSymbologyIdGs1CompositeGs1128CompositeCCB = 54;
    public static final byte kSymbologyIdGs1CompositeGs1128CompositeCCC = 59;
    public static final byte kSymbologyIdGs1DataBarExpanded = 39;
    public static final byte kSymbologyIdGs1DataBarExpandedCompositeCCA = 45;
    public static final byte kSymbologyIdGs1DataBarLimited = 38;
    public static final byte kSymbologyIdGs1DataBarLimitedCompositeCCA = 44;
    public static final byte kSymbologyIdGs1DataBarOmniCompositeCCA = 43;
    public static final byte kSymbologyIdGs1DataBarOmniDirectional = 37;
    public static final byte kSymbologyIdIncompleteMulticode = 78;
    public static final byte kSymbologyIdInfomail = 76;
    public static final byte kSymbologyIdInterleaved2of5 = 15;
    public static final byte kSymbologyIdIsbn = 60;
    public static final byte kSymbologyIdIsbt128 = 35;
    public static final byte kSymbologyIdIsmn = 72;
    public static final byte kSymbologyIdIssn = 73;
    public static final byte kSymbologyIdJapanPost = 66;
    public static final byte kSymbologyIdKoreanPost = 69;
    public static final byte kSymbologyIdMatrix2of5 = 17;
    public static final byte kSymbologyIdMaxiCode = 42;
    public static final byte kSymbologyIdMicroPdf = 36;
    public static final byte kSymbologyIdMsi = 21;
    public static final byte kSymbologyIdMulticode = 77;
    public static final byte kSymbologyIdPdf417 = 33;
    public static final byte kSymbologyIdPlanet = 62;
    public static final byte kSymbologyIdPlessey = 22;
    public static final byte kSymbologyIdPostnet = 61;
    public static final byte kSymbologyIdQRCode = 41;
    public static final byte kSymbologyIdStandard2of5 = 16;
    public static final byte kSymbologyIdSwedenPost = 75;
    public static final byte kSymbologyIdTelepen = 27;
    public static final byte kSymbologyIdTlc39 = 70;
    public static final byte kSymbologyIdTrioptic = 71;
    public static final byte kSymbologyIdUPCA = 3;
    public static final byte kSymbologyIdUPCE = 4;
    public static final byte kSymbologyIdUpcACompositeCCA = 49;
    public static final byte kSymbologyIdUpcACompositeCCB = 57;
    public static final byte kSymbologyIdUpcAWithAddOn2 = 7;
    public static final byte kSymbologyIdUpcAWithAddOn5 = 11;
    public static final byte kSymbologyIdUpcECompositeCCA = 50;
    public static final byte kSymbologyIdUpcECompositeCCB = 58;
    public static final byte kSymbologyIdUpcEWithAddOn2 = 8;
    public static final byte kSymbologyIdUpcEWithAddOn5 = 12;
    public static final byte kSymbologyIdUspsIntelligentMail = 79;
    static final int kSymbologyStatusOffset = 6;
    public static final int sizeofUChar = 1;
    public static final int sizeofUshort = 2;
    private final char[] BTISCP_GET_MTU = {'C', '0', 128};
    private final char DEFAULT_MTU = 128;
    private final int kMaxPacketsInPool = 4;
    private final int kPacketSize = 8192;
    final int kPreambleOffset = 17;
    private final int kReadCacheMaxSize = 128;
    private SktScanTypes.TSktScanSymbology m_LastSymbologyInfo;
    private SktPlatform.SktLock m_MapSequenceNumberLock = new SktPlatform.SktLock();
    private SktList m_MapSequenceNumberToSktScanPropId = new SktList();
    private SktPlatform.SktEvent m_PacketReadyToSendEvent = new SktPlatform.SktEvent();
    private SktPacket[] m_PacketsPool;
    SktCache m_ReadCache = new SktCache();
    private SktPlatform.SktLock m_ScanObjDeviceBypassLock = new SktPlatform.SktLock();
    private SktList m_WriteBuffer = new SktList();
    private SktPlatform.SktLock m_WriteBufferLock = new SktPlatform.SktLock();
    private boolean m_bProtocolResync;
    private byte m_eUndleState;
    private int m_nInitializationPropertiesCount;
    private int m_nPacketAvailable;
    private int m_nPacketComplete;
    private char m_ucSequenceNumber = 0;
    private char m_wMtu = 128;
    private final byte stateData = 1;
    private final byte stateEsc = 2;
    private final byte stateSync = 0;

    interface eParamType {
        public static final int kByte = 1;
        public static final int kNone = 0;
        public static final int kString = 3;
        public static final int kWord = 2;
    }

    class SktGroupFunctionParam {
        private int m_Byte = 0;
        private char m_Word = 0;
        private String m_pValue = null;
        private int m_ucFunctionId = 0;
        private int m_ucGroupId = 0;

        public SktGroupFunctionParam() {
        }

        /* access modifiers changed from: package-private */
        public void SetGroupId(int ucGroupId) {
            this.m_ucGroupId = ucGroupId;
        }

        /* access modifiers changed from: package-private */
        public int GetGroupId() {
            return this.m_ucGroupId;
        }

        /* access modifiers changed from: package-private */
        public void SetFunctionId(int ucFunctionId) {
            this.m_ucFunctionId = ucFunctionId;
        }

        /* access modifiers changed from: package-private */
        public int GetFunctionId() {
            return this.m_ucFunctionId;
        }

        /* access modifiers changed from: package-private */
        public int GetParamType() {
            return this.m_ucFunctionId >> 6;
        }

        /* access modifiers changed from: package-private */
        public void SetByteValue(int ucNewValue) {
            this.m_Byte = ucNewValue;
        }

        /* access modifiers changed from: package-private */
        public int GetByteValue() {
            return this.m_Byte;
        }

        /* access modifiers changed from: package-private */
        public void SetWordValue(char wNewValue) {
            this.m_Word = wNewValue;
        }

        /* access modifiers changed from: package-private */
        public char GetWordValue() {
            return this.m_Word;
        }

        /* access modifiers changed from: package-private */
        public long WriteStringValue(String pszNewString, int wLength) {
            if (wLength <= 0) {
                return 0;
            }
            this.m_pValue = "";
            if (this.m_pValue == null) {
                return -2;
            }
            this.m_pValue = pszNewString;
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String GetStringValue() {
            return this.m_pValue;
        }

        /* access modifiers changed from: package-private */
        public long FillParamFromFunctionType(char[] pBuffer, SktScanTypes.TSktScanInteger Offset) {
            long Result = 0;
            if (pBuffer == null || Offset == null) {
                Result = -18;
            }
            int pOffset = Offset.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (GetParamType()) {
                    case 1:
                        this.m_Byte = pBuffer[pOffset];
                        pOffset++;
                        break;
                    case 2:
                        this.m_Word = pBuffer[pOffset];
                        int pOffset2 = pOffset + 1;
                        this.m_Word = (char) (this.m_Word << 8);
                        this.m_Word = (char) (this.m_Word + pBuffer[pOffset2]);
                        pOffset = pOffset2 + 1;
                        break;
                    case 3:
                        char wLength = pBuffer[pOffset];
                        int pOffset3 = pOffset + 1;
                        int wLength2 = (wLength << 8) + pBuffer[pOffset3];
                        pOffset = pOffset3 + 1;
                        this.m_pValue = null;
                        if (wLength2 > 0) {
                            this.m_pValue = new String(arrays.copy(pBuffer, pOffset, wLength2));
                            pOffset += wLength2;
                            break;
                        }
                        break;
                    default:
                        SktDebug.DBGSKT_MSG(68, "Unknown Param Type: 0x" + GetParamType());
                        Result = -23;
                        break;
                }
            }
            Offset.setValue(pOffset);
            return Result;
        }
    }

    class SktBtIscpMapSequenceNumberPropId {
        private long m_PropertyId = 0;
        private boolean m_bGet = false;
        private char m_ucSequenceNumber = 0;

        public SktBtIscpMapSequenceNumberPropId() {
        }

        public void SetSequenceNumber(char ucSequenceNumber) {
            this.m_ucSequenceNumber = ucSequenceNumber;
        }

        public int GetSequenceNumber() {
            return this.m_ucSequenceNumber;
        }

        public void SetPropertyId(long PropId) {
            this.m_PropertyId = PropId;
        }

        public long GetPropertyId() {
            return this.m_PropertyId;
        }

        public void SetGetOperation(boolean bGet) {
            this.m_bGet = bGet;
        }

        public boolean GetGetOperation() {
            return this.m_bGet;
        }
    }

    class SktPacket extends SktBuffer {
        public boolean m_bComplete = false;
        public boolean m_bWrongProtocol = false;

        public SktPacket() {
        }
    }

    static class TSktBtIscpSymbologyTranslator {
        int SktSymbologyID;
        char ucFunctionId;
        char ucGroupId;

        public TSktBtIscpSymbologyTranslator(int SymbologyID, int GroupId, int FunctionId) {
            this.SktSymbologyID = SymbologyID;
            this.ucGroupId = (char) GroupId;
            this.ucFunctionId = (char) FunctionId;
        }
    }

    static class TSktDecodedSymbologyTranslator {
        int SktSymbologyID;
        byte wSTCIdentifier;

        public TSktDecodedSymbologyTranslator(byte STCIdentifier, int SymbologyID) {
            this.SktSymbologyID = SymbologyID;
            this.wSTCIdentifier = STCIdentifier;
        }
    }

    static class TSktLocalDecodeAction {
        long ulScanAPILocalDecodeAction;
        int wBtIscpLocalDecodeAction;

        public TSktLocalDecodeAction(long ScanAPILocalDecodeAction, int BtIscpLocalDecodeAction) {
            this.ulScanAPILocalDecodeAction = ScanAPILocalDecodeAction;
            this.wBtIscpLocalDecodeAction = BtIscpLocalDecodeAction;
        }
    }

    public SktBtIscpProtocol(SktTransport pTransport) {
        super(pTransport);
    }

    public int GetProtocolId() {
        return 2;
    }

    public long StartInitializing() {
        long Result;
        long Result2 = 0;
        TSktScanObject ScanObj = new TSktScanObject();
        SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
        this.m_eUndleState = 0;
        this.m_bProtocolResync = true;
        SktDebug.DBGSKT_MSG(65, "BTISCP Protocol Starting initialization");
        this.m_nInitializationPropertiesCount = GetInitializationPropertyCount();
        SktList.Position headPosition = GetInitializationHeadPosition();
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_WriteBufferLock.Initialize(), "m_WriteBufferLock.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberLock.Initialize(), "m_MapSequenceNumberLock.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_ScanObjDeviceBypassLock.Initialize(), "m_ScanObjDeviceBypassLock.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_PacketReadyToSendEvent.Create(false, false), "m_PacketReadyToSendEvent.Create(false,false)");
        }
        this.m_nPacketAvailable = 0;
        this.m_nPacketComplete = 0;
        this.m_PacketsPool = new SktPacket[4];
        if (this.m_PacketsPool == null) {
            Result2 = -2;
        }
        for (int i = 0; i < 4; i++) {
            SktPacket sktPacket = new SktPacket();
            if (sktPacket == null) {
                Result2 = -2;
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SktDebug.DBGSKT_EVAL(sktPacket.Allocate(8192), "pPacket.Allocate(kPacketSize)");
            }
            this.m_PacketsPool[i] = sktPacket;
            if (!SktScanErrors.SKTSUCCESS(Result2)) {
                break;
            }
        }
        long Result3 = SktDebug.DBGSKT_EVAL(this.m_ReadCache.Initialize(128), "m_ReadCache.Initialize(kReadCacheMaxSize)");
        Property.f13ID = 65536;
        Property.Type = 0;
        if (SktScanErrors.SKTSUCCESS(Result3)) {
            Result3 = SktDebug.DBGSKT_EVAL(AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition)");
        }
        SktUtilities.ReleaseProperty(Property);
        Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceSpecific;
        Property.Type = 4;
        Property.Array.Size = this.BTISCP_GET_MTU.length;
        Property.Array.pData = new char[Property.Array.Size];
        if (Property.Array.pData == null) {
            Result3 = -2;
        } else {
            Property.Array.pData = arrays.copy(this.BTISCP_GET_MTU, 0, Property.Array.Size);
        }
        if (SktScanErrors.SKTSUCCESS(Result3)) {
            Result3 = SktDebug.DBGSKT_EVAL(AddInitializationProperty(true, Property, 0, headPosition, (SktProtocolInterface.TSktPropertyMaskFunction) null), "AddInitializationProperty(true,Property,SktScanErrors.ESKT_NOERROR,headPosition)");
        }
        SktUtilities.ReleaseProperty(Property);
        this.m_nInitializationPropertiesCount = GetInitializationPropertyCount() - this.m_nInitializationPropertiesCount;
        boolean bContinue = true;
        while (bContinue) {
            bContinue = false;
            SktScanTypes.TSktScanBoolean Get = new SktScanTypes.TSktScanBoolean(false);
            SktScanTypes.TSktScanLong tSktScanLong = new SktScanTypes.TSktScanLong(0);
            Result = SktDebug.DBGSKT_EVAL(ReadHeadInitializationProperty(Get, ScanObj.Property, tSktScanLong), "ReadHeadInitializationProperty(Get,ScanObj.Property,pResultToIgnore)");
            if (Get.getValue()) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetProperty(ScanObj, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "GetProperty(ScanObj,null,null)");
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SetProperty(ScanObj, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "SetProperty(ScanObj,null,null)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == tSktScanLong.getValue()) {
                bContinue = true;
            }
            SktUtilities.ReleaseProperty(ScanObj.Property);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            for (int index = 0; index < 4; index++) {
                this.m_PacketsPool[index] = null;
            }
            this.m_PacketsPool = null;
        }
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
            Result = SktDebug.DBGSKT_EVAL(ReadHeadInitializationProperty(bGet, ScanObj.Property, ResultToIgnore), "ReadHeadInitializationProperty(bGet,ScanObj.Property,ResultToIgnore)");
            if (bGet.getValue()) {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetProperty(ScanObj, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "GetProperty(ScanObj,null,null)");
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SetProperty(ScanObj, (SktScanTypes.TSktScanBoolean) null, (TSktScanObject[]) null), "SetProperty(ScanObj,null,null)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == ResultToIgnore.getValue()) {
                bContinue = true;
            }
            SktUtilities.ReleaseProperty(ScanObj.Property);
        }
        return Result;
    }

    public long CheckIfInitialized(SktScanTypes.TSktScanInteger pState) {
        boolean decodedData = false;
        TSktScanObject[] ScanObj = {new TSktScanObject()};
        SktScanTypes.TSktScanProperty Property = new SktScanTypes.TSktScanProperty();
        SktScanTypes.TSktScanBoolean bGet = new SktScanTypes.TSktScanBoolean(false);
        SktScanTypes.TSktScanLong ResultToIgnore = new SktScanTypes.TSktScanLong(0);
        SktProtocolInterface.TSktPropertyMaskFunction[] pfnMaskFunction = new SktProtocolInterface.TSktPropertyMaskFunction[1];
        SktDebug.DBGSKT_MSG(65, "initialization Receives Response");
        pState.setValue(1);
        long Result = SktDebug.DBGSKT_EVAL(RetrieveScanObject(ScanObj), "RetrieveScanObject(ScanObj)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = ScanObj[0].Msg.Result;
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == -48) {
                pState.setValue(4);
                Result = 0;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result) && ScanObj[0].Msg.MsgID == 6 && ScanObj[0].Msg.Event.f12ID == 1) {
            StoreFirstDecodedData(ScanObj[0]);
            decodedData = true;
        }
        if (!decodedData) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RemoveInitializationProperty(bGet, Property, ResultToIgnore, pfnMaskFunction), "RemoveInitializationProperty(bGet,Property,null)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (ScanObj[0].Property.f13ID == Property.f13ID) {
                    long Result2 = SktDebug.DBGSKT_EVAL(SaveInitializationResponse(Property), "SaveInitializationResponse(Property)");
                    Result = SktDebug.DBGSKT_EVAL(SktUtilities.ReleaseProperty(Property), "SktUtilities.ReleaseProperty(Property)");
                    if (this.m_nInitializationPropertiesCount > 0) {
                        this.m_nInitializationPropertiesCount--;
                    }
                } else {
                    SktList.Position headPosition = GetInitializationHeadPosition();
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(AddInitializationProperty(bGet.getValue(), Property, 0, headPosition, pfnMaskFunction[0]), "AddInitializationProperty(bGet.getValue(),Property,SktScanErrors.ESKT_NOERROR,headPosition)");
                    }
                }
            }
            SktUtilities.ReleaseProperty(ScanObj[0].Property);
        }
        if (this.m_nInitializationPropertiesCount == 0) {
            pState.setValue(2);
        }
        if (SktScanErrors.SKTSUCCESS(Result) || Result != -44) {
            return Result;
        }
        pState.setValue(3);
        return 0;
    }

    public long GetProperty(TSktScanObject pScanObj, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        SktBuffer pBuffer = null;
        if (GetTransport() == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (pBuffer = new SktBuffer()) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(TransformPropertyToBtIscpCommands(pScanObj, true, pBuffer), "TransformPropertyToBtIscpCommands(pScanObj,true,pBuffer)");
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == -17) {
                Result = -15;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddDataWriteBuffer(pBuffer), "AddDataWriteBuffer(pBuffer)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result) && Result == -15 && pbImmediateResponse != null && ppResponseScanObj != null) {
            Result = SktDebug.DBGSKT_EVAL(BuildErrorResponseScanObject(pScanObj, true, Result, ppResponseScanObj), "BuildErrorResponseScanObject(pScanObj,true,Result,ppResponseScanObj)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pScanObj.Property.f13ID == 7798788) {
                    ppResponseScanObj[0].Property.Symbology.Status = 2;
                    ppResponseScanObj[0].Msg.Result = 0;
                }
                pbImmediateResponse.setValue(true);
            }
        }
        return Result;
    }

    public long SetProperty(TSktScanObject pScanObj, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        SktBuffer pBuffer = null;
        if (GetTransport() == null) {
            Result = -19;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (pBuffer = new SktBuffer()) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(TransformPropertyToBtIscpCommands(pScanObj, false, pBuffer), "TransformPropertyToBtIscpCommands(pScanObj,false,pBuffer)");
            if (!SktScanErrors.SKTSUCCESS(Result) && Result == -17) {
                Result = -15;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(AddDataWriteBuffer(pBuffer), "AddDataWriteBuffer(pBuffer)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result) && Result == -15 && pbImmediateResponse != null && ppResponseScanObj != null) {
            Result = SktDebug.DBGSKT_EVAL(BuildErrorResponseScanObject(pScanObj, false, Result, ppResponseScanObj), "BuildErrorResponseScanObject(pScanObj,false,Result,ppResponseScanObj)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pScanObj.Property.f13ID == 7798788) {
                    ppResponseScanObj[0].Property.Symbology.Status = 2;
                    ppResponseScanObj[0].Msg.Result = 0;
                }
                pbImmediateResponse.setValue(true);
            }
        }
        return Result;
    }

    public long RetrieveScanObject(TSktScanObject[] pScanObj) {
        SktPacket[] pPacket = new SktPacket[1];
        long Result = SktDebug.DBGSKT_EVAL(RetrievePacketFromPool(true, pPacket), "RetrievePacketFromPool(true,pPacket)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (!pPacket[0].m_bWrongProtocol) {
                Result = SktDebug.DBGSKT_EVAL(BuildScanObjectFromBtIscpPacket(pPacket[0], pScanObj), "BuildScanObjectFromBtIscpPacket(pPacket,pScanObj)");
            } else {
                Result = -44;
            }
            ReturnPacketToPool(pPacket[0]);
        }
        return Result;
    }

    public long DoIoOperation(SktScanTypes.TSktScanBoolean pbPacketReady, SktPlatform.SktEvent[] ppReadCompletionEvent, SktPlatform.SktEvent[] ppWriteCompletionEvent, SktPlatform.SktEvent[] ppPacketReadyToSend) {
        long Result = SktDebug.DBGSKT_EVAL(DoIoReadOperation(pbPacketReady, ppReadCompletionEvent), "DoIoReadOperation(pbPacketReady,ppReadCompletionEvent)");
        long Result2 = SktDebug.DBGSKT_EVAL(DoIoWriteOperation(ppWriteCompletionEvent), "DoIoWriteOperation(ppWriteCompletionEvent)");
        if (!SktScanErrors.SKTSUCCESS(Result2)) {
            return Result2;
        }
        if (ppReadCompletionEvent[0] == null && ppWriteCompletionEvent[0] == null) {
            return Result2;
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

    protected static long TransformPropertyToDataPointer(SktScanTypes.TSktScanProperty pProperty, char[][] ppData, SktScanTypes.TSktScanInteger pnSize) {
        long Result = 0;
        if (pProperty == null || ppData == null || pnSize == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        switch (pProperty.Type) {
            case 0:
                return Result;
            case 2:
                ppData[0] = new char[1];
                ppData[0][0] = pProperty.Byte;
                pnSize.setValue(1);
                return Result;
            case 3:
                ppData[0] = new char[4];
                ppData[0][0] = (char) ((int) (pProperty.Ulong & 255));
                ppData[0][1] = (char) ((int) ((pProperty.Ulong >> 8) & 255));
                ppData[0][2] = (char) ((int) ((pProperty.Ulong >> 16) & 255));
                ppData[0][3] = (char) ((int) ((pProperty.Ulong >> 24) & 255));
                pnSize.setValue(4);
                return Result;
            case 4:
                ppData[0] = pProperty.Array.pData;
                pnSize.setValue(pProperty.Array.Size);
                return Result;
            case 5:
                ppData[0] = pProperty.String.m_Value.toCharArray();
                pnSize.setValue(pProperty.String.m_Value.length());
                return Result;
            default:
                return -39;
        }
    }

    /* access modifiers changed from: protected */
    public long TransformPropertyToBtIscpCommands(TSktScanObject pScanObj, boolean bGetOperation, SktBuffer pBuffer) {
        long Result = 0;
        SktTranslator Translator = new SktTranslator();
        if (pBuffer == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.InitializeTable(TablePropertyToBtIscpPrimitive, TablePropertyToBtIscpPrimitive.length), "Translator.InitializeTable(TablePropertyToBtIscpPrimitive,TablePropertyToBtIscpPrimitive.length)");
        }
        SktTranslator.TSktTranslatorData Data = new SktTranslator.TSktTranslatorData();
        Data.From.PropId = (long) pScanObj.Property.f13ID;
        Data.From.bGetOperation = bGetOperation;
        Data.pThis = this;
        Data.pDataIn = pScanObj.Property;
        Data.nDataInSize = 36;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.TranslateToPrimitive(0, Data, new SktScanTypes.TSktScanInteger(0)), "Translator.TranslateToPrimitive(Data,IndexFound)");
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_MSG(68, "Error " + Result + " for Property " + (SktScan.helper.SKTRETRIEVEGROUPID(pScanObj.Property.f13ID) == 0 ? SktScanAPI.DBG_GENERALPROPIDDEVICE_NAME[SktScan.helper.SKTRETRIEVEID(pScanObj.Property.f13ID)] : SktScanAPI.DBG_LOCALFUNCTIONSPROPID_NAME[SktScan.helper.SKTRETRIEVEID(pScanObj.Property.f13ID)]));
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pBuffer.m_pucData = (char[]) Data.pDataOut;
            pBuffer.m_nLength = Data.nDataOutSize;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long FormatBtIscpPacket(long PropId, boolean bGet, char ucFrameType, int wGroup, char ucFunction, char[] pParam, int wParamSizeInByte, char[][] ppucData, SktScanTypes.TSktScanInteger pDataSize) {
        long Result = 0;
        SktProtocolInterface.SktChecksum Checksum = new SktProtocolInterface.SktChecksum();
        int wFrameSize = 0;
        char[] pCurrent = null;
        SktScanTypes.TSktScanInteger Index = new SktScanTypes.TSktScanInteger(0);
        if (ppucData == null || pDataSize == null) {
            Result = -18;
        }
        SktScanTypes.TSktScanInteger tSktScanInteger = new SktScanTypes.TSktScanInteger(0);
        if (pParam != null && SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadParamSizeFromFunction(ucFunction, pParam, wParamSizeInByte, tSktScanInteger), "ReadParamSizeFromFunction(ucFunction,pParam,wParamSizeInByte,ParamSize)");
        }
        int nParamSize = tSktScanInteger.getValue();
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int nBufferSize = 11 + nParamSize;
        if (((long) nBufferSize) > SktUtilities.kMaxWord || wGroup > 255) {
            Result = -41;
        } else {
            wFrameSize = nBufferSize;
            ppucData[0] = new char[(nBufferSize * 2)];
            if (ppucData[0] == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pCurrent = ppucData[0];
            pCurrent[0] = 2;
            Index.setValue(0 + 1);
            SktScanTypes.TSktScanChar tSktScanChar = new SktScanTypes.TSktScanChar('0');
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveNextSequenceNumber(PropId, bGet, tSktScanChar), "RetrieveNextSequenceNumber(PropId,bGet,SequenceNumber)");
            }
            char ucSequenceNumber = tSktScanChar.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, ucSequenceNumber, Checksum), "AddDleByte(pCurrent,Index,ucSequenceNumber,Checksum)");
            }
            char[] FramSize = {(char) wFrameSize, 0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleBuffer(pCurrent, Index, FramSize, 2, Checksum), "AddDleBuffer(pCurrent,Index,FramSize,2,Checksum)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, ucFrameType, Checksum), "AddDleByte(pCurrent,Index,ucFrameType,Checksum)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, (char) wGroup, Checksum), "AddDleByte(pCurrent,Index,(byte)wGroup,Checksum)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, ucFunction, Checksum), "AddDleByte(pCurrent,Index,ucFunction,Checksum)");
            }
            int value = Index.getValue();
            if (pParam != null) {
                switch (GetParamType(ucFunction)) {
                    case 2:
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, pParam[0], Checksum), "AddDleByte(pCurrent,Index,pParam[0],Checksum)");
                            break;
                        }
                        break;
                    case 3:
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, pParam[0], Checksum), "AddDleByte(pCurrent,Index,pParam[0],Checksum)");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, pParam[1], Checksum), "AddDleByte(pCurrent,Index,pParam[1],Checksum)");
                            break;
                        }
                        break;
                    case 4:
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, (char) (wParamSizeInByte >> 8), Checksum), "AddDleByte(pCurrent,Index,(byte)(wParamSizeInByte>>8),Checksum)");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, (char) (wParamSizeInByte & 255), Checksum), "AddDleByte(pCurrent,Index,(byte)wParamSizeInByte,Checksum)");
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            if (pParam.length < 2) {
                                char tempvalue = 0;
                                if (pParam.length == 1) {
                                    tempvalue = pParam[0];
                                }
                                pParam = new char[]{tempvalue, 0};
                            }
                            Result = SktDebug.DBGSKT_EVAL(AddDleBuffer(pCurrent, Index, pParam, wParamSizeInByte, Checksum), "AddDleBuffer(pCurrent,Index,pParam,wParamSizeInByte,Checksum)");
                            break;
                        }
                        break;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, GetFrameManagement(), Checksum), "AddDleByte(pCurrent,Index,GetFrameManagement(),Checksum)");
            }
            int nIndex = Index.getValue();
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, (char) (Checksum.Get() >> 8), (SktProtocolInterface.SktChecksum) null), "AddDleByte(pCurrent,Index,(byte)(Checksum.Get()>>8),null)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, Checksum.Get(), (SktProtocolInterface.SktChecksum) null), "AddDleByte(pCurrent,Index,(byte)Checksum.Get(),null)");
            }
            int nIndex2 = Index.getValue();
            int nIndex3 = nIndex2 + 1;
            pCurrent[nIndex2] = 3;
            pDataSize.setValue(nIndex3);
            if (nIndex3 > GetMtu()) {
                int i = nIndex3;
                return -46;
            }
            return Result;
        }
        char[][] ppucData2 = null;
        pDataSize.setValue(0);
        return Result;
    }

    /* access modifiers changed from: protected */
    public long FormatRawBtIscpPacket(long PropId, boolean bGet, char[] pRawBtIscp, int nRawBtIscpSizeInByte, char[][] ppucData, SktScanTypes.TSktScanInteger pDataSize) {
        long Result = 0;
        SktProtocolInterface.SktChecksum Checksum = new SktProtocolInterface.SktChecksum();
        char[] pCurrent = null;
        SktScanTypes.TSktScanInteger Index = new SktScanTypes.TSktScanInteger(0);
        int wFrameSize = nRawBtIscpSizeInByte + 6 + 2;
        if (ppucData == null || pDataSize == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        ppucData[0] = new char[(wFrameSize * 2)];
        if (ppucData[0] == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pCurrent = ppucData[0];
            pCurrent[0] = 2;
            Index.setValue(0 + 1);
            SktScanTypes.TSktScanChar tSktScanChar = new SktScanTypes.TSktScanChar('0');
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveNextSequenceNumber(PropId, bGet, tSktScanChar), "RetrieveNextSequenceNumber(PropId,bGet,SequenceNumber)");
            }
            char ucSequenceNumber = tSktScanChar.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, ucSequenceNumber, Checksum), "AddDleByte(pCurrent,Index,ucSequenceNumber,Checksum)");
            }
            char[] FramSize = {(char) wFrameSize, 0};
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleBuffer(pCurrent, Index, FramSize, 2, Checksum), "AddDleBuffer(pCurrent,Index,FramSize,1,Checksum)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleBuffer(pCurrent, Index, pRawBtIscp, nRawBtIscpSizeInByte, Checksum), "AddDleBuffer(pCurrent,Index,pRawBtIscp,nRawBtIscpSizeInByte,Checksum)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, GetFrameManagement(), Checksum), "AddDleByte(pCurrent,Index,GetFrameManagement(),Checksum)");
            }
            int value = Index.getValue();
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, (char) (Checksum.Get() >> 8), (SktProtocolInterface.SktChecksum) null), "AddDleByte(pCurrent,Index,(byte)(Checksum.Get()>>8),null)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(AddDleByte(pCurrent, Index, (char) (Checksum.Get() & 255), (SktProtocolInterface.SktChecksum) null), "AddDleByte(pCurrent,Index,(byte)Checksum.Get(),null)");
            }
            int nIndex = Index.getValue();
            int nIndex2 = nIndex + 1;
            pCurrent[nIndex] = 3;
            pDataSize.setValue(nIndex2);
            if (nIndex2 > GetMtu()) {
                int i = nIndex2;
                return -46;
            }
            return Result;
        }
        char[][] ppucData2 = null;
        pDataSize.setValue(0);
        return Result;
    }

    /* access modifiers changed from: protected */
    public int GetParamType(char ucFunction) {
        switch (ucFunction & 192) {
            case 0:
                return 1;
            case '@':
                return 2;
            case 128:
                return 3;
            case 192:
                return 4;
            default:
                return 1;
        }
    }

    /* access modifiers changed from: protected */
    public long RetrieveNextSequenceNumber(long PropId, boolean bGet, SktScanTypes.TSktScanChar pSequenceNumber) {
        long Result = 0;
        SktBtIscpMapSequenceNumberPropId pNewSequence = new SktBtIscpMapSequenceNumberPropId();
        if (pNewSequence == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pSequenceNumber == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_ucSequenceNumber = (char) (this.m_ucSequenceNumber + 1);
            if (this.m_ucSequenceNumber == 0) {
                this.m_ucSequenceNumber = (char) (this.m_ucSequenceNumber + 1);
            } else if (this.m_ucSequenceNumber == 255) {
                this.m_ucSequenceNumber = 1;
            }
            pNewSequence.SetSequenceNumber(this.m_ucSequenceNumber);
            pNewSequence.SetPropertyId(PropId);
            pNewSequence.SetGetOperation(bGet);
            Result = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberLock.Lock(), "m_MapSequenceNumberLock.Lock()");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberToSktScanPropId.AddTail(pNewSequence), "m_MapSequenceNumberToSktScanPropId.AddTail(pNewSequence)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    pSequenceNumber.setValue(this.m_ucSequenceNumber);
                }
                this.m_MapSequenceNumberLock.Unlock();
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long RetrievePropIdFromSequenceNumber(char ucSequenceNumber, SktScanTypes.TSktScanLong pPropId, SktScanTypes.TSktScanBoolean pbGet) {
        long Result;
        SktBtIscpMapSequenceNumberPropId[] pSequence = new SktBtIscpMapSequenceNumberPropId[1];
        boolean bFound = false;
        if (pPropId == null || pbGet == null) {
        }
        if (ucSequenceNumber != 255) {
            Result = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberLock.Lock(), "m_MapSequenceNumberLock.Lock()");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktList.Position position = this.m_MapSequenceNumberToSktScanPropId.GetHeadPosition();
                while (true) {
                    if (!SktScanErrors.SKTSUCCESS(Result) || !position.IsValid()) {
                        break;
                    }
                    SktList.Position removePosition = position;
                    SktList.Position removePosition2 = position.Copy();
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        pSequence[0] = (SktBtIscpMapSequenceNumberPropId) position.GetNext();
                    }
                    if (SktScanErrors.SKTSUCCESS(Result) && pSequence[0].GetSequenceNumber() == ucSequenceNumber) {
                        pPropId.setValue(pSequence[0].GetPropertyId());
                        pbGet.setValue(pSequence[0].GetGetOperation());
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = this.m_MapSequenceNumberToSktScanPropId.RemoveAt(removePosition2, pSequence);
                        }
                        bFound = true;
                    }
                }
                this.m_MapSequenceNumberLock.Unlock();
            }
        } else {
            Result = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberLock.Lock(), "m_MapSequenceNumberLock.Lock()");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberToSktScanPropId.RemoveHead(pSequence), "m_MapSequenceNumberToSktScanPropId.RemoveHead(pSequence)");
                this.m_MapSequenceNumberLock.Unlock();
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pPropId.setValue(pSequence[0].GetPropertyId());
                pbGet.setValue(pSequence[0].GetGetOperation());
                bFound = true;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || bFound) {
            return Result;
        }
        return -17;
    }

    /* access modifiers changed from: package-private */
    public boolean isNotARepeatedSequenceNumber(char ucSequenceNumberReceived) {
        boolean bIsNotARepeatedNumber = true;
        char ucSequenceNumberReceived2 = (char) (ucSequenceNumberReceived + 1);
        if (ucSequenceNumberReceived2 == 255) {
            ucSequenceNumberReceived2 = 1;
        }
        long Result = SktDebug.DBGSKT_EVAL(this.m_MapSequenceNumberLock.Lock(), "m_MapSequenceNumberLock.Lock()");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position Position = this.m_MapSequenceNumberToSktScanPropId.GetHeadPosition();
            if (!Position.IsValid()) {
                bIsNotARepeatedNumber = false;
            }
            while (true) {
                if (!SktScanErrors.SKTSUCCESS(Result) || !Position.IsValid()) {
                    break;
                }
                SktBtIscpMapSequenceNumberPropId sequence = (SktBtIscpMapSequenceNumberPropId) Position.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (sequence.GetSequenceNumber() == ucSequenceNumberReceived2) {
                        bIsNotARepeatedNumber = false;
                    }
                }
            }
            this.m_MapSequenceNumberLock.Unlock();
        }
        return bIsNotARepeatedNumber;
    }

    /* access modifiers changed from: protected */
    public char GetFrameManagement() {
        return '`';
    }

    /* access modifiers changed from: protected */
    public long AddDleByte(char[] pData, SktScanTypes.TSktScanInteger pIndex, char ucByte, SktProtocolInterface.SktChecksum pChecksum) {
        int nIndex;
        long Result = 0;
        if (pData == null || pIndex == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            char ucByte2 = (char) (ucByte & 255);
            if (pChecksum != null) {
                pChecksum.Add(ucByte2);
            }
            int nIndex2 = pIndex.getValue();
            switch (ucByte2) {
                case 2:
                    int nIndex3 = nIndex2 + 1;
                    pData[nIndex2] = 16;
                    nIndex = nIndex3 + 1;
                    pData[nIndex3] = 'B';
                    break;
                case 3:
                    int nIndex4 = nIndex2 + 1;
                    pData[nIndex2] = 16;
                    nIndex = nIndex4 + 1;
                    pData[nIndex4] = 'C';
                    break;
                case 16:
                    int nIndex5 = nIndex2 + 1;
                    pData[nIndex2] = 16;
                    nIndex = nIndex5 + 1;
                    pData[nIndex5] = 'P';
                    break;
                default:
                    pData[nIndex2] = ucByte2;
                    nIndex = nIndex2 + 1;
                    break;
            }
            pIndex.setValue(nIndex);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long AddDleBuffer(char[] pData, SktScanTypes.TSktScanInteger pIndex, char[] pBuffer, int nBufferSize, SktProtocolInterface.SktChecksum pChecksum) {
        long Result = 0;
        if (pBuffer == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int i = 0;
        while (i < nBufferSize) {
            try {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(AddDleByte(pData, pIndex, pBuffer[i], pChecksum), "AddDleByte(pData,pIndex,pBuffer[i],pChecksum)");
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                SktDebug.DBGSKT_MSG(4, "Invalid Buffer Size " + i + "!=" + nBufferSize);
                return -18;
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long BuildErrorResponseScanObject(TSktScanObject pScanObj, boolean bGetOperation, long ResultToReport, TSktScanObject[] ppResponseScanObj) {
        long Result = 0;
        if (ppResponseScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppResponseScanObj[0] = new TSktScanObject();
            if (ppResponseScanObj != null) {
                if (bGetOperation) {
                    ppResponseScanObj[0].Msg.MsgID = 5;
                } else {
                    ppResponseScanObj[0].Msg.MsgID = 4;
                }
                ppResponseScanObj[0].Msg.Result = ResultToReport;
                Result = SktDebug.DBGSKT_EVAL(SktUtilities.AllocateAndCopyProperty(ppResponseScanObj[0].Property, pScanObj.Property), "SktUtilities.AllocateAndCopyProperty((ppResponseScanObj[0]).Property,pScanObj.Property)");
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                }
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long AddDataWriteBuffer(SktBuffer pBuffer) {
        long Result = 0;
        if (pBuffer == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_WriteBufferLock.Lock(), "m_WriteBufferLock.Lock()");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this.m_PacketReadyToSendEvent.Set(), "m_PacketReadyToSendEvent.Set()");
        long Result3 = SktDebug.DBGSKT_EVAL(this.m_WriteBuffer.AddTail(pBuffer), "m_WriteBuffer.AddTail(pBuffer)");
        this.m_WriteBufferLock.Unlock();
        return Result3;
    }

    /* access modifiers changed from: protected */
    public long DoIoReadOperation(SktScanTypes.TSktScanBoolean pbPacketReady, SktPlatform.SktEvent[] ppReadCompletionEvent) {
        long Result = 0;
        int[] nReadSize = {this.m_ReadCache.GetCacheSize()};
        SktPacket[] pPacket = new SktPacket[1];
        if (pbPacketReady == null || ppReadCompletionEvent == null) {
            Result = -18;
        } else {
            pbPacketReady.setValue(false);
            ppReadCompletionEvent[0] = null;
        }
        if (this.m_ReadCache.isEmpty() && !pbPacketReady.getValue()) {
            SktDebug.DBGSKT_MSG(InputDeviceCompat.SOURCE_DPAD, "Cache is empty, try to read more bytes");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(GetTransport().ReadBlock(this.m_ReadCache.GetPointer(), 0, nReadSize), "GetTransport().ReadBlock(m_ReadCache.GetPointer(),0,nReadSize)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (Result == 3) {
                    ppReadCompletionEvent[0] = GetTransport().GetReadCompletionEvent();
                } else {
                    SktDebug.DBGSKT_MSG(InputDeviceCompat.SOURCE_DPAD, "Add " + nReadSize[0] + " bytes in the cache and check if packet is complete");
                    this.m_ReadCache.SetDataSize(nReadSize[0]);
                }
            }
        }
        if (this.m_ReadCache.isEmpty() || pbPacketReady.getValue()) {
            return Result;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrievePacketFromPool(false, pPacket), "RetrievePacketFromPool(false,pPacket)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(UndleCacheIntoBuffer(this.m_ReadCache, pPacket[0]), "UndleCacheIntoBuffer(m_ReadCache,pPacket[0])");
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || !pPacket[0].m_bComplete) {
            return Result;
        }
        if (pPacket[0].m_bWrongProtocol) {
            pbPacketReady.setValue(true);
            return Result;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(VerifyChecksum(pPacket[0], pbPacketReady), "VerifyChecksum(pPacket[0],pbPacketReady)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReassembleIfNecessary(pPacket[0], pbPacketReady), "ReassembleIfNecessary(pPacket[0],pbPacketReady)");
        }
        if (pbPacketReady.getValue()) {
            SktDebug.DBGSKT_MSG(65, "Packet is complete with good checksum");
            if (this.m_bProtocolResync) {
                if (pPacket[0].m_pucData[0] == 255) {
                    SktDebug.DBGSKT_MSG(65, "Throw this Packet away because wrong Sequence Number");
                    pbPacketReady.setValue(false);
                } else {
                    this.m_bProtocolResync = false;
                }
            }
        }
        if (!(!pbPacketReady.getValue() || pPacket[0].m_pucData[0] == 255 || pPacket[0].m_pucData[0] == 0)) {
            pbPacketReady.setValue(isNotARepeatedSequenceNumber(pPacket[0].m_pucData[0]));
            if (pbPacketReady.getValue()) {
                SktDebug.DBGSKT_MSG(65, "If this packet a repeat?: no");
            } else {
                SktDebug.DBGSKT_MSG(65, "If this packet a repeat?: yes");
            }
        }
        if (pbPacketReady.getValue() || !SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        return SktDebug.DBGSKT_EVAL(ReturnPacketToPool(pPacket[0]), "ReturnPacketToPool(pPacket[0])");
    }

    /* access modifiers changed from: protected */
    public long DoIoWriteOperation(SktPlatform.SktEvent[] ppWriteCompletionEvent) {
        long Result = 0;
        SktBuffer[] pBuffer = new SktBuffer[1];
        int[] nByteSent = {0};
        if (ppWriteCompletionEvent == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppWriteCompletionEvent[0] = null;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_WriteBufferLock.Lock(), "m_WriteBufferLock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position position = this.m_WriteBuffer.GetHeadPosition();
            if (position.IsValid()) {
                Result = SktDebug.DBGSKT_EVAL(this.m_WriteBuffer.RemoveAt(position, pBuffer), "m_WriteBuffer.RemoveAt(position,pBuffer)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(GetTransport().WriteBlock(pBuffer[0].m_pucData, pBuffer[0].m_nLength, nByteSent), "GetTransport().WriteBlock(pBuffer[0].m_pucData,pBuffer[0].m_nLength,nByteSent)");
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        if (Result == 3) {
                            ppWriteCompletionEvent[0] = GetTransport().GetWriteCompletionEvent();
                            if (nByteSent[0] == 0) {
                                Result = SktDebug.DBGSKT_EVAL(this.m_WriteBuffer.AddHead(pBuffer), "m_WriteBuffer.AddHead(pBuffer)");
                                if (SktScanErrors.SKTSUCCESS(Result)) {
                                }
                            }
                        }
                        if (SktScanErrors.SKTSUCCESS(Result) && ppWriteCompletionEvent[0] != null) {
                            Result = 3;
                        }
                    }
                }
            }
            if (this.m_WriteBuffer.GetCount() == 0) {
                this.m_PacketReadyToSendEvent.Reset();
            }
            this.m_WriteBufferLock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long BuildScanObjectFromBtIscpPacket(SktBuffer pBuffer, TSktScanObject[] pScanObj) {
        long Result = 0;
        char ucType = 0;
        boolean bInterpreteResult = false;
        SktTranslator Translator = new SktTranslator();
        SktTranslator.TSktTranslatorData Data = new SktTranslator.TSktTranslatorData();
        if (pBuffer == null) {
            Result = -18;
        } else if (pBuffer.m_nLength < 4) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ucType = pBuffer.m_pucData[3];
            char ucSequenceNumber = pBuffer.m_pucData[0];
            if (ucSequenceNumber != 0) {
                SktScanTypes.TSktScanLong ID = new SktScanTypes.TSktScanLong(0);
                SktScanTypes.TSktScanBoolean BGet = new SktScanTypes.TSktScanBoolean(false);
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(RetrievePropIdFromSequenceNumber(ucSequenceNumber, ID, BGet), "RetrievePropIdFromSequenceNumber(ucSequenceNumber,ID,BGet)");
                }
                pScanObj[0].Property.f13ID = (int) ID.getValue();
                boolean bGet = BGet.getValue();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (bGet) {
                        pScanObj[0].Msg.MsgID = 5;
                    } else {
                        pScanObj[0].Msg.MsgID = 4;
                    }
                    if (pScanObj[0].Property.f13ID != 4456451) {
                        bInterpreteResult = true;
                    } else if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(BuildScanObjectForDeviceSpecific(pBuffer, pScanObj), "BuildScanObjectForDeviceSpecific(pBuffer,pScanObj)");
                    }
                }
            } else if (ucSequenceNumber == 0) {
                bInterpreteResult = true;
            }
        }
        if (!bInterpreteResult) {
            return Result;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.InitializeTable(TablePropertyFromBtIscpPrimitive, TablePropertyFromBtIscpPrimitive.length), "Translator.InitializeTable(TablePropertyFromBtIscpPrimitive,TablePropertyFromBtIscpPrimitive.length)");
        }
        Data.f16To.ucFrameType = ucType;
        Data.f16To.wGroupId = 0;
        Data.f16To.ucFunctionId = 0;
        if (ucType == 'P' || ucType == 'S' || ucType == 'a') {
            Data.f16To.wGroupId = pBuffer.m_pucData[4];
            Data.f16To.ucFunctionId = pBuffer.m_pucData[5];
        }
        Data.From.PropId = (long) pScanObj[0].Property.f13ID;
        Data.pThis = this;
        Data.pDataIn = pBuffer;
        Data.nDataInSize = pBuffer.m_nLength;
        Data.pDataOut = pScanObj[0];
        if (pScanObj[0].Property.Array.pData == null) {
            Data.nDataOutSize = 0;
        } else {
            Data.nDataOutSize = pScanObj[0].Property.Array.pData.length;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Translator.TranslateFromPrimitive(Data, (SktScanTypes.TSktScanInteger) null), "Translator.TranslateFromPrimitive(Data,null)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pScanObj[0].Msg.Result = Result;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long BuildScanObjectForDeviceSpecific(SktBuffer pBuffer, TSktScanObject[] pScanObj) {
        long Result = 0;
        int nLength = 0;
        if (pBuffer == null || pScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pBuffer.m_nLength - 6 < 1) {
            Result = -38;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj[0].Property.Array.pData = new char[nLength];
            if (pScanObj[0].Property.Array.pData == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = nLength;
            pScanObj[0].Property.Array.pData = arrays.copy(pBuffer.m_pucData, 3, nLength);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long CopyTypeParamDataPacketInArray(char ucFrameType, char ucGroup, char ucFunction, char[] pucParam, int wParamSize, char[] ppucData, SktScanTypes.TSktScanInteger pnDataSize) {
        long Result = 0;
        if (ppucData == null || pnDataSize == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadParamSizeFromFunction(ucFunction, pucParam, wParamSize, pnDataSize), "ReadParamSizeFromFunction(ucFunction,pucParam,wParamSize,pnDataSize)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pnDataSize.setValue(pnDataSize.getValue() + 3);
            ppucData = new char[pnDataSize.getValue()];
            if (ppucData == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            char[] pCurrent = ppucData;
            pCurrent[0] = ucFrameType;
            pCurrent[1] = ucGroup;
            pCurrent[2] = ucFunction;
            switch (GetParamType(ucFunction)) {
                case 2:
                    pCurrent[3] = pucParam[0];
                    break;
                case 3:
                    pCurrent[3] = pucParam[1];
                    pCurrent[4] = pucParam[0];
                    break;
                case 4:
                    pCurrent[3] = (char) (wParamSize >> 8);
                    pCurrent[4] = (char) wParamSize;
                    for (int i = 0; i < wParamSize; i++) {
                        pCurrent[i + 4] = pucParam[i];
                    }
                    break;
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReadParamSizeFromFunction(char ucFunction, char[] pucParam, int wParamSize, SktScanTypes.TSktScanInteger pnSize) {
        long Result = 0;
        if (pnSize == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        pnSize.setValue(0);
        switch (GetParamType(ucFunction)) {
            case 1:
                if (wParamSize != 0) {
                    return -18;
                }
                return Result;
            case 2:
                if (wParamSize != 1 || pucParam == null) {
                    return -18;
                }
                pnSize.setValue(1);
                return Result;
            case 3:
                if (wParamSize != 2 || pucParam == null) {
                    return -18;
                }
                pnSize.setValue(2);
                return Result;
            case 4:
                if (pucParam == null) {
                    return -18;
                }
                pnSize.setValue(wParamSize + 2);
                return Result;
            default:
                return Result;
        }
    }

    protected static char ConvertAsciiToNiddle(char cChar) {
        if (cChar >= '0' && cChar <= '9') {
            return (char) (cChar - '0');
        }
        if (cChar >= 'a' && cChar <= 'f') {
            return (char) ((cChar - 'a') + 10);
        }
        if (cChar < 'A' || cChar > 'F') {
            return 0;
        }
        return (char) ((cChar - 'A') + 10);
    }

    /* access modifiers changed from: protected */
    public long RetrieveResponses(SktBuffer pBuffer, SktList pResponsesList) {
        long Result = 0;
        if (pBuffer == null || pResponsesList == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int nParamLength = pBuffer.m_nLength - 3;
            int nIndex = 4;
            while (true) {
                if (nIndex < nParamLength) {
                    SktGroupFunctionParam pGroup = new SktGroupFunctionParam();
                    if (pGroup == null) {
                        Result = -2;
                    } else {
                        pGroup.SetGroupId(pBuffer.m_pucData[nIndex]);
                        nIndex++;
                        if (nIndex < pBuffer.m_nLength) {
                            pGroup.SetFunctionId(pBuffer.m_pucData[nIndex]);
                            int nIndex2 = nIndex + 1;
                            SktScanTypes.TSktScanInteger Index = new SktScanTypes.TSktScanInteger(0);
                            if (SktScanErrors.SKTSUCCESS(Result)) {
                                Result = SktDebug.DBGSKT_EVAL(pGroup.FillParamFromFunctionType(pBuffer.m_pucData, Index), "pGroup.FillParamFromFunctionType(pBuffer.m_pucData,Index)");
                            }
                            nIndex = Index.getValue();
                        } else {
                            Result = -41;
                        }
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(pResponsesList.AddTail(pGroup), "pResponsesList.AddTail(pGroup)");
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long RetrievePacketFromPool(boolean bComplete, SktPacket[] ppPacket) {
        long Result = 0;
        if (ppPacket == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        ppPacket[0] = null;
        int index = this.m_nPacketAvailable;
        if (bComplete) {
            index = this.m_nPacketComplete;
        }
        int cycle = 0;
        while (true) {
            if (cycle >= 4) {
                break;
            }
            if (index >= 4) {
                index = 0;
            }
            SktPacket pPacket = this.m_PacketsPool[index];
            if (pPacket.m_bComplete == bComplete) {
                ppPacket[0] = pPacket;
                if (bComplete) {
                    this.m_nPacketComplete = index;
                } else {
                    this.m_nPacketAvailable = index;
                }
            } else {
                index++;
                cycle++;
            }
        }
        if (ppPacket[0] == null) {
            return -17;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReturnPacketToPool(SktPacket pPacket) {
        long Result = 0;
        if (pPacket == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pPacket.m_nLength = 0;
            pPacket.m_bComplete = false;
            pPacket.m_bWrongProtocol = false;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long UndleCacheIntoBuffer(SktCache pCache, SktPacket pPacket) {
        long Result = 0;
        boolean bContinue = true;
        char[] SsiNak = {5, 209, 0, 0, 2, 255, '('};
        int nDataSize = 0;
        if (pCache == null && pPacket == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            char[] pCurrent = pPacket.m_pucData;
            nDataSize = pCache.GetDataSize();
            int i = 0;
            while (i < nDataSize) {
                SktScanTypes.TSktScanChar UCByte = new SktScanTypes.TSktScanChar('0');
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pCache.ReadByte(UCByte), "pCache.ReadByte(UCByte)");
                }
                char ucByte = UCByte.getValue();
                switch (this.m_eUndleState) {
                    case 0:
                        if (ucByte == 2) {
                            this.m_eUndleState = 1;
                            pCurrent = pPacket.m_pucData;
                            pPacket.m_nLength = 0;
                            break;
                        }
                        break;
                    case 1:
                        if (ucByte != 3) {
                            if (ucByte != 16) {
                                if (ucByte != 2) {
                                    pCurrent[pPacket.m_nLength] = ucByte;
                                    pPacket.m_nLength++;
                                    if (pPacket.m_nLength >= pPacket.m_nMaxLength) {
                                        SktDebug.DBGSKT_MSG(66, "Discard Packet too big: " + pPacket.m_nLength + " >= " + pPacket.m_nMaxLength);
                                        this.m_eUndleState = 0;
                                        pPacket.m_nLength = 0;
                                        break;
                                    }
                                } else {
                                    pCurrent = pPacket.m_pucData;
                                    pPacket.m_nLength = 0;
                                    break;
                                }
                            } else {
                                this.m_eUndleState = 2;
                                break;
                            }
                        } else {
                            this.m_eUndleState = 0;
                            pPacket.m_bComplete = true;
                            bContinue = false;
                            break;
                        }
                        break;
                    case 2:
                        if (ucByte <= '@') {
                            if (ucByte != 2) {
                                SktDebug.DBGSKT_MSG(66, "Invalid Esc sequence so restart synchro");
                                this.m_eUndleState = 0;
                                break;
                            } else {
                                SktDebug.DBGSKT_MSG(66, "Invalid Esc sequence but STX received so restart packet");
                                this.m_eUndleState = 1;
                                break;
                            }
                        } else {
                            pCurrent[pPacket.m_nLength] = (char) (ucByte - '@');
                            pPacket.m_nLength++;
                            this.m_eUndleState = 1;
                            break;
                        }
                }
                if (bContinue) {
                    i++;
                }
            }
        }
        if (!pPacket.m_bComplete && nDataSize == SsiNak.length && !arrays.equals(pCache.GetPointer(), SsiNak)) {
            pPacket.m_bComplete = true;
            pPacket.m_bWrongProtocol = true;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long VerifyChecksum(SktPacket pPacket, SktScanTypes.TSktScanBoolean pbCorrect) {
        long Result = 0;
        SktProtocolInterface.SktChecksum Checksum = new SktProtocolInterface.SktChecksum();
        if (pPacket == null || pbCorrect == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pbCorrect.setValue(false);
            int nMaxLength = pPacket.m_nLength;
            if (nMaxLength >= 7) {
                int nMaxLength2 = nMaxLength - 2;
                int index = 0;
                while (index < nMaxLength2) {
                    Checksum.Add(pPacket.m_pucData[index]);
                    index++;
                }
                int index2 = index + 1;
                int index3 = index2 + 1;
                int wCompare = (pPacket.m_pucData[index] << 8) + pPacket.m_pucData[index2];
                if (wCompare == Checksum.Get()) {
                    pbCorrect.setValue(true);
                    int i = index3;
                } else {
                    SktDebug.DBGSKT_MSG(66, "Invalid checksum: 0x" + Integer.toHexString(wCompare) + " != 0x" + Integer.toHexString(Checksum.Get()));
                    int i2 = index3;
                }
            } else {
                SktDebug.DBGSKT_MSG(66, "Packet too small: " + nMaxLength);
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReassembleIfNecessary(SktPacket pPacket, SktScanTypes.TSktScanBoolean pbCorrect) {
        long Result = 0;
        if (pPacket == null || pbCorrect == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pbCorrect.getValue()) {
            pbCorrect.setValue(false);
            if (((char) (pPacket.m_pucData[(pPacket.m_nLength - 2) - 1] & '`')) == '`') {
                pbCorrect.setValue(true);
            }
        }
        return Result;
    }

    protected static boolean IsSocketCommand(char ucType, int wGroupId, char ucFunctionId) {
        if ((ucType == '@' || ucType == 'A') && wGroupId == 251) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long StoreLastSymbologyInfo(SktScanTypes.TSktScanSymbology pSymbology) {
        this.m_LastSymbologyInfo = pSymbology;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long RetrieveLastSymbologyInfo(SktScanTypes.TSktScanSymbology pSymbology) {
        pSymbology.Flags = this.m_LastSymbologyInfo.Flags;
        pSymbology.f14ID = this.m_LastSymbologyInfo.f14ID;
        pSymbology.Status = this.m_LastSymbologyInfo.Status;
        this.m_LastSymbologyInfo = new SktScanTypes.TSktScanSymbology();
        return 0;
    }

    protected static long ConvertFrequency(boolean bFromDevice, char[] pData, int nSize) {
        long Result = 0;
        if (nSize < 10) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int wNbTones = (pData[2] << 8) + pData[3];
            for (int i = 0; i < wNbTones; i++) {
                int wFrequency = (pData[(i * 6) + 4] << 8) + pData[(i * 6) + 5];
                if (!bFromDevice) {
                    switch (wFrequency) {
                        case 0:
                            wFrequency = 0;
                            break;
                        case 1:
                            wFrequency = 1000;
                            break;
                        case 2:
                            wFrequency = 3300;
                            break;
                        case 3:
                            wFrequency = 4000;
                            break;
                        default:
                            Result = -18;
                            break;
                    }
                } else if (wFrequency == 0) {
                    wFrequency = 0;
                } else if (wFrequency > 3300) {
                    wFrequency = 3;
                } else if (wFrequency > 3300 || wFrequency <= 1000) {
                    wFrequency = 1;
                } else {
                    wFrequency = 2;
                }
                pData[(i * 6) + 4] = (char) (wFrequency >> 8);
                pData[(i * 6) + 5] = (char) wFrequency;
            }
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
                    case 0:
                        wSoundAction = 1;
                        break;
                    case 1:
                        wSoundAction = 0;
                        break;
                    case 2:
                        wSoundAction = 3;
                        break;
                    case 3:
                        wSoundAction = 2;
                        break;
                    default:
                        Result = -15;
                        break;
                }
            } else {
                switch (wSoundAction) {
                    case 0:
                        wSoundAction = 1;
                        break;
                    case 1:
                        wSoundAction = 0;
                        break;
                    case 2:
                        wSoundAction = 3;
                        break;
                    case 3:
                        wSoundAction = 2;
                        break;
                    default:
                        Result = -15;
                        break;
                }
            }
            pData[0] = (char) (wSoundAction >> 8);
            pData[1] = (char) wSoundAction;
        }
        return Result;
    }

    protected static long ConvertTriggerLockTimer(boolean bFromDevice, char[] pData, int nSize) {
        int wTriggerLockTimer;
        long Result = 0;
        if (nSize < 8) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int wTriggerLockTimer2 = (pData[2] << 8) + pData[3];
            if (!bFromDevice) {
                wTriggerLockTimer = (wTriggerLockTimer2 * 250) / 4;
            } else {
                wTriggerLockTimer = (wTriggerLockTimer2 * 4) / 250;
            }
            pData[2] = (char) (wTriggerLockTimer >> 8);
            pData[3] = (char) wTriggerLockTimer;
        }
        return Result;
    }

    protected static long ExtractParameter(SktTranslator.TSktTranslatorData pData, SktBtIscpProtocol ppThis, SktBuffer[] ppBuffer, TSktScanObject[] ppScanObj, int nMinimumSize) {
        if (pData == null || ppThis == null || ppBuffer == null || ppScanObj == null) {
            return -18;
        }
        SktBtIscpProtocol ppThis2 = (SktBtIscpProtocol) pData.pThis;
        ppBuffer[0] = (SktBuffer) pData.pDataIn;
        ppScanObj[0] = (TSktScanObject) pData.pDataOut;
        if (ppThis2 == null || ppBuffer == null || ppScanObj == null) {
            return -18;
        }
        if (nMinimumSize <= 0 || ppBuffer[0].m_nLength >= nMinimumSize) {
            return 0;
        }
        return -18;
    }

    protected static long ConvertBatteryLevel(int wPowerStatus) {
        return 0 | ((long) SktScan.helper.SKTBATTERY_SETCURLEVEL(wPowerStatus)) | ((long) SktScan.helper.SKTBATTERY_SETMAXLEVEL(100)) | ((long) SktScan.helper.SKTBATTERY_SETMINLEVEL(0));
    }

    protected static long ConvertPowerState(int wPowerStatus) {
        long ulResult = 0;
        if ((wPowerStatus & 2) == 2) {
            ulResult = (long) SktScan.helper.SKTPOWER_SETSTATE(4);
        }
        if ((wPowerStatus & 4) == 4) {
            ulResult |= (long) SktScan.helper.SKTPOWER_SETSTATE(2);
        }
        if (ulResult == 0) {
            return (long) SktScan.helper.SKTPOWER_SETSTATE(1);
        }
        return ulResult;
    }

    public static class TranslateNotificationsToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r20) {
            /*
                r19 = this;
                r14 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r17.<init>()
                r10 = 0
                r11 = 0
                r4 = 1
                char[][] r12 = new char[r4][]
                r16 = 0
                r18 = 0
                if (r20 != 0) goto L_0x00e1
                r14 = -18
            L_0x0015:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0095
                r0 = r17
                long r4 = r0.Ulong
                r6 = 1
                long r4 = r4 & r6
                r6 = 1
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x002a
                r18 = r18 | 1
            L_0x002a:
                r0 = r17
                long r4 = r0.Ulong
                r6 = 2
                long r4 = r4 & r6
                r6 = 2
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0039
                r18 = r18 | 2
            L_0x0039:
                r0 = r17
                long r4 = r0.Ulong
                r6 = 4
                long r4 = r4 & r6
                r6 = 4
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0048
                r18 = r18 | 4
            L_0x0048:
                r0 = r17
                long r4 = r0.Ulong
                r6 = 8
                long r4 = r4 & r6
                r6 = 8
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0057
                r18 = r18 | 8
            L_0x0057:
                r0 = r17
                long r4 = r0.Ulong
                r6 = 16
                long r4 = r4 & r6
                r6 = 16
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0066
                r18 = r18 | 16
            L_0x0066:
                r0 = r17
                long r4 = r0.Ulong
                r6 = 32
                long r4 = r4 & r6
                r6 = 32
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0075
                r18 = r18 | 32
            L_0x0075:
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                r2[r4] = r18
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r18 = r2[r4]
                r4 = 2
                char[] r10 = new char[r4]
                r4 = 0
                int r5 = r18 >> 8
                r5 = r5 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 1
                r0 = r18
                r5 = r0 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                r11 = 2
            L_0x0095:
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x00c9
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r8 = r0.f16To
                int r8 = r8.wGroupId
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r9 = r0.f16To
                char r9 = r9.ucFunctionId
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,pPropertyData,nPropertySize,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x00c9:
                int r16 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x00e0
                r4 = 0
                r4 = r12[r4]
                r0 = r20
                r0.pDataOut = r4
                r0 = r16
                r1 = r20
                r1.nDataOutSize = r0
            L_0x00e0:
                return r14
            L_0x00e1:
                r0 = r20
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r20
                java.lang.Object r0 = r0.pDataIn
                r17 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r17
                if (r3 == 0) goto L_0x00f3
                if (r17 != 0) goto L_0x0015
            L_0x00f3:
                r14 = -18
                goto L_0x0015
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateNotificationsToBtIscpPacket.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r23) {
            /*
                r22 = this;
                r16 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r19 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r19.<init>()
                r4 = 1
                char[][] r0 = new char[r4][]
                r20 = r0
                r11 = 0
                r4 = 1
                char[][] r12 = new char[r4][]
                r18 = 0
                r21 = 0
                r14 = 0
                if (r23 != 0) goto L_0x00c5
                r16 = -18
            L_0x001b:
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r16)
                if (r4 == 0) goto L_0x0035
                r0 = r19
                r1 = r20
                long r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TransformPropertyToDataPointer(r0, r1, r13)
                java.lang.String r6 = "TransformPropertyToDataPointer(pProperty,pPropertyData,Size)"
                long r16 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x0035:
                int r11 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r16)
                if (r4 == 0) goto L_0x007c
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r4 = r0.f16To
                char r4 = r4.ucFrameType
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r5 = r0.f16To
                int r5 = r5.wGroupId
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r6 = r0.f16To
                char r6 = r6.ucFunctionId
                boolean r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.IsSocketCommand(r4, r5, r6)
                r5 = 1
                if (r4 != r5) goto L_0x0072
                r4 = 0
                r4 = r20[r4]
                if (r4 != 0) goto L_0x00db
                r4 = 0
                r5 = 2
                char[] r5 = new char[r5]
                r20[r4] = r5
                r4 = 0
                r4 = r20[r4]
                r5 = 0
                r6 = 0
                r4[r5] = r6
                r4 = 0
                r4 = r20[r4]
                r5 = 1
                r6 = 0
                r4[r5] = r6
                r11 = 2
            L_0x0072:
                long r4 = (long) r11
                r6 = 65535(0xffff, double:3.23786E-319)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 <= 0) goto L_0x007c
                r16 = -26
            L_0x007c:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r16)
                if (r4 == 0) goto L_0x00ad
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r8 = r0.f16To
                int r8 = r8.wGroupId
                r0 = r23
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r9 = r0.f16To
                char r9 = r9.ucFunctionId
                r10 = 0
                r10 = r20[r10]
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,pPropertyData,nPropertySize,pDleBtIscpFrame,Size)"
                long r16 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x00ad:
                int r18 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r16)
                if (r4 == 0) goto L_0x00c4
                r4 = 0
                r4 = r12[r4]
                r0 = r23
                r0.pDataOut = r4
                r0 = r18
                r1 = r23
                r1.nDataOutSize = r0
            L_0x00c4:
                return r16
            L_0x00c5:
                r0 = r23
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r23
                java.lang.Object r0 = r0.pDataIn
                r19 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r19 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r19
                if (r3 == 0) goto L_0x00d7
                if (r19 != 0) goto L_0x001b
            L_0x00d7:
                r16 = -18
                goto L_0x001b
            L_0x00db:
                r0 = r19
                int r4 = r0.Type
                r5 = 2
                if (r4 != r5) goto L_0x0111
                r4 = 0
                r4 = r20[r4]
                r5 = 0
                char r21 = r4[r5]
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                r2[r4] = r21
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r21 = r2[r4]
                r4 = 0
                r5 = 2
                char[] r5 = new char[r5]
                r20[r4] = r5
                r4 = 0
                r4 = r20[r4]
                r5 = 0
                int r6 = r21 >> 8
                char r6 = (char) r6
                r4[r5] = r6
                r4 = 0
                r4 = r20[r4]
                r5 = 1
                r0 = r21
                r6 = r0 & 255(0xff, float:3.57E-43)
                char r6 = (char) r6
                r4[r5] = r6
                r11 = 2
                goto L_0x0072
            L_0x0111:
                r0 = r19
                int r4 = r0.Type
                r5 = 3
                if (r4 != r5) goto L_0x0072
                r4 = 0
                r4 = r20[r4]
                r5 = 3
                char r4 = r4[r5]
                long r14 = (long) r4
                r4 = 8
                long r14 = r14 << r4
                r4 = 0
                r4 = r20[r4]
                r5 = 2
                char r4 = r4[r5]
                long r4 = (long) r4
                long r14 = r14 + r4
                r4 = 8
                long r14 = r14 << r4
                r4 = 0
                r4 = r20[r4]
                r5 = 1
                char r4 = r4[r5]
                long r4 = (long) r4
                long r14 = r14 + r4
                r4 = 8
                long r14 = r14 << r4
                r4 = 0
                r4 = r20[r4]
                r5 = 0
                char r4 = r4[r5]
                long r4 = (long) r4
                long r14 = r14 + r4
                r4 = 65535(0xffff, double:3.23786E-319)
                int r4 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
                if (r4 > 0) goto L_0x0171
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                int r5 = (int) r14
                r2[r4] = r5
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r21 = r2[r4]
                r4 = 0
                r5 = 2
                char[] r5 = new char[r5]
                r20[r4] = r5
                r4 = 0
                r4 = r20[r4]
                r5 = 0
                int r6 = r21 >> 8
                char r6 = (char) r6
                r4[r5] = r6
                r4 = 0
                r4 = r20[r4]
                r5 = 1
                r0 = r21
                r6 = r0 & 255(0xff, float:3.57E-43)
                char r6 = (char) r6
                r4[r5] = r6
                r11 = 2
                goto L_0x0072
            L_0x0171:
                r16 = -41
                goto L_0x0072
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateToBtIscpPacket.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateVersionToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBtIscpProtocol pThis = null;
            int wVersionOption = 0;
            int nPropertySize = 0;
            char[][] pDleBtIscpFrame = new char[1][];
            if (pData == null) {
                Result = -18;
            } else {
                pThis = (SktBtIscpProtocol) pData.pThis;
                if (pThis == null) {
                    Result = -18;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pData.From.PropId == 65538) {
                    wVersionOption = 3;
                }
                int[] Value = {wVersionOption};
                SktProtocolInterface.MarshallWordToPrimitive(Value);
                wVersionOption = Value[0];
                nPropertySize = 2;
                if (((long) 2) > SktUtilities.kMaxWord) {
                    Result = -26;
                }
            }
            char[] VersionOption = {(char) ((65280 & wVersionOption) >> 8), (char) (wVersionOption & 255)};
            SktScanTypes.TSktScanInteger Size = new SktScanTypes.TSktScanInteger(0);
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pThis.FormatBtIscpPacket(pData.From.PropId, pData.From.bGetOperation, pData.f16To.ucFrameType, pData.f16To.wGroupId, pData.f16To.ucFunctionId, VersionOption, nPropertySize, pDleBtIscpFrame, Size), "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,VersionOption,nPropertySize,pDleBtIscpFrame,Size)");
            }
            int nDleBtIscpFrameSize = Size.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pData.pDataOut = pDleBtIscpFrame[0];
                pData.nDataOutSize = nDleBtIscpFrameSize;
            }
            return Result;
        }
    }

    public static class TranslateDeletePairingToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r20) {
            /*
                r19 = this;
                r14 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r17.<init>()
                r18 = 0
                r11 = 0
                r4 = 1
                char[][] r12 = new char[r4][]
                r16 = 0
                if (r20 != 0) goto L_0x0099
                r14 = -18
            L_0x0014:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0037
                r0 = r17
                char r0 = r0.Byte
                r18 = r0
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                r2[r4] = r18
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r18 = r2[r4]
                r11 = 2
                long r4 = (long) r11
                r6 = 65535(0xffff, double:3.23786E-319)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 <= 0) goto L_0x0037
                r14 = -26
            L_0x0037:
                r4 = 2
                char[] r10 = new char[r4]
                r4 = 0
                r5 = 65280(0xff00, float:9.1477E-41)
                r5 = r5 & r18
                int r5 = r5 >> 8
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 1
                r0 = r18
                r5 = r0 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0081
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r8 = r0.f16To
                int r8 = r8.wGroupId
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r9 = r0.f16To
                char r9 = r9.ucFunctionId
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,PropertyDeleteMode,nPropertySize,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x0081:
                int r16 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0098
                r4 = 0
                r4 = r12[r4]
                r0 = r20
                r0.pDataOut = r4
                r0 = r16
                r1 = r20
                r1.nDataOutSize = r0
            L_0x0098:
                return r14
            L_0x0099:
                r0 = r20
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r20
                java.lang.Object r0 = r0.pDataIn
                r17 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r17
                if (r3 != 0) goto L_0x0014
                r14 = -18
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateDeletePairingToBtIscpPacket.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateRawToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBtIscpProtocol pThis = null;
            SktScanTypes.TSktScanProperty pProperty = new SktScanTypes.TSktScanProperty();
            char[][] pPropertyData = new char[1][];
            char[][] pDleBtIscpFrame = new char[1][];
            if (pData == null) {
                Result = -18;
            } else {
                pThis = (SktBtIscpProtocol) pData.pThis;
                pProperty = (SktScanTypes.TSktScanProperty) pData.pDataIn;
                if (pThis == null || pProperty == null) {
                    Result = -18;
                }
            }
            SktScanTypes.TSktScanInteger Size = new SktScanTypes.TSktScanInteger(0);
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.TransformPropertyToDataPointer(pProperty, pPropertyData, Size), "TransformPropertyToDataPointer(pProperty,pPropertyData,Size)");
            }
            int nPropertyDataSize = Size.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(pThis.FormatRawBtIscpPacket(pData.From.PropId, pData.From.bGetOperation, pPropertyData[0], nPropertyDataSize, pDleBtIscpFrame, Size), "pThis.FormatRawBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pPropertyData,nPropertyDataSize,pDleBtIscpFrame,Size)");
            }
            int nDleBtIscpFrameSize = Size.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pData.pDataOut = pDleBtIscpFrame[0];
                pData.nDataOutSize = nDleBtIscpFrameSize;
            }
            return Result;
        }
    }

    public static class TranslateTriggerToBtIscpCommand implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r20) {
            /*
                r19 = this;
                r14 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r17.<init>()
                r4 = 1
                char[][] r12 = new char[r4][]
                r16 = 0
                r8 = 0
                r9 = 0
                r18 = 0
                if (r20 != 0) goto L_0x0087
                r14 = -18
            L_0x0015:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0024
                r0 = r17
                char r4 = r0.Byte
                switch(r4) {
                    case 1: goto L_0x009d;
                    case 2: goto L_0x00a4;
                    case 3: goto L_0x00ac;
                    case 4: goto L_0x00b4;
                    default: goto L_0x0022;
                }
            L_0x0022:
                r14 = -15
            L_0x0024:
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                r2[r4] = r18
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r18 = r2[r4]
                r4 = 2
                char[] r10 = new char[r4]
                r4 = 0
                r5 = 65280(0xff00, float:9.1477E-41)
                r5 = r5 & r18
                int r5 = r5 >> 8
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 1
                r0 = r18
                r5 = r0 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x006f
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r20
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r11 = 2
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,(int)ucGroupId,ucFunctionId,ArrValue,1,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x006f:
                int r16 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0086
                r4 = 0
                r4 = r12[r4]
                r0 = r20
                r0.pDataOut = r4
                r0 = r16
                r1 = r20
                r1.nDataOutSize = r0
            L_0x0086:
                return r14
            L_0x0087:
                r0 = r20
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r20
                java.lang.Object r0 = r0.pDataIn
                r17 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r17
                if (r3 == 0) goto L_0x0099
                if (r17 != 0) goto L_0x0015
            L_0x0099:
                r14 = -18
                goto L_0x0015
            L_0x009d:
                r8 = 251(0xfb, float:3.52E-43)
                r9 = 149(0x95, float:2.09E-43)
                r18 = 0
                goto L_0x0024
            L_0x00a4:
                r8 = 251(0xfb, float:3.52E-43)
                r9 = 149(0x95, float:2.09E-43)
                r18 = 1
                goto L_0x0024
            L_0x00ac:
                r8 = 251(0xfb, float:3.52E-43)
                r9 = 148(0x94, float:2.07E-43)
                r18 = 1
                goto L_0x0024
            L_0x00b4:
                r8 = 251(0xfb, float:3.52E-43)
                r9 = 148(0x94, float:2.07E-43)
                r18 = 0
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateTriggerToBtIscpCommand.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateLocalDecodeActionToBtIscpCommand implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktScanTypes.TSktScanProperty pProperty = new SktScanTypes.TSktScanProperty();
            if (pData == null) {
                Result = -18;
            } else {
                SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
                pProperty = (SktScanTypes.TSktScanProperty) pData.pDataIn;
                if (pThis == null || pProperty == null) {
                    Result = -18;
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            if (!pData.From.bGetOperation) {
                if (pProperty.Byte == 0) {
                    pProperty.Byte = 0;
                } else if (pProperty.Byte == 1) {
                    pProperty.Byte = 1;
                } else if (pProperty.Byte == 2) {
                    pProperty.Byte = 2;
                } else if (pProperty.Byte == 4) {
                    pProperty.Byte = 4;
                } else if (pProperty.Byte == 3) {
                    pProperty.Byte = 3;
                } else if (pProperty.Byte == 7) {
                    pProperty.Byte = 7;
                } else if (pProperty.Byte == 5) {
                    pProperty.Byte = 5;
                } else if (pProperty.Byte == 6) {
                    pProperty.Byte = 6;
                } else {
                    Result = -15;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                return SktDebug.DBGSKT_EVAL(new TranslateToBtIscpPacket().SktTranslatorFunction(pData), "(new TranslateToBtIscpPacket()).SktTranslatorFunction(pData)");
            }
            return Result;
        }
    }

    public static class TranslateDataConfirmationToBtIscpCommand implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r21) {
            /*
                r20 = this;
                r14 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r18 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r18.<init>()
                r4 = 1
                char[][] r12 = new char[r4][]
                r16 = 0
                r4 = 1
                int[] r0 = new int[r4]
                r19 = r0
                r4 = 0
                r5 = 0
                r19[r4] = r5
                r17 = 0
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktLocalDecodeAction[] r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.LocalDecodeActionTranslationTable
                int r2 = r4.length
                if (r21 != 0) goto L_0x00b5
                r14 = -18
            L_0x001f:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0053
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                boolean r4 = r4.bGetOperation
                if (r4 != 0) goto L_0x0053
                r17 = 0
            L_0x002f:
                r0 = r17
                if (r0 >= r2) goto L_0x004d
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktLocalDecodeAction[] r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.LocalDecodeActionTranslationTable
                r4 = r4[r17]
                long r4 = r4.ulScanAPILocalDecodeAction
                r0 = r18
                long r6 = r0.Ulong
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00c9
                r4 = 0
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktLocalDecodeAction[] r5 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.LocalDecodeActionTranslationTable
                r5 = r5[r17]
                int r5 = r5.wBtIscpLocalDecodeAction
                r19[r4] = r5
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r19)
            L_0x004d:
                r0 = r17
                if (r0 < r2) goto L_0x0053
                r14 = -18
            L_0x0053:
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                r4 = 2
                char[] r10 = new char[r4]
                r4 = 0
                r5 = 0
                r5 = r19[r5]
                int r5 = r5 >> 8
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 1
                r5 = 0
                r5 = r19[r5]
                r5 = r5 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x009d
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r8 = r0.f16To
                int r8 = r8.wGroupId
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r9 = r0.f16To
                char r9 = r9.ucFunctionId
                r11 = 2
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,pRawData,sizeofUshort,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x009d:
                int r16 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x00b4
                r4 = 0
                r4 = r12[r4]
                r0 = r21
                r0.pDataOut = r4
                r0 = r16
                r1 = r21
                r1.nDataOutSize = r0
            L_0x00b4:
                return r14
            L_0x00b5:
                r0 = r21
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r21
                java.lang.Object r0 = r0.pDataIn
                r18 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r18 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r18
                if (r3 != 0) goto L_0x001f
                r14 = -18
                goto L_0x001f
            L_0x00c9:
                int r17 = r17 + 1
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateDataConfirmationToBtIscpCommand.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateSymbologyToBtIscpSymbology implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r22) {
            /*
                r21 = this;
                r14 = 0
                r2 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r19 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r19.<init>()
                r18 = 0
                r20 = 0
                r10 = 0
                r11 = 0
                r4 = 1
                char[][] r12 = new char[r4][]
                r16 = 0
                if (r22 != 0) goto L_0x00d8
                r14 = -18
            L_0x0018:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0027
                r0 = r19
                int r4 = r0.Type
                r5 = 7
                if (r4 == r5) goto L_0x0027
                r14 = -18
            L_0x0027:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x005b
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktBtIscpSymbologyTranslator[] r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.SymbologyTranslator
                int r0 = r4.length
                r17 = r0
                r0 = r19
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanSymbology r4 = r0.Symbology
                int r0 = r4.f14ID
                r18 = r0
            L_0x003a:
                r0 = r18
                r1 = r17
                if (r0 >= r1) goto L_0x0057
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktBtIscpSymbologyTranslator[] r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.SymbologyTranslator
                r4 = r4[r18]
                int r4 = r4.SktSymbologyID
                r0 = r19
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanSymbology r5 = r0.Symbology
                int r5 = r5.f14ID
                if (r4 != r5) goto L_0x00ee
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktBtIscpSymbologyTranslator[] r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.SymbologyTranslator
                r4 = r4[r18]
                char r4 = r4.ucGroupId
                if (r4 == 0) goto L_0x0057
                r2 = 1
            L_0x0057:
                if (r2 != 0) goto L_0x005b
                r14 = -15
            L_0x005b:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0085
                r0 = r22
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                boolean r4 = r4.bGetOperation
                if (r4 != 0) goto L_0x0085
                r0 = r19
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanSymbology r4 = r0.Symbology
                int r4 = r4.Status
                r5 = 1
                if (r4 != r5) goto L_0x0074
                r20 = 1
            L_0x0074:
                r4 = 1
                char[] r10 = new char[r4]
                r4 = 0
                r10[r4] = r20
                r11 = 1
                long r4 = (long) r11
                r6 = 65535(0xffff, double:3.23786E-319)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 <= 0) goto L_0x0085
                r14 = -26
            L_0x0085:
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x00b9
                r0 = r22
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r22
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r22
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktBtIscpSymbologyTranslator[] r8 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.SymbologyTranslator
                r8 = r8[r18]
                char r8 = r8.ucGroupId
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol$TSktBtIscpSymbologyTranslator[] r9 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.SymbologyTranslator
                r9 = r9[r18]
                char r9 = r9.ucFunctionId
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,SymbologyTranslator[nSymbologyIndex].ucGroupId,SymbologyTranslator[nSymbologyIndex].ucFunctionId,pucFrameData,nFrameDataSize,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x00b9:
                int r16 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x00d7
                r0 = r19
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanSymbology r4 = r0.Symbology
                r3.StoreLastSymbologyInfo(r4)
                r4 = 0
                r4 = r12[r4]
                r0 = r22
                r0.pDataOut = r4
                r0 = r16
                r1 = r22
                r1.nDataOutSize = r0
            L_0x00d7:
                return r14
            L_0x00d8:
                r0 = r22
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r22
                java.lang.Object r0 = r0.pDataIn
                r19 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r19 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r19
                if (r3 == 0) goto L_0x00ea
                if (r19 != 0) goto L_0x0018
            L_0x00ea:
                r14 = -18
                goto L_0x0018
            L_0x00ee:
                int r18 = r18 + 1
                goto L_0x003a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateSymbologyToBtIscpSymbology.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateSoundOrRumbleConfigToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r19) {
            /*
                r18 = this;
                r14 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r17.<init>()
                r10 = 0
                r11 = 0
                r4 = 1
                char[][] r12 = new char[r4][]
                r16 = 0
                if (r19 != 0) goto L_0x0076
                r14 = -18
            L_0x0013:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0029
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                boolean r4 = r4.bGetOperation
                r5 = 1
                if (r4 != r5) goto L_0x00c3
                r4 = 2
                char[] r10 = new char[r4]
                if (r10 != 0) goto L_0x008b
                r14 = -2
            L_0x0029:
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x005d
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r8 = r0.f16To
                int r8 = r8.wGroupId
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r9 = r0.f16To
                char r9 = r9.ucFunctionId
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,pwFrameData,nFrameDataSize,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x005d:
                int r16 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0074
                r4 = 0
                r4 = r12[r4]
                r0 = r19
                r0.pDataOut = r4
                r0 = r16
                r1 = r19
                r1.nDataOutSize = r0
            L_0x0074:
                r10 = 0
                return r14
            L_0x0076:
                r0 = r19
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r19
                java.lang.Object r0 = r0.pDataIn
                r17 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r17 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r17
                if (r3 == 0) goto L_0x0088
                if (r17 != 0) goto L_0x0013
            L_0x0088:
                r14 = -18
                goto L_0x0013
            L_0x008b:
                r11 = 2
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                r0 = r17
                char r5 = r0.Byte
                r2[r4] = r5
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r5 = 0
                r5 = r2[r5]
                r6 = 65280(0xff00, float:9.1477E-41)
                r5 = r5 & r6
                int r5 = r5 >> 8
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 1
                r5 = 0
                r5 = r2[r5]
                r5 = r5 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0029
                r4 = 0
                int r5 = r10.length
                long r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.ConvertSoundAction(r4, r10, r5)
                java.lang.String r6 = "ConvertSoundAction(false,pwFrameData,pwFrameData.length)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
                goto L_0x0029
            L_0x00c3:
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r4 = r0.Array
                int r4 = r4.Size
                char[] r10 = new char[r4]
                if (r10 != 0) goto L_0x00d1
                r14 = -2
                goto L_0x0029
            L_0x00d1:
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r4 = r0.Array
                int r11 = r4.Size
                long r4 = (long) r11
                r6 = 65535(0xffff, double:3.23786E-319)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 <= 0) goto L_0x00e3
                r14 = -26
                goto L_0x0029
            L_0x00e3:
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r6 = 2359559(0x240107, double:1.165777E-317)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x010d
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x010d
                r4 = 0
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r5 = r0.Array
                char[] r5 = r5.pData
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r6 = r0.Array
                int r6 = r6.Size
                long r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.ConvertFrequency(r4, r5, r6)
                java.lang.String r6 = "ConvertFrequency(false,pProperty.Array.pData,pProperty.Array.Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x010d:
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r6 = 2359559(0x240107, double:1.165777E-317)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 == 0) goto L_0x0127
                r0 = r19
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r6 = 2359567(0x24010f, double:1.165781E-317)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0144
            L_0x0127:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0144
                r4 = 0
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r5 = r0.Array
                char[] r5 = r5.pData
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r6 = r0.Array
                int r6 = r6.Size
                long r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.ConvertSoundAction(r4, r5, r6)
                java.lang.String r6 = "ConvertSoundAction(false,pProperty.Array.pData,pProperty.Array.Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x0144:
                r0 = r17
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r4 = r0.Array
                char[] r4 = r4.pData
                char[] r10 = com.SocketMobile.ScanAPICore.arrays.copy(r4)
                goto L_0x0029
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateSoundOrRumbleConfigToBtIscpPacket.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateTimersToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator.TSktTranslatorData r21) {
            /*
                r20 = this;
                r14 = 0
                r3 = 0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r18 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty
                r18.<init>()
                r10 = 0
                r11 = 0
                r4 = 1
                char[][] r12 = new char[r4][]
                r17 = 0
                r16 = 0
                if (r21 != 0) goto L_0x007e
                r14 = -18
            L_0x0015:
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x002c
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                boolean r4 = r4.bGetOperation
                r5 = 1
                if (r4 != r5) goto L_0x00d2
                r4 = 8
                char[] r10 = new char[r4]
                if (r10 != 0) goto L_0x0093
                r14 = -2
            L_0x002c:
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger r13 = new com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanInteger
                r4 = 0
                r13.<init>(r4)
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0060
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r4 = r0.From
                long r4 = r4.PropId
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorFrom r6 = r0.From
                boolean r6 = r6.bGetOperation
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r7 = r0.f16To
                char r7 = r7.ucFrameType
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r8 = r0.f16To
                int r8 = r8.wGroupId
                r0 = r21
                com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorTo r9 = r0.f16To
                char r9 = r9.ucFunctionId
                long r4 = r3.FormatBtIscpPacket(r4, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r6 = "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,pwFrameData,nFrameDataSize,pDleBtIscpFrame,Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
            L_0x0060:
                int r17 = r13.getValue()
                boolean r4 = com.SocketMobile.ScanAPI.SktScanErrors.SKTSUCCESS(r14)
                if (r4 == 0) goto L_0x0077
                r4 = 0
                r4 = r12[r4]
                r0 = r21
                r0.pDataOut = r4
                r0 = r17
                r1 = r21
                r1.nDataOutSize = r0
            L_0x0077:
                r4 = 1
                r0 = r16
                if (r0 != r4) goto L_0x007d
                r10 = 0
            L_0x007d:
                return r14
            L_0x007e:
                r0 = r21
                java.lang.Object r3 = r0.pThis
                com.SocketMobile.ScanAPICore.SktBtIscpProtocol r3 = (com.SocketMobile.ScanAPICore.SktBtIscpProtocol) r3
                r0 = r21
                java.lang.Object r0 = r0.pDataIn
                r18 = r0
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanProperty r18 = (com.SocketMobile.ScanAPICore.SktScanTypes.TSktScanProperty) r18
                if (r3 == 0) goto L_0x0090
                if (r18 != 0) goto L_0x0015
            L_0x0090:
                r14 = -18
                goto L_0x0015
            L_0x0093:
                r11 = 8
                r16 = 1
                r19 = 7
                r4 = 1
                int[] r2 = new int[r4]
                r4 = 0
                r2[r4] = r19
                com.SocketMobile.ScanAPICore.SktProtocolInterface.MarshallWordToPrimitive(r2)
                r4 = 0
                r5 = 0
                r5 = r2[r5]
                r6 = 65280(0xff00, float:9.1477E-41)
                r5 = r5 & r6
                int r5 = r5 >> 8
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 1
                r5 = 0
                r5 = r2[r5]
                r5 = r5 & 255(0xff, float:3.57E-43)
                char r5 = (char) r5
                r10[r4] = r5
                r4 = 2
                r5 = 0
                r10[r4] = r5
                r4 = 3
                r5 = 0
                r10[r4] = r5
                r4 = 4
                r5 = 0
                r10[r4] = r5
                r4 = 5
                r5 = 0
                r10[r4] = r5
                r4 = 6
                r5 = 0
                r10[r4] = r5
                r4 = 7
                r5 = 0
                r10[r4] = r5
                goto L_0x002c
            L_0x00d2:
                r4 = 8
                char[] r10 = new char[r4]
                if (r10 != 0) goto L_0x00dc
                r14 = -2
                goto L_0x002c
            L_0x00dc:
                r11 = 8
                r16 = 1
                r4 = 0
                r0 = r18
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r5 = r0.Array
                char[] r5 = r5.pData
                r0 = r18
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r6 = r0.Array
                int r6 = r6.Size
                long r4 = com.SocketMobile.ScanAPICore.SktBtIscpProtocol.ConvertTriggerLockTimer(r4, r5, r6)
                java.lang.String r6 = "ConvertTriggerLockTimer(false,pProperty.Array.pData,pProperty.Array.Size)"
                long r14 = com.SocketMobile.ScanAPICore.SktDebug.DBGSKT_EVAL(r4, r6)
                r0 = r18
                com.SocketMobile.ScanAPICore.SktScanTypes$TSktScanArray r4 = r0.Array
                char[] r4 = r4.pData
                char[] r10 = com.SocketMobile.ScanAPICore.arrays.copy(r4)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.SocketMobile.ScanAPICore.SktBtIscpProtocol.TranslateTimersToBtIscpPacket.SktTranslatorFunction(com.SocketMobile.ScanAPICore.SktTranslator$TSktTranslatorData):long");
        }
    }

    public static class TranslateLocalAcknowledgmentToBtIscpPacket implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            int[] wTriggerMode = {0};
            SktBtIscpProtocol pThis = null;
            SktScanTypes.TSktScanProperty pProperty = null;
            char[][] pDleBtIscpFrame = new char[1][];
            SktScanTypes.TSktScanInteger nDleBtIscpFrameSize = new SktScanTypes.TSktScanInteger(0);
            if (pData == null) {
                Result = -18;
            } else {
                pThis = (SktBtIscpProtocol) pData.pThis;
                pProperty = (SktScanTypes.TSktScanProperty) pData.pDataIn;
                if (pThis == null || pProperty == null) {
                    Result = -18;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result) && !pData.From.bGetOperation) {
                switch (pProperty.getByte()) {
                    case 0:
                        wTriggerMode[0] = 1;
                        break;
                    case 1:
                        wTriggerMode[0] = 0;
                        break;
                    default:
                        Result = -18;
                        break;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    SktProtocolInterface.MarshallWordToPrimitive(wTriggerMode);
                }
            }
            long Result2 = SktDebug.DBGSKT_EVAL(pThis.FormatBtIscpPacket(pData.From.PropId, pData.From.bGetOperation, pData.f16To.ucFrameType, pData.f16To.wGroupId, pData.f16To.ucFunctionId, new char[]{(char) (wTriggerMode[0] >> 8), (char) (wTriggerMode[0] & 255)}, 2, pDleBtIscpFrame, nDleBtIscpFrameSize), "pThis.FormatBtIscpPacket(pData.From.PropId,pData.From.bGetOperation,pData.To.ucFrameType,pData.To.wGroupId,pData.To.ucFunctionId,pFrameData,(short)nFrameDataSize,pDleBtIscpFrame,nDleBtIscpFrameSize)");
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                pData.pDataOut = pDleBtIscpFrame[0];
                pData.nDataOutSize = nDleBtIscpFrameSize.getValue();
            }
            return Result2;
        }
    }

    public static class FillScanObjectWithUnexpectedCommand implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            return -39;
        }
    }

    public static class FillScanObjectPropertySymbologyFromFunction implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            boolean bFound = false;
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 6), "ExtractParameter(pData,pThis,pBuffer,pScanObj,6)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.f13ID = (int) pData.From.PropId;
            pScanObj[0].Property.Type = 7;
            pScanObj[0].Property.Symbology.Flags = 1;
            pScanObj[0].Property.Symbology.Status = pBuffer[0].m_pucData[6];
            int nSize = SktBtIscpProtocol.SymbologyTranslator.length;
            char ucGroup = pBuffer[0].m_pucData[4];
            char ucFunction = pBuffer[0].m_pucData[5];
            int nSymbologyIndex = 0;
            while (true) {
                if (nSymbologyIndex < nSize) {
                    if (SktBtIscpProtocol.SymbologyTranslator[nSymbologyIndex].ucGroupId == ucGroup && SktBtIscpProtocol.SymbologyTranslator[nSymbologyIndex].ucFunctionId == ucFunction) {
                        pScanObj[0].Property.Symbology.f14ID = SktBtIscpProtocol.SymbologyTranslator[nSymbologyIndex].SktSymbologyID;
                        bFound = true;
                        break;
                    }
                    nSymbologyIndex++;
                } else {
                    break;
                }
            }
            if (!bFound) {
                return -39;
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyLocalDecodeActionFromFunction implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 6), "ExtractParameter(pData,pThis,pBuffer,pScanObj,6)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdLocalDecodeActionDevice;
                pScanObj[0].Property.Type = 2;
                switch ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7]) {
                    case 0:
                        pScanObj[0].Property.Byte = 0;
                        break;
                    case 1:
                        pScanObj[0].Property.Byte = 1;
                        break;
                    case 2:
                        pScanObj[0].Property.Byte = 2;
                        break;
                    case 3:
                        pScanObj[0].Property.Byte = 3;
                        break;
                    case 4:
                        pScanObj[0].Property.Byte = 4;
                        break;
                    case 5:
                        pScanObj[0].Property.Byte = 5;
                        break;
                    case 6:
                        pScanObj[0].Property.Byte = 6;
                        break;
                    case 7:
                        pScanObj[0].Property.Byte = 7;
                        break;
                    default:
                        pScanObj[0].Msg.Result = -18;
                        break;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectWithCapabilities implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 6), "ExtractParameter(pData,pThis,pBuffer,pScanObj,6)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.Type = 3;
            int wSize = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
            if (wSize == 2) {
                int wCapabilityType = (pBuffer[0].m_pucData[8] << 8) + pBuffer[0].m_pucData[9];
                switch (wCapabilityType) {
                    case 1:
                        pScanObj[0].Property.Ulong = 1;
                        return Result;
                    case 2:
                        pScanObj[0].Property.Ulong = 1;
                        return Result;
                    default:
                        SktDebug.DBGSKT_MSG(4, "Capability is not 1 or 2 as expected:" + wCapabilityType);
                        return -18;
                }
            } else {
                SktDebug.DBGSKT_MSG(4, "Size is not 2 as expected:" + wSize);
                return -18;
            }
        }
    }

    public static class FillScanObjectWithLocalAcknowlegmentMode implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 6), "ExtractParameter(pData,pThis,pBuffer,pScanObj,6)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 2;
                switch ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7]) {
                    case 0:
                        pScanObj[0].Property.Byte = 1;
                        break;
                    case 1:
                        pScanObj[0].Property.Byte = 0;
                        break;
                    default:
                        pScanObj[0].Msg.Result = -18;
                        break;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromFunction implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 6), "ExtractParameter(pData,pThis,pBuffer,pScanObj,6)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            pScanObj[0].Property.f13ID = (int) pData.From.PropId;
            switch (pThis.GetParamType(pBuffer[0].m_pucData[5])) {
                case 1:
                    pScanObj[0].Property.Type = 0;
                    return Result;
                case 2:
                    pScanObj[0].Property.Type = 2;
                    pScanObj[0].Property.Byte = pBuffer[0].m_pucData[6];
                    return Result;
                case 3:
                    pScanObj[0].Property.Type = 3;
                    pScanObj[0].Property.Ulong = (long) pBuffer[0].m_pucData[6];
                    pScanObj[0].Property.Ulong <<= 8;
                    pScanObj[0].Property.Ulong += (long) pBuffer[0].m_pucData[7];
                    return Result;
                case 4:
                    if (pBuffer[0].m_nLength < 8) {
                        return Result;
                    }
                    pScanObj[0].Property.Type = 5;
                    pScanObj[0].Property.String.nLength = pBuffer[0].m_pucData[6];
                    pScanObj[0].Property.String.nLength <<= 8;
                    pScanObj[0].Property.String.nLength += pBuffer[0].m_pucData[7];
                    if (pScanObj[0].Property.String.nLength < 0) {
                        return Result;
                    }
                    if (new char[pScanObj[0].Property.String.nLength] == null) {
                        return -2;
                    }
                    pScanObj[0].Property.String.m_Value = new String(arrays.copy(pBuffer[0].m_pucData, 8, pScanObj[0].Property.String.nLength));
                    return Result;
                default:
                    return -39;
            }
        }
    }

    public static class FillScanObjectWithBarcodeData implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            return 0;
        }
    }

    public static class FillScanObjectWithBarcodeDataEx implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 12), "ExtractParameter(pData,pThis,pBuffer,pScanObj,12)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int wBarcodeLength = (pBuffer[0].m_pucData[12] << 8) + pBuffer[0].m_pucData[11];
            pScanObj[0].Msg.MsgID = 6;
            pScanObj[0].Msg.Event.f12ID = 1;
            pScanObj[0].Msg.Event.Data.Type = 5;
            pScanObj[0].Msg.Event.Data.DecodedData.String.nLength = wBarcodeLength;
            if (wBarcodeLength <= 0) {
                return Result;
            }
            if (new char[(wBarcodeLength + 1)] == null) {
                return -2;
            }
            char[] Value = arrays.copy(pBuffer[0].m_pucData, 17, wBarcodeLength);
            pScanObj[0].Msg.Event.Data.DecodedData.String.m_Value = new String(Value);
            return Result;
        }
    }

    public static class FillScanObjectWithBarcodeDataEx2 implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 12), "ExtractParameter(pData,pThis,pBuffer,pScanObj,12)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int wStc = (pBuffer[0].m_pucData[5] << 8) + pBuffer[0].m_pucData[6];
            int wBarcodeLength = 0 + (pBuffer[0].m_pucData[7] << 8) + pBuffer[0].m_pucData[8] + (pBuffer[0].m_pucData[9] << 8) + pBuffer[0].m_pucData[10] + (pBuffer[0].m_pucData[11] << 8) + pBuffer[0].m_pucData[12] + (pBuffer[0].m_pucData[13] << 8) + pBuffer[0].m_pucData[14];
            pScanObj[0].Msg.MsgID = 6;
            pScanObj[0].Msg.Event.f12ID = 1;
            pScanObj[0].Msg.Event.Data.Type = 5;
            pScanObj[0].Msg.Event.Data.DecodedData.String.nLength = wBarcodeLength;
            pScanObj[0].Msg.Event.Data.DecodedData.SymbologyID = 0;
            if (wBarcodeLength <= 0) {
                return Result;
            }
            if (new char[(wBarcodeLength + 1)] == null) {
                return -2;
            }
            char[] Value = arrays.copy(pBuffer[0].m_pucData, 17, wBarcodeLength);
            pScanObj[0].Msg.Event.Data.DecodedData.String.m_Value = new String(Value);
            for (int i = 0; i < SktBtIscpProtocol.StcTranslator.length; i++) {
                if (SktBtIscpProtocol.StcTranslator[i].wSTCIdentifier == wStc) {
                    pScanObj[0].Msg.Event.Data.DecodedData.SymbologyID = SktBtIscpProtocol.StcTranslator[i].SktSymbologyID;
                    return Result;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectWithBatteryNotification implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int nIndex = 6 + 1;
            int nIndex2 = nIndex + 1;
            if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[nIndex] < 2) {
                return -18;
            }
            pScanObj[0].Msg.MsgID = 6;
            pScanObj[0].Msg.Event.f12ID = (int) pData.From.PropId;
            pScanObj[0].Msg.Event.Data.Type = 2;
            pScanObj[0].Msg.Event.Data.Ulong = 0;
            int nIndex3 = nIndex2 + 1;
            int i = nIndex3 + 1;
            int wNotification = (pBuffer[0].m_pucData[nIndex2] << 8) + pBuffer[0].m_pucData[nIndex3];
            pScanObj[0].Msg.Event.Data.Ulong = SktBtIscpProtocol.ConvertBatteryLevel(wNotification);
            return Result;
        }
    }

    public static class FillScanObjectWithPowerNotification implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int nIndex = 6 + 1;
            int nIndex2 = nIndex + 1;
            if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[nIndex] < 2) {
                return -18;
            }
            pScanObj[0].Msg.MsgID = 6;
            pScanObj[0].Msg.Event.f12ID = (int) pData.From.PropId;
            pScanObj[0].Msg.Event.Data.Type = 2;
            pScanObj[0].Msg.Event.Data.Ulong = 0;
            int nIndex3 = nIndex2 + 1;
            int i = nIndex3 + 1;
            int wNotification = (pBuffer[0].m_pucData[nIndex2] << 8) + pBuffer[0].m_pucData[nIndex3];
            pScanObj[0].Msg.Event.Data.Ulong = SktBtIscpProtocol.ConvertPowerState(wNotification);
            return Result;
        }
    }

    public static class FillScanObjectWithButtonsNotification implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int nIndex = 6 + 1;
            int nIndex2 = nIndex + 1;
            if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[nIndex] < 2) {
                return -18;
            }
            pScanObj[0].Msg.MsgID = 6;
            pScanObj[0].Msg.Event.f12ID = (int) pData.From.PropId;
            pScanObj[0].Msg.Event.Data.Type = 1;
            pScanObj[0].Msg.Event.Data.Byte = 0;
            int nIndex3 = nIndex2 + 1;
            int i = nIndex3 + 1;
            int wNotification = (pBuffer[0].m_pucData[nIndex2] << 8) + pBuffer[0].m_pucData[nIndex3];
            if ((wNotification & 1) == 1) {
                SktScanTypes.TSktEventData tSktEventData = pScanObj[0].Msg.Event.Data;
                tSktEventData.Byte = (char) (tSktEventData.Byte | SktScan.helper.SKTBUTTON_POWERPRESSED(1));
            }
            if ((wNotification & 2) != 2) {
                return Result;
            }
            SktScanTypes.TSktEventData tSktEventData2 = pScanObj[0].Msg.Event.Data;
            tSktEventData2.Byte = (char) (tSktEventData2.Byte | SktScan.helper.SKTBUTTON_MIDDLEPRESSED(1));
            return Result;
        }
    }

    public static class FillScanObjectWithResultResponse implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 3), "ExtractParameter(pData,pThis,pBuffer,pScanObj,3)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            if (pScanObj[0].Property.f13ID != 7798788) {
                char ucRid = pBuffer[0].m_pucData[4];
                switch (ucRid) {
                    case 0:
                        break;
                    case 1:
                        Result = -38;
                        SktDebug.DBGSKT_MSG(66, "Communication Error: Unknown Frame Type");
                        break;
                    case 129:
                        Result = -15;
                        SktDebug.DBGSKT_MSG(66, "Communication Error: Group Unknown");
                        break;
                    case 130:
                        Result = -38;
                        SktDebug.DBGSKT_MSG(66, "Communication Error: Indentifier Unknown");
                        break;
                    case 131:
                        Result = -18;
                        SktDebug.DBGSKT_MSG(66, "Communication Error: Invalid Parameter");
                        break;
                    default:
                        Result = -39;
                        SktDebug.DBGSKT_MSG(66, "Communication Error: Unknown Error Code:0x%" + Integer.toHexString(ucRid));
                        break;
                }
                pScanObj[0].Msg.Result = Result;
                return 0;
            }
            pScanObj[0].Property.Type = 7;
            pThis.RetrieveLastSymbologyInfo(pScanObj[0].Property.Symbology);
            pScanObj[0].Property.Symbology.Status = 2;
            return Result;
        }
    }

    public static class FillScanObjectWithBatteryLevel implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int wPowerStatus = (pBuffer[0].m_pucData[6] << 8) | pBuffer[0].m_pucData[7];
                pScanObj[0].Property.Type = 3;
                pScanObj[0].Property.Ulong = SktBtIscpProtocol.ConvertBatteryLevel(wPowerStatus);
            }
            return Result;
        }
    }

    public static class FillScanObjectWithPowerState implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int wPowerStatus = (pBuffer[0].m_pucData[6] << 8) | pBuffer[0].m_pucData[7];
                pScanObj[0].Property.Type = 3;
                pScanObj[0].Property.Ulong = SktBtIscpProtocol.ConvertPowerState(wPowerStatus);
            }
            return Result;
        }
    }

    public static class FillScanObjectWithDeviceVersion implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int wParamLength = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
                if (wParamLength >= 15) {
                    pScanObj[0].Property.Type = 6;
                    pScanObj[0].Property.Version.wMajor = pBuffer[0].m_pucData[8];
                    pScanObj[0].Property.Version.wMiddle = pBuffer[0].m_pucData[9];
                    pScanObj[0].Property.Version.wMinor = 0;
                    pScanObj[0].Property.Version.dwBuild = pBuffer[0].m_pucData[10];
                    pScanObj[0].Property.Version.dwBuild <<= 8;
                    pScanObj[0].Property.Version.dwBuild += pBuffer[0].m_pucData[11];
                    pScanObj[0].Property.Version.dwBuild <<= 8;
                    pScanObj[0].Property.Version.dwBuild += pBuffer[0].m_pucData[12];
                    pScanObj[0].Property.Version.dwBuild <<= 8;
                    pScanObj[0].Property.Version.dwBuild += pBuffer[0].m_pucData[13];
                    pScanObj[0].Property.Version.wYear = pBuffer[0].m_pucData[14];
                    pScanObj[0].Property.Version.wYear <<= 8;
                    pScanObj[0].Property.Version.wYear += pBuffer[0].m_pucData[15];
                    pScanObj[0].Property.Version.wMonth = pBuffer[0].m_pucData[16];
                    pScanObj[0].Property.Version.wMonth <<= 8;
                    pScanObj[0].Property.Version.wMonth += pBuffer[0].m_pucData[17];
                    pScanObj[0].Property.Version.wDay = pBuffer[0].m_pucData[18];
                    pScanObj[0].Property.Version.wDay <<= 8;
                    pScanObj[0].Property.Version.wDay += pBuffer[0].m_pucData[19];
                    pScanObj[0].Property.Version.wHour = pBuffer[0].m_pucData[20];
                    pScanObj[0].Property.Version.wHour <<= 8;
                    pScanObj[0].Property.Version.wHour += pBuffer[0].m_pucData[21];
                    pScanObj[0].Property.Version.wHour = SktUtilities.DecodeDecimalInHexa(pScanObj[0].Property.Version.wHour);
                    pScanObj[0].Property.Version.wHour /= 60;
                    pScanObj[0].Property.Version.wMinute = pBuffer[0].m_pucData[20];
                    pScanObj[0].Property.Version.wMinute <<= 8;
                    pScanObj[0].Property.Version.wMinute += pBuffer[0].m_pucData[21];
                    pScanObj[0].Property.Version.wMinute = SktUtilities.DecodeDecimalInHexa(pScanObj[0].Property.Version.wMinute);
                    pScanObj[0].Property.Version.wMinute -= pScanObj[0].Property.Version.wHour * 60;
                    pScanObj[0].Property.Version.wHour = SktUtilities.CodeDecimalInHexa(pScanObj[0].Property.Version.wHour);
                    pScanObj[0].Property.Version.wMinute = SktUtilities.CodeDecimalInHexa(pScanObj[0].Property.Version.wMinute);
                } else {
                    if (wParamLength >= SktBtIscpProtocol.ISCP_WRONG_PROTOCOL.length && arrays.equals(pBuffer[0].m_pucData, 8, SktBtIscpProtocol.ISCP_WRONG_PROTOCOL, 0, SktBtIscpProtocol.ISCP_WRONG_PROTOCOL.length)) {
                        Result = -44;
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = -18;
                    }
                }
            }
            if (!SktScanErrors.SKTSUCCESS(Result) || (pScanObj[0].Property.Version.wMajor << 8) + pScanObj[0].Property.Version.wMiddle < SktBtIscpProtocol.kChs7xDeviceMaxVersionSupportedNotIncluded) {
                return Result;
            }
            return -48;
        }
    }

    public static class FillScanObjectWithDeviceType implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            char[] p7xiString = {'7', 'x', 'i'};
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.f13ID = (int) pData.From.PropId;
                pScanObj[0].Property.Type = 3;
                SktDebug.DBGSKT_MSG(1, "Length: " + pBuffer[0].m_nLength);
                if (pBuffer[0].m_nLength <= 8) {
                    SktDebug.DBGSKT_MSG(1, "Length null then this is a 7x");
                    pScanObj[0].Property.Ulong = (long) SktScanDeviceType.kSktScanDeviceTypeScanner7x;
                } else {
                    int size = p7xiString.length;
                    if (size > pBuffer[0].m_nLength - 8) {
                        size = pBuffer.length - 8;
                    }
                    SktDebug.DBGSKT_MSG(1, "Length: " + size + " pBuffer=" + String.valueOf(pBuffer[0].m_pucData, 8, size));
                    if (arrays.equals(pBuffer[0].m_pucData, 8, p7xiString, 0, size)) {
                        pScanObj[0].Property.Ulong = (long) SktScanDeviceType.kSktScanDeviceTypeScanner7xi;
                    } else {
                        pScanObj[0].Property.Ulong = (long) SktScanDeviceType.kSktScanDeviceTypeScanner7x;
                    }
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectWithArray implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,8)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int wParamLength = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = wParamLength;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            pScanObj[0].Property.Array.pData = arrays.copy(pBuffer[0].m_pucData, 8, pScanObj[0].Property.Array.Size);
            if (pScanObj[0].Property.f13ID == 2359559 && SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ConvertFrequency(true, pScanObj[0].Property.Array.pData, pScanObj[0].Property.Array.Size), "ConvertFrequency(true,pScanObj[0].Property.Array.pData,pScanObj[0].Property.Array.Size)");
            }
            if ((pData.From.PropId == 2359559 || pData.From.PropId == 2359567) && SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ConvertSoundAction(true, pScanObj[0].Property.Array.pData, pScanObj[0].Property.Array.Size), "ConvertSoundAction(true,pScanObj[0].Property.Array.pData,pScanObj[0].Property.Array.Size)");
            }
            if (pScanObj[0].Property.f13ID != 262408 || !SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            return SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ConvertTriggerLockTimer(true, pScanObj[0].Property.Array.pData, pScanObj[0].Property.Array.Size), "ConvertTriggerLockTimer(true,pScanObj[0].Property.Array.pData,pScanObj[0].Property.Array.Size)");
        }
    }

    public static class FillScanObjectWithArrayValueToUlong implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,kStringOffset)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int wParamLength = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
                pScanObj[0].Property.Type = 3;
                pScanObj[0].Property.Ulong = 0;
                if (wParamLength > 4) {
                    wParamLength = 4;
                }
                for (short i = 0; i < wParamLength; i = (short) (i + 1)) {
                    pScanObj[0].Property.Ulong <<= 8;
                    pScanObj[0].Property.Ulong += (long) pBuffer[0].m_pucData[i + 8];
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectWithStatisticCounters implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long dwValue;
            int nIndex;
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 7), "ExtractParameter(pData,pThis,pBuffer,pScanObj,kLowLengthOffset)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            int wParamLength = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
            if (wParamLength <= 2) {
                return -18;
            }
            int nIndex2 = 7 + 1;
            int nIndex3 = nIndex2 + 1;
            int nIndex4 = nIndex3 + 1;
            int wCount = (pBuffer[0].m_pucData[nIndex2] << 8) + pBuffer[0].m_pucData[nIndex3];
            if (wParamLength < (wCount * 4) + 2) {
                return -18;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = (wCount * 8) + 2;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            int nPropertyArrayIndex = 0 + 1;
            pScanObj[0].Property.Array.pData[0] = (char) (wCount >> 8);
            pScanObj[0].Property.Array.pData[nPropertyArrayIndex] = (char) wCount;
            short wCounter = 0;
            int nPropertyArrayIndex2 = nPropertyArrayIndex + 1;
            while (wCounter < wCount) {
                int iStatisticID = wCounter + 1;
                if (wCount < SktBtIscpProtocol.StatisticIdentifier.length) {
                    dwValue = SktBtIscpProtocol.StatisticIdentifier[iStatisticID];
                } else {
                    if (iStatisticID >= SktBtIscpProtocol.StatisticIdentifierEx.length) {
                        iStatisticID = 0;
                    }
                    dwValue = SktBtIscpProtocol.StatisticIdentifierEx[iStatisticID];
                }
                int nPropertyArrayIndex3 = nPropertyArrayIndex2 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex2] = (char) ((int) (dwValue >> 24));
                int nPropertyArrayIndex4 = nPropertyArrayIndex3 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex3] = (char) ((int) (dwValue >> 16));
                int nPropertyArrayIndex5 = nPropertyArrayIndex4 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex4] = (char) ((int) (dwValue >> 8));
                int nPropertyArrayIndex6 = nPropertyArrayIndex5 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex5] = (char) ((int) dwValue);
                long dwValue2 = 0;
                int i = 0;
                while (true) {
                    nIndex = nIndex4;
                    if (i >= 4) {
                        break;
                    }
                    nIndex4 = nIndex + 1;
                    dwValue2 = (dwValue2 << 8) + ((long) pBuffer[0].m_pucData[nIndex]);
                    i++;
                }
                int nPropertyArrayIndex7 = nPropertyArrayIndex6 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex6] = (char) ((int) (dwValue2 >> 24));
                int nPropertyArrayIndex8 = nPropertyArrayIndex7 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex7] = (char) ((int) (dwValue2 >> 16));
                int nPropertyArrayIndex9 = nPropertyArrayIndex8 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex8] = (char) ((int) (dwValue2 >> 8));
                nPropertyArrayIndex2 = nPropertyArrayIndex9 + 1;
                pScanObj[0].Property.Array.pData[nPropertyArrayIndex9] = (char) ((int) dwValue2);
                wCounter = (short) (wCounter + 1);
                nIndex4 = nIndex;
            }
            int i2 = nPropertyArrayIndex2;
            return Result;
        }
    }

    public static class FillScanObjectWithWordValueToByte implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,8)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int wWordValue = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
                pScanObj[0].Property.Type = 2;
                pScanObj[0].Property.Byte = (char) wWordValue;
            }
            return Result;
        }
    }

    public static class FillScanObjectWithWordValueToUlong implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,8)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 3;
                pScanObj[0].Property.Ulong = (((long) pBuffer[0].m_pucData[6]) << 8) + ((long) pBuffer[0].m_pucData[7]);
            }
            return Result;
        }
    }

    public static class FillScanObjectWithProfileConfig implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 22), "ExtractParameter(pData,pThis,pBuffer,pScanObj,kProfileConfigSize+kStringOffset)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7] == 14) {
                    pScanObj[0].Property.Type = 4;
                    pScanObj[0].Property.Array.Size = 14;
                    pScanObj[0].Property.Array.pData = new char[14];
                    if (pScanObj[0].Property.Array.pData == null) {
                        Result = -2;
                    }
                } else {
                    Result = -18;
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Array.pData = arrays.copy(pBuffer[0].m_pucData, 8, 14);
            }
            return Result;
        }
    }

    public static class FillScanObjectWithNotifications implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,8)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int nIndex = 6 + 1;
                int nIndex2 = nIndex + 1;
                if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[nIndex] >= 2) {
                    int nIndex3 = nIndex2 + 1;
                    int i = nIndex3 + 1;
                    int wValue = (pBuffer[0].m_pucData[nIndex2] << 8) + pBuffer[0].m_pucData[nIndex3];
                    pScanObj[0].Property.Type = 3;
                    pScanObj[0].Property.Ulong = 0;
                    if ((wValue & 1) == 1) {
                        pScanObj[0].Property.Ulong |= 1;
                    }
                    if ((wValue & 2) == 2) {
                        pScanObj[0].Property.Ulong |= 2;
                    }
                    if ((wValue & 4) == 4) {
                        pScanObj[0].Property.Ulong |= 4;
                    }
                    if ((wValue & 8) == 8) {
                        pScanObj[0].Property.Ulong |= 8;
                    }
                    if ((wValue & 16) == 16) {
                        pScanObj[0].Property.Ulong |= 16;
                    }
                    if ((wValue & 32) == 32) {
                        pScanObj[0].Property.Ulong |= 32;
                    }
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyFromErrorReply implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 0), "ExtractParameter(pData,pThis,pBuffer,pScanObj,0)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                switch (pScanObj[0].Property.f13ID) {
                    case ISktScanProperty.propId.kSktScanPropIdStandConfigDevice:
                        pScanObj[0].Msg.Result = -15;
                        SktDebug.DBGSKT_MSG(66, "Return a Not supported for this property 0x" + Integer.toHexString(pScanObj[0].Property.f13ID));
                        break;
                    case ISktScanProperty.propId.kSktScanPropIdSymbologyDevice:
                        pScanObj[0].Property.Type = 7;
                        pThis.RetrieveLastSymbologyInfo(pScanObj[0].Property.Symbology);
                        pScanObj[0].Property.Symbology.Status = 2;
                        break;
                    default:
                        pScanObj[0].Msg.Result = -18;
                        SktDebug.DBGSKT_MSG(66, "Return an Invalid Parameter for this property 0x" + Integer.toHexString(pScanObj[0].Property.f13ID));
                        break;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectWithDeviceAddress implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,8)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7] < 12) {
                return -41;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = 6;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            int nIndex = 0;
            for (int i = 0; i < 6; i++) {
                int nIndex2 = nIndex + 1;
                char ucByte = (char) (SktBtIscpProtocol.ConvertAsciiToNiddle(pBuffer[0].m_pucData[nIndex + 8]) << 4);
                nIndex = nIndex2 + 1;
                pScanObj[0].Property.Array.pData[i] = (char) (SktBtIscpProtocol.ConvertAsciiToNiddle(pBuffer[0].m_pucData[nIndex2 + 8]) + ucByte);
            }
            return Result;
        }
    }

    public static class FillScanObjectWithSoundConfig implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 8), "ExtractParameter(pData,pThis,pBuffer,pScanObj,8)");
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                return Result;
            }
            if ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7] < 12) {
                return -41;
            }
            pScanObj[0].Property.Type = 4;
            pScanObj[0].Property.Array.Size = 6;
            pScanObj[0].Property.Array.pData = new char[pScanObj[0].Property.Array.Size];
            if (pScanObj[0].Property.Array.pData == null) {
                return -2;
            }
            int nIndex = 0;
            for (int i = 0; i < 6; i++) {
                int nIndex2 = nIndex + 1;
                char ucByte = (char) (SktBtIscpProtocol.ConvertAsciiToNiddle(pBuffer[0].m_pucData[nIndex + 8]) << 4);
                nIndex = nIndex2 + 1;
                pScanObj[0].Property.Array.pData[i] = (char) (SktBtIscpProtocol.ConvertAsciiToNiddle(pBuffer[0].m_pucData[nIndex2 + 8]) + ucByte);
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertySecurityModeFromFunction implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 7), "ExtractParameter(pData,pThis,pBuffer,pScanObj,kLowWordOffset)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 2;
                switch ((pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7]) {
                    case 0:
                        pScanObj[0].Property.Byte = 0;
                        break;
                    case 1:
                        pScanObj[0].Property.Byte = 1;
                        break;
                    case 2:
                        pScanObj[0].Property.Byte = 2;
                        break;
                    default:
                        pScanObj[0].Msg.Result = -18;
                        break;
                }
            }
            return Result;
        }
    }

    public static class FillScanObjectPropertyButtonsStatusFromFunction implements SktTranslator.ISktTranslatorFunction {
        public long SktTranslatorFunction(SktTranslator.TSktTranslatorData pData) {
            long Result = 0;
            SktBuffer[] pBuffer = new SktBuffer[1];
            TSktScanObject[] pScanObj = new TSktScanObject[1];
            SktBtIscpProtocol pThis = (SktBtIscpProtocol) pData.pThis;
            if (SktScanErrors.SKTSUCCESS(0)) {
                Result = SktDebug.DBGSKT_EVAL(SktBtIscpProtocol.ExtractParameter(pData, pThis, pBuffer, pScanObj, 7), "ExtractParameter(pData,pThis,pBuffer,pScanObj,kLowWordOffset)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj[0].Property.Type = 2;
                pScanObj[0].Property.Byte = 0;
                int wButtonsStatus = (pBuffer[0].m_pucData[6] << 8) + pBuffer[0].m_pucData[7];
                if ((wButtonsStatus & 1) == 1) {
                    SktScanTypes.TSktScanProperty tSktScanProperty = pScanObj[0].Property;
                    tSktScanProperty.Byte = (char) (tSktScanProperty.Byte | SktScan.helper.SKTBUTTON_POWERPRESSED(1));
                }
                if ((wButtonsStatus & 2) == 2) {
                    SktScanTypes.TSktScanProperty tSktScanProperty2 = pScanObj[0].Property;
                    tSktScanProperty2.Byte = (char) (tSktScanProperty2.Byte | SktScan.helper.SKTBUTTON_MIDDLEPRESSED(1));
                }
            }
            return Result;
        }
    }

    /* access modifiers changed from: protected */
    public long SaveInitializationResponse(SktScanTypes.TSktScanProperty pProperty) {
        long Result = 0;
        if (pProperty == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && pProperty.f13ID == 4456451 && pProperty.Array.Size > 3 && pProperty.Array.pData[0] == 'S' && pProperty.Array.pData[1] == '0' && pProperty.Array.pData[2] == 128) {
            char wMtu = 0;
            if (pProperty.Array.Size >= 5) {
                wMtu = pProperty.Array.pData[3];
            }
            SetMtu((char) (pProperty.Array.pData[4] + ((char) (wMtu << 8))));
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public void SetMtu(char wMtu) {
        this.m_wMtu = wMtu;
    }

    /* access modifiers changed from: protected */
    public char GetMtu() {
        return this.m_wMtu;
    }

    static boolean Test() {
        return true;
    }
}
