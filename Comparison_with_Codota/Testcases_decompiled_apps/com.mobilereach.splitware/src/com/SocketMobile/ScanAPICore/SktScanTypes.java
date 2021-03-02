package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.ISktScanApi;
import com.SocketMobile.ScanAPI.ISktScanArray;
import com.SocketMobile.ScanAPI.ISktScanDecodedData;
import com.SocketMobile.ScanAPI.ISktScanDevice;
import com.SocketMobile.ScanAPI.ISktScanEvent;
import com.SocketMobile.ScanAPI.ISktScanMsg;
import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.ISktScanString;
import com.SocketMobile.ScanAPI.ISktScanSymbology;
import com.SocketMobile.ScanAPI.ISktScanVersion;

interface SktScanTypes {
    public static final int kSktScanDeviceNameSize = 64;

    public static final class TSktEventData {
        TSktScanArray Array = new TSktScanArray();
        char Byte;
        TSktScanDecodedData DecodedData = new TSktScanDecodedData();
        TSktScanString String = new TSktScanString();
        int Type;
        long Ulong;
    }

    public static final class TSktScanDevice {
        long DeviceType;
        String Guid;
        ISktScanDevice hDevice;
        String szDeviceName;
    }

    public static final class TSktScanEnum {
        int nCurrentIndex;
        int nTotal;
        TSktScanProperty property;
    }

    public static final class TSktScanInteger {
        int m_value;

        public TSktScanInteger(int value) {
            this.m_value = value;
        }

        public void setValue(int value) {
            this.m_value = value;
        }

        public int getValue() {
            return this.m_value;
        }
    }

    public static final class TSktScanChar {
        private char m_value;

        public TSktScanChar(char value) {
            this.m_value = value;
        }

        public void setValue(char value) {
            this.m_value = value;
        }

        public char getValue() {
            return this.m_value;
        }
    }

    public static final class TSktScanBoolean {
        boolean m_value;

        public TSktScanBoolean(boolean value) {
            this.m_value = value;
        }

        public void setValue(boolean value) {
            this.m_value = value;
        }

        public boolean getValue() {
            return this.m_value;
        }
    }

    public static final class TSktScanLong {
        long m_value;

        public TSktScanLong(long value) {
            this.m_value = value;
        }

        public void setValue(long value) {
            this.m_value = value;
        }

        public long getValue() {
            return this.m_value;
        }
    }

    public static final class TSktScanArray implements ISktScanArray {
        int Size = 0;
        char[] pData = null;

        public void setValue(char[] value, int length) {
            this.pData = arrays.copy(value, 0, length);
            this.Size = length;
        }

        public char[] getValue() {
            return this.pData;
        }

        public int getLength() {
            return this.Size;
        }

        public void setLength(int size) {
            this.Size = size;
            if (size > 0) {
                this.pData = new char[size];
            } else {
                this.pData = null;
            }
        }
    }

    public static final class TSktScanString implements ISktScanString {
        String m_Value;
        int nLength;

        public void setValue(String value) {
            this.m_Value = value;
            this.nLength = this.m_Value.length();
        }

        public String getValue() {
            return this.m_Value;
        }

        public int getLength() {
            return this.nLength;
        }
    }

    public static final class TSktScanVersion implements ISktScanVersion {
        int dwBuild;
        int wDay;
        int wHour;
        int wMajor;
        int wMiddle;
        int wMinor;
        int wMinute;
        int wMonth;
        int wYear;

        public int getBuild() {
            return this.dwBuild;
        }

        public int getDay() {
            return this.wDay;
        }

        public int getHour() {
            return this.wHour;
        }

        public int getMajor() {
            return this.wMajor;
        }

        public int getMiddle() {
            return this.wMiddle;
        }

        public int getMinor() {
            return this.wMinor;
        }

        public int getMinute() {
            return this.wMinute;
        }

        public int getMonth() {
            return this.wMonth;
        }

        public int getYear() {
            return this.wYear;
        }
    }

