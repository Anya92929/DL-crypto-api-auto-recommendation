package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;

class SktScanAPIConfiguration extends SktConfigurationBase {
    public static final String kSktDeviceConfigurationFileNameChs7x = "ConfigChs7x.xml";
    public static final String kSktDeviceConfigurationGuidChs7x = "{422C0329-3E8E-417a-A552-06FABF335B00}";
    private final String kSktScanAPIConfigFile = "ScanAPI.xml";

    SktScanAPIConfiguration() {
    }

    /* access modifiers changed from: protected */
    public long RetrieveConfiguration(SktConfigXml ConfigXml) {
        long Result = 0;
        String[] pszAppDataPath = null;
        if (SktScanErrors.SKTSUCCESS(0)) {
            pszAppDataPath = new String[1];
        }
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktSystem.ReadApplicationDataPath(pszAppDataPath, 2048), "SktSystem.ReadApplicationDataPath(pszAppDataPath,nLength)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath[0] = pszAppDataPath[0] + SktConfigurationBase.kSktApplicationDataPath;
            if (!SktPlatform.SktDirectory.DoesExist(pszAppDataPath[0])) {
                Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktDirectory.Create(pszAppDataPath[0]), "SktDirectory.Create(pszAppDataPath[0])");
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ConfigXml.Load(pszAppDataPath[0], "ScanAPI.xml", SktConfigurationBase.kSktDefaultScanApiXml), "ConfigXml.Load(pszAppDataPath[0], kSktScanAPIConfigFile, kSktDefaultScanApiXml)");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long SaveConfiguration(SktConfigXml ConfigXml) {
        long Result = 0;
        String[] pszAppDataPath = null;
        if (GetConfigXml() == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath = new String[1];
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktSystem.ReadApplicationDataPath(pszAppDataPath, 2048), "SktSystem.ReadApplicationDataPath(pszAppDataPath,nLength)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pszAppDataPath[0] = pszAppDataPath[0] + SktConfigurationBase.kSktApplicationDataPath;
            if (!SktPlatform.SktDirectory.DoesExist(pszAppDataPath[0])) {
                Result = SktDebug.DBGSKT_EVAL(SktPlatform.SktDirectory.Create(pszAppDataPath[0]), "SktDirectory.Create(pszAppDataPath[0])");
            }
        }
        return SktScanErrors.SKTSUCCESS(Result) ? SktDebug.DBGSKT_EVAL(GetConfigXml().Save(pszAppDataPath[0], "ScanAPI.xml"), "pXmlParser.Read(pszBuffer,ulBufferSize,ulSizeRead)") : Result;
    }
}
