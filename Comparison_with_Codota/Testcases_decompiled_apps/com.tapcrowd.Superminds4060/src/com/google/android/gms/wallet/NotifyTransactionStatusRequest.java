package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0411dm;

public class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator<NotifyTransactionStatusRequest> CREATOR = new C0764i();

    /* renamed from: iM */
    final int f1933iM;
    int status;

    /* renamed from: tH */
    String f1934tH;

    /* renamed from: uj */
    String f1935uj;

    public final class Builder {
        private Builder() {
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            C0411dm.m943b(!TextUtils.isEmpty(NotifyTransactionStatusRequest.this.f1934tH), "googleTransactionId is required");
            if (NotifyTransactionStatusRequest.this.status < 1 || NotifyTransactionStatusRequest.this.status > 8) {
                z = false;
            }
            C0411dm.m943b(z, "status is an unrecognized value");
            return NotifyTransactionStatusRequest.this;
        }

        public Builder setDetailedReason(String detailedReason) {
            NotifyTransactionStatusRequest.this.f1935uj = detailedReason;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            NotifyTransactionStatusRequest.this.f1934tH = googleTransactionId;
            return this;
        }

        public Builder setStatus(int status) {
            NotifyTransactionStatusRequest.this.status = status;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    public NotifyTransactionStatusRequest() {
        this.f1933iM = 1;
    }

    NotifyTransactionStatusRequest(int versionCode, String googleTransactionId, int status2, String detailedReason) {
        this.f1933iM = versionCode;
        this.f1934tH = googleTransactionId;
        this.status = status2;
        this.f1935uj = detailedReason;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.f1935uj;
    }

    public String getGoogleTransactionId() {
        return this.f1934tH;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.f1933iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0764i.m2190a(this, out, flags);
    }
}
