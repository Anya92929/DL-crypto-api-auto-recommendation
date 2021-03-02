package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.SktScanDeviceType;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktSimpleXml;

abstract class SktConfigurationBase {
    public static final String kSktApplicationDataPath = "ScanAPI/";
    public static final long kSktDefaultIgnoreUnableInitialize = 0;
    public static final String kSktDefaultScanApiXml = "<ScanAPI>\n<Config>\n<SerialPorts Value=\"server:ScanAPI-1\"/>\n<DataConfirmationMode Value=\"0\"/>\n<DataConfirmationAction Value=\"5\"/>\n<MonitorDbgLevel Value=\"4\"/>\n<SoftScan Value=\"notsupported\"/>\n</Config>\n<SoftScan>\n<FriendlyName Value=\"SoftScanner\" />\n<Preamble Value=\"\" />\n<Postamble Value=\"\\r\" />\n<DecodeAction Value=\"1\"/>\n<Symbologies>\n<Ean13 Value=\"0\"/>\n<Upce Value=\"1\"/>\n<Ean8 Value=\"1\"/>\n<Sticky Value=\"0\"/>\n<QrCode Value=\"1\"/>\n<Code128 Value=\"1\"/>\n<Code39 Value=\"1\"/>\n<Code93 Value=\"1\"/>\n<Datamatrix Value=\"1\"/>\n<Interleaved Value=\"1\"/>\n<RSS14 Value=\"1\"/>\n<Codabar Value=\"1\"/>\n</Symbologies>\n</SoftScan>\n<DataEditing>\n<CurrentProfile Value=\"\"/>\n</DataEditing>\n</ScanAPI>\n";
    public static final String kSktDeviceConfigurationFileNameChs7 = "ConfigChs7.xml";
    public static final String kSktDeviceConfigurationFileNameChs7x = "ConfigChs7x.xml";
    public static final String kSktDeviceConfigurationFileNameChs7xi = "ConfigChs7xi.xml";
    public static final String kSktDeviceConfigurationFileNameChs8ci = "ConfigChs8ci.xml";
    public static final String kSktDeviceConfigurationFileNameCrs9 = "ConfigCrs9.xml";
    public static final String kSktDeviceConfigurationGuidChs7 = "{226A875B-D036-41dc-9111-2E56A4AB1D1F}";
    public static final String kSktDeviceConfigurationGuidChs7x = "{422C0329-3E8E-417a-A552-06FABF335B00}";
    public static final String kSktDeviceConfigurationGuidChs7xi = "{87EABFFD-F5D5-4895-BD8C-EFC2DA2AB56D}";
    public static final String kSktDeviceConfigurationGuidChs8ci = "{8B81AAB0-2C1F-4369-9908-0FFF14F4DDF5}";
    public static final String kSktDeviceConfigurationGuidCrs9 = "{85C0C540-1290-422a-9189-2ED0D7A38510}";
    public static final String kSktIgnoreUnableInitializeConfig = "IgnoreUnableInitialize";
    private final String kSktContains = "Contains";
    private final String kSktCurrentProfile = "CurrentProfile";
    private final String kSktDataConfirmationAction = "DataConfirmationAction";
    private final String kSktDataConfirmationMode = "DataConfirmationMode";
    protected final String kSktDataEditingTag = "ScanAPI/DataEditing";
    private final String kSktEndsWith = "EndsWith";
    private final String kSktMaxLength = "MaxLength";
    private final String kSktMinLength = "MinLength";
    private final String kSktOperation = "Operation";
    private final String kSktProfile = "Profile";
    private final String kSktScanAPIConfigTag = "ScanAPI/Config";
    private final String kSktScanAPIRootTag = "ScanAPI";
    private final String kSktSoftscanConfigTag = "ScanAPI/SoftScan";
    private final String kSktSoftscanFriendlyName = "FriendlyName";
    private final String kSktSoftscanStatus = "SoftScan";
    private final String kSktStartsWith = "StartsWith";
    private final String kSktSymbology = "Symbology";
    private final String kSktTrigger = "Trigger";
    protected SktConfigXml m_ConfigXml;
    protected SktPlatform.SktLock m_Lock;
    private int m_nDataConfirmationMode = 0;
    private long m_ulDataConfirmationAction = 0;
    private long m_ulIgnoreUnableInitialize = 0;
    private long m_ulMonitorDbgChannel;
    private long m_ulMonitorDbgFileLineLevel;
    private long m_ulMonitorDbgLevel;

    /* access modifiers changed from: protected */
    public abstract long RetrieveConfiguration(SktConfigXml sktConfigXml);

    /* access modifiers changed from: protected */
    public abstract long SaveConfiguration(SktConfigXml sktConfigXml);

