package com.SocketMobile.ScanAPI;

public interface ISktScanSymbology {

    /* renamed from: com.SocketMobile.ScanAPI.ISktScanSymbology$flags */
    public interface C0164flags {
        public static final byte kSktScanSymbologyFlagParam = 2;
        public static final byte kSktScanSymbologyFlagStatus = 1;
    }

    /* renamed from: com.SocketMobile.ScanAPI.ISktScanSymbology$id */
    public interface C0165id {
        public static final byte kSktScanSymbologyAustraliaPost = 1;
        public static final byte kSktScanSymbologyAztec = 2;
        public static final byte kSktScanSymbologyBooklandEan = 3;
        public static final byte kSktScanSymbologyBritishPost = 4;
        public static final byte kSktScanSymbologyCanadaPost = 5;
        public static final byte kSktScanSymbologyChinese2of5 = 6;
        public static final byte kSktScanSymbologyCodabar = 7;
        public static final byte kSktScanSymbologyCodablockA = 8;
        public static final byte kSktScanSymbologyCodablockF = 9;
        public static final byte kSktScanSymbologyCode11 = 10;
        public static final byte kSktScanSymbologyCode128 = 15;
        public static final byte kSktScanSymbologyCode39 = 11;
        public static final byte kSktScanSymbologyCode39Extended = 12;
        public static final byte kSktScanSymbologyCode39Trioptic = 13;
        public static final byte kSktScanSymbologyCode93 = 14;
        public static final byte kSktScanSymbologyDataMatrix = 16;
        public static final byte kSktScanSymbologyDirectPartMarking = 46;
        public static final byte kSktScanSymbologyDutchPost = 17;
        public static final byte kSktScanSymbologyEan128 = 20;
        public static final byte kSktScanSymbologyEan128Irregular = 21;
        public static final byte kSktScanSymbologyEan13 = 19;
        public static final byte kSktScanSymbologyEan8 = 18;
        public static final byte kSktScanSymbologyEanUccCompositeAB = 22;
        public static final byte kSktScanSymbologyEanUccCompositeC = 23;
        public static final byte kSktScanSymbologyGs1Databar = 24;
        public static final byte kSktScanSymbologyGs1DatabarExpanded = 26;
        public static final byte kSktScanSymbologyGs1DatabarLimited = 25;
        public static final byte kSktScanSymbologyHanXin = 47;
        public static final byte kSktScanSymbologyInterleaved2of5 = 27;
        public static final byte kSktScanSymbologyIsbt128 = 28;
        public static final byte kSktScanSymbologyJapanPost = 29;
        public static final byte kSktScanSymbologyLastSymbolID = 48;
        public static final byte kSktScanSymbologyMatrix2of5 = 30;
        public static final byte kSktScanSymbologyMaxicode = 31;
        public static final byte kSktScanSymbologyMsi = 32;
        public static final byte kSktScanSymbologyNotSpecified = 0;
        public static final byte kSktScanSymbologyPdf417 = 33;
        public static final byte kSktScanSymbologyPdf417Micro = 34;
        public static final byte kSktScanSymbologyPlanet = 35;
        public static final byte kSktScanSymbologyPlessey = 36;
        public static final byte kSktScanSymbologyPostnet = 37;
        public static final byte kSktScanSymbologyQRCode = 38;
        public static final byte kSktScanSymbologyStandard2of5 = 39;
        public static final byte kSktScanSymbologyTelepen = 40;
        public static final byte kSktScanSymbologyTlc39 = 41;
        public static final byte kSktScanSymbologyUpcA = 42;
        public static final byte kSktScanSymbologyUpcE0 = 43;
        public static final byte kSktScanSymbologyUpcE1 = 44;
        public static final byte kSktScanSymbologyUspsIntelligentMail = 45;
    }

    public interface status {
        public static final byte kSktScanSymbologyStatusDisable = 0;
        public static final byte kSktScanSymbologyStatusEnable = 1;
        public static final byte kSktScanSymbologyStatusNotSupported = 2;
    }

    int getFlags();

    int getID();

    String getName();

    int getStatus();

    void setFlags(int i);

    void setID(int i);

    void setStatus(int i);
}
