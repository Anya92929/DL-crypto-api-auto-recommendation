package com.tapcrowd.app.utils;

import android.content.Context;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
    public static String unicodeToString(String d) {
        return d != null ? d : "";
    }

    public static String timeToTimeAgo(String date) {
        try {
            double dif = Math.floor((double) (new Date().getTime() / 1000)) - Math.floor((double) (new Date(date).getTime() / 1000));
            if (dif < 0.0d) {
                return "...";
            }
            if (dif == 0.0d) {
                return "now";
            }
            if (dif < 60.0d) {
                return String.valueOf((int) dif) + "s";
            }
            if (dif < 3600.0d) {
                return String.valueOf((int) Math.floor(dif / 60.0d)) + "m";
            }
            if (dif < 86400.0d) {
                return String.valueOf((int) Math.floor(dif / 3600.0d)) + "h";
            }
            int t = (int) Math.floor(dif / 86400.0d);
            if (t == 1) {
                return "1d";
            }
            return String.valueOf(t) + "d";
        } catch (Exception e) {
            return "";
        }
    }

    public static String timeAgoToTime(String timeAgo) {
        return null;
    }

    public static String dateToTimeAgo(Date date) {
        try {
            double dif = Math.floor((double) (new Date().getTime() / 1000)) - Math.floor((double) (date.getTime() / 1000));
            if (dif < 0.0d) {
                return "...";
            }
            if (dif == 0.0d) {
                return "now";
            }
            if (dif < 60.0d) {
                return String.valueOf((int) dif) + "s";
            }
            if (dif < 3600.0d) {
                return String.valueOf((int) Math.floor(dif / 60.0d)) + "m";
            }
            if (dif < 86400.0d) {
                return String.valueOf((int) Math.floor(dif / 3600.0d)) + "h";
            }
            int t = (int) Math.floor(dif / 86400.0d);
            if (t == 1) {
                return "1d";
            }
            return String.valueOf(t) + "d";
        } catch (Exception e) {
            return "";
        }
    }

    public static String md5(String in) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 18
            digest.reset(); // CRYPTOGRAPHIC API CALLSITE 17
            digest.update(in.getBytes()); // CRYPTOGRAPHIC API CALLSITE 16
            byte[] a = digest.digest(); // CRYPTOGRAPHIC API CALLSITE 1
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int dateToInt(String dd, String mm, String yyyy) {
        return Integer.parseInt(yyyy + mm + dd);
    }

    public static int dateToInt(int dd, int mm, int yyyy) {
        return Integer.parseInt(new StringBuilder().append(yyyy).append(mm).append(dd).toString());
    }

    public static String urlToName(String s) {
        if (s != null && !s.equalsIgnoreCase("")) {
            return s.replace("http://", "").replace("tapcrowd.com", "").replace("admin.", "").replace("cache", "").replace("/", "");
        }
        return "";
    }

    public static String datesToString(String start, String stop) {
        if (start == null || stop == null || start.equals("1970-01-01")) {
            return "";
        }
        String start2 = start.replace("-", "");
        String stop2 = stop.replace("-", "");
        int j = Integer.parseInt(start2.substring(0, 4));
        int m = Integer.parseInt(start2.substring(4, 6));
        Date dstart = new Date(j - 1900, m - 1, Integer.parseInt(start2.substring(6, 8)));
        int sj = Integer.parseInt(stop2.substring(0, 4));
        int sm = Integer.parseInt(stop2.substring(4, 6));
        Date dstop = new Date(sj - 1900, sm - 1, Integer.parseInt(stop2.substring(6, 8)));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if (start2.equalsIgnoreCase(stop2)) {
            return sdf.format(dstart);
        }
        return String.valueOf(sdf.format(dstart)) + " - " + sdf.format(dstop);
    }

    public static int timeToInt(String time) {
        String[] times = time.split("h");
        int hours = Integer.parseInt(times[0]);
        return (hours * 60) + Integer.parseInt(times[1]);
    }

    public static String intToTime(int time) {
        String result = String.valueOf("") + Math.round((float) (time / 60)) + ":";
        if (time % 60 < 10) {
            result = String.valueOf(result) + "0";
        }
        return String.valueOf(result) + (time % 60);
    }

    public static int timeToIntMin(String time) {
        return Integer.parseInt(time.split("h")[1]);
    }

    public static float convertDpToPixel(float dp, Context ctx) {
        return dp * (((float) ctx.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }
}
