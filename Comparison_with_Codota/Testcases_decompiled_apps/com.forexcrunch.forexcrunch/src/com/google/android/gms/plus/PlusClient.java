package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.internal.C0531bt;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PlusClient implements GooglePlayServicesClient {
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";

    /* renamed from: hU */
    final C0531bt f1650hU;

    public static class Builder {

        /* renamed from: e */
        private GooglePlayServicesClient.OnConnectionFailedListener f1651e;

        /* renamed from: g */
        private String f1652g;

        /* renamed from: hV */
        private GooglePlayServicesClient.ConnectionCallbacks f1653hV;

        /* renamed from: hW */
        private ArrayList<String> f1654hW = new ArrayList<>();

        /* renamed from: hX */
        private String[] f1655hX;

        /* renamed from: hY */
        private String[] f1656hY;

        /* renamed from: hZ */
        private String f1657hZ = this.mContext.getPackageName();

        /* renamed from: ia */
        private String f1658ia = this.mContext.getPackageName();

        /* renamed from: ib */
        private String f1659ib;
        private Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f1653hV = connectionCallbacks;
            this.f1651e = connectionFailedListener;
            this.f1654hW.add(Scopes.PLUS_LOGIN);
        }

        public PlusClient build() {
            if (this.f1652g == null) {
                this.f1652g = "<<default account>>";
            }
            return new PlusClient(new C0531bt(this.mContext, new C0751a(this.f1652g, (String[]) this.f1654hW.toArray(new String[this.f1654hW.size()]), this.f1655hX, this.f1656hY, this.f1657hZ, this.f1658ia, this.f1659ib), this.f1653hV, this.f1651e));
        }

        public Builder clearScopes() {
            this.f1654hW.clear();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.f1652g = accountName;
            return this;
        }

        public Builder setActions(String... actions) {
            this.f1655hX = actions;
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f1654hW.clear();
            this.f1654hW.addAll(Arrays.asList(scopes));
            return this;
        }

        @Deprecated
        public Builder setVisibleActivities(String... actions) {
            setActions(actions);
            return this;
        }
    }

    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    public interface OnMomentsLoadedListener {
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    public interface OrderBy {
        public static final int ALPHABETICAL = 0;
        public static final int BEST = 1;
    }

    PlusClient(C0531bt plusClientImpl) {
        this.f1650hU = plusClientImpl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bu */
    public C0531bt mo6308bu() {
        return this.f1650hU;
    }

    public void clearDefaultAccount() {
        this.f1650hU.clearDefaultAccount();
    }

    public void connect() {
        this.f1650hU.connect();
    }

    public void disconnect() {
        this.f1650hU.disconnect();
    }

    public String getAccountName() {
        return this.f1650hU.getAccountName();
    }

    public Person getCurrentPerson() {
        return this.f1650hU.getCurrentPerson();
    }

    public boolean isConnected() {
        return this.f1650hU.isConnected();
    }

    public boolean isConnecting() {
        return this.f1650hU.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f1650hU.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f1650hU.isConnectionFailedListenerRegistered(listener);
    }

    public void loadMoments(OnMomentsLoadedListener listener) {
        this.f1650hU.loadMoments(listener);
    }

    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.f1650hU.loadMoments(listener, maxResults, pageToken, targetUrl, type, userId);
    }

    public void loadPeople(OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.f1650hU.mo4916a(listener, personIds);
    }

    public void loadPeople(OnPeopleLoadedListener listener, String... personIds) {
        this.f1650hU.mo4917a(listener, personIds);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.f1650hU.loadVisiblePeople(listener, orderBy, pageToken);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        this.f1650hU.loadVisiblePeople(listener, pageToken);
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f1650hU.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f1650hU.registerConnectionFailedListener(listener);
    }

    public void removeMoment(String momentId) {
        this.f1650hU.removeMoment(momentId);
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        this.f1650hU.revokeAccessAndDisconnect(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f1650hU.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f1650hU.unregisterConnectionFailedListener(listener);
    }

    public void writeMoment(Moment moment) {
        this.f1650hU.writeMoment(moment);
    }
}
