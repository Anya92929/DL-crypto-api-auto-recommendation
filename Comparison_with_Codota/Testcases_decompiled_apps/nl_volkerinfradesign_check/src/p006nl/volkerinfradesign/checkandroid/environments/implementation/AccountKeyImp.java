package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.os.Parcel;
import android.os.Parcelable;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentParams;

@Deprecated
/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.AccountKeyImp */
public class AccountKeyImp implements Accounts.AccountKey {
    public static final Parcelable.Creator<Accounts.AccountKey> CREATOR = new Parcelable.Creator<Accounts.AccountKey>() {
        /* renamed from: a */
        public Accounts.AccountKey createFromParcel(Parcel parcel) {
            return new AccountKeyImp(parcel);
        }

        /* renamed from: a */
        public Accounts.AccountKey[] newArray(int i) {
            return new Accounts.AccountKey[i];
        }
    };

    /* renamed from: a */
    private final long f4887a;

    /* renamed from: b */
    private final EnvironmentParams.C1510a f4888b;

    public AccountKeyImp(EnvironmentParams environmentParams, long j) {
        this.f4887a = j;
        this.f4888b = environmentParams.nameSpace;
    }

    private AccountKeyImp(Parcel parcel) {
        this.f4887a = parcel.readLong();
        this.f4888b = EnvironmentParams.C1510a.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public boolean exists() {
        return m5993a().mo8481b(this.f4887a);
    }

    public String getEmail() {
        Accounts.AccountCursor query = query();
        try {
            return query.moveToFirst() ? query.getEmail() : null;
        } finally {
            query.close();
        }
    }

    public long getId() {
        return this.f4887a;
    }

    public boolean hasServerId() {
        Accounts.AccountCursor query = query();
        try {
            return query.moveToFirst() && query.hasServerId();
        } finally {
            query.close();
        }
    }

    public Accounts.AccountCursor query() {
        return m5993a().mo8475a(this.f4887a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4887a);
        parcel.writeString(this.f4888b.name());
    }

    /* renamed from: a */
    private C1239ib m5993a() {
        return EnvironmentFactory.f4904a.get(this.f4888b).f4889a;
    }

    public Accounts.Profile getProfile() {
        return EnvironmentFactory.f4904a.get(this.f4888b).f4889a.mo8476a(this);
    }
}
