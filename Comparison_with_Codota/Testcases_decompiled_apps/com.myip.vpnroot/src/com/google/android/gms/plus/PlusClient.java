package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.C1955e;
import com.google.android.gms.plus.internal.C1967i;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1955e akS;

    @Deprecated
    public static class Builder {
        private final GooglePlayServicesClient.ConnectionCallbacks akX;
        private final GooglePlayServicesClient.OnConnectionFailedListener akY;
        private final C1967i akZ = new C1967i(this.mContext);
        private final Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.akX = connectionCallbacks;
            this.akY = connectionFailedListener;
        }

        public PlusClient build() {
            return new PlusClient(new C1955e(this.mContext, this.akX, this.akY, this.akZ.mo11397no()));
        }

        public Builder clearScopes() {
            this.akZ.mo11396nn();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.akZ.mo11393ce(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.akZ.mo11395h(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.akZ.mo11394g(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    PlusClient(C1955e plusClientImpl) {
        this.akS = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.akS.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.akS.connect();
    }

    @Deprecated
    public void disconnect() {
        this.akS.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.akS.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.akS.getCurrentPerson();
    }

    @Deprecated
    public boolean isConnected() {
        return this.akS.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.akS.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.akS.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.akS.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener) {
        this.akS.mo11363k(new BaseImplementation.C0270b<Moments.LoadMomentsResult>() {
            /* renamed from: a */
            public void mo4196b(Moments.LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().mo4261gu(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }
        });
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.akS.mo11354a(new BaseImplementation.C0270b<Moments.LoadMomentsResult>() {
            /* renamed from: a */
            public void mo4196b(Moments.LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().mo4261gu(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }
        }, maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.akS.mo11356a((BaseImplementation.C0270b<People.LoadPeopleResult>) new BaseImplementation.C0270b<People.LoadPeopleResult>() {
            /* renamed from: a */
            public void mo4196b(People.LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo4261gu(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, personIds);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, String... personIds) {
        this.akS.mo11360d(new BaseImplementation.C0270b<People.LoadPeopleResult>() {
            /* renamed from: a */
            public void mo4196b(People.LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo4261gu(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, personIds);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.akS.mo11353a((BaseImplementation.C0270b<People.LoadPeopleResult>) new BaseImplementation.C0270b<People.LoadPeopleResult>() {
            /* renamed from: a */
            public void mo4196b(People.LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo4261gu(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, String pageToken) {
        this.akS.mo11366r(new BaseImplementation.C0270b<People.LoadPeopleResult>() {
            /* renamed from: a */
            public void mo4196b(People.LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo4261gu(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, pageToken);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mX */
    public C1955e mo11263mX() {
        return this.akS;
    }

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.akS.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.akS.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.akS.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(final OnAccessRevokedListener listener) {
        this.akS.mo11365m(new BaseImplementation.C0270b<Status>() {
            /* renamed from: aA */
            public void mo4196b(Status status) {
                listener.onAccessRevoked(status.getStatus().mo4261gu());
            }
        });
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.akS.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.akS.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.akS.mo11355a((BaseImplementation.C0270b<Status>) null, moment);
    }
}
