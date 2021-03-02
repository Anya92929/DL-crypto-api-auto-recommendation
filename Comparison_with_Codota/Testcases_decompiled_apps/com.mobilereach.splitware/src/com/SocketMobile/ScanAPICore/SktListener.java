package com.SocketMobile.ScanAPICore;

import android.support.p000v4.view.InputDeviceCompat;
import com.SocketMobile.Bluetooth.BluetoothHelper;
import com.SocketMobile.ScanAPI.ISktScanProperty;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktEnumerator;
import com.SocketMobile.ScanAPICore.SktHardwareNotificationTypes;
import com.SocketMobile.ScanAPICore.SktList;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktScanTypes;
import com.SocketMobile.ScanAPICore.SktTransport;
import java.util.Vector;

final class SktListener implements Runnable {
    static boolean _bluetoothAdapterInitialized;
    final int kDeviceReadIntervalTimeout = 30;
    final int kDeviceReadMultiplierTimeout = 0;
    final int kDeviceReadTimeout = BluetoothHelper.kDefaultReadTotalTimeout;
    final int kDeviceWriteMultiplier = 0;
    final int kDeviceWriteTimeout = 4000;
    final int kHardwareNotificationTimeoutWhenDevice = SktSsiProtocol.kMinimumDelayBeforeRetry;
    final int kHardwareNotificationTimeoutWhenNoDevice = 1000;
    SktScanAPI pScanAPI = null;

    public SktListener(SktScanAPI ScanAPI) {
        this.pScanAPI = ScanAPI;
    }

