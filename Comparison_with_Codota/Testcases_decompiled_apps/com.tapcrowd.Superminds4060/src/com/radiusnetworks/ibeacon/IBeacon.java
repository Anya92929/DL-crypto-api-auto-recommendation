package com.radiusnetworks.ibeacon;

import android.support.p000v4.view.MotionEventCompat;
import android.util.Log;
import com.flurry.android.Constants;
import com.radiusnetworks.ibeacon.client.IBeaconDataFactory;
import com.radiusnetworks.ibeacon.client.NullIBeaconDataFactory;

public class IBeacon {
    public static final int PROXIMITY_FAR = 3;
    public static final int PROXIMITY_IMMEDIATE = 1;
    public static final int PROXIMITY_NEAR = 2;
    public static final int PROXIMITY_UNKNOWN = 0;
    private static final String TAG = "IBeacon";
    private static final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static IBeaconDataFactory iBeaconDataFactory = new NullIBeaconDataFactory();
    protected Double accuracy;
    protected int major;
    protected int minor;
    protected Integer proximity;
    protected String proximityUuid;
    protected int rssi;
    protected Double runningAverageRssi = null;
    protected int txPower;

    public double getAccuracy() {
        if (this.accuracy == null) {
            this.accuracy = Double.valueOf(calculateAccuracy(this.txPower, this.runningAverageRssi != null ? this.runningAverageRssi.doubleValue() : (double) this.rssi));
        }
        return this.accuracy.doubleValue();
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getProximity() {
        if (this.proximity == null) {
            this.proximity = Integer.valueOf(calculateProximity(getAccuracy()));
        }
        return this.proximity.intValue();
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getTxPower() {
        return this.txPower;
    }

    public String getProximityUuid() {
        return this.proximityUuid;
    }

    public int hashCode() {
        return this.minor;
    }

    public boolean equals(Object that) {
        if (!(that instanceof IBeacon)) {
            return false;
        }
        IBeacon thatIBeacon = (IBeacon) that;
        if (thatIBeacon.getMajor() == getMajor() && thatIBeacon.getMinor() == getMinor() && thatIBeacon.getProximityUuid().equals(getProximityUuid())) {
            return true;
        }
        return false;
    }

    public static IBeacon fromScanData(byte[] scanData, int rssi2) {
        int startByte = 2;
        boolean patternFound = false;
        while (true) {
            if (startByte <= 5) {
                if ((scanData[startByte + 2] & Constants.UNKNOWN) == 2 && (scanData[startByte + 3] & Constants.UNKNOWN) == 21) {
                    patternFound = true;
                    break;
                } else if ((scanData[startByte] & Constants.UNKNOWN) == 45 && (scanData[startByte + 1] & Constants.UNKNOWN) == 36 && (scanData[startByte + 2] & Constants.UNKNOWN) == 191 && (scanData[startByte + 3] & Constants.UNKNOWN) == 22) {
                    if (IBeaconManager.LOG_DEBUG) {
                        Log.d(TAG, "This is a proprietary Estimote beacon advertisement that does not meet the iBeacon standard.  Identifiers cannot be read.");
                    }
                    IBeacon iBeacon = new IBeacon();
                    iBeacon.major = 0;
                    iBeacon.minor = 0;
                    iBeacon.proximityUuid = "00000000-0000-0000-0000-000000000000";
                    iBeacon.txPower = -55;
                    return iBeacon;
                } else if ((scanData[startByte] & Constants.UNKNOWN) == 173 && (scanData[startByte + 1] & Constants.UNKNOWN) == 119 && (scanData[startByte + 2] & Constants.UNKNOWN) == 0 && (scanData[startByte + 3] & Constants.UNKNOWN) == 198) {
                    if (IBeaconManager.LOG_DEBUG) {
                        Log.d(TAG, "This is a proprietary Gimbal beacon advertisement that does not meet the iBeacon standard.  Identifiers cannot be read.");
                    }
                    IBeacon iBeacon2 = new IBeacon();
                    iBeacon2.major = 0;
                    iBeacon2.minor = 0;
                    iBeacon2.proximityUuid = "00000000-0000-0000-0000-000000000000";
                    iBeacon2.txPower = -55;
                    return iBeacon2;
                } else {
                    startByte++;
                }
            } else {
                break;
            }
        }
        if (!patternFound) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "This is not an iBeacon advertisment (no 4c000215 seen in bytes 2-5).  The bytes I see are: " + bytesToHex(scanData));
            }
            return null;
        }
        IBeacon iBeacon3 = new IBeacon();
        iBeacon3.major = ((scanData[startByte + 20] & Constants.UNKNOWN) * Constants.FEMALE) + (scanData[startByte + 21] & Constants.UNKNOWN);
        iBeacon3.minor = ((scanData[startByte + 22] & Constants.UNKNOWN) * Constants.FEMALE) + (scanData[startByte + 23] & Constants.UNKNOWN);
        iBeacon3.txPower = scanData[startByte + 24];
        iBeacon3.rssi = rssi2;
        byte[] proximityUuidBytes = new byte[16];
        System.arraycopy(scanData, startByte + 4, proximityUuidBytes, 0, 16);
        String hexString = bytesToHex(proximityUuidBytes);
        iBeacon3.proximityUuid = hexString.substring(0, 8) + "-" + hexString.substring(8, 12) + "-" + hexString.substring(12, 16) + "-" + hexString.substring(16, 20) + "-" + hexString.substring(20, 32);
        return iBeacon3;
    }

    public void requestData(IBeaconDataNotifier notifier) {
        iBeaconDataFactory.requestIBeaconData(this, notifier);
    }

    protected IBeacon(IBeacon otherIBeacon) {
        this.major = otherIBeacon.major;
        this.minor = otherIBeacon.minor;
        this.accuracy = otherIBeacon.accuracy;
        this.proximity = otherIBeacon.proximity;
        this.rssi = otherIBeacon.rssi;
        this.proximityUuid = otherIBeacon.proximityUuid;
        this.txPower = otherIBeacon.txPower;
    }

    protected IBeacon() {
    }

    protected IBeacon(String proximityUuid2, int major2, int minor2, int txPower2, int rssi2) {
        this.proximityUuid = proximityUuid2;
        this.major = major2;
        this.minor = minor2;
        this.rssi = rssi2;
        this.txPower = txPower2;
    }

    public IBeacon(String proximityUuid2, int major2, int minor2) {
        this.proximityUuid = proximityUuid2;
        this.major = major2;
        this.minor = minor2;
        this.rssi = this.rssi;
        this.txPower = -59;
        this.rssi = 0;
    }

    protected static double calculateAccuracy(int txPower2, double rssi2) {
        if (rssi2 == 0.0d) {
            return -1.0d;
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "calculating accuracy based on rssi of " + rssi2);
        }
        double ratio = (rssi2 * 1.0d) / ((double) txPower2);
        if (ratio < 1.0d) {
            return Math.pow(ratio, 10.0d);
        }
        double accuracy2 = (0.89976d * Math.pow(ratio, 7.7095d)) + 0.111d;
        if (!IBeaconManager.LOG_DEBUG) {
            return accuracy2;
        }
        Log.d(TAG, " avg rssi: " + rssi2 + " accuracy: " + accuracy2);
        return accuracy2;
    }

    protected static int calculateProximity(double accuracy2) {
        if (accuracy2 < 0.0d) {
            return 0;
        }
        if (accuracy2 < 0.5d) {
            return 1;
        }
        if (accuracy2 <= 4.0d) {
            return 2;
        }
        return 3;
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & MotionEventCompat.ACTION_MASK;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[(j * 2) + 1] = hexArray[v & 15];
        }
        return new String(hexChars);
    }
}
