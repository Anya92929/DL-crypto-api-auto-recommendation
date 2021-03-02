package com.SocketMobile.ScanAPI;

public final class SktScan {

    public static class helper {
        public static int SKTRETRIEVEID(int propId) {
            return (propId >> 0) & 255;
        }

        public static int SKTRETRIEVESETTYPE(int propId) {
            return (propId >> 16) & 15;
        }

        public static int SKTRETRIEVEGETTYPE(int propId) {
            return (propId >> 20) & 15;
        }

        public static int SKTRETRIEVEGROUPID(int propId) {
            return (propId >> 8) & 15;
        }

        public static final int SKTISSCANAPI(int propId) {
            return propId >> 31;
        }

        public static final int SKTDATACONFIRMATION(int reserved, int rumble, int beep, int led) {
            return (reserved << 6) | (rumble << 4) | (beep << 2) | led;
        }

        public static final int SKTDATACONFIRMATION_LED(long dataConfirmation) {
            return (int) (3 & dataConfirmation);
        }

        public static final int SKTDATACONFIRMATION_BEEP(long dataConfirmation) {
            return (int) ((dataConfirmation >> 2) & 3);
        }

        public static final int SKTDATACONFIRMATION_RUMBLE(long dataConfirmation) {
            return (int) ((dataConfirmation >> 4) & 3);
        }

        public static final boolean SKTBUTTON_ISLEFTPRESSED(int buttonsStatus) {
            return (buttonsStatus & 1) == 1;
        }

        public static final boolean SKTBUTTON_ISRIGHTPRESSED(int buttonsStatus) {
            return (buttonsStatus & 2) == 2;
        }

        public static final boolean SKTBUTTON_ISMIDDLEPRESSED(int buttonsStatus) {
            return (buttonsStatus & 4) == 4;
        }

        public static final boolean SKTBUTTON_ISPOWERPRESSED(int buttonsStatus) {
            return (buttonsStatus & 8) == 8;
        }

        public static final boolean SKTBUTTON_ISRINGDETACHED(int buttonsStatus) {
            return (buttonsStatus & 8) == 8;
        }

        public static final int SKTBUTTON_LEFTPRESSED(int pressed) {
            return pressed & 1;
        }

        public static final int SKTBUTTON_RIGHTPRESSED(int pressed) {
            return (pressed << 1) & 2;
        }

        public static final int SKTBUTTON_MIDDLEPRESSED(int pressed) {
            return (pressed << 2) & 4;
        }

        public static final int SKTBUTTON_POWERPRESSED(int pressed) {
            return (pressed << 3) & 8;
        }

        public static final int SKTBUTTON_RINGDETACHED(int detached) {
            return (detached << 4) & 16;
        }

        public static final int SKTPOWER_GETSTATE(int powerStatus) {
            return powerStatus & 255;
        }

        public static final int SKTBATTERY_GETMINLEVEL(long powerStatus) {
            return ((int) (powerStatus >> 16)) & 255;
        }

        public static final int SKTBATTERY_GETMAXLEVEL(long powerStatus) {
            return (int) (powerStatus >> 24);
        }

        public static final int SKTBATTERY_GETCURLEVEL(long powerStatus) {
            return ((int) (powerStatus >> 8)) & 255;
        }

        public static final int SKTPOWER_SETSTATE(int powerStatus) {
            return powerStatus & 255;
        }

        public static final int SKTBATTERY_SETMINLEVEL(int powerStatus) {
            return (powerStatus & 255) << 16;
        }

        public static final int SKTBATTERY_SETMAXLEVEL(int powerStatus) {
            return (powerStatus & 255) << 24;
        }

        public static final int SKTBATTERY_SETCURLEVEL(int powerStatus) {
            return (powerStatus & 255) << 8;
        }

        public static String formatBluetoothAddress(char[] bluetoothAddress, boolean semiColon) {
            StringBuffer szBdAddress = new StringBuffer();
            int max = bluetoothAddress.length;
            for (int i = 0; i < max; i++) {
                if (bluetoothAddress[i] < 16) {
                    szBdAddress.append("0" + Integer.toHexString(bluetoothAddress[i]));
                } else {
                    szBdAddress.append(Integer.toHexString(bluetoothAddress[i]));
                }
                if (semiColon && i < max - 1) {
                    szBdAddress.append(':');
                }
            }
            return szBdAddress.toString();
        }
    }
}
