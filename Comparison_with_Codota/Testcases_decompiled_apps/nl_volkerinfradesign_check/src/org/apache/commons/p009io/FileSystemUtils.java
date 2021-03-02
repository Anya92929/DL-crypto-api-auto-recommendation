package org.apache.commons.p009io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/* renamed from: org.apache.commons.io.FileSystemUtils */
public class FileSystemUtils {

    /* renamed from: a */
    private static final FileSystemUtils f6835a = new FileSystemUtils();

    /* renamed from: b */
    private static final int f6836b;

    /* renamed from: c */
    private static final String f6837c;

    static {
        int i = 3;
        String str = "df";
        try {
            String property = System.getProperty("os.name");
            if (property == null) {
                throw new IOException("os.name not found");
            }
            String lowerCase = property.toLowerCase(Locale.ENGLISH);
            if (lowerCase.indexOf("windows") != -1) {
                i = 1;
            } else if (lowerCase.indexOf("linux") != -1 || lowerCase.indexOf("mpe/ix") != -1 || lowerCase.indexOf("freebsd") != -1 || lowerCase.indexOf("irix") != -1 || lowerCase.indexOf("digital unix") != -1 || lowerCase.indexOf("unix") != -1 || lowerCase.indexOf("mac os x") != -1) {
                i = 2;
            } else if (lowerCase.indexOf("sun os") != -1 || lowerCase.indexOf("sunos") != -1 || lowerCase.indexOf("solaris") != -1) {
                str = "/usr/xpg4/bin/df";
            } else if (lowerCase.indexOf("hp-ux") == -1 && lowerCase.indexOf("aix") == -1) {
                i = 0;
            }
            f6836b = i;
            f6837c = str;
        } catch (Exception e) {
            i = -1;
        }
    }

    @Deprecated
    public static long freeSpace(String str) throws IOException {
        return f6835a.mo12499a(str, f6836b, false, -1);
    }

    public static long freeSpaceKb(String str) throws IOException {
        return freeSpaceKb(str, -1);
    }

    public static long freeSpaceKb(String str, long j) throws IOException {
        return f6835a.mo12499a(str, f6836b, true, j);
    }

