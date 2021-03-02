package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C1317ij;
import com.google.android.gms.internal.C1335iq;
import com.google.android.gms.internal.C1338ir;
import com.google.android.gms.internal.C1339is;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    /* access modifiers changed from: private */

    /* renamed from: FG */
    public final C1335iq f475FG = new C1335iq() {
        /* access modifiers changed from: protected */
        public void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        /* access modifiers changed from: protected */
        public void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: FH */
    public final C0256a f476FH = new C0256a();

    /* renamed from: FI */
    private OnMetadataUpdatedListener f477FI;

    /* renamed from: FJ */
    private OnStatusUpdatedListener f478FJ;
    /* access modifiers changed from: private */

    /* renamed from: mw */
    public final Object f479mw = new Object();

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a */
    private class C0256a implements C1338ir {

        /* renamed from: FX */
        private GoogleApiClient f519FX;

        /* renamed from: FY */
        private long f520FY = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a$a */
        private final class C0257a implements ResultCallback<Status> {

            /* renamed from: FZ */
            private final long f521FZ;

            C0257a(long j) {
                this.f521FZ = j;
            }

            /* renamed from: k */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    RemoteMediaPlayer.this.f475FG.mo8837b(this.f521FZ, status.getStatusCode());
                }
            }
        }

        public C0256a() {
        }

        /* renamed from: a */
        public void mo4102a(String str, String str2, long j, String str3) throws IOException {
            if (this.f519FX == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.f519FX, str, str2).setResultCallback(new C0257a(j));
        }

        /* renamed from: b */
        public void mo4103b(GoogleApiClient googleApiClient) {
            this.f519FX = googleApiClient;
        }

        /* renamed from: fy */
        public long mo4104fy() {
            long j = this.f520FY + 1;
            this.f520FY = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$b */
    private static abstract class C0258b extends Cast.C0240a<MediaChannelResult> {

        /* renamed from: Gb */
        C1339is f523Gb = new C1339is() {
            /* renamed from: a */
            public void mo4108a(long j, int i, JSONObject jSONObject) {
                C0258b.this.mo4196b(new C0261c(new Status(i), jSONObject));
            }

            /* renamed from: n */
            public void mo4109n(long j) {
                C0258b.this.mo4196b(C0258b.this.mo3773c(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        };

        C0258b() {
        }

        /* renamed from: l */
        public MediaChannelResult mo3773c(final Status status) {
            return new MediaChannelResult() {
                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$c */
    private static final class C0261c implements MediaChannelResult {

        /* renamed from: CM */
        private final Status f527CM;

        /* renamed from: Fl */
        private final JSONObject f528Fl;

        C0261c(Status status, JSONObject jSONObject) {
            this.f527CM = status;
            this.f528Fl = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.f528Fl;
        }

        public Status getStatus() {
            return this.f527CM;
        }
    }

    public RemoteMediaPlayer() {
        this.f475FG.mo8834a(this.f476FH);
    }

    /* access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.f477FI != null) {
            this.f477FI.onMetadataUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.f478FJ != null) {
            this.f478FJ.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.f479mw) {
            approximateStreamPosition = this.f475FG.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.f479mw) {
            mediaInfo = this.f475FG.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.f479mw) {
            mediaStatus = this.f475FG.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.f475FG.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.f479mw) {
            streamDuration = this.f475FG.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, (long[]) null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8918a(this.f523Gb, mediaInfo2, z, j, jArr, jSONObject);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.f475FG.mo8836aD(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8920a(this.f523Gb, customData);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8924c(this.f523Gb, customData);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8915a(this.f523Gb);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8917a(this.f523Gb, j, i, jSONObject);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8922a(this.f523Gb, trackIds);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.f477FI = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.f478FJ = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8921a(this.f523Gb, muteState, customData);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IllegalStateException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e2) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8916a(this.f523Gb, d, jSONObject);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IllegalStateException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IllegalArgumentException e2) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e3) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
                return;
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.mo4221b(new C0258b() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C1317ij ijVar) {
                    synchronized (RemoteMediaPlayer.this.f479mw) {
                        RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                        try {
                            RemoteMediaPlayer.this.f475FG.mo8919a(this.f523Gb, trackStyle);
                            RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        } catch (IOException e) {
                            mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                            RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo4221b(new C0258b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1317ij ijVar) {
                synchronized (RemoteMediaPlayer.this.f479mw) {
                    RemoteMediaPlayer.this.f476FH.mo4103b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f475FG.mo8923b(this.f523Gb, customData);
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (IOException e) {
                        mo4196b(mo3773c(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f476FH.mo4103b((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }
}
