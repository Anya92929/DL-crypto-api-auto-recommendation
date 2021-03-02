package com.SocketMobile.ScanAPICore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.ISktScanSymbology;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPI.SoftScanActivity;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktProtocolInterface;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktSimpleXml;
import java.util.Map;

final class SktSoftScanDeviceObject extends SktDeviceObjectInterface implements SoftScanActivityListener {
    public static SktSoftScanDeviceObject _softscan;
    final String SOFTSCAN_VERSION_DATE = "$Date: 2014-09-04 17:25:01 -0400 (Thu, 04 Sep 2014) $";
    final SymbologyTranslator[] SoftscanStcTranslator = {new SymbologyTranslator((byte) 43, "Upce", "Upc E0"), new SymbologyTranslator(ISktScanSymbology.C0165id.kSktScanSymbologyEan8, "Ean8", "Ean 8"), new SymbologyTranslator((byte) 19, "Ean13", "Ean 13"), new SymbologyTranslator((byte) 38, "QrCode", "QR Code"), new SymbologyTranslator((byte) 15, "Code128", "Code 128"), new SymbologyTranslator((byte) 11, "Code39", "Code 39"), new SymbologyTranslator((byte) 14, "Code93", "Code 93"), new SymbologyTranslator((byte) 16, "Datamatrix", "Data Matrix"), new SymbologyTranslator((byte) 24, "Gs1Databar", "GS1 Databar"), new SymbologyTranslator((byte) 27, "Interleaved", "Interleaved 2 of 5"), new SymbologyTranslator((byte) 7, "Codabar", "Codabar")};
    RLObject _rlObject = new RLObject();
    SktScanAPI _scanApi;
    String kSktApplicationDataPath = SktConfigurationBase.kSktApplicationDataPath;
    String kSktDefaultScanApiXml;
    final String kSktDefaultSoftScannerDecodeAction = "1";
    final String kSktDefaultSoftScannerName = "SoftScanner";
    final int kSktLocalActionBeep = 1;
    final int kSktLocalActionVibrate = 2;
    final String kSktScanAPIConfigFile = "ScanAPI.xml";
    final String kSktSoftscanConfigTag = "ScanAPI/SoftScan";
    final String kSktSoftscanDecodeAction = "DecodeAction";
    final String kSktSoftscanFriendlyName = "FriendlyName";
    final String kSktSoftscanPostamble = "Postamble";
    final String kSktSoftscanPreamble = "Preamble";
    final String kSktSoftscanSymbologyTag = "ScanAPI/SoftScan/Symbologies";
    final String kSymbologyDisabled = "0";
    final String kSymbologyEnabled = "1";
    protected SktConfigXml m_Config = new SktConfigXml();

    class SymbologyTranslator {
        String sDescription;
        String sName;
        byte wSymbologyID;

        public SymbologyTranslator(byte SymbologyID, String Name, String Description) {
            this.wSymbologyID = SymbologyID;
            this.sName = Name;
            this.sDescription = Description;
        }
    }

    class RLObject {
        private boolean doBeep = true;
        private boolean doCodabar = true;
        private boolean doCode128 = true;
        private boolean doCode39 = true;
        private boolean doCode93 = true;
        private boolean doDataMatrix = true;
        private boolean doEan13 = false;
        private boolean doEan8 = true;
        private boolean doITF = true;
        private boolean doQRCode = true;
        private boolean doRSS14 = false;
        private boolean doUpce = true;
        private boolean doVibrate = false;
        Map<String, Object> paranetview = null;

        public RLObject() {
        }

        public void updateSymStatus(byte symid, boolean status) {
            switch (symid) {
                case 7:
                    this.doCodabar = status;
                    return;
                case 11:
                    this.doCode39 = status;
                    return;
                case 14:
                    this.doCode93 = status;
                    return;
                case 15:
                    this.doCode128 = status;
                    return;
                case 16:
                    this.doDataMatrix = status;
                    return;
                case 18:
                    this.doEan8 = status;
                    return;
                case 19:
                    this.doEan13 = status;
                    return;
                case 24:
                    this.doRSS14 = status;
                    return;
                case 27:
                    this.doITF = status;
                    return;
                case 38:
                    this.doQRCode = status;
                    return;
                case 43:
                    this.doUpce = status;
                    return;
                default:
                    return;
            }
        }

        public long launchScanner() {
            long result = 0;
            if (this.paranetview == null) {
                result = -90;
            }
            if (!SktScanErrors.SKTSUCCESS(result)) {
                return result;
            }
            try {
                Context context = (Context) this.paranetview.get(ISktScanProperty.values.softScanContext.kSktScanSoftScanContext);
                if (context.getPackageManager().queryIntentActivities(new Intent(SoftScanActivity.INTENT_ZXING), 0).size() <= 0) {
                    return -27;
                }
                Intent scanIntent = new Intent(context, SoftScanActivity.class);
                scanIntent.putExtra("SCAN_FORMATS", SktSoftScanDeviceObject.this._rlObject.getScanFormatsExtra());
                context.startActivity(scanIntent);
                return result;
            } catch (Exception e) {
                SktDebug.DBGSKT_MSG(20, "Exception starting SoftScan Activity:" + e.getLocalizedMessage() + " " + e.getCause());
                SktDebug.DBGSKT_MSG(20, "Did you pass a context to SoftScan?");
                return -27;
            }
        }

        public long stopScanner() {
            return 0;
        }