    public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1);
    }

    public static long freeSpaceKb(long j) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo12499a(String str, int i, boolean z, long j) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        switch (i) {
            case 0:
                throw new IllegalStateException("Unsupported operating system");
            case 1:
                return z ? mo12500a(str, j) / 1024 : mo12500a(str, j);
            case 2:
                return mo12502a(str, z, false, j);
            case 3:
                return mo12502a(str, z, true, j);
            default:
                throw new IllegalStateException("Exception caught when determining operating system");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo12500a(String str, long j) throws IOException {
        String str2;
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize.length() <= 0 || normalize.charAt(0) == '\"') {
            str2 = normalize;
        } else {
            str2 = "\"" + normalize + "\"";
        }
        List<String> a = mo12504a(new String[]{"cmd.exe", "/C", "dir /a /-c " + str2}, Integer.MAX_VALUE, j);
        for (int size = a.size() - 1; size >= 0; size--) {
            String str3 = a.get(size);
            if (str3.length() > 0) {
                return mo12501a(str3, str2);
            }
        }
        throw new IOException("Command line 'dir /-c' did not return any info for path '" + str2 + "'");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo12501a(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int length = str.length() - 1;
        while (true) {
            if (length < 0) {
                i2 = length;
                i = 0;
                break;
            } else if (Character.isDigit(str.charAt(length))) {
                i = length + 1;
                i2 = length;
                break;
            } else {
                length--;
            }
        }
        while (true) {
            if (i2 < 0) {
                i3 = 0;
                break;
            }
            char charAt = str.charAt(i2);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i3 = i2 + 1;
                break;
            }
            i2--;
        }
        if (i2 < 0) {
            throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
        }
        StringBuilder sb = new StringBuilder(str.substring(i3, i));
        while (i4 < sb.length()) {
            if (sb.charAt(i4) == ',' || sb.charAt(i4) == '.') {
                sb.deleteCharAt(i4);
                i4--;
            }
            i4++;
        }
        return mo12505b(sb.toString(), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo12502a(String str, boolean z, boolean z2, long j) throws IOException {
        String[] strArr;
        StringTokenizer stringTokenizer;
        if (str.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String str2 = "-";
        if (z) {
            str2 = str2 + "k";
        }
        if (z2) {
            str2 = str2 + "P";
        }
        if (str2.length() > 1) {
            strArr = new String[]{f6837c, str2, str};
        } else {
            strArr = new String[]{f6837c, str};
        }
        List<String> a = mo12504a(strArr, 3, j);
        if (a.size() < 2) {
            throw new IOException("Command line '" + f6837c + "' did not return info as expected " + "for path '" + str + "'- response was " + a);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(a.get(1), " ");
        if (stringTokenizer2.countTokens() >= 4) {
            stringTokenizer2.nextToken();
            stringTokenizer = stringTokenizer2;
        } else if (stringTokenizer2.countTokens() != 1 || a.size() < 3) {
            throw new IOException("Command line '" + f6837c + "' did not return data as expected " + "for path '" + str + "'- check path is valid");
        } else {
            stringTokenizer = new StringTokenizer(a.get(2), " ");
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return mo12505b(stringTokenizer.nextToken(), str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo12505b(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + f6837c + "' did not find free space in response " + "for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e) {
            throw new IOExceptionWithCause("Command line '" + f6837c + "' did not return numeric data as expected " + "for path '" + str2 + "'- check path is valid", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo12504a(java.lang.String[] r10, int r11, long r12) throws java.io.IOException {
        /*
            r9 = this;
            r2 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r0 = 20
            r7.<init>(r0)
            java.lang.Thread r8 = p000.C1326jm.m5721a((long) r12)     // Catch:{ InterruptedException -> 0x010e, all -> 0x00f5 }
            java.lang.Process r6 = r9.mo12503a(r10)     // Catch:{ InterruptedException -> 0x010e, all -> 0x00f5 }
            java.io.InputStream r5 = r6.getInputStream()     // Catch:{ InterruptedException -> 0x0115, all -> 0x00fc }
            java.io.OutputStream r4 = r6.getOutputStream()     // Catch:{ InterruptedException -> 0x011c, all -> 0x0102 }
            java.io.InputStream r3 = r6.getErrorStream()     // Catch:{ InterruptedException -> 0x0123, all -> 0x0107 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ InterruptedException -> 0x012a, all -> 0x010b }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ InterruptedException -> 0x012a, all -> 0x010b }
            r0.<init>(r5)     // Catch:{ InterruptedException -> 0x012a, all -> 0x010b }
            r1.<init>(r0)     // Catch:{ InterruptedException -> 0x012a, all -> 0x010b }
            java.lang.String r0 = r1.readLine()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
        L_0x002a:
            if (r0 == 0) goto L_0x0044
            int r2 = r7.size()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            if (r2 >= r11) goto L_0x0044
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r0 = r0.toLowerCase(r2)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r0 = r0.trim()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            r7.add(r0)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r0 = r1.readLine()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            goto L_0x002a
        L_0x0044:
            r6.waitFor()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            p000.C1326jm.m5723a((java.lang.Thread) r8)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            int r0 = r6.exitValue()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            if (r0 == 0) goto L_0x00be
            java.io.IOException r0 = new java.io.IOException     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r7 = "Command line returned OS error code '"
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            int r7 = r6.exitValue()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r7 = "' for command "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.util.List r7 = java.util.Arrays.asList(r10)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            r0.<init>(r2)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            throw r0     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
        L_0x007b:
            r0 = move-exception
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
        L_0x0080:
            org.apache.commons.io.IOExceptionWithCause r6 = new org.apache.commons.io.IOExceptionWithCause     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r7.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r8 = "Command line threw an InterruptedException for command "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00a7 }
            java.util.List r8 = java.util.Arrays.asList(r10)     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00a7 }
            java.lang.String r8 = " timeout="
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r7 = r7.append(r12)     // Catch:{ all -> 0x00a7 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a7 }
            r6.<init>(r7, r0)     // Catch:{ all -> 0x00a7 }
            throw r6     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r0 = move-exception
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
        L_0x00ac:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r5)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r4)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r3)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.Reader) r1)
            if (r6 == 0) goto L_0x00bd
            r6.destroy()
        L_0x00bd:
            throw r0
        L_0x00be:
            boolean r0 = r7.isEmpty()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            if (r0 == 0) goto L_0x00e3
            java.io.IOException r0 = new java.io.IOException     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r7 = "Command line did not return any info for command "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.util.List r7 = java.util.Arrays.asList(r10)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            r0.<init>(r2)     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
            throw r0     // Catch:{ InterruptedException -> 0x007b, all -> 0x00e1 }
        L_0x00e1:
            r0 = move-exception
            goto L_0x00ac
        L_0x00e3:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r5)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r4)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.InputStream) r3)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.Reader) r1)
            if (r6 == 0) goto L_0x00f4
            r6.destroy()
        L_0x00f4:
            return r7
        L_0x00f5:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            r5 = r2
            r6 = r2
            goto L_0x00ac
        L_0x00fc:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            r5 = r2
            goto L_0x00ac
        L_0x0102:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            goto L_0x00ac
        L_0x0107:
            r0 = move-exception
            r1 = r2
            r3 = r2
            goto L_0x00ac
        L_0x010b:
            r0 = move-exception
            r1 = r2
            goto L_0x00ac
        L_0x010e:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            r5 = r2
            goto L_0x0080
        L_0x0115:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            r5 = r6
            goto L_0x0080
        L_0x011c:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r5
            r5 = r6
            goto L_0x0080
        L_0x0123:
            r0 = move-exception
            r1 = r2
            r3 = r4
            r4 = r5
            r5 = r6
            goto L_0x0080
        L_0x012a:
            r0 = move-exception
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p009io.FileSystemUtils.mo12504a(java.lang.String[], int, long):java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Process mo12503a(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }
}
