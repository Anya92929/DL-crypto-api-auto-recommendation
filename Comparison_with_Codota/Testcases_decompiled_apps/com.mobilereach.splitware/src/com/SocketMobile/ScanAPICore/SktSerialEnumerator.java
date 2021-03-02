package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktEnumerator;
import com.SocketMobile.ScanAPICore.SktHardwareNotificationTypes;
import com.SocketMobile.ScanAPICore.SktList;

final class SktSerialEnumerator extends SktEnumerator {
    private SktHardwareNotificationTypes.TSktHardware m_LastChange = new SktHardwareNotificationTypes.TSktHardware();

    public long RegisterDevice(SktEnumerator.SktEnumDevice EnumDevice) {
        long Result = SktDebug.DBGSKT_EVAL(super.RegisterDevice(EnumDevice), "super.RegisterDevice(EnumDevice)");
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        SktList.Position pos = this.m_RegisteredDevices.GetHeadPosition();
        while (pos.IsValid()) {
            SktEnumerator.SktEnumDevice newDevice = (SktEnumerator.SktEnumDevice) pos.GetNext();
            if (newDevice.GetManufacturerName().equalsIgnoreCase(EnumDevice.GetManufacturerName())) {
                SktEnumerator.SktEnumDeviceInstance Instance = new SktEnumerator.SktEnumDeviceInstance();
                Instance.SetInstanceName(EnumDevice.GetManufacturerName());
                return SktDebug.DBGSKT_EVAL(TryOpenTransport(newDevice, Instance), "TryOpenTransport(newDevice,Instance)");
            }
        }
        return Result;
    }

    public long Check(SktHardwareNotificationTypes.TSktHardware Hardware) {
        long Result = 0;
        if (Hardware == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || this.m_RegisteredDevices.GetCount() <= 0 || Hardware.TransportType == 2) {
        }
        return -32;
    }

