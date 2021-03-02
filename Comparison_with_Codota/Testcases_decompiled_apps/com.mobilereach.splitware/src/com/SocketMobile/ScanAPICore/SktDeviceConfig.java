package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktSimpleXml;

final class SktDeviceConfig extends SktDeviceObjectInterface {
    String kConfigDevice = "ConfigDevice";
    String kSktApplicationDataPath;
    String kSktDefaultDeviceXml = "<ConfigDevice>\n<Symbologies>\n</Symbologies>\n</ConfigDevice>\n";
    String kSymbologies = "Symbologies";
    String kSymbology = "Symbology";
    String kSymbologyDisabled = "0";
    String kSymbologyEnabled = "1";
    String kSymbologyStatus = "Status";
    String kSymbologyValue = "Value";
    protected SktConfigXml m_Config;

    SktDeviceConfig() {
    }

    public long Initialize(String fileName, long ulDeviceType, String configGuid) {
        String[] guid = new String[1];
        long Result = SktDebug.DBGSKT_EVAL(super.Initialize(fileName, ulDeviceType), "super.Initialize(fileName,ulDeviceType)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktPlatform.SktGuid.Copy(guid, configGuid);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this.m_Guid = guid[0];
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            Deinitialize();
        }
        return Result;
    }

    public long Deinitialize() {
        return SktDebug.DBGSKT_EVAL(super.Deinitialize(), "super.Deinitialize()");
    }

    public boolean IsPhysicalDevice() {
        return false;
    }

    public long Open() {
        long Result = 0;
        String[] pszAppDataPath = null;
        if (SktScanErrors.SKTSUCCESS(0) && (pszAppDataPath = new String[1]) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktPlatform.SktSystem.ReadApplicationDataPath(pszAppDataPath, 2048);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath[0] = pszAppDataPath[0] + this.kSktApplicationDataPath;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Config.Load(pszAppDataPath[0], GetFriendlyName(), this.kSktDefaultDeviceXml);
        }
        if (SktScanErrors.SKTSUCCESS(Result) && Result == 5 && SktScanErrors.SKTSUCCESS(Result)) {
            Result = AddDefaultSymbologies();
        }
        return Result;
    }

    public long Close() {
        return 0;
    }