        public Bundle buildBundle(Integer LayoutID, Integer ViewFinderID, Integer FlashButtonID) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(SoftScanActivity.DO_UPCE, this.doUpce);
            bundle.putBoolean(SoftScanActivity.DO_EAN8, this.doEan8);
            bundle.putBoolean(SoftScanActivity.DO_EAN13, this.doEan13);
            bundle.putBoolean(SoftScanActivity.DO_QRCODE, this.doQRCode);
            bundle.putBoolean(SoftScanActivity.DO_CODE128, this.doCode128);
            bundle.putBoolean(SoftScanActivity.DO_CODE39, this.doCode39);
            bundle.putBoolean(SoftScanActivity.DO_CODE93, this.doCode93);
            bundle.putBoolean(SoftScanActivity.DO_DATAMATRIX, this.doDataMatrix);
            bundle.putBoolean(SoftScanActivity.DO_RSS14, this.doRSS14);
            bundle.putBoolean(SoftScanActivity.DO_ITF, this.doITF);
            bundle.putBoolean(SoftScanActivity.DO_CODABAR, this.doCodabar);
            bundle.putBoolean(SoftScanActivity.DO_BEEP, this.doBeep);
            bundle.putBoolean(SoftScanActivity.DO_VIBRATE, this.doVibrate);
            if (LayoutID != null) {
                bundle.putInt(SoftScanActivity.DO_LAYOUTID, LayoutID.intValue());
            }
            if (ViewFinderID != null) {
                bundle.putInt(SoftScanActivity.DO_VIEWFINDERID, ViewFinderID.intValue());
            }
            if (FlashButtonID != null) {
                bundle.putInt(SoftScanActivity.DO_FLASHBUTTONID, FlashButtonID.intValue());
            }
            return bundle;
        }

        public String getScanFormatsExtra() {
            StringBuilder csv = new StringBuilder();
            if (this.doUpce) {
                csv.append("UPC_E,");
            }
            if (this.doEan8) {
                csv.append("EAN_8,");
            }
            if (this.doEan13) {
                csv.append("EAN_13,");
            }
            if (this.doQRCode) {
                csv.append("QR_CODE,");
            }
            if (this.doCode128) {
                csv.append("CODE_128,");
            }
            if (this.doCode39) {
                csv.append("CODE_39,");
            }
            if (this.doCode93) {
                csv.append("CODE_93,");
            }
            if (this.doDataMatrix) {
                csv.append("DATA_MATRIX,");
            }
            if (this.doRSS14) {
                csv.append("RSS_14,");
            }
            if (this.doITF) {
                csv.append("ITF,");
            }
            if (this.doCodabar) {
                csv.append("CODABAR,");
            }
            csv.setLength(Math.max(csv.length() - 1, 0));
            return csv.toString();
        }

        public void setParanetView(Object view) {
            this.paranetview = (Map) view;
        }

        public void setBeep(boolean beep) {
            this.doBeep = beep;
        }