    public long Initialize() {
        this.m_Lock = new SktPlatform.SktLock();
        this.m_ConfigXml = new SktConfigXml();
        long Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Initialize(), "m_Lock.Initialize()");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml()");
        }
        long[] nData = {1};
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), "DataConfirmationMode", nData), "ReadConfigurationFromXml(GetConfigXml(),kSktDataConfirmationMode,nData)");
            this.m_nDataConfirmationMode = (int) nData[0];
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), "DataConfirmationAction", nData), "ReadConfigurationFromXml(GetConfigXml(),kSktDataConfirmationAction,nData)");
            this.m_ulDataConfirmationAction = nData[0];
        }
        this.m_ulMonitorDbgLevel = 0;
        this.m_ulMonitorDbgFileLineLevel = 0;
        this.m_ulMonitorDbgChannel = 0;
        long[] pulValue = new long[1];
        int[] defaultValue = new int[1];
        GetConfigXml().setNotFoundError(false);
        SktDebug.DBGSKT_GETLEVEL(defaultValue);
        this.m_ulMonitorDbgLevel = (long) defaultValue[0];
        if (IsConfigurationValueNamePresent(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel, pulValue), "ReadConfigurationFromXml(GetConfigXml()," + ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel + ",pulValue)");
            this.m_ulMonitorDbgLevel = pulValue[0];
        }
        SktDebug.DBGSKT_GETFILELINELEVEL(defaultValue);
        this.m_ulMonitorDbgFileLineLevel = (long) defaultValue[0];
        if (IsConfigurationValueNamePresent(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel, pulValue), "ReadConfigurationFromXml(GetConfigXml()," + ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel + ",pulValue)");
            this.m_ulMonitorDbgFileLineLevel = pulValue[0];
        }
        SktDebug.DBGSKT_GETCHANNEL(defaultValue);
        this.m_ulMonitorDbgChannel = (long) defaultValue[0];
        if (IsConfigurationValueNamePresent(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel, pulValue), "ReadConfigurationFromXml(GetConfigXml()," + ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel + ",pulValue)");
            this.m_ulMonitorDbgChannel = pulValue[0];
        }
        if (IsConfigurationValueNamePresent(GetConfigXml(), kSktIgnoreUnableInitializeConfig)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), kSktIgnoreUnableInitializeConfig, pulValue), "ReadConfigurationFromXml(GetConfigXml()," + kSktIgnoreUnableInitializeConfig + ",pulValue)");
            this.m_ulIgnoreUnableInitialize = pulValue[0];
        }
        if (GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, new SktSimpleXml.CSktXmlTag[1]) == -17) {
            AddDataEditingDefaults();
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            Deinitialize();
        }
        return Result;
    }

    public long Deinitialize() {
        return SktDebug.DBGSKT_EVAL(this.m_Lock.Deinitialize(), "m_Lock.Deinitialize()");
    }

    /* access modifiers changed from: package-private */
    public long AddDataEditingDefaults() {
        SktSimpleXml.CSktXmlParser Parser = new SktSimpleXml.CSktXmlParser();
        SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
        long Result = Parser.Parse(kSktDefaultScanApiXml.toCharArray(), (long) kSktDefaultScanApiXml.length());
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Parser.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", 0, true, pTagFound), "Parser.Seek(null,kSktDataEditingTag,0,true,pTagFound)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(InsertXmlTags("ScanAPI", pTagFound[0]), "InsertXmlTags(kSktScanAPIRootTag,pTagFound[0])");
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public SktConfigXml GetConfigXml() {
        return this.m_ConfigXml;
    }

    public long ReadDataConfirmationMode(int[] pMode) {
        long Result = 0;
        if (pMode == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pMode[0] = this.m_nDataConfirmationMode;
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataConfirmationMode(int nMode) {
        long Result;
        long Result2 = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (this.m_nDataConfirmationMode != nMode) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), "DataConfirmationMode", (long) nMode), "WriteConfigurationToXml(GetConfigXml(),kSktDataConfirmationMode,(long)nMode)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    this.m_nDataConfirmationMode = nMode;
                }
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataConfirmationAction(long[] pulAction) {
        long Result = 0;
        if (pulAction == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pulAction[0] = this.m_ulDataConfirmationAction;
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataConfirmationAction(long ulAction) {
        long Result;
        long Result2 = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (this.m_ulDataConfirmationAction != ulAction) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), "DataConfirmationAction", this.m_ulDataConfirmationAction), "WriteConfigurationToXml(GetConfigXml(),kSktDataConfirmationAction,m_ulDataConfirmationAction)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    this.m_ulDataConfirmationAction = ulAction;
                }
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadMonitorDbg(String pszMonitorDbgType, long[] pulValue) {
        long Result = 0;
        if (pulValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel)) {
                pulValue[0] = this.m_ulMonitorDbgLevel;
            } else if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel)) {
                pulValue[0] = this.m_ulMonitorDbgFileLineLevel;
            } else if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel)) {
                pulValue[0] = this.m_ulMonitorDbgChannel;
            } else {
                Result = -23;
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteMonitorDbg(String pszMonitorDbgType, long ulValue) {
        long Result;
        long Result2 = 0;
        long ulCachedValue = 0;
        String name = "";
        if (pszMonitorDbgType == null) {
            Result2 = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result2)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel)) {
                ulCachedValue = this.m_ulMonitorDbgLevel;
                name = ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel;
            } else if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel)) {
                ulCachedValue = this.m_ulMonitorDbgFileLineLevel;
                name = ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel;
            } else if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel)) {
                ulCachedValue = this.m_ulMonitorDbgChannel;
                name = ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel;
            } else {
                Result = -23;
            }
            SktDebug.DBGSKT_MSG(1, "Write " + name + " original value:" + ulCachedValue + " new value:" + ulValue);
            if (SktScanErrors.SKTSUCCESS(Result) && ulCachedValue != ulValue) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), name, ulValue), "WriteConfigurationToXml(GetConfigXml()," + name + ",ulValue)");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgLevel)) {
                        this.m_ulMonitorDbgLevel = ulValue;
                    } else if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgFileLineLevel)) {
                        this.m_ulMonitorDbgFileLineLevel = ulValue;
                    } else if (pszMonitorDbgType.equalsIgnoreCase(ISktScanProperty.values.configuration.kSktScanConfigMonitorDbgChannel)) {
                        this.m_ulMonitorDbgChannel = ulValue;
                    }
                }
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadIgnoreUnableInitialize(long[] pulValue) {
        long Result = 0;
        if (pulValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pulValue[0] = this.m_ulIgnoreUnableInitialize;
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteIgnoreUnableInitialize(long ulValue) {
        long Result;
        long Result2 = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result2 = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result) && this.m_ulIgnoreUnableInitialize != ulValue) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), kSktIgnoreUnableInitializeConfig, ulValue), "WriteConfigurationToXml(GetConfigXml()," + kSktIgnoreUnableInitializeConfig + ",ulValue)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                this.m_ulIgnoreUnableInitialize = ulValue;
            }
        }
        this.m_Lock.Unlock();
        return Result;
    }

    public boolean IsConfigurationValueNamePresent(SktConfigXml ConfigXml, String name) {
        SktSimpleXml.CSktXmlTag[] pScanAPIConfig = new SktSimpleXml.CSktXmlTag[1];
        SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/Config", true, pScanAPIConfig), "GetConfigXml().Seek(null,kSktScanAPIConfigTag,true,pScanAPIConfig)"))) {
            long result = SktDebug.DBGSKT_EVAL(pScanAPIConfig[0].Seek(name, 0, false, pTagFound), "pScanAPIConfig[0].Seek(kSktScanAPIConfigTag,0,false,pTagFound)");
        }
        if (pTagFound[0] != null) {
            return true;
        }
        return false;
    }

    public long ReadSerialPorts(String[] pszSerialPorts, int nLength) {
        long Result = 0;
        if (pszSerialPorts == null || nLength == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigSerialComPort, pszSerialPorts, nLength), "ReadConfigurationFromXml(GetConfigXml(),SktScanTypes.kSktScanConfigSerialComPort,pszSerialPorts,nLength)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteSerialPorts(String pszSerialPorts) {
        long Result = 0;
        if (pszSerialPorts == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), ISktScanProperty.values.configuration.kSktScanConfigSerialComPort, pszSerialPorts, pszSerialPorts.length()), "WriteConfigurationToXml(GetConfigXml(),SktScanTypes.kSktScanConfigSerialComPort,pszSerialPorts,pszSerialPorts.length())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public long ReadSoftscanStatus(String[] pszSoftscanStatus, int nLength) {
        long Result = 0;
        if (pszSoftscanStatus == null || nLength == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), "SoftScan", pszSoftscanStatus, nLength), "ReadConfigurationFromXml(GetConfigXml(),kSktSoftscanStatus,pszSoftscanStatus,nLength)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public long WriteSoftscanStatus(String pszSoftscanStatus) {
        long Result = 0;
        if (pszSoftscanStatus == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), "SoftScan", pszSoftscanStatus, pszSoftscanStatus.length()), "WriteConfigurationToXml(GetConfigXml(),kSktSoftscanStatus,pszSoftscanStatus,pszSoftscanStatus.length())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public long ReadSoftscanFriendlyName(String[] pszFriendlyName, int nLength) {
        long Result = 0;
        if (pszFriendlyName == null || nLength == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadSoftScanConfigFromXml(GetConfigXml(), "FriendlyName", "ScanAPI/SoftScan", pszFriendlyName, nLength), "ReadConfigurationFromXml(GetConfigXml(),kSktSoftscanFriendlyName,kSktSoftscanConfigTag,pszFriendlyName,nLength)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public long WriteSoftscanFriendlyName(String pszFriendlyName) {
        long Result = 0;
        if (pszFriendlyName == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteSoftScanConfigToXml(GetConfigXml(), "FriendlyName", "ScanAPI/SoftScan", pszFriendlyName, pszFriendlyName.length()), "WriteSoftScanConfigToXml(GetConfigXml(),kSktSoftscanFriendlyName,kSktSoftscanConfigTag,pszFriendlyName,pszSoftscanStatus.length())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadConfigGuid(int ulDeviceType, String[] pGuid) {
        long Result = 0;
        if (pGuid == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (ulDeviceType == SktScanDeviceType.kSktScanDeviceTypeScanner7) {
            pGuid[0] = kSktDeviceConfigurationGuidChs7;
            return Result;
        } else if (ulDeviceType == SktScanDeviceType.kSktScanDeviceTypeScanner7x) {
            pGuid[0] = "{422C0329-3E8E-417a-A552-06FABF335B00}";
            return Result;
        } else if (ulDeviceType != SktScanDeviceType.kSktScanDeviceTypeScanner9) {
            return -15;
        } else {
            pGuid[0] = kSktDeviceConfigurationGuidCrs9;
            return Result;
        }
    }

    public long InsertSoftScanTags() {
        SktSimpleXml.CSktXmlParser Parser = new SktSimpleXml.CSktXmlParser();
        SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
        long Result = SktDebug.DBGSKT_EVAL(Parser.Parse(kSktDefaultScanApiXml.toCharArray(), (long) kSktDefaultScanApiXml.length()), "Parser.Parse(kSktDefaultScanApiXml.toCharArray(),kSktDefaultScanApiXml.length())");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(Parser.Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/SoftScan", 0, true, pTagFound), "Parser.Seek(null,kSktSoftscanConfigTag,0,true,pTagFound)");
        }
        SktConfigXml Config = new SktConfigXml();
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml()");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(Config.InsertXmlTags("ScanAPI", 0, pTagFound[0]), "Config.InsertXmlTags(kSktScanAPIRootTag,0,pTagFound[0])");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(Config), "SaveConfiguration(Config)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadCurrentProfile(String[] pszCurrentProfile) {
        long Result = 0;
        if (pszCurrentProfile == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadSoftScanConfigFromXml(GetConfigXml(), "CurrentProfile", "ScanAPI/DataEditing", pszCurrentProfile, 1024), "ReadSoftScanConfigFromXml(GetConfigXml(),kSktCurrentProfile,kSktDataEditingTag,pszCurrentProfile,nStringValueLength)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteCurrentProfile(String pszCurrentProfile) {
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (pszCurrentProfile != null && pszCurrentProfile.length() != 0) {
                SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pDataEditing)");
                }
                SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
                int i = 0;
                while (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
                    if (SktScanErrors.SKTSUCCESS(Result) && pszCurrentProfile.equals(pProfileTag[0].GetAttributeValue("Value"))) {
                        break;
                    }
                    i++;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(WriteSoftScanConfigToXml(GetConfigXml(), "CurrentProfile", "ScanAPI/DataEditing", pszCurrentProfile, pszCurrentProfile.length()), "WriteSoftScanConfigToXml(GetConfigXml(),kSktCurrentProfile,kSktDataEditingTag,pszCurrentProfile,1)");
                }
            } else if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteSoftScanConfigToXml(GetConfigXml(), "CurrentProfile", "ScanAPI/DataEditing", "", 0), "WriteSoftScanConfigToXml(GetConfigXml(),kSktCurrentProfile,kSktDataEditingTag,\"\",0)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingProfiles(String[] pszProfileNames) {
        long Result = 0;
        if (pszProfileNames == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingProfilesFromXml(GetConfigXml(), "Profile", pszProfileNames), "ReadDataEditingProfilesFromXml(GetConfigXml(),kSktProfile,pszProfileNames)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingProfiles(String pszProfileNames) {
        long Result = 0;
        if (SktScanErrors.SKTSUCCESS(0)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pszProfileNames == null || pszProfileNames.length() == 0) {
                    Result = SktDebug.DBGSKT_EVAL(WriteDataEditingProfilesToXml(GetConfigXml(), "Profile", ""), "WriteDataEditingProfilesToXml(GetConfigXml(),kSktProfile,\"\")");
                } else {
                    Result = SktDebug.DBGSKT_EVAL(WriteDataEditingProfilesToXml(GetConfigXml(), "Profile", pszProfileNames), "WriteDataEditingProfilesToXml(GetConfigXml(),kSktProfile,pszProfileNames)");
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingSymbologies(String pszProfile, String[] pszProfileSymbologies) {
        long Result = 0;
        if (pszProfile == null || pszProfileSymbologies == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingSymbologiesFromXml(GetConfigXml(), pszProfile, pszProfileSymbologies), "ReadDataEditingSymbologiesFromXml(GetConfigXml(),pszProfile,pszProfileSymbologies)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingSymbologies(String pszProfileSymbologies) {
        long Result = 0;
        if (pszProfileSymbologies == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingSymbologiesToXml(GetConfigXml(), pszProfileSymbologies), "WriteDataEditingSymbologiesToXml(GetConfigXml(),pszProfileSymbologies)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingMinLength(String pszProfile, String[] pszProfileMinLength) {
        long Result = 0;
        if (pszProfile == null || pszProfileMinLength == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingParametersFromXml(GetConfigXml(), "MinLength", pszProfile, pszProfileMinLength), "ReadDataEditingParametersFromXml(GetConfigXml(),kSktMinLength,pszProfile,pszProfileMinLength)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingMinLength(String pszProfileMinLength) {
        long Result = 0;
        if (pszProfileMinLength == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingParametersToXml(GetConfigXml(), "MinLength", pszProfileMinLength), "WriteDataEditingParametersToXml(GetConfigXml(),kSktMinLength,pszProfileMinLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingMaxLength(String pszProfile, String[] pszProfileMaxLength) {
        long Result = 0;
        if (pszProfile == null || pszProfileMaxLength == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingParametersFromXml(GetConfigXml(), "MaxLength", pszProfile, pszProfileMaxLength), "ReadDataEditingParametersFromXml(GetConfigXml(),kSktMaxLength,pszProfile,pszProfileMaxLength)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingMaxLength(String pszProfileMaxLength) {
        long Result = 0;
        if (pszProfileMaxLength == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingParametersToXml(GetConfigXml(), "MaxLength", pszProfileMaxLength), "WriteDataEditingParametersToXml(GetConfigXml(),kSktMaxLength,pszProfileMaxLength)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingStartsBy(String pszProfile, String[] pszProfileStartsWith) {
        long Result = 0;
        if (pszProfile == null || pszProfileStartsWith == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingParametersFromXml(GetConfigXml(), "StartsWith", pszProfile, pszProfileStartsWith), "ReadDataEditingParametersFromXml(GetConfigXml(),kSktStartsWith,pszProfile,pszProfileStartsWith)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingStartsBy(String pszProfileStartsWith) {
        long Result = 0;
        if (pszProfileStartsWith == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingParametersToXml(GetConfigXml(), "StartsWith", pszProfileStartsWith), "WriteDataEditingParametersToXml(GetConfigXml(),kSktStartsWith,pszProfileStartsWith)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingEndsWith(String pszProfile, String[] pszProfileEndsWith) {
        long Result = 0;
        if (pszProfile == null || pszProfileEndsWith == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingParametersFromXml(GetConfigXml(), "EndsWith", pszProfile, pszProfileEndsWith), "ReadDataEditingParametersFromXml(GetConfigXml(),kSktEndsWith,pszProfile,pszProfileEndsWith)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingEndsWith(String pszProfileEndsWith) {
        long Result = 0;
        if (pszProfileEndsWith == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingParametersToXml(GetConfigXml(), "EndsWith", pszProfileEndsWith), "WriteDataEditingParametersToXml(GetConfigXml(),kSktEndsWith,pszProfileEndsWith)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingContains(String pszProfile, String[] pszProfileContains) {
        long Result = 0;
        if (pszProfile == null || pszProfileContains == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingParametersFromXml(GetConfigXml(), "Contains", pszProfile, pszProfileContains), "ReadDataEditingParametersFromXml(GetConfigXml(),kSktContains,pszProfile,pszProfileContains)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingContains(String pszProfileContains) {
        long Result = 0;
        if (pszProfileContains == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingParametersToXml(GetConfigXml(), "Contains", pszProfileContains), "WriteDataEditingParametersToXml(GetConfigXml(),kSktContains,pszProfileContains)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ReadDataEditingOperation(String pszProfile, String[] pszProfileOperation) {
        long Result = 0;
        if (pszProfile == null || pszProfileOperation == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(ReadDataEditingOperationFromXml(GetConfigXml(), pszProfile, pszProfileOperation), "ReadDataEditingOperationFromXml(GetConfigXml(),pszProfile,pszProfileOperation)");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long WriteDataEditingOperation(String pszProfileOperation) {
        long Result = 0;
        if (pszProfileOperation == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(WriteDataEditingOperationToXml(GetConfigXml(), pszProfileOperation), "WriteDataEditingOperationToXml(GetConfigXml(),pszProfileOperation,pszProfileOperation)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ExportDataEditing(String pszProfiles, String[] pszDataEditing) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (pszProfiles == null || pszDataEditing == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pXmlConfig)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                String[] profileNames = SktUtilities.split(pszProfiles, ";");
                SktScanTypes.TSktScanBoolean bFound = new SktScanTypes.TSktScanBoolean(false);
                SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
                int validTagIndex = 0;
                String pszTemp = "";
                for (String Search : profileNames) {
                    SktScanTypes.TSktScanInteger buffersize = new SktScanTypes.TSktScanInteger(1024);
                    char[] buffer = new char[buffersize.m_value];
                    GetConfigXml().Search(pDataEditing[0], "Profile", Search, bFound, pTagFound);
                    if (bFound.m_value) {
                        SktSimpleXml.CSktXmlTag[] pTagTemp = new SktSimpleXml.CSktXmlTag[1];
                        GetConfigXml().Seek(pTagFound[0], "Operation", false, pTagTemp);
                        if (!(pTagTemp[0] == null || pTagTemp[0].GetAttributeValue("Value") == null || pTagTemp[0].GetAttributeValue("Value").length() == 0)) {
                            pTagFound[0].ReadTagContent(buffer, buffersize.m_value, buffersize);
                            pszTemp = pszTemp + String.valueOf(buffer, 0, buffersize.m_value);
                            validTagIndex++;
                        }
                    }
                }
                if (validTagIndex > 0) {
                    pszDataEditing[0] = pszTemp;
                } else {
                    pszDataEditing[0] = "";
                }
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    public long ImportDataEditing(String pszDataEditing, String[] pszErrorDetail) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (pszDataEditing == null || pszErrorDetail == null) {
            Result = -18;
        }
        SktSimpleXml.CSktXmlParser parser = new SktSimpleXml.CSktXmlParser();
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(parser.Parse(pszDataEditing.toCharArray(), (long) pszDataEditing.length()), "parser.Parse(pszDataEditing.toCharArray(),pszDataEditing.length())");
        }
        SktSimpleXml.CSktXmlTag[] pImportDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(parser.Seek((SktSimpleXml.CSktXmlTag) null, "DataEditing", 0, true, pImportDataEditing), "parser.Seek(null,\"DataEditing\",0,true,pImportDataEditing)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            int[] dwCurrentMajor = new int[1];
            int[] dwCurrentMiddle = new int[1];
            int[] dwCurrentMinor = new int[1];
            int[] dwImportedMajor = new int[1];
            int[] dwImportedMiddle = new int[1];
            int[] dwImportedMinor = new int[1];
            SktScanAPI.RetrieveVersion(pImportDataEditing[0].GetAttributeValue("ScanAPIInterfaceVersion"), false, dwImportedMajor, dwImportedMiddle, dwImportedMinor, new int[1]);
            SktScanAPI.RetrieveVersion(SktScanAPI.SKTSCANAPIINTERFACE_VERSION, false, dwCurrentMajor, dwCurrentMiddle, dwCurrentMinor, new int[1]);
            if (dwImportedMajor[0] > dwCurrentMajor[0]) {
                Result = -86;
            } else if (dwImportedMiddle[0] > dwCurrentMiddle[0]) {
                Result = -86;
            } else if (dwImportedMinor[0] > dwCurrentMinor[0]) {
                Result = -86;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pXmlConfig)");
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                int i = 0;
                SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
                while (true) {
                    if (!SktScanErrors.SKTSUCCESS(parser.Seek(pImportDataEditing[0], "Profile", i, true, pProfileTag))) {
                        break;
                    }
                    SktSimpleXml.CSktXmlTag[] pOperationTag = new SktSimpleXml.CSktXmlTag[1];
                    parser.Seek(pProfileTag[0], "Operation", 0, false, pOperationTag);
                    if (pOperationTag[0] == null) {
                        i++;
                    } else if (pOperationTag[0].GetAttributeValue("Value") == null || pOperationTag[0].GetAttributeValue("Value").length() == 0) {
                        i++;
                    } else {
                        SktScanTypes.TSktScanBoolean tSktScanBoolean = new SktScanTypes.TSktScanBoolean(false);
                        GetConfigXml().Search(pDataEditing[0], "Profile", pProfileTag[0].GetAttributeValue("Value"), tSktScanBoolean, new SktSimpleXml.CSktXmlTag[1]);
                        if (tSktScanBoolean.m_value) {
                            pszErrorDetail[0] = pProfileTag[0].GetAttributeValue("Value");
                            Result = -80;
                            break;
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().InsertXmlTags("ScanAPI/DataEditing", 0, pProfileTag[0]), "GetConfigXml().InsertXmlTags(kSktDataEditingTag,0,pProfileTag[0])");
                        }
                        i++;
                    }
                }
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
            }
            this.m_Lock.Unlock();
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long InsertXmlTags(String pszRootTagName, SktSimpleXml.CSktXmlTag pTagsToInsert) {
        long Result = 0;
        if (pszRootTagName == null || pTagsToInsert == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Lock.Lock(), "m_Lock.Lock()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(RetrieveConfiguration(GetConfigXml()), "RetrieveConfiguration(GetConfigXml())");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().InsertXmlTags(pszRootTagName, 0, pTagsToInsert), "GetConfigXml().InsertXmlTags(pszRootTagName, 0, pTagsToInsert)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SaveConfiguration(GetConfigXml()), "SaveConfiguration(GetConfigXml())");
        }
        this.m_Lock.Unlock();
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteConfigurationToXml(SktConfigXml ConfigXml, String pszName, String pszValue, int nValueLength) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pXmlConfig = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/Config", true, pXmlConfig), "pXmlParser.Seek(null,kSktScanAPIConfigTag,true,pXmlConfig)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(GetConfigXml().WriteSubValue(pXmlConfig[0], pszName, pszValue, nValueLength), "GetConfigXml().WriteSubValue(pXmlConfig[0]," + pszName + "," + pszValue + "," + nValueLength + ")");
        if (SktScanErrors.SKTSUCCESS(Result2) || Result2 != -17) {
            return Result2;
        }
        SktDebug.DBGSKT_MSG(17, "Config Tag " + pszName + " then try to add it");
        return SktDebug.DBGSKT_EVAL(GetConfigXml().AddValue(pXmlConfig[0], pszName, pszValue), "GetConfigXml().AddValue(pXmlConfig[0], pszName, pszValue)");
    }

    /* access modifiers changed from: protected */
    public long ReadConfigurationFromXml(SktConfigXml ConfigXml, String pszName, String[] pszValue, int nValueLength) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pXmlConfig = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszName == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/Config", true, pXmlConfig), "pXmlParser.Seek(null,kSktScanAPIConfigTag,true,pXmlConfig)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(GetConfigXml().ReadSubValue(pXmlConfig[0], pszName, pszValue, nValueLength), "pXmlConfig[0].Seek(pszName,0,pXmlConfig)");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteConfigurationToXml(SktConfigXml ConfigXml, String pszName, long ulValue) {
        String szValue = String.valueOf(ulValue);
        if (SktScanErrors.SKTSUCCESS(0)) {
            return SktDebug.DBGSKT_EVAL(WriteConfigurationToXml(GetConfigXml(), pszName, szValue, szValue.length()), "WriteConfigurationToXml(pXmlParser,pszName,szValue,szValue.length())");
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public long ReadConfigurationFromXml(SktConfigXml ConfigXml, String pszName, long[] pulValue) {
        long Result = 0;
        String[] szValue = new String[1];
        if (GetConfigXml() == null || pszName == null || pulValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(ReadConfigurationFromXml(GetConfigXml(), pszName, szValue, 32), "ReadConfigurationFromXml(GetConfigXml(),pszName,szValue,nValueSize)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            pulValue[0] = Long.parseLong(szValue[0]);
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReadSoftScanConfigFromXml(SktConfigXml ConfigXml, String pszName, String pszTag, String[] pszValue, int nValueLength) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pXmlConfig = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszName == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, pszTag, true, pXmlConfig), "pXmlParser.Seek(null,pszTag,true,pXmlConfig)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(GetConfigXml().ReadSubValue(pXmlConfig[0], pszName, pszValue, nValueLength), "pXmlConfig[0].Seek(pszName,0,pXmlConfig)");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteSoftScanConfigToXml(SktConfigXml ConfigXml, String pszName, String pszTag, String pszValue, int nValueLength) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pXmlConfig = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, pszTag, true, pXmlConfig), "pXmlParser.Seek(null,pszTag,true,pXmlConfig)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        long Result2 = SktDebug.DBGSKT_EVAL(GetConfigXml().WriteSubValue(pXmlConfig[0], pszName, pszValue, nValueLength), "GetConfigXml().WriteSubValue(pXmlConfig[0]," + pszName + "," + pszValue + "," + nValueLength + ")");
        if (SktScanErrors.SKTSUCCESS(Result2) || Result2 != -17) {
            return Result2;
        }
        SktDebug.DBGSKT_MSG(17, "Config Tag " + pszName + " then try to add it");
        return SktDebug.DBGSKT_EVAL(GetConfigXml().AddValue(pXmlConfig[0], pszName, pszValue), "GetConfigXml().AddValue(pXmlConfig[0], pszName, pszValue)");
    }

    /* access modifiers changed from: protected */
    public long ReadDataEditingProfilesFromXml(SktConfigXml ConfigXml, String pszName, String[] pszValue) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszName == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pDataEditing)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        for (int i = 0; SktScanErrors.SKTSUCCESS(GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag)); i++) {
            if (i == 0) {
                pszValue[0] = pProfileTag[0].GetAttributeValue("Value");
            } else {
                pszValue[0] = pszValue[0] + ";" + pProfileTag[0].GetAttributeValue("Value");
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteDataEditingProfilesToXml(SktConfigXml ConfigXml, String pszName, String pszValue) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pDataEditing)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
            String[] pszCurrentProfile = new String[1];
            GetConfigXml().ReadSubValue(pDataEditing[0], "CurrentProfile", pszCurrentProfile, 1);
            int i = 0;
            while (true) {
                if (!SktScanErrors.SKTSUCCESS(GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pTagFound))) {
                    break;
                }
                if (pszValue.indexOf(pTagFound[0].GetAttributeValue("Value")) >= 0) {
                    i++;
                } else if (pszCurrentProfile[0].equalsIgnoreCase(pTagFound[0].GetAttributeValue("Value"))) {
                    Result = -81;
                    break;
                } else {
                    pDataEditing[0].RemoveTag(pTagFound[0]);
                }
            }
            if (pszValue.length() > 0) {
                for (String profileName : SktUtilities.split(pszValue, ";")) {
                    SktScanTypes.TSktScanBoolean bFound = new SktScanTypes.TSktScanBoolean(false);
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Search(pDataEditing[0], pszName, profileName, bFound, pTagFound), "GetConfigXml().Search(pDataEditing[0],pszName,profileName,bFound,pTagFound)");
                    }
                    if (!bFound.m_value && SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(GetConfigXml().AddSection(pDataEditing[0], pszName, profileName, pTagFound), "GetConfigXml().AddSection(pDataEditing[0],pszName,profileName,pTagFound)");
                    }
                }
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReadDataEditingSymbologiesFromXml(SktConfigXml ConfigXml, String pszProfile, String[] pszValue) {
        long Result = 0;
        boolean profileFound = false;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszProfile == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pXmlConfig)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        int i = 0;
        while (true) {
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                break;
            }
            Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
            if (SktScanErrors.SKTSUCCESS(Result) && pszProfile.equalsIgnoreCase(pProfileTag[0].GetAttributeValue("Value"))) {
                profileFound = true;
                break;
            }
            i++;
        }
        SktSimpleXml.CSktXmlTag[] pTriggerTag = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek(pProfileTag[0], "Trigger", true, pTriggerTag), "GetConfigXml().Seek(pProfileTag[0],kSktTrigger,true,pTriggerTag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktSimpleXml.CSktXmlTag[] pSymbologyTag = new SktSimpleXml.CSktXmlTag[1];
            for (int i2 = 0; SktScanErrors.SKTSUCCESS(GetConfigXml().Enumerate(pTriggerTag[0], i2, "Symbology", pSymbologyTag)); i2++) {
                if (i2 > 0) {
                    pszValue[0] = pszValue[0] + ";";
                    pszValue[0] = pszValue[0] + pSymbologyTag[0].GetAttributeValue("Value");
                } else {
                    pszValue[0] = pSymbologyTag[0].GetAttributeValue("Value");
                }
            }
        }
        if (!SktScanErrors.SKTSUCCESS(Result) && Result == -17 && profileFound) {
            return 0;
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteDataEditingSymbologiesToXml(SktConfigXml ConfigXml, String pszProfileSymbologies) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null) {
            Result = -18;
        }
        String pszProfile = "";
        String pszSymbologies = "";
        if (SktScanErrors.SKTSUCCESS(Result)) {
            String[] profileandSymbologyes = SktUtilities.split(pszProfileSymbologies, "=");
            if (profileandSymbologyes.length > 1) {
                pszProfile = profileandSymbologyes[0];
                pszSymbologies = profileandSymbologyes[1];
            } else {
                Result = -18;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pXmlConfig)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        int i = 0;
        while (SktScanErrors.SKTSUCCESS(Result)) {
            Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pszProfile.equalsIgnoreCase(pProfileTag[0].GetAttributeValue("Value"))) {
                    break;
                }
            }
            i++;
        }
        SktSimpleXml.CSktXmlTag[] pTriggerTag = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(Result) && GetConfigXml().Seek(pProfileTag[0], "Trigger", true, pTriggerTag) == -17) {
            GetConfigXml().AddSection(pProfileTag[0], "Trigger", (String) null, pTriggerTag);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
        int i2 = 0;
        while (SktScanErrors.SKTSUCCESS(GetConfigXml().Enumerate(pTriggerTag[0], i2, "Symbology", pTagFound))) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (pszSymbologies.indexOf(pTagFound[0].GetAttributeValue("Value")) >= 0) {
                    i2++;
                }
            }
            pTriggerTag[0].RemoveTag(pTagFound[0]);
        }
        if (pszSymbologies.length() <= 0) {
            return Result;
        }
        String[] symbologies = SktUtilities.split(pszSymbologies, ";");
        int count = symbologies.length;
        for (int i3 = 0; i3 < count; i3++) {
            String symbologyName = symbologies[i3];
            int j = 1;
            while (j < 48 && !symbologyName.equalsIgnoreCase(SktScanAPI.SktScanSymbologyNames[j])) {
                j++;
            }
            if (j == 48) {
                return -18;
            }
            SktScanTypes.TSktScanBoolean bFound = new SktScanTypes.TSktScanBoolean(false);
            if (SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Search(pTriggerTag[0], "Symbology", symbologyName, bFound, pTagFound), "GetConfigXml().Search(pTriggerTag[0],kSktSymbology,symbologyName,bFound,pTagFound)");
            }
            if (!bFound.m_value && SktScanErrors.SKTSUCCESS(Result)) {
                Result = SktDebug.DBGSKT_EVAL(GetConfigXml().AddSection(pTriggerTag[0], "Symbology", symbologyName, pTagFound), "GetConfigXml().AddSection(pTriggerTag[0],kSktSymbology,symbologyName,pTagFound)");
            }
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long ReadDataEditingParametersFromXml(SktConfigXml ConfigXml, String pszTag, String pszProfile, String[] pszValue) {
        long Result = 0;
        boolean profileFound = false;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszTag == null || pszProfile == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "GetConfigXml().Seek(null,kSktDataEditingTag,true,pDataEditing)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        int i = 0;
        while (true) {
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                break;
            }
            Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
            if (SktScanErrors.SKTSUCCESS(Result) && pszProfile.equalsIgnoreCase(pProfileTag[0].GetAttributeValue("Value"))) {
                profileFound = true;
                break;
            }
            i++;
        }
        SktSimpleXml.CSktXmlTag[] pTriggerTag = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek(pProfileTag[0], "Trigger", true, pTriggerTag), "GetConfigXml().Seek(pProfileTag[0],kSktTrigger,true,pTriggerTag)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().ReadSubValue(pTriggerTag[0], pszTag, pszValue, 1), "GetConfigXml().ReadSubValue(pTriggerTag[0], pszTag, pszValue, 1)");
        }
        if (SktScanErrors.SKTSUCCESS(Result) || !profileFound || Result != -17) {
            return Result;
        }
        pszValue[0] = "";
        return 0;
    }

    /* access modifiers changed from: protected */
    public long WriteDataEditingParametersToXml(SktConfigXml ConfigXml, String pszTag, String pszProfileParameter) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null) {
            Result = -18;
        }
        String pszProfile = "";
        String pszParameter = "";
        if (SktScanErrors.SKTSUCCESS(Result)) {
            String[] profileandSymbologyes = SktUtilities.split(pszProfileParameter, "=");
            if (profileandSymbologyes.length > 1) {
                pszProfile = profileandSymbologyes[0];
                pszParameter = profileandSymbologyes[1];
            } else {
                Result = -18;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pXmlConfig)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        int i = 0;
        while (SktScanErrors.SKTSUCCESS(Result)) {
            Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
            if (SktScanErrors.SKTSUCCESS(Result) && pszProfile.equalsIgnoreCase(pProfileTag[0].GetAttributeValue("Value"))) {
                break;
            }
            i++;
        }
        SktSimpleXml.CSktXmlTag[] pTriggerTag = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(Result) && GetConfigXml().Seek(pProfileTag[0], "Trigger", true, pTriggerTag) == -17) {
            GetConfigXml().AddSection(pProfileTag[0], "Trigger", (String) null, pTriggerTag);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(GetConfigXml().Seek(pTriggerTag[0], pszTag, true, pTagFound))) {
            return SktDebug.DBGSKT_EVAL(GetConfigXml().WriteValue(pTagFound[0], pszParameter), "GetConfigXml().WriteValue(pTagFound)[0],pszParameter)");
        }
        return SktDebug.DBGSKT_EVAL(GetConfigXml().AddSection(pTriggerTag[0], pszTag, pszParameter, pTagFound), "GetConfigXml().AddSection(pTriggerTag[0],pszTag,pszParameter,pTagFound)");
    }

    /* access modifiers changed from: protected */
    public long ReadDataEditingOperationFromXml(SktConfigXml ConfigXml, String pszProfile, String[] pszValue) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null || pszProfile == null || pszValue == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "GetConfigXml().Seek(null,kSktDataEditingTag,true,pDataEditing)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        int i = 0;
        while (SktScanErrors.SKTSUCCESS(Result)) {
            Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
            if (SktScanErrors.SKTSUCCESS(Result) && pszProfile.equalsIgnoreCase(pProfileTag[0].GetAttributeValue("Value"))) {
                break;
            }
            i++;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(GetConfigXml().ReadSubValue(pProfileTag[0], "Operation", pszValue, 1), "GetConfigXml().ReadSubValue(pProfileTag[0], kSktOperation, pszValue, 1)");
        }
        return Result;
    }

    /* access modifiers changed from: protected */
    public long WriteDataEditingOperationToXml(SktConfigXml ConfigXml, String pszProfileOperation) {
        long Result = 0;
        SktSimpleXml.CSktXmlTag[] pDataEditing = new SktSimpleXml.CSktXmlTag[1];
        if (GetConfigXml() == null) {
            Result = -18;
        }
        String pszProfile = "";
        String pszOperation = "";
        if (SktScanErrors.SKTSUCCESS(Result)) {
            String[] profileandSymbologyes = SktUtilities.split(pszProfileOperation, "=");
            if (profileandSymbologyes.length > 1) {
                pszProfile = profileandSymbologyes[0];
                pszOperation = profileandSymbologyes[1];
            } else {
                Result = -18;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(GetConfigXml().Seek((SktSimpleXml.CSktXmlTag) null, "ScanAPI/DataEditing", true, pDataEditing), "pXmlParser.Seek(null,kSktDataEditingTag,true,pXmlConfig)");
        }
        SktSimpleXml.CSktXmlTag[] pProfileTag = new SktSimpleXml.CSktXmlTag[1];
        int i = 0;
        while (SktScanErrors.SKTSUCCESS(Result)) {
            Result = GetConfigXml().Enumerate(pDataEditing[0], i, "Profile", pProfileTag);
            if (SktScanErrors.SKTSUCCESS(Result) && pszProfile.equalsIgnoreCase(pProfileTag[0].GetAttributeValue("Value"))) {
                break;
            }
            i++;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktSimpleXml.CSktXmlTag[] pTagFound = new SktSimpleXml.CSktXmlTag[1];
        if (SktScanErrors.SKTSUCCESS(GetConfigXml().Seek(pProfileTag[0], "Operation", true, pTagFound))) {
            return SktDebug.DBGSKT_EVAL(GetConfigXml().WriteValue(pTagFound[0], pszOperation), "GetConfigXml().WriteValue(pTagFound)[0],pszOperation)");
        }
        return SktDebug.DBGSKT_EVAL(GetConfigXml().AddSection(pProfileTag[0], "Operation", pszOperation, pTagFound), "GetConfigXml().AddSection(pProfileTag[0],kSktOperation,pszOperation,pTagFound)");
    }
}
