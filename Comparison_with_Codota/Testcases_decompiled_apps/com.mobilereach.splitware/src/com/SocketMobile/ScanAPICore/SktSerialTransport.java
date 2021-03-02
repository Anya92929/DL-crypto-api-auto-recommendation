package com.SocketMobile.ScanAPICore;

import android.support.p000v4.view.InputDeviceCompat;
import com.SocketMobile.Bluetooth.BluetoothData;
import com.SocketMobile.Bluetooth.BluetoothHelper;
import com.SocketMobile.Bluetooth.BluetoothHelperClassFactory;
import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;
import com.SocketMobile.ScanAPICore.SktTransport;

public final class SktSerialTransport extends SktTransport {
    private BluetoothHelper _bluetoothHelper = BluetoothHelperClassFactory.CreateBluetoothHelper();
    private BluetoothData _readBuffer = BluetoothHelperClassFactory.CreateBluetoothData();
    private BluetoothData _writeBuffer = BluetoothHelperClassFactory.CreateBluetoothData();
    protected boolean m_bReadPending = false;
    protected boolean m_bWritePending = false;
    protected int m_nReadBufferSize = 0;
    protected char[] m_pucReadBuffer;

    public /* bridge */ /* synthetic */ boolean GetConnected() {
        return super.GetConnected();
    }

    public /* bridge */ /* synthetic */ String GetDeviceName() {
        return super.GetDeviceName();
    }

    public /* bridge */ /* synthetic */ SktPlatform.SktEvent GetIoControlCompletionEvent() {
        return super.GetIoControlCompletionEvent();
    }

    public /* bridge */ /* synthetic */ SktPlatform.SktEvent GetReadCompletionEvent() {
        return super.GetReadCompletionEvent();
    }

    public /* bridge */ /* synthetic */ SktPlatform.SktEvent GetWriteCompletionEvent() {
        return super.GetWriteCompletionEvent();
    }

    public /* bridge */ /* synthetic */ long Initialize() {
        return super.Initialize();
    }

    public /* bridge */ /* synthetic */ void SetConnected(boolean x0) {
        super.SetConnected(x0);
    }

    public long Deinitialize() {
        SktDebug.DBGSKT_MSG(129, "Deinitialize Transport: " + GetDeviceName());
        long result = super.Deinitialize();
        if (this._bluetoothHelper != null) {
            if (!BluetoothHelper.Errors.IsSuccess(this._bluetoothHelper.deinitialize())) {
                result = -22;
            }
            this._bluetoothHelper = null;
        }
        return result;
    }

