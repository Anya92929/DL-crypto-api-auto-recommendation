package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$10 */
    class C072710 extends LoadExtendedGamesImpl {

        /* renamed from: Yk */
        final /* synthetic */ String f1999Yk;

        /* renamed from: Yl */
        final /* synthetic */ int f2000Yl;

        /* renamed from: Ym */
        final /* synthetic */ boolean f2001Ym;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6614a((BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult>) this, this.f1999Yk, this.f2000Yl, false, true, false, this.f2001Ym);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$11 */
    class C072811 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2002XU;

        /* renamed from: XW */
        final /* synthetic */ String f2003XW;

        /* renamed from: Yl */
        final /* synthetic */ int f2004Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6668c(this, this.f2003XW, this.f2004Yl, false, this.f2002XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$12 */
    class C072912 extends LoadExtendedGamesImpl {

        /* renamed from: XW */
        final /* synthetic */ String f2005XW;

        /* renamed from: Yl */
        final /* synthetic */ int f2006Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6668c(this, this.f2005XW, this.f2006Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$13 */
    class C073013 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2007XU;

        /* renamed from: XW */
        final /* synthetic */ String f2008XW;

        /* renamed from: Yl */
        final /* synthetic */ int f2009Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6678d(this, this.f2008XW, this.f2009Yl, false, this.f2007XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$14 */
    class C073114 extends LoadExtendedGamesImpl {

        /* renamed from: XW */
        final /* synthetic */ String f2010XW;

        /* renamed from: Yl */
        final /* synthetic */ int f2011Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6678d(this, this.f2010XW, this.f2011Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$15 */
    class C073215 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2012XU;

        /* renamed from: Yk */
        final /* synthetic */ String f2013Yk;

        /* renamed from: Yl */
        final /* synthetic */ int f2014Yl;

        /* renamed from: Ym */
        final /* synthetic */ boolean f2015Ym;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6614a((BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult>) this, this.f2013Yk, this.f2014Yl, true, false, this.f2012XU, this.f2015Ym);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$16 */
    class C073316 extends LoadExtendedGamesImpl {

        /* renamed from: Yk */
        final /* synthetic */ String f2016Yk;

        /* renamed from: Yl */
        final /* synthetic */ int f2017Yl;

        /* renamed from: Ym */
        final /* synthetic */ boolean f2018Ym;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6614a((BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult>) this, this.f2016Yk, this.f2017Yl, true, true, false, this.f2018Ym);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$17 */
    class C073417 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2019XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2020Yl;

        /* renamed from: Yn */
        final /* synthetic */ String f2021Yn;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6687e(this, this.f2021Yn, this.f2020Yl, false, this.f2019XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$18 */
    class C073518 extends LoadExtendedGamesImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2022Yl;

        /* renamed from: Yn */
        final /* synthetic */ String f2023Yn;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6687e(this, this.f2023Yn, this.f2022Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$19 */
    class C073619 extends LoadGameSearchSuggestionsImpl {

        /* renamed from: Yn */
        final /* synthetic */ String f2024Yn;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6731m(this, this.f2024Yn);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2 */
    class C07372 extends LoadExtendedGamesImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2025XX;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6709k(this, this.f2025XX);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3 */
    class C07383 extends LoadGameInstancesImpl {

        /* renamed from: XX */
        final /* synthetic */ String f2026XX;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6730l(this, this.f2026XX);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$4 */
    class C07394 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2027XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2028Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6651b(this, (String) null, this.f2028Yl, false, this.f2027XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$5 */
    class C07405 extends LoadExtendedGamesImpl {

        /* renamed from: Yl */
        final /* synthetic */ int f2029Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6651b(this, (String) null, this.f2029Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$6 */
    class C07416 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2030XU;

        /* renamed from: XW */
        final /* synthetic */ String f2031XW;

        /* renamed from: Yl */
        final /* synthetic */ int f2032Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6651b(this, this.f2031XW, this.f2032Yl, false, this.f2030XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$7 */
    class C07427 extends LoadExtendedGamesImpl {

        /* renamed from: XW */
        final /* synthetic */ String f2033XW;

        /* renamed from: Yl */
        final /* synthetic */ int f2034Yl;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6651b(this, this.f2033XW, this.f2034Yl, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$8 */
    class C07438 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2035XU;

        /* renamed from: Yl */
        final /* synthetic */ int f2036Yl;

        /* renamed from: Yo */
        final /* synthetic */ int f2037Yo;

        /* renamed from: Yp */
        final /* synthetic */ boolean f2038Yp;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6603a((BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult>) this, this.f2036Yl, this.f2037Yo, this.f2038Yp, this.f2035XU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$9 */
    class C07449 extends LoadExtendedGamesImpl {

        /* renamed from: XU */
        final /* synthetic */ boolean f2039XU;

        /* renamed from: Yk */
        final /* synthetic */ String f2040Yk;

        /* renamed from: Yl */
        final /* synthetic */ int f2041Yl;

        /* renamed from: Ym */
        final /* synthetic */ boolean f2042Ym;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.mo6614a((BaseImplementation.C0270b<GamesMetadata.LoadExtendedGamesResult>) this, this.f2040Yk, this.f2041Yl, false, false, this.f2039XU, this.f2042Ym);
        }
    }

    private static abstract class LoadExtendedGamesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadExtendedGamesResult> {
        private LoadExtendedGamesImpl() {
        }

        /* renamed from: P */
        public GamesMetadata.LoadExtendedGamesResult mo3773c(final Status status) {
            return new GamesMetadata.LoadExtendedGamesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameInstancesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGameInstancesResult> {
        private LoadGameInstancesImpl() {
        }

        /* renamed from: Q */
        public GamesMetadata.LoadGameInstancesResult mo3773c(final Status status) {
            return new GamesMetadata.LoadGameInstancesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGameSearchSuggestionsResult> {
        private LoadGameSearchSuggestionsImpl() {
        }

        /* renamed from: R */
        public GamesMetadata.LoadGameSearchSuggestionsResult mo3773c(final Status status) {
            return new GamesMetadata.LoadGameSearchSuggestionsResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGamesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGamesResult> {
        private LoadGamesImpl() {
        }

        /* renamed from: S */
        public GamesMetadata.LoadGamesResult mo3773c(final Status status) {
            return new GamesMetadata.LoadGamesResult() {
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.m593as(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m2159c(apiClient).mo6710ka();
    }

    public PendingResult<GamesMetadata.LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.mo4219a(new LoadGamesImpl() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.mo6689f(this);
            }
        });
    }
}
