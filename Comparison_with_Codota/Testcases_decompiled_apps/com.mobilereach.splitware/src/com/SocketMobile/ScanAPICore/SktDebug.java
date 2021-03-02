package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;
import com.SocketMobile.ScanAPICore.SktPlatform;

public class SktDebug {
    static final int DBGSKT_CORE = 16;
    static final int DBGSKT_COREE = 20;
    static final int DBGSKT_CORET = 17;
    static final int DBGSKT_COREW = 18;
    static final int DBGSKT_DEVICEINT = 256;
    static final int DBGSKT_DEVICEINTE = 260;
    static final int DBGSKT_DEVICEINTT = 257;
    static final int DBGSKT_DEVICEINTW = 258;
    static final int DBGSKT_LISTENER = 32;
    static final int DBGSKT_LISTENERE = 36;
    static final int DBGSKT_LISTENERT = 33;
    static final int DBGSKT_LISTENERW = 34;
    static final int DBGSKT_MAX_FILENAME_LENGTH = 32;
    static final int DBGSKT_MAX_LENGTH = 256;
    static final int DBGSKT_PROTOCOL = 64;
    static final int DBGSKT_PROTOCOLE = 68;
    static final int DBGSKT_PROTOCOLT = 65;
    static final int DBGSKT_PROTOCOLW = 66;
    static final int DBGSKT_RX = 512;
    static final int DBGSKT_RXE = 516;
    static final int DBGSKT_RXT = 513;
    static final int DBGSKT_RXW = 514;
    static final int DBGSKT_SERIAL = 128;
    static final int DBGSKT_SERIALE = 132;
    static final int DBGSKT_SERIALT = 129;
    static final int DBGSKT_SERIALW = 130;
    static final int DBGSKT_TX = 1024;
    static final int DBGSKT_TXE = 1028;
    static final int DBGSKT_TXT = 1025;
    static final int DBGSKT_TXW = 1026;
    static final int SKTDEBUG_FILE_LINE_LEVEL = 4;
    static final String SKTDEBUG_MODULE_NAME = "SktScanAPI";
    static int gSktDbgChannel = 1;
    static SktDebugExternal gSktDbgExternalTrace = null;
    static int gSktDbgFileLineLevel = -12;
    static int gSktDbgLevel = -9;
    static int gSktDbgLineCount = 0;
    static final String gszSktCarriageReturn = "\n";
    static final String gszSktError = "!!Error!! ";
    static final String gszSktLine = "(%d) ";
    static final String gszSktWarning = "Warning! ";

    public interface DBGSKT_CHANNEL {
        public static final int DBG_DEBUG_EXTERNAL = 8;
        public static final int DBG_DEBUG_FILE = 2;
        public static final int DBG_DEBUG_OUTPUT = 1;
        public static final int DBG_DEBUG_PORT = 4;
    }

    public interface DBGSKT_LEVEL {
        public static final int DBGSKT_ALWAYS = 8;
        public static final int DBGSKT_ERROR = 4;
        public static final int DBGSKT_MODULES = -16;
        public static final int DBGSKT_TRACE = 1;
        public static final int DBGSKT_WARNING = 2;
    }

    public interface SktDebugExternal {
        void Trace(String str);
    }

    public static final void DBGSKT_MSG(int level, String text) {
        SktDbgTrace(SKTDEBUG_MODULE_NAME, level, "", 0, text);
    }

    public static final long DBGSKT_SUCCESS(long Result, long Expression) {
        long Result2;
        do {
            Result2 = Expression;
            if (!SktScanErrors.SKTSUCCESS(Result2)) {
                DBGSKT_MSG(4, String.valueOf(Expression) + " returned " + String.valueOf(Result2) + "(0x" + Integer.toHexString((int) Result2) + ")");
            }
        } while (SktDbgReturn(false));
        return Result2;
    }

    public static final boolean DBGSKT_EXPECTING(long result, String expression, long expectingResult) {
        if (result == expectingResult) {
            return true;
        }
        DBGSKT_MSG(4, expression + " returned " + String.valueOf(result) + "(0x" + Integer.toHexString((int) result) + ")" + " instead of " + String.valueOf(expectingResult) + "(0x" + Integer.toHexString((int) expectingResult) + ")");
        return false;
    }

    public static final void DBGSKT_ENABLE(int level) {
        SktDbgEnable(level);
    }

    public static final void DBGSKT_DISABLE(int level) {
        SktDbgDisable(level);
    }

    public static final void DBGSKT_GETLEVEL(int[] level) {
        level[0] = SktDbgGetLevel();
    }

    public static final void DBGSKT_SETLEVEL(int level) {
        SktDbgSetLevel(level);
    }

    public static final void DBGSKT_GETCHANNEL(int[] channel) {
        channel[0] = SktDbgGetChannel();
    }

    public static final void DBGSKT_SETCHANNEL(int channel) {
        SktDbgSetChannel(channel);
    }

    public static final boolean DBGSKT_TEST() {
        return SktDbgTest();
    }

    public static final void DBGSKT_SETFILELINELEVEL(int level) {
        SktDbgSetFileLineLevel(level);
    }

