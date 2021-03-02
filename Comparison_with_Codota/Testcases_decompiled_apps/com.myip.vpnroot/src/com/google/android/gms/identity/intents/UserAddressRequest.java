package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new C0877a();

    /* renamed from: BR */
    private final int f2400BR;
    List<CountrySpecification> adz;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (UserAddressRequest.this.adz == null) {
                UserAddressRequest.this.adz = new ArrayList();
            }
            UserAddressRequest.this.adz.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (UserAddressRequest.this.adz == null) {
                UserAddressRequest.this.adz = new ArrayList();
            }
            UserAddressRequest.this.adz.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (UserAddressRequest.this.adz != null) {
                UserAddressRequest.this.adz = Collections.unmodifiableList(UserAddressRequest.this.adz);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
        this.f2400BR = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.f2400BR = versionCode;
        this.adz = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f2400BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0877a.m3783a(this, out, flags);
    }
}