    public long GetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponse) {
        long Result = 0;
        if (pbImmediateResponse == null || ppResponse == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (pScanObj.Property.f13ID != 7798788) {
            return -15;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = ReadSymbologyStatus(pScanObj.Property.Symbology, ppResponse);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        ppResponse[0].Property.Context = pScanObj.Property.Context;
        pbImmediateResponse.setValue(true);
        return Result;
    }

    public long SetProperty(TSktScanObject pScanObj, int Destination, SktScanTypes.TSktScanBoolean pbImmediateResponse, TSktScanObject[] ppResponse) {
        long Result = 0;
        if (pbImmediateResponse == null || ppResponse == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (pScanObj.Property.f13ID != 7798788) {
            return -15;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = WriteSymbologyStatus(pScanObj.Property.Symbology, ppResponse);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        ppResponse[0].Msg.Device.DeviceType = pScanObj.Msg.Device.DeviceType;
        ppResponse[0].Msg.Device.szDeviceName = pScanObj.Msg.Device.szDeviceName;
        ppResponse[0].Msg.Device.Guid = pScanObj.Msg.Device.Guid;
        ppResponse[0].Msg.Device.hDevice = pScanObj.Msg.Device.hDevice;
        ppResponse[0].Property.Context = pScanObj.Property.Context;
        pbImmediateResponse.setValue(true);
        return Result;
    }

    /* access modifiers changed from: protected */
    public long RetrievePropertiesToApply(SktList pPropertiesList) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] pSymbologyTag = new SktSimpleXml.CSktXmlTag[1];
        String[] pszEnabled = new String[0];
        long[] ulSymbologyId = {0};
        int nIndex = 0;
        if (pPropertiesList == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (pszEnabled = new String[1]) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = RetrieveSymbologiesTag(pSymbologiesTag);
        }
        while (true) {
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                break;
            }
            int nIndex2 = nIndex + 1;
            if (!SktScanErrors.SKTSUCCESS(this.m_Config.Enumerate(pSymbologiesTag[0], nIndex, this.kSymbology, pSymbologyTag))) {
                int i = nIndex2;
                break;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.ReadValue(pSymbologyTag[0], ulSymbologyId);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.ReadSubValue(pSymbologyTag[0], this.kSymbologyStatus, pszEnabled, 64);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktScanTypes.TSktScanProperty pProperty = new SktScanTypes.TSktScanProperty();
                if (pProperty == null) {
                    Result = -2;
                    nIndex = nIndex2;
                } else {
                    pProperty.f13ID = ISktScanProperty.propId.kSktScanPropIdSymbologyDevice;
                    pProperty.Type = 7;
                    pProperty.Symbology.f14ID = (int) ulSymbologyId[0];
                    pProperty.Symbology.Flags = 1;
                    if (pszEnabled[0] == this.kSymbologyEnabled) {
                        pProperty.Symbology.Status = 1;
                    } else {
                        pProperty.Symbology.Status = 0;
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = pPropertiesList.AddTail(pProperty);
                    }
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        nIndex = nIndex2;
                    }
                }
            }
            nIndex = nIndex2;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long SaveConfiguration() {
        long Result = 0;
        String[] pszAppDataPath = null;
        if (SktScanErrors.SKTSUCCESS(0) && (pszAppDataPath = new String[1]) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktPlatform.SktSystem.ReadApplicationDataPath(pszAppDataPath, 2048);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath[0] = pszAppDataPath[0] + this.kSktApplicationDataPath;
            this.m_Config.Save(pszAppDataPath[0], GetFriendlyName());
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long AddDefaultSymbologies() {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologies = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] pSymbology = new SktSimpleXml.CSktXmlTag[1];
        String szSymbologyId = "";
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = RetrieveSymbologiesTag(pSymbologies);
        }
        for (int index = 1; index < 48; index++) {
            szSymbologyId = szSymbologyId + index;
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.AddSection(pSymbologies[0], this.kSymbology, szSymbologyId, pSymbology);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.AddValue(pSymbology[0], this.kSymbologyStatus, this.kSymbologyEnabled);
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SaveConfiguration();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReadSymbologyStatus(SktScanTypes.TSktScanSymbology pSymbology, TSktScanObject[] ppScanObj) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] pSymbologyTag = new SktSimpleXml.CSktXmlTag[1];
        String[] szEnabled = new String[0];
        boolean bFound = false;
        SktScanTypes.TSktScanBoolean CFound = new SktScanTypes.TSktScanBoolean(false);
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = RetrieveSymbologiesTag(pSymbologiesTag);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.Search(pSymbologiesTag[0], this.kSymbology, (long) pSymbology.f14ID, CFound, pSymbologyTag);
            }
            bFound = CFound.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (bFound) {
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = this.m_Config.ReadSubValue(pSymbologyTag[0], this.kSymbologyStatus, szEnabled, 16);
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        if (szEnabled[0] == this.kSymbologyEnabled) {
                            pSymbology.Status = 1;
                        } else {
                            pSymbology.Status = 0;
                        }
                    }
                } else {
                    Result = -17;
                }
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (ppScanObj = new TSktScanObject[1]) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppScanObj[0] = new TSktScanObject();
            ppScanObj[0].Msg.MsgID = 5;
            if (bFound) {
                ppScanObj[0].Msg.Result = 0;
            } else {
                ppScanObj[0].Msg.Result = -17;
            }
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
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pSymbologiesTag = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] pSymbologyTag = new SktSimpleXml.CSktXmlTag[1];
        String[] pszEnabled = new String[0];
        boolean bFound = false;
        SktScanTypes.TSktScanBoolean CFound = new SktScanTypes.TSktScanBoolean(false);
        if (ppScanObj == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = RetrieveSymbologiesTag(pSymbologiesTag);
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = this.m_Config.Search(pSymbologiesTag[0], this.kSymbology, (long) pSymbology.f14ID, CFound, pSymbologyTag);
            }
            bFound = CFound.getValue();
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (bFound) {
                    if (pSymbology.Status == 1) {
                        pszEnabled[0] = this.kSymbologyEnabled;
                    } else {
                        pszEnabled[0] = this.kSymbologyDisabled;
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = this.m_Config.WriteSubValue(pSymbologyTag[0], this.kSymbologyStatus, pszEnabled[0], pszEnabled[0].length());
                    }
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SaveConfiguration();
                    }
                } else {
                    Result = -17;
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
            ppScanObj[0].Msg.MsgID = 4;
            if (bFound) {
                ppScanObj[0].Msg.Result = 0;
            } else {
                ppScanObj[0].Msg.Result = -17;
            }
            ppScanObj[0].Property.f13ID = ISktScanProperty.propId.kSktScanPropIdSymbologyDevice;
            ppScanObj[0].Property.Type = 0;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long RetrieveSymbologiesTag(SktSimpleXml.CSktXmlTag[] ppSymbologies) {
        String pszSymbologiesPath = this.kConfigDevice + "/" + this.kSymbologies;
        if (SktScanErrors.SKTSUCCESS(0)) {
            return this.m_Config.Seek((SktSimpleXml.CSktXmlTag) null, pszSymbologiesPath, true, ppSymbologies);
        }
        return 0;
    }
}
