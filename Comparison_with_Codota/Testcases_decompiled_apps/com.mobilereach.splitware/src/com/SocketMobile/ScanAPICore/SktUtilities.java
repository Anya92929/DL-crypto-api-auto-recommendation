package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import java.util.Vector;

final class SktUtilities {
    public static final int kMaxByte = 255;
    public static final long kMaxWord = 65535;

    SktUtilities() {
    }

    public static long strcpy(String pszDst, int nDstSizeInBytes, String Src) {
        long Result = 0;
        if (Src == null || pszDst == null || nDstSizeInBytes == 0) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            String pszDst2 = Src;
        }
        return Result;
    }

    public static long AllocateAndCopyProperty(SktScanTypes.TSktScanProperty Destination, SktScanTypes.TSktScanProperty Source) {
        long Result = 0;
        if (Destination == null || Source == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        Destination.f13ID = Source.f13ID;
        Destination.Type = Source.Type;
        Destination.Context = Source.Context;
        switch (Destination.Type) {
            case 0:
            case 1:
                return Result;
            case 2:
                Destination.Byte = Source.Byte;
                return Result;
            case 3:
                Destination.Ulong = Source.Ulong;
                return Result;
            case 4:
                Destination.Array.Size = Source.Array.Size;
                Destination.Array.pData = new char[Source.Array.Size];
                if (Destination.Array.pData == null) {
                    return -2;
                }
                Destination.Array.pData = Source.Array.pData;
                return Result;
            case 5:
                Destination.String.nLength = Source.String.nLength;
                Destination.String.m_Value = "";
                if (Destination.String.m_Value == null) {
                    return -2;
                }
                Destination.Array.pData = Source.Array.pData;
                return Result;
            case 6:
                Destination.Version = Source.Version;
                return Result;
            case 7:
                Destination.Symbology.Flags = Source.Symbology.Flags;
                Destination.Symbology.f14ID = Source.Symbology.f14ID;
                Destination.Symbology.Status = Source.Symbology.Status;
                Destination.Symbology.Name = Source.Symbology.Name;
                return Result;
            default:
                return -15;
        }
    }

    public static long ReleaseProperty(SktScanTypes.TSktScanProperty Property) {
        if (Property != null) {
            switch (Property.Type) {
                case 4:
                    Property.Array.pData = null;
                    Property.Array.Size = 0;
                    break;
                case 5:
                    Property.String.m_Value = null;
                    Property.String.nLength = 0;
                    break;
            }
        }
        return 0;
    }

    public static long ReleaseScanObject(TSktScanObject ScanObj) {
        long Result = 0;
        if (ScanObj != null) {
            Result = SktDebug.DBGSKT_EVAL(ReleaseProperty(ScanObj.Property), "ReleaseProperty(ScanObj.Property)");
            switch (ScanObj.Msg.Event.Data.Type) {
                case 3:
                    ScanObj.Msg.Event.Data.Array.pData = null;
                    ScanObj.Msg.Event.Data.Array.Size = 0;
                    break;
                case 4:
                    ScanObj.Msg.Event.Data.String.m_Value = null;
                    ScanObj.Msg.Event.Data.String.nLength = 0;
                    break;
                case 5:
                    ScanObj.Msg.Event.Data.DecodedData.String.m_Value = null;
                    ScanObj.Msg.Event.Data.DecodedData.String.nLength = 0;
                    break;
            }
        }
        return Result;
    }

    public static long CopyScanObjectMsg(TSktScanObject Destination, TSktScanObject Source) {
        long Result = 0;
        if (Destination == null || Source == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        Destination.Msg.MsgID = Source.Msg.MsgID;
        Destination.Msg.Device.DeviceType = Source.Msg.Device.DeviceType;
        Destination.Msg.Device.Guid = Source.Msg.Device.Guid;
        Destination.Msg.Device.hDevice = Source.Msg.Device.hDevice;
        Destination.Msg.Device.szDeviceName = Source.Msg.Device.szDeviceName;
        Destination.Msg.Result = Source.Msg.Result;
        Destination.Msg.Event.f12ID = Source.Msg.Event.f12ID;
        Destination.Msg.Event.Data.Type = Source.Msg.Event.Data.Type;
        switch (Destination.Msg.Event.Data.Type) {
            case 0:
                return Result;
            case 1:
                Destination.Msg.Event.Data.Byte = Source.Msg.Event.Data.Byte;
                return Result;
            case 2:
                Destination.Msg.Event.Data.Ulong = Source.Msg.Event.Data.Ulong;
                return Result;
            case 3:
                Destination.Msg.Event.Data.Array.Size = Source.Msg.Event.Data.Array.Size;
                Destination.Msg.Event.Data.Array.pData = new char[Source.Msg.Event.Data.Array.Size];
                if (Destination.Msg.Event.Data.Array.pData == null) {
                    return -2;
                }
                Destination.Msg.Event.Data.Array.pData = Source.Msg.Event.Data.Array.pData;
                return Result;
            case 4:
                return SktDebug.DBGSKT_EVAL(AllocateAndCopySktString(Destination.Msg.Event.Data.String, Source.Msg.Event.Data.String), "AllocateAndCopySktString(Destination.Event.Data.String,Source.Event.Data.String)");
            case 5:
                Destination.Msg.Event.Data.DecodedData.SymbologyID = Source.Msg.Event.Data.DecodedData.SymbologyID;
                return SktDebug.DBGSKT_EVAL(AllocateAndCopySktString(Destination.Msg.Event.Data.DecodedData.String, Source.Msg.Event.Data.DecodedData.String), "AllocateAndCopySktString(Destination.Event.Data.DecodedData.String,Source.Event.Data.DecodedData.String)");
            default:
                return -15;
        }
    }

    public static long AllocateAndCopySktString(SktScanTypes.TSktScanString Destination, SktScanTypes.TSktScanString Source) {
        long Result = 0;
        if (Destination == null || Source == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Destination.nLength = Source.nLength;
            if (Source.nLength > 0) {
                if (Source.m_Value == null) {
                    Result = -18;
                }
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Destination.m_Value = Source.m_Value;
                }
            }
        }
        return Result;
    }

    public static String[] split(String original, String regex) {
        Vector v = new Vector();
        int index = 0;
        int startIndex = original.indexOf(regex);
        while (startIndex < original.length() && startIndex != -1) {
            String temp = original.substring(index, startIndex);
            System.out.println("     " + startIndex);
            v.addElement(temp);
            index = startIndex + regex.length();
            startIndex = original.indexOf(regex, regex.length() + startIndex);
        }
        v.addElement(original.substring((index + 1) - regex.length()));
        String[] str = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            str[i] = (String) v.elementAt(i);
        }
        return str;
    }

    public static int CodeDecimalInHexa(int nDecimal) {
        int nDecimalInHexa = 0 + ((nDecimal / 1000) * 4096);
        int nDecimal2 = nDecimal - ((nDecimal / 1000) * 1000);
        int nDecimalInHexa2 = nDecimalInHexa + ((nDecimal2 / 100) * 256);
        int nDecimal3 = nDecimal2 - ((nDecimal2 / 100) * 100);
        return nDecimalInHexa2 + ((nDecimal3 / 10) * 16) + (nDecimal3 - ((nDecimal3 / 10) * 10));
    }

    public static int DecodeDecimalInHexa(int wDecimalInHexa) {
        int nDecimal = 0;
        int nMultiplier = 1;
        while (wDecimalInHexa > 0) {
            nDecimal += (wDecimalInHexa & 15) * nMultiplier;
            wDecimalInHexa >>= 4;
            nMultiplier *= 10;
        }
        return nDecimal;
    }

    public static long ConvertAsciiHexaToUnsignedLong(String pszHexaValue) {
        long ulConvertedValue = 0;
        if (pszHexaValue != null) {
            int nLength = pszHexaValue.length();
            int nIndex = 0;
            while (nIndex < nLength) {
                int nIndex2 = nIndex + 1;
                char OneChar = pszHexaValue.charAt(nIndex);
                ulConvertedValue <<= 4;
                if (OneChar >= '0' && OneChar <= '9') {
                    ulConvertedValue |= (long) (OneChar - '0');
                    nIndex = nIndex2;
                } else if (OneChar >= 'a' && OneChar <= 'f') {
                    ulConvertedValue |= (long) ((OneChar - 'a') + 10);
                    nIndex = nIndex2;
                } else if (OneChar < 'A' || OneChar > 'F') {
                    nIndex = nIndex2;
                } else {
                    ulConvertedValue |= (long) ((OneChar - 'a') + 10);
                    nIndex = nIndex2;
                }
            }
            int i = nIndex;
        }
        return ulConvertedValue;
    }

    public static int ConvertStringToInt(String stringValue) {
        if (stringValue == null || stringValue.length() <= 0) {
            return 0;
        }
        return Integer.valueOf(stringValue).intValue();
    }
}
