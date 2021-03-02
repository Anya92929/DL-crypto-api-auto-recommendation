package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.database.CursorIndexOutOfBoundsException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentParams;

@Deprecated
/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.ProfileImp */
public final class ProfileImp implements Accounts.Profile {
    public static final Parcelable.Creator<ProfileImp> CREATOR = new Parcelable.Creator<ProfileImp>() {
        /* renamed from: a */
        public ProfileImp[] newArray(int i) {
            return new ProfileImp[i];
        }

        /* renamed from: a */
        public ProfileImp createFromParcel(Parcel parcel) {
            return new ProfileImp(parcel);
        }
    };

    /* renamed from: a */
    final EnvironmentParams.C1510a f4913a;

    /* renamed from: b */
    final Accounts.AccountKey f4914b;

    /* renamed from: c */
    final String f4915c;

    /* renamed from: d */
    private Accounts.Profile.Person f4916d;

    /* renamed from: e */
    private String f4917e;

    /* renamed from: f */
    private String f4918f;

    /* renamed from: g */
    private String f4919g;

    /* renamed from: h */
    private String f4920h;

    /* renamed from: i */
    private String f4921i;

    /* renamed from: j */
    private Long f4922j;

    /* renamed from: k */
    private boolean f4923k;

    public ProfileImp(EnvironmentParams.C1510a aVar, AccountKeyImp accountKeyImp) {
        this(aVar, accountKeyImp.query(), true);
    }

    private ProfileImp(EnvironmentParams.C1510a aVar, Accounts.AccountCursor accountCursor, boolean z) {
        this.f4923k = false;
        try {
            this.f4913a = aVar;
            if (accountCursor.moveToFirst()) {
                this.f4914b = accountCursor.getKey();
                this.f4915c = accountCursor.getEmail();
                this.f4917e = accountCursor.getFirstName();
                this.f4918f = accountCursor.getMiddleName();
                this.f4919g = accountCursor.getLastName();
                this.f4920h = accountCursor.getVcaNumber();
                this.f4921i = accountCursor.getPhoneMobile();
                this.f4922j = Long.valueOf(accountCursor.getBirthDayMillis());
                this.f4916d = accountCursor.getPersonInCharge();
                if (!z) {
                    return;
                }
                return;
            }
            throw new CursorIndexOutOfBoundsException(accountCursor.getPosition(), accountCursor.getCount());
        } finally {
            if (z) {
                accountCursor.close();
            }
        }
    }

    private ProfileImp(Parcel parcel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Long l;
        Parcelable parcelable;
        this.f4923k = false;
        this.f4913a = EnvironmentParams.C1510a.valueOf(parcel.readString());
        this.f4914b = (Accounts.AccountKey) parcel.readParcelable((ClassLoader) null);
        this.f4923k = parcel.readInt() == 1;
        this.f4915c = parcel.readString();
        if (parcel.readInt() == 1) {
            str = parcel.readString();
        } else {
            str = null;
        }
        this.f4917e = str;
        if (parcel.readInt() == 1) {
            str2 = parcel.readString();
        } else {
            str2 = null;
        }
        this.f4918f = str2;
        if (parcel.readInt() == 1) {
            str3 = parcel.readString();
        } else {
            str3 = null;
        }
        this.f4919g = str3;
        if (parcel.readInt() == 1) {
            str4 = parcel.readString();
        } else {
            str4 = null;
        }
        this.f4920h = str4;
        if (parcel.readInt() == 1) {
            str5 = parcel.readString();
        } else {
            str5 = null;
        }
        this.f4921i = str5;
        if (parcel.readInt() == 1) {
            l = Long.valueOf(parcel.readLong());
        } else {
            l = null;
        }
        this.f4922j = l;
        if (parcel.readInt() == 1) {
            parcelable = parcel.readParcelable((ClassLoader) null);
        } else {
            parcelable = null;
        }
        this.f4916d = (Accounts.Profile.Person) parcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4913a.name());
        parcel.writeParcelable(this.f4914b, 0);
        parcel.writeInt(this.f4923k ? 1 : 0);
        parcel.writeString(this.f4915c);
        if (this.f4917e != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f4917e);
        } else {
            parcel.writeInt(0);
        }
        if (this.f4918f != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f4918f);
        } else {
            parcel.writeInt(0);
        }
        if (this.f4919g != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f4919g);
        } else {
            parcel.writeInt(0);
        }
        if (this.f4920h != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f4920h);
        } else {
            parcel.writeInt(0);
        }
        if (this.f4921i != null) {
            parcel.writeInt(1);
            parcel.writeString(this.f4921i);
        } else {
            parcel.writeInt(0);
        }
        if (this.f4922j != null) {
            parcel.writeInt(1);
            parcel.writeLong(this.f4922j.longValue());
        } else {
            parcel.writeInt(0);
        }
        if (this.f4916d != null) {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f4916d, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public void setFirstName(String str) {
        this.f4917e = str;
        this.f4923k = true;
    }

    public String getFirstName() {
        return this.f4917e;
    }

    public boolean hasFirstName() {
        return StringUtils.isNotBlank(this.f4917e);
    }

    public void setMiddleName(String str) {
        this.f4918f = str;
        this.f4923k = true;
    }

    public String getMiddleName() {
        return this.f4918f;
    }

    public boolean hasMiddleName() {
        return StringUtils.isNotBlank(this.f4918f);
    }

    public void setLastName(String str) {
        this.f4919g = str;
        this.f4923k = true;
    }

    public String getLastName() {
        return this.f4919g;
    }

    public boolean hasLastName() {
        return StringUtils.isNotBlank(this.f4919g);
    }

    public String getVcaNumber() {
        return this.f4920h;
    }

    public void setVcaNumber(String str) {
        this.f4920h = str;
        this.f4923k = true;
    }

    public String getPhoneMobile() {
        return this.f4921i;
    }

    public void setPhoneMobile(String str) {
        this.f4921i = str;
        this.f4923k = true;
    }

    public boolean hasPhoneMobile() {
        return StringUtils.isNotBlank(this.f4921i);
    }

    public boolean hasVcaNumber() {
        return StringUtils.isNotBlank(this.f4920h);
    }

    public void apply() {
        if (this.f4916d != null) {
            EnvironmentFactory.f4904a.get(this.f4913a).f4889a.mo8478a(this.f4915c, this.f4917e, this.f4918f, this.f4919g, this.f4920h, getBirthDay(), (String) null, (String) null, (String) null, (String) null, Long.valueOf(this.f4916d.getServerId()), this.f4916d.getName(), this.f4916d.getEmail(), this.f4921i);
        } else {
            EnvironmentFactory.f4904a.get(this.f4913a).f4889a.mo8478a(this.f4915c, this.f4917e, this.f4918f, this.f4919g, this.f4920h, getBirthDay(), (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (String) null, this.f4921i);
        }
    }

    public void setBirthDay(Calendar calendar) {
        this.f4922j = Long.valueOf(calendar.getTimeInMillis());
        this.f4923k = true;
    }

    public Calendar getBirthDay() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.f4922j.longValue());
        return instance;
    }

    public boolean hasBirthDay() {
        return this.f4922j != null;
    }

    public boolean isChanged() {
        return this.f4923k;
    }

    public boolean hasPersonInCharge() {
        return this.f4916d != null;
    }

    public Accounts.Profile.Person getPersonInCharge() {
        return this.f4916d;
    }

    public void setPersonInCharge(Accounts.Profile.Person person) {
        this.f4916d = person;
        this.f4923k = true;
    }
}
