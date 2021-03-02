package com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version implements Comparable<Version>, Serializable {
    private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, (String) null, (String) null, (String) null);
    private static final long serialVersionUID = 1;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    @Deprecated
    public Version(int major, int minor, int patchLevel, String snapshotInfo) {
        this(major, minor, patchLevel, snapshotInfo, (String) null, (String) null);
    }

    public Version(int major, int minor, int patchLevel, String snapshotInfo, String groupId, String artifactId) {
        this._majorVersion = major;
        this._minorVersion = minor;
        this._patchLevel = patchLevel;
        this._snapshotInfo = snapshotInfo;
        this._groupId = groupId == null ? "" : groupId;
        this._artifactId = artifactId == null ? "" : artifactId;
    }

    public static Version unknownVersion() {
        return UNKNOWN_VERSION;
    }

    public boolean isUknownVersion() {
        return this == UNKNOWN_VERSION;
    }

    public boolean isSnapshot() {
        return this._snapshotInfo != null && this._snapshotInfo.length() > 0;
    }

    public int getMajorVersion() {
        return this._majorVersion;
    }

    public int getMinorVersion() {
        return this._minorVersion;
    }

    public int getPatchLevel() {
        return this._patchLevel;
    }

    public String getGroupId() {
        return this._groupId;
    }

    public String getArtifactId() {
        return this._artifactId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._majorVersion).append('.');
        sb.append(this._minorVersion).append('.');
        sb.append(this._patchLevel);
        if (isSnapshot()) {
            sb.append('-').append(this._snapshotInfo);
        }
        return sb.toString();
    }

    public int hashCode() {
        return this._artifactId.hashCode() ^ (((this._groupId.hashCode() + this._majorVersion) - this._minorVersion) + this._patchLevel);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        Version other = (Version) o;
        if (other._majorVersion == this._majorVersion && other._minorVersion == this._minorVersion && other._patchLevel == this._patchLevel && other._artifactId.equals(this._artifactId) && other._groupId.equals(this._groupId)) {
            return true;
        }
        return false;
    }

    public int compareTo(Version other) {
        if (other == this) {
            return 0;
        }
        int diff = this._groupId.compareTo(other._groupId);
        if (diff != 0) {
            return diff;
        }
        int diff2 = this._artifactId.compareTo(other._artifactId);
        if (diff2 != 0) {
            return diff2;
        }
        int diff3 = this._majorVersion - other._majorVersion;
        if (diff3 != 0) {
            return diff3;
        }
        int diff4 = this._minorVersion - other._minorVersion;
        if (diff4 == 0) {
            return this._patchLevel - other._patchLevel;
        }
        return diff4;
    }
}
