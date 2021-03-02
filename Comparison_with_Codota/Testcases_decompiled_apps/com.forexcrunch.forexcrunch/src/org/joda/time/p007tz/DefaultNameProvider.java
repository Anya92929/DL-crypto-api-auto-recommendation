package org.joda.time.p007tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.DateTimeUtils;

/* renamed from: org.joda.time.tz.DefaultNameProvider */
public class DefaultNameProvider implements NameProvider {
    private HashMap<Locale, Map<String, Map<String, Object>>> iByLocaleCache = createCache();

    public String getShortName(Locale locale, String str, String str2) {
        String[] nameSet = getNameSet(locale, str, str2);
        if (nameSet == null) {
            return null;
        }
        return nameSet[0];
    }

    public String getName(Locale locale, String str, String str2) {
        String[] nameSet = getNameSet(locale, str, str2);
        if (nameSet == null) {
            return null;
        }
        return nameSet[1];
    }

    private synchronized String[] getNameSet(Locale locale, String str, String str2) {
        String[] strArr;
        HashMap hashMap;
        String[] strArr2;
        String[] strArr3 = null;
        synchronized (this) {
            if (locale == null || str == null || str2 == null) {
                strArr = null;
            } else {
                Map map = this.iByLocaleCache.get(locale);
                if (map == null) {
                    HashMap<Locale, Map<String, Map<String, Object>>> hashMap2 = this.iByLocaleCache;
                    HashMap createCache = createCache();
                    hashMap2.put(locale, createCache);
                    hashMap = createCache;
                } else {
                    hashMap = map;
                }
                Map map2 = (Map) hashMap.get(str);
                if (map2 == null) {
                    map2 = createCache();
                    hashMap.put(str, map2);
                    String[][] zoneStrings = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                    int length = zoneStrings.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String[] strArr4 = zoneStrings[i];
                            if (strArr4 != null && strArr4.length == 5 && str.equals(strArr4[0])) {
                                strArr2 = strArr4;
                                break;
                            }
                            i++;
                        } else {
                            strArr2 = null;
                            break;
                        }
                    }
                    String[][] zoneStrings2 = DateTimeUtils.getDateFormatSymbols(locale).getZoneStrings();
                    int length2 = zoneStrings2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String[] strArr5 = zoneStrings2[i2];
                            if (strArr5 != null && strArr5.length == 5 && str.equals(strArr5[0])) {
                                strArr3 = strArr5;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (!(strArr2 == null || strArr3 == null)) {
                        map2.put(strArr2[2], new String[]{strArr3[2], strArr3[1]});
                        if (strArr2[2].equals(strArr2[4])) {
                            map2.put(strArr2[4] + "-Summer", new String[]{strArr3[4], strArr3[3]});
                        } else {
                            map2.put(strArr2[4], new String[]{strArr3[4], strArr3[3]});
                        }
                    }
                }
                strArr = (String[]) map2.get(str2);
            }
        }
        return strArr;
    }

    private HashMap createCache() {
        return new HashMap(7);
    }
}
