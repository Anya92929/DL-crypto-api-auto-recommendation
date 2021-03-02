package org.joda.time.p007tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

/* renamed from: org.joda.time.tz.UTCProvider */
public final class UTCProvider implements Provider {
    public DateTimeZone getZone(String str) {
        if ("UTC".equalsIgnoreCase(str)) {
            return DateTimeZone.UTC;
        }
        return null;
    }

    public Set<String> getAvailableIDs() {
        return Collections.singleton("UTC");
    }
}
