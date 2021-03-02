package com.SocketMobile.Bluetooth;

public class BluetoothDataCore implements BluetoothData {
    private int _allocatedSize;
    private int _availableOffset;
    private char[] _buffer;
    private int _readOffset;

    BluetoothDataCore() {
        this._buffer = null;
        this._allocatedSize = 0;
        this._availableOffset = 0;
        this._readOffset = 0;
        this._buffer = null;
    }

    public long allocate(int size) {
        if (size > this._allocatedSize) {
            char[] temp = new char[size];
            for (int i = 0; i < this._availableOffset; i++) {
                temp[i] = this._buffer[i];
            }
            this._buffer = temp;
        }
        this._allocatedSize = size;
        return 0;
    }

    public long read(char[] data, int offset, int readSize) {
        long result = 0;
        if (this._readOffset + readSize > this._availableOffset) {
            readSize = this._availableOffset - this._readOffset;
        }
        try {
            System.arraycopy(this._buffer, this._readOffset, data, offset, readSize);
        } catch (IndexOutOfBoundsException e) {
            result = -6;
        } catch (ArrayStoreException e2) {
            result = -7;
        } catch (NullPointerException e3) {
            result = -7;
        }
        this._readOffset += readSize;
        if (this._readOffset >= this._availableOffset) {
            this._availableOffset = 0;
            this._readOffset = 0;
        }
        return result;
    }

    public long write(char[] data) {
        long result = 0;
        if (data.length > this._allocatedSize - this._availableOffset) {
            result = allocate(data.length + this._availableOffset);
        }
        try {
            System.arraycopy(data, 0, this._buffer, this._availableOffset, data.length);
        } catch (IndexOutOfBoundsException e) {
            result = -6;
        } catch (ArrayStoreException e2) {
            result = -7;
        } catch (NullPointerException e3) {
            result = -7;
        }
        this._availableOffset += data.length;
        return result;
    }

    public long read(byte[] data) {
        int readSize = data.length;
        if (this._readOffset + readSize > this._availableOffset) {
            readSize = this._availableOffset - this._readOffset;
        }
        int i = 0;
        while (i < readSize) {
            data[i] = (byte) this._buffer[this._readOffset + i];
            i++;
        }
        this._readOffset += i;
        if (this._readOffset != this._availableOffset) {
            return 0;
        }
        this._availableOffset = 0;
        this._readOffset = 0;
        return 0;
    }

    public long write(byte[] data) {
        long result = 0;
        if (data.length > this._allocatedSize - this._availableOffset) {
            result = allocate(data.length + this._availableOffset);
        }
        int i = 0;
        while (i < data.length) {
            this._buffer[this._availableOffset + i] = (char) (data[i] & 255);
            i++;
        }
        this._availableOffset += i;
        return result;
    }

    public long write(byte[] data, int startOffset, int size) {
        long result = 0;
        if (size > this._allocatedSize - this._availableOffset) {
            result = allocate(this._availableOffset + size);
        }
        int i = 0;
        while (i < size) {
            this._buffer[this._availableOffset + i] = (char) (data[startOffset + i] & 255);
            i++;
        }
        this._availableOffset += i;
        return result;
    }

    public int getAvailableSize() {
        return this._allocatedSize - this._availableOffset;
    }

    public int getSize() {
        return this._availableOffset - this._readOffset;
    }

    public int getTotalSize() {
        return this._allocatedSize;
    }
}
