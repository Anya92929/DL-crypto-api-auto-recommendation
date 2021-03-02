package com.SocketMobile.ScanAPI;

public class SktScanErrors {
    public static final long ESKT_ALREADYDONE = 2;
    public static final long ESKT_ALREADYEXISTING = -25;
    public static final long ESKT_BUFFERTOOSMALL = -26;
    public static final long ESKT_COMMANDDENIED = -37;
    public static final long ESKT_COMMUNICATIONERROR = -38;
    public static final long ESKT_CONFLICTPROFILE = -80;
    public static final long ESKT_CREATED = 5;
    public static final long ESKT_DELETECURRENTPROFILE = -81;
    public static final long ESKT_DEVICENOTOPEN = -31;
    public static final long ESKT_EVENTNOTCREATED = -10;
    public static final long ESKT_EXCEEDINGMTUSIZE = -46;
    public static final long ESKT_FILEACCESSDENIED = -64;
    public static final long ESKT_FILENOTFOUND = -63;
    public static final long ESKT_INCORRECTNUMBEROFPARAMETERS = -84;
    public static final long ESKT_INVALIDCHECKSUM = -36;
    public static final long ESKT_INVALIDCONFIGURATION = -24;
    public static final long ESKT_INVALIDFORMAT = -85;
    public static final long ESKT_INVALIDHANDLE = -11;
    public static final long ESKT_INVALIDOPERATION = -43;
    public static final long ESKT_INVALIDPARAMETER = -18;
    public static final long ESKT_INVALIDVALUE = -41;
    public static final long ESKT_INVALIDVERSION = -86;
    public static final long ESKT_INVALIDXMLTAG = -49;
    public static final long ESKT_LISTEMPTY = -6;
    public static final long ESKT_NOERROR = 0;
    public static final long ESKT_NOTAVAILABLE = -32;
    public static final long ESKT_NOTENOUGHMEMORY = -2;
    public static final long ESKT_NOTFOUND = -17;
    public static final long ESKT_NOTHINGTOLISTEN = -47;
    public static final long ESKT_NOTINITIALIZED = -19;
    public static final long ESKT_NOTSUPPORTED = -15;
    public static final long ESKT_OUTDATEDVERSION = -48;
    public static final long ESKT_OVERLAYVIEWNOTSET = -90;
    public static final long ESKT_PENDING = 3;
    public static final long ESKT_PENDINGOPERATIONNOTCOMPLETED = -16;
    public static final long ESKT_QUEUERESETED = -45;
    public static final long ESKT_RECEIVEUNEXPECTEDCOMMAND = -39;
    public static final long ESKT_REQUESTTIMEDOUT = -42;
    public static final long ESKT_STILLPENDING = 4;
    public static final long ESKT_SYNTAXERROR = -52;
    public static final long ESKT_TESTFAILED = -1;
    public static final long ESKT_THREADALREADYCREATED = -13;
    public static final long ESKT_THREADSTILLRUNNING = -14;
    public static final long ESKT_TIMEOUTOUTOFRANGE = -20;
    public static final long ESKT_UNABLECONFIGUREDEVICE = -28;
    public static final long ESKT_UNABLECONVERTSTRING = -29;
    public static final long ESKT_UNABLECOPYSTRING = -30;
    public static final long ESKT_UNABLECREATEDIRECTORY = -55;
    public static final long ESKT_UNABLECREATEEVENT = -7;
    public static final long ESKT_UNABLECREATEGUID = -40;
    public static final long ESKT_UNABLECREATELOCK = -3;
    public static final long ESKT_UNABLECREATETHREAD = -12;
    public static final long ESKT_UNABLEDEINITIALIZE = -22;
    public static final long ESKT_UNABLEDELETEDIRECTORY = -57;
    public static final long ESKT_UNABLEDELETEFILE = -56;
    public static final long ESKT_UNABLEGETCLASSDEVICES = -61;
    public static final long ESKT_UNABLEGETDEVICEINTERFACE = -62;
    public static final long ESKT_UNABLEINITIALIZE = -21;
    public static final long ESKT_UNABLEINITIALIZEDATAEDITING = -82;
    public static final long ESKT_UNABLELOCK = -4;
    public static final long ESKT_UNABLEOPENDEVICE = -27;
    public static final long ESKT_UNABLEOPENFILE = -53;
    public static final long ESKT_UNABLEREADFILE = -34;
    public static final long ESKT_UNABLEREADHIDINFO = -70;
    public static final long ESKT_UNABLEREADMODEMSTATUS = -60;
    public static final long ESKT_UNABLEREGISTERFORHIDCHANGES = -50;
    public static final long ESKT_UNABLERESETEVENT = -9;
    public static final long ESKT_UNABLERETRIEVEMESSAGE = -51;
    public static final long ESKT_UNABLERETRIEVEPATH = -54;
    public static final long ESKT_UNABLESETEVENT = -8;
    public static final long ESKT_UNABLEUNLOCK = -5;
    public static final long ESKT_UNABLEWRITEFILE = -33;
    public static final long ESKT_UNKNOWNCONFIGURATION = -23;
    public static final long ESKT_UNKNOWNDATAEDITINGOPERATION = -83;
    public static final long ESKT_WAITFAILED = -35;
    public static final long ESKT_WAITTIMEOUT = 1;
    public static final long ESKT_WRONGPROTOCOL = -44;

    public static final boolean SKTSUCCESS(long result) {
        return result >= 0;
    }
}