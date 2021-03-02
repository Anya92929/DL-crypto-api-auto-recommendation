package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1326ik;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new C0263b();

    /* renamed from: BR */
    private final int f424BR;

    /* renamed from: ER */
    private String f425ER;

    /* renamed from: ES */
    String f426ES;

    /* renamed from: ET */
    private Inet4Address f427ET;

    /* renamed from: EU */
    private String f428EU;

    /* renamed from: EV */
    private String f429EV;

    /* renamed from: EW */
    private String f430EW;

    /* renamed from: EX */
    private int f431EX;

    /* renamed from: EY */
    private List<WebImage> f432EY;

    /* renamed from: EZ */
    private int f433EZ;

    /* renamed from: Fa */
    private int f434Fa;

    private CastDevice() {
        this(3, (String) null, (String) null, (String) null, (String) null, (String) null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status) {
        this.f424BR = versionCode;
        this.f425ER = deviceId;
        this.f426ES = hostAddress;
        if (this.f426ES != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.f426ES);
                if (byName instanceof Inet4Address) {
                    this.f427ET = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.f427ET = null;
            }
        }
        this.f428EU = friendlyName;
        this.f429EV = modelName;
        this.f430EW = deviceVersion;
        this.f431EX = servicePort;
        this.f432EY = icons;
        this.f433EZ = capabilities;
        this.f434Fa = status;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : C1326ik.m4984a(this.f425ER, castDevice.f425ER) && C1326ik.m4984a(this.f427ET, castDevice.f427ET) && C1326ik.m4984a(this.f429EV, castDevice.f429EV) && C1326ik.m4984a(this.f428EU, castDevice.f428EU) && C1326ik.m4984a(this.f430EW, castDevice.f430EW) && this.f431EX == castDevice.f431EX && C1326ik.m4984a(this.f432EY, castDevice.f432EY) && this.f433EZ == castDevice.f433EZ && this.f434Fa == castDevice.f434Fa;
    }

    public int getCapabilities() {
        return this.f433EZ;
    }

    public String getDeviceId() {
        return this.f425ER;
    }

    public String getDeviceVersion() {
        return this.f430EW;
    }

    public String getFriendlyName() {
        return this.f428EU;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage;
        WebImage webImage2 = null;
        if (this.f432EY.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return this.f432EY.get(0);
        }
        WebImage webImage3 = null;
        for (WebImage next : this.f432EY) {
            int width = next.getWidth();
            int height = next.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height))) {
                    webImage = webImage3;
                }
                next = webImage2;
                webImage = webImage3;
            } else {
                if (webImage3 == null || (webImage3.getWidth() > width && webImage3.getHeight() > height)) {
                    WebImage webImage4 = webImage2;
                    webImage = next;
                    next = webImage4;
                }
                next = webImage2;
                webImage = webImage3;
            }
            webImage3 = webImage;
            webImage2 = next;
        }
        if (webImage3 == null) {
            webImage3 = webImage2 != null ? webImage2 : this.f432EY.get(0);
        }
        return webImage3;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.f432EY);
    }

    public Inet4Address getIpAddress() {
        return this.f427ET;
    }

    public String getModelName() {
        return this.f429EV;
    }

    public int getServicePort() {
        return this.f431EX;
    }

    public int getStatus() {
        return this.f434Fa;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f424BR;
    }

    public boolean hasIcons() {
        return !this.f432EY.isEmpty();
    }

    public int hashCode() {
        if (this.f425ER == null) {
            return 0;
        }
        return this.f425ER.hashCode();
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (getDeviceId() == null) {
            return castDevice.getDeviceId() == null;
        }
        return C1326ik.m4984a(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.f428EU, this.f425ER});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0263b.m451a(this, out, flags);
    }
}
