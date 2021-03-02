package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Pattern;

public class VersionUtil {
    public static final String VERSION_FILE = "VERSION.txt";
    private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
    private final Version _version;

    protected VersionUtil() {
        Version v = null;
        try {
            v = versionFor(getClass());
        } catch (Exception e) {
            System.err.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
        }
        this._version = v == null ? Version.unknownVersion() : v;
    }

    public Version version() {
        return this._version;
    }

    public static Version versionFor(Class<?> cls) {
        InputStream in;
        Version version = null;
        try {
            in = cls.getResourceAsStream(VERSION_FILE);
            if (in != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String groupStr = null;
                String artifactStr = null;
                String versionStr = br.readLine();
                if (!(versionStr == null || (groupStr = br.readLine()) == null)) {
                    groupStr = groupStr.trim();
                    artifactStr = br.readLine();
                    if (artifactStr != null) {
                        artifactStr = artifactStr.trim();
                    }
                }
                version = parseVersion(versionStr, groupStr, artifactStr);
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (IOException e3) {
        } catch (Throwable th) {
            in.close();
            throw th;
        }
        return version == null ? Version.unknownVersion() : version;
    }

    public static Version mavenVersionFor(ClassLoader classLoader, String groupId, String artifactId) {
        InputStream pomPoperties = classLoader.getResourceAsStream("META-INF/maven/" + groupId.replaceAll("\\.", "/") + "/" + artifactId + "/pom.properties");
        if (pomPoperties != null) {
            try {
                Properties props = new Properties();
                props.load(pomPoperties);
                Version parseVersion = parseVersion(props.getProperty("version"), props.getProperty("groupId"), props.getProperty("artifactId"));
                try {
                    pomPoperties.close();
                    return parseVersion;
                } catch (IOException e) {
                    return parseVersion;
                }
            } catch (IOException e2) {
                try {
                    pomPoperties.close();
                } catch (IOException e3) {
                }
            } catch (Throwable th) {
                try {
                    pomPoperties.close();
                } catch (IOException e4) {
                }
                throw th;
            }
        }
        return Version.unknownVersion();
    }

    @Deprecated
    public static Version parseVersion(String versionStr) {
        return parseVersion(versionStr, (String) null, (String) null);
    }

    public static Version parseVersion(String versionStr, String groupId, String artifactId) {
        int minor;
        int patch;
        String snapshot = null;
        if (versionStr == null) {
            return null;
        }
        String versionStr2 = versionStr.trim();
        if (versionStr2.length() == 0) {
            return null;
        }
        String[] parts = VERSION_SEPARATOR.split(versionStr2);
        int major = parseVersionPart(parts[0]);
        if (parts.length > 1) {
            minor = parseVersionPart(parts[1]);
        } else {
            minor = 0;
        }
        if (parts.length > 2) {
            patch = parseVersionPart(parts[2]);
        } else {
            patch = 0;
        }
        if (parts.length > 3) {
            snapshot = parts[3];
        }
        return new Version(major, minor, patch, snapshot, groupId, artifactId);
    }

    protected static int parseVersionPart(String partStr) {
        String partStr2 = partStr.toString();
        int len = partStr2.length();
        int number = 0;
        for (int i = 0; i < len; i++) {
            char c = partStr2.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }
            number = (number * 10) + (c - '0');
        }
        return number;
    }
}
