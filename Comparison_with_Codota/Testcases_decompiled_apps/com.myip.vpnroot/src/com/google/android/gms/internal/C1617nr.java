package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.C1955e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

/* renamed from: com.google.android.gms.internal.nr */
public final class C1617nr implements Moments {

    /* renamed from: com.google.android.gms.internal.nr$a */
    private static abstract class C1622a extends Plus.C1930a<Moments.LoadMomentsResult> {
        private C1622a() {
        }

        /* renamed from: aC */
        public Moments.LoadMomentsResult mo3773c(final Status status) {
            return new Moments.LoadMomentsResult() {
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.nr$b */
    private static abstract class C1624b extends Plus.C1930a<Status> {
        private C1624b() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.nr$c */
    private static abstract class C1625c extends Plus.C1930a<Status> {
        private C1625c() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.mo4219a(new C1622a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.mo11363k(this);
            }
        });
    }

    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.mo4219a(new C1622a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.mo11354a(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.mo4221b(new C1624b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.removeMoment(momentId);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.mo4221b(new C1625c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.mo11355a((BaseImplementation.C0270b<Status>) this, moment);
            }
        });
    }
}
