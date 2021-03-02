package com.SocketMobile.Bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.util.Log;
import com.SocketMobile.Bluetooth.BluetoothHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class BluetoothHelperCore implements BluetoothHelper {
    /* access modifiers changed from: private */
    public static final UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String TAG = "BluetoothHelper";
    private static BluetoothAdapter _generalBluetoothAdapter;
    private final int ANDROID_LEVEL_INSECURE_CONNECTION = 10;
    private AcceptThread _acceptThread;
    private boolean _closeInProgress;
    private CommunicationThread _communicationThread;
    private boolean _deviceConnected = false;
    private String _mode;
    private String _name;
    private boolean _openDone;
    /* access modifiers changed from: private */
    public BluetoothData _readBlock = null;
    /* access modifiers changed from: private */
    public BluetoothHelper.EventComplete _readCompleteEvent = null;
    /* access modifiers changed from: private */
    public int _readIntervalTimeout = 200;
    /* access modifiers changed from: private */
    public boolean _readPending = false;
    /* access modifiers changed from: private */
    public Timer _readTimer = null;
    private boolean _readTimerStarted = false;
    private int _readTotalTimeout = BluetoothHelper.kDefaultReadTotalTimeout;
    /* access modifiers changed from: private */
    public DataBuffer _recdb = new DataBuffer();
    private int _recdbReadOffset = 0;
    /* access modifiers changed from: private */
    public byte[] _receiveBuffer = new byte[1024];
    /* access modifiers changed from: private */
    public DataBuffer _sentdb = new DataBuffer();
    private ServerSocket _serverSocket;
    private Object _syncReadTimer = new Object();
    /* access modifiers changed from: private */
    public BluetoothHelper.EventComplete _writeCompleteEvent = null;
    /* access modifiers changed from: private */
    public boolean _writePending = false;
    private final int kReceiveBufferSize = 1024;

    static class Debug {
        public static final int kLevelError = 4;
        public static final int kLevelTrace = 1;
        public static final int kLevelTraceTimer = 2;
        public static final int kLevelWarning = 3;

        Debug() {
        }

        public static void Msg(int level, String text) {
            if (level != 1 && level != 2) {
                String text2 = "threadId-" + Thread.currentThread().getId() + ":" + text;
                if (level == 1) {
                    Log.i(BluetoothHelperCore.TAG, text2);
                } else if (level == 3) {
                    Log.w(BluetoothHelperCore.TAG, text2);
                } else if (level == 4) {
                    Log.e(BluetoothHelperCore.TAG, text2);
                } else {
                    Log.v(BluetoothHelperCore.TAG, text2);
                }
            }
        }
    }

    class DataBuffer {
        private int _availableSize = 1024;
        private byte[] _dataArray = new byte[1024];
        private final int _maxLength = 1024;
        private int _readPosition = 0;
        private int _writePosition = 0;

        public DataBuffer() {
        }

        public int getAvailableSize() {
            return this._availableSize;
        }

        public int getLength() {
            return this._writePosition - this._readPosition;
        }

        public byte[] getArray(int length) {
            this._readPosition += length;
            return this._dataArray;
        }

        public int getArrayStart() {
            return 0;
        }

        public void write(byte[] buffer, int offset, int count) {
            if (buffer != null) {
                int max = count;
                if (this._writePosition + max > 1024) {
                    max = 1024 - this._writePosition;
                }
                for (int i = 0; i < max; i++) {
                    this._dataArray[this._writePosition + i] = buffer[offset + i];
                }
                this._writePosition += max;
                this._availableSize = 1024 - this._writePosition;
            }
        }

        public void write(byte[] buffer) {
            if (buffer != null) {
                if (this._writePosition + buffer.length > 1024) {
                    int max = 1024 - this._writePosition;
                }
                for (int i = 0; i < buffer.length; i++) {
                    this._dataArray[this._writePosition + i] = buffer[i];
                }
                this._writePosition += buffer.length;
                this._availableSize = 1024 - this._writePosition;
            }
        }

        public void reset() {
            this._availableSize = 1024;
            this._writePosition = 0;
            this._readPosition = 0;
            for (int i = 0; i < 1024; i++) {
                this._dataArray[i] = 0;
            }
        }
    }

    private class ServerSocket {
        private BluetoothAdapter _bluetoothAdapter;
        private boolean _canceled = false;
        private BluetoothServerSocket _internalServerSocket;
        private String _serverName;

        public ServerSocket(BluetoothAdapter bluetoothAdapter, String name) {
            this._bluetoothAdapter = bluetoothAdapter;
            this._serverName = name;
            this._internalServerSocket = null;
        }

        public void setName(String name) {
            this._serverName = name;
        }

        public long startServer() {
            this._canceled = false;
            try {
                if (this._internalServerSocket == null) {
                    Debug.Msg(1, "About to register SDP and listener on SPP");
                    if (Build.VERSION.SDK_INT >= 10) {
                        Debug.Msg(1, "register SDP and listener on SPP in INSECURE MODE");
                        this._internalServerSocket = this._bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(this._serverName, BluetoothHelperCore.SPP_UUID);
                    } else {
                        this._internalServerSocket = this._bluetoothAdapter.listenUsingRfcommWithServiceRecord(this._serverName, BluetoothHelperCore.SPP_UUID);
                    }
                    Debug.Msg(1, "Done registering SDP and listener on SPP: " + this._internalServerSocket);
                    return 0;
                }
                Debug.Msg(1, "The SDP Record already created listening on SPP: " + this._internalServerSocket);
                return 0;
            } catch (Exception e) {
                Debug.Msg(4, "listen() failed " + e.getMessage());
                return -1;
            }
        }

        public BluetoothSocket accept() throws IOException {
            try {
                if (this._internalServerSocket != null) {
                    return this._internalServerSocket.accept();
                }
                return null;
            } catch (IOException e) {
                if (!this._canceled && this._internalServerSocket != null) {
                    this._internalServerSocket.close();
                    this._internalServerSocket = null;
                }
                throw e;
            }
        }

        public void stopServer() {
            String str;
            this._canceled = true;
            Debug.Msg(1, "About to stop the Server Socket");
            if (this._internalServerSocket != null) {
                try {
                    Debug.Msg(1, "About to close the Server Socket");
                    this._internalServerSocket.close();
                    Debug.Msg(1, "###########  Done closing the Server Socket #########");
                } catch (IOException e) {
                    Debug.Msg(4, "Closing the Server Socket Exception :" + e.getMessage());
                } finally {
                    str = "Closing the Server Socket Exception in finally";
                    Debug.Msg(4, str);
                    this._internalServerSocket = null;
                }
                this._internalServerSocket = null;
            }
            Debug.Msg(1, "Done stopping the Server Socket");
        }

        /* access modifiers changed from: package-private */
        public boolean isCanceled() {
            return this._canceled;
        }
    }

    public long initialize() {
        Debug.Msg(1, "About to initialize Bluetooth");
        return 0;
    }

    public long deinitialize() {
        Debug.Msg(1, "About to deinitialize Bluetooth in " + this._mode + " mode with name " + this._name);
        if (this._serverSocket != null) {
            this._serverSocket.stopServer();
        }
        this._serverSocket = null;
        _generalBluetoothAdapter = null;
        return 0;
    }

    public long open(String mode, String name) {
        long result = 0;
        close();
        this._closeInProgress = false;
        if (_generalBluetoothAdapter == null) {
            _generalBluetoothAdapter = getDefaultBluetoothAdapter();
        }
        Debug.Msg(1, "About to open Bluetooth in " + mode + " mode with name " + name);
        if (mode.equalsIgnoreCase("Server")) {
            this._mode = "Server";
            this._name = name;
            Debug.Msg(1, "Check if the server Socket is null");
            if (this._serverSocket == null) {
                Debug.Msg(1, "The server Socket is null, then create a new Server Socket");
                this._serverSocket = new ServerSocket(_generalBluetoothAdapter, name);
                Debug.Msg(1, "The server Socket is created, then start the Server Socket");
            } else {
                this._serverSocket.setName(name);
            }
            result = this._serverSocket.startServer();
            Debug.Msg(1, "The server Socket is started");
            if (BluetoothHelper.Errors.IsSuccess(result)) {
                Debug.Msg(1, "Check if the accept Thread is null");
                if (this._acceptThread == null) {
                    Debug.Msg(1, "The accept Thread is null then create Accept Thread");
                    this._acceptThread = new AcceptThread();
                    Debug.Msg(1, "The accept Thread is started");
                    this._acceptThread.setServerSocket(this._serverSocket);
                }
                Debug.Msg(1, "The accept Thread is about to be started");
                this._acceptThread.start();
                this._openDone = true;
                Debug.Msg(1, "The accept Thread is started then create a read timer");
                this._readTimer = new Timer();
                Debug.Msg(1, "The read timer is created");
            }
        } else {
            Set<BluetoothDevice> pairedDevices = _generalBluetoothAdapter.getBondedDevices();
            if (pairedDevices != null && pairedDevices.size() > 0) {
                Iterator i$ = pairedDevices.iterator();
                while (true) {
                    if (!i$.hasNext()) {
                        break;
                    }
                    BluetoothDevice device = i$.next();
                    String devicename = device.getName();
                    if (devicename != null && devicename.equalsIgnoreCase(name)) {
                        this._mode = "Client";
                        this._name = name;
                        result = ConnectToDevice(device);
                        this._openDone = BluetoothHelper.Errors.IsSuccess(result);
                        if (this._openDone) {
                            this._readTimer = new Timer();
                        }
                    }
                }
            }
        }
        if (!BluetoothHelper.Errors.IsSuccess(result) || this._openDone) {
            return result;
        }
        return -1;
    }

    public long close() {
        Debug.Msg(1, "Close the Bluetooth port");
        this._closeInProgress = true;
        if (this._communicationThread != null) {
            this._communicationThread.cancel();
            this._communicationThread = null;
        }
        if (this._acceptThread != null) {
            this._acceptThread.cancel();
            this._acceptThread = null;
        }
        this._openDone = false;
        this._deviceConnected = false;
        this._writePending = false;
        this._readPending = false;
        if (this._readTimer != null) {
            this._readTimer.cancel();
        }
        this._readTimer = null;
        return 0;
    }

    public long readBlock(BluetoothData block) {
        long result = CheckIfOpenAndConnected();
        if (BluetoothHelper.Errors.IsSuccess(result)) {
            synchronized (this._recdb) {
                if (!this._readPending) {
                    if (this._readCompleteEvent != null) {
                        this._readCompleteEvent.reset();
                    }
                    Debug.Msg(2, "Data To read, about to enter critical section");
                    CopyReceiveBufferToBlock(block);
                    if (block.getAvailableSize() > 0) {
                        this._readPending = true;
                        if (block.getSize() == 0) {
                            StartReadTimer((long) this._readTotalTimeout);
                        } else {
                            StartReadTimer((long) this._readIntervalTimeout);
                        }
                    }
                    if (this._readPending) {
                        result = 1;
                    } else {
                        Debug.Msg(1, "Read completed");
                        if (this._readCompleteEvent != null) {
                            this._readCompleteEvent.setComplete();
                        }
                    }
                    Debug.Msg(2, "Data To read, about to leave critical section");
                } else {
                    result = 1;
                }
            }
        }
        return result;
    }

    public long writeBlock(BluetoothData block) {
        long result = CheckIfOpenAndConnected();
        if (BluetoothHelper.Errors.IsSuccess(result)) {
            synchronized (this._sentdb) {
                int length = block.getSize();
                if (length > 0) {
                    byte[] writeData = new byte[length];
                    long result2 = block.read(writeData);
                    this._sentdb.write(writeData);
                    if (!this._writePending) {
                        if (this._writeCompleteEvent != null) {
                            this._writeCompleteEvent.reset();
                        }
                        this._communicationThread.write();
                    }
                    result = 1;
                }
            }
        }
        return result;
    }

    public boolean isOpen() {
        return this._openDone;
    }

    public boolean isConnected() {
        return this._deviceConnected;
    }

    public boolean isReadBlockPending() {
        return this._readPending;
    }

    public boolean isWriteBlockPending() {
        return this._writePending;
    }

    public void setReadTimeout(boolean total, int readTimeout) {
        if (total) {
            this._readTotalTimeout = readTimeout;
        } else {
            this._readIntervalTimeout = readTimeout;
        }
    }

    public void setReadCompleteEvent(BluetoothHelper.EventComplete event) {
        this._readCompleteEvent = event;
    }

    public void setWriteCompleteEvent(BluetoothHelper.EventComplete event) {
        this._writeCompleteEvent = event;
    }

    /* access modifiers changed from: private */
    public int CopyReceiveBufferToBlock(BluetoothData block) {
        int size = block.getAvailableSize();
        boolean reset = false;
        synchronized (this._recdb) {
            if (size > this._recdb.getLength()) {
                size = this._recdb.getLength();
                this._readBlock = block;
                reset = true;
            }
            if (size > 0) {
                block.write(this._recdb.getArray(size), this._recdbReadOffset + this._recdb.getArrayStart(), size);
                if (reset) {
                    Debug.Msg(1, "Entire buffer has been read " + size + " bytes");
                    this._recdb.reset();
                    this._recdbReadOffset = 0;
                } else {
                    this._recdbReadOffset += size;
                    Debug.Msg(1, "Only " + size + " bytes has been read, remaining " + this._recdb.getLength() + " bytes");
                }
            }
        }
        return size;
    }

    private long CheckIfOpenAndConnected() {
        if (!this._deviceConnected) {
            return -4;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void StartReadTimer(long delay) {
        StopReadTimer();
        synchronized (this._syncReadTimer) {
            try {
                this._readTimer.schedule(new TimerTask() {
                    public void run() {
                        synchronized (BluetoothHelperCore.this._readTimer) {
                            Debug.Msg(2, "Read timer occuring");
                            boolean unused = BluetoothHelperCore.this.StopReadTimer();
                            synchronized (BluetoothHelperCore.this._recdb) {
                                boolean unused2 = BluetoothHelperCore.this._readPending = false;
                                Debug.Msg(2, "Read completed");
                                if (BluetoothHelperCore.this._readCompleteEvent != null) {
                                    BluetoothHelperCore.this._readCompleteEvent.setComplete();
                                }
                            }
                        }
                    }
                }, delay);
                Debug.Msg(2, "Read timer started for " + delay + "ms");
                this._readTimerStarted = true;
            } catch (Exception e) {
                Debug.Msg(4, "Unable to start a timer: " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean StopReadTimer() {
        boolean stopped = false;
        synchronized (this._syncReadTimer) {
            if (this._readTimerStarted) {
                Debug.Msg(2, "Stop the read timer");
                try {
                    this._readTimer.cancel();
                    stopped = true;
                } catch (Exception e) {
                    Debug.Msg(4, "Exception trying to cancel the timer in the time fct: " + e.getMessage());
                }
                this._readTimer = new Timer();
            }
            this._readTimerStarted = false;
        }
        return stopped;
    }

    public String getName() {
        return this._name;
    }

    public String getMode() {
        return this._mode;
    }

    private static synchronized BluetoothAdapter getDefaultBluetoothAdapter() {
        BluetoothAdapter bluetoothAdapter;
        synchronized (BluetoothHelperCore.class) {
            _generalBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter = _generalBluetoothAdapter;
        }
        return bluetoothAdapter;
    }

    public synchronized long connect(BluetoothSocket socket, BluetoothDevice device) {
        long result;
        result = 0;
        this._deviceConnected = true;
        try {
            this._communicationThread = new CommunicationThread(socket);
            this._communicationThread.start();
        } catch (IOException e) {
            Debug.Msg(4, "Unable to connect: " + e.getMessage());
            result = -1;
        }
        return result;
    }

    /* access modifiers changed from: private */
    public synchronized void connectionLost() {
        this._deviceConnected = false;
        Debug.Msg(3, "Connection is lost");
        if (this._mode.equalsIgnoreCase("Server")) {
            if (this._serverSocket == null || this._closeInProgress) {
                Debug.Msg(1, "Don't listen again on Bluetooth as it has been deinitialized");
            } else {
                Debug.Msg(1, "Listen on Bluetooth for next connection");
                if (BluetoothHelper.Errors.IsSuccess(this._serverSocket.startServer())) {
                    this._acceptThread = new AcceptThread();
                    this._acceptThread.setServerSocket(this._serverSocket);
                    this._acceptThread.start();
                    Debug.Msg(1, "Bluetooth ready for next connection");
                    this._openDone = true;
                } else {
                    Debug.Msg(1, "Cannot start the socket server, is Bluetooth OFF??");
                    this._openDone = false;
                }
            }
        }
    }

    private class AcceptThread extends Thread {
        private boolean _continueListening = true;
        private ServerSocket _serverSocket;

        public AcceptThread() {
        }

        public void setServerSocket(ServerSocket serverSocket) {
            this._serverSocket = serverSocket;
            if (this._serverSocket == null) {
                Debug.Msg(3, "AcceptThread: SERVER SOCKET IS NULL!!!");
            }
        }

        public void run() {
            setName("AcceptThread");
            BluetoothSocket socket = null;
            while (this._continueListening) {
                try {
                    Debug.Msg(1, "About to call server Socket accept method: " + this._serverSocket);
                    socket = this._serverSocket.accept();
                } catch (IOException e) {
                    if (this._continueListening && !this._serverSocket.isCanceled() && !BluetoothHelper.Errors.IsSuccess(this._serverSocket.startServer())) {
                        BluetoothHelperCore.this.connectionLost();
                        this._continueListening = false;
                        Debug.Msg(1, "Done with the Accept thread because it failed to start the server");
                        this._serverSocket.stopServer();
                    }
                }
                Debug.Msg(1, "done with server Socket accept and socket=" + socket);
                if (socket != null) {
                    if (BluetoothHelper.Errors.IsSuccess(BluetoothHelperCore.this.connect(socket, socket.getRemoteDevice()))) {
                        this._continueListening = false;
                        Debug.Msg(1, "Done with the Accept thread");
                        this._serverSocket.stopServer();
                    }
                } else if (this._serverSocket.isCanceled()) {
                    this._continueListening = false;
                }
            }
            Debug.Msg(1, "Accept thread terminated");
        }

        public void cancel() {
            Debug.Msg(1, "Stop the Accept Thread");
            this._continueListening = false;
            this._serverSocket.stopServer();
            int count = 20;
            Debug.Msg(1, "Wait for the Accept Thread to die");
            while (isAlive() && count > 0) {
                try {
                    Thread.sleep(100);
                    count--;
                } catch (InterruptedException e) {
                    Debug.Msg(4, "Couldn't make the thread sleep:" + e.getMessage());
                }
            }
            Debug.Msg(1, "Done waiting for the Accept thread");
        }
    }

    private long ConnectToDevice(BluetoothDevice device) {
        long result = 0;
        BluetoothSocket tmp = null;
        try {
            if (Build.VERSION.SDK_INT >= 10) {
                Debug.Msg(1, "connect in INSECURE MODE");
                tmp = device.createInsecureRfcommSocketToServiceRecord(SPP_UUID);
            } else {
                tmp = device.createRfcommSocketToServiceRecord(SPP_UUID);
            }
        } catch (IOException e) {
            Debug.Msg(4, "create() failed " + e.getMessage());
            result = -1;
        }
        BluetoothSocket socket = tmp;
        try {
            socket.connect();
        } catch (IOException e2) {
            Debug.Msg(4, "Unable to connect device " + e2.getMessage());
            try {
                socket.close();
            } catch (IOException e22) {
                Debug.Msg(4, "unable to close() socket during connection failure " + e22.getMessage());
            }
            result = -1;
        }
        if (!BluetoothHelper.Errors.IsSuccess(result)) {
            return result;
        }
        Debug.Msg(1, "Start the ConnectThread");
        return connect(socket, device);
    }

    private class CommunicationThread extends Thread {
        private InputStream _inStream;
        private OutputStream _outStream;
        private BluetoothSocket _socket;

        public CommunicationThread(BluetoothSocket socket) throws IOException {
            Debug.Msg(1, "create ConnectedThread");
            this._socket = socket;
            try {
                InputStream tmpIn = socket.getInputStream();
                OutputStream tmpOut = socket.getOutputStream();
                this._inStream = tmpIn;
                this._outStream = tmpOut;
            } catch (IOException e) {
                Debug.Msg(4, "temp sockets not created " + e.getMessage());
                throw e;
            }
        }

        public void run() {
            Debug.Msg(1, "Start mConnectedThread");
            while (true) {
                int maxLength = 1024;
                try {
                    synchronized (BluetoothHelperCore.this._recdb) {
                        if (1024 > BluetoothHelperCore.this._recdb.getAvailableSize()) {
                            maxLength = BluetoothHelperCore.this._recdb.getAvailableSize();
                        }
                        Debug.Msg(1, "Try to read " + maxLength + " bytes from the Bluetooth stream");
                    }
                    if (maxLength == 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Debug.Msg(4, "Exception during communication thread: " + e.getMessage());
                        }
                    } else {
                        int len = this._inStream.read(BluetoothHelperCore.this._receiveBuffer, 0, maxLength);
                        synchronized (BluetoothHelperCore.this._recdb) {
                            Debug.Msg(1, "Size read from the Bluetooth stream: " + len);
                            boolean restartTimer = BluetoothHelperCore.this.StopReadTimer();
                            BluetoothHelperCore.this._recdb.write(BluetoothHelperCore.this._receiveBuffer, 0, len);
                            if (BluetoothHelperCore.this._readPending) {
                                Debug.Msg(1, "A Read is pending so fill in the user buffer");
                                int unused = BluetoothHelperCore.this.CopyReceiveBufferToBlock(BluetoothHelperCore.this._readBlock);
                                Debug.Msg(1, "The user buffer has " + BluetoothHelperCore.this._readBlock.getAvailableSize() + " bytes available left");
                                if (BluetoothHelperCore.this._readBlock.getAvailableSize() <= 0) {
                                    Debug.Msg(1, "No more byte available in the user buffer so Read completed");
                                    boolean unused2 = BluetoothHelperCore.this._readPending = false;
                                    if (BluetoothHelperCore.this._readCompleteEvent != null) {
                                        BluetoothHelperCore.this._readCompleteEvent.setComplete();
                                    }
                                } else if (restartTimer) {
                                    BluetoothHelperCore.this.StartReadTimer((long) BluetoothHelperCore.this._readIntervalTimeout);
                                }
                            }
                        }
                    }
                } catch (IOException e2) {
                    Debug.Msg(4, "disconnected: " + e2.getMessage());
                    closeStreamAndConnection();
                    BluetoothHelperCore.this.connectionLost();
                } catch (NullPointerException e3) {
                    Debug.Msg(4, "null pointer, disconnected: " + e3.getMessage());
                    closeStreamAndConnection();
                    BluetoothHelperCore.this.connectionLost();
                }
            }
            while (true) {
            }
            Debug.Msg(1, "mConnectedThread is Dead");
        }

        public void write() {
            synchronized (BluetoothHelperCore.this._sentdb) {
                int size = BluetoothHelperCore.this._sentdb.getLength();
                if (size > 0) {
                    try {
                        this._outStream.write(BluetoothHelperCore.this._sentdb.getArray(size), 0, size);
                        BluetoothHelperCore.this._sentdb.reset();
                        boolean unused = BluetoothHelperCore.this._writePending = false;
                    } catch (IOException e) {
                        Debug.Msg(4, "Exception during write " + e.getMessage());
                        boolean unused2 = BluetoothHelperCore.this._writePending = false;
                    }
                } else {
                    boolean unused3 = BluetoothHelperCore.this._writePending = false;
                }
                if (!BluetoothHelperCore.this._writePending) {
                    Debug.Msg(1, "Write completed");
                    if (BluetoothHelperCore.this._writeCompleteEvent != null) {
                        BluetoothHelperCore.this._writeCompleteEvent.setComplete();
                    }
                }
            }
        }

        public void cancel() {
            Debug.Msg(1, "About to close the connection");
            closeStreamAndConnection();
            int count = 20;
            Debug.Msg(1, "Wait for the Communication Thread to die");
            while (isAlive() && count > 0) {
                try {
                    Thread.sleep(100);
                    count--;
                } catch (InterruptedException e) {
                    Debug.Msg(4, "Couldn't make the communication thread sleep:" + e.getMessage());
                }
            }
            Debug.Msg(1, "Done waiting for the Communication thread");
        }

        private synchronized void closeStreamAndConnection() {
            try {
                if (this._inStream != null) {
                    this._inStream.close();
                }
            } catch (IOException e1) {
                Debug.Msg(4, "disconnected Exception during InStream close" + e1.getMessage());
                e1.printStackTrace();
            }
            try {
                if (this._outStream != null) {
                    this._outStream.close();
                }
            } catch (IOException e12) {
                Debug.Msg(4, "disconnected Exception during OutStream close" + e12.getMessage());
                e12.printStackTrace();
            }
            try {
                if (this._socket != null) {
                    this._socket.close();
                }
            } catch (IOException e13) {
                Debug.Msg(4, "disconnected Exception during Socket close" + e13.getMessage());
                e13.printStackTrace();
            }
            this._inStream = null;
            this._outStream = null;
            this._socket = null;
            return;
        }
    }
}
