package org.apache.commons.lang3;

import java.io.File;

public class SystemUtils {
    public static final String AWT_TOOLKIT = m7374c("awt.toolkit");
    public static final String FILE_ENCODING = m7374c("file.encoding");
    public static final String FILE_SEPARATOR = m7374c("file.separator");
    public static final boolean IS_JAVA_1_1 = m7369a("1.1");
    public static final boolean IS_JAVA_1_2 = m7369a("1.2");
    public static final boolean IS_JAVA_1_3 = m7369a("1.3");
    public static final boolean IS_JAVA_1_4 = m7369a("1.4");
    public static final boolean IS_JAVA_1_5 = m7369a("1.5");
    public static final boolean IS_JAVA_1_6 = m7369a("1.6");
    public static final boolean IS_JAVA_1_7 = m7369a("1.7");
    public static final boolean IS_OS_AIX = m7372b("AIX");
    public static final boolean IS_OS_HP_UX = m7372b("HP-UX");
    public static final boolean IS_OS_IRIX = m7372b("Irix");
    public static final boolean IS_OS_LINUX;
    public static final boolean IS_OS_MAC = m7372b("Mac");
    public static final boolean IS_OS_MAC_OSX = m7372b("Mac OS X");
    public static final boolean IS_OS_OS2 = m7372b("OS/2");
    public static final boolean IS_OS_SOLARIS = m7372b("Solaris");
    public static final boolean IS_OS_SUN_OS = m7372b("SunOS");
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS = m7372b("Windows");
    public static final boolean IS_OS_WINDOWS_2000 = m7375c("Windows", "5.0");
    public static final boolean IS_OS_WINDOWS_7 = m7375c("Windows", "6.1");
    public static final boolean IS_OS_WINDOWS_95 = m7375c("Windows 9", "4.0");
    public static final boolean IS_OS_WINDOWS_98 = m7375c("Windows 9", "4.1");
    public static final boolean IS_OS_WINDOWS_ME = m7375c("Windows", "4.9");
    public static final boolean IS_OS_WINDOWS_NT = m7372b("Windows NT");
    public static final boolean IS_OS_WINDOWS_VISTA = m7375c("Windows", "6.0");
    public static final boolean IS_OS_WINDOWS_XP = m7375c("Windows", "5.1");
    public static final String JAVA_AWT_FONTS = m7374c("java.awt.fonts");
    public static final String JAVA_AWT_GRAPHICSENV = m7374c("java.awt.graphicsenv");
    public static final String JAVA_AWT_HEADLESS = m7374c("java.awt.headless");
    public static final String JAVA_AWT_PRINTERJOB = m7374c("java.awt.printerjob");
    public static final String JAVA_CLASS_PATH = m7374c("java.class.path");
    public static final String JAVA_CLASS_VERSION = m7374c("java.class.version");
    public static final String JAVA_COMPILER = m7374c("java.compiler");
    public static final String JAVA_ENDORSED_DIRS = m7374c("java.endorsed.dirs");
    public static final String JAVA_EXT_DIRS = m7374c("java.ext.dirs");
    public static final String JAVA_HOME = m7374c("java.home");
    public static final String JAVA_IO_TMPDIR = m7374c("java.io.tmpdir");
    public static final String JAVA_LIBRARY_PATH = m7374c("java.library.path");
    public static final String JAVA_RUNTIME_NAME = m7374c("java.runtime.name");
    public static final String JAVA_RUNTIME_VERSION = m7374c("java.runtime.version");
    public static final String JAVA_SPECIFICATION_NAME = m7374c("java.specification.name");
    public static final String JAVA_SPECIFICATION_VENDOR = m7374c("java.specification.vendor");
    public static final String JAVA_SPECIFICATION_VERSION = m7374c("java.specification.version");
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = m7374c("java.util.prefs.PreferencesFactory");
    public static final String JAVA_VENDOR = m7374c("java.vendor");
    public static final String JAVA_VENDOR_URL = m7374c("java.vendor.url");
    public static final String JAVA_VERSION = m7374c("java.version");
    public static final String JAVA_VM_INFO = m7374c("java.vm.info");
    public static final String JAVA_VM_NAME = m7374c("java.vm.name");
    public static final String JAVA_VM_SPECIFICATION_NAME = m7374c("java.vm.specification.name");
    public static final String JAVA_VM_SPECIFICATION_VENDOR = m7374c("java.vm.specification.vendor");
    public static final String JAVA_VM_SPECIFICATION_VERSION = m7374c("java.vm.specification.version");
    public static final String JAVA_VM_VENDOR = m7374c("java.vm.vendor");
    public static final String JAVA_VM_VERSION = m7374c("java.vm.version");
    public static final String LINE_SEPARATOR = m7374c("line.separator");
    public static final String OS_ARCH = m7374c("os.arch");
    public static final String OS_NAME = m7374c("os.name");
    public static final String OS_VERSION = m7374c("os.version");
    public static final String PATH_SEPARATOR = m7374c("path.separator");
    public static final String USER_COUNTRY;
    public static final String USER_DIR = m7374c("user.dir");
    public static final String USER_HOME = m7374c("user.home");
    public static final String USER_LANGUAGE = m7374c("user.language");
    public static final String USER_NAME = m7374c("user.name");
    public static final String USER_TIMEZONE = m7374c("user.timezone");

    /* renamed from: a */
    private static final JavaVersion f7053a = JavaVersion.m7354a(JAVA_SPECIFICATION_VERSION);

    static {
        String c;
        boolean z;
        boolean z2 = false;
        if (m7374c("user.country") == null) {
            c = m7374c("user.region");
        } else {
            c = m7374c("user.country");
        }
        USER_COUNTRY = c;
        if (m7372b("Linux") || m7372b("LINUX")) {
            z = true;
        } else {
            z = false;
        }
        IS_OS_LINUX = z;
        if (IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX || IS_OS_SOLARIS || IS_OS_SUN_OS) {
            z2 = true;
        }
        IS_OS_UNIX = z2;
    }

    public static File getJavaHome() {
        return new File(System.getProperty("java.home"));
    }

    public static File getJavaIoTmpDir() {
        return new File(System.getProperty("java.io.tmpdir"));
    }

    /* renamed from: a */
    private static boolean m7369a(String str) {
        return m7370a(JAVA_SPECIFICATION_VERSION, str);
    }

    /* renamed from: c */
    private static boolean m7375c(String str, String str2) {
        return m7371a(OS_NAME, OS_VERSION, str, str2);
    }

    /* renamed from: b */
    private static boolean m7372b(String str) {
        return m7373b(OS_NAME, str);
    }

    /* renamed from: c */
    private static String m7374c(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            System.err.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

    public static File getUserHome() {
        return new File(System.getProperty("user.home"));
    }

    public static boolean isJavaAwtHeadless() {
        if (JAVA_AWT_HEADLESS != null) {
            return JAVA_AWT_HEADLESS.equals(Boolean.TRUE.toString());
        }
        return false;
    }

    public static boolean isJavaVersionAtLeast(JavaVersion javaVersion) {
        return f7053a.atLeast(javaVersion);
    }

    /* renamed from: a */
    static boolean m7370a(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    /* renamed from: a */
    static boolean m7371a(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || !str.startsWith(str3) || !str2.startsWith(str4)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    static boolean m7373b(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }
}
