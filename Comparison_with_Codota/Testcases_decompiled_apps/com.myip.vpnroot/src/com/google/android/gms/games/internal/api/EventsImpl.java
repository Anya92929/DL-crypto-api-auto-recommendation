package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult> {
        private LoadImpl() {
        }

        /* renamed from: O */
        public Events.LoadEventsResult mo3773c(final Status status) {
            return new Events.LoadEventsResult() {
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Result> {
        private UpdateImpl() {
        }

        /* renamed from: c */
        public Result mo3773c(final Status status) {
            return new Result() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl d = Games.m2160d(apiClient);
        if (d.isConnected()) {
            d.mo6733n(eventId, incrementAmount);
        } else {
            apiClient.mo4221b(new UpdateImpl() {
                /* renamed from: a */
                public void mo3769a(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.mo6733n(eventId, incrementAmount);
                }
            });
        }
    }

    public PendingResult<Events.LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo4219a(new LoadImpl() {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6681d((BaseImplementation.C0270b<Events.LoadEventsResult>) this, forceReload);
            }
        });
    }

    public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.mo4219a(new LoadImpl() {
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6633a((BaseImplementation.C0270b<Events.LoadEventsResult>) this, forceReload, eventIds);
            }
        });
    }
}