    public long Open(String pszDeviceName, boolean bQuery) {
        long status;
        Close();
        long Result = SktDebug.DBGSKT_EVAL(this.m_ReadCompletionEvent.Create(false, false), "m_ReadCompletionEvent.Create(false, false)");
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(this.m_WriteCompletionEvent.Create(false, false), "m_WriteCompletionEvent.Create(false, false)");
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            if (pszDeviceName.toLowerCase().startsWith("client")) {
                pszDeviceName = pszDeviceName.substring(pszDeviceName.indexOf(":") + 1);
                SktDebug.DBGSKT_MSG(129, "About to open: " + pszDeviceName + " in client mode");
                status = this._bluetoothHelper.open("Client", pszDeviceName);
            } else if (pszDeviceName.toLowerCase().startsWith("server")) {
                pszDeviceName = pszDeviceName.substring(pszDeviceName.indexOf(":") + 1);
                SktDebug.DBGSKT_MSG(129, "About to open: " + pszDeviceName + " in server mode");
                status = this._bluetoothHelper.open("Server", pszDeviceName);
            } else {
                SktDebug.DBGSKT_MSG(129, "About to open: " + pszDeviceName + " in server mode (default)");
                status = this._bluetoothHelper.open("Server", pszDeviceName);
            }
            if (!BluetoothHelper.Errors.IsSuccess(status)) {
                SktDebug.DBGSKT_MSG(129, "Unable to open successfully: " + pszDeviceName);
                Result = -27;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            SktDebug.DBGSKT_MSG(129, "Done opening successfully: " + pszDeviceName);
            this._bluetoothHelper.setReadCompleteEvent(new BluetoothHelper.EventComplete() {
                public void setComplete() {
                    SktDebug.DBGSKT_MSG(512, "Set Read Complete event");
                    SktDebug.DBGSKT_EVAL(SktSerialTransport.this.GetReadCompletionEvent().Set(), "GetReadCompletionEvent().Set()");
                }

                public void reset() {
                    SktDebug.DBGSKT_MSG(512, "Reset Read Complete event");
                    SktDebug.DBGSKT_EVAL(SktSerialTransport.this.GetReadCompletionEvent().Reset(), "GetReadCompletionEvent().Reset()");
                }
            });
            this._bluetoothHelper.setWriteCompleteEvent(new BluetoothHelper.EventComplete() {
                public void setComplete() {
                    SktDebug.DBGSKT_MSG(1024, "Set Write Complete event");
                    SktDebug.DBGSKT_EVAL(SktSerialTransport.this.GetWriteCompletionEvent().Set(), "GetWriteCompletionEvent().Set()");
                }

                public void reset() {
                    SktDebug.DBGSKT_MSG(1024, "Reset Write Complete event");
                    SktDebug.DBGSKT_EVAL(SktSerialTransport.this.GetWriteCompletionEvent().Reset(), "GetWriteCompletionEvent().Reset()");
                }
            });
            this.m_pucReadBuffer = new char[2048];
            if (this.m_pucReadBuffer == null) {
                Result = -2;
            }
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Result = SktDebug.DBGSKT_EVAL(SetDeviceName(pszDeviceName), "SetDeviceName(pszDeviceName)");
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            Close();
        }
        return Result;
    }

    public long Close() {
        String deviceName = GetDeviceName();
        if (deviceName != null) {
            SktDebug.DBGSKT_MSG(129, "About to close: " + deviceName);
        }
        this._bluetoothHelper.close();
        if (deviceName != null) {
            SktDebug.DBGSKT_MSG(129, deviceName + " is closed");
        }
        this.m_pucReadBuffer = null;
        this.m_bReadPending = false;
        this.m_bWritePending = false;
        this.m_ReadCompletionEvent.Delete();
        this.m_WriteCompletionEvent.Delete();
        return 0;
    }

    public long ReadBlock(char[] data, int offset, int[] nBlockSize) {
        int numberOfByteToRead;
        long Result = 0;
        int numberOfByteRead = 0;
        if (!this._bluetoothHelper.isOpen()) {
            Result = -31;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (data == null || nBlockSize == null)) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        if (!this.m_bReadPending) {
            if (nBlockSize[0] > 2048) {
                numberOfByteToRead = 2048;
            } else {
                numberOfByteToRead = nBlockSize[0];
            }
            this._readBuffer.allocate(numberOfByteToRead);
            if (SktScanErrors.SKTSUCCESS(Result)) {
                long status = this._bluetoothHelper.readBlock(this._readBuffer);
                if (!BluetoothHelper.Errors.IsSuccess(status)) {
                    Result = -34;
                    SktDebug.DBGSKT_MSG(4, "Unable to read from Serial transport");
                } else if (status == 1) {
                    SktDebug.DBGSKT_MSG(InputDeviceCompat.SOURCE_DPAD, "Read pending");
                    this.m_bReadPending = true;
                } else {
                    numberOfByteRead = this._readBuffer.getSize();
                    this._readBuffer.read(data, offset, numberOfByteRead);
                    this.m_pucReadBuffer = data;
                    SktDebug.DBGSKT_DUMPBYTE(129, "<-", this.m_pucReadBuffer, numberOfByteRead);
                    SktDebug.DBGSKT_MSG(129, "Read returns size:" + numberOfByteRead);
                }
            }
        } else {
            this.m_bReadPending = this._bluetoothHelper.isReadBlockPending();
            if (!this.m_bReadPending) {
                numberOfByteRead = this._readBuffer.getSize();
                this._readBuffer.read(data, offset, numberOfByteRead);
                this.m_pucReadBuffer = data;
                SktDebug.DBGSKT_DUMPBYTE(129, "<-", this.m_pucReadBuffer, numberOfByteRead);
                if (numberOfByteRead > 0) {
                    SktDebug.DBGSKT_MSG(129, "In Overlapped result, size:" + numberOfByteRead);
                }
            }
        }
        nBlockSize[0] = numberOfByteRead;
        if (!SktScanErrors.SKTSUCCESS(Result) || !this.m_bReadPending) {
            return Result;
        }
        return 3;
    }

