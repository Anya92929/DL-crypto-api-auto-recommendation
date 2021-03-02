package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class SnapshotsImpl implements Snapshots {

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl$7 */
    class C08427 extends LoadImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2277XU;

        /* renamed from: XW */
        final /* synthetic */ String f2278XW;

        /* renamed from: XX */
        final /* synthetic */ String f2279XX;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6670c((BaseImplementation.C0270b<Snapshots.LoadSnapshotsResult>) this, this.f2278XW, this.f2279XX, this.f2277XU);
        }
    }

    private static abstract class CommitImpl extends Games.BaseGamesApiMethodImpl<Snapshots.CommitSnapshotResult> {
        private CommitImpl() {
        }

        /* renamed from: ao */
        public Snapshots.CommitSnapshotResult mo3773c(final Status status) {
            return new Snapshots.CommitSnapshotResult() {
                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class DeleteImpl extends Games.BaseGamesApiMethodImpl<Snapshots.DeleteSnapshotResult> {
        private DeleteImpl() {
        }

        /* renamed from: ap */
        public Snapshots.DeleteSnapshotResult mo3773c(final Status status) {
            return new Snapshots.DeleteSnapshotResult() {
                public String getSnapshotId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Snapshots.LoadSnapshotsResult> {
        private LoadImpl() {
        }

        /* renamed from: aq */
        public Snapshots.LoadSnapshotsResult mo3773c(final Status status) {
            return new Snapshots.LoadSnapshotsResult() {
                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class OpenImpl extends Games.BaseGamesApiMethodImpl<Snapshots.OpenSnapshotResult> {
        private OpenImpl() {
        }

        /* renamed from: ar */
        public Snapshots.OpenSnapshotResult mo3773c(final Status status) {
            return new Snapshots.OpenSnapshotResult() {
                public String getConflictId() {
                    return null;
                }

                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                public Contents getResolutionContents() {
                    return null;
                }

                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                public Snapshot getSnapshot() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, final Snapshot snapshot, final SnapshotMetadataChange metadataChange) {
        return apiClient.mo4221b(new CommitImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6608a((BaseImplementation.C0270b<Snapshots.CommitSnapshotResult>) this, snapshot, metadataChange);
            }
        });
    }

    public PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient apiClient, final SnapshotMetadata metadata) {
        return apiClient.mo4221b(new DeleteImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6704j(this, metadata.getSnapshotId());
            }
        });
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.m2159c(apiClient).mo6642a(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6728ks();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6727kr();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.m2159c(apiClient).mo6600a(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
            return null;
        }
        return (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo4219a(new LoadImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6688e((BaseImplementation.C0270b<Snapshots.LoadSnapshotsResult>) this, forceReload);
            }
        });
    }

    public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient apiClient, final String fileName, final boolean createIfNotFound) {
        return apiClient.mo4221b(new OpenImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6655b((BaseImplementation.C0270b<Snapshots.OpenSnapshotResult>) this, fileName, createIfNotFound);
            }
        });
    }

    public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new SnapshotMetadataChange.Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, Contents contents) {
        final SnapshotContents snapshotContents = new SnapshotContents(contents);
        final String str = conflictId;
        final String str2 = snapshotId;
        final SnapshotMetadataChange snapshotMetadataChange = metadataChange;
        return apiClient.mo4221b(new OpenImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.mo6622a((BaseImplementation.C0270b<Snapshots.OpenSnapshotResult>) this, str, str2, snapshotMetadataChange, snapshotContents);
            }
        });
    }

    public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, SnapshotContents snapshotContents) {
        final String str = conflictId;
        final String str2 = snapshotId;
        final SnapshotMetadataChange snapshotMetadataChange = metadataChange;
        final SnapshotContents snapshotContents2 = snapshotContents;
        return apiClient.mo4221b(new OpenImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.mo6622a((BaseImplementation.C0270b<Snapshots.OpenSnapshotResult>) this, str, str2, snapshotMetadataChange, snapshotContents2);
            }
        });
    }
}