    public static final void DBGSKT_GETFILELINELEVEL(int[] level) {
        level[0] = SktDbgGetFileLineLevel();
    }

    public static final void DBGSKT_SETTRACEEXTERNAL(SktDebugExternal pfnTraceExternal) {
        gSktDbgExternalTrace = pfnTraceExternal;
    }

    public static final long DBGSKT_EVAL(long result, String expression) {
        return Eval(result, expression);
    }

    static void SktDbgTrace(String pszPrefix, int nLevel, String fileName, int nLine, String format) {
        boolean truncated = false;
        int outputLevel = 1;
        if (SktDbgCheckLevel(nLevel)) {
            StringBuffer pszChar = new StringBuffer(256);
            pszChar.append(System.currentTimeMillis() + ":");
            pszChar.append(Thread.currentThread().hashCode() + ":");
            if (pszPrefix != "") {
                pszChar.append(pszPrefix);
                pszChar.append(" ");
            }
            if (SktDbgCheckFileLineLevel(nLevel)) {
                if (fileName.length() > 32) {
                    fileName = fileName.substring(32);
                    pszChar.append("...");
                }
                pszChar.append(fileName);
                pszChar.append("(" + nLine + ") ");
            }
            if ((nLevel & 4) == 4) {
                pszChar.append(gszSktError);
                outputLevel = 3;
            }
            if ((nLevel & 2) == 2) {
                pszChar.append(gszSktWarning);
                outputLevel = 2;
            }
            if (format.length() > 256 - pszChar.length()) {
                format = format.substring(0, (256 - pszChar.length()) - 5);
                truncated = true;
            }
            pszChar.append(format);
            if (truncated) {
                pszChar.append("...");
            }
            if (pszChar.length() + gszSktCarriageReturn.length() < 256) {
                pszChar.append(gszSktCarriageReturn);
            }
            if ((SktDbgGetChannel() & 1) == 1) {
                SktPlatform.SktOutput.print(outputLevel, pszPrefix, pszChar.toString());
                gSktDbgLineCount++;
            }
            if ((SktDbgGetChannel() & 8) == 8 && gSktDbgExternalTrace != null) {
                gSktDbgExternalTrace.Trace(pszChar.toString());
            }
        }
    }

    static boolean SktDbgCheckLevel(int nLevel) {
        return (gSktDbgLevel & nLevel) == nLevel || (nLevel & 8) == 8;
    }

    static void SktDbgDisable(int nLevel) {
        gSktDbgLevel &= nLevel ^ -1;
    }

    static void SktDbgEnable(int nLevel) {
        gSktDbgLevel |= nLevel;
    }

    static int SktDbgGetChannel() {
        return gSktDbgChannel;
    }

    static void SktDbgSetChannel(int newDbgChannel) {
        gSktDbgChannel = newDbgChannel;
    }

    static int SktDbgGetLevel() {
        return gSktDbgLevel;
    }

    static void SktDbgSetLevel(int newDbgLevel) {
        gSktDbgLevel = newDbgLevel;
    }

    static void SktDbgSetFileLineLevel(int nLevel) {
        gSktDbgFileLineLevel = nLevel;
    }

    static int SktDbgGetFileLineLevel() {
        return gSktDbgFileLineLevel;
    }

    static boolean SktDbgCheckFileLineLevel(int nLevel) {
        return (gSktDbgFileLineLevel & nLevel) == nLevel;
    }

    static boolean SktDbgReturn(boolean bReturn) {
        return bReturn;
    }

    static void SktDbgDumpByte(String prefix, int level, String file, int line, String dataPrefix, char[] data, int size) {
        char[] pString;
        int nIndex;
        int nIndex2;
        char ucByte;
        if (size > 0 && (pString = new char[(size * 2)]) != null) {
            int nIndex3 = 0;
            int i = 0;
            while (i < size) {
                int j = 0;
                while (true) {
                    nIndex2 = nIndex;
                    if (j >= 2) {
                        break;
                    }
                    char ucByte2 = (char) (data[i] & 255);
                    if (j == 0) {
                        ucByte = (char) (ucByte2 >> 4);
                    } else {
                        ucByte = (char) (ucByte2 & 15);
                    }
                    if (ucByte >= 0 && ucByte <= 9) {
                        nIndex = nIndex2 + 1;
                        pString[nIndex2] = (char) (ucByte + '0');
                    } else if (ucByte < 10 || ucByte > 15) {
                        nIndex = nIndex2 + 1;
                        pString[nIndex2] = '?';
                    } else {
                        nIndex = nIndex2 + 1;
                        pString[nIndex2] = (char) ((ucByte + 'A') - 10);
                    }
                    j++;
                }
                i++;
                nIndex3 = nIndex2;
            }
            SktDbgTrace(prefix, level, file, line, dataPrefix + String.valueOf(pString));
        }
    }

    public static long Eval(long result, String strExpression) {
        if (!SktScanErrors.SKTSUCCESS(result)) {
            DBGSKT_MSG(4, "Error: " + result + " " + strExpression);
        }
        return result;
    }

