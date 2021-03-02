package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4 */
    class C08274 extends SendRequestImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2229XX;

        /* renamed from: Zs */
        final /* synthetic */ String[] f2230Zs;

        /* renamed from: Zt */
        final /* synthetic */ int f2231Zt;

        /* renamed from: Zu */
        final /* synthetic */ byte[] f2232Zu;

        /* renamed from: Zv */
        final /* synthetic */ int f2233Zv;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6630a((BaseImplementation.C0270b<Requests.SendRequestResult>) this, this.f2229XX, this.f2230Zs, this.f2231Zt, this.f2232Zu, this.f2233Zv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5 */
    class C08285 extends SendRequestImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2234XX;

        /* renamed from: Zs */
        final /* synthetic */ String[] f2235Zs;

        /* renamed from: Zt */
        final /* synthetic */ int f2236Zt;

        /* renamed from: Zu */
        final /* synthetic */ byte[] f2237Zu;

        /* renamed from: Zv */
        final /* synthetic */ int f2238Zv;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6630a((BaseImplementation.C0270b<Requests.SendRequestResult>) this, this.f2234XX, this.f2235Zs, this.f2236Zt, this.f2237Zu, this.f2238Zv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6 */
    class C08296 extends UpdateRequestsImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2239XX;

        /* renamed from: Zk */
        final /* synthetic */ String f2240Zk;

        /* renamed from: Zo */
        final /* synthetic */ String[] f2241Zo;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6626a((BaseImplementation.C0270b<Requests.UpdateRequestsResult>) this, this.f2239XX, this.f2240Zk, this.f2241Zo);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7 */
    class C08307 extends LoadRequestsImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2242XX;

        /* renamed from: Yu */
        final /* synthetic */ int f2243Yu;

        /* renamed from: Zk */
        final /* synthetic */ String f2244Zk;

        /* renamed from: Zq */
        final /* synthetic */ int f2245Zq;

        /* renamed from: Zr */
        final /* synthetic */ int f2246Zr;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6619a((BaseImplementation.C0270b<Requests.LoadRequestsResult>) this, this.f2242XX, this.f2244Zk, this.f2245Zq, this.f2246Zr, this.f2243Yu);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8 */
    class C08318 extends LoadRequestSummariesImpl {

        /* renamed from: Zk */
        final /* synthetic */ String f2247Zk;

        /* renamed from: Zr */
        final /* synthetic */ int f2248Zr;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6691f(this, this.f2247Zk, this.f2248Zr);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestSummariesResult> {
        private LoadRequestSummariesImpl() {
        }

        /* renamed from: ak */
        public Requests.LoadRequestSummariesResult mo3773c(final Status status) {
            return new Requests.LoadRequestSummariesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadRequestsImpl extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestsResult> {
        private LoadRequestsImpl() {
        }

        /* renamed from: al */
        public Requests.LoadRequestsResult mo3773c(final Status status) {
            return new Requests.LoadRequestsResult() {
                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.m593as(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class SendRequestImpl extends Games.BaseGamesApiMethodImpl<Requests.SendRequestResult> {
        private SendRequestImpl() {
        }

        /* renamed from: am */
        public Requests.SendRequestResult mo3773c(final Status status) {
            return new Requests.SendRequestResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateRequestsImpl extends Games.BaseGamesApiMethodImpl<Requests.UpdateRequestsResult> {
        private UpdateRequestsImpl() {
        }

        /* renamed from: an */
        public Requests.UpdateRequestsResult mo3773c(final Status status) {
            return new Requests.UpdateRequestsResult() {
                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public PendingResult<Requests.UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<Requests.UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo4221b(new UpdateRequestsImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6658b((BaseImplementation.C0270b<Requests.UpdateRequestsResult>) this, strArr);
            }
        });
    }

    public PendingResult<Requests.UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<Requests.UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo4221b(new UpdateRequestsImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6673c((BaseImplementation.C0270b<Requests.UpdateRequestsResult>) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList<>();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList<>() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6724ko();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6726kq();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6725kp();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m2159c(apiClient).mo6598a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<Requests.LoadRequestsResult> loadRequests(GoogleApiClient apiClient, final int requestDirection, final int types, final int sortOrder) {
        return apiClient.mo4219a(new LoadRequestsImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6602a((BaseImplementation.C0270b<Requests.LoadRequestsResult>) this, requestDirection, types, sortOrder);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m2159c(apiClient).mo6641a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m2159c(apiClient).mo6718ki();
    }
}
