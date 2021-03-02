package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.fitness.FitnessActivities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.iu */
public class C1341iu {

    /* renamed from: Gr */
    private static final C1334ip f4055Gr = new C1334ip("MetadataUtils");

    /* renamed from: HA */
    private static final String[] f4056HA = {"Z", "+hh", "+hhmm", "+hh:mm"};

    /* renamed from: HB */
    private static final String f4057HB = ("yyyyMMdd'T'HHmmss" + f4056HA[0]);

    /* renamed from: a */
    public static String m5075a(Calendar calendar) {
        if (calendar == null) {
            f4055Gr.mo8910b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = f4057HB;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        return format.endsWith("+0000") ? format.replace("+0000", f4056HA[0]) : format;
    }

    /* renamed from: a */
    public static void m5076a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* renamed from: a */
    public static void m5077a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage bL : list) {
                jSONArray.put(bL.mo4380bL());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: aL */
    public static Calendar m5078aL(String str) {
        if (TextUtils.isEmpty(str)) {
            f4055Gr.mo8910b("Input string is empty or null", new Object[0]);
            return null;
        }
        String aM = m5079aM(str);
        if (TextUtils.isEmpty(aM)) {
            f4055Gr.mo8910b("Invalid date format", new Object[0]);
            return null;
        }
        String aN = m5080aN(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(aN)) {
            aM = aM + "T" + aN;
            str2 = aN.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : f4057HB;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(aM));
            return instance;
        } catch (ParseException e) {
            f4055Gr.mo8910b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    /* renamed from: aM */
    private static String m5079aM(String str) {
        if (TextUtils.isEmpty(str)) {
            f4055Gr.mo8910b("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return str.substring(0, "yyyyMMdd".length());
        } catch (IndexOutOfBoundsException e) {
            f4055Gr.mo8911c("Error extracting the date: %s", e.getMessage());
            return null;
        }
    }

    /* renamed from: aN */
    private static String m5080aN(String str) {
        if (TextUtils.isEmpty(str)) {
            f4055Gr.mo8910b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            f4055Gr.mo8910b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case FitnessActivities.KITESURFING:
                case FitnessActivities.MEDITATION:
                    if (m5081aO(substring)) {
                        return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    return null;
                case 'Z':
                    if (substring.length() == "HHmmss".length() + f4056HA[0].length()) {
                        return substring.substring(0, substring.length() - 1) + "+0000";
                    }
                    return null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            f4055Gr.mo8910b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    /* renamed from: aO */
    private static boolean m5081aO(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == f4056HA[1].length() + length2 || length == f4056HA[2].length() + length2 || length == length2 + f4056HA[3].length();
    }
}