    public static void DBGSKT_DUMPBYTE(int level, String prefix, char[] data, int size) {
        SktDbgDumpByte(SKTDEBUG_MODULE_NAME, level, "", 0, prefix, data, size);
    }

    static boolean SktDbgTest() {
        boolean bResult = true;
        int nBackupCurrentLevel = SktDbgGetLevel();
        long Result = DBGSKT_EVAL(-37, "SktScanErrors.ESKT_COMMANDDENIED");
        DBGSKT_MSG(8, "DEBUG LIB TEST");
        DBGSKT_MSG(8, "Dbg Level:0x" + Integer.toHexString(SktDbgGetLevel()) + " before disabling everything");
        int nCurrentCount = gSktDbgLineCount;
        DBGSKT_DISABLE(7);
        DBGSKT_MSG(8, "New Dbg Level:0x" + Integer.toHexString(SktDbgGetLevel()));
        DBGSKT_MSG(1, "You should not see this trace");
        DBGSKT_MSG(2, "You should not see this warning");
        DBGSKT_MSG(4, "You should not see this error");
        DBGSKT_ENABLE(4);
        DBGSKT_MSG(8, "New Dbg Level:0x" + Integer.toHexString(SktDbgGetLevel()));
        DBGSKT_MSG(1, "You should not see this trace");
        DBGSKT_MSG(2, "You should not see this warning");
        DBGSKT_MSG(4, "You should see this error");
        DBGSKT_ENABLE(2);
        DBGSKT_MSG(8, "New Dbg Level:0x" + Integer.toHexString(SktDbgGetLevel()));
        DBGSKT_MSG(1, "You should not see this trace");
        DBGSKT_MSG(2, "You should see this warning");
        DBGSKT_MSG(4, "You should see this error");
        DBGSKT_ENABLE(1);
        DBGSKT_MSG(8, "New Dbg Level:0x" + Integer.toHexString(SktDbgGetLevel()));
        DBGSKT_MSG(1, "You should see this trace");
        DBGSKT_MSG(2, "You should see this warning");
        DBGSKT_MSG(4, "You should see this error");
        DBGSKT_MSG(1, "This is a long trace that is even longer than the max supported by this SKTDBG lib, as you can see I can type a long sentence that will eventually get truncated to the maximum size Here is the rest of the string so it can be very long. Hopefully it won't crash your application Because that would be bad");
        int[] FileLineLevel = new int[1];
        DBGSKT_GETFILELINELEVEL(FileLineLevel);
        DBGSKT_MSG(8, "Current level for File name and Line number:0x" + Integer.toHexString(FileLineLevel[0]));
        DBGSKT_MSG(8, "Set the File name and line number for all levels");
        DBGSKT_SETFILELINELEVEL(15);
        DBGSKT_MSG(1, "You should see the file name and the line number");
        DBGSKT_MSG(2, "You should see the file name and the line number");
        DBGSKT_MSG(4, "You should see the file name and the line number");
        DBGSKT_MSG(8, "Restore the Current level for File name and Line number");
        DBGSKT_SETFILELINELEVEL(FileLineLevel[0]);
        DBGSKT_MSG(1, "You should not see the file name and the line number");
        DBGSKT_MSG(2, "You should not see the file name and the line number");
        DBGSKT_MSG(4, "You should see the file name and the line number");
        DBGSKT_DISABLE(-16);
        DBGSKT_ENABLE(16);
        DBGSKT_MSG(33, "You should not see this trace");
        DBGSKT_MSG(34, "You should not see this trace");
        DBGSKT_MSG(36, "You should not see this trace");
        DBGSKT_MSG(40, "You should see this trace");
        DBGSKT_MSG(17, "You should see this trace");
        DBGSKT_MSG(18, "You should see this trace");
        DBGSKT_MSG(20, "You should see this trace");
        DBGSKT_MSG(24, "You should see this trace");
        DBGSKT_ENABLE(-16);
        DBGSKT_MSG(33, "You should see this trace");
        DBGSKT_MSG(34, "You should see this trace");
        DBGSKT_MSG(36, "You should see this trace");
        DBGSKT_MSG(40, "You should see this trace");
        long Result2 = DBGSKT_SUCCESS(DBGSKT_SUCCESS(DBGSKT_SUCCESS(0, -19), 0), 1);
        if (1 == 1 && 0 != 0) {
            bResult = false;
        }
        if (bResult && 0 != 1) {
            bResult = false;
        }
        if (bResult && 0 != 1) {
        }
        DBGSKT_DISABLE(-9);
        DBGSKT_ENABLE(nBackupCurrentLevel);
        DBGSKT_MSG(8, "Restore Dbg Level to:0x" + Integer.toHexString(SktDbgGetLevel()));
        if (gSktDbgLineCount - nCurrentCount >= 31) {
            return true;
        }
        DBGSKT_MSG(4, "Number of displayed traces doesn't match:" + Integer.toString(gSktDbgLineCount - nCurrentCount) + " instead of " + Integer.toString(31));
        return false;
    }
}
