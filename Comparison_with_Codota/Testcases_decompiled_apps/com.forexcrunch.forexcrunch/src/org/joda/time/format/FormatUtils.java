package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;

public class FormatUtils {
    private static final double LOG_10 = Math.log(10.0d);

    private FormatUtils() {
    }

    public static void appendPaddedInteger(StringBuffer stringBuffer, int i, int i2) {
        int i3;
        if (i < 0) {
            stringBuffer.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                while (i2 > 10) {
                    stringBuffer.append('0');
                    i2--;
                }
                stringBuffer.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            while (i2 > 1) {
                stringBuffer.append('0');
                i2--;
            }
            stringBuffer.append((char) (i + 48));
        } else if (i < 100) {
            while (i2 > 2) {
                stringBuffer.append('0');
                i2--;
            }
            int i4 = ((i + 1) * 13421772) >> 27;
            stringBuffer.append((char) (i4 + 48));
            stringBuffer.append((char) (((i - (i4 << 3)) - (i4 << 1)) + 48));
        } else {
            if (i < 1000) {
                i3 = 3;
            } else if (i < 10000) {
                i3 = 4;
            } else {
                i3 = ((int) (Math.log((double) i) / LOG_10)) + 1;
            }
            while (i2 > i3) {
                stringBuffer.append('0');
                i2--;
            }
            stringBuffer.append(Integer.toString(i));
        }
    }

    public static void appendPaddedInteger(StringBuffer stringBuffer, long j, int i) {
        int i2 = (int) j;
        if (((long) i2) == j) {
            appendPaddedInteger(stringBuffer, i2, i);
        } else if (i <= 19) {
            stringBuffer.append(Long.toString(j));
        } else {
            if (j < 0) {
                stringBuffer.append('-');
                if (j != Long.MIN_VALUE) {
                    j = -j;
                } else {
                    while (i > 19) {
                        stringBuffer.append('0');
                        i--;
                    }
                    stringBuffer.append("9223372036854775808");
                    return;
                }
            }
            int log = ((int) (Math.log((double) j) / LOG_10)) + 1;
            while (i > log) {
                stringBuffer.append('0');
                i--;
            }
            stringBuffer.append(Long.toString(j));
        }
    }

    public static void writePaddedInteger(Writer writer, int i, int i2) throws IOException {
        int i3;
        if (i < 0) {
            writer.write(45);
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                while (i2 > 10) {
                    writer.write(48);
                    i2--;
                }
                writer.write("2147483648");
                return;
            }
        }
        if (i < 10) {
            while (i2 > 1) {
                writer.write(48);
                i2--;
            }
            writer.write(i + 48);
        } else if (i < 100) {
            while (i2 > 2) {
                writer.write(48);
                i2--;
            }
            int i4 = ((i + 1) * 13421772) >> 27;
            writer.write(i4 + 48);
            writer.write(((i - (i4 << 3)) - (i4 << 1)) + 48);
        } else {
            if (i < 1000) {
                i3 = 3;
            } else if (i < 10000) {
                i3 = 4;
            } else {
                i3 = ((int) (Math.log((double) i) / LOG_10)) + 1;
            }
            while (i2 > i3) {
                writer.write(48);
                i2--;
            }
            writer.write(Integer.toString(i));
        }
    }

    public static void writePaddedInteger(Writer writer, long j, int i) throws IOException {
        int i2 = (int) j;
        if (((long) i2) == j) {
            writePaddedInteger(writer, i2, i);
        } else if (i <= 19) {
            writer.write(Long.toString(j));
        } else {
            if (j < 0) {
                writer.write(45);
                if (j != Long.MIN_VALUE) {
                    j = -j;
                } else {
                    while (i > 19) {
                        writer.write(48);
                        i--;
                    }
                    writer.write("9223372036854775808");
                    return;
                }
            }
            int log = ((int) (Math.log((double) j) / LOG_10)) + 1;
            while (i > log) {
                writer.write(48);
                i--;
            }
            writer.write(Long.toString(j));
        }
    }

    public static void appendUnpaddedInteger(StringBuffer stringBuffer, int i) {
        if (i < 0) {
            stringBuffer.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                stringBuffer.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            stringBuffer.append((char) (i + 48));
        } else if (i < 100) {
            int i2 = ((i + 1) * 13421772) >> 27;
            stringBuffer.append((char) (i2 + 48));
            stringBuffer.append((char) (((i - (i2 << 3)) - (i2 << 1)) + 48));
        } else {
            stringBuffer.append(Integer.toString(i));
        }
    }

    public static void appendUnpaddedInteger(StringBuffer stringBuffer, long j) {
        int i = (int) j;
        if (((long) i) == j) {
            appendUnpaddedInteger(stringBuffer, i);
        } else {
            stringBuffer.append(Long.toString(j));
        }
    }

    public static void writeUnpaddedInteger(Writer writer, int i) throws IOException {
        if (i < 0) {
            writer.write(45);
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                writer.write("2147483648");
                return;
            }
        }
        if (i < 10) {
            writer.write(i + 48);
        } else if (i < 100) {
            int i2 = ((i + 1) * 13421772) >> 27;
            writer.write(i2 + 48);
            writer.write(((i - (i2 << 3)) - (i2 << 1)) + 48);
        } else {
            writer.write(Integer.toString(i));
        }
    }

    public static void writeUnpaddedInteger(Writer writer, long j) throws IOException {
        int i = (int) j;
        if (((long) i) == j) {
            writeUnpaddedInteger(writer, i);
        } else {
            writer.write(Long.toString(j));
        }
    }

    public static int calculateDigitCount(long j) {
        if (j < 0) {
            if (j != Long.MIN_VALUE) {
                return calculateDigitCount(-j) + 1;
            }
            return 20;
        } else if (j < 10) {
            return 1;
        } else {
            if (j < 100) {
                return 2;
            }
            if (j < 1000) {
                return 3;
            }
            if (j < 10000) {
                return 4;
            }
            return ((int) (Math.log((double) j) / LOG_10)) + 1;
        }
    }

    static int parseTwoDigits(String str, int i) {
        int charAt = str.charAt(i) - '0';
        return (((charAt << 1) + (charAt << 3)) + str.charAt(i + 1)) - 48;
    }

    static String createErrorMessage(String str, int i) {
        String concat;
        int i2 = i + 32;
        if (str.length() <= i2 + 3) {
            concat = str;
        } else {
            concat = str.substring(0, i2).concat("...");
        }
        if (i <= 0) {
            return "Invalid format: \"" + concat + '\"';
        }
        if (i >= str.length()) {
            return "Invalid format: \"" + concat + "\" is too short";
        }
        return "Invalid format: \"" + concat + "\" is malformed at \"" + concat.substring(i) + '\"';
    }
}