    public static final class TSktScanDecodedData implements ISktScanDecodedData {
        TSktScanString String = new TSktScanString();
        int SymbologyID = 0;
        TSktScanString SymbologyName = new TSktScanString();

        public char[] getData() {
            return this.String.m_Value.toCharArray();
        }

        public int getDataSize() {
            return this.String.nLength;
        }

        public int getSymbologyID() {
            return this.SymbologyID;
        }

        public String getSymbologyName() {
            return this.SymbologyName.m_Value;
        }
    }

    public static final class TSktScanSymbology implements ISktScanSymbology {
        int Flags;

        /* renamed from: ID */
        int f14ID;
        TSktScanString Name;
        int Status;

        public int getFlags() {
            return this.Flags;
        }

        public int getID() {
            return this.f14ID;
        }

        public String getName() {
            return this.Name.m_Value;
        }

        public int getStatus() {
            return this.Status;
        }

        public void setFlags(int flags) {
            this.Flags = flags;
        }

        public void setID(int id) {
            this.f14ID = id;
        }

        public void setStatus(int status) {
            this.Status = status;
        }
    }

    public static final class TSktScanMsg implements ISktScanMsg {
        TSktScanDevice Device = new TSktScanDevice();
        TSktScanEvent Event = new TSktScanEvent();
        int MsgID = 0;
        long Result = 0;

        public int getID() {
            return this.MsgID;
        }

        public String getDeviceGuid() {
            return this.Device.Guid;
        }

        public String getDeviceName() {
            return this.Device.szDeviceName;
        }

        public long getDeviceType() {
            return this.Device.DeviceType;
        }

        public long getResult() {
            return this.Result;
        }

        public ISktScanDevice getDeviceInterface() {
            if (this.Device.hDevice == null) {
                this.Device.hDevice = new SktScanCore((ISktScanApi) null);
            }
            return this.Device.hDevice;
        }

        public ISktScanEvent getEvent() {
            return this.Event;
        }
    }

    public static final class TSktScanProperty implements ISktScanProperty {
        TSktScanArray Array = new TSktScanArray();
        char Byte;
        Object Context;

        /* renamed from: ID */
        int f13ID;
        TSktScanString String = new TSktScanString();
        TSktScanSymbology Symbology = new TSktScanSymbology();
        int Type;
        long Ulong;
        TSktScanVersion Version = new TSktScanVersion();
        Object object;

        public int getID() {
            return this.f13ID;
        }

        public void setID(int ID) {
            this.f13ID = ID;
        }

        public int getType() {
            return this.Type;
        }

        public void setType(int type) {
            this.Type = type;
        }

        public char getByte() {
            return this.Byte;
        }

        public void setByte(char value) {
            this.Byte = value;
        }

        public ISktScanString getString() {
            return this.String;
        }

        public long getUlong() {
            return this.Ulong;
        }

        public void setUlong(long value) {
            this.Ulong = value;
        }

        public ISktScanVersion getVersion() {
            return this.Version;
        }

        public ISktScanArray getArray() {
            return this.Array;
        }

        public void SetValue(int id, int type, char value) {
            this.f13ID = id;
            this.Type = type;
            this.Byte = value;
        }

        public ISktScanSymbology getSymbology() {
            return this.Symbology;
        }

        public Object getObject() {
            return this.object;
        }

        public void setObject(Object context) {
            this.object = context;
        }

        public Object getContext() {
            return this.Context;
        }

        public void setContext(Object context) {
            this.Context = context;
        }
    }

    public static final class TSktScanEvent implements ISktScanEvent {
        TSktEventData Data = new TSktEventData();

        /* renamed from: ID */
        int f12ID;

        public char getDataByte() {
            return 0;
        }

        public ISktScanDecodedData getDataDecodedData() {
            return this.Data.DecodedData;
        }

        public long getDataLong() {
            return this.Data.Ulong;
        }

        public String getDataString() {
            return this.Data.String.m_Value;
        }

        public int getDataType() {
            return this.Data.Type;
        }

        public int getID() {
            return this.f12ID;
        }
    }
}
