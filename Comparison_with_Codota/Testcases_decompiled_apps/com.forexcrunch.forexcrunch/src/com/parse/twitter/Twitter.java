package com.parse.twitter;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.parse.internal.AsyncCallback;
import com.parse.oauth.OAuth1FlowDialog;
import com.parse.oauth.OAuth1FlowException;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.OAuthProvider;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthProvider;
import com.parse.signpost.http.HttpParameters;
import org.apache.http.client.methods.HttpUriRequest;

public class Twitter {
    static final String ACCESS_TOKEN_URL = "https://api.twitter.com/oauth/access_token";
    static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize";
    private static final String CALLBACK_URL = "twitter-oauth://complete";
    /* access modifiers changed from: private */
    public static final OAuthProvider PROVIDER = new CommonsHttpOAuthProvider(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZE_URL);
    static final String REQUEST_TOKEN_URL = "https://api.twitter.com/oauth/request_token";
    private static final String SCREEN_NAME_PARAM = "screen_name";
    private static final String USER_ID_PARAM = "user_id";
    private static final String VERIFIER_PARAM = "oauth_verifier";
    private String authToken;
    private String authTokenSecret;
    private String consumerKey;
    private String consumerSecret;
    private String screenName;
    private String userId;

    public Twitter(String consumerKey2, String consumerSecret2) {
        this.consumerKey = consumerKey2;
        this.consumerSecret = consumerSecret2;
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public void setConsumerKey(String consumerKey2) {
        this.consumerKey = consumerKey2;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret2) {
        this.consumerSecret = consumerSecret2;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken2) {
        this.authToken = authToken2;
    }

    public String getAuthTokenSecret() {
        return this.authTokenSecret;
    }

    public void setAuthTokenSecret(String authTokenSecret2) {
        this.authTokenSecret = authTokenSecret2;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId2) {
        this.userId = userId2;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String screenName2) {
        this.screenName = screenName2;
    }

    public void signRequest(HttpUriRequest request) {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
        consumer.setTokenWithSecret(getAuthToken(), getAuthTokenSecret());
        try {
            consumer.sign((Object) request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void authorize(Context context, AsyncCallback callback) {
        if (getConsumerKey() == null || getConsumerKey().length() == 0 || getConsumerSecret() == null || getConsumerSecret().length() == 0) {
            throw new IllegalStateException("Twitter must be initialized with a consumer key and secret before authorization.");
        }
        final OAuthConsumer consumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Loading...");
        final AsyncCallback asyncCallback = callback;
        final Context context2 = context;
        new AsyncTask<Void, Void, String>() {
            private Throwable error;

            /* access modifiers changed from: protected */
            public void onPostExecute(String result) {
                super.onPostExecute(result);
                try {
                    if (this.error != null) {
                        asyncCallback.onFailure(this.error);
                        return;
                    }
                    CookieSyncManager.createInstance(context2);
                    Context context = context2;
                    final AsyncCallback asyncCallback = asyncCallback;
                    final OAuthConsumer oAuthConsumer = consumer;
                    final ProgressDialog progressDialog = progress;
                    new OAuth1FlowDialog(context, result, Twitter.CALLBACK_URL, "api.twitter", new OAuth1FlowDialog.FlowResultHandler() {
                        public void onError(int errorCode, String description, String failingUrl) {
                            asyncCallback.onFailure(new OAuth1FlowException(errorCode, description, failingUrl));
                        }

                        public void onComplete(String callbackUrl) {
                            CookieSyncManager.getInstance().sync();
                            final String verifier = Uri.parse(callbackUrl).getQueryParameter("oauth_verifier");
                            if (verifier == null) {
                                asyncCallback.onCancel();
                                return;
                            }
                            final OAuthConsumer oAuthConsumer = oAuthConsumer;
                            final ProgressDialog progressDialog = progressDialog;
                            final AsyncCallback asyncCallback = asyncCallback;
                            new AsyncTask<Void, Void, HttpParameters>() {
                                private Throwable error;

                                /* access modifiers changed from: protected */
                                public HttpParameters doInBackground(Void... params) {
                                    try {
                                        Twitter.PROVIDER.retrieveAccessToken(oAuthConsumer, verifier);
                                    } catch (Throwable e) {
                                        this.error = e;
                                    }
                                    return Twitter.PROVIDER.getResponseParameters();
                                }

                                /* access modifiers changed from: protected */
                                public void onPreExecute() {
                                    super.onPreExecute();
                                    progressDialog.show();
                                }

                                /* access modifiers changed from: protected */
                                public void onPostExecute(HttpParameters result) {
                                    super.onPostExecute(result);
                                    try {
                                        if (this.error != null) {
                                            asyncCallback.onFailure(this.error);
                                            return;
                                        }
                                        Twitter.this.setAuthToken(oAuthConsumer.getToken());
                                        Twitter.this.setAuthTokenSecret(oAuthConsumer.getTokenSecret());
                                        Twitter.this.setScreenName(result.getFirst(Twitter.SCREEN_NAME_PARAM));
                                        Twitter.this.setUserId(result.getFirst(Twitter.USER_ID_PARAM));
                                        asyncCallback.onSuccess(Twitter.this);
                                    } catch (Throwable e) {
                                        asyncCallback.onFailure(e);
                                    } finally {
                                        progressDialog.dismiss();
                                    }
                                }
                            }.execute(new Void[0]);
                        }

                        public void onCancel() {
                            asyncCallback.onCancel();
                        }
                    }).show();
                    progress.dismiss();
                } finally {
                    progress.dismiss();
                }
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                super.onPreExecute();
                progress.show();
            }

            /* access modifiers changed from: protected */
            public String doInBackground(Void... params) {
                try {
                    return Twitter.PROVIDER.retrieveRequestToken(consumer, Twitter.CALLBACK_URL);
                } catch (Throwable e) {
                    this.error = e;
                    return null;
                }
            }
        }.execute(new Void[0]);
    }
}
