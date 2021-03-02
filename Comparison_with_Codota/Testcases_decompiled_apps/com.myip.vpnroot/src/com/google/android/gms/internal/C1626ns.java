package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.C1955e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

/* renamed from: com.google.android.gms.internal.ns */
public final class C1626ns implements People {

    /* renamed from: com.google.android.gms.internal.ns$a */
    private static abstract class C1632a extends Plus.C1930a<People.LoadPeopleResult> {
        private C1632a() {
        }

        /* renamed from: aD */
        public People.LoadPeopleResult mo3773c(final Status status) {
            return new People.LoadPeopleResult() {
                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m6516a(googleApiClient, Plus.f4496CU).getCurrentPerson();
    }

    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.mo4219a(new C1632a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.mo11356a((BaseImplementation.C0270b<People.LoadPeopleResult>) this, (Collection<String>) personIds);
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.mo4219a(new C1632a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.mo11360d(this, personIds);
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.mo4219a(new C1632a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                eVar.mo11364l(this);
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.mo4219a(new C1632a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                mo4192a(eVar.mo11353a((BaseImplementation.C0270b<People.LoadPeopleResult>) this, orderBy, pageToken));
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.mo4219a(new C1632a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1955e eVar) {
                mo4192a(eVar.mo11366r(this, pageToken));
            }
        });
    }
}
