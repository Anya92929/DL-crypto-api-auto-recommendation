package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ClientSettings {

    /* renamed from: IG */
    private final View f734IG;

    /* renamed from: Lk */
    private final ParcelableClientSettings f735Lk;

    public static final class ParcelableClientSettings implements SafeParcelable {
        public static final ParcelableClientSettingsCreator CREATOR = new ParcelableClientSettingsCreator();

        /* renamed from: BR */
        private final int f736BR;

        /* renamed from: Dd */
        private final String f737Dd;

        /* renamed from: IF */
        private final int f738IF;

        /* renamed from: IH */
        private final String f739IH;

        /* renamed from: Jd */
        private final List<String> f740Jd;

        ParcelableClientSettings(int versionCode, String accountName, List<String> scopes, int gravityForPopups, String realClientPackageName) {
            this.f740Jd = new ArrayList();
            this.f736BR = versionCode;
            this.f737Dd = accountName;
            this.f740Jd.addAll(scopes);
            this.f738IF = gravityForPopups;
            this.f739IH = realClientPackageName;
        }

        public ParcelableClientSettings(String accountName, Collection<String> scopes, int gravityForPopups, String realClientPackageName) {
            this(3, accountName, new ArrayList(scopes), gravityForPopups, realClientPackageName);
        }

        public int describeContents() {
            return 0;
        }

        public String getAccountName() {
            return this.f737Dd;
        }

        public String getAccountNameOrDefault() {
            return this.f737Dd != null ? this.f737Dd : "<<default account>>";
        }

        public int getGravityForPopups() {
            return this.f738IF;
        }

        public String getRealClientPackageName() {
            return this.f739IH;
        }

        public List<String> getScopes() {
            return new ArrayList(this.f740Jd);
        }

        public int getVersionCode() {
            return this.f736BR;
        }

        public void writeToParcel(Parcel out, int flags) {
            ParcelableClientSettingsCreator.m677a(this, out, flags);
        }
    }

    public ClientSettings(String accountName, Collection<String> scopes, int gravityForPopups, View viewForPopups, String realClientPackageName) {
        this.f735Lk = new ParcelableClientSettings(accountName, scopes, gravityForPopups, realClientPackageName);
        this.f734IG = viewForPopups;
    }

    public String getAccountName() {
        return this.f735Lk.getAccountName();
    }

    public String getAccountNameOrDefault() {
        return this.f735Lk.getAccountNameOrDefault();
    }

    public int getGravityForPopups() {
        return this.f735Lk.getGravityForPopups();
    }

    public ParcelableClientSettings getParcelableClientSettings() {
        return this.f735Lk;
    }

    public String getRealClientPackageName() {
        return this.f735Lk.getRealClientPackageName();
    }

    public List<String> getScopes() {
        return this.f735Lk.getScopes();
    }

    public String[] getScopesArray() {
        return (String[]) this.f735Lk.getScopes().toArray(new String[0]);
    }

    public View getViewForPopups() {
        return this.f734IG;
    }
}