    public long Wait(long ulTimeoutMilliseconds, SktHardwareNotificationTypes.TSktHardware[] ppHardware, SktTransport[] ppTransport) {
        long Result = 0;
        boolean bWait = true;
        if (ppHardware == null || ppTransport == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppHardware[0] = null;
            ppTransport[0] = null;
            if (this.m_bRegisteredDevicesModified) {
                SktList.Position position = this.m_RegisteredDevices.GetHeadPosition();
                while (position.IsValid()) {
                    SktEnumerator.SktEnumDevice pEnumDevice = (SktEnumerator.SktEnumDevice) position.GetNext();
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        SktEnumerator.SktEnumDeviceInstance Instance = new SktEnumerator.SktEnumDeviceInstance();
                        Instance.SetInstanceName(pEnumDevice.GetManufacturerName());
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            Result = TryOpenTransport(pEnumDevice, Instance);
                        }
                    }
                    this.m_bRegisteredDevicesModified = false;
                }
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktSerialTransport[] pSerialDevice = new SktSerialTransport[1];
            SktList.Position position2 = this.m_Transports.GetHeadPosition();
            SktList.Position Copy = position2.Copy();
            long[] ulModemStatus = new long[1];
            int[] nModemStatusSize = {4};
            if (!position2.IsValid()) {
                SktDebug.DBGSKT_MSG(2, "There is no transport for the serial enumerator to check on");
                Result = -47;
            }
            while (true) {
                if (!position2.IsValid()) {
                    break;
                }
                SktList.Position removePosition = position2.Copy();
                pSerialDevice[0] = (SktSerialTransport) position2.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result)) {
                    Result = SktDebug.DBGSKT_EVAL(pSerialDevice[0].IoControl(1, (Object) null, 0, ulModemStatus, nModemStatusSize), "pSerialDevice[0].IoControl(SktSerialTransport.kSktIoCtlGetModemStatus,null,0,ulModemStatus,nModemStatusSize)");
                    if (!SktScanErrors.SKTSUCCESS(Result)) {
                        Result = SktDebug.DBGSKT_EVAL(this.m_Transports.RemoveAt(removePosition, pSerialDevice), "m_Transports.RemoveAt(removePosition,pSerialDevice)");
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            if (pSerialDevice[0].GetConnected()) {
                                pSerialDevice[0].SetConnected(false);
                                this.m_LastChange.TransportType = 2;
                                this.m_LastChange.Notification = 2;
                                this.m_LastChange.pszDeviceName = pSerialDevice[0].GetDeviceName();
                                bWait = false;
                                ppTransport[0] = pSerialDevice[0];
                                ppHardware[0] = this.m_LastChange;
                                break;
                            }
                            pSerialDevice = null;
                        }
                    }
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    continue;
                } else if ((ulModemStatus[0] & 128) == 128) {
                    if (!pSerialDevice[0].GetConnected()) {
                        pSerialDevice[0].SetConnected(true);
                        this.m_LastChange.TransportType = 2;
                        this.m_LastChange.Notification = 1;
                        this.m_LastChange.pszDeviceName = pSerialDevice[0].GetDeviceName();
                        bWait = false;
                        ppTransport[0] = pSerialDevice[0];
                        ppHardware[0] = this.m_LastChange;
                        break;
                    }
                } else if (pSerialDevice[0].GetConnected()) {
                    pSerialDevice[0].SetConnected(false);
                    this.m_LastChange.TransportType = 2;
                    this.m_LastChange.Notification = 2;
                    this.m_LastChange.pszDeviceName = pSerialDevice[0].GetDeviceName();
                    bWait = false;
                    ppTransport[0] = pSerialDevice[0];
                    ppHardware[0] = this.m_LastChange;
                    break;
                }
            }
        }
        if (!bWait) {
            return Result;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_Event.Create(false, false), "m_Event.Create(false,false)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(this.m_Event.Wait(ulTimeoutMilliseconds), "m_Event.Wait(ulTimeoutMilliseconds)");
        }
        return Result;
    }

    private long TryOpenTransport(SktEnumerator.SktEnumDevice pDevice, SktEnumerator.SktEnumDeviceInstance pNewInstance) {
        long Result = 0;
        if (pDevice == null || pNewInstance == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result) || pDevice.HasThisInstance(pNewInstance)) {
            return Result;
        }
        SktTransport pSerialDevice = new SktSerialTransport();
        if (pSerialDevice == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(pSerialDevice.Initialize(), "pSerialDevice.Initialize()");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(pSerialDevice.Open(pNewInstance.GetInstanceName(), false), "pSerialDevice.Open(pNewInstance.GetInstanceName(),false)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = this.m_Transports.AddTail(pSerialDevice);
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            return SktDebug.DBGSKT_EVAL(pDevice.AddNewInstance(pNewInstance), "pDevice.AddNewInstance(pNewInstance)");
        }
        return Result;
    }

    public static boolean Test() {
        boolean bResult = true;
        long Result = 0;
        SktHardwareNotificationTypes.TSktHardware Hardware = new SktHardwareNotificationTypes.TSktHardware();
        SktHardwareNotificationTypes.TSktHardware[] pHardwareResult = new SktHardwareNotificationTypes.TSktHardware[1];
        SktTransport[] pTransport = new SktTransport[1];
        SktSerialEnumerator SerialEnumerator = new SktSerialEnumerator();
        SktEnumerator.SktEnumDevice EnumDevice = new SktEnumerator.SktEnumDevice();
        Hardware.TransportType = 2;
        Hardware.Notification = 1;
        Hardware.pszDeviceName = "COM3";
        if (1 == 1) {
            Result = SerialEnumerator.Check(Hardware);
            if (Result != -32) {
                bResult = false;
            }
        }
        if (bResult) {
            Result = EnumDevice.SetManufacturerName("COM1");
            if (Result != 0) {
                bResult = false;
            }
        }
        if (bResult) {
            Result = SerialEnumerator.RegisterDevice(EnumDevice);
            if (Result != 0) {
                bResult = false;
            }
        }
        if (!bResult) {
            return bResult;
        }
        if (bResult) {
            Result = SerialEnumerator.Wait(100, pHardwareResult, pTransport);
            if (Result != 0) {
                bResult = false;
            }
        }
        if (bResult || Result != 1) {
            return bResult;
        }
        SktDebug.DBGSKT_MSG(2, "The COM port 1 has nothing attached... so it failed in timeout");
        return true;
    }
}
