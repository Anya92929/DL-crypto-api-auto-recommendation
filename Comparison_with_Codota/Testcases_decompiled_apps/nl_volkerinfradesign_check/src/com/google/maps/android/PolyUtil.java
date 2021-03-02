package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PolyUtil {
    private PolyUtil() {
    }

    /* renamed from: a */
    private static double m4456a(double d, double d2, double d3, double d4) {
        return ((Math.tan(d) * Math.sin(d3 - d4)) + (Math.tan(d2) * Math.sin(d4))) / Math.sin(d3);
    }

    /* renamed from: b */
    private static double m4462b(double d, double d2, double d3, double d4) {
        return ((C1210hm.m5288a(d) * (d3 - d4)) + (C1210hm.m5288a(d2) * d4)) / d3;
    }

    /* renamed from: a */
    private static boolean m4460a(double d, double d2, double d3, double d4, double d5, boolean z) {
        if ((d5 >= 0.0d && d5 >= d3) || ((d5 < 0.0d && d5 < d3) || d4 <= -1.5707963267948966d || d <= -1.5707963267948966d || d2 <= -1.5707963267948966d || d >= 1.5707963267948966d || d2 >= 1.5707963267948966d || d3 <= -3.141592653589793d)) {
            return false;
        }
        double d6 = (((d3 - d5) * d) + (d2 * d5)) / d3;
        if (d >= 0.0d && d2 >= 0.0d && d4 < d6) {
            return false;
        }
        if ((d > 0.0d || d2 > 0.0d || d4 < d6) && d4 < 1.5707963267948966d) {
            return z ? Math.tan(d4) >= m4456a(d, d2, d3, d5) : C1210hm.m5288a(d4) >= m4462b(d, d2, d3, d5);
        }
        return true;
    }

    public static boolean containsLocation(LatLng latLng, List<LatLng> list, boolean z) {
        int i;
        int size = list.size();
        if (size == 0) {
            return false;
        }
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        LatLng latLng2 = list.get(size - 1);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        int i2 = 0;
        double d = radians4;
        double d2 = radians3;
        for (LatLng next : list) {
            double b = C1210hm.m5293b(radians2 - d, -3.141592653589793d, 3.141592653589793d);
            if (radians == d2 && b == 0.0d) {
                return true;
            }
            double radians5 = Math.toRadians(next.latitude);
            double radians6 = Math.toRadians(next.longitude);
            if (m4460a(d2, radians5, C1210hm.m5293b(radians6 - d, -3.141592653589793d, 3.141592653589793d), radians, b, z)) {
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
            d = radians6;
            d2 = radians5;
        }
        return (i2 & 1) != 0;
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z, double d) {
        return m4461a(latLng, list, true, z, d);
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z) {
        return isLocationOnEdge(latLng, list, z, 0.1d);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z, double d) {
        return m4461a(latLng, list, false, z, d);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z) {
        return isLocationOnPath(latLng, list, z, 0.1d);
    }

    /* renamed from: a */
    private static boolean m4461a(LatLng latLng, List<LatLng> list, boolean z, boolean z2, double d) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        double d2 = d / 6371009.0d;
        double c = C1210hm.m5294c(d2);
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        LatLng latLng2 = list.get(z ? size - 1 : 0);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        if (z2) {
            Iterator<LatLng> it = list.iterator();
            while (true) {
                double d3 = radians3;
                if (!it.hasNext()) {
                    break;
                }
                LatLng next = it.next();
                radians3 = Math.toRadians(next.latitude);
                double radians5 = Math.toRadians(next.longitude);
                if (m4459a(d3, radians4, radians3, radians5, radians, radians2, c)) {
                    return true;
                }
                radians4 = radians5;
            }
        } else {
            double d4 = radians - d2;
            double d5 = radians + d2;
            double a = C1210hm.m5288a(radians3);
            double a2 = C1210hm.m5288a(radians);
            double[] dArr = new double[3];
            double d6 = a;
            double d7 = radians4;
            for (LatLng next2 : list) {
                double radians6 = Math.toRadians(next2.latitude);
                double a3 = C1210hm.m5288a(radians6);
                double radians7 = Math.toRadians(next2.longitude);
                if (Math.max(radians3, radians6) >= d4 && Math.min(radians3, radians6) <= d5) {
                    double b = C1210hm.m5293b(radians7 - d7, -3.141592653589793d, 3.141592653589793d);
                    double b2 = C1210hm.m5293b(radians2 - d7, -3.141592653589793d, 3.141592653589793d);
                    dArr[0] = b2;
                    dArr[1] = 6.283185307179586d + b2;
                    dArr[2] = b2 - 6.283185307179586d;
                    int length = dArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            continue;
                            break;
                        }
                        double d8 = dArr[i2];
                        double d9 = a3 - d6;
                        double d10 = (b * b) + (d9 * d9);
                        double a4 = d10 <= 0.0d ? 0.0d : C1210hm.m5290a(((d8 * b) + ((a2 - d6) * d9)) / d10, 0.0d, 1.0d);
                        if (C1210hm.m5295c(radians, C1210hm.m5291b((a4 * d9) + d6), d8 - (a4 * b)) < c) {
                            return true;
                        }
                        i = i2 + 1;
                    }
                }
                d6 = a3;
                d7 = radians7;
                radians3 = radians6;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static double m4457a(double d, double d2, double d3, double d4, double d5, double d6) {
        double sin = Math.sin(d);
        double cos = Math.cos(d3);
        double cos2 = Math.cos(d5);
        double d7 = d6 - d2;
        double d8 = d4 - d2;
        double sin2 = Math.sin(d7) * cos2;
        double sin3 = Math.sin(d8) * cos;
        double c = (cos2 * 2.0d * sin * C1210hm.m5294c(d7)) + Math.sin(d5 - d);
        double c2 = (sin * 2.0d * cos * C1210hm.m5294c(d8)) + Math.sin(d3 - d);
        double d9 = ((sin2 * sin2) + (c * c)) * ((sin3 * sin3) + (c2 * c2));
        if (d9 <= 0.0d) {
            return 1.0d;
        }
        return ((c2 * sin2) - (c * sin3)) / Math.sqrt(d9);
    }

    /* renamed from: a */
    private static boolean m4459a(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double c = C1210hm.m5295c(d, d5, d2 - d6);
        if (c <= d7) {
            return true;
        }
        double c2 = C1210hm.m5295c(d3, d5, d4 - d6);
        if (c2 <= d7) {
            return true;
        }
        double f = C1210hm.m5298f(m4457a(d, d2, d3, d4, d5, d6) * C1210hm.m5297e(c));
        if (f > d7) {
            return false;
        }
        double c3 = C1210hm.m5295c(d, d3, d2 - d4);
        double d8 = ((1.0d - (2.0d * c3)) * f) + c3;
        if (c > d8 || c2 > d8) {
            return false;
        }
        if (c3 < 0.74d) {
            return true;
        }
        double d9 = 1.0d - (2.0d * f);
        return C1210hm.m5292b((c - f) / d9, (c2 - f) / d9) > 0.0d;
    }

    public static List<LatLng> simplify(List<LatLng> list, double d) {
        LatLng latLng;
        int size = list.size();
        if (size < 1) {
            throw new IllegalArgumentException("Polyline must have at least 1 point");
        } else if (d <= 0.0d) {
            throw new IllegalArgumentException("Tolerance must be greater than zero");
        } else {
            boolean isClosedPolygon = isClosedPolygon(list);
            if (isClosedPolygon) {
                LatLng latLng2 = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                list.add(new LatLng(latLng2.latitude + 1.0E-11d, latLng2.longitude + 1.0E-11d));
                latLng = latLng2;
            } else {
                latLng = null;
            }
            Stack stack = new Stack();
            double[] dArr = new double[size];
            dArr[0] = 1.0d;
            dArr[size - 1] = 1.0d;
            if (size > 2) {
                stack.push(new int[]{0, size - 1});
                int i = 0;
                while (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    double d2 = 0.0d;
                    int i2 = i;
                    for (int i3 = iArr[0] + 1; i3 < iArr[1]; i3++) {
                        double distanceToLine = distanceToLine(list.get(i3), list.get(iArr[0]), list.get(iArr[1]));
                        if (distanceToLine > d2) {
                            i2 = i3;
                        } else {
                            distanceToLine = d2;
                        }
                        d2 = distanceToLine;
                    }
                    if (d2 > d) {
                        dArr[i2] = d2;
                        stack.push(new int[]{iArr[0], i2});
                        stack.push(new int[]{i2, iArr[1]});
                        i = i2;
                    } else {
                        i = i2;
                    }
                }
            }
            if (isClosedPolygon) {
                list.remove(list.size() - 1);
                list.add(latLng);
            }
            int i4 = 0;
            ArrayList arrayList = new ArrayList();
            Iterator<LatLng> it = list.iterator();
            while (true) {
                int i5 = i4;
                if (!it.hasNext()) {
                    return arrayList;
                }
                LatLng next = it.next();
                if (dArr[i5] != 0.0d) {
                    arrayList.add(next);
                }
                i4 = i5 + 1;
            }
        }
    }

    public static boolean isClosedPolygon(List<LatLng> list) {
        if (list.get(0).equals(list.get(list.size() - 1))) {
            return true;
        }
        return false;
    }

    public static double distanceToLine(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng2.equals(latLng3)) {
            SphericalUtil.computeDistanceBetween(latLng3, latLng);
        }
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double radians5 = Math.toRadians(latLng3.latitude) - radians3;
        double radians6 = Math.toRadians(latLng3.longitude) - radians4;
        double d = (((radians - radians3) * radians5) + ((radians2 - radians4) * radians6)) / ((radians5 * radians5) + (radians6 * radians6));
        if (d <= 0.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng2);
        }
        if (d >= 1.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng3);
        }
        return SphericalUtil.computeDistanceBetween(new LatLng(latLng.latitude - latLng2.latitude, latLng.longitude - latLng2.longitude), new LatLng((latLng3.latitude - latLng2.latitude) * d, d * (latLng3.longitude - latLng2.longitude)));
    }

    public static List<LatLng> decode(String str) {
        int i;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = 1;
            int i6 = 0;
            while (true) {
                i = i2 + 1;
                int charAt = (str.charAt(i2) - '?') - 1;
                i5 += charAt << i6;
                i6 += 5;
                if (charAt < 31) {
                    break;
                }
                i2 = i;
            }
            i4 += (i5 & 1) != 0 ? (i5 >> 1) ^ -1 : i5 >> 1;
            int i7 = 1;
            int i8 = 0;
            while (true) {
                i2 = i + 1;
                int charAt2 = (str.charAt(i) - '?') - 1;
                i7 += charAt2 << i8;
                i8 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i = i2;
            }
            int i9 = ((i7 & 1) != 0 ? (i7 >> 1) ^ -1 : i7 >> 1) + i3;
            arrayList.add(new LatLng(((double) i4) * 1.0E-5d, ((double) i9) * 1.0E-5d));
            i3 = i9;
        }
        return arrayList;
    }

    public static String encode(List<LatLng> list) {
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        long j2 = 0;
        for (LatLng next : list) {
            long round = Math.round(next.latitude * 100000.0d);
            long round2 = Math.round(next.longitude * 100000.0d);
            m4458a(round - j2, stringBuffer);
            m4458a(round2 - j, stringBuffer);
            j = round2;
            j2 = round;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m4458a(long j, StringBuffer stringBuffer) {
        long j2 = j < 0 ? (j << 1) ^ -1 : j << 1;
        while (j2 >= 32) {
            stringBuffer.append(Character.toChars((int) (((31 & j2) | 32) + 63)));
            j2 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j2 + 63)));
    }
}
