package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.C0546fl;
import com.google.android.gms.internal.C0556fo;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public class PlusClient implements GooglePlayServicesClient {

    /* renamed from: rb */
    final C0546fl f1790rb;

    public static class Builder {

        /* renamed from: ir */
        private final GooglePlayServicesClient.OnConnectionFailedListener f1791ir;
        private final Context mContext;

        /* renamed from: rc */
        private final GooglePlayServicesClient.ConnectionCallbacks f1792rc;

        /* renamed from: rd */
        private final C0556fo f1793rd = new C0556fo(this.mContext);

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f1792rc = connectionCallbacks;
            this.f1791ir = connectionFailedListener;
        }

        public PlusClient build() {
            return new PlusClient(new C0546fl(this.mContext, this.f1793rd.mo4868dh(), this.f1792rc, this.f1791ir));
        }

        public Builder clearScopes() {
            this.f1793rd.mo4867dg();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.f1793rd.mo4865Z(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.f1793rd.mo4869e(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f1793rd.mo4866d(scopes);
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

    PlusClient(C0546fl plusClientImpl) {
        this.f1790rb = plusClientImpl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cR */
    public C0546fl mo6149cR() {
        return this.f1790rb;
    }

    public void clearDefaultAccount() {
        this.f1790rb.clearDefaultAccount();
    }

    public void connect() {
        this.f1790rb.connect();
    }

    public void disconnect() {
        this.f1790rb.disconnect();
    }

    public String getAccountName() {
        return this.f1790rb.getAccountName();
    }

    public Person getCurrentPerson() {
        return this.f1790rb.getCurrentPerson();
    }

    public boolean isConnected() {
        return this.f1790rb.isConnected();
    }

    public boolean isConnecting() {
        return this.f1790rb.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f1790rb.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f1790rb.isConnectionFailedListenerRegistered(listener);
    }

    public void loadMoments(OnMomentsLoadedListener listener) {
        this.f1790rb.loadMoments(listener);
    }

    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.f1790rb.loadMoments(listener, maxResults, pageToken, targetUrl, type, userId);
    }

    public void loadPeople(OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.f1790rb.mo4835a(listener, personIds);
    }

    public void loadPeople(OnPeopleLoadedListener listener, String... personIds) {
        this.f1790rb.mo4836a(listener, personIds);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.f1790rb.loadVisiblePeople(listener, orderBy, pageToken);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        this.f1790rb.loadVisiblePeople(listener, pageToken);
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f1790rb.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f1790rb.registerConnectionFailedListener(listener);
    }

    public void removeMoment(String momentId) {
        this.f1790rb.removeMoment(momentId);
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        this.f1790rb.revokeAccessAndDisconnect(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f1790rb.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f1790rb.unregisterConnectionFailedListener(listener);
    }

    public void writeMoment(Moment moment) {
        this.f1790rb.writeMoment(moment);
    }
}
