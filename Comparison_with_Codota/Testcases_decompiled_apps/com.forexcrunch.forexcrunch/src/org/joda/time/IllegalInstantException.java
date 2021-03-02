package org.joda.time;

import org.joda.time.format.DateTimeFormat;

public class IllegalInstantException extends IllegalArgumentException {
    private static final long serialVersionUID = 2858712538216L;

    public IllegalInstantException(String str) {
        super(str);
    }

    public IllegalInstantException(long j, String str) {
        super(createMessage(j, str));
    }

    private static String createMessage(long j, String str) {
        return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").print((ReadableInstant) new Instant(j)) + (str != null ? " (" + str + ")" : "");
    }

    public static boolean isIllegalInstant(Throwable th) {
        if (th instanceof IllegalInstantException) {
            return true;
        }
        if (th.getCause() == null || th.getCause() == th) {
            return false;
        }
        return isIllegalInstant(th.getCause());
    }
}