    public long WriteBlock(char[] data, int nBlockSize, int[] nBlockSizeWritten) {
        long Result = 0;
        if (!this._bluetoothHelper.isOpen()) {
            Result = -31;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && (data == null || nBlockSizeWritten == null)) {
            Result = -18;
        }
        this.m_bWritePending = this._bluetoothHelper.isWriteBlockPending();
        if (!this.m_bWritePending) {
            if (SktScanErrors.SKTSUCCESS(Result)) {
                SktDebug.DBGSKT_DUMPBYTE(129, "->", data, nBlockSize);
                this._writeBuffer.write(data);
                long status = this._bluetoothHelper.writeBlock(this._writeBuffer);
                if (!BluetoothHelper.Errors.IsSuccess(status)) {
                    SktDebug.DBGSKT_MSG(4, "Unable to write in the Serial port:" + status);
                    Result = -33;
                } else if (status == 1) {
                    this.m_bWritePending = true;
                    Result = 3;
                }
            }
        } else if (this.m_bWritePending) {
            Result = 3;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            nBlockSizeWritten[0] = this._writeBuffer.getAvailableSize();
        }
        return Result;
    }

    public long IoControl(int nIoControl, Object pDataIn, int nDataInSize, Object pDataOut, int[] nDataOutSize) {
        long Result = 0;
        if (!this._bluetoothHelper.isOpen()) {
            Result = -31;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        switch (nIoControl) {
            case 1:
                if (pDataOut == null || nDataOutSize == null) {
                    Result = SktDebug.DBGSKT_EVAL(-18, "SktScanErrors.ESKT_INVALIDPARAMETER");
                }
                if (!SktScanErrors.SKTSUCCESS(Result)) {
                    return Result;
                }
                if (this._bluetoothHelper.isConnected()) {
                    ((long[]) pDataOut)[0] = 128;
                    nDataOutSize[0] = 4;
                    return Result;
                }
                ((long[]) pDataOut)[0] = 0;
                nDataOutSize[0] = 4;
                return Result;
            default:
                return -15;
        }
    }

    public long ConfigureTimeouts(SktTransport.TSktTransportTimeouts Timeouts) {
        long Result = 0;
        if (!this._bluetoothHelper.isOpen()) {
            Result = -31;
        }
        if (SktScanErrors.SKTSUCCESS(Result) && Timeouts == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            this._bluetoothHelper.setReadTimeout(true, (int) Timeouts.ulReadTotalTimeoutConstant);
            this._bluetoothHelper.setReadTimeout(false, (int) Timeouts.ulReadIntervalTimeout);
        }
        return Result;
    }

    public long CopyReadBufferAndClean(Object Data, int nBlockSize, char[] pucReadBuffer, long ulNumberOfByteRead) {
        if (((long) nBlockSize) < ulNumberOfByteRead) {
            ulNumberOfByteRead = (long) nBlockSize;
        }
        Object Data2 = pucReadBuffer;
        int nBlockSize2 = (int) ulNumberOfByteRead;
        char[] pucReadBuffer2 = "".toCharArray();
        return 0;
    }

    public static boolean Test() {
        return true;
    }
}