    private String[] split(String original, String regex) {
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

    public void run() {
        String str;
        String str2;
        long Result = 0;
        if (!_bluetoothAdapterInitialized) {
            SktPlatform.SktBluetoothAdapter.initializeDefaultBluetoothAdapter();
            _bluetoothAdapterInitialized = true;
        }
        TSktScanObject[] pScanObj = new TSktScanObject[1];
        SktPlatform.SktFlipFlop.State state = new SktPlatform.SktFlipFlop.State();
        SktHardwareNotificationTypes.TSktHardware[] pHardwareNotification = new SktHardwareNotificationTypes.TSktHardware[1];
        SktDebug.DBGSKT_MSG(33, "Listener ScanAPI:" + this.pScanAPI);
        SktSerialEnumerator SerialEnumerator = new SktSerialEnumerator();
        SktTransport.TSktTransportTimeouts Timeouts = new SktTransport.TSktTransportTimeouts();
        SktTransport[] pTransport = new SktTransport[1];
        SktDeviceInterface[] pDeviceInterface = new SktDeviceInterface[1];
        SktList DeviceInterfaceList = new SktList();
        Timeouts.ulReadIntervalTimeout = 30;
        Timeouts.ulReadTotalTimeoutConstant = 2000;
        Timeouts.ulReadTotalTimeoutMultiplier = 0;
        Timeouts.ulWriteTotalTimeoutConstant = 4000;
        Timeouts.ulWriteTotalTimeoutMultiplier = 0;
        this.pScanAPI.HasConfigurationChanged(state);
        boolean bConfigurationHasChanged = true;
        while (bConfigurationHasChanged) {
            bConfigurationHasChanged = false;
            long Result2 = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyListenerThreadStarted(), "pScanAPI.NotifyListenerThreadStarted()");
            if (SktScanErrors.SKTSUCCESS(Result2)) {
                Result2 = this.pScanAPI.ReadConfiguration(ISktScanProperty.values.configuration.kSktScanConfigSerialComPort, pScanObj);
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                if (SktScanErrors.SKTSUCCESS(pScanObj[0].Msg.getResult())) {
                    SktEnumerator.SktEnumDevice EnumDevice = new SktEnumerator.SktEnumDevice();
                    if (pScanObj[0].Property.Type == 5) {
                        String[] StringArray = split(pScanObj[0].Property.String.m_Value, ";");
                        int nTotalCount = 0;
                        int nCount = StringArray.length;
                        for (int i = 0; i < nCount; i++) {
                            EnumDevice.SetManufacturerName(StringArray[i]);
                            Result = SktDebug.DBGSKT_EVAL(SerialEnumerator.RegisterDevice(EnumDevice), "SerialEnumerator.RegisterDevice(EnumDevice)");
                            if (!SktScanErrors.SKTSUCCESS(Result)) {
                                long Result3 = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyError(Result, (SktDeviceInterface) null, EnumDevice.GetManufacturerName()), "pScanAPI.NotifyError(Result,null,EnumDevice.GetManufacturerName())");
                                Result = SktDebug.DBGSKT_EVAL(SerialEnumerator.UnregisterDevice(EnumDevice), "SerialEnumerator.UnregisterDevice(EnumDevice)");
                            } else {
                                nTotalCount++;
                            }
                        }
                        if (SktScanErrors.SKTSUCCESS(Result) && nTotalCount == 0) {
                            Result = SktDebug.DBGSKT_EVAL(-47, "SktScanErrors.ESKT_NOTHINGTOLISTEN");
                        }
                    } else {
                        Result = SktDebug.DBGSKT_EVAL(-18, "SktScanErrors.ESKT_INVALIDPARAMETER");
                    }
                } else {
                    Result = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyError(pScanObj[0].Msg.getResult(), (SktDeviceInterface) null, (String) null), "pScanAPI.NotifyError(pScanObj[0].Msg.getResult(),null,null)");
                }
                this.pScanAPI.ReleaseScanObject(pScanObj[0]);
                pScanObj[0] = null;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                while (true) {
                    if (this.pScanAPI.HasConfigurationChanged(state)) {
                        bConfigurationHasChanged = true;
                        SktDebug.DBGSKT_MSG(1, "Listener thread has detected a change is ScanAPI configuration");
                    } else if (this.pScanAPI.ShouldListenerStop()) {
                        SktDebug.DBGSKT_MSG(1, "Listener thread is asked to shutdown by ScanAPI");
                    } else {
                        Result = 1;
                        if (SktScanErrors.SKTSUCCESS(1)) {
                            Result = SktDebug.DBGSKT_EVAL(SerialEnumerator.Wait(100, pHardwareNotification, pTransport), "SerialEnumerator.Wait(100,pHardwareNotification,pTransport)");
                            if (!SktScanErrors.SKTSUCCESS(Result) && Result == -47) {
                                SktDebug.DBGSKT_MSG(1, "Listener thread has nothing to listen on after the enumeration, Bluetooth OFF?");
                            }
                        }
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            if (Result != 1) {
                                switch (pHardwareNotification[0].Notification) {
                                    case 1:
                                        if (pHardwareNotification[0].TransportType == 1) {
                                            str2 = "HID";
                                        } else {
                                            str2 = "Serial Device Arrival (" + pHardwareNotification[0].pszDeviceName + ")";
                                        }
                                        SktDebug.DBGSKT_MSG(33, str2);
                                        long Result4 = SktDebug.DBGSKT_EVAL(pTransport[0].ConfigureTimeouts(Timeouts), "pTransport[0].ConfigureTimeouts(Timeouts)");
                                        if (SktScanErrors.SKTSUCCESS(Result4)) {
                                            Result4 = AddNewDeviceInterface(pHardwareNotification[0], pTransport[0], DeviceInterfaceList, pDeviceInterface);
                                        }
                                        if (!SktScanErrors.SKTSUCCESS(Result)) {
                                            break;
                                        } else {
                                            Result = this.pScanAPI.NotifyDeviceArrival(pDeviceInterface[0]);
                                            break;
                                        }
                                    case 2:
                                        if (pHardwareNotification[0].TransportType == 1) {
                                            str = "HID";
                                        } else {
                                            str = "Serial Device Removal (" + pHardwareNotification[0].pszDeviceName + ")";
                                        }
                                        SktDebug.DBGSKT_MSG(33, str);
                                        Result = SktDebug.DBGSKT_EVAL(RemoveDeviceInterface(pHardwareNotification[0], pTransport[0], DeviceInterfaceList, pDeviceInterface), "RemoveDeviceInterface(pHardwareNotification[0],pTransport[0],DeviceInterfaceList,pDeviceInterface)");
                                        if (!SktScanErrors.SKTSUCCESS(Result)) {
                                            break;
                                        } else {
                                            Result = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyDeviceRemoval(pDeviceInterface[0]), "pScanAPI.NotifyDeviceRemoval(pDeviceInterface[0])");
                                            break;
                                        }
                                }
                            } else if (DeviceInterfaceList.GetCount() > 0) {
                                Result = ReadFromEachDeviceInterface(DeviceInterfaceList, this.pScanAPI, 2000);
                            }
                        }
                    }
                }
            }
            SktDebug.DBGSKT_MSG(1, "The listener thread is removing all the devices (" + DeviceInterfaceList.GetCount() + ") from its list");
            while (SktScanErrors.SKTSUCCESS(DeviceInterfaceList.RemoveHead(pDeviceInterface))) {
                Result = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyDeviceRemoval(pDeviceInterface[0]), "pScanAPI.NotifyDeviceRemoval(pDeviceInterface[0])");
                pDeviceInterface[0] = null;
            }
            if (bConfigurationHasChanged) {
                SktDebug.DBGSKT_MSG(33, "Configuration has changed so unregister devices and remove transports");
                SerialEnumerator.UnregisterAllDevices();
                SerialEnumerator.RemoveAllTransports();
            }
            if (!SktScanErrors.SKTSUCCESS(Result)) {
                long ResultToReport = Result;
                SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyError(ResultToReport, (SktDeviceInterface) null, (String) null), "pScanAPI.NotifyError(ResultToReport,null,null)");
                if (ResultToReport == -24) {
                    Result = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyError(SktDebug.DBGSKT_EVAL(-47, "SktScanErrors.ESKT_NOTHINGTOLISTEN"), (SktDeviceInterface) null, (String) null), "pScanAPI.NotifyError(Result,null,null)");
                }
                bConfigurationHasChanged = WaitForConfigurationChange(this.pScanAPI, state);
            }
        }
        if (!bConfigurationHasChanged) {
            SerialEnumerator.UnregisterAllDevices();
            SerialEnumerator.RemoveAllTransports();
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            long Result5 = SktDebug.DBGSKT_EVAL(this.pScanAPI.NotifyError(Result, (SktDeviceInterface) null, (String) null), "pScanAPI.NotifyError(Result,null,null)");
        }
        SktDebug.DBGSKT_MSG(1, "The listener thread is done closing transport");
        SktDebug.DBGSKT_MSG(1, "The listener thread is shutting down");
    }

    /* access modifiers changed from: package-private */
    public long AddNewDeviceInterface(SktHardwareNotificationTypes.TSktHardware pHardwareNotification, SktTransport pTransport, SktList pDeviceInterfaceList, SktDeviceInterface[] ppDeviceInterface) {
        long Result = 0;
        SktDeviceInterface pNewDeviceInterface = null;
        if (pHardwareNotification == null || pTransport == null || pDeviceInterfaceList == null || ppDeviceInterface == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (pNewDeviceInterface = new SktDeviceInterface(pHardwareNotification.TransportType, pTransport)) == null) {
            Result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(pDeviceInterfaceList.AddTail(pNewDeviceInterface), "pDeviceInterfaceList.AddTail(pNewDeviceInterface)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            ppDeviceInterface[0] = pNewDeviceInterface;
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public long RemoveDeviceInterface(SktHardwareNotificationTypes.TSktHardware pHardwareNotification, SktTransport pTransport, SktList pDeviceInterfaceList, SktDeviceInterface[] ppDeviceInterface) {
        long Result = 0;
        SktDeviceInterface[] pDeviceInterface = new SktDeviceInterface[1];
        if (pHardwareNotification == null || pTransport == null || pDeviceInterfaceList == null || ppDeviceInterface == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktList.Position position = pDeviceInterfaceList.GetHeadPosition();
            while (true) {
                if (!position.IsValid()) {
                    break;
                }
                SktList.Position removePosition = position.Copy();
                pDeviceInterface[0] = (SktDeviceInterface) position.GetNext();
                if (SktScanErrors.SKTSUCCESS(Result) && pDeviceInterface[0].GetTransport() == pTransport) {
                    Result = SktDebug.DBGSKT_EVAL(pDeviceInterfaceList.RemoveAt(removePosition, pDeviceInterface), "pDeviceInterfaceList.RemoveAt(removePosition,pDeviceInterface)");
                    if (SktScanErrors.SKTSUCCESS(Result)) {
                        ppDeviceInterface[0] = pDeviceInterface[0];
                        break;
                    }
                }
            }
        }
        return Result;
    }

    /* access modifiers changed from: package-private */
    public long ReadFromEachDeviceInterface(SktList deviceInterfaceList, SktScanAPI scanAPI, long timeoutInMilliSeconds) {
        long Result = 0;
        SktPlatform.SktEvent[] readCompletionEvent = new SktPlatform.SktEvent[1];
        SktPlatform.SktEvent[] writeCompletionEvent = new SktPlatform.SktEvent[1];
        SktPlatform.SktEvent[] packetReadyEvent = new SktPlatform.SktEvent[1];
        SktPlatform.SktWait Wait = new SktPlatform.SktWait();
        boolean cycleThrough = false;
        long startTime = System.currentTimeMillis();
        Integer[] waitParam = new Integer[1];
        if (deviceInterfaceList == null || scanAPI == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktDebug.DBGSKT_MSG(1537, "Start Reading from each device");
            SktList.Position position = deviceInterfaceList.GetHeadPosition();
            if (position.IsValid()) {
                int deviceInterfaceIndex = 0;
                SktScanTypes.TSktScanBoolean packetReady = new SktScanTypes.TSktScanBoolean(false);
                while (true) {
                    boolean continueForLoop = true;
                    while (true) {
                        if (!position.IsValid()) {
                            break;
                        }
                        SktDeviceInterface currentDeviceInterface = (SktDeviceInterface) position.GetNext();
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            packetReady.setValue(false);
                            Result = SktDebug.DBGSKT_EVAL(currentDeviceInterface.DoIoOperation(packetReady, readCompletionEvent, writeCompletionEvent, packetReadyEvent), "pCurrentDeviceInterface.DoIoOperation(CPacketReady,pReadCompletionEvent,pWriteCompletionEvent,pPacketReadyEvent)");
                        }
                        if (!SktScanErrors.SKTSUCCESS(Result)) {
                            continueForLoop = false;
                            break;
                        }
                        if (Result == 3) {
                            if (readCompletionEvent[0] != null) {
                                SktDebug.DBGSKT_MSG(InputDeviceCompat.SOURCE_DPAD, "A Read " + deviceInterfaceIndex + " is pending");
                                Result = SktDebug.DBGSKT_EVAL(Wait.AddEvent(readCompletionEvent[0], new Integer(deviceInterfaceIndex)), "Wait.AddEvent(pReadCompletionEvent[0],new Integer(nDeviceInterfaceIndex))");
                            }
                            if (writeCompletionEvent[0] != null) {
                                SktDebug.DBGSKT_MSG(1025, "A Write " + deviceInterfaceIndex + " is pending");
                                if (SktScanErrors.SKTSUCCESS(Result)) {
                                    Result = SktDebug.DBGSKT_EVAL(Wait.AddEvent(writeCompletionEvent[0], new Integer(deviceInterfaceIndex)), "Wait.AddEvent(pWriteCompletionEvent[0],new Integer(nDeviceInterfaceIndex))");
                                }
                            }
                            if (packetReadyEvent[0] != null) {
                                SktDebug.DBGSKT_MSG(1025, "Waiting for more data to send " + deviceInterfaceIndex + " is pending");
                                if (SktScanErrors.SKTSUCCESS(Result)) {
                                    Result = SktDebug.DBGSKT_EVAL(Wait.AddEvent(packetReadyEvent[0], new Integer(deviceInterfaceIndex)), "Wait.AddEvent(pPacketReadyEvent[0],new Integer(nDeviceInterfaceIndex))");
                                }
                            }
                        } else {
                            cycleThrough = true;
                        }
                        if (packetReady.getValue()) {
                            Result = SktDebug.DBGSKT_EVAL(scanAPI.NotifyDataFromDeviceInterface(currentDeviceInterface), "pScanAPI.NotifyDataFromDeviceInterface(pCurrentDeviceInterface)");
                        }
                        deviceInterfaceIndex++;
                        if (cycleThrough && !position.IsValid()) {
                            cycleThrough = false;
                            if (System.currentTimeMillis() - startTime >= timeoutInMilliSeconds) {
                                continueForLoop = false;
                                break;
                            }
                            position = deviceInterfaceList.GetHeadPosition();
                            deviceInterfaceIndex = 0;
                        }
                    }
                    if (!continueForLoop || !SktScanErrors.SKTSUCCESS(Result)) {
                        break;
                    } else if (Wait.GetEventCount() > 0) {
                        SktDebug.DBGSKT_MSG(1537, "Wait for an IO to complete");
                        Result = SktDebug.DBGSKT_EVAL(Wait.Wait(timeoutInMilliSeconds, waitParam), "Wait.Wait(ulTimeoutInMilliSeconds,waitParam)");
                        if (SktScanErrors.SKTSUCCESS(Result)) {
                            if (Result == 1) {
                                break;
                            }
                            deviceInterfaceIndex = waitParam[0].intValue();
                            SktList.Position positionFound = new SktList.Position();
                            long Result2 = SktDebug.DBGSKT_EVAL(deviceInterfaceList.FindIndex((long) deviceInterfaceIndex, positionFound), "pDeviceInterfaceList.FindIndex(nDeviceInterfaceIndex,positionFound)");
                            position = positionFound;
                            SktDebug.DBGSKT_MSG(1537, "An IO " + deviceInterfaceIndex + " has completed");
                            Result = SktDebug.DBGSKT_EVAL(Wait.RemoveEvents(new Integer(deviceInterfaceIndex)), "Wait.RemoveEvents(new Integer(nDeviceInterfaceIndex))");
                        } else {
                            continue;
                        }
                    } else {
                        position = deviceInterfaceList.GetHeadPosition();
                        deviceInterfaceIndex = 0;
                    }
                }
            }
        }
        SktDebug.DBGSKT_MSG(1537, "Stop Reading from each device");
        return Result;
    }

    /* access modifiers changed from: package-private */
    public boolean WaitForConfigurationChange(SktScanAPI ScanAPI, SktPlatform.SktFlipFlop.State state) {
        if (ScanAPI == null || state == null) {
            return false;
        }
        while (!ScanAPI.HasConfigurationChanged(state)) {
            if (ScanAPI.ShouldListenerStop()) {
                return false;
            }
            SktPlatform.SktSystem.sleep(250);
        }
        return true;
    }
}