        public void setVibrate(boolean vibrate) {
            this.doVibrate = vibrate;
        }
    }

    public SktSoftScanDeviceObject(SktScanAPI scanapi) {
        this._scanApi = scanapi;
        _softscan = this;
        SoftScanActivity.setListener(this);
    }

    public long Initialize(String fileName, long ulDeviceType) {
        String[] guid = new String[1];
        long Result = SktDebug.DBGSKT_EVAL(super.Initialize(fileName, ulDeviceType), "super.Initialize(fileName,ulDeviceType)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktGuid.Create(guid), "SktGuid.Create(guid)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_Guid = guid[0];
        }
        String[] pszAppDataPath = null;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath = new String[1];
            Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktSystem.ReadApplicationDataPath(pszAppDataPath, 2048), "SktSystem.ReadApplicationDataPath(pszAppDataPath,nLength)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath[0] = pszAppDataPath[0] + this.kSktApplicationDataPath;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (this.kSktDefaultScanApiXml == null) {
                this.kSktDefaultScanApiXml = SktConfigurationBase.kSktDefaultScanApiXml;
            }
            Result = SktDebug.DBGSKT_EVAL(this.m_Config.Load(pszAppDataPath[0], "ScanAPI.xml", this.kSktDefaultScanApiXml), "m_Config.Load(pszAppDataPath[0],kSktScanAPIConfigFile,kSktDefaultScanApiXml)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ConfigureScannerWithSettings(), "ConfigureScannerWithSettings()");
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
        long Result = 0;
        if (pScanObj == null || pbImmediateResponse == null || ppResponse == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (pScanObj.Property.f13ID == 7798788) {
            long Result2 = SktDebug.DBGSKT_EVAL(ReadSymbologyStatus(pScanObj.Property.Symbology, ppResponse), "ReadSymbologyStatus(pScanObj.Property.Symbology,ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result2)) {
                return Result2;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result2;
        } else if (pScanObj.Property.f13ID == 327936) {
            long Result3 = SktDebug.DBGSKT_EVAL(ReadSoftScanFriendlyName(ppResponse), "ReadSoftScanFriendlyName(ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result3)) {
                return Result3;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result3;
        } else if (pScanObj.Property.f13ID == 65536) {
            long Result4 = SktDebug.DBGSKT_EVAL(ReadSoftScanVersion(ppResponse), "ReadSoftScanVersion(ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result4)) {
                return Result4;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result4;
        } else if (pScanObj.Property.f13ID == 65538) {
            ppResponse[0] = new TSktScanObject();
            ppResponse[0].Msg.MsgID = 5;
            ppResponse[0].Msg.Result = 0;
            ppResponse[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdDeviceType;
            ppResponse[0].Property.Type = 3;
            ppResponse[0].Property.Ulong = (long) SktScanDeviceType.kSktScanDeviceTypeSoftScan;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result;
        } else if (pScanObj.Property.f13ID == 327687) {
            long Result5 = SktDebug.DBGSKT_EVAL(ReadSoftScanPreamble(ppResponse), "ReadSoftScanPreamble(ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result5)) {
                return Result5;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result5;
        } else if (pScanObj.Property.f13ID == 327688) {
            long Result6 = SktDebug.DBGSKT_EVAL(ReadSoftScanPostamble(ppResponse), "ReadSoftScanPostamble(ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result6)) {
                return Result6;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result6;
        } else if (pScanObj.Property.f13ID == 131340) {
            long Result7 = SktDebug.DBGSKT_EVAL(ReadDecodeAction(ppResponse), "ReadSoftScanDecodeAction(ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result7)) {
                return Result7;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result7;
        } else if (pScanObj.Property.f13ID == 2162697) {
            ppResponse[0] = new TSktScanObject();
            ppResponse[0].Msg.MsgID = 5;
            ppResponse[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdCapabilitiesDevice;
            ppResponse[0].Property.Type = 3;
            switch (pScanObj.Property.Byte) {
                case 1:
                    ppResponse[0].Property.Ulong = 1;
                    break;
                case 2:
                    if (!hasVibrateCapability()) {
                        ppResponse[0].Property.Ulong = 0;
                        break;
                    } else {
                        ppResponse[0].Property.Ulong = 1;
                        break;
                    }
                default:
                    Result = -18;
                    break;
            }
            ppResponse[0].Msg.Result = Result;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return 0;
        } else if (pScanObj.Property.f13ID == 65546) {
            long Result8 = SktDebug.DBGSKT_EVAL(GetSoftScanChangeID(ppResponse), "GetSoftScanChangeID(ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result8)) {
                return Result8;
            }
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result8;
        } else if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        } else {
            ppResponse[0] = new TSktScanObject();
            ppResponse[0].Msg.MsgID = 5;
            ppResponse[0].Msg.Result = -15;
            ppResponse[0].Property.f13ID = pScanObj.Property.f13ID;
            ppResponse[0].Property.Type = pScanObj.Property.Type;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result;
        }
    }

    private boolean hasVibrateCapability() {
        return false;
    }

    public long SetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponse) {
        long Result;
        long Result2 = 0;
        if (pScanObj == null || pbImmediateResponse == null || ppResponse == null) {
            Result2 = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result2)) {
            return Result2;
        }
        if (pScanObj.Property.f13ID == 7798788) {
            long Result3 = SktDebug.DBGSKT_EVAL(WriteSymbologyStatus(pScanObj.Property.Symbology, ppResponse), "WriteSymbologyStatus(pScanObj.Property.Symbology,ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result3)) {
                return Result3;
            }
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result3;
        } else if (pScanObj.Property.f13ID == 327936) {
            long Result4 = SktDebug.DBGSKT_EVAL(WriteSoftScanFriendlyName(pScanObj.Property.String.m_Value, ppResponse), "WriteSoftScanFriendlyName(pScanObj.Property.String.m_Value,ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result4)) {
                return Result4;
            }
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result4;
        } else if (pScanObj.Property.f13ID == 1179653) {
            if (pScanObj.Property.Byte == 1) {
                SktDebug.DBGSKT_MSG(17, "Set SoftScan Trigger Start");
                Result = SktDebug.DBGSKT_EVAL(this._rlObject.launchScanner(), "rlObject.launchScanner()");
            } else if (pScanObj.Property.Byte == 2) {
                SktDebug.DBGSKT_MSG(17, "Set SoftScan Trigger Stop");
                Result = SktDebug.DBGSKT_EVAL(this._rlObject.stopScanner(), "rlObject.stopScanner()");
            } else {
                Result = -15;
            }
            ppResponse[0] = new TSktScanObject();
            ppResponse[0].Msg.MsgID = 4;
            ppResponse[0].Msg.Result = Result;
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.f13ID = pScanObj.Property.f13ID;
            ppResponse[0].Property.Type = 0;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return 0;
        } else if (pScanObj.Property.f13ID == 327687) {
            long Result5 = SktDebug.DBGSKT_EVAL(WriteSoftScanPreamble(pScanObj.Property.String.m_Value, ppResponse), "WriteSoftScanPreamble(pScanObj.Property.String.m_Value, ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result5)) {
                return Result5;
            }
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result5;
        } else if (pScanObj.Property.f13ID == 327688) {
            long Result6 = SktDebug.DBGSKT_EVAL(WriteSoftScanPostamble(pScanObj.Property.String.m_Value, ppResponse), "WriteSoftScanPostamble(pScanObj.Property.String.m_Value, ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result6)) {
                return Result6;
            }
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result6;
        } else if (pScanObj.Property.f13ID == 131340) {
            long Result7 = SktDebug.DBGSKT_EVAL(WriteDecodeAction(pScanObj.Property.getByte(), ppResponse), "WriteDecodeAction(pScanObj.Property.getUlong(), ppResponse)");
            if (!SktScanErrors.SKTSUCCESS(Result7)) {
                return Result7;
            }
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result7;
        } else if (pScanObj.Property.f13ID == 590105) {
            if (pScanObj.Property.object != null) {
                SktDebug.DBGSKT_MSG(17, "Set Overlay View Device");
                this._rlObject.setParanetView(pScanObj.Property.object);
            } else {
                Result2 = -18;
            }
            if (!SktScanErrors.SKTSUCCESS(Result2)) {
                return Result2;
            }
            ppResponse[0] = new TSktScanObject();
            ppResponse[0].Msg.MsgID = 4;
            ppResponse[0].Msg.Result = Result2;
            ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
            ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
            ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
            ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
            ppResponse[0].Property.f13ID = pScanObj.Property.f13ID;
            ppResponse[0].Property.Type = 0;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result2;
        } else {
            ppResponse[0] = new TSktScanObject();
            ppResponse[0].Msg.MsgID = 4;
            ppResponse[0].Msg.Result = -15;
            ppResponse[0].Property.f13ID = pScanObj.Property.f13ID;
            ppResponse[0].Property.Type = pScanObj.Property.Type;
            ppResponse[0].Property.Context = pScanObj.Property.Context;
            pbImmediateResponse.setValue(true);
            return Result2;
        }
    }

    /* access modifiers changed from: protected */
    public long ReadSoftScanVersion(TSktScanObject[] ppScanObj) {
        long Result = 0;
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        int[] pwMajor = new int[1];
        int[] pwMiddle = new int[1];
        int[] pwMinor = new int[1];
        int[] pdwBuild = new int[1];
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0].Msg.MsgID = 5;
            ppScanObj[0].Msg.Result = 0;
            ppScanObj[0].Property.f13ID = 65536;
            ppScanObj[0].Property.Type = 6;
            pwMajor[0] = CodeDecimalInHexa(1);
            pwMiddle[0] = CodeDecimalInHexa(0);
            pwMinor[0] = CodeDecimalInHexa(0);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0].Property.Version.wMajor = pwMajor[0];
            ppScanObj[0].Property.Version.wMiddle = pwMiddle[0];
            ppScanObj[0].Property.Version.wMinor = pwMinor[0];
            ppScanObj[0].Property.Version.dwBuild = pdwBuild[0];
            String Date = new String("$Date: 2014-09-04 17:25:01 -0400 (Thu, 04 Sep 2014) $");
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
                            ppScanObj[0].Property.Version.wYear = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 1:
                            ppScanObj[0].Property.Version.wMonth = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 2:
                            ppScanObj[0].Property.Version.wDay = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 3:
                            ppScanObj[0].Property.Version.wHour = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
                            break;
                        case 4:
                            ppScanObj[0].Property.Version.wMinute = (short) CodeDecimalInHexa(Integer.parseInt(Number.toString()));
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
        }
        return Result;
    }

    private static int CodeDecimalInHexa(int nDecimal) {
        int nDecimalInHexa = 0 + ((nDecimal / 1000) * 4096);
        int nDecimal2 = nDecimal - ((nDecimal / 1000) * 1000);
        int nDecimalInHexa2 = nDecimalInHexa + ((nDecimal2 / 100) * 256);
        int nDecimal3 = nDecimal2 - ((nDecimal2 / 100) * 100);
        return nDecimalInHexa2 + ((nDecimal3 / 10) * 16) + (nDecimal3 - ((nDecimal3 / 10) * 10));
    }

    /* access modifiers changed from: protected */
    public long SaveConfiguration() {
        long Result = 0;
        String[] pszAppDataPath = null;
        if (SktScanErrors.SKTSUCCESS(0)) {
            pszAppDataPath = new String[1];
        }
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktSystem.ReadApplicationDataPath(pszAppDataPath, 2048), "SktSystem.ReadApplicationDataPath(pszAppDataPath,nLength)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath[0] = pszAppDataPath[0] + this.kSktApplicationDataPath;
            this.m_Config.Save(pszAppDataPath[0], "ScanAPI.xml");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReadSymbologyStatus(SktScanTypes.TSktScanSymbology pSymbology, TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        String[] szEnabled = new String[1];
        boolean bFound = false;
        int symbologyindex = 0;
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int nSize = this.SoftscanStcTranslator.length;
            int i = 0;
            while (true) {
                if (i >= nSize) {
                    break;
                } else if (pSymbology.f14ID == this.SoftscanStcTranslator[i].wSymbologyID) {
                    symbologyindex = i;
                    bFound = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!bFound) {
                pSymbology.Status = 2;
            } else {
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = RetrieveSymbologiesTag(pSymbologiesTag);
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = this.m_Config.ReadSubValue(pSymbologiesTag[0], this.SoftscanStcTranslator[symbologyindex].sName, szEnabled, 16);
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        if (szEnabled[0].compareTo("1") == 0) {
                            pSymbology.Status = 1;
                        } else {
                            pSymbology.Status = 0;
                        }
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        Result = -17;
                    }
                }
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0].Msg.MsgID = 5;
            ppScanObj[0].Msg.Result = 0;
            ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdSymbologyDevice;
            ppScanObj[0].Property.Type = 7;
            ppScanObj[0].Property.Symbology.f14ID = pSymbology.f14ID;
            ppScanObj[0].Property.Symbology.Flags = pSymbology.Flags;
            ppScanObj[0].Property.Symbology.Status = pSymbology.Status;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteSymbologyStatus(SktScanTypes.TSktScanSymbology pSymbology, TSktScanObject[] ppScanObj) {
        String pszEnabled;
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        boolean bFound = false;
        int symbologyindex = 0;
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        int nSize = this.SoftscanStcTranslator.length;
        int i = 0;
        while (true) {
            if (i >= nSize) {
                break;
            } else if (pSymbology.f14ID == this.SoftscanStcTranslator[i].wSymbologyID) {
                symbologyindex = i;
                bFound = true;
                break;
            } else {
                i++;
            }
        }
        if (!bFound) {
            Result = -15;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveSymbologiesTag(pSymbologiesTag), "RetrieveSymbologiesTag(pSymbologiesTag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pSymbology.Status == 1) {
                pszEnabled = "1";
                this._rlObject.updateSymStatus(this.SoftscanStcTranslator[symbologyindex].wSymbologyID, true);
            } else {
                pszEnabled = "0";
                this._rlObject.updateSymStatus(this.SoftscanStcTranslator[symbologyindex].wSymbologyID, false);
            }
            Result = SktDebug.DBGSKT_EVAL(this.m_Config.WriteSubValue(pSymbologiesTag[0], this.SoftscanStcTranslator[symbologyindex].sName, pszEnabled, pszEnabled.length()), "m_Config.WriteSubValue(pSymbologiesTag[0],SoftscanStcTranslator[symbologyindex].sName,pszEnabled,pszEnabled.length())");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(), "SaveConfiguration()");
            }
        }
        ppScanObj[0].Msg.MsgID = 4;
        ppScanObj[0].Msg.Result = Result;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdSymbologyDevice;
        ppScanObj[0].Property.Type = 0;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long ReadSoftScanPreamble(TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        String[] pszPreamble = new String[1];
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag), "m_Config.Seek(null,kSktSoftscanConfigTag,true, pSoftScanConfigTag)");
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_Config.ReadSubValue(pSoftScanConfigTag[0], "Preamble", pszPreamble, 1024), "m_Config.ReadSubValue(pSoftScanConfigTag[0],kSktSoftscanPreamble,pszPreamble,nLength)");
            if (Result2 == -17) {
                pszPreamble[0] = "";
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SktDebug.DBGSKT_EVAL(InterpreteBackSlashCharacter(pszPreamble), "InterpreteBackSlashCharacter(pszPreamble)");
            }
        }
        ppScanObj[0].Msg.MsgID = 5;
        ppScanObj[0].Msg.Result = Result2;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdPreambleDevice;
        ppScanObj[0].Property.Type = 5;
        ppScanObj[0].Property.String.m_Value = pszPreamble[0];
        ppScanObj[0].Property.String.nLength = pszPreamble[0].length();
        return 0;
    }

    /* access modifiers changed from: protected */
    public long WriteSoftScanPreamble(String pszPreamble, TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        if (pszPreamble == null || ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            String pszPreamble2 = ConvertBackslashCharacter(pszPreamble);
            Result2 = this.m_Config.WriteSubValue(pSoftScanConfigTag[0], "Preamble", pszPreamble2, pszPreamble2.length());
            if (Result2 == -17) {
                Result2 = this.m_Config.AddValue(pSoftScanConfigTag[0], "Preamble", pszPreamble2);
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SaveConfiguration();
            }
        }
        ppScanObj[0].Msg.MsgID = 4;
        ppScanObj[0].Msg.Result = Result2;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdPreambleDevice;
        ppScanObj[0].Property.Type = 0;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long ReadSoftScanPostamble(TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        String[] pszPostamble = new String[1];
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Config.ReadSubValue(pSoftScanConfigTag[0], "Postamble", pszPostamble, 1024);
            if (Result == -17) {
                pszPostamble[0] = "";
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = InterpreteBackSlashCharacter(pszPostamble);
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0].Msg.MsgID = 5;
            ppScanObj[0].Msg.Result = Result;
            ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdPostambleDevice;
            ppScanObj[0].Property.Type = 5;
            ppScanObj[0].Property.String.m_Value = pszPostamble[0];
            ppScanObj[0].Property.String.nLength = pszPostamble[0].length();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteSoftScanPostamble(String pszPostamble, TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        if (pszPostamble == null || ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            String pszPostamble2 = ConvertBackslashCharacter(pszPostamble);
            Result2 = this.m_Config.WriteSubValue(pSoftScanConfigTag[0], "Postamble", pszPostamble2, pszPostamble2.length());
            if (Result2 == -17) {
                Result2 = this.m_Config.AddValue(pSoftScanConfigTag[0], "Postamble", pszPostamble2);
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SaveConfiguration();
            }
        }
        ppScanObj[0].Msg.MsgID = 4;
        ppScanObj[0].Msg.Result = Result2;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdPostambleDevice;
        ppScanObj[0].Property.Type = 0;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long ReadSoftScanFriendlyName(TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        String[] friendlyname = new String[1];
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = this.m_Config.ReadSubValue(pSoftScanConfigTag[0], "FriendlyName", friendlyname, 1024);
            if (Result2 == -17) {
                friendlyname[0] = "SoftScanner";
            }
        }
        ppScanObj[0].Msg.MsgID = 5;
        ppScanObj[0].Msg.Result = Result2;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdFriendlyNameDevice;
        ppScanObj[0].Property.Type = 5;
        ppScanObj[0].Property.String.m_Value = friendlyname[0];
        ppScanObj[0].Property.String.nLength = friendlyname[0].length();
        return 0;
    }

    /* access modifiers changed from: protected */
    public long WriteSoftScanFriendlyName(String friendlyname, TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        if (friendlyname == null || ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = this.m_Config.WriteSubValue(pSoftScanConfigTag[0], "FriendlyName", friendlyname, friendlyname.length());
            if (Result2 == -17) {
                Result2 = this.m_Config.AddValue(pSoftScanConfigTag[0], "FriendlyName", friendlyname);
            }
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = SaveConfiguration();
            }
        }
        ppScanObj[0].Msg.MsgID = 4;
        ppScanObj[0].Msg.Result = Result2;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdFriendlyNameDevice;
        ppScanObj[0].Property.Type = 0;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long ReadDecodeAction(TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        String[] decodeAction = new String[1];
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Config.ReadSubValue(pSoftScanConfigTag[0], "DecodeAction", decodeAction, 1024);
            if (Result == -17) {
                decodeAction[0] = "1";
                Result = 0;
            }
        }
        ppScanObj[0] = new TSktScanObject();
        ppScanObj[0].Msg.MsgID = 5;
        ppScanObj[0].Msg.Result = Result;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdLocalDecodeActionDevice;
        ppScanObj[0].Property.Type = 2;
        ppScanObj[0].Property.Byte = (char) Integer.valueOf(decodeAction[0]).intValue();
        return 0;
    }

    /* access modifiers changed from: protected */
    public long WriteDecodeAction(int decodeAction, TSktScanObject[] ppScanObj) {
        long Result;
        long Result2 = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        String localDecodeAction = Integer.toString(decodeAction);
        if (ppScanObj == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Config.WriteSubValue(pSoftScanConfigTag[0], "DecodeAction", localDecodeAction, localDecodeAction.length());
            if (Result == -17) {
                Result = this.m_Config.AddValue(pSoftScanConfigTag[0], "DecodeAction", localDecodeAction);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SaveConfiguration();
            }
        }
        if ((decodeAction & 1) == 1) {
            this._rlObject.setBeep(true);
        } else {
            this._rlObject.setBeep(false);
        }
        if ((decodeAction & 4) == 4) {
            this._rlObject.setVibrate(true);
        } else {
            this._rlObject.setVibrate(false);
        }
        ppScanObj[0] = new TSktScanObject();
        ppScanObj[0].Msg.MsgID = 4;
        ppScanObj[0].Msg.Result = Result;
        ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdLocalDecodeActionDevice;
        ppScanObj[0].Property.Type = 0;
        return 0;
    }

    /* access modifiers changed from: protected */
    public long RetrieveSymbologiesTag(SktSimpleXml.CSktXmlTag[] ppSymbologies) {
        if (SktScanErrors.SKTSUCCESS(0)) {
            return this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan/Symbologies", true, ppSymbologies);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long RetrieveDecodeActionValue(int configName, boolean[] state) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSoftScanConfigTag = new SktSimpleXml.CSktXmlTag[1];
        long[] decodeAction = new long[1];
        if (state == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfigTag), "m_Config.Seek(null,kSktSoftscanConfigTag,true, pSoftScanConfigTag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Config.ReadSubValue(pSoftScanConfigTag[0], "DecodeAction", decodeAction), "m_Config.ReadSubValue(pSoftScanConfigTag[0], configName, pulValue)");
            if (Result == -17) {
                SktDebug.DBGSKT_MSG(18, "Some of the configuration tags for Softscan aren't found in the ScanAPI.xml");
                Result = 0;
            }
        }
        long lValue = -1;
        if (configName == 1) {
            lValue = 1;
        } else if (configName == 2) {
            lValue = 4;
        } else {
            Result = -23;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if ((decodeAction[0] & lValue) == lValue) {
                state[0] = true;
            } else {
                state[0] = false;
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long GetSoftScanChangeID(TSktScanObject[] ppScanObj) {
        long Result;
        long Result2 = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        String[] szEnabled = new String[1];
        SktProtocolInterface.SktChecksum Checksum = new SktProtocolInterface.SktChecksum();
        if (ppScanObj == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(RetrieveSymbologiesTag(pSymbologiesTag), "RetrieveSymbologiesTag(pSymbologiesTag)");
        }
        long ulCount = (long) this.SoftscanStcTranslator.length;
        if (SktScanErrors.SKTSUCCESS(Result)) {
            for (int i = 0; ((long) i) < ulCount; i++) {
                Result = SktDebug.DBGSKT_EVAL(this.m_Config.ReadSubValue(pSymbologiesTag[0], this.SoftscanStcTranslator[i].sName, szEnabled, 16), "m_Config.ReadSubValue(pSymbologiesTag[0],SoftscanStcTranslator[i].sName,szEnabled,nEnabledLength)");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (szEnabled[0].equalsIgnoreCase("1")) {
                        Checksum.Add(1);
                    } else {
                        Checksum.Add(0);
                    }
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    Result = 0;
                }
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            if (ppScanObj[0] == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0].Msg.MsgID = 5;
            ppScanObj[0].Msg.Result = 0;
            ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdChangeIdDevice;
            ppScanObj[0].Property.Type = 3;
            ppScanObj[0].Property.setUlong((long) Checksum.Get());
        }
        return Result;
    }

    public long sendDecodedData(String decodeddata, byte symbologyid) {
        long Result = 0;
        if (this._scanApi == null) {
            Result = -31;
        }
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj.Msg.MsgID = 6;
            pScanObj.Msg.Device.DeviceType = (long) SktScanDeviceType.kSktScanDeviceTypeSoftScan;
            pScanObj.Msg.Device.Guid = this.m_Guid;
            pScanObj.Msg.Device.hDevice = getHandle();
            pScanObj.Msg.Device.szDeviceName = GetFriendlyName();
            pScanObj.Msg.Result = 0;
            pScanObj.Msg.Event.f12ID = 1;
            pScanObj.Msg.Event.Data.Type = 5;
            pScanObj.Msg.Event.Data.DecodedData.SymbologyID = symbologyid;
            boolean bFound = false;
            int nSize = this.SoftscanStcTranslator.length;
            int i = 0;
            while (true) {
                if (i >= nSize) {
                    break;
                } else if (symbologyid == this.SoftscanStcTranslator[i].wSymbologyID) {
                    pScanObj.Msg.Event.Data.DecodedData.SymbologyName.m_Value = this.SoftscanStcTranslator[i].sDescription;
                    pScanObj.Msg.Event.Data.DecodedData.SymbologyName.nLength = this.SoftscanStcTranslator[i].sDescription.length();
                    bFound = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!bFound) {
                pScanObj.Msg.Event.Data.DecodedData.SymbologyName.m_Value = "Unknown Symbology";
                pScanObj.Msg.Event.Data.DecodedData.SymbologyName.nLength = "Unknown Symbology".length();
            }
            String[] pszPreamble = null;
            String[] pszPostamble = null;
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pszPostamble = new String[1];
                pszPreamble = new String[1];
                if (pszPreamble == null || pszPostamble == null) {
                    Result = -2;
                }
            }
            SktSimpleXml.CSktXmlTag[] pSoftScanConfig = new SktSimpleXml.CSktXmlTag[1];
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfig);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                long Result2 = this.m_Config.ReadSubValue(pSoftScanConfig[0], "Preamble", pszPreamble, 1024);
                if (Result2 == -17) {
                    pszPreamble[0] = "";
                }
                if (SktScanErrors.SKTSUCCESS(Result2)) {
                    long Result3 = InterpreteBackSlashCharacter(pszPreamble);
                }
                Result = 0;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                long Result4 = this.m_Config.ReadSubValue(pSoftScanConfig[0], "Postamble", pszPostamble, 1024);
                if (Result4 == -17) {
                    pszPostamble[0] = "";
                }
                if (SktScanErrors.SKTSUCCESS(Result4)) {
                    long Result5 = InterpreteBackSlashCharacter(pszPostamble);
                }
                Result = 0;
            }
            pScanObj.Msg.Event.Data.DecodedData.String.m_Value = pszPreamble[0] + decodeddata + pszPostamble[0];
            pScanObj.Msg.Event.Data.DecodedData.String.nLength = pszPreamble[0].length() + decodeddata.length() + pszPostamble[0].length();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this._scanApi.AddIntoQueue(pScanObj);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj = null;
            }
            SktUtilities.ReleaseScanObject(pScanObj);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public String ConvertBackslashCharacter(String source) {
        StringBuffer destination = new StringBuffer(255);
        int nLength = source.length();
        for (int nIndex = 0; nIndex < nLength; nIndex++) {
            if (source.charAt(nIndex) >= ' ') {
                destination.append(source.charAt(nIndex));
            } else if (source.charAt(nIndex) == 13) {
                destination.append('\\');
                destination.append('n');
            } else if (source.charAt(nIndex) == 10) {
                destination.append('\\');
                destination.append('r');
            } else if (source.charAt(nIndex) == 6) {
                destination.append('\\');
                destination.append('t');
            } else {
                destination.append(Integer.toString(source.charAt(nIndex)));
            }
        }
        return destination.toString();
    }

    /* access modifiers changed from: protected */
    public long InterpreteBackSlashCharacter(String[] string) {
        int nCopyIndex;
        int nLength = string[0].length();
        boolean bEscape = false;
        boolean bEscapeValue = false;
        int nIndex = 0;
        char ucValue = 0;
        char[] pszString = string[0].toCharArray();
        int nCopyIndex2 = 0;
        while (nIndex < nLength) {
            pszString[nIndex] = (char) (pszString[nIndex] & 255);
            if (pszString[nIndex] == '\\') {
                if (bEscape) {
                    nCopyIndex = nCopyIndex2 + 1;
                    pszString[nCopyIndex2] = pszString[nIndex];
                    bEscape = false;
                } else {
                    bEscape = true;
                    nCopyIndex = nCopyIndex2;
                }
            } else if (bEscape) {
                bEscape = false;
                if (pszString[nIndex] >= 0 && pszString[nIndex] <= 9) {
                    ucValue = (char) ((pszString[nIndex] - '0') | ((char) (ucValue * 10)));
                    bEscapeValue = true;
                    bEscape = true;
                    if (nIndex + 1 == nLength) {
                        nCopyIndex = nCopyIndex2 + 1;
                        pszString[nCopyIndex2] = ucValue;
                    }
                } else if (bEscapeValue) {
                    int nCopyIndex3 = nCopyIndex2 + 1;
                    pszString[nCopyIndex2] = ucValue;
                    ucValue = 0;
                    bEscapeValue = false;
                    pszString[nCopyIndex3] = pszString[nIndex];
                    nCopyIndex = nCopyIndex3 + 1;
                } else if (pszString[nIndex] == 'n') {
                    nCopyIndex = nCopyIndex2 + 1;
                    pszString[nCopyIndex2] = 13;
                } else if (pszString[nIndex] == 'r') {
                    nCopyIndex = nCopyIndex2 + 1;
                    pszString[nCopyIndex2] = 10;
                } else if (pszString[nIndex] == 't') {
                    nCopyIndex = nCopyIndex2 + 1;
                    pszString[nCopyIndex2] = 6;
                }
                nCopyIndex = nCopyIndex2;
            } else {
                nCopyIndex = nCopyIndex2 + 1;
                pszString[nCopyIndex2] = pszString[nIndex];
            }
            nIndex++;
            nCopyIndex2 = nCopyIndex;
        }
        string[0] = new String(pszString);
        string[0] = string[0].substring(0, nCopyIndex2);
        return 0;
    }

    private long ConfigureScannerWithSettings() {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] pSymbologyTag = new SktSimpleXml.CSktXmlTag[1];
        String[] SymbologyStatus = new String[1];
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveSymbologiesTag(pSymbologiesTag), "RetrieveSymbologiesTag(pSymbologiesTag)");
        }
        int nCount = this.SoftscanStcTranslator.length;
        for (int i = 0; i < nCount; i++) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_Config.Enumerate(pSymbologiesTag[0], 0, this.SoftscanStcTranslator[i].sName, pSymbologyTag), "m_Config.Enumerate(pSymbologiesTag[0], 0, SoftscanStcTranslator[i].sName, pSymbologyTag)");
                if (Result == -17) {
                    Result = SktDebug.DBGSKT_EVAL(this.m_Config.AddValue(pSymbologiesTag[0], this.SoftscanStcTranslator[i].sName, "0"), "m_Config.AddValue(pSymbologiesTag[0],SoftscanStcTranslator[i].sName,0)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(this.m_Config.Enumerate(pSymbologiesTag[0], 0, this.SoftscanStcTranslator[i].sName, pSymbologyTag), "m_Config.Enumerate(pSymbologiesTag[0], 0, SoftscanStcTranslator[i].sName, pSymbologyTag)");
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(this.m_Config.ReadValue(pSymbologyTag[0], SymbologyStatus, 16), "m_Config.ReadValue(pSymbologyTag[0], SymbologyStatus, nSymbologyStatusLength)");
                if (SymbologyStatus[0].compareTo("1") == 0) {
                    this._rlObject.updateSymStatus(this.SoftscanStcTranslator[i].wSymbologyID, true);
                } else {
                    this._rlObject.updateSymStatus(this.SoftscanStcTranslator[i].wSymbologyID, false);
                }
            }
        }
        boolean[] bValue = new boolean[1];
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveDecodeActionValue(1, bValue), "RetrieveDecodeActionValue(kSktLocalActionBeep,bValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this._rlObject.setBeep(bValue[0]);
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveDecodeActionValue(2, bValue), "RetrieveDecodeActionValue(kSktLocalActionVibrate,bValue)");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this._rlObject.setVibrate(bValue[0]);
            }
        }
        return Result;
    }

    public static boolean IsSupported() {
        return true;
    }

    public void onDecodedData(String decodedData, byte symbologyId) {
        long Result = 0;
        if (this._scanApi == null) {
            Result = -31;
        }
        TSktScanObject pScanObj = new TSktScanObject();
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pScanObj.Msg.MsgID = 6;
            pScanObj.Msg.Device.DeviceType = (long) SktScanDeviceType.kSktScanDeviceTypeSoftScan;
            pScanObj.Msg.Device.Guid = this.m_Guid;
            pScanObj.Msg.Device.hDevice = getHandle();
            pScanObj.Msg.Device.szDeviceName = GetFriendlyName();
            pScanObj.Msg.Result = 0;
            pScanObj.Msg.Event.f12ID = 1;
            pScanObj.Msg.Event.Data.Type = 5;
            pScanObj.Msg.Event.Data.DecodedData.SymbologyID = symbologyId;
            boolean bFound = false;
            int nSize = this.SoftscanStcTranslator.length;
            int i = 0;
            while (true) {
                if (i >= nSize) {
                    break;
                } else if (symbologyId == this.SoftscanStcTranslator[i].wSymbologyID) {
                    pScanObj.Msg.Event.Data.DecodedData.SymbologyName.m_Value = this.SoftscanStcTranslator[i].sDescription;
                    pScanObj.Msg.Event.Data.DecodedData.SymbologyName.nLength = this.SoftscanStcTranslator[i].sDescription.length();
                    bFound = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!bFound) {
                pScanObj.Msg.Event.Data.DecodedData.SymbologyName.m_Value = "Unknown Symbology";
                pScanObj.Msg.Event.Data.DecodedData.SymbologyName.nLength = "Unknown Symbology".length();
            }
            String[] pszPreamble = null;
            String[] pszPostamble = null;
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pszPostamble = new String[1];
                pszPreamble = new String[1];
                if (pszPreamble == null || pszPostamble == null) {
                    Result = -2;
                }
            }
            SktSimpleXml.CSktXmlTag[] pSoftScanConfig = new SktSimpleXml.CSktXmlTag[1];
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", true, pSoftScanConfig);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                long Result2 = this.m_Config.ReadSubValue(pSoftScanConfig[0], "Preamble", pszPreamble, 1024);
                if (Result2 == -17) {
                    pszPreamble[0] = "";
                }
                if (SktScanErrors.SKTSUCCESS(Result2)) {
                    long Result3 = InterpreteBackSlashCharacter(pszPreamble);
                }
                Result = 0;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                long Result4 = this.m_Config.ReadSubValue(pSoftScanConfig[0], "Postamble", pszPostamble, 1024);
                if (Result4 == -17) {
                    pszPostamble[0] = "";
                }
                if (SktScanErrors.SKTSUCCESS(Result4)) {
                    long Result5 = InterpreteBackSlashCharacter(pszPostamble);
                }
                Result = 0;
            }
            pScanObj.Msg.Event.Data.DecodedData.String.m_Value = pszPreamble[0] + decodedData + pszPostamble[0];
            pScanObj.Msg.Event.Data.DecodedData.String.nLength = pszPreamble[0].length() + decodedData.length() + pszPostamble[0].length();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_EVAL(this._scanApi.AddIntoQueue(pScanObj), "AddIntoQueue(pScanObj)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                pScanObj = null;
            }
            SktUtilities.ReleaseScanObject(pScanObj);
        }
    }
}
