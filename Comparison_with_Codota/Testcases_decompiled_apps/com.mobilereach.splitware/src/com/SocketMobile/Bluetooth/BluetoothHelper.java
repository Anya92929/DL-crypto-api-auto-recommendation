package com.SocketMobile.Bluetooth;

public interface BluetoothHelper {
    public static final int kDefaultReadTimeout = 200;
    public static final int kDefaultReadTotalTimeout = 2000;

    public interface EventComplete {
        void reset();

        void setComplete();
    }

    long close();

    long deinitialize();

    String getMode();

    String getName();

    long initialize();

    boolean isConnected();

    boolean isOpen();

    boolean isReadBlockPending();

    boolean isWriteBlockPending();

    long open(String str, String str2);

    long readBlock(BluetoothData bluetoothData);

    void setReadCompleteEvent(EventComplete eventComplete);

    void setReadTimeout(boolean z, int i);

    void setWriteCompleteEvent(EventComplete eventComplete);

    long writeBlock(BluetoothData bluetoothData);

    public static class Errors {
        public static final long INVALIDBUFFERSIZE = -6;
        public static final long INVALIDPARAMETER = -7;
        public static final long NODEVICEFOUND = -2;
        public static final long NOERROR = 0;
        public static final long NOTCONNECTED = -4;
        public static final long NOTOPEN = -3;
        public static final long NOTSUPPORTED = -5;
        public static final long PENDING = 1;
        public static final long UNABLEOPEN = -1;

        public static boolean IsSuccess(long result) {
            return result >= 0;
        }
    }
}
